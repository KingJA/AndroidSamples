package sample.kingja.canvas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import sample.kingja.canvas.clip.ClipActivity;
import sample.kingja.fontMetrics.FontMetricsActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goClipActivity(View view) {
        startActivity(new Intent(this, ClipActivity.class));
    }

    public void goFontMetricsActivity(View view) {
        startActivity(new Intent(this, FontMetricsActivity.class));
    }
}
