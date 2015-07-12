package theoaktroop.finddoctor.Doctor;

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


public class DoctorListActivity extends ActionBarActivity {
    private ListView doctorListView;
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
        setContentView(R.layout.activity_doctor_list);

        doctorListView=(ListView)findViewById(R.id.listViewDoctor);


        CustomListDoctorAdapter adapter=new CustomListDoctorAdapter(this, doctorName,doctorSpeciality,doctorLocation, imgid);


        doctorListView.setAdapter(adapter);
        doctorListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent newDoctorDtailesIntent = new Intent(DoctorListActivity.this, DoctorDetailsActivity.class);
                newDoctorDtailesIntent.putExtra("position", String.valueOf(position));
                startActivity(newDoctorDtailesIntent);
            }
        });
    }


    public void searchAction(View view){
        LayoutInflater inflater = LayoutInflater.from(this);
        View dialogView = inflater.inflate(R.layout.doctor_search, null);

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
