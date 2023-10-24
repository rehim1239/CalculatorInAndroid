package com.android.firstapplication;

import androidx.appcompat.app.AppCompatActivity;




import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import com.google.android.material.button.MaterialButton;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;





public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    MaterialButton button0, button1, button2, button3, button4, button5, button6, button7, button8, button9, button_ac,
            button_plus_minus, button_percent, button_divide, button_multi, button_substraction, button_equal, button_dot,
            button_addition;

    TextView text;
    boolean addition = false,subs = false,division = false,multi = false,minus = true,dott = true;

    String result = "",result_show = "";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button_addition = (MaterialButton)findViewById(R.id.button_addition) ;
         button_substraction = (MaterialButton) findViewById(R.id.button_substition);
        button_ac = (MaterialButton)findViewById(R.id.button_ac);
        button_divide = (MaterialButton) findViewById(R.id.button_division);
        button_multi = (MaterialButton) findViewById(R.id.button_multiplaction);
        button_equal = (MaterialButton)findViewById(R.id.button_equal);
        button_percent = (MaterialButton)findViewById(R.id.button_percent);
        button_plus_minus = (MaterialButton)findViewById(R.id.button_minus);
        button_dot = (MaterialButton)findViewById(R.id.button_dot);


        text = (TextView) findViewById(R.id.text);
        set_id(button0, R.id.button0);
        set_id(button1, R.id.button1);
        set_id(button2, R.id.button2);
        set_id(button3, R.id.button3);
        set_id(button4, R.id.button4);
        set_id(button5, R.id.button5);
        set_id(button6, R.id.button6);
        set_id(button7, R.id.button7);
        set_id(button8, R.id.button8);
        set_id(button9, R.id.button9);
        //set_id(button_ac, R.id.button_ac);
        set_id(button_plus_minus, R.id.button_minus);
        set_id(button_percent, R.id.button_percent);
        set_id(button_divide, R.id.button_division);
        set_id(button_multi, R.id.button_multiplaction);
        //set_id(button_substraction, R.id.button_substition);
        set_id(button_addition,R.id.button_addition);
        //set_id(button_equal, R.id.button_equal);
        set_id(button_dot, R.id.button_dot);
        //set_id_operator(button_addition,R.id.button_addition);





        button_addition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(subs){
                   reset_color(button_substraction);
                   subs = false;
               }
                if(division){
                    reset_color(button_divide);
                    division = false;
                }
                if(multi){
                    reset_color(button_multi);
                    multi = false;
                }
                change_color(button_addition);
                addition = true;
                if(!result.isEmpty()){
                    double answer = calculate(result);
                    String answer_string = String.valueOf(answer);
                    if(answer_string.endsWith(".0")){
                        answer_string = answer_string.replace(".0","");

                    }
                    if(answer_string.contains(".")){ // 0.5 kimi ededlerde ekrana 0,5 yazdirmaq ucun.
                        String new_answer = answer_string.replace(".",",");
                        text.setText(new_answer);
                    }else {
                        text.setText(answer_string); // icinde "." yoxdursa normal cavabi yazsin
                    }
                    result = answer_string; // result ise "." ile olan inputu almalidir deye else-nin icinde olmur

                }
            }

        });

        button_substraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(addition){
                    reset_color(button_addition);
                    addition= false;
                }
                if(division){
                    reset_color(button_divide);
                    division= false;
                }
                if(multi){
                    reset_color(button_multi);
                    multi = false;
                }

                change_color(button_substraction);
                subs = true;

                if(!result.isEmpty()){
                    double answer = calculate(result);
                    String answer_string = String.valueOf(answer);
                    if(answer_string.endsWith(".0")){
                        answer_string = answer_string.replace(".0","");

                    }
                    if(answer_string.contains(".")){ // 0.5 kimi ededlerde ekrana 0,5 yazdirmaq ucun.
                       String new_answer = answer_string.replace(".",",");
                        text.setText(new_answer);
                    }else {
                        text.setText(answer_string); // icinde "." yoxdursa normal cavabi yazsin
                    }
                    result = answer_string; // result ise "." ile olan inputu almalidir deye else-nin icinde olmur

                }

            }
        });

        button_divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(addition){
                    reset_color(button_addition);
                    addition= false;
                }
                if(subs){
                    reset_color(button_substraction);
                    subs = false;
                }
                if(multi){
                    reset_color(button_multi);
                    multi = false;
                }

                change_color(button_divide);
                division = true;
                if(result.contains("/")){
                    double answer = calculate(result);
                    String answer_string = String.valueOf(answer);
                    if(answer_string.endsWith(".0")){
                        answer_string = answer_string.replace(".0","");

                    }
                    if(answer_string.contains(".")){ // 0.5 kimi ededlerde ekrana 0,5 yazdirmaq ucun.
                        String new_answer = answer_string.replace(".",",");
                        text.setText(new_answer);
                    }else {
                        text.setText(answer_string); // icinde "." yoxdursa normal cavabi yazsin
                    }
                    result = answer_string; // result ise "." ile olan inputu almalidir deye else-nin icinde olmur
                }
            }
        });

        button_multi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(addition){
                    reset_color(button_addition);
                    addition= false;
                }
                if(subs){
                    reset_color(button_substraction);
                    subs = false;
                }
                if(division){
                    reset_color(button_divide);
                    division= false;
                }

                change_color(button_multi);
                multi = true;
                System.out.println(result);
                if(result.contains("*")){
                    double answer = calculate(result);
                    String answer_string = String.valueOf(answer);
                    if(answer_string.endsWith(".0")){
                        answer_string = answer_string.replace(".0","");

                    }
                    if(answer_string.contains(".")){ // 0.5 kimi ededlerde ekrana 0,5 yazdirmaq ucun.
                        String new_answer = answer_string.replace(".",",");
                        text.setText(new_answer);
                    }else {
                        text.setText(answer_string); // icinde "." yoxdursa normal cavabi yazsin
                    }
                    result = answer_string; // result ise "." ile olan inputu almalidir deye else-nin icinde olmur

                }
            }
        });

        button_ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setText("0");
                if(addition){
                    reset_color(button_addition);
                    addition = false;
                }
                if(subs){
                    reset_color(button_substraction);
                    subs = false;
                }
                if(division){
                    reset_color(button_divide);
                    division= false;
                }
                if(multi){
                    reset_color(button_multi);
                    multi = false;
                }
               result = "";
            }
        });

        button_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (addition) {
                    reset_color(button_addition);
                    addition = false;
                    reset_color(button_addition);
                    //result = result + "+";
                }
                if (subs) {
                    reset_color(button_substraction);
                    subs = false;
                }
                if (division) {
                    reset_color(button_divide);
                    division = false;
                }
                if (multi) {
                    reset_color(button_multi);
                    multi = false;
                }
                System.out.println(result);

                if (result.endsWith(".0")) {
                    result = result.replace(".0", "");
                }
                double answer = calculate(result);
                String answer_string = String.valueOf(answer);
                if (answer_string.endsWith(".0")) {
                    answer_string = answer_string.replace(".0", "");

                }

//                String answer_str = answer_string;
//                int i = answer_str.length();
//                System.out.println(answer_string);
//                if (i >= 4 && i < 10) {
//
//                    if (i >= 7) {
//                        answer_str = answer_str.substring(0, i - 6) + "." + answer_str.substring(i - 6, i - 3) + "." + answer_str.substring(i - 3, i - 1);
//                        answer_string = answer_str;
//                    } else {
//                        answer_str = answer_str.substring(0, i - 3) + "." + answer_str.substring(i - 3, i - 1);
//                        answer_string = answer_str;
//                    }
//                }
                if (answer_string.contains(".")) { // 0.5 kimi ededlerde ekrana 0,5 yazdirmaq ucun.
                    String new_answer = answer_string.replace(".", ",");
                    text.setText(new_answer);
                } else {
                    text.setText(answer_string); // icinde "." yoxdursa normal cavabi yazsin
                }


                result = answer_string; // result ise "." ile olan inputu almalidir deye else-nin icinde olmur
            }

        });

        button_plus_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tex = text.getText().toString();
                if(tex.substring(0,1).equals("-")){
                    minus = false;
                }
              if(minus) {
                  tex = "-" + tex;
                  result = "-" + result;
                  text.setText(tex);
                  minus = false;
              }
              else{
                 tex = tex.replace("-","");
                 result = result.replace("-","");
                 text.setText(tex);
                 minus = true;
              }
            }
        });

        button_percent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                   String tex = text.getText().toString();
                   if(tex.contains(",")){
                       tex = tex.replace(",",".");
                   }
                    tex = tex + "/100";
                System.out.println(tex);
                    double answer = calculate(tex);
                    String answer_string = String.valueOf(answer);
                    if(answer_string.endsWith(".0")){
                        answer_string = answer_string.replace(".0","");

                    }
                    text.setText(answer_string);
                    result = answer_string;

            }
        });

        button_dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tex = text.getText().toString();
                if(!tex.contains(",")){
                    dott = true;
                }
                if(dott){
                    tex = tex + ",";
                    result = result + ".";
                    text.setText(tex);
                    dott = false;
                }
            }
        });








    }

    private void set_id(MaterialButton button, int id) {
        button = (MaterialButton) findViewById(id);
        button.setOnClickListener(this);
    }

    private void set_id_operator(MaterialButton button , int id){
        button = (MaterialButton) findViewById(id);
    }

    @Override
    public void onClick(View v) {
        MaterialButton button = (MaterialButton) v;
        String button_text = button.getText().toString();

        //result = text.getText().toString();
         result_show = text.getText().toString();

        String result_test = result;
        result_test = result_test + button_text;
        //System.out.println(result_test);
        int i = result_test.length();
      if(result_test.matches("-?\\d+(\\.\\d+)?")) {
          if (i >= 4 && i < 10) {
              if (i >= 7) {
                  result_test = result_test.substring(0, i - 6) + "." + result_test.substring(i - 6, i - 3) + "." + result_test.substring(i - 3, i - 1);
                  result_show = result_test;
              } else {
                  result_test = result_test.substring(0, i - 3) + "." + result_test.substring(i - 3, i - 1);
                  result_show = result_test;
              }
          }
      }

         if(addition){
            result_show = "";
            result = result + "+";
             addition = false;
            reset_color(button_addition);
            //System.out.println(result);

         }
         if(subs){
             result_show = "";
             result = result + "-";
             subs = false;
             reset_color(button_substraction);
         }

        if(multi){
            result_show = "";
            result = result + "*";
            multi = false;
            reset_color(button_multi);
        }

        if(division){
            result_show = "";
            result = result + "/";
            division = false;
            reset_color(button_divide);
        }


            result_show = result_show + button_text;
            result = result + button_text;
            if (result.startsWith("0") && !result.startsWith("0.")) {
                if(Double.parseDouble(result) != 0) {
                    result = result.replace("0", "");
                }
                else{
                    result ="0";
                }
            }
        if (result_show.startsWith("0") && !result_show.startsWith("0,")) {
            if(Double.parseDouble(result_show) != 0) {
                result_show = result_show.replace("0", "");
            }
            else{
                result_show = "0";
            }
        }

        if(result.endsWith(".0")){
            result = result.replace(".0","");
        }
        if(result_show.endsWith(".0")){
            result_show = result_show.replace(".0","");
        }
        //System.out.println(result_show.length());



            System.out.println(result);
            text.setText(result_show);

    }

    public double calculate(String input) {
       try {
           Context rhino = Context.enter();
           rhino.setOptimizationLevel(-1);
           Scriptable scope = rhino.initStandardObjects();

           Object result = rhino.evaluateString(scope, input, "expression", 1, null);

           System.out.println(Context.toNumber(result));

           Context.exit();

           return (double) result;
       }
       catch(Exception e){
           text.setText("Error");
           return 0;
       }
    }

    public void change_color(MaterialButton button) {
        button.setTextColor(Color.parseColor("#FF9800"));
        final int[] colorList = new int[]{Color.parseColor("#FF9800"), Color.WHITE};
        ValueAnimator colorAnimation = ValueAnimator.ofArgb(colorList);
        colorAnimation.setDuration(400);
        colorAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animator) {
                button.setBackgroundTintList(ColorStateList.valueOf((int) animator.getAnimatedValue()));

            }
        });
        colorAnimation.start();
    }

    public void reset_color(MaterialButton button){
        button.setTextColor(Color.parseColor("#FFFFFF"));
        final int[] colorList = new int[]{ Color.WHITE,Color.parseColor("#FF9800")};
        ValueAnimator colorAnimation = ValueAnimator.ofArgb(colorList);
        colorAnimation.setDuration(400);
        colorAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animator) {
                button.setBackgroundTintList(ColorStateList.valueOf((int) animator.getAnimatedValue()));

            }
        });
        colorAnimation.start();
    }
}



