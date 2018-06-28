package com.example.asus.austcgpacalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpPage extends AppCompatActivity {
    String name, pass;
    EditText edit_tex_user_name, edit_tex_password;
    loginDBHaandeler db;

    /*protected void onStop() {
        super.onStop();
        finish();
    }*/
    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page);

        edit_tex_user_name = (EditText)findViewById(R.id.userName);
        edit_tex_password = (EditText)findViewById(R.id.password);

        db = new loginDBHaandeler(this);
    }
    void insUser(View view){
        if(edit_tex_user_name.getText().toString().equals("") || edit_tex_password.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(), "Invalid Input", Toast.LENGTH_SHORT).show();
        }else{
            //Toast.makeText(getApplicationContext(), edit_tex_user_name.getText().toString(), Toast.LENGTH_SHORT).show();
            db.insertUser(new User(edit_tex_user_name.getText().toString(), edit_tex_password.getText().toString()));
            Toast.makeText(getApplicationContext(), "Insert Successful", Toast.LENGTH_SHORT).show();
            Intent it = new Intent(SignUpPage.this,LoginPage.class);
            startActivity(it);
            this.finish();
        }
    }
}
