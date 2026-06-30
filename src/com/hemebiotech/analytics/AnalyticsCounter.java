package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.util.List;
import java.util.ArrayList;
import java.io.IOException;

public class AnalyticsCounter {
    /**
    * La classe AnalyticsCounter permet d'analyser la présence et la récurrence de 3 symptomes dans le fichier source.
    *
    *@param headacheCount : compteur du symptome headache.
    *@param rashCount : compteur du symtome rash.
    *@param pupilCount : compteur des symptomes contenant la chaine de caractère "pupil".
    *@see ReadSymptomDataFromFile.java
    *@see ISymptomReader.java
    */
    private static int headacheCount = 0;	
    private static int rashCount = 0;		
    private static int pupilCount = 0;		
    public static void main(String args[]) throws IOException {
	    // Ajout d'un bloc try{}/catch{} pour gérer l'exception IO
	    try {
            ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
            List<String> symptoms = reader.getSymptoms();
            System.out.println(symptoms+"\n");
	        for (String symptomeAAnalyser : symptoms){
	            if (symptomeAAnalyser.contains("headache")) {
		            headacheCount++;
		            System.out.println("number of headaches: " + headacheCount);
		        }
		        else if (symptomeAAnalyser.contains("rash")) {
		            rashCount++;
		            System.out.println("number of rash: " + rashCount);
		        }
		        else if (symptomeAAnalyser.contains("pupils")) {
		            pupilCount++;
		            System.out.println("number of pupils: " + pupilCount);
		        }
            }
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