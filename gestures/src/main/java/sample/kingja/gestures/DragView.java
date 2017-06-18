package sample.kingja.gestures;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.support.v4.view.GestureDetectorCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.Scroller;

/**
 * Description：
 * 1.绘制背景
 * 2.绘制按钮
 * public void startScroll(int startX, int startY, int dx, int dy, int duration)
 * dx,dy正数正价，负数减少
 * Create Time：2017/6/1812:40
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class DragView extends View {
    private final String TAG = getClass().getSimpleName();
    private int lastX;
    private int downX;
    private Scroller mScroller;
    private Paint mPaint;
    private float width;
    private float height;
    private GestureDetectorCompat mDetector;
    private int mSlop;
    private int distanceX;
    private boolean singleClick;

    public DragView(Context context) {
        this(context, null);
    }

    public DragView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DragView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initDragView();
    }

    private void initDragView() {
        mDetector = new GestureDetectorCompat(getContext(), new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                Log.e(TAG, "onSingleTapUp: ");
                singleClick = true;
                return true;
            }
        });
        mScroller = new Scroller(getContext());
        mSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        Log.e(TAG, "mSlop: " + mSlop);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaint.setColor(0xff00ff00);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        height = getMeasuredHeight();
        width = getMeasuredWidth();
    }

    private float leftX;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (leftX < 0) {
            leftX = 0;
        }
        if (leftX > width / 2) {
            leftX = width / 2;
        }
        canvas.drawRect(leftX, 0, width / 2 + leftX, height, mPaint);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mDetector.onTouchEvent(event);

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                singleClick = false;
                Log.e(TAG, "ACTION_DOWN: " );
                downX = lastX = (int) event.getX();
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e(TAG, "ACTION_MOVE: " );
                float dx = event.getX() - lastX;
                leftX += dx;
                lastX = (int) event.getX();
                distanceX = (int) Math.abs(event.getX() - downX);
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
                Log.e(TAG, "singleClick: "+singleClick );
                if (singleClick) {
                    break;
                }
                Log.e(TAG, "ACTION_UP: " );
                if (leftX >= width / 4f) {
                    mScroller.startScroll((int) leftX, 0, (int) (width / 2 - leftX), 0, 5);
                } else {
                    mScroller.startScroll((int) leftX, 0, (int) -leftX, 0, 5);
                }
                invalidate();
                break;

            default:
                break;
        }
        return true;
    }

    @Override
    public void computeScroll() {
        if (mScroller.computeScrollOffset()) {
            Log.e(TAG, "mScroller.getCurrX(): " + mScroller.getCurrX() + " mScroller.getCurrY(): " + mScroller.getCurrY());
            leftX = mScroller.getCurrX();
            invalidate();
        }
    }
}
