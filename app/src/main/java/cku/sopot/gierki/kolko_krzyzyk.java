package cku.sopot.gierki;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class kolko_krzyzyk extends AppCompatActivity {
    Button kolorki;
    Button duzoMalo;
    Button p11; Button p12; Button p13;
    Button p21; Button p22; Button p23;
    Button p31; Button p32; Button p33;
    TextView komunikat;
    Button graj;

    String znak ="O";
    int licznik = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kolko_krzyzyk);

        kolorki = (Button) findViewById(R.id.kolorki);
        duzoMalo = (Button) findViewById(R.id.duzoMalo);

        p11 = (Button) findViewById(R.id.p11);
        p12 = (Button) findViewById(R.id.p12);
        p13 = (Button) findViewById(R.id.p13);

        p21 = (Button) findViewById(R.id.p21);
        p22 = (Button) findViewById(R.id.p22);
        p23 = (Button) findViewById(R.id.p23);

        p31 = (Button) findViewById(R.id.p31);
        p32 = (Button) findViewById(R.id.p32);
        p33 = (Button) findViewById(R.id.p33);

        komunikat = (TextView) findViewById(R.id.komunikat);

        graj = (Button) findViewById(R.id.graj);

        graj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                licznik = 0;
                odblokuj(true);
                p11.setText(""); p12.setText(""); p13.setText("");
                p21.setText(""); p22.setText(""); p23.setText("");
                p31.setText(""); p32.setText(""); p33.setText("");
                komunikat.setText("");
            }
        });


        kolorki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(kolko_krzyzyk.this, MainActivity.class);
                startActivity(intent);
            }
        });
        duzoMalo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inetent = new Intent(kolko_krzyzyk.this, za_duzo_za_malo.class);
                startActivity(inetent);
            }
        });

        View.OnClickListener uchoPrzyciskow = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button b = (Button) view;
                if(b.getText().toString().length()==0){
                    b.setText(znak);
                    if (czyWygrana()) {
                        komunikat.setText("Wygrał " + znak);
                        odblokuj(false);
                    }
                    else if (licznik>=9) komunikat.setText("Remis");
                    if(znak.equals("O")) znak="X";
                    else znak = "O";
                }
            }
        };
        p11.setOnClickListener(uchoPrzyciskow);
        p12.setOnClickListener(uchoPrzyciskow);
        p13.setOnClickListener(uchoPrzyciskow);

        p21.setOnClickListener(uchoPrzyciskow);
        p22.setOnClickListener(uchoPrzyciskow);
        p23.setOnClickListener(uchoPrzyciskow);

        p31.setOnClickListener(uchoPrzyciskow);
        p32.setOnClickListener(uchoPrzyciskow);
        p33.setOnClickListener(uchoPrzyciskow);



        }
    boolean czyWygrana(){
        String p11s = p11.getText().toString();
        String p12s = p12.getText().toString();
        String p13s = p13.getText().toString();

        String p21s = p21.getText().toString();
        String p22s = p22.getText().toString();
        String p23s = p23.getText().toString();

        String p31s = p31.getText().toString();
        String p32s = p32.getText().toString();
        String p33s = p33.getText().toString();

        if ( ((p11s.equals(p12s) && p11s.equals(p13s) && p11s.length()>0)) ||
                ((p21s.equals(p22s) && p21s.equals(p23s) && p21s.length()>0)) ||
                ((p31s.equals(p32s) && p31s.equals(p33s) && p31s.length()>0)) ||

                ((p11s.equals(p21s) && p11s.equals(p31s) && p31s.length()>0)) ||
                ((p12s.equals(p22s) && p12s.equals(p32s) && p31s.length()>0)) ||
                ((p13s.equals(p23s) && p13s.equals(p33s) && p31s.length()>0)) ||

                ((p11s.equals(p22s) && p11s.equals(p33s) && p11s.length()>0)) ||
                ((p31s.equals(p22s) && p31s.equals(p13s) && p31s.length()>0))
        ) return true;
        else return false;
    }
    void odblokuj (boolean odblokowac){
        p11.setEnabled(odblokowac); p12.setEnabled(odblokowac); p13.setEnabled(odblokowac);
        p21.setEnabled(odblokowac); p22.setEnabled(odblokowac); p23.setEnabled(odblokowac);
        p31.setEnabled(odblokowac); p32.setEnabled(odblokowac); p33.setEnabled(odblokowac);
    }
}
