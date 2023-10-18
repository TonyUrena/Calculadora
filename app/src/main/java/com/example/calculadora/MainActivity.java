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
        TextViewOperaciones.setText(Integer.toString(Calculator.calculate((String) TextViewOperaciones.getText())));
    }
    public void borraOperaciones(View v) {
        TextViewOperaciones.setText("0");
    }

}
