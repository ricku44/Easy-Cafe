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

public class FourthLayout extends Fragment {

    View myView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.fourth_layout, container, false);

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

        final String[] a = getResources().getStringArray(R.array.Menu1);
        final String[] b = getResources().getStringArray(R.array.Menu2);
        final String[] c = getResources().getStringArray(R.array.Menu3);

        final MyDataBase myDataBase = new MyDataBase(getActivity().getApplicationContext());


        textView3.setText(a[1]);
        textView4.setText(a[2]);
        textView5.setText(a[3]);
        textView6.setText(a[4]);
        textView31.setText(b[1]);
        textView41.setText(b[2]);
        textView51.setText(b[3]);
        textView61.setText(b[4]);
        textView32.setText(c[1]);
        textView42.setText(c[2]);
        textView52.setText(c[3]);
        textView62.setText(c[4]);

        for (int i=1; i<=4; i++) {
            Cursor cursor = myDataBase.getfood(a[i]);
            Cursor cursor2 = myDataBase.getfood(b[i]);
            Cursor cursor3 = myDataBase.getfood(c[i]);

            if (cursor.getCount() == 1 && cursor2.getCount() == 1 && cursor3.getCount() == 1) {
                cursor.moveToLast();
                cursor2.moveToLast();
                cursor3.moveToLast();
                switch (i) {
                    case 1: editText3.setText(cursor.getString(cursor.getColumnIndex(MyDataBase.colll2)));
                        editText31.setText(cursor2.getString(cursor2.getColumnIndex(MyDataBase.colll2)));
                        editText32.setText(cursor3.getString(cursor3.getColumnIndex(MyDataBase.colll2)));
                        break;

                    case 2: editText4.setText(cursor.getString(cursor.getColumnIndex(MyDataBase.colll2)));
                        editText41.setText(cursor2.getString(cursor2.getColumnIndex(MyDataBase.colll2)));
                        editText42.setText(cursor3.getString(cursor3.getColumnIndex(MyDataBase.colll2)));
                        break;

                    case 3: editText5.setText(cursor.getString(cursor.getColumnIndex(MyDataBase.colll2)));
                        editText51.setText(cursor2.getString(cursor2.getColumnIndex(MyDataBase.colll2)));
                        editText52.setText(cursor3.getString(cursor3.getColumnIndex(MyDataBase.colll2)));
                        break;

                    case 4: editText6.setText(cursor.getString(cursor.getColumnIndex(MyDataBase.colll2)));
                        editText61.setText(cursor2.getString(cursor2.getColumnIndex(MyDataBase.colll2)));
                        editText62.setText(cursor3.getString(cursor3.getColumnIndex(MyDataBase.colll2)));
                        break;
                }
            }
            else {
                switch (i) {
                    case 1: editText3.setHint("Enter Item");
                        editText31.setHint("Enter Item");
                        editText32.setHint("Enter Item");
                        break;

                    case 2: editText4.setHint("Enter Item");
                        editText41.setHint("Enter Item");
                        editText42.setHint("Enter Item");
                        break;

                    case 3: editText5.setHint("Enter Item");
                        editText51.setHint("Enter Item");
                        editText52.setHint("Enter Item");
                        break;

                    case 4: editText6.setHint("Enter Item");
                        editText61.setHint("Enter Item");
                        editText62.setHint("Enter Item");
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


                for(int p=0;p<12;p++){
                    if(p<4)
                        myDataBase.insertData3(a[p+1],d[p]);

                    else if(p>7)
                        myDataBase.insertData3(c[p-7],d[p]);

                    else if(p<=7 && p>=4)
                        myDataBase.insertData3(b[p-3],d[p]);
                }

                Toast.makeText(getActivity().getApplicationContext(), "Updated", Toast.LENGTH_LONG).show();

            }
        });
        return myView;
    }
}
