package com.example.android.amaliaintansafura_1202150248_modul5;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Amalia Intan Safura on 3/25/2018.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.holder> {
    int warna;
    private Context mcontex;
    private List<TambahData> list;


    //konstruktor
    public Adapter(Context cntx, List<TambahData> list, int color){
        this.mcontex=cntx;
        this.list=list;
        this.warna=color;
    }

    //menentukan viewholder untuk recyclerview
    @Override
    public holder onCreateViewHolder(ViewGroup parent, int viewType) {
        //membuat view baru
        View view = LayoutInflater.from(mcontex).inflate(R.layout.cardview, parent, false);
        holder hldr = new holder(view);
        return hldr;
    }

    //mengatur nilai yang didapatkan pada viewholder
    @Override
    public void onBindViewHolder(holder holder, int position) {
        TambahData data = list.get(position);
        holder.ToDo.setText(data.getTodo());
        holder.Desc.setText(data.getDesc());
        holder.Priority.setText(data.getPrior());
        holder.card_view.setCardBackgroundColor(mcontex.getResources().getColor(this.warna));
    }

    //get jumlah listnya
    @Override
    public int getItemCount() {
        return list.size();
    }

    //get list dari adapter
    public TambahData getData(int position){
        return list.get(position);
    }

    //menghapus list pada todolist
    public void deleteData(int i){
        //hapus item yang dipilih
        list.remove(i);
        //memberi pemberitahuan item yang dihapus
        notifyItemRemoved(i);
        notifyItemRangeChanged(i, list.size());
    }

    class holder extends RecyclerView.ViewHolder{
        //deklarasi variabel yang akan digunakan
        public TextView ToDo, Desc, Priority;
        public CardView card_view;
        public holder(View itemView){
            super(itemView);

            //get id text view dan cardview pada layout
            ToDo = itemView.findViewById(R.id.todo);
            Desc = itemView.findViewById(R.id.description);
            Priority = itemView.findViewById(R.id.number);
            card_view = itemView.findViewById(R.id.cardview);
        }
    }
}
