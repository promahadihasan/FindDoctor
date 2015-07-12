package theoaktroop.finddoctor.Ambulance;

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


public class AmbulanceListActivity extends ActionBarActivity {
    private ListView ambulanceListView;
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
        setContentView(R.layout.activity_ambulance_list);

        ambulanceListView = (ListView) findViewById(R.id.ambulanceListView);

        AmbulanceCustomAdapter adapter = new AmbulanceCustomAdapter(this, ambulanceName, ambulanceLocation, ambulancePhone, ambulanceCost);
        ambulanceListView.setAdapter(adapter);

        ambulanceListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent ambulanceIntent = new Intent(AmbulanceListActivity.this, AmbulanceDetailsActivity.class);
                ambulanceIntent.putExtra("position", String.valueOf(position));
                startActivity(ambulanceIntent);
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
