package site.metacoding.bubble.test;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import lombok.Getter;
import lombok.Setter;

public class Player extends JLabel{

	private static final int JUMPSPEED = 2; // ���� �ӵ�����2
	private static final int SPEED = 4; // �̵� �ӵ�����4
	
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
        setLocation(x, y); // paintComponent ȣ������

        isRight = false;
        isLeft = false;
        isJump = false;
    }

    public void left() {
        isLeft = true;
        setIcon(playerL);
        System.out.println("���� �̵�");

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
        System.out.println("������ �̵�");

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

		System.out.println("���� ����");
		// ������ for���� ����մϴ� (�ϴ���
		// up : sleep(5), down : sleep(3)


		new Thread(() -> {
			// ����
			for (int i = 0; i < 130 / JUMPSPEED; i++) { // JUMPSPEED�� ���� ���̰� �޶����� �ȵ�!
				y = y - JUMPSPEED;
				setLocation(x, y); // �ٽ� ���� 
				isJump = true; // ������������ ���� �Ұ���;

				try {
					Thread.sleep(5);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			// down
			// �ٴڿ� �������� �� while�� ����!
			for (int i = 0; i < 130 / JUMPSPEED; i++) {
				y = y + JUMPSPEED;
				setLocation(x, y); // �׸� �ٽ� �׸���
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