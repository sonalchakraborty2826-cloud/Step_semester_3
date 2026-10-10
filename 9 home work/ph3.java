import java.util.*;

abstract class Student {
    String name;

    Student(String name) {
        this.name = name;
    }

    abstract double calculateFee();
}

interface BusUser {
    double TRANSPORT_FEE = 12000;
}

class DayScholar extends Student implements BusUser {
    DayScholar(String name) {
        super(name);
    }

    double calculateFee() {
        return 40000 + TRANSPORT_FEE;
    }
}

class Hosteller extends Student {
    Hosteller(String name) {
        super(name);
    }

    double calculateFee() {
        return 40000 + 60000;
    }
}

class Scholar extends Student implements BusUser {
    Scholar(String name) {
        super(name);
    }

    double calculateFee() {
        return 20000 + TRANSPORT_FEE;
    }
}

public class ph3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();

            Student s;

            if (type.equals("DAY_SCHOLAR"))
                s = new DayScholar(name);
            else if (type.equals("HOSTELLER"))
                s = new Hosteller(name);
            else
                s = new Scholar(name);

            double fee = s.calculateFee();

            System.out.printf("%s: %.2f%n", name, fee);
            total += fee;
        }

        System.out.printf("Total Collected: %.2f%n", total);
    }
}
