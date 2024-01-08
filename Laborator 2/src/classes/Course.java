package classes;
public class Course {
    private  final String name;
    private  final String description;
    private  final Professor teacher;
    private  Student[] students;

    public Course(String name, String description, Professor teacher, Student[] students) {
        this.name = name;
        this.description = description;
        this.teacher = teacher;
        this.students = students;
    }

    public void addStudent(Student student) {
        Student[] newStudents = new Student[students.length +1];
        System.arraycopy(students, 0, newStudents, 0, students.length);
        newStudents[students.length] = student;
        students = newStudents;

    }
    public Professor getTeacher(){
        return teacher;
    }
    public String getName() {
        return name;
    }
    public Student[] getStudents(){
        return students;
    }


    public String toString() {
    StringBuilder courseInfo = new StringBuilder();
    courseInfo.append("Couse: ").append(name).append("\n");
    courseInfo.append("Description: ").append(description).append("\n");
    courseInfo.append("Teacher: ").append(teacher.getFullName()).append("\n");
    courseInfo.append("Students:\n");

    for (Student student : students){
        courseInfo.append("   ").append(student.getFullName()).append("\n");

    }
    return courseInfo.toString();
    }
}

