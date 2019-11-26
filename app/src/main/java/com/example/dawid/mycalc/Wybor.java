package com.example.dawid.mycalc;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Wybor extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wybor);

        Button klasyczny = (Button) findViewById(R.id.klasyczny);
        klasyczny.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wlaczklasyczny();

            }
        });

        Button naukowy = (Button) findViewById(R.id.naukowy);
        naukowy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wlacznaukowy();

            }
        });

        Button Help = (Button) findViewById(R.id.Help);
        Help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wlaczHelp();

            }
        });

        Button Exit = (Button) findViewById(R.id.Exit);
        Exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveTaskToBack(true);

            }
        });
    }
    public void wlacznaukowy()
    {
        Intent intent = new Intent(this,Naukowy.class);
        startActivity(intent);
    }
    public void wlaczklasyczny()
    {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);

    }

    public void wlaczHelp()
    {
        Intent intent = new Intent(this,Help.class);
        startActivity(intent);

    }

}
