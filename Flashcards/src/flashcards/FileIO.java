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
    private static Gson gson = new Gson();
    private static File saveDir = new File(".\\src\\savedSets"), ioDataDir = new File(".\\src\\IOData");
    private static String activeFile = "";
    private static File lastSet = new File(ioDataDir + "\\lastSet.txt");

    // contructor
    public FileIO() {
        System.out.println("Save directory: " + saveDir);
        checkDir(saveDir);
        checkDir(ioDataDir);

        // Check if a set exist at start
        if (lastSet.exists()) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(lastSet));
                String last = reader.readLine();
                loadSet(last);

            } catch (IOException e) {
                System.err.println("Error: " + e);
            }
        } else {
            cardEditor frame = new cardEditor();
            frame.setVisible(true);
        }
    }

    // Loads supplied set and returns the list name, receiver must check for null!    
    public static ArrayList<CardEntry> loadSet(String fileName) {
        if (new File(saveDir + "\\" + fileName + ".json").exists()) {
            activeFile = fileName;
            //System.out.println(activeFile + " name");
            if (!Cards.isEmpty()) {
                writeSet();
                Cards.clear();
            }
            if (!activeFile.equals("")) {
                try {
                    BufferedReader reader = new BufferedReader(new FileReader(saveDir + "\\" + activeFile + ".json"));
                    ArrayList<CardEntry> in = gson.fromJson(reader, new TypeToken<ArrayList<CardEntry>>() {
                    }.getType());
                    Cards = in;
                    /*for(int i = 0; i < in.size(); i++){
                    //System.out.println(i + " - " + in.get(i).getWord());
                }*/
                } catch (IOException e) {
                    System.err.println("Error: " + e);
                }
                try {
                    FileWriter file = new FileWriter(lastSet);
                    file.write((fileName));
                    file.close();
                } catch (IOException e) {
                    System.err.println("Error: " + e);
                }
                return Cards;
            }
            return null;
        }else{
            System.out.println("AHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH TEAR");
            activeFile = fileName;
            Cards.clear();
            writeSet();
        }
        return null;
    }

    // fetch saved sets
    public static ArrayList<String> fetchSets() {
        ArrayList<String> sets = new ArrayList<String>();
        File[] fileNames = saveDir.listFiles();
        System.out.println(fileNames);
        for (File file : fileNames) {
            if (!file.isDirectory()) {
                String newEntry = (file.getName().split("\\.")[0]);
                if (sets.isEmpty()) {
                    sets.add(newEntry);
                } else {
                    for (int i = 0; i < sets.size(); i++) {
                        //System.out.println("Checking: " + i + " " + newEntry + " - " + sets.get(i));
                        if (!sets.get(i).equals(newEntry) && i == sets.size() - 1) {
                            sets.add(newEntry);
                        } else if (sets.get(i).equals(newEntry)) {
                            i = sets.size();
                        }
                    }
                }

            }
        }
        if (sets.isEmpty()) {
            return null;
        } else {
            return sets;
        }
    }

    // Write current card set to file
    private static void writeSet() {
        if (!Cards.isEmpty() && checkDir(saveDir)) {
            try {
                FileWriter file = new FileWriter(saveDir + "\\" + (activeFile) + ".json");
                String newWrite = gson.toJson(Cards);
                file.write(newWrite);
                file.close();
            } catch (IOException e) {
                System.err.println("Error: " + e);
            }

        } else if (Cards.isEmpty()) {
            System.out.println("Writing empty set");
            try {
                FileWriter file = new FileWriter(saveDir + "\\" + (activeFile) + ".json");
                Cards.add(new CardEntry("Example word", "Example definition"));
                String newWrite = gson.toJson(Cards);
                file.write(newWrite);
                file.close();
            } catch (IOException e) {
                System.err.println("Error: " + e);
            }
            
        } else if (checkDir(saveDir) == false) {
            System.err.println("Director fail");
        }
    }

    // Update our loaded set with its new data.
    public static void updateSet(ArrayList<CardEntry> newSet) {
        if (!Cards.isEmpty()) {
            Cards.clear();
        }
        Cards = newSet;
        //System.out.println("Updating: " + Cards.size());
        writeSet();
    }

    // Fetchs a specific card
    public static CardEntry fetchCard(int loc) {
        if (!Cards.isEmpty()) {
            if (loc > 0 || loc <= Cards.size()) {
                return Cards.get(loc);
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    // returns the length of the loaded card set
    public static int fetchSetLength() {
        return Cards.size();
    }

    public static void removeSet(String fileName) {
        if (new File(saveDir + "\\" + fileName + ".json").exists()) {
            System.out.println("Removing set: " + saveDir + "\\" + fileName + ".json");
            new File(saveDir + "\\" + fileName + ".json").delete();
        }
    }

    public static void main(String args[]){
        loadSet("AHHHH");
        
    }
    
    // Check if file directory exist
    private static boolean checkDir(File dir) {
        if (dir.exists() == false) {
            if (dir.mkdirs()) {
                return true;
            } else {
                System.err.println("Error: Directory make fail");
                return false;
            }
        } else {
            return true;
        }
    }
}

class CardEntry {

    private String def = "", word = "";
    private Color cardColor;

    // Accessors
    public Color getColor() {
        return cardColor;
    }

    public String getDef() {
        return def;
    }

    public String getWord() {
        return word;
    }

    // Mutators
    public void setColor(Color c) {
        cardColor = c;
    }

    public void setDef(String s) {
        def = s;
    }

    public void setWord(String s) {
        word = s;
    }

    public void setCard(String w, String d) {
        word = w;
        def = d;
        cardColor = new Color(255, 255, 255);
    }

    public void setCard(String w, String d, Color c) {
        word = w;
        def = d;
        cardColor = c;
    }

    // Constructors
    public CardEntry(String w, String d) {
        word = w;
        def = d;
        cardColor = new Color(255, 255, 255);
    }

    public CardEntry(String w, String d, Color c) {
        word = w;
        def = d;
        cardColor = c;
    }
}
