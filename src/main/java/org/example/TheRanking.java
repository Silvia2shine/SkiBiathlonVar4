package org.example;
/**
 * An enum that is used to list the ranking ;
 *
 */
public enum TheRanking {

    WINNER("Piotr Smitzer", 1810),
    RUNNER_UP("Jimmy Smiles", 1815),
    THIRD_PLACE("Umar Jorgson", 1857);
    public final String nameOfTheParticipant;
    public final Integer finalResult;

    TheRanking(String nameOfTheParticipant, Integer finalResult) {
        this.nameOfTheParticipant = nameOfTheParticipant;
        this.finalResult = finalResult;
    }

    public void transformFinalResult(int totalSeconds) {
        int minutes = totalSeconds / 60;
        int seconds = totalSeconds % 60;
        if (seconds >= 60){
           seconds = totalSeconds-60;
           minutes = minutes + 1;
        }
        String formattedTime = String.format("%02d:%02d", minutes, seconds);
        System.out.println(formattedTime);

    }
}

