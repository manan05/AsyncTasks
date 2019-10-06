package com.example.asynctasks;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
public static final String TAG = "ASYNC";
    Button btnChangeColor;
    ConstraintLayout clBackground;
    ListView lvItems;

    String[] items = new String[]{
      "Jager","Vigil","Tachanka","Bandit","Castle","Valkyrie","Rook"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnChangeColor = findViewById(R.id.btnChangeColor);
        clBackground = findViewById(R.id.clBackground);
        lvItems = findViewById(R.id.lvItems);

        ArrayAdapter<String> itemAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                items
        );

        lvItems.setAdapter(itemAdapter);

        btnChangeColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                waitNSec(10);
//                clBackground.setBackgroundColor(Color.RED);
//                Log.d(TAG, "onClick: "+System.currentTimeMillis());

                // In the output when handler is used,
                //We can use the list even after pressing the button
                Handler h = new Handler();
                // Runnable is an interface that has a function called run.
                Runnable r = new Runnable() {
                    @Override
                    public void run() {
                        Log.d(TAG, "run: We have waited 5 seconds");
                        clBackground.setBackgroundColor(Color.RED);
                    }
                };
                h.postDelayed(r,5000); // Handler is calculated on a separate thread
            }
        });
    }

    void wait1Sec(){
        long startTime = System.currentTimeMillis();
        while(System.currentTimeMillis()<startTime+1000);
    }

    void waitNSec(int n){
        for(int i = 0; i<n;i++){
            wait1Sec();
        }
    }
}
