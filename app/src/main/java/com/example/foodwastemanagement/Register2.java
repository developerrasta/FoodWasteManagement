package com.example.foodwastemanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register2 extends AppCompatActivity {


    EditText CName,CBNo,CStreet,CDistrict,RName,RBNo,RStreet,RDistrict;
    Button next2;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);

        sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);

        CName = findViewById(R.id.cname);
        CBNo = findViewById(R.id.cbno);
        CStreet = findViewById(R.id.cstreet);
        CDistrict = findViewById(R.id.cdistrict);
        RName = findViewById(R.id.rname);
        RBNo = findViewById(R.id.rbno);
        RStreet = findViewById(R.id.rstreet);
        RDistrict = findViewById(R.id.rdistrict);
        next2 = findViewById(R.id.next2);

        next2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(
                                        CName.getText().toString().isEmpty() ||
                                        CBNo.getText().toString().isEmpty() ||
                                        CStreet.getText().toString().isEmpty() ||
                                        CDistrict.getText().toString().isEmpty()   ||
                                        RName.getText().toString().isEmpty()||
                                        RBNo.getText().toString().isEmpty() ||
                                        RStreet.getText().toString().isEmpty() ||
                                        RDistrict.getText().toString().isEmpty()


                ))
                {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("CName", CName.getText().toString()); //CName=key
                    editor.putString("CBNo", CBNo.getText().toString()); //CName=key
                    editor.putString("CStreet", CStreet.getText().toString()); //CName=key
                    editor.putString("CDistrict", CDistrict.getText().toString()); //CName=key
                    editor.putString("RName", RName.getText().toString()); //CName=key
                    editor.putString("RBNo", RBNo.getText().toString()); //CName=key
                    editor.putString("RStreet", RStreet.getText().toString()); //CName=key
                    editor.putString("RDistrict", RDistrict.getText().toString()); //CName=key
                    editor.apply();

                    Intent next2 = new Intent(getApplicationContext(),Register3.class);
                    startActivity(next2);
                }
                else
                {
                    Toast.makeText(Register2.this,"Incorrect Values",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
