class TopPerformer {

    static String findMinMaxSpread(int[] scores) {

        int min = scores[0];
        int max = scores[0];

        for (int i = 1; i < scores.length; i++) {

            if (scores[i] < min) {
                min = scores[i];
            }

            if (scores[i] > max) {
                max = scores[i];
            }
        }

        int spread = max - min;

        return "Minimum: " + min +
               " | Maximum: " + max +
               " | Spread: " + spread;
    }

    public static void main(String[] args) {

        int[] scores = {75, 42, 91, 63, 88};

        System.out.println(findMinMaxSpread(scores));
    }
}