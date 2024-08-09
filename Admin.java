// Admin can add Doctors,view patients list,
//   view Doctors list,remove doctors, see feedback given by patients,view reports,logout.


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;


    public class Admin extends doctor{
        Scanner sc=new Scanner(System.in);
        String name="Ritik";
        String password="Ritik1432";
        public void LoginA() throws Exception{
            System.out.print("USERNAME:");
            String name1=sc.nextLine();
            System.out.print("PASSWORD:");
            String password1=sc.nextLine();
            if(name1.equals(name)&&(password1.equals(password))){
                entryA();
            }else{
                System.out.println("Wrong username or password");
            }
        }
        //Add doctors
    public void AddDoctors() throws Exception{
        try {
            String id,name,email,specification,contact;
            System.out.println("Want to add doctors:-------------->");
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter the doctors id:");
            id=sc.nextLine();
            System.out.println("enter the password:");
            password=sc.nextLine();
            System.out.println("Enter doctor name:");
            name=sc.nextLine();
            System.out.println("Enter the email:");
            email=sc.nextLine();
            System.out.println("Enter specification of doctor:");
            specification=sc.nextLine();
            System.out.println("Enter the doctors contactno:");
            contact=sc.nextLine();
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("driver loaded successfully");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hms","root","bapu1432");
            System.out.println("successfully");
            PreparedStatement ps=con.prepareStatement("Insert into dradd values(?,?,?,?,?,?)");
            ps.setString(1, id);
            ps.setString(2, password);
            ps.setString(3, name);
            ps.setString(4, email);
            ps.setString(5, specification);
            ps.setString(6, contact);
            int i=ps.executeUpdate();
                if(i>0){
                    System.out.println("SUCCESS");
                }else{
                System.out.println("FAILED");
                }
                
                } catch (Exception e) {
                e.printStackTrace();
            }
            entryA();
        }
        //View patient lists
        public void viewPatientList() throws Exception{
            System.out.println("----------------------------PATIENT DETAILS----------------------------------");
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hms","root","bapu1432");
            PreparedStatement ps=con.prepareStatement("SELECT * from signup");
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                System.out.println("------------------------------------------------------------------------------------");
                String name = rs.getString("name");
                System.out.println("name:"+name);

                String email = rs.getString("email");
                System.out.println("email:"+email);

                String password=rs.getString("password");
                System.out.println("password:"+password);

                String contactno = rs.getString("contactno");
                System.out.println("contactno:"+contactno);

                String gender = rs.getString("gender");
                System.out.println("gender:"+gender);
                
                
            }
            System.out.println("--------------------------------------------------------------------------------------");
            System.out.println("\n");
            entryA();
        }

        //view doctors list
                public void viewDoctorList() throws Exception{
                System.out.println("--------------------------------DOCTOR LIST-----------------------------------");
                Scanner sc=new Scanner(System.in);
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hms","root","bapu1432");
                String q="select * from dradd";
                PreparedStatement ps=con.prepareStatement(q);
                ResultSet rs=ps.executeQuery();
                        while(rs.next()){
                    System.out.println("-------------------------------------------------------------------------------");
                    String id=rs.getString("id");
                    System.out.println("id:"+id);
                    String password=rs.getString("password");
                    System.out.println("password:"+password);
                    String name=rs.getString("name");
                    System.out.println("name:"+name);
                    String email= rs.getString("email");
                    System.out.println("email:"+email);
                    String specification= rs.getString("specification");
                    System.out.println("specification:"+specification);
                    String contact = rs.getString("contact");
                    System.out.println("contact:"+contact);
                    
                    }
                    System.out.println("---------------------------------------------------------------------------------");
                    entryA();
                    System.out.println("\n");
                    
                }

// remove doctors
    public void removeDoctors() {
        try{
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter the doctors id:");
        String id=sc.nextLine();
        System.out.println("Enter the password:");
        String password=sc.nextLine();
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hms","root","bapu1432");
        PreparedStatement ps=con.prepareStatement("delete from dradd where id=? and password=?");
        ps.setString(1, id);
        ps.setString(2, password);
        int i=ps.executeUpdate();
        
        if(i>0) {
            System.out.println("deleted data successfully");
            entryA();
        }else{
            System.out.println("failed to delete the data");
        }
    con.close();
}catch(Exception e){
            e.printStackTrace();
        }
        
    }

    //
    public void feedback() throws Exception{
        try {
            System.out.println("------------------------------------FEEDBACK--------------------------------------------");
            Scanner sc = new Scanner(System.in);
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hms", "root", "bapu1432");
            PreparedStatement ps = con.prepareStatement("select * from feedback");
            ResultSet rs=ps.executeQuery();
            
            while (rs.next()) {
                String patient_name=rs.getString("patient_name");
                System.out.println("patient_name:"+patient_name);

                String doctor_name=rs.getString("doctor_name");
                System.out.println("doctor_name:"+doctor_name);

                String feedback_Details=rs.getString("feedback_Details");
                System.out.println("feedback_details:"+feedback_Details);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("------------------------------------------------------------------------------------------");
        entryA();
    }

    public void viewReports() throws Exception{
        System.out.println("-----------------------------VIEW REPORT------------------------------------");
        Scanner sc = new Scanner(System.in);
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hms", "root", "bapu1432");
        PreparedStatement ps = con.prepareStatement("SELECT * FROM report");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String email=rs.getString("patient_email");
            System.out.println("Email:"+email);
            String reportID = rs.getString("report_id");
            System.out.println("Report ID:"+reportID);
            String date = rs.getString("Report_date");
            System.out.println("Report Date:"+date);
            String details = rs.getString("Report_details");
            System.out.println("Details about report:"+details);
            String doctorName = rs.getString("doctor_Name");
            System.out.println("Doctor's name:"+doctorName);
        
}
            System.out.println("------------------------------------------------------------------------");
            entryA();
        }
//           delete reports//
        public void removeReport() {
            try{
            Scanner sc =new Scanner(System.in);
            System.out.println("Enter the patient email:");
            String email=sc.nextLine();
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hms","root","bapu1432");
            PreparedStatement ps=con.prepareStatement("delete from report where patient_email=?");
            ps.setString(1, email);
            int i=ps.executeUpdate();
            if(i>0) {
                System.out.println("deleted report successfully");
                entryA();
            }else{
                System.out.println("failed to delete the report");
            }
        con.close();
    }catch(Exception e){
                e.printStackTrace();
            }
            
        }
    
        //logout
    public void Logout() throws Exception{
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

    public void entryA() throws Exception{
        
        System.out.println("1:Add doctors");
        System.out.println("2:View Patient List");
        System.out.println("3:View Doctors List");
        System.out.println("4:Remove doctors");
        System.out.println("5:See feedback given by patients");
        System.out.println("6:View Reports");
        System.out.println("7:Logout");
        System.out.println("8:remove reports");
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the choice:");
        int choice=sc.nextInt();
        switch(choice) {
            case 1:AddDoctors();
            break;
            case 2:viewPatientList();
            break;
            case 3:viewDoctorList();
            break;
            case 4:removeDoctors();
            break;
            case 5:feedback();
            break;
            case 6:viewReports();
            break;
            case 7:Logout();
            break;
            case 8:removeReport();
            break;
            default:
            break;
        }
        }
    }




