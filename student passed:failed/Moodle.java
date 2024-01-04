package TEST1;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;


public class Moodle {
   
    ArrayList<Student> users=new ArrayList<Student>();

    public ArrayList<Student> getUsers() 
    {
        return users;
    }

    public void setUsers(ArrayList<Student> users) 
    {
        this.users = users;
    }
   
    public  Map<Student,Integer> toMap()
    {
        Map<Student,Integer> studentMap=new HashMap<Student, Integer>();
        for(Student studObj:users)
        {
            int noOfCourses=studObj.getCourses().size();
            studentMap.put(studObj, noOfCourses);
        }
        return studentMap;
    }

    public static void main(String args[])
    {
        Moodle moodle=new Moodle();

        ArrayList<Student> students=new ArrayList<Student>();
        Student stud=new Student("Adrian", "AdrianS@upb.ro");
        stud.addCourse(new Course("C1", true,75));
        stud.addCourse(new Course("C2", false,45));
        students.add(stud);
        Student stud2=new Student("Alexandra", "AlexandraK@upb.ro");
        stud2.addCourse(new Course("C2", false,35));
        stud2.addCourse(new Course("C3", true,80));
        stud2.addCourse(new Course("C4", false,20));
        stud2.addCourse(new Course("C5", true,80));
        students.add(stud2);

        moodle.setUsers(students);
        System.out.println(moodle.getUsers());
       
        Map<Student,Integer> studentMap=moodle.toMap();
       }
}