public class Student {

    private int studentId; // ID do Estudante
    private String studentName; // Nome do Estudante
    private String studentEmail; // E-mail do Estudante
    private double grade01; // Nota da AV1 do Estudante
    private double grade02; // Nota da AV2 do Estudante

    public Student(int studentId, String studentName, String studentEmail) { // Método construtor
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentEmail = studentEmail;
    }

    public double avgGradeCalc() { // Calcula a média do aluno
        return(grade01 + grade02) / 2;
    }

    public String approvedOrNot() { // Retorna se ele foi aprovado ou não, considerando média mínima = 7
        if(avgGradeCalc() >= 7) {
            return "Approved";
        } else {
            return "Failed";
        }
    }
    // getters e setters
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
    public String toString() { // Para formatação no console
        return "ID: " + studentId +
                ", Name: " + studentName +
                ", Email: " + studentEmail +
                ", Grade 01: " + grade01 +
                ", Grade 02: " + grade02;
    }
}
