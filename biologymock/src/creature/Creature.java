package creature;

import field.Location;

import java.util.ArrayList;

public abstract class Creature {
    private double age;
    private double ageLimit;
    private boolean isAlive = true;
    private double breedAge;

    public Creature(int ageLimit, int breedAge) {
        this.ageLimit = ageLimit;
        this.breedAge = breedAge;
    }

    public boolean isBreedable() {
        return age >= breedAge;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public Location move(Location[] freeAdj) {
        Location ret = null;
        if (freeAdj.length > 0 && Math.random() < 0.2) {
            ret = freeAdj[(int) (Math.random() * freeAdj.length)];
        }
        return ret;
    }

    public Location feed(ArrayList<Location> neighbour) {
        return null;
    }

    public void grow() {
        if (age >= ageLimit) {
            die();
        } else
            age++;
    }

    public abstract Creature breed();

    public void die() {
        isAlive = false;
    }

    public double getPerOfAge() {
        return age / ageLimit;
    }

    protected void longerLife(double inc) {
        ageLimit += inc;
    }

}
