package ump.PropertiesToYamlConverter;

import ump.PropertiesToYamlConverter.convertisseur.impl.ImbriqueYAMLConvertisseur;
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

        ImbriqueYAMLConvertisseur convertisseur = new ImbriqueYAMLConvertisseur();

        ResultatConversion resultat = convertisseur.convertir(props);

        if (resultat.isSucces()) {
            System.out.println("Conversion réussie ! Résultat YAML :");
            System.out.println(resultat.getContenu());
        } else {
            System.out.println("Échec de la conversion : " + resultat.getErreur());
        }
    }
}