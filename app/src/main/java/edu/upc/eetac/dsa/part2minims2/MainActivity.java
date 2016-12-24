package edu.upc.eetac.dsa.part2minims2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    String username = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_main);

        Button buto1 = (Button) findViewById(R.id.buto1);
        username = getIntent().getExtras().getString("Name");
        buto1.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent1 = new Intent(MainActivity.this, LogIn.class);
                startActivity(intent1);
            }
        });
        Button buto2 = (Button) findViewById(R.id.buto2);

        buto2.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent1 = new Intent(MainActivity.this, EtakemonUsuari.class);
                intent1.putExtra("Name", username);
                startActivity(intent1);
            }
        });
    }


}
