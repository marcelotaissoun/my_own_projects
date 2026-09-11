public class Student {

    private int studentId;
    private String studentName;
    private String studentEmail;
    private double grade01;
    private double grade02;

    public Student(int studentId, String studentName, String studentEmail) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentEmail = studentEmail;
    }

    public double avgGradeCalc() {
        return(grade01 + grade02) / 2;
    }

    public String approvedOrNot() {
        if(avgGradeCalc() >= 7) {
            return "Approved";
        } else {
            return "Failed";
        }
    }

    public int get studentId() {
        return studentId;
    }

     public void set studentId(int studentId) {
        this.studentId = studentId;
    }

    public String get studentName() {
        return studentName;
    }

     public void set studentName(String studentName) {
        this.studentName = studentName;
    }

    public String get studentEmail() {
        return studentEmail;
    }

     public void set studentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public double get grade01() {
        return grade01;
    }

     public void set grade01(double grade01) {
        this.grade01 = grade01;
    }

    public double get grade02() {
        return grade02;
    }

     public void set grade02(double grade02) {
        this.grade02 = grade02;
    }
}
