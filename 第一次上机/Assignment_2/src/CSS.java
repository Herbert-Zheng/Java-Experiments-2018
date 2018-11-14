import java.util.*;

/**
 * @author 郑昊鹏
 * @author 16130120181
 * @author 1033998328@qq.com
 */

public class CSS {
    public static void main(String[] args) {
        //  Create courses along with books required
        Course java = new Course("Java");
        Books javaBooks = new Books(new String[]{"Thinking in Java", "Java 8"});

        Course webEngineering = new Course("WebEngineering");
        Books webEngBooks = new Books(new String[]{"Web Engineering"});

        Course operationSystem = new Course("OperationSystem");
        Books operSysBooks = new Books(new String[]{"Modern Operation System"});

        //  Using maps to correspond courses and books
        Map<Course, Books> courseToBooks = new HashMap<>();
        courseToBooks.put(java, javaBooks);
        courseToBooks.put(webEngineering, webEngBooks);
        courseToBooks.put(operationSystem, operSysBooks);

        //  Using maps to correspond strings and courses
        Map<String, Course> strToCour = new HashMap<>();
        strToCour.put("Java", java);
        strToCour.put("WebEngineering", webEngineering);
        strToCour.put("OperationSystem", operationSystem);

        // Create Course array to initialize class Student
        Course[] coursesInput = new Course[args.length - 1];

        for (int i = 0; i < coursesInput.length; i++)   //  Change String into Course
            coursesInput[i] = strToCour.get(args[i + 1]);

        Student student = new Student(args[0], coursesInput, courseToBooks);

        student.PrintCourse();
    }
}

class Student {
    private String stuNum;
    private Course[] stuCour;
    private Map<Course, Books> courseBooksMap;

    Student(String inputNum, Course[] inputCourse, Map<Course, Books> inputMap) {
        stuNum = inputNum;
        stuCour = inputCourse;
        courseBooksMap = inputMap;
    }

    public void PrintCourse() {
        System.out.print(stuNum + " select ");
        for (int i = 0; i < stuCour.length; i++) {
            stuCour[i].PrintCourse();
            courseBooksMap.get(stuCour[i]).PrintBooks();

            if (i != stuCour.length - 1)    // Put different courses apart
                System.out.print("; and ");
        }
    }
}

class Course {
    private String courName;

    Course(String name) {
        courName = name;
    }

    public void PrintCourse() {     // Print course
        System.out.print(courName + " with ");
    }
}

class Books {   // Books for each identical course
    private String[] bookList;

    Books(String[] input) {
        bookList = input;
    }

    public void PrintBooks() {    // Print books of this course
        if (bookList.length > 1)   // Plural form for more than one book
            System.out.print("books ");

        for (int i = 0; i < bookList.length; i++) {
            System.out.print(bookList[i]);

            if (i != bookList.length - 1)  // Print comma for non-last member
                System.out.print(", ");
        }
    }
}
