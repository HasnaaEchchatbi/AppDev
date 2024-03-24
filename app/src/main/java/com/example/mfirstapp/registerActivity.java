
package com.example.mfirstapp;

        import androidx.appcompat.app.AlertDialog;
        import androidx.appcompat.app.AppCompatActivity;

        import android.annotation.SuppressLint;
        import android.content.Intent;
        import android.database.Cursor;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Adapter;
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Spinner;
        import android.widget.TextView;
        import android.widget.Toast;

        import java.util.ArrayList;

public class registerActivity extends AppCompatActivity {
    EditText title;
    android.widget.Spinner spin;
    Button view;

    private Spinner spinner1;
    private Spinner spinner;
    private Spinner spinner8;
    DBconnexion db;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_annonce);

        title = (EditText) findViewById(R.id.titr);
        Spinner spin = (Spinner) findViewById(R.id.spinner8);
        spinner1 = findViewById(R.id.spinner1);
        db = new DBconnexion(this);

       view = (Button) findViewById(R.id.enter);

     view.setOnClickListener(new View.OnClickListener() {
        public void onClick(View view) {

            String title1 = title.getText().toString();
            String city1 = spin.getSelectedItem().toString();

            Boolean insert = db.insertannoncedata(title1, city1);
            if (insert == true) {
                Toast.makeText(registerActivity.this, "annonce added successfull", Toast.LENGTH_SHORT).show();
                Intent myintent = new Intent(getApplicationContext(), loginActivity.class);
                startActivity(myintent);

            } else {
                Toast.makeText(registerActivity.this, "email or password  incorrect", Toast.LENGTH_SHORT).show();
            }

        }


        });


        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                String item = adapterView.getItemAtPosition(position).toString();


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                String item = adapterView.getItemAtPosition(position).toString();


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinner8 = findViewById(R.id.spinner8);
        spinner8.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                String item = adapterView.getItemAtPosition(position).toString();


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Web");
        arrayList.add("TV");
        arrayList.add("Radio");
        arrayList.add("Mobile");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, arrayList);
        adapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        spinner1.setAdapter(adapter);

        ArrayList<String> arrayList2 = new ArrayList<>();
        arrayList2.add("IT");
        arrayList2.add("Santé");
        arrayList2.add("Education");
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, arrayList2);
        adapter2.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        spinner.setAdapter(adapter2);

        ArrayList<String> arrayList3 = new ArrayList<>();
        arrayList3.add("Agadir");
        arrayList3.add("Casa");
        arrayList3.add("Rabat");
        ArrayAdapter<String> adapter3 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, arrayList3);
        adapter3.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        spinner8.setAdapter(adapter3);
    }


    }
