package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.util.Map;
import java.util.TreeMap;
import java.io.IOException;

/**
* la classe WriteSymptomDataToFile écrit les données dans un fichier cible. 
* la classe initialise une chaîne de caractère qui va contenir le chemin relatif ou absolu du fichier cible.
* @see ISymptomWriter
*/

public class WriteSymptomDataToFile implements ISymptomWriter {
    private String filepath;

    /**
    * Construit le chemin d'accès au fichier cible
    * @param filepath contient le chemin relatif ou absolu du fichier cible.
    /*

    public WriteSymptomDataToFile (String filepath) {
        this.filepath = filepath;
    }

    /**
    * la méthode writeSymptoms écrit dans le fichier cible, ligne par ligne, le contenu de chaque clé/valeur de la Map.
    * @param symptoms contient la liste de tous les symptomes triés par ordre alphabétique, dédoublonnés avec leurs occurences.
    */
    
    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) throws IOException {
        if (filepath != null && symptoms != null) {
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(filepath)))) {
                for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
                    bufferedWriter.write(entry.getKey() + ": " + entry.getValue());
                    bufferedWriter.newLine();
                }
            }
        }
    }
}
