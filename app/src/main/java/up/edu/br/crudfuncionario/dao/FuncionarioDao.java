package up.edu.br.crudfuncionario.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

import up.edu.br.crudfuncionario.model.Funcionario;
import up.edu.br.crudfuncionario.sqlite.Conexao;

public class FuncionarioDao {

    static ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();

    public void salvar(Funcionario funcionario) {
        SQLiteDatabase db = Conexao.getInstance();

        ContentValues values = new ContentValues();

        values.put("nome", funcionario.getNome());
        values.put("cpf", funcionario.getCpf());
        values.put("cargo", funcionario.getCargo());
        values.put("email", funcionario.getEmail());
        values.put("telefone", funcionario.getTelefone());

        db.insert("FUNCIONARIO", null, values);

    }

    public void deletar(Integer index) {


        Funcionario funcionario = funcionarios.get(index);

        Long guid = funcionario.getGuidFuncionario();
        SQLiteDatabase db = Conexao.getInstance();

        db.delete("FUNCIONARIO", "guidFuncionario" + "=" + Long.toString(guid), null);

        funcionarios.remove(index);

    }

    public List<Funcionario> listar() {
        /*List<Funcionario> funcionarios = new ArrayList<>();*/

        funcionarios.clear();
        SQLiteDatabase db = Conexao.getInstance();
        Cursor cursor = db.query("FUNCIONARIO",
                new String [] {"guidFuncionario","nome","cpf","cargo","email","telefone"}, null, null, null, null, null);


        if (cursor.moveToFirst()) {

        do {
            Funcionario funcionario = new Funcionario();
            funcionario.setGuidFuncionario(cursor.getLong(0));
            funcionario.setNome(cursor.getString(1));
            funcionario.setCpf(cursor.getString(2));
            funcionario.setCargo(cursor.getString(3));
            funcionario.setEmail(cursor.getString(4));
            funcionario.setTelefone(cursor.getString(5));
            funcionarios.add(funcionario);

            } while (cursor.moveToNext());
        }


        return funcionarios;
    }

}
