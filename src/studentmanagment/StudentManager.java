
package studentmanagment;

import java.io.*;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class StudentManager extends Student{
    
    private int fileId;
    
    public StudentManager(String name, String dateOfBirth, String session, String year, String gender, String department,String email, int phoneNumber, String fathersName, String mothersName, String address) {
        super(name, dateOfBirth, session, year, gender,department, email, phoneNumber, fathersName, mothersName, address);
        fileId = StudentManager.getIdCount();
    }
    
    public StudentManager(){
        
    }
    
    public static int getIdCount() {
        return idCount;
    }

    public static void setIdCount(int newCount) {
        Student.idCount = newCount;
    }

    
    
    public void saveToFile(){
        String path = "Student-"+fileId+".txt";
        try{
            FileWriter fw = new FileWriter(path);
            BufferedWriter writer = new BufferedWriter(fw);
            writer.write(super.getId()+",");   //0         
            writer.write(super.getName()+",");    //1     
            writer.write(super.getDateOfBirth()+",");   //2
            writer.write(super.getGender()+",");   //3
            writer.write(super.getSession()+",");  //4         
            writer.write(super.getYear()+",");  //5         
            writer.write(super.getDepartment()+",");    //6
            writer.write(super.getEmail()+",");    //7
            writer.write(super.getPhoneNumber()+",");  //8
            writer.write(super.getFathersName()+",");  //9
            writer.write(super.getMothersName()+",");   //10
            writer.write(super.getAddress()); //11
            writer.close();
        }catch(Exception e){
            System.out.println(e);
        }
        
    }
    
    public void OverrideFile(int index){
        String path = "Student-"+index+".txt";
        try{
            FileWriter fw = new FileWriter(path);
            BufferedWriter writer = new BufferedWriter(fw);
            writer.write(super.getId()+",");   //0         
            writer.write(super.getName()+",");    //1     
            writer.write(super.getDateOfBirth()+",");   //2
            writer.write(super.getGender()+",");   //3
            writer.write(super.getSession()+",");  //4         
            writer.write(super.getYear()+",");  //5         
            writer.write(super.getDepartment()+",");    //6
            writer.write(super.getEmail()+",");    //7
            writer.write(super.getPhoneNumber()+",");  //8
            writer.write(super.getFathersName()+",");  //9
            writer.write(super.getMothersName()+",");   //10
            writer.write(super.getAddress()); //11
            writer.close();
        }catch(Exception e){
            System.out.println(e);
        }
        
    }
    
    private static JFrame frame;
//    public static void addRecord(int count){
//        try{
//            String path = "Student-"+count+".txt";
//            FileReader fr= new FileReader(path);
//            BufferedReader reader = new BufferedReader(fr);
//            String line;
//            while((line=reader.readLine())!=null){
//                String[] info  = line.split(",");
//                String id = (info[0]);
//                String name = info[1];
//                String gender = info[2];
//                String session = info[3];
//                String year = info[4];
//                String email = info[5];
//                int phoneNumber =  Integer.parseInt(info[6]);
//                String fathersName = info[7];
//                String mothersName = info[8];
//                String address = info[9];
//                StudentManager oldStudent = new StudentManager(name,session,year,gender,email,phoneNumber,fathersName,mothersName,address);
//                System.out.println(oldStudent.toString());
//            }
//            JOptionPane.showMessageDialog(frame, "Files Loaded");
//            reader.close();
//            
//        }catch(Exception e){
//            System.out.println(e);
//        }
//        
//        
//    }
    
    
    
    
    
    
    //will add later
    @Override
    public double calculateGPA() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setGPA(double gpa) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public double getGPA() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public double getGrade() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setGrade(double grade) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public double calculateAvgCGPA() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
    
}
