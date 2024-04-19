package com.mystudy.linear.GridView;

import static android.graphics.ColorSpace.match;

import android.os.Bundle;
import android.widget.GridView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.mystudy.R;

import java.util.ArrayList;
import java.util.List;

public class GridViewAdvance extends AppCompatActivity {

    GridView gvApp;
    List<App> appList;
    AppAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_grid_view_advance);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        match();

        adapter = new AppAdapter(this,R.layout.app, appList);

        gvApp.setAdapter(adapter);
    }

    private void match() {
        gvApp = this.findViewById(R.id.gvApp);
        appList = new ArrayList<>();
        appList.add(new App("YouTube",R.drawable.youtube));
        appList.add(new App("Calendar",R.drawable.calendar));
        appList.add(new App("Calculator",R.drawable.calculator));
        appList.add(new App("Notes",R.drawable.notes));
        appList.add(new App("Facebook",R.drawable.facebook));
        appList.add(new App("Messenger",R.drawable.messenger));
        appList.add(new App("Camera",R.drawable.camera));
        appList.add(new App("Gallery",R.drawable.watermelon));
        appList.add(new App("Clock",R.drawable.watermelon));
        appList.add(new App("Setting",R.drawable.watermelon));
        appList.add(new App("Phone",R.drawable.watermelon));
        appList.add(new App("Contacts",R.drawable.watermelon));
        appList.add(new App("Store",R.drawable.watermelon));
        appList.add(new App("YouTube",R.drawable.watermelon));
        appList.add(new App("YouTube",R.drawable.watermelon));
        appList.add(new App("YouTube",R.drawable.watermelon));
    }
}