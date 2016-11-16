package Btn;

import Mode.Mode;

import javax.swing.*;

/**
 * Created by NiHao on 2016/10/25.
 */
public class Btn extends JButton {
    private Mode mode;
    private String name;
    private boolean used;

    public Btn(){
        used = false;
    }
    public void setName(String s){
        name = s;
    }
    public String getName(){
        return name;
    }
    public void setMode(Mode m){
        mode = m;
    }
    public Mode getMode(){
        return mode;
    }


    public boolean getUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

}
