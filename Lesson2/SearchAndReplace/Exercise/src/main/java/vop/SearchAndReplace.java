package vop;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SearchAndReplace {

    public static String[] toStringArray(String input){
        Scanner scanner = new Scanner(input);
        List<String> stringList = new ArrayList<>();

        while(scanner.hasNextLine()){
            String[] nextLine = scanner.nextLine().split(" ");
            for ( String s :
                    nextLine ) {
                stringList.add(s);
            }
            stringList.add("LINEBREAK");
        }
        scanner.close();
        String[] returnStrings = stringList.toArray(new String[stringList.size()]);
        return returnStrings;

    }

    public static String[] toStringArray(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        List<String> stringList = new ArrayList<>();

        while(scanner.hasNextLine()){
            String[] nextLine = scanner.nextLine().split(" ");
            for ( String s :
                    nextLine ) {
                stringList.add(s);
            }
            stringList.add("LINEBREAK");
        }
        scanner.close();
        String[] returnStrings = stringList.toArray(new String[stringList.size()]);
        return returnStrings;

    }

    public static String[] searchAndReplace(String[] strings, String search, String replace){
        String[] stringsReturn = strings;
        for ( int i = 0; i<stringsReturn.length; i++ ) {
            if(stringsReturn[i].equals(search)){
                stringsReturn[i] = replace;
            }
        }
        return stringsReturn;
    }

    public static String toString(String[] strings){
        String returnString = "";
        for ( String s :
                strings ) {
            if(s.equals("LINEBREAK")){
                returnString += "\n";

            }else{
                returnString += s + " ";
            }

        }
        return returnString;
    }
}
