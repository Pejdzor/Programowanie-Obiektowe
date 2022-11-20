package agh.ics.oop;

import java.util.Comparator;
import java.util.TreeSet;

public class MapBoundary implements IPositionChangeObserver{
    TreeSet<Vector2d> xsorted = new TreeSet<>(new Comparator<Vector2d>() {
        @Override
        public int compare(Vector2d o1, Vector2d o2) {
            if (o1.x>o2.x||(o1.x==o2.x && o2.y<=o1.y)){
                return 1;
            }
            return -1;
        }
    });
    TreeSet<Vector2d> ysorted = new TreeSet<>(new Comparator<Vector2d>() {
        @Override
        public int compare(Vector2d o1, Vector2d o2) {
            if (o1.y>o2.y||(o1.y==o2.y && o2.x<=o1.x)){
                return 1;
            }
            return -1;
        }
    });

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        remove(oldPosition);
        add(newPosition);

    }
    public void add(Vector2d position){
        xsorted.add(position);
        ysorted.add(position);
    }

    public void remove(Vector2d position){
        xsorted.remove(position);
        ysorted.remove(position);
    }




}
