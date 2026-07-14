package com.hemebiotech.analytics;

import java.util.Map;
import java.util.List;
import java.io.IOException;

/** 
* Appelle les méthodes qui réalisent les différentes actions de lecture, de traitement et d'ecriture des données. 
*
* reader           : Lecteur de symptome.
* writer           : Écrivain de symptome.
* analyticsCounter : Instance qui permet de faire appel aux fonctions de traitement des symptomes.
*
* @see ISymptomReader
* @see ReadSymptomDataFromFile
* @see ISymptomWriter
* @see WriteSymptomDataToFile
* @see AnalyticsCounter
*/

public class Main {
    public static void main(String args[]) throws IOException {
        ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt"); 
        ISymptomWriter writer = new WriteSymptomDataToFile("result.out");
        AnalyticsCounter analyticsCounter = new AnalyticsCounter(reader, writer);
        List<String> symptoms = analyticsCounter.getSymptoms();
        Map<String, Integer> countedSymptoms = analyticsCounter.countSymptoms(symptoms);
        Map<String, Integer> sortedSymptoms = analyticsCounter.sortSymptoms(countedSymptoms);
        analyticsCounter.writeSymptoms(sortedSymptoms);     
    }
}