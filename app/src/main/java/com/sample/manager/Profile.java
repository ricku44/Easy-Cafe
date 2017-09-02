package com.sample.manager;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Arrays;

public class Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Intent intent = getIntent();
        final String name = intent.getStringExtra("name");
        final String email = intent.getStringExtra("email");
        final String password = intent.getStringExtra("password");
        final String pno = intent.getStringExtra("pno");
        final String gender = intent.getStringExtra("gender");
        final String dob = intent.getStringExtra("dob");
        final String city = intent.getStringExtra("city");

        String[] a = {name, email, password, pno, gender, dob, city};
        final ArrayList<String> note = new ArrayList<>();
        note.addAll(Arrays.asList(getResources().getStringArray(R.array.prof)));

        final ArrayList<String> dt = new ArrayList<>();
        dt.addAll(Arrays.asList(a));

        final Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        myToolbar.setTitle(name + "'s Profile");
        myToolbar.setTitleTextColor(Color.parseColor("#ffffff"));
        setSupportActionBar(myToolbar);


        final AlertDialog alertDialog = new AlertDialog.Builder(Profile.this).create();
        alertDialog.setTitle("Enter Your Password:");
        final EditText input = new EditText(this);
        alertDialog.setView(input);
        alertDialog.setButton(DialogInterface.BUTTON_NEUTRAL,"SUBMIT", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int which){
            }
        });

        alertDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {

                if(password.matches(input.getText().toString())) {

                    alertDialog.dismiss();

                }
                else {
                    alertDialog.show();
                }
            }
        });

        alertDialog.show();


        final ListView listView = (ListView) findViewById(R.id.listview);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.listview2,R.id.text10,note) {
            @NonNull
            public View getView(int position, View convertView, @NonNull ViewGroup parent) {


                View view = super.getView(position, convertView, parent);
                final TextView text1 = view.findViewById(R.id.text10);
                final TextView text2 = view.findViewById(R.id.text15);


                    text1.setText(note.get(position));
                    text2.setText(dt.get(position));

                    if(position!=2)
                        text2.setInputType(InputType.TYPE_CLASS_TEXT);


                text1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        AlertDialog alertDialog = new AlertDialog.Builder(Profile.this).create();
                        alertDialog.setTitle(text1.getText().toString());

                        final EditText input = new EditText(getApplicationContext());
                        input.setHint(text2.getText().toString());
                        input.setTextColor(Color.parseColor("#000000"));
                        alertDialog.setView(input);
                        alertDialog.setButton(DialogInterface.BUTTON_NEUTRAL,"SUBMIT", new DialogInterface.OnClickListener(){
                            public void onClick(DialogInterface dialog, int which){
                                if(!input.getText().toString().matches(""))
                                    text2.setText(input.getText().toString());
                            }
                        });

                        alertDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                            @Override
                            public void onDismiss(DialogInterface dialog) {

                            }
                        });
                        alertDialog.show();
                    }
                });

                text2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        AlertDialog alertDialog = new AlertDialog.Builder(Profile.this).create();
                        alertDialog.setTitle(text1.getText().toString());

                        final EditText input = new EditText(getApplicationContext());
                        input.setHint(text2.getText().toString());
                        input.setTextColor(Color.parseColor("#000000"));
                        alertDialog.setView(input);
                        alertDialog.setButton(DialogInterface.BUTTON_NEUTRAL,"SUBMIT", new DialogInterface.OnClickListener(){
                            public void onClick(DialogInterface dialog, int which){
                                if(!input.getText().toString().matches(""))
                                    text2.setText(input.getText().toString());

                            }
                        });

                        alertDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                            @Override
                            public void onDismiss(DialogInterface dialog) {

                            }
                        });
                        alertDialog.show();
                    }
                });

                return view;
            }
        };

        listView.setAdapter(adapter);



        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MyDataBase myDbHelper = new MyDataBase(getApplicationContext());
                myDbHelper.deleteData(email);
                Toast.makeText(getApplicationContext(),"Deleted",Toast.LENGTH_LONG).show();
                Intent intent1 = new Intent(getApplicationContext(),Login.class);
                startActivity(intent1);
            }
        });


        Button button1 = (Button) findViewById(R.id.button2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int itemsCount = listView.getChildCount();
                String[] info = new String[itemsCount];


                for (int i = 0; i < itemsCount; i++) {

                    View view = listView.getChildAt(i);
                    String itemquantity = ((TextView) view.findViewById(R.id.text15)).getText().toString();
                        if (!itemquantity.matches(""))
                            info[i] = itemquantity;
                        else
                            info[i]=dt.get(i);

                }



                MyDataBase myDataBase = new MyDataBase(getApplicationContext());
                myDataBase.updateData(info[0],info[1],info[2],info[3],info[4],info[5],info[6]);

                Toast.makeText(getApplicationContext(), "Updated", Toast.LENGTH_LONG).show();

                Intent intent1 = new Intent(getApplicationContext(),Manager.class);
                intent1.putExtra("name",    info[0]);
                intent1.putExtra("email",   info[1]);
                intent1.putExtra("pno",     info[3]);
                intent1.putExtra("password",info[2]);
                intent1.putExtra("gender",  info[4]);
                intent1.putExtra("dob",     info[5]);
                intent1.putExtra("city",    info[6]);
                startActivity(intent1);
            }
        });
    }
}
