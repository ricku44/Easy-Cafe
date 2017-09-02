package com.sample.manager;

import android.app.Fragment;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ThirdLayout extends Fragment {

    View myView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.third_layout, container, false);

        TextView textView1 = myView.findViewById(R.id.textView19);
        TextView textView2 = myView.findViewById(R.id.textView20);
        TextView textView3 = myView.findViewById(R.id.textView21);
        TextView textView4 = myView.findViewById(R.id.textView22);

        final int[] a = new int[100];
        final int[] b = new int[100];
        final int[] c = new int[100];

        MyDataBase myDataBase = new MyDataBase(getActivity().getApplicationContext());
        Cursor cursor1 = myDataBase.getsales("Main Course");
        if (cursor1.moveToFirst()) {
            while(!cursor1.isAfterLast()) {
                for(int p=0;p<cursor1.getCount();p++){
                    a[p] = cursor1.getInt(cursor1.getColumnIndex(MyDataBase.col21));
                    cursor1.moveToNext();
                }
            }
        }

        Cursor cursor2 = myDataBase.getsales("Deluxe Course");
        if (cursor1.moveToFirst()) {
            while(!cursor2.isAfterLast()) {
                for(int p=0;p<cursor2.getCount();p++){
                    b[p] = cursor2.getInt(cursor1.getColumnIndex(MyDataBase.col21));
                    cursor2.moveToNext();
                }
            }
        }

        Cursor cursor3 = myDataBase.getsales("Luxury Course");
        if (cursor1.moveToFirst()) {
            while(!cursor3.isAfterLast()) {
                for(int p=0;p<cursor3.getCount();p++){
                    c[p] = cursor3.getInt(cursor1.getColumnIndex(MyDataBase.col21));
                    cursor3.moveToNext();
                }
            }
        }


        int sum1 = 0, sum2 = 0, sum3 = 0, sum4;

        for (int i : a)
            sum1 += i;

        for (int i : b)
            sum1 += i;

        for (int i : c)
            sum1 += i;

        sum4 = sum1 + sum2 + sum3;

        String a1 = "Rs. "+sum1;
        String a2 = "Rs. "+sum2;
        String a3 = "Rs. "+sum3;
        String a4 = "Rs. "+sum4;



        textView1.setText(a1);
        textView2.setText(a2);
        textView3.setText(a3);
        textView4.setText(a4);


        return myView;
    }
}
