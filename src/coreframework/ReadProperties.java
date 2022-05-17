package coreframework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
    private  static Properties properties;
    public static void loadAllproperties(){
        if(properties==null){
            properties=new Properties();
            String[] propArr={"Browser.properties","DBConnection.properties","Environment.properties","QueryString.properties"};
            for(String arr:propArr){
                try {
                    properties.load(new FileInputStream("./src/"+arr));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static Properties getProperties(){
        return properties;
    }
    public static String get(String key){
        loadAllproperties();
        return properties.getProperty(key);
    }
}
