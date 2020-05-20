package org.mycompany.myname;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class XMLReader {
    public static String read(String bodePath) throws IOException {
        FileReader reader = new FileReader("c:/data.xml");
        FileWriter writer = new FileWriter(bodePath);

        while (reader.ready()) //пока есть непрочитанные байты в потоке ввода
        {
            int data = reader.read(); //читаем один символ (char будет расширен до int)
            writer.write(data); //пишем один символ (int будет обрезан/сужен до char)
        }
        reader.close();
        writer.close();

        return bodePath;
    }

}
