package UML_Editor;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import BasicObject.Shape;
import Btn.BtnPanel;
import Mode.*;
import com.sun.org.apache.bcel.internal.generic.SWAP;

/**
 * Created by NiHao on 2016/10/24.
 */
public class MyCanvas extends Canvas implements MouseListener,MouseMotionListener{

    private static MyCanvas instance = null;
    private ArrayList<Shape> shapeList;
    private Mode currentMode;
    private Point pressedPoint;
    private Point releasedPoint;

    public MyCanvas(){
        setBackground(Color.pink);
        addMouseListener(this);
        addMouseMotionListener(this);
        shapeList = new ArrayList<Shape>();
        currentMode = new ClassMode();
        pressedPoint = new Point();
        releasedPoint = new Point();
    }
    public void setCurrentMode( Mode m ){
        currentMode = m;
    }
    public Mode getCurrentMode() {
        return currentMode;
    }
    public static MyCanvas getInstance(){
        if( instance == null){
            instance = new MyCanvas();
        }
        return instance;
    }

    public void addShape(Shape obj){
        shapeList.add(obj);
    }

    public Shape getLastShape(){
        return shapeList.get( shapeList.size()-1 );
    }

    public void delLastShape(){
        shapeList.remove( shapeList.size()-1 );
    }

    public void delShape(Shape obj){
        shapeList.remove(obj);
    }

    public void paint(Graphics g){
        for(int i=0;i<shapeList.size();i++){
            shapeList.get(i).draw(g);
        }
    }

    public Shape getShapeByIdx(int idx){
        return shapeList.get(idx);
    }

    public int getShapeListSize(){
        return shapeList.size();
    }

    public void removeShape(Shape s){
        shapeList.remove(s);
    }

    public int findObj(int mouse_x,int mouse_y){
        for (int i = 0; i < shapeList.size() ; i++) {
            int x = shapeList.get(i).getX();
            int y = shapeList.get(i).getY();
            int w = shapeList.get(i).getWidth();
            int h = shapeList.get(i).getHeight();
            if( mouse_x >= x && mouse_x <=x+w && mouse_y>=y && mouse_y<=y+h )
                return i;
        }
        return -1;
    }

    public ArrayList<Shape> findGroupObj(int x1,int y1,int x2,int y2){

        ArrayList<Shape> list = new ArrayList<Shape>();
        for (int i = 0; i < shapeList.size() ; i++) {
            int x = shapeList.get(i).getX();
            int y = shapeList.get(i).getY();
            int w = shapeList.get(i).getWidth();
            int h = shapeList.get(i).getHeight();
            if( x1 <= x && x<=x2 && y1<=y && y<=y2
                    && x1 <= x+w && x+w<=x2  && y1 <= y+h && y+h<=y2){
                list.add( shapeList.get(i) );
            }
        }
        return list;
    }

    public Point getPressedPoint() {
        return pressedPoint;
    }

    public void setPressedPoint(Point pressedPoint) {
        this.pressedPoint = pressedPoint;
    }

    public Point getReleasedPoint() {
        return releasedPoint;
    }

    public void setReleasedPoint(Point releasedPoint) {
        this.releasedPoint = releasedPoint;
    }

    public void mouseClicked(MouseEvent e) {
        System.out.println("MyCanvas mouseClicked");
        currentMode.mouseClicked(e);
    }
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {
        System.out.println("MyCanvas mousePressed");
        currentMode.mousePressed(e);
    }
    public void mouseReleased(MouseEvent e) {
        System.out.println("MyCanvas mouseReleased");
        currentMode.mouseReleased(e);
        repaint();
    }
    public void mouseMoved(MouseEvent e) {
    }
    public void mouseDragged(MouseEvent e) {
        System.out.println("MyCanvas mouseDragged");
        currentMode.mouseDragged(e);
        repaint();
    }
}
