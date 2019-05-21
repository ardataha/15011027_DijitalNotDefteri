package com.example.a15011027_dijitalnotdefteri;

import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class NotlarAdapter extends RecyclerView.Adapter<NotlarAdapter.MyViewHolder> {

    private List<Not> notlar;

    public class MyViewHolder extends RecyclerView.ViewHolder{

        public ConstraintLayout not_mini;

        public MyViewHolder(View view){
            super(view);
            not_mini = (ConstraintLayout)view.findViewById(R.id.not_mini);
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

        holder.not_mini.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Hello World!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public int getItemCount(){
        return notlar.size();
    }
}
