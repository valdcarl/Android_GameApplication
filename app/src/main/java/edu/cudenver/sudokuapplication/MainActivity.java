/*
    Thinking of making the MainActivity, the start-up screen
        * This will fulfill an activity requirement
        * It will help direct things in the application
            - Start the Game
            - Exit the Game
            - Setting button (optional)
 */

package edu.cudenver.sudokuapplication;

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
        // var to prepare exitBtn
        Button exitBtn = findViewById(R.id.exitBtn);

        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // makes a call to onClickPlayBtn function below which starts the activity
                onClickPlayBtn();
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
        Intent intent = new Intent(this, SelectDifficultyActivity.class);
        startActivity(intent);
    }
    public void onClickExitBtn() {
        // When the user clicks on the exit button
        // We should close the application completely
        finish();
        System.exit(0);
    }
}