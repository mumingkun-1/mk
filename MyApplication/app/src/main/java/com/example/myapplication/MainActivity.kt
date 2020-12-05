package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener{
    private val msgList = ArrayList<Msg>()
    private var adapter : MsgAdapter? = null
    override fun onClick(v: View?) {
        when(v) {
            send -> {
                val content = et1.text.toString()
                if(content.isNotEmpty()) {
                    val msg = Msg(content, Msg.TYPE_SENT)
                    msgList.add(msg)
                    adapter?.notifyItemInserted(msgList.size - 1)
                    recycleview.scrollToPosition(msgList.size - 1)
                    et1.setText("")
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initMsg()
        val layoutListener = LinearLayoutManager(this)
        recycleview.layoutManager = layoutListener
        adapter = MsgAdapter(msgList)
        recycleview.adapter = adapter
        send.setOnClickListener(this)

    }

    private fun initMsg() {
        val msg1 = Msg("Hello guy.", Msg.TYPE_RECEIVE);
        msgList.add(msg1)
        val msg2 = Msg("Hello. Who is that", Msg.TYPE_SENT);
        msgList.add(msg2);

        repeat(4) {
            msgList.add(msg1)
            msgList.add(msg2)
        }
    }
}
