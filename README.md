# Java Swing To-Do Application

Objective
---------
Create a simple desktop To-Do list application using Java Swing where users can add and delete tasks using a graphical interface.

Tools used
----------
- Java (JDK 8+)
- Java Swing (part of standard Java SE)
- Any Java IDE (IntelliJ IDEA, Eclipse) or the command line (javac/java)

Concepts demonstrated
----------------------
- Swing components: `JFrame`, `JPanel`, `JButton`, `JTextField`, `JList`, `JScrollPane`
- Event handling with `ActionListener`
- Layout managers: `BorderLayout`, `FlowLayout`
- Use of `DefaultListModel` to back a `JList`
- GUI threading: `SwingUtilities.invokeLater`

How to run (command line - Windows cmd)
--------------------------------------
1. Open a command prompt and change to the project directory (where this README is located):

```
cd C:\Users\om\Desktop\todoapp
```

2. Compile the source into the `bin` directory (this will create `bin` if it does not exist):

```
if not exist bin mkdir bin && javac -d bin src\ToDoApp.java
```

3. Run the application:

```
java -cp bin ToDoApp
```

Notes
-----
- The GUI window will open; use the text field and "Add Task" button (or press Enter) to add items. Select an item in the list and click "Delete Selected" to remove it.
- The program is intentionally simple and beginner-friendly. You can extend it by adding persistence (saving to a file), editing tasks, or marking tasks as completed.

Troubleshooting
---------------
- If you get a "HeadlessException" when running on a server without a display, run locally on a machine with a GUI environment.
- Ensure Java is installed and `javac` / `java` are available on your PATH.

Enjoy!

OUTPUT

![alt text](image.png)
