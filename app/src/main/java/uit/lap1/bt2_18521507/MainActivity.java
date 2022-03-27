package uit.lap1.bt2_18521507;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    Button btnPhone, btnTime, btnAlert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //        Call layout
        btnPhone = findViewById(R.id.btnCall);
        btnTime = findViewById(R.id.btnTime);
        btnAlert = findViewById(R.id.btnAlert);

        btnPhone.setOnClickListener((View view) -> CallPhone());
        btnTime.setOnClickListener((View view) -> CurrentTime());
        btnAlert.setOnClickListener((View view) -> ShowEditText());
    }
    private void CallPhone(){
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, CallActivity.class);
        startActivity(intent);
    }
    private void CurrentTime(){
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, TimeActivity.class);
        startActivity(intent);
    }
    private void ShowEditText(){
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, ShowEditActivity.class);
        startActivity(intent);
    }

}