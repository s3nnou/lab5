package ClassWorks;

import java.util.Scanner;

public class InputExtension {
    public static int typeInt(){
        int value;
        Scanner typer = new Scanner(System.in);
        value =  typer.nextInt();
        return  value;
    }
    public static String typeString(){
        String value;
        Scanner typer = new Scanner(System.in);
        value =  typer.nextLine();
        return  value;
    }
}
