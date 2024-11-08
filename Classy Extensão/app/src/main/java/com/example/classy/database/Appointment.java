import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Appointment {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String clientName;
    private String appointmentType;
    private String date;
    private String time;
    private String notes;

    // Getters e setters
    // ...
}
