package ump.PropertiesToYamlConverter;

import ump.PropertiesToYamlConverter.facade.ConvertisseurManager;
import ump.PropertiesToYamlConverter.convertisseur.ConvertisseurFactory;
import ump.PropertiesToYamlConverter.model.ResultatConversion;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        ConvertisseurManager manager = new ConvertisseurManager();

        // Chemins des fichiers d'entrée et de sortie (à adapter selon votre environnement)
        String[] inputFiles = {"file1.properties"};
        String outputFileSimple = "output_simple.yaml";
        String outputFileImbrique = "output_imbrique.yaml";

        try {
            // Test avec convertisseur SIMPLE
            System.out.println("Conversion avec le convertisseur SIMPLE :");
            ResultatConversion resultatSimple = manager.convertirFichiers(
                    ConvertisseurFactory.ConvertisseurType.SIMPLE,
                    outputFileSimple,
                    inputFiles
            );

            if (resultatSimple.isSucces()) {
                System.out.println("Conversion SIMPLE réussie ! Contenu :");
                System.out.println(resultatSimple.getContenu());
            } else {
                System.out.println("Erreur lors de la conversion SIMPLE : " + resultatSimple.getErreur());
            }

            // Test avec convertisseur IMBRIQUE
            System.out.println("\nConversion avec le convertisseur IMBRIQUE :");
            ResultatConversion resultatImbrique = manager.convertirFichiers(
                    ConvertisseurFactory.ConvertisseurType.IMBRIQUE,
                    outputFileImbrique,
                    inputFiles
            );

            if (resultatImbrique.isSucces()) {
                System.out.println("Conversion IMBRIQUE réussie ! Contenu :");
                System.out.println(resultatImbrique.getContenu());
            } else {
                System.out.println("Erreur lors de la conversion IMBRIQUE : " + resultatImbrique.getErreur());
            }

        } catch (IOException e) {
            System.out.println("Erreur générale : " + e.getMessage());
        }
    }
}