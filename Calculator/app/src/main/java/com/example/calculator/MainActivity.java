package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    Button CE_btn, C_btn, open, close, btn7, btn8, btn9, Multiple_btn, btn4, btn5, btn6,
            Minus_btn, btn1, btn2, btn3, Plus_btn, btn0, btn_dot, btn_equal, btn_sec, btn_percentage;
    EditText editText;
    TextView txtResult, txtSolution;
    String input, output, newoutput;
    int val1, val2;
    boolean isNewop = true;

    void init() {
        txtResult = findViewById(R.id.txtResult);
        txtSolution = findViewById(R.id.txtsolution);
        CE_btn = findViewById(R.id.numCE);
        C_btn = findViewById(R.id.numC);
        open = findViewById(R.id.parentheses_o);
//    close = findViewById(R.id.parentheses_c);
//    DEL_btn = findViewById(R.id.delete);
        btn7 = findViewById(R.id.n7);
        btn8 = findViewById(R.id.n8);
        btn9 = findViewById(R.id.n9);
        Multiple_btn = findViewById(R.id.multiple);
        btn4 = findViewById(R.id.n4);
        btn5 = findViewById(R.id.n5);
        btn6 = findViewById(R.id.n6);
        Minus_btn = findViewById(R.id.minus);
        btn1 = findViewById(R.id.n1);
        btn2 = findViewById(R.id.n2);
        btn3 = findViewById(R.id.n3);
        Plus_btn = findViewById(R.id.plus);
        btn0 = findViewById(R.id.zero);
        btn_dot = findViewById(R.id.dot);
        btn_equal = findViewById(R.id.equal);
        btn_sec = findViewById(R.id.sec);
        btn_percentage = findViewById(R.id.percentage);
    }
//void assignID(Button btn, int id, String action) {
//    btn = findViewById(id);
//    btn.setOnClickListener(new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            if(txtSolution.getText().length() == 0) {
//                Toast.makeText(MainActivity.this, "Định dạng không hợp lệ", Toast.LENGTH_SHORT).show();
//            }
//            else {
//                action = "";
//            }
//        }
//    });
//}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        if (isNewop)
            txtSolution.setText("");
        // assignID(btn1, R.id.n1);
//        btn1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                editText.setText(editText.getText() + "1");
//            }
//        });
//onClick(btn0);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                txtSolution.setText(txtSolution.getText() + "2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtSolution.setText(txtSolution.getText() + "3");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtSolution.setText(txtSolution.getText() + "4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtSolution.setText(txtSolution.getText() + "5");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtSolution.setText(txtSolution.getText() + "6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtSolution.setText(txtSolution.getText() + "7");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtSolution.setText(txtSolution.getText() + "8");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtSolution.setText(txtSolution.getText() + "9");
            }
        });
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtSolution.setText(txtSolution.getText() + "0");
            }
        });
        CE_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = txtSolution.getText().toString();
                if (txtSolution.getText() == null) {
                    Toast.makeText(MainActivity.this, "Không có kí tự cần xoá", Toast.LENGTH_SHORT).show();
                } else {
                    number = number.substring(0, number.length() - 1);
                }
                txtSolution.setText(number);
                txtResult.setText(number);
            }
        });
        C_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtSolution.setText(null);
                txtResult.setText(null);
                output = "";
                input = "";
            }
        });
        Minus_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtSolution.getText().length() == 0) {
                    Toast.makeText(MainActivity.this, "Định dạng không hợp lệ", Toast.LENGTH_SHORT).show();
                } else {
                    input = txtSolution.getText().toString() + "-";
                    txtSolution.setText(input);
                    solve_sub();
                }
            }
        });
        Multiple_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtSolution.getText().length() == 0) {
                    Toast.makeText(MainActivity.this, "Định dạng không hợp lệ", Toast.LENGTH_SHORT).show();
                } else {
                    input = txtSolution.getText().toString() + "*";
                    txtSolution.setText(input);
                    solve_Mul();
                }
            }
        });
        Plus_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtSolution.getText().length() == 0) {
                    Toast.makeText(MainActivity.this, "Định dạng không hợp lệ", Toast.LENGTH_SHORT).show();
                } else {
                    input = txtSolution.getText().toString();
//                    txtSolution.setText(txtSolution.getText() + "+");
//                    input = txtSolution.getText().toString();
                    txtSolution.setText(input + "+");
                    if (input.length() > 2) {

                        solve();
                    }
                }
            }
        });

        btn_percentage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input = txtSolution.getText().toString();
                if (txtSolution.getText().length() == 0) {
                    Toast.makeText(MainActivity.this, "Định dạng không hợp lệ", Toast.LENGTH_SHORT).show();
                } else {
                    input = input + "%";
                    double d = Double.parseDouble(txtSolution.getText().toString()) / 100;
                    txtSolution.setText(input);
                    txtResult.setText(String.valueOf(d));


                }
            }
        });

    }

    public void calculateArraySum(String arr[]) {
        double sum = 0;
        double num;
        for (int i = 0; i < arr.length; i++) {
            sum += Double.parseDouble(arr[i]);
        }
        output = cutDecimal(String.valueOf(sum));
    }

    public void calculateSubtraction(String arr[]) {
        double sub = Double.parseDouble(arr[0]);
        for (int i = 1; i <= arr.length-1; i++) {
            sub -= Double.parseDouble(arr[i]);

        }
        output = cutDecimal(String.valueOf(sub));

    }

    public void calculateMultipile(String arr[]) {
        double mul = 1;
        for (int i = 0; i < arr.length; i++) {
            mul = mul * Double.parseDouble(arr[i]);
            output = cutDecimal(String.valueOf(mul));
        }
    }

    public void solve_Mul() {
        if (input.split("\\*").length >= 2) {
            String number[] = input.split("\\*");
            calculateMultipile(number);
        }
        txtResult.setText(output);
    }

    public void solve() {
        double sum;
        if (input.split("\\+").length >= 2) {
            String number[] = input.split("\\+");
            calculateArraySum(number);
        }

        txtResult.setText(output);
    }

    public void solve_sub() {
        if (input.split("\\-").length >= 1) {
            String number[] = input.split("\\-");
            calculateSubtraction(number);
        }
        txtResult.setText(output);
    }
    public String cutDecimal(String number) {
        String n[] = number.split("\\.");
        if (n.length > 1) {
            if (n[1].equals("0")) {
                number = n[0];
            }
        }
        return number;
    }

}