import java.util.Scanner;

class PalindromeToolkit {

    // 1. Iterative method
    static boolean isPalindromeIterative(String text) {

        int left = 0;
        int right = text.length() - 1;

        while (left < right) {

            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    // 2. Recursive method
    static boolean isPalindromeRecursive(String text) {

        // Base condition
        if (text.length() <= 1) {
            return true;
        }

        // Compare first and last characters
        if (text.charAt(0) != text.charAt(text.length() - 1)) {
            return false;
        }

        // Check remaining middle part
        return isPalindromeRecursive(text.substring(1, text.length() - 1));
    }

    // 3. Array reversal method
    static boolean isPalindromeArrayReversal(String text) {

        char[] original = text.toCharArray();
        char[] reverse = new char[original.length];

        for (int i = 0; i < original.length; i++) {
            reverse[i] = original[original.length - 1 - i];
        }

        String reversedText = new String(reverse);

        return text.equals(reversedText);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.nextLine();

        boolean result1 = isPalindromeIterative(text);
        boolean result2 = isPalindromeRecursive(text);
        boolean result3 = isPalindromeArrayReversal(text);

        System.out.println("\n===== PALINDROME CHECK =====");

        System.out.println("Iterative Method      : " + result1);
        System.out.println("Recursive Method      : " + result2);
        System.out.println("Array Reversal Method : " + result3);

        if (result1 == result2 && result2 == result3) {
            System.out.println("\nAll three methods agree.");
        }

        if (result1) {
            System.out.println("Result: Palindrome");
        } else {
            System.out.println("Result: Not a Palindrome");
        }

        sc.close();
    }
}
