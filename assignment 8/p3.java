import java.util.*;

abstract class Delivery {
    abstract double calculateFee(double weight, double distance);
}

class Standard extends Delivery {
    double calculateFee(double weight, double distance) {
        return 5 + 0.50 * weight + 0.10 * distance;
    }
}

class Express extends Delivery {
    double calculateFee(double weight, double distance) {
        return 15 + weight + 0.20 * distance;
    }
}

class International extends Delivery {
    double customs;

    International(double customs) {
        this.customs = customs;
    }

    double calculateFee(double weight, double distance) {
        return 25 + 2 * weight + 0.50 * distance + customs;
    }
}

public class p3{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double distance = sc.nextDouble();
            Delivery d;

            if (type.equals("STANDARD"))
                d = new Standard();
            else if (type.equals("EXPRESS"))
                d = new Express();
            else
                d = new International(sc.nextDouble());

            double fee = d.calculateFee(weight, distance);
            System.out.printf(Locale.US, "%s: %.2f%n", type, fee);
            total += fee;
        }

        System.out.printf(Locale.US, "Total: %.2f%n", total);
        sc.close();
    }
}