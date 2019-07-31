package com.example.newtasksharedprefs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    DatabaseHelper databaseHelper;

    EditText et_name, et_email, et_fathername, et_phone, et_password, et_confirmpassword;
    RadioGroup radioGroupGender;
    RadioButton radioButtongender;
    Spinner spinner_countries, spinner_cities;

    String[] countries_list = {"Pakistan", "UAE"};
    String[] pak_city_list = {"Karachi", "Lahore", "Islamabad"};
    String[] uae_city_list = {"Dubai", "Sharjah", "Abu Dhabi"};

    CheckBox checkBox;

    Button btn_register, btn_showdata, btn_proceedtoLogin;
    TextView tv_show_data;

    String Expn =

            "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"

                    + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"

                    + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."

                    + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"

                    + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"

                    + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$";

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        databaseHelper = new DatabaseHelper(this);

        et_email = findViewById(R.id.id_et_register_email);
        et_name = findViewById(R.id.id_et_name);
        et_fathername = findViewById(R.id.id_et_fathername);
        et_phone = findViewById(R.id.id_et_phone);
        et_password = findViewById(R.id.id_et_register_password);
        et_confirmpassword = findViewById(R.id.id_et_confirmpassword);

        radioGroupGender = findViewById(R.id.id_radiogroup_gender);
        //radioButtongender = findViewById();

        spinner_countries = findViewById(R.id.id_spinnercountry);
        spinner_cities = findViewById(R.id.id_spinnercity);

        checkBox = findViewById(R.id.id_checkbox);

        ArrayAdapter arrayAdaptercountry = new ArrayAdapter(this, android.R.layout.simple_spinner_item, countries_list);
        arrayAdaptercountry.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_countries.setAdapter(arrayAdaptercountry);

        final ArrayAdapter arrayAdapterpakcity = new ArrayAdapter(this, android.R.layout.simple_spinner_item, pak_city_list);
        arrayAdapterpakcity.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        final ArrayAdapter arrayAdapteruaecity = new ArrayAdapter(this, android.R.layout.simple_spinner_item, uae_city_list);
        arrayAdapteruaecity.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner_countries.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if (i == 0) {
                    spinner_cities.setAdapter(arrayAdapterpakcity);
                } else {
                    spinner_cities.setAdapter(arrayAdapteruaecity);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        checkBox.setText(Html.fromHtml(
                "<b>Please:</b>  Accept  " +
                        "<a href=\"http://www.google.com\">link</a> " +
                        "terms and conditions."));
        checkBox.setMovementMethod(LinkMovementMethod.getInstance());


        btn_register = findViewById(R.id.id_btn_register);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                register();

            }
        });


        btn_showdata = findViewById(R.id.id_btn_show);
        tv_show_data = findViewById(R.id.id_tv_show);
        btn_proceedtoLogin = findViewById(R.id.id_btn_movetologin);


        btn_showdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Cursor cursor = databaseHelper.getData();

                StringBuffer stringBuffer = new StringBuffer();

                if (cursor.getCount() > 0) {

                    while (cursor.moveToNext()) {

                        stringBuffer.append("Id : " + cursor.getString(0) + "\n");
                        stringBuffer.append("Email: " + cursor.getString(1) + "\n");
                        stringBuffer.append("Name : " + cursor.getString(2) + "\n");
                        stringBuffer.append("FName : " + cursor.getString(3) + "\n");
                        stringBuffer.append("Phone: " + cursor.getString(4) + "\n");
                        stringBuffer.append("Password : " + cursor.getString(5) + "\n");
                        stringBuffer.append("Confirm Password : " + cursor.getString(6) + "\n");
                        stringBuffer.append("Gender :" + cursor.getString(7) + "\n");
                        stringBuffer.append("Country : " + cursor.getString(8) + "\n");
                        stringBuffer.append("City : " + cursor.getString(9) + "\n");

                        tv_show_data.setText(stringBuffer.toString());

                    }
                }

            }
        });

        btn_proceedtoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            }
        });


    }


    public void register() {


        String email = et_email.getText().toString();

        if (TextUtils.isEmpty(et_email.getText().toString()) && TextUtils.isEmpty(et_name.getText().toString())) {
            Toast.makeText(getApplicationContext(), "Please fill complete information", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(et_email.getText().toString())) {
            Toast.makeText(getApplicationContext(), "Please Enter your email", Toast.LENGTH_SHORT).show();
        } else if (!email.matches(Expn) && email.length() > 0) {
            Toast.makeText(getApplicationContext(), "Invalid Email", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(et_name.getText().toString())) {
            Toast.makeText(getApplicationContext(), "Please Enter your Name", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(et_fathername.getText().toString())) {
            Toast.makeText(getApplicationContext(), "Please Enter your Father Name", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(et_phone.getText().toString())) {
            Toast.makeText(getApplicationContext(), "Please Enter your Phone Number", Toast.LENGTH_SHORT).show();
        }
/*
        else if (et_phone.getText().toString().length() <9) {

            Toast.makeText(getApplicationContext(), "Please Enter Complete Phone Number", Toast.LENGTH_SHORT).show();

        }
*/
        else if (TextUtils.isEmpty(et_password.getText().toString())) {
            Toast.makeText(getApplicationContext(), "Please enter password", Toast.LENGTH_SHORT).show();
        } else if (et_password.getText().toString().length() < 6) {
            Toast.makeText(getApplicationContext(), "Password must be atleast 6 digits", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(et_confirmpassword.getText().toString())) {
            Toast.makeText(getApplicationContext(), "Please enter confirm password", Toast.LENGTH_SHORT).show();
        }

        else if (et_confirmpassword.getText().toString().length() < 6) {
            Toast.makeText(getApplicationContext(), "Password must be atleast 6 digits", Toast.LENGTH_SHORT).show();
        }

        else if (!et_password.getText().toString().equals(et_confirmpassword.getText().toString())) {
            Toast.makeText(getApplicationContext(), "Password did not match", Toast.LENGTH_SHORT).show();
        } else if (radioGroupGender.getCheckedRadioButtonId() == -1) {
            Toast.makeText(getApplicationContext(), "Please select your gender", Toast.LENGTH_SHORT).show();
        } else if (!checkBox.isChecked()) {

            Toast.makeText(getApplicationContext(), "Please accept terms and conditions", Toast.LENGTH_SHORT).show();
        } else {


            //  Toast.makeText(getApplicationContext(), "Registered", Toast.LENGTH_SHORT).show();

            int selectedId = radioGroupGender.getCheckedRadioButtonId();
            radioButtongender = findViewById(selectedId);


            //   String gender = String.valueOf(radioButtongender.getText());


            boolean result = databaseHelper.addUser(et_email.getText().toString(), et_name.getText().toString(),
                    et_fathername.getText().toString(), Integer.valueOf(et_phone.getText().toString()), et_password.getText().toString(),
                    et_confirmpassword.getText().toString(), radioButtongender.getText().toString(), spinner_countries.getSelectedItem().toString(), spinner_cities.getSelectedItem().toString());

            if (result == true) {
                Toast.makeText(getApplicationContext(), "Data Inserted Successfully", Toast.LENGTH_SHORT).show();

                /*
                btn_proceedtoLogin.setVisibility(View.VISIBLE);
                btn_proceedtoLogin.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                    }
                });
                */
                finish();
            } else {
                Toast.makeText(getApplicationContext(), "NOOO!!!", Toast.LENGTH_SHORT).show();
            }
        }


    }


}


