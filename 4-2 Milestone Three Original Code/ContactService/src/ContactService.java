import java.util.HashMap;
import java.util.Map;

public class ContactService {
    private final Map<String, Contact> contacts = new HashMap<>();

    // Method to add a new contact
    public void addContact(String contactId, String firstName, String lastName, String phone, String address) {
        if (contactId == null || contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID must be unique and not null");
        }
        Contact newContact = new Contact(contactId, firstName, lastName, phone, address);
        contacts.put(contactId, newContact);
    }

    // Method to delete a contact
    public void deleteContact(String contactId) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID does not exist");
        }
        contacts.remove(contactId);
    }

    // Method to update contact fields
    public void updateContact(String contactId, String firstName, String lastName, String phone, String address) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID does not exist");
        }
        Contact contactToUpdate = contacts.get(contactId);
        if (firstName != null && !firstName.isEmpty()) {
            contactToUpdate.setFirstName(firstName);
        }
        if (lastName != null && !lastName.isEmpty()) {
            contactToUpdate.setLastName(lastName);
        }
        if (phone != null && !phone.isEmpty()) {
            contactToUpdate.setPhone(phone);
        }
        if (address != null && !address.isEmpty()) {
            contactToUpdate.setAddress(address);
        }
    }
}
