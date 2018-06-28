package com.example.asus.austcgpacalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginPage extends AppCompatActivity {

    public EditText edit_tex_user_name, edit_tex_password;
    public loginDBHaandeler db;
    private String temp_name;
    private String temp_password;



    @Override
    protected void onResume() {
        super.onResume();
        edit_tex_user_name.setText("");
        edit_tex_password.setText("");
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        edit_tex_user_name = (EditText)findViewById(R.id.userName);
        edit_tex_password = (EditText)findViewById(R.id.password);

        db = new loginDBHaandeler(this);
    }

    public void logging(View view) {

        User user = db.getuser(edit_tex_user_name.getText().toString(),edit_tex_password.getText().toString());

        if (user == null) {
            Toast.makeText(getApplicationContext(), "No Data Found", Toast.LENGTH_SHORT).show();
        } else {

            Intent it = new Intent(LoginPage.this,Select.class);
            it.putExtra("user", edit_tex_user_name.getText().toString());
            startActivity(it);
        }
    }

    public void signUp(View view) {
        Intent it = new Intent(LoginPage.this,SignUpPage.class);
        startActivity(it);
    }
}
