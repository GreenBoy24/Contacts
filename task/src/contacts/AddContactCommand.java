package contacts;

public class AddContactCommand implements Command {
    private Contacts contacts;

    AddContactCommand(Contacts contacts){
        this.contacts = contacts;
    }

    @Override
    public void execute() {
        System.out.print("Enter the type (person, organization): ");
        String type = contacts.scanner.next();

        if (type.equals("person")) {
            ContactOfPerson person = new ContactOfPerson(contacts);
            person.add();
        } else if (type.equals("organization")){
            ContactOfOrganization organization = new ContactOfOrganization(contacts);
            organization.add();
        }

        System.out.println("The record added.\n");
    }
}
