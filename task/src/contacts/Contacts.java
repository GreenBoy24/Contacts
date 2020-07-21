package contacts;

import java.io.*;
import java.util.*;

public class Contacts implements Serializable {

    List<Contact> contacts = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    private void serialize() {
        try {
            List<Contact> list = contacts;
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data.txt"));
            out.writeObject(list);
            out.close();
        } catch (IOException e) {
            System.exit(-1);
        }
    }

    private void deserialize() {
        try {
            FileInputStream file = new FileInputStream("data.txt");
            ObjectInputStream in = new ObjectInputStream(file);
            contacts = (List<Contact>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Contacts file is not found");
        } catch (ClassCastException e) {
            System.out.println("Contacts file is corrupted.");
        }
    }

    void start() {

        File file = new File("data.txt");
        if(file.exists() && !file.isDirectory()) {
            deserialize();
            System.out.println("open phonebook.db");
        }
        Command command;
        String choice;

        menu:
        while (true) {
            System.out.print("[menu] Enter action (add, list, search, count, exit): ");
            choice = scanner.nextLine();
            switch (choice) {
                case "add":
                    command = new AddContactCommand(this);
                    command.execute();
                    break;
                case "list":
                    command = new ListCommand(this);
                    command.execute();
                    break;
                case "search":
                    command = new SearchCommand(this);
                    command.execute();
                    break;
                case "count":
                    System.out.printf("The phone book has %s records.\n",
                            contacts.size());
                    break;
                case "exit":
                    break menu;
                default:
                    System.out.println("Wrong action.");
                    break;
            }
        }
        serialize();
    }
}
