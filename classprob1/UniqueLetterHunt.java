import java.util.Scanner;

class UniqueLetterHunt {

    // Method to find first non-repeating character
    static char findFirstNonRepeatingChar(String text) {

        // Check every character
        for (int i = 0; i < text.length(); i++) {

            int count = 0;

            // Count how many times this character appears
            for (int j = 0; j < text.length(); j++) {

                if (text.charAt(i) == text.charAt(j)) {
                    count++;
                }
            }

            // If character appears only once
            if (count == 1) {
                return text.charAt(i);
            }
        }

        return '\0';   // No non-repeating character
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a word or sentence: ");
        String text = sc.nextLine();

        char result = findFirstNonRepeatingChar(text);

        if (result == '\0') {
            System.out.println("No non-repeating character found.");
        } else {
            System.out.println("First non-repeating character: " + result);
        }

        sc.close();
    }
}