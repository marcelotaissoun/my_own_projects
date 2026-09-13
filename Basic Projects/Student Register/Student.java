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

    public int getStudentId() {
        return studentId;
    }

     public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

     public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

     public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public double getGrade01() {
        return grade01;
    }

     public void setGrade01(double grade01) {
        this.grade01 = grade01;
    }

    public double getGrade02() {
        return grade02;
    }

     public void setGrade02(double grade02) {
        this.grade02 = grade02;
    }

    @Override
    public String toString() {
        return "ID: " + studentId +
                ", Name: " + studentName +
                ", Email: " + studentEmail +
                ", Grade 01: " + grade01 +
                ", Grade 02: " + grade02;
    }
}
