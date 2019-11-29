package com.example.foodwastemanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class InsertSuccessfull extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    String FirstName,LastName,Gender,HouseName,HouseNo,Street,District;
    String CateringName,CateringBuildingNo,CateringStreet,CateringDistrict,RestName,RestBuildingNo,RestStreet,RestDistrict;
    String MobileNo,UserName,Password,Email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_successfull);

        sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);

        //fetching shared preference data
        FirstName = sharedPreferences.getString("FirstName", "*****");
        LastName = sharedPreferences.getString("LastName", "*****");
        Gender = sharedPreferences.getString("Gender", "*****");
        HouseName = sharedPreferences.getString("HouseName", "*****");
        HouseNo = sharedPreferences.getString("HouseNumber", "*****");
        Street = sharedPreferences.getString("Street", "*****");
        District = sharedPreferences.getString("District", "*****");

        CateringName = sharedPreferences.getString("CName", "*****");
        CateringBuildingNo = sharedPreferences.getString("CBNo", "*****");
        CateringStreet = sharedPreferences.getString("CStreet", "*****");
        CateringDistrict = sharedPreferences.getString("CDistrict", "*****");

        RestName = sharedPreferences.getString("RName", "*****");
        RestBuildingNo = sharedPreferences.getString("RBNo", "*****");
        RestStreet = sharedPreferences.getString("RStreet", "*****");
        RestDistrict = sharedPreferences.getString("RDistrict", "*****");

        MobileNo = sharedPreferences.getString("MNum", "*****");
        UserName = sharedPreferences.getString("UName", "*****");
        Password = sharedPreferences.getString("Pass", "*****");
        Email = sharedPreferences.getString("EMail", "*****");

        //Toast.makeText(Profile.this,FirstName,Toast.LENGTH_SHORT).show();



        StringRequest stringRequest = new StringRequest(Request.Method.POST,"https://lilac-wing.000webhostapp.com/FoodWasteManagement/Register.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        //If we are getting success from server

                        Toast.makeText(InsertSuccessfull.this,response,Toast.LENGTH_LONG).show();



                        try {
                            JSONArray jsonArray=new JSONArray(response);
                            for(int i=0;i<jsonArray.length();i++){
                                JSONObject json_obj = jsonArray.getJSONObject(i);

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //error handling
                    }

                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                //Adding parameters to request

                params.put("firstname",FirstName); //name=$_POST['name'];
                params.put("lastname",LastName);
                params.put("gender",Gender);
                params.put("mobileno",MobileNo);
                params.put("username",UserName);
                params.put("password",Password);
                params.put("email",Email);
                params.put("housename",HouseName);
                params.put("houseno",HouseNo);
                params.put("street",Street);
                params.put("district",District);
                params.put("catname",CateringName);
                params.put("catbuildno",CateringBuildingNo);
                params.put("catstreet",CateringStreet);
                params.put("catdistrict",CateringDistrict);
                params.put("restname",RestName);
                params.put("restbuildno",RestBuildingNo);
                params.put("reststreet",RestStreet);
                params.put("restdistrict",RestDistrict);


                //returning parameter
                return params;
            }
        };


        //Adding the string request to the queue
        RequestQueue requestQueue = Volley.newRequestQueue(InsertSuccessfull.this);
        requestQueue.add(stringRequest);

    }
}
