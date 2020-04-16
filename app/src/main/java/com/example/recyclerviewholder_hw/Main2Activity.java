package com.example.recyclerviewholder_hw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    public static final String MAIN_2_ACTIVITY = "main_2_activity";

    StudentsFullInformation SFI;
    TextView fullName;
    TextView group;
    TextView grade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        SFI = new StudentsFullInformation();

        fullName = findViewById(R.id.fullName);
        group = findViewById(R.id.group);
        grade = findViewById(R.id.grade);

        if (getIntent() != null) {
            SFI = (StudentsFullInformation) getIntent().getSerializableExtra(MainActivity.TEXT_KEY);
            fullName.setText(SFI.getFullName());
            group.setText(SFI.getGroup());
            grade.setText(SFI.getGrade());
        }

        Button changeButton = findViewById(R.id.change_save_button);
        changeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getText();
                Intent intent = new Intent();
                intent.putExtra(MAIN_2_ACTIVITY, SFI);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    public void getText() {
        SFI.setFullName(fullName.getText().toString());
        SFI.setGroup(group.getText().toString());
        SFI.setGrade(grade.getText().toString());
    }
}
