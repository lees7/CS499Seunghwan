import org.junit.jupiter.api.Test;
import java.util.Calendar;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class AppointmentTest {

    @Test
    public void testAppointmentIDNotNullOrEmpty() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Appointment(null, new Date(), "Description"));
        assertEquals("Invalid appointment ID.", exception.getMessage());
    }

    @Test
    public void testAppointmentIdLength() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Appointment("12345678901", new Date(), "Description"));
        assertEquals("Invalid appointment ID.", exception.getMessage());
    }

    @Test
    public void testAppointmentDateNotNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Appointment("12345", null, "Description"));
        assertEquals("Appointment date must be in the future.", exception.getMessage());
    }

    @Test
    public void testAppointmentDateNotInPast() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1); // Set to yesterday
        Date pastDate = calendar.getTime();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Appointment("12345", pastDate, "Description"));
        assertEquals("Appointment date must be in the future.", exception.getMessage());
    }

    @Test
    public void testDescriptionNotNullOrEmpty() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Appointment("12345", new Date(), null));
        assertEquals("Description is invalid.", exception.getMessage());
    }

    @Test
    public void testDescriptionLength() {
        char[] chars = new char[51];
        java.util.Arrays.fill(chars, 'a');
        String longDescription = new String(chars);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Appointment("12345", new Date(), longDescription));
        assertEquals("Description is invalid.", exception.getMessage());
    }

    @Test
    public void testAppointmentCreationSuccess() {
        assertDoesNotThrow(() -> new Appointment("12345", new Date(), "Valid Description"));
    }
}
