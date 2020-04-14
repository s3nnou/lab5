package IntegerWorks;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileExtensions {
    public static Integer[] readFileWithNumbers() throws IOException {

        String str;
        ArrayList<Integer> arr = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("numbers.txt"))){
            while ((str = reader.readLine()) != null){
                String[] nums = str.split(" ");

                for (var item : nums){
                    str = item;
                    arr.add(Integer.parseInt(str));
                }
            }
        }
        catch (FileNotFoundException fileEx){}

        return arr.toArray(Integer[]::new);
    }


}
