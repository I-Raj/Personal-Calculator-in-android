package com.example.inchararaj.incharascalci;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity {

    private Button num0;
    private Button num1;
    private Button num2;
    private Button num3;
    private Button num4;
    private Button num5;
    private Button num6;
    private Button num7;
    private Button num8;
    private Button num9;

    private Button add;
    private Button sub;
    private Button mul;
    private Button div;
    private Button eq;
    private Button point;
    private Button del;

    private TextView compute;
    private TextView result;
    private boolean flag;

    private final char ADDITION = '+';
    private final char SUBTRACTION = '-';
    private final char MULTIPLICATION = '*';
    private final char DIVISION = '/';
    private final char EQU = '0';

    private double val1=Double.NaN;
    private double val2=Double.NaN;
    private char ACTION;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        setup();

        point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(compute.getText().toString().length()>0) {
                    CharSequence temp = compute.getText().toString();
                    char temp1 = temp.charAt(temp.length() - 1);
                    if (temp1 != '.') {
                        compute.setText(compute.getText().toString() + ".");
                    }
                }
                else {
                    compute.setText(".");
                }
            }
        });
        num0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute.setText(compute.getText().toString() + "0");
            }
        });
        num1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute.setText(compute.getText().toString() + "1");
            }
        });
        num2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute.setText(compute.getText().toString() + "2");
            }
        });
        num3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute.setText(compute.getText().toString() + "3");
            }
        });
        num4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute.setText(compute.getText().toString() + "4");
            }
        });
        num5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute.setText(compute.getText().toString() + "5");
            }
        });
        num6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute.setText(compute.getText().toString() + "6");
            }
        });
        num7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute.setText(compute.getText().toString() + "7");
            }
        });
        num8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute.setText(compute.getText().toString() + "8");
            }
        });
        num9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute.setText(compute.getText().toString() + "9");
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate();
                if(flag==true) {
                    ACTION = ADDITION;
                    result.setText(val1 + "               +");
                    compute.setText(null);
                }
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate();
                if(flag==true) {
                    ACTION = SUBTRACTION;
                    result.setText(String.valueOf(val1) + "                -");
                    compute.setText(null);
                }

            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate();
                if(flag==true) {
                    ACTION = MULTIPLICATION;
                    result.setText(String.valueOf(val1) + "                *");
                    compute.setText(null);
                }
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate();
                if(flag==true) {
                    ACTION = DIVISION;
                    result.setText(String.valueOf(val1) + "                /");
                    compute.setText(null);
                }
            }
        });
        eq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate();
                if(flag==true) {
                    ACTION = EQU;
                    result.setText(String.valueOf(val1));
                    val1 = Double.NaN;
                    val2 = Double.NaN;
                    compute.setText(null);
                }
            }
        });

        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute.setText(null);
                result.setText(null);
                val1=Double.NaN;
                val2=Double.NaN;
                }
        });
    }


    private void calculate() {
        if ((result.getText().toString().isEmpty()) && (compute.getText().toString().isEmpty()||(compute.getText().toString()=="."))){
            flag = false;
        } else {
            flag=true;
            if (!Double.isNaN(val1)) {
                if (compute.getText().length() > 0) {
                    val2 = Double.parseDouble(compute.getText().toString());

                    switch (ACTION) {
                        case ADDITION:
                            val1 = val1 + val2;
                            break;

                        case SUBTRACTION:
                            val1 = val1 - val2;
                            break;

                        case MULTIPLICATION:
                            val1 = val1 * val2;
                            break;

                        case DIVISION:
                            val1 = val1 / val2;
                            break;

                        case EQU:
                            val1 = Double.parseDouble(result.getText().toString());
                            break;
                    }
                }
            } else {
                if (result.getText().toString().length() == 0) {
                    val1 = Double.parseDouble(compute.getText().toString());
                } else {
                    val1 = Double.parseDouble(result.getText().toString());
                }
            }
        }
    }

    private void setup() {
        num0=(Button)findViewById(R.id.B0);
        num1=(Button)findViewById(R.id.B1);
        num2=(Button)findViewById(R.id.B2);
        num3=(Button)findViewById(R.id.B3);
        num4=(Button)findViewById(R.id.B4);
        num5=(Button)findViewById(R.id.B5);
        num6=(Button)findViewById(R.id.B6);
        num7=(Button)findViewById(R.id.B7);
        num8=(Button)findViewById(R.id.B8);
        num9=(Button)findViewById(R.id.B9);

        add=(Button)findViewById(R.id.Badd);
        sub=(Button)findViewById(R.id.Bsub);
        mul=(Button)findViewById(R.id.Bmul);
        div=(Button)findViewById(R.id.Bdiv);
        del=(Button)findViewById(R.id.Bdel);
        eq=(Button)findViewById(R.id.Beq);
        point=(Button)findViewById(R.id.Bpoint);
        compute=(TextView)findViewById(R.id.Tcompute);
        result=(TextView) findViewById(R.id.Tresult);
    }
}



