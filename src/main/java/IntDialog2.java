//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//


import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class IntDialog2 extends JDialog {
    JPanel panel1;
    BorderLayout borderLayout1;
    JPanel jPanel1;
    JPanel jPanel2;
    BorderLayout borderLayout2;
    JButton newObject;
    JButton run;
    JScrollPane jScrollPane1;
    JScrollPane jScrollPane2;
    Constructor[] cons;
    Method[] mtd;
    Object obj_exe;
    Class className;
    JLabel jLabel1;
    JList jList1;
    JList jList2;
    JButton done;
    JPanel jPanel3;
    JPanel jPanel4;
    BorderLayout borderLayout3;

    public IntDialog2(Frame frame, String title, boolean modal) {
        super(frame, title, modal);
        this.panel1 = new JPanel();
        this.borderLayout1 = new BorderLayout();
        this.jPanel1 = new JPanel();
        this.jPanel2 = new JPanel();
        this.borderLayout2 = new BorderLayout();
        this.newObject = new JButton();
        this.run = new JButton();
        this.jScrollPane1 = new JScrollPane();
        this.jScrollPane2 = new JScrollPane();
        this.jLabel1 = new JLabel();
        this.jList1 = new JList();
        this.jList2 = new JList();
        this.done = new JButton();
        this.jPanel3 = new JPanel();
        this.jPanel4 = new JPanel();
        this.borderLayout3 = new BorderLayout();

        try {
            this.jbInit();
            this.pack();
        } catch (Exception var5) {
            var5.printStackTrace();
        }

    }

    public IntDialog2(Class className) {
        this((Frame)null, "", true);
        this.className = className;
        this.jLabel1.setText(className.getName());
        this.initialize(className);
    }

    private void jbInit() throws Exception {
        this.panel1.setLayout(this.borderLayout1);
        this.jPanel2.setLayout(this.borderLayout2);
        this.newObject.setText("New Object");
        this.newObject.addActionListener(new IntDialog2_newObject_actionAdapter(this));
        this.run.setText("Run");
        this.run.addActionListener(new IntDialog2_run_actionAdapter(this));
        this.jLabel1.setText("                      ");
        this.done.setText("Done");
        this.done.addActionListener(new IntDialog2_done_actionAdapter(this));
        this.jPanel1.setLayout(this.borderLayout3);
        this.setTitle("WWL Dialog2");
        this.getContentPane().add(this.panel1);
        this.panel1.add(this.jPanel1, "North");
        this.jPanel1.add(this.jPanel3, "North");
        this.jPanel3.add(this.jLabel1, (Object)null);
        this.jPanel1.add(this.jPanel4, "Center");
        this.jPanel4.add(this.newObject, (Object)null);
        this.jPanel4.add(this.run, (Object)null);
        this.jPanel4.add(this.done, (Object)null);
        this.panel1.add(this.jPanel2, "Center");
        this.jPanel2.add(this.jScrollPane1, "Center");
        this.jScrollPane1.getViewport().add(this.jList1, (Object)null);
        this.jPanel2.add(this.jScrollPane2, "South");
        this.jScrollPane2.getViewport().add(this.jList2, (Object)null);
    }

    public void initialize(Class c) {
        try {
            this.cons = c.getConstructors();
            String[] str = new String[this.cons.length];

            int i;
            for(i = 0; i < this.cons.length; ++i) {
                Class[] cls = this.cons[i].getParameterTypes();
                str[i] = this.cons[i].getName() + "(";

                for(i = 0; i < cls.length; ++i) {
                    if (i == cls.length - 1) {
                        str[i] = str[i] + cls[i].getName();
                    } else {
                        str[i] = str[i] + cls[i].getName() + ",";
                    }
                }

                str[i] = str[i] + ")";
            }

            this.jList1.setListData(str);
            Method[] tmp = c.getMethods();
            Vector v = new Vector();

            for(i = 0; i < tmp.length; ++i) {
                if (tmp[i].getReturnType() == this.className) {
                    v.add(tmp[i]);
                }
            }

            this.mtd = new Method[v.size()];

            for(i = 0; i < v.size(); ++i) {
                this.mtd[i] = (Method)v.elementAt(i);
            }

            str = new String[this.mtd.length];

            for(i = 0; i < this.mtd.length; ++i) {
                Class[] cls = this.mtd[i].getParameterTypes();
                str[i] = this.mtd[i].getReturnType().getName() + " " + this.mtd[i].getName() + "(";

                for(int j = 0; j < cls.length; ++j) {
                    if (j == cls.length - 1) {
                        str[i] = str[i] + cls[j].getName();
                    } else {
                        str[i] = str[i] + cls[j].getName() + ",";
                    }
                }

                str[i] = str[i] + ")";
            }

            this.jList2.setListData(str);
        } catch (Exception var8) {
            System.out.println(var8);
        }

    }

    public Object getObject() {
        return this.obj_exe;
    }

    private Object[] class2object(Class[] cls) {
        Object[] obj = new Object[cls.length];

        for(int j = 0; j < cls.length; ++j) {
            if (!cls[j].isPrimitive() /*&& cls[j] != (class$java$lang$String == null ? (class$java$lang$String = class$("java.lang.String")) : class$java$lang$String)*/) {
                IntDialog2 id2 = new IntDialog2(cls[j]);
                id2.setVisible(true);
                obj[j] = id2.getObject();
            } else {
                IntDialog1 id1 = new IntDialog1(cls[j]);
                id1.setVisible(true);
                obj[j] = id1.getObject();
            }
        }

        return obj;
    }

    void newObject_actionPerformed(ActionEvent e) {
        int idx = this.jList1.getSelectedIndex();
        Class[] cls = this.cons[idx].getParameterTypes();
        Object[] obj = this.class2object(cls);

        try {
            this.obj_exe = this.cons[idx].newInstance(obj);
        } catch (Exception var6) {
            System.out.println(var6);
        }

    }

    void run_actionPerformed(ActionEvent e) {
        int idx = this.jList2.getSelectedIndex();
        Class[] cls = this.mtd[idx].getParameterTypes();
        Object[] obj = this.class2object(cls);

        try {
            this.obj_exe = this.mtd[idx].invoke(this.obj_exe, obj);
        } catch (Exception var6) {
            System.out.println(var6);
        }

    }

    void done_actionPerformed(ActionEvent e) {
        this.dispose();
    }
}
