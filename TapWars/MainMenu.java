package com.nevinsunnyapplication.tapwar;
//import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import org.andengine.ui.activity.SimpleBaseGameActivity;
import org.andengine.engine.options.EngineOptions;
import org.andengine.entity.scene.Scene;
import org.andengine.engine.camera.Camera;
import org.andengine.engine.handler.IUpdateHandler;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.resolutionpolicy.FillResolutionPolicy;
import org.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.andengine.opengl.font.Font;
import org.andengine.opengl.font.FontFactory;
import org.andengine.opengl.texture.ITexture;
import org.andengine.opengl.texture.bitmap.BitmapTexture;
import org.andengine.util.adt.io.in.IInputStreamOpener;
import org.andengine.util.debug.Debug;

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.text.Text;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.texture.region.TextureRegionFactory;


public class MainMenu extends SimpleBaseGameActivity   {

	private ITextureRegion mBackground, mStart, mStartPress, mTutorial, mTutorialPress,mLeaderBoard,mLeaderBoardPress;
	private static int CAMERA_WIDTH = 1080;
	private static int CAMERA_HEIGHT = 1920;
	Sprite StartPress,Start,Tutorial,LeaderBoard;
	Scene scene = new Scene();
	@Override
	public EngineOptions onCreateEngineOptions() {
		// TODO Auto-generated method stub
		final Camera camera = new Camera(0, 0, CAMERA_WIDTH,CAMERA_HEIGHT );
		return new EngineOptions(true, ScreenOrientation.PORTRAIT_FIXED,
		new FillResolutionPolicy(), camera);
		
	}

	@Override
	protected void onCreateResources() {
		try {
		    ITexture backgroundTexture = new BitmapTexture(this.getTextureManager(), new IInputStreamOpener() {
		        @Override
		        public InputStream open() throws IOException {
		            return getAssets().open("gfx/mainback.png");
		        }
		    });backgroundTexture.load();this.mBackground = TextureRegionFactory.extractFromTexture(backgroundTexture);
		    
		    ITexture Start = new BitmapTexture(this.getTextureManager(), new IInputStreamOpener() {
		        @Override
		        public InputStream open() throws IOException {
		            return getAssets().open("gfx/play.png");
		        }
		    });Start.load();this.mStart = TextureRegionFactory.extractFromTexture(Start);
		    
		    ITexture StartPress = new BitmapTexture(this.getTextureManager(), new IInputStreamOpener() {
		        @Override
		        public InputStream open() throws IOException {
		            return getAssets().open("gfx/playpress.png");
		        }
		    });StartPress.load();this.mStartPress = TextureRegionFactory.extractFromTexture(StartPress);
		 
		    ITexture Tutorial = new BitmapTexture(this.getTextureManager(), new IInputStreamOpener() {
		        @Override
		        public InputStream open() throws IOException {
		            return getAssets().open("gfx/tut.png");
		        }
		    });Tutorial.load();this.mTutorial = TextureRegionFactory.extractFromTexture(Tutorial);
		    
		    ITexture TutorialPress = new BitmapTexture(this.getTextureManager(), new IInputStreamOpener() {
		        @Override
		        public InputStream open() throws IOException {
		            return getAssets().open("gfx/tutpress.png");
		        }
		    });TutorialPress.load();this.mTutorialPress = TextureRegionFactory.extractFromTexture(TutorialPress);
		    
		    ITexture LeaderBoard = new BitmapTexture(this.getTextureManager(), new IInputStreamOpener() {
		        @Override
		        public InputStream open() throws IOException {
		            return getAssets().open("gfx/lead.png");
		        }
		    });LeaderBoard.load();this.mLeaderBoard = TextureRegionFactory.extractFromTexture(LeaderBoard);
		 
		    ITexture LeaderBoardPress = new BitmapTexture(this.getTextureManager(), new IInputStreamOpener() {
		        @Override
		        public InputStream open() throws IOException {
		            return getAssets().open("gfx/leadpress.png");
		        }
		    });LeaderBoardPress.load();this.mLeaderBoardPress = TextureRegionFactory.extractFromTexture(LeaderBoardPress);
		   
		  
		    
		    
		    
		    
		} catch (IOException e) {
		    Debug.e(e);
		
			}
	}


	@Override
	protected Scene onCreateScene() {
		
		Sprite backgroundSprite = new Sprite(0, 0, this.mBackground, getVertexBufferObjectManager());
		
		
		scene.attachChild(backgroundSprite);
		
		
		
		
		
		
		StartPress = new Sprite(130, 104, this.mStartPress, getVertexBufferObjectManager());
		
		scene.attachChild(StartPress);
		
		
		 Start = new Sprite(130, 104, this.mStart, getVertexBufferObjectManager()){
			@Override
			public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float pTouchAreaLocalY) {
				scene.detachChild(Start);
				if (pSceneTouchEvent.getAction() == TouchEvent.ACTION_UP) {		        	
//					scene.attachChild(Start);
					scene.attachChild(Start);
					
					MainMenu.this.startActivity(new Intent(MainMenu.this, GameActivity.class));
					
					MainMenu.this.finish();
					
			    }
			    return true;
			}
		};
		scene.registerTouchArea(Start);
		scene.setTouchAreaBindingOnActionDownEnabled(true);
		scene.attachChild(Start);
		
		Sprite TutorialPress = new Sprite(130, 377, this.mTutorialPress, getVertexBufferObjectManager());
		scene.attachChild(TutorialPress);
		
		
		Tutorial = new Sprite(130, 377, this.mTutorial, getVertexBufferObjectManager()){
			@Override
			public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float pTouchAreaLocalY) {
				scene.detachChild(Tutorial);
				if (pSceneTouchEvent.getAction() == TouchEvent.ACTION_UP) {		        	

					scene.attachChild(Tutorial);
			    }
			    return true;
			}
		};
		scene.registerTouchArea(Tutorial);
		scene.setTouchAreaBindingOnActionDownEnabled(true);
		scene.attachChild(Tutorial);
		
		
		Sprite LeaderBoardPress = new Sprite(130, 642, this.mLeaderBoardPress, getVertexBufferObjectManager());
		scene.attachChild(LeaderBoardPress);
		
		
		
		LeaderBoard = new Sprite(130, 642, this.mLeaderBoard, getVertexBufferObjectManager()){
			@Override
			public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float pTouchAreaLocalY) {
				scene.detachChild(LeaderBoard);
				if (pSceneTouchEvent.getAction() == TouchEvent.ACTION_UP) {		        	

					scene.attachChild(LeaderBoard);
			    }
			    return true;
			}
		};
		scene.registerTouchArea(LeaderBoard);
		scene.setTouchAreaBindingOnActionDownEnabled(true);
		scene.attachChild(LeaderBoard);
		
		
		
		return scene;
		
	}

}























