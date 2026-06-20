import java.util.*;
import java.util.stream.Collectors;

public class AppointmentService {

    private final Map<String, Appointment> appointments;

    public AppointmentService() {
        this.appointments = new HashMap<>();
    }

    // Add appointment
    public void addAppointment(Appointment appointment) {
        if (appointment == null) {
            throw new IllegalArgumentException("Appointment cannot be null.");
        }

        if (appointments.containsKey(appointment.getAppointmentId())) {
            throw new IllegalArgumentException("Appointment ID already exists.");
        }

        appointments.put(appointment.getAppointmentId(), appointment);
    }

    // Delete appointment
    public void deleteAppointment(String appointmentId) {
        if (!appointments.containsKey(appointmentId)) {
            throw new IllegalArgumentException("Appointment ID does not exist.");
        }

        appointments.remove(appointmentId);
    }

    // Retrieve appointment by ID
    public Appointment getAppointment(String appointmentId) {

        Appointment appointment = appointments.get(appointmentId);

        if (appointment == null) {
            throw new IllegalArgumentException("Appointment ID does not exist.");
        }

        return appointment;
    }

    // Update description
    public void updateDescription(String appointmentId, String description) {

        Appointment appointment = getAppointment(appointmentId);

        appointment.setDescription(description);
    }

    // Update date
    public void updateAppointmentDate(String appointmentId, Date date) {

        Appointment appointment = getAppointment(appointmentId);

        appointment.setAppointmentDate(date);
    }

    // Search by keyword in description
    public List<Appointment> searchByDescription(String keyword) {

        List<Appointment> results = new ArrayList<>();

        for (Appointment appointment : appointments.values()) {

            if (appointment.getDescription()
                    .toLowerCase()
                    .contains(keyword.toLowerCase())) {

                results.add(appointment);
            }
        }

        return results;
    }

    // Filter appointments within date range
    public List<Appointment> getAppointmentsBetweenDates(
            Date startDate,
            Date endDate) {

        List<Appointment> results = new ArrayList<>();

        for (Appointment appointment : appointments.values()) {

            Date appointmentDate = appointment.getAppointmentDate();

            if (!appointmentDate.before(startDate)
                    && !appointmentDate.after(endDate)) {

                results.add(appointment);
            }
        }

        return results;
    }

    // Sort appointments by date ascending
    public List<Appointment> getAppointmentsSortedByDate() {

        List<Appointment> sortedAppointments =
                new ArrayList<>(appointments.values());

        sortedAppointments.sort(
                Comparator.comparing(Appointment::getAppointmentDate));

        return sortedAppointments;
    }

    // Sort appointments by description
    public List<Appointment> getAppointmentsSortedByDescription() {

        List<Appointment> sortedAppointments =
                new ArrayList<>(appointments.values());

        sortedAppointments.sort(
                Comparator.comparing(Appointment::getDescription));

        return sortedAppointments;
    }

    // Count appointments
    public int getAppointmentCount() {
        return appointments.size();
    }

    // Return copy of all appointments
    public Map<String, Appointment> getAllAppointments() {
        return new HashMap<>(appointments);
    }
}