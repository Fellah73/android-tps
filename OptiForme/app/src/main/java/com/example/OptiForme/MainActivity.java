package com.example.OptiForme;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // defining the components
    private EditText poidsInput;
    private EditText tailleInput;
    private Button btnCalculer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // fetching the components by id

        tailleInput = findViewById(R.id.edittaiile);
        poidsInput = findViewById(R.id.editpoids);

        btnCalculer = findViewById(R.id.compute_button);

        // add listenner to the button
        btnCalculer.setOnClickListener(this::compute);

    }

    public void compute(View view) {

        String weightValue = poidsInput.getText().toString().trim();
        String heightValue = tailleInput.getText().toString().trim();

        // if one feild is empty show a toast
        if (weightValue.isEmpty() || heightValue.isEmpty()) {
            Toast.makeText(this, "please fill all fields", Toast.LENGTH_LONG).show();
            return;
        }

        // calculte BMI
        double weight = Double.parseDouble(weightValue);
        double height = Double.parseDouble(heightValue) / 100.;
        height = Math.pow(height, 2);
        double BMI = weight / height;

        // intent to move to ResultActivity
        Intent path = new Intent(this, resultat.class);
        path.putExtra("EXTRA_BMI", BMI);
        startActivity(path);
    }


}