package com.example.a15011027_dijitalnotdefteri;

import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.List;

public class NotlarAdapter extends RecyclerView.Adapter<NotlarAdapter.MyViewHolder> {

    private List<Not> notlar;

    public class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView baslik, metin, tarih;

        public MyViewHolder(View view){
            super(view);

            baslik = (TextView) view.findViewById(R.id.baslik_mini);
            metin = (TextView) view.findViewById(R.id.metin_mini);
            tarih = (TextView) view.findViewById(R.id.tarih_mini);
        }
    }

    public NotlarAdapter(List<Not> notlar){
        this.notlar = notlar;
    }

    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.not_mini, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Not not = notlar.get(position);
        holder.baslik.setText(not.getBaslik());
        holder.metin.setText(not.getMetin());
        SimpleDateFormat objSDF = new SimpleDateFormat("dd MMM yyyy");
        holder.tarih.setText(objSDF.format(not.getTarih()));
    }

    public int getItemCount(){
        return notlar.size();
    }
}
