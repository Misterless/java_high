/*package site.metacoding.bubble.ex03;
/*
/**
 * 
 * @author miste
 * 플레이어는 좌우 이동가능하다.
 * 점프가 가능하다.
 * 방울발사 -> 나중에 생각
 */
/*public class Player {
	private int x;
	private int y;
	private ImageIcon playerR;
	public player() {
		initObject();
		initSetting();
	}

}
private void initObject() {
	PlayerR= new ImageIcon("image/playerR.png");
}

private void initSetting() {
	x=55;
	y=535;
	setIcon(PLayerR);
	setSize(50,50);
	setLocation(x,y);
}

public void left () {
	
}
public void right() {
	System.out.println("move right");
	x=x+10;
	setLocation(x,y);	
}*/
/*
package site.metacoding.bubble.ex04;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
/**
 * 
 * @author 메타코딩
 *  플레이어는 좌우 이동이 가능하다.
 *  점프가 가능하다.
 *  방울 발사 (나중에 생각하자)
 */
/*
public class Player extends JLabel{

    private int x;
    private int y;
    private ImageIcon playerR;
    private ImageIcon playerL;
    
    private boolean isRight;
    private boolean isLeft;
    public Player() {
        initObject();
        initSetting();
    }

    private void initObject() {
        playerR = new ImageIcon("image/playerR.png");
        playerL = new ImageIcon("image/playerL.png");
    }

    private void initSetting() {
        x = 70;
        y = 535;
        setIcon(playerR);
        setSize(50, 50);
        setLocation(x, y); // paintComponent 호출해줌
        isRight=false;
        isLeft=false;
        
    }

   
    public boolean isRight() {
		return isRight;
	}

	public void setRight(boolean isRight) {
		this.isRight = isRight;
	}

	public boolean isLeft() {
		return isLeft;
	}

	public void setLeft(boolean isLeft) {
		this.isLeft = isLeft;
	}

	public void right() {
    	isRight=true;
    	setIcon(playerR);
    	System.out.println("오른쪽 이동");
    	new Thread(()->{
    		while(isRight) {
    	        x = x + 15;
    	        
    	        setLocation(x, y);
    	        }
    	try {
    		Thread.sleep(15);
    	} catch(Exception e) {
    		e.printStackTrace();
    		}
    	});
        
    }
public void left() {
	isLeft=true;
	setIcon(playerL);
	System.out.println("Move Left");
	new Thread(()->{
		while(isLeft) {
			x= x-15;
			setLocation(x, y);
		}
		try {
			Thread.sleep(15);
		} catch (Exception e) {
			e.printStackTrace();
		}
	

	});
}
}
*/

package site.metacoding.bubble.ex04;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * 
 * @author 메타코딩
 *  플레이어는 좌우 이동이 가능하다.
 *  점프가 가능하다.
 *  방울 발사 (나중에 생각하자)
 */

public class Player extends JLabel{

    private int x;
    private int y;
    private ImageIcon playerR, playerL;

    private boolean isRight;
    private boolean isLeft;

    public boolean isRight() {
        return isRight;
    }

    public void setRight(boolean isRight) {
        this.isRight = isRight;
    }

    public boolean isLeft() {
        return isLeft;
    }

    public void setLeft(boolean isLeft) {
        this.isLeft = isLeft;
    }

    public Player() {
        initObject();
        initSetting();
    }

    private void initObject() {
        playerR = new ImageIcon("image/playerR.png");
        playerL = new ImageIcon("image/playerL.png");
    }

    private void initSetting() {
        x = 70;
        y = 535;
        setIcon(playerR);
        setSize(50, 50);
        setLocation(x, y); // paintComponent 호출해줌

        isRight = false;
        isLeft = false;
    }

    public void left() {
        isLeft = true;
        setIcon(playerL);
        System.out.println("왼쪽 이동");

        new Thread(()->{
            while(isLeft) {
                x = x - 12;
                setLocation(x, y);
                try {
                    Thread.sleep(13);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void right() {
        isRight = true;
        setIcon(playerR);
        System.out.println("오른쪽 이동");

        new Thread(()->{
            while(isRight) {
                x = x + 12;
                setLocation(x, y);
                try {
                    Thread.sleep(13);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}