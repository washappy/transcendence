package behappy.hap.mangers;

import org.bukkit.Bukkit;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import static behappy.hap.mangers.ArrayManager.humanss;

public class FileManager {

    public static JSONObject jsonFile = new JSONObject();
    public static JSONArray jsonList = new JSONArray();
    public static String path = System.getProperty("user.dir");

    public static void makeFile() {
        File f = new File(path +"/plugins/능력자/playerDs.json");
        if (f.exists()) {
            Bukkit.getLogger().info("playerDs.json exists");
        } else {
            Bukkit.getLogger().info("playerDs.json not exist");
            Bukkit.getLogger().info("making playerDs.json");

            try {
                FileWriter file = new FileWriter(path +"/plugins/능력자/playerDs.json");
                file.write(jsonFile.toJSONString());
                file.flush();
                file.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void saveFile() {
        try {
            FileWriter file = new FileWriter(path +"/plugins/능력자/playerDs.json");
            file.write(jsonFile.toJSONString());
            file.flush();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static JSONObject getFile() {
        JSONParser parser = new JSONParser();
        try {
            FileReader reader = new FileReader(path +"/plugins/능력자/playerDs.json");
            Object obj = parser.parse(reader);
            JSONObject jsonObject = (JSONObject) obj;

            reader.close();

            return jsonObject;

        } catch (IOException | ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void makeList() {
        File f = new File(path +"/plugins/능력자/playerList.json");
        if (f.exists()) {
            Bukkit.getLogger().info("playerList.json exists");
        } else {
            Bukkit.getLogger().info("playerList.json not exist");
            Bukkit.getLogger().info("making playerList.json");

            try {
                FileWriter file = new FileWriter(path +"/plugins/능력자/playerList.json");
                file.write(jsonList.toJSONString());
                file.flush();
                file.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void saveList() {
        try {
            for (int i = 0; i<humanss.toArray().length;i++) {
                String toPut = (String) humanss.toArray()[i];
                boolean contain = jsonList.contains(toPut);
                if (contain) {
                } else {
                    jsonList.add(toPut);
                }
            }
            FileWriter file = new FileWriter(path +"/plugins/능력자야생/playerList.json");
            file.write(jsonList.toJSONString());
            file.flush();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<String> getList() {
        JSONParser parser = new JSONParser();
        try {
            FileReader reader = new FileReader(path +"/plugins/능력자야생/playerList.json");
            Object obj = parser.parse(reader);
            JSONArray jsonArray = (JSONArray) obj;
            reader.close();
            return jsonArray;
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void saveAll() {
        FileManager.makeFile();
        FileManager.makeList();
        FileManager.saveFile();
        FileManager.saveList();
    }

    FileManager() {
    }
}
