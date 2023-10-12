package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    TextView TextViewOperaciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextViewOperaciones = (TextView) findViewById(R.id.TextViewOperaciones);
    }

    public void anadeCaracter(View v) {
        if (TextViewOperaciones.getText().equals("0")) TextViewOperaciones.setText("");
        TextViewOperaciones.setText(TextViewOperaciones.getText().toString() + ((Button) v).getText());
    }

    public void calculaOperaciones(View v) {
        TextViewOperaciones.setText(Integer.toString(calculate((String) TextViewOperaciones.getText())));
    }

    public static int calculate(String operacion) {

        if (!operacion.contains("+") && !operacion.contains("-")) {
            try {
                return Integer.parseInt(operacion);
            } catch (NumberFormatException e) {
                return -1;
            }
        } else {
            int indiceMas = operacion.lastIndexOf("+");
            int indiceMenos = operacion.lastIndexOf("-");
            int indiceOperador;

            if (indiceMas != -1 && indiceMenos != -1) {
                indiceOperador = Math.max(indiceMas, indiceMenos);
            } else {
                indiceOperador = (indiceMas != -1) ? indiceMas : indiceMenos;
            }

            String string1 = operacion.substring(0, indiceOperador);
            String string2 = operacion.substring(indiceOperador + 1);

            int resultado1 = calculate(string1);
            int resultado2 = calculate(string2);

            if (resultado1 == -1 || resultado2 == -1) {
                return -1;
            }

            char o = operacion.charAt(indiceOperador);
            switch (o) {
                case '+':
                    return resultado1 + resultado2;
                case '-':
                    return resultado1 - resultado2;
                default:
                    return -1;
            }
        }
    }

    public void borraOperaciones(View v) {
        TextViewOperaciones.setText("0");
    }

}
