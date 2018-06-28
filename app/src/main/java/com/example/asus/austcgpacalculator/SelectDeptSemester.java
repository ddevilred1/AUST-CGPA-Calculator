package com.example.asus.austcgpacalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class SelectDeptSemester extends AppCompatActivity {
    Button goToSecondPageBtn;
    String user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_dept_semester);
        user = getIntent().getExtras().getString("user");
        final Spinner myspinner = (Spinner)findViewById(R.id.spinner1);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(SelectDeptSemester.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.names));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        myspinner.setAdapter(myAdapter);



        final Spinner myspinner2 = (Spinner)findViewById(R.id.spinner2);
        ArrayAdapter<String> myAdapter2 = new ArrayAdapter<String>(SelectDeptSemester.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.semester));
        myAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        myspinner2.setAdapter(myAdapter2);


        goToSecondPageBtn = (Button)findViewById(R.id.button1);
        goToSecondPageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),Calculate.class);
                i.putExtra("user", user);
                i.putExtra("dept", myspinner.getSelectedItem().toString());
                i.putExtra("semester", myspinner2.getSelectedItem().toString());
                startActivity(i);


            }
        });
    }
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i = new Intent(getApplicationContext(),Select.class);
        i.putExtra("user", user);
        startActivity(i);
        this.finish();
    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }
}
