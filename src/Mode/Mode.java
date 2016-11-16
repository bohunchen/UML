package Mode;

import java.awt.event.MouseEvent;

/**
 * Created by NiHao on 2016/10/24.
 */

public abstract class Mode {
    public abstract void showMode();
    public abstract void mouseClicked(MouseEvent e);
    public abstract void mousePressed(MouseEvent e);
    public abstract void mouseReleased(MouseEvent e);
    public abstract void mouseDragged(MouseEvent e);
}
