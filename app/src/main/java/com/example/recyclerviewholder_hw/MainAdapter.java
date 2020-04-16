package com.example.recyclerviewholder_hw;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainViewHolder> {

    ArrayList<StudentsFullInformation> list;
    onClick onClick;

    public MainAdapter() {
        list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            StudentsFullInformation SFI = new StudentsFullInformation();
            SFI.setFullName("Chris Heria");
            SFI.setGroup("3");
            SFI.setGrade("F");
            list.add(SFI);
            SFI.setPosition(i);
            notifyDataSetChanged();
        }
    }

    public void update(StudentsFullInformation SFI) {
        list.remove(SFI.getPosition());
        list.add(SFI.getPosition(), SFI);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.view_holder_main, parent, false);
        MainViewHolder holder = new MainViewHolder(view);
        holder.onClick = onClick;
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        holder.onClick = onClick;
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
