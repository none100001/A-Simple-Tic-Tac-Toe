package com.rajkin3.tictactoe;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class AndroidTicTacToeActivity extends Activity {
    private TextView information;
    private Button[] mBoardButtons;
    public TicTacToe mGame;
    public Button button,buttonback;
    public int lev;
    
    
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        String level = getIntent().getStringExtra("level");
        lev = Integer.valueOf(level);
        
        mBoardButtons = new Button[9];
        mBoardButtons[0] = (Button) findViewById(R.id.one);
        mBoardButtons[1] = (Button) findViewById(R.id.two);
        mBoardButtons[2] = (Button) findViewById(R.id.three);
        mBoardButtons[3] = (Button) findViewById(R.id.four);
        mBoardButtons[4] = (Button) findViewById(R.id.five);
        mBoardButtons[5] = (Button) findViewById(R.id.six);
        mBoardButtons[6] = (Button) findViewById(R.id.seven);
        mBoardButtons[7] = (Button) findViewById(R.id.eight);
        mBoardButtons[8] = (Button) findViewById(R.id.nine);
        
        button = (Button) findViewById(R.id.clear);
        buttonback = (Button) findViewById(R.id.back);
        
        button.setOnClickListener(new A());
        buttonback.setOnClickListener(new B());

        information = (TextView) findViewById(R.id.information);
        mGame = new TicTacToe();
        
        mGame.LEVEL = lev;
        startNewGame();
    }
    
    
    class A implements OnClickListener {
        A() {
        }

        public void onClick(View v) {
        	
        	startNewGame();
        }
    }
    
    
    class B implements OnClickListener {
        B() {
        }

        public void onClick(View v) {
        	
        	Intent i = new Intent(AndroidTicTacToeActivity.this, ModeActivity.class);
        	startActivity(i);
        }
    }
    
   
    
    
    


    class ButtonClickListener implements OnClickListener {
        int location;

        public ButtonClickListener(int location) {
            this.location = location;
        }

        public void onClick(View view) {
        	
            if (mBoardButtons[location].isEnabled()) {
                setMove(TicTacToe.HUMAN_PLAYER, location);
                int winner = mGame.checkForWinner();
                if (winner == 11) {
                    information.setText("Computer Goes");
                    setMove(TicTacToe.COMPUTER_PLAYER, mGame.getComputerMove());
                    winner = mGame.checkForWinner();
                }
                if (winner == 11) {
                    information.setText("Human Goes");
                } else if (winner == 1111) {
                    information.setText("Its a tie");
                } else if (winner == 0) {
                    information.setText("Human Wins");
                    makedisable();
                } else if (winner == 1) {
                    information.setText("Computer Wins");
                    makedisable();
                }
            }
        }
    }


    public void makedisable() {
        for (Button enabled : mBoardButtons) {
            enabled.setEnabled(false);
        }
    }

    private void startNewGame() {
        mGame.clearBoard();
        information.setText("Human Goes");
        for (int i = 0; i < mBoardButtons.length; i++) {
            mBoardButtons[i].setText("");
            mBoardButtons[i].setEnabled(true);
            mBoardButtons[i].setOnClickListener(new ButtonClickListener(i));
        }
    }

    void setMove(char player, int location) {
        mGame.setMove(player, location);
        mBoardButtons[location].setEnabled(false);
        mBoardButtons[location].setText(String.valueOf(player));
        if (player == TicTacToe.HUMAN_PLAYER) {
            mBoardButtons[location].setTextColor(Color.rgb(0, 200, 0));
        } else {
            mBoardButtons[location].setTextColor(Color.rgb(200, 0, 0));
        }
    }
}
