package com.valdio.valdioveliu.butterknifecalculator;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends ActionBarActivity {


    //Bind the Views of the activity_main.xml file
    @Bind(R.id.textView)
    TextView textView;
    @Bind(R.id.button7)
    Button button7;
    @Bind(R.id.button8)
    Button button8;
    @Bind(R.id.button9)
    Button button9;
    @Bind(R.id.button4)
    Button button4;
    @Bind(R.id.button5)
    Button button5;
    @Bind(R.id.button6)
    Button button6;
    @Bind(R.id.button1)
    Button button1;
    @Bind(R.id.button2)
    Button button2;
    @Bind(R.id.button3)
    Button button3;
    @Bind(R.id.button)
    Button button;
    @Bind(R.id.button0)
    Button button0;
    @Bind(R.id.result)
    Button result;
    @Bind(R.id.add)
    Button add;
    @Bind(R.id.substact)
    Button substact;
    @Bind(R.id.division)
    Button division;
    @Bind(R.id.multiply)
    Button multiply;
    @Bind(R.id.sqrt)
    Button sqrt;
    @Bind(R.id.ln)
    Button ln;
    @Bind(R.id.clear)
    Button clear;
    @Bind(R.id.delete)
    Button delete;


    //The onClick() methods for the buttons

    @OnClick(R.id.button)
    public void onClick() {
        append(button);
    }

    @OnClick(R.id.button1)
    public void onClick1() {
        append(button1);
    }
    @OnClick(R.id.button2)
    public void onClick2() {
        append(button2);
    }
    @OnClick(R.id.button3)
    public void onClick3() {
        append(button3);
    }
    @OnClick(R.id.button4)
    public void onClick4() {
        append(button4);
    }
    @OnClick(R.id.button5)
    public void onClick5() {
        append(button5);
    }
    @OnClick(R.id.button6)
    public void onClick6() {
        append(button6);
    }
    @OnClick(R.id.button7)
    public void onClick7() {
        append(button7);
    }
    @OnClick(R.id.button8)
    public void onClick8() {
        append(button8);
    }
    @OnClick(R.id.button9)
    public void onClick9() {
        append(button9);
    }
    @OnClick(R.id.button0)
    public void onClick0() {
        append(button0);
    }
    @OnClick(R.id.result)
    public void onClickresult() {
        append(result);
    }
    @OnClick(R.id.add)
    public void onClickadd() {
        append(add);
    }
    @OnClick(R.id.substact)
    public void onClicksub() {
        append(substact);
    }
    @OnClick(R.id.multiply)
    public void onClickmul() {
        append(multiply);
    }
    @OnClick(R.id.division)
    public void onClickdiv() {
        append(division);
    }


    @OnClick(R.id.delete)
    public void onClickdelete() {
        delete();
    }
    @OnClick(R.id.clear)
    public void onClickclear() {
        clear();
    }
    @OnClick(R.id.sqrt)
    public void onClicksqrt() {
        sqrt();
    }
    @OnClick(R.id.ln)
    public void onClickln() {
        log();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }


    public void delete(){
        if (textView.getText().length()==0)
            return;
            textView.setText( textView.getText().subSequence(0,textView.getText().length()-1));
        }


    public  void clear(){
       textView.setText("");
    }


    public void sqrt(){

        String nr = textView.getText().toString();

            if(nr == ""){
                Toast.makeText(getApplication(), "Enter a number\nto perform this action", Toast.LENGTH_LONG).show();
                return;
            }
            else
            {
                double n = Double.parseDouble(nr);
                nr = String.valueOf(Math.sqrt(n));
            }

            textView.setText(textView.getText() +"=\n" + nr);
    }


    public void log (){

            String nr = textView.getText().toString();

            if(nr == ""){
                Toast.makeText(getApplication(), "Enter a number\nto perform this action", Toast.LENGTH_LONG).show();
                return;
            }
            else {
                Double n = Double.parseDouble(nr);
                nr = String.valueOf(Math.log(n));

            }
            textView.setText(textView.getText() +"=\n" + nr);

    }



    private String result(){


        try {

            String result = textView.getText().toString();

            char[] expression = result.toCharArray();

            int possition = 0;
            for (int i = 0 ;i<expression.length;i++){

                if (
                        expression[i] == '+' || expression[i] == '-' ||
                                expression[i] == '*' || expression[i] == '/'
                        )
                {
                    possition = i;
                    break;
                }

            }

            if ( possition == 0 || possition == expression.length-1 ){
                Toast.makeText(getApplicationContext(), "Wrong format of expression!", Toast.LENGTH_LONG).show();
                return "";
            }

            String nr1 = "", nr2 = "";
            for (int i = 0 ; i<possition ; i++) {
                nr1 += expression[i];
            }
            for (int i = possition+1; i < expression.length; i++) {
                nr2 += expression[i];
            }

            double n1 = Double.parseDouble(nr1);
            double n2 = Double.parseDouble(nr2);

            double res = 0;

            switch (expression[possition]){

                case '+':
                    res = n1+n2;
                    break;
                case '-':
                    res = n1-n2;
                    break;
                case '*':
                    res = n1*n2;
                    break;
                case '/':
                    res = n1/n2;
                    break;

            }

            return String.valueOf(res);


        }catch (Exception e){

            Toast.makeText(getApplicationContext(), "Impossible action", Toast.LENGTH_LONG).show();

            return "ERROR";
        }
    }


    public void append(Button btn){

            if (btn == button0)
                textView.setText(textView.getText()+"0");
            if (btn == button1)
                textView.setText(textView.getText()+"1");
            if (btn == button2)
                textView.setText(textView.getText()+"2");
            if (btn == button3)
                textView.setText(textView.getText()+"3");
            if (btn == button4)
                textView.setText(textView.getText()+"4");
            if (btn == button5)
                textView.setText(textView.getText()+"5");
            if (btn == button6)
                textView.setText(textView.getText()+"6");
            if (btn == button7)
                textView.setText(textView.getText()+"7");
            if (btn == button8)
                textView.setText(textView.getText()+"8");
            if (btn == button9)
                textView.setText(textView.getText()+"9");
            if (btn == button)
                textView.setText(textView.getText()+".");
            if (btn == result)
                textView.setText(textView.getText()+ "=\n" + result());
            if (btn == add)
                textView.setText(textView.getText()+"+");
            if (btn == substact)
                textView.setText(textView.getText()+"-");
            if (btn == multiply)
                textView.setText(textView.getText()+"*");
            if (btn == division)
                textView.setText(textView.getText()+"/");

     }
}
