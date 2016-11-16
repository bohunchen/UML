package Mode;

import Line.AssoLine;

import java.awt.event.MouseEvent;

/**
 * Created by NiHao on 2016/10/25.
 */
public class AssoMode extends DrawLineMode{
    @Override
    public void showMode() {
        System.out.println("AssoMode");
    }
    public void mouseClicked(MouseEvent e){
    }
    public void mousePressed(MouseEvent e){
        lineObj = new AssoLine();
        super.mousePressed(e);
    }
    public void mouseReleased(MouseEvent e){
        super.mouseReleased(e);
    }
    public void mouseDragged(MouseEvent e){}
}
