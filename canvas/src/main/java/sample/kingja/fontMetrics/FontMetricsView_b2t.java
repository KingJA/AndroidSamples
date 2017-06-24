package sample.kingja.fontMetrics;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Description:TODO
 * Create Time:2017/6/24 13:15
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class FontMetricsView_b2t extends View {
    private static final String TAG = "FontMetricsView";
    private float baseX;
    private float baseY;
    private Paint paint;
    private String text = "Google 你好|KingJA";
    private float ascent;
    private float bottom;
    private float top;
    private float descent;
    private int measuredWidth;
    private int measuredHeight;
    private float textWidth;
    private float fontHeight;
    private float fontMiddleY;


    public FontMetricsView_b2t(Context context) {
        super(context);

    }

    public FontMetricsView_b2t(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setTextSize(80);
        paint.setColor(0xff000000);
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        top = fontMetrics.top;
        ascent = fontMetrics.ascent;
        descent = fontMetrics.descent;
        bottom = fontMetrics.bottom;
        Log.e(TAG, "top: "+top );
        Log.e(TAG, "ascent: "+ascent );
        Log.e(TAG, "descent: "+descent );
        Log.e(TAG, "bottom: "+bottom );
        fontHeight = bottom - top;
//        fontHeight = descent - ascent;

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        measuredWidth = getMeasuredWidth();
        measuredHeight = getMeasuredHeight();
        textWidth = paint.measureText(text);
        baseX = measuredWidth * 0.5f - textWidth * 0.5f;
        baseY = measuredHeight * 0.5f+(0.5f*fontHeight-bottom);

//        float offsetY=0.5f*fontHeight-bottom;
//        baseY+=offsetY;
        fontMiddleY = baseY + top + 0.5f * fontHeight;
    }

    @Override
    protected void onDraw(Canvas canvas) {

             /*rect*/
        paint.setColor(0xffb36680);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawRect(baseX, baseY + top, baseX + textWidth, baseY + bottom, paint);

        paint.setColor(0xff000000);
        canvas.drawText(text, baseX, baseY, paint);
        paint.setTextSize(25);
            /*base*/
        paint.setColor(0xff000000);
        canvas.drawLine(baseX, baseY, baseX + textWidth, baseY, paint);
        canvas.drawText("base", baseX + textWidth, baseY, paint);
            /*top*/
        paint.setColor(0xff00765c);
        canvas.drawLine(baseX, baseY + top, baseX + textWidth, baseY + top, paint);
        canvas.drawText("top", baseX + textWidth, baseY + top, paint);

            /*bottom*/
        paint.setColor(0xffff0000);
        canvas.drawLine(baseX, baseY + bottom, baseX + textWidth, baseY + bottom, paint);
        canvas.drawText("bottom", baseX + textWidth, baseY + bottom + 20, paint);

            /*ascent*/
        paint.setColor(0xff00ff00);
        canvas.drawLine(baseX, baseY + ascent, baseX + textWidth, baseY + ascent, paint);
        canvas.drawText("ascent", baseX + textWidth, baseY + ascent + 20, paint);

            /*descent*/
        paint.setColor(0xff0000ff);

        canvas.drawLine(baseX, baseY + descent, baseX + textWidth, baseY + descent, paint);
        canvas.drawText("descent", baseX + textWidth, baseY + descent, paint);

        /*font middle line*/
        paint.setColor(0xffffffff);
        canvas.drawLine(baseX, fontMiddleY, baseX + textWidth, fontMiddleY,
                paint);
        canvas.drawText("font middle", baseX + textWidth, fontMiddleY+10, paint);
        /*middle line*/
        paint.setColor(0xff2d04a6);
        canvas.drawLine(0, 0.5f * measuredHeight, measuredWidth, 0.5f * measuredHeight, paint);
    }
}