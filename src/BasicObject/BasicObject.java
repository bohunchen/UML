package BasicObject;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by NiHao on 2016/10/24.
 */
public class BasicObject extends Shape{
    private Port[] ports;
    public BasicObject(){
        super();
    }

    public BasicObject(int x,int y,int w,int h){

        System.out.println("BasicObject constr");
        setLocate(x,y);
        setSize(w,h);
        ports = new Port[4];
        createPorts();
    }

    public void createPorts(){
        System.out.println("BasicObject createPorts");
        System.out.println("(X,Y) -> "+getX()+" "+getY());
        System.out.println("(W,H) -> "+getWidth()+" "+getHeight());
        /* Top-> Right-> Bottom-> Left*/
        double[] x_dir = { 0.5, 1, 0.5, 0};
        double[] y_dir = { 0, 0.5, 1, 0.5};
        for (int i = 0; i < 4 ; i++) {
            ports[i] = new Port();
            int c_x = (int)(getX() + x_dir[i] * getWidth());
            int c_y = (int)(getY() + y_dir[i] * getHeight());
            ports[i].setCentralLocate( c_x,c_y );
            ports[i].setPortNum(i);
        }
    }

    public void showPorts(boolean choose){
        for (int i = 0; i < ports.length; i++) {
            ports[i].setVisible(choose);
        }
    }

    public void draw(Graphics g){
        System.out.println("BasicObject draw");
        for (int i = 0; i < ports.length; i++) {
            ports[i].draw(g);
        }
    }

    public void objMove(int moveX,int moveY){
        setLocate(getX()+moveX, getY()+moveY);
        for(int i=0;i<ports.length;i++){
            ports[i].setCentralLocate(ports[i].getX()+moveX, ports[i].getY()+moveY);
        }
    }

    public Port findPort(int x,int y){
        int[] dis = new int[4];
        int min = 999999;
        int portIdx = -1;
        for (int i = 0; i < ports.length ; i++) {
            dis[i] = ( ports[i].getX() - x ) * ( ports[i].getX() - x )+
                    ( ports[i].getY() - y )*( ports[i].getY() - y );
            if( dis[i] < min ){
                min = dis[i];
                portIdx = i;
            }
        }
        System.out.println("BasicObject findPort "+portIdx);
        if( ports[portIdx].isConnected() == false)
            return ports[portIdx];
        else
            return null;
    }

    public ArrayList<Port> getPortArrayList(){
        ArrayList<Port> list = new  ArrayList<Port>();
        for (Port p : ports) {
            list.add(p);
        }
        return list;
    }
}
