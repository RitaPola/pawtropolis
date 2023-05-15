package pawtropoliss.domain.game;

import lombok.*;

import java.util.logging.Logger;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Player{
    private String name;
    private int health;
    private final Bag bagPlayer;

    /*aggiunge un oggetto nello zaino del giocatore*/
    public void addItemInTheBagPlayerBag(Item item) {
        bagPlayer.addItem(item);
    }

    /*rimozione oggetto dallo zaino del giocatore*/
    public Item removeItemFromTheBagPlayer(Item item) {
        return bagPlayer.removeItem(item);
    }

    /*rimozione dell'oggetto tramite nome*/
    public Item removeItemFromTheBagPlayerByName(String nameItem) {
        return bagPlayer.removeItemByName(nameItem);
    }

    /*rimuove tutti oggetti dallo zaino del giocatore*/
    public void removeAllItemFromTheBagPlayer() {
        bagPlayer.removeAllItemFromTheBag();
    }

    /*Ricerca oggetto per nome*/
    public Item getItemFromTheBagPlayerByName(String nameItem) {
        return bagPlayer.getItemByName(nameItem);
    }

    /*verifica gli slot disponibili nella borsa*/
    public int availableSlotsInBag() {
        return bagPlayer.checkAvailableSlotsInTheBag();
    }

    /*incrementa la vita del giocatore*/
    public void increasePlayerLifePoints(int point) {
        if (point <= 0) {
            throw new IllegalArgumentException("The life point must be a positive integer");
        }
        health = Math.min(health + point, 100);
    }
    /*Decrementa la vita del giocatore*/
    public void decreasePlayerLifePoints(int point) {
        Logger LOGGER = Logger.getLogger("myLogger");
        if (point <= 0) {
            throw new IllegalArgumentException("The life point must be a positive integer");
        }
        int delta = health - point;
        health = Math.max(delta, 0);
        if (health == 0) {
            LOGGER.info("Player is dead");
        }
    }

    /*verifica se il player è vivo*/
    public boolean isAlive() {
        return health > 0;
    }

}
