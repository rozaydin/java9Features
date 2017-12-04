package com.rhtech.jshell;

import jdk.jshell.JShell;
import jdk.jshell.SnippetEvent;

import java.util.List;

public class JShellApiExample
{
    public static void main(String[] args) {

        // Create a JShell instance
        JShell jShell = JShell.create();

        List<SnippetEvent> events = jShell.eval("int x = 10, y = 100;"
                + "System.out.println(x + y);");

        events.stream().map(event->jShell.status(event.snippet())).forEach(System.out::println);
    }
}
