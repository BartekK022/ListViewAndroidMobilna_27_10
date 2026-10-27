package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String>arrayListWarzywa = new ArrayList<>();
    ListView listView;
    ArrayAdapter<String> arrayAdapter;
    Button buttonDodaj;
    EditText editTextNowyElement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        arrayListWarzywa.add("Ziemniak");
        arrayListWarzywa.add("Burak");
        arrayListWarzywa.add("Marchewka");
        arrayListWarzywa.add("Seler");
        listView = findViewById(R.id.listViewWarzywa);
        arrayAdapter = new ArrayAdapter<>(MainActivity.this,
                android.R.layout.simple_list_item_1,
                arrayListWarzywa
        );
        listView.setAdapter(arrayAdapter);

        buttonDodaj = findViewById(R.id.button);
        editTextNowyElement = findViewById(R.id.editTextText);

        buttonDodaj.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String nowyElementWarzywo = editTextNowyElement.getText().toString();
                        if (nowyElementWarzywo != "") {
                            arrayListWarzywa.add(nowyElementWarzywo);
                            arrayAdapter.notifyDataSetChanged();
                            editTextNowyElement.setText("");
                        }
                    }
                }
        );




    }
}