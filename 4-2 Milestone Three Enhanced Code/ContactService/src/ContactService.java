import java.util.*;

public class ContactService {

    private final Map<String, Contact> contacts;

    public ContactService() {
        contacts = new HashMap<>();
    }

    // Add contact
    public void addContact(String contactId,
                           String firstName,
                           String lastName,
                           String phone,
                           String address) {

        if (contactId == null || contacts.containsKey(contactId)) {
            throw new IllegalArgumentException(
                    "Contact ID must be unique and not null");
        }

        Contact newContact =
                new Contact(contactId,
                        firstName,
                        lastName,
                        phone,
                        address);

        contacts.put(contactId, newContact);
    }

    // Delete contact
    public void deleteContact(String contactId) {

        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException(
                    "Contact ID does not exist");
        }

        contacts.remove(contactId);
    }

    // Retrieve contact
    public Contact getContact(String contactId) {

        Contact contact = contacts.get(contactId);

        if (contact == null) {
            throw new IllegalArgumentException(
                    "Contact ID does not exist");
        }

        return contact;
    }

    // Update contact
    public void updateContact(String contactId,
                              String firstName,
                              String lastName,
                              String phone,
                              String address) {

        Contact contactToUpdate = getContact(contactId);

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

    // Search by first name
    public List<Contact> searchByFirstName(String firstName) {

        List<Contact> results = new ArrayList<>();

        for (Contact contact : contacts.values()) {

            if (contact.getFirstName()
                    .equalsIgnoreCase(firstName)) {

                results.add(contact);
            }
        }

        return results;
    }

    // Search by last name
    public List<Contact> searchByLastName(String lastName) {

        List<Contact> results = new ArrayList<>();

        for (Contact contact : contacts.values()) {

            if (contact.getLastName()
                    .equalsIgnoreCase(lastName)) {

                results.add(contact);
            }
        }

        return results;
    }

    // Search by phone
    public Contact searchByPhone(String phone) {

        for (Contact contact : contacts.values()) {

            if (contact.getPhone().equals(phone)) {
                return contact;
            }
        }

        return null;
    }

    // Filter by area code
    public List<Contact> filterByAreaCode(String areaCode) {

        List<Contact> results = new ArrayList<>();

        for (Contact contact : contacts.values()) {

            if (contact.getPhone().startsWith(areaCode)) {
                results.add(contact);
            }
        }

        return results;
    }

    // Sort by first name
    public List<Contact> getContactsSortedByFirstName() {

        List<Contact> sorted =
                new ArrayList<>(contacts.values());

        sorted.sort(
                Comparator.comparing(Contact::getFirstName));

        return sorted;
    }

    // Sort by last name
    public List<Contact> getContactsSortedByLastName() {

        List<Contact> sorted =
                new ArrayList<>(contacts.values());

        sorted.sort(
                Comparator.comparing(Contact::getLastName));

        return sorted;
    }

    // Count contacts
    public int getContactCount() {
        return contacts.size();
    }

    // Return all contacts
    public Map<String, Contact> getAllContacts() {
        return new HashMap<>(contacts);
    }
}