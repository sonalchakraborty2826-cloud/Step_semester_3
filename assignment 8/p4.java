import java.util.*;
import java.util.regex.*;

abstract class Question {
    double points;

    Question(double points) {
        this.points = points;
    }

    abstract double grade(String correct, String answer);
}

class MCQ extends Question {
    MCQ(double p) {
        super(p);
    }

    double grade(String c, String a) {
        return c.equals(a) ? points : 0;
    }
}

class TF extends Question {
    TF(double p) {
        super(p);
    }

    double grade(String c, String a) {
        return c.equals(a) ? points : 0;
    }
}

class Essay extends Question {
    Essay(double p) {
        super(p);
    }

    double grade(String c, String a) {
        String[] keywords = c.split(",");
        int count = 0;

        for (String k : keywords) {
            if (a.toLowerCase().contains(k.trim().toLowerCase()))
                count++;
        }

        if (count >= 2)
            return points * 0.75;
        else if (count == 1)
            return points * 0.50;
        else
            return 0;
    }
}

public class p4{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        double total = 0;
        Pattern pattern = Pattern.compile("\"([^\"]*)\"");

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            Matcher m = pattern.matcher(line);
            List<String> fields = new ArrayList<>();

            while (m.find())
                fields.add(m.group(1));

            String type = line.substring(0, line.indexOf('"')).trim();
            double points = Double.parseDouble(
                line.substring(line.lastIndexOf('"') + 1).trim()
            );

            Question q;
            if (type.equals("MCQ"))
                q = new MCQ(points);
            else if (type.equals("TF"))
                q = new TF(points);
            else
                q = new Essay(points);

            double score = q.grade(fields.get(1), fields.get(2));
            System.out.printf(Locale.US, "%s: %.2f%n", type, score);
            total += score;
        }

        System.out.printf(Locale.US, "Total Score: %.2f%n", total);
        sc.close();
    }
}