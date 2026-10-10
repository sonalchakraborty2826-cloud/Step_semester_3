class Scorecard {
    private final boolean[] answers;
    private int count = 0;

    public Scorecard(int totalQuestions) {
        answers = new boolean[totalQuestions];
    }

    public void recordAnswer(boolean result) {
        if (count < answers.length) {
            answers[count] = result;
            count++;
        } else {
            System.out.println("All answers recorded");
        }
    }

    public int getScore() {
        int score = 0;

        for (int i = 0; i < count; i++) {
            if (answers[i]) {
                score++;
            }
        }

        return score;
    }
}

class p2 {
    public static void main(String[] args) {
        Scorecard sc = new Scorecard(4);

        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);

        System.out.println(sc.getScore());
    }
}