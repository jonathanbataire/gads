package com.example.gadsleaderboard;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SubmitActivity extends AppCompatActivity {

    EditText fName, lName,email, gitLink;
    Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);
        Button backButton = findViewById(R.id.back_button);
        submitButton = findViewById(R.id.button_submit);
        fName = findViewById(R.id.editTextFirstName);
        lName = findViewById(R.id.editTextLastName);
        email = findViewById(R.id.editTextEmailAddress);
        gitLink = findViewById(R.id.editTextgithub);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String FirstName = fName.getText().toString().trim();
                String LastName = lName.getText().toString().trim();
                String strEmail = email.getText().toString().trim();
                String strGitLink = gitLink.getText().toString().trim();

                Toast.makeText(getApplicationContext(),FirstName + LastName + strEmail + strGitLink,Toast.LENGTH_LONG).show();

            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}