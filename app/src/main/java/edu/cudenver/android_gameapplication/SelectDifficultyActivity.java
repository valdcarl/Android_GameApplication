package edu.cudenver.android_gameapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SelectDifficultyActivity extends AppCompatActivity {

    private int difficultySelectedByUser;       // we want to carry this into the level chosen
                                                // right now thinking using putExtra

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_difficulty);

        // must initialize the easy/medium/hard buttons to select difficulty level
        Button easyBtn = findViewById(R.id.easyBtn);    // A game given 50/81 squares
        Button medBtn = findViewById(R.id.medBtn);      // A game given 40/81 squares
        Button hardBtn = findViewById(R.id.hardBtn);    // A game given 30/81 squares

        // Tried using a switch-case, but Dr.L warned about warnings, so just went with this way
        easyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // makes a call to the game, but loads in an easy difficulty activity
                difficultySelectedByUser = 1;
                //testClickWorks();
                onClickDifficultySelected();
            }
        });
        medBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                difficultySelectedByUser = 2;
                onClickDifficultySelected();
            }
        });
        hardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                difficultySelectedByUser = 3;
                onClickDifficultySelected();
            }
        });

    } // end of onCreate SelectedDifficultyActivity

    // onClick function with appropriate intent and designated difficulty selected
    public void onClickDifficultySelected() {
        Intent intent = new Intent(SelectDifficultyActivity.this, PlayGameActivity.class);
        intent.putExtra("DIFFICULTY", difficultySelectedByUser);
        SelectDifficultyActivity.this.startActivity(intent);
        //startActivity(intent);
    }
    public void testClickWorks() {
        // unit testing on if button is clicked (WORKS)
        Toast.makeText(
                SelectDifficultyActivity.this,
                "Button clicked",
                Toast.LENGTH_SHORT).show();
    }
}