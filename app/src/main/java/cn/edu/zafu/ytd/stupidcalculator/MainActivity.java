package cn.edu.zafu.ytd.stupidcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button[] buttons = new Button[20];
    Calculator calculator = new Calculator();
    TextView inputView, resultView;
    String input = "0";
    String formula = "";
    boolean again = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputView = findViewById(R.id.input);
        resultView = findViewById(R.id.result);

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

        for (int i = 0; i < 20; i++) {
            buttons[i].setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id._0:
                if (input.equals("0")) break;
            case R.id._1:
            case R.id._2:
            case R.id._3:
            case R.id._4:
            case R.id._5:
            case R.id._6:
            case R.id._7:
            case R.id._8:
            case R.id._9:
                if (input.equals("0")) {
                    input = "";
                }

            case R.id.dot:

                if (again) {
                    formula = "";
                    calculator.clear();
                    again = false;
                }
                boolean noDot = true;
                if(v.getId()==R.id.dot) {
                    if(input.isEmpty()){
                        input = "0";
                        formula += "0";
                        break;
                    }
                    for(int i =0; i<input.length();i++){
                        if(input.charAt(i)=='.') {
                            noDot = false;
                            break;
                        }
                    }
                    }

                if(noDot){    input += ((Button) v).getText().toString();
                formula += ((Button) v).getText().toString();
                inputView.setText(formula);}
                break;
            case R.id.sign:
                break;
            case R.id.equals:
                if(!again)
                if (!formula.isEmpty()) {
                    if (!input.isEmpty()) calculator.addInput(input);
                    else {
                        calculator.removeTool();
                        formula = eraseLast(formula);
                    }
                    formula = calculator.result();
                    inputView.setText(formula);
                    resultView.setText("");
                    input = "";
                    again = true;
                }
                break;
            case R.id.add:
            case R.id.minus:
            case R.id.divide:
            case R.id.x:
            case R.id.percent:
                if (!formula.isEmpty()) {
                    if (!input.isEmpty()) {
                        calculator.addInput(input);
                        input = "";
                        resultView.setText(calculator.result());
                    } else {
                        if (!again) {
                            calculator.removeTool();
                            formula = eraseLast(formula);

                        }
                    }
                    calculator.addTool(((Button) v).getText().toString());
                    formula += ((Button) v).getText().toString();
                    inputView.setText(formula);
                    again = false;
                }
                break;
            case R.id.bracket:
                break;
            case R.id.c:
                input = "0";
                formula = "";
                inputView.setText("");
                resultView.setText("");
                calculator.clear();
                break;
        }
    }

    public String eraseLast(String str) {
        if (str.length() != 0)
            str = str.substring(0, str.length() - 1);
        return str;
    }

}
