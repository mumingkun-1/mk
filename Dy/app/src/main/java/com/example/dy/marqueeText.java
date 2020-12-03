package com.example.dy;

import android.graphics.Rect;
import android.widget.TextView;
import android.content.Context;
import android.util.AttributeSet;
public class marqueeText extends TextView {
    boolean isfocus;
    public marqueeText(Context context) {
        super(context);
    }
    public marqueeText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public marqueeText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    @Override
    public boolean isFocused() {
        return true;
    }

    @Override
    protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {

    }
}
