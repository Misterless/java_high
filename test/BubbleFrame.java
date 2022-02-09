package site.metacoding.bubble.test;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class BubbleFrame extends JFrame{
// ���� �÷��̾� �����Ұ̴ϴ�. (����)
//���� ����� ���� ���� ����?
	// JFrame ��� �޽��ϴ�.
	private JLabel backgroundMap;
    private Player player;
    //������ ����_������ �ڵ带 �������� ������ �º�����
    public BubbleFrame() {
        initObject();
        initSetting();
        initListener();
        setVisible(true);
}
    //�ʱ� �繰�� ���� (����μ��� ĳ���Ϳ� ��� ��)
    private void initObject() {
        backgroundMap = new JLabel();
        backgroundMap.setIcon(new ImageIcon("image/backgroundMap.png"));
        setContentPane(backgroundMap); // ��׶��� ȭ�� ����

        player = new Player();
        add(player);
    }
    //�ʱ� ������ (â������ ���̾ƿ� null���� , �ߴ� â�� ��ġ��
    //�����,�������� x��ư Ŭ���ϸ� JVM���� ������..
    private void initSetting() {
        setSize(1000, 640); //â ������ 1000,640����
        getContentPane().setLayout(null); // JFrame�� �⺻ JPanel�� ���̾ƿ� ����
        setLocationRelativeTo(null); // ��� ��ġ
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x��ư Ŭ���� JVM ���� ����
    }
    
	
	//Ű���� ������ �ʱ�ȭ
    private void initListener() {
    	addKeyListener(new KeyListener() {
    
        	
        	 @Override
             public void keyTyped(KeyEvent e) {
                 // TODO Auto-generated method stub

             }

             @Override
             public void keyReleased(KeyEvent e) {
             	
                 System.out.println("Ű���� ������");
                 if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
                     player.setRight(false);
                 }else if (e.getKeyCode()==KeyEvent.VK_LEFT) {
                 	player.setLeft(false);
                 }
             }

             @Override
             public void keyPressed(KeyEvent e) {
            	 
            	 System.out.println("Ű���� ������ : " + e.getKeyCode());
             
                 // ���� 37, ������ 39, ���� 38, �Ʒ��� 40
                 //System.out.println("Ű���� ������ : "+e.getKeyCode());
            	 //������� �����е� ȭ��ǥ�� ��������. 
                 if(e.getKeyCode() == (KeyEvent.VK_RIGHT) ||e.getKeyCode() ==  (227)) {
                     if (!player.isRight()) {
                     	System.out.println("�������ϴ� �����е�6��");
                    	 player.right();
                     }
                 }else if (e.getKeyCode()==(KeyEvent.VK_UP)||e.getKeyCode()==KeyEvent.VK_KP_UP||e.getKeyCode()==(32)) {
                       if(!player.isJump()) {
                       System.out.println("�������ϴ� �����е�8�� �����̽���");
                        player.jump();
                       }	                  	   
                     }else if (e.getKeyCode()==(KeyEvent.VK_LEFT)||e.getKeyCode()==(KeyEvent.VK_KP_LEFT)) {
                	   if(!player.isLeft()) {
                		   System.out.println("�������ϴ� �����е�4��");
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

