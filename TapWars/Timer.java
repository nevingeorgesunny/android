package com.nevinsunnyapplication.tapwar;
import org.andengine.engine.handler.IUpdateHandler;

public class Timer implements IUpdateHandler {
     
        private ITimerCallback mCallback;
        private double mInterval;
        private double mSecondsElapsed;
        public Timer(final double pInterval, final ITimerCallback pCallback) {
                this.mInterval = pInterval;
                this.mCallback = pCallback;
        }
       
        public void setInterval(final float pInterval) {
                this.mInterval = pInterval;
        }
      
        @Override
        public void onUpdate(float pSecondsElapsed) {
        	this.mSecondsElapsed+= pSecondsElapsed;
            if(this.mSecondsElapsed >= this.mInterval) {
                        this.mSecondsElapsed -= this.mInterval;
                        this.mCallback.onTick();
            }   
        }
        @Override
        public void reset() {
                this.mSecondsElapsed = 0;
               
        }
    
        public interface ITimerCallback {
                public void onTick();
        }
}