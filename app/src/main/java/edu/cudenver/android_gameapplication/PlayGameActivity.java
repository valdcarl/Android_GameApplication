package edu.cudenver.android_gameapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.SystemClock;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

public class PlayGameActivity extends AppCompatActivity {
    private Chronometer timer;                  // timer control for duration played in-game
    private boolean playerActiveTurn;           // switch between player turns
    private TextView firstPlayer;               // first player
    private TextView secondPlayer;              // second player
    private int player1TxtViewScore;            // first player score counter
    private int player2TxtViewScore;            // second player score counter
    private int endCounter;                     // 9 total moves
    private Button restartTheGame;              // button to restart the game
    private Button [] buttons = new Button[9];  // array of buttons (GameBoard)

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

    } // end of onCreate PlayGameActivity
}