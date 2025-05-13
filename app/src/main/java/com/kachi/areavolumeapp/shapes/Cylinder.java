package com.kachi.areavolumeapp.shapes;

import static java.lang.Math.PI;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.kachi.areavolumeapp.R;

public class Cylinder extends AppCompatActivity {

    EditText radius, height;
    TextView result;
    Button calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cylinder);

        radius = findViewById(R.id.radiusOfCylinder);
        height = findViewById(R.id.height);
        result = findViewById(R.id.result);
        calculate = findViewById(R.id.calculateCylinder);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String radiusInput = radius.getText().toString();
                String heightInput = height.getText().toString();

                if(radiusInput.isEmpty()){
                    result.setText("Enter the Radius");
                    return;
                } else if (heightInput.isEmpty()) {
                    result.setText("Enter the Height");
                    return;
                }

                double r = Double.parseDouble(radiusInput);
                double h = Double.parseDouble(heightInput);

                double area = 2*PI*r*(h+r);
                double volume = PI*r*r*h;

                String areaString = String.format("%.2f", area);
                String volumeString = String.format("%.2f", volume);

                result.setText("\n\nArea: " + areaString + "\nVolume: " + volumeString);
            }
        });
    }
}