package com.example.snipper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    TextView full_name, email_address;
    Button logout_button;

    SharedPreferences sharedPreferences;

    //Create a shared preferences name and also create key name

    private static final String SHARED_PREF_NAME = "mPrefs";
    private static final String KEY_NAME = "name";
    private static final String KEY_EMAIL = "email";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        full_name = findViewById(R.id.full_name);
        email_address= findViewById(R.id.email);
        logout_button = findViewById(R.id.logout_button);



        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);

        String name = sharedPreferences.getString(KEY_NAME, null);
        String email = sharedPreferences.getString(KEY_EMAIL, null);

        if (name != null || email != null) {
            //we set data on textView
            full_name.setText("Full Name : " + name);
            email_address.setText("Email ID : " + email);
        }

        logout_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.commit();
                finish();
            }
        });
    }
}

