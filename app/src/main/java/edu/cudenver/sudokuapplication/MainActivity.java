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

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}