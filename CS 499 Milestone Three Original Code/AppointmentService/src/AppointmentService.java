import java.util.HashMap;
import java.util.Map;

public class AppointmentService {
    private final Map<String, Appointment> appointments;

    public AppointmentService() {
        this.appointments = new HashMap<>();
    }

    // Method to add an appointment. Throws IllegalArgumentException if the ID already exists.
    public void addAppointment(Appointment appointment) throws IllegalArgumentException {
        if (appointments.containsKey(appointment
                .getAppointmentId())) {
            throw new IllegalArgumentException("Appointment ID already exists.");
        }
        appointments.put(appointment.getAppointmentId(), appointment);
    }

    // Method to delete an appointment by ID. Throws IllegalArgumentException if the ID does not exist.
    public void deleteAppointment(String appointmentId) throws IllegalArgumentException {
        if (!appointments.containsKey(appointmentId)) {
            throw new IllegalArgumentException("Appointment ID does not exist.");
        }
        appointments.remove(appointmentId);
    }

    // Optional: Method to retrieve all appointments (useful for testing)
    public Map<String, Appointment> getAllAppointments() {
        return new HashMap<>(appointments);
    }
}

