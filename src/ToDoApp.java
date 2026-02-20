import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Simple To-Do List application using Java Swing.
 *
 * Features:
 * - Add a task
 * - Delete selected task
 * - Tasks displayed in a scrollable JList
 * - Input field cleared after adding
 *
 * Beginner-friendly and uses ActionListener for event handling.
 */
public class ToDoApp {
    private DefaultListModel<String> listModel;
    private JFrame frame;
    private JList<String> taskList;
    private JTextField inputField;
    private JButton addButton;
    private JButton deleteButton;

    public ToDoApp() {
        // Main window (JFrame)
        frame = new JFrame("To-Do List");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300); // Set window size
        frame.setLayout(new BorderLayout()); // Use BorderLayout to organize regions

        // Model and JList for tasks
        listModel = new DefaultListModel<>();
        taskList = new JList<>(listModel);
        taskList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane listScrollPane = new JScrollPane(taskList); // Scrollable list

        // Top panel: input field and Add button
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        inputField = new JTextField(20);
        addButton = new JButton("Add Task");
        inputPanel.add(inputField);
        inputPanel.add(addButton);

        // Bottom panel: Delete button
        JPanel controlPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        deleteButton = new JButton("Delete Selected");
        controlPanel.add(deleteButton);

        // Add components to the frame
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(listScrollPane, BorderLayout.CENTER);
        frame.add(controlPanel, BorderLayout.SOUTH);

        // Event handling using ActionListener
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addTask();
            }
        });

        // Allow pressing Enter in the text field to add the task
        inputField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addTask();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = taskList.getSelectedIndex();
                if (index != -1) {
                    listModel.remove(index);
                } else {
                    // Friendly message if nothing is selected
                    JOptionPane.showMessageDialog(frame, "Please select a task to delete.", "No Selection", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        // Center the window on screen and show it
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // Adds a task from the input field to the list and clears the input
    private void addTask() {
        String task = inputField.getText().trim();
        if (!task.isEmpty()) {
            listModel.addElement(task);
            inputField.setText(""); // Clear input field after adding
            inputField.requestFocusInWindow();
        } else {
            // Optional: inform user when trying to add empty tasks
            JOptionPane.showMessageDialog(frame, "Please enter a non-empty task.", "Empty Input", JOptionPane.WARNING_MESSAGE);
        }
    }

    // Entry point: schedule GUI creation on the Event Dispatch Thread
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ToDoApp();
            }
        });
    }
}
