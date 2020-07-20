package contacts;

import java.time.LocalDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract class Contact {
    private String name;
    private String number;
    private LocalDateTime timeAdded;
    private LocalDateTime timeEdited;
    Contacts contacts;

    Contact(Contacts contacts){
        this.contacts = contacts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    void setTimeAdded() {
        timeAdded = LocalDateTime.now();
        timeEdited = LocalDateTime.now();
    }

    void setTimeEdited() {
        timeEdited = LocalDateTime.now();
    }

    LocalDateTime getTimeAdded() {
        return timeAdded;
    }

    LocalDateTime getTimeEdited() {
        return timeEdited;
    }

    public static String hasNumber(String number){
        String trueNumber;
        Pattern pattern = Pattern.compile("^\\+?([\\da-zA-Z]{1,}[\\s-]?)?(\\([\\da-zA-Z]{2,}(\\)[\\s-]|\\)$))?([\\da-zA-Z]{2,}[\\s-]?)*([\\da-zA-Z]{2,})?$");
        Matcher matcher = pattern.matcher(number);
        if(matcher.matches()){
            trueNumber = number;
        } else{
            System.out.println("Wrong number format!");
            trueNumber = "[no number]";
        }
        return trueNumber;
    }

    abstract void add();
    abstract void print();
    abstract String fullName();
    abstract void setField(String field);
}
