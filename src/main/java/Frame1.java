//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;

public class Frame1 extends JFrame {
    JPanel contentPane;
    JMenuBar jMenuBar1 = new JMenuBar();
    JMenu jMenuFile = new JMenu();
    JMenuItem jMenuFileExit = new JMenuItem();
    JMenu jMenuHelp = new JMenu();
    JMenuItem jMenuHelpAbout = new JMenuItem();
    JToolBar jToolBar = new JToolBar();
    JButton jButton1 = new JButton();
    JButton jButton2 = new JButton();
    JButton jButton3 = new JButton();
    ImageIcon image1;
    ImageIcon image2;
    ImageIcon image3;
    BorderLayout borderLayout1 = new BorderLayout();
    Method[] mtd;
    Constructor[] cons;
    Object obj_exe;
    JTextField jTextField1 = new JTextField();
    JSplitPane jSplitPane1 = new JSplitPane();
    JList classList = new JList();
    JScrollPane jScrollPane3 = new JScrollPane();
    JScrollPane jScrollPane1 = new JScrollPane();
    JList methodList = new JList();
    JPanel jPanel2 = new JPanel();
    BorderLayout borderLayout3 = new BorderLayout();
    JPanel jPanel3 = new JPanel();
    JButton newObject = new JButton();
    JLabel jLabel1 = new JLabel();
    JPanel jPanel4 = new JPanel();
    BorderLayout borderLayout4 = new BorderLayout();
    JPanel jPanel5 = new JPanel();
    JLabel jLabel2 = new JLabel();
    JButton run = new JButton();
    JLabel jLabel3 = new JLabel();
    JScrollPane jScrollPane2 = new JScrollPane();
    JTextArea jTextArea1 = new JTextArea();

    public Frame1() {
        this.enableEvents(64L);

        try {

            this.jbInit();

            JViewport jvp = new JViewport();
            // TODO: Make method use counters and add those to jvp
            String methodUseCount = "1\n2\n3\n";// TEST
            JTextArea rowText = new JTextArea(methodUseCount);
            jvp.add(rowText);
            jScrollPane3.setRowHeader(jvp);

        } catch (Exception var2) {
            var2.printStackTrace();
        }

    }

    private void jbInit() throws Exception {
        this.contentPane = (JPanel)this.getContentPane();
        this.contentPane.setLayout(this.borderLayout1);
        this.contentPane.add(this.jToolBar, "North");
        this.setSize(new Dimension(508, 513));
        this.setTitle("WWL FUNCTIONAL TESTING TOOL");

        // MENU ITEMS
        this.jMenuFile.setText("File");
        this.jMenuFile.add(this.jMenuFileExit);
        this.jMenuFileExit.setText("Exit");
        this.jMenuFileExit.addActionListener(new Frame1_jMenuFileExit_ActionAdapter(this));
        this.jMenuHelp.setText("Help");
        this.jMenuHelp.add(this.jMenuHelpAbout);
        this.jMenuHelpAbout.setText("About");
        this.jMenuHelpAbout.addActionListener(new Frame1_jMenuHelpAbout_ActionAdapter(this));
        this.jMenuBar1.add(this.jMenuFile);
        this.jMenuBar1.add(this.jMenuHelp);
        this.setJMenuBar(this.jMenuBar1);

        // TOOLBAR AND BUTTONS
        this.jButton1.setIcon(this.image1);
        this.jButton1.setToolTipText("Open File");
        this.jButton2.setIcon(this.image2);
        this.jButton2.setToolTipText("Close File");
        this.jButton3.setIcon(this.image3);
        this.jButton3.setToolTipText("Help");
        this.jToolBar.add(this.jButton1);
        this.jToolBar.add(this.jButton2);
        this.jToolBar.add(this.jButton3);
        this.jToolBar.add(this.jLabel3, (Object)null);
        this.jToolBar.add(this.jTextField1, (Object)null);

        // TEXT FIELDS
        this.jTextField1.setFont(new Font("Dialog", 0, 20));
        this.jTextField1.setMaximumSize(new Dimension(201, Integer.MAX_VALUE));
        this.jTextField1.setPreferredSize(new Dimension(201, 31));
        this.jTextField1.setText("functionalTest.Box");
        this.jTextField1.addActionListener(new Frame1_jTextField1_actionAdapter(this));

        // LISTS
        this.classList.setFont(new Font("Dialog", 0, 20));
        this.classList.addListSelectionListener(new ClassList_click_actionAdapter(this));
        this.methodList.setFont(new Font("Dialog", 0, 20));

        // PANES AND PANELS
        this.jScrollPane1.getViewport().add(this.classList, (Object)null);
        this.jScrollPane2.setMinimumSize(new Dimension(19, 90));
        this.jScrollPane2.getViewport().add(this.jTextArea1);
        this.jScrollPane2.setPreferredSize(new Dimension(2, 90));
        this.jScrollPane3.setPreferredSize(new Dimension(258, 150));
        this.jScrollPane3.getViewport().add(this.methodList, (Object)null);
        this.jPanel2.setLayout(this.borderLayout3);
        this.jPanel2.setMinimumSize(new Dimension(220, 163));
        this.jPanel2.setPreferredSize(new Dimension(258, 163));
        this.jPanel2.add(this.jScrollPane1, "Center");
        this.jPanel2.add(this.jPanel3, "North");
        this.jPanel3.add(this.jLabel1, (Object)null);
        this.jPanel3.add(this.newObject, (Object)null);
        this.jPanel4.setLayout(this.borderLayout4);
        this.jPanel4.add(this.jScrollPane3, "Center");
        this.jPanel4.add(this.jPanel5, "North");
        this.jPanel5.add(this.jLabel2, (Object)null);
        this.jPanel5.add(this.run, (Object)null);
        this.jSplitPane1.add(this.jPanel4, "right");
        this.jSplitPane1.add(this.jPanel2, "left");

        // NEW OBJECT
        this.newObject.setText("New Object");
        this.newObject.addActionListener(new Frame1_newObject_actionAdapter(this));

        // LABELS
        this.jLabel1.setText("Constructors");
        this.jLabel2.setRequestFocusEnabled(true);
        this.jLabel2.setText("Methods");
        this.jLabel3.setFont(new Font("Dialog", 0, 20));
        this.jLabel3.setText("   Tested Class:");

        // not sure where these need to go just yet
        this.run.setText("Run");
        this.run.addActionListener(new Frame1_run_actionAdapter(this));
        this.jTextArea1.setText("");
        this.contentPane.add(this.jSplitPane1, "Center");


    }

    public void jMenuFileExit_actionPerformed(ActionEvent e) {
        System.exit(0);
    }

    public void jMenuHelpAbout_actionPerformed(ActionEvent e) {
    }

    protected void processWindowEvent(WindowEvent e) {
        super.processWindowEvent(e);
        if (e.getID() == 201) {
            this.jMenuFileExit_actionPerformed((ActionEvent)null);
        }

    }

    private Object[] class2object(Class[] cls) {
        Object[] obj = new Object[cls.length];

        for(int j = 0; j < cls.length; ++j) {
            if (!cls[j].isPrimitive() /*&& cls[j] != (class.java.lang.String == null ? (class$java$lang$String = class$("java.lang.String")) : class$java$lang$String)*/) {
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

    void jTextField1_actionPerformed(ActionEvent e) {

        try {
            //Get list of files in directory
            File f = new File("out\\production\\SWENG431_Lab08");
            System.out.println(f.listFiles());
            JFileChooser jfc = new JFileChooser(this.jTextField1.getText());
            jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            jfc.setAcceptAllFileFilterUsed(false);
            File[] directoryContents = null;
            if (jfc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                f = jfc.getSelectedFile();
                directoryContents = f.listFiles();
            }

            String[] fileNameList = new String[directoryContents.length];

            for(int i  = 0; i < fileNameList.length; i++){
                if(! directoryContents[i].isDirectory()) {
                    // only add files and not directories to the list
                    fileNameList[i] = directoryContents[i].getName();
                }
            }
            this.classList.setListData(fileNameList);


        } catch (Exception var7) {
            System.out.println(var7);
        }

    }


    /*private String buildParamList(Class[] cls, String str){
        int count = 1;
        for(int j = 0; j < cls.length; ++j) {
            if (j == cls.length - 1) {

                //Check for String array, cannot use first char as parameter name (will be c nto sa)
                if(cls[j].getTypeName().equals("java.lang.String[]")){
                    System.out.print(cls[j].getTypeName() + "  sa" + count);
                    count++;
                }

                str = str + cls[j].getName() + " " + cls[j].toString().charAt(0) + count;
            } else {
                str = str + cls[j].getName() + " " + cls[j].toString().charAt(0) + count + ",";
                count++;
            }
        }

        return str;
    }*/

    void classList_actionPerformed(ListSelectionEvent e){
        String[] str = {"e","2"};
            this.methodList.setListData(str);
    }

    void newObject_actionPerformed(ActionEvent e) {
        int idx = this.classList.getSelectedIndex();
        Class[] cls = this.cons[idx].getParameterTypes();
        Object[] obj = this.class2object(cls);

        try {
            this.obj_exe = this.cons[idx].newInstance(obj);
        } catch (Exception var6) {
            System.out.println(var6);
        }

    }

    void run_actionPerformed(ActionEvent e) {
        int idx = this.methodList.getSelectedIndex();
        Class[] cls = this.mtd[idx].getParameterTypes();
        Object[] obj = this.class2object(cls);

        try {
            Object outcome = this.mtd[idx].invoke(this.obj_exe, obj);
            if (outcome != null) {
                this.jTextArea1.append(outcome.toString() + "\n");
            } else {
                this.jTextArea1.append("null\n");
            }
        } catch (Exception var6) {
            System.out.println(var6);
        }

    }
}

