package ump.PropertiesToYamlConverter.convertisseur.impl;

import ump.PropertiesToYamlConverter.convertisseur.PropertiesConvertisseur;
import ump.PropertiesToYamlConverter.model.ResultatConversion;
import org.yaml.snakeyaml.Yaml;

import java.util.Map;

public class SimpleYAMLConvertisseur implements PropertiesConvertisseur {
    @Override
    public ResultatConversion convertir(Map<String, String> props) {
        try {
            // Utiliser SnakeYAML pour convertir la Map directement en YAML
            Yaml yaml = new Yaml();
            String yamlOutput = yaml.dump(props);

            return new ResultatConversion(true, yamlOutput, null);
        } catch (Exception e) {
            return new ResultatConversion(false, null, "Erreur lors de la conversion simple en YAML : " + e.getMessage());
        }
    }
}