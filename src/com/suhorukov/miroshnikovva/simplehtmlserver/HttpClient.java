package com.suhorukov.miroshnikovva.simplehtmlserver;

import com.suhorukov.miroshnikovva.dirindexhtml.DirHtmlGenerator;
import com.suhorukov.miroshnikovva.dirindexhtml.Http404Exception;

import javax.activation.MimetypesFileTypeMap;
import java.io.*;
import java.net.Socket;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: MiroshnikovVA
 * Date: 17.07.13
 * Time: 19:43
 * To change this template use File | Settings | File Templates.
 */
public class HttpClient implements Runnable {
    private Socket socket;
    private DirHtmlGenerator generator;

    public HttpClient(Socket socket, DirHtmlGenerator generator) {
        this.socket = socket;
        this.generator = generator;
    }

    @Override
    public void run() {
        try {
            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            OutputStream output = socket.getOutputStream();
            //OutputStreamWriter writer = new OutputStreamWriter(output);
            String line = "";
            String get = "";
            while ( true ) {
                //System.out.println("Ожидаем строку...");
                line = reader.readLine();
                if (line == null || line.isEmpty()) break;
                System.out.println(line);
                String[] ss = line.split(" ");
                if (ss.length>=2){
                    if ("GET".equals(ss[0])) {
                        get = ss[1];
                    }
                }
            }

            if (!get.isEmpty()){
                //Требуется ответ от сервера
                writeFromGet(get, output);
            }
            //writer.close();
            output.close();
            System.out.println("Обработчик завершил работу");
        }
        catch (IOException ex) {
            ex.printStackTrace();
    }
    }

    void write404(OutputStream out) throws IOException {
        //Вызываем метод, который пишет 404
        out.write("HTTP/1.0 404 fuck!\r\n".getBytes());
        //пустая строка отделяет заголовки от тела
        out.write("\r\n".getBytes());
        out.flush();
        System.out.println("По сети отправлена ошибка 404");
    }

    void writeFromGet(String get, OutputStream out) throws IOException {
        System.out.println("Отправляем ответ");
        // пишем ответ
        String s = null;
        File file = new File(generator.getHomeDir()+get);
        if (!file.exists() || !generator.isChildren(file)) //Проверяем безопасность
        {
            write404(out);
        }

        //открытие файла index.html
        File indexhtmFile = new File(generator.getHomeDir()+get + "/index.html");
        if (indexhtmFile.exists() & indexhtmFile.isFile()) {
            file = indexhtmFile;
        }

        if (file.isDirectory())  {
            try {
                s = generator.generateHtml(get);
            } catch (Http404Exception e) {
                write404(out);
                return;
            }
            byte[] bytes = s.getBytes("Cp1251");
            //пишем статус ответа
            out.write("HTTP/1.0 200 OK\r\n".getBytes());
            //минимально необходимые заголовки, тип и длина
            out.write("Content-Type: text/html\r\n".getBytes());
            out.write(("Content-Length: "+bytes.length+"\r\n").getBytes());
            //пустая строка отделяет заголовки от тела
            out.write("\r\n".getBytes());
            //тело
            out.write(bytes);
            out.flush();

            System.out.println("По сети отправлено HTML страница: "+ s);
        }
        else {    //Отправляем файл
            String contentType = new MimetypesFileTypeMap().getContentType(file);
            //пишем статус ответа
            out.write("HTTP/1.0 200 OK\r\n".getBytes());
            //минимально необходимые заголовки, тип и длина
            if (file == indexhtmFile) {
                out.write("Content-Type: text/html\r\n".getBytes());
            } else   {
                out.write(("Content-Type: "+ contentType + "\r\n").getBytes());
            }
            out.write(("Content-Length: "+file.length()+"\r\n").getBytes());
            out.write(("Last-Modified: " + new Date(file.lastModified()) + "\r\n").getBytes());

            //пустая строка отделяет заголовки от тела
            out.write("\r\n".getBytes());
            //тело

            FileInputStream reader = null;
            byte[] b = new byte[100];
            try {
                reader = new FileInputStream(file);
                int c = reader.read(b,0,100);
                while (c>0){
                    out.write(b, 0, c);
                    c = reader.read(b,0,100);
                }
            } finally {
                reader.close();
            }
            out.flush();

            System.out.println("По сети отправлен файл: "+ file.getName());

        }



    }
}
