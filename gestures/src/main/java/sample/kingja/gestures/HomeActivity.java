package sample.kingja.gestures;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Description：TODO
 * Create Time：2017/6/1723:01
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class HomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void goTrackingMovementActivity(View view) {
        startActivity(new Intent(this, TrackingMovementActivity.class));

    }

    public void goTouchableAreaActivity(View view) {
        startActivity(new Intent(this, TouchableAreaActivity.class));

    }

    public void goDragViewActivity(View view) {
        startActivity(new Intent(this, DragViewActivity.class));
    }

    public void goScrollActivity(View view) {
        startActivity(new Intent(this, ScrollActivity.class));
    }
}
