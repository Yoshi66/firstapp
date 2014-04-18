package value.app;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class Book extends Activity implements OnCheckedChangeListener {
		TextView textOut;
		EditText getInput;
		RadioGroup Gunit;
		RadioGroup SUnit;
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.book);
		
		Gunit = (RadioGroup) findViewById(R.id.rgGravity);
		Gunit.setOnCheckedChangeListener(this);
		SUnit = (RadioGroup) findViewById(R.id.rgStyle);
		SUnit.setOnCheckedChangeListener(this);
		
		textOut = (TextView) findViewById(R.id.tvGetInput);
		getInput = (EditText) findViewById(R.id.etInput);
		Button ok = (Button) findViewById(R.id.bOk);
		ok.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				textOut.setText(getInput.getText());
				
			}
		});
		
	}


	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		// TODO Auto-generated method stub
		//BoldとNormalは効くのに他のは効かない。
		switch (checkedId){
		case R.id.rbLeft:
			textOut.setGravity(Gravity.LEFT);
			break;
		case R.id.rbCenter:
			textOut.setGravity(Gravity.CENTER);
			break;
		case R.id.rbRight:
			textOut.setGravity(Gravity.RIGHT);
			break;
		case R.id.rbNormal:
			textOut.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
			break;
		case R.id.rbBold:
			textOut.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
			break;
		case R.id.rbItalic:
			textOut.setTypeface(Typeface.defaultFromStyle(Typeface.ITALIC));
			break;
			}
	   }


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		super.onCreateOptionsMenu(menu);
		MenuInflater blowUp = getMenuInflater();
		blowUp.inflate(R.menu.mainmenu, menu);
		return true;
	}


	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch(item.getItemId()){
		case R.id.menu_education:
		{
			Intent intent = new Intent(this,Education.class);
			startActivity(intent);
			break;
		}
		case R.id.menu_book:
		{
			Intent intent =new Intent(this, Book.class);
			startActivity(intent);
			break;
		}
		case R.id.menu_popup:
		{
			Intent intent =new Intent(this, Popup.class);
			startActivity(intent);
			break;
		}case R.id.menu_sigh:
		{
			Toast display = Toast.makeText(this, "Sigh", Toast.LENGTH_SHORT);
			display.show();
			break;
		}
	}
	return false;
	
		}
		
	}
	

