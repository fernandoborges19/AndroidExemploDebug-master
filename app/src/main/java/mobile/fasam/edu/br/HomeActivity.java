package mobile.fasam.edu.br;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class HomeActivity extends DebugActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void exibirTela(View view) {

        int opcao = view.getId();
        Intent intent;

        //Verificar qual botao foi acionado
        switch (opcao){
            //Exibir a tela Main
            case R.id.btnMain:
                 intent = new Intent(this,MainActivity.class);

                 Bundle b = new Bundle();
                 b.putString("nome","Carlos Henrique");
                 intent.putExtras(b);
                startActivity(intent);

                break;
                //exibir a tela Lista
            case R.id.btnLista:
                 intent = new Intent(this,ListaActivity.class);
                startActivity(intent);

                break;

                //exibir a tela AlunoActivity
            case R.id.btnAluno:

                //Passagem de dados de uma tela para a outra
                //Prepara a intenção para passar os dados

                intent = new Intent(this,AlunoActivity.class);
                intent.putExtra("dados","Exemplo de passagem de parametros");
                startActivity(intent);

                break;

            case R.id.btnProfessor:

                break;


              default:

              Toast.makeText(getApplicationContext(),"Opcao Invalida",Toast.LENGTH_LONG).show();

              break;
        }
    }
}
