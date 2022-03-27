package uit.lap1.bt2_18521507;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class CallActivity extends AppCompatActivity {

    private static final int REQUEST_CALL = 1;
    private EditText mainEditNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.call_activity);

        mainEditNumber = findViewById(R.id.editTextPhone);

        ImageView imageCall = findViewById(R.id.image_call);

        imageCall.setOnClickListener((View view)-> callPhone());
    }

    private void callPhone(){
//        get number type string
        String number = mainEditNumber.getText().toString();
//        check number in Edittext
        if(number.trim().length() > 0) {
            if(ContextCompat.checkSelfPermission(CallActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
            {
                ActivityCompat.requestPermissions(CallActivity.this, new String[]{Manifest.permission.CALL_PHONE }, REQUEST_CALL);
            } else {
                String detail = "tel:" + number;
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(detail));
                startActivity(intent);
            }
        } else {
            Toast.makeText(CallActivity.this, "Enter phone number", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CALL) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                callPhone();
            } else {
                Toast.makeText(this, "Permission DENIED", Toast.LENGTH_SHORT).show();
            }
        }
    }

}