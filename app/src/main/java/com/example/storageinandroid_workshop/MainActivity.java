package com.example.storageinandroid_workshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txt_email , txt_password;
    private Button register , login;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_email = (EditText) findViewById(R.id.txt_email);        //We can also use like this
        txt_password = findViewById(R.id.txt_password);
        login = findViewById(R.id.btn_login);
        register = findViewById(R.id.btn_register);

        sharedPreferences =  getSharedPreferences("RIT", MODE_PRIVATE);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = txt_email.getText().toString();
                String password = txt_password.getText().toString();
                editor = sharedPreferences.edit();
                editor.putString("RIT_Email" , email);          //Here RIT_Email and RIT_Password is the keys
                editor.putString("RIT_Password" , password);
                editor.commit();
                Toast.makeText(MainActivity.this, "Register Successfully", Toast.LENGTH_SHORT).show();

                txt_email.setText("");
                txt_password.setText("");
            }
        });


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = txt_email.getText().toString();
                String password = txt_password.getText().toString();
                if (email.equals(sharedPreferences.getString("RIT_Email"  , null)) && password.equals(sharedPreferences.getString("RIT_Password" , null)))
                {
                    Toast.makeText(MainActivity.this, "Login SuccessFully", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    startActivity(intent);

                }
                else
                {
                    Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();

                }

                txt_email.setText("");
                txt_password.setText("");
            }
        });


    }
}