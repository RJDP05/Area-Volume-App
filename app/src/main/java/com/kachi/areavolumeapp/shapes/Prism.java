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

public class Prism extends AppCompatActivity {

    EditText base,height;
    TextView result;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_prism);

        base =  findViewById(R.id.baseEdge);
        height = findViewById(R.id.height);
        result = findViewById(R.id.result);
        button = findViewById(R.id.calculatePrism);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String baseInput = base.getText().toString();
                String heightInput = height.getText().toString();

                if(baseInput.isEmpty()){
                    result.setText("Enter the Base");
                    return;
                } else if (heightInput.isEmpty()) {
                    result.setText("Enter the Height");
                    return;
                }

                double b = Double.parseDouble(baseInput);
                double h = Double.parseDouble(heightInput);

                double area = 2*b*(b+2*h);
                double volume = b*b*h;

                String areaString = String.format("%.2f", area);
                String volumeString = String.format("%.2f", volume);

                result.setText("\n\nArea: " + areaString + "\nVolume: " + volumeString);
            }
        });
    }
}