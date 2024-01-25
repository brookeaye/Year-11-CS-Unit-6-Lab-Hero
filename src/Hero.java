public class Hero {
    String name;
    int hitPoints;
    public Hero(String name){
        this.name = name;
        hitPoints = 100;
    }
    public String getName(){
        return name;
    }
    public int getHitPoints(){
        return hitPoints;
    }
    public String toString(){
        return "Hero{name='" + name + "', hitPoints=" + hitPoints + "}";
    }
    public void attack(Hero opponent){
        double num = Math.random();
        if (num < 0.5){
            opponent.hitPoints -= 10;
        }
        if (num >= 0.5){
            hitPoints -= 10;
        }
    }
    public void senzuBean(){
        hitPoints = 100;
    }
    private void fightUntilTheDeathHelper(Hero opponent){
        while (opponent.hitPoints > 0 && hitPoints > 0){
            attack(opponent);
        }
    }
    public String fightUntilTheDeath(Hero opponent){
        fightUntilTheDeathHelper(opponent);
        return opponent.name + ": " + opponent.hitPoints + "\t" + name + hitPoints;
    }
    private int[] nFightsToTheDeathHelper(Hero opponent, int n){
        int[] wins = {0, 0};
        for (int i = 0; i < n; i++){
            fightUntilTheDeathHelper(opponent);
            if (opponent.hitPoints == 0){
                wins[0]++;
            }
            else{
                wins[1]++;
            }
            opponent.senzuBean();
            senzuBean();
        }
        return wins;
    }
    //0 is ME. 1 is the opponent who won.
    public String nFightsToTheDeath(Hero opponent, int n){
        int[] endResult = nFightsToTheDeathHelper(opponent, n);
        if (endResult[0] == endResult[1]){
            return opponent.name + ": " +  endResult[1] + " wins\n" + name + ": " + endResult[0] + " wins\n" + "OMG! It was actually a draw!";
        }
        else if (endResult[0] > endResult[1]){
            return opponent.name + ": " +  endResult[1] + " wins\n" + name + ": " + endResult[0] + " wins\n" + name + " wins!";
        }
        return opponent.name + ": " +  endResult[1] + " wins\n" + name + ": " + endResult[0] + " wins\n" + opponent.name + " wins!";
    }
    public void dramaticFightToTheDeath(Hero opponent) throws InterruptedException {
        while (opponent.hitPoints > 0 || hitPoints > 0){
            attack(opponent);
            System.out.println(opponent.name + ": " + opponent.hitPoints + "\t"+ name + ": " + hitPoints);
            Thread.sleep(100);
        }
        if (opponent.hitPoints == 0){
            System.out.println(name + " wins!");
        }
        else{
            System.out.println(opponent.name + " wins!");
        }
    }
}
