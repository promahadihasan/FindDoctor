package theoaktroop.finddoctor.Doctor;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import theoaktroop.finddoctor.R;

/**
 * Created by Sunny_PC on 7/12/2015.
 */
public class DoctorDetailsActivity  extends ActionBarActivity{
    private AlphaAnimation buttonClick = new AlphaAnimation(1F, 0.002F);
    private final String[] doctorName={
            "Prof. Md. Kamrul Hassan",
            "Prof. Asit Baran Adhikary",
            "Prof. Sajid Hasan",
            "Prof. Md. Kamrul Hassan",
            "Prof. Asit Baran Adhikary",
            "Prof. Sajid Hasan"
    };
    private final String[] doctorSpeciality={
            "Otolaryngologist",
            "Cardiac Sargon",
            "Urologist",
            "Otolaryngologist",
            "Cardiac Sargon",
            "Urologist"
    };
    private final String[] doctorLocation={
            "Wari, Dhaka",
            "Mirpur, Dhaka",
            "Shahbagh, Dhaka",
            "Wari, Dhaka",
            "Mirpur, Dhaka",
            "Shahbagh, Dhaka"
    };
    private final Integer[] imgid={
            R.drawable.pic1,
            R.drawable.pic2,
            R.drawable.pic3,
            R.drawable.pic1,
            R.drawable.pic2,
            R.drawable.pic3
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.doctor_details);

        TextView txtdoctorName = (TextView) findViewById(R.id.doctorName);
        TextView txtdoctorSpeciality = (TextView) findViewById(R.id.doctorSpeciality);
        TextView txtdoctorLocation= (TextView) findViewById(R.id.doctorLocation);
        ImageView imageView = (ImageView) findViewById(R.id.doctorImageView);
    int position=Integer.parseInt(getIntent().getStringExtra("position"));

        txtdoctorName.setText(doctorName[position]);
        txtdoctorSpeciality.setText("Speciality: "+doctorSpeciality[position]);
        txtdoctorLocation.setText("Location: " + doctorLocation[position]);
        imageView.setImageResource(imgid[position]);

    }

    public void phoneCallAction(View view){
        view.startAnimation(buttonClick);

        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:015212080709"));
        startActivity(callIntent);
    }

    public void emailAction(View view){
        view.startAnimation(buttonClick);

        Log.i("Send email", "");
        String[] TO = {"hasan_cse1991@yahoo.com"};
        String[] CC = {""};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "");

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
            Log.i("Email Sent!", "");
        }
        catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(DoctorDetailsActivity.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }
}
