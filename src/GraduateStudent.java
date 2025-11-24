public class GraduateStudent extends Student {
    private String subject;
    private int yearOfEntry;
    private String thesisTopic;

    public GraduateStudent(int id, String first, String last, double[] marks,
                           Address addr, String subject, int yearOfEntry, String thesisTopic) {
        super(id, first, last, marks, addr);
        this.subject = subject;
        this.yearOfEntry = yearOfEntry;
        this.thesisTopic = thesisTopic;
    }

    @Override
    public boolean Graduate() { return Average() > 70.0; }

    @Override
    public String toString() {
        return "[Graduate] " + super.toString() +
               " | Subject:" + subject +
               " | Year:" + yearOfEntry +
               " | Thesis:" + thesisTopic +
               " | Eligible:" + (Graduate() ? "YES" : "NO");
    }
}
