package set;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;


/**
 * @author Hypnos Tsang
 * @date 2020/7/8
 */
public class FileOperation {
    public static boolean readFile(String fileName, ArrayList<String> words){
        if (fileName == null || words == null){
            System.out.println("fileName is null or words is null ");
            return false;
        }

        Scanner scanner;
        try{
            File file = new File(fileName);
            if (file.exists()){
                FileInputStream fis = new FileInputStream(file);
                scanner = new Scanner(new BufferedInputStream(fis), String.valueOf(StandardCharsets.UTF_8));
                scanner.useLocale(Locale.ENGLISH);
            }
            else {
                return false;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }

        if (scanner.hasNextLine()){
            String contents = scanner.useDelimiter("\\A").next();
            int start = firstCharacterIndex(contents, 0);
            for (int i = start + 1; i <= contents.length(); ) {
                if (i == contents.length() || !Character.isLetter(contents.charAt(i))){
                    String word = contents.substring(start, i).toLowerCase();
                    words.add(word);
                    start = firstCharacterIndex(contents, i);
                    i = start + 1;
                }
                else {
                    i++;
                }
            }
        }
        return true;
    }


    private static int firstCharacterIndex(String s, int start){
        for (int i = start + 1 ; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))) {
                return i;
            }
        }
        return s.length();
    }
}
