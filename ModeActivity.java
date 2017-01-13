package com.rajkin3.tictactoe;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ModeActivity extends Activity {
	public Button leg;
	public Button har;
	public Button sem;
	public Button eas;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mode);
		
		leg = (Button) findViewById(R.id.leg);
		leg.setOnClickListener(new A());
		
		har = (Button) findViewById(R.id.har);
		har.setOnClickListener(new B());
		
		sem = (Button) findViewById(R.id.sem);
		sem.setOnClickListener(new C());
		
		eas = (Button) findViewById(R.id.eas);
		eas.setOnClickListener(new D());
	}
	
	
	 class A implements OnClickListener {
	        A() {
	        }

	        public void onClick(View v) {
	        	
	            Intent i = new Intent(ModeActivity.this, AndroidTicTacToeActivity.class);
	            i.putExtra("level", "9");
	            //ModeActivity.this.startActivity(i);
	            startActivity(i);
	        }
	 }
	 
	 
	 
	 
	 
	 
	 class B implements OnClickListener {
	        B() {
	        }

	        public void onClick(View v) {
	        	
	            Intent i = new Intent(ModeActivity.this, AndroidTicTacToeActivity.class);
	            i.putExtra("level", "6");
	            startActivity(i);
	        }
	 }
	 
	 
	 
	 
	 
	 
	 
	 class C implements OnClickListener {
	        C() {
	        }

	        public void onClick(View v) {
	        	
	            Intent i = new Intent(ModeActivity.this, AndroidTicTacToeActivity.class);
	            i.putExtra("level", "4");
	            //ModeActivity.this.startActivity(i);
	            startActivity(i);
	        }
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 class D implements OnClickListener {
	        D() {
	        }

	        public void onClick(View v) {
	        	
	            Intent i = new Intent(ModeActivity.this, AndroidTicTacToeActivity.class);
	            i.putExtra("level", "2");
	            //ModeActivity.this.startActivity(i);
	            startActivity(i);
	        }
	 }
	
	
	
	
	
}











