package org.example;

public class HRCalculator {
    public static int calculateMaxHR(int age) {
        if (age > 120 || age < 0) {
            throw new IllegalArgumentException("Age out of bounds");
        }
        return 220 - age;
    }
    public static String getWorkoutZone(int age, int bpm) {
        int maximumHR = calculateMaxHR(age);

        if (bpm <= 0) {
            throw new IllegalArgumentException("BPM cannot be 0 or lower");
        }

        double ratio = (double) bpm * 100 / maximumHR;

        if (ratio < 50) {
            return "Resting";
        } else if (ratio < 60) {
            return "Recovery";
        } else if (ratio < 70) {
            return "Fat Burn";
        } else if (ratio < 80) {
            return "Aerobic";
        } else if (ratio < 90) {
            return "Anaerobic";
        } else {
            return "VO2 Max";
        }

    }
}