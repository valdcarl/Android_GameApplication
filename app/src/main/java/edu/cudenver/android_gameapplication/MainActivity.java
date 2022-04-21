
package edu.cudenver.android_gameapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // must initialize the buttons play and exit
        // each needs a setOnClickListener
        // var to prepare playBtn
        Button playBtn = findViewById(R.id.playBtn);
        // var to prepare aboutBtn
        Button aboutBtn = findViewById(R.id.aboutBtn);
        // var to prepare exitBtn
        Button exitBtn = findViewById(R.id.exitBtn);

        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // makes a call to onClickPlayBtn function below which starts the activity
                onClickPlayBtn();
            }
        });
        aboutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // makes a call to onClickAboutBtn function below which starts the activity
                // Toast.makeText(MainActivity.this, "About In Progress", Toast.LENGTH_SHORT).show();
                onClickAboutBtn();
            }
        });
        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // makes a call to onClickExitBtn function below which force quits application
                onClickExitBtn();
            }
        });
    } //end of onCreate MainActivity


    // onClick functions, with appropriate intents
    public void onClickPlayBtn() {
        // When the user clicks on the play button
        // We should go to the next activity that will display the difficulty levels
        Intent intent = new Intent(this, PlayerSelectActivity.class);
        startActivity(intent);
    }

    //
    public void onClickAboutBtn() {
        Intent intent = new Intent(this, AboutActivity.class);
        startActivity(intent);

    }

    public void onClickExitBtn() {
        // When the user clicks on the exit button
        // We should close the application completely
        finish();
        System.exit(0);
    }
}

/*
    Notes:
        do not need onClickListeners if desired, but good practice to know how to do
 */
