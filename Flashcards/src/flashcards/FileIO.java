// Frank Work
package flashcards;

import java.awt.Color;
import java.util.ArrayList;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileIO {
    private static ArrayList<CardEntry> Cards = new ArrayList<CardEntry>();
    static Gson gson = new Gson();
    static String savePath = System.getenv("APPDATA") + "\\flashcards";
    static File dir = new File(savePath);
    static int errState = 0;
    static String[] errs = {"Nothing", "Card library is empty!", "Directory creation fail!", "Data write fail!", "Data read fail!"};
    
    public static ArrayList<CardEntry> fetchCards(String fileName){
        // Wipe array
        Cards.clear();
        try{
            BufferedReader reader = new BufferedReader(new FileReader(savePath + "\\" + fileName));
            ArrayList<CardEntry> out = gson.fromJson(reader, new TypeToken<ArrayList<CardEntry>>(){}.getType());
            for(int i = 0; i < out.size(); i++){
                System.out.println(i + " - " + out.get(i).getWord());
            }
        }catch(IOException e){
            
        }
        return Cards;
    }
    public static void writeCards(String fileName){
        if(Cards.size() > 0 && checkDir()){
            try{
                FileWriter file = new FileWriter(savePath + "\\" + fileName);
                String newWrite = gson.toJson(Cards);
                file.write(newWrite);
                file.close();
            }catch(IOException e){
                errState = 3;
                System.err.println(errs[errState]);
            }
            
        }else if(Cards.size() == 0){
            errState = 1;
            System.err.println(errs[errState]);
        }else if(checkDir() == false){
            errState = 2;
            System.err.println(errs[errState]);
        }
    }
    public static void createCard(String w, String d, Color c){
        Cards.add(new CardEntry(w, d, c));
    }
    public static void createCard(String w, String d){
        Cards.add(new CardEntry(w, d));
    }
    public static void main(String[] args){
        System.out.println(savePath);
        Cards = fetchCards("test.json");
        Cards.add(new CardEntry("Test", "A test thing"));
        Cards.add(new CardEntry("yeet", "weow"));
        checkDir();
        writeCards("test.json");
    }
    private static boolean checkDir(){
        if(dir.exists() == false){
            if(dir.mkdirs()){
                return true;
            }else{
                return false;
            }
        }else{
            return true;
        }
    }
}
class CardEntry{
    private String def = "", word = "";
    private Color cardColor;
    
    // Accessors
    public Color getColor(){
        return cardColor;
    }
    
    public String getDef(){
        return def;
    }
    
    public String getWord(){
        return word;
    }
    
    // Mutators
    public void setColor(Color c){
        cardColor = c;
    }
    public void setDef(String s){
        def = s;
    }
    public void setColor(String s){
        word = s;
    }
    
    // Constructors
    public CardEntry(String w, String d){
        word = w;
        def = d;
        cardColor = new Color(255,255,255);
    }
    public CardEntry(String w, String d, Color c){
        word = w;
        def = d;
        cardColor = c;
    }
}

