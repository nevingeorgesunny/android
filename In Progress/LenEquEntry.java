package com.example.lenequ;



import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LenEquEntry extends ActionBarActivity {
	
	Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,bPoint,bN,bANS,bHelp,bB;
	String [][] s=new String[3][4];
	
	TextView [][] t=new TextView[3][4];
	boolean[][] flag = new boolean[3][4];
	boolean[][] occFlag=new boolean[3][4];
	boolean firstMatInputed=false,secondMatInputed=false,negFlag=false;;
	double[][] mat=new double[3][3];
	double[][] mat2=new double[3][1];
	double[][] ans=new double[3][1];
	int a,b,i,j;
	Button[] num=new Button[10];
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getActionBar().hide();
		setContentView(R.layout.activity_len_equ_entry);
		occFlag[0][0]=true;
		
		for(a=0;a<3;a++)
			for(b=0;b<4;b++)
				s[a][b]=" ";
		
		b1=(Button)findViewById(R.id.button1);
		b2=(Button)findViewById(R.id.Button01);
		b3=(Button)findViewById(R.id.Button02);
		b4=(Button)findViewById(R.id.Button03);
		b5=(Button)findViewById(R.id.Button04);
		b6=(Button)findViewById(R.id.Button05);
		b7=(Button)findViewById(R.id.Button06);
		b8=(Button)findViewById(R.id.Button07);
		b9=(Button)findViewById(R.id.Button08);
		b0=(Button)findViewById(R.id.Button09);
		bB=(Button)findViewById(R.id.Button12);
				
		
		bANS=(Button)findViewById(R.id.button3);
		bN=(Button)findViewById(R.id.Button11);
		bHelp=(Button)findViewById(R.id.button2);
		bPoint=(Button)findViewById(R.id.Button10);
		
		t[0][0]=(TextView)findViewById(R.id.editText1);
		t[0][1]=(TextView)findViewById(R.id.EditText01);
		t[0][2]=(TextView)findViewById(R.id.EditText03);
		t[0][3]=(TextView)findViewById(R.id.EditText04);
		
		t[1][0]=(TextView)findViewById(R.id.EditText02);
		t[1][1]=(TextView)findViewById(R.id.EditText05);
		t[1][2]=(TextView)findViewById(R.id.EditText06);
		t[1][3]=(TextView)findViewById(R.id.EditText07);
		
		t[2][0]=(TextView)findViewById(R.id.EditText08);
		t[2][1]=(TextView)findViewById(R.id.EditText09);
		t[2][2]=(TextView)findViewById(R.id.EditText10);
		t[2][3]=(TextView)findViewById(R.id.EditText11);
		
		
		t[0][0].setOnClickListener(new View.OnClickListener() {

             @Override
             public void onClick(View v) {
             
            	 
            	 for(int i=0;i<3;i++)
             		for(int j=0;j<4;j++){
             		
             			  t[i][j].setBackgroundResource(R.drawable.mat2);
             			
             		}
            	 
            	 
            	
            	 t[0][0].setBackgroundResource(R.drawable.mb);
        	
             }
         }); 
		
		
		t[0][1].setOnFocusChangeListener(new OnFocusChangeListener() {          
			public void onFocusChange(View v, boolean hasFocus) {
				if(hasFocus){
					for(a=0;a<3;a++)
						for(b=0;b<4;b++)
							occFlag[a][b]=false;
					occFlag[0][1]=true;
				}
			}
		});
		t[0][2].setOnFocusChangeListener(new OnFocusChangeListener() {          
			public void onFocusChange(View v, boolean hasFocus) {
				if(hasFocus){
					for(a=0;a<3;a++)
						for(b=0;b<4;b++)
							occFlag[a][b]=false;
					occFlag[0][2]=true;
				}
			}
		});
		t[0][3].setOnFocusChangeListener(new OnFocusChangeListener() {          
			public void onFocusChange(View v, boolean hasFocus) {
				if(hasFocus){
					for(a=0;a<3;a++)
						for(b=0;b<4;b++)
							occFlag[a][b]=false;
					occFlag[0][3]=true;
				}
			}
		});
	
////////////////////////////////////////////////////////////////////////////////////////
		t[1][0].setOnFocusChangeListener(new OnFocusChangeListener() {          
			public void onFocusChange(View v, boolean hasFocus) {
				if(hasFocus){
					for(a=0;a<3;a++)
						for(b=0;b<4;b++)
							occFlag[a][b]=false;
					occFlag[1][0]=true;
				}
			}
		});
		t[1][1].setOnFocusChangeListener(new OnFocusChangeListener() {          
			public void onFocusChange(View v, boolean hasFocus) {
				if(hasFocus){
					for(a=0;a<3;a++)
						for(b=0;b<4;b++)
							occFlag[a][b]=false;
					occFlag[1][1]=true;
				}
			}
		});
		t[1][2].setOnFocusChangeListener(new OnFocusChangeListener() {          
			public void onFocusChange(View v, boolean hasFocus) {
				if(hasFocus){
					for(a=0;a<3;a++)
						for(b=0;b<4;b++)
							occFlag[a][b]=false;
					occFlag[1][2]=true;
				}
			}
		});
		t[1][3].setOnFocusChangeListener(new OnFocusChangeListener() {          
			public void onFocusChange(View v, boolean hasFocus) {
				if(hasFocus){
					for(a=0;a<3;a++)
						for(b=0;b<4;b++)
							occFlag[a][b]=false;
					occFlag[1][3]=true;
				}
			}
		});
///////////////////////////////////////////////////////////////////////////////////////////
		
		t[2][0].setOnFocusChangeListener(new OnFocusChangeListener() {          
			public void onFocusChange(View v, boolean hasFocus) {
				if(hasFocus){
					for(a=0;a<3;a++)
						for(b=0;b<4;b++)
							occFlag[a][b]=false;
					occFlag[2][0]=true;
				}
			}
		});
		t[2][1].setOnFocusChangeListener(new OnFocusChangeListener() {          
			public void onFocusChange(View v, boolean hasFocus) {
				if(hasFocus){
					for(a=0;a<3;a++)
						for(b=0;b<4;b++)
							occFlag[a][b]=false;
					occFlag[2][1]=true;
				}
			}
		});
		t[2][2].setOnFocusChangeListener(new OnFocusChangeListener() {          
			public void onFocusChange(View v, boolean hasFocus) {
				if(hasFocus){
					for(a=0;a<3;a++)
						for(b=0;b<4;b++)
							occFlag[a][b]=false;
					occFlag[2][2]=true;
				}
			}
		});
		t[2][3].setOnFocusChangeListener(new OnFocusChangeListener() {          
			public void onFocusChange(View v, boolean hasFocus) {
				if(hasFocus){
					for(a=0;a<3;a++)
						for(b=0;b<4;b++)
							occFlag[a][b]=false;
					occFlag[2][3]=true;
				}
			}
		});
/////////////////////////////////////////////////////////////////////////////////////////		
	
		
		b1.setOnClickListener(new View.OnClickListener() {
			@Override
               public void onClick(View v) {
               
				if(occFlag[0][0]){
					s[0][0]+="1";         	
					t[0][0].setText(s[0][0]);flag[0][0]=true;
				}
				if(occFlag[0][1]){
					s[0][1]+="1";         	
					t[0][1].setText(s[0][1]);flag[0][1]=true;
				}
				if(occFlag[0][2]){
					s[0][2]+="1";         	
					t[0][2].setText(s[0][2]);flag[0][2]=true;
				}
				if(occFlag[0][3]){
					s[0][3]+="1";         	
					t[0][3].setText(s[0][3]);flag[0][3]=true;
				}
				if(occFlag[1][0]){
					s[1][0]+="1";         	
					t[1][0].setText(s[1][0]);flag[1][0]=true;
				}
				if(occFlag[1][1]){
					s[1][1]+="1";         	
					t[1][1].setText(s[1][1]);flag[1][1]=true;
				}
				if(occFlag[1][2]){
					s[1][2]+="1";         	
					t[1][2].setText(s[1][2]);flag[1][2]=true;
				}
				if(occFlag[1][3]){
					s[1][3]+="1";         	
					t[1][3].setText(s[1][3]);flag[1][3]=true;
				}
				if(occFlag[2][0]){
					s[2][0]+="1";         	
					t[2][0].setText(s[2][0]);flag[2][0]=true;
				}
				if(occFlag[2][1]){
					s[2][1]+="1";         	
					t[2][1].setText(s[2][1]);flag[2][1]=true;
				}
				if(occFlag[2][2]){
					s[2][2]+="1";         	
					t[2][2].setText(s[2][2]);flag[2][2]=true;
				}
				if(occFlag[2][3]){
					s[2][3]+="1";         	
					t[2][3].setText(s[2][3]);flag[2][3]=true;
				}
				
               }
           }); 
		
		
		b2.setOnClickListener(new View.OnClickListener() {
			@Override
               public void onClick(View v) {
               
				if(occFlag[0][0]){
					s[0][0]+="2";         	
					t[0][0].setText(s[0][0]);flag[0][0]=true;
				}
				if(occFlag[0][1]){
					s[0][1]+="2";         	
					t[0][1].setText(s[0][1]);flag[0][1]=true;
				}
				if(occFlag[0][2]){
					s[0][2]+="2";         	
					t[0][2].setText(s[0][2]);flag[0][2]=true;
				}
				if(occFlag[0][3]){
					s[0][3]+="2";         	
					t[0][3].setText(s[0][3]);flag[0][3]=true;
				}
				if(occFlag[1][0]){
					s[1][0]+="2";         	
					t[1][0].setText(s[1][0]);flag[1][0]=true;
				}
				if(occFlag[1][1]){
					s[1][1]+="2";         	
					t[1][1].setText(s[1][1]);flag[1][1]=true;
				}
				if(occFlag[1][2]){
					s[1][2]+="2";         	
					t[1][2].setText(s[1][2]);flag[1][2]=true;
				}
				if(occFlag[1][3]){
					s[1][3]+="2";         	
					t[1][3].setText(s[1][3]);flag[1][3]=true;
				}
				if(occFlag[2][0]){
					s[2][0]+="2";         	
					t[2][0].setText(s[2][0]);flag[2][0]=true;
				}
				if(occFlag[2][1]){
					s[2][1]+="2";         	
					t[2][1].setText(s[2][1]);flag[2][1]=true;
				}
				if(occFlag[2][2]){
					s[2][2]+="2";         	
					t[2][2].setText(s[2][2]);flag[2][2]=true;
				}
				if(occFlag[2][3]){
					s[2][3]+="2";         	
					t[2][3].setText(s[2][3]);flag[2][3]=true;
				}
				
               }
           }); 
		
		
		b3.setOnClickListener(new View.OnClickListener() {
			@Override
               public void onClick(View v) {
               
				if(occFlag[0][0]){
					s[0][0]+="3";         	
					t[0][0].setText(s[0][0]);flag[0][0]=true;
				}
				if(occFlag[0][1]){
					s[0][1]+="3";         	
					t[0][1].setText(s[0][1]);flag[0][1]=true;
				}
				if(occFlag[0][2]){
					s[0][2]+="3";         	
					t[0][2].setText(s[0][2]);flag[0][2]=true;
				}
				if(occFlag[0][3]){
					s[0][3]+="3";         	
					t[0][3].setText(s[0][3]);flag[0][3]=true;
				}
				if(occFlag[1][0]){
					s[1][0]+="3";         	
					t[1][0].setText(s[1][0]);flag[1][0]=true;
				}
				if(occFlag[1][1]){
					s[1][1]+="3";         	
					t[1][1].setText(s[1][1]);flag[1][1]=true;
				}
				if(occFlag[1][2]){
					s[1][2]+="3";         	
					t[1][2].setText(s[1][2]);flag[1][2]=true;
				}
				if(occFlag[1][3]){
					s[1][3]+="3";         	
					t[1][3].setText(s[1][3]);flag[1][3]=true;
				}
				if(occFlag[2][0]){
					s[2][0]+="3";         	
					t[2][0].setText(s[2][0]);flag[2][0]=true;
				}
				if(occFlag[2][1]){
					s[2][1]+="3";         	
					t[2][1].setText(s[2][1]);flag[2][1]=true;
				}
				if(occFlag[2][2]){
					s[2][2]+="3";         	
					t[2][2].setText(s[2][2]);flag[2][2]=true;
				}
				if(occFlag[2][3]){
					s[2][3]+="3";         	
					t[2][3].setText(s[2][3]);flag[2][3]=true;
				}
				
               }
           }); 
		
		
		b4.setOnClickListener(new View.OnClickListener() {
			@Override
               public void onClick(View v) {
               
				if(occFlag[0][0]){
					s[0][0]+="4";         	
					t[0][0].setText(s[0][0]);flag[0][0]=true;
				}
				if(occFlag[0][1]){
					s[0][1]+="4";         	
					t[0][1].setText(s[0][1]);flag[0][1]=true;
				}
				if(occFlag[0][2]){
					s[0][2]+="4";         	
					t[0][2].setText(s[0][2]);flag[0][2]=true;
				}
				if(occFlag[0][3]){
					s[0][3]+="4";         	
					t[0][3].setText(s[0][3]);flag[0][3]=true;
				}
				if(occFlag[1][0]){
					s[1][0]+="4";         	
					t[1][0].setText(s[1][0]);flag[1][0]=true;
				}
				if(occFlag[1][1]){
					s[1][1]+="4";         	
					t[1][1].setText(s[1][1]);flag[1][1]=true;
				}
				if(occFlag[1][2]){
					s[1][2]+="4";         	
					t[1][2].setText(s[1][2]);flag[1][2]=true;
				}
				if(occFlag[1][3]){
					s[1][3]+="4";         	
					t[1][3].setText(s[1][3]);flag[1][3]=true;
				}
				if(occFlag[2][0]){
					s[2][0]+="4";         	
					t[2][0].setText(s[2][0]);flag[2][0]=true;
				}
				if(occFlag[2][1]){
					s[2][1]+="4";         	
					t[2][1].setText(s[2][1]);flag[2][1]=true;
				}
				if(occFlag[2][2]){
					s[2][2]+="4";         	
					t[2][2].setText(s[2][2]);flag[2][2]=true;
				}
				if(occFlag[2][3]){
					s[2][3]+="4";         	
					t[2][3].setText(s[2][3]);flag[2][3]=true;
				}
				
               }
           }); 
		
		
		b5.setOnClickListener(new View.OnClickListener() {
			@Override
               public void onClick(View v) {
               
				if(occFlag[0][0]){
					s[0][0]+="5";         	
					t[0][0].setText(s[0][0]);flag[0][0]=true;
				}
				if(occFlag[0][1]){
					s[0][1]+="5";         	
					t[0][1].setText(s[0][1]);flag[0][1]=true;
				}
				if(occFlag[0][2]){
					s[0][2]+="5";         	
					t[0][2].setText(s[0][2]);flag[0][2]=true;
				}
				if(occFlag[0][3]){
					s[0][3]+="5";         	
					t[0][3].setText(s[0][3]);flag[0][3]=true;
				}
				if(occFlag[1][0]){
					s[1][0]+="5";         	
					t[1][0].setText(s[1][0]);flag[1][0]=true;
				}
				if(occFlag[1][1]){
					s[1][1]+="5";         	
					t[1][1].setText(s[1][1]);flag[1][1]=true;
				}
				if(occFlag[1][2]){
					s[1][2]+="5";         	
					t[1][2].setText(s[1][2]);flag[1][2]=true;
				}
				if(occFlag[1][3]){
					s[1][3]+="5";         	
					t[1][3].setText(s[1][3]);flag[1][3]=true;
				}
				if(occFlag[2][0]){
					s[2][0]+="5";         	
					t[2][0].setText(s[2][0]);flag[2][0]=true;
				}
				if(occFlag[2][1]){
					s[2][1]+="5";         	
					t[2][1].setText(s[2][1]);flag[2][1]=true;
				}
				if(occFlag[2][2]){
					s[2][2]+="5";         	
					t[2][2].setText(s[2][2]);flag[2][2]=true;
				}
				if(occFlag[2][3]){
					s[2][3]+="5";         	
					t[2][3].setText(s[2][3]);flag[2][3]=true;
				}
				
               }
           }); 
		
		
		b6.setOnClickListener(new View.OnClickListener() {
			@Override
               public void onClick(View v) {
               
				if(occFlag[0][0]){
					s[0][0]+="6";         	
					t[0][0].setText(s[0][0]);flag[0][0]=true;
				}
				if(occFlag[0][1]){
					s[0][1]+="6";         	
					t[0][1].setText(s[0][1]);flag[0][1]=true;
				}
				if(occFlag[0][2]){
					s[0][2]+="6";         	
					t[0][2].setText(s[0][2]);flag[0][2]=true;
				}
				if(occFlag[0][3]){
					s[0][3]+="6";         	
					t[0][3].setText(s[0][3]);flag[0][3]=true;
				}
				if(occFlag[1][0]){
					s[1][0]+="6";         	
					t[1][0].setText(s[1][0]);flag[1][0]=true;
				}
				if(occFlag[1][1]){
					s[1][1]+="6";         	
					t[1][1].setText(s[1][1]);flag[1][1]=true;
				}
				if(occFlag[1][2]){
					s[1][2]+="6";         	
					t[1][2].setText(s[1][2]);flag[1][2]=true;
				}
				if(occFlag[1][3]){
					s[1][3]+="6";         	
					t[1][3].setText(s[1][3]);flag[1][3]=true;
				}
				if(occFlag[2][0]){
					s[2][0]+="6";         	
					t[2][0].setText(s[2][0]);flag[2][0]=true;
				}
				if(occFlag[2][1]){
					s[2][1]+="6";         	
					t[2][1].setText(s[2][1]);flag[2][1]=true;
				}
				if(occFlag[2][2]){
					s[2][2]+="6";         	
					t[2][2].setText(s[2][2]);flag[2][2]=true;
				}
				if(occFlag[2][3]){
					s[2][3]+="6";         	
					t[2][3].setText(s[2][3]);flag[2][3]=true;
				}
				
               }
           }); 
		
		b7.setOnClickListener(new View.OnClickListener() {
			@Override
               public void onClick(View v) {
               
				if(occFlag[0][0]){
					s[0][0]+="7";         	
					t[0][0].setText(s[0][0]);flag[0][0]=true;
				}
				if(occFlag[0][1]){
					s[0][1]+="7";         	
					t[0][1].setText(s[0][1]);flag[0][1]=true;
				}
				if(occFlag[0][2]){
					s[0][2]+="7";         	
					t[0][2].setText(s[0][2]);flag[0][2]=true;
				}
				if(occFlag[0][3]){
					s[0][3]+="7";         	
					t[0][3].setText(s[0][3]);flag[0][3]=true;
				}
				if(occFlag[1][0]){
					s[1][0]+="7";         	
					t[1][0].setText(s[1][0]);flag[1][0]=true;
				}
				if(occFlag[1][1]){
					s[1][1]+="7";         	
					t[1][1].setText(s[1][1]);flag[1][1]=true;
				}
				if(occFlag[1][2]){
					s[1][2]+="7";         	
					t[1][2].setText(s[1][2]);flag[1][2]=true;
				}
				if(occFlag[1][3]){
					s[1][3]+="7";         	
					t[1][3].setText(s[1][3]);flag[1][3]=true;
				}
				if(occFlag[2][0]){
					s[2][0]+="7";         	
					t[2][0].setText(s[2][0]);flag[2][0]=true;
				}
				if(occFlag[2][1]){
					s[2][1]+="7";         	
					t[2][1].setText(s[2][1]);flag[2][1]=true;
				}
				if(occFlag[2][2]){
					s[2][2]+="7";         	
					t[2][2].setText(s[2][2]);flag[2][2]=true;
				}
				if(occFlag[2][3]){
					s[2][3]+="7";         	
					t[2][3].setText(s[2][3]);flag[2][3]=true;
				}
				
               }
           }); 
		
		b8.setOnClickListener(new View.OnClickListener() {
			@Override
               public void onClick(View v) {
               
				if(occFlag[0][0]){
					s[0][0]+="8";         	
					t[0][0].setText(s[0][0]);flag[0][0]=true;
				}
				if(occFlag[0][1]){
					s[0][1]+="8";         	
					t[0][1].setText(s[0][1]);flag[0][1]=true;
				}
				if(occFlag[0][2]){
					s[0][2]+="8";         	
					t[0][2].setText(s[0][2]);flag[0][2]=true;
				}
				if(occFlag[0][3]){
					s[0][3]+="8";         	
					t[0][3].setText(s[0][3]);flag[0][3]=true;
				}
				if(occFlag[1][0]){
					s[1][0]+="8";         	
					t[1][0].setText(s[1][0]);flag[1][0]=true;
				}
				if(occFlag[1][1]){
					s[1][1]+="8";         	
					t[1][1].setText(s[1][1]);flag[1][1]=true;
				}
				if(occFlag[1][2]){
					s[1][2]+="8";         	
					t[1][2].setText(s[1][2]);flag[1][2]=true;
				}
				if(occFlag[1][3]){
					s[1][3]+="8";         	
					t[1][3].setText(s[1][3]);flag[1][3]=true;
				}
				if(occFlag[2][0]){
					s[2][0]+="8";         	
					t[2][0].setText(s[2][0]);flag[2][0]=true;
				}
				if(occFlag[2][1]){
					s[2][1]+="8";         	
					t[2][1].setText(s[2][1]);flag[2][1]=true;
				}
				if(occFlag[2][2]){
					s[2][2]+="8";         	
					t[2][2].setText(s[2][2]);flag[2][2]=true;
				}
				if(occFlag[2][3]){
					s[2][3]+="8";         	
					t[2][3].setText(s[2][3]);flag[2][3]=true;
				}
				
               }
           }); 
		
		b9.setOnClickListener(new View.OnClickListener() {
			@Override
               public void onClick(View v) {
               
				if(occFlag[0][0]){
					s[0][0]+="9";         	
					t[0][0].setText(s[0][0]);flag[0][0]=true;
				}
				if(occFlag[0][1]){
					s[0][1]+="9";         	
					t[0][1].setText(s[0][1]);flag[0][1]=true;
				}
				if(occFlag[0][2]){
					s[0][2]+="9";         	
					t[0][2].setText(s[0][2]);flag[0][2]=true;
				}
				if(occFlag[0][3]){
					s[0][3]+="9";         	
					t[0][3].setText(s[0][3]);flag[0][3]=true;
				}
				if(occFlag[1][0]){
					s[1][0]+="9";         	
					t[1][0].setText(s[1][0]);flag[1][0]=true;
				}
				if(occFlag[1][1]){
					s[1][1]+="9";         	
					t[1][1].setText(s[1][1]);flag[1][1]=true;
				}
				if(occFlag[1][2]){
					s[1][2]+="9";         	
					t[1][2].setText(s[1][2]);flag[1][2]=true;
				}
				if(occFlag[1][3]){
					s[1][3]+="9";         	
					t[1][3].setText(s[1][3]);flag[1][3]=true;
				}
				if(occFlag[2][0]){
					s[2][0]+="9";         	
					t[2][0].setText(s[2][0]);flag[2][0]=true;
				}
				if(occFlag[2][1]){
					s[2][1]+="9";         	
					t[2][1].setText(s[2][1]);flag[2][1]=true;
				}
				if(occFlag[2][2]){
					s[2][2]+="9";         	
					t[2][2].setText(s[2][2]);flag[2][2]=true;
				}
				if(occFlag[2][3]){
					s[2][3]+="9";         	
					t[2][3].setText(s[2][3]);flag[2][3]=true;
				}
				
               }
           }); 
		b0.setOnClickListener(new View.OnClickListener() {
			@Override
               public void onClick(View v) {
               
				if(occFlag[0][0]){
					s[0][0]+="0";         	
					t[0][0].setText(s[0][0]);flag[0][0]=true;
				}
				if(occFlag[0][1]){
					s[0][1]+="0";         	
					t[0][1].setText(s[0][1]);flag[0][1]=true;
				}
				if(occFlag[0][2]){
					s[0][2]+="0";         	
					t[0][2].setText(s[0][2]);flag[0][2]=true;
				}
				if(occFlag[0][3]){
					s[0][3]+="0";         	
					t[0][3].setText(s[0][3]);flag[0][3]=true;
				}
				if(occFlag[1][0]){
					s[1][0]+="0";         	
					t[1][0].setText(s[1][0]);flag[1][0]=true;
				}
				if(occFlag[1][1]){
					s[1][1]+="0";         	
					t[1][1].setText(s[1][1]);flag[1][1]=true;
				}
				if(occFlag[1][2]){
					s[1][2]+="0";         	
					t[1][2].setText(s[1][2]);flag[1][2]=true;
				}
				if(occFlag[1][3]){
					s[1][3]+="0";         	
					t[1][3].setText(s[1][3]);flag[1][3]=true;
				}
				if(occFlag[2][0]){
					s[2][0]+="0";         	
					t[2][0].setText(s[2][0]);flag[2][0]=true;
				}
				if(occFlag[2][1]){
					s[2][1]+="0";         	
					t[2][1].setText(s[2][1]);flag[2][1]=true;
				}
				if(occFlag[2][2]){
					s[2][2]+="0";         	
					t[2][2].setText(s[2][2]);flag[2][2]=true;
				}
				if(occFlag[2][3]){
					s[2][3]+="0";         	
					t[2][3].setText(s[2][3]);flag[2][3]=true;
				}
				
               }
           }); 
		
		bPoint.setOnClickListener(new View.OnClickListener() {
			@Override
               public void onClick(View v) {
               
				if(occFlag[0][0]){
					s[0][0]+=".";         	
					t[0][0].setText(s[0][0]);flag[0][0]=true;
				}
				if(occFlag[0][1]){
					s[0][1]+=".";         	
					t[0][1].setText(s[0][1]);flag[0][1]=true;
				}
				if(occFlag[0][2]){
					s[0][2]+=".";         	
					t[0][2].setText(s[0][2]);flag[0][2]=true;
				}
				if(occFlag[0][3]){
					s[0][3]+=".";         	
					t[0][3].setText(s[0][3]);flag[0][3]=true;
				}
				if(occFlag[1][0]){
					s[1][0]+="0";         	
					t[1][0].setText(s[1][0]);flag[1][0]=true;
				}
				if(occFlag[1][1]){
					s[1][1]+=".";         	
					t[1][1].setText(s[1][1]);flag[1][1]=true;
				}
				if(occFlag[1][2]){
					s[1][2]+=".";         	
					t[1][2].setText(s[1][2]);flag[1][2]=true;
				}
				if(occFlag[1][3]){
					s[1][3]+=".";         	
					t[1][3].setText(s[1][3]);flag[1][3]=true;
				}
				if(occFlag[2][0]){
					s[2][0]+=".";         	
					t[2][0].setText(s[2][0]);flag[2][0]=true;
				}
				if(occFlag[2][1]){
					s[2][1]+=".";         	
					t[2][1].setText(s[2][1]);flag[2][1]=true;
				}
				if(occFlag[2][2]){
					s[2][2]+=".";         	
					t[2][2].setText(s[2][2]);flag[2][2]=true;
				}
				if(occFlag[2][3]){
					s[2][3]+=".";         	
					t[2][3].setText(s[2][3]);flag[2][3]=true;
				}
				
			}
           });
		
		
		bN.setOnClickListener(new View.OnClickListener() {
			@Override
               public void onClick(View v) {
               
				if(occFlag[0][0]){
					s[0][0]+="-";         	
					t[0][0].setText(s[0][0]);flag[0][0]=true;
				}
				if(occFlag[0][1]){
					s[0][1]+="-";         	
					t[0][1].setText(s[0][1]);flag[0][1]=true;
				}
				if(occFlag[0][2]){
					s[0][2]+="-";         	
					t[0][2].setText(s[0][2]);flag[0][2]=true;
				}
				if(occFlag[0][3]){
					s[0][3]+="-";         	
					t[0][3].setText(s[0][3]);flag[0][3]=true;
				}
				if(occFlag[1][0]){
					s[1][0]+="-";         	
					t[1][0].setText(s[1][0]);flag[1][0]=true;
				}
				if(occFlag[1][1]){
					s[1][1]+="-";         	
					t[1][1].setText(s[1][1]);flag[1][1]=true;
				}
				if(occFlag[1][2]){
					s[1][2]+="-";         	
					t[1][2].setText(s[1][2]);flag[1][2]=true;
				}
				if(occFlag[1][3]){
					s[1][3]+="-";         	
					t[1][3].setText(s[1][3]);flag[1][3]=true;
				}
				if(occFlag[2][0]){
					s[2][0]+="-";         	
					t[2][0].setText(s[2][0]);flag[2][0]=true;
				}
				if(occFlag[2][1]){
					s[2][1]+="-";         	
					t[2][1].setText(s[2][1]);flag[2][1]=true;
				}
				if(occFlag[2][2]){
					s[2][2]+="-";         	
					t[2][2].setText(s[2][2]);flag[2][2]=true;
				}
				if(occFlag[2][3]){
					s[2][3]+="-";         	
					t[2][3].setText(s[2][3]);flag[2][3]=true;
				}
				
			}
           });
		
		
		bB.setOnClickListener(new View.OnClickListener() {
			@Override
               public void onClick(View v) {
               
				for(a=0;a<3;a++)
					for(b=0;b<4;b++){
						s[a][b]=" ";
						t[a][b].setText(s[a][b]);
					}
			}
           });
		
		
		bANS.setOnClickListener(new View.OnClickListener() {
			@Override
               public void onClick(View v) {
               
				for(a=0;a<3;a++)
					for(b=0;b<3;b++){
						if(s[a][b]==" ")
							s[a][b]="0.0";
						s[a][b].substring(1);
						if(s[a][b].startsWith("-")){
							s[a][b].substring(1);
							negFlag=true;
						}
						double x=Double.parseDouble(s[a][b]);
						if(negFlag){
							x*=-1;
							negFlag=false;
						}
						mat[a][b]=x;
						
					}
				
				mat=invert(mat);
				
				
				for(a=0;a<3;a++){
					if(s[a][3]==" ")
						s[a][3]="0.0";
					s[a][3].substring(1);
					double x=Double.parseDouble(s[a][3]);
					mat2[a][0]=x;
				}
				
			/*		 		
				for (int i=0; i<2; ++i)
				    for (int j=0; j<2; ++j)
				      for (int k=0; k<2; ++k)
				        ans[i][k]+=mat[i][k]*mat2[k][j];  
				
				*/
			}
           });
		
		
		bHelp.setOnClickListener(new View.OnClickListener() {
			@Override
               public void onClick(View v) {
               
				for(a=0;a<3;a++)
					for(b=0;b<3;b++){
						t[a][b].setText(Double.toString(mat[a][b]));
					}
				//for(a=0;a<3;a++)
					//t[a][3].setText(Double.toString(mat2[a][0]));		
			}
           });
		
		/*
		bB.setOnClickListener(new View.OnClickListener() {
			@Override
               public void onClick(View v) {
               
				for(a=0;a<3;a++)
					for(b=0;b<4;b++){
						s[a][b]=" ";
						t[a][b].setText(s[a][b]);
					}
						
			}
           });
		
		
		
		*/
	
		
		
		
		
		
	}
	
////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////
	
	 double[][] invert(double a[][]) 
	    {
	        int n = a.length;
	        double x[][] = new double[n][n];
	        double b[][] = new double[n][n];
	        int index[] = new int[n];
	        for (int i=0; i<n; ++i) 
	            b[i][i] = 1;
	 
	 // Transform the matrix into an upper triangle
	        gaussian(a, index);
	 
	 // Update the matrix b[i][j] with the ratios stored
	        for (int i=0; i<n-1; ++i)
	            for (int j=i+1; j<n; ++j)
	                for (int k=0; k<n; ++k)
	                    b[index[j]][k]
	                    	    -= a[index[j]][i]*b[index[i]][k];
	 
	 // Perform backward substitutions
	        for (int i=0; i<n; ++i) 
	        {
	            x[n-1][i] = b[index[n-1]][i]/a[index[n-1]][n-1];
	            for (int j=n-2; j>=0; --j) 
	            {
	                x[j][i] = b[index[j]][i];
	                for (int k=j+1; k<n; ++k) 
	                {
	                    x[j][i] -= a[index[j]][k]*x[k][i];
	                }
	                x[j][i] /= a[index[j]][j];
	            }
	        }
	        return x;
	    }
	 
/////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////
	 public static void gaussian(double a[][], int index[]) 
	    {
	        int n = index.length;
	        double c[] = new double[n];
	 
	 // Initialize the index
	        for (int i=0; i<n; ++i) 
	            index[i] = i;
	 
	 // Find the rescaling factors, one from each row
	        for (int i=0; i<n; ++i) 
	        {
	            double c1 = 0;
	            for (int j=0; j<n; ++j) 
	            {
	                double c0 = Math.abs(a[i][j]);
	                if (c0 > c1) c1 = c0;
	            }
	            c[i] = c1;
	        }
	 
	 // Search the pivoting element from each column
	        int k = 0;
	        for (int j=0; j<n-1; ++j) 
	        {
	            double pi1 = 0;
	            for (int i=j; i<n; ++i) 
	            {
	                double pi0 = Math.abs(a[index[i]][j]);
	                pi0 /= c[index[i]];
	                if (pi0 > pi1) 
	                {
	                    pi1 = pi0;
	                    k = i;
	                }
	            }
	 
	   // Interchange rows according to the pivoting order
	            int itmp = index[j];
	            index[j] = index[k];
	            index[k] = itmp;
	            for (int i=j+1; i<n; ++i) 	
	            {
	                double pj = a[index[i]][j]/a[index[j]][j];
	 
	 // Record pivoting ratios below the diagonal
	                a[index[i]][j] = pj;
	 
	 // Modify other elements accordingly
	                for (int l=j+1; l<n; ++l)
	                    a[index[i]][l] -= pj*a[index[j]][l];
	            }
	        }
	    }
/////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////
	
	
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.len_equ_entry, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
