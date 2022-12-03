import java.util.ArrayDeque;
import java.util.Queue;

public class Course {
    private String courseName;
    private String courseNumber;
    private int limit;
    private int count;

    public Queue<Student> waitList;

    public Course(String courseName, String courseNumber) {
        this.courseName = courseName;
        this.courseNumber = courseNumber;
        this.limit = 5;
        this.count = 0;
        this.waitList = new ArrayDeque<>();
    }

    public void addToWaitList(Student s){
            waitList.add(s);
    }

    public Student removeFromWaitList(){
        if(waitList.isEmpty()){
            return null;
        }
        return waitList.poll();
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return
                "CourseName = '" + courseName + '\'' +
                ", CourseNumber = '" + courseNumber + '\'';
    }
}
