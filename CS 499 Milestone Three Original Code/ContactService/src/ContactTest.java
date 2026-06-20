import org.junit.Test;
import static org.junit.Assert.*;

public class ContactTest {

    @Test
    public void testContactCreation() {
        Contact contact = new Contact("ID12345678", "John", "Doe", "1234567890", "123 Main St");
        assertNotNull(contact);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidContactId() {
        new Contact(null, "Jane", "Doe", "0123456789", "456 Elm St");
    }

    // Additional tests can be added here...
}
