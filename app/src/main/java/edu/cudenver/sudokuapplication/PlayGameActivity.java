package edu.cudenver.sudokuapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.widget.Button;
import android.widget.Chronometer;

public class PlayGameActivity extends AppCompatActivity {

//    private class Cell {
//        int value;              // each cell has a value
//        boolean fixed;          // some cells cannot be changed by the user
//        Button bt;
//
//        public Cell(int initialValue, Context THIS) {
//            if(initialValue == 0) {
//                boolean
//            }
//        }
//    }
    private Chronometer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_game);

        // for the chronometer to count
        // pausing/saving time is for future updates exceeding project limitations
        timer = findViewById(R.id.timeElapsed);
        timer.setBase(SystemClock.elapsedRealtime());
        timer.start();
        // every entry into a game starts at 00:00


    } // end of onCreate PlayGameActivity
}