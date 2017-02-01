package com.example.k_map;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class KmapEntry extends ActionBarActivity {

	public static final String KEY="key";
	int scoreX=0,scoreY=0; 
	int [][] refrence=new int[4][5];
	Button [][] b=new Button[4][5];
	Button bR,bU;
	TextView t1,t2,t3,t4,t5;
	int pSel=1;int c=0;
	int m=0,n=0;
	int [][] mat=new int[4][5];
	boolean [][] occ=new boolean[4][5];
	boolean [][] lock=new boolean[4][5];
	boolean undoF=false;
	boolean execption=false;
	boolean scoreAdded=false;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_kmap_entry);
		getActionBar().hide();
		int key=0;
		for(int i=0;i<4;i++)
			for(int j=0;j<5;j++){
				occ[i][j]=false;
				lock[i][j]=false;
				mat[i][j]=9;
				refrence[i][j]=key++;
			}
		
		
		b[0][0]=(Button)findViewById(R.id.Button15);
		b[0][1]=(Button)findViewById(R.id.Button16);
		b[0][2]=(Button)findViewById(R.id.Button17);
		b[0][3]=(Button)findViewById(R.id.Button18);
		b[0][4]=(Button)findViewById(R.id.Button19);
		
		b[1][0]=(Button)findViewById(R.id.Button12);
		b[1][1]=(Button)findViewById(R.id.Button11);
		b[1][2]=(Button)findViewById(R.id.Button10);
		b[1][3]=(Button)findViewById(R.id.Button13);
		b[1][4]=(Button)findViewById(R.id.Button14);
		
		b[2][0]=(Button)findViewById(R.id.Button07);
		b[2][1]=(Button)findViewById(R.id.Button06);
		b[2][2]=(Button)findViewById(R.id.Button05);
		b[2][3]=(Button)findViewById(R.id.Button08);
		b[2][4]=(Button)findViewById(R.id.Button09);
		
		b[3][0]=(Button)findViewById(R.id.Button03);
		b[3][1]=(Button)findViewById(R.id.Button02);
		b[3][2]=(Button)findViewById(R.id.button1);
		b[3][3]=(Button)findViewById(R.id.Button01);
		b[3][4]=(Button)findViewById(R.id.Button04);
		
		bR=(Button)findViewById(R.id.button3);
		bU=(Button)findViewById(R.id.button2);
		
		
		t1=(TextView)findViewById(R.id.textView1);
		t2=(TextView)findViewById(R.id.TextView03);
		
		t3=(TextView)findViewById(R.id.textView5);
		t4=(TextView)findViewById(R.id.textView6);
		t5=(TextView)findViewById(R.id.textView7);
		
		
		bU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	if(undoF)
            	  pSel*=-1;
            	undoF=false;
            	occ[m][n]=false;
            	b[m][n].setBackgroundResource(R.drawable.tile);
            }
        });
		
		 bR.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
             	undoF=true;
            	pSel=1;
             	for(int i=0;i<4;i++)
             		for(int j=0;j<5;j++){
             			occ[i][j]=false;
             			mat[i][j]=9;
             			b[i][j].setBackgroundResource(R.drawable.tile);
             		}
             	scoreX=0;
             	scoreY=0;
             	execption=false;
            	t1.setText(String.valueOf(scoreX));
              	t2.setText(String.valueOf(scoreY));
             }
         });
		
		
		 b[0][0].setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
            	  /*for(int i=0;i<4;i++)
          			for(int j=0;j<5;j++)
          				lock[i][j]=false;
          			lock[0][0]=true;*/
            	  undoF=true;
            	  m=0;n=0;
              	if((pSel==1)&&!occ[0][0]==true){
              		b[0][0].setBackgroundResource(R.drawable.x);
              		pSel*=-1;
              		mat[0][0]=1;
              		occ[0][0]=true;
              		HorizontalScoreCalculator(mat,0,0);
                  	VerticalScoreCalculator(mat,0,0);
                  	t1.setText(String.valueOf(scoreX));
                  	t2.setText(String.valueOf(scoreY));
              		
              	}
              	else if((pSel==-1)&& !occ[0][0]){
              		b[0][0].setBackgroundResource(R.drawable.o);
              		pSel*=-1;
              		mat[0][0]=0;
              		occ[0][0]=true;
              		HorizontalScoreCalculator(mat,0,0);
                  	VerticalScoreCalculator(mat,0,0);
                  	t1.setText(String.valueOf(scoreX));
                  	t2.setText(String.valueOf(scoreY));
              	}
              	if(GridCompleated()){
            		if(scoreX>scoreY){
            			 Intent intent = new Intent(KmapEntry.this,Victor.class);
	                  
	                   
                    String string="one";
                    intent.putExtra(KEY,string);
                    startActivity(intent);
            		}
            		else{
            			 Intent intent = new Intent(KmapEntry.this,Victor.class);
   	                  
  	                   
                         String string="two";
                         intent.putExtra(KEY,string);
                         startActivity(intent);
            		}
            			
            	}
              /*	else if(oc==
              		b[0][0].setBackgroundResource(R.drawable.tile);
              		occ[0][0]=false;
              		lock[0][0]=false;
              	}*/
              	
              }
          });
		 
		 b[0][1].setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
            	 m=0;n=1;
            	 undoF=true;
             	if((pSel==1)&&!occ[0][1]){
             		b[0][1].setBackgroundResource(R.drawable.x);
             		pSel*=-1;
             		mat[0][1]=1;
             		occ[0][1]=true;
             		VerticalScoreCalculator(mat,0,1);
                 	HorizontalScoreCalculator(mat,0,1);
             		t1.setText(String.valueOf(scoreX));
                  	t2.setText(String.valueOf(scoreY));
             	}
             	else if((pSel==-1)&&!occ[0][1]){
             		b[0][1].setBackgroundResource(R.drawable.o);
             		pSel*=-1;
             		mat[0][1]=0;
             		occ[0][1]=true;
             		VerticalScoreCalculator(mat,0,1);
                 	HorizontalScoreCalculator(mat,0,1);
             		t1.setText(String.valueOf(scoreX));
                  	t2.setText(String.valueOf(scoreY));
             	}
             	if(GridCompleated()){
            		if(scoreX>scoreY){
            			 Intent intent = new Intent(KmapEntry.this,Victor.class);
	                  
	                   
                    String string="one";
                    intent.putExtra(KEY,string);
                    startActivity(intent);
            		}
            		else{
            			 Intent intent = new Intent(KmapEntry.this,Victor.class);
   	                  
  	                   
                         String string="two";
                         intent.putExtra(KEY,string);
                         startActivity(intent);
            		}
            			
            	}
             
             }
         });
		 b[0][2].setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
            	 m=0;n=2;
            	 undoF=true;
             	if((pSel==1)&&!occ[0][2]){
             		b[0][2].setBackgroundResource(R.drawable.x);
             		pSel*=-1;
             		mat[0][2]=1;
             		occ[0][2]=true;
             		VerticalScoreCalculator(mat,0,2);
                 	HorizontalScoreCalculator(mat,0,2);
                	t1.setText(String.valueOf(scoreX));
                  	t2.setText(String.valueOf(scoreY));
             		
             	}
             	else if((pSel==-1)&&!occ[0][2]){
             		b[0][2].setBackgroundResource(R.drawable.o);
             		pSel*=-1;
             		mat[0][2]=0;
             		occ[0][2]=true;
             		VerticalScoreCalculator(mat,0,2);
                 	HorizontalScoreCalculator(mat,0,2);
                	t1.setText(String.valueOf(scoreX));
                  	t2.setText(String.valueOf(scoreY));
             	}
             	if(GridCompleated()){
            		if(scoreX>scoreY){
            			 Intent intent = new Intent(KmapEntry.this,Victor.class);
	                  
	                   
                    String string="one";
                    intent.putExtra(KEY,string);
                    startActivity(intent);
            		}
            		else{
            			 Intent intent = new Intent(KmapEntry.this,Victor.class);
   	                  
  	                   
                         String string="two";
                         intent.putExtra(KEY,string);
                         startActivity(intent);
            		}
            			
            	}
             
             }
         });
		 b[0][3].setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
            	 m=0;n=3;
            	 undoF=true;
             	if((pSel==1)&&!occ[0][3]){
             		b[0][3].setBackgroundResource(R.drawable.x);
             		pSel*=-1;
             		mat[0][3]=1;
             		occ[0][3]=true;
             		HorizontalScoreCalculator(mat,0,3);
                 	VerticalScoreCalculator(mat,0,3);
                	t1.setText(String.valueOf(scoreX));
                  	t2.setText(String.valueOf(scoreY));
             	}
             	else if((pSel==-1)&&!occ[0][3]){
             		b[0][3].setBackgroundResource(R.drawable.o);
             		pSel*=-1;
             		mat[0][3]=0;
             		occ[0][3]=true;
             		HorizontalScoreCalculator(mat,0,3);
                 	VerticalScoreCalculator(mat,0,3);
                	t1.setText(String.valueOf(scoreX));
                  	t2.setText(String.valueOf(scoreY));
             	}
             	if(GridCompleated()){
            		if(scoreX>scoreY){
            			 Intent intent = new Intent(KmapEntry.this,Victor.class);
	                  
	                   
                    String string="one";
                    intent.putExtra(KEY,string);
                    startActivity(intent);
            		}
            		else{
            			 Intent intent = new Intent(KmapEntry.this,Victor.class);
   	                  
  	                   
                         String string="two";
                         intent.putExtra(KEY,string);
                         startActivity(intent);
            		}
            			
            	}
             
             }
         });
		 b[0][4].setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
            	 m=0;n=4;
            	 undoF=true;
             	if((pSel==1)&&!occ[0][4]){
             		b[0][4].setBackgroundResource(R.drawable.x);
             		pSel*=-1;
             		mat[0][4]=1;
             		occ[0][4]=true;
             		HorizontalScoreCalculator(mat,0,4);
                 	VerticalScoreCalculator(mat,0,4);
                	t1.setText(String.valueOf(scoreX));
                  	t2.setText(String.valueOf(scoreY));
             	}
             	else if((pSel==-1)&&!occ[0][4]){
             		b[0][4].setBackgroundResource(R.drawable.o);
             		pSel*=-1;
             		mat[0][4]=0;
             		occ[0][4]=true;
             		HorizontalScoreCalculator(mat,0,4);
                 	VerticalScoreCalculator(mat,0,4);
                	t1.setText(String.valueOf(scoreX));
                  	t2.setText(String.valueOf(scoreY));
             	}
             	if(GridCompleated()){
            		if(scoreX>scoreY){
            			 Intent intent = new Intent(KmapEntry.this,Victor.class);
	                  
	                   
                    String string="one";
                    intent.putExtra(KEY,string);
                    startActivity(intent);
            		}
            		else{
            			 Intent intent = new Intent(KmapEntry.this,Victor.class);
   	                  
  	                   
                         String string="two";
                         intent.putExtra(KEY,string);
                         startActivity(intent);
            		}
            			
            	}
             
             }
         });
		 //////////////////////////////////////////////////////////////////////////////////
		 //////////////////////////////////////////////////////////////////////////////////
		 b[1][0].setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
           	  /*for(int i=0;i<4;i++)
         			for(int j=0;j<5;j++)
         				lock[i][j]=false;
         			lock[1][0]=true;*/
            	 m=1;n=0;
            	 undoF=true;
             	if((pSel==1)&&!occ[1][0]==true){
             		b[1][0].setBackgroundResource(R.drawable.x);
             		pSel*=-1;
             		mat[1][0]=1;
             		occ[1][0]=true;
             		HorizontalScoreCalculator(mat,1,0);
                 	VerticalScoreCalculator(mat,1,0);
                	t1.setText(String.valueOf(scoreX));
                  	t2.setText(String.valueOf(scoreY));
             	}
             	else if((pSel==-1)&& !occ[1][0]){
             		b[1][0].setBackgroundResource(R.drawable.o);
             		pSel*=-1;
             		mat[1][0]=0;
             		occ[1][0]=true;
             		HorizontalScoreCalculator(mat,1,0);
                 	VerticalScoreCalculator(mat,1,0);
                	t1.setText(String.valueOf(scoreX));
                  	t2.setText(String.valueOf(scoreY));
             	}
             /*	else if(oc==
             		b[1][0].setBackgroundResource(R.drawable.tile);
             		occ[1][0]=false;
             		lock[1][0]=false;
             	}*/
             	if(GridCompleated()){
            		if(scoreX>scoreY){
            			 Intent intent = new Intent(KmapEntry.this,Victor.class);
	                  
	                   
                    String string="one";
                    intent.putExtra(KEY,string);
                    startActivity(intent);
            		}
            		else{
            			 Intent intent = new Intent(KmapEntry.this,Victor.class);
   	                  
  	                   
                         String string="two";
                         intent.putExtra(KEY,string);
                         startActivity(intent);
            		}
            			
            	}
             }
         });
		 
		 b[1][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	m=1;n=1;
            	undoF=true;
            	if((pSel==1)&&!occ[1][1]){
            		b[1][1].setBackgroundResource(R.drawable.x);
            		pSel*=-1;
            		mat[1][1]=1;
            		occ[1][1]=true;
            		HorizontalScoreCalculator(mat,1,1);
                	VerticalScoreCalculator(mat,1,1);
                	t1.setText(String.valueOf(scoreX));
                  	t2.setText(String.valueOf(scoreY));
            	}
            	else if((pSel==-1)&&!occ[1][1]){
            		b[1][1].setBackgroundResource(R.drawable.o);
            		pSel*=-1;
            		mat[1][1]=0;
            		occ[1][1]=true;
            		HorizontalScoreCalculator(mat,1,1);
                	VerticalScoreCalculator(mat,1,1);
                	t1.setText(String.valueOf(scoreX));
                  	t2.setText(String.valueOf(scoreY));
            	}
            	
            	if(GridCompleated()){
            		if(scoreX>scoreY){
            			 Intent intent = new Intent(KmapEntry.this,Victor.class);
	                  
	                   
                    String string="one";
                    intent.putExtra(KEY,string);
                    startActivity(intent);
            		}
            		else{
            			 Intent intent = new Intent(KmapEntry.this,Victor.class);
   	                  
  	                   
                         String string="two";
                         intent.putExtra(KEY,string);
                         startActivity(intent);
            		}
            			
            	}
            }
        });
		 b[1][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	m=1;n=2;
            	undoF=true;
            	if((pSel==1)&&!occ[1][2]){
            		b[1][2].setBackgroundResource(R.drawable.x);
            		pSel*=-1;
            		mat[1][2]=1;
            		occ[1][2]=true;
            		HorizontalScoreCalculator(mat,1,2);
                	VerticalScoreCalculator(mat,1,2);
                	t1.setText(String.valueOf(scoreX));
                  	t2.setText(String.valueOf(scoreY));
            	}
            	else if((pSel==-1)&&!occ[1][2]){
            		b[1][2].setBackgroundResource(R.drawable.o);
            		pSel*=-1;
            		mat[1][2]=0;
            		occ[1][2]=true;
            		HorizontalScoreCalculator(mat,1,2);
                	VerticalScoreCalculator(mat,1,2);
                	t1.setText(String.valueOf(scoreX));
                  	t2.setText(String.valueOf(scoreY));
            	}
            	
            	if(GridCompleated()){
            		if(scoreX>scoreY){
            			 Intent intent = new Intent(KmapEntry.this,Victor.class);
	                  
	                   
                    String string="one";
                    intent.putExtra(KEY,string);
                    startActivity(intent);
            		}
            		else{
            			 Intent intent = new Intent(KmapEntry.this,Victor.class);
   	                  
  	                   
                         String string="two";
                         intent.putExtra(KEY,string);
                         startActivity(intent);
            		}
            			
            	}
            }
        });
		 b[1][3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	m=1;n=3;
            	undoF=true;
            	if((pSel==1)&&!occ[1][3]){
            		b[1][3].setBackgroundResource(R.drawable.x);
            		pSel*=-1;
            		mat[1][3]=1;
            		occ[1][3]=true;
            		HorizontalScoreCalculator(mat,1,3);
                	VerticalScoreCalculator(mat,1,3);
                	t1.setText(String.valueOf(scoreX));
                  	t2.setText(String.valueOf(scoreY));
            	}
            	else if((pSel==-1)&&!occ[1][3]){
            		b[1][3].setBackgroundResource(R.drawable.o);
            		pSel*=-1;
            		mat[1][3]=0;
            		occ[1][3]=true;
            		HorizontalScoreCalculator(mat,1,3);
                	VerticalScoreCalculator(mat,1,3);
                	t1.setText(String.valueOf(scoreX));
                  	t2.setText(String.valueOf(scoreY));
            	}
            	
            	if(GridCompleated()){
            		if(scoreX>scoreY){
            			 Intent intent = new Intent(KmapEntry.this,Victor.class);
	                  
	                   
                    String string="one";
                    intent.putExtra(KEY,string);
                    startActivity(intent);
            		}
            		else{
            			 Intent intent = new Intent(KmapEntry.this,Victor.class);
   	                  
  	                   
                         String string="two";
                         intent.putExtra(KEY,string);
                         startActivity(intent);
            		}
            			
            	}
            }
        });
		 b[1][4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	m=1;n=4;
            	undoF=true;
            	if((pSel==1)&&!occ[1][4]){
            		b[1][4].setBackgroundResource(R.drawable.x);
            		pSel*=-1;
            		mat[1][4]=1;
            		occ[1][4]=true;
            		HorizontalScoreCalculator(mat,1,4);
                	VerticalScoreCalculator(mat,1,4);
                	t1.setText(String.valueOf(scoreX));
                  	t2.setText(String.valueOf(scoreY));
            	}
            	else if((pSel==-1)&&!occ[1][4]){
            		b[1][4].setBackgroundResource(R.drawable.o);
            		pSel*=-1;
            		mat[1][4]=0;
            		occ[1][4]=true;
            		HorizontalScoreCalculator(mat,1,4);
                	VerticalScoreCalculator(mat,1,4);
                	t1.setText(String.valueOf(scoreX));
                  	t2.setText(String.valueOf(scoreY));
            	}
            	if(GridCompleated()){
            		if(scoreX>scoreY){
            			 Intent intent = new Intent(KmapEntry.this,Victor.class);
	                  
	                   
                    String string="one";
                    intent.putExtra(KEY,string);
                    startActivity(intent);
            		}
            		else{
            			 Intent intent = new Intent(KmapEntry.this,Victor.class);
   	                  
  	                   
                         String string="two";
                         intent.putExtra(KEY,string);
                         startActivity(intent);
            		}
            			
            	}
            
            }
        });
		 //////////////////////////////////////////////////////////////////////////////////
		 //////////////////////////////////////////////////////////////////////////////////
		 b[2][0].setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
            	 m=2;n=0;
            	 undoF=true;
           	  /*for(int i=0;i<4;i++)
         			for(int j=0;j<5;j++)
         				lock[i][j]=false;
         			lock[2][0]=true;*/
             	if((pSel==1)&&!occ[2][0]==true){
             		b[2][0].setBackgroundResource(R.drawable.x);
             		pSel*=-1;
             		mat[2][0]=1;
             		occ[2][0]=true;
             		HorizontalScoreCalculator(mat,2,0);
                 	VerticalScoreCalculator(mat,2,0);
                	t1.setText(String.valueOf(scoreX));
                  	t2.setText(String.valueOf(scoreY));
             	}
             	else if((pSel==-1)&& !occ[2][0]){
             		b[2][0].setBackgroundResource(R.drawable.o);
             		pSel*=-1;
             		mat[2][0]=0;
             		occ[2][0]=true;
             		HorizontalScoreCalculator(mat,2,0);
                 	VerticalScoreCalculator(mat,2,0);
                	t1.setText(String.valueOf(scoreX));
                  	t2.setText(String.valueOf(scoreY));
             		
             	}
             	if(GridCompleated()){
            		if(scoreX>scoreY){
            			 Intent intent = new Intent(KmapEntry.this,Victor.class);
	                  
	                   
                    String string="one";
                    intent.putExtra(KEY,string);
                    startActivity(intent);
            		}
            		else{
            			 Intent intent = new Intent(KmapEntry.this,Victor.class);
   	                  
  	                   
                         String string="two";
                         intent.putExtra(KEY,string);
                         startActivity(intent);
            		}
            			
            	}
             }
         });
		 
		 b[2][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	m=2;n=1;
            	undoF=true;
            	if((pSel==1)&&!occ[2][1]){
            		b[2][1].setBackgroundResource(R.drawable.x);
            		pSel*=-1;
            		mat[2][1]=1;
            		occ[2][1]=true;
            		HorizontalScoreCalculator(mat,2,1);
                	VerticalScoreCalculator(mat,2,1);
                	t1.setText(String.valueOf(scoreX));
                  	t2.setText(String.valueOf(scoreY));
            	}
            	else if((pSel==-1)&&!occ[2][1]){
            		b[2][1].setBackgroundResource(R.drawable.o);
            		pSel*=-1;
            		mat[2][1]=0;
            		occ[2][1]=true;
            		HorizontalScoreCalculator(mat,2,1);
                	VerticalScoreCalculator(mat,2,1);
                	t1.setText(String.valueOf(scoreX));
                  	t2.setText(String.valueOf(scoreY));
            	}if(GridCompleated()){
            		if(scoreX>scoreY){
           			 Intent intent = new Intent(KmapEntry.this,Victor.class);
	                  
	                   
                   String string="one";
                   intent.putExtra(KEY,string);
                   startActivity(intent);
           		}
           		else{
           			 Intent intent = new Intent(KmapEntry.this,Victor.class);
  	                  
 	                   
                        String string="two";
                        intent.putExtra(KEY,string);
                        startActivity(intent);
           		}
           			
           	}
            	
            
            }
        });
		 b[2][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	m=2;n=2;
            	undoF=true;
            	if((pSel==1)&&!occ[2][2]){
            		b[2][2].setBackgroundResource(R.drawable.x);
            		pSel*=-1;
            		mat[2][2]=1;
            		occ[2][2]=true;
            		HorizontalScoreCalculator(mat,2,2);
                	VerticalScoreCalculator(mat,2,2);
                	t1.setText(String.valueOf(scoreX));
                  	t2.setText(String.valueOf(scoreY));
            	}
            	else if((pSel==-1)&&!occ[2][2]){
            		b[2][2].setBackgroundResource(R.drawable.o);
            		pSel*=-1;
            		mat[2][2]=0;
            		occ[2][2]=true;
            		HorizontalScoreCalculator(mat,2,2);
                	VerticalScoreCalculator(mat,2,2);
                	t1.setText(String.valueOf(scoreX));
                  	t2.setText(String.valueOf(scoreY));
            	}
            	if(GridCompleated()){
            		if(scoreX>scoreY){
            			 Intent intent = new Intent(KmapEntry.this,Victor.class);
	                  
	                   
                    String string="one";
                    intent.putExtra(KEY,string);
                    startActivity(intent);
            		}
            		else{
            			 Intent intent = new Intent(KmapEntry.this,Victor.class);
   	                  
  	                   
                         String string="two";
                         intent.putExtra(KEY,string);
                         startActivity(intent);
            		}
            			
            	}
            	
            
            }
        });
		 b[2][3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	m=2;n=3;
            	undoF=true;
            	if((pSel==1)&&!occ[2][3]){
            		b[2][3].setBackgroundResource(R.drawable.x);
            		pSel*=-1;
            		mat[2][3]=1;
            		occ[2][3]=true;
            		HorizontalScoreCalculator(mat,2,3);
                	VerticalScoreCalculator(mat,2,3);
                	t1.setText(String.valueOf(scoreX));
                  	t2.setText(String.valueOf(scoreY));
            	}
            	else if((pSel==-1)&&!occ[2][3]){
            		b[2][3].setBackgroundResource(R.drawable.o);
            		pSel*=-1;
            		mat[2][3]=0;
            		occ[2][3]=true;
            		HorizontalScoreCalculator(mat,2,3);
                	VerticalScoreCalculator(mat,2,3);
                	t1.setText(String.valueOf(scoreX));
                  	t2.setText(String.valueOf(scoreY));
            	}
            	if(GridCompleated()){
            		if(scoreX>scoreY){
            			 Intent intent = new Intent(KmapEntry.this,Victor.class);
	                  
	                   
                    String string="one";
                    intent.putExtra(KEY,string);
                    startActivity(intent);
            		}
            		else{
            			 Intent intent = new Intent(KmapEntry.this,Victor.class);
   	                  
  	                   
                         String string="two";
                         intent.putExtra(KEY,string);
                         startActivity(intent);
            		}
            			
            	}
            	
            
            }
        });
		 b[2][4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	m=2;n=4;
            	undoF=true;
            	if((pSel==1)&&!occ[2][4]){
            		b[2][4].setBackgroundResource(R.drawable.x);
            		pSel*=-1;
            		mat[2][4]=1;
            		occ[2][4]=true;
            		HorizontalScoreCalculator(mat,2,4);
                	VerticalScoreCalculator(mat,2,4);
                	t1.setText(String.valueOf(scoreX));
                  	t2.setText(String.valueOf(scoreY));
            	}
            	else if((pSel==-1)&&!occ[2][4]){
            		b[2][4].setBackgroundResource(R.drawable.o);
            		pSel*=-1;
            		mat[2][4]=0;
            		occ[2][4]=true;
            		HorizontalScoreCalculator(mat,2,4);
                	VerticalScoreCalculator(mat,2,4);
                	t1.setText(String.valueOf(scoreX));
                  	t2.setText(String.valueOf(scoreY));
            	}
            	if(GridCompleated()){
            		if(scoreX>scoreY){
            			 Intent intent = new Intent(KmapEntry.this,Victor.class);
	                  
	                   
                    String string="one";
                    intent.putExtra(KEY,string);
                    startActivity(intent);
            		}
            		else{
            			 Intent intent = new Intent(KmapEntry.this,Victor.class);
   	                  
  	                   
                         String string="two";
                         intent.putExtra(KEY,string);
                         startActivity(intent);
            		}
            			
            	}
            
            }
        });
		 //////////////////////////////////////////////////////////////////////////////////
		 //////////////////////////////////////////////////////////////////////////////////
		 b[3][0].setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
            	 m=3;n=0;
            	 undoF=true;
           	  /*for(int i=0;i<4;i++)
         			for(int j=0;j<5;j++)
         				lock[i][j]=false;
         			lock[3][0]=true;*/
             	if((pSel==1)&&!occ[3][0]==true){
             		b[3][0].setBackgroundResource(R.drawable.x);
             		pSel*=-1;
             		mat[3][0]=1;
             		occ[3][0]=true;
             		HorizontalScoreCalculator(mat,3,0);
                 	VerticalScoreCalculator(mat,3,0);
                	t1.setText(String.valueOf(scoreX));
             	}
             	else if((pSel==-1)&& !occ[3][0]){
             		b[3][0].setBackgroundResource(R.drawable.o);
             		pSel*=-1;
             		mat[3][0]=0;
             		occ[3][0]=true;
             		HorizontalScoreCalculator(mat,3,0);
                 	VerticalScoreCalculator(mat,3,0);
                	t1.setText(String.valueOf(scoreX));
             	}
             	if(GridCompleated()){
            		if(scoreX>scoreY){
            			 Intent intent = new Intent(KmapEntry.this,Victor.class);
	                  
	                   
                    String string="one";
                    intent.putExtra(KEY,string);
                    startActivity(intent);
            		}
            		else{
            			 Intent intent = new Intent(KmapEntry.this,Victor.class);
   	                  
  	                   
                         String string="two";
                         intent.putExtra(KEY,string);
                         startActivity(intent);
            		}
            			
            	}
             	
              	t2.setText(String.valueOf(scoreY));
             }
         });
		 
		 b[3][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	m=3;n=1;
            	undoF=true;
            	if((pSel==1)&&!occ[3][1]){
            		b[3][1].setBackgroundResource(R.drawable.x);
            		pSel*=-1;
            		mat[3][1]=1;
            		occ[3][1]=true;
            		HorizontalScoreCalculator(mat,3,1);
                	VerticalScoreCalculator(mat,3,1);
                	t1.setText(String.valueOf(scoreX));
                  	t2.setText(String.valueOf(scoreY));
            	}
            	else if((pSel==-1)&&!occ[3][1]){
            		b[3][1].setBackgroundResource(R.drawable.o);
            		pSel*=-1;
            		mat[3][1]=0;
            		occ[3][1]=true;
            		HorizontalScoreCalculator(mat,3,1);
                	VerticalScoreCalculator(mat,3,1);
                	t1.setText(String.valueOf(scoreX));
                  	t2.setText(String.valueOf(scoreY));
            	}
            	if(GridCompleated()){
            		if(scoreX>scoreY){
            			 Intent intent = new Intent(KmapEntry.this,Victor.class);
	                  
	                   
                    String string="one";
                    intent.putExtra(KEY,string);
                    startActivity(intent);
            		}
            		else{
            			 Intent intent = new Intent(KmapEntry.this,Victor.class);
   	                  
  	                   
                         String string="two";
                         intent.putExtra(KEY,string);
                         startActivity(intent);
            		}
            			
            	}
            	
            
            }
        });
		 b[3][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	m=3;n=2;
            	undoF=true;
            	if((pSel==1)&&!occ[3][2]){
            		b[3][2].setBackgroundResource(R.drawable.x);
            		pSel*=-1;
            		mat[3][2]=1;
            		occ[3][2]=true;
            		HorizontalScoreCalculator(mat,3,2);
                	VerticalScoreCalculator(mat,3,2);
                	t1.setText(String.valueOf(scoreX));
                  	t2.setText(String.valueOf(scoreY));
            	}
            	else if((pSel==-1)&&!occ[3][2]){
            		b[3][2].setBackgroundResource(R.drawable.o);
            		pSel*=-1;
            		mat[3][2]=0;
            		occ[3][2]=true;
            		HorizontalScoreCalculator(mat,3,2);
                	VerticalScoreCalculator(mat,3,2);
                	t1.setText(String.valueOf(scoreX));
                  	t2.setText(String.valueOf(scoreY));
            	}
            	if(GridCompleated()){
            		if(scoreX>scoreY){
            			 Intent intent = new Intent(KmapEntry.this,Victor.class);
	                  
	                   
                    String string="one";
                    intent.putExtra(KEY,string);
                    startActivity(intent);
            		}
            		else{
            			 Intent intent = new Intent(KmapEntry.this,Victor.class);
   	                  
  	                   
                         String string="two";
                         intent.putExtra(KEY,string);
                         startActivity(intent);
            		}
            			
            	}
            	
            
            }
        });
		 b[3][3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	m=3;n=3;
            	undoF=true;
            	if((pSel==1)&&!occ[3][3]){
            		b[3][3].setBackgroundResource(R.drawable.x);
            		pSel*=-1;
            		mat[3][3]=1;
            		occ[3][3]=true;
            		HorizontalScoreCalculator(mat,3,3);
                	VerticalScoreCalculator(mat,3,3);
                	t1.setText(String.valueOf(scoreX));
                  	t2.setText(String.valueOf(scoreY));
            	}
            	else if((pSel==-1)&&!occ[3][3]){
            		b[3][3].setBackgroundResource(R.drawable.o);
            		pSel*=-1;
            		mat[3][3]=0;
            		occ[3][3]=true;
            		HorizontalScoreCalculator(mat,3,3);
                	VerticalScoreCalculator(mat,3,3);
                	t1.setText(String.valueOf(scoreX));
                  	t2.setText(String.valueOf(scoreY));
            	}
            	if(GridCompleated()){
            		if(scoreX>scoreY){
            			 Intent intent = new Intent(KmapEntry.this,Victor.class);
	                  
	                   
                    String string="one";
                    intent.putExtra(KEY,string);
                    startActivity(intent);
            		}
            		else{
            			 Intent intent = new Intent(KmapEntry.this,Victor.class);
   	                  
  	                   
                         String string="two";
                         intent.putExtra(KEY,string);
                         startActivity(intent);
            		}
            			
            	}
            	
            
            }
        });
		 b[3][4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	m=3;n=4;
            	undoF=true;
            	if((pSel==1)&&!occ[3][4]){
            		b[3][4].setBackgroundResource(R.drawable.x);
            		pSel*=-1;
            		mat[3][4]=1;
            		occ[3][4]=true;
            		HorizontalScoreCalculator(mat,3,4);
                	VerticalScoreCalculator(mat,3,4);
                	t1.setText(String.valueOf(scoreX));
                  	t2.setText(String.valueOf(scoreY));
            	}
            	else if((pSel==-1)&&!occ[3][4]){
            		b[3][4].setBackgroundResource(R.drawable.o);
            		pSel*=-1;
            		mat[3][4]=0;
            		occ[3][4]=true;
            		HorizontalScoreCalculator(mat,3,4);
                	VerticalScoreCalculator(mat,3,4);
                	t1.setText(String.valueOf(scoreX));
                  	t2.setText(String.valueOf(scoreY));
            	}
            	
            	if(GridCompleated()){
            		if(scoreX>scoreY){
            			 Intent intent = new Intent(KmapEntry.this,Victor.class);
	                  
	                   
                    String string="one";
                    intent.putExtra(KEY,string);
                    startActivity(intent);
            		}
            		else{
            			 Intent intent = new Intent(KmapEntry.this,Victor.class);
   	                  
  	                   
                         String string="two";
                         intent.putExtra(KEY,string);
                         startActivity(intent);
            		}
            			
            	}
            	
            
            }
        });
		
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	void VerticalScoreCalculator(int mat[][],int i,int j){
		BoxOrderFourCalculator(mat,i,j);
		int initialIval=i,VerticalCount=0;
		int player=mat[i][j];
		boolean circle=false;
		if(mat[i][j]==player){
			i++;
			if(i==4)
				i=0;
			while(true){
				if(mat[i][j]==player){
					VerticalCount++;
					if(circle)
						if(i==initialIval){
							circle=false;
							if(player==1)
								scoreX+=2;
							else if(player==0)
								scoreY+=2;
							break;
						}
					i++;
					if(VerticalCount==2)
						if(player==1)
							scoreX++;
						else if(player==0)
							scoreY++;
					if(VerticalCount==3)
						if(player==1)
							scoreX+=2;
						else if(player==0)
							scoreY+=2;
					if(i==4){
						i=0;
						circle=true;
					}	
				}
				else
					break;
			}
			i=initialIval;
			i--;
			if(i==-1)
				i=3;
			while(true){
				if(mat[i][j]==player){
					VerticalCount++;
					if(circle)
						if(i==initialIval){
							circle=false;
							break;
						}
					i--;
					if(VerticalCount==2)
						if(player==1)
							scoreX++;
						else if(player==0)
							scoreY++;
					if(VerticalCount==3)
						if(player==1)
							scoreX+=2;
						else if(player==0)
							scoreY+=2;
					if(i==-1){
						i=3;
						circle=true;
					}	
				}
				else
					break;	
			}	
		}
	}
	
	
	void Zeus(int mat[][],int aa,int bb){
		
		
		int AdjecentLocations=0;
		int N,NE,E,SE,S,SW,W,NW;
		int player =mat[aa][bb];
		int x,y;
		if(aa==3)
			x=0;
		else{
			x=++aa;
			aa--;
		}
		if(bb==0)
			y=4;
		else{
			y=--bb;
			bb++;
		}
		SW=refrence[x][y];
		if(aa==3)
			x=0;
		else{
			x=++aa;
			aa--;
		}
		if(bb==4)
			y=0;
		else{
			y=++bb;
			bb--;
		}
		SE=refrence[x][y];
		if(aa==0)
			x=3;
		else{
			x=--aa;
			aa++;
		}
		if(bb==0)
			y=4;
		else{
			y=--bb;
			bb++;
		}
		NW=refrence[x][y];
		if(aa==0)
			x=3;
		else{
			x=--aa;
			aa++;
		}
		if(bb==4)
			y=0;
		else{
			y=++bb;
			bb--;
		}
		NE=refrence[x][y];
		if(aa==0)
			N=refrence[3][bb];
		else{
			N=refrence[--aa][bb];
			aa++;
		}
		if(aa==3)
			S=refrence[0][bb];
		else{
			S=refrence[++aa][bb];
			aa--;
		}
		if(bb==4)
			E=refrence[aa][0];
		else{
			E=refrence[aa][++bb];
			bb--;
		}
		if(bb==0)
			W=refrence[aa][4];
		else{
			W=refrence[aa][--bb];
			bb++;
		}
		
		if(player==N)
			AdjecentLocations++;
		
		if(player==S)
			AdjecentLocations++;
		
		if(player==E)
			AdjecentLocations++;
		
		if(player==W)
			AdjecentLocations++;
	
		int []Adjecent=new int[AdjecentLocations];
		
		//for(int i=0;i<AdjecentLocations;i++)
		//	if()
		
	
		String aaa=" ";
		aaa+="    "+String.valueOf(N);
		
		aaa+="    "+String.valueOf(S);
		
		aaa+="    "+String.valueOf(E);
		
		aaa+="    "+String.valueOf(W);
		
		aaa+="    "+String.valueOf(NE);
		
		aaa+="    "+String.valueOf(NW);
		
		
		aaa+="\n    "+String.valueOf(SE);
		aaa+="    "+String.valueOf(SW);
		//aa++;
		//aaa+="    "+String.valueOf(S);
		
		//aaa+="    "+String.valueOf(N);
		
	
		
		
		t4.setText(aaa);
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	void BoxOrderFourCalculator(int mat[][],int aa,int bb){
		
		int N,NE,E,SE,S,SW,W,NW;
		int player =mat[aa][bb];
		int x,y;
		if(aa==3)
			x=0;
		else{
			x=++aa;
			aa--;
		}
		if(bb==0)
			y=4;
		else{
			y=--bb;
			bb++;
		}
		SW=mat[x][y];
		if(aa==3)
			x=0;
		else{
			x=++aa;
			aa--;
		}
		if(bb==4)
			y=0;
		else{
			y=++bb;
			bb--;
		}
		SE=mat[x][y];
		if(aa==0)
			x=3;
		else{
			x=--aa;
			aa++;
		}
		if(bb==0)
			y=4;
		else{
			y=--bb;
			bb++;
		}
		NW=mat[x][y];
		if(aa==0)
			x=3;
		else{
			x=--aa;
			aa++;
		}
		if(bb==4)
			y=0;
		else{
			y=++bb;
			bb--;
		}
		NE=mat[x][y];
		if(aa==0)
			N=mat[3][bb];
		else{
			N=mat[--aa][bb];
			aa++;
		}
		if(aa==3)
			S=mat[0][bb];
		else{
			S=mat[++aa][bb];
			aa--;
		}
		if(bb==4)
			E=mat[aa][0];
		else{
			E=mat[aa][++bb];
			bb--;
		}
		if(bb==0)
			W=mat[aa][4];
		else{
			W=mat[aa][--bb];
			bb++;
		}
	
		
		if(player==N&&player==NE&&player==E)
			if(player==1)
				scoreX+=2;
			else
				scoreY+=2;
		
		if(player==N&&player==NW&&player==W)
			if(player==1)
				scoreX+=2;
			else
				scoreY+=2;
		
		if(player==S&&player==SE&&player==E)
			if(player==1)
				scoreX+=2;
			else
				scoreY+=2;
		
		if(player==S&&player==SW&&player==W)
			if(player==1)
				scoreX+=2;
			else
				scoreY+=2;
		
		
		
		
		
	
		
		String aaa=" ",bbb=" ";
		//aaa=String.valueOf(aa);
		//bbb=String.valueOf(bb);
		bbb+="    "+String.valueOf(aa);
		//bb--;
		bbb+="    "+String.valueOf(bb);
		
	
		t5.setText(bbb);
		
		
		String a=" ";
		for(int i=0;i<4;i++){
			for(int j=0;j<5;j++)
				a+=mat[i][j]+" ";
			a+="\n ";
		}
		t3.setText(a);
		
		Zeus(mat,aa,bb);
	}
	
	
	
	
	
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	boolean GridCompleated(){
		
		for(int i=0;i<4;i++)
			for(int j=0;j<5;j++)
				if(!occ[i][j])
					return false;
		
		return false;
	}
	
	
	void HorizontalScoreCalculator(int mat[][],int i,int j){
		int initialJval=j;
		int HorizontalCount=0;
		int player=mat[i][j];
		boolean circle=false,switchSides=false,direct=true,entry=false;;
		if(mat[i][j]==player){
			j++;
			if(j==5)
				j=0;
			while(true){
				if(mat[i][j]==player){
					entry=true;
					HorizontalCount++;
					if(circle)
						if(j==initialJval){
							if(player==1){
								scoreX=999;
								 Intent intent = new Intent(KmapEntry.this,Victor.class);
				                  
				                   
				                    String string="one";
				                    intent.putExtra(KEY,string);
				                    startActivity(intent);
							}
							else if(player==0){
								scoreY=999;
								Intent intent = new Intent(KmapEntry.this,Victor.class);
				                  
				                   
			                    String string="two";
			                    intent.putExtra(KEY,string);
			                    startActivity(intent);
							}
							circle=false;
							break;
						}
					j++;
					if(HorizontalCount==2)
						if(player==1)
							scoreX++;
						else if(player==0)
							scoreY++;
					if(HorizontalCount==3){
						if(player==1)
							scoreX+=2;
						else if(player==0)
							scoreY+=2;
						if(circle)
							if(player==1)
								scoreX++;
							else if(player==0)
								scoreY++;
					}
					if(j==5){
						j=0;
						circle=true;
					}
				}
				else{
					if(!entry)
						direct=true;
					break;
				}
			}
			j=initialJval;
			j--;
			if(j==-1)
				j=4;
			while(true){
				if(mat[i][j]==player){
					while(!direct){
						switchSides=true;
						direct=false;
					}
					if(entry)
						switchSides=true;
					HorizontalCount++;
					if(circle)
						if(j==initialJval){
							if(player==1)
								scoreX=999;
							else if(player==0)
								scoreY=999;
							circle=false;
							break;
						}
					j--;
					if(HorizontalCount==2)
						if(player==1)
							scoreX++;
						else if(player==0)
							scoreY++;
					if(HorizontalCount==3){
						if(player==1)
							scoreX+=2;
						else if(player==0)
							scoreY+=2;
						if(circle||switchSides){
							if(player==1)
								scoreX++;
							else if(player==0)
								scoreY++;	
							switchSides=false;
						}
					}
					if(j==-1){
						j=4;
						circle=true;
					}
				}
				else
					break;	
			}		
		}	
	}
}
