package com.example.assignment4;

import java.util.Scanner;

public class UndoRedoManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UndoRedo<String> undoRedo = new UndoRedo<>();
        System.out.println("Commands: add <state>, undo, redo, show, quit");

        while(true) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("quit")) break;

            String[] parts = input.split("\\s+", 2);
            String cmd = parts[0].toLowerCase();

            try {
                switch (cmd) {
                    case "add":
                        if (parts.length < 2) {
                            System.out.println("❗ Usage: add <text>");
                        } else {
                            String state = parts[1];
                            undoRedo.add(state);
                            System.out.println("✅ Added state: " + state);
                        }
                        break;
                    case "undo":
                        String undone = undoRedo.undo();
                        System.out.println("↩ Undid: " + undone + " | Current state: " + undoRedo.current());
                        break;
                    case "redo":
                        String redone = undoRedo.redo();
                        System.out.println("↪ Redid: " + redone + " | Current state: " + undoRedo.current());
                        break;
                    case "show":
                        String current = undoRedo.current();
                        if (current != null) {
                            System.out.println("📜 Current state: " + current);
                        } else {
                            System.out.println("❗ No current state.");
                        }
                        break;
                    default:
                        System.out.println("❗ Unknown command: " + cmd);
                        System.out.println("Available commands: add, undo, redo, show, quit");
                        break;

                }
            } catch (Exception e) {
                System.out.println("❗ Error: " + e.getMessage());
            }
        }

    }
}
