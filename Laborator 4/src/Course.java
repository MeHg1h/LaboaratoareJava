import java.util.Set;
public class Course {
    private String nume;
    private String descriere;
    private Professor profesor;
    private Set<Student> studenti;
    public Set<Student> getStudenti() {
        return studenti;
    }
    public Professor getProfesor() {
        return profesor;
    }
    public Course(String nume, String descriere, Professor profesor, Set<Student> studenti) {
        this.nume = nume;
        this.descriere = descriere;
        this.profesor = profesor;
        this.studenti = studenti;
    }
    public String getNume() {
        return nume;
    }
}
