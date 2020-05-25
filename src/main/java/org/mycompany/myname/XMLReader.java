package org.mycompany.myname;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class XMLReader {
    public static String read(String bodyPath){
        StringBuilder result = new StringBuilder();
        List<String> lines = null;
        try {
            lines = Files.readAllLines(Paths.get(bodyPath), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(String line: lines){
            result.append(line).append(System.lineSeparator());
        }
        return result.toString();
    }
}





      /*  public static String read(String bodePath) throws IOException {
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
    }*/
    


