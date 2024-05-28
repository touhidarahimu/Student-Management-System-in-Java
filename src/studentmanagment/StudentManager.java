
package studentmanagment;

import java.io.*;
import java.util.ArrayList;

public class StudentManager extends Student{
    
    public StudentManager(String name, String session, String year, String gender, String email, int phoneNumber, String fathersName, String mothersName, String address) {
        super(name, session, year, gender, email, phoneNumber, fathersName, mothersName, address);
    }
    
    public StudentManager(){
        
    }
    
    public static int getIdCount() {
        return idCount;
    }

    
    
    public void saveToFile(){
        String path = "Student-"+super.getId()+".txt";
        try{
            FileWriter fw = new FileWriter(path);
            BufferedWriter writer = new BufferedWriter(fw);
            writer.write(super.getName()+","+super.getId()+","+super.getGender());
            writer.close();
            System.out.println("Saved to file yay!");
        }catch(Exception e){
            System.out.println(e);
        }
        
        
        
    }
    
    
    
    
    
    
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
