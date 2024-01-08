import java.util.List;
import java.util.Set;
import java.util.Collections;
import java.util.ArrayList;

public class Student implements Comparable<Student> {
    private String nume;
    private String prenume;
    private int grup;

    public Student(String nume, String prenume, int grup) {
        this.nume = nume;
        this.prenume = prenume;
        this.grup = grup;
    }

    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public int getGrup() {
        return grup;
    }

    @Override
    public int compareTo(Student altStudent) {
        int rezultatComparare = this.nume.compareTo(altStudent.nume);
        if (rezultatComparare == 0) {
            rezultatComparare = this.prenume.compareTo(altStudent.prenume);
        }

        return rezultatComparare;
    }

    public static void main(String[] args) {
        List<Student> studenti = new ArrayList<>();
        studenti.add(new Student("Mocanu", "Mihai", 1));
        studenti.add(new Student("Macanu", "Vasile", 2));
        studenti.add(new Student("Mocanu", "Gabriel", 1));

        Collections.sort(studenti);

        for (Student student : studenti) {
            System.out.println(student.getNume() + " " + student.getPrenume());
        }
    }
}