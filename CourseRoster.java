
public class CourseRoster {

    public Course course;
    public sortedLinkedList studentsRegistered;

    public CourseRoster(Course c){
        studentsRegistered = new sortedLinkedList();
        course = c;
    }

    public void addStudent(Student s){
        studentsRegistered.insert(s);
    }

    public void removeStudent(Student s){
        studentsRegistered.delete(s);
    }

    public boolean findStudent(String id){
        LLNode current = studentsRegistered.head.next;
        while(current!=null){
            Student s = (Student) current.getData();

            if(s.getIDNo().compareTo(id)==0){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public String toString() {
        return course +
                ", Students Registered: " + studentsRegistered ;
    }
}
