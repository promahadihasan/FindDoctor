package theoaktroop.finddoctor.SplashScreen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import theoaktroop.finddoctor.Home.HomeActivity;
import theoaktroop.finddoctor.R;


public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // METHOD 1

        /****** Create Thread that will sleep for 2 seconds *************/
        Thread background = new Thread() {
            public void run() {

                try {
                    // Thread will sleep for 2000 seconds
                    sleep(100);

                    // After 5 seconds redirect to another intent
                    Intent i=new Intent(SplashActivity.this,HomeActivity.class);
                    startActivity(i);

                    //Remove activity
                    finish();

                } catch (Exception e) {

                }
            }
        };

        // start thread
        background.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
