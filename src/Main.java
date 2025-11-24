import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> list = new ArrayList<>();

        while (true) {
            // menu
            System.out.println("\n1. Add Undergraduate");
            System.out.println("2. Add Graduate");
            System.out.println("3. View All");
            System.out.println("4. View Eligible");
            System.out.println("5. Exit");

            int menu = readInt(sc, "Select: ", 1, 5);

            if (menu == 1) {
                System.out.println("[Add Undergraduate]");
                int id = readInt(sc, "ID: ", 1, 2_000_000_00);
                String first = readName(sc, "First name: ");
                String last  = readName(sc, "Last name: ");

                int n = readInt(sc, "How many marks? ", 0, 9);
                double[] marks = new double[n];
                for (int i = 0; i < n; i++) {
                    marks[i] = readDouble(sc, "Mark " + (i + 1) + ": ", 0, 100);
                }

                System.out.println("Enter address info");
                String st   = readLine(sc, "Street: ");
                String city = readLine(sc, "City: ");
                String postal = readLine(sc, "Postal: ");
                String prov   = readLine(sc, "Province: ");
                String country= readLine(sc, "Country: ");
                Address addr  = new Address(st, city, postal, prov, country);

                String sub  = readLine(sc, "Subject: ");
                int year    = readInt(sc, "Year of entry: ", 1990, 2100);

                list.add(new UndergraduateStudent(id, first, last, marks, addr, sub, year));
                System.out.println("Undergraduate student added!");

            } else if (menu == 2) {
                System.out.println("[Add Graduate]");
                int id = readInt(sc, "ID: ", 1, 2_000_000_00);
                String first = readName(sc, "First name: ");
                String last  = readName(sc, "Last name: ");

                int n = readInt(sc, "How many marks? ", 0, 9);
                double[] marks = new double[n];
                for (int i = 0; i < n; i++) {
                    marks[i] = readDouble(sc, "Mark " + (i + 1) + ": ", 0, 100);
                }

                System.out.println("Enter address info");
                String st   = readLine(sc, "Street: ");
                String city = readLine(sc, "City: ");
                String postal = readLine(sc, "Postal: ");
                String prov   = readLine(sc, "Province: ");
                String country= readLine(sc, "Country: ");
                Address addr  = new Address(st, city, postal, prov, country);

                String sub    = readLine(sc, "Subject: ");
                int year      = readInt(sc, "Year of entry: ", 1990, 2100);
                String thesis = readLine(sc, "Thesis topic: ");

                list.add(new GraduateStudent(id, first, last, marks, addr, sub, year, thesis));
                System.out.println("Graduate student added!");

            } else if (menu == 3) {
                System.out.println("[All Students]");
                if (list.isEmpty()) {
                    System.out.println("(none)");
                } else {
                    for (Student s : list) System.out.println(s.toString());
                }

            } else if (menu == 4) {
                System.out.println("[Eligible to Graduate]");
                boolean any = false;
                for (Student s : list) {
                    if (s.Graduate()) {
                        System.out.println(s);
                        any = true;
                    }
                }
                if (!any) System.out.println("(no eligible students)");

            } else if (menu == 5) {
                System.out.println("Program ended.");
                break;
            }
        }
    }

    //  input helpers
    private static String readName(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim();
            if (s.matches("^[\\p{L}][\\p{L}\\p{M} '\\-]{1,49}$")) {
                return s;
            }
            System.out.println("-> Letters only (A–Z, accented letters ok), spaces, hyphen (-), apostrophe ('). 2–50 chars.");
        }
    }

    private static String readLine(Scanner sc, String prompt) {
        System.out.print(prompt);
        String s = sc.nextLine().trim();
        while (s.isEmpty()) {
            System.out.print("Please enter again: ");
            s = sc.nextLine().trim();
        }
        return s;
    }

    private static int readInt(Scanner sc, String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim();
            try {
                int v = Integer.parseInt(s);
                if (v < min || v > max) throw new NumberFormatException();
                return v;
            } catch (NumberFormatException e) {
                System.out.println("-> Enter an integer in [" + min + " ~ " + max + "]");
            }
        }
    }

    private static double readDouble(Scanner sc, String prompt, double min, double max) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim();
            try {
                double v = Double.parseDouble(s);
                if (v < min || v > max) throw new NumberFormatException();
                return v;
            } catch (NumberFormatException e) {
                System.out.println("-> Enter a number in [" + min + " ~ " + max + "]");
            }
        }
    }
}
