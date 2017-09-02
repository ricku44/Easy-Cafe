package com.sample.manager;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Objects;

import static com.sample.manager.R.array.qty;

public class Review extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        final ArrayList<String> list = new ArrayList<>();
        final String[] price = new String[20];
        final int[] total = new int[20];
        final MyDataBase myDb = new MyDataBase(getApplicationContext());

        final Intent intent = getIntent();

        final String email = intent.getStringExtra("email");

        final String tableno = intent.getStringExtra("tableno");
        final String time = intent.getStringExtra("time");
        final String vn = intent.getStringExtra("vn");

        final String course = intent.getStringExtra("course");
        final String pkey = tableno +"-"+ time;

        final String starter1 = intent.getStringExtra("starter1");
        final String starter2 = intent.getStringExtra("starter2");
        final String starter3 = intent.getStringExtra("starter3");
        final String starter4 = intent.getStringExtra("starter4");
        final String starter5 = intent.getStringExtra("starter5");

        final String main1 = intent.getStringExtra("main1");
        final String main2 = intent.getStringExtra("main2");
        final String main3 = intent.getStringExtra("main3");
        final String main4 = intent.getStringExtra("main4");
        final String main5 = intent.getStringExtra("main5");

        final String dessert1 = intent.getStringExtra("dessert1");
        final String dessert2 = intent.getStringExtra("dessert2");
        final String dessert3 = intent.getStringExtra("dessert3");
        final String dessert4 = intent.getStringExtra("dessert4");
        final String dessert5 = intent.getStringExtra("dessert5");

        TextView textView = (TextView) findViewById(R.id.header2);
        TextView textView2 = (TextView) findViewById(R.id.textView5);
        TextView textView3 = (TextView) findViewById(R.id.header3);

        textView.setText(tableno);
        textView2.setText(time);
        textView3.setText(course);



        String[] info = {

                starter1,
                starter2,
                starter3,
                starter4,
                starter5,

                main1,
                main2,
                main3,
                main4,
                main5,

                dessert1,
                dessert2,
                dessert3,
                dessert4,
                dessert5
        };


        for(String s : info) {
            if(!Objects.equals(s, getResources().getString(R.string.def)) && !Objects.equals(s, "0") && s.length() > 0) {
                list.add(s);
            }
        }

        final int itemsCount = list.size();
        for (int i = 0; i < itemsCount; i++) {

            Cursor cursor = myDb.getprice(list.get(i));

            if (cursor.getCount() != 0) {
                cursor.moveToLast();
                price[i] = cursor.getString(cursor.getColumnIndex(MyDataBase.coll3));
            }
            else
                price[i] = "0";
        }

        for (int i = 0; i < itemsCount; i++) {

            if(price[i].matches("")){
                price[i] = "0";
            }
        }

        final ListView listView = (ListView) findViewById(R.id.listView);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.listview, R.id.text10, list) {
            @NonNull
            public View getView(final int position, View convertView, @NonNull ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView text1 = view.findViewById(R.id.text10);
                final TextView text2 = view.findViewById(R.id.text20);
                text1.setText(list.get(position));
                text1.setTextSize(20);
                text1.setTextColor(Color.parseColor("#000000"));
                text2.setTextColor(Color.parseColor("#000000"));

                String q2 = "Rs. "+price[position];
                text2.setText(q2);

                final Spinner spinner = view.findViewById(R.id.spinner);
                ArrayAdapter adapter = ArrayAdapter.createFromResource(getApplicationContext(),
                        qty, R.layout.spinner2);

                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);

                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                            total[position] = Integer.parseInt(price[position])*(i+1);

                            String q = "Rs. "+total[position];
                            text2.setText(q);
                    }
                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });
                return view;
            }
        };


        listView.setAdapter(adapter);


        Button button = (Button) findViewById(R.id.Button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                int sum = 0;

                for (int i : total)
                    sum += i;


                String upTo = pkey.substring(0, Math.min(pkey.length(), 25));
                if (sum!=0) {
                    long l = myDb.insertData(upTo, course, tableno, time, vn,

                            starter1,
                            starter2,
                            starter3,
                            starter4,
                            starter5,

                            main1,
                            main2,
                            main3,
                            main4,
                            main5,

                            dessert1,
                            dessert2,
                            dessert3,
                            dessert4,
                            dessert5,
                            sum
                    );

                    if (l < 0)
                        Toast.makeText(getApplicationContext(), "Already Booked", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(getApplicationContext(), "Successfully Booked", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(getApplicationContext(), "Update the Prices", Toast.LENGTH_SHORT).show();

                Cursor cursor = myDb.login2(email);

                if(cursor.getCount()==1) {

                    String name,pno,gender,dob,city,password;
                    while (cursor.moveToNext()){
                        name = cursor.getString(cursor.getColumnIndex(MyDataBase.coln2));
                        password = cursor.getString(cursor.getColumnIndex(MyDataBase.coln4));
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
            }
        });
    }
}
