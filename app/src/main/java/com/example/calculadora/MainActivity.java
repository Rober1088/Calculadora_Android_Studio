package com.example.calculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView TvResultado;

    private double numero1 = 0.0;
    private double numero2 = 0.0;
    private char operador = ' ';

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TvResultado = findViewById(R.id.TvResultado);
        TvResultado.setText("0");
    }

    /* ======================
       ESCRIBIR NÚMEROS
       ====================== */
    public void escribirNumero(View view) {
        String valor = ((TextView) view).getText().toString();
        String actual = TvResultado.getText().toString();

        if (actual.equals("0")) {
            TvResultado.setText(valor);
        } else {
            TvResultado.append(valor);
        }
    }

    /* ======================
       OPERADORES
       ====================== */
    public void operar(View view) {
        numero1 = Double.parseDouble(TvResultado.getText().toString());
        operador = ((TextView) view).getText().toString().charAt(0);
        TvResultado.setText("0");
    }

    /* ======================
       RESULTADO
       ====================== */
    public void BotonResultado(View view) {
        numero2 = Double.parseDouble(TvResultado.getText().toString());

        double resultado;

        switch (operador) {
            case '+':
                resultado = numero1 + numero2;
                break;
            case '-':
                resultado = numero1 - numero2;
                break;
            case '*':
                resultado = numero1 * numero2;
                break;
            case '/':
                if (numero2 == 0) {
                    Toast.makeText(this, "OPERACIÓN NO VÁLIDA", Toast.LENGTH_SHORT).show();
                    TvResultado.setText("0");
                    return;
                }
                resultado = numero1 / numero2;
                break;
            case '%':
                resultado = numero1 % numero2;
                break;
            default:
                return;
        }

        TvResultado.setText(String.valueOf(resultado));
        operador = ' ';
    }

    /* ======================
       UTILIDADES
       ====================== */
    public void Borrar(View view) {
        numero1 = 0.0;
        numero2 = 0.0;
        operador = ' ';
        TvResultado.setText("0");
    }

    public void Punto(View view) {
        String texto = TvResultado.getText().toString();
        if (!texto.contains(".")) {
            TvResultado.append(".");
        }
    }

    public void borrarUltimoNumero(View view) {
        String texto = TvResultado.getText().toString();

        if (texto.length() > 1) {
            TvResultado.setText(texto.substring(0, texto.length() - 1));
        } else {
            TvResultado.setText("0");
        }
    }
}
