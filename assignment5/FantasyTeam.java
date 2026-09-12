import java.util.Scanner;

class FantasyTeam {

    static void applyMultipliers(double[] playerScores,
                                 int captainIndex,
                                 int viceCaptainIndex) {

        playerScores[captainIndex] =
                playerScores[captainIndex] * 2;

        playerScores[viceCaptainIndex] =
                playerScores[viceCaptainIndex] * 1.5;
    }

    public static void main(String[] args) {

        double[] scores = {40, 60, 50, 30, 80};

        int captainIndex = 1;
        int viceCaptainIndex = 3;

        applyMultipliers(scores, captainIndex, viceCaptainIndex);

        for (int i = 0; i < scores.length; i++) {
            System.out.println("Player " + i + ": " + scores[i]);
        }
    }
}