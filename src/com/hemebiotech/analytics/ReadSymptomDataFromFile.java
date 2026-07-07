package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * la classe ReadSymptomDataFromFile qui lit les données ligne par ligne depuis un fichier source.
 * la classe instancie un objet de type String qui contient nom du fichier source.
 * @see ISymptomReader
 */

public class ReadSymptomDataFromFile implements ISymptomReader {
    private String filepath;
    /**
    * Construit le chemin d'accès au fichier source.
    * @param filepath contient le chemin d'accès realatif ou absolu du fichier source.
    */
    
    public ReadSymptomDataFromFile (String filepath) {
        this.filepath = filepath;
    }
    /**
    * La méthode getSymptoms lit les données depuis le fichier source ligne par ligne et les injecte dans une liste
    * de chaîne de caractère
    *
    * @return result retourne la liste de chaîne de caractère potentiellement doublonnée.
    */
    
    @Override
    public List<String> getSymptoms() {
        ArrayList<String> result = new ArrayList<String>();
        if (filepath != null) {
            try {
                BufferedReader reader = new BufferedReader (new FileReader(filepath));
		String line = reader.readLine();
                while (line != null) {
                    result.add(line);
                    line = reader.readLine();
                }
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
	return result;
    }
}