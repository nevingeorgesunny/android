package com.nevinsunnyapplication.tapwar;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.resolutionpolicy.FillResolutionPolicy;
import org.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.text.Text;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.font.Font;
import org.andengine.opengl.font.FontFactory;
import org.andengine.opengl.texture.ITexture;
import org.andengine.opengl.texture.bitmap.BitmapTexture;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.texture.region.TextureRegionFactory;
import org.andengine.ui.activity.SimpleBaseGameActivity;
import org.andengine.util.adt.io.in.IInputStreamOpener;
import org.andengine.util.debug.Debug;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;

public class GameActivity extends SimpleBaseGameActivity {
	
	int inc=0;
	double Killer=0.5,Distroyer=0.25;
	int checkFile;
	private ITextureRegion mBackground,mStation,mGhost,mTap,mIncorrect,mNFE,mDim,mWindow,mReset,mShare,mBomb,mKa;
	int historicX,historicY,PrimaryCheck=1;
	int score=0,HistoricScore=333;
	float HistoricYpostition,HistoricXpostition;
	Sprite Ghost,Tap,Incorrect,NFE,Dim,Window,Reset,Share,Bomb,Ka;
	Sprite [][]station=new Sprite[3][3];
	int[][]refrence=new int[3][3];
	int BombSelector=1;
	private Font font,font2;
	Text text,text2,text3;
	String HighScore = "HighScore";
	Timer timer,terminator,Taper,t2,t3,t4,t5,BombTimer,t6;
	int width=0, height=2150;
	double clock=0;
	int counter=0,counter2=0,check=1,check2=1,check3=1,counter3=0,check4=1,dimCheck,dimCheck2,dimcounter=0;
	Scene scene = new Scene();
	double interval=1;
	static double Xfactor=1.6;
	static double Yfactor=1.5;
	String sInput;
	private static int CAMERA_WIDTH = 1080;
	private static int CAMERA_HEIGHT = 1920;
	int w=262;int h=358;
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
		            return getAssets().open("gfx/GameBack.png");
		        }
		    });backgroundTexture.load();this.mBackground = TextureRegionFactory.extractFromTexture(backgroundTexture);
		    
		    ITexture Station = new BitmapTexture(this.getTextureManager(), new IInputStreamOpener() {
		        @Override
		        public InputStream open() throws IOException {
		            return getAssets().open("gfx/station.png");
		        }
		    });Station.load();this.mStation = TextureRegionFactory.extractFromTexture(Station);
		    
		    ITexture Ka = new BitmapTexture(this.getTextureManager(), new IInputStreamOpener() {
		        @Override
		        public InputStream open() throws IOException {
		            return getAssets().open("gfx/kaboom.png");
		        }
		    });Ka.load();this.mKa = TextureRegionFactory.extractFromTexture(Ka);
		    
		    ITexture Ghost = new BitmapTexture(this.getTextureManager(), new IInputStreamOpener() {
		        @Override
		        public InputStream open() throws IOException {
		            return getAssets().open("gfx/face.png");
		        }
		    });Ghost.load();this.mGhost = TextureRegionFactory.extractFromTexture(Ghost);
		    
		    ITexture Tap = new BitmapTexture(this.getTextureManager(), new IInputStreamOpener() {
		        @Override
		        public InputStream open() throws IOException {
		            return getAssets().open("gfx/hand.png");
		        }
		    });Tap.load();this.mTap = TextureRegionFactory.extractFromTexture(Tap);
		    
		    ITexture Incorrect = new BitmapTexture(this.getTextureManager(), new IInputStreamOpener() {
		        @Override
		        public InputStream open() throws IOException {
		            return getAssets().open("gfx/incorrect.png");
		        }
		    });Incorrect.load();this.mIncorrect = TextureRegionFactory.extractFromTexture(Incorrect);
		    
		    ITexture Bomb = new BitmapTexture(this.getTextureManager(), new IInputStreamOpener() {
		        @Override
		        public InputStream open() throws IOException {
		            return getAssets().open("gfx/bomb.png");
		        }
		    });Bomb.load();this.mBomb = TextureRegionFactory.extractFromTexture(Bomb);
		    
		   
		  
		    
		    ITexture Window = new BitmapTexture(this.getTextureManager(), new IInputStreamOpener() {
		        @Override
		        public InputStream open() throws IOException {
		            return getAssets().open("gfx/window.png");
		        }
		    });Window.load();this.mWindow = TextureRegionFactory.extractFromTexture(Window);
		    
		    ITexture Reset = new BitmapTexture(this.getTextureManager(), new IInputStreamOpener() {
		        @Override
		        public InputStream open() throws IOException {
		            return getAssets().open("gfx/reset.png");
		        }
		    });Reset.load();this.mReset = TextureRegionFactory.extractFromTexture(Reset);
		    
		    ITexture Share = new BitmapTexture(this.getTextureManager(), new IInputStreamOpener() {
		        @Override
		        public InputStream open() throws IOException {
		            return getAssets().open("gfx/share.png");
		        }
		    });Share.load();this.mShare = TextureRegionFactory.extractFromTexture(Share);
		    
		    
		    font = FontFactory.create(this.getFontManager(), this.getTextureManager(), 465,465, Typeface.create(Typeface.DEFAULT, Typeface.BOLD), 145,Color.DKGRAY);
		    font.load();
		    
		    font2 = FontFactory.create(this.getFontManager(), this.getTextureManager(), 400,400, Typeface.create(Typeface.DEFAULT, Typeface.BOLD), 100,Color.DKGRAY);
		    font2.load();
		    
		   int key=0; 
		   for(int i=0;i<3;i++)
			   for(int j=0;j<3;j++)
				   refrence[i][j]=key++;
		    
		    
		} catch (IOException e) {
		    Debug.e(e);
		
			}
		
	}

	@Override
	protected Scene onCreateScene() {
		Sprite backgroundSprite = new Sprite(0, 0, this.mBackground, getVertexBufferObjectManager());
		Bomb = new Sprite(0, 0, this.mBomb, getVertexBufferObjectManager());
		backgroundSprite.setWidth(  (backgroundSprite.getWidth() ));
		backgroundSprite.setHeight(  (backgroundSprite.getHeight() ));
		scene.attachChild(backgroundSprite);
		Ka = new Sprite(0, 0, this.mKa, getVertexBufferObjectManager());
		Incorrect = new Sprite(0,0, this.mIncorrect, getVertexBufferObjectManager());
		int shift=100;		
		station[0][0] = new Sprite( (75),  (205+shift ), this.mStation, getVertexBufferObjectManager());
		station[0][0].setWidth(  (station[0][0].getWidth() ));
		station[0][0].setHeight(  (station[0][0].getHeight() ));
		scene.attachChild(station[0][0]);
		
		station[0][1] = new Sprite( (409 ),  (205 +shift), this.mStation, getVertexBufferObjectManager());
		station[0][1].setWidth(  (station[0][0].getWidth() ));
		station[0][1].setHeight(  (station[0][0].getHeight() ));
		scene.attachChild(station[0][1]);
		
		station[0][2] = new Sprite( (736), ( 205+shift ), this.mStation, getVertexBufferObjectManager());
		station[0][2].setWidth(  (station[0][0].getWidth() ));
		station[0][2].setHeight(  (station[0][0].getHeight() ));
		scene.attachChild(station[0][2]);
		
		
		station[1][0] = new Sprite( (75 ),  (549+shift ), this.mStation, getVertexBufferObjectManager());
		station[1][0].setWidth(  (station[0][0].getWidth() ));
		station[1][0].setHeight(  (station[0][0].getHeight() ));
		scene.attachChild(station[1][0]);
		
		station[1][1] = new Sprite( (736 ),  (549+shift ), this.mStation, getVertexBufferObjectManager());
		station[1][1].setWidth(  (station[0][0].getWidth() ));
		station[1][1].setHeight(  (station[0][0].getHeight() ));
		scene.attachChild(station[1][1]);
		
		station[1][2] = new Sprite( (409 ),  (549 +shift), this.mStation, getVertexBufferObjectManager());
		station[1][2].setWidth(  (station[0][0].getWidth() ));
		station[1][2].setHeight(  (station[0][0].getHeight() ));
		scene.attachChild(station[1][2]);
		
		station[2][0] = new Sprite( (75 ),  (893+shift ), this.mStation, getVertexBufferObjectManager());
		station[2][0].setWidth(  (station[0][0].getWidth() ));
		station[2][0].setHeight(  (station[0][0].getHeight() ));
		scene.attachChild(station[2][0]);
		
		station[2][1] = new Sprite( (409 ),  (893+shift ), this.mStation, getVertexBufferObjectManager());
		station[2][1].setWidth(  (station[0][0].getWidth() ));
		station[2][1].setHeight(  (station[0][0].getHeight() ));
		scene.attachChild(station[2][1]);
		
		station[2][2] = new Sprite( (736 ),  (893+shift ), this.mStation, getVertexBufferObjectManager());
		station[2][2].setWidth(  (station[0][0].getWidth() ));
		station[2][2].setHeight(  (station[0][0].getHeight() ));
		scene.attachChild(station[2][2]); 
		int x=randInt(0,2);
		int y=randInt(0,2);	

		Ghost = new Sprite(station[x][y].getX()- (44 ), station[x][y].getY()- (44 ), this.mGhost, getVertexBufferObjectManager()){
		    @Override
		    public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float pTouchAreaLocalY) {
		    	scene.detachChild(Tap);
		    	if (pSceneTouchEvent.getAction() == TouchEvent.ACTION_UP) {		        	
		    		int selector=randInt(0,11);
		        	int x;
		        	x=randInt(0,2);
		        	while(x==historicX)
		        		x=randInt(0,2);		        	
		    		int y;		    		
		    		y=randInt(0,2);
		    		while(y==historicY)
		        		y=randInt(0,2);		    		
		        	for(int i=0;i<2;i++)
		        		for(int j=0;j<2;j++)
		        			if(selector==refrence[i][j]){
		        				x=i;j=i;
		        				break;
		        			}
		        	this.setPosition(station[x][y].getX()- (44 ), station[x][y].getY()- (44 ));
		        	Bomb.setPosition(Ghost.getX()-20,Ghost.getY()-60);
		        	score++;
		        	text.setText(String.valueOf(score));
		        	historicX=x;
		        	historicY=y;
		        	Ghost.unregisterUpdateHandler(terminator);	 
		        	
		        	if(BombSelector==0)
		        		 Killer=0;
		        	 else
		        		 Killer=0.5;
		        	
		        	BombSelector=randInt(0,7);
		    		if(BombSelector==0){
			    		Bomb.setVisible(true);
			    		Ghost.setVisible(false);
			    		 BombTimer = new Timer(0.01, new Timer.ITimerCallback() {
				    		    public void onTick() {
				    		    	if(inc>100){
				    		    		Bomb.setWidth(375);
				    		    		Bomb.setHeight(375);
				    		    		Bomb.setPosition(station[historicX][historicY].getX()- (60 ), station[historicX][historicY].getY()- (100 ));
					    		    	 HistoricXpostition=station[historicX][historicY].getX()- (44 );
					    		    	 HistoricYpostition=station[historicX][historicY].getY()- (44 );
					    		    	 width=0;
					    		    	 Bomb.unregisterUpdateHandler(BombTimer);
					    		    	 inc=0;
				    		    	}
				    		    	else{	
				    		    		inc+=20;
				    		    		Bomb.setWidth(375+inc);
				    		    		Bomb.setHeight(375+inc);
				    		    		Bomb.setPosition(Bomb.getX()- (10 ),Bomb.getY()- (10));				    		    		
				    		    	}
				    		    }
				    		});
			    		 Bomb.registerUpdateHandler(BombTimer);	
		    		}
		    		else
			    		Bomb.setVisible(false);
		    		 timer = new Timer(0.01, new Timer.ITimerCallback() {
			    		    public void onTick() {
			    		      width+=20;
			    		    	if(width>100){
			    		    		Ghost.setWidth(340);
				    		    	 Ghost.setHeight(340);
				    		    	 Ghost.setPosition(station[historicX][historicY].getX()- (44 ), station[historicX][historicY].getY()- (44 ));
				    		    	 HistoricXpostition=station[historicX][historicY].getX()- (44 );
				    		    	 HistoricYpostition=station[historicX][historicY].getY()- (44 );
				    		    	 width=0;
				    		    	 Ghost.unregisterUpdateHandler(timer);
			    		    	}
			    		    	else{	
			    		    	 Ghost.setWidth(340+width);
			    		    	 Ghost.setHeight(340+width);
			    		    	 Ghost.setPosition(Ghost.getX()- (10 ),Ghost.getY()- (10));			    		    	
			    		    	}
			    		    }
			    		});
		        	 Ghost.registerUpdateHandler(timer);
		        	 terminator = new Timer(Killer, new Timer.ITimerCallback() {// editor
			    		    public void onTick() {		    		    	
			    		    	if(BombSelector==0){
			    		    		Ghost.setVisible(true);
			    		    		int selector=randInt(0,11);
			    		        	int x;
			    		        	x=randInt(0,2);
			    		        	while(x==historicX)
			    		        	x=randInt(0,2);		        	
			    		    		int y;		    		
			    		    		y=randInt(0,2);
			    		    		while(y==historicY)
			    		        		y=randInt(0,2);		    		
			    		        	for(int i=0;i<2;i++)
			    		        		for(int j=0;j<2;j++)
			    		        			if(selector==refrence[i][j]){
			    		        				x=i;j=i;
			    		        				break;
			    		        			}
			    		        	Ghost.setPosition(station[x][y].getX()- (44 ), station[x][y].getY()- (44 ));
			    		        	historicX=x;
			    		        	historicY=y;
			    		        
				    		    		
			    		    		 timer = new Timer(0.01, new Timer.ITimerCallback() {
			    			    		    public void onTick() {
			    			    		      width+=20;
			    			    		    	if(width>100){
			    			    		    		Ghost.setWidth(340);
			    				    		    	 Ghost.setHeight(340);
			    				    		    	 Ghost.setPosition(station[historicX][historicY].getX()- (44 ), station[historicX][historicY].getY()- (44 ));
			    				    		    	 HistoricXpostition=station[historicX][historicY].getX()- (44 );
			    				    		    	 HistoricYpostition=station[historicX][historicY].getY()- (44 );
			    				    		    	 width=0;
			    				    		    	 Ghost.unregisterUpdateHandler(timer);
			    			    		    	}
			    			    		    
			    			    		   
			    			    		    	else{	
			    			    		    	 Ghost.setWidth(340+width);
			    			    		    	 Ghost.setHeight(340+width);
			    			    		    	 
			    			    		    	 Ghost.setPosition(Ghost.getX()- (10 ),Ghost.getY()- (10));
			    			    		    	 
			    			    		    	
			    			    		    	}
			    			    		    	//scene.detachChild(Ghost)
			    			    		    }
			    			    		});
			    		        	 Ghost.registerUpdateHandler(timer);
			    		    		
			    		        	 Bomb.setVisible(false);
			    		        	 BombSelector=1;			    		    		
			    		    	}			    		    	
				    		    	else if(BombSelector!=0){
					    		    	Incorrect.setPosition(Ghost.getX()+20,Ghost.getY());
					    		    	if(Killer==0){
					    		    		scene.attachChild(Ka);
					    		    		Incorrect.setVisible(false);
					    		    		Ghost.setVisible(false);
					    		    	}
					    		    	else
					    		    		scene.attachChild(Incorrect);
					    		    	scene.detachChild(Ghost);	
					    		    	scene.unregisterTouchArea(Ghost);
					    		    	if(Killer==0)
					    		    		Distroyer=0;
					    		    	else
					    		    		Distroyer=0.25;					    		    
					    		    	 t3 = new Timer(Distroyer, new Timer.ITimerCallback() { 
								    		    public void onTick() {						    		    									    		    	
								    		    	if(Killer!=0){
									    		    	check3*=-1;
									    		    	if(check3==1){
									    		    		scene.attachChild(Incorrect);
									    		    		counter3++;
									    		    	}
									    		    	if(check3==-1)
									    		    		scene.detachChild(Incorrect);
								    		    	}
								    		    	else{
								    		    		 Ka.setWidth(1080+inc);
					    			    		    	 Ka.setHeight(1920+inc);
					    			    		    	 inc+=300;
					    			    		    	 Ka.setPosition(Ka.getX()-100,Ka.getY()-100);
					    			    		    	 if(inc>2000)
					    			    		    	 	counter3=2;
								    		    	}
								    		    	
								    		    	
								    		    	
								    		    	if(counter3==2){					    		 
								    		    		scene.attachChild(Window);
								    		    		text3.setText(String.valueOf(score));
								    		    		scene.attachChild(text3);			    		    		
								    		    		try {
															FileInputStream fosInitial = openFileInput("HighScore");												
														} catch (FileNotFoundException e3) {
														// TODO Auto-generated catch block
														PrimaryCheck=0;
														e3.printStackTrace();
													}
							    		    		if(PrimaryCheck==0){
							    		    			try {
							    		    				FileOutputStream fosTemp = openFileOutput("HighScore", Context.MODE_PRIVATE);
							    		    			} catch (FileNotFoundException e2) {
														// TODO Auto-generated catch block
							    		    				e2.printStackTrace();
							    		    			}
							    		    		
							    		    		}
							    		    		try {
														
							    		    			FileInputStream fos = openFileInput("HighScore");
							    		    			try {
															HistoricScore=fos.read();
															text2.setText(String.valueOf(HistoricScore));
														} catch (IOException e) {
															// TODO Auto-generated catch block
															e.printStackTrace();	
														}	
							    		    			if(HistoricScore<score){
							    		    				text2.setText(String.valueOf(score));
															FileOutputStream fos2 = openFileOutput("HighScore", Context.MODE_PRIVATE);
															try {
																fos2.write(score);
															} catch (IOException e1) {
																// TODO Auto-generated catch block
																e1.printStackTrace();
															}
														}
							    		    		} catch (FileNotFoundException e) {
														// TODO Auto-generated catch block
														e.printStackTrace();
													}
							    		    		scene.attachChild(text2);
							    		    		scene.attachChild(Share);
							    		    		scene.attachChild(Reset);
							    		    		scene.registerTouchArea(Share);
							    		    		scene.setTouchAreaBindingOnActionDownEnabled(true);
							    		    		scene.registerTouchArea(Reset);
							    		    		scene.setTouchAreaBindingOnActionDownEnabled(true);						    		    		 
							    		    		scene.unregisterUpdateHandler(t3);					    		    	
							    		    	}	
							    		    }
							    		});
				    		    	 scene.registerUpdateHandler(t3);		    		    
				    		    	 t2 = new Timer(0.001, new Timer.ITimerCallback() {
							    		    public void onTick() {
							    		    	
							    		    	counter2+=check;
							    		    	if(counter2>3){
							    		    		check*=-1;
							    		    		check2++;
							    		    		if(check2==3){
							    		    			Incorrect.setPosition(HistoricXpostition,HistoricYpostition);
							    		    			scene.unregisterUpdateHandler(t2);
							    		    		}
							    		    	}
							    		    			check*=-1;
							    		    		
							    		    		
							    		    	Incorrect.setPosition(Incorrect.getX()+check*3,Incorrect.getY());
							    		    	
							    		    	
							    		    }
							    		});
						        	 
				    		    	 scene.registerUpdateHandler(t2);/////////////
				    		    }
			    		    	
			    		    }
			    		});
		        	 
		        	 
		        	 
		        	 
		        	 
		        	 Ghost.registerUpdateHandler(terminator);
		        	
		        	 
		        }
		        
		    	
		        
		        return true;
		    }
		};
		scene.registerTouchArea(Ghost);
		scene.setTouchAreaBindingOnActionDownEnabled(true);
		scene.attachChild(Ghost);
		
		
		scene.attachChild(Bomb);
		Bomb.setVisible(false);
		
		
		Tap = new Sprite(Ghost.getX()+ (60 ), Ghost.getY()+ (120 ), this.mTap, getVertexBufferObjectManager());
		scene.attachChild(Tap);
		
		 Taper = new Timer(0.01, new Timer.ITimerCallback() {
 		    public void onTick() {
  		    	counter++;
 		    	if(counter>5){
 		    		Tap.setWidth(262);
 	 		    	Tap.setHeight(358);
 	 		    	Tap.setPosition(Ghost.getX()+ (60 ), Ghost.getY()+ (120 ));
 	 		    	if(counter>100)
 	 		    		counter=0;
 	 		    	h=358;
 	 		    	w=262;
 		    	}
 		    		//scene.unregisterUpdateHandler(Taper);
 		    	else{
 		    		h+=10;
 		    		w+=10;
 		    	
 		    		Tap.setWidth(w);
 		    		Tap.setHeight(h);
		    	 
 		    		Tap.setPosition(Tap.getX()- (5 ),Tap.getY()- (5 ));
 		    	}
 		    	//scene.detachChild(Ghost);	
 		    	
 		    }
 		});
		
		 scene.registerUpdateHandler(Taper);
		 
		 
		 
		 Window = new Sprite(0,0, this.mWindow, getVertexBufferObjectManager());
//		scene.attachChild(Window);
		 
		 Share = new Sprite( (558 ), (1002 ), this.mShare, getVertexBufferObjectManager()){
			    @Override
			    public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float pTouchAreaLocalY) {
			        scene.detachChild(Share);
			    	if (pSceneTouchEvent.getAction() == TouchEvent.ACTION_UP) {		        	
			        	scene.attachChild(Share);
			        
			        }
			        return true;
			    }
			};
		 
		 
		 
		 
		 
		 Reset = new Sprite( (189 ), (1002 ), this.mReset, getVertexBufferObjectManager()){
			    @Override
			    public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float pTouchAreaLocalY) {
			       scene.detachChild(Reset);
			    	if (pSceneTouchEvent.getAction() == TouchEvent.ACTION_UP) {		        	
			        	scene.attachChild(Reset);
			        	
			        	GameActivity.this.startActivity(new Intent(GameActivity.this, GameActivity.class));
						
			        	GameActivity.this.finish();
						
			        
			        }
			        return true;
			    }
			};
		
			
			text=new Text( (650 ), (25 ),font,"0",50,this.getVertexBufferObjectManager());
			scene.attachChild(text);
			text2=new Text( (663 ), (800 ),font2,"0",50,this.getVertexBufferObjectManager());
		 
			text3=new Text( (663 ), (655 ),font2,"0",50,this.getVertexBufferObjectManager());
		return scene;
	}
	
	public static int randInt(int min, int max){
	    Random rand = new Random();
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}

}