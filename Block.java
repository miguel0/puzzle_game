import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import java.awt.Color;

public class Block extends JPanel{
    private int type; //0:Player 1:Goal 2:Movable 3:NotMovable 4:Empty

    public Block (int type){
        super();
        this.type = type;
        this.setPreferredSize(new Dimension(50, 50));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    public static void changeBackground(Block[][] blockList){
        for(int i=0; i<blockList.length; i++){
            for(int j=0; j<blockList[i].length; j++){
                switch (blockList[i][j].getType()) {
                    case 0:
                    blockList[i][j].setBackground(Color.BLUE);
                    break;
        
                    case 1:
                    blockList[i][j].setBackground(Color.YELLOW);
                    break;
        
                    case 2:
                    blockList[i][j].setBackground(Color.RED);
                    break;
        
                    case 3:
                    blockList[i][j].setBackground(Color.BLACK);
                    break;
        
                    case(4):
                    blockList[i][j].setBackground(Color.WHITE);
                    break;
        
                    default:
                    System.out.println("Error");
                }
            }
        }
    }

    public void setType(int type){
        this.type = type;
    }

    public int getType(){
        return this.type;
    }
}