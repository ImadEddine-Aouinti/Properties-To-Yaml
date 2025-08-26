package ump.PropertiesToYamlConverter.load;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertiesLoader {
    public static Map<String, String> loadProperties(String... filePaths) throws IOException {
        Map<String, String> combinedProperties = new HashMap<>();

        for (String filePath : filePaths) {
            Properties props = new Properties();
            try (FileInputStream input = new FileInputStream(filePath)) {
                props.load(input);
                props.forEach((key, value) -> combinedProperties.put(key.toString(), value.toString()));
            } catch (IOException e) {
                throw new IOException("Erreur lors du chargement du fichier : " + filePath, e);
            }
        }

        return combinedProperties;
    }
}