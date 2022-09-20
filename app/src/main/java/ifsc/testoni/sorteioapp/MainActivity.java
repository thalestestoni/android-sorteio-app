package ifsc.testoni.sorteioapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sortear(View view) {
        EditText editTextValor1 = findViewById(R.id.valor1);
        EditText editTextValor2 = findViewById(R.id.valor2);

        int valor1 = 0;
        int valor2 = 0;

        try {
            valor1 = Integer.parseInt(editTextValor1.getText().toString());
            valor2 = Integer.parseInt(editTextValor2.getText().toString());
        } catch (Exception e) {
            setarMensagem("Todos os valores devem ser informados com números inteiros");
            return;
        }

        int valorMax = Math.max(valor1, valor2);
        int valorMin = Math.min(valor1, valor2);

        Random rand = new Random();
        int numeroSorteado = rand.nextInt(valorMax - valorMin) + valorMin;

        setarMensagem(Integer.toString(numeroSorteado));
    }

    private void setarMensagem(String mensagem) {
        TextView textViewMensagem = findViewById(R.id.mensagem);
        textViewMensagem.setText(mensagem);
    }
}