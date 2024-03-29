package value.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Data extends Activity implements OnClickListener{
	Button start, startFor;
	EditText sendET;
	TextView getAnswer;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.get);
		initialize();
	}
	private void initialize(){
		start = (Button) findViewById(R.id.bSA);
		startFor = (Button) findViewById(R.id.bSAFR);
		sendET = (EditText) findViewById(R.id.etSend);
		getAnswer = (TextView) findViewById(R.id.tvGot);
		start.setOnClickListener(this);
		startFor.setOnClickListener(this);
		
		
	}
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getId()){
		case R.id.bSA:
			String bread = sendET.getText().toString();
			Bundle basket = new Bundle();
			basket.putString("key", bread);
			Intent a = new Intent(Data.this,OpenClass.class);
			a.putExtras(basket);
			startActivity(a);
			break;
		case R.id.bSAFR:
			Intent i = new Intent(Data.this,OpenClass.class);
			startActivityForResult(i, 0);
			break;
		}
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if(resultCode == RESULT_OK){
		Bundle basket = data.getExtras();
		String s = basket.getString(("answer"));
		getAnswer.setText(s);
	}
	}
}
