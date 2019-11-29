package com.example.foodwastemanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Register3 extends AppCompatActivity {

    EditText MNum,UName,Pass,CPass,EMail;
    Button submitt;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register3);

        sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);

        MNum = findViewById(R.id.mobileno);
        UName = findViewById(R.id.uname);
        Pass = findViewById(R.id.password);
        CPass = findViewById(R.id.cpassword);
        EMail = findViewById(R.id.email);

        submitt= findViewById(R.id.submitt);

        submitt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(
                                MNum.getText().toString().isEmpty()   ||
                                UName.getText().toString().isEmpty()  ||
                                Pass.getText().toString().isEmpty()   ||
                                CPass.getText().toString().isEmpty()  ||
                                EMail.getText().toString().isEmpty())  &&
                                        (Pass.getText().toString().equals(CPass.getText().toString())))


                {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("MNum", MNum.getText().toString()); //MName=key
                    editor.putString("UName", UName.getText().toString());
                    editor.putString("Pass", Pass.getText().toString());
                    editor.putString("EMail", EMail.getText().toString());
                    editor.apply();

                    Intent next3 = new Intent(getApplicationContext(),InsertSuccessfull.class);
                    startActivity(next3);
                }
                else
                {
                    Toast.makeText(Register3.this,"Incorrect Values",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
