package br.edu.fatec.converterbinario;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import br.edu.fatec.converterbinario.controllers.ConversorBinarioController;

public class MainActivity extends AppCompatActivity {

    private EditText etNumero;
    private TextView tvError;
    private TextView tvResultado;
    private Button converterButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etNumero = findViewById(R.id.etNumero);
        tvError = findViewById(R.id.tvError);
        tvResultado = findViewById(R.id.tvResultado);
        converterButton = findViewById(R.id.converterButton);

        converterButton.setOnClickListener(op -> converter());
    }

    private void converter() {
        var conversorController = new ConversorBinarioController();
        int num = 0;

        if (!etNumero.getText().toString().isEmpty() && !etNumero.getText().toString().isBlank()) {
            num = Integer.parseInt(etNumero.getText().toString());
        }

        if (num > 1 && num <= 1000) {
            tvError.setText("");
            String binario = conversorController.converter(num);
            tvResultado.setText(String.format(getResources().getString(R.string.tv_resultado_preenchido), binario));
        } else {
            tvError.setText(R.string.et_error);
            tvResultado.setText(getResources().getString(R.string.tv_resultado));
            etNumero.setText("");
        }
    }
}