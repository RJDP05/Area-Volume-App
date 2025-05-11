package com.kachi.areavolumeapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.kachi.areavolumeapp.shapes.Cube;
import com.kachi.areavolumeapp.shapes.Cylinder;
import com.kachi.areavolumeapp.shapes.Prism;
import com.kachi.areavolumeapp.shapes.Sphere;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    GridView gridView;

    ArrayList<Shape> shapes;

    MyAdapter adapter;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.grid_view);

        shapes = new ArrayList<>();

        shapes.add(new Shape(R.drawable.cube, "Cube"));
        shapes.add(new Shape(R.drawable.prism, "Prism"));
        shapes.add(new Shape(R.drawable.cylinder, "Cylinder"));
        shapes.add(new Shape(R.drawable.sphere, "Sphere"));

        adapter = new MyAdapter(this, shapes);
        gridView.setAdapter(adapter);
        gridView.setNumColumns(2);

        gridView.setOnItemClickListener((parent, view, position, id) -> {
            Shape shape = shapes.get(position); //
            // Handle the click event for the selected shape
            // You can start a new activity or show a dialog with the shape details
            switch (position) {
                case 0:
                    intent = new Intent(getApplicationContext(), Cube.class);
                    startActivity(intent);
                    break;
                case 1:
                    intent = new Intent(MainActivity.this, Prism.class);
                    startActivity(intent);
                    break;
                case 2:
                    intent = new Intent(MainActivity.this, Cylinder.class);
                    startActivity(intent);
                    break;
                case 3:
                    intent = new Intent(MainActivity.this, Sphere.class);
                    startActivity(intent);
                    break;
            }
        });
    }
}