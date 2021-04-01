package com.ifmo.jjd.lesson7;

import com.ifmo.jjd.lesson7.utils.Randoms;

abstract public class BattleUnit extends Unit implements AttackAble{
    private int attackScore ;

    public BattleUnit(int healthScore, int attackScore){
        super(healthScore); //вызов конструктора родителя
        this.attackScore = attackScore ;
    }

    public static BattleUnit getBattleUnit(){
         String[] types = {"knight", "infantry"} ;
         BattleUnit unit = null ;
         switch (types[Randoms.getRandomInt(types.length)]) {
             case "knight":
                 unit = new Knight(Randoms.getRandomInt(10,20), Randoms.getRandomInt(10,50));
                 break;
             case "infantry":
                 unit = new Infantry(Randoms.getRandomInt(5,15), Randoms.getRandomInt(30, 100));
                 break;
         }
         return unit;
    }


    public int getAttackScore() {
        return attackScore;
    }
}
