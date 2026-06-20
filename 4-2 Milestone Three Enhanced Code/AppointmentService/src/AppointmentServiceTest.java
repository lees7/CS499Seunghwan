import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

public class AppointmentServiceTest {
    private AppointmentService service;

    @BeforeEach
    public void setup() {
        service = new AppointmentService();
    }

    @Test
    public void testAddAppointmentWithUniqueID() {
        Appointment appointment = new Appointment("A123", new Date(), "Checkup");
        assertDoesNotThrow(() -> service.addAppointment(appointment));
        assertEquals(1, service.getAllAppointments().size());
        assertTrue(service.getAllAppointments().containsKey("A123"));
    }

    @Test
    public void testAddAppointmentWithDuplicateIDFails() {
        Appointment appointment1 = new Appointment("A123", new Date(), "Checkup");
        Appointment appointment2 = new Appointment("A123", new Date(), "Dental Cleaning");
        service.addAppointment(appointment1);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> service.addAppointment(appointment2));
        assertEquals("Appointment ID already exists.", exception.getMessage());
    }

    @Test
    public void testDeleteAppointment() {
        Appointment appointment = new Appointment("A123", new Date(), "Checkup");
        service.addAppointment(appointment);
        assertDoesNotThrow(() -> service.deleteAppointment("A123"));
        assertEquals(0, service.getAllAppointments().size());
    }

    @Test
    public void testDeleteNonExistentAppointment() {
        assertThrows(IllegalArgumentException.class, () -> service.deleteAppointment("NonExistentID"));
    }
}
