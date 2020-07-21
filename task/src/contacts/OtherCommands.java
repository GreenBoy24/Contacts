package contacts;

class OtherCommands {
    public Contacts contacts;

    OtherCommands(Contacts contacts){
        this.contacts = contacts;
    }

    public void remove(int record) {
        contacts.contacts.remove(record);
        System.out.println("The record removed!\n");
    }

    public void edit(int record){
        contacts.contacts.get(record-1).setField();
        System.out.println("Saved\n");
        contacts.contacts.get(record-1).print();
    }

    public void recordOperations(int record){
        contacts.contacts.get(record-1).print();
        System.out.println();
        System.out.print("[record] Enter action (edit, delete, menu): ");
        String action;
        recordMenu:
        {
            while (true) {
                action = contacts.scanner.nextLine();
                switch (action) {
                    case "edit":
                        edit(record);
                        break;
                    case "delete":
                        remove(record);
                        break;
                    case "menu":
                        break recordMenu;
                    default:
                        System.out.println("Wrong action");
                        break;
                }
            }
        }
    }
}
