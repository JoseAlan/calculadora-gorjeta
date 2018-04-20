package br.com.udemy.calculadoradegorjetas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText valorPag;
    private TextView porcentGorj;
    private TextView textGorj;
    private TextView textTotal;
    private SeekBar seekGorj;

    private double porcentagem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valorPag = findViewById(R.id.main_edit_text);
        porcentGorj = findViewById(R.id.main_percent);
        textGorj = findViewById(R.id.main_gorjeta_valor);
        textTotal = findViewById(R.id.main_total_valor);
        seekGorj = findViewById(R.id.main_seekbar);


        seekGorj.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                porcentagem = seekBar.getProgress();
                porcentGorj.setText(Math.round(porcentagem) + "%");
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

    private void calcular() {

        double valorDigitado = Double.parseDouble(valorPag.getText().toString());
        double gorjeta = valorDigitado * (porcentagem / 100);
        double total = valorDigitado + gorjeta;
        textGorj.setText("R$ " + Math.round(gorjeta));
        textTotal.setText("R$ " + Math.round(total));
    }
}
