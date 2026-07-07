package com.hemebiotech.analytics;

import java.util.Map;
import java.util.List;
import java.io.IOException;

/** La Classe Main utilise les contrats des deux interfaces ISymptomReader et ISymptomWriter pour appeler les méthodes conrètes qui réalisent les actions
*   de lecture et d'ecriture des données. La Classe Main utilise aussi les méthodes de la classe AnalyticsCounter pour les différents traitements des données.
* reader           : Objet permettant l'affectation du fichier source et la lecture des données.
* writer           : Objet permettant l'affectation du fichier cible et l'écriture dans le fichier cible.
* analiticsCounter : l'Objet de Classe AnalyticsCounter nous permet de faire appel à 5 fonctions : demander la récupération des symptomes depuis le fichier, 
*                    effectuer la récupération des symptomes vers une liste de type chaine de caractère, compter les occurences à l'aide d'une HashMap, 
*                    trier les les symptomes par ordre alphabétique avec une TreeMap, et demander l'écriture des symptomes occurés et triés dans un fichier.
* symptoms         : Objet de type List qui contient les données non triée et doublonnée du fichier source.
* countedSymptoms  : Objet de type HashMap qui contient les données non triée et dédoublonnée issue de la liste symptoms.
* sortedSymptoms   : Objet de type TreeMap qui contient les données triées avec leurs occurences issue de la HashMap countedSymptoms.
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