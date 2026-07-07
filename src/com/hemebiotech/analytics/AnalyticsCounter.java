package com.hemebiotech.analytics;

import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.HashMap;
import java.io.IOException;

/**
* La classe AnalyticsCounter contient les méthodes permettant le traitement des données en 4 étapes : Demander la récupération des données dans une List, 
* compter les occurences des données (dédoublonnage), trier les données (par ordre alphabétique), demander l'écriture du résultat dans un fichier.
*
* La classe AnalyticsCounter initialise un objet reader et un objet writer utilisés pour les opération de lecture et d'écriture qui sont déléguées aux interfaces
* ISymptomReader et ISymptomWriter.
*
* @see ISymptomReader
* @see ISymptomWriter
* @see ReadSymptomDataFromFile
* @see WriteSymptomDataToFile
*/

public class AnalyticsCounter {    
    private final ISymptomReader reader;
    private final ISymptomWriter writer;

    /**
    * Construit un analyseur de symptomes avec un lecteur et un écrivain.
    * @param reader lecteur utilisé pour récupérer les symptomes du fichier source.
    * @param writer écrivain utilisé pour produire le fichier de résultat.
    */    
    
    public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) { 
        this.reader = reader;
        this.writer = writer;
    }
    
    /**
    * Méthode de type List de chaîne de caractère qui demande la lecture du fichier source qui est déléguée à l'interface ISymptomReader et sa classe concrète ReadSymptomDataFromFile.
    * @return reader.getSymptoms renvoie une liste de chaine de caractère lue dans le fichier source.
    */    
    
    public List<String> getSymptoms() {
        return reader.getSymptoms();
    }

    /**
    * Méthode qui compte les occurences par l'intermédiaire d'une HashMap.
    * @return counterSymptoms renvoie une HashMap avec pour clé une chaine de caractère (symptômes) et pour valeur un Integer(occurence).
    */     
    
    public Map<String, Integer> countSymptoms(List<String> symptoms) { 
        Map<String, Integer> counterSymptoms = new HashMap<>();
        for (String symptom : symptoms) {
            if (symptom != null && !symptom.isBlank()) {
                counterSymptoms.put(symptom, counterSymptoms.getOrDefault(symptom, 0) + 1);
            }
        }
    return counterSymptoms;
    }

    /**
    * Méthode qui trie les symtomes par ordre alphabatique par l'intermédiaire d'une TreeMap.
    * @return symptoms renvoie une TreeMap avec pour clé une chaine de caractère (symptômes) et pour valeur un Integer(occurence).
    */
 
    public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
        return new TreeMap<>(symptoms);
    }

    /**
    * Méthode qui demande l'écriture de la TreeMap dans le fichier cible, action déléguée à l'instance ISymptomWriter et sa classe concrète WriteSymptomDataéToFile.
    * @Exception IOException gérer la possible levée d'exception si une erreur se produit lors de l'ouverture du fichier ou de l'écriture des données.
    */
    
    public void writeSymptoms(Map<String, Integer> symptoms) {
        try {
            writer.writeSymptoms(symptoms);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}