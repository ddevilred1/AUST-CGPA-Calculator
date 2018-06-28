package com.example.asus.austcgpacalculator;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class Calculate extends AppCompatActivity {
    Button gotocgpashowbtn, saveButton;
    String dept, semester, user;
    ResultDBHandeler db;
    static boolean done;

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i = new Intent(getApplicationContext(),SelectDeptSemester.class);
        i.putExtra("user", user);
        startActivity(i);
        this.finish();
    }


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);
        user = getIntent().getExtras().getString("user");
        dept = getIntent().getExtras().getString("dept");
        semester = getIntent().getExtras().getString("semester");
        db = new ResultDBHandeler(this);
        TextView dep, sem, sub;
        dep = (TextView)findViewById(R.id.obj1);
        sem = (TextView)findViewById(R.id.obj2);
        dep.setText("Department of " + dept);
        sem.setText(semester);
        sub = (TextView)findViewById(R.id.subjects);
        if(dept.equals("CSE") && semester.equals("1.1"))sub.setText(getResources().getString(R.string.csesubjects11));
        else if(dept.equals("CSE") && semester.equals("1.2"))sub.setText(getResources().getString(R.string.csesubjects12));
        else if(dept.equals("CSE") && semester.equals("2.1"))sub.setText(getResources().getString(R.string.csesubjects21));
        else if(dept.equals("CSE") && semester.equals("2.2"))sub.setText(getResources().getString(R.string.csesubjects22));
        else if(dept.equals("CSE") && semester.equals("3.1"))sub.setText(getResources().getString(R.string.csesubjects31));
        else if(dept.equals("CSE") && semester.equals("3.2"))sub.setText(getResources().getString(R.string.csesubjects32));
        else if(dept.equals("CSE") && semester.equals("4.1"))sub.setText(getResources().getString(R.string.csesubjects41));
        else if(dept.equals("CSE") && semester.equals("4.2"))sub.setText(getResources().getString(R.string.csesubjects42));
        else if(dept.equals("EEE") && semester.equals("1.1"))sub.setText(getResources().getString(R.string.eeesubjects11));
        else if(dept.equals("EEE") && semester.equals("1.2"))sub.setText(getResources().getString(R.string.eeesubjects12));
        else if(dept.equals("EEE") && semester.equals("2.1"))sub.setText(getResources().getString(R.string.eeesubjects21));
        else if(dept.equals("EEE") && semester.equals("2.2"))sub.setText(getResources().getString(R.string.eeesubjects22));
        else if(dept.equals("EEE") && semester.equals("3.1"))sub.setText(getResources().getString(R.string.eeesubjects31));
        else if(dept.equals("EEE") && semester.equals("3.2"))sub.setText(getResources().getString(R.string.eeesubjects32));
        else if(dept.equals("EEE") && semester.equals("4.1"))sub.setText(getResources().getString(R.string.eeesubjects41));
        else if(dept.equals("EEE") && semester.equals("4.2"))sub.setText(getResources().getString(R.string.eeesubjects42));

        final Spinner myspinner1= (Spinner)findViewById(R.id.sub1);
        final ArrayAdapter<String> myAdapter1 = new ArrayAdapter<String>(Calculate.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.cg));
        myAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        myspinner1.setAdapter(myAdapter1);

        final Spinner myspinner2 = (Spinner)findViewById(R.id.sub2);
        final ArrayAdapter<String> myAdapter2 = new ArrayAdapter<String>(Calculate.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.cg));
        myAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        myspinner2.setAdapter(myAdapter2);

        final Spinner myspinner3 = (Spinner)findViewById(R.id.sub3);
        final ArrayAdapter<String> myAdapter3 = new ArrayAdapter<String>(Calculate.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.cg));
        myAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        myspinner3.setAdapter(myAdapter3);


        final Spinner myspinner4 = (Spinner)findViewById(R.id.sub4);
        final ArrayAdapter<String> myAdapter4= new ArrayAdapter<String>(Calculate.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.cg));
        myAdapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        myspinner4.setAdapter(myAdapter4);

        final Spinner myspinner5 = (Spinner)findViewById(R.id.sub5);
        final ArrayAdapter<String> myAdapter5 = new ArrayAdapter<String>(Calculate.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.cg));
        myAdapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        myspinner5.setAdapter(myAdapter5);

        final Spinner myspinner6 = (Spinner)findViewById(R.id.sub6);
        final ArrayAdapter<String> myAdapter6 = new ArrayAdapter<String>(Calculate.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.cg));
        myAdapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        myspinner6.setAdapter(myAdapter6);

        final Spinner myspinner7 = (Spinner)findViewById(R.id.sub7);
        final ArrayAdapter<String> myAdapter7= new ArrayAdapter<String>(Calculate.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.cg));
        myAdapter7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        myspinner7.setAdapter(myAdapter7);

        final Spinner myspinner8 = (Spinner)findViewById(R.id.sub8);
        final ArrayAdapter<String> myAdapter8 = new ArrayAdapter<String>(Calculate.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.cg));
        myAdapter8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        myspinner8.setAdapter(myAdapter8);

        final Spinner myspinner9 = (Spinner)findViewById(R.id.sub9);
        final ArrayAdapter<String> myAdapter9 = new ArrayAdapter<String>(Calculate.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.cg));
        myAdapter9.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        myspinner9.setAdapter(myAdapter9);

        final Spinner myspinner10 = (Spinner)findViewById(R.id.sub10);
        final ArrayAdapter<String> myAdapter10 = new ArrayAdapter<String>(Calculate.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.cg));
        myAdapter10.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        myspinner10.setAdapter(myAdapter10);

        gotocgpashowbtn = (Button)findViewById(R.id.button2);
        gotocgpashowbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent i = new Intent(getApplicationContext(),Main2Activity.class);
                //startActivity(i);
                double cg[] = new double[10];
                double cgpa=0;
                cg[0] = Double.parseDouble(myspinner1.getSelectedItem().toString());
                cg[1] = Double.parseDouble(myspinner2.getSelectedItem().toString());
                cg[2] = Double.parseDouble(myspinner3.getSelectedItem().toString());
                cg[3] = Double.parseDouble(myspinner4.getSelectedItem().toString());
                cg[4] = Double.parseDouble(myspinner5.getSelectedItem().toString());
                cg[5] = Double.parseDouble(myspinner6.getSelectedItem().toString());
                cg[6] = Double.parseDouble(myspinner7.getSelectedItem().toString());
                cg[7] = Double.parseDouble(myspinner8.getSelectedItem().toString());
                cg[8] = Double.parseDouble(myspinner9.getSelectedItem().toString());
                cg[9] = Double.parseDouble(myspinner10.getSelectedItem().toString());
                if(dept.equals("CSE") && (semester.equals("1.1") || semester.equals("1.2") || semester.equals("2.1"))){
                    double gpa=0;
                    for(int i=0; i<5; i++)gpa+=(cg[i]*3);
                    for(int i=5; i<8; i++)gpa+=(cg[i]*1.5);
                    gpa+=(cg[8]*0.75);
                    cgpa = gpa/20.25;
                }
                else if(dept.equals("CSE") && semester.equals("2.2")){
                    double gpa=0;
                    for(int i=0; i<5; i++)gpa+=(cg[i]*3);
                    for(int i=5; i<7; i++)gpa+=(cg[i]*1.5);
                    for(int i=7; i<10; i++)gpa+=(cg[i]*0.75);
                    cgpa = gpa/20.25;
                }
                else if(dept.equals("CSE") && (semester.equals("3.1") || semester.equals("3.2"))){
                    double gpa=0;
                    for(int i=0; i<5; i++)gpa+=(cg[i]*3);
                    gpa+=(cg[5]*1.5);
                    for(int i=6; i<9; i++)gpa+=(cg[i]*0.75);
                    cgpa = gpa/18.75;
                }
                else if(dept.equals("CSE") && (semester.equals("4.1") || semester.equals("4.2"))){
                    double gpa=0;
                    for(int i=0; i<6; i++)gpa+=(cg[i]*3);
                    gpa+=(cg[6]*1.5);
                    for(int i=7; i<10; i++)gpa+=(cg[i]*0.75);
                    cgpa = gpa/21.75;
                }
                else if(dept.equals("EEE") && (semester.equals("1.1") || semester.equals("1.2") || semester.equals("2.1"))){
                    double gpa=0;
                    for(int i=0; i<5; i++)gpa+=(cg[i]*3);
                    for(int i=5; i<8; i++)gpa+=(cg[i]*1.5);
                    gpa+=(cg[8]*0.75);
                    cgpa = gpa/20.25;
                }
                else if(dept.equals("EEE") && semester.equals("2.2")){
                    double gpa=0;
                    for(int i=0; i<5; i++)gpa+=(cg[i]*3);
                    for(int i=5; i<7; i++)gpa+=(cg[i]*1.5);
                    for(int i=7; i<10; i++)gpa+=(cg[i]*0.75);
                    cgpa = gpa/20.25;
                }
                else if(dept.equals("EEE") && (semester.equals("3.1") || semester.equals("3.2"))){
                    double gpa=0;
                    for(int i=0; i<5; i++)gpa+=(cg[i]*3);
                    gpa+=(cg[5]*1.5);
                    for(int i=6; i<9; i++)gpa+=(cg[i]*0.75);
                    cgpa = gpa/18.75;
                }
                else if(dept.equals("EEE") && (semester.equals("4.1") || semester.equals("4.2"))){
                    double gpa=0;
                    for(int i=0; i<6; i++)gpa+=(cg[i]*3);
                    gpa+=(cg[6]*1.5);
                    for(int i=7; i<10; i++)gpa+=(cg[i]*0.75);
                    cgpa = gpa/21.75;
                }

                AlertDialog alertDialog = new AlertDialog.Builder(
                        Calculate.this).create();
                int cgp = (int)(cgpa*10000);
                cgpa = cgp/10000.0;
                alertDialog.setMessage("CGPA is: " + Double.toString(cgpa));
                alertDialog.show();
            }
        });

        saveButton = (Button)findViewById(R.id.button3);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double cg[] = new double[10];
                double cgpa=0;
                cg[0] = Double.parseDouble(myspinner1.getSelectedItem().toString());
                cg[1] = Double.parseDouble(myspinner2.getSelectedItem().toString());
                cg[2] = Double.parseDouble(myspinner3.getSelectedItem().toString());
                cg[3] = Double.parseDouble(myspinner4.getSelectedItem().toString());
                cg[4] = Double.parseDouble(myspinner5.getSelectedItem().toString());
                cg[5] = Double.parseDouble(myspinner6.getSelectedItem().toString());
                cg[6] = Double.parseDouble(myspinner7.getSelectedItem().toString());
                cg[7] = Double.parseDouble(myspinner8.getSelectedItem().toString());
                cg[8] = Double.parseDouble(myspinner9.getSelectedItem().toString());
                cg[9] = Double.parseDouble(myspinner10.getSelectedItem().toString());
                if(dept.equals("CSE") && (semester.equals("1.1") || semester.equals("1.2") || semester.equals("2.1"))){
                    double gpa=0;
                    for(int i=0; i<5; i++)gpa+=(cg[i]*3);
                    for(int i=5; i<8; i++)gpa+=(cg[i]*1.5);
                    gpa+=(cg[8]*0.75);
                    cgpa = gpa/20.25;
                }
                else if(dept.equals("CSE") && semester.equals("2.2")){
                    double gpa=0;
                    for(int i=0; i<5; i++)gpa+=(cg[i]*3);
                    for(int i=5; i<7; i++)gpa+=(cg[i]*1.5);
                    for(int i=7; i<10; i++)gpa+=(cg[i]*0.75);
                    cgpa = gpa/20.25;
                }
                else if(dept.equals("CSE") && (semester.equals("3.1") || semester.equals("3.2"))){
                    double gpa=0;
                    for(int i=0; i<5; i++)gpa+=(cg[i]*3);
                    gpa+=(cg[5]*1.5);
                    for(int i=6; i<9; i++)gpa+=(cg[i]*0.75);
                    cgpa = gpa/18.75;
                }
                else if(dept.equals("CSE") && (semester.equals("4.1") || semester.equals("4.2"))){
                    double gpa=0;
                    for(int i=0; i<6; i++)gpa+=(cg[i]*3);
                    gpa+=(cg[6]*1.5);
                    for(int i=7; i<10; i++)gpa+=(cg[i]*0.75);
                    cgpa = gpa/21.75;
                }
                else if(dept.equals("EEE") && (semester.equals("1.1") || semester.equals("1.2") || semester.equals("2.1"))){
                    double gpa=0;
                    for(int i=0; i<5; i++)gpa+=(cg[i]*3);
                    for(int i=5; i<8; i++)gpa+=(cg[i]*1.5);
                    gpa+=(cg[8]*0.75);
                    cgpa = gpa/20.25;
                }
                else if(dept.equals("EEE") && semester.equals("2.2")){
                    double gpa=0;
                    for(int i=0; i<5; i++)gpa+=(cg[i]*3);
                    for(int i=5; i<7; i++)gpa+=(cg[i]*1.5);
                    for(int i=7; i<10; i++)gpa+=(cg[i]*0.75);
                    cgpa = gpa/20.25;
                }
                else if(dept.equals("EEE") && (semester.equals("3.1") || semester.equals("3.2"))){
                    double gpa=0;
                    for(int i=0; i<5; i++)gpa+=(cg[i]*3);
                    gpa+=(cg[5]*1.5);
                    for(int i=6; i<9; i++)gpa+=(cg[i]*0.75);
                    cgpa = gpa/18.75;
                }
                else if(dept.equals("EEE") && (semester.equals("4.1") || semester.equals("4.2"))){
                    double gpa=0;
                    for(int i=0; i<6; i++)gpa+=(cg[i]*3);
                    gpa+=(cg[6]*1.5);
                    for(int i=7; i<10; i++)gpa+=(cg[i]*0.75);
                    cgpa = gpa/21.75;
                }
                int cgp = (int)(cgpa*10000);
                cgpa = cgp/10000.0;
                Result res = new Result(user, semester, cgpa);
                db.insertResult(res);
                Intent it = new Intent(Calculate.this,Select.class);
                it.putExtra("user", user);
                startActivity(it);
            }
        });

    }
}
