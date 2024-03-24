package com.example.mfirstapp;

//import static com.example.mfirstapp.R.id.buttonReset;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class loginActivity extends AppCompatActivity {
    EditText usern, pass;
    Button btnlog,btninscription;

    DBconnexion db;

    public void inscrip(View view){
        startActivity(new Intent(loginActivity.this,registerActivity.class));
    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        db = new DBconnexion(this);

        usern = (EditText) findViewById(R.id.username1);
        pass = (EditText) findViewById(R.id.password1);
        btnlog = (Button) findViewById(R.id.btnlogin);

        btnlog.setOnClickListener(new View.OnClickListener() {


            public void onClick(View view) {
                String user = usern.getText().toString();
                String passw = pass.getText().toString();
                if (user.equals("") || passw.equals("")) {
                    Snackbar snackbar = Snackbar.make(view, "Please enter all the fields", Snackbar.LENGTH_SHORT);
                    View snackbarView = snackbar.getView();

                    snackbar.show();
                } else {
                    Boolean checkuserpass = db.checkpassword(user, passw);
                    if (checkuserpass) {
                        Snackbar snackbar = Snackbar.make(view, "Login successful", Snackbar.LENGTH_SHORT);
                        snackbar.show();

                        Intent intent = new Intent(getApplicationContext(), registerActivity.class);
                        startActivity(intent);
                    } else {
                        Snackbar snackbar = Snackbar.make(view, "Email or password incorrect", Snackbar.LENGTH_SHORT);
                        View snackbarView = snackbar.getView();
                        snackbarView.setBackgroundColor(Color.RED); // Couleur de fond bleue
                        snackbar.show();
                    }
                }
            }
        });
    }

}