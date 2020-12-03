package com.example.dy;

public class Peoplemessage {
    private int drawid;
    private String name;
    private String mess;
    private int getDrawid (){
        return drawid;
    }
    public void setDrawid(int draw_Id) {
        this.drawid = draw_Id;
    }
    public int getDraw() {
        return drawid;
    }
    public String getName() {
        return name;
    }
    public void setName(String nickname) {
        this.name = nickname;
    }
    public String getMess() {
        return mess;
    }
    public void setMess(String Mess) {
        this.mess = Mess;
    }
}
