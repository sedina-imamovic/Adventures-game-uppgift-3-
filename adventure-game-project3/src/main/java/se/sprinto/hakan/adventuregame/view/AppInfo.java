package se.sprinto.hakan.adventuregame.view;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class AppInfo {
    // skapar en statisk variabel av typen AppInfo
    // används för att implementera singleton, aå att det finns bara ett objekt
    private static AppInfo instance;
    // skapas för att kunna läsa från en fil
    private Properties properties;

    private AppInfo() {
        properties = new Properties();
        try (FileReader reader = new FileReader("app.property")) {
            properties.load(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // metod för att hämta singleton-instansen
    public static AppInfo getInstance() {
        if (instance == null) {
            instance = new AppInfo();
        }
        return instance;
    }

    // metod som returnerar värdet för en viss nyckel i properties
    public String getProperty(String key) {
        return properties.getProperty(key);
    }


}
