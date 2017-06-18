package sample.kingja.gestures;

import android.support.v4.view.VelocityTrackerCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;

/**
 * Description：TODO
 * Create Time：2017/6/1722:59
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class TrackingMovementActivity extends AppCompatActivity {
    private  final String TAG = "TrackingMovementActivity";
    private VelocityTracker mVelocityTracker = null;
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int index = event.getActionIndex();
        int action = event.getActionMasked();
        int pointerId = event.getPointerId(index);

        switch(action) {
            case MotionEvent.ACTION_DOWN:
                if(mVelocityTracker == null) {
                    // Retrieve a new VelocityTracker object to watch the velocity of a motion.
                    mVelocityTracker = VelocityTracker.obtain();
                }
                else {
                    // Reset the velocity tracker back to its initial state.
                    mVelocityTracker.clear();
                }
                // Add a user's movement to the tracker.
                mVelocityTracker.addMovement(event);
                break;
            case MotionEvent.ACTION_MOVE:
                mVelocityTracker.addMovement(event);
                // When you want to determine the velocity, call
                // computeCurrentVelocity(). Then call getXVelocity()
                // and getYVelocity() to retrieve the velocity for each pointer ID.
                mVelocityTracker.computeCurrentVelocity(1000);
                // Log velocity of pixels per second
                // Best practice to use VelocityTrackerCompat where possible.
                Log.e(TAG, "X : " +
                        VelocityTrackerCompat.getXVelocity(mVelocityTracker,
                                pointerId)+" Y : " +
                        VelocityTrackerCompat.getYVelocity(mVelocityTracker,
                                pointerId));
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                // Return a VelocityTracker object back to be re-used by others.
                mVelocityTracker.recycle();
                mVelocityTracker=null;
                break;
        }
        return true;
    }
}
