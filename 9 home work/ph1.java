import java.util.*;

abstract class Ticket {
    static final double FEE = 20.0;
    abstract double calculate(int count);
}

class Regular extends Ticket {
    double calculate(int count) {
        return (150 + FEE) * count;
    }
}

class Premium extends Ticket {
    double calculate(int count) {
        return (250 + FEE) * count;
    }
}

class Recliner extends Ticket {
    double calculate(int count) {
        return (400 + FEE) * count;
    }
}

public class ph1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String seat = sc.next();
            int count = sc.nextInt();
            Ticket t;

            if (seat.equals("REGULAR"))
                t = new Regular();
            else if (seat.equals("PREMIUM"))
                t = new Premium();
            else
                t = new Recliner();

            double amount = t.calculate(count);
            System.out.printf("%s: %.2f%n", seat, amount);
            total += amount;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}