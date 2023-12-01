import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {

    private Map<String, List<String>> contacts;

    public PhoneBook() {
        this.contacts = new HashMap<>();
    }

    public void add(String name, String surname, String middleName, String phoneNumber) {

        String fullName = name + " " + surname + " " + middleName;
        contacts.computeIfAbsent(fullName, i -> new ArrayList<>()).add(phoneNumber);
    }

    public List<String> find(String name, String surname, String middleName) {

        String fullName = name + " " + surname + " " + middleName;
        return contacts.getOrDefault(fullName, new ArrayList<>());
    }

    public boolean containsPhoneNumber(String phoneNumber) {
        return contacts
                .values()
                .stream()
                .anyMatch(phoneNumbers -> phoneNumbers.contains(phoneNumber));
    }
}