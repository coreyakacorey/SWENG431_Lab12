import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OpenFileButton_Click_actionAdapter implements ActionListener {
    Frame1 adaptee;

    OpenFileButton_Click_actionAdapter(Frame1 adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        this.adaptee.opeFile_actionPerformed(e);
    }
}
