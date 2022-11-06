package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class GrassField implements IWorldMap{
    public List<Animal> animals= new ArrayList<Animal>();
    public List<Grass> grass= new ArrayList<Grass>();
    public int nograss;
    public GrassField(int n){
        this.nograss=n;
        generateField(n);
    }
    private void generateField(int n){
        int x;
        int y;
        boolean flag;
        Vector2d position;
        int count=0;
        while(count<n){
            x=(int)(Math.random()*Math.sqrt(10*n) +1);
            y=(int)(Math.random()*Math.sqrt(10*n) +1);
            position=new Vector2d(x,y);
            flag=true;
            for (Grass trawa:grass){
                if(trawa.getPosition().equals(position)){
                    flag=false;
                    break;
                }
            }
            if (flag){
                grass.add(new Grass(position));
                count++;
            }
        }
    }
    private Vector2d getRightTop(){
        int x=grass.get(0).getPosition().x;
        int y=grass.get(0).getPosition().y;
        for (int i=1;i<nograss;i++){
            if (grass.get(i).getPosition().x>x){
                x=grass.get(i).getPosition().x;
            }
            if (grass.get(i).getPosition().y>y){
                y=grass.get(i).getPosition().y;
            }
        }
        return new Vector2d(x,y);

    }
    @Override
    public boolean canMoveTo(Vector2d position) {
        if (this.isOccupied(position)&&position.follows(new Vector2d(0,0))){
            return false;
        }
        return true;
    }

    @Override
    public boolean place(Animal animal) {
        if (!(objectAt(animal.getPosition()) instanceof Animal)){
            this.animals.add(animal);
            return true;
        }
        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for(Grass trawa:this.grass){
            if(trawa.getPosition().equals(position)){
                return true;
            }
        }
        for (Animal zwierzatko:this.animals){
            if(zwierzatko.getPosition().equals(position)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for(Grass trawa : this.grass){
            if(trawa.getPosition().equals(position)){
                return trawa;
            }
        }
        for (Animal zwierzatko:this.animals){
            if(zwierzatko.getPosition().equals(position)){
                return zwierzatko;
            }
        }
        return null;
    }
    public String toString(){
        MapVisualizer mapVisualzier= new MapVisualizer(this);
        return mapVisualzier.draw(new Vector2d(0,0),this.getRightTop());
    }
}
