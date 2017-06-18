package sample.kingja.gestures;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class GestureActivity extends AppCompatActivity {
    public  final String TAG = getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GestureView gestureView = (GestureView) findViewById(R.id.gestureView);
//        gestureView.setOnTouchListener(new View.OnTouchListener() {
//
//
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                Log.e(TAG, "onTouch: ");
//                return true;
//            }
//        });

    }
}
