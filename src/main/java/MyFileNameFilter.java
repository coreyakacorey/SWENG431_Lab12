//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.File;
import java.io.FilenameFilter;

public class MyFileNameFilter implements FilenameFilter {
    public MyFileNameFilter() {
    }

    public boolean accept(File dir, String name) {
        return name.indexOf(".class") > 0;
    }
}
