package com.cosc4730.program3;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity extends AppCompatActivity {
    private EditText calcLog;
    private EditText calcAns;
    private String log, ans;
    boolean addDot;
    boolean addOp;
    boolean addNeg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        initTextViews();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            return insets;
        });
    }

    private void  initTextViews(){
        calcLog = (EditText)findViewById(R.id.calcLog);
        calcAns = (EditText) findViewById(R.id.calcAns);
        calcAns.setShowSoftInputOnFocus(false);
        log = "";
        ans = " ";
        addDot = false;
        addOp = false;
        addNeg = false;

        calcAns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(getString(R.string.answer).equals(calcAns.getText().toString())){
                    calcAns.setText("");

                }

            }
        });
    }


    public void displayLog(){
        calcLog.setText(log);
    }

    public void displayAnswer(){
        calcAns.setText(ans);
    }


    public void equalOnClick(View view) {
         if(addOp && !log.substring(log.length() - 1, log.length()).equals(" ")){

             String [] tokens = log.split(" ");

                /*if(tokens .length == 1 && tokens [0].startsWith("~")){
                    ans = Double.toString(-Double.parseDouble(tokens[0].substring(1)));
                }*/

                    switch (tokens [1].charAt(0)) {
                        case '+':
                            ans = Double.toString(Double.parseDouble(tokens [0]) + Double.parseDouble(tokens [2]));
                            break;
                        case '-':
                            ans = Double.toString(Double.parseDouble(tokens [0]) - Double.parseDouble(tokens [2]));
                            break;
                        case '/':
                            ans = Double.toString(Double.parseDouble(tokens [0]) / Double.parseDouble(tokens [2]));
                            break;
                        case '*':
                            ans = Double.toString(Double.parseDouble(tokens [0]) * Double.parseDouble(tokens [2]));
                            break;
                        case '^':
                            ans = Double.toString(Math.pow(Double.parseDouble(tokens [0]), Double.parseDouble(tokens [2])));
                            break;

                    }
                }

                    displayAnswer();
                    log = ans;
                    addOp = false;
                    addNeg =false;
                    addDot= false;
                    displayLog();

    }

    public void backspace(){
        if(!log.isEmpty()) {

            if (log.substring(log.length() - 1, log.length()).equals(".")) {
                addDot = false;
            }

            if (log.substring(log.length() - 1, log.length()).equals(" ")) {
                log = log.substring(0, log.length() - 3);
                addOp = false;
            } else {
                log = log.substring(0, log.length() - 1);
            }
        }

    }

    public void clearOnClick(View view){
        backspace();
        displayLog();

    }



    public void AclearOnClick(View view){
        log = "";
        ans = "";
        addDot = false;
        addOp = false;
        displayLog();
        displayAnswer();

    }

    public void powOnClick(View view){
        addDot = false;
        addNeg = false;

        if(!log.isEmpty()) {
            if (log.substring(log.length() - 1, log.length()).equals(".")) {
                backspace();
            }

            if (!addOp) {
                log = log + " ^ ";
                addOp = true;
            }
        }
        displayLog();

    }

    public void divOnClick(View view){
      addDot = false;
      addNeg = false;

      if(!log.isEmpty()) {
          if (log.substring(log.length() - 1, log.length()).equals(".")) {
              backspace();
          }

          if (!addOp) {
              log = log + " / ";
              addOp = true;
          }
      }
      displayLog();

    }

    public void sevenOnClick(View view){
        log = log + "7";
        displayLog();

    }

    public void eightOnClick(View view){
        log = log + "8";
        displayLog();

    }

    public void nineOnClick(View view){
        log = log + "9";
        displayLog();

    }

    public void mulitOnClick(View view){
        addDot = false;
        addNeg = false;
        if(!log.isEmpty()) {
            if (log.substring(log.length() - 1, log.length()).equals(".")) {
                backspace();
            }

            if (!addOp) {
                log = log + " * ";
                addOp = true;
            }
        }
        displayLog();

    }

    public void fourOnClick(View view){
        log = log + "4";
        displayLog();


    }

    public void fiveOnClick(View view){
        log = log + "5";
        displayLog();

    }

    public void sixOnClick(View view){
        log = log + "6";
        displayLog();


    }

    public void plusOnClick(View view){
        addDot = false;
        addNeg = false;

        if(!log.isEmpty()) {
            if (log.substring(log.length() - 1, log.length()).equals(".")) {
                backspace();
            }

            if (!addOp) {
                log = log + " + ";
                addOp = true;
            }
        }
        displayLog();

    }

    public void oneOnClick(View view){
        log = log + "1";
        displayLog();

    }

    public void twoOnClick(View view){
        log = log + "2";
        displayLog();

    }

    public void threeOnClick(View view){
        log = log + "3";
        displayLog();

    }

    public void subOnClick(View view){
        addDot = false;
        addNeg = false;
        if(!log.isEmpty()) {
            if (log.substring(log.length() - 1, log.length()).equals(".")) {
                backspace();
            }

            if (!addOp) {
                log = log + " - ";
                addOp = true;
            }
        }
        displayLog();

    }

    public void negOnClick(View view) {
        addDot = false;
        addNeg = false;
        if (!log.isEmpty()) {
            if (log.endsWith(".")) {
                backspace();
            }

            if (!addNeg && !log.startsWith("~")) {
                log = "~" + log;
                addNeg = true;
            }
            if(log.startsWith("~")){
                //insert ~ behind operator / in front of second half of the expression.
                log = log.replaceAll(" (\\d)", " ~$1");
                addNeg = true;
            }
         /*   if (addNeg && log.startsWith("~")) {
                log = log.substring(1);
                addNeg = false;
            } else{
                log = log.replaceAll(" (\\d)", "  $1");
                addNeg = false;
            }*/

            displayLog();
        }
    }


    public void dotOnClick(View view){

        if(log.isEmpty()){
            log = "0.";
            addDot = true;
        }

        if(!addDot){
            log = log + ".";
            addDot = true;
        }
        displayLog();
    }

    public void zeroOnClick(View view){
        log = log + "0";
        displayLog();

    }




}
