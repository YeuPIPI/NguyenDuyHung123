package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import java.util.Scanner;
import java.util.Set;

public class Controller extends DictionaryCommandLine {
    @FXML
    private Button EDIT;
    @FXML
    private TextField englishLabel;
    @FXML
    private TextArea vietnameseLabel;
    @FXML
    private Button Add;
    @FXML
    private Button Delete;
    @FXML
    private TextField Delete1;
    @FXML
    private TextField addEnglish;
    @FXML
    private TextField addVietnamese;
    @FXML
    private TextField edit1;
    @FXML
    private TextField edit2;

    @FXML
    private Button speak;

    @FXML
    private Button GGTranslate;

    @FXML
    private void initialize(URL url, ResourceBundle rb) {
    }
    @FXML
    private void searchWord(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            String english = englishLabel.getText();
            Set<String> a = hashmap.words.keySet();
            for (String key : a) {
                if (hashmap.words.containsKey(english)) {
                    vietnameseLabel.setText(hashmap.words.get(english));
                }
            }
        }
    }
    @FXML
    private void deleteWord(KeyEvent event){
            String deleteword = Delete1.getText();
            Set<String> a = hashmap.words.keySet();
            for (String key : a) {
                if (key.equals(deleteword) == true) {
                    hashmap.words.remove(key);
                }
                if(key.equals(deleteword) == false){
                    continue;
                }
            }

    }
    @FXML
    private void addWord(KeyEvent event){
            String add1 = addEnglish.getText();
            String add2 = addVietnamese.getText();
            newWord.setWord_target(add1);
            newWord.setWord_explain(add2);
            hashmap.words.put(newWord.getWord_target(), newWord.getWord_explain());
    }
    @FXML   
    private void editWord(KeyEvent event){
            String edita = edit1.getText();
            String editb = edit2.getText();
            Set<String> d = hashmap.words.keySet();
            for(String key : d){
                if(edita.equals(key) == true){
                    hashmap.words.replace(edita,editb);
                }
            }
    }
    @FXML
    private void DictionarySearch(KeyEvent event){

            String find = englishLabel.getText();
            Set<String> a = hashmap.words.keySet();
            for (String key : a) {
                if (key.contains(find)) {
                    vietnameseLabel.setText(key + " : " + hashmap.words.get(key));
                }
            }

    }

    public void actionSpeak(){
        Speech.GoogleAPI(englishLabel.getText());
    }

    public void actionGGTranslate(){
        vietnameseLabel.setText(Speech.GoogleTranslate(englishLabel.getText()));
    }
}
