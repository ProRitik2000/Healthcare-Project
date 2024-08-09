import java.util.Scanner;
public class User extends Admin{
public static void main(String[] args) throws Exception{
        Scanner sc=new Scanner(System.in);

        System.out.println("-------------------------Welcome to E-Healthcare Management System-------------------------");
        Admin a=new Admin();
        doctor d=new doctor();
        patient p=new patient();
        System.out.println("1.Patient ");
        
        System.out.println("2.Doctor");
        System.out.println("3.Admin");
        System.out.println("enter your choice:");
        int choice=sc.nextInt();
        if(choice==1){
                System.out.println("                       PATIENT                    ");
                p.enterPatient();
        }
        if(choice==2){
                System.out.println("                       DOCTOR                    ");
                d.Logind();
        }
        if(choice==3){
                System.out.println("                       ADMIN                       ");
                a.LoginA();
        }
}
}