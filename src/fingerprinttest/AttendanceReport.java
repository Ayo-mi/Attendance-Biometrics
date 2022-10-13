/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fingerprinttest;

/**
 *
 * @author AYO
 */
public class AttendanceReport {
    private int classHeld, classPresent, classAbsent, attendancePercentage,id;
    private String matricNumber, firstName, lastName, courseCode, courseTitle;
    
    public AttendanceReport(int classHeld, int id, int classPresent, int classAbsent, int attendancePercentage, String matricNumber,
                   String courseCode){
        
        this.classHeld=classHeld;      
        this.id = id;
        this.classPresent=classPresent;
        this.classAbsent=classAbsent;
        this.attendancePercentage=attendancePercentage;
        this.matricNumber=matricNumber;
        this.courseCode=courseCode;

        
    }
    
    public int getId(){
        return id;
    }
    
    public int getClassHeld(){
        return classHeld;
    }
    
    public int getClassPresent(){
        return classPresent;
    }
    
    public int getClassAbsent(){
        return classAbsent;
    }
    
    public int getAttendancePercentage(){
        return attendancePercentage;
    }
    
    public String getMatricNumber(){
        return matricNumber;
    }

    public String getFirstName(){
        return firstName;
    }
    
    public String getLastName(){
        return lastName;
    }
    
    public String getCourseCode(){
        return courseCode;
    }
    
    public String getCourseTitle(){
        return courseTitle;
    }
}
