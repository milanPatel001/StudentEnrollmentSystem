
import java.util.Objects;

public class Student implements Comparable<Student>{
    private String firstName;
    private String lastName;
    private String IDNo;

    public Student(String firstName, String lastName, String IDNo) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.IDNo = IDNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIDNo() {
        return IDNo;
    }

    public void setIDNo(String IDNo) {
        this.IDNo = IDNo;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(IDNo, student.IDNo);
    }

    @Override
    public String toString() {
        return " FirstName='" + firstName + '\'' +
                ", LastName='" + lastName + '\'' +
                ", IDNo='" + IDNo + '\'';
    }

    @Override
    public int compareTo(Student o) {
       if(o.lastName.compareTo(lastName)==0){
           if(o.firstName.compareTo(firstName)==0){
               return o.IDNo.compareTo(IDNo);
           }
           return o.firstName.compareTo(firstName);
       }
       return o.lastName.compareTo(lastName);
    }
}
