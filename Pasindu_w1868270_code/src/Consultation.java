import java.util.ArrayList;
import java.util.Date;
public class Consultation extends Patient {
    private double cost;
    private String note;
    private Doctor doctor;
    private Date bookDateTime;
    // array list to store all the consultation details.
    static ArrayList<Consultation> bookings = new ArrayList<>();

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Date getBookDateTime() {
        return bookDateTime;
    }

    public void setBookDateTime(Date bookDateTime) {
        this.bookDateTime = bookDateTime;
    }
}
