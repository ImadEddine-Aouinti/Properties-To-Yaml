package ump.PropertiesToYamlConverter.facade;

import ump.PropertiesToYamlConverter.convertisseur.ConvertisseurFactory;
import ump.PropertiesToYamlConverter.convertisseur.PropertiesConvertisseur;
import ump.PropertiesToYamlConverter.load.PropertiesLoader;
import ump.PropertiesToYamlConverter.model.ResultatConversion;
import ump.PropertiesToYamlConverter.output.YamlFile;

import java.io.IOException;
import java.util.Map;

public class ConvertisseurManager {
    public ResultatConversion convertirFichiers(ConvertisseurFactory.ConvertisseurType type,
                                                String outputFilePath,
                                                String... inputFilePaths) throws IOException {
        try {
            Map<String, String> properties = PropertiesLoader.loadProperties(inputFilePaths);

            PropertiesConvertisseur convertisseur = ConvertisseurFactory.getConvertisseur(type);

            ResultatConversion resultat = convertisseur.convertir(properties);

            if (resultat.isSucces()) {
                YamlFile.writeYamlFile(resultat.getContenu(), outputFilePath);
            }

            return resultat;
        } catch (IOException e) {
            return new ResultatConversion(false, null,
                    "Erreur lors de la conversion des fichiers : " + e.getMessage(), null);
        }
    }
}