package ump.PropertiesToYamlConverter;

import ump.PropertiesToYamlConverter.convertisseur.impl.SimpleYAMLConvertisseur;
import ump.PropertiesToYamlConverter.model.ResultatConversion;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Créer une Map simulant un fichier properties
        Map<String, String> props = new HashMap<>();
        props.put("name", "Alice");
        props.put("age", "25");
        props.put("city", "Paris");
        props.put("enabled", "true");

        // Instancier SimpleYAMLConvertisseur
        SimpleYAMLConvertisseur convertisseur = new SimpleYAMLConvertisseur();

        // Effectuer la conversion
        ResultatConversion resultat = convertisseur.convertir(props);

        // Vérifier le résultat
        if (resultat.isSucces()) {
            System.out.println("Conversion réussie ! Résultat YAML :");
            System.out.println(resultat.getContenu());
        } else {
            System.out.println("Échec de la conversion : " + resultat.getErreur());
        }

    }
}