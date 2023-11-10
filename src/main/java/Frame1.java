//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import com.sun.jdi.VirtualMachine;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.io.File;
import java.lang.reflect.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
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
    JButton openFileButton = new JButton();
    JButton closeFileButton = new JButton();
    JButton helpButton = new JButton();
    JButton runButton = new JButton();
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
    JPanel jPanel2 = new JPanel();
    BorderLayout borderLayout3 = new BorderLayout();
    JPanel jPanel3 = new JPanel();
    JPanel jPanel4 = new JPanel();
    BorderLayout borderLayout4 = new BorderLayout();
    JPanel jPanel5 = new JPanel();
    JLabel jLabel3 = new JLabel();
    JScrollPane jScrollPane2 = new JScrollPane();
    JTextArea jTextArea1 = new JTextArea();
    JTextArea rowText = new JTextArea();
    JFileChooser chooser = new JFileChooser();
    File dir = null;
    File[] farray;
    MyFileNameFilter filter = new MyFileNameFilter();
    //MyThread mt;
    URLClassLoader ucl;
    URL[] urls = new URL[1];
    VirtualMachine vm = null;

    //For trying to clear the JList
    DefaultListModel listModel = new DefaultListModel<>();

    /**
     * Frame constructor:
     * Calls initializing method to fill frame
     */
    public Frame1() {
        this.enableEvents(64L);

        try {

            this.jbInit();

            JViewport jvp = new JViewport();
            rowText.setBackground(Color.GRAY);
            jvp.add(rowText);
            jScrollPane3.setRowHeader(jvp);

        } catch (Exception var2) {
            var2.printStackTrace();
        }

    }

    /**
     * jbInit
     * Initialized panes, panels, menu, toolbar, buttons, text fields,
     * lists, and labels needed for GUI frame
     * @throws Exception
     */
    private void jbInit() throws Exception {
        this.image1 = new ImageIcon("src/main/resources/openfile.png");
        this.image2 = new ImageIcon("src/main/resources/closefile.png");
        this.image3 = new ImageIcon("src/main/resources/help.png");
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
        this.openFileButton.setIcon(this.image1);
        this.openFileButton.setToolTipText("Open File");
        this.openFileButton.addActionListener(new OpenFileButton_Click_actionAdapter(this));
        this.closeFileButton.setIcon(this.image2);
        this.closeFileButton.setToolTipText("Close File");
        this.helpButton.setIcon(this.image3);
        this.helpButton.setToolTipText("Help");
        this.runButton.setText("RUN");
        this.runButton.setToolTipText("RUN");
        this.jToolBar.add(this.openFileButton);
        this.jToolBar.add(this.closeFileButton);
        this.jToolBar.add(this.helpButton);
        this.jToolBar.add(this.runButton);

        // TEXT FIELDS
        this.jTextField1.setFont(new Font("Dialog", 0, 20));
        this.jTextField1.setMaximumSize(new Dimension(201, Integer.MAX_VALUE));
        this.jTextField1.setPreferredSize(new Dimension(201, 31));
        this.jTextField1.setText("functionalTest.Box");
        this.jTextField1.addActionListener(new Frame1_jTextField1_actionAdapter(this));

        // LISTS
        this.classList.setFont(new Font("Dialog", 0, 20));
        this.classList.addListSelectionListener(new ClassList_click_actionAdapter(this));
        this.classList.setModel(listModel);

        // PANES AND PANELS
        this.jScrollPane1.getViewport().add(this.classList, (Object)null);
        this.jScrollPane2.setMinimumSize(new Dimension(19, 90));
        this.jScrollPane2.getViewport().add(this.jTextArea1);
        this.jScrollPane2.setPreferredSize(new Dimension(2, 90));
        this.jScrollPane3.setPreferredSize(new Dimension(258, 150));
        this.jScrollPane3.getViewport().add(this.jTextArea1, (Object)null);
        this.jPanel2.setLayout(this.borderLayout3);
        this.jPanel2.setMinimumSize(new Dimension(220, 163));
        this.jPanel2.setPreferredSize(new Dimension(258, 163));
        this.jPanel2.add(this.jScrollPane1, "Center");
        this.jPanel2.add(this.jPanel3, "North");
        this.jPanel4.setLayout(this.borderLayout4);
        this.jPanel4.add(this.jScrollPane3, "Center");
        this.jPanel4.add(this.jPanel5, "North");
        this.jSplitPane1.add(this.jPanel4, "right");
        this.jSplitPane1.add(this.jPanel2, "left");

        // LABELS
        this.jLabel3.setFont(new Font("Dialog", 0, 20));
        this.jLabel3.setText("   Tested Class:");

        this.jTextArea1.setText("");
        this.contentPane.add(this.jSplitPane1, "Center");
    }

    /**
     * jMenuFileExit_actionPerformed
     * Exits on click
     * @param e
     */
    public void jMenuFileExit_actionPerformed(ActionEvent e) {
        System.exit(0);
    }

    /**
     * jMenuHelpAbout_actionPerformed
     * @param e
     */
    public void jMenuHelpAbout_actionPerformed(ActionEvent e) {
    }

    /**
     * processWindowEvent
     * @param e  the window event
     */
    protected void processWindowEvent(WindowEvent e) {
        super.processWindowEvent(e);
        if (e.getID() == 201) {
            this.jMenuFileExit_actionPerformed((ActionEvent)null);
        }

    }

    /**
     * class2object
     * creates array of objects from class list
     * @param cls class array
     * @return object array
     */
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

    //List for class files in the chosen directory
    ArrayList<File> directoryContents = new ArrayList<>();

    /**
     * jTextField1_actionPerformed
     * reads in .class files from user-selected directory and stores them
     * in a file name list
     * @param e
     */
    void jTextField1_actionPerformed(ActionEvent e) {

        this.chooser.setFileSelectionMode(1);
        int returnVal = this.chooser.showOpenDialog(this);
        if (returnVal == 0) {
            this.dir = this.chooser.getSelectedFile();
            this.farray = this.dir.listFiles(this.filter);
            DefaultListModel dlm = new DefaultListModel();

            for(int i = 0; i < this.farray.length; ++i) {
                dlm.add(i, this.farray[i].getName());
            }

            this.classList.setModel(dlm);

            try {
                URL u = this.dir.getParentFile().toURL();
                this.urls[0] = u;
                this.ucl = new URLClassLoader(this.urls);
            } catch (Exception var6) {
                System.out.println(var6);
            }
        }

        /*try {
            //Get list of files in directory
            File f;
            JFileChooser jfc = new JFileChooser(this.jTextField1.getText());

            //Get only directories
            jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            jfc.setAcceptAllFileFilterUsed(false);

            if (jfc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                f = jfc.getSelectedFile();

                //Add file to list if it is a ".class" file only
                for (File file:f.listFiles()) {
                    if(file.getName().contains(".class")){
                        directoryContents.add(file);
                    }
                }
            }

            String[] fileNameList = new String[directoryContents.size()];

            for(int i  = 0; i < fileNameList.length; i++){
                fileNameList[i] = directoryContents.get(i).getName();
            }

            //Not sure how to clear the list, this doesn't work
            this.listModel.clear();

            this.classList.setListData(fileNameList);

        } catch (Exception var7) {
            System.out.println(var7);
        }*/
    }

    /**
     * classList_actionPerformed
     * Reads file and creates "skeleton" of class with constructor and other methods
     * @param e
     * @throws MalformedURLException
     */
    void classList_actionPerformed(ListSelectionEvent e) throws MalformedURLException {
        Class c = null;
        ArrayList<String> classPath = new ArrayList<>();

        for(int i = 0; i < directoryContents.size(); i++){
            //Get file
            File f = directoryContents.get(i);

            //Check if the file is the correct one
            Object selectedClass = this.classList.getSelectedValue();
            String currentFileClassName = "";
            currentFileClassName = f.getName().split("\\\\")[0];
            if(selectedClass.equals(currentFileClassName))
            {
                //Get the classpath, package and class, and the parent class path
                while(!f.getName().split("/")[0].contains("classes")){
                    classPath.add(f.getName().split("/")[0]);
                    f = f.getParentFile();
                }

                //Set up the URLClassLoader
                URL url = f.toURI().toURL();
                URL[] urla = {url};
                URLClassLoader ucl = new URLClassLoader(urla);

                String fileName = "";

                //Construct the correct fully qualified class path
                for(int j = classPath.size(); j > 0; j--){
                    if(j != 1) {
                        fileName += classPath.get(j - 1) + ".";
                    }
                    else {
                        fileName += classPath.get(j - 1).split("\\.")[0];
                    }
                }

                //Try to open class and get methods
                try{
                    c = Class.forName(fileName, true, ucl);

                    if(fileName.contains(".")){
                        this.jTextArea1.setText("package " + fileName.split("\\.")[0] + ";\n\n");
                        this.jTextArea1.append(Modifier.toString(c.getModifiers()) + " class " +c.getSimpleName() + "{\n\n");
                        this.rowText.setText("\n\n");
                    }
                    else
                    {
                        this.jTextArea1.setText(Modifier.toString(c.getModifiers()) + " class " +c.getSimpleName() + "{\n\n");
                        this.rowText.setText("\n\n");
                    }

                    Constructor[] constuctors = c.getDeclaredConstructors();

                    for (Constructor contructor:constuctors) {
                        this.jTextArea1.append("    " + Modifier.toString(contructor.getModifiers()) + " " + contructor.getDeclaringClass().getSimpleName() + "() {}\n\n");
                        this.rowText.append("0\n\n");
                    }

                    //Get methods
                    Method[] methods = c.getDeclaredMethods();

                    for (Method method:methods) {
                        this.rowText.append("0\n\n");
                        this.jTextArea1.append("    " + Modifier.toString(method.getModifiers()) + " " + method.getReturnType().getName() + " " + method.getName() + "() {}\n\n");
                    }
                    this.jTextArea1.append("}");
                }
                catch (Exception fileException){
                    System.out.println(fileException);
                }
                catch (NoClassDefFoundError err){}
            }
        }
    }

    /**
     * newObject_actionPerformed
     * @param e
     */
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

    /**
     * opeFile_actionPerformed
     * @param e
     */
    void opeFile_actionPerformed(ActionEvent e){
        this.jTextField1_actionPerformed(e);
    }

}

