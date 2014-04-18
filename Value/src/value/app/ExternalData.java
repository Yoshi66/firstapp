package value.app;
//issue: cannot find getExternalPublicStorageDirectory, is it caused by the level of API?
import java.io.File;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class ExternalData extends Activity implements OnItemSelectedListener{

	private TextView canWrite, canRead;
	private String state;
	boolean canW, canR;
	Spinner spinner;
	String[] paths = {"Music", "Picture", "Download"};
	File path = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.externaldata);
		canWrite = (TextView) findViewById(R.id.tvCanWrite);
		canRead = (TextView) findViewById(R.id.tvCanRead);
		
		state = Environment.getExternalStorageState();
		if (state.equals(Environment.MEDIA_MOUNTED)){
			canWrite.setText("true");
			canRead.setText("true");
			canW= canR = true;
		}else if (state.equals(Environment.MEDIA_MOUNTED_READ_ONLY)){
			canWrite.setText("false");
			canRead.setText("true");
			canW = false;
			canR = true;
		}else{
			canWrite.setText("false");
			canRead.setText("false");
			canW = canR = false;
			
		}
		
		ArrayAdapter<String> adapter= new ArrayAdapter<String>(ExternalData.this,android.R.layout.simple_spinner_item) ; 
		
		spinner =(Spinner) findViewById(R.id.spinner1);
		spinner.setAdapter(adapter);
		spinner.setOnItemSelectedListener(this);
	}


	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		int position = spinner.getSelectedItemPosition();
		switch(position){
		case 0:
		//path = Environment.getExternalStorageDirectory(Environment.);
				break;
		case 1:
			break;
		case 2:
			break;
		}
			
		
	}


	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}

}
