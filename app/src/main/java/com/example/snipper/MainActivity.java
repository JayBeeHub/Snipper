  package com.example.snipper;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;


  public class MainActivity extends AppCompatActivity {


      private static final int REQUEST_CAMERA = 1;
      private static final int SELECT_FILE = 0;


      EditText mUsername;
      EditText mEmail;
      Button mButtonSave;
      ImageButton userImage;
      SharedPreferences sharedPreferences;

      //Create a shared preferences name and also create key name

      private static final String SHARED_PREF_NAME = "mPrefs";
      private static final String KEY_NAME = "name";
      private static final String KEY_EMAIL = "email";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        mUsername = (EditText)findViewById(R.id.full_name);
        mEmail = (EditText)findViewById(R.id.email);
        mButtonSave = (Button) findViewById(R.id.save_button);
        userImage = (ImageButton) findViewById(R.id.add_user);


        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);

        String name = sharedPreferences.getString(KEY_NAME,null);

        if (name != null){
        //if data is available so directly call on HomeActivity...
            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
            startActivity(intent);

        }


        userImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SelectImage();


//                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
//                builder.setTitle("Choose Profile Picture")
//                        .setMessage("Select from Options")
//                        .setCancelable(false);

            }
        });






        mButtonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               //when you click, a button put data on Shared Preferences
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(KEY_NAME,mUsername.getText().toString());
                editor.putString(KEY_EMAIL,mEmail.getText().toString());
                editor.apply();


                Intent intent = new Intent(MainActivity.this,HomeActivity.class);
                startActivity(intent);

                Toast.makeText(MainActivity.this,"Login Success",Toast.LENGTH_SHORT).show();
            }
        });


    }
      @Override
      public  void onActivityResult(int requestCode, int resultCode, Intent data){
          super.onActivityResult(requestCode, resultCode,data);

          if(resultCode== Activity.RESULT_OK){

              if(requestCode==REQUEST_CAMERA){

                  Bundle bundle = data.getExtras();
                  final Bitmap bmp = (Bitmap) bundle.get("data");
                  userImage.setImageBitmap(bmp);

              }else if(requestCode==SELECT_FILE){

                  Uri selectedImageUri = data.getData();
                  userImage.setImageURI(selectedImageUri);
              }

          }
      }

      private void SelectImage(){

          final CharSequence[] items={"Camera","Gallery", "Cancel"};

          AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
          builder.setTitle("Add Image");

          builder.setItems(items, new DialogInterface.OnClickListener() {

              @Override
              public void onClick(DialogInterface dialogInterface, int i) {
                  if (items[i].equals("Camera")) {

                      Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                      startActivityForResult(intent, REQUEST_CAMERA);

                  } else if (items[i].equals("Gallery")) {

                      Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                      intent.setType("image/*");
                      //startActivityForResult(intent.createChooser(intent, "Select File"), SELECT_FILE);
                      startActivityForResult(intent, SELECT_FILE);

                  } else if (items[i].equals("Cancel")) {
                      dialogInterface.dismiss();
                  }
              }
          });
          builder.show();

      }


  }