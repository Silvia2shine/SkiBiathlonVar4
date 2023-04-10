package org.example;

public class IdentifyThePlayers {
    String line;
    TimeResult calculateTheTimeResult = new TimeResult();  // an object of the class TimeResult

    public String[] splitIntoLines(String line) {
        String[] tokensSentences = line.split("\n");
        return tokensSentences;
    }

    public String[] splitIntoWords(String line) {


        String[] tokensWord = line.split(","); // split into words
        return tokensWord;
    }

    public void assignValuesToAthlete(String[] tokensWord, Athlete athlete) throws ValidationException {

        int finalResult = 0;
        for (int i = 0; i < tokensWord.length; i++) {

            if (tokensWord == null)  {
                throw new ValidationException("The sentence is null");
            }
            if (tokensWord[0] == null || tokensWord[0].equalsIgnoreCase("")) {
                throw new ValidationException("The athlete number can't be smaller than 1.");
            }
            if (tokensWord[1] == null || tokensWord[1].equalsIgnoreCase("")) {
                throw new ValidationException("The athlete name can't null.");
            }
            if (tokensWord[2] == null || tokensWord[2].equalsIgnoreCase("")) {
                throw new ValidationException("The country code can't be null.");
            }
            if (tokensWord[3] == null || tokensWord[3].equalsIgnoreCase("")) {
                throw new ValidationException("The time result can't be null.");
            }
            if (tokensWord[4] == null || tokensWord[4].equalsIgnoreCase("")) {
                throw new ValidationException("The first shooting can't be null.");
            }
            if (tokensWord[5] == null || tokensWord[5].equalsIgnoreCase("")) {
                throw new ValidationException("The second shooting can't be null.");
            }
            if (tokensWord[6] == null || tokensWord[6].equalsIgnoreCase("")) {
                throw new ValidationException("The third shooting can't be null.");
            }
            if (tokensWord.length != 7) {
                throw new IndexOutOfBoundsException("The fields are not completed.");
            }

            athlete.athleteNumber = Integer.parseInt(tokensWord[0]);
            athlete.athleteName = tokensWord[1];
            athlete.countryCode = tokensWord[2];
            athlete.skiTimeResult = tokensWord[3];
            athlete.firstShooting = tokensWord[4];
            athlete.secondShooting = tokensWord[5];
            athlete.thirdShooting = tokensWord[6];
        }
        System.out.println("Athlete: " + athlete.athleteName);
        System.out.println("First penalty: " + calculateTheTimePenalty(tokensWord[4]));
        System.out.println("Second penalty: " + calculateTheTimePenalty(tokensWord[5]));
        System.out.println("Third penalty: " + calculateTheTimePenalty(tokensWord[6]));
        int finalResultInSec = calculateTheFinalResultInSeconds(athlete);
        System.out.println("Final result in seconds: "
                + finalResultInSec);
        System.out.println("Final result in min/sec: "
                + transformFinalResult(finalResultInSec));
        System.out.println();
    }

    public int calculateTheTimePenalty(String shoot) {

        int countThePenalty = 0;
        try {
            countThePenalty = calculateTheTimeResult.calculator(shoot);
        } catch (ValidationException e) {
            System.out.println("The input is null." + e.getMessage());
        }
        return countThePenalty;
    }

    public int calculateTheFinalResultInSeconds(Athlete athlete) throws ValidationException {

        int finalResultInSeconds = 0;
     if (calculateTheTimeResult.skiTimeResultSec(athlete.skiTimeResult)==0){
         throw  new ValidationException("Input is null");
     }
            finalResultInSeconds = calculateTheTimeResult.skiTimeResultSec(athlete.skiTimeResult) +
                    calculateTheTimePenalty(athlete.firstShooting) +
                    calculateTheTimePenalty(athlete.secondShooting) +
                    calculateTheTimePenalty(athlete.thirdShooting);

        return finalResultInSeconds;
    }

    public String transformFinalResult(int totalSeconds) {
        int minutes = totalSeconds / 60;
        int seconds = totalSeconds % 60;
        if (seconds >= 60) {
            seconds = totalSeconds - 60;
            minutes = minutes + 1;
        }
        String formattedTime = String.format("%02d:%02d", minutes, seconds);
        return formattedTime;
    }
}


