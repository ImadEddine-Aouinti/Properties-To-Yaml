package ump.PropertiesToYamlConverter.convertisseur;

import ump.PropertiesToYamlConverter.model.ResultatConversion;

import java.util.Map;

public interface PropertiesConvertisseur {
    ResultatConversion convertir(Map<String,String> props );
}
