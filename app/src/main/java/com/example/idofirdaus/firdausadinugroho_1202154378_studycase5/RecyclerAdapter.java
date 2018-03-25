package com.example.idofirdaus.firdausadinugroho_1202154378_studycase5;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.idofirdaus.firdausadinugroho_1202154378_studycase5.Model.Activity;
import com.example.idofirdaus.firdausadinugroho_1202154378_studycase5.UI.MainActivity;

import java.util.ArrayList;

import java.util.LinkedList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private List<com.example.idofirdaus.firdausadinugroho_1202154378_studycase5.Model.Activity> mActivityList;
    private LayoutInflater inflater;

    //    //Membuat Konstruktor pada Class RecyclerViewAdapter
    public RecyclerAdapter(Context context, LinkedList<com.example.idofirdaus.firdausadinugroho_1202154378_studycase5.Model.Activity> mActivityList){
        inflater = LayoutInflater.from(context);
        this.mActivityList = mActivityList;
    }

    //ViewHolder Digunakan Untuk Menyimpan Referensi Dari View-View
    class ViewHolder extends RecyclerView.ViewHolder {
        public TextView activity, desc, priority;
        final RecyclerAdapter mAdapter;

        public ViewHolder(View itemView, RecyclerAdapter adapter) {
            super(itemView);
            //Menginisialisasi View-View untuk kita gunakan pada RecyclerView
            activity = itemView.findViewById(R.id.todo);
            desc = itemView.findViewById(R.id.desc);
            priority = itemView.findViewById(R.id.priority);
            this.mAdapter = adapter;
        }
    }

    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Membuat View untuk Menyiapkan dan Memasang Layout yang Akan digunakan pada RecyclerView
        View mItemView = inflater.inflate(R.layout.activity_info, parent, false);
        return new ViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.ViewHolder holder, int position) {

        holder.activity.setText(mActivityList.get(position).getTodo());
        holder.desc.setText(mActivityList.get(position).getDescription());
        holder.priority.setText(mActivityList.get(position).getPriority());
    }

    @Override
    public int getItemCount() {
        return mActivityList.size();
    }

    public void dismissData(int data){
        com.example.idofirdaus.firdausadinugroho_1202154378_studycase5.DatabaseHandler db = new com.example.idofirdaus.firdausadinugroho_1202154378_studycase5.DatabaseHandler(inflater.getContext());
        boolean deleted = db.delete(mActivityList.get(data));
        if (deleted){
            mActivityList.remove(data);
            this.notifyItemRemoved(data);
            Toast.makeText(inflater.getContext(),"Deleted Success",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(inflater.getContext(),"Deleted Failed",Toast.LENGTH_SHORT).show();
        }
    }
}
