package edu.cudenver.android_gameapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;
import android.widget.Toast;

public class PlayGameActivity extends AppCompatActivity implements View.OnClickListener {
    private Chronometer timer;                  // timer control for duration played in-game
    private boolean playerActiveTurn;           // switch between player turns
    private TextView firstPlayer;               // first player
    private TextView secondPlayer;              // second player
    private TextView player1TxtViewScore;            // first player score counter
    private TextView player2TxtViewScore;            // second player score counter
    private int untilEndGameCounter;            // 9 total moves allowed
    private Button restartTheGame;              // button to restart the game
    private Button [] buttons = new Button[9];  // array of buttons (GameBoard)

    int [] gameState = {2, 2, 2,
                        2, 2, 2,
                        2, 2, 2};
    // initially a game is in a state of all-empty tiles
    // gameState will be updated as players progress their progress
    /*
        Game States to keep track of what buttons pertain to which players
        player 1 tile => 0
        player 2 tile => 1
        empty tile    => 2
     */
    // need to keep track of all possible combinations that determine a winning position
    // the horizontals, the verticals, the diagonals
    int [][] possibleWinningCombinations = {
            // horizontals
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8},
            // verticals
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
            // diagonals
            {0, 4, 8}, {2, 4, 6}
    };
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

        // get the players to display while the player's play again
        firstPlayer = findViewById(R.id.firstPlayer);
        secondPlayer = findViewById(R.id.secondPlayer);

        // gave player1 the key of "PLAYER1", and player2 the key of "PLAYER2"
        String player_1 = getIntent().getStringExtra("PLAYER1");
        String player_2 = getIntent().getStringExtra("PLAYER2");
        // set the player names into the activity
        firstPlayer.setText(player_1);
        secondPlayer.setText(player_2);

        // for the score counters (TextViews)
        player1TxtViewScore = findViewById(R.id.player1TxtViewScore);
        player2TxtViewScore = findViewById(R.id.player2TxtViewScore);
        // for restarting the game for a clean-state (Button)
        restartTheGame = findViewById(R.id.restartBtn);
        // to initialize all of our buttons
        for (int i = 0; i < buttons.length; i++) {
            // all buttons are +@+id/btni , where we can iterate through each button easier
            String id = "btn" + i;
            // need too convert to R.id.theResourceName format
            int rId = getResources().getIdentifier(id, "id", getPackageName());
            // same as findViewById(R.id.theSpecificButton)
            buttons[i] = findViewById(rId);
            buttons[i].setOnClickListener(this);
        }


    } // end of onCreate PlayGameActivity

    // on click for each button
    @Override
    public void onClick(View view) {
        Toast.makeText(this, "Test Button", Toast.LENGTH_SHORT).show();
    }
}