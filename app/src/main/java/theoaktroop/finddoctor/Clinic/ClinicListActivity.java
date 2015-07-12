package theoaktroop.finddoctor.Clinic;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import theoaktroop.finddoctor.R;


public class ClinicListActivity extends ActionBarActivity {
    private ListView clinicListView;
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clinic_list);

        clinicListView = (ListView) findViewById(R.id.clinicListView);
        ClinicCustomAdapter clinicCustomAdapter = new ClinicCustomAdapter(this, clinicName, clinicLocation, clinicPhone);
        clinicListView.setAdapter(clinicCustomAdapter);

        clinicListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent clinicIntent = new Intent(ClinicListActivity.this, ClinicDetailsActivity.class);
                clinicIntent.putExtra("position", String.valueOf(position));
                startActivity(clinicIntent);
            }
        });

    }

    public void searchAmbulanceClinicDiagnostic(View view){
        LayoutInflater inflater = LayoutInflater.from(this);
        View dialogView = inflater.inflate(R.layout.ambulance_clinic_diagnostic_search, null);

        new AlertDialog.Builder(this)
                .setTitle("Searching filter")
                .setMessage("Input your required searching field for filtering: ")
                .setView(dialogView)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // continue with delete
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // do nothing
                    }
                })
                .setIcon(android.R.drawable.ic_search_category_default)
                .show();
    }


}
