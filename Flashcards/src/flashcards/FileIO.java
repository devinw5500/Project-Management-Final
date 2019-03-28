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
    static String savePath = ".\\src\\savedSets"; //System.getenv("APPDATA") + "
    static File dir = new File(savePath);
    static int errState = 0;
    static String activeFile = "";
    static String[] errs = {"Nothing", "Card library is empty!", "Directory creation fail!", "Data write fail!", "Data read fail!"};
    
    public static void loadSet(String fileName){
        activeFile = fileName + ".json";
        if(!Cards.isEmpty()){
            writeCards();
            Cards.clear();
        }
    }
    
    public static ArrayList<String> fetchSets(){
        ArrayList<String> sets = new ArrayList<String>();
        File[] fileNames = new File(savePath).listFiles();
        for(File file: fileNames){
            if(!file.isDirectory()){
                String newEntry = (file.getName().split("\\.")[0]);
                if(sets.isEmpty()){
                    sets.add(newEntry);
                }else{
                    for(int i = 0; i < sets.size(); i++){
                        System.out.println("Checking: " + i + " " + newEntry + " - " + sets.get(i));
                        if(!sets.get(i).equals(newEntry) && i == sets.size()-1){
                            sets.add(newEntry);
                        }else if(sets.get(i).equals(newEntry)){
                            i = sets.size();
                        }
                    }
                }
                
            }
        }
        if(sets.isEmpty()){
            return null;
        }else{
            return sets;
        }
    }
    
    // Fetches a cardset from a specific file name.
    public static ArrayList<CardEntry> fetchCards(){
        if(!activeFile.equals("")){
            try{
                BufferedReader reader = new BufferedReader(new FileReader(savePath + "\\" + activeFile));
                ArrayList<CardEntry> out = gson.fromJson(reader, new TypeToken<ArrayList<CardEntry>>(){}.getType());
                for(int i = 0; i < out.size(); i++){
                    System.out.println(i + " - " + out.get(i).getWord());
                }
            }catch(IOException e){

            }
            return Cards;
        }
        return null;
    }
    
    public static void writeCards(){
        if(!Cards.isEmpty() && checkDir()){
            try{
                FileWriter file = new FileWriter(savePath + "\\" + (activeFile));
                String newWrite = gson.toJson(Cards);
                file.write(newWrite);
                file.close();
            }catch(IOException e){
                errState = 3;
                System.err.println(errs[errState]);
            }
            
        }else if(Cards.isEmpty()){
            errState = 1;
            System.err.println(errs[errState]);
        }else if(checkDir() == false){
            errState = 2;
            System.err.println(errs[errState]);
        }
    }
    public static void main(String[] args){
        System.out.println(savePath);
        //Cards = fetchCards("test.json");
        Cards.add(new CardEntry("Test", "A test thing"));
        Cards.add(new CardEntry("yeet", "weow"));
        Cards.add(new CardEntry("yaga", "not really"));
        checkDir();
        fetchSets();
        loadSet("test");
        writeCards();
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
    public void setWord(String s){
        word = s;
    }
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

