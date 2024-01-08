import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        MockClassesManager mockManager = new MockClassesManager();

        List<Course> cursuri = new ArrayList<>(mockManager.getCursuri());
        List<Student> studenti = new ArrayList<>(mockManager.getStudenti());

        CourseManager courseManager = new CourseManager();

        courseManager.getCursuri().addAll(cursuri);

        courseManager.sortCourses("nume");

        List<Course> cursuriSortate = courseManager.getCursuri();
        for (Course curs : cursuriSortate) {
            System.out.println("Curs: " + curs.getNume() + ", Profesor: " + curs.getProfesor().getNume());
        }

        String numeCursCautat = "Java Programming";
        Course cursGasit = courseManager.cautaCursDupaNume(numeCursCautat);

        if (cursGasit != null) {
            System.out.println("Cursul a fost găsit: " + cursGasit.getNume());
        } else {
            System.out.println("Cursul nu a fost găsit.");
        }
    }
}