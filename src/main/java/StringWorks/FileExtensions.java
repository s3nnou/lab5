package StringWorks;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileExtensions {
    public static String[] readFileWithLetters() throws IOException {

        String str;
        ArrayList<String> arr = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("text.txt"))){
            while ((str = reader.readLine()) != null){
                String[] nums = str.split(" ");

                for (var item : nums){
                        str = item;
                        arr.add(str);
                    }
                }
            }
            catch (FileNotFoundException fileEx){}

            return arr.toArray(String[]::new);
    }


}
