import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ContactServiceTest {
    private ContactService service;

    @Before
    public void setUp() {
        service = new ContactService();
    }

    @Test
    public void testAddContact() {
        service.addContact("ID123", "John", "Doe", "1234567890", "123 Main St");
        assertNotNull(service);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddContactWithDuplicateId() {
        service.addContact("ID123", "Jane", "Doe", "9876543210", "456 Elm St");
        service.addContact("ID123", "John", "Doe", "1234567890", "123 Main St");
    }

    @Test
    public void testDeleteContact() {
        service.addContact("ID123", "John", "Doe", "1234567890", "123 Main St");
        service.deleteContact("ID123");
        // Additional logic to verify the contact was deleted
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDeleteNonexistentContact() {
        service.deleteContact("NonexistentID");
    }

    @Test
    public void testUpdateContact() {
        service.addContact("ID123", "John", "Doe", "1234567890", "123 Main St");
        service.updateContact("ID123", "Johnny", "Doe", "0987654321", "321 Elm St");
        // Additional logic to verify the contact was updated
    }

    // Additional tests can be added here...
}
