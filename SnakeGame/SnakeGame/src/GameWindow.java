
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hp
 */
public class GameWindow extends javax.swing.JFrame {

    /**
     * Creates new form GameWindow
     */
    int x1[]={135,110,85,60,35,10};
    int y1[]={100,100,100,100,100,100};
    JLabel l[]=new JLabel[6];
    public GameWindow() {
        initComponents();
        setSize(800,700);
        displaySnake();
        w=getWidth();
        h=getHeight();
        
        Timer t=new Timer(100,
                new TimerClass());
        t.start();
    }
    public void displaySnake()
    {
        for(int i=0;i<6;i++){
            l[i]=new JLabel(
                    new ImageIcon(
                            "snake.png"));
            l[i].setBounds(x1[i], y1[i], 25, 25);
            jPanel1.add(l[i]);
        }
        jPanel1.invalidate();
        jPanel1.repaint();;
        jPanel1.updateUI();
    }
    int lw,lh,w,h,oldkey;
    class TimerClass implements 
            ActionListener
    {
        int x=10,y=100;
        @Override
        public void actionPerformed(
                ActionEvent e) 
        {
            if(keycode==KeyEvent.VK_D)
                x=x<w?x+25:0;
            else if(keycode==KeyEvent.VK_A)
                x=x>0?x-25:w;
            else if(keycode==KeyEvent.VK_W)
                y=y>0?y-25:h;
            else if(keycode==KeyEvent.VK_S)
                y=y<h?y+25:0;
            for(int i=5;i>0;i--){
                x1[i]=x1[i-1];
                y1[i]=y1[i-1];
            }
            x1[0]=x;
            y1[0]=y;
            for(int i=0;i<6;i++){
                l[i].setBounds(x1[i],y1[i],25,25);
            }
        }      
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel1KeyPressed(evt);
            }
        });
        jPanel1.setLayout(null);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 903, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1KeyPressed
    int keycode=KeyEvent.VK_D;
    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        keycode=evt.getKeyCode();
        if(keycode==KeyEvent.VK_W&&oldkey==KeyEvent.VK_S)
            keycode=KeyEvent.VK_S;
        else if(keycode==KeyEvent.VK_S&&oldkey==KeyEvent.VK_W)
            keycode=KeyEvent.VK_W;
        else if(keycode==KeyEvent.VK_A&&oldkey==KeyEvent.VK_D)
            keycode=KeyEvent.VK_D;
        else if(keycode==KeyEvent.VK_D&&oldkey==KeyEvent.VK_A)
            keycode=KeyEvent.VK_A;
        oldkey=keycode;
    }//GEN-LAST:event_formKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GameWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
