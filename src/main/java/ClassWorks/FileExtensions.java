package ClassWorks;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileExtensions {
    public static Sportsman addSportsman(String type, String firstName, String lastName, int birthYear, int score, int place){
        Sportsman newGuy = new Sportsman();

        newGuy.setType(type);
        newGuy.setFirstName(firstName);
        newGuy.setLastName(lastName);
        newGuy.setBirthYear(birthYear);
        newGuy.setPlace(place);
        newGuy.setScore(score);

        return newGuy;
    }

    public static Sportsman[] read() throws IOException {
        ArrayList result = new ArrayList();

        FileReader fr=new FileReader("data.txt");
        BufferedReader br=new BufferedReader(fr);
        String line="";
        String[] arrs=null;
        int num=0;
        while ((line=br.readLine())!=null) {
            arrs=line.split(",");

            result.add(FileExtensions.addSportsman(arrs[0],
                    arrs[1],
                    arrs[2],
                    Integer.valueOf(arrs[3]),
                    Integer.valueOf(arrs[4]),
                    Integer.valueOf(arrs[5])));
        }
        br.close();
        fr.close();

        return (Sportsman[]) result.toArray(Sportsman[]::new);
    }

}
