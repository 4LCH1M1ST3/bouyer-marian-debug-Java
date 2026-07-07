package com.hemebiotech.analytics;

import java.util.List;

/**
* Lit les symptomes depuis un fichier source.
*
* @see ReadSymptomDateFromFile
*/

public interface ISymptomReader {
    
    /**
    * Lit les données formatées sous forme d'un liste de chaîne de caractères. 
    * Cette liste de chaîne de caractère retrounée contient possiblement des doublons.
    */
    
    List<String> getSymptoms ();
}
