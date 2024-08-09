// using this Application patients can quickly Sign up, Login, view his/her profile, view doctors,
//  book Appointment, view Report, choose doctor,
//  view Appointments, give feedback, pay online and logout

import java.sql.Connection;
import java.sql.DriverManager;
import java .sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
public class patient{
    //String name=null;

    public void enterPatient() throws Exception{
        Scanner sc=new Scanner(System.in);
        System.out.println("enter 1:Signup");
        System.out.println("enter 2:Login");
        System.out.println("enter 3:For other operations:");
        System.err.println("Enter your choice:");
        int num=sc.nextInt();
        if(num==1){
        Signup();
        entryp();
        }
        else if(num==2){
            Login();
        }
        else if(num==3){
        entryp();
        }
    }
    //METHOD to SIGNUP a new PATIENT//
    public void  Signup(){
        try{
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the name");
        String name=sc.nextLine();
        System.out.println("enter the email");
        String email=sc.nextLine();
        System.out.println("enter the password");
        String password=sc.nextLine();
        System.out.println("enter the contact number");
        String contactno=sc.nextLine();
        System.out.println("enter the gender");
        String gender=sc.nextLine();
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver loaded successfully");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hms","root","ritik2000");
        System.out.println("Successfull");

        PreparedStatement ps=con.prepareStatement("insert into signup Values(?,?,?,?,?)");
        ps.setString(1, name);
        ps.setString(2, email);
        ps.setString(3, password);
        ps.setString(4, contactno);
        ps.setString(5, gender);
        int i=ps.executeUpdate();
        if(i>0){
            System.out.println("success");
        }
        else{
            System.out.println("failed");
        }
    
    }catch(Exception e){
        e.printStackTrace();
    }
    }

    //METHOD to LOGIN//
    public void Login(){
        try{
        Scanner sc=new Scanner(System.in);
        System.out.println("enter an username:");
        String name=sc.nextLine();
        System.out.println("enter the password:");
        String password=sc.nextLine();
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver loaded successfully");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hms","root","ritik2000");
        System.out.println("successfully");
        PreparedStatement ps=con.prepareStatement("SELECT * from signup");
        ResultSet rs=ps.executeQuery();
        
        while(rs.next()){
            String name1=rs.getString("name");
            String password1=rs.getString("password");
            if(name.equals(name1)&&password.equals(password1)){
                entryp();
            }else{
                System.out.println("patient doesn't exits");
            }
            }
            
    }catch(Exception e){
        System.out.println(e.getMessage());
    }
        }
        //METHOD to view PATIENT_DETAILS//
        public void viewProfile() throws Exception{
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter patient email to view his/her details:");
            String email=sc.nextLine();
            System.out.println("enter the password:");
            String password=sc.nextLine();
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hms","root","ritik2000");
            PreparedStatement ps=con.prepareStatement("SELECT * from signup where email=? and password=?");
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()){
                String email1= rs.getString("email");
                System.out.println("email:"     +email1);
                String password1 = rs.getString("password");
                System.out.println("password:"     +password1);
                if(email.equals(email1)&&(password.equals(password1))){
                String name = rs.getString("name");
                System.out.println("name:"      +name);
                String contactno = rs.getString("contactno");
                System.out.println("contactno:"     +contactno);
                String gender = rs.getString("gender");
                System.out.println("gender:"     +gender);
                    System.out.println();
                    
                        }else{
                            System.out.println("email & password doestnot match for given id");
                        }
                        }
                        entryp();
                    
                    }

                    // METHOD to view doctors//
                        public void viewDoctors() throws Exception{
                            System.out.println("---------------------------VIEW DOCTORS--------------------------------");
                        try{
                        Scanner sc=new Scanner(System.in);
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hms","root","ritik2000");
                        PreparedStatement ps=con.prepareStatement("select * from dradd");
                        ResultSet rs=ps.executeQuery();
    
                        while(rs.next()){
                            
                            String id=rs.getString("id");
                            System.out.println("id:"+id);
                            String name= rs.getString("name");
                            System.out.println("name:"+name);
                            String email=rs.getString("email");
                            System.out.println("email:"+email);
                            String specification= rs.getString("specification");
                            System.out.println("specification:"+specification);
                            String contact= rs.getString("contact");
                            System.out.println("contact:"+contact);
                            
                        }
                            System.out.println("--------------------------------------------------------------------------");
                            entryp();
                    }catch(Exception e){
                    System.out.println(e.getMessage());
                    }
                    System.out.println("\n");
                    }


                     // choose doctors //
            public void chooseDoctors() throws Exception{
                //viewDoctors();
                //System.out.println("Available doctors>>>");
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hms","root","ritik2000");
            PreparedStatement ps=con.prepareStatement("Select * from dradd");
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                String id1=rs.getString("id");
                System.out.println("id:"+id1);
                String password1=rs.getString("password");
                System.out.println("password:"+password1);
                
            }
        //     con.close();
        }

        //entry for booking//
            public void entryforbooking() throws Exception{
                
                Scanner sc=new Scanner(System.in);
                System.out.println("Enter the patient name:");
                String appointmentBy=sc.nextLine();
                
                
                System.out.println("Enter the patient disease:");
                String disease=sc.nextLine();
        
                System.out.println("Enter the doctors name:");
                String appointmentTo=sc.nextLine();
        
                System.out.println("Enter the doctor's specification:");
                String specification=sc.nextLine();
            
                System.out.println("Enter the appointment date (YYYY-MM-DD)");
                String aDate=sc.nextLine();
        
                System.out.println("Enter the appointment time(HH:MM)");
                String aTime=sc.nextLine();

                
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hms","root","ritik2000");
                PreparedStatement ps=con.prepareStatement("insert into appointment values(?,?,?,?,?,?)");
                ps.setString(1, appointmentBy);
                ps.setString(2, disease);
                ps.setString(3, appointmentTo);
                ps.setString(4, specification);
                ps.setString(5, aDate);
                ps.setString(6, aTime);
                int i=ps.executeUpdate();
                if(i>0){
                    System.out.println("successful");
                }else{
                    System.out.println("failed");
                }
                entryp();
            }

        //book appointments//
        public void bookAppointment() throws Exception{
        chooseDoctors();
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the ID:");
        String id=sc.nextLine();
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hms","root","ritik2000");
        PreparedStatement ps=con.prepareStatement("select * from dradd");
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            //b=true;
        String id1=rs.getString("id");
        if(id1.equals(id)){
            entryforbooking();
        }

    else
    {
        System.out.println("doctor for this ID is not available now...!");
    }
    entryp();
}}
        //}

     //view appointments//
    public void viewAppointment() throws Exception{
        System.out.println("------------------------------VIEW APPOINTMENT-----------------------------------");
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hms", "root", "ritik2000");
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
entryp();
    
}

// feedback by patient //
        public void giveFeedback() throws Exception{
            System.out.println("----------------------------FEEDBACK BY PATIENT------------------------------");
                try {
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Enter the patient name:");
                    String patient_Name = sc.nextLine();
                    System.out.println("Enter the doctor name:");
                    String doctor_Name = sc.nextLine();
                    System.out.println("Enter the feedback details:");
                    String feedback_Details = sc.nextLine();

                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hms", "root", "ritik2000");
                    PreparedStatement ps = con.prepareStatement("INSERT INTO feedback VALUES (?, ?, ?)");
                    ps.setString(1, patient_Name);
                    ps.setString(2, doctor_Name);
                    ps.setString(3, feedback_Details);
                    int i = ps.executeUpdate();
                    if (i > 0) {
                        System.out.println("Feedback submitted successfully");
                    } else {
                        System.out.println("Failed to submit feedback");
                    }
                
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("---------------------------------------------------------------------------------------");
                entryp();
            }
        
            //
        public void viewReport() throws Exception{
            System.out.println("-----------------------------VIEW REPORT------------------------------------");
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Enter patient email to view reports:");
                    String email = sc.nextLine();

                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hms", "root", "ritik2000");
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM report WHERE patient_email='"+email+"'");
                    
                    ResultSet rs = ps.executeQuery();
                    
                    while (rs.next()) {
                        String email1=rs.getString("patient_email");
                        if(email.equals(email1)){
                        String reportID = rs.getString("Report_id");
                        System.out.println("Report ID:"+reportID);
                        String date = rs.getString("Report_date");
                        System.out.println("Report Date:"+date);
                        String details = rs.getString("Report_details");
                        System.out.println("Details about report:"+details);
                        String doctorName = rs.getString("doctor_Name");
                        System.out.println("Doctor's name:"+doctorName);
                    }
        else {
            System.out.println("Invalid patient for this email ID...!");
        }
    }
        System.out.println("------------------------------------------------------------------------");
        entryp();
    }
    // payment by patient to doctors //
        public void payOnline() throws Exception{
            System.out.println("-----------------------------------PAYMENT------------------------------------");
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter the patient name:");
                String patient_name = sc.nextLine();
                System.out.println("Enter the amount to pay:");
                String  Amt_to_paid = sc.nextLine();
            
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hms", "root", "ritik2000");
                PreparedStatement ps = con.prepareStatement("insert into payment values(?,?)");
                ps.setString(1, Amt_to_paid);
                ps.setString(2, patient_name);
                int i = ps.executeUpdate();
                if (i > 0) {
                    System.out.println("Payment successful");
                } else {
                    System.out.println("Payment failed. Please try again.");
                }
                entryp();
            con.close();
        }
        // Logout //
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
        public void entryp()throws Exception{
            System.out.println("1: Login");
            System.out.println("2: view profile");
            System.out.println("3:view Doctors");
            System.out.println("4: entrybooking appointment");
            System.out.println("5:view appointment");
            System.out.println("6:view report");
            System.out.println("7:give feedback");
            System.out.println("8:pay online");
            System.out.println("9:logout");
            Scanner sc=new Scanner(System.in);
            System.out.println("enter the choice");
            int n=sc.nextInt();
            switch (n) {
                    case 1:Login();
                    break;
                    case 2:viewProfile();
                    break;
                    case 3:viewDoctors();
                    break;
                    case 4:entryforbooking();
                    break;
                    case 5:viewAppointment();
                    break;
                    case 6:viewReport();
                            break;
                    case 7:giveFeedback();
                            break;
                    case 8:payOnline();
                            break;
                    case 9:logout();
                            break;
                    default:
                            break;
            }
        }
    
    }
