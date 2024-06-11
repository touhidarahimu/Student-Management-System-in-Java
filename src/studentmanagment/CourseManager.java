
package studentmanagment;

import java.io.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author mahjabinnoornabila
 */
public class CourseManager extends Course{

    private static int courseCount =0 ;
    private int courseFileID;

    public CourseManager() {
    }
    
    
    
    public CourseManager(String courseName, String courseCode, int creditHours) {
        super(courseName, courseCode, creditHours);
        courseCount++;
        courseFileID = courseCount;
    }
    
    
    private static JFrame frame;
    //start loop from 11
    public void saveCourseToFile(){
        String path = "Course-"+courseFileID+".txt";
        try{
            FileWriter fw = new FileWriter(path);
            BufferedWriter writer = new BufferedWriter(fw);
            writer.write(super.getCourseName()+",");
            writer.write(super.getCreditHours()+",");
            writer.write(super.getCourseCode());
            writer.close();
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(frame, "Error! "+e.getMessage());
        }
    }
    
    public static CourseManager addPreviousCourse(int count){
        CourseManager oldCourse = null;
        String path = "Course-"+count+".txt";
        try{
            FileReader fr = new FileReader(path);
            BufferedReader reader = new BufferedReader(fr);
            String line;
            while((line=reader.readLine())!=null){
                String[] info  = line.split(",");
                String courseName = info[0];
                int creditHours = Integer.parseInt(info[1]);
                String courseCode = info[2];
                oldCourse = new CourseManager(courseName,courseCode,creditHours);
            }
            reader.close();
        }catch(FileNotFoundException e){
            return null;
        }catch(Exception e){
            JOptionPane.showMessageDialog(frame, "Unexcpected Error! "+e.getMessage());
        }
        
        return oldCourse;

    }
        
    public void deleteCourseFile(int index){
        File file = new File("Course-"+index+".txt");
        if(file.exists()){
            file.delete();
            JOptionPane.showMessageDialog(frame, "Course file deleted!");

        }
        else{
            JOptionPane.showMessageDialog(frame, "No such file in directory!");

        }
        
        
    }    
        
        
    
    public static int getCourseCount() {
        return courseCount;
    }

    public static void setCourseCount(int courseCount) {
        CourseManager.courseCount = courseCount;
    }

    public int getCourseFileID() {
        return courseFileID;
    }

    public void setCourseFileID(int courseFileID) {
        this.courseFileID = courseFileID;
    }
    
    
}
