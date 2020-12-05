package com.example.dy;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private ListViewAdapter myAdapter;

    int [] imageId = new int [] {
            R.drawable.mm,
            R.drawable.mm1,
            R.drawable.mm2,
            R.drawable.mm3,
            R.drawable.mm,
            R.drawable.mm,
            R.drawable.mm,R.drawable.mm,R.drawable.mm,R.drawable.mm,R.drawable.mm,R.drawable.mm,R.drawable.mm,R.drawable.mm
    };
    String[] title = new String[] {"1","2","3","4","5","6","7","8","9","10","11","12","13","14",};
    String[] mess = new String[] {"123你好我亲爱的祖国我爱你爱人民爱大江山河","你好你好我亲爱的祖国我爱你爱人民爱大江山河","你好你好我亲爱的祖国我爱你爱人民爱大江山河","你好你好我亲爱的祖国我爱你爱人民爱大江山河","你好","你好","你好","你好","你好","你好","你好","你好","你好","你好你好，我亲爱的祖国，我爱你，爱人民，爱大江山"};
    private TextView textView1, textView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        listView = this.findViewById(R.id.lv);

        myAdapter = new ListViewAdapter();
        myAdapter.setContext(this);
        myAdapter.setData(getList());
        listView.setAdapter(myAdapter);
        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Peoplemessage pe = (Peoplemessage) myAdapter.getItem(position);
                Toast.makeText(MainActivity.this, pe.getName() + pe.getMess() + "", Toast.LENGTH_SHORT).show();
            }
        });
        //init();
    }
    public void init() {

        textView2 = findViewById(R.id.fmtv2);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView2.setEllipsize(TextUtils.TruncateAt.MARQUEE);
                textView2.setFocusable(true);
                textView2.setFocusableInTouchMode(true);
                textView2.requestFocus();
            }
        });
    }
    private List<Peoplemessage> getList() {
        List<Peoplemessage> list = new ArrayList<Peoplemessage>();
        for(int i = 0; i < imageId.length; i++) {
            Peoplemessage pe =new Peoplemessage();
            pe.setDrawid(imageId[i]);
            pe.setName(title[i]);
            pe.setMess(mess[i]);
            list.add(pe);
        }
        return list;




    }
}
