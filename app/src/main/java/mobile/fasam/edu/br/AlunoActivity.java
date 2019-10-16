package mobile.fasam.edu.br;

import android.icu.text.TimeZoneFormat;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.net.PasswordAuthentication;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AlunoActivity extends DebugActivity {

    EditText txtNomeAluno;
    EditText txtNota1;
    EditText txtNota2;
    EditText txtNota3;
    float media;
    ListView listView;

    List<HashMap<String,String>> listaAluno = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aluno);
    }

    public void AdicionarAluno(View view) {


        //passo 1 capturar dados da tela
        //FById busca daados por Id
        txtNomeAluno = findViewById(R.id.txtNomeAluno);
        txtNota1 = findViewById(R.id.txtNota1);
        txtNota2 = findViewById(R.id.txtNota2);
        txtNota3 = findViewById(R.id.txtNota3);

        //pegar o texto que o usuario digitou
        String nome,nota1,nota2,nota3;

        nome = txtNomeAluno.getText().toString();
        nota1 = txtNota1.getText().toString();
        nota2 = txtNota2.getText().toString();
        nota3 = txtNota3.getText().toString();

        float n1,n2,n3, media;

        n1 = Float.parseFloat(nota1);
        n2 = Float.parseFloat(nota2);
        n3 = Float.parseFloat(nota3);

        media = (n1+n2+n3)/3;

        String mediaS;

        mediaS = Float.toString(media);

        //Formatr saida para o usuario
        String dados = String.format("O texto digitado foi:\n %s \n %s",nome,nota1,nota2,nota3);

        //mapa como um "array associativo", K = key, V = value
        HashMap<String,String> map = new HashMap<>();
        map.put("Nome",nome);
        map.put("Nota1",nota1);
        map.put("Nota2",nota2);
        map.put("Nota3",nota3);
        map.put("Media",mediaS);


        //adiciona o map na lista
        listaAluno.add(map);

        //id's do layout item.xml
        String[] de = {"Nome","Nota1","Nota2","Nota3","Media"};
        int[] para =  {R.id.labelNomeAluno,R.id.labelNota1,R.id.labelNota2,R.id.labelNota3,R.id.labelMedia};

        //Criar o SimpleAdapter
        SimpleAdapter adapter = new SimpleAdapter(getApplicationContext(),listaAluno,R.layout.aluno,de,para);

        //Buscar a ListView e imprimir os dados
        listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);


    }
}
