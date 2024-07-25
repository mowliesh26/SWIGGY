import java.util.Scanner;

class Player {
    String name;
    int health;
    int strength;
    int attack;

    Player(String name, int health, int strength, int attack) {
        this.name = name;
        this.health = health;
        this.strength = strength;
        this.attack = attack;
    }

    void takeDamage(int damage) {
        this.health -= damage;
    }

    boolean isAlive() {
        return this.health > 0;
    }
}

public class MagicalArena {
    static Scanner scanner = new Scanner(System.in);

    static int getDiceRoll(String playerName) {
        System.out.print(playerName + ", enter your dice roll (1-6): ");
        int roll = scanner.nextInt();
        while (roll < 1 || roll > 6) {
            System.out.print("Invalid roll. " + playerName + ", enter a valid dice roll (1-6): ");
            roll = scanner.nextInt();
        }
        return roll;
    }

    static void attack(Player attacker, Player defender) {
        int attackRoll = getDiceRoll(attacker.name);
        int defendRoll = getDiceRoll(defender.name);
        int attackDamage = attacker.attack * attackRoll;
        int defendStrength = defender.strength * defendRoll;
        int damageToDefender = Math.max(0, attackDamage - defendStrength);
        defender.takeDamage(damageToDefender);

        System.out.println(attacker.name + " attacks and rolls die: " + attackRoll);
        System.out.println(defender.name + " defends and rolls die: " + defendRoll);
        System.out.println("Attack damage: " + attackDamage + ", Defend strength: " + defendStrength);
        System.out.println(defender.name + " health reduced by " + damageToDefender + " to " + defender.health);
        System.out.println();
    }

    static void startBattle(Player player1, Player player2) {
        Player currentAttacker = player1.health < player2.health ? player1 : player2;
        Player currentDefender = currentAttacker == player1 ? player2 : player1;

        while (player1.isAlive() && player2.isAlive()) {
            attack(currentAttacker, currentDefender);
 
            Player temp = currentAttacker;
            currentAttacker = currentDefender;
            currentDefender = temp;
        }

        System.out.println("Game Over!");
        if (player1.isAlive()) {
            System.out.println(player1.name + " wins with " + player1.health + " health left.");
        } else {
            System.out.println(player2.name + " wins with " + player2.health + " health left.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.println("Enter details for Player A:");
        System.out.print("Name: ");
        String nameA = scanner.nextLine();
        System.out.print("Health: ");
        int healthA = scanner.nextInt();
        System.out.print("Strength: ");
        int strengthA = scanner.nextInt();
        System.out.print("Attack: ");
        int attackA = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter details for Player B:");
        System.out.print("Name: ");
        String nameB = scanner.nextLine();
        System.out.print("Health: ");
        int healthB = scanner.nextInt();
        System.out.print("Strength: ");
        int strengthB = scanner.nextInt();
        System.out.print("Attack: ");
        int attackB = scanner.nextInt();

    
        Player playerA = new Player(nameA, healthA, strengthA, attackA);
        Player playerB = new Player(nameB, healthB, strengthB, attackB);

    
        startBattle(playerA, playerB);
    }
}
