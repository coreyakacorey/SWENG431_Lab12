import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;

public class ClassList_click_actionAdapter implements ListSelectionListener {
    Frame1 adaptee;

    ClassList_click_actionAdapter(Frame1 adaptee) {
        this.adaptee = adaptee;
    }


    /**
     * valueChanged
     * handles change when user selects a list
     * @param e the event that characterizes the change.
     */
    @Override
    public void valueChanged(ListSelectionEvent e) {
        if(e.getValueIsAdjusting() == true) {
            try {
                this.adaptee.classList_actionPerformed(e);
            } catch (MalformedURLException ex) {
                throw new RuntimeException(ex);
            }
        }

    }
}
