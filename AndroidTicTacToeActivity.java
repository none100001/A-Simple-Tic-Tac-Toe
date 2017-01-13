/*
 * Copyright (C) 2010 By Frank McCown at Harding University
 * 
 * This is the solution to Tutorial 3.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package edu.harding.tictactoe;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class AndroidTicTacToeActivity extends Activity {
	
	static final int DIALOG_DIFFICULTY_ID = 0;
	static final int DIALOG_QUIT_ID = 1;
	static final int DIALOG_ABOUT = 2;
	
	// Indicates if game is currently over or not
	private boolean mGameOver = false;
	
	// Buttons making up the board
	private Button mBoardButtons[];
		
	// Whose turn to go first
	private char mTurn = TicTacToeGame.COMPUTER_PLAYER;    
	
	private int mHumanWins = 0;
	private int mComputerWins = 0;
	private int mTies = 0;
	
	// Represents the internal state of the game
	private TicTacToeGame mGame;
	
	private TextView mInfoTextView; 
	private TextView mHumanScoreTextView;
	private TextView mComputerScoreTextView;
	private TextView mTieScoreTextView;
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
                
        mBoardButtons = new Button[TicTacToeGame.BOARD_SIZE];
        mBoardButtons[0] = (Button) findViewById(R.id.one);
        mBoardButtons[1] = (Button) findViewById(R.id.two); 
        mBoardButtons[2] = (Button) findViewById(R.id.three); 
        mBoardButtons[3] = (Button) findViewById(R.id.four); 
        mBoardButtons[4] = (Button) findViewById(R.id.five); 
        mBoardButtons[5] = (Button) findViewById(R.id.six);
        
        
        mBoardButtons[6] = (Button) findViewById(R.id.seven); 
        mBoardButtons[7] = (Button) findViewById(R.id.eight); 
        mBoardButtons[8] = (Button) findViewById(R.id.nine);
        mBoardButtons[9] = (Button) findViewById(R.id.ten); 
        mBoardButtons[10] = (Button) findViewById(R.id.eleven); 
        mBoardButtons[11] = (Button) findViewById(R.id.twelve);
        
        
        
        
        
        
        
        mBoardButtons[12] = (Button) findViewById(R.id.thirteen); 
        mBoardButtons[13] = (Button) findViewById(R.id.fourteen); 
        mBoardButtons[14] = (Button) findViewById(R.id.fifteen);
        mBoardButtons[15] = (Button) findViewById(R.id.sixteen); 
        mBoardButtons[16] = (Button) findViewById(R.id.seventeen); 
        mBoardButtons[17] = (Button) findViewById(R.id.eighteen);
        
        
        
        
        mBoardButtons[18] = (Button) findViewById(R.id.nineteen); 
        mBoardButtons[19] = (Button) findViewById(R.id.twenty); 
        mBoardButtons[20] = (Button) findViewById(R.id.twentyone);
        mBoardButtons[21] = (Button) findViewById(R.id.twentytwo); 
        mBoardButtons[22] = (Button) findViewById(R.id.twentythree); 
        mBoardButtons[23] = (Button) findViewById(R.id.twentyfour);
        
        
        
        mBoardButtons[24] = (Button) findViewById(R.id.twentyfive); 
        mBoardButtons[25] = (Button) findViewById(R.id.twentysix); 
        mBoardButtons[26] = (Button) findViewById(R.id.twentyseven);
        mBoardButtons[27] = (Button) findViewById(R.id.twentyeight); 
        mBoardButtons[28] = (Button) findViewById(R.id.twentynine); 
        mBoardButtons[29] = (Button) findViewById(R.id.thirty);
        
        
        
        
        
        mBoardButtons[30] = (Button) findViewById(R.id.thirtyone); 
        mBoardButtons[31] = (Button) findViewById(R.id.thirtytwo); 
        mBoardButtons[32] = (Button) findViewById(R.id.thirtythree);
        mBoardButtons[33] = (Button) findViewById(R.id.thirtyfour); 
        mBoardButtons[34] = (Button) findViewById(R.id.thirtyfive); 
        mBoardButtons[35] = (Button) findViewById(R.id.thirtysix);
        
        
        
        
        mBoardButtons[36] = (Button) findViewById(R.id.thirtyseven); 
        mBoardButtons[37] = (Button) findViewById(R.id.thirtyeight); 
        mBoardButtons[38] = (Button) findViewById(R.id.thirtynine);
        mBoardButtons[39] = (Button) findViewById(R.id.fourty); 
        mBoardButtons[40] = (Button) findViewById(R.id.fourtyone); 
        mBoardButtons[41] = (Button) findViewById(R.id.fourtytwo);
        
        
        
        
        
        mBoardButtons[42] = (Button) findViewById(R.id.fourtythree); 
        mBoardButtons[43] = (Button) findViewById(R.id.fourtyfour); 
        mBoardButtons[44] = (Button) findViewById(R.id.fourtyfive);
        mBoardButtons[45] = (Button) findViewById(R.id.fourtysix); 
        mBoardButtons[46] = (Button) findViewById(R.id.fourtyseven); 
        mBoardButtons[47] = (Button) findViewById(R.id.fourtyeight);
        
        
        
        
        
        
        mInfoTextView = (TextView) findViewById(R.id.information); 
        mHumanScoreTextView = (TextView) findViewById(R.id.player_score);
        mComputerScoreTextView = (TextView) findViewById(R.id.computer_score);
        mTieScoreTextView = (TextView) findViewById(R.id.tie_score);
               
        mGame = new TicTacToeGame();
        
        startNewGame();
    }
    
    @Override 
    public boolean onCreateOptionsMenu(Menu menu) { 
         super.onCreateOptionsMenu(menu); 
         	    
         MenuInflater inflater = getMenuInflater();
         inflater.inflate(R.menu.options_menu, menu);
         return true;
    } 
    
    @Override
    protected Dialog onCreateDialog(int id) {
    	Dialog dialog = null;
    	AlertDialog.Builder builder = new AlertDialog.Builder(this);
    	
        switch(id) {
        case DIALOG_DIFFICULTY_ID:
            // Create the Difficulty dialog
        	        	
        	final CharSequence[] levels = {
        			getResources().getString(R.string.difficulty_easy),
        			getResources().getString(R.string.difficulty_harder), 
        			getResources().getString(R.string.difficulty_expert)};

        	builder.setTitle(R.string.difficulty_choose);
        	
        	// Determine which radio button should be selected
        	int selected = -1;
        	if (mGame.getDifficultyLevel() == TicTacToeGame.DifficultyLevel.Easy)
        		selected = 0;
        	else if (mGame.getDifficultyLevel() == TicTacToeGame.DifficultyLevel.Harder)
        		selected = 1;
        	else if (mGame.getDifficultyLevel() == TicTacToeGame.DifficultyLevel.Expert)
        		selected = 2;
        	
        	// Set the difficulty level to whatever selection was made
        	builder.setSingleChoiceItems(levels, selected, new DialogInterface.OnClickListener() {
        	    public void onClick(DialogInterface dialog, int item) {
        	    	dialog.dismiss();   // Close dialog
        	    	
        	    	switch (item) {
        	    	case 0:
        	    		mGame.setDifficultyLevel(TicTacToeGame.DifficultyLevel.Easy);
        	    		break;
        	    	case 1:
        	    		mGame.setDifficultyLevel(TicTacToeGame.DifficultyLevel.Harder);
        	    		break;
        	    	case 2:
        	    		mGame.setDifficultyLevel(TicTacToeGame.DifficultyLevel.Expert);
        	    		break;
        	    	}        	    	
        	    	
        	    	// Display the selected difficulty level
        	    	Toast.makeText(getApplicationContext(), levels[item], Toast.LENGTH_SHORT).show();
        	    }
        	});
        	dialog = builder.create();
       	
            break;
        case DIALOG_QUIT_ID:
            // Create the quit confirmation dialog
        	
        	builder.setMessage(R.string.quit_question)
        	       .setCancelable(false)
        	       .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
        	           public void onClick(DialogInterface dialog, int id) {
        	        	   AndroidTicTacToeActivity.this.finish();
        	           }
        	       })
        	       .setNegativeButton(R.string.no, null);
        	dialog = builder.create();
        	
            break;
        case DIALOG_ABOUT:
        	// Show an about dialog box
        	
        	Context context = getApplicationContext();
        	LayoutInflater inflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
        	View layout = inflater.inflate(R.layout.about_dialog, null); 		

			builder.setView(layout);
			builder.setPositiveButton("OK", null);	
			dialog = builder.create();   
        	break;
        }
        
        return dialog;        
    }
    
    @Override
    protected void onPrepareDialog(int id, Dialog dialog) {
    	super.onPrepareDialog(id, dialog);
    	
    	
    }
    
    // Handles menu item selections 
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case R.id.new_game:
        	startNewGame();
            return true;
        case R.id.ai_difficulty: 
        	showDialog(DIALOG_DIFFICULTY_ID);        	
        	return true;
        case R.id.about:
        	showDialog(DIALOG_ABOUT);
        	return true;
        case R.id.quit:
        	showDialog(DIALOG_QUIT_ID);
            return true;
        }
        return false;
    }   
    
    
 // Set up the game board. 
    private void startNewGame() {   	
    	
    	mGame.clearBoard();
    	
    	// Reset all buttons
    	for (int i = 0; i < mBoardButtons.length; i++) {
    		mBoardButtons[i].setText("");
    		mBoardButtons[i].setEnabled(true); 
    		mBoardButtons[i].setOnClickListener(new ButtonClickListener(i));    		   		   
    	}

    	// Alternate who goes first
    	if (mTurn == TicTacToeGame.HUMAN_PLAYER) {
    		mTurn = TicTacToeGame.COMPUTER_PLAYER;
    		mInfoTextView.setText(R.string.first_computer);
    		int move = mGame.getComputerMove();
    		setMove(TicTacToeGame.COMPUTER_PLAYER, move);
    		mInfoTextView.setText(R.string.turn_human);
    	}
    	else {
    		mTurn = TicTacToeGame.HUMAN_PLAYER;
    		mInfoTextView.setText(R.string.first_human); 
    	}	
    	
    	mGameOver = false;
    } 
    
    void setMove(char player, int location) {
    	
    	mGame.setMove(player, location);
    	mBoardButtons[location].setEnabled(false); 
    	mBoardButtons[location].setText(String.valueOf(player));
    	if (player == TicTacToeGame.HUMAN_PLAYER) 
    		mBoardButtons[location].setTextColor(Color.rgb(0, 200, 0));      
    	else 
        	mBoardButtons[location].setTextColor(Color.rgb(200, 0, 0));
    }
    
    class ButtonClickListener implements View.OnClickListener { 
        int location; 

        public ButtonClickListener(int location) { 
             this.location = location; 
        } 

        public void onClick(View view) { 
        	if (!mGameOver && mBoardButtons[location].isEnabled()) {
        		setMove(TicTacToeGame.HUMAN_PLAYER, location);        		
            	
            	// If no winner yet, let the computer make a move
            	int winner = mGame.checkForWinner();
            	if (winner == 0) { 
            		mInfoTextView.setText(R.string.turn_computer); 
            		int move = mGame.getComputerMove();
            		setMove(TicTacToeGame.COMPUTER_PLAYER, move);
            		winner = mGame.checkForWinner();
            	} 
            	
            	if (winner == 0)
            		mInfoTextView.setText(R.string.turn_human);
            	else {        
            		// Game is over
	            	if (winner == 1) {
	            		mTies++;
	            		mTieScoreTextView.setText(Integer.toString(mTies));
	            		mInfoTextView.setText(R.string.result_tie); 
	            	}
	            	else if (winner == 2) {
	            		mHumanWins++;
	            		mHumanScoreTextView.setText(Integer.toString(mHumanWins));
	            		mInfoTextView.setText(R.string.result_human_wins);
	            	}
	            	else if (winner == 3) {
	            		mComputerWins++;
	            		mComputerScoreTextView.setText(Integer.toString(mComputerWins));
	            		mInfoTextView.setText(R.string.result_computer_wins);
	            	}
	            	
	            	mGameOver = true;
            	}
             } 
        } 
   }    
}