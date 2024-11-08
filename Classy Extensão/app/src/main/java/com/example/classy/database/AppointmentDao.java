import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@Dao
public interface AppointmentDao {
    @Insert
    void insert(Appointment appointment);

    @Query("SELECT * FROM Appointment WHERE date = :date")
    List<Appointment> getAppointmentsByDate(String date);
}
