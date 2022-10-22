package com.example.thestudentandroid;

import static com.example.thestudentandroid.DBAlunos.TABLENAME;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Home extends AppCompatActivity {

DBAlunos dBAlunos;
SQLiteDatabase sqLiteDatabase;
EditText nomeAluno, moradaAluno, telefoneAluno, emailAluno;
Button submit, display, edit;
int id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        
        dBAlunos = new DBAlunos(this);
        // create method
        finidid();
        insertDate();
    }

    private void insertDate() {
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContentValues cv = new ContentValues();
                cv.put("nomeAluno", nomeAluno.getText().toString());
                cv.put("moradaAluno", moradaAluno.getText().toString());
                cv.put("telefoneAluno", telefoneAluno.getText().toString());
                cv.put("emailAluno", emailAluno.getText().toString());

                sqLiteDatabase = dBAlunos.getWritableDatabase();
                Long recinsert = sqLiteDatabase.insert(TABLENAME, null, cv);
                if (recinsert != null){
                    Toast.makeText(Home.this, "Dados inserido com sucesso :)", Toast.LENGTH_SHORT).show();
                    // limpar quando click no registar
                    nomeAluno.setText("");
                    moradaAluno.setText("");
                    telefoneAluno.setText("");
                    emailAluno.setText("");
                }else{
                    Toast.makeText(Home.this, "Algo saiu errado, tente novameente :(", Toast.LENGTH_SHORT).show();
                }
            }
        });
        // Quando clicado no botão mostrar, será vizualizado os dados do aluno!

        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, MostrarDadosAlunos.class);
                startActivity(intent);
            }
        });

    }

    private void finidid() {
        nomeAluno = (EditText) findViewById(R.id.et_nomeAluno);
        moradaAluno = (EditText) findViewById(R.id.et_moradaAluno);
        telefoneAluno = (EditText) findViewById(R.id.et_telefoneAluno);
        emailAluno = (EditText) findViewById(R.id.et_emailAluno);

        submit = (Button) findViewById(R.id.submit_btn);
        display = (Button) findViewById(R.id.display_btn);
        edit = (Button) findViewById(R.id.edit_btn);
    }
}