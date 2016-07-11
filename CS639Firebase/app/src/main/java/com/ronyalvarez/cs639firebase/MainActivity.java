package com.ronyalvarez.cs639firebase;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private EditText etId;
    private EditText etFirstName;
    private DatabaseReference rootRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        rootRef = FirebaseDatabase.getInstance().getReference();

        etId = (EditText) findViewById(R.id.etId);
        etFirstName = (EditText) findViewById(R.id.etFirstName);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = etId.getText().toString().trim();
                String firstName = etFirstName.getText().toString().trim();
                Student student = new Student(id, firstName);
                rootRef.push().setValue(student);

                Toast.makeText(getApplicationContext(), "User added successfully!", Toast.LENGTH_LONG).show();
            }
        });

    }


}
