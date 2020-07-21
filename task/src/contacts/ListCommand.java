package contacts;

public class ListCommand extends OtherCommands implements Command{

    ListCommand(Contacts contacts){
        super(contacts);
    }

    @Override
    public void execute() {
        for (int i = 0; i < contacts.contacts.size(); i++) {
            System.out.println(i + 1 + ". " + contacts.contacts.get(i).fullName());
            System.out.println();
        }
        System.out.print("[list] Enter action ([number], back): ");
        String action = contacts.scanner.nextLine();
        if(action.equals("back")){
            return;
        } else{
            try{
                int record = Integer.parseInt(action);
                recordOperations(record);

            } catch (Exception e){
                System.out.println("Wrong format.");
            }
        }
    }
}
