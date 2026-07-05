package com.hemebiotech.analytics;

import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.HashMap;
import java.io.IOException;

/**
* La classe AnalyticsCounter contient les 4 méthodes permettant la demande de récupération, le traitement et la demande d'écriture des données, 
* utilisant les deux interfaces et leurs méthodes concrètes pour action.
*
* @param ISymptomReader : Déclare un reader de l'interface ISymptomReader pour affectuer la valeur reader dans le constructeur de la classe. 
*                         Le reader va nous permettre d'appeler la méthode getSymptoms() qui effectue la lecture du fichier source.
* @param ISymptomWriter : Déclare un writer de l'interface ISymptomReader pour affectuer la valeur writer dans le constructeur.
*                         Le Writer va nous permettre d'appeler la méthode writeSymptoms() qui effectue l'écriture dans le fichier cible.
* 
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
}