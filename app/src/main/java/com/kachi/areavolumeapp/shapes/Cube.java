package com.kachi.areavolumeapp.shapes;

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

public class Cube extends AppCompatActivity {

    EditText editText;
    TextView textView, result;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cube);

        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.sideLength);
        result = findViewById(R.id.result);
        button = findViewById(R.id.calculate);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = editText.getText().toString();
                if (input.isEmpty()) {
                    result.setText("Please Enter the Side Length");
                    return;
                }
                double sideLength = Double.parseDouble(input);
                double area = 6 * Math.pow(sideLength, 2);
                double volume = Math.pow(sideLength, 3);

                String areaString = String.format("%.2f", area);
                String volumeString = String.format("%.2f", volume);

                // Display the results
                result.setText("\n\nArea: " + areaString + "\nVolume: " + volumeString);

            }
        });

    }
}