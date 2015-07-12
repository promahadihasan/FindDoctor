package theoaktroop.finddoctor.Diagnostic_Center;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import theoaktroop.finddoctor.R;


public class DiagnosticCenterListActivity extends ActionBarActivity {
    private ListView diagnosticCenterListView;
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnostic_center_list);

        diagnosticCenterListView = (ListView) findViewById(R.id.diagnosticListView);
        DiagnosticCenterCustomAdapter diagnosticCenterCustomAdapter = new DiagnosticCenterCustomAdapter(this, diagnosticCenterName, diagnosticCenterLocation, diagnosticCenterPhone);
        diagnosticCenterListView.setAdapter(diagnosticCenterCustomAdapter);

        diagnosticCenterListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent diagnosticCenterIntent = new Intent(DiagnosticCenterListActivity.this, DiagnosticCenterDetailsActivity.class);
                diagnosticCenterIntent.putExtra("position", String.valueOf(position));
                startActivity(diagnosticCenterIntent);
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
