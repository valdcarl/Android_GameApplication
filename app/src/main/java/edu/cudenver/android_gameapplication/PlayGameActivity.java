package edu.cudenver.android_gameapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
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
    private TextView player1TxtViewScore;       // first player score Textview
    private TextView player2TxtViewScore;       // second player score Textview
    private int player1Counter;                 // first player score counter
    private int player2Counter;                 // second player score counter
    private int untilEndGameCounter;            // 9 total moves allowed
    private Button restartBtn;                  // button to restart the game
    private Button goHomeFromGameBtn;           // button to completely exit the game
    private Button [] buttons = new Button[9];  // array of buttons (GameBoard)

    int [] gameState = {2, 2, 2,
                        2, 2, 2,
                        2, 2, 2};
    // initially a game is in a state of all-empty tiles
    // gameState will be updated as players progress their progress
    /*
        Game States to keep track of what buttons pertain to which players, and no players
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
        player1Counter = 0;
        player2Counter = 0;
        untilEndGameCounter = 0;    // no moves are made when games starts so game counter = 0
        playerActiveTurn = true;    // toggle turn true = player1, false = player2

        // for restarting the game for a clean-state (Button)
        restartBtn = findViewById(R.id.restartBtn);
        // to go to the home screen from the game (Button)
        goHomeFromGameBtn = findViewById(R.id.goHomeFromGameBtn);

        // to initialize all of our buttons
        for(int i = 0; i < buttons.length; i++) {
            // all buttons are +@+id/btn[i] , where we can iterate through each button easier
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
        /*
            An action is to occur per button clicked throughout the duration of the game
            The actions include an onClick event to make a button an X, O, not allow movement,
            switch between player turns, etc.
         */

        // every button is it's own view
        // Toast.makeText(this, "Test Button", Toast.LENGTH_SHORT).show();
        // must constantly check availability of the button
        if(!((Button)view).getText().toString().equals("")) {
            return;
            // it's an empty button, so a player is allowed to play here
        } // otherwise
        // retrieve a button's id
        String buttonID = view.getResources().getResourceEntryName(view.getId());
        // need to trim the id string though so that we only retrieve the specific value
        // this allows us to get the index for our game state, -1 allows us to get that last value
        int gameStatePointer = Integer.parseInt(
                buttonID.substring(buttonID.length()-1, buttonID.length()));

        if(playerActiveTurn) {
            // if it's player 1, change the text to an 'X' and set color of X
            ((Button)view).setText("X");
            ((Button)view).setTextColor(Color.parseColor("#95120A"));
            // update game state as well
            gameState[gameStatePointer] = 0;
        } else {
            // otherwise, it's player2, change the text to an 'O' and set color of O
            ((Button)view).setText("O");
            ((Button)view).setTextColor(Color.parseColor("#0047AB"));
            // update game state as well
            gameState[gameStatePointer] = 1;
        }
        untilEndGameCounter++;

        if(checkWinnerOfGame()) {
            if(playerActiveTurn) {
                // need to get the score for player1, then update that score +1
//                 String player1StringScore = player1TxtViewScore.getText().toString();
//                 int player1Score = Integer.parseInt(player1StringScore);
//                 // increment p1's previous score by +1
//                 player1Score++;
//                 // set player1's score TextView to the updated score
//                 player1TxtViewScore.setText(player1Score);
                 // announce winner using a toast, CAN ALSO CALL ANOTHER ACTIVITY HERE OR A FRAGMENT
                player1Counter++;
                updateScores();
                // need to getText from the textView and convert it to String for the toast to work
                // properly, otherwise it returns a toast with the object textview
                String firstPlayerName = firstPlayer.getText().toString();
                Toast.makeText(this, firstPlayerName + " WINS!", Toast.LENGTH_SHORT). show();
                 rematch();
            } else {
//                String player2StringScore = player2TxtViewScore.getText().toString();
//                int player2Score = Integer.parseInt(player2StringScore);
//                // increment p1's previous score by +1
//                player2Score++;
//                // set player1's score TextView to the updated score
//                player1TxtViewScore.setText(player2Score);
                // announce winner using a toast, CAN ALSO CALL ANOTHER ACTIVITY HERE OR A FRAGMENT
                player2Counter++;
                updateScores();
                // need to getText from the textView and convert it to String for the toast to work
                // properly, otherwise it returns a toast with the object textview
                String secondPlayerName = secondPlayer.getText().toString();
                Toast.makeText(this, secondPlayerName + " WINS!", Toast.LENGTH_SHORT). show();
                rematch();
            }
        } else if(untilEndGameCounter == 9){
            // no one won the game, simply rematch!
            Toast.makeText(this, "TIE GAME! GO AGAIN!", Toast.LENGTH_SHORT). show();
            rematch();
        } else {
            // toggle turns between the players
            playerActiveTurn = !playerActiveTurn;
        }

        // restart Button
        restartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player1Counter=0;
                player2Counter=0;
                updateScores();
                rematch();
                Toast.makeText(PlayGameActivity.this, "GAME RESTARTED", Toast.LENGTH_SHORT). show();
            }
        });
        // go home Button (from game)
        goHomeFromGameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // head to main activity, resets everything also, since no saving state
                goHomeFromGameBtnFunction();
            }
        });

    } // onClick for buttons
    public boolean checkWinnerOfGame() {
        /*
            Check against all the possibleWinningCombinations to determine if a player has won
            the game or not.
         */
        boolean winner = false;
        // iterate through all winning positions and their indices
        for(int [] winningCombo : possibleWinningCombinations) {
            // checking each index of each position matching a certain players gameState assigned
            // value, if that value is 2 however, we know that they are empty tiles
            // empty tiles are un-played tiles meaning should not win on this condition, (!= 2)
            if (gameState[winningCombo[0]] == gameState[winningCombo[1]] &&
                    gameState[winningCombo[1]] == gameState[winningCombo[2]] &&
                    gameState[winningCombo[0]] != 2) {
                winner = true;
            }
        }
        return winner;
    } // end checkWinnerOfGame function

    public void updateScores() {
        player1TxtViewScore.setText(Integer.toString(player1Counter));
        player2TxtViewScore.setText(Integer.toString(player2Counter));
    }

    public void rematch() {
        /*
            After a match is completed, the game should repeat with a clean gameState, updated
            counters with a clean board of no X's or O's
            Every game is player1's turn first

            Can also be-used for the restart Button to wipe board clean from all scores as well
         */
        untilEndGameCounter = 0;
        playerActiveTurn = true;
        for (int i = 0; i < buttons.length; i++) {
            gameState[i] = 2;
            buttons[i].setText("");
        }
    } // end rematch function

    public void goHomeFromGameBtnFunction() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
} // end PlayGameActivity