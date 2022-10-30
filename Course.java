public class Course {
    private String courseName;
    private String courseNumber;
    private int limit;
    private int count;

    public Course(String courseName, String courseNumber) {
        this.courseName = courseName;
        this.courseNumber = courseNumber;
        this.limit = 10;
        this.count = 0;
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
