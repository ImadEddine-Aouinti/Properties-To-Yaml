package ump.PropertiesToYamlConverter.convertisseur.impl;

import org.yaml.snakeyaml.DumperOptions;
import ump.PropertiesToYamlConverter.convertisseur.PropertiesConvertisseur;
import ump.PropertiesToYamlConverter.model.ResultatConversion;
import org.yaml.snakeyaml.Yaml;

import java.util.Map;

public class SimpleYAMLConvertisseur implements PropertiesConvertisseur {
    @Override
    public ResultatConversion convertir(Map<String, String> props) {
        try {
            DumperOptions options = new DumperOptions();
            options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
            options.setPrettyFlow(true);
            options.setIndent(2); 

            Yaml yaml = new Yaml(options);
            String yamlOutput = yaml.dump(props);

            return new ResultatConversion(true, yamlOutput, null, null);
        } catch (Exception e) {
            return new ResultatConversion(false, null, "Erreur lors de la conversion simple en YAML : " + e.getMessage(), null);
        }
    }
}