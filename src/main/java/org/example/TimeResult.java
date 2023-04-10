package org.example;

/**
 * A  class that is used to identify the first players ;
 *
 * @param - file path;
 * @param - path;
 */
public class TimeResult {
    /**
     * A  method that counts the shoots ;
     *
     * @param - count;
     * @param - shoot;
     */
    public int calculator(String initial) throws ValidationException {
        int count = 0;
        if (initial == null || initial.equalsIgnoreCase("")) {

            throw new ValidationException("The penalty can't be calculate, " +
                    "because the value introduce is null!");
        }
    char[] shoot = initial.toCharArray();
        for(
    int i = 0;
    i<shoot.length;i++)

    {
        if (shoot[i] == 'o') {
            count += 10;
        }
    }
        return count;
}

    /**
     * A  method that transform the score read from the file, in seconds;
     *
     * @param - minSec;
     * @param - minInSec;
     * @param - sec;
     * @param - resultInSec;
     */
    public int skiTimeResultSec(String resultRead) throws ValidationException {

        int resultInSec = 0;

        if (resultRead.isEmpty() || resultRead == null) {
            throw new ValidationException("The result can't be calculate, " +
                    "because the value is null!");
        }
        String[] minSec = resultRead.split(":");
        if (minSec.length != 2) {
            throw new ValidationException("The result string has an invalid format.");
        }
        int minInSec = Integer.parseInt(minSec[0]) * 60;
        int sec = Integer.parseInt(minSec[1]);
        resultInSec = (minInSec + sec);

        return resultInSec;
    }

}


