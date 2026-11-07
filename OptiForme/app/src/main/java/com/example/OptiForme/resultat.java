package com.example.OptiForme;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class resultat extends AppCompatActivity {

    private TextView bmiText;
    private TextView bmiInterpreationText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);


        setContentView(R.layout.activity_resultat);

        bmiText = findViewById(R.id.bmiResultat);
        bmiInterpreationText = findViewById(R.id.interpretationText);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        double BMI = getIntent().getDoubleExtra("EXTRA_BMI", 0.0);
        String BMIFormated = String.format("%.2f", BMI);
        bmiText.setText("BMI : " + BMIFormated);

        String interpreatation;

        if(BMI < 18.5){
            interpreatation ="Insuffisance pondérale";
        } else if (BMI < 24.9) {
            interpreatation = "Corpulence normale";
            
        }else if(BMI < 29.9){
            interpreatation = "Surpoids";
        }else {
            interpreatation = "Obésité";
        }
        bmiInterpreationText.setText(interpreatation);

    }

    public void back(View view) {
        Intent path = new Intent(this, MainActivity.class);
        startActivity(path);
    }
}