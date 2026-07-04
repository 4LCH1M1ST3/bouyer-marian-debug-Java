package com.hemebiotech.analytics;

import java.util.Map;
import java.util.TreeMap;
import java.util.List;
import java.io.IOException;

/**
* Analyse la liste de chaine de caractères des symptômes présents dans le fichier source retournée par la classe ReadSymptomDataFile    
* et trie les symptomes et ajoute les occurences avec une TreeMap pour les envoyer vers WriteSymptomDataToFile pour qu'ils soient écrits dans un fichier.
* @see ISymptomReader
* @see ReadSymptomDataFromFile
*/
public class AnalyticsCounter {
    public static void main(String args[]) {
        try {
            ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
            ISymptomWriter writer = new WriteSymptomDataToFile("result.out");

            List<String> symptomsReader = reader.getSymptoms();

            Map<String, Integer> symptomsCounter = new TreeMap<>();

            for (String symptom : symptomsReader) {
                if (symptom != null && !symptom.isBlank()) {
                    symptomsCounter.put(symptom, symptomsCounter.getOrDefault(symptom, 0) + 1);
                }
            }

            writer.writeSymptoms(symptomsCounter);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}