package contacts;

import java.io.Serializable;
import java.time.LocalDate;

public class ContactOfPerson extends Contact implements Serializable {
    private String surname;
    private String gender;
    private LocalDate birthDate;

    ContactOfPerson(Contacts contacts) {
        super(contacts);
    }

    @Override
    void print() {
        String birth = birthDate == null ?
                "[no data]" : birthDate.toString();

        System.out.printf("Name: %s\n" +
                        "Surname: %s\n" +
                        "Birth date: %s\n" +
                        "Gender: %s\n" +
                        "Number: %s\n" +
                        "Time created: %s\n" +
                        "Time last edit: %s\n",
                getName(), surname, birth, gender,
                getNumber(), getTimeAdded(), getTimeEdited());
    }

    @Override
    void setField() {
        System.out.println("Select a field (name, address, number): ");
        String field = contacts.scanner.nextLine();
        switch (field) {
            case "name":
                System.out.print("Enter the name: ");
                setName(contacts.scanner.nextLine());
                break;
            case "surname":
                System.out.print("Enter the surname: ");
                surname = contacts.scanner.nextLine();
                break;
            case "number":
                System.out.print("Enter the number: ");
                setNumber(hasNumber(contacts.scanner.nextLine()));
                break;
            case "gender":
                System.out.print("Enter the gender (M, F): ");
                gender(contacts.scanner.nextLine());
                break;
            case "birth":
                System.out.print("Enter the birth date: ");
                validateBirthDate(contacts.scanner.nextLine());
        }
        setTimeEdited();
    }

    @Override
    void add() {
        System.out.print("Enter the name: ");
        setName(contacts.scanner.next());

        System.out.print("Enter the surname: ");
        this.surname = contacts.scanner.next();

        System.out.print("Enter the birth date: ");
        contacts.scanner.nextLine();
        validateBirthDate(contacts.scanner.nextLine());

        System.out.print("Enter the gender (M, F): ");
        gender(contacts.scanner.nextLine());

        System.out.print("Enter the number: ");
        setNumber(hasNumber(contacts.scanner.nextLine()));

        setTimeAdded();

        contacts.contacts.add(this);
    }

    public void gender(String line){
        if (line.equals("M")){
            this.gender = line;
        } else if(line.equals("F")){
            this.gender = line;
        } else{
            System.out.println("Bad gender!");
            this.gender = "[no data]";
        }
    }

    public void validateBirthDate(String date){
        try {
            LocalDate.parse(date);
            this.birthDate = LocalDate.parse(date);
        } catch (Exception e) {
            System.out.println("Bad birth date!");
        }
    }

    public String fullName(){
        return getName() + " " + surname;
    }
}
