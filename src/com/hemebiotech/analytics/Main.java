package com.hemebiotech.analytics;

import java.util.Map;
import java.util.List;
import java.io.IOException;

/** La Classe Main utilise les contrats des deux interfaces ISymptomReader et ISymptomWriter pour instancier les méthodes qui réalisent les actions
*   de lecture et d'ecriture des données. La Classe Main utilise aussi les méthodes de la classe AnalyticsCounter pour les différents traitements des données.
*
* @param reader           : Objet permettant l'affectation du fichier source pour lecture.
* @param writer           : Objet permettant l'affectation du fichier cible pour écriture.
* @param analiticsCounter : l'Objet de Classe AnalyticsCounter nous permet de faire appel à 5 fonctions : demander la récupération les symptomes depuis le fichier, 
*                           affectuer la récupération des symptomes à une liste de type chaine de caractère, compter les occurences à l'aide d'une HashMap, 
*                           trier les les symptomes par ordre alphabétique avec une TreeMap, et demander l'écriture des symptomes occurés et triés dans un fichier.
* @param symptoms         : Objet de type List qui contient la liste non triée et doublonnée des données du fichier source.
* @param countedSymptoms  : Objet de type Map qui contient la récupération des données du fichier source.
* @param sortedSymptoms   : Objet de type Map qui contient les données non triées avec leurs occurences.
*
* @see ISymptomReader
* @see ISymptomWriter
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