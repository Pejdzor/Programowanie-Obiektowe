package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class SimulationEngine implements IEngine,Runnable {
    private List<MoveDirection> ruchy;
    public List<Animal> pieseczki = new ArrayList<>();

    public SimulationEngine(List<MoveDirection> ruchy, AbstractWorldMap map, Vector2d[] pozycje) {
        try{
        for(Vector2d pozycja : pozycje){
                Animal zwierzatko = new Animal(map, pozycja);
                map.place(zwierzatko);
                this.pieseczki.add(zwierzatko);
        }
        this.ruchy = ruchy;
        }catch(IllegalArgumentException e){System.out.println(e.getMessage());
        }

    }
    @Override
    public void run() {
        for(int i = 0; i<this.ruchy.size(); i++){
            this.pieseczki.get(i%pieseczki.size()).move(this.ruchy.get(i));
        }
    }
}
