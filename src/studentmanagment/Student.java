
package studentmanagment;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Student implements Gradable{
    
    public static int idCount;
    public static int sessionCount;

    private String id;
    private String name;
    //date of birth get JCalender
    private String session; //semester + start year
    //add department
    private String year;
    private String gender;
    private String email;
    private int phoneNumber;
    private String fathersName;
    private String mothersName;
    private String address;
    //public static ArrayList<String> sessionCode = new ArrayList<>();
    public static HashMap<String,Integer> sessionCode = new HashMap<>();
    
    public Student(){
        
    }
    
    public Student(String name, String session,String year,String gender, String email, int phoneNumber, String fathersName, String mothersName, String address) {
        idCount++;
        //generating unique id
        this.year = year;
        String sessionFormat = "";
        if(session.compareTo("Spring")==0){
            sessionFormat = 1+"";
        }
        else{
            sessionFormat = 2+"";
        }

        String yearFormat = year.substring(2);
        this.id = idGenerate(sessionFormat,yearFormat);
        this.name = name;
        this.session = session;
        this.gender = gender;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.fathersName = fathersName;
        this.mothersName = mothersName;
        this.address = address;
        
    }
    
    private String idGenerate(String sessionFormat, String yearFormat){
        //24 + 1 etc
        String format = yearFormat + sessionFormat;
        
        sessionCode.putIfAbsent(format,0);  //if key does not exist create a new one
        sessionCode.put(format, sessionCode.get(format)+1); //increase the value of by one
        
        String generatedId = String.format("%07d", sessionCode.get(format));
        
        return  format+ generatedId;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSession() {
        return session;
    }

    public String getGender() {
        return gender;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getEmail() {
        return email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String getFathersName() {
        return fathersName;
    }

    public String getMothersName() {
        return mothersName;
    }

    public String getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setFathersName(String fathersName) {
        this.fathersName = fathersName;
    }

    public void setMothersName(String mothersName) {
        this.mothersName = mothersName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static int getIdCount() {
        return idCount;
    }

    public static void setIdCount(int idCount) {
        Student.idCount = idCount;
    }
    
    
}
