package com.example.fb_testapplication2;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.Request;
import com.facebook.Response;
import com.facebook.Session;
import com.facebook.SessionState;
import com.facebook.UiLifecycleHelper;
import com.facebook.model.GraphUser;
import com.facebook.widget.LoginButton;
import com.facebook.widget.LoginButton.UserInfoChangedCallback;

public class MainActivity extends FragmentActivity {

	private final String Tag = getClass().getName();
	Boolean PhotoPresent=false;
	private LoginButton loginBtn;
	private Button postImageBtn;
	private Button updateStatusBtn,bCamera;
	ImageView Photo;
	Bitmap photo2;
	private TextView userName;

	private UiLifecycleHelper uiHelper;

	private static final List<String> PERMISSIONS = Arrays.asList("publish_actions");

	private static String message = "Sample status posted from android app";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//final int CAMERA_REQUEST = 1888; 
		uiHelper = new UiLifecycleHelper(this, statusCallback);
		uiHelper.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);

		userName = (TextView) findViewById(R.id.user_name);
		loginBtn = (LoginButton) findViewById(R.id.fb_login_button);
		bCamera=(Button)findViewById(R.id.Button01);
		Photo=(ImageView)findViewById(R.id.imageView1);
		
		
		
		
		loginBtn.setUserInfoChangedCallback(new UserInfoChangedCallback() {
			@Override
			public void onUserInfoFetched(GraphUser user) {
				if (user != null) {
					userName.setText("Hello, " + user.getName());
				} else {
					userName.setText("You are not logged");
				}
			}
		});

		postImageBtn = (Button) findViewById(R.id.post_image);
		postImageBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				
				if(!PhotoPresent)
					Toast.makeText(getApplicationContext(), "Click a picture", 
							   Toast.LENGTH_LONG).show();
				else
					postImage();
			}
		});
		
		bCamera.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				StartCam();
			}
		});
		

		updateStatusBtn = (Button) findViewById(R.id.update_status);
		updateStatusBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				postStatusMessage();

			}
		});

		buttonsEnabled(false);
	}

	
	
	void StartCam(){
		
		
		
		
		
//		Intent i = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
//		i.putExtra(MediaStore.EXTRA_OUTPUT, MyFileContentProvider.CONTENT_URI);
//		startActivityForResult(i, 123);
		
		
		
		
		
		Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		
		intent.putExtra(MediaStore.EXTRA_OUTPUT, MyFileContentProvider.CONTENT_URI);
		startActivityForResult(intent, 123);
		
//		 Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//
//		 
//		 
//         startActivityForResult(intent, 123);
		
	}
	
	private Session.StatusCallback statusCallback = new Session.StatusCallback() {
		@Override
		public void call(Session session, SessionState state,
				Exception exception) {
			if (state.isOpened()) {
				buttonsEnabled(true);
				Log.d("FacebookSampleActivity", "Facebook session opened");
			} else if (state.isClosed()) {
				buttonsEnabled(false);
				Log.d("FacebookSampleActivity", "Facebook session closed");
			}
		}
	};

	public void buttonsEnabled(boolean isEnabled) {
		postImageBtn.setEnabled(isEnabled);
		updateStatusBtn.setEnabled(isEnabled);
	}

	public void postImage() {
		if (checkPermissions()) {
			
			//String s1=MyFileContentProvider.CONTENT_URI.toString();
			
			
			//Bitmap img = BitmapFactory.decodeFile(s1);
			
			
			
			
			Bitmap img=photo2;
			
			Request uploadRequest = Request.newUploadPhotoRequest(
					Session.getActiveSession(), img, new Request.Callback() {
						@Override
						public void onCompleted(Response response) {
							Toast.makeText(MainActivity.this,
									"Photo uploaded successfully",
									Toast.LENGTH_LONG).show();
						}
					});
			uploadRequest.executeAsync();
		} else {
			requestPermissions();
		}
	}

	public void postStatusMessage() {
		if (checkPermissions()) {
			Request request = Request.newStatusUpdateRequest(
					Session.getActiveSession(), "teste 123",
					new Request.Callback() {
						@Override
						public void onCompleted(Response response) {
							if (response.getError() == null)
								Toast.makeText(MainActivity.this,
										"Status updated successfully",
										Toast.LENGTH_LONG).show();
						}
					});
			request.executeAsync();
		} else {
			requestPermissions();
		}
	}

	public boolean checkPermissions() {
		Session s = Session.getActiveSession();
		if (s != null) {
			return s.getPermissions().contains("publish_actions");
		} else
			return false;
	}

	public void requestPermissions() {
		Session s = Session.getActiveSession();
		if (s != null)
			s.requestNewPublishPermissions(new Session.NewPermissionsRequest(
					this, PERMISSIONS));
	}

	@Override
	public void onResume() {
		super.onResume();
		uiHelper.onResume();
		buttonsEnabled(Session.getActiveSession().isOpened());
	}

	@Override
	public void onPause() {
		super.onPause();
		uiHelper.onPause();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		uiHelper.onDestroy();
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		 super.onActivityResult(requestCode, resultCode, data);

		  Log.i(Tag, "Receive the camera result");

		    if (resultCode == RESULT_OK && requestCode == 123) {

		   File out = new File(getFilesDir(), "newImage.jpg");

		     if(!out.exists()) {

		    Toast.makeText(getBaseContext(),

		      "Error while capturing image", Toast.LENGTH_LONG)

		      .show();

		    return;

		   }

		     photo2= BitmapFactory.decodeFile(out.getAbsolutePath());

		   Photo.setImageBitmap(photo2);
		   PhotoPresent=true;

		  }
		 
	}

	@Override
	public void onSaveInstanceState(Bundle savedState) {
		super.onSaveInstanceState(savedState);
		uiHelper.onSaveInstanceState(savedState);
	}

}