package com.example.calculatrix;

import java.text.DecimalFormat;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;
import android.widget.PopupMenu.OnMenuItemClickListener;
import android.widget.TextView;

public class Cal extends ActionBarActivity implements OnMenuItemClickListener {
	
	String s1=" ",t=" ";
	Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,bPoint,bMul,bPlus,bSub,bDiv,bOpen,bClose,bE;
	Button bKill,bSqrt,bEx,bTen,bFact,bTor,bNega;
	TextView txtView;
	boolean stringFlag=true,AddStringB=false,AddStringA=false,pointFlag=false,flag=false;
	int flagOP,flagCO;
	int mulCount=0,divCount=0,plusCount=0,subCount=0,sinCount=0,cosCount=0,tanCount=0;
	int logCount=0,lnCount=0,exCount=0,cbrtCount=0,sqrtCount=0,factCount=0;
	int OpenCount=0,CloseCount=0;
	boolean nega=false,toNega=false;
	boolean negF=false;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cal_entry);
		getActionBar().hide();
		
		findViewById(R.id.button30).setOnClickListener(new OnClickListener() {

			@TargetApi(Build.VERSION_CODES.HONEYCOMB)
			@SuppressLint("NewApi")
			@Override
			public void onClick(View view) {
				PopupMenu popupMenu = new PopupMenu(Cal.this, view);
				popupMenu.setOnMenuItemClickListener(Cal.this);
				popupMenu.inflate(R.menu.roots);
				popupMenu.show();
			}
		});
		
		
		
		findViewById(R.id.button16).setOnClickListener(new OnClickListener() {

			@TargetApi(Build.VERSION_CODES.HONEYCOMB)
			@SuppressLint("NewApi")
			@Override
			public void onClick(View view) {
				PopupMenu popupMenu = new PopupMenu(Cal.this, view);
				popupMenu.setOnMenuItemClickListener(Cal.this);
				popupMenu.inflate(R.menu.trigo);
				popupMenu.show();
			}
		});
		findViewById(R.id.button20).setOnClickListener(new OnClickListener() {

			@TargetApi(Build.VERSION_CODES.HONEYCOMB)
			@SuppressLint("NewApi")
			@Override
			public void onClick(View view) {
				PopupMenu popupMenu = new PopupMenu(Cal.this, view);
				popupMenu.setOnMenuItemClickListener(Cal.this);
				popupMenu.inflate(R.menu.constant_list);
				popupMenu.show();
			}
		});
		
		
		findViewById(R.id.button26).setOnClickListener(new OnClickListener() {

			@TargetApi(Build.VERSION_CODES.HONEYCOMB)
			@SuppressLint("NewApi")
			@Override
			public void onClick(View view) {
				PopupMenu popupMenu = new PopupMenu(Cal.this, view);
				popupMenu.setOnMenuItemClickListener(Cal.this);
				popupMenu.inflate(R.menu.log);
				popupMenu.show();
			}
		});
		
		
		b1=(Button)findViewById(R.id.button8);
		b2=(Button)findViewById(R.id.button9);
		b3=(Button)findViewById(R.id.button10);
		b4=(Button)findViewById(R.id.button11);
		b5=(Button)findViewById(R.id.button12);
		b6=(Button)findViewById(R.id.button13);
		b7=(Button)findViewById(R.id.button14);
		b8=(Button)findViewById(R.id.button1);
		b9=(Button)findViewById(R.id.button2);
		b0=(Button)findViewById(R.id.button4);
		bPoint=(Button)findViewById(R.id.button3);
		bMul=(Button)findViewById(R.id.button22);
		bPlus=(Button)findViewById(R.id.button17);
		bE=(Button)findViewById(R.id.button19);
		bDiv=(Button)findViewById(R.id.button18);
		bSub=(Button)findViewById(R.id.button21);
		bOpen=(Button)findViewById(R.id.button7);
		bClose=(Button)findViewById(R.id.button25);
		bKill=(Button)findViewById(R.id.button5);
		bEx=(Button)findViewById(R.id.button29);
		bTen=(Button)findViewById(R.id.button27);
		bFact=(Button)findViewById(R.id.button28);
		txtView=(TextView)findViewById(R.id.textView1);
		bTor=(Button)findViewById(R.id.button6);
		bNega=(Button)findViewById(R.id.button24);
		
		
		
		bNega.setOnClickListener(new View.OnClickListener() {

             @Override
             public void onClick(View v) {
             
             
            	 s1+="(-";
            	 nega=true;
            
          	txtView.setText(s1);  
      
             }
         }); 
		  
		   
		   bFact.setOnClickListener(new View.OnClickListener() {

               @Override
               public void onClick(View v) {
               
               	s1+="!";
      
              
            	txtView.setText(s1);  
        
               }
           }); 
		   
		   
		   
		   
		   bTen.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
               	   s1+="E";
               	   txtView.setText(s1);
               }
           }); 
		   
		   /*
		   bSqrt.setOnClickListener(new View.OnClickListener() {

               @Override
               public void onClick(View v) {
                   // TODO Auto-generated method stub
         
               	s1+="sqrt";
      
               	
               	txtView.setText(s1);
                 
               }
           }); 
		   
		   */
		   bEx.setOnClickListener(new View.OnClickListener() {

               @Override
               public void onClick(View v) {
                  
               	
               	s1+="e^";
      
               	
               	txtView.setText(s1);
                 
               }
           }); 
		  
	   
		   
	     bKill.setOnClickListener(new View.OnClickListener() {

	                    @Override
	                    public void onClick(View v) {
	                        
	                    	
	                    	s1=" ";
	                    	stringFlag=true;
	                    	pointFlag=true;
	                    	
	                    	txtView.setText(s1);
	                      
	                    }
	                });
	        
		   
        b1.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        
                    	
                    	s1+="1";
                    	stringFlag=true;
                    	pointFlag=true;
                    	
                    	txtView.setText(s1);
                      
                    }
                });
        
        b2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                
            	
            	s1+="2";
            	stringFlag=true;
            	pointFlag=true;
            	txtView.setText(s1);
              
            }
        });
        
        
        b3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                
            	
            	s1+="3";
            	stringFlag=true;
            	pointFlag=true;
            	txtView.setText(s1);
              
            }
        });
        
        
        b4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

            	
            	s1+="4";
            	pointFlag=true;
            	stringFlag=true;
            	txtView.setText(s1);
              
            }
        });
        
        b5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
              
            	
            	s1+="5";
            	stringFlag=true;
            	pointFlag=true;
            	txtView.setText(s1);
              
            }
        });
        
        
        b6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

            	
            	s1+="6";
            	pointFlag=true;
            	stringFlag=true;
            	txtView.setText(s1);
              
            }
        });
        
        b7.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                
            	
            	s1+="7";
            	pointFlag=true;
            	stringFlag=true;
            	txtView.setText(s1);
              
            }
        });
        
        
        b8.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
            	
            	s1+="8";
            	pointFlag=true;
            	stringFlag=true;
            	txtView.setText(s1);
              
            }
        });
        
        b9.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
            	
            	s1+="9";
            	pointFlag=true;
            	stringFlag=true;
            	txtView.setText(s1);
              
            }
        });
        
        b0.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                
            	
            	s1+="0";
            	pointFlag=true;
            	stringFlag=true;
            	txtView.setText(s1);
              
            }
        });
        
        
        bPoint.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                
            	if(stringFlag&&pointFlag)
            		s1+=".";
            	else if(stringFlag&&!pointFlag)
            		s1+="0.";
            	stringFlag=false;
            	txtView.setText(s1);
              
            }
        });
        
        
        bMul.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                
            	
            	
            	if(nega){
            		s1+=")";
            		nega=false;
            	}
            	if(stringFlag)
            		s1+="*";
            	pointFlag=false;
            	stringFlag=false;
            	txtView.setText(s1);
              
            }
        });
        
        
        bPlus.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                
            	if(nega){
            		s1+=")";
            		nega=false;
            	}
            	if(stringFlag)
            		s1+="+";
            	stringFlag=false;
            	pointFlag=false;
            	txtView.setText(s1);
              
            }
        });
        
        
        bDiv.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
            	if(nega){
            		s1+=")";
            		nega=false;
            	}
            	if(stringFlag)
            		s1+="/";
            	stringFlag=false;
            	pointFlag=false;
            	txtView.setText(s1);
              
            }
        });
        
        bSub.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
            	if(nega){
            		s1+=")";
            		nega=false;
            	}
            	if(stringFlag)
            		s1+="-";
            	stringFlag=false;
            	pointFlag=false;
            	txtView.setText(s1);
              
            }
        });
        
        
    
        bOpen.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
            	
            	s1+="(";
            	stringFlag=true;
            	pointFlag=false;
            	txtView.setText(s1);
              
            }
        });
        
        
      
        
        bClose.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
            	
            	s1+=")";
            	stringFlag=true;
            	pointFlag=false;
            	txtView.setText(s1);
              
            }
        });
        
    
        bE.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
            	stringFlag=true;
            	if(s1.charAt(1)=='-')
            		s1='0'+s1;
            	t=computeString(s1);
            	s1=" ";
            	s1+=t;
            	
            	txtView.setText(s1);
              
            }
        });
        
        
        
		
		
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	void CountOp(String string){
		
		int len=string.length();
		Character[] ar;
		ar=getCharArray(string);
		for(int i=0;i<len;i++){
			if(ar[i]=='+')plusCount++;
			//if(ar[i]=='-')subCount++;
			if(ar[i]=='*')mulCount++;
			if(ar[i]=='/')divCount++;
			if(ar[i]=='S')sinCount++;
			if(ar[i]=='C')cosCount++;
			if(ar[i]=='T')tanCount++;
			if(ar[i]=='L')logCount++;
			if(ar[i]=='l')lnCount++;
			if(ar[i]=='e')exCount++;
			if(ar[i]=='b')cbrtCount++;
			if(ar[i]=='q')sqrtCount++;
			if(ar[i]=='!')factCount++;
			if(ar[i]=='(')OpenCount++;
			if(ar[i]==')')CloseCount++;
			
			//subCount-=OpenCount;
		}
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////

	String SingleOpCalculator(String string){
		
		String sA,sB,result;
		double a,res=1;
		int len=string.length(),k;
		Character[] ar;
		ar=getCharArray(string);
		for(int i=0;i<len;i++){
			if(ar[i]=='S'){
				k=i;
				k+=3;
				if(ar[k]!='^'&&ar[k]!='('){
					a=ComputeB(k-1,ar,len);
					res=Math.sin(Math.toRadians(a));
					result=Double.toString(res);
					sA=ComputeSa(i,ar);
					sB=ComputeSb(k-1,ar,len);
					if(AddStringA){
						string=sA;
						string+=result;
					}
					else
						string=result;
					if(AddStringB){
						string+=sB;
						AddStringB=false;
					}
					sinCount--;
					return string;
				}
			}
			if(ar[i]=='C'){
				k=i;
				k+=3;
				if(ar[k]!='^'&&ar[k]!='('){
					a=ComputeB(k-1,ar,len);
					res=Math.cos(Math.toRadians(a));
					result=Double.toString(res);
					sA=ComputeSa(i,ar);
					sB=ComputeSb(k-1,ar,len);
					if(AddStringA){
						string=sA;
						string+=result;
						AddStringA=false;
					}
					else
						string=result;
					if(AddStringB){
						string+=sB;
						AddStringB=false;
					}
					cosCount--;
					return string;
				}
			}
			if(ar[i]=='T'){
				k=i;
				k+=3;
				if(ar[k]!='^'&&ar[k]!='('){
					a=ComputeB(k-1,ar,len);
					res=Math.tan(Math.toRadians(a));
					//res=Math.log10(a);
					result=Double.toString(res);
					sA=ComputeSa(i,ar);
					sB=ComputeSb(k-1,ar,len);
					if(AddStringA){
						string=sA;
						string+=result;
						AddStringA=false;
					}
					else
						string=result;
					if(AddStringB){
						string+=sB;
						AddStringB=false;
					}
					tanCount--;
					return string;
				}
			}
			if(ar[i]=='L'){
				k=i;
				k+=3;
				if(ar[k]!='('){
					a=ComputeB(k-1,ar,len);
					res=Math.log10(a);
					result=Double.toString(res);
					sA=ComputeSa(i,ar);
					sB=ComputeSb(k-1,ar,len);
					if(AddStringA){
						string=sA;
						string+=result;
						AddStringA=false;
					}
					else
						string=result;
					if(AddStringB){
						string+=sB;
						AddStringB=false;
					}
					logCount--;
					return string;
				}
			}
			if(ar[i]=='l'){
				k=i;
				k+=2;
				if(ar[k]!='('){
					a=ComputeB(k-1,ar,len);
					res=Math.log(a);
					result=Double.toString(res);
					sA=ComputeSa(i,ar);
					sB=ComputeSb(k-1,ar,len);
					if(AddStringA){
						string=sA;
						string+=result;
						AddStringA=false;
					}
					else
						string=result;
					if(AddStringB){
						string+=sB;
						AddStringB=false;
					}
					lnCount--;
					return string;
				}
			}
			
				
			if(ar[i]=='e'){
				k=i;
				k+=2;
				if(ar[k]!='('){
					a=ComputeB(k-1,ar,len);
					res=Math.exp(a);
					result=Double.toString(res);
					sA=ComputeSa(i,ar);
					sB=ComputeSb(k-1,ar,len);
					if(AddStringA){
						string=sA;
						string+=result;
						AddStringA=false;
					}
					else
						string=result;
					if(AddStringB){
						string+=sB;
						AddStringB=false;
					}
					exCount--;
					return string;
				}
	    	}
			if(ar[i]=='q'){
				k=i;
				k+=3;
				if(ar[k]!='('){
					a=ComputeB(k-1,ar,len);
					res=Math.sqrt(a);
					result=Double.toString(res);
					sA=ComputeSa(i,ar);
					sB=ComputeSb(k-1,ar,len);
					if(AddStringA){
						string=sA;
						string+=result;
						AddStringA=false;
					}
					else
						string=result;
					if(AddStringB){
						string+=sB;
						AddStringB=false;
					}
					sqrtCount--;
					return string;
				}
	    	}
			
			if(ar[i]=='b'){
				k=i;
				k+=3;
				if(ar[k]!='('){
					a=ComputeB(k-1,ar,len);
					res=Math.cbrt(a);
					result=Double.toString(res);
					sA=ComputeSa(i,ar);
					sB=ComputeSb(k-1,ar,len);
					if(AddStringA){
						string=sA;
						string+=result;
						AddStringA=false;
					}
					else
						string=result;
					if(AddStringB){
						string+=sB;
						AddStringB=false;
					}
					cbrtCount--;
					return string;
				}
	    	}
			if(ar[i]=='!'){
				k=i;
				k--;
				if(ar[k]!=')'){
					a=ComputeA(i,ar);
					
					while(a!=0){
						res*=a;
						a--;
					}
					result=Double.toString(res);
					sA=ComputeSa(i,ar);
					sB=ComputeSb(i,ar,len);
					if(AddStringA){
						string=sA;
						string+=result;
						AddStringA=false;
					}
					else
						string=result;
					if(AddStringB){
						string+=sB;
						AddStringB=false;
					}
					factCount--;
					return string;
				}
	    	}
		}
					
		return null;
	}
	
	
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////

	Character[] getCharArray(String string){
		int stringLength=string.length();
		Character[] CharacterArray=new Character[stringLength];
		for(int i=0;i<stringLength;i++)
			CharacterArray[i]=new Character(string.charAt(i));
		return CharacterArray;
	}
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////

	String StringBreakDown(String string){
		
		int openID=0,closeID=0,length=0;
		int len=string.length();
		Character[] ar=new Character[len];
		ar=getCharArray(string);
		for(int i=0;i<len;i++){
			if(ar[i]=='(')
				openID=i;
			else if(ar[i]==')'){
				closeID=i;
				break;
			}
		}
		length=closeID-openID;
		Character[] ar2=new Character[length];
		for(int j=0;j<length ;j++)
			ar2[j]=ar[++openID];
		
		
			
		return string;
	}
	
	
	
///////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////
	String computeString(String s1){

		CountOp(s1);
		
		
		while(sinCount!=0||cosCount!=0||tanCount!=0||logCount!=0||lnCount!=0||exCount!=0||sqrtCount!=0||cbrtCount!=0||factCount!=0)
			s1=SingleOpCalculator(" "+s1);
		
		while(divCount!=0){
			
			s1=DivCompute(" "+s1);
		}
		while(mulCount!=0){
			
			s1=MulCompute(" "+s1);
		}
		while(subCount!=0){
			
			s1=SubCompute(" "+s1);
			
		}
		while(plusCount!=0){
			
			s1=AdditionCompute(" "+s1);
		}
		
		
		return s1;
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////
	
		
	

	String AdditionCompute(String string){
		
		String sA,sB,st=null;
		double a,b,result;
		int cont=0;
		int len=string.length();
		Character[] ar= new Character[len];
		ar=getCharArray(string);
		for(int i=2;i<len;i++){
			if(ar[i]=='+'){
				if(ar[i]=='+'){
					sA=ComputeSa(i,ar);
					sB=ComputeSb(i,ar,len);
					a=ComputeA(i,ar);
					b=ComputeB(i,ar,len);
					result=a+b;
					if(AddStringA){
						st=sA;
						st+=Double.toString(result);
					}
					else
						st=Double.toString(result);
					if(AddStringB){
						st+=sB;
						AddStringB=false;
						break;
					}
				}
			}
				
		}
		
		if(st==null)
			return string;
		else{
			plusCount--;
			return st;
		}
		
	}

	
//////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////
	
	String MulCompute(String string){
		
		String sA,sB,st=null;
		double a,b,result;
		int len=string.length();
		Character[] ar= new Character[len];
		ar=getCharArray(string);
		for(int i=0;i<len;i++){
			if(ar[i]=='*'){
				if(ar[i]=='*'){
					sA=ComputeSa(i,ar);
					sB=ComputeSb(i,ar,len);
					a=ComputeA(i,ar);
					b=ComputeB(i,ar,len);
					result=a*b;
					if(AddStringA){
						st=sA;
						st+=Double.toString(result);
					}
					else
						st=Double.toString(result);
					if(AddStringB){
						st+=sB;
						AddStringB=false;
						break;
					}
				}
			}	
		}
		
		if(st==null)
			return string;
		else{
			mulCount--;
			return st;
		}
	}

	
////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////
	
	String SubCompute(String string){
		
		String sA,sB,st=null;
		double a,b,result;
		int len=string.length();
		Character[] ar= new Character[len];
		ar=getCharArray(string);
		for(int i=0;i<len;i++){
			if(ar[i]=='-'){
				if(ar[i]=='-'){
					sA=ComputeSa(i,ar);
					sB=ComputeSb(i,ar,len);
					a=ComputeA(i,ar);
					b=ComputeB(i,ar,len);
					result=a-b;
						
					if(AddStringA){
						st=sA;
						st+=Double.toString(result);
					}
					else
						st=Double.toString(result);
					if(AddStringB){
						st+=sB;
						AddStringB=false;
						break;
					}
				}
			}
				
		}
		string=string.substring(1);
		if(st==null)
			return string;
		else{
			subCount--;
			return st;
		}
		
	}

	
/////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////
	
	String DivCompute(String string){
		
		String sA,sB,st=null;
		double a,b,result;
		int len=string.length();
		Character[] ar= new Character[len];
		ar=getCharArray(string);
		for(int i=0;i<len;i++){
			if(ar[i]=='/'){
				if(ar[i]=='/'){
					sA=ComputeSa(i,ar);
					sB=ComputeSb(i,ar,len);
					a=ComputeA(i,ar);
					b=ComputeB(i,ar,len);
					result=a/b;
					if(AddStringA){
						st=sA;
						st+=Double.toString(result);
					}
					else
						st=Double.toString(result);
					if(AddStringB){
						st+=sB;
						AddStringB=false;
						break;
					}
				}
			}
				
		}
		
		if(st==null)
			return string;
		else{
			divCount--;
			return st;
		}
		
	}

	


	
///////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////

	
	

	String ComputeSa(int i,Character ar[]){
		
		String sA=null;
		int j=0,k=0,ID=0,a=0;
		i--;
		for(j=i;j>=1;j--)
			if((ar[j]=='+')||(ar[j]=='-')||(ar[j]=='*')||(ar[j]=='/')){
				AddStringA=true;
				ID=j;
				break;
			}
		if(AddStringA){
			Character[] array = new Character[ID];
			for (k=1;k<=ID;k++) {
				array[a] = ar[k];
				a++;
			}
			StringBuilder sb = new StringBuilder(array.length);
			for (Character c : array)
			sb.append(c.charValue());
			sA = sb.toString();
		}
		return sA;
	}
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	String ComputeSb(int i,Character ar[],int end){
		
		String sB=null;
		int j=0,k=0,a=0,ID=0;
		i++;
		for(j=i;j<end;j++){
			if((ar[j]=='+')||(ar[j]=='-')||(ar[j]=='*')||(ar[j]=='/')){
				AddStringB=true;	
				ID=j;
				break;
			}
		}
		if(AddStringB){
			Character[] array = new Character[end-ID];
			for (k=ID;k<end;k++) {
			     array[a] = ar[k];
			     a++;
			}
			StringBuilder sb = new StringBuilder(array.length);
			for (Character c : array)
			sb.append(c.charValue());
			sB=sb.toString();	
		}
		return sB;
	}
	
////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////
	
	double RoundToDecimals(double val) {
        DecimalFormat df2 = new DecimalFormat("###.##");
    return Double.valueOf(df2.format(val));
    }
	
//////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////

	
	int getNumber(Character ar[],int k){
		
		int a=0;
		if(ar[k]=='1')a=1;	
		if(ar[k]=='2')a=2;
		if(ar[k]=='3')a=3;
		if(ar[k]=='4')a=4;
		if(ar[k]=='5')a=5;
		if(ar[k]=='6')a=6;
		if(ar[k]=='7')a=7;
		if(ar[k]=='8')a=8;
		if(ar[k]=='9')a=9;
		if(ar[k]=='0')a=0;	
		return a;
		
	}
	
/////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////
	
	double ComputeA(int i,Character ar[]){
		
		double a=0.0,dec=0.0;
		int c=0,j=0,k=0;
		boolean flag=true;
		i--;
		for(j=i;j>=1;j--)
			if(ar[j]==')')
				toNega=true;
		
			else if((ar[j]=='+')||(ar[j]=='-')||(ar[j]=='*')||(ar[j]=='/'))
					break;	
		
		//if(toNega)
			//return 100.0;
		if(toNega){
			j++;
			i--;
		}
		else
			j++;
		for(k=j;k<=i;k++){
			if(ar[k]=='.'){
				a/=10;
				flag=false;
				k++;
			}
			if(flag){
				a+=getNumber(ar,k);
				a*=10;
			}
			else{
				dec=getNumber(ar,k);
				c++;
				for(int inc=0;inc<c;inc++)
					dec*=0.1;
				a+=dec;
				}
			}
		if(flag)a/=10;
		if(toNega){
			a*=-1;
			//toNega=false;
			return a;
		}
		return a;
	}
	
////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////\
	
	
	
	double ComputeB(int i,Character ar[],int len){
		
		double b=0.0,dec=0.0;
		int c=0,j=0,k=0;
		boolean flag=true;
		i++;
		for(k=i;k<len;k++){
			if((ar[k]=='+')||(ar[k]=='-')||(ar[k]=='*')||(ar[k]=='/'))
				break;
			if(ar[k]=='.'){
				b/=10;
				flag=false;
				k++;
			}
			if(flag){
				b+=getNumber(ar,k);
				b*=10;
			}
			else{
				dec=getNumber(ar,k);
				c++;
				for(int inc=0;inc<c;inc++)
					dec*=0.1;
				b+=dec;
				}
			}
		if(flag)b/=10;
		return b;
	}
/*
	@Override
	public boolean onMenuItemClick(MenuItem item) {
		switch (item.getItemId()) {

		case R.id.sin:
			s1+="Sin";
        	txtView.setText(s1);
			return true;
		case R.id.cos:
			s1+="Cos";
        	txtView.setText(s1);
			return true;
		case R.id.tan:
			s1+="Tan";
        	txtView.setText(s1);
			return true;
		case R.id.sin_in:
			s1+="sin^-1";
        	txtView.setText(s1);
			return true;
		case R.id.cos_in:
			s1+="cos^-1";
        	txtView.setText(s1);
			return true;
		case R.id.tan_in:
			s1+="tan^-1";
        	txtView.setText(s1);
			return true;
		case R.id.log:
			s1+="Log";
        	txtView.setText(s1);
			return true;
		case R.id.ln:
			s1+="ln";
        	txtView.setText(s1);
			return true;
		case R.id.sqrt:
			s1+="sqrt";
        	txtView.setText(s1);
			return true;
		case R.id.cbrt:
			s1+="cbrt";
        	txtView.setText(s1);
			return true;
		case R.id.frt:
			s1+="cbrt";
        	txtView.setText(s1);
			return true;
		default:
			return false;
		}

		
	}
	*/	
////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////

@Override
public boolean onMenuItemClick(MenuItem item) {
	switch (item.getItemId()) {
/*
	case R.id.sin:
		s1+="Sin";
    	txtView.setText(s1);
		return true;
	case R.id.cos:
		s1+="Cos";
    	txtView.setText(s1);
		return true;
	case R.id.tan:
		s1+="Tan";
    	txtView.setText(s1);
		return true;
	case R.id.sin_in:
		s1+="sin^-1";
    	txtView.setText(s1);
		return true;
	case R.id.cos_in:
		s1+="cos^-1";
    	txtView.setText(s1);
		return true;
	case R.id.tan_in:
		s1+="tan^-1";
    	txtView.setText(s1);
		return true;
	case R.id.log:
		s1+="Log";
    	txtView.setText(s1);
		return true;
	case R.id.ln:
		s1+="ln";
    	txtView.setText(s1);
		return true;
	case R.id.sqrt:
		s1+="sqrt";
    	txtView.setText(s1);
		return true;
	case R.id.cbrt:
		s1+="cbrt";
    	txtView.setText(s1);
		return true;
	case R.id.frt:
		s1+="cbrt";
    	txtView.setText(s1);
		return true;
		
		*/
	default:
		return false;
	}
}

	
}
