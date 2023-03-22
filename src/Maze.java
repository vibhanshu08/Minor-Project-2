import java.util.*;
import java.awt.*;
import javax.swing.*;
 class DepthFirst{
    public  boolean searchpath(int [][] maze,int x,int y,ArrayList<Integer>path){
        if(maze[x][y]==9){
            path.add(x);
            path.add(y);
            return true;
        }
          if(maze[x][y]==0){
           maze[x][y]=2;
           int dx=-1;
           int dy=0;
           if(searchpath(maze,x+dx,y+dy,path)){
            path.add(x);
            path.add(y);
            return true;
           }
           dx=1;
           dy=0;
            if(searchpath(maze,x+dx,y+dy,path)){
            path.add(x);
            path.add(y);
            return true;
           }
           dx=0;
           dy=-1;
            if(searchpath(maze,x+dx,y+dy,path)){
            path.add(x);
            path.add(y);
            return true;
           }
           dx=0;
           dy=1;
            if(searchpath(maze,x+dx,y+dy,path)){
            path.add(x);
            path.add(y);
            return true;
           }  
        }
        
        return false;
    }
    
}
 public class Maze extends JFrame{

   private int maze[][]={
        {1,1,1,1,1,1,1,1},
        {1,0,0,1,1,0,1,1},
        {1,1,0,0,0,1,1,1},
        {1,1,1,1,0,1,1,1},
        {1,1,0,0,0,1,0,1},
        {1,0,1,0,0,1,0,1},
        {1,1,0,1,0,0,9,1},
        {1,1,1,1,1,1,1,1}
    };
    public ArrayList<Integer>path=new ArrayList<>();
    public Maze(){
        setTitle("Maze Solver");
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DepthFirst a=new DepthFirst();
        // ArrayList<Integer>ans=new ArrayList<>();
        a.searchpath(maze,1,1,this.path);

    }
    @Override
    public void paint(Graphics g){
g.translate(60,60);
for(int i=0;i<maze.length;i++){
for(int j=0;j<maze[0].length;j++){
    Color color;
    switch(maze[i][j]){
    case 1:color=Color.BLUE;break;
    case 9:color=Color.RED;break;
    default: color=Color.WHITE;break;
    }
    g.setColor(color);
    g.fillRect(30*i,30*j,30,30);
    g.setColor(Color.BLACK);
    g.drawRect(30*i,30*j, 30, 30);
}
    }
    for(int i=0;i<path.size();i+=2){
        int pathx=path.get((i));
        int pathy=path.get((i+1));
        g.setColor(Color.GREEN);
        g.fillRect(30*pathx,30*pathy,20,20);
        

    }
    }
    public static void main(String [] args){
           Maze view=new Maze();
           view.setVisible(true);
    }
}