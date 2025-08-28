package ump.PropertiesToYamlConverter.convertisseur;

import ump.PropertiesToYamlConverter.convertisseur.impl.*;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ConvertisseurFactory {
    public enum ConvertisseurType{
        SIMPLE,
        IMBRIQUE
    }
    private static final Map<ConvertisseurType, Supplier<PropertiesConvertisseur>> CONVERTISSEUR_MAP = new HashMap<>();

    static {
        CONVERTISSEUR_MAP.put(ConvertisseurType.SIMPLE, SimpleYAMLConvertisseur::new);
        CONVERTISSEUR_MAP.put(ConvertisseurType.IMBRIQUE, ImbriqueYAMLConvertisseur::new);
    }

    public static PropertiesConvertisseur getConvertisseur(ConvertisseurType type) {
        Supplier<PropertiesConvertisseur> supplier = CONVERTISSEUR_MAP.get(type);
        if (supplier == null) {
            throw new IllegalArgumentException("Type de convertisseur inconnu : " + type);
        }
        return supplier.get();
    }

}
