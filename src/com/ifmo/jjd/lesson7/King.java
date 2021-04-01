package com.ifmo.jjd.lesson7;

import com.ifmo.jjd.lesson7.utils.Randoms;

import java.util.Arrays;

import static com.ifmo.jjd.lesson7.Settings.*;

final public class King extends Unit{
    private int gold;
    private BattleUnit[] army;

    public King () {
        super (KING_HEALTH) ;
        generateArmy();
        gold = GOLD_COUNT;
    }

    // стоимость армии 200
    private void generateArmy(){
        army = new BattleUnit[ARMY_COUNT] ;
        for (int i = 0; i < ARMY_COUNT; i++) {
            army[i] = BattleUnit.getBattleUnit() ;
            this.minusGold(ARMY_COST) ;
        }
    }

    public void addUnits(){
        for (int i = 0; i < ARMY_COUNT; i++) {
              if (!this.army[i].isAlive() && !(this.gold>=UNIT_COST)){
                army[i] = BattleUnit.getBattleUnit() ;
                this.minusGold(UNIT_COST) ;
              }
        }
    }

    public void startBattle (King enemy) {
        for (int i = 0; i < ARMY_COUNT; i++) {
            int randomUnit = Randoms.getRandomInt(ARMY_COUNT);
            int randomEnemiesUnit = Randoms.getRandomInt(ARMY_COUNT);
            if (this.army[randomUnit].isAlive() && enemy.army[randomEnemiesUnit].isAlive()) {
                this.army[randomUnit].attack(enemy.army[randomEnemiesUnit]);
                this.army[randomUnit].rest();
            }
            randomUnit = Randoms.getRandomInt(ARMY_COUNT);
            randomEnemiesUnit = Randoms.getRandomInt(ARMY_COUNT);
            if (this.army[randomUnit].isAlive() && enemy.army[randomEnemiesUnit].isAlive()) {
                enemy.army[randomEnemiesUnit].attack(this.army[randomUnit]);
                enemy.army[randomEnemiesUnit].rest();
            }
        }
    }

    private boolean hasGold() {
        return gold>0 ;
    }

    private void plusGold (int count) {
        gold += count ;
    }

    private void minusGold (int count) {
        if (!hasGold()) return ;
        gold -= count ;
    }

    @Override
    public void rest() {
        minusGold(50);
        plusHealth(10);
    }

    @Override
    public String toString() {
        return "King{" +
                "gold=" + gold +
                ", army=" + Arrays.toString(army) +
                '}';
    }
}
