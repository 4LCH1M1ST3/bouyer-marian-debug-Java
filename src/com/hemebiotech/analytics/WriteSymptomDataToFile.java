package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.util.TreeMap;
import java.util.Map;
/**
* la Classe WriteSymptomDataToFile permet de déterminer le fichier de sortie avec le constructeur et avec la méthode writeSymptoms
* écrit dans le ficher de sortie les symptomes triées grâce à la TreeMap obtenue en paramètre.
*
*@see ISymptomWriter.java
*@see AnalyticsCounter.java
*/

public class WriteSymptomDataToFile implements ISymptomWriter {

    	private String filepath;

    public WriteSymptomDataToFile (String filepath) {
        this.filepath = filepath;
    }

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
