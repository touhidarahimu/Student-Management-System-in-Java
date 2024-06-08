
package studentmanagment;

public class Course {
    
    private String courseName;
    private String courseCode;
    private String semester;
    private int creditHours;
    private double marks;

    public Course(String courseName, String courseCode, int creditHours) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.creditHours = creditHours;
        marks = 0;
    }

    public Course(String courseName, String courseCode, String semester, int creditHours) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.semester = semester;
        this.creditHours = creditHours;
    }
    
    

    public String getCourseName() {
        return courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public int getCreditHours() {
        return creditHours;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public void setCreditHours(int creditHours) {
        this.creditHours = creditHours;
    }

    @Override
    public String toString() {
        return courseCode+" - "+creditHours;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }
    
    
    
    
    
}
