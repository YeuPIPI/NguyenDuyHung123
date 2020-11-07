package sample;

import java.nio.file.Paths;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;
import java.util.*;
import java.io.*;
import com.sun.glass.ui.Application;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.event.ActionEvent;
import javafx.scene.text.Text;
public class DictionaryManagement {
    public static Dictionary hashmap = new Dictionary();
    Word newWord = new Word();
    public static void insertFromCommandline() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Số Lượng từ : ");
        int Numberofwords = scanner.nextInt();
        for (int i = 0; i < Numberofwords; i++) {
            Word newWord = new Word();
            System.out.println("Từ Tiếng Anh : ");
            String wordTarget = scanner.next();
            System.out.println("Từ Tiếng Việt :  ");
            scanner.nextLine();
            String wordExplain = scanner.nextLine();
            newWord.setWord_target(wordTarget);
            newWord.setWord_explain(wordExplain);
            hashmap.words.put(newWord.getWord_target(), newWord.getWord_explain());
        }

    }
    public static void insertFromFile(String fileName) throws Exception {
        File file = new File(fileName);
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] splitted = line.split("\t");
            String target = splitted[0].trim();
            String explain = splitted[1].trim();
            Word newWord = new Word(target,explain);
            //newWord.setWord_target(target);
            //newWord.setWord_explain(explain);
            hashmap.words.put(newWord.getWord_target(), newWord.getWord_explain());
        }
    }
    public static void dictionaryExportToFile(HashMap<String, String> map) {
        //write to file : "fileone"
        try {
            File fileTwo = new File("dictionaries.txt");
            FileOutputStream fos = new FileOutputStream(fileTwo);
            PrintWriter pw = new PrintWriter(fos);

            for (Map.Entry<String, String> m : map.entrySet()) {
                pw.println(m.getKey() + " " + m.getValue());
            }

            pw.flush();
            pw.close();
            fos.close();
        } catch (Exception e) {
        }

        //read from file
        try {
            File toRead = new File("dictionaries.txt");
            FileInputStream fis = new FileInputStream(toRead);

            Scanner sc = new Scanner(fis);

            HashMap<String, String> mapInFile = new HashMap<String, String>();

            //read data from file line by line:
            String currentLine;
            while (sc.hasNextLine()) {
                currentLine = sc.nextLine();
                //now tokenize the currentLine:
                StringTokenizer st = new StringTokenizer(currentLine, "=", false);
                //put tokens ot currentLine in map
                mapInFile.put(st.nextToken(), st.nextToken());
            }
            fis.close();
        } catch (Exception e) {
        }
    }

    /**
     *
     */
    public static void dictionaryLookUp() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ban muon tim tu : ");
        String wordTarget = sc.next();
        if (hashmap.words.containsKey(wordTarget)) {
            System.out.print("Tu ban dang tim kiem : ");
            System.out.printf(hashmap.words.get(wordTarget));
        } else {
            System.out.println("Khong tim thay tu");
        }
    }

    public static void add() {
        Scanner scanner = new Scanner(System.in);
        Word newWord = new Word();
        System.out.println("Từ Tiếng Anh : ");
        String wordTarget = scanner.next();
        System.out.println("Từ Tiếng Việt : ");
        scanner.nextLine();
        String wordExplain = scanner.nextLine();
        newWord.setWord_target(wordTarget);
        newWord.setWord_explain(wordExplain);
        hashmap.words.put(newWord.getWord_target(), newWord.getWord_explain());
    }

    public static void delete() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bạn muốn xóa từ gì ?");
        String change2 = scanner.next();
        Set<String> a = hashmap.words.keySet();
        for (String key : a) {
            if (key.equals(change2) == true) {
                hashmap.words.remove(key);
            }
            if(key.equals(change2) == false){
                continue;
            }
        }
    }
    public static void edit(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Bạn muốn chỉnh sửa từ gì ?");
        String edits2 = scanner.next();
        System.out.print("Bạn muốn sửa thành từ ?");
        scanner.nextLine();
        String edits3 = scanner.nextLine();
        Set<String> d = hashmap.words.keySet();
        for(String key : d){
            if(edits2.equals(key) == true){
                hashmap.words.replace(edits2,edits3);
            }
        }
    }

}


