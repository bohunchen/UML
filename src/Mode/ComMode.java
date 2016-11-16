package Mode;

import Line.ComLine;
import Line.GenLine;

import java.awt.event.MouseEvent;

/**
 * Created by NiHao on 2016/10/27.
 */
public class ComMode extends DrawLineMode{
    @Override
    public void showMode() {
        System.out.println("GenMode");
    }
    public void mouseClicked(MouseEvent e){
    }
    public void mousePressed(MouseEvent e){
        lineObj = new ComLine();
        super.mousePressed(e);
    }
    public void mouseReleased(MouseEvent e){
        super.mouseReleased(e);
    }
    public void mouseDragged(MouseEvent e){}
}
