package com.sample.manager;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;
import java.util.Calendar;
import java.util.regex.Pattern;

public class SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.rg);
        radioGroup.check(R.id.radioButton3);

        Spinner spinner = (Spinner) findViewById(R.id.spinner2);
        String[] cities = getResources().getStringArray(R.array.cities);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getApplicationContext(),R.layout.spinner1,cities);
        spinner.setAdapter(arrayAdapter);

    }

    public void test(View view){

        Calendar currentDate = Calendar.getInstance();
        int Year = currentDate.get(Calendar.YEAR);
        int Month = currentDate.get(Calendar.MONTH);
        int Day = currentDate.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog DatePicker = new DatePickerDialog(SignUp.this, new DatePickerDialog.OnDateSetListener() {
            public void onDateSet(android.widget.DatePicker datepicker, int selectedyear, int selectedmonth, int selectedday) {
                int day = datepicker.getDayOfMonth();
                int month = datepicker.getMonth() + 1;
                int year = datepicker.getYear();
                EditText editText8 = (EditText) findViewById(R.id.editText8);

                if(day>9&&month>9){
                    editText8.setText(day+"-"+month+"-"+year);
                }
                else
                if(day<=9&&month<=9){
                    editText8.setText("0"+day+"-0"+month+"-"+year);
                }
                else
                if(day<=9&&month>9){
                    editText8.setText("0"+day+"-"+month+"-"+year);
                }
                else
                {
                    editText8.setText(day+"-0"+month+"-"+year);
                }
            }
        }, Year, Month, Day);
        DatePicker.setTitle("Select Date");
        DatePicker.show();
    }


    public void onBtnClicked2 (View v) {


        EditText editText1 = (EditText) findViewById(R.id.editText);
        EditText editText2 = (EditText) findViewById(R.id.editText2);
        EditText editText3 = (EditText) findViewById(R.id.editText3);
        EditText editText4 = (EditText) findViewById(R.id.editText4);
        EditText editText9 = (EditText) findViewById(R.id.editText8);
        Spinner spinner = (Spinner) findViewById(R.id.spinner2);

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.rg);
        int rid = radioGroup.getCheckedRadioButtonId();
        RadioButton radioButton = (RadioButton) findViewById(rid);


        String name = editText1.getText().toString();
        String email = editText2.getText().toString();
        String pno = editText3.getText().toString();
        String password = editText4.getText().toString();
        String dob = editText9.getText().toString();
        String city = spinner.getSelectedItem().toString();
        String gender = radioButton.getText().toString();


        Pattern pattern = Patterns.EMAIL_ADDRESS;
        boolean check = pattern.matcher(email).matches();

        Pattern pattern1 = Patterns.PHONE;
        boolean check2 = pattern1.matcher(pno).matches();


        if (name.matches("")) {
            Toast.makeText(getApplicationContext(), "Please Enter Name", Toast.LENGTH_LONG).show();
        } else if (email.matches("")) {
            Toast.makeText(getApplicationContext(), "Please Enter Email ID", Toast.LENGTH_LONG).show();
        } else if (!check) {
            Toast.makeText(getApplicationContext(), "Check Email ID", Toast.LENGTH_LONG).show();
        } else if (pno.matches("")) {
            Toast.makeText(getApplicationContext(), "Please Enter Phone No.", Toast.LENGTH_LONG).show();
        } else if (!check2) {
            Toast.makeText(getApplicationContext(), "Check Phone No.", Toast.LENGTH_LONG).show();
        } else if (password.matches("")) {
            Toast.makeText(getApplicationContext(), "Please Enter Password", Toast.LENGTH_LONG).show();
        } else if (dob.matches("")) {
            Toast.makeText(getApplicationContext(), "Please Enter D.O.B", Toast.LENGTH_LONG).show();
        } else if (city.matches(getString(R.string.def))) {
            Toast.makeText(getApplicationContext(), "Please Select City", Toast.LENGTH_LONG).show();
        } else {

            MyDataBase myDb = new MyDataBase(getApplicationContext());
            long l = myDb.insertData5(name, email, password, pno, gender, dob, city);


            if (l < 0)
                Toast.makeText(getApplicationContext(), "Registration Unsuccessful", Toast.LENGTH_LONG).show();

            else {
                Toast.makeText(getApplicationContext(), "User Registered Successfully", Toast.LENGTH_LONG).show();
                Intent intent2 = new Intent(getApplicationContext(), Login.class);
                startActivity(intent2);
            }

        }
    }

}
