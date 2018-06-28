package com.example.asus.austcgpacalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Splash extends AppCompatActivity {

    private ImageView iv;

    Thread timer = new Thread(){
        public void run()
        {
            try{
                sleep(5000);
                final Intent i = new Intent(Splash.this,LoginPage.class);
                startActivity(i);
            } catch (InterruptedException e) {

            }
            finally {
                finish();
            }
        }
    };

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        timer.interrupt();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        iv=(ImageView)findViewById(R.id.iv);
        Animation myanim = AnimationUtils.loadAnimation(this,R.anim.mytransition);

        iv.startAnimation(myanim);
        timer.start();
    }
}
