package com.mystudy.linear.ListViewFruit;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.mystudy.R;
import com.mystudy.linear.ListViewFruit.Fruit;
import com.mystudy.linear.ListViewFruit.FruitAdapter;

import java.util.ArrayList;

public class FruitListView extends AppCompatActivity {

    ListView lvFruit;
    ArrayList<Fruit> fruits;
    FruitAdapter fruitAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fruit_list_view);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        match();

        fruitAdapter = new FruitAdapter(this, R.layout.fruit_item, fruits);
        lvFruit.setAdapter(fruitAdapter);
        lvFruit.setOnItemClickListener((parent, view, position, id) -> {
            Toast.makeText(this, fruits.get(position).getName()+"-"+fruits.get(position).getDescription(), Toast.LENGTH_SHORT).show();
        });
    }

    public void match() {
        lvFruit = findViewById(R.id.lvFruit);
        fruits = new ArrayList<Fruit>();
        fruits.add(new Fruit("Orange","Orange that plant in VietNam", R.drawable.orange));
        fruits.add(new Fruit("Strawberry","Strawberry that plant in VietNam", R.drawable.strawberry));
        fruits.add(new Fruit("Blueberry","Blueberry that plant in VietNam", R.drawable.blueberry));
        fruits.add(new Fruit("Watermelon","Watermelon that plant in VietNam", R.drawable.watermelon));
        fruits.add(new Fruit("Mango","Mango that plant in VietNam", R.drawable.mango01));
        fruits.add(new Fruit("Mango","Mango that plant in VietNam", R.drawable.mango01));
        fruits.add(new Fruit("Mango","Mango that plant in VietNam", R.drawable.mango01));
        fruits.add(new Fruit("Mango","Mango that plant in VietNam", R.drawable.mango01));
        fruits.add(new Fruit("Mango","Mango that plant in VietNam", R.drawable.mango01));
    }
}