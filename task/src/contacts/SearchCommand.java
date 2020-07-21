package contacts;

import java.util.ArrayList;
import java.util.regex.*;

public class SearchCommand extends OtherCommands implements Command {
    private ArrayList<String> resultSearch = new ArrayList<>();

    SearchCommand(Contacts contacts) {
        super(contacts);
    }

    @Override
    public void execute() {
        searchFullName();
        System.out.print("[search] Enter action ([number], back, again): ");
        String action = contacts.scanner.nextLine();
        if(action.equals("again")){
            searchFullName();
        } else{
            try{
                int record = Integer.parseInt(action);
                for (int i = 0; i < contacts.contacts.size(); i++) {
                    if(resultSearch.get(record).equals(contacts.contacts.get(record).fullName())){
                        record = i;
                    }
                }
                recordOperations(record);

            } catch (Exception e){
                System.out.println("Wrong format.");
            }
        }
    }

    private void searchFullName() {
        System.out.println("Enter search query:");
        String query = contacts.scanner.nextLine();
        String line = "\\b[A-Za-z]*" + query + "[A-Za-z]*\\b";
        Pattern pattern = Pattern.compile(line, Pattern.CASE_INSENSITIVE);
        for (int i = 0; i < contacts.contacts.size(); i++) {
            Matcher matcher = pattern.matcher(contacts.contacts.get(i).fullName());
            while (matcher.find()){
                resultSearch.add(contacts.contacts.get(i).fullName());
            }
        }
        searchNumber(query);
        System.out.println("Found " + resultSearch.size() + " results");
        for (int i = 0; i < resultSearch.size() ; i++) {
            System.out.println(i + 1 + " " + resultSearch.get(i));
        }
    }

    private void searchNumber(String query){
        Pattern pattern = Pattern.compile(query, Pattern.CASE_INSENSITIVE);
        for (int i = 0; i < contacts.contacts.size(); i++) {
            Matcher matcher = pattern.matcher(contacts.contacts.get(i).getNumber());
            while (matcher.find()){
                resultSearch.add(contacts.contacts.get(i).fullName());
            }
        }
    }
}
