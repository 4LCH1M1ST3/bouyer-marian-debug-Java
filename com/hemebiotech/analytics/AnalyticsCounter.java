package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class AnalyticsCounter {
    // Création et initialisation de 3 variables de classes utilisées en compteurs de symptomes.
    private static int headacheCount = 0;	
    private static int rashCount = 0;		
    private static int pupilCount = 0;		
    public static void main(String args[]) throws IOException {
	// Ajout d'un bloc try{}/catch{} pour gérer l'exception IO
	try {
            BufferedReader reader = new BufferedReader (new FileReader(new File("symptoms.txt")));
	    String line = reader.readLine();
	    while (line != null) {
	        System.out.println("symptom from file: " + line);
		if (line.equals("headache")) {
		    headacheCount++;
		    System.out.println("number of headaches: " + headacheCount);
		}
		else if (line.equals("rash")) {
	            rashCount++;
                    System.out.println("number of rash: " + rashCount);
                }
		else if (line.contains("pupils")) {
		    pupilCount++;
		    System.out.println("number of pupil: " + pupilCount);
		}
		line = reader.readLine();// Extraire la ligne suivante du fichier
	    }
	    reader.close();
	    // Après lecture complète du fichier, écriture des résultats dans le fichier result.out.
            BufferedWriter writer = new BufferedWriter (new FileWriter(new File("result.out")));
	    writer.write("headache: " + headacheCount + "\n");
            writer.write("rash: " + rashCount + "\n");
	    writer.write("dialated pupils: " + pupilCount + "\n");
            writer.close();
	}catch (IOException e) {
	    System.out.println("Error reading file: " + e.getMessage());
        }
    }
}