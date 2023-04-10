package org.example;

public class Athlete {
   int athleteNumber;
   String athleteName;
   String countryCode;
   String skiTimeResult;  //(Minutes:Seconds)
    String firstShooting;
    String secondShooting;
    String thirdShooting;

    public Athlete(int athleteNumber, String athleteName,
                  String countryCode, String skiTimeResult,
                   String firstShooting, String secondShooting,
                   String thirdShooting) {
        this.athleteNumber = athleteNumber;
        this.athleteName = athleteName;
        this.countryCode = countryCode;
        this.skiTimeResult = skiTimeResult;
        this.firstShooting = firstShooting;
        this.secondShooting = secondShooting;
        this.thirdShooting = thirdShooting;
    }

    @Override
    public String toString() {
        return  athleteNumber + " , " + athleteName + " , " + countryCode + " , " +
                skiTimeResult + " , " + firstShooting + " , " + secondShooting + " , " +
                 thirdShooting;
    }
}
