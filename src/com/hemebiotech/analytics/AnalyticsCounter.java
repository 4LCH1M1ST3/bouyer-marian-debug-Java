package com.hemebiotech.analytics;

import java.util.Map;
import java.util.List;
import java.util.TreeMap;
import java.util.HashMap;
import java.io.IOException;

/**
* Refactorisation : création du constructeur et de 4 méthodes qui séparent les divers traitements de la donnée.
* Lire les données(getSymptoms), compter les occurrences(countSymptoms), trier les données(sortSymptoms), écrire les données(writeSymptoms).
* @see ISymptomReader
* @see ISymptomWriter
* @see ReadSymptomDataFromFile
* @see WriteSymptomDataToFile
*/

public class AnalyticsCounter {
    private final ISymptomReader reader;
    private final ISymptomWriter writer;
    
    public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) { 
        this.reader = reader;
        this.writer = writer;
    }
    
    public List<String> getSymptoms() {
        return reader.getSymptoms();
    }
    
    public Map<String, Integer> countSymptoms(List<String> symptoms) { 
        Map<String, Integer> counterSymptoms = new HashMap<>();
        for (String symptom : symptoms) {
            if (symptom != null && !symptom.isBlank()) {
                counterSymptoms.put(symptom, counterSymptoms.getOrDefault(symptom, 0) + 1);
            }
        }
    
    return counterSymptoms;
    }
    
    public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
        return new TreeMap<>(symptoms);
    }
    
    public void writeSymptoms(Map<String, Integer> symptoms) {
        try {
            writer.writeSymptoms(symptoms);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {}
}