// Frank Work
package flashcards;

import java.awt.Color;
import java.util.ArrayList;
import com.google.gson.*;

public class FileIO {
    private ArrayList<CardEntry> Cards = new ArrayList<CardEntry>();
    Gson gson = new Gson();
    static String savePath = System.getenv("APPDATA") + "\\flashcards";
    
    public ArrayList<CardEntry> fetchCards(){
        // Wipe array
        return Cards;
    }
    public void writeCards(){
        if(Cards.size() > 0){
            String newWrite = gson.toJson(Cards);
        }
    }
    public static void main(String[] args){
        System.out.println(savePath);
    }
    private boolean checkDir(String path){
        
        return false;
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
    public void setCard(String w, String d){
        word = w;
        def = d;
        cardColor = new Color(255,255,255);
    }
    public void setCard(String w, String d, Color c){
        word = w;
        def = d;
        cardColor = c;
    }
}

