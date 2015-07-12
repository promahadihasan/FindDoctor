package theoaktroop.finddoctor.Clinic;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import theoaktroop.finddoctor.R;

/**
 * Created by Hasan Abdullah on 12-Jul-15.
 */
public class ClinicCustomAdapter extends ArrayAdapter<String> {
    private final Activity context;
    private final String[] clinicName;
    private final String[] clinicLocation;
    private final String[] clinicPhone;


    public ClinicCustomAdapter(Activity context, String[] clinicName, String[] clinicLocation, String[] clinicPhone) {
        super(context, R.layout.ambulance_clinic_diagnostic_list_helper, clinicName);
        this.context = context;
        this.clinicName = clinicName;
        this.clinicLocation = clinicLocation;
        this.clinicPhone = clinicPhone;
    }

    public View getView(int position, View view, ViewGroup parent){
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.ambulance_clinic_diagnostic_list_helper, null, true);

        TextView name = (TextView) rowView.findViewById(R.id.nameTextView);
        TextView location = (TextView) rowView.findViewById(R.id.locationTextView);
        TextView phone = (TextView) rowView.findViewById(R.id.phoneTextView);

        name.setText(clinicName[position]);
        location.setText("Location: "+clinicLocation[position]);
        phone.setText("Phone: "+clinicPhone[position]);
        return rowView;
    }
}
