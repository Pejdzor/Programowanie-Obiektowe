package agh.ics.oop;
import static java.lang.System.out;

public class World {
    public static void run(Direction[] args){
        for (Integer i=0;i<args.length;i++) {
            if (args[i] != null) {
                switch (args[i]) {
                    case FORWARD:
                        out.println("Zwierzak idzie do przodu");
                        break;
                    case BACKWARD:
                        out.println("Zwierzak idzie do tyłu");
                        break;
                    case RIGHT:
                        out.println("Zwierzak skręca w prawo");
                        break;
                    case LEFT:
                        out.println("Zwierzak skręca w lewo");
                        break;
                    default:
                        break;
                }
            }
        }
    }
    public static void main(String[] args){

        out.println(-1%4);
//Lab1
//        out.println("system wystartował");
//        Direction[] dirarg = Direction.strArrtoDir(args);
//        run(dirarg);
//        out.println("system zakończył działanie");
        Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));
        MapDirection kierunek=MapDirection.SOUTH;
        Vector2d a=kierunek.toUnitVector();
        System.out.println(a);
    }

}
