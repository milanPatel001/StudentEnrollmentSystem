import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;

public class Registration {
    public static void main(String[] args) {
        BST studentMaster = new BST();

        CourseRoster[] courseMaster = new CourseRoster[4];

        Scanner in = null;

        try{
            in = new Scanner(new File("Students.txt"));

            while(in.hasNextLine()){
                String s = in.nextLine();

                String[] line = s.split("[\\s,]");

                Student st = new Student(line[0].toUpperCase(),line[1].toUpperCase(),line[2].toUpperCase());
                StudentRecord sr = new StudentRecord(st);
                studentMaster.insert(sr);
            }

           // System.out.println(studentMaster);
            in.close();
        }catch (FileNotFoundException err){
            System.out.println("Student Text File not found");
            System.exit(-1);
        }

        try{
            in = new Scanner(new File("Courses.txt"));

            int index = 0;
            while(in.hasNextLine()){
                String s = in.nextLine();

                String[] line = s.split("[\\s,]");

                StringBuilder courseName = new StringBuilder();
                for(int i=0;i< line.length-1;i++){
                    courseName.append(line[i]);
                    courseName.append(" ");
                }

                Course c = new Course(courseName.toString().trim(),line[line.length-1]);
                CourseRoster cr = new CourseRoster(c);

                courseMaster[index++] = cr;
            }

           // System.out.println(Arrays.toString(courseMaster));
            in.close();
        }catch (FileNotFoundException err){
            System.out.println("Courses Text File not found");
            System.exit(-1);
        }

        /*

        // DUMMY DATA:
        studentMaster.insert(new StudentRecord(new Student("a","b","1")));
        studentMaster.insert(new StudentRecord(new Student("c","d","2")));
        studentMaster.insert(new StudentRecord(new Student("e","f","3")));

        courseMaster[0] = new CourseRoster(new Course("Assembly language","CSCI240"));
        courseMaster[1] = new CourseRoster(new Course("DSA","CSCI313"));
        courseMaster[2] = new CourseRoster(new Course("Theory of Computation","CSCI320"));
        courseMaster[3] = new CourseRoster(new Course("Design of Algo","CSCI343"));

         */


        System.out.println("\nChoose one of the following: ");
        System.out.println("1. Add a course to a student.");

        System.out.println("2. Drop a course for a student");

        System.out.println("3. Search for a student in the course roster.");
        System.out.println("4. Search for a course in the student record.");

        System.out.println("5. Print a student's info.");
        System.out.println("6. Print a course's info");
        System.out.println("7. Print courses master list");
        System.out.println("8. Print a students master list");

        System.out.println("9: Quit");


        String id = "";
        String firstName = "";
        String lastName = "";
        String courseNum = "";
        Student s = null;

        boolean studentFound = false;
        boolean courseFound = false;
        boolean quitFlag = false;

        while(!quitFlag){
            in = new Scanner(System.in);

            System.out.print("\nEnter option: ");

            int option = 0;

            try{
                option = Integer.parseInt(in.next());
            }catch (NumberFormatException err){
                System.out.println("\nNot a number");
            }

            switch (option){
                case 1:
                    System.out.print("Enter student's First Name: ");
                     firstName = in.next();

                    System.out.print("Enter student's Last Name: ");
                    lastName = in.next();

                    System.out.print("Enter student's id number: ");
                    id = in.next();

                    System.out.print("Enter the course number you want to add to this student: ");
                    courseNum = in.next();


                    s = new Student(firstName.toUpperCase(),lastName.toUpperCase(),id);

                    BSTNode current = studentMaster.root;
                    studentFound = false;
                    courseFound = false;

                    while(current!=null){
                        StudentRecord sr = (StudentRecord) current.getData();

                        if(sr.student.compareTo(s)==0){
                            studentFound = true;

                            for(int i=0;i< courseMaster.length;i++){
                                Course c = courseMaster[i].course;
                                if(c.getCourseNumber().compareTo(courseNum)==0){

                                    sr.addCourse(c);                         //adding course to studentRecord
                                    courseMaster[i].addStudent(sr.student);  //adding student to courseRoster

                                    courseFound = true;

                                    System.out.println("\n"+c.getCourseName() + " successfully added to "+ sr.student);
                                    break;
                                }
                            }

                            if (!courseFound) System.out.println("\nCourse with this course number not found...\n");
                            current = null;
                        }

                        else if(sr.student.compareTo(s)>0) current = current.rightChild;
                        else current = current.leftChild;
                    }
                    if (!studentFound) System.out.println("\nStudent not found...\n");
                    break;

                case 2:
                    System.out.print("Enter student's First Name: ");
                    firstName = in.next();

                    System.out.print("Enter student's Last Name: ");
                    lastName = in.next();

                    System.out.print("Enter student's ID Number: ");
                     id = in.next();

                    System.out.print("Enter course number you want to drop from this student: ");
                    courseNum = in.next();

                    s = new Student(firstName.toUpperCase(),lastName.toUpperCase(),id);

                    current = studentMaster.root;
                    studentFound = false;
                    courseFound = false;

                    while(current!=null){
                        StudentRecord sr = (StudentRecord) current.getData();

                        if(sr.student.compareTo(s)==0){
                            studentFound = true;
                            courseFound = sr.removeCourse(courseNum);     // removed course from studentRecord

                            if(courseFound){
                                for(int i=0;i< courseMaster.length;i++){
                                    if(courseMaster[i].course.getCourseNumber().compareTo(courseNum)==0){
                                        courseMaster[i].removeStudent(sr.student); //removed student from courseRoster
                                    }
                                }
                                System.out.println("Course successfully removed.");
                            }else{
                                System.out.println("\nCourse with this course number not found in this student record\n");
                            }
                            current = null;
                        }

                        else if(sr.student.compareTo(s)>0) current = current.rightChild;
                        else current = current.leftChild;
                        }

                    if (!studentFound) System.out.println("\nStudent not found\n");
                    break;

                case 3:
                    System.out.print("Enter course number: ");
                    courseNum = in.next();

                    System.out.print("Enter student's First Name: ");
                    firstName = in.next();

                    System.out.print("Enter student's Last Name: ");
                    lastName = in.next();

                    System.out.print("Enter the id of the Student: ");
                    id = in.next();

                    s = new Student(firstName.toUpperCase(),lastName.toUpperCase(),id);

                    courseFound = false;

                    for(int i=0;i< courseMaster.length;i++){
                        if(courseMaster[i].course.getCourseNumber().compareTo(courseNum)==0){
                            courseFound = true;
                            if(courseMaster[i].findStudent(s)) {
                                System.out.println("\nStudent found in this course..");
                            }else{
                                System.out.println("\nStudent was not found in this course");
                            }
                            break;
                        }
                    }
                    if(!courseFound) System.out.println("Invalid Course Number..");

                    break;

                case 4:
                    System.out.print("Enter student's First Name: ");
                    firstName = in.next();

                    System.out.print("Enter student's Last Name: ");
                    lastName = in.next();

                    System.out.print("Enter the id of the Student: ");
                    id = in.next();

                    System.out.print("Enter course number: ");
                    courseNum = in.next();

                    s = new Student(firstName.toUpperCase(),lastName.toUpperCase(),id);

                    current = studentMaster.root;
                    studentFound = false;

                    while(current!=null){
                        StudentRecord sr = (StudentRecord) current.getData();

                        if(sr.student.compareTo(s)==0){
                            studentFound = true;
                            if(sr.findCourse(courseNum)){
                                System.out.println("\nThis course is taken by this student.");
                            }else{
                                System.out.println("\nThis course is not taken by this student");
                            }
                            current = null;
                            break;
                        }

                        else if(sr.student.compareTo(s)>0) current = current.rightChild;
                        else current = current.leftChild;
                    }

                    if(!studentFound) System.out.println("Student not found");

                    break;
                case 5:
                    System.out.print("Enter student's First Name: ");
                    firstName = in.next();

                    System.out.print("Enter student's Last Name: ");
                    lastName = in.next();

                    System.out.print("Enter student's ID: ");
                    id = in.next();

                    s = new Student(firstName.toUpperCase(),lastName.toUpperCase(),id);

                    BSTNode current2 = studentMaster.root;
                    studentFound = false;

                    while(current2!=null){
                        StudentRecord currRecord = (StudentRecord) current2.getData();
                        if(currRecord.student.compareTo(s)==0){
                            System.out.println(currRecord);
                            studentFound = true;
                            current2 = null;
                            break;
                        }
                        else if(currRecord.student.compareTo(s)>0) current2 = current2.rightChild;
                        else current2 = current2.leftChild;
                    }
                    if(!studentFound) System.out.println("Student not found");
                    break;

                case 6:
                    System.out.print("Enter course's Number: ");
                    id = in.next();

                    courseFound = false;

                    for(int i=0;i<courseMaster.length;i++){
                        if(courseMaster[i].course.getCourseNumber().compareTo(id)==0){
                            System.out.println(courseMaster[i]);
                            courseFound = true;
                            break;
                        }
                    }
                    if(!courseFound) System.out.println("\nCourse not found with given course number");
                    break;

                case 7:
                    System.out.println();

                    for(int i=0;i< courseMaster.length;i++){
                        System.out.println(courseMaster[i]);
                    }

                    break;

                case 8:
                    studentMaster.print(studentMaster.root);
                    break;

                default:
                    System.out.println("Exited the program.");
                    in.close();
                    quitFlag = true;
            }
        }
    }
}
