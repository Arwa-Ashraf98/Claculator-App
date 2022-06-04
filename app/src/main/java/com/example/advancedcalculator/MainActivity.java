package com.example.advancedcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.advancedcalculator.databinding.ActivityMainBinding;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding ;
    String input , operator , output ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        onClicks();
    }

    private void onClicks (){
        binding.btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input = binding.textResult.getText().toString().trim();
                binding.textResult.setText(input + "0");
            }
        });
        binding.btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input = binding.textResult.getText().toString().trim();
                binding.textResult.setText(input+ "1");
            }
        });
        binding.btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input = binding.textResult.getText().toString().trim();
                binding.textResult.setText(input+ "2");
            }
        });
        binding.btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input = binding.textResult.getText().toString().trim();
                binding.textResult.setText(input +"3");
            }
        });
        binding.btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input = binding.textResult.getText().toString().trim();
                binding.textResult.setText(input+ "4");
            }
        });
        binding.btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input = binding.textResult.getText().toString().trim();
                binding.textResult.setText(input+ "5");
            }
        });
        binding.btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input = binding.textResult.getText().toString().trim();
                binding.textResult.setText(input+ "6");
            }
        });
        binding.btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input = binding.textResult.getText().toString().trim();
                binding.textResult.setText(input+ "7");
            }
        });
        binding.btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input = binding.textResult.getText().toString().trim();
                binding.textResult.setText(input+ "8");
            }
        });
        binding.btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input = binding.textResult.getText().toString().trim();
                binding.textResult.setText(input +"9");
            }
        });
        binding.btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input = null ;
                output = null ;
                binding.textResult.setText(null);

            }
        });
        binding.btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input = binding.textResult.getText().toString().trim();
                binding.textResult.setText(input+ ".");
            }
        });
        binding.btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    input= binding.textResult.getText().toString().trim();
                    binding.textResult.setText(input+"+");

            }
        });
        binding.btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    input= binding.textResult.getText().toString().trim();
                    binding.textResult.setText(input+"-");

            }
        });
        binding.btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    input= binding.textResult.getText().toString().trim();
                    binding.textResult.setText(input+"*");
            }
        });
        binding.btnDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    input= binding.textResult.getText().toString().trim();
                    binding.textResult.setText(input+"/");
            }
        });
       binding.btnPercentage.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
                   input= binding.textResult.getText().toString().trim();
                   binding.textResult.setText(input+"%");
                   double percentage = Double.parseDouble(input) / 100 ;
                   binding.textResult.setText(String.valueOf(percentage));
           }
       });
       binding.btnPower.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               input = binding.textResult.getText().toString().trim();
               binding.textResult.setText(input+"^");
           }
       });
       binding.btnEqual.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               input = binding.textResult.getText().toString().trim();
               check_operator(input);
               String op ;
               op = operator ;
               if (!input.isEmpty()){
                   if (input.length()>=2){
                       String [] numbers = input.split(op);
                       binding.textResult.setText(input + "=");
                       double num1 = Double.parseDouble(numbers[0]);
                       double num2 = Double.parseDouble(numbers[1]);
                       operation(num1,num2,op);
                   }else if (input.length()<2){
                       binding.textResult.setText(input);

                       /*if (op.isEmpty()){
                           binding.textInput.setText(input);
                           binding.textOutput.setText(input);
                       }else if (!op.isEmpty()){
                           String [] numbers = input.split(op);
                           if (numbers[0].isEmpty()){
                               numbers[0] = "0";
                               double num1 = Double.parseDouble(numbers[0]);
                               double num2 = Double.parseDouble(numbers[1]);
                               operation(num1,num2,op);
                           }else if (numbers[1].isEmpty()){
                               numbers[1] = "0";
                               double num1 = Double.parseDouble(numbers[0]);
                               double num2 = Double.parseDouble(numbers[1]);
                               operation(num1,num2,op);
                           }
                       }*/
                   }
                   }else if (input.isEmpty()) {
                   binding.textResult.setError(getString(R.string.plz_enter_op));
                   Toast.makeText(MainActivity.this, R.string.plz_enter_op, Toast.LENGTH_SHORT).show();
               }

           }
       });
    }
    private String check_operator (String text){
        if (text.contains("+")){
            operator = "\\+";
        }else if (text.contains("-")){
            operator = "-";
        }else if (text.contains("*")){
            operator= "\\*" ;
        }else if (text.contains("/")){
            operator = "/";
        }else if (text.contains("^")){
            operator = "\\^";
        }else if (text.contains("%")){
            operator="\\%";
        }
        return operator ;
    }
    private void operation (double num1 , double num2 , String op) {
        double res = 0.0;
        switch (operator) {
            case "\\+":
                res = num1 + num2;
                output = Double.toString(res);
                String newOUTPUT = cutDecimal(output);
                binding.textResult.setText(newOUTPUT);
                break;
            case "-":
                    res = num1 -  num2 ;
                    output = Double.toString(res);
                    newOUTPUT = cutDecimal(output);
                    binding.textResult.setText(newOUTPUT);
                break;
            case "\\*":
                res = num1 * num2;
                output = Double.toString(res);
                newOUTPUT = cutDecimal(output);
                binding.textResult.setText(newOUTPUT);
                break;
            case "/":
                if (num2 == 0) {
                    binding.textResult.setError("Invalid number");
                } else {
                    res =num1/num2;
                    output = Double.toString(res);
                    newOUTPUT = cutDecimal(output);
                    binding.textResult.setText(newOUTPUT);
                }
                break;
            case "\\^":
                res =Math.pow(num1,num2);
                output = Double.toString(res);
                newOUTPUT = cutDecimal(output);
                binding.textResult.setText(newOUTPUT);
                break;

        }
    }
    private  String cutDecimal (String number){
        String [] num = number.split("\\.");
        if (num.length>1){
            if(num[1].equals("0")){
                number = num[0];
            }
        }
        return number ;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding=null;
    }
}