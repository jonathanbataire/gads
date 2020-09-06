package com.example.gadsleaderboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.drawable.DrawableCompat;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SubmitActivity extends AppCompatActivity {

    EditText fName, lName,email, gitLink;
    Button submitButton;
    private APIService mAPIService;
    private String FirstName;
    private String strEmail;
    private String LastName;
    private String strGitLink;

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
        mAPIService = ApiUtils.getAPIService();

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirstName = fName.getText().toString().trim();
                LastName = lName.getText().toString().trim();
                strEmail = email.getText().toString().trim();
                strGitLink = gitLink.getText().toString().trim();
                //showAlertDialog("Are you Sure",true);



                //Toast.makeText(getApplicationContext(),FirstName + LastName + strEmail + strGitLink,Toast.LENGTH_LONG).show();

            }
        });
    }

    public void sendPost() throws IOException {

        Call<String> call = mAPIService.getStringScalar(FirstName, LastName, strGitLink, strEmail);

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {

                //Toast.makeText(getApplicationContext(), "this "+response, Toast.LENGTH_SHORT).show();
                //showAlertDialog("Successful!!!!",false);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

                //Toast.makeText(getApplicationContext(), "Error" + t.getMessage(), Toast.LENGTH_SHORT).show();
                //showAlertDialog("Failure...",false);

            }
        });

    }

    public void showAlertDialog(String msg,Boolean buttons,int flag){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        /*Drawable icon;
        icon = AppCompatResources.getDrawable(this, R.drawable.ic_baseline_check_circle_24);
        DrawableCompat.setTint(icon, Color.GREEN);
        if(flag == 1){

        }else {
            icon = AppCompatResources.getDrawable(this, R.drawable.ic_baseline_warning_24);
            DrawableCompat.setTint(icon, Color.RED);

        }*/

        builder.setTitle(Html.fromHtml("<font color='#000000'>"+msg+"</font>"));
        if(buttons){
            builder.setNegativeButton(Html.fromHtml("<font color='#ffa333'>No</font>"), new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int arg1) {
                    dialog.dismiss();
                }
            });
        }
        builder.setPositiveButton(Html.fromHtml("<font color='#ffa333'>OK</font>"), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int arg1) {
                try {
                    sendPost();
                } catch (IOException e) {
                        e.printStackTrace();
                }
            }
        });

        builder.create();
        builder.show();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}