class DuplicatePlayer {

    static String findDuplicatePick(String[] playerNames) {

        for (int i = 0; i < playerNames.length; i++) {

            for (int j = i + 1; j < playerNames.length; j++) {

                if (playerNames[i].equals(playerNames[j])) {
                    return "Duplicate player found: " + playerNames[i];
                }
            }
        }

        return "No duplicate player found";
    }

    public static void main(String[] args) {

        String[] players = {
            "Virat", "Rohit", "Dhoni", "Virat", "Bumrah"
        };

        System.out.println(findDuplicatePick(players));
    }
}