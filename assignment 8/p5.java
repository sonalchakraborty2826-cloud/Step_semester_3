import java.util.*;

abstract class Transport {
    abstract double calculateFare(double distance);
}

class Bus extends Transport {
    double calculateFare(double distance) {
        return Math.min(2 + 0.10 * distance, 10);
    }
}

class Train extends Transport {
    double calculateFare(double distance) {
        return 3 + 0.15 * distance;
    }
}

class Metro extends Transport {
    double factor;

    Metro(double factor) {
        this.factor = factor;
    }

    double calculateFare(double distance) {
        return (1.50 + 0.20 * distance) * factor;
    }
}

public class p5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double distance = sc.nextDouble();
            Transport t;

            if (type.equals("BUS"))
                t = new Bus();
            else if (type.equals("TRAIN"))
                t = new Train();
            else
                t = new Metro(sc.nextDouble());

            double fare = t.calculateFare(distance);
            System.out.printf(Locale.US, "%s: %.2f%n", type, fare);
            total += fare;
        }

        System.out.printf(Locale.US, "Total: %.2f%n", total);
        sc.close();
    }
}
