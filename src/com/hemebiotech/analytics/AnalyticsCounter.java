package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
import java.io.IOException;

/**
* Traite les données en 4 méthodes : Demander la récupération des données dans une List, compter les occurences des données (dédoublonnage)
* trier les données (par ordre alphabétique), demander l'écriture du résultat dans un fichier.
*
* La classe implémente les contrats ISymptomReader et ISymptomWriter utilisés pour les opération de lecture et d'écriture.
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
    *
    * @param reader lecteur utilisé pour récupérer les symptomes du fichier source.
    * @param writer écrivain utilisé pour produire le fichier de résultat.
    */    
    
    public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) { 
        this.reader = reader;
        this.writer = writer;
    }
    
    /**
    * Demande la lecture du fichier source qui est déléguée à l'interface ISymptomReader et sa classe concrète ReadSymptomDataFromFile.
    *
    * @return reader.getSymptoms renvoie une liste de chaine de caractère lue depuis le fichier source.
    */    
    
    public List<String> getSymptoms() {
        return reader.getSymptoms();
    }

    /**
    * Compte les occurences.
    *
    * @return counterSymptoms renvoie une HashMap avec pour clé les symptômes et pour valeur leurs occurences.
    */     
    
    public Map<String, Integer> countSymptoms(List<String> symptoms) { 
        Map<String, Integer> counterSymptoms = new HashMap<>();
            symptoms.stream()
                    .filter(symptom -> symptom != null && !symptom.isBlank())
                    .forEach(symptom -> counterSymptoms.merge(symptom, 1, Integer::sum));
        return counterSymptoms;
    }

    /**
    * Trie les symtomes par ordre alphabatique.
    *
    * @return symptoms renvoie une TreeMap avec pour clé les symptômes triés par ordre alphabétique et pour valeur leurs occurences.
    */
 
    public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
        return new TreeMap<>(symptoms);
    }

    /**
    * Demande l'écriture de la TreeMap dans le fichier cible, action déléguée à l'instance ISymptomWriter et sa classe concrète WriteSymptomDataéToFile.
    *
    * @Exception IOException Gérer la possible levée d'exception si une erreur se produit lors de l'ouverture du fichier ou de l'écriture des données.
    */
    
    public void writeSymptoms(Map<String, Integer> symptoms) {
        try {
            writer.writeSymptoms(symptoms);
        } catch (IOException e) {
            System.err.println("Erreur lors de l'écriture des données dans le fichier cible");
            e.printStackTrace();
        }
    }
}