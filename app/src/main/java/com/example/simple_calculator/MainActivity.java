package com.example.simple_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

//Mirage


public class MainActivity extends AppCompatActivity {
    Button button0, button1, button2, button3, button4, button5, button6,
            button7, button8, button9, buttonAdd, buttonSub, buttonDivision,
    buttonMul, buttonDot, buttonC, buttonEqual;
    TextView edttxt;

    float val_one, val_two;
    boolean add, sub, mul, div;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clearOperations();

        button0 = (Button) findViewById(R.id.btn0);
        button1 = (Button) findViewById(R.id.btn1);
        button2 = (Button) findViewById(R.id.btn2);
        button3 = (Button) findViewById(R.id.btn3);
        button4 = (Button) findViewById(R.id.btn4);
        button5 = (Button) findViewById(R.id.btn5);
        button6 = (Button) findViewById(R.id.btn6);
        button7 = (Button) findViewById(R.id.btn7);
        button8 = (Button) findViewById(R.id.btn8);
        button9 = (Button) findViewById(R.id.btn9);
        buttonAdd = (Button) findViewById(R.id.btnplus);
        buttonSub = (Button) findViewById(R.id.btnMinus);
        buttonMul = (Button) findViewById(R.id.btnMul);
        buttonDivision = (Button) findViewById(R.id.btnDiv);
        buttonDot = (Button) findViewById(R.id.btndot);
        buttonC = (Button) findViewById(R.id.btnClear);
        buttonEqual = (Button) findViewById(R.id.btnEqual);

        edttxt = (TextView) findViewById(R.id.screen);

        button0.setOnClickListener((v)-> {
            edttxt.setText(edttxt.getText()+ "0");
        });

        button1.setOnClickListener((v)-> {
            edttxt.setText(edttxt.getText()+ "1");
        });
        button2.setOnClickListener((v)-> {
            edttxt.setText(edttxt.getText()+ "2");
        });
        button3.setOnClickListener((v)-> {
            edttxt.setText(edttxt.getText()+ "3");
        });
        button4.setOnClickListener((v)-> {
            edttxt.setText(edttxt.getText()+ "4");
        });
        button5.setOnClickListener((v)-> {
            edttxt.setText(edttxt.getText()+ "5");
        });
        button6.setOnClickListener((v)-> {
            edttxt.setText(edttxt.getText()+ "6");
        });
        button7.setOnClickListener((v)-> {
            edttxt.setText(edttxt.getText()+ "7");
        });
        button8.setOnClickListener((v)-> {
            edttxt.setText(edttxt.getText()+ "8");
        });
        button9.setOnClickListener((v)-> {
            edttxt.setText(edttxt.getText()+ "9");
        });

        buttonAdd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
            edttxt.setText(edttxt.getText() + "+");
            add = true;
            }
        });

        buttonDot.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                edttxt.setText(edttxt.getText() + ".");
            }
        });
        buttonMul.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                edttxt.setText(edttxt.getText() +"*");
                mul = true;
            }
        });

        buttonSub.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                edttxt.setText(edttxt.getText() +"-");
                sub = true;
            }
        });
        buttonDivision.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                edttxt.setText(edttxt.getText() +"/");
                div = true;
            }
        });

        buttonC.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                edttxt.setText("");
                clearOperations();
            }
        });

        buttonEqual.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                float[] operands;
                double result = 0.0;

               if(add == true)
               {
                 if(edttxt.getText().toString() != "")
                 {
                     operands = parseResultText("\\+");// here we have to escape the +
                     result = operands[0] + operands[1];
                     String strResult = Double.toString(result);
                     edttxt.setText(strResult);
                     clearOperations();
                 }
               }
               else  if(sub == true)
               {
                   if(edttxt.getText().toString() != "")
                   {
                       operands = parseResultText("\\-");// here we have to escape the -
                       result = operands[0] - operands[1];
                       String strResult = Double.toString(result);
                       edttxt.setText(strResult);
                       clearOperations();
                   }
               }

               else  if(mul == true)
               {
                   if(edttxt.getText().toString() != "")
                   {
                       operands = parseResultText("\\*");// here we have to escape the *
                       result = operands[0] * operands[1];
                       String strResult = Double.toString(result);
                       edttxt.setText(strResult);
                       clearOperations();
                   }
               }

               else  if(div == true)
               {
                   if(edttxt.getText().toString() != "")
                   {
                       operands = parseResultText("\\/");// here we have to escape the /
                       result = operands[0] / operands[1];
                       String strResult = Double.toString(result);
                       edttxt.setText(strResult);
                       clearOperations();
                   }
               }



            }
        });

    }

    private void clearOperations()
    {
        add = false;
        mul = false;
        sub = false;
        div = false;
    }

    private float[] parseResultText(String operation)
    {
        float[] fOperands = new float[2];
        String[] operands = edttxt.getText().toString().split(operation);
        fOperands[0] = Float.parseFloat(operands[0]);
        fOperands[1] = Float.parseFloat(operands[1]);
        return fOperands;

    }




}