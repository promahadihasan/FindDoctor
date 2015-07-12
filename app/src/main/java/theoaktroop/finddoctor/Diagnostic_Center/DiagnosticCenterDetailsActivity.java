package theoaktroop.finddoctor.Diagnostic_Center;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;

import theoaktroop.finddoctor.R;

/**
 * Created by Hasan Abdullah on 13-Jul-15.
 */
public class DiagnosticCenterDetailsActivity extends ActionBarActivity {
    private AlphaAnimation buttonClick = new AlphaAnimation(1F, 0.002F);
    private final String[] diagnosticCenterName = {
            "Dream Aid Diagnostic Center",
            "Mirpur Diagnostic Center",
            "Popular Diagnostic Institute",
            "Dream Aid Diagnostic Center",
            "Mirpur Diagnostic Center",
            "Popular Diagnostic Institute"
    };
    private final String[] diagnosticCenterLocation = {
            "Kalyanpur, Dhaka",
            "Mirpur-1, Dhaka",
            "Dhanmondi, Dhaka",
            "Kalyanpur, Dhaka",
            "Mirpur-1, Dhaka",
            "Dhanmondi, Dhaka"
    };
    private final String[] diagnosticCenterPhone = {
            "015214569878",
            "0285215698",
            "018456598789",
            "015214569878",
            "0285215698",
            "018456598789"
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diagnostic_details);

        TextView name = (TextView) findViewById(R.id.nameCDTextView);
        TextView location = (TextView) findViewById(R.id.locationCDTextView);
        TextView phone = (TextView) findViewById(R.id.diagnosticPhoneTextView);
        int position = Integer.parseInt(getIntent().getStringExtra("position"));

        name.setText(diagnosticCenterName[position]);
        location.setText("Location: "+diagnosticCenterLocation[position]);
        phone.setText("Phone: "+diagnosticCenterPhone[position]);
    }

    public void phoneCallAction(View view){
        view.startAnimation(buttonClick);

        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:015212080709"));
        startActivity(callIntent);
    }
}
