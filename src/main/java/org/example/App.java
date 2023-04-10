package org.example;


import java.util.Map;
import java.util.TreeMap;

public class App {

    public static void main(String[] args) {


        Map<Integer, String> athleteMap = new TreeMap<>();

        Athlete athlete = new Athlete(99,
                "Umar Jorgson", "SK", "30:27", ",xxxox",
                "xxxxx", "xxoxo");

        ReadAndSaveCSV reader = new ReadAndSaveCSV();
        System.out.println(reader.readAndSaveCSV());
        System.out.println();

        IdentifyThePlayers players = new IdentifyThePlayers();

        String[] line = players.splitIntoLines(reader.readAndSaveCSV());
        for (int i = 0; i < line.length; i++) {
            String[] words = players.splitIntoWords(line[i]);
            try {
                players.assignValuesToAthlete(words, athlete);
            } catch (ValidationException e) {
                System.out.println("The athlete read is not valid");
            }

            try {
                players.assignValuesToAthlete(words, athlete);
            } catch (IndexOutOfBoundsException | ValidationException e) {
                System.out.println("The sentence read is not valid/ Index out of bound exception.");
            }

            try {
                athleteMap.put(players.calculateTheFinalResultInSeconds(athlete), athlete.athleteName);
            } catch (ValidationException e) {
                System.out.println("Invalid input." +e.getMessage());
            }

            System.out.println("The map and the rank is: " + athleteMap);

            System.out.println();
            System.out.println("The final rank is :  ");
            System.out.println();

            for (TheRanking theRanking : TheRanking.values()) {
                System.out.print(theRanking + " - " + theRanking.nameOfTheParticipant +
                        ", final result in seconds: " + +theRanking.finalResult + " ; ");
                theRanking.transformFinalResult(theRanking.finalResult);
                System.out.println();
            }

        }
    }
}

