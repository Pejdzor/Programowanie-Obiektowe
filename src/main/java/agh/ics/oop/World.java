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
        out.println("system wystartował");
        Direction[] dirarg = Direction.strArrtoDir(args);
        run(dirarg);
        out.println("system zakończył działanie");
    }
}
