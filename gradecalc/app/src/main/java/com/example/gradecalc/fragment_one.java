package com.example.gradecalc;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;


public class fragment_one extends Fragment {
    TextView A,B,C,D,F;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Bundle bundle = this.getArguments();
        View myInflatedView = inflater.inflate(R.layout.fragment_one, container, false);

        double Astudents = bundle.getDouble("percentOfA");
        double Bstudents = bundle.getDouble("percentOfB");
        double Cstudents = bundle.getDouble("percentOfC");
        double Dstudents = bundle.getDouble("percentOfD");
        double Fstudents = bundle.getDouble("percentOfF");

        A = (TextView) myInflatedView.findViewById(R.id.PercentofA_edit);
        B = (TextView) myInflatedView.findViewById(R.id.PercentofB_edit);
        C = (TextView) myInflatedView.findViewById(R.id.PercentofC_edit);
        D = (TextView) myInflatedView.findViewById(R.id.PercentofD_edit);
        F = (TextView) myInflatedView.findViewById(R.id.PercentofF_edit);

        A.setText(String.valueOf(Astudents)+  "%");
        B.setText(String.valueOf(Bstudents) + "%");
        C.setText(String.valueOf(Cstudents) + "%");
        D.setText(String.valueOf(Dstudents) + "%");
        F.setText(String.valueOf(Fstudents) + "%");


        Button button = (Button) myInflatedView.findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener()
        {
            public void onClick (View view){
            Intent intent = new Intent(getActivity(), barchart.class);
            Bundle nbundle = new Bundle();
            nbundle.putDouble("percentOfA", Astudents);
            nbundle.putDouble("percentOfB", Bstudents);
            nbundle.putDouble("percentOfC", Cstudents);
            nbundle.putDouble("percentOfD", Dstudents);
            nbundle.putDouble("percentOfF", Fstudents);
            intent.putExtras(nbundle);
            startActivity(intent);
        }
        });
        return myInflatedView;
    }

}
