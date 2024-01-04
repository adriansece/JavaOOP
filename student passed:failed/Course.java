package TEST1;
public class Course {
    
    private double score;
    private boolean passed;
    private String courseId;

    public void setScore(double score) 
    {
        this.score = score;
    }

    public double getScore() 
    {
        return score;
    }
   
    public void setCourseId(String courseId) 
    {
        this.courseId = courseId;
    }
   
    public Course(String courseId, boolean passed, double score) 
    {
        super();
        this.courseId = courseId;
        this.passed = passed;
        this.score = score;
    }
    
    public void setPassed(boolean passed) 
    {
        this.passed = passed;
    }

    public String getCourseId() 
    {
        return courseId;
    }

    public boolean isPassed() 
    {
        return passed;
    }
   
    @Override
    public String toString() {
        return "CourseId= " + courseId + ", passed= " + passed + ", score= " + score + "]";
    }
   
}