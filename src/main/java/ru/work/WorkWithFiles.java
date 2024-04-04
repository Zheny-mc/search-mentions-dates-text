package ru.work;
import java.io.*;
import java.util.List;

public class WorkWithFiles {

    public static void write(String filename, List<String> lst_str) {
        try (var writer = new FileWriter(filename, false))
        {
            for (var text: lst_str) {
                writer.write(text);
                writer.append('\n');
            }
            writer.flush();
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static String read(String filename) {

        try (FileReader reader = new FileReader(filename))
        {
            var sb = new StringBuilder();
            int c;
            while((c=reader.read())!=-1){
                sb.append((char)c);
            }
            return sb.toString();
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return "";
    }

}
