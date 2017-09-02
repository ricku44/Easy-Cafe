package com.sample.manager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class Login extends AppCompatActivity {

    public static final String PREFS_NAME = "MyPrefsFile";
    private static final String PREF_USERNAME = "username";
    private static final String PREF_PASSWORD = "password";
    String email,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final MyDataBase myDbHelper = new MyDataBase(getApplicationContext());
        SharedPreferences pref = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        Button button = (Button) findViewById(R.id.button3);
        final Button button2 = (Button) findViewById(R.id.button);
        final EditText editText = (EditText) findViewById(R.id.editText6);
        final EditText editText1 = (EditText) findViewById(R.id.editText4);
        final CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox);
        checkBox.setChecked(true);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                email = editText.getText().toString();
                password = editText1.getText().toString();

                Pattern pattern = Patterns.EMAIL_ADDRESS;
                boolean check = pattern.matcher(email).matches();

                if(checkBox.isChecked()) {

                    getSharedPreferences(PREFS_NAME,MODE_PRIVATE)
                            .edit()
                            .putString(PREF_USERNAME, email)
                            .putString(PREF_PASSWORD, password)
                            .apply();
                }

                if (email.matches("")) {
                    Toast.makeText(getApplicationContext(), "Please Enter Email ID", Toast.LENGTH_LONG).show();
                }

                else
                if(!check){
                    Toast.makeText(getApplicationContext(), "Check Email ID", Toast.LENGTH_LONG).show();
                }

                else
                if (password.matches("")) {
                    Toast.makeText(getApplicationContext(), "Please Enter Password", Toast.LENGTH_LONG).show();
                }


                else {


                    Cursor cursor = myDbHelper.login(email,password);

                    if(cursor.getCount()==1) {

                        String name,pno,gender,dob,city;
                        while (cursor.moveToNext()){
                            name = cursor.getString(cursor.getColumnIndex(MyDataBase.coln2));
                            pno = cursor.getString(cursor.getColumnIndex(MyDataBase.coln5));
                            gender = cursor.getString(cursor.getColumnIndex(MyDataBase.coln6));
                            dob = cursor.getString(cursor.getColumnIndex(MyDataBase.coln7));
                            city = cursor.getString(cursor.getColumnIndex(MyDataBase.coln8));

                            Intent intent = new Intent(getApplicationContext(),Manager.class);
                            intent.putExtra("name",name);
                            intent.putExtra("email",email);
                            intent.putExtra("password",password);
                            intent.putExtra("pno",pno);
                            intent.putExtra("gender",gender);
                            intent.putExtra("dob",dob);
                            intent.putExtra("city",city);

                            startActivity(intent);
                        }
                    }

                    else
                        Toast.makeText(getApplicationContext(), "Incorrect Email or Password", Toast.LENGTH_LONG).show();
                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),SignUp.class);
                startActivity(intent);
            }
        });

        String username = pref.getString(PREF_USERNAME, null);
        String password2 = pref.getString(PREF_PASSWORD, null);

        if (username != null && password2 != null) {

            editText.setText(username);
            editText1.setText(password2);
        }
    }
}
