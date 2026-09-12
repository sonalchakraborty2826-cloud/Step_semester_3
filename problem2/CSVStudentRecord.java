import java.util.Scanner;

class CSVStudentRecord {

    static void parseRecord(String line) {
        String[] fields = line.split(",");

        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        System.out.println("Name: " + fields[0]
                + " | Roll No: " + fields[1]
                + " | Dept: " + fields[2]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter student record: ");
        String line = sc.nextLine();

        parseRecord(line);
    }
}
