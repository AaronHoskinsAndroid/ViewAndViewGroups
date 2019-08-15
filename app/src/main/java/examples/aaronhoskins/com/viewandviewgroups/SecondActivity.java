package examples.aaronhoskins.com.viewandviewgroups;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    public static final String TAG = "TAG_SEC_ACT";
    TextView tvFirstName;
    TextView tvLastName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        tvFirstName = findViewById(R.id.tvFirstName);
        tvLastName = findViewById(R.id.tvLastName);
        Log.d(TAG, "onCreate: ");
        //Get Intent which created component
        Intent passedIntent = getIntent();
        //Get the bundle from the intent
        Bundle passedBundle = passedIntent.getExtras();
        //pull values from the bundle
//        final String firstInputs = passedBundle.getString("one");
//        final String sencondInput = passedBundle.getString("two");
        Name passedName = passedBundle.getParcelable("name");
       //populate views
//        tvLastName.setText(sencondInput);
////        tvFirstName.setText(firstInputs);

        tvFirstName.setText(passedName.getFirstName());
        tvLastName.setText(passedName.getLastName());
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
}
