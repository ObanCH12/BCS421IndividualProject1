package com.example.individualproject1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    SharedPreferences sharedpreferences;
    public static final String MYPREF = "My_PREF_FILE_NAME";
    public static final String Email = "NAME_KEY";
    public static final String Password = "EMAIL_KEY";

    EditText email;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void Login(View view) {
        String e = "";
        String p = "";

        sharedpreferences = getSharedPreferences(MYPREF,
                Context.MODE_PRIVATE);
        email = (EditText) findViewById(R.id.EmailEdit);
        password = (EditText) findViewById(R.id.PasswordEdit);

        if (sharedpreferences.contains(Email)) {
            e =sharedpreferences.getString(Email, "");
        }
        if (sharedpreferences.contains(Password)) {
           p = sharedpreferences.getString(Password, "");
        }

       if( e.equals(email.getText().toString()) && p.equals(password.getText().toString())){
            Toast toast = Toast.makeText(Login.this, "Login Successful", Toast.LENGTH_LONG);
            toast.show();
        }
       else{
           Toast toast = Toast.makeText(Login.this, "Login failed", Toast.LENGTH_LONG);
           toast.show();
       }


    }

    public void Registration(View view) {
        Intent R = new Intent(getBaseContext(), Register.class);
        startActivity(R);
    }
}