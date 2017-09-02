package com.sample.manager;

import android.content.Intent;
import android.database.Cursor;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.content.Context;
import android.support.v7.widget.ThemedSpinnerAdapter;
import android.content.res.Resources.Theme;
import android.widget.TextView;
import android.widget.Toast;
import java.text.DateFormat;
import java.util.Date;
import java.util.Objects;

public class Course extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);

        Intent intent = getIntent();
        final String table = intent.getStringExtra("TableNo");
        final String k = intent.getStringExtra("k");
        final String email = intent.getStringExtra("email");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if(getSupportActionBar() != null)
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        // Setup spinner
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setAdapter(new MyAdapter(
                toolbar.getContext(),
                new String[]{
                        "Main Course",
                        "Deluxe Course",
                        "Luxury Course",
                }));

        spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                switch (position){
                    case 0:
                            getSupportFragmentManager().beginTransaction()
                                .replace(R.id.container, PlaceholderFragment.newInstance(position + 1,table,k,email))
                                .commit();
                            break;

                    case 1:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.container, PlaceholderFragment2.newInstance(position + 1,table,k,email))
                                .commit();
                        break;

                    case 2:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.container, PlaceholderFragment3.newInstance(position + 1,table,k,email))
                                .commit();
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_course, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Toast.makeText(getApplicationContext(), R.string.c,Toast.LENGTH_LONG).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private static class MyAdapter extends ArrayAdapter<String> implements ThemedSpinnerAdapter {
        private final ThemedSpinnerAdapter.Helper mDropDownHelper;

        MyAdapter(Context context, String[] objects) {
            super(context, android.R.layout.simple_list_item_1, objects);
            mDropDownHelper = new ThemedSpinnerAdapter.Helper(context);
        }

        @Override
        public View getDropDownView(int position, View convertView, @NonNull ViewGroup parent) {
            View view;

            if (convertView == null) {
                // Inflate the drop down using the helper's LayoutInflater
                LayoutInflater inflater = mDropDownHelper.getDropDownViewInflater();
                view = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
            } else {
                view = convertView;
            }

            TextView textView = view.findViewById(android.R.id.text1);
            textView.setText(getItem(position));

            return view;
        }

        @Override
        public Theme getDropDownViewTheme() {
            return mDropDownHelper.getDropDownViewTheme();
        }

        @Override
        public void setDropDownViewTheme(Theme theme) {
            mDropDownHelper.setDropDownViewTheme(theme);
        }
    }

    public static class PlaceholderFragment extends Fragment {

        private static final String ARG_SECTION_NUMBER = "section_number";
        private static final String k = "K";
        private static final String ARG_TABLE_NUMBER = "table_number";
        private static final String ARG_EMAIL = "email";
        public PlaceholderFragment() {}

        public static PlaceholderFragment newInstance(int sectionNumber,String table,String k2, String email) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            args.putString(ARG_TABLE_NUMBER, table);
            args.putString(k, k2);
            args.putString(ARG_EMAIL,email);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            final View rootView = inflater.inflate(R.layout.first_tab, container, false);


            final TextView tV = rootView.findViewById(R.id.textView2);
            final TextView tV2 = rootView.findViewById(R.id.textView4);
            final EditText preb = rootView.findViewById(R.id.preb);

            final Spinner spinner1 = rootView.findViewById(R.id.spinner2);
            final Spinner spinner12 = rootView.findViewById(R.id.spinner21);
            final Spinner spinner13 = rootView.findViewById(R.id.spinner22);
            final Spinner spinner14 = rootView.findViewById(R.id.spinner23);
            final Spinner spinner15 = rootView.findViewById(R.id.spinner24);

            final Spinner spinner2 = rootView.findViewById(R.id.spinner3);
            final Spinner spinner22 = rootView.findViewById(R.id.spinner31);
            final Spinner spinner23 = rootView.findViewById(R.id.spinner32);
            final Spinner spinner24 = rootView.findViewById(R.id.spinner33);
            final Spinner spinner25 = rootView.findViewById(R.id.spinner34);

            final Spinner spinner3 = rootView.findViewById(R.id.spinner4);
            final Spinner spinner32 = rootView.findViewById(R.id.spinner41);
            final Spinner spinner33 = rootView.findViewById(R.id.spinner42);
            final Spinner spinner34 = rootView.findViewById(R.id.spinner43);
            final Spinner spinner35 = rootView.findViewById(R.id.spinner44);


            final RadioGroup radioGroup = rootView.findViewById(R.id.radioGroup);
            radioGroup.check(R.id.radioButton);


            final TextView textView8 = rootView.findViewById(R.id.textView8);
            final TextView textView9 = rootView.findViewById(R.id.textView9);
            final TextView textView10 = rootView.findViewById(R.id.textView10);
            final TextView textView11 = rootView.findViewById(R.id.textView11);
            final TextView textView12 = rootView.findViewById(R.id.textView12);


            final TextView textView8a = rootView.findViewById(R.id.textView8a);
            final TextView textView9a = rootView.findViewById(R.id.textView9a);
            final TextView textView10a = rootView.findViewById(R.id.textView10a);
            final TextView textView11a = rootView.findViewById(R.id.textView11a);
            final TextView textView12a = rootView.findViewById(R.id.textView12a);


            final TextView textView8b = rootView.findViewById(R.id.textView8b);
            final TextView textView9b = rootView.findViewById(R.id.textView9b);
            final TextView textView10b = rootView.findViewById(R.id.textView10b);
            final TextView textView11b = rootView.findViewById(R.id.textView11b);
            final TextView textView12b = rootView.findViewById(R.id.textView12b);



            tV.setText(String.format("%s%s", getResources().getString(R.string.tno), getArguments().getString(ARG_TABLE_NUMBER)));
            final String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());

            final String v=getArguments().getString(k);
            if(v!=null) {

                if (v.matches("2")) {
                    preb.setVisibility(View.VISIBLE);
                    tV2.setVisibility(View.GONE);
                } else {
                    preb.setVisibility(View.GONE);
                    tV2.setVisibility(View.VISIBLE);
                    tV2.setText(currentDateTimeString);
                }
            }


            final MyDataBase myDataBase = new MyDataBase(getActivity().getApplicationContext());
            final String[] a = new String[5];
            final String[] b = new String[5];
            final String[] c = new String[5];
            a[0] = b[0] = c[0] = getResources().getString(R.string.def);


            Cursor cursor10 = myDataBase.getfood2();
                if (cursor10.moveToFirst()) {
                    while(!cursor10.isAfterLast()) {
                        for(int p=0;p<12;p++){
                            if(p<4)
                                a[p+1] = cursor10.getString(cursor10.getColumnIndex(MyDataBase.colll2));

                            else if(p>7)
                                c[p-7] = cursor10.getString(cursor10.getColumnIndex(MyDataBase.colll2));

                            else
                                b[p-3] = cursor10.getString(cursor10.getColumnIndex(MyDataBase.colll2));

                            cursor10.moveToNext();
                        }
                    }
                }


            else {
                for(int p=1;p<5;p++){
                    a[p] = "ITEM";
                    b[p] = "ITEM";
                    c[p] = "ITEM";
                }
            }

            final ArrayAdapter<String> s2 = new ArrayAdapter<>(getActivity().getApplicationContext(),
                                                                              R.layout.spinnerlayout, a);

            final ArrayAdapter<String> s3 = new ArrayAdapter<>(getActivity().getApplicationContext(),
                    R.layout.spinnerlayout, b);

            final ArrayAdapter<String> s4 = new ArrayAdapter<>(getActivity().getApplicationContext(),
                    R.layout.spinnerlayout, c);

            spinner1.setAdapter(s2);
            spinner12.setAdapter(s2);
            spinner13.setAdapter(s2);
            spinner14.setAdapter(s2);
            spinner15.setAdapter(s2);

            spinner2.setAdapter(s3);
            spinner22.setAdapter(s3);
            spinner23.setAdapter(s3);
            spinner24.setAdapter(s3);
            spinner25.setAdapter(s3);

            spinner3.setAdapter(s4);
            spinner32.setAdapter(s4);
            spinner33.setAdapter(s4);
            spinner34.setAdapter(s4);
            spinner35.setAdapter(s4);



           radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {


                    textView8.setVisibility(View.GONE);
                    textView9.setVisibility(View.GONE);
                    textView10.setVisibility(View.GONE);
                    textView11.setVisibility(View.GONE);
                    textView12.setVisibility(View.GONE);

                    textView8a.setVisibility(View.GONE);
                    textView9a.setVisibility(View.GONE);
                    textView10a.setVisibility(View.GONE);
                    textView11a.setVisibility(View.GONE);
                    textView12a.setVisibility(View.GONE);

                    textView8b.setVisibility(View.GONE);
                    textView9b.setVisibility(View.GONE);
                    textView10b.setVisibility(View.GONE);
                    textView11b.setVisibility(View.GONE);
                    textView12b.setVisibility(View.GONE);

                    spinner22.setVisibility(View.GONE);
                    spinner23.setVisibility(View.GONE);
                    spinner24.setVisibility(View.GONE);
                    spinner25.setVisibility(View.GONE);

                    spinner32.setVisibility(View.GONE);
                    spinner33.setVisibility(View.GONE);
                    spinner34.setVisibility(View.GONE);
                    spinner35.setVisibility(View.GONE);

                    spinner1.setVisibility(View.VISIBLE);
                    spinner12.setVisibility(View.GONE);
                    spinner13.setVisibility(View.GONE);
                    spinner14.setVisibility(View.GONE);
                    spinner15.setVisibility(View.GONE);


                    if (i==R.id.radioButton) {
                        spinner1.setAdapter(s2);
                        spinner12.setAdapter(s2);
                        spinner13.setAdapter(s2);
                        spinner14.setAdapter(s2);
                        spinner15.setAdapter(s2);

                        spinner2.setAdapter(s3);
                        spinner22.setAdapter(s3);
                        spinner23.setAdapter(s3);
                        spinner24.setAdapter(s3);
                        spinner25.setAdapter(s3);

                        spinner3.setAdapter(s4);
                        spinner32.setAdapter(s4);
                        spinner33.setAdapter(s4);
                        spinner34.setAdapter(s4);
                        spinner35.setAdapter(s4);
                    }

                    else if(i==R.id.radioButton2)
                    {
                        spinner1.setAdapter(s2);
                        spinner12.setAdapter(s2);
                        spinner13.setAdapter(s2);
                        spinner14.setAdapter(s2);
                        spinner15.setAdapter(s2);

                        spinner2.setAdapter(s3);
                        spinner22.setAdapter(s3);
                        spinner23.setAdapter(s3);
                        spinner24.setAdapter(s3);
                        spinner25.setAdapter(s3);

                        spinner3.setAdapter(s4);
                        spinner32.setAdapter(s4);
                        spinner33.setAdapter(s4);
                        spinner34.setAdapter(s4);
                        spinner35.setAdapter(s4);
                    }
                }
            });

            spinner1.setOnItemSelectedListener(new OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    textView8.setText(spinner1.getSelectedItem().toString());
                    if (i != 0) {
                        textView8.setVisibility(View.VISIBLE);
                        spinner1.setVisibility(View.GONE);
                        spinner12.setVisibility(View.VISIBLE);
                    }
                }
                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {}
            });

            spinner12.setOnItemSelectedListener(new OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    textView9.setText(spinner12.getSelectedItem().toString());
                    if (i != 0) {
                        textView9.setVisibility(View.VISIBLE);
                        spinner12.setVisibility(View.GONE);
                        spinner13.setVisibility(View.VISIBLE);
                    }
                }
                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {}
            });

            spinner13.setOnItemSelectedListener(new OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    textView10.setText(spinner13.getSelectedItem().toString());
                    if (i != 0) {
                        textView10.setVisibility(View.VISIBLE);
                        spinner13.setVisibility(View.GONE);
                        spinner14.setVisibility(View.VISIBLE);
                    }
                }
                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {}
            });

            spinner14.setOnItemSelectedListener(new OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    textView11.setText(spinner14.getSelectedItem().toString());
                    if (i != 0) {
                        textView11.setVisibility(View.VISIBLE);
                        spinner14.setVisibility(View.GONE);
                        spinner15.setVisibility(View.VISIBLE);
                    }
                }
                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {}
            });

            spinner15.setOnItemSelectedListener(new OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    textView12.setText(spinner15.getSelectedItem().toString());
                    if (i != 0) {
                        textView12.setVisibility(View.VISIBLE);
                        spinner15.setVisibility(View.GONE);
                    }
                }
                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {}
            });



            spinner2.setOnItemSelectedListener(new OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    textView8a.setText(spinner2.getSelectedItem().toString());
                    if (i != 0) {
                        textView8a.setVisibility(View.VISIBLE);
                        spinner2.setVisibility(View.GONE);
                        spinner22.setVisibility(View.VISIBLE);
                    }
                }
                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {}
            });

            spinner22.setOnItemSelectedListener(new OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    textView9a.setText(spinner22.getSelectedItem().toString());
                    if (i != 0) {
                        textView9a.setVisibility(View.VISIBLE);
                        spinner22.setVisibility(View.GONE);
                        spinner23.setVisibility(View.VISIBLE);
                    }
                }
                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {}
            });

            spinner23.setOnItemSelectedListener(new OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    textView10a.setText(spinner23.getSelectedItem().toString());
                    if (i != 0) {
                        textView10a.setVisibility(View.VISIBLE);
                        spinner23.setVisibility(View.GONE);
                        spinner24.setVisibility(View.VISIBLE);
                    }
                }
                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {}
            });

            spinner24.setOnItemSelectedListener(new OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    textView11a.setText(spinner24.getSelectedItem().toString());
                    if (i != 0) {
                        textView11a.setVisibility(View.VISIBLE);
                        spinner24.setVisibility(View.GONE);
                        spinner25.setVisibility(View.VISIBLE);
                    }
                }
                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {}
            });

            spinner25.setOnItemSelectedListener(new OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    textView12a.setText(spinner25.getSelectedItem().toString());
                    if (i != 0) {
                        textView12a.setVisibility(View.VISIBLE);
                        spinner25.setVisibility(View.GONE);
                    }
                }
                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {}
            });


            spinner3.setOnItemSelectedListener(new OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    textView8b.setText(spinner3.getSelectedItem().toString());
                    if (i != 0) {
                        textView8b.setVisibility(View.VISIBLE);
                        spinner3.setVisibility(View.GONE);
                        spinner32.setVisibility(View.VISIBLE);
                    }
                }
                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {}
            });

            spinner32.setOnItemSelectedListener(new OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    textView9b.setText(spinner32.getSelectedItem().toString());
                    if (i != 0) {
                        textView9b.setVisibility(View.VISIBLE);
                        spinner32.setVisibility(View.GONE);
                        spinner33.setVisibility(View.VISIBLE);
                    }
                }
                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {}
            });

            spinner33.setOnItemSelectedListener(new OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    textView10b.setText(spinner33.getSelectedItem().toString());
                    if (i != 0) {
                        textView10b.setVisibility(View.VISIBLE);
                        spinner33.setVisibility(View.GONE);
                        spinner34.setVisibility(View.VISIBLE);
                    }
                }
                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {}
            });

            spinner34.setOnItemSelectedListener(new OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    textView11b.setText(spinner34.getSelectedItem().toString());
                    if (i != 0) {
                        textView11b.setVisibility(View.VISIBLE);
                        spinner34.setVisibility(View.GONE);
                        spinner35.setVisibility(View.VISIBLE);
                    }
                }
                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {}
            });

            spinner35.setOnItemSelectedListener(new OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    textView12b.setText(spinner35.getSelectedItem().toString());
                    if (i != 0) {
                        textView12b.setVisibility(View.VISIBLE);
                        spinner35.setVisibility(View.GONE);
                    }
                }
                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {}
            });

            Button button = rootView.findViewById(R.id.book);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String starter = textView8.getText().toString();
                    String main = textView8a.getText().toString();
                    String dessert = textView8b.getText().toString();

                    if(starter.matches(getResources().getString(R.string.def))){
                        Toast.makeText(getActivity().getApplicationContext(),"Select Starter",Toast.LENGTH_SHORT).show();
                    }

                    else if(main.matches(getResources().getString(R.string.def))){
                        Toast.makeText(getActivity().getApplicationContext(),"Select Main",Toast.LENGTH_SHORT).show();
                    }

                    else if(dessert.matches(getResources().getString(R.string.def))){
                        Toast.makeText(getActivity().getApplicationContext(),"Select Dessert",Toast.LENGTH_SHORT).show();
                    }


                    else {


                        RadioButton radioButton = rootView.findViewById(radioGroup.getCheckedRadioButtonId());

                        Intent intent = new Intent(getActivity().getApplicationContext(),Review.class);

                        intent.putExtra("tableno", tV.getText().toString());
                        if(v!=null) {
                            if (v.matches("1")&& !Objects.equals(preb.getText().toString(), ""))
                                intent.putExtra("time", preb.getText().toString());

                            else
                                intent.putExtra("time", tV2.getText().toString());
                        }                        intent.putExtra("vn", radioButton.getText().toString());

                        intent.putExtra("starter1",textView8.getText().toString());
                        intent.putExtra("starter2",textView9.getText().toString());
                        intent.putExtra("starter3",textView10.getText().toString());
                        intent.putExtra("starter4",textView11.getText().toString());
                        intent.putExtra("starter5",textView12.getText().toString());

                        intent.putExtra("main1",textView8a.getText().toString());
                        intent.putExtra("main2",textView9a.getText().toString());
                        intent.putExtra("main3",textView10a.getText().toString());
                        intent.putExtra("main4",textView11a.getText().toString());
                        intent.putExtra("main5",textView12a.getText().toString());

                        intent.putExtra("dessert1",textView8b.getText().toString());
                        intent.putExtra("dessert2",textView9b.getText().toString());
                        intent.putExtra("dessert3",textView10b.getText().toString());
                        intent.putExtra("dessert4",textView11b.getText().toString());
                        intent.putExtra("dessert5",textView12b.getText().toString());

                        intent.putExtra("email",getArguments().getString(ARG_EMAIL));

                        intent.putExtra("course","Main Course");

                        startActivity(intent);
                    }
                }
            });

            return rootView;
        }
    }

    public static class PlaceholderFragment2 extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";
        private static final String k = "section_number";
        private static final String ARG_TABLE_NUMBER = "table_number";
        private static final String ARG_EMAIL = "email";


        public PlaceholderFragment2() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment2 newInstance(int sectionNumber, String table,String k2, String email) {
            PlaceholderFragment2 fragment = new PlaceholderFragment2();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            args.putString(ARG_TABLE_NUMBER, table);
            args.putString(k, k2);
            args.putString(ARG_EMAIL,email);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            final View rootView = inflater.inflate(R.layout.second_tab, container, false);

            final TextView tV = rootView.findViewById(R.id.textView2);
            final TextView tV2 = rootView.findViewById(R.id.textView4);
            final EditText preb = rootView.findViewById(R.id.preb);

            final Spinner spinner1 = rootView.findViewById(R.id.spinner2);
            final Spinner spinner12 = rootView.findViewById(R.id.spinner21);
            final Spinner spinner13 = rootView.findViewById(R.id.spinner22);
            final Spinner spinner14 = rootView.findViewById(R.id.spinner23);
            final Spinner spinner15 = rootView.findViewById(R.id.spinner24);

            final Spinner spinner2 = rootView.findViewById(R.id.spinner3);
            final Spinner spinner22 = rootView.findViewById(R.id.spinner31);
            final Spinner spinner23 = rootView.findViewById(R.id.spinner32);
            final Spinner spinner24 = rootView.findViewById(R.id.spinner33);
            final Spinner spinner25 = rootView.findViewById(R.id.spinner34);

            final Spinner spinner3 = rootView.findViewById(R.id.spinner4);
            final Spinner spinner32 = rootView.findViewById(R.id.spinner41);
            final Spinner spinner33 = rootView.findViewById(R.id.spinner42);
            final Spinner spinner34 = rootView.findViewById(R.id.spinner43);
            final Spinner spinner35 = rootView.findViewById(R.id.spinner44);


            final RadioGroup radioGroup = rootView.findViewById(R.id.radioGroup);
            radioGroup.check(R.id.radioButton);


            final TextView textView8 = rootView.findViewById(R.id.textView8);
            final TextView textView9 = rootView.findViewById(R.id.textView9);
            final TextView textView10 = rootView.findViewById(R.id.textView10);
            final TextView textView11 = rootView.findViewById(R.id.textView11);
            final TextView textView12 = rootView.findViewById(R.id.textView12);


            final TextView textView8a = rootView.findViewById(R.id.textView8a);
            final TextView textView9a = rootView.findViewById(R.id.textView9a);
            final TextView textView10a = rootView.findViewById(R.id.textView10a);
            final TextView textView11a = rootView.findViewById(R.id.textView11a);
            final TextView textView12a = rootView.findViewById(R.id.textView12a);


            final TextView textView8b = rootView.findViewById(R.id.textView8b);
            final TextView textView9b = rootView.findViewById(R.id.textView9b);
            final TextView textView10b = rootView.findViewById(R.id.textView10b);
            final TextView textView11b = rootView.findViewById(R.id.textView11b);
            final TextView textView12b = rootView.findViewById(R.id.textView12b);




            tV.setText(String.format("%s%s", getResources().getString(R.string.tno), getArguments().getString(ARG_TABLE_NUMBER)));
            final String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());

            final String v=getArguments().getString(k);
            if(v!=null){
                if(v.matches("2"))
                {
                    preb.setVisibility(View.VISIBLE);
                    tV2.setVisibility(View.GONE);
                }
                else {
                    preb.setVisibility(View.GONE);
                    tV2.setVisibility(View.VISIBLE);
                    tV2.setText(currentDateTimeString);
                }
            }

            final MyDataBase myDataBase = new MyDataBase(getActivity().getApplicationContext());
            final String[] a = new String[5];
            final String[] b = new String[5];
            final String[] c = new String[5];
            a[0] = b[0] = c[0] = getResources().getString(R.string.def);


            Cursor cursor10 = myDataBase.getfood2();
            if (cursor10.moveToFirst()) {
                while(!cursor10.isAfterLast()) {
                    for(int p=0;p<12;p++){
                        if(p<4)
                            a[p+1] = cursor10.getString(cursor10.getColumnIndex(MyDataBase.colll2));

                        else if(p>7)
                            c[p-7] = cursor10.getString(cursor10.getColumnIndex(MyDataBase.colll2));

                        else
                            b[p-3] = cursor10.getString(cursor10.getColumnIndex(MyDataBase.colll2));

                        cursor10.moveToNext();
                    }
                }
            }


            else {
                for(int p=1;p<5;p++){
                    a[p] = "ITEM";
                    b[p] = "ITEM";
                    c[p] = "ITEM";
                }
            }

            final ArrayAdapter<String> s2 = new ArrayAdapter<>(getActivity().getApplicationContext(),
                    R.layout.spinnerlayout, a);

            final ArrayAdapter<String> s3 = new ArrayAdapter<>(getActivity().getApplicationContext(),
                    R.layout.spinnerlayout, b);

            final ArrayAdapter<String> s4 = new ArrayAdapter<>(getActivity().getApplicationContext(),
                    R.layout.spinnerlayout, c);


            spinner1.setAdapter(s2);
            spinner12.setAdapter(s2);
            spinner13.setAdapter(s2);
            spinner14.setAdapter(s2);
            spinner15.setAdapter(s2);

            spinner2.setAdapter(s3);
            spinner22.setAdapter(s3);
            spinner23.setAdapter(s3);
            spinner24.setAdapter(s3);
            spinner25.setAdapter(s3);

            spinner3.setAdapter(s4);
            spinner32.setAdapter(s4);
            spinner33.setAdapter(s4);
            spinner34.setAdapter(s4);
            spinner35.setAdapter(s4);




            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {


                    textView8.setVisibility(View.GONE);
                    textView9.setVisibility(View.GONE);
                    textView10.setVisibility(View.GONE);
                    textView11.setVisibility(View.GONE);
                    textView12.setVisibility(View.GONE);

                    textView8a.setVisibility(View.GONE);
                    textView9a.setVisibility(View.GONE);
                    textView10a.setVisibility(View.GONE);
                    textView11a.setVisibility(View.GONE);
                    textView12a.setVisibility(View.GONE);

                    textView8b.setVisibility(View.GONE);
                    textView9b.setVisibility(View.GONE);
                    textView10b.setVisibility(View.GONE);
                    textView11b.setVisibility(View.GONE);
                    textView12b.setVisibility(View.GONE);

                    spinner22.setVisibility(View.GONE);
                    spinner23.setVisibility(View.GONE);
                    spinner24.setVisibility(View.GONE);
                    spinner25.setVisibility(View.GONE);

                    spinner32.setVisibility(View.GONE);
                    spinner33.setVisibility(View.GONE);
                    spinner34.setVisibility(View.GONE);
                    spinner35.setVisibility(View.GONE);

                    spinner1.setVisibility(View.VISIBLE);
                    spinner12.setVisibility(View.GONE);
                    spinner13.setVisibility(View.GONE);
                    spinner14.setVisibility(View.GONE);
                    spinner15.setVisibility(View.GONE);


                    if (i==R.id.radioButton) {
                        spinner1.setAdapter(s2);
                        spinner12.setAdapter(s2);
                        spinner13.setAdapter(s2);
                        spinner14.setAdapter(s2);
                        spinner15.setAdapter(s2);

                        spinner2.setAdapter(s3);
                        spinner22.setAdapter(s3);
                        spinner23.setAdapter(s3);
                        spinner24.setAdapter(s3);
                        spinner25.setAdapter(s3);

                        spinner3.setAdapter(s4);
                        spinner32.setAdapter(s4);
                        spinner33.setAdapter(s4);
                        spinner34.setAdapter(s4);
                        spinner35.setAdapter(s4);
                    }

                    else if(i==R.id.radioButton2)
                    {
                        spinner1.setAdapter(s2);
                        spinner12.setAdapter(s2);
                        spinner13.setAdapter(s2);
                        spinner14.setAdapter(s2);
                        spinner15.setAdapter(s2);

                        spinner2.setAdapter(s3);
                        spinner22.setAdapter(s3);
                        spinner23.setAdapter(s3);
                        spinner24.setAdapter(s3);
                        spinner25.setAdapter(s3);

                        spinner3.setAdapter(s4);
                        spinner32.setAdapter(s4);
                        spinner33.setAdapter(s4);
                        spinner34.setAdapter(s4);
                        spinner35.setAdapter(s4);
                    }
                }
            });

            spinner1.setOnItemSelectedListener(new OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    textView8.setText(spinner1.getSelectedItem().toString());
                    if (i != 0) {
                        textView8.setVisibility(View.VISIBLE);
                        spinner1.setVisibility(View.GONE);
                        spinner12.setVisibility(View.VISIBLE);
                    }
                }
                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {}
            });

            spinner12.setOnItemSelectedListener(new OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    textView9.setText(spinner12.getSelectedItem().toString());
                    if (i != 0) {
                        textView9.setVisibility(View.VISIBLE);
                        spinner12.setVisibility(View.GONE);
                        spinner13.setVisibility(View.VISIBLE);
                    }
                }
                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {}
            });

            spinner13.setOnItemSelectedListener(new OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    textView10.setText(spinner13.getSelectedItem().toString());
                    if (i != 0) {
                        textView10.setVisibility(View.VISIBLE);
                        spinner13.setVisibility(View.GONE);
                        spinner14.setVisibility(View.VISIBLE);
                    }
                }
                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {}
            });

            spinner14.setOnItemSelectedListener(new OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    textView11.setText(spinner14.getSelectedItem().toString());
                    if (i != 0) {
                        textView11.setVisibility(View.VISIBLE);
                        spinner14.setVisibility(View.GONE);
                        spinner15.setVisibility(View.VISIBLE);
                    }
                }
                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {}
            });

            spinner15.setOnItemSelectedListener(new OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    textView12.setText(spinner15.getSelectedItem().toString());
                    if (i != 0) {
                        textView12.setVisibility(View.VISIBLE);
                        spinner15.setVisibility(View.GONE);
                    }
                }
                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {}
            });






            spinner2.setOnItemSelectedListener(new OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    textView8a.setText(spinner2.getSelectedItem().toString());
                    if (i != 0) {
                        textView8a.setVisibility(View.VISIBLE);
                        spinner2.setVisibility(View.GONE);
                        spinner22.setVisibility(View.VISIBLE);
                    }
                }
                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {}
            });

            spinner22.setOnItemSelectedListener(new OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    textView9a.setText(spinner22.getSelectedItem().toString());
                    if (i != 0) {
                        textView9a.setVisibility(View.VISIBLE);
                        spinner22.setVisibility(View.GONE);
                        spinner23.setVisibility(View.VISIBLE);
                    }
                }
                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {}
            });

            spinner23.setOnItemSelectedListener(new OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    textView10a.setText(spinner23.getSelectedItem().toString());
                    if (i != 0) {
                        textView10a.setVisibility(View.VISIBLE);
                        spinner23.setVisibility(View.GONE);
                        spinner24.setVisibility(View.VISIBLE);
                    }
                }
                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {}
            });

            spinner24.setOnItemSelectedListener(new OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    textView11a.setText(spinner24.getSelectedItem().toString());
                    if (i != 0) {
                        textView11a.setVisibility(View.VISIBLE);
                        spinner24.setVisibility(View.GONE);
                        spinner25.setVisibility(View.VISIBLE);
                    }
                }
                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {}
            });

            spinner25.setOnItemSelectedListener(new OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    textView12a.setText(spinner25.getSelectedItem().toString());
                    if (i != 0) {
                        textView12a.setVisibility(View.VISIBLE);
                        spinner25.setVisibility(View.GONE);
                    }
                }
                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {}
            });




            spinner3.setOnItemSelectedListener(new OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    textView8b.setText(spinner3.getSelectedItem().toString());
                    if (i != 0) {
                        textView8b.setVisibility(View.VISIBLE);
                        spinner3.setVisibility(View.GONE);
                        spinner32.setVisibility(View.VISIBLE);
                    }
                }
                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {}
            });

            spinner32.setOnItemSelectedListener(new OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    textView9b.setText(spinner32.getSelectedItem().toString());
                    if (i != 0) {
                        textView9b.setVisibility(View.VISIBLE);
                        spinner32.setVisibility(View.GONE);
                        spinner33.setVisibility(View.VISIBLE);
                    }
                }
                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {}
            });

            spinner33.setOnItemSelectedListener(new OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    textView10b.setText(spinner33.getSelectedItem().toString());
                    if (i != 0) {
                        textView10b.setVisibility(View.VISIBLE);
                        spinner33.setVisibility(View.GONE);
                        spinner34.setVisibility(View.VISIBLE);
                    }
                }
                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {}
            });

            spinner34.setOnItemSelectedListener(new OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    textView11b.setText(spinner34.getSelectedItem().toString());
                    if (i != 0) {
                        textView11b.setVisibility(View.VISIBLE);
                        spinner34.setVisibility(View.GONE);
                        spinner35.setVisibility(View.VISIBLE);
                    }
                }
                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {}
            });

            spinner35.setOnItemSelectedListener(new OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    textView12b.setText(spinner35.getSelectedItem().toString());
                    if (i != 0) {
                        textView12b.setVisibility(View.VISIBLE);
                        spinner35.setVisibility(View.GONE);
                    }
                }
                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {}
            });


            Button button = rootView.findViewById(R.id.book);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String starter = textView8.getText().toString();
                    String main = textView8a.getText().toString();
                    String dessert = textView8b.getText().toString();

                    if(starter.matches(getResources().getString(R.string.def))){
                        Toast.makeText(getActivity().getApplicationContext(),"Select Starter",Toast.LENGTH_SHORT).show();
                    }

                    else if(main.matches(getResources().getString(R.string.def))){
                        Toast.makeText(getActivity().getApplicationContext(),"Select Main",Toast.LENGTH_SHORT).show();
                    }

                    else if(dessert.matches(getResources().getString(R.string.def))){
                        Toast.makeText(getActivity().getApplicationContext(),"Select Dessert",Toast.LENGTH_SHORT).show();
                    }


                    else {

                        RadioButton radioButton = rootView.findViewById(radioGroup.getCheckedRadioButtonId());

                        Intent intent = new Intent(getActivity().getApplicationContext(),Review.class);

                        intent.putExtra("tableno", tV.getText().toString());
                        if(v!=null) {
                            if (v.matches("1")&& !Objects.equals(preb.getText().toString(), ""))
                                intent.putExtra("time", preb.getText().toString());

                            else
                                intent.putExtra("time", tV2.getText().toString());
                        }                        intent.putExtra("vn", radioButton.getText().toString());

                        intent.putExtra("starter1",textView8.getText().toString());
                        intent.putExtra("starter2",textView9.getText().toString());
                        intent.putExtra("starter3",textView10.getText().toString());
                        intent.putExtra("starter4",textView11.getText().toString());
                        intent.putExtra("starter5",textView12.getText().toString());

                        intent.putExtra("main1",textView8a.getText().toString());
                        intent.putExtra("main2",textView9a.getText().toString());
                        intent.putExtra("main3",textView10a.getText().toString());
                        intent.putExtra("main4",textView11a.getText().toString());
                        intent.putExtra("main5",textView12a.getText().toString());

                        intent.putExtra("dessert1",textView8b.getText().toString());
                        intent.putExtra("dessert2",textView9b.getText().toString());
                        intent.putExtra("dessert3",textView10b.getText().toString());
                        intent.putExtra("dessert4",textView11b.getText().toString());
                        intent.putExtra("dessert5",textView12b.getText().toString());

                        intent.putExtra("email",getArguments().getString(ARG_EMAIL));

                        intent.putExtra("course","Deluxe Course");

                        startActivity(intent);
                    }
                }
            });

            return rootView;
        }
    }

    public static class PlaceholderFragment3 extends Fragment {

        private static final String ARG_SECTION_NUMBER = "section_number";
        private static final String k = "section_number";
        private static final String ARG_TABLE_NUMBER = "table_number";
        private static final String ARG_EMAIL = "email";

        public PlaceholderFragment3() {}

        public static PlaceholderFragment3 newInstance(int sectionNumber,String table,String k2, String email) {
            PlaceholderFragment3 fragment = new PlaceholderFragment3();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            args.putString(ARG_TABLE_NUMBER, table);
            args.putString(k, k2);
            args.putString(ARG_EMAIL,email);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            final View rootView = inflater.inflate(R.layout.third_tab, container, false);

            final TextView tV = rootView.findViewById(R.id.textView2);
            final TextView tV2 = rootView.findViewById(R.id.textView4);
            final EditText preb = rootView.findViewById(R.id.preb);

            final Spinner spinner1 = rootView.findViewById(R.id.spinner2);
            final Spinner spinner12 = rootView.findViewById(R.id.spinner21);
            final Spinner spinner13 = rootView.findViewById(R.id.spinner22);
            final Spinner spinner14 = rootView.findViewById(R.id.spinner23);
            final Spinner spinner15 = rootView.findViewById(R.id.spinner24);

            final Spinner spinner2 = rootView.findViewById(R.id.spinner3);
            final Spinner spinner22 = rootView.findViewById(R.id.spinner31);
            final Spinner spinner23 = rootView.findViewById(R.id.spinner32);
            final Spinner spinner24 = rootView.findViewById(R.id.spinner33);
            final Spinner spinner25 = rootView.findViewById(R.id.spinner34);

            final Spinner spinner3 = rootView.findViewById(R.id.spinner4);
            final Spinner spinner32 = rootView.findViewById(R.id.spinner41);
            final Spinner spinner33 = rootView.findViewById(R.id.spinner42);
            final Spinner spinner34 = rootView.findViewById(R.id.spinner43);
            final Spinner spinner35 = rootView.findViewById(R.id.spinner44);


            final RadioGroup radioGroup = rootView.findViewById(R.id.radioGroup);
            radioGroup.check(R.id.radioButton);


            final TextView textView8 = rootView.findViewById(R.id.textView8);
            final TextView textView9 = rootView.findViewById(R.id.textView9);
            final TextView textView10 = rootView.findViewById(R.id.textView10);
            final TextView textView11 = rootView.findViewById(R.id.textView11);
            final TextView textView12 = rootView.findViewById(R.id.textView12);


            final TextView textView8a = rootView.findViewById(R.id.textView8a);
            final TextView textView9a = rootView.findViewById(R.id.textView9a);
            final TextView textView10a = rootView.findViewById(R.id.textView10a);
            final TextView textView11a = rootView.findViewById(R.id.textView11a);
            final TextView textView12a = rootView.findViewById(R.id.textView12a);


            final TextView textView8b = rootView.findViewById(R.id.textView8b);
            final TextView textView9b = rootView.findViewById(R.id.textView9b);
            final TextView textView10b = rootView.findViewById(R.id.textView10b);
            final TextView textView11b = rootView.findViewById(R.id.textView11b);
            final TextView textView12b = rootView.findViewById(R.id.textView12b);

            tV.setText(String.format("%s%s", getResources().getString(R.string.tno), getArguments().getString(ARG_TABLE_NUMBER)));
            final String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());

            final String v=getArguments().getString(k);
            if(v!=null) {
                if (v.matches("2")) {
                    preb.setVisibility(View.VISIBLE);
                    tV2.setVisibility(View.GONE);
                } else {
                    preb.setVisibility(View.GONE);
                    tV2.setVisibility(View.VISIBLE);
                    tV2.setText(currentDateTimeString);
                }
            }

            final MyDataBase myDataBase = new MyDataBase(getActivity().getApplicationContext());
            final String[] a = new String[5];
            final String[] b = new String[5];
            final String[] c = new String[5];
            a[0] = b[0] = c[0] = getResources().getString(R.string.def);


            Cursor cursor10 = myDataBase.getfood2();
            if (cursor10.moveToFirst()) {
                while(!cursor10.isAfterLast()) {
                    for(int p=0;p<12;p++){
                        if(p<4)
                            a[p+1] = cursor10.getString(cursor10.getColumnIndex(MyDataBase.colll2));

                        else if(p>7)
                            c[p-7] = cursor10.getString(cursor10.getColumnIndex(MyDataBase.colll2));

                        else
                            b[p-3] = cursor10.getString(cursor10.getColumnIndex(MyDataBase.colll2));

                        cursor10.moveToNext();
                    }
                }
            }


            else {

                for(int p=1;p<5;p++){
                    a[p] = "ITEM";
                    b[p] = "ITEM";
                    c[p] = "ITEM";
                }
            }

            final ArrayAdapter<String> s2 = new ArrayAdapter<>(getActivity().getApplicationContext(),
                    R.layout.spinnerlayout, a);

            final ArrayAdapter<String> s3 = new ArrayAdapter<>(getActivity().getApplicationContext(),
                    R.layout.spinnerlayout, b);

            final ArrayAdapter<String> s4 = new ArrayAdapter<>(getActivity().getApplicationContext(),
                    R.layout.spinnerlayout, c);


            spinner1.setAdapter(s2);
            spinner12.setAdapter(s2);
            spinner13.setAdapter(s2);
            spinner14.setAdapter(s2);
            spinner15.setAdapter(s2);

            spinner2.setAdapter(s3);
            spinner22.setAdapter(s3);
            spinner23.setAdapter(s3);
            spinner24.setAdapter(s3);
            spinner25.setAdapter(s3);

            spinner3.setAdapter(s4);
            spinner32.setAdapter(s4);
            spinner33.setAdapter(s4);
            spinner34.setAdapter(s4);
            spinner35.setAdapter(s4);



            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {


                    textView8.setVisibility(View.GONE);
                    textView9.setVisibility(View.GONE);
                    textView10.setVisibility(View.GONE);
                    textView11.setVisibility(View.GONE);
                    textView12.setVisibility(View.GONE);

                    textView8a.setVisibility(View.GONE);
                    textView9a.setVisibility(View.GONE);
                    textView10a.setVisibility(View.GONE);
                    textView11a.setVisibility(View.GONE);
                    textView12a.setVisibility(View.GONE);

                    textView8b.setVisibility(View.GONE);
                    textView9b.setVisibility(View.GONE);
                    textView10b.setVisibility(View.GONE);
                    textView11b.setVisibility(View.GONE);
                    textView12b.setVisibility(View.GONE);

                    spinner22.setVisibility(View.GONE);
                    spinner23.setVisibility(View.GONE);
                    spinner24.setVisibility(View.GONE);
                    spinner25.setVisibility(View.GONE);

                    spinner32.setVisibility(View.GONE);
                    spinner33.setVisibility(View.GONE);
                    spinner34.setVisibility(View.GONE);
                    spinner35.setVisibility(View.GONE);

                    spinner1.setVisibility(View.VISIBLE);
                    spinner12.setVisibility(View.GONE);
                    spinner13.setVisibility(View.GONE);
                    spinner14.setVisibility(View.GONE);
                    spinner15.setVisibility(View.GONE);


                    if (i==R.id.radioButton) {
                        spinner1.setAdapter(s2);
                        spinner12.setAdapter(s2);
                        spinner13.setAdapter(s2);
                        spinner14.setAdapter(s2);
                        spinner15.setAdapter(s2);

                        spinner2.setAdapter(s3);
                        spinner22.setAdapter(s3);
                        spinner23.setAdapter(s3);
                        spinner24.setAdapter(s3);
                        spinner25.setAdapter(s3);

                        spinner3.setAdapter(s4);
                        spinner32.setAdapter(s4);
                        spinner33.setAdapter(s4);
                        spinner34.setAdapter(s4);
                        spinner35.setAdapter(s4);
                    }

                    else if(i==R.id.radioButton2)
                    {
                        spinner1.setAdapter(s2);
                        spinner12.setAdapter(s2);
                        spinner13.setAdapter(s2);
                        spinner14.setAdapter(s2);
                        spinner15.setAdapter(s2);

                        spinner2.setAdapter(s3);
                        spinner22.setAdapter(s3);
                        spinner23.setAdapter(s3);
                        spinner24.setAdapter(s3);
                        spinner25.setAdapter(s3);

                        spinner3.setAdapter(s4);
                        spinner32.setAdapter(s4);
                        spinner33.setAdapter(s4);
                        spinner34.setAdapter(s4);
                        spinner35.setAdapter(s4);
                    }
                }
            });

            spinner1.setOnItemSelectedListener(new OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    textView8.setText(spinner1.getSelectedItem().toString());
                    if (i != 0) {
                        textView8.setVisibility(View.VISIBLE);
                        spinner1.setVisibility(View.GONE);
                        spinner12.setVisibility(View.VISIBLE);
                    }
                }
                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {}
            });

            spinner12.setOnItemSelectedListener(new OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    textView9.setText(spinner12.getSelectedItem().toString());
                    if (i != 0) {
                        textView9.setVisibility(View.VISIBLE);
                        spinner12.setVisibility(View.GONE);
                        spinner13.setVisibility(View.VISIBLE);
                    }
                }
                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {}
            });

            spinner13.setOnItemSelectedListener(new OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    textView10.setText(spinner13.getSelectedItem().toString());
                    if (i != 0) {
                        textView10.setVisibility(View.VISIBLE);
                        spinner13.setVisibility(View.GONE);
                        spinner14.setVisibility(View.VISIBLE);
                    }
                }
                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {}
            });

            spinner14.setOnItemSelectedListener(new OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    textView11.setText(spinner14.getSelectedItem().toString());
                    if (i != 0) {
                        textView11.setVisibility(View.VISIBLE);
                        spinner14.setVisibility(View.GONE);
                        spinner15.setVisibility(View.VISIBLE);
                    }
                }
                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {}
            });

            spinner15.setOnItemSelectedListener(new OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    textView12.setText(spinner15.getSelectedItem().toString());
                    if (i != 0) {
                        textView12.setVisibility(View.VISIBLE);
                        spinner15.setVisibility(View.GONE);
                    }
                }
                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {}
            });






            spinner2.setOnItemSelectedListener(new OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    textView8a.setText(spinner2.getSelectedItem().toString());
                    if (i != 0) {
                        textView8a.setVisibility(View.VISIBLE);
                        spinner2.setVisibility(View.GONE);
                        spinner22.setVisibility(View.VISIBLE);
                    }
                }
                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {}
            });

            spinner22.setOnItemSelectedListener(new OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    textView9a.setText(spinner22.getSelectedItem().toString());
                    if (i != 0) {
                        textView9a.setVisibility(View.VISIBLE);
                        spinner22.setVisibility(View.GONE);
                        spinner23.setVisibility(View.VISIBLE);
                    }
                }
                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {}
            });

            spinner23.setOnItemSelectedListener(new OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    textView10a.setText(spinner23.getSelectedItem().toString());
                    if (i != 0) {
                        textView10a.setVisibility(View.VISIBLE);
                        spinner23.setVisibility(View.GONE);
                        spinner24.setVisibility(View.VISIBLE);
                    }
                }
                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {}
            });

            spinner24.setOnItemSelectedListener(new OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    textView11a.setText(spinner24.getSelectedItem().toString());
                    if (i != 0) {
                        textView11a.setVisibility(View.VISIBLE);
                        spinner24.setVisibility(View.GONE);
                        spinner25.setVisibility(View.VISIBLE);
                    }
                }
                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {}
            });

            spinner25.setOnItemSelectedListener(new OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    textView12a.setText(spinner25.getSelectedItem().toString());
                    if (i != 0) {
                        textView12a.setVisibility(View.VISIBLE);
                        spinner25.setVisibility(View.GONE);
                    }
                }
                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {}
            });




            spinner3.setOnItemSelectedListener(new OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    textView8b.setText(spinner3.getSelectedItem().toString());
                    if (i != 0) {
                        textView8b.setVisibility(View.VISIBLE);
                        spinner3.setVisibility(View.GONE);
                        spinner32.setVisibility(View.VISIBLE);
                    }
                }
                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {}
            });

            spinner32.setOnItemSelectedListener(new OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    textView9b.setText(spinner32.getSelectedItem().toString());
                    if (i != 0) {
                        textView9b.setVisibility(View.VISIBLE);
                        spinner32.setVisibility(View.GONE);
                        spinner33.setVisibility(View.VISIBLE);
                    }
                }
                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {}
            });

            spinner33.setOnItemSelectedListener(new OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    textView10b.setText(spinner33.getSelectedItem().toString());
                    if (i != 0) {
                        textView10b.setVisibility(View.VISIBLE);
                        spinner33.setVisibility(View.GONE);
                        spinner34.setVisibility(View.VISIBLE);
                    }
                }
                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {}
            });

            spinner34.setOnItemSelectedListener(new OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    textView11b.setText(spinner34.getSelectedItem().toString());
                    if (i != 0) {
                        textView11b.setVisibility(View.VISIBLE);
                        spinner34.setVisibility(View.GONE);
                        spinner35.setVisibility(View.VISIBLE);
                    }
                }
                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {}
            });

            spinner35.setOnItemSelectedListener(new OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    textView12b.setText(spinner35.getSelectedItem().toString());
                    if (i != 0) {
                        textView12b.setVisibility(View.VISIBLE);
                        spinner35.setVisibility(View.GONE);
                    }
                }
                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {}
            });

            Button button = rootView.findViewById(R.id.book);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    String starter = textView8.getText().toString();
                    String main = textView8a.getText().toString();
                    String dessert = textView8b.getText().toString();

                    if(starter.matches(getResources().getString(R.string.def))){
                        Toast.makeText(getActivity().getApplicationContext(),"Select Starter",Toast.LENGTH_SHORT).show();
                    }

                    else if(main.matches(getResources().getString(R.string.def))){
                        Toast.makeText(getActivity().getApplicationContext(),"Select Main",Toast.LENGTH_SHORT).show();
                    }

                    else if(dessert.matches(getResources().getString(R.string.def))){
                        Toast.makeText(getActivity().getApplicationContext(),"Select Dessert",Toast.LENGTH_SHORT).show();
                    }

                    else if(preb.getText().toString().matches("")){
                            tV2.setText(currentDateTimeString);
                            preb.setText(currentDateTimeString);
                    }


                    else {

                        RadioButton radioButton = rootView.findViewById(radioGroup.getCheckedRadioButtonId());

                        Intent intent = new Intent(getActivity().getApplicationContext(),Review.class);

                        intent.putExtra("tableno", tV.getText().toString());

                        if(v!=null) {
                            if (v.matches("1")&& !Objects.equals(preb.getText().toString(), ""))
                                intent.putExtra("time", preb.getText().toString());

                            else
                                intent.putExtra("time", tV2.getText().toString());
                        }
                        intent.putExtra("vn", radioButton.getText().toString());

                        intent.putExtra("starter1",textView8.getText().toString());
                        intent.putExtra("starter2",textView9.getText().toString());
                        intent.putExtra("starter3",textView10.getText().toString());
                        intent.putExtra("starter4",textView11.getText().toString());
                        intent.putExtra("starter5",textView12.getText().toString());

                        intent.putExtra("main1",textView8a.getText().toString());
                        intent.putExtra("main2",textView9a.getText().toString());
                        intent.putExtra("main3",textView10a.getText().toString());
                        intent.putExtra("main4",textView11a.getText().toString());
                        intent.putExtra("main5",textView12a.getText().toString());

                        intent.putExtra("dessert1",textView8b.getText().toString());
                        intent.putExtra("dessert2",textView9b.getText().toString());
                        intent.putExtra("dessert3",textView10b.getText().toString());
                        intent.putExtra("dessert4",textView11b.getText().toString());
                        intent.putExtra("dessert5",textView12b.getText().toString());

                        intent.putExtra("email",getArguments().getString(ARG_EMAIL));

                        intent.putExtra("course","Luxury Course");

                        startActivity(intent);
                    }
                }
            });


            return rootView;
        }
    }

}


























