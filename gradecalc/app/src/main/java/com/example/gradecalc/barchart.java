package com.example.gradecalc;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class barchart extends AppCompatActivity {
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barchart);
        getSupportActionBar().setTitle("Grade Bar Chart");
        Bundle bundle = getIntent().getExtras();

        double A = bundle.getDouble("percentOfA");
        double B = bundle.getDouble("percentOfB");
        double C = bundle.getDouble("percentOfC");
        double D = bundle.getDouble("percentOfD");
        double F = bundle.getDouble("percentOfF");

        float fA = (float)A;
        float fB = (float)B;
        float fC = (float)C;
        float fD = (float)D;
        float fF = (float)F;


        BarChart barChart = findViewById(R.id.barChart);
        ArrayList<BarEntry> grades =new ArrayList<>();
        grades.add(new BarEntry(0, fA));
        grades.add(new BarEntry(1, fB));
        grades.add(new BarEntry(2, fC));
        grades.add(new BarEntry(3, fD));
        grades.add(new BarEntry(4, fF));

        BarDataSet settingData = new BarDataSet(grades, "Grades");
        settingData.setColors(ColorTemplate.MATERIAL_COLORS);
        settingData.setValueTextColor(Color.LTGRAY);
        settingData.setValueTextSize(16f);

        BarData BD = new BarData(settingData);

        final ArrayList<String> xLabel = new ArrayList<>();
        xLabel.add("A");
        xLabel.add("B");
        xLabel.add("C");
        xLabel.add("D");
        xLabel.add("F");

        XAxis xAxisLabel = barChart.getXAxis();
        xAxisLabel.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxisLabel.setGranularity(1f);
        xAxisLabel.setGranularityEnabled(true);
        xAxisLabel.setDrawGridLines(false);
        xAxisLabel.setValueFormatter(new IndexAxisValueFormatter(xLabel));

        barChart.setFitBars(true);
        barChart.setData(BD);
        barChart.getDescription().setText("Grade Bar Chart");
        barChart.animateY(2000);

    }
}