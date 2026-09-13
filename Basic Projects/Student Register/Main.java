import java.util.Scanner;
import java.util.ArrayList;

public class Main { // Execução do projeto e interação com o usuário
  public static void main(String args[]) {
    
    StudentService alunoService = new StudentService(); // Como os métodos não são static, é criado um objeto para usar os métodos do Service
    Scanner scanner = new Scanner(System.in);
    int option;

    do { // Cria um menu onde o usuário escolhe sua próxima ação
       System.out.println("1 - Register a student");
       System.out.println("2 - List students");
       System.out.println("3 - Look for a student");
       System.out.println("4 - Alter student");
       System.out.println("5 - Remove a student");
       System.out.println("6 - Register grades");
       System.out.println("7 - Exit console");

       option = scanner.nextInt();

       switch (option) { // Define as operações baseado na opção escolhida
           case 1: { // O usuário registra um aluno
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
           }

           case 2: { // O usuário pede ao sistema pra listar os alunos cadastrados
               alunoService.listStudents();
               break;
           }

            case 3: { // O usuário procura um aluno pelo seu ID
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
            }
            
            case 4: { // O usuário atualiza os dados de um aluno 
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
            }

            case 5: { // O usuário remove um aluno 
               System.out.print("Insert the student's ID: ");
               int studentId = scanner.nextInt();
               scanner.nextLine();

               Student student = alunoService.searchById(studentId);

               if(student != null) {
                  alunoService.removeStudent(studentId);
                  System.out.println("Student succesfully removed!");

                } else {
                    System.out.println("Student not found!");
                  }
                break;
             }
           
             case 6: { // O usuário atualiza as notas de um aluno
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
             }

             case 7: { // O usuário sai do menu e encerra o programa
               System.out.println("Encerrando...");
               break;
             }

             default: // Caso o usuário selecione uma opção fora do intervalo de 1 - 7
                System.out.println("Opção inválida.");
        }
    } while (option != 7);
  }
}
