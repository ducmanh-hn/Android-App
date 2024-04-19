package com.mystudy.linear;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.mystudy.R;

public class Views extends AppCompatActivity {
    Switch sWifi;
    CheckBox checkBox;
    RadioGroup radioGroup;
    Button btn1;
    RadioButton rd1, rd2, rd3;

    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_views);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        sWifi = findViewById(R.id.switch1);
        sWifi.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if(isChecked){
                Toast.makeText(this, "Turned on Wifi", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this,"Turned off Wifi", Toast.LENGTH_LONG).show();
            }
        });
        checkBox = (CheckBox) findViewById(R.id.checkBox1);
        checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if(isChecked){
                Toast.makeText(this, "Checked", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this,"Unchecked", Toast.LENGTH_LONG).show();
            }
        });
        radioGroup = findViewById(R.id.radioGroup1);
//        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//
//                Log.d("checkId", "onCheckedChanged: "+checkedId);
//                int id = group.findViewById(checkedId).getId();
//                if (id == R.id.radioButton3) {
//                    Toast.makeText(Views.this, "option 1", Toast.LENGTH_SHORT).show();
//                } else if (id == R.id.radioButton4) {
//                    Toast.makeText(Views.this, "option 2", Toast.LENGTH_SHORT).show();
//                } else if (id == R.id.radioButton5) {
//                    Toast.makeText(Views.this, "option 3", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
        btn1 = findViewById(R.id.button1);
        rd1 = findViewById(R.id.radioButton3);
        rd2 = findViewById(R.id.radioButton4);
        rd3 = findViewById(R.id.radioButton5);

        btn1.setOnClickListener(v->{
            if(rd1.isChecked())
                Toast.makeText(Views.this, rd1.getText(), Toast.LENGTH_SHORT).show();
            if(rd2.isChecked())
                Toast.makeText(Views.this, rd2.getText(), Toast.LENGTH_SHORT).show();
            if(rd3.isChecked())
                Toast.makeText(Views.this, rd3.getText(), Toast.LENGTH_SHORT).show();
        });

        progressBar = findViewById(R.id.progressBar2);
        CountDownTimer countDownTimer =new CountDownTimer(40000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                int current = progressBar.getProgress();
                progressBar.setProgress(current+10);
                if(current == progressBar.getMax()){
                    progressBar.setProgress(0);
                }
            }

            @Override
            public void onFinish() {
                Toast.makeText(Views.this, "Times up", Toast.LENGTH_SHORT).show();
            }
        };
        countDownTimer.start();
    }
}