package theoaktroop.finddoctor.Clinic;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;
import theoaktroop.finddoctor.R;

/**
 * Created by Hasan Abdullah on 12-Jul-15.
 */
public class ClinicDetailsActivity extends ActionBarActivity {
    private AlphaAnimation buttonClick = new AlphaAnimation(1F, 0.002F);
    private final String[] clinicName = {
            "Dhaka Medical College Hospital",
            "Shaheed Sohrawardi Hospital",
            "LabAid Specialized Hospital",
            "Delta Medical College Hospital",
            "Ibn Sina Medical College Hospital",
            "Dhaka Medical College Hospital",
            "Shaheed Sohrawardi Hospital",
            "LabAid Specialized Hospital",
            "Delta Medical College Hospital",
            "Ibn Sina Medical College Hospital"
    };
    private final String[] clinicLocation = {
            "Chankhar pool, Dhaka",
            "Mirpur Road, Dhaka",
            "Dhanmondi, Dhaka",
            "Mirpur, Dhaka",
            "Kalyanpur, Dhaka",
            "Chankhar pool, Dhaka",
            "Mirpur Road, Dhaka",
            "Dhanmondi, Dhaka",
            "Mirpur, Dhaka",
            "Kalyanpur, Dhaka"
    };
    private final String[] clinicPhone = {
            "015214569878",
            "0285215698",
            "018456598789",
            "015214569878",
            "0285215698",
            "018456598789",
            "015214569878",
            "0285215698",
            "015214569878",
            "018456598789"
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clinic_details);

        TextView name = (TextView) findViewById(R.id.nameCDTextView);
        TextView location = (TextView) findViewById(R.id.locationCDTextView);
        TextView phone = (TextView) findViewById(R.id.clinicPhone);
        int position = Integer.parseInt(getIntent().getStringExtra("position"));

        name.setText(clinicName[position]);
        location.setText("Location: "+clinicLocation[position]);
        phone.setText("Phone: "+clinicPhone[position]);
    }

    public void phoneCallAction(View view){
        view.startAnimation(buttonClick);

        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:015212080709"));
        startActivity(callIntent);
    }
}
