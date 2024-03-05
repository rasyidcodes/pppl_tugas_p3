import org.example.Student;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestCaseStudent {

    ArrayList<Student> students;

    @BeforeAll
    public void initClass(){
        students = new ArrayList<Student>();
    }

    @BeforeEach
    public void intMethod(){
        students.add(new Student("rasyid", 20));
    }

    @AfterEach
    public void cleanMethod(){
        students.clear();
    }

    @AfterAll
    public void  cleanClass(){
        students.clear();
    }

    @Test
    void testDataCreation(){
        assertAll(
                ()->assertNotNull(students.get(0).getName()),
                ()->assertNotNull(students.get(0).getAge()),
                ()->assertNotEquals(0,students.toArray().length)
        );
    }

    @Test
    void testStudentEnrollment(){
        students.get(0).enrollCourse("Math");
        students.get(0).enrollCourse("Science");
        assertAll(
                ()->assertEquals(2,students.get(0).getEnrolledCourses().size())
        );
    }

    @Test
    void testSetGrade(){
        students.get(0).setGrade("Math","A");
        students.get(0).setGrade("Science","B");
        Assertions.assertNotNull(students.get(0).getGrade("Math"));
        Assertions.assertNotNull(students.get(0).getGrade("Science"));
    }


}
