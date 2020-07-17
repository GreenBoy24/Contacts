package contacts;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Contact> contacts = new ArrayList<>();

    public static void main(String[] args) {
        menu();
    }

    public static void menu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter action (add, remove, edit, count, list, exit):");
        String choice = scanner.nextLine();
        switch (choice){
            case "add":
                add();
                break;
            case "remove":
                remote();
                break;
            case "edit":
                edit();
                break;
            case "count":
                count();
                break;
            case "list":
                list();
                break;
            case "exit":
                exit();
                break;
            default:
                System.out.println("Wrong choice");
        }
    }

    public static void add(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name:");
        String name = scanner.nextLine();
        System.out.println("Enter the surname:");
        String surName = scanner.nextLine();
        System.out.println("Enter the number:");
        String number = scanner.nextLine();
        System.out.println("The record added.");
        contacts.add(new Contact(name,surName,Contact.hasNumber(number)));
        menu();
    }

    public static void remote(){
        Scanner scanner = new Scanner(System.in);
        if(!contacts.isEmpty()){
            for (int i = 0; i < contacts.size(); i++) {
                System.out.println(i + 1 + ". " + contacts.get(i).toString());
            }
            System.out.println("Select a record:");
            int record = Integer.parseInt(scanner.nextLine());
            contacts.remove(record-1);
            System.out.println("The record removed!");
        } else{
            System.out.println("No records to remove!");
        }
        menu();
    }

    public static void edit(){
        Scanner scanner = new Scanner(System.in);
        if(!contacts.isEmpty()){
            for (int i = 0; i < contacts.size(); i++) {
                System.out.println(i + 1 +". " + contacts.get(i).toString());
            }
            System.out.println("Select a record:");
            int record = Integer.parseInt(scanner.nextLine());
            System.out.println("Select a field (name, surname, number):");
            String field = scanner.nextLine();
            if(field.equals("name")){
                System.out.println("Enter name:");
                String name = scanner.nextLine();
                contacts.get(record-1).setName(name);
            }
            if(field.equals("surname")){
                System.out.println("Enter surname:");
                String surname = scanner.nextLine();
                contacts.get(record-1).setSurname(surname);
            }
            if(field.equals("number")){
                System.out.println("Enter number:");
                String number = scanner.nextLine();
                contacts.get(record-1).setNumber(Contact.hasNumber(number));
            }
            System.out.println("The record updated!");
        } else{
            System.out.println("No records to edit!");
        }
        menu();
    }

    public static void count(){
        System.out.println(contacts.size() + " records");
        menu();
    }

    public static void list(){
        if(!contacts.isEmpty()){
            for (int i = 0; i < contacts.size(); i++) {
                System.out.println(i + 1 + ". "+ contacts.get(i).toString());
            }
        } else{
            System.out.println("No records!");
        }
        menu();
    }

    public static void exit(){
        System.out.println();
    }
}
