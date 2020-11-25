package life;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.InvocationTargetException;

public class GameOfLife extends JFrame {

    private Universe universe;
    JLabel generationText;
    JLabel aliveText;
    JPanel universePanel;
    Thread gameThread;


    public static void main(String[] args) {
        try {
            SwingUtilities.invokeAndWait(GameOfLife::new);
        } catch (InterruptedException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public GameOfLife() {
        this(20, 15);
    }

    public GameOfLife(int size, int generations) {
        universe = new Universe(size);

        generationText = new JLabel();
        aliveText = new JLabel();
        universePanel = new JPanel();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setTitle("Game of Life");
        setLayout(null);
        setLocationRelativeTo(null);
        initComponents(size);
        gameThread = showNewGeneration(1);
        gameThread.start();

        setVisible(true);

    }

    private Thread showNewGeneration(int startGeneration) {
        return new Thread(() -> {
            int generation = startGeneration;
            while (true) {
                updateComponents(generation);
                validate();
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    break;
                }
                universe.nextGeneration();
                generation++;
            }
        });
    }

    private void initComponents(int size) {

        generationText.setText("Generation #0");
        generationText.setBounds(10, 0, 500, 20);
        generationText.setHorizontalAlignment(SwingConstants.LEFT);
        generationText.setVerticalAlignment(SwingConstants.TOP);
        generationText.setName("GenerationLabel");

        aliveText.setText("Alive: 0");
        aliveText.setBounds(10, 20, 500, 20);
        aliveText.setHorizontalAlignment(SwingConstants.LEFT);
        aliveText.setVerticalAlignment(SwingConstants.TOP);
        aliveText.setName("AliveLabel");

        JToggleButton playButton = new JToggleButton();
        playButton.setSelected(true);
        playButton.setBounds(10, 40, 80, 30);
        playButton.setText("Pause");
        playButton.setName("PlayToggleButton");
        playButton.addChangeListener(changeEvent -> {
            if (playButton.isSelected()) {
                if (gameThread.getState() == Thread.State.TERMINATED) {
                    gameThread = showNewGeneration(Integer.parseInt(generationText.getText()
                            .split("#")[1].trim()));
                    gameThread.start();
                }
                playButton.setText("Pause");
            } else {
                if (gameThread.getState() == Thread.State.RUNNABLE ||
                        gameThread.getState() == Thread.State.TIMED_WAITING) {
                    gameThread.interrupt();
                }
                playButton.setText("Play");
            }
        });

        JButton resetButton = new JButton();
        resetButton.setBounds(100, 40, 80, 30);
        resetButton.setText("Reset");
        resetButton.setName("ResetButton");
        resetButton.addActionListener(actionEvent -> {
            if (gameThread.getState() == Thread.State.RUNNABLE ||
                    gameThread.getState() == Thread.State.TIMED_WAITING) {
                gameThread.interrupt();
            }
            universe = new Universe(size);
            gameThread = showNewGeneration(1);
            gameThread.start();
            playButton.setSelected(true);
            playButton.setText("Pause");
        });

        universePanel.setBounds(20, 80, 440, 380);
        universePanel.setBorder(BorderFactory.createEmptyBorder(1, 1, 0, 0));
        universePanel.setLayout(new GridLayout(size, size, 1, 1));
        universePanel.setBackground(Color.BLACK);

        Cell[][] cells = universe.getCells();
        for (Cell[] line : cells) {
            for (Cell cell : line) {
                JPanel cellPanel = new JPanel();
                if (cell.isAlive()) {
                    cellPanel.setBackground(Color.BLACK);
                } else {
                    cellPanel.setBackground(Color.WHITE);
                }
                universePanel.add(cellPanel);
            }
        }

        add(generationText);
        add(aliveText);
        add(playButton);
        add(resetButton);
        add(universePanel);

    }

    private void updateComponents(int currentGeneration) {

        generationText.setText("Generation #" + currentGeneration);

        aliveText.setText("Alive: " + universe.countAlive());

        universePanel.removeAll();

        Cell[][] cells = universe.getCells();
        for (Cell[] line : cells) {
            for (Cell cell : line) {
                JPanel cellPanel = new JPanel();
                if (cell.isAlive()) {
                    cellPanel.setBackground(Color.BLACK);
                } else {
                    cellPanel.setBackground(Color.WHITE);
                }
                universePanel.add(cellPanel);
            }
        }

    }

}
