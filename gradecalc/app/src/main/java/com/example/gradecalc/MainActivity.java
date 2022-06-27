package com.example.gradecalc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {
    EditText numOfStudents, Astudents,Bstudents,Cstudents,Dstudents,Fstudents;
    Button calculate;
    fragment_one mFragmentOne;
    int showingFragment=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFragmentOne = new fragment_one();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frameLayout, mFragmentOne);
        fragmentTransaction.commit();
        fragmentTransaction.remove(mFragmentOne);
        showingFragment=0;
        numOfStudents = (EditText) findViewById(R.id.numOfStudentsET);
        Astudents = (EditText) findViewById(R.id.AstudentET);
        Bstudents = (EditText) findViewById(R.id.BstudentET);
        Cstudents = (EditText) findViewById(R.id.CstudentET);
        Dstudents = (EditText) findViewById(R.id.DstudentET);
        Fstudents = (EditText) findViewById(R.id.FstudentET);
        calculate = (Button) findViewById(R.id.calc);
    }

    public void pressToCalc(View view){
        int gradeTotalOfStudents;
        Double percentOfA, percentOfB, percentOfC, percentOfD, percentOfF;

        if(Astudents.getText().toString().isEmpty() || Bstudents.getText().toString().isEmpty() || Cstudents.getText().toString().isEmpty() || Dstudents.getText().toString().isEmpty() || Fstudents.getText().toString().isEmpty()){
            Toast.makeText(MainActivity.this, "ALL FIELDS ARE REQUIRED, PLEASE FILL OUT AND EMPTY FIELDS.", Toast.LENGTH_SHORT).show();
            return;
        }
        gradeTotalOfStudents = Integer.parseInt(Astudents.getText().toString()) + Integer.parseInt(Bstudents.getText().toString()) + Integer.parseInt(Cstudents.getText().toString()) + Integer.parseInt(Dstudents.getText().toString()) + Integer.parseInt(Fstudents.getText().toString());
        if (gradeTotalOfStudents > Integer.parseInt(numOfStudents.getText().toString()) || gradeTotalOfStudents < Integer.parseInt(numOfStudents.getText().toString())){
            Toast.makeText(MainActivity.this, String.format("The total number of students should be %s, the number based on all students grades is %s", numOfStudents.getText().toString(), gradeTotalOfStudents), Toast.LENGTH_LONG).show();
            return;
        }
        percentOfA=(Double.parseDouble(Astudents.getText().toString())/Integer.parseInt(numOfStudents.getText().toString()))*100;
        percentOfB=(Double.parseDouble(Bstudents.getText().toString())/Integer.parseInt(numOfStudents.getText().toString()))*100;
        percentOfC=(Double.parseDouble(Cstudents.getText().toString())/Integer.parseInt(numOfStudents.getText().toString()))*100;
        percentOfD=(Double.parseDouble(Dstudents.getText().toString())/Integer.parseInt(numOfStudents.getText().toString()))*100;
        percentOfF=(Double.parseDouble(Fstudents.getText().toString())/Integer.parseInt(numOfStudents.getText().toString()))*100;

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Bundle bundle = new Bundle();
        bundle.putDouble("percentOfA", percentOfA);
        bundle.putDouble("percentOfB", percentOfB);
        bundle.putDouble("percentOfC", percentOfC);
        bundle.putDouble("percentOfD", percentOfD);
        bundle.putDouble("percentOfF", percentOfF);
        mFragmentOne.setArguments(bundle);
        fragmentTransaction.replace(R.id.frameLayout, mFragmentOne);


        if (showingFragment==0) {
            System.out.println("Fragment is on!");
            fragmentTransaction.replace(R.id.frameLayout, mFragmentOne);
            showingFragment=1;
        } else {
            fragmentTransaction.remove(mFragmentOne);
            showingFragment=0;
        }
        fragmentTransaction.commit();


    }

}
