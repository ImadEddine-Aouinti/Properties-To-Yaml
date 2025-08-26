package ump.PropertiesToYamlConverter.output;

import java.io.FileWriter;
import java.io.IOException;

public class YamlFile {
    public static void writeYamlFile(String content, String outputFilePath) throws IOException {
        try (FileWriter writer = new FileWriter(outputFilePath)) {
            writer.write(content);
            System.out.println("Fichier YAML généré avec succès : " + outputFilePath);
        } catch (IOException e) {
            throw new IOException("Erreur lors de l'écriture du fichier YAML : " + outputFilePath, e);
        }
    }
}