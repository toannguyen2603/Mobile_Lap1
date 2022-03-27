package uit.lap1.bt2_18521507;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Date;
public class TimeActivity extends AppCompatActivity {
    Button btnSeeTime;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.time_activity);
//    get layout
        btnSeeTime = findViewById(R.id.btnSeeTime);
        btnSeeTime.setOnClickListener((View view) -> CurrentTime());
    }
//    function event show current time
    private void CurrentTime(){
        final AlertDialog alert = new AlertDialog.Builder(this).create();
        Date time = new Date();
        String message = "Current time : " + time;
        alert.setMessage(message);
        alert.show();
    }
}
