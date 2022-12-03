
public class CourseRoster {

    public Course course;
    public BST studentsRegistered;


    public CourseRoster(Course c){
        studentsRegistered = new BST();
        course = c;
    }

    public void addStudent(Student s){
        if(course.getCount()<course.getLimit()) {
            studentsRegistered.insert(s);
            course.setCount(course.getCount()+1);
        }
        else {
            course.addToWaitList(s);
            System.out.println("\nStudent added to Waitlist");
        }
    }

    public void removeStudent(Student s){
        studentsRegistered.delete(s);

        if(!course.waitList.isEmpty()){
            Student waiting = course.removeFromWaitList();

            if(waiting.compareTo(s)!=0) {
                course.setCount(course.getCount()-1);
                addStudent(waiting);
                System.out.println("\n" + waiting.getFirstName() + " " + waiting.getLastName() + " added to this course from waiting list.");
            }else{
                System.out.println("\n" + waiting.getFirstName() + " " + waiting.getLastName() +" removed from waitlist");
            }
        }else{
            course.setCount(course.getCount()-1);
        }
    }

    public boolean findStudent(Student s){
        return studentsRegistered.search(s);
    }

    @Override
    public String toString() {
        return course +
                ", Students Registered: " + studentsRegistered ;
    }
}
