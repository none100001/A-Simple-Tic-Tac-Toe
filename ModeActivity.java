
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ModeActivity extends Activity {
	public Button legendary;
	public Button hard;
	public Button semipro;
	public Button easy;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mode);
		
		legendary = (Button) findViewById(R.id.leg);
		legendary.setOnClickListener(new A());
		
		hard = (Button) findViewById(R.id.har);
		hard.setOnClickListener(new B());
		
		semipro = (Button) findViewById(R.id.sem);
		semipro.setOnClickListener(new C());
		
		easy = (Button) findViewById(R.id.eas);
		easy.setOnClickListener(new D());
	}
	
	 class A implements OnClickListener {
	        A() { }
	        public void onClick(View v) {	
	            Intent i = new Intent(ModeActivity.this, AndroidTicTacToeActivity.class);
	            i.putExtra("level", "9");
	            startActivity(i);
	        }
	 }
	 
	 class B implements OnClickListener {
	        B() { }
	        public void onClick(View v) {
	            Intent i = new Intent(ModeActivity.this, AndroidTicTacToeActivity.class);
	            i.putExtra("level", "6");
	            startActivity(i);
	        }
	 }
	 
	 class C implements OnClickListener {
	        C() { }
	        public void onClick(View v) {
	            Intent i = new Intent(ModeActivity.this, AndroidTicTacToeActivity.class);
	            i.putExtra("level", "4");
	            startActivity(i);
	        }
	 }
	 
	 class D implements OnClickListener {
	        D() { }
	        public void onClick(View v) {
	            Intent i = new Intent(ModeActivity.this, AndroidTicTacToeActivity.class);
	            i.putExtra("level", "2");
	            startActivity(i);
	        }
	 }
}
