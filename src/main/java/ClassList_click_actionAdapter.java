import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClassList_click_actionAdapter implements ActionListener {
    JComponent adaptee;

    ClassList_click_actionAdapter(JList adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //this.adaptee.acti
    }
}
