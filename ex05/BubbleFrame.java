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
 *  ëª©ì  : smooth ?´?™
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
        setVisible(true); // ?‚´ë¶??— paintComponent() ?˜¸ì¶? ì½”ë“œê°? ?ˆ?‹¤.
    }

    // new ?•˜?Š” ê²?
    private void initObject() {
        backgroundMap = new JLabel();
        backgroundMap.setIcon(new ImageIcon("image/backgroundMap.png"));
        setContentPane(backgroundMap); // ë°±ê·¸?¼?š´?“œ ?™”ë©? ?„¤? •

        player = new Player();
        add(player);
    }

    // ê°ì¢… ëª¨ë“  ?„¸?Œ…
    private void initSetting() {
        setSize(1000, 640);
        getContentPane().setLayout(null); // JFrame?˜ ê¸°ë³¸ JPanel?˜ ? ˆ?´?•„?›ƒ ?„¤? •
        setLocationRelativeTo(null); // ê°??š´?° ë°°ì¹˜
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // xë²„íŠ¼ ?´ë¦??‹œ JVM ê°™ì´ ì¢…ë£Œ?•˜ê¸?
    }

    private void initListener() {
        addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void keyReleased(KeyEvent e) {
            	
                System.out.println("?‚¤ë³´ë“œ ë¦´ë¦¬ì¦?");
                if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    player.setRight(false);
                }else if (e.getKeyCode()==KeyEvent.VK_LEFT) {
                	player.setLeft(false);
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                // ?™¼ìª? 37, ?˜¤ë¥¸ìª½ 39, ?œ„ìª? 38, ?•„?˜ìª? 40
                //System.out.println("?‚¤ë³´ë“œ ?”„? ˆ?Š¤ : "+e.getKeyCode());

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
package site.metacoding.bubble.ex05;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
/**
 * 
 * @author ë©”í?ì½”ë”©
 *  ëª©ì  : ?Š¤ë¬´ìŠ¤?•œ ì¢Œìš°?´?™
 *
 */

public class BubbleFrame extends JFrame{

    private JLabel backgroundMap;
    private Player player;
    
    public BubbleFrame() {
        initObject();
        initSetting();
        initListener();
        setVisible(true); // ?‚´ë¶??— paintComponent() ?˜¸ì¶? ì½”ë“œê°? ?ˆ?‹¤.
    }
    
    // new ?•˜?Š” ê²?
    private void initObject() {
        backgroundMap = new JLabel();
        backgroundMap.setIcon(new ImageIcon("image/backgroundMap.png"));
        setContentPane(backgroundMap); // ë°±ê·¸?¼?š´?“œ ?™”ë©? ?„¤? •

        player = new Player();
        add(player);
    }
    
    // ê°ì¢… ëª¨ë“  ?„¸?Œ…
    private void initSetting() {
        setSize(1000, 640);
        getContentPane().setLayout(null); // JFrame?˜ ê¸°ë³¸ JPanel?˜ ? ˆ?´?•„?›ƒ ?„¤? •
        setLocationRelativeTo(null); // ê°??š´?° ë°°ì¹˜
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // xë²„íŠ¼ ?´ë¦??‹œ JVM ê°™ì´ ì¢…ë£Œ?•˜ê¸?
    }
    
    private void initListener() {
        addKeyListener(new KeyAdapter() {
            
            @Override
            public void keyTyped(KeyEvent e) {
                // TODO Auto-generated method stub
                
            }
            
            @Override
       /*     public void keyReleased(KeyEvent e) {
                System.out.println("-----Å° ¶¼¾îÁü-----");
                
                if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    // isRightë¥? false
                    player.setRight(false);
                }else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
                    // isLeftë¥? false
                    player.setLeft(false);
                } else if(e.getKeyCode() == KeyEvent.VK_UP) {
                    // isUpë¥? false
                    player.setJump(false);
                }
            }
          */
            
            public void keyPressed(KeyEvent e) {
				// System.out.println(e.getKeyCode());

				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					if (!player.isLeft()) {
						player.left();
					}
					break;
				case KeyEvent.VK_RIGHT:
					if (!player.isRight()) {
						player.right();
					}

					break;
				case KeyEvent.VK_UP:
					if(!player.isJump() && !player.isDown()) {
						player.jump();
					}
					break;
				}
			}
            @Override
           /*
            *  public void keyPressed(KeyEvent e) {
                // ?™¼ìª? 37, ?˜¤ë¥¸ìª½ 39, ?œ„ìª? 38, ?•„?˜ìª? 40
                // System.out.println("?‚¤ë³´ë“œ ?”„? ˆ?Š¤ : "+e.getKeyCode());
                
                if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    // ?‚¤ë³´ë“œë¥? ?ˆ„ë¥´ê³  ?ˆ?Š” ?™?•ˆ right() ë©”ì„œ?“œë¥? ?•œë²ˆë§Œ ?‹¤?–‰?•˜ê³? ?‹¶?‹¤.
                    if(player.isRight() == false) {
                        player.right();
                    }
                    
                }else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
                    if(player.isLeft() == false) {
                        player.left();
                    }
                    else if(e.getKeyCode()== KeyEvent.VK_UP ) {
                    	if(player.isJump() == false) {
                    		player.jump();
                    	}
                    }
                }
            }
        });
    }
    */
            public void keyReleased(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					player.setLeft(false);
					break;
				case KeyEvent.VK_RIGHT:
					player.setRight(false);
					break;
				}
			}

		});
	}
            
    public static void main(String[] args) {
        new BubbleFrame();
    }

}
