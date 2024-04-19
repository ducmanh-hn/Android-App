package com.mystudy.linear;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.mystudy.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ListView01 extends AppCompatActivity {

    ListView listView;
    EditText subjectName;
    Button btnAdd, btnUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_view);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
//        this.getSupportActionBar().hide();

        listView = findViewById(R.id.listView);
        List<String> courses = new ArrayList<String>();
        courses.add("English");
        courses.add("Math");
        courses.add("Physical");
        courses.add("Literature");

        ArrayAdapter adapter = new ArrayAdapter(ListView01.this, android.R.layout.simple_list_item_1, courses);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            subjectName.setText(courses.get(position));
            btnUpdate.setOnClickListener(v -> {
                String subject = subjectName.getText().toString();
                courses.set(position, subject);
                adapter.notifyDataSetChanged();
                subjectName.setText("");
            });
        });

        subjectName = findViewById(R.id.subjectName);
        btnAdd = findViewById(R.id.btnAdd);
        btnUpdate = findViewById(R.id.btnUpdate);

        btnAdd.setOnClickListener(v -> {
            String subject = subjectName.getText().toString();
            if(subject.length() != 0){
                courses.add(subject);
                adapter.notifyDataSetChanged();
                subjectName.setText("");
            }else {
                Toast.makeText(this, "Enter subject name", Toast.LENGTH_SHORT).show();
            }
        });


    }
}