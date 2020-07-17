package contacts;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Contact {

    private String name;
    private String surname;
    private String number;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Contact(String name, String surname, String number) {
        this.name = name;
        this.surname = surname;
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
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

    @Override
    public String toString() {
        return name + " " + surname + ", " + number;
    }
}
