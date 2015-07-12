package theoaktroop.finddoctor.Doctor;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import theoaktroop.finddoctor.R;

public class CustomListDoctorAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] doctorName;
    private final String[] doctorSpec;
    private final String[] doctorLocation;
    private final Integer[] imgid;

    public CustomListDoctorAdapter(Activity context, String[] doctorName,String[] doctorSpece,String[] doctorLaocation, Integer[] imgid) {
        super(context, R.layout.doctor_list_helper, doctorName);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.doctorName=doctorName;
        this.doctorSpec=doctorSpece;
        this.doctorLocation=doctorLaocation;
        this.imgid=imgid;
    }

    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.doctor_list_helper, null,true);

        TextView txtdoctorName = (TextView) rowView.findViewById(R.id.doctorNameTextView);
        TextView txtdoctorSpeciality = (TextView) rowView.findViewById(R.id.doctorSpecialityTextView);
        TextView txtdoctorLocation= (TextView) rowView.findViewById(R.id.doctorLocationTextView);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.doctorImage);


        txtdoctorName.setText(doctorName[position]);
        txtdoctorSpeciality.setText("Speciality: "+doctorSpec[position]);
        txtdoctorLocation.setText("Location: "+doctorLocation[position]);
        imageView.setImageResource(imgid[position]);

        return rowView;

    };
}
