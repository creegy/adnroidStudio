package cku.sopot.gierki;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class za_duzo_za_malo extends AppCompatActivity {
    EditText zgadywana;
    Button sprawdz;
    TextView wynik;
    Button kolorki;
    Button krzyzyk;
    Integer wylosowana;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_za_duzo_za_malo);

        wylosowana = (int) (Math.random() * 100 + 1);

        zgadywana = (EditText) findViewById(R.id.zgadywana);
        sprawdz = (Button) findViewById(R.id.sprawdz);
        wynik = (TextView) findViewById(R.id.wynik);
        kolorki = (Button) findViewById(R.id.kolorki);
        krzyzyk = (Button) findViewById(R.id.krzyzyk);

        krzyzyk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(za_duzo_za_malo.this, kolko_krzyzyk.class);
                startActivity(intent);
            }
        });

        kolorki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inetent = new Intent(za_duzo_za_malo.this, MainActivity.class);
                startActivity(inetent);
            }
        });

        sprawdz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String zgadywanaS = zgadywana.getText().toString();
                if (zgadywanaS.length() == 0) {
                    wynik.setText("Wprowadź liczbę >:(");
                } else {

                    Integer zgadywanaI = Integer.parseInt(zgadywanaS);
                    if (zgadywanaI > wylosowana) {
                        wynik.setText("Za dużo");
                    } else if (zgadywanaI < wylosowana) {
                        wynik.setText("Za mało");
                    } else {
                        wynik.setText("BRAWO, ZGADŁEŚ/AŚ!!! graj dalej");
                        wylosowana = (int) (Math.random() * 100 + 1);
                    }

                }
            }
        });

    }
}