import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Frame1_runButton_actionAdapter implements ActionListener {

    Frame1 adaptee;

    public Frame1_runButton_actionAdapter(Frame1 frame1) {
        this.adaptee = frame1;
    }

    public void actionPerformed(ActionEvent e) {
        this.adaptee.runButton_actionPerformed(e);
    }
}
