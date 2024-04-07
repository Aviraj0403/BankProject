package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class GCP1 extends JFrame implements ActionListener {
    // ... (your existing code)
    JLabel mainL;
    JLabel verL;
    JTextField vertCF;
    JLabel edgeL;
    JTextField edgeCF;
    JLabel colorL;
    JTextField colorCF;
    JTextArea resultTA;
    JButton btn;
    JButton generateGraphBtn;
    //    JFrame graphFrame;
    JPanel graphFrame;
    public GCP1() {
        // ... (your existing code)

        setTitle("Graph Coloring Project");
        mainL = new JLabel("Graph Coloring Problem");
        mainL.setFont(new Font("Osward", Font.BOLD, 35));
        mainL.setForeground(Color.BLACK);
        mainL.setBounds(220,30,450,45);
        add(mainL);

        verL = new JLabel("Numbers of Vertices :  ");
        verL.setFont(new Font("Osward", Font.BOLD, 15));
        verL.setForeground(Color.BLACK);
        verL.setBounds(20,90,200,30);
        add(verL);

        vertCF = new JTextField();
        vertCF.setBounds(180,90,150,30);
        add(vertCF);

        edgeL=new JLabel("Number of Edges : ");
        edgeL.setFont(new Font("Osward", Font.BOLD, 15));
        edgeL.setForeground(Color.BLACK);
        edgeL.setBounds(20,130,200,30);
        add(edgeL);

        edgeCF = new JTextField();
        edgeCF.setBounds(180,130,150,30);
        add(edgeCF);

        colorL = new JLabel("Number of Colors :");
        colorL.setFont(new Font("Osward", Font.BOLD, 15));
        colorL.setForeground(Color.BLACK);
        colorL.setBounds(20,170,200,30);
        add(colorL);

        colorCF = new JTextField();
        colorCF.setBounds(180,170,150,30);
        add(colorCF);

        resultTA = new JTextArea();
        resultTA.setFont(new Font("Raleway", Font.BOLD, 14));
        resultTA.setBounds(20, 245, 350, 300);
        add(resultTA);

        JButton generateGraphBtn = new JButton("Generate Graph");
        generateGraphBtn.setBackground(Color.BLACK);
        generateGraphBtn.setForeground(Color.WHITE);
        generateGraphBtn.setFont(new Font("Arial", Font.BOLD, 14));
        generateGraphBtn.setBounds(180, 210, 150, 30);
        generateGraphBtn.addActionListener(e -> generateGraph());
        add(generateGraphBtn);

        JButton mDecisionColoringBtn = new JButton("Solve M-Decision Coloring");
        mDecisionColoringBtn.setBackground(Color.BLACK);
        mDecisionColoringBtn.setForeground(Color.WHITE);
        mDecisionColoringBtn.setFont(new Font("Arial", Font.BOLD, 14));
        mDecisionColoringBtn.setBounds(180, 250, 250, 30);
        mDecisionColoringBtn.addActionListener(e -> solveMDecisionColoring());
        add(mDecisionColoringBtn);

        JButton mColoringOptimizationBtn = new JButton("M-Coloring Optimization (Backtracking)");
        mColoringOptimizationBtn.setBackground(Color.BLACK);
        mColoringOptimizationBtn.setForeground(Color.WHITE);
        mColoringOptimizationBtn.setFont(new Font("Arial", Font.BOLD, 14));
        mColoringOptimizationBtn.setBounds(180, 290, 350, 30);
        mColoringOptimizationBtn.addActionListener(e -> solveMColoringOptimization());
        add(mColoringOptimizationBtn);

        // ... (your existing code)
        JLabel title =new JLabel("Graph Visualization");
        title.setFont(new Font("Osward", Font.HANGING_BASELINE, 15));
        title.setForeground(Color.BLACK);
        title.setBounds(575,97,450,25);
        add(title);

        graphFrame = new JPanel();

        graphFrame.setBounds(400, 95, 500, 450);
        add(graphFrame);

        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setSize(800,600);
        setLocation(550,200);
        setVisible(true);
    }

    private void generateGraph() {
        try {
            int vertexCount = Integer.parseInt(vertCF.getText());
            int edgeCount = Integer.parseInt(edgeCF.getText());

            Graph1 generatedGraph = GraphGenerator.generateGraph(vertexCount, edgeCount);

            // Display the generated graph in the UI (you need to implement this)
            // For example, you can create a separate panel or component for graph visualization
            // and update it with the generated graph.

            // Example: Assuming you have a GraphVisualizationPanel class for displaying the graph
            GraphColoring1 graphPanel = new GraphColoring1(generatedGraph);
            graphFrame.add(graphPanel);
            graphFrame.revalidate();
            graphFrame.repaint();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(graphFrame, "Invalid input. Please enter valid numbers.");
        }
    }


    private void solveMDecisionColoring() {
        try {
            int m = Integer.parseInt(colorCF.getText());
            boolean canColor = MDecisionColoring.canColorGraph(generatedGraph, m);

            if (canColor) {
                resultTA.setText("Graph can be colored with " + m + " colors.");
            } else {
                resultTA.setText("Graph cannot be colored with " + m + " colors.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(graphFrame, "Invalid input. Please enter a valid number of colors (m).");
        }
    }


    private void solveMColoringOptimization() {
        try {
            int m = Integer.parseInt(colorCF.getText());
            Map<Integer, Integer> coloring = MColoringOptimization.solveMColoring(generatedGraph, m);

            if (!coloring.isEmpty()) {
                // Display the coloring result in the UI (you need to implement this)
                // You can update the resultTA or a separate component with the coloring information.

                // Example: Assuming you have a method to format and display the coloring result
                displayColoringResult(coloring);
            } else {
                resultTA.setText("No valid coloring found with " + m + " colors.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(graphFrame, "Invalid input. Please enter a valid number of colors (m).");
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    // ... (rest of your existing code)
}
