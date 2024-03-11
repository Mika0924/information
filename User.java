import java.util.Scanner;

public class User {
    private String lastName;
    private String firstName;
    private String fathername;
    private String birthDate;
    private Integer phone;
    private String gender;
    public User(String lastName,  String firstName,String fathername, String birthDate, Integer phone, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.fathername = fathername;
        this.birthDate = birthDate;
        this.gender = gender;
    }
    void creteUser(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ФИО, дату рождения, номер телефона и пол (через пробел):");
        String input = scanner.nextLine();

    }
}