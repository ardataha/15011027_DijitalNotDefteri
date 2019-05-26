package com.example.a15011027_dijitalnotdefteri;

import android.content.Intent;
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
        public ConstraintLayout not_mini;

        public MyViewHolder(View view){
            super(view);

            baslik = (TextView) view.findViewById(R.id.baslik_mini);
            metin = (TextView) view.findViewById(R.id.metin_mini);
            tarih = (TextView) view.findViewById(R.id.tarih_mini);
            not_mini = (ConstraintLayout) view.findViewById(R.id.not_mini);
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
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        Not not = notlar.get(position);
        holder.baslik.setText(not.getBaslik());
        holder.metin.setText(not.getMetin());
        SimpleDateFormat objSDF = new SimpleDateFormat("dd MMM yyyy");
        holder.tarih.setText(objSDF.format(not.getTarih()));

        holder.not_mini.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), NotEdit.class);
                intent.putExtra("Not", notlar.get(position));
                v.getContext().startActivity(intent);
            }
        });
    }

    public int getItemCount(){
        return notlar.size();
    }
}
