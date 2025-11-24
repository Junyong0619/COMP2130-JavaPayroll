public abstract class Student {
    private int studentID;
    private String stdFirstName;
    private String stdLastName;
    private double[] stdMarks;
    private Address stdAddress;

    public Student(int studentID, String firstName, String lastName, double[] marks, Address address) {
        this.studentID = studentID;
        this.stdFirstName = firstName;
        this.stdLastName = lastName;
        this.stdMarks = (marks == null) ? new double[0] : marks.clone();
        this.stdAddress = address;
    }

    public int getStudentID() { return studentID; }
    public void setStudentID(int studentID) { this.studentID = studentID; }
    public String getStdFirstName() { return stdFirstName; }
    public void setStdFirstName(String stdFirstName) { this.stdFirstName = stdFirstName; }
    public String getStdLastName() { return stdLastName; }
    public void setStdLastName(String stdLastName) { this.stdLastName = stdLastName; }
    public double[] getStdMarks() { return stdMarks.clone(); }
    public void setStdMarks(double[] stdMarks) {
        this.stdMarks = (stdMarks == null) ? new double[0] : stdMarks.clone();
    }
    public Address getStdAddress() { return stdAddress; }
    public void setStdAddress(Address stdAddress) { this.stdAddress = stdAddress; }

    // required methods
    public double Average() {
        if (stdMarks.length == 0) return 0.0;
        double sum = 0;
        for (double m : stdMarks) sum += m;
        return sum / stdMarks.length;
    }

    public abstract boolean Graduate();

    @Override
    public String toString() {
        String addr = (stdAddress == null) ? "N/A" : stdAddress.toString();
        return "ID:" + studentID +
               " | Name:" + stdFirstName + " " + stdLastName +
               " | Avg:" + String.format("%.2f", Average()) +
               " | Address:[" + addr + "]" +
               " | Marks:" + stdMarks.length + " item(s)";
    }
}
