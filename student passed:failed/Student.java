package TEST1;
import java.util.ArrayList;

public class Student implements Comparable<Student>{
    private String userName;
    private String email;
    private ArrayList<Course> courses;
   
    public Student(String userName, String email) 
    {
        super();
        courses=new ArrayList<Course>();
        this.userName = userName;
        this.email = email;
    }
    
    public void setUserName(String userName) 
    {
        this.userName = userName;
    }
    
        public String getUserName() 
    {
        return userName;
    }
    
    public void addCourse(Course course)
    {
        boolean doesCourseExist = false;
   
        for(Course c:courses)
        {
        }
    }

    public String getEmail() 
    {
        return email;
    }
    public double getAverageGrade()
    {
        double passedScoreAddition = 0;
        int passedScoreContor = 0;
        for(Course c:courses)
        {
            if(c.isPassed())
            {
                passedScoreAddition = passedScoreAddition+c.getScore();
                passedScoreContor++;
            }
        }
        return passedScoreAddition/passedScoreContor;
    }

    public void setEmail(String email) 
    {
        this.email = email;
    }
   
    public ArrayList<Course> getCourses() 
    {
        return courses;
    }
   
    @Override
    public int hashCode() 
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((userName == null) ? 0 : userName.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) 
    {
        
        if (!(obj instanceof Student))
            return false;
        if (this == obj)
            return true;
        Student other = (Student) obj;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (userName == null) {
            if (other.userName != null)
                return false;
        } else if (!userName.equals(other.userName))
            return false;
        return true;
    }
    @Override
    public int compareTo(Student obj) {
        return this.getUserName().compareTo(obj.getUserName());
    }
    @Override
    public String toString() {
        return "Student Name=" + userName + ", email=" + email + ", courses=" + courses + "]";
    }
}