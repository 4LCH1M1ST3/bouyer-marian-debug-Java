package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Map;
import java.io.IOException;

/**
* Écrit les données dans un fichier cible. 
* Initialise une chaîne de caractère qui va contenir le chemin relatif ou absolu du fichier cible.
*
* @see ISymptomWriter
*/

public class WriteSymptomDataToFile implements ISymptomWriter {
    private String filepath;

    /**
    * Construit le chemin d'accès au fichier cible
    *
    * @param filepath contient le chemin relatif ou absolu du fichier cible.
    */

    public WriteSymptomDataToFile (String filepath) {
        this.filepath = filepath;
    }

    /**
    * Écrit dans le fichier cible, ligne par ligne, le contenu de chaque clé(symptôme)/valeur(occurence) de la Map.
    *
    * @Exception IOException Gère la possible levée d'exception lors d'une erreur d'écriture.
    */
    
    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) throws IOException {
        if (filepath == null && symptoms == null) {
            return;
        }
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filepath))) {
            for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
                bufferedWriter.write(entry.getKey() + ": " + entry.getValue());
                bufferedWriter.newLine();
            }
        }
    }
}
