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

public class Sphere extends AppCompatActivity {

    EditText editText;
    TextView result;
    Button calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sphere);

        editText = findViewById(R.id.radiusOfSphere);
        result = findViewById(R.id.result);
        calculate = findViewById(R.id.calculateSphere);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = editText.getText().toString();

                if(input.isEmpty()){
                    result.setText("Enter The Radius");
                    return;
                }

                double r = Double.parseDouble(input);

                double area = 4*PI*r*r;
                double volume = (4/3)*PI*r*r*r;

                String areaString = String.format("%.2f", area);
                String volumeString = String.format("%.2f", volume);

                result.setText("\n\nArea: " + areaString + "\nVolume: " + volumeString);
            }
        });

    }
}