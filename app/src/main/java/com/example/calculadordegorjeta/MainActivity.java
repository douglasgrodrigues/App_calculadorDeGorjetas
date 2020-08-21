package com.example.calculadordegorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editValor;
    private TextView textPorcentagem, textGorjeta, textTotal;
    private SeekBar seekBarGorjeta;

    private double porcentagem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editValor = findViewById(R.id.editValor);
        textGorjeta = findViewById(R.id.textGorjeta);
        textPorcentagem = findViewById(R.id.textPorcentagem);
        textTotal = findViewById(R.id.textTotal);
        seekBarGorjeta = findViewById(R.id.seekBarGorjeta);

        seekBarGorjeta.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                porcentagem = i;
                textPorcentagem.setText( Math.round(porcentagem) + " %" );
                calcular();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    public void calcular(){

        String valorRecuparado = editValor.getText().toString();
        if ( valorRecuparado == null || valorRecuparado.equals("") ){
            Toast.makeText(getApplicationContext(),"Informe um valor a calcular", Toast.LENGTH_SHORT).show();

        }else{

            double valorDigitado = Double.parseDouble( valorRecuparado );
            double gorjeta = valorDigitado * ( porcentagem/100 );
            double total = gorjeta + valorDigitado;



            textGorjeta.setText(("R$ " + Math.round(gorjeta)));
            textTotal.setText(("R$ " + Math.round(total)));
        }

    }



}
