package com.example.thestudentandroid;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ThisAppAdapter extends RecyclerView.Adapter<ThisAppAdapter.ModelViewHolder> {
    Context context;
    ArrayList<Model>modelArrayList = new ArrayList<>();
    SQLiteDatabase sqLiteDatabase;
    // Gerar constructor

    public ThisAppAdapter(Context context, int singledata, ArrayList<Model> modelArrayList, SQLiteDatabase sqLiteDatabase) {
        this.context = context;
        this.modelArrayList = modelArrayList;
        this.sqLiteDatabase = sqLiteDatabase;
    }

    @NonNull
    @Override
    public ThisAppAdapter.ModelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.singledata, null);
        return new ModelViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ThisAppAdapter.ModelViewHolder holder, int position) {
        final Model model = modelArrayList.get(position);
        holder.txtNomeAluno.setText(model.getNomeAluno());
        holder.txtMoradaAluno.setText(model.getMoradaAluno());
        holder.txtTelefoneAluno.setText(model.getTelefoneAluno());
        holder.txtEmailAluno.setText(model.getEmailAluno());
    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }

    public class ModelViewHolder extends RecyclerView.ViewHolder {
        TextView txtNomeAluno, txtMoradaAluno, txtTelefoneAluno, txtEmailAluno;
        public ModelViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNomeAluno = (TextView)itemView.findViewById(R.id.txtNomeAluno);
            txtMoradaAluno = (TextView)itemView.findViewById(R.id.txtMoradaAluno);
            txtTelefoneAluno = (TextView)itemView.findViewById(R.id.txtTelefoneAluno);
            txtEmailAluno = (TextView)itemView.findViewById(R.id.txtEmailAluno);

        }
    }
}
