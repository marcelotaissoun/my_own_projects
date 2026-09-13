import java.util.ArrayList; // Permite o uso de Array Lists

public class StudentService { // Essa classe define métodos que definem e controlam a lógica do Sistema de Alunos
    private ArrayList<Student> students = new ArrayList<>(); // Cria uma Array List que guarda os alunos

    public void addStudent(Student student) { // Adiciona um aluno a Array List
        students.add(student);
    }

    public void listStudents() { // Retorna os alunos presentes na Array List
        for(Student student : students) {
            System.out.println(student);
        }
    }

    public Student searchById(int studentId) { // Procura um aluno por seu ID (Primary Key)
        for(Student student : students){
            if(student.getStudentId() == studentId) {
               return student;
            }
        }
      
        return null;
    }

    public void removeStudent(int studentId) { // Remove um aluno da Array List
         Student student = searchById(studentId);

         if(student != null) {
             students.remove(student);
         }      
    }

    public void updateStudent(int studentId, String studentName, String studentEmail) { // Atualiza os dados de um aluno
         Student student = searchById(studentId);
         if(student != null) {
            student.setStudentName(studentName);
            student.setStudentEmail(studentEmail);
         }
   }

   public void updateGrade01(int studentId, double grade01) { // Atualiza a nota da AV1
         Student student = searchById(studentId);
         if(student != null) {
            student.setGrade01(grade01);
         }
   }

   public void updateGrade02(int studentId, double grade02) { // Atualiza a nota da AV2
         Student student = searchById(studentId);
         if(student != null) {
            student.setGrade02(grade02);
         }
   }
}
