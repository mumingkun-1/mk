package com.example.dy;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;
import java.util.Map;

import android.widget.ImageView;
import android.widget.TextView;
public class ListViewAdapter extends BaseAdapter {
    private Context context;
    private List<Peoplemessage> listitem;

    public void setData(List l_) {
        listitem = l_;
    }
    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return listitem.size();
    }

    @Override
    public Object getItem(int position) {
        return listitem.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    private Bitmap getBitmap(Drawable drawable) {
        Bitmap bitmap = Bitmap.createBitmap(
                drawable.getIntrinsicWidth(),
                drawable.getIntrinsicHeight(),
                drawable.getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888
                        : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bitmap);
        //canvas.setBitmap(bitmap);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        drawable.draw(canvas);
        return bitmap;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = View.inflate(context, R.layout.listviewfriend, null);
        Peoplemessage pe = listitem.get(position);
        ImageView iv = (ImageView) view.findViewById(R.id.fmiv);
        TextView tv1 = (TextView) view.findViewById(R.id.fmtv1);
        TextView tv2 = (TextView) view.findViewById(R.id.fmtv2);


        System.out.println(R.id.fmiv + " compare " + pe.getDraw());

        iv.setImageResource(pe.getDraw());
        ImageView imageView = (ImageView) view.findViewById(R.id.fmiv);

        Bitmap bitmap;

        Drawable drawable = iv.getDrawable();
//        bitmap = getBitmap(drawable);
//        bitmap = circleBitmapByShader(bitmap, bitmap.getWidth() / 2);
//
//        iv.setImageBitmap(bitmap);
//
//        drawable = new BitmapDrawable(bitmap);

        BitmapDrawable bd = (BitmapDrawable)drawable;
        bitmap = bd.getBitmap();

        bitmap = circleBitmapByShader(bitmap, bitmap.getWidth() / 2);
        iv.setImageBitmap(bitmap);
        tv1.setText(pe.getName());
        tv2.setText(pe.getMess());


        return view;
    }


    private Bitmap circleBitmapByShader(Bitmap bitmap, int edgeWidth) {

        if(bitmap == null) {
            throw new NullPointerException("Bitmap can't be null");
        }

        float btWidth = bitmap.getWidth();
        float btHeight = bitmap.getHeight();
        // 水平方向开始裁剪的位置
        float btWidthCutSite = 0;
        // 竖直方向开始裁剪的位置
        float btHeightCutSite = 0;
        // 裁剪成正方形图片的边长，未拉伸缩放
        float squareWidth = 0f;
        if(btWidth > btHeight) { // 如果矩形宽度大于高度
            btWidthCutSite = (btWidth - btHeight) / 2f;
            squareWidth = btHeight;
        } else { // 如果矩形宽度不大于高度
            btHeightCutSite = (btHeight - btWidth) / 2f;
            squareWidth = btWidth;
        }

        // 设置拉伸缩放比
        float scale = edgeWidth * 1.0f / squareWidth;
        Matrix matrix = new Matrix();
        matrix.setScale(scale, scale);

        // 将矩形图片裁剪成正方形并拉伸缩放到控件大小
        Bitmap squareBt = Bitmap.createBitmap(bitmap, (int)btWidthCutSite, (int)btHeightCutSite, (int)squareWidth, (int)squareWidth, matrix, true);

        // 初始化绘制纹理图
        BitmapShader bitmapShader = new BitmapShader(squareBt, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);

        // 初始化目标bitmap
        Bitmap targetBitmap = Bitmap.createBitmap(edgeWidth, edgeWidth, Bitmap.Config.ARGB_8888);

        // 初始化目标画布
        Canvas targetCanvas = new Canvas(targetBitmap);

        // 初始化画笔
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setShader(bitmapShader);

        // 利用画笔绘制圆形图
        targetCanvas.drawRoundRect(new RectF(0, 0, edgeWidth, edgeWidth), edgeWidth, edgeWidth, paint);

        return targetBitmap;
    }
}
