package value.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Box extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.box);
		Thread timer = new Thread(){
			public void run(){
				try{
					sleep(5000);
					
				} catch (InterruptedException e){
					e.printStackTrace();
				}finally{
					Intent intent = new Intent(Box.this, SkeletonActivity.class);
					startActivity(intent);
				}
			}
		};
		timer.start();
		
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}
	
}

