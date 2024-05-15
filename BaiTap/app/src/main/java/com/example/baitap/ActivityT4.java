package com.example.baitap;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;

import com.android.volley.toolbox.StringRequest;


public class ActivityT4 extends AppCompatActivity {

    Button btnRead;
    TextView txtRead;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_t4);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnRead = this.findViewById(R.id.btnRead);
        txtRead = this.findViewById(R.id.txtRead);

        txtRead.setMovementMethod(new ScrollingMovementMethod());

        String url = "https://hungnttg.github.io/array_json_new.json";
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest request = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
//                        txtResponse[0] =s;
                        txtRead.setText(s);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
//                        txtResponse[0] =volleyError.getMessage();
                    }
                });
        requestQueue.add(request);
//        btnRead.setOnClickListener(v->{
//            txtRead.setText(txtResponse[0]);
//        });
    }
}