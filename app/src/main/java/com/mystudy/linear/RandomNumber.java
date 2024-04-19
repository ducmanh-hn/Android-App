package com.mystudy.linear;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.mystudy.R;

import java.util.Random;

public class RandomNumber extends AppCompatActivity {

    TextView txt1;
    Button btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_random_number);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txt1 = findViewById(R.id.txt1);
        btn1 = findViewById(R.id.btn1);

        btn1.setOnClickListener(v -> {
            Random random = new Random();
            Integer num = random.nextInt(100);
            txt1.setText(num.toString());
        });
        txt1.setOnClickListener(v -> {
            Toast.makeText(this, "Don't touch here", Toast.LENGTH_SHORT).show();
        });
    }
}