package theoaktroop.finddoctor.Ambulance;

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
public class AmbulanceDetailsActivity extends ActionBarActivity{
    private AlphaAnimation buttonClick = new AlphaAnimation(1F, 0.002F);
    private final String[] ambulanceName = {
            "Addin Ambulance Service",
            "Anjuman Mufidul Islam Ambulance",
            "Al Baraka Ambulance Service",
            "Delta Medical Ambulance Service",
            "Addin Ambulance Service",
            "Anjuman Mufidul Islam Ambulance",
            "Al Baraka Ambulance Service",
            "Delta Medical Ambulance Service"
    };
    private final String[] ambulanceLocation = {
            "Mogbazar, Dhaka",
            "Kakrail, Dhaka",
            "Lalbagh, Dhaka",
            "Mirpur, Dhaka",
            "Mogbazar, Dhaka",
            "Kakrail, Dhaka",
            "Lalbagh, Dhaka",
            "Mirpur, Dhaka"
    };
    private final String[] ambulancePhone = {
            "01199285231",
            "01715689548",
            "028007994",
            "029557896",
            "01199285231",
            "01715689548",
            "028007994",
            "029557896"
    };
    private final String[] ambulanceCost = {
            "420 TK",
            "260 TK",
            "400 TK",
            "350 TK",
            "420 TK",
            "260 TK",
            "400 TK",
            "350 TK"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ambulance_details);

        TextView name = (TextView) findViewById(R.id.ambulanceNameTextView);
        TextView location = (TextView) findViewById(R.id.ambulanceLocationTextView);
        TextView cost = (TextView) findViewById(R.id.ambulanceCostTextView);
        int position = Integer.parseInt(getIntent().getStringExtra("position"));

        name.setText(ambulanceName[position]);
        location.setText("Office Location: "+ambulanceLocation[position]);
        cost.setText("Service Charge: "+ambulanceCost[position]);
    }

    public void phoneCallAction(View view){
        view.startAnimation(buttonClick);

        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:015212080709"));
        startActivity(callIntent);
    }
}
