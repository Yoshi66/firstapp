/*
 * Copyright (C) 2007 The Android Open Source Project
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

package value.app;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This class provides a basic demonstration of how to write an Android
 * activity. Inside of its window, it places a single view: an EditText that
 * displays and edits some internal text.
 */
public class SkeletonActivity extends ListActivity{

		String classes[] = {"Education","Book","Toggle","Circle","Camera","Data","OpenClass","SimpleBrowser"
				,"Flipper","SharedPrefs","SQLiteExample","HttpExample"};
		
		

		@Override
		protected void onCreate(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			
			super.onCreate(savedInstanceState);
			
			//fullscreen
			requestWindowFeature(Window.FEATURE_NO_TITLE);
			getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
					WindowManager.LayoutParams.FLAG_FULLSCREEN);
			
			setListAdapter(new ArrayAdapter<String>(SkeletonActivity.this,android.R.layout.simple_list_item_1 , classes));
			}


		@Override
		protected void onListItemClick(ListView l, View v, int position, long id) {
			// TODO Auto-generated method stub
			super.onListItemClick(l, v, position, id);
			String cheese = classes[position];
			try{
			Class ourClass = Class.forName("com.example.android.skeletonapp." + cheese);
			Intent intent = new Intent(SkeletonActivity.this,ourClass);
			startActivity(intent);}catch(ClassNotFoundException e){
				e.printStackTrace();
			}
			
		}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		
		super.onCreateOptionsMenu(menu);
		
		MenuInflater inflater = getMenuInflater();
		
		inflater.inflate(R.menu.mainmenu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
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
    