package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class GrassField extends AbstractWorldMap{
    public int nograss;
    public GrassField(int n){
        generateField(n);
    }
    private void generateField(int n){
        int x;
        int y;
        boolean flag;
        Vector2d position;
        while(nograss<n){
            x=(int)(Math.random()*Math.sqrt(10*n));
            y=(int)(Math.random()*Math.sqrt(10*n));
            position=new Vector2d(x,y);
            flag=true;
            if(mapElement.containsKey(position)){
                if(!(objectAt(position) instanceof Grass)){
                    flag=true;
                }
            }
            if (flag){
                mapElement.put(position,new Grass(position));
                nograss++;
            }
        }
    }
    public Vector2d getRightTop(){
        int x=Integer.MIN_VALUE;
        int y=Integer.MIN_VALUE;
        for (Vector2d positions:mapElement.keySet()){
            if(positions.x>x){
                x= positions.x;
            }
            if(positions.y>y){
                y= positions.y;
            }
        }
        return new Vector2d(x,y);


    }
    public Vector2d getLeftLow(){
        int x=Integer.MAX_VALUE;
        int y=Integer.MAX_VALUE;
        for (Vector2d positions:mapElement.keySet()){
            if(positions.x<x){
                x= positions.x;
            }
            if(positions.y<y){
                y= positions.y;
            }
        }
        return new Vector2d(x,y);
    }
    @Override
    public boolean canI(Vector2d position) {
        if (isSomethingThere(position)){
            int size=this.nograss;
            mapElement.remove(position);
            nograss--;
            generateField(size);


        }

        return true;
    }



    @Override
    public boolean isSomethingThere(Vector2d position) {
        return true;
    }


}
