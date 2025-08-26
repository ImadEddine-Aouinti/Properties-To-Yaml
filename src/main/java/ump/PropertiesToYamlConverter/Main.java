package ump.PropertiesToYamlConverter;

import ump.PropertiesToYamlConverter.convertisseur.ConvertisseurFactory;
import ump.PropertiesToYamlConverter.convertisseur.PropertiesConvertisseur;
import ump.PropertiesToYamlConverter.load.PropertiesLoader;
import ump.PropertiesToYamlConverter.model.ResultatConversion;

import java.io.IOException;
import java.util.Map;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] filePaths = {"file1.properties"};
        try {
            System.out.println("Chargement des fichiers : " + Arrays.toString(filePaths));

            Map<String, String> props = PropertiesLoader.loadProperties(filePaths);

            testConvertisseur(ConvertisseurFactory.ConvertisseurType.IMBRIQUE, props);
        } catch (IOException e) {
            System.out.println("Erreur lors du chargement des fichiers properties : " + e.getMessage());
        }
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