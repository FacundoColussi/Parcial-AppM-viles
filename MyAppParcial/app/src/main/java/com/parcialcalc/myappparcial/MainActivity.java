package com.parcialcalc.myappparcial;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText txt1, txt2;
    private RadioGroup radioGroup;
    private RadioButton rbSuma, rbResta, rbProducto, rbDivision;
    private Button btCalcular;
    private TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    //variables
        txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt2);
        radioGroup = findViewById(R.id.radioGroup);
        rbSuma = findViewById(R.id.rb_suma);
        rbResta = findViewById(R.id.rb_resta);
        rbProducto = findViewById(R.id.rb_producto);
        rbDivision = findViewById(R.id.rb_division);
        btCalcular = findViewById(R.id.bt_calcular);
        tvResultado = findViewById(R.id.tv_resultado);

        btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularResultado();
            }
        });
    }

    private void calcularResultado() {
        String str1 = txt1.getText().toString();
        String str2 = txt2.getText().toString();

        if (str1.isEmpty() || str2.isEmpty()) {
            tvResultado.setText("Por favor, ingrese un numero! .");
            return;
        }

        double num1 = Double.parseDouble(str1);
        double num2 = Double.parseDouble(str2);
        double resultado = 0;

        int selectedId = radioGroup.getCheckedRadioButtonId();

        if (selectedId == rbSuma.getId()) {
            resultado = num1 + num2;
        } else if (selectedId == rbResta.getId()) {
            resultado = num1 - num2;
        } else if (selectedId == rbProducto.getId()) {
            resultado = num1 * num2;
        } else if (selectedId == rbDivision.getId()) {
            if (num2 != 0) {
                resultado = num1 / num2;
            } else {
                tvResultado.setText("Error");
                return;
            }
        } else {
            tvResultado.setText("seleccione una operación.");
            return;
        }

        tvResultado.setText("Resultado: " + resultado);
    }
}