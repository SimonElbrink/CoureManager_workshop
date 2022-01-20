package se.lexicon.course_manager_assignment.data.dao;



import se.lexicon.course_manager_assignment.data.sequencers.CourseSequencer;
import se.lexicon.course_manager_assignment.model.Course;
import se.lexicon.course_manager_assignment.model.Student;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;


public class CourseCollectionRepository implements CourseDao{

    private Collection<Course> courses;


    public CourseCollectionRepository(Collection<Course> courses) {
        this.courses = courses;
    }

    @Override
    public Course createCourse(String courseName, LocalDate startDate, int weekDuration) {

        int id = CourseSequencer.nextCourseId();
        Course course = new Course(id,courseName,startDate,weekDuration);

        //Ternary Operator
       return courses.add(course) ? course : null;


    }

    @Override
    public Course findById(int id) {
        for (Course course : courses) {
            if (course.getId().equals(id)){
                return course;
            }
        }
        return null;
    }

    @Override
    public Collection<Course> findByNameContains(String name) {

        Collection<Course> matchingCourses = new HashSet<>();

        for (Course course: courses) {
            if (course.getCourseName().toLowerCase().trim().contains(name.trim().toLowerCase())){
                matchingCourses.add(course);
            }
        }

        return matchingCourses;
    }

    @Override
    public Collection<Course> findByDateBefore(LocalDate end) {

        Collection<Course> found = new HashSet<>();

        for (Course course :
                courses) {
            if (course.getStartDate().isBefore(end)){
                found.add(course);
            }
        }
        return found;
    }

    @Override
    public Collection<Course> findByDateAfter(LocalDate start) {
        Collection<Course> found = new HashSet<>();


        for (Course c : courses) {
            if (c.getStartDate().isAfter(start)) {
                found.add(c);
            }
        }

        return found;
    }

    @Override
    public Collection<Course> findAll() {
        return new HashSet<>(courses);
    }

    @Override
    public Collection<Course> findByStudentId(int studentId) {

        Collection<Course> found = new HashSet<>();

        for (Course course : courses){
            for (Student student: course.getStudents()){
                if (student.getId().equals(studentId)){
                    found.add(course);
                }
            }
        }
        return found;
    }

    @Override
    public boolean removeCourse(Course course) {
        return courses.remove(course);
    }

    @Override
    public void clear() {
        this.courses = new HashSet<>();
    }
}
