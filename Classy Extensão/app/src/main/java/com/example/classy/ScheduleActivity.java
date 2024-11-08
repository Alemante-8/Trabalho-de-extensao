import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

public class ScheduleActivity extends AppCompatActivity {

    private EditText editClientName, editAppointmentType, editTime, editNotes;
    private Button btnSaveAppointment;
    private AppDatabase db;
    private String selectedDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "appointments_db")
                .allowMainThreadQueries()
                .build();

        editClientName = findViewById(R.id.editClientName);
        editAppointmentType = findViewById(R.id.editAppointmentType);
        editTime = findViewById(R.id.editTime);
        editNotes = findViewById(R.id.editNotes);
        btnSaveAppointment = findViewById(R.id.btnSaveAppointment);

        selectedDate = getIntent().getStringExtra("selectedDate");

        btnSaveAppointment.setOnClickListener(v -> {
            String clientName = editClientName.getText().toString();
            String appointmentType = editAppointmentType.getText().toString();
            String time = editTime.getText().toString();
            String notes = editNotes.getText().toString();

            Appointment appointment = new Appointment();
            appointment.setClientName(clientName);
            appointment.setAppointmentType(appointmentType);
            appointment.setDate(selectedDate);
            appointment.setTime(time);
            appointment.setNotes(notes);

            db.appointmentDao().insert(appointment);

            Toast.makeText(this, "Consulta agendada!", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}
