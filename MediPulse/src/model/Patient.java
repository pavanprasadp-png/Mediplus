package model;

public class Patient extends Person {
    private final int id;
    private final int age;
    private final String gender;
    private final String disease;

    public Patient(int id, String name, int age, String gender, String phone, String disease) {
        super(name, phone);
        this.id = id; this.age = age;
        this.gender = gender; this.disease = disease;
    }
    public int getId() { return id; }
    public int getAge() { return age; }
    public String getGender() { return gender; }
    public String getDisease() { return disease; }

    @Override
    public void displayInfo() {
        System.out.printf("%-5d %-20s %-5d %-8s %-12s %-15s%n",
            id, getName(), age, gender, getPhone(), disease);
    }
}