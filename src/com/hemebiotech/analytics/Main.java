package com.hemebiotech.analytics;

import java.util.Map;
import java.util.List;
import java.io.IOException;

/** Appelle les méthodes qui réalisent les différentes actions de lecture, de traitement et d'ecriture des données. 
*
* reader           : Lecteur de symptome.
* writer           : Écrivain de symptome.
* analyticsCounter : Instance qui permet de faire appel à 5 fonctions : demander la récupération des symptomes depuis le fichier, 
*                    effectuer la récupération des symptomes vers une liste de type chaine de caractère, compter les occurences à l'aide d'une HashMap, 
*                    trier les les symptomes par ordre alphabétique avec une TreeMap, et demander l'écriture des symptomes occurés et triés dans un fichier.
* symptoms         : Contient les données sous forme de liste non triée et doublonnée du fichier source.
* countedSymptoms  : Contient les données sous forme de HashMap non triée avec occurences issue de la liste symptoms.
* sortedSymptoms   : Contient les données sous forme de TreeMap triée avec occurences issue de la HashMap countedSymptoms.
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