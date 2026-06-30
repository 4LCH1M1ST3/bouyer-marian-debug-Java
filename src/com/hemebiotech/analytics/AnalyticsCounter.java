package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.util.List;
import java.io.IOException;

/**
* Analyse la liste de chaine de caractères des symptômes présents dans le fichier source retournée par la classe ReadSymptomDataFile    
* et écrit les résultats dans un fichier de sortie.
* @see ISymptomReader
* @see ReadSymptomDataFromFile
*/
public class AnalyticsCounter {
    
    private static int headacheCount = 0;	
    private static int rashCount = 0;		
    private static int pupilCount = 0;		
    public static void main(String args[]) throws IOException {
	    try {
            ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
            List<String> symptoms = reader.getSymptoms();
            System.out.println(symptoms);
	        for (String symptomeAAnalyser : symptoms){
	            if (symptomeAAnalyser.equals("headache")) {
		            headacheCount++;
		            System.out.println("number of headaches: " + headacheCount);
		        }
		        else if (symptomeAAnalyser.equals("rash")) {
		            rashCount++;
		            System.out.println("number of rash: " + rashCount);
		        }
		        else if (symptomeAAnalyser.contains("pupils")) {
		            pupilCount++;
		            System.out.println("number of pupils contains: " + pupilCount);
		        }
            }
        BufferedWriter writer = new BufferedWriter (new FileWriter(new File("result.out")));
	writer.write("headache: " + headacheCount + "\n");
        writer.write("rash: " + rashCount + "\n");
        writer.write("dialated pupils: " + pupilCount + "\n");
        writer.close();
        }catch (IOException e) {
            e.printStackTrace;
        }
    }
}