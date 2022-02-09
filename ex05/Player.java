package site.metacoding.bubble.ex05;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

/**
 * 
 * 점프
**/

/*
public class Player extends JLabel{
	
	
    public boolean isDown() {
		return isDown;
	}

	public void setDown(boolean isDown) {
		this.isDown = isDown;
	}

	public void setJump(boolean isJump) {
		this.isJump = isJump;
	}
	private int x,y;
    
    private ImageIcon playerR, playerL;

    private boolean isRight,isLeft,isJump,isDown;

    public boolean isJump() {
        return isJump;
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
        isJump= false;
        
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




    public void jump() {
    	System.out.println("점프");
    	isJump=true;
    	//점프는 sleep (5)
    	//다운은 sleep(3)
    	new Thread(()->{
    	for (int i = 0; i < 130/JUMPSPEED; i++) {
    		
			y=y-JUMPSPEED;
			setLocation(x, y);
		
		
    	try {
			Thread.sleep(5);
		} catch (Exception e) {
			e.printStackTrace();
			}
    	}
    	}
    	).start();
    	}
}
    	*/
    /*	new Thread (()->{
    		while (isJump) {
    			for (int i=0;i>=60;i++) {
    				y=y+2i;
    		  				setLocation(x.y);
    				}
    			for(int j=0;j>=60;j--) {
    				isDown=true;
    				y=y-2j;
    				setLocation(x.y);
    				}
    				try {
    					Thread.sleep(5);
    				} catch (Exception e) {
                        e.printStackTrace();
    				    				}
*/    			
    		
   // 	}).start();
    
public class Player extends JLabel implements Moveable {

	// 위치 상태
	private int x;
	private int y;

	// 움직임 상태
	private boolean left;
	private boolean right;
	private boolean up;
	private boolean down;
	
	// 플레이어 속도 상태
	private final int SPEED = 4;
	private final int JUMPSPEED = 2; // up, down

	private ImageIcon playerR, playerL;

	public Player() {
		initObject();
		initSetting();
	}

	private void initObject() {
		playerR = new ImageIcon("image/playerR.png");
		playerL = new ImageIcon("image/playerL.png");
	}

	private void initSetting() {
		x = 55;
		y = 535;

		left = false;
		right = false;
		up = false;
		down = false;

		setIcon(playerR);
		setSize(50, 50);
		setLocation(x, y);
	}

	// 이벤트 핸들러
	@Override
	public void left() {
		System.out.println("left");
		left = true;
		new Thread(()-> {
			while(left) {
				setIcon(playerL);
				x = x - SPEED;
				setLocation(x, y);
				try {
					Thread.sleep(10); // 0.01초
				} catch (InterruptedException e) {
					e.printStackTrace();
				} 
			}
		}).start();

	}

	@Override
	public void right() {
		System.out.println("right");
		right = true;
		new Thread(()-> {
			while(right) {
				setIcon(playerR);
				x = x + SPEED;
				setLocation(x, y);
				try {
					Thread.sleep(10); // 0.01초
				} catch (InterruptedException e) {
					e.printStackTrace();
				} 
			}
		}).start();
		

	}

	// left + up, right + up
	@Override
	public void up() {
		System.out.println("up");
		up = true;
		new Thread(()->{
			for(int i=0; i<130/JUMPSPEED; i++) {
				y = y - JUMPSPEED;
				setLocation(x, y);
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			up = false;
			down();
			
		}).start();
	}

	@Override
	public void down() {
		System.out.println("down");
		down = true;
		new Thread(()->{
			for(int i=0; i<130/JUMPSPEED; i++) {
				y = y + JUMPSPEED;
				setLocation(x, y);
				try {
					Thread.sleep(3);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			down = false;
		}).start();
	}
}


