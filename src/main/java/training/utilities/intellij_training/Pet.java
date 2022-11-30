package training.utilities.intellij_training;

public class Pet {

    String firstName;
    String lastName;

    int age;

    public Pet(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    // introduce paraneter object
    // Strg + Alt + V: local Variable einführen --> Strg + Alt + N: rückgängig machen (inline)
    public static void main(String[] args) {
        Pet pet = new Pet("Fritz", "Mausi", 2);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
