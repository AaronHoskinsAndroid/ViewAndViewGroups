package examples.aaronhoskins.com.viewandviewgroups;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "TAG_MAIN_ACT";
    private TextView tvDisplay;
    private EditText etInput;
    private EditText etUserInputThree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDisplay = findViewById(R.id.tvUserDisplay);
        etInput = findViewById(R.id.etUserInput);
        etUserInputThree = findViewById(R.id.etUserInputThree);
        //logd
        Log.d(TAG, "onCreate: ");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    public void buttonClicked(View view) {

        switch (view.getId()) {
            case R.id.btnDoSomething:
                final String input = etInput.getText().toString();
                if(etUserInputThree == null) {
                    tvDisplay.setText(input);
                } else {
                    final String input3 = etUserInputThree.getText().toString();
                    tvDisplay.setText(input + " " + input3);
                }

                Log.d("TAG_CLICKED", String.format(Locale.US,"User entered %s", input));
                break;
            case R.id.tvUserDisplay:
                Toast.makeText(this, tvDisplay.getText(), Toast.LENGTH_LONG).show();
                break;

            case R.id.btnGotoSecondActivity:
                Intent explicitIntent = new Intent(this, SecondActivity.class);
                startActivity(explicitIntent);
                break;
        }
    }
}
