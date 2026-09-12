import java.util.Scanner;

class PalindromeCheck {

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

        if (text.length() <= 1) {
            return true;
        }

        if (text.charAt(0) != text.charAt(text.length() - 1)) {
            return false;
        }

        return isPalindromeRecursive(
            text.substring(1, text.length() - 1)
        );
    }

    // 3. Array reversal method
    static boolean isPalindromeArrayReversal(String text) {

        char[] arr = text.toCharArray();
        char[] reverse = new char[arr.length];

        for (int i = 0; i < arr.length; i++) {
            reverse[i] = arr[arr.length - 1 - i];
        }

        String reversedText = new String(reverse);

        return text.equals(reversedText);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.nextLine();

        boolean iterative = isPalindromeIterative(text);
        boolean recursive = isPalindromeRecursive(text);
        boolean array = isPalindromeArrayReversal(text);

        System.out.println("\nIterative Method      : " + iterative);
        System.out.println("Recursive Method      : " + recursive);
        System.out.println("Array Reversal Method : " + array);

        if (iterative == recursive && recursive == array) {
            System.out.println("\nAll three methods agree.");
        }

        if (iterative) {
            System.out.println("Result: Palindrome");
        } else {
            System.out.println("Result: Not a Palindrome");
        }

        sc.close();
    }
}