package ump.PropertiesToYamlConverter.load;

import ump.PropertiesToYamlConverter.exception.PropertiesLoadingException;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

public class PropertiesLoader implements IFilePropertiesLoader{
    @Override
    public Map<String, String> load(String... filePaths) throws PropertiesLoadingException {
        Map<String, String> combinedProperties = new LinkedHashMap<>(); //pour conserve l'ordre

        for (String filePath : filePaths) {
            Properties props = new Properties();
            try (FileInputStream input = new FileInputStream(filePath)) {
                props.load(input);
                props.forEach((key, value) -> combinedProperties.put(key.toString(), value.toString()));
            } catch (IOException e) {
                throw new PropertiesLoadingException("Erreur lors du chargement du fichier : " + filePath, e);
            }
        }

        return combinedProperties;
    }
}