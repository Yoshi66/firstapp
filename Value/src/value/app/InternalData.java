package value.app;
//Issue:how to make sure if the last part of code is working correctly.
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class InternalData extends Activity implements OnClickListener {

	EditText sharedData;
	TextView dataResults;
	FileOutputStream fos;
	String FILENAME = "InternalString";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sharedpref);
		setupVariables();
	}
	private void setupVariables(){
		Button save = (Button) findViewById(R.id.bSave);
		Button load = (Button) findViewById(R.id.bLoad);
		sharedData = (EditText) findViewById(R.id.etSharedData);
		dataResults = (TextView) findViewById(R.id.tvSYD);
		save.setOnClickListener(this);
		load.setOnClickListener(this);
		try{
			fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
			fos.close();
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
		
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		//TUTOTRIAL 97 MAKE SURE
		switch(v.getId()){
		case R.id.bSave:
			String data = sharedData.getText().toString();
			//Saving data via File
			/*File f = new File(FILENAME);
			try{
				fos = new FileOutputStream(f);
				//write some data here
				fos.close();
			}catch(IOException e){
				e.printStackTrace();
			}*/
			try{
			fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
			fos.write(data.getBytes());
			fos.close();}catch(IOException e){
				e.printStackTrace();
			}
			break;
		case R.id.bLoad:
			new loadSomeStuff().execute(FILENAME);
			break;
		}	
	}
	public class loadSomeStuff extends AsyncTask<String, Integer, String>{

		ProgressDialog dialog;
		
		
		protected void onPreExecute(){
			dialog = new ProgressDialog(InternalData.this);
			dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
			dialog.setMax(100);
			dialog.show();
		}
		
		@Override
		protected String doInBackground(String... params) {
			// TODO Auto-generated method stub
			String collected = null;
			FileInputStream fis = null;
			
			for(int i= 0; i < 20; i++){
				publishProgress(5);
				try {
					Thread.sleep(88);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			dialog.dismiss();
			
			try {
				fis = openFileInput(FILENAME);
				byte[] dataArray= new byte[fis.available()];
				while (fis.read(dataArray) != -1){
					collected = new String(dataArray);
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try {
					fis.close();
					return collected;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			return null;
		}
		protected void onProgressUpdate(Integer...progress){
			dialog.incrementProgressBy(progress[0]);
		}
		protected void onPostExecute(String result){
			dataResults.setText(result);
		}
	}
}
