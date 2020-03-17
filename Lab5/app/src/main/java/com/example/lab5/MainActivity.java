package com.example.lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText edNewCar = findViewById(R.id.ed_new_car);
        Button addCarButton = findViewById(R.id.b_add_car);

        ListView listView = findViewById(R.id.lv_list_carsd);
        final CarAdapter carAdapter = new CarAdapter(this);
        listView.setAdapter(carAdapter);
        carAdapter.addCar("Car1", R.drawable.lab5_car_icon);
        carAdapter.addCar("Car2", R.drawable.lab5_car_icon);
        carAdapter.addCar("Car3", R.drawable.lab5_car_icon);
        carAdapter.addCar("Car4", R.drawable.lab5_car_icon);
        carAdapter.addCar("Car2", R.drawable.lab5_car_icon);
        carAdapter.addCar("Car3", R.drawable.lab5_car_icon);
        carAdapter.addCar("Car4", R.drawable.lab5_car_icon);
        carAdapter.addCar("Car2", R.drawable.lab5_car_icon);
        carAdapter.addCar("Car3", R.drawable.lab5_car_icon);
        carAdapter.addCar("Car4", R.drawable.lab5_car_icon);
        carAdapter.addCar("Car2", R.drawable.lab5_car_icon);
        carAdapter.addCar("Car3", R.drawable.lab5_car_icon);
        carAdapter.addCar("Car4", R.drawable.lab5_car_icon);

        addCarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                carAdapter.addCar(edNewCar.getText().toString(), R.drawable.lab5_car_icon);
                edNewCar.setText("");
            }
        });
    }
}

class Car
{
    public String name;
    public int imageResource;
}

class TagCar
{
    public TextView name;
    public ImageView image;
}