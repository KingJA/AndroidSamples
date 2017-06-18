package sample.kingja.gestures;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.view.GestureDetectorCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * Description：TODO
 * Create Time：2017/6/1521:37
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class GestureView extends View {
    private String TAG = getClass().getSimpleName();
    private GestureDetectorCompat mDetector;

    public GestureView(Context context) {
        this(context, null);
    }

    public GestureView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public GestureView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initGestures();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
//        mDetector.onTouchEvent(event);
//        return super.onTouchEvent(event);
        switch(event.getAction()) {
            case (MotionEvent.ACTION_DOWN) :
                Log.d(TAG,"Action was DOWN");
                return true;
            case (MotionEvent.ACTION_MOVE) :
                Log.d(TAG,"Action was MOVE");
                return true;
            case (MotionEvent.ACTION_UP) :
                Log.d(TAG,"Action was UP");
                return true;
            case (MotionEvent.ACTION_CANCEL) :
                Log.d(TAG,"Action was CANCEL");
                return true;
            case (MotionEvent.ACTION_OUTSIDE) :
                Log.d(TAG,"Movement occurred outside bounds " +
                        "of current screen element");
                return true;
            default :
                return super.onTouchEvent(event);
        }
    }

    private void initGestures() {
        mDetector = new GestureDetectorCompat(getContext(), new MyGestureListener());
    }


    class MyGestureListener extends GestureDetector.SimpleOnGestureListener {
        private static final String DEBUG_TAG = "Gestures";

        @Override
        public boolean onDown(MotionEvent event) {
            Log.d(TAG, "onDown: " + MotionEvent.actionToString(event.getAction()));
            return true;
        }

        @Override
        public boolean onFling(MotionEvent event1, MotionEvent event2,
                               float velocityX, float velocityY) {
            Log.d(TAG, "onFling: " + MotionEvent.actionToString(event1.getAction()) + MotionEvent.actionToString(event2.getAction()));
            return true;
        }

        @Override
        public void onLongPress(MotionEvent event) {
            Log.d(TAG, "onLongPress: " + MotionEvent.actionToString(event.getAction()));
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
                                float distanceY) {
            Log.d(TAG, "onScroll: " + MotionEvent.actionToString(e1.getAction()) + MotionEvent.actionToString(e2.getAction()));
            return true;
        }

        @Override
        public void onShowPress(MotionEvent event) {
            Log.d(TAG, "onShowPress: " + MotionEvent.actionToString(event.getAction()));
        }

        @Override
        public boolean onSingleTapUp(MotionEvent event) {
            Log.d(TAG, "onSingleTapUp: " + MotionEvent.actionToString(event.getAction()));
            return true;
        }

        /*OnDoubleTapListener*/
        @Override
        public boolean onDoubleTap(MotionEvent event) {
        /**/
            Log.d(TAG, "onDoubleTap: " + MotionEvent.actionToString(event.getAction()));
            return true;
        }

        @Override
        public boolean onDoubleTapEvent(MotionEvent event) {
            Log.d(TAG, "onDoubleTapEvent: " + MotionEvent.actionToString(event.getAction()));
            return true;
        }

        @Override
        public boolean onSingleTapConfirmed(MotionEvent event) {
            Log.d(TAG, "onSingleTapConfirmed: " + MotionEvent.actionToString(event.getAction()));
            return true;
        }

        @Override
        public boolean onContextClick(MotionEvent event) {
            Log.d(TAG, "onContextClick: " + MotionEvent.actionToString(event.getAction()));
            return false;
        }
    }
}
