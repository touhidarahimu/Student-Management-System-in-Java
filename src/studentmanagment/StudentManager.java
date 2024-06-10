
package studentmanagment;

import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class StudentManager extends Student{
    
    private int fileId;
    private ArrayList<Course> courses;
    private double gpa;
    public static double CGPA;
    
    public StudentManager(String name, String dateOfBirth, String session, String year, String gender, String department,String email, int phoneNumber, String fathersName, String mothersName, String address) {
        super(name, dateOfBirth, session, year, gender,department, email, phoneNumber, fathersName, mothersName, address);
        fileId = StudentManager.getIdCount();
        courses = new ArrayList<Course>();
        gpa = 0;
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
    
    
    private static JFrame frame;
    //adding previous students to system
    //returns the oldStudent until there are no files left, then it returns null
    public static StudentManager addRecord(int count){
        StudentManager oldStudent = null;
        String path = "Student-"+count+".txt";
       
        try{
            FileReader fr= new FileReader(path);
            BufferedReader reader = new BufferedReader(fr);
            String line;
            while((line=reader.readLine())!=null){
                String[] info  = line.split(",");
                String id = (info[0]);
                String name = info[1];
                String dateOfBirth = info[2];
                String gender = info[3];
                String session = info[4];
                String year = info[5];
                String department = info[6];
                String email = info[7];
                int phoneNumber =  Integer.parseInt(info[8]);
                String fathersName = info[9];
                String mothersName = info[10];
                String address = info[11];
                oldStudent = new StudentManager(name,dateOfBirth,session,year,gender,department,email,phoneNumber,fathersName,mothersName,address);
                 
            }
            reader.close();
            
        }catch(FileNotFoundException e){
            return null;
        }catch(Exception e){
            JOptionPane.showMessageDialog(frame, "Unexcpected Error! "+e.getMessage());
        }
        
        return oldStudent;

    }
    
   
        
        
    
    
    public void deleteFile(int index){
        File file = new File("Student-"+index+".txt");
        if(file.exists()){
            file.delete();
            JOptionPane.showMessageDialog(frame, "Student file deleted!");

        }
        else{
            JOptionPane.showMessageDialog(frame, "No such file in directory!");

        }
        
        
    }
    
    public void enrollInCourse(Course course){
        courses.add(course);
    }
    
    public void dropCourse(Course course){
        courses.remove(course);
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }
    
    
    
    @Override
    public double calculateGPA() {
        
        if(courses.isEmpty()){
            return 0;
        }
        double GPA = 0;
        for(int i=0;i<courses.size();i++){
            GPA += calculateGrade(courses.get(i).getMarks());
        }
        
        
        return GPA/courses.size();
        
    }

    @Override
    public void setGPA(double gpa) {
        
        

    }

    @Override
    public double getGPA() {
        gpa = calculateGPA();
        return gpa;
    }

    @Override
    public double getGrade() {
        
        return 0;
        
    }

    @Override
    public double calculateGrade(double mark) {
        
        if(mark>=93){
            return 4.0;
        }
        else if(mark>=90&&mark<=92){
            return 3.7;
        }
        else if(mark>=87&&mark<=89){
            return 3.3;
        }
        else if(mark>=83&&mark<=86){
            return 3.0;
        }
        else if(mark>=80&&mark<=82){
            return 2.7;
        }
        else if(mark>=77&&mark<=79){
            return 2.3;
        }
        else if(mark>=73&&mark<=76){
            return 2.0;
        }
        else if(mark>=70&&mark<=72){
            return 1.7;
        }
        else if(mark>=67&&mark<=69){
            return 1.3;
        }
        else if(mark>=60&&mark<=66){
            return 1.0;
        }
        else{
            return 0.0;
        }

    }

    //calculates the total cgpa of all the students but does not find average
    @Override
    public double calculateCGPA(StudentManager student) {
        double totalCGPA = 0;
        for(int i=0;i<student.courses.size();i++) {
            totalCGPA += student.gpa;
        }
        
        return totalCGPA;
        
    }

    public int getFileId() {
        return fileId;
    }

    public void setFileId(int fileId) {
        this.fileId = fileId;
    }

    @Override
    public String toString() {
        return "StudentManager{" + "fileId=" + fileId + ", courses=" + courses + ", gpa=" + gpa + '}';
    }
    
    
    
    
}
