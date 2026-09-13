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
               // alterar
               break;

           case 5:
               // remover
               break;

           case 6:
               // notas
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
