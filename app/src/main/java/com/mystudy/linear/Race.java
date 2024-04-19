package com.mystudy.linear;

import static android.graphics.ColorSpace.match;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.mystudy.R;

import java.util.Random;

public class Race extends AppCompatActivity {
    RadioGroup radioGroup;
    RadioButton player1, player2, player3;
    SeekBar race1, race2, race3;
    ImageButton btnStart;
    View main;
    int winner;
    CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        this.getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_race);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        match();
        race1.setEnabled(false);
        race2.setEnabled(false);
        race3.setEnabled(false);

        int choice = choosePlayer();
        btnStart.setOnClickListener(v -> {
            btnStart.setMaxHeight(0);
            btnStart.setMaxWidth(0);
            btnStart.setVisibility(View.GONE);
            run();
            countDownTimer.start();
            main.setOnClickListener(v1 -> {
                init();
            });
        });
    }

    public void match() {
        radioGroup = findViewById(R.id.radioGroup);
        player1 = findViewById(R.id.player1);
        player2 = findViewById(R.id.player2);
        player3 = findViewById(R.id.player3);
        race1 = findViewById(R.id.race1);
        race2 = findViewById(R.id.race2);
        race3 = findViewById(R.id.race3);
        btnStart = findViewById(R.id.btnStart);
        main = findViewById(R.id.main);
    }
    public int choosePlayer(){
        if(player1.isChecked())
            return player1.getId();
        if(player2.isChecked())
            return player2.getId();
        if(player3.isChecked())
            return player3.getId();
        return 0;
    }
    public void run(){
        countDownTimer = new CountDownTimer(5000,100) {
            Random random = new Random();
            @Override

            public void onTick(long millisUntilFinished) {
                int step1 = random.nextInt(5)+1;
                int step2 = random.nextInt(5)+1;
                int step3 = random.nextInt(5)+1;
                int current1 = race1.getProgress();
                int current2 = race2.getProgress();
                int current3 = race3.getProgress();
                race1.setProgress(current1+step1);
                race2.setProgress(current2+step2);
                race3.setProgress(current3+step3);
                if(isFinish(race1) !=-1 || isFinish(race2)!=-1 || isFinish(race3)!=-1){
                    Log.d("runid", winner+"");
                    if(winner == race1.getId()){
                        Toast.makeText(Race.this, "Player 1 win", Toast.LENGTH_LONG).show();
                    }
                    if(winner == race2.getId()){
                        Toast.makeText(Race.this, "Player 2 win", Toast.LENGTH_LONG).show();
                    }
                    if(winner == race3.getId()){
                        Toast.makeText(Race.this, "Player 3 win", Toast.LENGTH_LONG).show();
                    }
                    return;
                }

            }

            @Override
            public void onFinish() {
            }
        };
    }
    public void init(){
        race1.setProgress(0);
        race2.setProgress(0);
        race3.setProgress(0);
        btnStart.setVisibility(View.VISIBLE);
        countDownTimer.cancel();
    }
    public int isFinish(SeekBar race){
        if(race.getProgress()>=race.getMax()){
            winner = race.getId();
            countDownTimer.cancel();
            return race.getId();
        }
        return -1;
    }
}