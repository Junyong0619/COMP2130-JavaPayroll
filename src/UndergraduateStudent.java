public class UndergraduateStudent extends Student {
    private String subject;
    private int yearOfEntry;

    public UndergraduateStudent(int id, String first, String last, double[] marks,
                                Address addr, String subject, int yearOfEntry) {
        super(id, first, last, marks, addr);
        this.subject = subject;
        this.yearOfEntry = yearOfEntry;
    }

    @Override
    public boolean Graduate() { return Average() > 50.0; }

    @Override
    public String toString() {
        return "[Undergrad] " + super.toString() +
               " | Subject:" + subject +
               " | Year:" + yearOfEntry +
               " | Eligible:" + (Graduate() ? "YES" : "NO");
    }
}
