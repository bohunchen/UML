package BasicObject;

import java.awt.*;

/**
 * Created by NiHao on 2016/10/24.
 */
public abstract class Shape {
    private String objName;
    /* UseClass Class Part */
    private int x;
    private int y;
    private int width;
    private int height;
    /* ports */
    private Port[] ports;
    /* Line Part */
    private Port frontPort;
    private Port endPort;

    public Shape(){
        System.out.println("Shape constr");
       // x = y = width = height = 0;
        objName = "";
        frontPort = endPort = null;
    }

    public void setSize(int width,int height){
        this.width = width;
        this.height = height;
    }
    public void setLocate(int x,int y){
        this.x = x;
        this.y = y;
    }
    public void setObjName( String str ){ objName = str; }
    public void setFrontPort(Port p){ frontPort = p; }
    public void setEndPort(Port p){ endPort = p; }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }
    public Port getFrontPort(){ return frontPort; }
    public Port getEndPort(){ return endPort; }
    public String getObjName(){ return objName; }

    public void showPorts(boolean isShow){
    }

    public void objMove(int moveX,int moveY){}

    public Port findPort(int x,int y){
        return null;
    }
    public abstract void draw(Graphics g);
}
