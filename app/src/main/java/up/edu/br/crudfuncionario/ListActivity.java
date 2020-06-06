package up.edu.br.crudfuncionario;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.content.Intent;

import java.util.ArrayList;
import java.util.List;

import up.edu.br.crudfuncionario.dao.FuncionarioDao;
import up.edu.br.crudfuncionario.model.Funcionario;

public class ListActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        final ListView listFuncionarios = findViewById(R.id.listFuncionarios);

        ArrayAdapter<Funcionario> arrayFuncionarios =
                new ArrayAdapter<>(getApplicationContext(),
                        android.R.layout.simple_list_item_1);

        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios = new FuncionarioDao().listar();

        arrayFuncionarios.addAll(funcionarios);

        listFuncionarios.setAdapter(arrayFuncionarios);

        listFuncionarios.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent infos = new Intent(ListActivity.this, InfoActivity.class );
                infos.putExtra("pos", Integer.toString(position));
                startActivity(infos);
            }
        });

        arrayFuncionarios.notifyDataSetChanged();
        updateListView();
    }

    @Override
    protected void onResume() {
        super.onResume();

        updateListView();
    }

    public void updateListView() {
        ArrayAdapter<Funcionario> arrayFuncionarios =
                new ArrayAdapter<>(getApplicationContext(),
                        android.R.layout.simple_list_item_1);

        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios = new FuncionarioDao().listar();

        arrayFuncionarios.addAll(funcionarios);
    }

    public void fechaTela(View view) {
        finish();
    }

}