package up.edu.br.crudfuncionario.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class Conexao extends SQLiteOpenHelper {
    static SQLiteDatabase instance;

    public static SQLiteDatabase getInstance() {
        return instance;
    }

    public Conexao(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        instance = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE FUNCIONARIO(" +
                "guidFuncionario INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nome VARCHAR(255)," +
                "cpf VARCHAR(255)," +
                "cargo VARCHAR(255)," +
                "email VARCHAR(255)," +
                "telefone VARCHAR(255)" +
                "); ");



//        private Long guidFuncionario;
//        private String nome;
//        private String cpf;
//        private String cargo;
//        private String email;
//        private String telefone;

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        if(oldVersion == 1 && newVersion == 2) {
//            db.execSQL("CREATE TABLE FUNCIONARIO(" +
//                    "guidFuncionario INTEGER PRIMARY KEY AUTOINCREMENT," +
//                    "nome VARCHAR(255)," +
//                    "cpf VARCHAR(255)," +
//                    "cargo VARCHAR(255)," +
//                    "email VARCHAR(255)," +
//                    "telefone VARCHAR(255)" +
//                    "); ");
//        }
    }
}
