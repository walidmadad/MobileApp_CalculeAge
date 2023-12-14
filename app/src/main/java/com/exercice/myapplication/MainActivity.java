package com.exercice.myapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

@RequiresApi(api=26)
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn1 = (Button)findViewById(R.id.button);
        EditText nom = (EditText)findViewById(R.id.txtNom);
        EditText prenom = (EditText)findViewById(R.id.txtPrenom);
        TextView msg = (TextView)findViewById(R.id.message);
        EditText dateNaissance = (EditText) findViewById(R.id.txtDate);
        TextView dateCalculer = (TextView)findViewById(R.id.dateCalculer);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1) {
                msg.setText("Bonjour " + nom.getText() + " " + prenom.getText());
            }
        });
        Button btnCalc = (Button)findViewById(R.id.calc);

        btnCalc.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v2) {
                String dateNaiss = dateNaissance.getText().toString();
                try {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    LocalDate dateNaissance = LocalDate.parse(dateNaiss, formatter);

                    Period la_date = Period.between(dateNaissance, LocalDate.now());
                    int jours = la_date.getDays();
                    int mois = la_date.getMonths();
                    int ans = la_date.getYears();
                    dateCalculer.setText("Age : " + ans + " ans " + mois + " mois " + jours + " jours ");

                } catch (DateTimeParseException e) {
                    System.out.println("Format de date invalide. Utilisez le format yyyy-MM-dd.");
                }
            }
            });

    }
}
