import java.awt.GridLayout;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.event.KeyEvent;

public class Level extends JPanel implements KeyListener{
    private static int[][] level1 = {{3,3,3,3,3,3,3,3,3,3,3,3,3,3,3},
                                    {3,4,4,4,4,4,4,4,4,4,4,4,4,4,3},
                                    {3,4,0,4,4,4,4,4,4,4,4,4,4,4,3},
                                    {3,4,4,4,4,4,4,4,4,4,4,4,4,4,3},
                                    {3,4,4,4,4,3,4,4,4,4,4,2,4,4,3},
                                    {3,4,4,4,4,4,4,4,4,4,4,4,4,4,3},
                                    {3,4,4,4,4,4,4,4,4,4,4,4,4,4,3},
                                    {3,4,4,4,4,4,1,2,3,4,4,4,4,4,3},
                                    {3,4,4,4,4,4,4,4,4,4,4,4,4,4,3},
                                    {3,4,4,4,4,4,4,4,4,4,4,2,4,4,3},
                                    {3,4,4,3,4,4,4,4,4,4,3,4,4,4,3},
                                    {3,4,4,4,4,3,4,3,3,3,3,4,4,4,3},
                                    {3,4,4,4,4,4,4,2,4,4,4,4,4,4,3},
                                    {3,4,4,3,4,4,4,4,4,4,4,4,4,4,3},
                                    {3,3,3,3,3,3,3,3,3,3,3,3,3,3,3}};
    
    private static int[][] level2 = {{3,3,3,3,3,3,3,3,3,3,3,3,3,3,3},
                                    {3,4,4,4,4,4,4,4,4,4,4,4,4,4,3},
                                    {3,4,4,4,4,4,4,4,4,4,4,4,0,4,3},
                                    {3,4,4,4,4,4,4,4,4,4,4,4,4,4,3},
                                    {3,4,4,4,4,4,4,4,4,4,4,4,4,4,3},
                                    {3,4,4,4,4,4,4,4,4,4,4,4,4,4,3},
                                    {3,4,4,4,4,4,4,4,4,4,4,4,4,4,3},
                                    {3,4,4,4,4,4,4,4,4,4,4,4,4,4,3},
                                    {3,4,4,4,4,4,4,4,4,4,4,4,4,4,3},
                                    {3,4,4,4,4,4,4,4,4,4,4,4,4,4,3},
                                    {3,4,4,4,4,4,4,4,4,4,4,4,4,4,3},
                                    {3,4,4,4,4,4,4,4,4,4,4,4,4,4,3},
                                    {3,4,4,3,2,1,4,4,4,4,4,4,4,4,3},
                                    {3,4,4,4,4,4,4,4,4,4,4,4,4,4,3},
                                    {3,3,3,3,3,3,3,3,3,3,3,3,3,3,3}};

    private static int[][] winScreen = {{3,3,3,3,3,3,3,3,3,3,3,3,3,3,3},
                                        {3,2,1,2,1,2,1,2,1,2,1,2,1,2,3},
                                        {3,1,2,1,2,1,2,1,2,1,2,1,2,1,3},
                                        {3,2,1,2,1,2,1,2,1,2,1,2,1,2,3},
                                        {3,1,2,1,2,1,2,1,2,1,2,1,2,1,3},
                                        {3,2,1,2,1,2,1,2,1,2,1,2,1,2,3},
                                        {3,1,2,1,2,1,2,1,2,1,2,1,2,1,3},
                                        {3,2,1,2,1,2,1,2,1,2,1,2,1,2,3},
                                        {3,1,2,1,2,1,2,1,2,1,2,1,2,1,3},
                                        {3,2,1,2,1,2,1,2,1,2,1,2,1,2,3},
                                        {3,1,2,1,2,1,2,1,2,1,2,1,2,1,3},
                                        {3,2,1,2,1,2,1,2,1,2,1,2,1,2,3},
                                        {3,1,2,1,2,1,2,1,2,1,2,1,2,1,3},
                                        {3,2,1,2,1,2,1,2,1,2,1,2,1,2,3},
                                        {3,3,3,3,3,3,3,3,3,3,3,3,3,3,3}};

    private static int[][][] levelList = {Level.level1, Level.level2, Level.winScreen};
    private int currentLvl;
    private Block[][] levelBlocks = new Block[15][15];
    
    public Level (){
        super(new GridLayout(15, 15));
        this.currentLvl = 1;
        for(int i=0; i<Level.level1.length; i++){
            for(int j=0; j<Level.level1[i].length; j++){
                Block aux = new Block(Level.level1[i][j]);
                this.levelBlocks[i][j] = aux;   
                this.add(this.levelBlocks[i][j]);
            }
        }
        this.addKeyListener(this);
        this.setFocusable(true);
        this.requestFocus();
        Block.changeBackground(this.levelBlocks);
    }

    public void loadLvl(int[][] level, boolean nextLvl){
        for(int i=0; i<level.length; i++){
            for(int j=0; j<level[i].length; j++){
                this.levelBlocks[i][j].setType(level[i][j]);
            }
        }
        Block.changeBackground(this.levelBlocks);
        if (nextLvl){
            this.currentLvl++;
        }
        if(nextLvl && this.currentLvl == Level.levelList.length){
            JOptionPane.showMessageDialog(this, "You won!!");
        }
    }

    public void movePly(int x, int y){
        int playerX = 0;
        int playerY = 0;
        for(int i=0; i<this.levelBlocks.length; i++){
            for(int j=0; j<this.levelBlocks[i].length; j++){
                if(this.levelBlocks[i][j].getType() == 0){
                    playerX = j;
                    playerY = i;
                }
            }
        }
        Block nextBlock = this.levelBlocks[playerY + y][playerX + x];
        if (nextBlock.getType() == 1) {
        	this.loadLvl(Level.levelList[this.currentLvl], true);
        } else if (nextBlock.getType() == 2) {
//			Codigo para mover el bloque un espacio a la vez.
        	
        	int i = 2;
        	if (this.levelBlocks[playerY + y*i][playerX + x*i].getType() == 4) {
        		this.levelBlocks[playerY + y*i][playerX + x*i].setType(2);
        		nextBlock.setType(0);
            	this.levelBlocks[playerY][playerX].setType(4);
        	} else {
        	mover:
	        	while (this.levelBlocks[playerY + y*i][playerX + x*i].getType() == 2) {
	        		i++;
					if (this.levelBlocks[playerY + y*i][playerX + x*i].getType() == 4) {
	        			this.levelBlocks[playerY + y*(i)][playerX + x*(i)].setType(2);
	            		nextBlock.setType(0);
	                	this.levelBlocks[playerY][playerX].setType(4);
	                	break mover;
					}
	        	}
        	}        	

//			Codigo para mover el bloque varios espacios (no sirve bien)       	

//        	try        
//        	{
//        		int i = 2;
//            	while (this.levelBlocks[playerY + y*i][playerX + x*i].getType() == 4) {
//    				this.levelBlocks[playerY + y*(i - 1)][playerX + x*(i - 1)].setType(4);
//    				this.levelBlocks[playerY + y*(i)][playerX + x*(i)].setType(2);
//            		i++;
//    				if (this.levelBlocks[playerY + y*i][playerX + x*i].getType() != 4) {
//            			this.levelBlocks[playerY + y*(i - 1)][playerX + x*(i - 1)].setType(2);
//                		nextBlock.setType(0);
//                    	this.levelBlocks[playerY][playerX].setType(4);
//    				}
//    		        Block.changeBackground(this.levelBlocks);
//			Thread.sleep(100);
//            	}
//        	}
//        	catch(InterruptedException ex) 
//        	{
//        	    Thread.currentThread().interrupt();
//        	}
        } else if (nextBlock.getType() == 4) {
        	nextBlock.setType(0);
        	this.levelBlocks[playerY][playerX].setType(4);
        }
        Block.changeBackground(this.levelBlocks);
    }
    
    public void setCurrentLvl(int lvl) {
    	this.currentLvl = lvl;
    }

    public void keyPressed(KeyEvent e){
    	int key = e.getKeyCode();
    	if(Level.levelList.length != this.currentLvl) {
	    	if (key == KeyEvent.VK_LEFT) {
	            this.movePly(-1, 0);
	        }
	        if (key == KeyEvent.VK_RIGHT) {
	            this.movePly(1, 0);
	        }
	        if (key == KeyEvent.VK_UP) {
	            this.movePly(0, -1);
	        }
	        if (key == KeyEvent.VK_DOWN) {
	            this.movePly(0, 1);
	        }
	        if (key == KeyEvent.VK_R) {
	            this.loadLvl(Level.levelList[this.currentLvl - 1], false);
	        }
    	} else {
    		if (key == KeyEvent.VK_R) {
    			this.setCurrentLvl(1);
	            this.loadLvl(Level.levelList[0], false);
	        }
    	}
    }

    public void keyReleased(KeyEvent e){
        
    }

    public void keyTyped(KeyEvent e){
        
    }
}