package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IdentifyThePlayersTest {
    @Test
    void assignValuesToAthleteValidInput()  {
        IdentifyThePlayers player = new IdentifyThePlayers();
        Athlete athlete = new Athlete(99, "Umar Jorgson",
                "SK", "30:27", ",xxxox",
                "xxxxx", "xxoxo");
        String sentence = "44,Silvia Padurean,RO,30:00,xxxxx,00000,xxxxx";
        String[] words = player.splitIntoWords(sentence);
        try {
            player.assignValuesToAthlete(words, athlete);
        } catch (ValidationException e) {
        }
        assertEquals(44, athlete.athleteNumber);
    }
@Test  // This test doesn't work; cach the: null pointer exception
    void assignValuesToAthleteInputNull()  {
        IdentifyThePlayers player = new IdentifyThePlayers();
        Athlete athlete = new Athlete(99, "Ioan",
                "SK", "30:27", ",xxxox",
                "xxxxx", "xxoxo");

        String sentence = "44, , ,30:00,xxxxx,00000,xxxxx";

        String[] words = player.splitIntoWords(sentence);

        assertThrows(ValidationException.class, () -> {
            player.assignValuesToAthlete(null, athlete);
        });
    }
    @Test
    void calculateTheFinalResultInSecondsValidInput() throws ValidationException {

        IdentifyThePlayers player = new IdentifyThePlayers();
        Integer theResult = player.calculateTheFinalResultInSeconds(new Athlete(99,
                "Umar Jorgson", "SK", "30:27", ",xxxox",
                "xxxxx", "xxoxo"));
        assertEquals(1857, theResult);
    }

    @Test  // the test dosn't work. It caches the null pointer exception
    void calculateTheFinalResultInSecondsNullInput() {

        IdentifyThePlayers player = new IdentifyThePlayers();
        Athlete athlete = new Athlete(99, "Ioan",
                "SK", "30:27", ",xxxox",
                "xxxxx", "xxoxo");

        assertThrows(ValidationException.class, () -> {
            player.assignValuesToAthlete(null,athlete);
        });
    }
    @Test
    void transformFinalResult() {
        Integer numberInSeconds = 1810;
        IdentifyThePlayers player = new IdentifyThePlayers();
        String transform = player.transformFinalResult(numberInSeconds);
        assertEquals("30:10", transform);
    }
}