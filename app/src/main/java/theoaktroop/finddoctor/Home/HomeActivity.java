package theoaktroop.finddoctor.Home;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;

import theoaktroop.finddoctor.Ambulance.AmbulanceListActivity;
import theoaktroop.finddoctor.Clinic.ClinicListActivity;
import theoaktroop.finddoctor.Diagnostic_Center.DiagnosticCenterListActivity;
import theoaktroop.finddoctor.Doctor.DoctorListActivity;
import theoaktroop.finddoctor.R;

/**
 * Created by Hasan Abdullah on 09-Jul-15.
 */
public class HomeActivity extends Activity {

    ImageView doctor;
    ImageView clinic;
    ImageView ambulance;
    ImageView diagnostic;
    private AlphaAnimation buttonClick = new AlphaAnimation(1F, 0.002F);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);

        viewInitialize();

    }

    public void featureButtonAction(View view){
        view.startAnimation(buttonClick);

        if(view.getId()==R.id.doctorButton){
            Intent intent = new Intent(HomeActivity.this, DoctorListActivity.class);
            startActivity(intent);
        }
        else if (view.getId()==R.id.clinicButton){
            Intent intent = new Intent(HomeActivity.this, ClinicListActivity.class);
            startActivity(intent);
        }
        else if (view.getId()==R.id.ambulanceButton){
            Intent intent = new Intent(HomeActivity.this, AmbulanceListActivity.class);
            startActivity(intent);
        }
        else if (view.getId()==R.id.diagnosticButton){
            Intent intent = new Intent(HomeActivity.this, DiagnosticCenterListActivity.class);
            startActivity(intent);
        }
    }

    private void viewInitialize() {
        doctor = (ImageView) findViewById(R.id.doctorButton);
        clinic = (ImageView) findViewById(R.id.clinicButton);
        ambulance = (ImageView) findViewById(R.id.ambulanceButton);
        diagnostic = (ImageView) findViewById(R.id.diagnosticButton);
    }

    public static void buttonEffect(View button){
        button.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        v.getBackground().setColorFilter(0xe0f47521, PorterDuff.Mode.SRC_ATOP);
                        v.invalidate();
                        break;
                    }
                    case MotionEvent.ACTION_UP: {
                        v.getBackground().clearColorFilter();
                        v.invalidate();
                        break;
                    }
                }
                return false;
            }
        });
    }
}
