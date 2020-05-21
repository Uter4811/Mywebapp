package org.mycompany.myname;

import java.io.*;


public class XMLReader {
    public static String read(String bodePath) throws IOException {
        String line = null;
        try {
            File file = new File(bodePath);
            //создаем объект FileReader для объекта File
            FileReader fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку
             line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                // считываем остальные строки в цикле
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }





      /*  FileReader reader = new FileReader("c:/data.xml");
        FileWriter writer = new FileWriter(bodePath);

        while (reader.ready()) //пока есть непрочитанные байты в потоке ввода
        {
            int data = reader.read(); //читаем один символ (char будет расширен до int)
            writer.write(data); //пишем один символ (int будет обрезан/сужен до char)
        }
        reader.close();
        writer.close();

        return bodePath;*/
    }

}
