//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Frame1_run_actionAdapter implements ActionListener {
    Frame1 adaptee;

    Frame1_run_actionAdapter(Frame1 adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        this.adaptee.run_actionPerformed(e);
    }
}
