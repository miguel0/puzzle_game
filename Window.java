import javax.swing.JFrame;

public class Window extends JFrame{
    public Window () {
        super("Game");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(new Level());
        this.pack();
        this.setResizable(false);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        Window game = new Window();
    }
}