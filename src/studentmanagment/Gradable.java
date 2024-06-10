
package studentmanagment;

public interface Gradable {
    
    public double calculateGPA();
    public void setGPA(double gpa);
    public double getGPA();
    
    public double getGrade();
    public double calculateGrade(double mark);
    
    public double calculateCGPA(StudentManager student);//set parameter later
    
    
    
}
