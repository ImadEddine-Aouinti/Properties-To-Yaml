package ump.PropertiesToYamlConverter.convertisseur.impl;

import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;
import ump.PropertiesToYamlConverter.convertisseur.PropertiesConvertisseur;
import ump.PropertiesToYamlConverter.model.ResultatConversion;

import java.util.HashMap;
import java.util.Map;

public class ImbriqueYAMLConvertisseur implements PropertiesConvertisseur {
    @Override
    public ResultatConversion convertir(Map<String,String> props){
        try{
            Map<String,Object> NewMap = convertirEnMapImbrique(props);
            DumperOptions options = new DumperOptions();
            options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
            options.setPrettyFlow(true);
            options.setIndent(2);

            Yaml yaml = new Yaml(options);
            String yamlOutput = yaml.dump(NewMap);
            return new ResultatConversion(true, yamlOutput, null, null);
        }catch (Exception e){
            return new ResultatConversion(false, null, "Erreur lors de la conversion imbriquée en YAML : " + e.getMessage(), null);
        }
    }


    private Map<String, Object> convertirEnMapImbrique(Map<String, String> props) {
        return props.entrySet().stream()
                .collect(HashMap::new,(res,entry) -> {
                    String[] parties = entry.getKey().split("\\.");
                    String valeur = entry.getValue();
                    Map<String,Object> niveauActuel = res ;

                    for(int i=0;i< parties.length-1;i++){
                        String part = parties[i];
                        niveauActuel =(Map<String,Object>) niveauActuel.computeIfAbsent(part,k -> new HashMap<String,Object>());
                    }
                    niveauActuel.put(parties[parties.length -1],valeur);
                },HashMap::putAll);
    }
}
