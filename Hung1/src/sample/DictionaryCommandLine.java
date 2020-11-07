package sample;

import java.io.IOException;
import java.util.Set;
import java.util.Scanner;
import java.nio.file.Paths;
public class DictionaryCommandLine extends DictionaryManagement{
    public static void showAllWords() {

        System.out.printf("%-10s %-20s %-20s", "No", "| English", "| Vietnamese");
        System.out.print("\n");
        int i = 1;
        Set<String> a = hashmap.words.keySet();
        for (String key : a) {
            System.out.printf("%-10d", i);
            i++;
            System.out.printf("%-20s %-20s", key , hashmap.words.get(key));
            System.out.print("\n");
        }
    }
    public static void dictionaryBaisc(){
        insertFromCommandline();
        showAllWords();
        dictionaryExportToFile(hashmap.words);
    }
    public static void A() throws Exception {
        insertFromFile("src/sample/dictionaries - word.txt");
        showAllWords();
        dictionarySearch();
    }
    public static void dictionarySearch() {
        System.out.println("Nhap tu Tieng Anh can tim kiem :  ");
        Word newWord = new Word();
        Scanner scanner = new Scanner(System.in);
        String find = scanner.next();
        int i = 1;
        Set<String> c = hashmap.words.keySet();
        for(String key : c){
            if(key.contains(find) == true){
                System.out.printf("%-10d", i);
                i++;
                System.out.printf("%-20s %-20s", key , hashmap.words.get(key));
                System.out.print("\n");
            }
        }

    }

}

