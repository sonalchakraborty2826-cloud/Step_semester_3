import java.util.Scanner;

class WordReversal {

    static void reverseWords(String sentence) {

        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {

            StringBuilder reverse = new StringBuilder();

            for (int j = words[i].length() - 1; j >= 0; j--) {
                reverse.append(words[i].charAt(j));
            }

            result.append(reverse);

            if (i < words.length - 1) {
                result.append(" ");
            }
        }

        System.out.println(result);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter sentence: ");
        String sentence = sc.nextLine();

        reverseWords(sentence);
    }
}