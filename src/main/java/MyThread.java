
import com.sun.jdi.*;
import com.sun.jdi.event.*;
import com.sun.jdi.request.*;

import java.util.Hashtable;
import java.util.List;

public class MyThread extends Thread {

    public MyThread() {
        try {
            jbInit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    VirtualMachine vm;
    boolean stopOnVMStart;
    boolean connected = true;
    int numClasses;
    String pkgName;

    Hashtable ht = new Hashtable(40);
    Frame1 frame;
    ReferenceType rt;

    public MyThread(VirtualMachine vm, boolean stopOnVMStart, String pkgName, int numClasses, Frame1 inputFrame) {
        this.vm = vm;
        this.stopOnVMStart = stopOnVMStart;
        this.numClasses = numClasses;
        this.pkgName = pkgName;
        this.frame = inputFrame;
        this.start();
    }

    public void run() {
        EventQueue queue = vm.eventQueue();
        for (int i = 1; i <= numClasses; i++) {
            ClassPrepareRequest cpr = vm.eventRequestManager().createClassPrepareRequest();
            cpr.addClassFilter(pkgName + ".*");
            cpr.addCountFilter(i);
            cpr.enable();
        }

        while (connected) {
            try {
                EventSet eventSet = queue.remove();
                boolean resumeStoppedApp = false;
                EventIterator it = eventSet.eventIterator();
                while (it.hasNext()) {
                    Event e = it.nextEvent();
                    resumeStoppedApp |= !handleEvent(e);
                }
                if (resumeStoppedApp) {
                    eventSet.resume();
                }
            } catch (Exception exc) {
                System.out.println(exc);
            }
        }
    }

    private boolean handleEvent(Event event) {
        if (event instanceof ExceptionEvent) {
            return exceptionEvent(event);
        } else if (event instanceof BreakpointEvent) {
            return breakpointEvent(event);
        } else if (event instanceof WatchpointEvent) {
            return fieldWatchEvent(event);
        } else if (event instanceof StepEvent) {
            return stepEvent(event);
        } else if (event instanceof MethodEntryEvent) {
            return methodEntryEvent(event);
        } else if (event instanceof MethodExitEvent) {
            return methodExitEvent(event);
        } else if (event instanceof ClassPrepareEvent) {

            //Get the event and its reference type
            ClassPrepareEvent cpe = (ClassPrepareEvent)event;
            this.rt = cpe.referenceType();

            try {
                //Get the methods for the Class
                List methodList = this.rt.methods();
                Object[] o = methodList.toArray();

                for(int i = 0; i < o.length; ++i) {

                    //Get the method location
                    Method method = (Method)o[i];
                    Location location = method.location();

                    //Create a breakpoint and enable it
                    BreakpointRequest br = this.vm.eventRequestManager().createBreakpointRequest(location);
                    br.enable();
                }
            } catch (Exception var9) {
                System.out.println(var9);
            }
            return classPrepareEvent(event);
        } else if (event instanceof ClassUnloadEvent) {
            return classUnloadEvent(event);
        } else if (event instanceof ThreadStartEvent) {
            return threadStartEvent(event);
        } else if (event instanceof ThreadDeathEvent) {
            return threadDeathEvent(event);
        } else if (event instanceof VMStartEvent) {
            return vmStartEvent(event);
        } else {
            return handleExitEvent(event);
        }
    }

    private boolean vmDied = false;

    private boolean handleExitEvent(Event event) {
        if (event instanceof VMDeathEvent) {
            this.vmDied = true;
            return this.vmDeathEvent(event);
        } else if (event instanceof VMDisconnectEvent) {
            this.connected = false;
            if (!this.vmDied) {
                this.vmDisconnectEvent(event);
            }
            return false;
        } else {
            throw new InternalError("Unexpected event type");
        }
    }

    private boolean vmStartEvent(Event event) {
        VMStartEvent se = (VMStartEvent) event;
        return stopOnVMStart;
    }

    @SuppressWarnings("removal")
    private boolean breakpointEvent(Event event) {
        BreakpointEvent be = (BreakpointEvent)event;

        if(this.ht.containsKey(be.location().method().toString())){
            Integer i = (Integer)this.ht.get(be.location().method().toString());
            int j = i + 1;
            this.ht.put(be.location().method().toString(), new Integer(j));
        } else {
            this.ht.put(be.location().method().toString(), new Integer(1));
        }

        this.frame.updateNumbers();
        return false;
    }

    private boolean methodEntryEvent(Event event) {
        MethodEntryEvent me = (MethodEntryEvent) event;
        System.out.println("MethodEntryEvent");
        System.out.println(me.method().toString());
        System.out.println(me.location().lineNumber());
        return true;
    }

    private boolean methodExitEvent(Event event) {
        MethodExitEvent me = (MethodExitEvent) event;
        return true;
    }

    private boolean fieldWatchEvent(Event event) {
        WatchpointEvent fwe = (WatchpointEvent) event;
        return true;
    }

    private boolean stepEvent(Event event) {
        StepEvent se = (StepEvent) event;
        return true;
    }

    private boolean classPrepareEvent(Event event) {
        ClassPrepareEvent cle = (ClassPrepareEvent) event;
        return false;
    }

    private boolean classUnloadEvent(Event event) {
        ClassUnloadEvent cue = (ClassUnloadEvent) event;
        return false;
    }

    private boolean exceptionEvent(Event event) {
        ExceptionEvent ee = (ExceptionEvent) event;
        return true;
    }

    private boolean threadDeathEvent(Event event) {
        ThreadDeathEvent tee = (ThreadDeathEvent) event;
        return false;
    }

    private boolean threadStartEvent(Event event) {
        ThreadStartEvent tse = (ThreadStartEvent) event;
        return false;
    }

    public boolean vmDeathEvent(Event event) {
        return false;
    }

    public boolean vmDisconnectEvent(Event event) {
        System.out.println("VMDisconnectEvent");
        return false;
    }

    private void jbInit() throws Exception {
    }

    public Hashtable getHashTable() {
        return this.ht;
    }

}