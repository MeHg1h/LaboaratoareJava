package classes;
public class Professor {
    String firstName;
    String lastName;
    public Professor(String firstName, String lastName ){
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public String getFullName(){
        return firstName + " " + lastName;
    }
    public String toString(){
        return "Professor { " + "firstName=" + firstName + " , lastName="
                 + lastName + " } ";
    }
    public static void main(String[] args){
        Professor professor = new Professor("Danciu", "Gabriel");
        String fullName = professor.getFullName();
        System.out.println(fullName);}
}

