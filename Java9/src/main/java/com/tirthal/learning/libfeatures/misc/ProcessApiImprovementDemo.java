package com.tirthal.learning.libfeatures.misc;

import java.lang.management.ManagementFactory;
import java.time.Instant;
import java.util.Comparator;

/**
 * java.lang.Process = Represent native process created from Java
 *
 * java.lang.ProcessHandle = Represent any native process on the operating system
 */
public class ProcessApiImprovementDemo {

    public static void main(String[] args) {

        // -----------------------------------
        // ProcessHandle.current().pid() usage
        // ------------------------------------

        // Prior to Java 9 way
        long pidOld = Long.parseLong(ManagementFactory.getRuntimeMXBean().getName().split("@")[0]);

        // With the new ProcessHandle API in Java 9:
        long pidNew = ProcessHandle.current().pid();
        long parentPid = ProcessHandle.current().parent().get().pid();

        System.out.println(String.format("{ pidOld: %s, pidNew: %s }\nparentPid (IDE): %s", pidOld, pidNew, parentPid));

        // -----------------------------------
        // ProcessHandle.allProcesses() to list all system processes
        // ------------------------------------

        ProcessHandle.allProcesses()
                .map(ProcessHandle::info)
                .sorted(Comparator.comparing(info -> info.startInstant().orElse(Instant.MAX)))
                .forEach(ProcessApiImprovementDemo::printInfo);

        // -----------------------------------
        // ProcessHandle's destroy() enables to kill other or child process
        // ------------------------------------

        // killing own process --- throws java.lang.IllegalStateException: destroy of current process not allowed
        ProcessHandle.current().destroyForcibly();
    }

    private static void printInfo(ProcessHandle.Info info) {
        if(info.startInstant().isPresent() && info.command().isPresent()) {
            System.out.println("Started at: " + info.startInstant().get() + ", Command: " + info.command().get());
        }
    }
}
