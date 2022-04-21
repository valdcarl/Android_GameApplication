package edu.cudenver.android_gameapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PlayerSelectActivity extends AppCompatActivity {

    private EditText player1;
    private EditText player2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_select);

        // for the player1's input
        player1 = findViewById(R.id.player1InputPlainText);
        // for the player2's input
        player2 = findViewById(R.id.player2InputPlainText);

    }

    public void onClickPlayBtn_playerSelect(View view) {
        // extracting names from the player views
        String player1InputPlainText = player1.getText().toString();
        String player2InputPlainText = player2.getText().toString();

        Intent intent = new Intent(this, PlayGameActivity.class);
        // sending the names to the new activity along
        intent.putExtra("PLAYER1",player1InputPlainText);
        intent.putExtra("PLAYER2",player2InputPlainText);
        startActivity(intent);

    }
}