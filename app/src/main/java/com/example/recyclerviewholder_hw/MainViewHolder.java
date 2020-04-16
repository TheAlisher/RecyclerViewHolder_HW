package com.example.recyclerviewholder_hw;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MainViewHolder extends RecyclerView.ViewHolder {

    TextView textView;
    onClick onClick;
    StudentsFullInformation SFI;

    public MainViewHolder(@NonNull View itemView) {
        super(itemView);

        textView = itemView.findViewById(R.id.vh_text_view );
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClick.onClick(SFI);
            }
        });

    }

    public void onBind(StudentsFullInformation SFI) {
        textView.setText(SFI.getFullName() + " " + SFI.getGroup());
        this.SFI = SFI;
    }
}
