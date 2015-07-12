package theoaktroop.finddoctor.Diagnostic_Center;

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
public class DiagnosticCenterCustomAdapter extends ArrayAdapter<String> {
    private final Activity context;
    private final String[] diagnosticCenterName;
    private final String[] diagnosticCenterLocation;
    private final String[] diagnosticCenterPhone;

    public DiagnosticCenterCustomAdapter(Activity context, String[] diagnosticCenterName, String[] diagnosticCenterLocation, String[] diagnosticCenterPhone) {
        super(context, R.layout.ambulance_clinic_diagnostic_list_helper, diagnosticCenterName);
        this.context = context;
        this.diagnosticCenterName = diagnosticCenterName;
        this.diagnosticCenterLocation = diagnosticCenterLocation;
        this.diagnosticCenterPhone = diagnosticCenterPhone;
    }

    public View getView(int position, View view, ViewGroup parent){
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.ambulance_clinic_diagnostic_list_helper, null, true);

        TextView name = (TextView) rowView.findViewById(R.id.nameTextView);
        TextView location = (TextView) rowView.findViewById(R.id.locationTextView);
        TextView phone = (TextView) rowView.findViewById(R.id.phoneTextView);

        name.setText(diagnosticCenterName[position]);
        location.setText(diagnosticCenterLocation[position]);
        phone.setText(diagnosticCenterPhone[position]);

        return rowView;
    }
}

