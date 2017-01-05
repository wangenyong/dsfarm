package com.wangenyong.dsfarm.module.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;

import com.wangenyong.dsfarm.R;

/**
 * Created by wangenyong on 2017/1/5.
 */

public class LevelView extends View {

    private Context mContext;
    private int mWidth, mHeight;

    private Paint mPaintB = new Paint();
    private Paint mPaintF = new Paint();
    private Paint mPaintT = new Paint();

    public LevelView(Context context) {
        this(context, null);
    }

    public LevelView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initPaint();
    }

    private void initPaint() {
        mPaintB.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaintB.setColor(ContextCompat.getColor(mContext, R.color.barBgLevelView));
        mPaintB.setAntiAlias(true);
        mPaintB.setStrokeWidth(10);

        mPaintF.setStyle(Paint.Style.FILL);
        mPaintF.setColor(ContextCompat.getColor(mContext, R.color.barLevelView));
        mPaintF.setAntiAlias(true);

        mPaintT.setStyle(Paint.Style.FILL);
        mPaintT.setColor(Color.BLACK);
        mPaintT.setAntiAlias(true);
        mPaintT.setTextSize(50);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(ContextCompat.getColor(mContext, R.color.bgLevelView));
        canvas.translate(0, mHeight / 2);

        RectF rectFB = new RectF(getPaddingLeft(),-10,mWidth-getPaddingRight(),10);
        canvas.drawRoundRect(rectFB, 10, 10, mPaintB);
        RectF rectFF = new RectF(getPaddingLeft(),-10,mWidth/3,10);
        canvas.drawRoundRect(rectFF, 10, 10, mPaintF);
    }

}
