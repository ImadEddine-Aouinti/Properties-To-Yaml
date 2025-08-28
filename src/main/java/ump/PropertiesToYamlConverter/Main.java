package ump.PropertiesToYamlConverter;

import ump.PropertiesToYamlConverter.convertisseur.ConvertisseurFactory;
import ump.PropertiesToYamlConverter.convertisseur.PropertiesConvertisseur;
import ump.PropertiesToYamlConverter.load.PropertiesLoader;
import ump.PropertiesToYamlConverter.model.ResultatConversion;
import ump.PropertiesToYamlConverter.output.YamlFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String[] filePaths = {"file1.properties"};
        try {
            System.out.println("Chargement des fichiers : " + Arrays.toString(filePaths));

            Map<String, String> props = new HashMap<>();
            for (String filePath : filePaths) {
                Map<String, String> fileProps = PropertiesLoader.loadProperties(filePath);
                System.out.println("Propriétés chargées depuis " + filePath + " : " + fileProps.size());
                props.putAll(fileProps);
            }

            if (props.isEmpty()) {
                System.out.println("Aucune propriété chargée depuis les fichiers.");
                return;
            }

            testConvertisseur(ConvertisseurFactory.ConvertisseurType.IMBRIQUE, props, "imbrique_output.yaml");
        } catch (IOException e) {
            System.out.println("Erreur lors du chargement ou de l'écriture des fichiers : " + e.getMessage());
        }
    }

    private static void testConvertisseur(ConvertisseurFactory.ConvertisseurType type, Map<String, String> props, String outputFilePath) {
        PropertiesConvertisseur convertisseur = ConvertisseurFactory.getConvertisseur(type);
        System.out.println("Test du convertisseur : " + type);

        ResultatConversion resultat = convertisseur.convertir(props);

        if (resultat.isSucces()) {
            System.out.println("Conversion réussie ! Résultat YAML :");
            System.out.println(resultat.getContenu());
            // Écrire le résultat dans un fichier YAML
            try {
                YamlFile.writeYamlFile(resultat.getContenu(), outputFilePath);
            } catch (IOException e) {
                System.out.println("Erreur lors de l'écriture du fichier YAML : " + e.getMessage());
            }
        } else {
            System.out.println("Échec de la conversion : " + resultat.getErreur());
        }
    }
}