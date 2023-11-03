import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClassList_click_actionAdapter implements ListSelectionListener {
    Frame1 adaptee;

    ClassList_click_actionAdapter(Frame1 adaptee) {
        this.adaptee = adaptee;
    }


    @Override
    public void valueChanged(ListSelectionEvent e) {
        this.adaptee.classList_actionPerformed(e);

    }
}
