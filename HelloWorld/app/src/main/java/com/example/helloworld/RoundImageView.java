package com.example.helloworld;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Region;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;


public class RoundImageView extends ImageView {
    private Bitmap mBitmap;
    private Rect mRect = new Rect();
    private PaintFlagsDrawFilter pdf = new PaintFlagsDrawFilter(0, Paint.ANTI_ALIAS_FLAG);
    private Paint mPaint = new Paint();
    private Path mPath=new Path();
    public RoundImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }


    //传入一个Bitmap对象
    public void setBitmap(Bitmap bitmap) {
        this.mBitmap = bitmap;
    }


    private void init() {
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setFlags(Paint.ANTI_ALIAS_FLAG);
        mPaint.setAntiAlias(true);// 抗锯尺
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(mBitmap == null)
        {
            return;
        }
        Log.d("DrwaText", mBitmap.getWidth() + " -- " + mBitmap.getHeight());
        mRect.set(0,0,getWidth(),getHeight());
        canvas.save();
        canvas.setDrawFilter(pdf);
        mPath.addCircle(getWidth() / 2, getWidth() / 2, getWidth() / 2, Path.Direction.CCW);

        if(Build.VERSION.SDK_INT >= 28){
            canvas.clipPath(mPath);
        }else {
            //canvas.clipPath(mPath, Region.Op.REPLACE);
            canvas.clipPath(mPath, Region.Op.XOR);
        }
        canvas.drawBitmap(mBitmap, null, mRect, mPaint);

        canvas.restore();
    }
}
