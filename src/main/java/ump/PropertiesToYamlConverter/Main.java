package ump.PropertiesToYamlConverter;

import ump.PropertiesToYamlConverter.convertisseur.ConvertisseurFactory;
import ump.PropertiesToYamlConverter.convertisseur.PropertiesConvertisseur;
import ump.PropertiesToYamlConverter.model.ResultatConversion;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, String> props = new HashMap<>();
        props.put("user.name", "Alice");
        props.put("user.age", "25");
        props.put("user.address.city", "Paris");
        props.put("user.address.country", "France");
        props.put("settings.enabled", "true");
        props.put("settings.theme", "dark");

        testConvertisseur(ConvertisseurFactory.ConvertisseurType.SIMPLE, props);
        System.out.println("----------------------------------------");
        testConvertisseur(ConvertisseurFactory.ConvertisseurType.IMBRIQUE, props);
    }

    private static void testConvertisseur(ConvertisseurFactory.ConvertisseurType type, Map<String, String> props) {
        PropertiesConvertisseur convertisseur = ConvertisseurFactory.getConvertisseur(type);
        System.out.println("Test du convertisseur : " + type);

        ResultatConversion resultat = convertisseur.convertir(props);

        if (resultat.isSucces()) {
            System.out.println("Conversion réussie ! Résultat YAML :");
            System.out.println(resultat.getContenu());
        } else {
            System.out.println("Échec de la conversion : " + resultat.getErreur());
        }
    }
}