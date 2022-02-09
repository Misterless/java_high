package site.metacoding.bubble.test;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class BubbleFrame extends JFrame{
// 배경과 플레이어 생성할겁니다. (현재)
//추후 버블과 적이 나올 예정?
	// JFrame 상속 받습니다.
	private JLabel backgroundMap;
    private Player player;
    //생성자 생성_복잡한 코드를 가지런히 정렬후 셋비저블
    public BubbleFrame() {
        initObject();
        initSetting();
        initListener();
        setVisible(true);
}
    //초기 사물들 생성 (현재로서는 캐릭터와 배경 뉴)
    private void initObject() {
        backgroundMap = new JLabel();
        backgroundMap.setIcon(new ImageIcon("image/backgroundMap.png"));
        setContentPane(backgroundMap); // 백그라운드 화면 설정

        player = new Player();
        add(player);
    }
    //초기 설정들 (창사이즈 레이아웃 null으로 , 뜨는 창의 위치를
    //가운데로,오른쪽위 x버튼 클릭하면 JVM같이 종료등등..
    private void initSetting() {
        setSize(1000, 640); //창 사이즈 1000,640으로
        getContentPane().setLayout(null); // JFrame의 기본 JPanel의 레이아웃 설정
        setLocationRelativeTo(null); // 가운데 배치
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x버튼 클릭시 JVM 같이 종료
    }
    
	
	//키보드 리스너 초기화
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
            	 
            	 System.out.println("키보드 프레스 : " + e.getKeyCode());
             
                 // 왼쪽 37, 오른쪽 39, 위쪽 38, 아래쪽 40
                 //System.out.println("키보드 프레스 : "+e.getKeyCode());
            	 //사람들은 숫자패드 화살표도 눌러본다. 
                 if(e.getKeyCode() == (KeyEvent.VK_RIGHT) ||e.getKeyCode() ==  (227)) {
                     if (!player.isRight()) {
                     	System.out.println("눌러집니다 숫자패드6도");
                    	 player.right();
                     }
                 }else if (e.getKeyCode()==(KeyEvent.VK_UP)||e.getKeyCode()==KeyEvent.VK_KP_UP||e.getKeyCode()==(32)) {
                       if(!player.isJump()) {
                       System.out.println("눌러집니다 숫자패드8도 스페이스도");
                        player.jump();
                       }	                  	   
                     }else if (e.getKeyCode()==(KeyEvent.VK_LEFT)||e.getKeyCode()==(KeyEvent.VK_KP_LEFT)) {
                	   if(!player.isLeft()) {
                		   System.out.println("눌러집니다 숫자패드4도");
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

