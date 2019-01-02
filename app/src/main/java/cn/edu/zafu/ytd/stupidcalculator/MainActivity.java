package cn.edu.zafu.ytd.stupidcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button[] buttons = new Button[20];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttons[0] = findViewById(R.id._0);
        buttons[1] = findViewById(R.id._1);
        buttons[2] = findViewById(R.id._2);
        buttons[3] = findViewById(R.id._3);
        buttons[4] = findViewById(R.id._4);
        buttons[5] = findViewById(R.id._5);
        buttons[6] = findViewById(R.id._6);
        buttons[7] = findViewById(R.id._7);
        buttons[8] = findViewById(R.id._8);
        buttons[9] = findViewById(R.id._9);

        buttons[10] = findViewById(R.id.sign);
        buttons[11] = findViewById(R.id.dot);
        buttons[12] = findViewById(R.id.equals);
        buttons[13] = findViewById(R.id.add);
        buttons[14] = findViewById(R.id.minus);
        buttons[15] = findViewById(R.id.x);
        buttons[16] = findViewById(R.id.divide);
        buttons[17] = findViewById(R.id.percent);
        buttons[18] = findViewById(R.id.bracket);
        buttons[19] = findViewById(R.id.c);

        for(int i=0; i<=20; i++){
            buttons[i].setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {

    }
}
