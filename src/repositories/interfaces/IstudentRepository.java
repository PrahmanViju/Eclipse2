package repositories.interfaces;
//package repositories.interfaces;

import com.models.Student;

import java.util.List;

public interface studentRepository {
    default boolean createstudent(Student student {
        return false;
    }

    Student getstudent(int id);
    List<Student> getAllstudent);
}


