package com.example.recyclerviewholder_hw;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements onClick {

    static String TEXT_KEY = "text_key";
    public static final int REQUEST_CODE = 16;

    MainAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        adapter = new MainAdapter();
        recyclerView.setAdapter(adapter);

        adapter.onClick = this;

    }

    @Override
    public void onClick(StudentsFullInformation SFI) {
        Intent intent = new Intent(this, Main2Activity.class);
        intent.putExtra(TEXT_KEY, SFI);
        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        StudentsFullInformation SFI = (StudentsFullInformation) data.getSerializableExtra(Main2Activity.MAIN_2_ACTIVITY);
        adapter.update(SFI);
        adapter.notifyDataSetChanged();
    }
}
