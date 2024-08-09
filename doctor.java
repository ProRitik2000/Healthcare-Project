
// Doctor can login, view profile, viewAppointments, Attend Patients and logout.



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
public class doctor {
         //login doctors
        public void Logind() throws Exception{
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter the login ID:");
            String id=sc.nextLine();
            System.out.println("Enter the login password:");
            String password=sc.nextLine();
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded successfully");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hms","root","bapu1432");
            System.out.println("successfully");
            PreparedStatement ps=con.prepareStatement("select * from dradd where ID=? and password=?");
            
            
            ps.setString(1, id);
            ps.setString(2, password);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                String id1=rs.getString("id");
                String password1=rs.getString("password");
                if(id.equals(id1)&&password.equals(password1)){
            System.out.println("Login successfully...!");
            }
        else {
            System.out.println("Wrong id or password!");
        }
    }
    entryd();
}
        // view doctors profile//
        public void viewProfile() throws Exception{
            System.out.println("-----------------------VIEW PROFILE-----------------------");
                Scanner sc=new Scanner(System.in);
                System.out.println("enter the doctors id:");
                String id=sc.nextLine();
                System.out.println("Enter doctors password to view his/her details:");
                String password=sc.nextLine();
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hms","root","bapu1432");
                PreparedStatement ps=con.prepareStatement("SELECT * from dradd where id=? and password=?");
                
                ps.setString(1, id);
                ps.setString(2, password);
                ResultSet rs=ps.executeQuery();
                while(rs.next()){
                    System.out.println("--------------------------------------------------------------------------------");
                    String id1=rs.getString("id");
                    System.out.println("id:"+id1);
                    String password1=rs.getString("password");
                    System.out.println("password:"+password1);
                    if(id.equals(id1)&&password.equals(password1)){
                    String name = rs.getString("name");
                    System.out.println("Name:"+"  "+name);
                    String specification= rs.getString("specification");
                    System.out.println("specifictaion:"+"  "+specification);
                    String contact= rs.getString("contact");
                    System.out.println("contact:"+"  "+contact);
                    }
                    else{
                        System.out.println("This doctor doesn't contain in the database...!");
                    }
        }
            System.out.println("--------------------------------------------------------------------------------");
                    entryd();
            }
            //view appointments //
            public void viewAppointment() throws Exception{
                try{
                System.out.println("------------------------------VIEW APPOINTMENT-----------------------------------");
                Class.forName("com.mysql.cj.jdbc.Driver");
                System.out.println("successfully");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hms", "root", "bapu1432");
                String q="select * from appointment";
                PreparedStatement ps=con.prepareStatement(q);
                ResultSet rs=ps.executeQuery();
                
                while(rs.next()){
                    System.out.println("--------------------------------------------------------------------------------");
                    String appointmentBy=rs.getString("appointmentBy");
                    System.out.println("patient name:"+appointmentBy);

                    String disease=rs.getString("disease");
                    System.out.println("disease:"+disease);

                    String appointmentTo = rs.getString("appointmentTo");
                    System.out.println("doctor name:"+appointmentTo);

                    String specification = rs.getString("specification");
                    System.out.println("specification:"+specification);

                    String aDate= rs.getString("aDate");
                    System.out.println("appointment date:"+aDate);

                    String aTime = rs.getString("aTime");
                    System.out.println("appointment time:"+aTime);
        }
                    System.out.println("--------------------------------------------------------------------------------");
                    entryd();
    }catch(Exception e){
        e.printStackTrace();
    }
    }
        // Attend patients //
        public void Attend_patient() throws Exception{
            System.out.println("doctor will attend the patient physically & treat after looking their current condition");
            entryd();
        }

        //Make report of a patient//
        public void makeReport() throws Exception{
            System.out.println("-----------------------------VIEW REPORT------------------------------------");
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter patient email to view reports:");
            String email = sc.nextLine();
            
            System.out.println("Enter the report id:");
            String reportID=sc.nextLine();
            
            System.out.println("Enter the report date:");
            String date=sc.nextLine();

            System.out.println("Enter the details:");
            String details=sc.nextLine();

            System.out.println("Enter the doctor's name:");
            String doctorName=sc.nextLine();
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hms", "root", "bapu1432");
            PreparedStatement ps = con.prepareStatement("insert into report values(?,?,?,?,?)");
            ps.setString(1, email);
            ps.setString(2, reportID);
            ps.setString(3, date);
            ps.setString(4, details);
            ps.setString(5, doctorName);
            int i = ps.executeUpdate();
            
            if(i>0){
                System.out.println("Report submitted successfully to the patient");
                entryd();
            }
        else{
            System.out.println("Invalid patient for this email ID...!");
        }
    }

        //logout //
        public void logout() throws Exception{
            System.out.println("logged out successfully...!");
            System.out.println("--------------------------Thanks for using...!----------------------------");
            Scanner sc=new Scanner(System.in);
            System.out.println("1:Patient");
            System.out.println("2.Doctor");
            System.out.println("3.Admin");
            int choice=sc.nextInt();
            if(choice==3){
            User u = new User();
            u.entryA();
            }

            else if(choice==2){
            doctor d=new doctor();
            d.entryd();
            }

            if(choice==1){
            patient p=new patient();
            p.entryp();
            }
        }
        // choices of an user //
        public void entryd() throws Exception{
            System.out.println("1:Login");
            System.out.println("2: View Profile");
            System.out.println("3:View Appointments");
            System.out.println("4:Attend patients");
            System.out.println("5:Make Report of patient");
            System.out.println("6:logout");
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter the choice:");
            int choice=sc.nextInt();
            switch (choice) {
                case 1:Logind();
                break;
                case 2:viewProfile();
                break;
                case 3:viewAppointment();
                break;
                case 4:Attend_patient();
                break;
                case 5:makeReport();
                break;
                case 6:logout();
                break;
                default:
                break;
            }
            }
    }

