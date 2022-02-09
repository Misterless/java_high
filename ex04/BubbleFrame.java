/*
package site.metacoding.bubble.ex03;

import java.awt.event.KeyEvent;

import java.awt.event.KeyListener;

import javax.swing.ImageIcon;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**@author misterless
 * InitObject();
 * InitSetting();
 * setVisible(true); // 
 *  left right move
 */
/*public class BubbleFrame extends JFrame{
	
	private JLabel backgroundMap;
	private Player player;
public BubbleFrame() {
	InitObject();
	InitSetting();
	InitListener();
	setVisible(true);
	
}
private void InitListener() {
	addKeyListener(new KeyListener() {
		
		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void keyReleased(KeyEvent e) {
System.out.println("key released");			
		}
		
		@Override
		public void keyPressed(KeyEvent e) {
System.out.println("key inputted"+e.getKeyCode());
		if (e.getKeyCode()==39) {
			player.right();
			
		}
		}// left 37 right 39 up 38 down 40
	});
}
private void InitObject() {
	backgroundMap = new JLabel();
	backgroundMap= new JLabel(new ImageIcon("Image/backgroundMap.png"));
	setContentPane(backgroundMap);
	player = new Player();
	add(player);
}
private void InitSetting() {
setSize(1000,640);	
getContentPane().setLayout(null);
setLocationRelativeTo(null);
setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
}
}
}
}
public static void main(String[] args) {
    new BubbleFrame();
}

}
*/
/*
package site.metacoding.bubble.ex04;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * 
 *
 *  목적 : smooth 이동
 *
 */
/*
public class BubbleFrame extends JFrame{

    private JLabel backgroundMap;
    private Player player;

    public BubbleFrame() {
        initObject();
        initSetting();
        initListener();
        setVisible(true); // 내부에 paintComponent() 호출 코드가 있다.
    }

    // new 하는 것
    private void initObject() {
        backgroundMap = new JLabel();
        backgroundMap.setIcon(new ImageIcon("image/backgroundMap.png"));
        setContentPane(backgroundMap); // 백그라운드 화면 설정

        player = new Player();
        add(player);
    }

    // 각종 모든 세팅
    private void initSetting() {
        setSize(1000, 640);
        getContentPane().setLayout(null); // JFrame의 기본 JPanel의 레이아웃 설정
        setLocationRelativeTo(null); // 가운데 배치
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x버튼 클릭시 JVM 같이 종료하기
    }

    private void initListener() {
        addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void keyReleased(KeyEvent e) {
            	
                System.out.println("키보드 릴리즈");
                if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    player.setRight(false);
                }else if (e.getKeyCode()==KeyEvent.VK_LEFT) {
                	player.setLeft(false);
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                // 왼쪽 37, 오른쪽 39, 위쪽 38, 아래쪽 40
                //System.out.println("키보드 프레스 : "+e.getKeyCode());

                if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    if (!player.isRight()) {
                    	player.right();
                    }
                    
                }else if (e.getKeyCode()==KeyEvent.VK_LEFT) {
                	player.left();
                }
            }
        });
    }

    public static void main(String[] args) {
        new BubbleFrame();
    }

}
*/
package site.metacoding.bubble.ex04;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * 
 * @author 메타코딩
 *  목적 : 스무스한 좌우이동
 *
 */

public class BubbleFrame extends JFrame{

    private JLabel backgroundMap;
    private Player player;
    
    public BubbleFrame() {
        initObject();
        initSetting();
        initListener();
        setVisible(true); // 내부에 paintComponent() 호출 코드가 있다.
    }
    
    // new 하는 것
    private void initObject() {
        backgroundMap = new JLabel();
        backgroundMap.setIcon(new ImageIcon("image/backgroundMap.png"));
        setContentPane(backgroundMap); // 백그라운드 화면 설정

        player = new Player();
        add(player);
    }
    
    // 각종 모든 세팅
    private void initSetting() {
        setSize(1000, 640);
        getContentPane().setLayout(null); // JFrame의 기본 JPanel의 레이아웃 설정
        setLocationRelativeTo(null); // 가운데 배치
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x버튼 클릭시 JVM 같이 종료하기
    }
    
    private void initListener() {
        addKeyListener(new KeyListener() {
            
            @Override
            public void keyTyped(KeyEvent e) {
                // TODO Auto-generated method stub
                
            }
            
            @Override
            public void keyReleased(KeyEvent e) {
                System.out.println("키보드 릴리즈");
                
                if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    // isRight를 false
                    player.setRight(false);
                }else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
                    // isLeft를 false
                    player.setLeft(false);
                }
            }
            
            @Override
            public void keyPressed(KeyEvent e) {
                // 왼쪽 37, 오른쪽 39, 위쪽 38, 아래쪽 40
                // System.out.println("키보드 프레스 : "+e.getKeyCode());
                
                if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    // 키보드를 누르고 있는 동안 right() 메서드를 한번만 실행하고 싶다.
                    if(player.isRight() == false) {
                        player.right();
                    }
                    
                }else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
                    if(player.isLeft() == false) {
                        player.left();
                    }
                }
            }
        });
    }
    
    public static void main(String[] args) {
        new BubbleFrame();
    }

}
