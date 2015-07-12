package theoaktroop.finddoctor.Ambulance;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import theoaktroop.finddoctor.R;

/**
 * Created by Hasan Abdullah on 12-Jul-15.
 */
public class AmbulanceCustomAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] ambulanceName;
    private final String[] ambulanceLocation;
    private final String[] ambulancePhone;
    private final String[] ambulanceCost;

    public AmbulanceCustomAdapter(Activity context, String[] ambulanceName, String[] ambulanceLocation, String[] ambulancePhone, String[] ambulanceCost) {
        super(context, R.layout.ambulance_clinic_diagnostic_list_helper, ambulanceName);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.ambulanceName = ambulanceName;
        this.ambulanceLocation = ambulanceLocation;
        this.ambulancePhone = ambulancePhone;
        this.ambulanceCost = ambulanceCost;
    }

    public View getView(int position, View view, ViewGroup parent){
        LayoutInflater layoutInflater = context.getLayoutInflater();
        View rowView = layoutInflater.inflate(R.layout.ambulance_clinic_diagnostic_list_helper, null, true);

        TextView nameTextView = (TextView) rowView.findViewById(R.id.nameTextView);
        TextView locationTextView = (TextView) rowView.findViewById(R.id.locationTextView);
        TextView phoneTextView = (TextView) rowView.findViewById(R.id.phoneTextView);

        nameTextView.setText(ambulanceName[position]);
        locationTextView.setText(ambulanceLocation[position]);
        phoneTextView.setText(ambulancePhone[position]);

        return rowView;
    }
}
