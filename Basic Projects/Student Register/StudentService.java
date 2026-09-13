import java.util.ArrayList;

public class StudentService {
    private ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public void listStudents() {
        for(Student student : students) {
            System.out.println(student);
        }
    }

    public Student searchById(int studentId) {
        for(Student student : students){
            if(student.getStudentId() == studentId) {
               return student;
            }
        }
      
        return null;
    }

    public void removeStudent(int studentId) {
         Student student = searchById(studentId);

         if(student != null) {
             students.remove(student);
         }      
    }

    public void updateStudent(int studentId, String studentName, String studentEmail) {
         Student student = searchById(studentId);
         if(student != null) {
            student.setStudentName(studentName);
            student.setStudentEmail(studentEmail);
         }
   }

   public void updateGrade01(int studentId, double grade01) {
         Student student = searchById(studentId);
         if(student != null) {
            student.setGrade01(grade01);
         }
   }

   public void updateGrade02(int studentId, double grade02) {
         Student student = searchById(studentId);
         if(student != null) {
            student.setGrade02(grade02);
         }
   }
}
