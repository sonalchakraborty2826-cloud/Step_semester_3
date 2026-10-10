import java.util.*;

abstract class Room {
    abstract double calculateBill(int units);
}

class SingleRoom extends Room {
    double calculateBill(int units) {
        return units * 8;
    }
}

class SharedRoom extends Room {
    int occupants;

    SharedRoom(int occupants) {
        this.occupants = occupants;
    }

    double calculateBill(int units) {
        return (units * 6.0) / occupants;
    }
}

class ACRoom extends Room {
    double calculateBill(int units) {
        return units * 10 + 200;
    }
}

public class ph3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int units = sc.nextInt();

            Room r;

            switch (type) {
                case "SINGLE":
                    r = new SingleRoom();
                    break;
                case "SHARED":
                    int occupants = sc.nextInt();
                    r = new SharedRoom(occupants);
                    break;
                default:
                    r = new ACRoom();
            }

            double bill = r.calculateBill(units);
            total += bill;

            System.out.printf("%s: %.2f%n", type, bill);
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}