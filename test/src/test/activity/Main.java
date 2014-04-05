package test.activity;


import java.io.FileNotFoundException;

import com.example.test.R;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class Main extends Activity {

	int resultforG = 100;
	int resultforC = 101;
	Button fromG, fromC;
	Bitmap image;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fromG = (Button) findViewById(R.id.fromG);
        fromC = (Button) findViewById(R.id.fromC);
        fromG.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
				startActivityForResult(intent, resultforG);
			}
		});
        fromC.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
			    if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
			        startActivityForResult(takePictureIntent, resultforC);
			    }
				
			}
		});
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data){
		if(resultCode == RESULT_OK && requestCode == resultforG){
			Uri targetUri = data.getData();
			try {
				image = BitmapFactory.decodeStream(getContentResolver().openInputStream(targetUri));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		if(resultCode == RESULT_OK && requestCode == resultforC){
			Bundle extras = data.getExtras();
			image = (Bitmap) extras.get("data");
		}
		super.onActivityResult(requestCode, resultCode, data);
		processtoEdit();
	}
	
	private void processtoEdit(){
		Intent toStart = new Intent("android.intent.action.EDIT");
		Bundle bundle = new Bundle();
		bundle.putParcelable("image", image);
		toStart.putExtra("image", bundle);
		startActivity(toStart);
	}
}
