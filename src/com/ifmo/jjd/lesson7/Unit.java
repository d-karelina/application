package com.ifmo.jjd.lesson7;

abstract class Unit implements RestAble {
    // класс реализует интерфейс RestAble
    protected int healthScore ;
    protected final int maxHealthScore ;

    public Unit (int healthScore) {
        this.healthScore = healthScore ;
        maxHealthScore = healthScore ;
    }

    public boolean isAlive () {
        return (healthScore > 0) ;
    }

    public void plusHealth (int count) {
        if (!isAlive()) return ;
        this.healthScore += count ;
        healthScore = healthScore + count >= maxHealthScore ? maxHealthScore : healthScore + count ;

        // healthScore = Math.min(healthScore + count, maxHealthScore) ;

        /*
        if (healthScore <= maxHealthScore) return ;
        else this.healthScore = maxHealthScore ;

         */
    }
    public void minushealth (int count) {
        if (!isAlive()) return ;
        this.healthScore -= count ;
        return ;
    }
}
