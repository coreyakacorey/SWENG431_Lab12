//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class IntDialog2_run_actionAdapter implements ActionListener {
    IntDialog2 adaptee;

    IntDialog2_run_actionAdapter(IntDialog2 adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        this.adaptee.run_actionPerformed(e);
    }
}

