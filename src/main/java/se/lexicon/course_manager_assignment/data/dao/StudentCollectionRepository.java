package se.lexicon.course_manager_assignment.data.dao;



import se.lexicon.course_manager_assignment.data.sequencers.StudentSequencer;
import se.lexicon.course_manager_assignment.model.Student;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;


public class StudentCollectionRepository implements StudentDao {

    private Collection<Student> students;

    public StudentCollectionRepository(Collection<Student> students) {
        this.students = students;
    }

    @Override
    public Student createStudent(String name, String email, String address) {

        Student newStudent = new Student(StudentSequencer.nextStudentId(), name, email, address);

        return students.add(newStudent) ? newStudent : null;
    }

    @Override
    public Student findByEmailIgnoreCase(String email) {

        for (Student s : students) {
            if (s.getEmail().trim().equalsIgnoreCase(email)) {
                return s;
            }
        }

        return null;
    }

    @Override
    public Collection<Student> findByNameContains(String name) {

        Collection<Student> foundMatches = new HashSet<>();

        for (Student s : students) {
            if (s.getName().trim().toLowerCase().contains(name.trim().toLowerCase())) {
                foundMatches.add(s);
            }
        }

        return foundMatches;
    }

    @Override
    public Student findById(int id) {

        for (Student s : students
        ) {
            if (s.getId() == id) {
                return s;
            }
        }

        return null;
    }

    @Override
    public Collection<Student> findAll() {
        return Collections.unmodifiableCollection(students);
    }

    @Override
    public boolean removeStudent(Student student) {
        return students.remove(student);
    }

    @Override
    public void clear() {
        this.students = new HashSet<>();
    }
}
