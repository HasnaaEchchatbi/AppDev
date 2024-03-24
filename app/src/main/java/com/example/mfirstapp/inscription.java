package com.example.mfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class inscription extends AppCompatActivity {


    EditText username, password, repassword;
    Button signup;
    DBconnexion db ;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username = (EditText) findViewById(R.id.emailr);
        password = (EditText) findViewById(R.id.passr);
        repassword = (EditText) findViewById(R.id.rpass);
        signup = (Button) findViewById(R.id.btnreg);
        db= new DBconnexion(this);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();

                if(user.equals("")||pass.equals("")||repass.equals(""))
                    Toast.makeText(inscription .this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else{
                    if(pass.equals(repass)){
                        Boolean checkuser = db.checkusername(user);
                        if(checkuser==false){
                            Boolean insert = db.insertuserdata(user, pass);
                            if(insert==true){
                                Toast.makeText(inscription .this, "Registered successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),loginActivity.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(inscription .this, "Registration failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(inscription .this, "User already exists! please sign in", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(inscription .this, "Passwords not matching", Toast.LENGTH_SHORT).show();
                    }
                } }
        });


    }
}
