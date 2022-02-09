package site.metacoding.bubble.test;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import lombok.Getter;
import lombok.Setter;

public class Player extends JLabel{

	private static final int JUMPSPEED = 2; // 점프 속도고정2
	private static final int SPEED = 4; // 이동 속도고정4
	
    private int x,y;
    
    private ImageIcon playerR, playerL;

    private boolean isRight,isLeft,isJump;
    
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
    public boolean isJump() {
		return isJump;
	}

	public void setJump(boolean isJump) {
		this.isJump = isJump;
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
        isJump = false;
    }

    public void left() {
        isLeft = true;
        setIcon(playerL);
        System.out.println("왼쪽 이동");

        new Thread(()->{
            while(isLeft) {
                x = x - SPEED;
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
                x = x + SPEED;
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
		isJump = true;

		System.out.println("위로 점프");
		// 점프는 for문을 사용합니다 (일단은
		// up : sleep(5), down : sleep(3)


		new Thread(() -> {
			// 점프
			for (int i = 0; i < 130 / JUMPSPEED; i++) { // JUMPSPEED에 따라 높이가 달라지면 안됨!
				y = y - JUMPSPEED;
				setLocation(x, y); // 다시 붓을 
				isJump = true; // 이중점프를는 아직 불가능;

				try {
					Thread.sleep(5);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			// down
			// 바닥에 떨어지는 건 while로 수정!
			for (int i = 0; i < 130 / JUMPSPEED; i++) {
				y = y + JUMPSPEED;
				setLocation(x, y); // 그림 다시 그리기
				try {
					Thread.sleep(3);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			isJump = false;

		}).start();
	}
}