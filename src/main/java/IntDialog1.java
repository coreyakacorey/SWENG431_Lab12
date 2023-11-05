//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.lang.Integer;
import java.lang.*;

public class IntDialog1 extends JDialog {
    JPanel panel1;
    BorderLayout borderLayout1;
    JPanel jPanel1;
    JLabel jLabel1;
    JTextField jTextField1;
    JButton jButton1;
    Object o;
    Class className;
    BorderLayout borderLayout2;
    JPanel jPanel2;
    JPanel jPanel3;
    JPanel jPanel4;

    public IntDialog1(Frame frame, String title, boolean modal) {
        super(frame, title, modal);
        this.panel1 = new JPanel();
        this.borderLayout1 = new BorderLayout();
        this.jPanel1 = new JPanel();
        this.jLabel1 = new JLabel();
        this.jTextField1 = new JTextField();
        this.jButton1 = new JButton();
        this.o = null;
        this.borderLayout2 = new BorderLayout();
        this.jPanel2 = new JPanel();
        this.jPanel3 = new JPanel();
        this.jPanel4 = new JPanel();

        try {
            this.jbInit();
            this.pack();
        } catch (Exception var5) {
            var5.printStackTrace();
        }

    }

    public IntDialog1(Class className) {
        this((Frame)null, "", true);
        this.className = className;
        this.jLabel1.setText(className.getName());
    }

    private void jbInit() throws Exception {
        this.panel1.setLayout(this.borderLayout1);
        this.jButton1.setText("OK");
        this.jButton1.addActionListener(new IntDialog1_jButton1_actionAdapter(this));
        this.jLabel1.setText("               ");
        this.jTextField1.setPreferredSize(new Dimension(100, 20));
        this.jTextField1.setText("");
        this.jTextField1.setHorizontalAlignment(10);
        this.jPanel1.setLayout(this.borderLayout2);
        this.setTitle("WWL Dialog1");
        this.getContentPane().add(this.panel1);
        this.panel1.add(this.jPanel1, "North");
        this.jPanel1.add(this.jPanel2, "North");
        this.jPanel2.add(this.jLabel1, (Object)null);
        this.jPanel1.add(this.jPanel3, "Center");
        this.jPanel3.add(this.jTextField1, (Object)null);
        this.jPanel1.add(this.jPanel4, "South");
        this.jPanel4.add(this.jButton1, (Object)null);
    }

    public Object getObject() {
        return this.o;
    }

    void jButton1_actionPerformed(ActionEvent e) {
        if (this.className == Integer.TYPE) {
            this.o = new Integer(this.jTextField1.getText());
        } else if (this.className == Double.TYPE) {
            this.o = new Double(this.jTextField1.getText());
        } else if (this.className == Float.TYPE) {
            this.o = new Float(this.jTextField1.getText());
        } else if (this.className == Long.TYPE) {
            this.o = new Long(this.jTextField1.getText());
        } else if (this.className == Short.TYPE) {
            this.o = new Short(this.jTextField1.getText());
        } else if (this.className == Byte.TYPE) {
            this.o = new Byte(this.jTextField1.getText());
        } else if (this.className == Character.TYPE) {
            this.o = new Character(this.jTextField1.getText().charAt(0));
        } else if (this.className == Boolean.TYPE) {
            this.o = new Boolean(this.jTextField1.getText());
        } else /*if (this.className == (class$java$lang$String == null ? (class$java$lang$String = class$("java.lang.String")) : class$java$lang$String))*/ {
            this.o = this.jTextField1.getText();
        }

        this.dispose();
    }
}
