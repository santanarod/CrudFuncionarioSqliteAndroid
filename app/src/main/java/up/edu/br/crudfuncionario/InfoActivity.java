package up.edu.br.crudfuncionario;

import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import up.edu.br.crudfuncionario.dao.FuncionarioDao;
import up.edu.br.crudfuncionario.model.Funcionario;

import static up.edu.br.crudfuncionario.dao.FuncionarioDao.*;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView txtNome = findViewById(R.id.textNameValue);
        TextView txtCpf = findViewById(R.id.textCPFValue);
        TextView txtTelefone = findViewById(R.id.textTelValue);
        TextView txtCargo = findViewById(R.id.textCargoValue);
        TextView txtEmail = findViewById(R.id.textMailValue);

        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios = new FuncionarioDao().listar();

        Bundle bundle = getIntent().getExtras();
        if (bundle != null)
        {
            String valuebundle = bundle.getString("pos");
            String Name = funcionarios.get(Integer.parseInt(valuebundle)).getNome();
            String CPF = funcionarios.get(Integer.parseInt(valuebundle)).getCpf();
            String Telefone = funcionarios.get(Integer.parseInt(valuebundle)).getTelefone();
            String Cargo = funcionarios.get(Integer.parseInt(valuebundle)).getCargo();
            String Email = funcionarios.get(Integer.parseInt(valuebundle)).getEmail();
            /*toolbar.setTitle(Name);*/
            txtNome.setText(Name);
            txtCpf.setText(CPF);
            txtTelefone.setText(Telefone);
            txtCargo.setText(Cargo);
            txtEmail.setText(Email);
        }

    }

    public void callFunc(View view)
    {
        TextView txtTelefone = findViewById(R.id.textTelValue);
        String Telefone = txtTelefone.getText().toString();
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", Telefone, null));
        startActivity(intent);
    }

    public void Delete(View view)
    {

        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios = new FuncionarioDao().listar();
        Bundle bundle = getIntent().getExtras();
        Integer pos = Integer.parseInt(bundle.getString("pos"));

        CharSequence text = bundle.getString("pos");
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(getApplicationContext(), text, duration);
        toast.show();

        new FuncionarioDao().deletar(pos);

        Intent list = new Intent(InfoActivity.this, ListActivity.class );
        startActivity(list);
    }

}
