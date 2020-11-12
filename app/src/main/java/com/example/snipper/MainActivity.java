  package com.example.snipper;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;


  public class MainActivity extends AppCompatActivity {


    EditText mUsername;
    EditText mEmail;
    Button mButtonSave;
    ImageButton userImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUsername = (EditText)findViewById(R.id.full_name);
        mEmail = (EditText)findViewById(R.id.email);
        mButtonSave = (Button) findViewById(R.id.save_button);
        userImage = (ImageButton) findViewById(R.id.add_user);

        userImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Choose Profile Picture")
                        .setMessage("Select from Options")
                        .setCancelable(false);

            }
        });
    }
}