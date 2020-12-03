package com.example.helloworld;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.sql.BatchUpdateException;
import java.util.Timer;
import java.util.TimerTask;

import static android.graphics.BitmapFactory.*;


public class MainActivity extends Activity {

    private Button btnOne, btnTwo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RoundImageView roundImageView = (RoundImageView) findViewById(R.id.iv);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.mm1);
        Log.d("MainText", "Bitmap");
        roundImageView.setBitmap(bitmap);



    }
}