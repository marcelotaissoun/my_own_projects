import java.util.Scanner;
import java.util.ArrayList;

public class Main {
  public static void main(String args[]) {
    StudentService alunoService = new StudentService();
    Scanner scanner = new Scanner(System.in);
    int option;

    do {
       System.out.println("1 - Register a student");
       System.out.println("2 - List students");
       System.out.println("3 - Look for a student");
       System.out.println("4 - Alter student");
       System.out.println("5 - Remove a student");
       System.out.println("6 - Register grades");
       System.out.println("7 - Check status");
       System.out.println("0 - Exit console");

       option = scanner.nextInt();

       switch (opcao) {
           case 1:
               System.out.print("Insert the student´s ID: ");
               int studentId = scanner.nextInt();
               scanner.nextLine();

               System.out.print("Insert the student´s name: ");
               String studentName = scanner.nextLine();

               System.out.print("Insert the student´s email: ");
               String studentEmail = scanner.nextLine();

               Student student = new Student(studentId, studentName, studentEmail);

               alunoService.addStudent(student);
               System.out.println("Student was succesfully registered!");
               break;

           case 2:
               ArrayList<Student> students = alunoService.listStudents();
               System.out.println(students);
               break;

            case 3:
               System.out.print("Insert the student´s ID: ");
               int studentId = scanner.nextInt();

               Student student = alunoService.searchById(studentId);

               if(student != null) {
                  System.out.println("Student found!");
                  System.out.println("Name: " + student.getStudentName());
                  System.out.println("Email: " + student.getStudentEmail());
               } else {
                   System.out.println("Student not found!");
                 }
               break;

            case 4:
                System.out.print("Insert the student's ID: ");
                int studentId = scanner.nextInt();
                scanner.nextLine();

                Student student = alunoService.searchById(studentId);

                if(student != null) {
                   System.out.print("Insert the new name: ");
                   String studentName = scanner.nextLine();

                   System.out.print("Insert the new email: ");
                   String studentEmail = scanner.nextLine();

                   alunoService.updateStudent(studentId, studentName, studentEmail);

                   System.out.println("Student updated successfully!");

                   } else {
                       System.out.println("Student not found!");
                     }
               break;

              case 5:
                  System.out.print("Insert the student's ID: ");
                  int studentId = scanner.nextInt();
                  scanner.nextLine();

                  Student student = alunoService.searchById(studentId);

                  if(student != null) {
                     alunoService.removeStudent(student);
                     System.out.println("Student succesfully removed!");

                  } else {
                      System.out.println("Student not found!");
                    }
               break;

               case 6:
                  System.out.print("Insert the student's ID: ");
                  int studentId = scanner.nextInt();
                  scanner.nextLine();

                  Student student = alunoService.searchById(studentId);

                  if(student != null) {
                     System.out.print("Insert the grade of the first test from this student: ");
                     double grade01 = scanner.nextDouble();
                     scanner.nextLine();
                     alunoService.updateGrade01(studentId, grade01);

                     System.out.print("Insert the grade of second test from this student: ");
                     double grade02 = scanner.nextDouble();
                     scanner.nextLine();
                     alunoService.updateGrade02(studentId, grade02);

                  } else {
                      System.out.println("Student not found!");
                    }                
               break;

               case 7:
                  // situação
               break;

               case 0:
                  System.out.println("Encerrando...");
               break;

               default:
                  System.out.println("Opção inválida.");
           }
       } while (opcao != 0);
  }
}
