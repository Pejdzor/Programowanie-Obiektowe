package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ThreadEngine implements IEngine,Runnable{
    private final AbstractWorldMap map;
    private final List<Animal> animals = new ArrayList<>();
    private final int moveDelay;
    private List<MoveDirection> moves;
    private List<IRefreshRequiredObserver> mapRefreshObserver = new ArrayList<>();

    public ThreadEngine(AbstractWorldMap map,Vector2d[] positions, int moveDelay){
        this.map=map;
        this.moveDelay=moveDelay;
        for (Vector2d position:positions){
            Animal animal=new Animal(this.map,position);
            this.map.place(animal);
            animals.add(animal);
        }
    }
    public ThreadEngine(List<MoveDirection> moves,AbstractWorldMap map,Vector2d[] positions,int moveDelay){
        this(map,positions,moveDelay);
        this.setMoves(moves);
    }

    @Override
    public void run() {
        ListIterator<MoveDirection> movesIterator=this.moves.listIterator();
        try{
            while(movesIterator.hasNext()){
                int i=movesIterator.nextIndex();
                MoveDirection moveDirection = movesIterator.next();
                this.animals.get(i%this.animals.size()).move(moveDirection);
                updateObservers();
                Thread.sleep(moveDelay);
            }
        }catch(InterruptedException e){
            System.out.println("Waiting for move interrupted");
        }



    }
    public void setMoves(List<MoveDirection> moves){
        this.moves=moves;
    }
    public void addObserver(IRefreshRequiredObserver observer){
        this.mapRefreshObserver.add(observer);
    }
    public void removeObserver(IRefreshRequiredObserver observer){
        this.mapRefreshObserver.remove(observer);
    }
    void updateObservers(){
        for(IRefreshRequiredObserver observer:this.mapRefreshObserver){
            observer.refresh();
        }
    }
}
