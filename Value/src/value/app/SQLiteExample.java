package value.app;

import value.app.R.id;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SQLiteExample extends Activity implements OnClickListener{

	Button sqlUpdate, sqlView, sqlGetInfo, sqlModify, sqlDelete;
	EditText sqlName, sqlScale, sqlRow;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sqliteexample);
		
		sqlUpdate = (Button) findViewById(R.id.bSQLUpdate);
		sqlView = (Button) findViewById(R.id.bSQLOpenView);
		//sqlGetInfo = (Button) findViewById(R.id.bGetInfo);
		//sqlModify = (Button) findViewById(R.id.bModify);
		//sqlDelete = (Button) findViewById(R.id.bDeleteEntry);
		sqlName = (EditText) findViewById(R.id.etSQLName);
		sqlScale = (EditText) findViewById(R.id.etSQLScale);
		//sqlRow = (EditText) findViewById(R.id.etSQLRow);
		sqlUpdate.setOnClickListener(this);
		sqlView.setOnClickListener(this);
		sqlGetInfo.setOnClickListener(this);
		sqlModify.setOnClickListener(this);
		sqlDelete.setOnClickListener(this);
		
		
		
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getId()){
		case R.id.bSQLUpdate:
			boolean didItWork = true;
			try{
			String name= sqlName.getText().toString();
			String scale = sqlScale.getText().toString();
			InterestingOrNot entry =new InterestingOrNot(SQLiteExample.this);
			entry.open();
			entry.createEntry(name, scale);
			entry.close();
			}
			catch(Exception e){
				didItWork = false;
				String error =e.toString();
					Dialog d = new Dialog(this);
					d.setTitle("Oh, No!!");
					TextView tv = new TextView(this);
					tv.setText(error);
					d.setContentView(tv);
					d.show();
			}finally{
				if(didItWork){
					Dialog d = new Dialog(this);
					d.setTitle("Yeah");
					TextView tv = new TextView(this);
					tv.setText("Success");
					d.setContentView(tv);
					d.show();
					
				}
			}
			break;
		case R.id.bSQLOpenView:
			Intent i = new Intent(this,SQLiteView.class);
			startActivity(i);
			break;
		/*case R.id.bGetInfo:
			try{
			String s = sqlRow.getText().toString();
			long l = Long.parseLong(s);
			InterestingOrNot hon = new InterestingOrNot(this);
			hon.open();
			String returnedName = hon.getName(l);
			String returnedInterest = hon.getScale(l);
			hon.close();
			
			sqlName.setText(returnedName);
			sqlScale.setText(returnedInterest);
			}catch(Exception e){
				String error =e.toString();
					Dialog d = new Dialog(this);
					d.setTitle("Yeah");
					TextView tv = new TextView(this);
					tv.setText(error);
					d.setContentView(tv);
					d.show();
			}
			break;
		case R.id.bModify:
			try{
			String mName = sqlRow.getText().toString();
			String mInterest = sqlRow.getText().toString();
			String sRow = sqlRow.getText().toString();
			long lRow = Long.parseLong(sRow);
			
			InterestingOrNot ex = new InterestingOrNot(this);
			ex.open();
			ex.updateEntry(lRow,mName, mInterest);
			ex.close();
			}catch(Exception e){
				String error =e.toString();
					Dialog d = new Dialog(this);
					d.setTitle("Yeah");
					TextView tv = new TextView(this);
					tv.setText(error);
					d.setContentView(tv);
					d.show();
			}
			
			break;
		case R.id.bDeleteEntry:
			try{
			String sRow1 = sqlRow.getText().toString();
			long lRow1 = Long.parseLong(sRow1);
			InterestingOrNot ex1 = new InterestingOrNot(this);
			ex1.open();
			ex1.deleteEntry(lRow1);
			ex1.close();
			}
			catch(Exception e){
				didItWork = false;
				String error =e.toString();
					Dialog d = new Dialog(this);
					d.setTitle("Yeah");
					TextView tv = new TextView(this);
					tv.setText(error);
					d.setContentView(tv);
					d.show();
			}
			break;
		
		}
	}*/
		}}
}
