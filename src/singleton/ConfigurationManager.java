package padroes_criacionais;

import java.util.HashMap;
import java.util.Map;

public class ConfigurationManager {

    private static ConfigurationManager instance;
    private final Map<String, String> configData;

    private ConfigurationManager() {

        this.configData = new HashMap<>();
    }


    public static ConfigurationManager getInstance() {
        if (instance == null){
            instance = new ConfigurationManager();
        }
        return instance;
    }

    public String getProperty(String key) {
        return this.configData.get(key);
    }

    public void setProperty(String key, String value) {
        this.configData.put(key, value);
    }
}

class ConfigurationManagerapp{
    public static void main(String[] args){
        ConfigurationManager config1 = ConfigurationManager.getInstance();
        ConfigurationManager config2 = ConfigurationManager.getInstance();
        config1.setProperty("appName", "Meu Sistema Java");

        System.out.println("Nome do App: " + config1.getProperty("appName"));

        System.out.println("Lido via config2: " + config2.getProperty("appName"));
        System.out.println("Mesma instância em memória? " + (config1 == config2));
    }
    }
