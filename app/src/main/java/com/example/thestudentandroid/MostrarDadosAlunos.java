package com.example.thestudentandroid;

import static com.example.thestudentandroid.DBAlunos.TABLENAME;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import java.util.ArrayList;

public class MostrarDadosAlunos extends AppCompatActivity {

    DBAlunos dDAlunos;
    SQLiteDatabase sqLiteDatabase;
    RecyclerView recyclerView;
    ThisAppAdapter thisAppAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_dados_alunos);
        dDAlunos = new DBAlunos(this);
        
        // Criar métodos
        findid();
        mostrarDadosAluno();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void mostrarDadosAluno() {
        sqLiteDatabase = dDAlunos.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select *from "+TABLENAME+"", null);
        ArrayList<Model>modelArrayList = new ArrayList<>();
        while (cursor.moveToNext()){
            int id = cursor.getInt(0);
            String nomeAluno = cursor.getString(1);
            String moradaAluno = cursor.getString(2);
            String telefoneAluno = cursor.getString(3);
            String emailAluno = cursor.getString(4);
            modelArrayList.add(new Model(id, nomeAluno, moradaAluno, telefoneAluno, emailAluno));
        }
        cursor.close();
        thisAppAdapter = new ThisAppAdapter(this, R.layout.singledata, modelArrayList, sqLiteDatabase);
        recyclerView.setAdapter(thisAppAdapter);
    }

    private void findid() { recyclerView=findViewById(R.id.rv); }


}