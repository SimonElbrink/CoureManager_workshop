package se.lexicon.course_manager_assignment.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

public class Course implements Serializable {

    private Integer id;
    private String courseName;
    private LocalDate StartDate;
    private Integer weekDuration;
    private Collection<Student> students;

    public Course() {
    }

    public Course(Integer id, String courseName, LocalDate startDate, Integer weekDuration) {
        this.id = id;
        this.courseName = courseName;
        StartDate = startDate;
        this.weekDuration = weekDuration;
        students = new ArrayList<>();
    }


    public boolean enrollStudent(Student student){
        if (student == null) throw new IllegalArgumentException("Student was Null");
        if (students == null) students = new ArrayList<>();

        if (!students.contains(student)){
           return students.add(student);
        }

        return false;
    }

    public boolean unrollStudent(Student student){
        if (student == null) throw new IllegalArgumentException("Student was Null");
        if (students == null) students = new ArrayList<>();

        return students.remove(student);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public LocalDate getStartDate() {
        return StartDate;
    }

    public void setStartDate(LocalDate startDate) {
        StartDate = startDate;
    }

    public Integer getWeekDuration() {
        return weekDuration;
    }

    public void setWeekDuration(Integer weekDuration) {
        this.weekDuration = weekDuration;
    }

    public Collection<Student> getStudents() {
        return students;
    }

    public void setStudents(Collection<Student> students) {
        this.students = students;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course)) return false;
        Course course = (Course) o;
        return Objects.equals(getId(), course.getId()) && Objects.equals(getCourseName(), course.getCourseName()) && Objects.equals(getStartDate(), course.getStartDate()) && Objects.equals(getWeekDuration(), course.getWeekDuration());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCourseName(), getStartDate(), getWeekDuration());
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", StartDate=" + StartDate +
                ", weekDuration=" + weekDuration +
                ", students=" + students +
                '}';
    }
}
