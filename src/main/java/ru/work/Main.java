package ru.work;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {
    static String regex_pattern_path = "src/main/resources/regex_pattern.txt";

    static String[] get_input(String[] args) throws IOException {
        if (args.length == 4) {
            String[] res = new String[2];
            for (int i = 0; i < args.length; i+=2) {
                switch (args[i]) {
                    case "-i":
                        res[0] = args[i+1];
                        break;
                    case "-o":
                        res[1] = args[i+1];
                        break;
                    default:
                        throw new IOException("Неверное имена флагов!");
                }
            }
            return res;
        }
        throw new IOException("Неверное кол-во аргументов!");
    }
    public static void main(String[] args) {
        try {
            String[] input_args = get_input(args);
            String input_file = input_args[0];
            String output_file = input_args[1];

            calcultion(input_file, output_file);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    static void calcultion(String input_file, String output_file) {
        String input_text = WorkWithFiles.read(input_file);
        String regular_pattern = WorkWithFiles.read(regex_pattern_path);
        List<String> lst_str = Logic.run(input_text, regular_pattern);
        lst_str.forEach(System.out::println);
        WorkWithFiles.write(output_file, lst_str);
    }
}



