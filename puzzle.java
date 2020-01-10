import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

public class puzzle extends JFrame implements ActionListener,MouseListener{  
  MyDrawPanel drawpanel1;
  JPanel panel1, panel;
  JTextField t1=new JTextField("",5), t2=new JTextField("",5);
  JButton b1=new JButton("OK");
  int mx=0, my=0, counter=0, move=0, count2, count=0 ; 
  int workspaceWidth=1000, workspaceHeight=800;
  int a[];
int rand[]=new int[16];
  int x[]=new int[16];
   int y[]= new int[16];
   int check[]=new int[16];
    BufferedImage img = null;
  Boolean win=true;
  ImageIO image;
  public static void main(String[ ] args) 
  {
    new puzzle();
  }  
  
  public puzzle()
  {
     try {
      img = ImageIO.read(new File("img.jpg"));
    } 
    catch (IOException e) 
    {
      System.out.println("Error loading image file");
    }
   
    count=0;
    count2=0;
    for(int mm=0;mm<16;mm++){
      do{
        rand[mm]=(int )(Math.random() * 16);
      }while(check[rand[mm]]==1);
      check[rand[mm]]=1;
      System.out.println(""+rand[mm]);
    }
    for(int ba=0;ba<4;ba++){
      for(int ab=0;ab<4;ab++){
        x[count]=ab*110;
        y[count]=ba*110;
        count++;
      }
    }
  repaint();

  
     addMouseListener(this); 
    this.setVisible(true);
  }
  public void mousePressed(MouseEvent evt){}
  public void mouseReleased(MouseEvent evt){}
  public void mouseClicked(MouseEvent evt){
   
    mx=evt.getX();
    my=evt.getY();
    int wx=mx/110;
    int wy=my/110;
    int temp=wx+wy*4;
    
    if(mx<275&&mx>183&&my<275&&my>183){
      for(int ab=0;ab<16;ab++){
        rand[ab]=-1;
        check[ab]=0;
      }
//      randi();
      move=0;
      mx=0;
      my=0;
      win=false;
   for(int ab=0;ab<16;ab++){
      if(rand[ab]==15){
        int temp2=ab;
        if (temp2-1==temp&&temp2!=0&&temp2!=4&&temp2!=8&&temp2!=12){
          rand[temp2]=rand[temp];
          rand[temp]=15;
          move+=1;
        }
        else if (temp2+1==temp&&temp2!=3&&temp2!=7&&temp2!=11&&temp2!=15){
          rand[temp2]=rand[temp];
          rand[temp]=15;
          move+=1;
        }
        else if (temp2-4==temp&&temp2!=0&&temp2!=1&&temp2!=2&&temp2!=3){
          rand[temp2]=rand[temp];
          rand[temp]=15;
          move+=1;
        }
        else if (temp2+4==temp&&temp2!=12&&temp2!=13&&temp2!=14&&temp2!=15){
          rand[temp2]=rand[temp];
          rand[temp]=15;
          move+=1;
        }
        //System.out.println(""+temp2);
      }
    }
    repaint();
  }
  }
  public void mouseEntered(MouseEvent evt){}
  public void mouseExited(MouseEvent evt){}
  
  public void actionPerformed(ActionEvent e)
  {}
  class MyDrawPanel extends JPanel {
    public void paintComponent(Graphics g) {
      //Converts the ordinay graphics object into a Graphics2d object
      Graphics2D g2 = (Graphics2D)g;
      
        g2.drawImage(img,460,0,120,120,null);
     if(win==true){
        g2.drawString("You Win",440,250);
        g2.drawString("Press Reset to Reset",440,270);
      }
      for(int bb=0;bb<4;bb++){
        for(int ba=0;ba<4;ba++){
          if(rand[count2]!=15){
      g2.drawImage(img,x[count2],y[count2],x[count2]+110,y[count2]+110,x[rand[count2]],y[rand[count2]],x[rand[count2]]+110,y[rand[count2]]+110,null);
      }
        }
      count2++;  }
      count=0;
  }
  }
}

