package cku.sopot.gierki;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    EditText czerwony;
    EditText zielony;
    EditText niebieski;
    Button butt;
    Button next;
    LinearLayout tlo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        czerwony = (EditText) findViewById(R.id.czerwony);
        zielony = (EditText) findViewById(R.id.zielony);
        niebieski = (EditText) findViewById(R.id.niebieski);
        tlo = (LinearLayout) findViewById(R.id.tlo);
        next = (Button) findViewById(R.id.next);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, za_duzo_za_malo.class);
                startActivity(intent);
            }
        });

        butt = (Button) findViewById(R.id.butt);
        butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String czerwonyS = czerwony.getText().toString();
                String zielonyS = zielony.getText().toString();
                String niebieskiS = niebieski.getText().toString();
                if(czerwony.length()==0) czerwonyS="0";
                if(zielony.length()==0) zielonyS="0";
                if(niebieski.length()==0) niebieskiS="0";

                Integer czerwonyA = Integer.parseInt(czerwonyS);
                Integer zielonyA = Integer.parseInt(zielonyS);
                Integer niebieskiA = Integer.parseInt(niebieskiS);

                if(czerwonyA>255) czerwonyA = 255;
                if(zielonyA>255) zielonyA = 255;
                if(niebieskiA>255) niebieskiA = 255;

                Integer kolorNapis = Color.rgb(255-czerwonyA, 255-zielonyA, 255-niebieskiA);
 //               czerwony.setTextColor(kolorNapis);
  //              zielony.setTextColor(kolorNapis);
  //              niebieski.setTextColor(kolorNapis);

                tlo.setBackgroundColor(Color.rgb(czerwonyA, zielonyA, niebieskiA));


            }
        });
    }
}