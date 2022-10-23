package agh.ics.oop;
import static java.lang.System.out;

public class World {


    public static void main(String[] args){

        Animal dog=new Animal();
        System.out.println(dog);
        MoveDirection[] commands = OptionParser.parse(args);
        for (MoveDirection command :commands){
            dog.move(command);
        }
        System.out.println(dog);
    }


}
