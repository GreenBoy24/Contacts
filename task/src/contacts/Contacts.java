package contacts;

public class Contacts {

    void start() {
        File f = new File("MyData.ser");
        if(f.exists() && !f.isDirectory()) {
            deserialize();
            System.out.println("open phonebook.db");
        }

        Command command;
        String choice;

        contacts:
        while (true) {
            System.out.print("[menu] Enter action (add, list, search, count, exit): ");
            choice = scanner.next();
            switch (choice) {
                case "add":
                    command = new AddContactCommand(this);
                    command.execute();
                    break;
                case "list":
                    new ListCommand(this).execute();
                    break;
                case "count":
                    System.out.printf("The phone book has %s records.\n",
                            contacts.size());
                    break;
                case "search":
                    new SearchCommand(this).execute();
                    break;
                case "exit":
                    break contacts;
            }
        }

    }
