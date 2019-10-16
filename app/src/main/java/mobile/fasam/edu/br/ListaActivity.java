package mobile.fasam.edu.br;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListaActivity extends DebugActivity {

    EditText txtNome;
    EditText txtEmail;
    ListView listView;

    List<HashMap<String,String>> lista = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
    }

    public void Adicionar (View view) {

        //passo 1 capturar dados da tela
        //FById busca daados por Id
        txtNome = findViewById(R.id.txtNome);
        txtEmail = findViewById(R.id.txtEmail);

        //pegar o texto que o usuario digitou
        String nome,email;

        nome = txtNome.getText().toString();
        email = txtEmail.getText().toString();

        //Formatr saida para o usuario
        String dados = String.format("O texto digitado foi:\n %s \n %s",nome, email);

        //mapa como um "array associativo", K = key, V = value
        HashMap<String,String> map = new HashMap<>();
        map.put("nome",nome);
        map.put("email",email);


        //adiciona o map na lista
        lista.add(map);

        //id's do layout item.xml
        String[] de = {"nome","email"};
        int[] para =  {R.id.labelNome,R.id.labelEmail};

        //Criar o SimpleAdapter
        SimpleAdapter adapter = new SimpleAdapter(getApplicationContext(),lista,R.layout.item,de,para);

        //Buscar a ListView e imprimir os dados
        listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);



    }
}
