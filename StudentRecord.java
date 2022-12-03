import java.util.Arrays;
import java.util.Queue;

public class StudentRecord implements Comparable<StudentRecord> {
    public Student student;
    public Course[] courseReg;

    private int count;

    public StudentRecord(Student s){
        student = s;
        courseReg = new Course[4];
        count = 0;
    }


    public void addCourse(Course c){
        if(count>=courseReg.length){
            System.out.println("Can't add more courses to this student!");
        }
        else {
            courseReg[count] = c;
            count++;
        }
        //System.out.println("\n"+c+" successfully added to Student "+student);
    }

    public boolean removeCourse(String courseNum){
        //if(courseReg.length==0) System.out.println("Empty list");

        for(int i=0;i<courseReg.length;i++){
            if(courseReg[i]==null) break;

            else if(courseNum.compareTo(courseReg[i].getCourseNumber())==0){

                    while(i<courseReg.length-1){
                        courseReg[i] = courseReg[i+1];
                        i++;
                    }
                    courseReg[i] = null;
                    count--;
                //System.out.println("Course successfully removed");
                    return true;
            }
        }

        return false;
    }

    public boolean findCourse(String courseNum){
        for(int i=0;i<courseReg.length;i++){
            if(courseReg[i]==null) break;
            if(courseReg[i].getCourseNumber().compareTo(courseNum)==0){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return student+
                " Courses Taken: " + Arrays.toString(courseReg);
    }

    @Override
    public int compareTo(StudentRecord o) {
        return o.student.compareTo(student);
    }
}
