# Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application

## Description
Lit depuis `symptom.txt`, compte les symptômes,
trie les résultats, écrit dans `result.out`.

## Fonctionnalités
- lecture avec `ISymptomReader`.
- comptage et triage avec `AnalyticsCounter`.
- écriture avec `ISymptomWriter`.

## Architecture
- `Main` appelle les méthodes successivement.
- Le reader lit le fichier source.
- `AnalyticsCounter` compte et trie les données.
- Le writer écrit les résultat dans le fichier cible.

## Installation/exécution
```bash
git clone https://github.com/4LCH1M1ST3/bouyer-marian-debug-Java
cd src/com/hemebiotech/analytics
# lancer Main.java depuis l'IDE.
```

## Extrait de code (méthode de comptage)
```java
public Map<String, Integer> countSymptoms(List<String> symptoms) { 
        Map<String, Integer> counterSymptoms = new HashMap<>();
            symptoms.stream()
                    .filter(symptom -> symptom != null && !symptom.isBlank())
                    .forEach(symptom -> counterSymptoms.merge(symptom, 1, Integer::sum));
        return counterSymptoms;
    }
```

## Auteur
4LCH1M1ST3(MB) 
 
 Projet 2 : Débuggez une application Java
 
 Formation OCR : Developpeur d'application Java
