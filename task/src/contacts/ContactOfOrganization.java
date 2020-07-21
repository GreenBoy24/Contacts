package contacts;

import java.io.Serializable;

public class ContactOfOrganization extends Contact implements Serializable {
    private String address;

    ContactOfOrganization(Contacts contacts) {
        super(contacts);
    }

    @Override
    void add() {
        System.out.print("Enter the organization name: ");
        contacts.scanner.nextLine();
        setName(contacts.scanner.nextLine());
        System.out.print("Enter the address: ");
        this.address = contacts.scanner.nextLine();
        System.out.print("Enter the number: ");
        setNumber(hasNumber(contacts.scanner.nextLine()));

        setTimeAdded();

        contacts.contacts.add(this);
    }

    @Override
    void print() {
        System.out.printf("Organization name: %s\n" +
                        "Address: %s\n" +
                        "Number: %s\n" +
                        "Time created: %s\n" +
                        "Time last edit: %s\n",
                getName(), address, getNumber(),
                getTimeAdded(), getTimeEdited());
    }

    @Override
    void setField() {
        System.out.println("Select a field (name, address, number): ");
        String field = contacts.scanner.nextLine();
        switch (field) {
            case "name":
                System.out.println("Enter name: ");
                setName(contacts.scanner.nextLine());
                break;
            case "address":
                System.out.println("Enter the address: ");
                address = contacts.scanner.nextLine();
                break;
            case "number":
                System.out.println("Enter the number: ");
                setNumber(hasNumber(contacts.scanner.nextLine()));
                break;
        }

        setTimeEdited();
    }

    public String fullName(){
        return getName();
    }
}
