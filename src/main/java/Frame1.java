//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

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
    //JList methodList = new JList();
    JPanel jPanel2 = new JPanel();
    BorderLayout borderLayout3 = new BorderLayout();
    JPanel jPanel3 = new JPanel();
    //JButton newObject = new JButton();
    //JLabel jLabel1 = new JLabel();
    JPanel jPanel4 = new JPanel();
    BorderLayout borderLayout4 = new BorderLayout();
    JPanel jPanel5 = new JPanel();
    //JLabel jLabel2 = new JLabel();
    //JButton run = new JButton();
    JLabel jLabel3 = new JLabel();
    JScrollPane jScrollPane2 = new JScrollPane();
    JTextArea jTextArea1 = new JTextArea();

    //For trying to clear the JList
    DefaultListModel listModel = new DefaultListModel<>();

    public Frame1() {
        this.enableEvents(64L);

        try {

            this.jbInit();

            JViewport jvp = new JViewport();

            String classSkeleton = jTextArea1.getText();
            ArrayList<Character> methodCounter = processText(classSkeleton);

            // TODO: FIGURE OUT HOW TO CONSTANTLY UPDATE methodUseCount RATHER THAN JUST SHOWING AT THE BEGINNING
            String methodUseCount = counterListToString(methodCounter);
            JTextArea rowText = new JTextArea(methodUseCount);
            rowText.setBackground(Color.GRAY);
            jvp.add(rowText);
            jScrollPane3.setRowHeader(jvp);

        } catch (Exception var2) {
            var2.printStackTrace();
        }

    }

    String counterListToString(ArrayList<Character> methodCounter){
        String methodUseCount = "";
        for (int i=0; i < methodCounter.size(); i++){
            methodUseCount += methodCounter.get(i); // put array item in string
            methodUseCount += "\n";                 // new line and move on to next line
        }
        return methodUseCount;
    }
    ArrayList<Character> processText(String classSkeleton){
        ArrayList<Character> methodCounter = new ArrayList<Character>();
        String[] lines = classSkeleton.split("\n");

        // cycle through code skeleton, line by line, to check its contents
        for(String line : lines){
            System.out.println(line);

            // line has contents and end in parenthesis, it's a method (right?)
            if((line.length() > 0) && (line.charAt(line.length()) == ')')){
                System.out.println("Line is a method");
                methodCounter.add('0'); // init at zero
            }
            else{
                System.out.println("Line is not a method");
                methodCounter.add('.');// IN FINAL PRODUCT, LEAVE SPACE. JUST PUTTING "." SO WE HAVE A VISUAL
            }
        }
        return methodCounter;
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
        this.classList.setModel(listModel);
        //this.methodList.setFont(new Font("Dialog", 0, 20));

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
        //this.jPanel3.add(this.jLabel1, (Object)null);
        //this.jPanel3.add(this.newObject, (Object)null);
        this.jPanel4.setLayout(this.borderLayout4);
        this.jPanel4.add(this.jScrollPane3, "Center");
        this.jPanel4.add(this.jPanel5, "North");
        //this.jPanel5.add(this.jLabel2, (Object)null);
        //this.jPanel5.add(this.run, (Object)null);
        this.jSplitPane1.add(this.jPanel4, "right");
        this.jSplitPane1.add(this.jPanel2, "left");

        // NEW OBJECT
        //this.newObject.setText("New Object");
        //this.newObject.addActionListener(new Frame1_newObject_actionAdapter(this));

        // LABELS
        //this.jLabel1.setText("Constructors");
        //this.jLabel2.setRequestFocusEnabled(true);
        //this.jLabel2.setText("Methods");
        this.jLabel3.setFont(new Font("Dialog", 0, 20));
        this.jLabel3.setText("   Tested Class:");

        // not sure where these need to go just yet
       // this.run.setText("Run");
        //this.run.addActionListener(new Frame1_run_actionAdapter(this));
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

    //List for class files in the chosen directory
    ArrayList<File> directoryContents = new ArrayList<>();
    void jTextField1_actionPerformed(ActionEvent e) {

        try {
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
        }
    }

    void classList_actionPerformed(ListSelectionEvent e) throws MalformedURLException {
        Class c = null;
        ArrayList<String> classPath = new ArrayList<>();

        for(int i = 0; i < directoryContents.size(); i++){
            //Get file
            File f = directoryContents.get(i);

            //Check if the file is the correct one
            Object str = this.classList.getSelectedValue();
            if(f.getName().contains((String)str))
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
                    }
                    else
                    {
                        this.jTextArea1.setText(Modifier.toString(c.getModifiers()) + " class " +c.getSimpleName() + "{\n\n");
                    }

                    Constructor[] constuctors = c.getDeclaredConstructors();

                    for (Constructor contructor:constuctors) {
                        this.jTextArea1.append("    " + Modifier.toString(contructor.getModifiers()) + " " + contructor.getDeclaringClass().getSimpleName() + "();"
                                + "{\n\n");
                    }

                    // TODO: SOME CLASSES ARE PRINTING ALL METHODS ON ONE LINE IN GUI
                    //Get methods
                    Method[] methods = c.getDeclaredMethods();

                    for (Method method:methods) {
                        this.jTextArea1.append("    " + Modifier.toString(method.getModifiers()) + " " + method.getReturnType().getName() + " " + method.getName() + " (");

                        java.lang.reflect.Type[] ta = method.getParameterTypes();

                        //Print parameters
                        int count = 1;
                        for(java.lang.reflect.Type type: ta){
                            if(count > 1){
                                this.jTextArea1.append( ", ");
                            }

                            //Check for String array, cannot use first char as parameter name (will be c nto sa)
                            if(type.getTypeName().equals("java.lang.String[]")){
                                this.jTextArea1.append(type.getTypeName() + "  sa" + count);
                                count++;
                            }

                            //Get first char for parameter name
                            else {
                                this.jTextArea1.append(type.getTypeName() + " " + type.toString().charAt(0) + count);
                                count++;
                            }
                        }
                        this.jTextArea1.append(")");
                    }
                }
                catch (Exception fileException){
                    System.out.println(fileException);
                }
                catch (NoClassDefFoundError err){}
            }
        }
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

    /*void run_actionPerformed(ActionEvent e) {
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

    }*/
}

