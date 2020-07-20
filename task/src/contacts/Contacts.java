package contacts;

import java.util.*;

public class Contacts {

    List<Contact> contacts = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    void start() {
        Command command;
        String choice;

        contacts:
        while (true) {
            System.out.println();
            System.out.print("Enter action (add, remove, edit, count, info, exit): ");
            choice = scanner.nextLine();
            switch (choice) {
                case "add":
                    command = new AddContactCommand(this);
                    command.execute();
                    break;
                case "remove":
                    command = new OtherCommands(this,1);
                    command.execute();
                    break;
                case "edit":
                    command = new OtherCommands(this,2);
                    command.execute();
                    break;
                case "count":
                    System.out.printf("The phone book has %s records.\n",
                            contacts.size());
                    break;
                case "info":
                    command = new OtherCommands(this,3);
                    command.execute();
                    break;
                case "exit":
                    break contacts;
            }
        }
    }
}
