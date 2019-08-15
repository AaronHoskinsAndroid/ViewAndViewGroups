package examples.aaronhoskins.com.viewandviewgroups;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "TAG_MAIN_ACT";
    public static final int REQUEST_CODE = 123;
    private TextView tvDisplay;
    private EditText etInput;
    private EditText etInputTwo;
    private EditText etUserInputThree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDisplay = findViewById(R.id.tvUserDisplay);
        etInput = findViewById(R.id.etUserInput);
        etInputTwo = findViewById(R.id.etUserInputTwo);

        etUserInputThree = findViewById(R.id.etUserInputThree);
        //logd
        Log.d(TAG, "onCreate: ");

        if(savedInstanceState != null) {
            final String passedValueFromTextView = savedInstanceState.getString("value", "No Value Found");
            tvDisplay.setText(passedValueFromTextView);
        }
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
                final String inputOne = etInput.getText().toString();
                final String inputTwo = etInputTwo.getText().toString();
                final Name name = new Name(inputOne, inputTwo);
                Intent explicitIntent = new Intent(this, SecondActivity.class);
                Bundle bundle = new Bundle();
                bundle.putParcelable("name", name);
                //bundle.putString("one", inputOne);
                //bundle.putString("two", inputTwo);

                explicitIntent.putExtras(bundle);

                startActivity(explicitIntent);
                break;
        }
    }

    public void startImpicitActivity(View view) {
        Intent implicitIntent = new Intent("examples.aaronhoskins.com.viewandviewgroups.implicitact");
        //startActivity(implicitIntent);
        startActivityForResult(implicitIntent, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (resultCode) {
            case ImplicitActivity.RESULT_CODE:
                String firstName = data.getStringExtra("first_name");
                String lastName = data.getStringExtra("last_name");
                tvDisplay.setText(firstName + " " + lastName);
                break;
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("value", tvDisplay.getText().toString());
        Log.d(TAG, "onSaveInstanceState:    ");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(TAG, "onRestoreInstanceState: ");
        final String passedValueFromTextView =
                savedInstanceState.getString("value", "No Value Found");
        tvDisplay.setText(passedValueFromTextView);

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Toast.makeText(this, "Landscape", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Portrait", Toast.LENGTH_SHORT).show();
        }
    }
}
