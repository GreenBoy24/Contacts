package contacts;

import java.util.Scanner;

public class OtherCommands implements Command{
    private Contacts contacts;
    private int choice;

    public int getChoice() {
        return choice;
    }

    public void setChoice(int choice) {
        this.choice = choice;
    }

    OtherCommands(Contacts contacts, int  choice){
        this.contacts = contacts;
        this.choice = choice;
    }

    @Override
    public void execute() {
        if(getChoice() == 1) {
            remove();
        }
        if(getChoice() == 2){
            edit();
        }
        if(getChoice() == 3) {
            info();
        }
    }

    private void remove() {
        Scanner scanner = new Scanner(System.in);
        if(!contacts.contacts.isEmpty()){
            for (int i = 0; i < contacts.contacts.size(); i++) {
                System.out.println(i + 1 + ". " + contacts.contacts.get(i).fullName());
            }
            System.out.println("Select a record:");
            int record = Integer.parseInt(scanner.nextLine());
            contacts.contacts.remove(record-1);
            System.out.println("The record removed!");
            System.out.println();
        } else{
            System.out.println("No records to remove!");
        }
    }

    private void edit(){
        Scanner scanner = new Scanner(System.in);
        if(!contacts.contacts.isEmpty()){
            for (int i = 0; i < contacts.contacts.size(); i++) {
                System.out.println(i + 1 + ". " + contacts.contacts.get(i).fullName());
            }
            System.out.print("Select a record:");
            int record = Integer.parseInt(scanner.nextLine());
            System.out.println("Select a field (name, surname, birth, gender, number):");
            String field = scanner.nextLine();
            contacts.contacts.get(record-1).setField(field);
            System.out.println("The record updated!");
            System.out.println();
        } else{
            System.out.println("No records to edit!");
        }
    }

    private void info(){
        Scanner scanner = new Scanner(System.in);
        if(!contacts.contacts.isEmpty()){
            for (int i = 0; i < contacts.contacts.size(); i++) {
                System.out.println(i + 1 + ". " + contacts.contacts.get(i).fullName());
            }
            System.out.print("Enter index to show info:");
            int record = Integer.parseInt(scanner.nextLine());
            contacts.contacts.get(record-1).print();
            System.out.println();
        } else{
            System.out.println("No records.");
        }
    }
}
