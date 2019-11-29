package com.example.foodwastemanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Register1 extends AppCompatActivity {

    Button next1;
    EditText fname,lname,hname,hno,street,district;
    RadioGroup radioGroup;
    SharedPreferences sharedPreferences;

    public static final String MyPREFERENCES = "MyPrefs" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register1);

        next1 = findViewById(R.id.next1);

        fname = findViewById(R.id.fname);
        lname = findViewById(R.id.lname);
        hname = findViewById(R.id.hname);
        hno = findViewById(R.id.hno);
        street = findViewById(R.id.street);
        district = findViewById(R.id.district);

        radioGroup = findViewById(R.id.radiogroup);

        radioGroup.clearCheck();

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = (RadioButton)group.findViewById(checkedId);
            }
        });

        next1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int selectedId = radioGroup.getCheckedRadioButtonId();

                sharedPreferences = getSharedPreferences(MyPREFERENCES, MODE_PRIVATE); //MyPREFERENCES="MyPrefs"


                if(!(
                                fname.getText().toString().isEmpty() ||
                                lname.getText().toString().isEmpty() ||
                                hname.getText().toString().isEmpty() ||
                                hno.getText().toString().isEmpty()   ||
                                street.getText().toString().isEmpty()||
                                district.getText().toString().isEmpty() ||
                                selectedId== -1

                ))
                {
                    RadioButton radioButton = (RadioButton)radioGroup.findViewById(selectedId);

                    //Toast.makeText(Register1.this, radioButton.getText(),Toast.LENGTH_SHORT).show();

                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("FirstName", fname.getText().toString()); //FirstName=key
                    editor.putString("LastName", lname.getText().toString());
                    editor.putString("HouseName", hname.getText().toString());
                    editor.putString("HouseNumber", hno.getText().toString());
                    editor.putString("Street", street.getText().toString());
                    editor.putString("District", district.getText().toString());
                    editor.putString("Gender", radioButton.getText().toString());
                    editor.apply();

                    Intent next1 = new Intent(getApplicationContext(),Register2.class);
                    startActivity(next1);

                }
                else
                {
                    Toast.makeText(Register1.this,"Incorrect Values",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
