package com.ashu.practice.interview;

/**
 * An avid hiker keeps meticulous records of their hikes. During the last hike that took exactly  steps,
 * for every step it was noted if it was an uphill, , or a downhill,  step. Hikes always start and end at sea level,
 * and each step up or down represents a  unit change in altitude. We define the following terms:
 * <p>
 * A mountain is a sequence of consecutive steps above sea level, starting with a step up from sea level and ending with a step down to sea level.
 * A valley is a sequence of consecutive steps below sea level, starting with a step down from sea level and ending with a step up to sea level.
 * Given the sequence of up and down steps during a hike, find and print the number of valleys walked through.
 * <p>
 * Example
 * <p>
 * <p>
 * <p>
 * The hiker first enters a valley  units deep. Then they climb out and up onto a mountain  units high. Finally, the hiker returns to sea level and ends the hike.
 * <p>
 * Function Description
 * <p>
 * Complete the countingValleys function in the editor below.
 * <p>
 * countingValleys has the following parameter(s):
 * <p>
 * int steps: the number of steps on the hike
 * string path: a string describing the path
 * Returns
 * <p>
 * int: the number of valleys traversed
 * Input Format
 * <p>
 * The first line contains an integer , the number of steps in the hike.
 * The second line contains a single string , of  characters that describe the path.
 * <p>
 * Constraints
 * <p>
 * Sample Input
 * <p>
 * 8
 * UDDDUDUU
 * Sample Output
 * <p>
 * 1
 * Explanation
 * <p>
 * If we represent _ as sea level, a step up as /, and a step down as \, the hike can be drawn as:
 * <p>
 * _/\      _
 * \    /
 * \/\/
 * The hiker enters and leaves one valley.
 */
public class CountingValleys {

    public static void main(String[] args) {
        int n = 8;
        String path = "UDDDUDUU";
        System.out.println(countingValleys(n, path));
    }

    public static int countingValleys(int steps, String path) {
        int valleyCounter = 0;
        int altitude = 0;

        for (int i = 0; i < steps; i++) {
            char ch = path.charAt(i);
            if (ch == 'U') {
                altitude++;
                if (altitude == 0) {
                    valleyCounter++;
                }
            } else {
                altitude--;
            }
        }
        return valleyCounter;

    }

}
