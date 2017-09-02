package com.sample.manager;

import android.app.Fragment;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FifthLayout extends Fragment {

    View myView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.fifth_layout, container, false);

        TextView textView3 = myView.findViewById(R.id.tv3);
        TextView textView4 = myView.findViewById(R.id.tv4);
        TextView textView5 = myView.findViewById(R.id.tv5);
        TextView textView6 = myView.findViewById(R.id.tv6);

        TextView textView31 = myView.findViewById(R.id.tv31);
        TextView textView41 = myView.findViewById(R.id.tv41);
        TextView textView51 = myView.findViewById(R.id.tv51);
        TextView textView61 = myView.findViewById(R.id.tv61);

        TextView textView32 = myView.findViewById(R.id.tv32);
        TextView textView42 = myView.findViewById(R.id.tv42);
        TextView textView52 = myView.findViewById(R.id.tv52);
        TextView textView62 = myView.findViewById(R.id.tv62);

        final EditText editText3 = myView.findViewById(R.id.e3);
        final EditText editText4 = myView.findViewById(R.id.e4);
        final EditText editText5 = myView.findViewById(R.id.e5);
        final EditText editText6 = myView.findViewById(R.id.e6);

        final EditText editText31 = myView.findViewById(R.id.e31);
        final EditText editText41 = myView.findViewById(R.id.e41);
        final EditText editText51 = myView.findViewById(R.id.e51);
        final EditText editText61 = myView.findViewById(R.id.e61);

        final EditText editText32 = myView.findViewById(R.id.e32);
        final EditText editText42 = myView.findViewById(R.id.e42);
        final EditText editText52 = myView.findViewById(R.id.e52);
        final EditText editText62 = myView.findViewById(R.id.e62);


        final MyDataBase myDataBase = new MyDataBase(getActivity().getApplicationContext());
        final String[] a = new String[12];

        Cursor cursor10 = myDataBase.getfood2();
        if (cursor10.moveToFirst()) {
            while(!cursor10.isAfterLast()) {
                for(int p=0;p<12;p++){
                    a[p] = cursor10.getString(cursor10.getColumnIndex(MyDataBase.colll2));
                    cursor10.moveToNext();
                }
            }
        }

        else {
            for(int p=0;p<12;p++){
                a[p] = "ITEM";
            }
        }
        textView3.setText(a[0]);
        textView4.setText(a[1]);
        textView5.setText(a[2]);
        textView6.setText(a[3]);
        textView31.setText(a[4]);
        textView41.setText(a[5]);
        textView51.setText(a[6]);
        textView61.setText(a[7]);
        textView32.setText(a[8]);
        textView42.setText(a[9]);
        textView52.setText(a[10]);
        textView62.setText(a[11]);

        for (int i=0; i<12; i++) {
            Cursor cursor = myDataBase.getprice(a[i]);

            if (cursor.getCount() == 1) {
                cursor.moveToLast();

                switch (i) {
                    case 0: editText3.setText(cursor.getString(cursor.getColumnIndex(MyDataBase.coll3)));
                        break;

                    case 1: editText4.setText(cursor.getString(cursor.getColumnIndex(MyDataBase.coll3)));
                        break;

                    case 2: editText5.setText(cursor.getString(cursor.getColumnIndex(MyDataBase.coll3)));
                        break;

                    case 3: editText6.setText(cursor.getString(cursor.getColumnIndex(MyDataBase.coll3)));
                        break;

                    case 4: editText31.setText(cursor.getString(cursor.getColumnIndex(MyDataBase.coll3)));
                        break;

                    case 5: editText41.setText(cursor.getString(cursor.getColumnIndex(MyDataBase.coll3)));
                        break;

                    case 6: editText51.setText(cursor.getString(cursor.getColumnIndex(MyDataBase.coll3)));
                        break;

                    case 7: editText61.setText(cursor.getString(cursor.getColumnIndex(MyDataBase.coll3)));
                        break;

                    case 8: editText32.setText(cursor.getString(cursor.getColumnIndex(MyDataBase.coll3)));
                        break;

                    case 9: editText42.setText(cursor.getString(cursor.getColumnIndex(MyDataBase.coll3)));
                        break;

                    case 10: editText52.setText(cursor.getString(cursor.getColumnIndex(MyDataBase.coll3)));
                        break;

                    case 11: editText62.setText(cursor.getString(cursor.getColumnIndex(MyDataBase.coll3)));
                        break;
                }
            }
            else {
                switch (i) {
                    case 1: editText3.setText("0");
                            editText31.setText("0");
                            editText32.setText("0");
                        break;

                    case 2: editText4.setText("0");
                            editText41.setText("0");
                            editText42.setText("0");
                        break;

                    case 3: editText5.setText("0");
                            editText51.setText("0");
                            editText52.setText("0");
                        break;

                    case 4: editText6.setText("0");
                            editText61.setText("0");
                            editText62.setText("0");
                        break;
                }
            }
        }

        Button button = myView.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String[] d = {editText3.getText().toString(),editText4.getText().toString(),editText5.getText().toString(),editText6.getText().toString(),
                        editText31.getText().toString(),editText41.getText().toString(),editText51.getText().toString(),editText61.getText().toString(),
                        editText32.getText().toString(),editText42.getText().toString(),editText52.getText().toString(),editText62.getText().toString()};

                for (int j=0;j<12;j++){

                    myDataBase.insertData2(a[j],d[j]);
                }

                Toast.makeText(getActivity().getApplicationContext(), "Updated", Toast.LENGTH_LONG).show();

            }
        });
        return myView;
    }
}