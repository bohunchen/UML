package BasicObject;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Created by NiHao on 2016/10/24.
 */
public class Port {
    private boolean visible;
    private int portNum;
    private boolean isConnected;
    private final int portLen = 12;
    private int x;
    private int y;
    public Port(){
        x = y = 0;
        visible = isConnected = false;
    }
    public void setCentralLocate(int x,int y){
        this.x = x;
        this.y = y;
    }
    public int getLocateX(){
        return x - portLen/2;
    }
    public int getLocateY(){
        return y - portLen/2;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public void setPortNum(int t){ portNum = t;};
    public int getPortNum(){ return  portNum; };

    public void setVisible(boolean visible){
        this.visible = visible;
    }

    public boolean isConnected() {
        return isConnected;
    }

    public void setConnected(boolean connected) {
        isConnected = connected;
    }

    public void draw(Graphics g){
        //System.out.println("port draw");
        if(visible == true){
            g.setColor(Color.BLACK);
            g.fillRect(x - portLen/2, y - portLen/2, portLen, portLen);
        }
    }


}
