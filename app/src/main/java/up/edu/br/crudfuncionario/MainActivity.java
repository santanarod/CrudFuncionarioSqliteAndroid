package up.edu.br.crudfuncionario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import up.edu.br.crudfuncionario.dao.FuncionarioDao;
import up.edu.br.crudfuncionario.model.Funcionario;
import up.edu.br.crudfuncionario.sqlite.Conexao;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Conexao(getApplicationContext(),
                "funcionario.db",
                null,
                2);


    }

    public void salvar(View view) {
        EditText txtNome = findViewById(R.id.textNome);
        EditText txtCpf = findViewById(R.id.textCpf);
        Spinner spinnerCargo = findViewById(R.id.spinnerCargo);
        EditText txtEmail = findViewById(R.id.textEmail);
        EditText txtTelefone = findViewById(R.id.textTelefone);

        Funcionario funcionario = new Funcionario();
        funcionario.setNome(txtNome.getText().toString());
        funcionario.setCpf(txtCpf.getText().toString());
        funcionario.setCargo(spinnerCargo.getSelectedItem().toString());
        funcionario.setEmail(txtEmail.getText().toString());
        funcionario.setTelefone(txtTelefone.getText().toString());


        new FuncionarioDao().salvar(funcionario);



        Toast.
                makeText(getApplicationContext(),
                        "Funcionário Salvo",
                        Toast.LENGTH_LONG).show();
        Intent intentList = new Intent(this,ListActivity.class);
        startActivity(intentList);
    }
    
}
