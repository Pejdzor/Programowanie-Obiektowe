package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class SimulationEngine implements IEngine {
    private MoveDirection[] ruchy;
    public List<Animal> pieseczki = new ArrayList<>();

    public SimulationEngine(MoveDirection[] ruchy, AbstractWorldMap map, Vector2d[] pozycje) {
        for(Vector2d pozycja : pozycje){
            if(!map.isOccupied(pozycja)){
                Animal zwierzatko = new Animal(map, pozycja);
                map.place(zwierzatko);
                this.pieseczki.add(zwierzatko);
            }
        }
        this.ruchy = ruchy;
    }
    @Override
    public void run() {
        for(int i = 0; i<this.ruchy.length; i++){
            this.pieseczki.get(i%pieseczki.size()).move(this.ruchy[i]);
        }
    }
}
