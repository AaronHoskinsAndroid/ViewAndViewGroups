package examples.aaronhoskins.com.viewandviewgroups;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ImplicitActivity extends AppCompatActivity {
    public static final int RESULT_CODE = 125;
    EditText etFirstName;
    EditText etLastName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit);

        etFirstName = findViewById(R.id.etFirstName);
        etLastName = findViewById(R.id.etLastName);
    }

    public void onSendDataPressed(View view) {
        final String firstName = etFirstName.getText().toString();
        final String lastName = etLastName.getText().toString();

        Intent intent = new Intent();
        intent.putExtra("first_name", firstName);
        intent.putExtra("last_name", lastName);
        setResult(RESULT_CODE, intent);
        finish();
    }
}
