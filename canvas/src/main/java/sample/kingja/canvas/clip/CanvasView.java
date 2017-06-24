package sample.kingja.canvas.clip;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Region;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Description:TODO
 * Create Time:2017/6/22 9:31
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class CanvasView extends View {
    private static final String TAG = "CanvasView";
    private int size;
    private Paint circlePaint;
    private Paint clipPaint;

    public CanvasView(Context context) {
        this(context, null);
    }

    public CanvasView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CanvasView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initCanvasView();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        size = Math.max(getMeasuredHeight(),getMeasuredWidth());
    }

    private void initCanvasView() {
        circlePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        circlePaint.setColor(0xff31a753);

        clipPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        clipPaint.setStyle(Paint.Style.STROKE);
        clipPaint.setColor(0xffff0000);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawCircle(0.5f*size,0.5f*size,0.5f*size,circlePaint);
    }
}
