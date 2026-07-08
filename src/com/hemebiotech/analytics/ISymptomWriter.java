package com.hemebiotech.analytics;

import java.util.Map;
import java.io.IOException;

/**
* Écrit les symptomes dans un fichier cible.
*  
* @see WriteSymptomDateToFile
*/

public interface ISymptomWriter {
    
    /**
    * Écrit les données formatées sous forme d'une Map qui n'autorise pas les doublons.
    *
    * @Exception IOException gère une possible levée d'exception pour une erreur lors de la création/ouverture du fichier et l'écriture des données.
    */
    
    void writeSymptoms(Map<String, Integer> symptoms) throws IOException;
}
