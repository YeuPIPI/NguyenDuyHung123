package sample;

import com.gtranslate.Audio;
import com.gtranslate.Language;
import com.gtranslate.Translator;
import javazoom.jl.decoder.JavaLayerException;

import java.io.IOException;
import java.io.InputStream;

public class Speech {
    public Speech() {
        System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
        //demoTTS();
        // demonstrateFreeTTS();
        // listAllVoices();
    }

    /* public static void main(String[] args){
         new Speech();
     }*/
    public static void GoogleAPI(String input) {

        try {
            Audio audio = Audio.getInstance();
            InputStream sound = audio.getAudio(input, Language.ENGLISH + "&client=tw-ob");
            audio.play(sound);
        } catch (IOException | JavaLayerException e) {
            System.out.println(e.getMessage());
        }
    }

    public static String GoogleTranslate(String input) {
        Translator translate = Translator.getInstance();
            String text = translate.translate(input + "&client=tw-ob", Language.ENGLISH, Language.VIETNAMESE);
        return text;
        // System.out.println(text); //
    }

}
