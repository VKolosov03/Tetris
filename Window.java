import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame {
    private JPanel[][] panels = new JPanel[20][10];
    private int y=0, x=0;
    public Window(){
        setTitle("Tetris");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(500,1000);
        for(int i=0; i<20; i++){
            for(int j=0; j<10; j++){
                panels[i][j]=new JPanel();
                panels[i][j].setBounds(j*50,i*50,50,50);
                add(panels[i][j]);
            }
        }
        setVisible(true);
        Timer time=new Timer(250, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(y>=9 || panels[y+1][x].getBackground()==Color.RED){
                    y=0;
                    x=(int)(Math.random()*9);
                }
                else if(y<9) {
                    panels[y][x].setBackground(Color.WHITE);
                    y++;
                    panels[y][x].setBackground(Color.RED);
                }
            }
        });
        time.start();
    }

    public static void main(String[] args) {
        Window mw = new Window();
    }
}