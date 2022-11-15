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
                flag=false;
            }
            if (flag){
                mapElement.put(position,new Grass(position));
                mapBoundary.add(position);
                nograss++;
            }
        }
    }
    public Vector2d getRightTop(){
       return new Vector2d(mapBoundary.xsorted.last().x,mapBoundary.ysorted.last().y);


    }
    public Vector2d getLeftLow(){
        return new Vector2d(mapBoundary.xsorted.first().x,mapBoundary.ysorted.first().y);
    }
    @Override
    public boolean canI(Vector2d position) {
        if (objectAt(position) instanceof Grass){
            int size=this.nograss;
            mapElement.remove(position);
            mapBoundary.remove(position);
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
