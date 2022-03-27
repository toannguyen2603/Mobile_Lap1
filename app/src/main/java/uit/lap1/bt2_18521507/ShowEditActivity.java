package uit.lap1.bt2_18521507;

import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class ShowEditActivity extends AppCompatActivity {
    EditText editTextShow;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_edit);
//        get layout
        editTextShow = findViewById(R.id.editTextShow);
//        create object alert dialog
        final AlertDialog alert = new AlertDialog.Builder(this).create();
//        get an event when press enter on keyboard & show string text in screen
        editTextShow.setOnKeyListener((v, keyCode, event) -> {
            if (keyCode == KeyEvent.KEYCODE_ENTER) {
                String message = editTextShow.getText().toString();
                alert.setMessage(message);
                alert.show();
                return true;
            }
            return false;
        });
    }
}
