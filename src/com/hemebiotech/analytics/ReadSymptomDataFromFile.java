package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
* Lit les données de symptomes ligne par ligne depuis un fichier source.
* Implémente le contrat ISymptomReader et retourne les symptomes sous forme de liste de chaîne de caractères.
*
* @see ISymptomReader
*/

public class ReadSymptomDataFromFile implements ISymptomReader {
    private final String filepath;
    
    /**
    * Construit un lecteur de symptome à partir du chemin d'accès au fichier source.
    *
    * @param filepath contient le chemin d'accès realatif ou absolu du fichier source.
    */    
    
    public ReadSymptomDataFromFile (String filepath) {
        this.filepath = filepath;
    }

    /**
    * Lit les données depuis le fichier source ligne par ligne et retourne les symptomes trouvés 
    * dans une liste de chaîne de caractère.
    *
    * @return result retourne la liste de chaîne de caractère potentiellement doublonnée.
    */    
    
    @Override
    public List<String> getSymptoms() {
        ArrayList<String> result = new ArrayList<>();
        if (filepath == null) {
            return result;
        }
        try (BufferedReader reader = new BufferedReader (new FileReader(filepath))) {
            String line = reader.readLine();
            while (line != null) {
                result.add(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier source.");
            e.printStackTrace();
        }
        return result;
    }
}
