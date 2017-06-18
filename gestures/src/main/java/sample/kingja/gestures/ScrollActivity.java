package sample.kingja.gestures;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Description：scrollBy,scrollTo移动的方向为坐标轴反方向。
 * Create Time：2017/6/1816:56
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class ScrollActivity extends AppCompatActivity {

    private LinearLayout ll_scroll;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll);
        ll_scroll = (LinearLayout) findViewById(R.id.ll_scroll);
    }


    public void onScrollBy(View view) {
        ll_scroll.scrollBy(-100,-100);
    }

    public void onScrollTo(View view) {
        ll_scroll.scrollTo(-100,-100);
    }
}
