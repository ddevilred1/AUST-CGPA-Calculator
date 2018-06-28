package com.example.asus.austcgpacalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class Select extends AppCompatActivity {
    String user;
    ResultDBHandeler db;
    TextView TV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
        user = getIntent().getExtras().getString("user");
        //Toast.makeText(getApplicationContext(), user, Toast.LENGTH_SHORT).show();
        db = new ResultDBHandeler(this);
        TV = (TextView) findViewById(R.id.results);
    }

    void calcCGPA(View view){
        Intent it = new Intent(Select.this,SelectDeptSemester.class);
        it.putExtra("user", user);
        TV.setText("");
        startActivity(it);
    }

    void check(View view){
        List<Result> res = db.getAllResults(user);
        if(res.size() == 0){
            Toast.makeText(getApplicationContext(), "No Entry Found", Toast.LENGTH_SHORT).show();
        }else{
            String s="User ID: " + user + "\n";
            s+="Semester\t\t\t\tGPA\n";

            for(Result result : res){
                s+=result.getSemester()+"\t\t\t\t\t\t\t\t"+result.getCg()+"\n";
            }
            TV.setText(s);
        }
    }

    @Override
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
        this.finish();
    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }
}
