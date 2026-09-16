package padroes_criacionais;

import java.util.HashMap;
import java.util.Map;

public class ConfigurationManager {

    private static ConfigurationManager instance;
    private final Map<String, String> configData;

    // TODO: Tornar o construtor privado e inicializar o mapa
    public ConfigurationManager() {
        this.configData = new HashMap<>();
    }

    // TODO: Criar o ponto de acesso global estático e thread-safe (getInstance)
    public static ConfigurationManager getInstance() {
        return null;
    }

    public String getProperty(String key) {
        return this.configData.get(key);
    }

    public void setProperty(String key, String value) {
        this.configData.put(key, value);
    }
}