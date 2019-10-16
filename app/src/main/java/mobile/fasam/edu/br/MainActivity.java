package mobile.fasam.edu.br;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends DebugActivity {
    EditText txtNome;
    EditText txtTelefone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        if(getIntent().getExtras()!=null){
            Bundle b = getIntent().getExtras();
            Toast.makeText(getApplicationContext(),b.get("nome").toString(), Toast.LENGTH_LONG).show();
        }



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void exibir(View view) {
        //passo 1 capturar dados da tela
        txtNome = findViewById(R.id.txtNome);
        txtTelefone = findViewById(R.id.txtTelefone);

        //pegar o texto que o usuario digitou
        String nome,telefone;
        nome = txtNome.getText().toString();
        telefone = txtTelefone.getText().toString();

        //Exibir dados ao usuario
        String dados = String.format("O texto digitado foi:\n %s \n %s",nome, telefone);

        //Exibir os dados para o usuario
        Toast.makeText(getApplicationContext(), dados,Toast.LENGTH_LONG).show();
    }
}
