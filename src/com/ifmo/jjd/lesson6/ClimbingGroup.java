package com.ifmo.jjd.lesson6;

import java.util.Arrays;
import java.util.Objects;

public class ClimbingGroup {
    private Mountain mountain ;
    private Climber[] climbers ;

    public ClimbingGroup(Mountain mountain, int climberCount) {
        this.mountain = Objects.requireNonNull(mountain, "mountain не может быть null");
        climbers = new Climber[climberCount] ;
    }

    public void addClimber(Climber climber){
        Objects.requireNonNull(climber, "climber не может быть null");
        for (int i = 0; i < climbers.length; i++) {
            if (climbers[i] == null) {
                climbers[i] = climber ;
                return; //в void методах return работает для завершения работы метода
            }
        }
        System.out.println("мест нет");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClimbingGroup)) return false;
        ClimbingGroup that = (ClimbingGroup) o;
        return mountain.equals(that.mountain) && Arrays.equals(climbers, that.climbers);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(mountain);
        result = 31 * result + Arrays.hashCode(climbers);
        return result;
    }

    @Override
    protected ClimbingGroup clone() {
        Mountain copyM = this.mountain.clone();
        ClimbingGroup copy = new ClimbingGroup(copyM, climbers.length) ;
        copy.climbers = climbers.clone();
        return copy;
    }

    @Override
    public String toString() {
        return "ClimbingGroup{" +
                "mountain=" + mountain +
                ", climbers=" + Arrays.toString(climbers) +
                '}';
    }
}
