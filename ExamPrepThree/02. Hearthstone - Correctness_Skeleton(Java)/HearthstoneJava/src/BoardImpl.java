import java.util.*;
import java.util.stream.Collectors;

public class BoardImpl implements Board {

    private Map<String, Card> cards;

    public BoardImpl() {
        this.cards = new HashMap<>();

    }

    @Override
    public void draw(Card card) {
        if (cardExists(card)) {
            throw new IllegalArgumentException();
        }

        this.cards.put(card.getName(), card);
    }

    @Override
    public Boolean contains(String name) {
        return cardExistByName(name);
    }

    @Override
    public int count() {
        return this.cards.size();

    }

    @Override
    public void play(String attackerCardName, String attackedCardName) {
        if (!cardExistByName(attackedCardName) || !cardExistByName(attackerCardName)) {
            throw new IllegalArgumentException();
        }
        Card attacker = this.cards.get(attackerCardName);
        Card attacked = this.cards.get(attackedCardName);

        if (attacker.getLevel() != attacked.getLevel()) {
            throw new IllegalArgumentException();
        }
        if (attacked.getHealth() <= 0) {
            return;
        }
        if (attacked.getHealth() - attacker.getDamage() <= 0) {
            attacker.setScore(attacker.getScore() + attacked.getLevel());
        }
        attacked.setHealth(attacked.getHealth() - attacker.getDamage());

    }

    private boolean cardExistByName(String nameOfCard) {
        return this.cards.containsKey(nameOfCard);
    }

    @Override
    public void remove(String name) {
        if (!cardExistByName(name)) {
            throw new IllegalArgumentException();
        }

        this.cards.remove(name);

    }

    @Override
    public void removeDeath() {
        this.cards.values().stream().filter(card -> card.getHealth() <= 0).collect(Collectors.toList()).
                forEach(card -> this.cards.remove(card.getName(), card));

    }

    @Override
    public Iterable<Card> getBestInRange(int start, int end) {
        List<Card> collect = this.cards.values().stream().filter(card -> card.getScore() >= start).
                filter(card -> card.getScore() <= end).sorted((c1, c2) -> {
                    return Integer.compare(c2.getLevel(), c1.getLevel());
                }).collect(Collectors.toList());
        return collect.isEmpty() ? Collections.emptyList() : collect;
    }

    @Override
    public Iterable<Card> listCardsByPrefix(String prefix) {
        return this.cards.values().stream().filter(card -> card.getName().startsWith(prefix)).
                sorted((c1, c2) -> {
                    int first = (int) c1.getName().charAt(c1.getName().length() - 1);
                    int second = (int) c2.getName().charAt(c2.getName().length() - 1);
                    int result = Integer.compare(first, second);
                    if (result == 0) {
                        result = Integer.compare(c1.getLevel(), c2.getLevel());
                    }
                    return result;
                }).collect(Collectors.toList());

    }



    @Override
    public Iterable<Card> searchByLevel(int level) {
        return this.cards.values().stream().filter(card -> card.getLevel() == level).
                sorted((c1, c2) -> Integer.compare(c2.getScore(), c1.getScore())).collect(Collectors.toList());
    }

    @Override
    public void heal(int health) {
        Card card = this.cards.values().stream().sorted((c1, c2) -> {
            return Integer.compare(c1.getHealth(), c2.getHealth());
        }).collect(Collectors.toList()).get(0);

        card.setHealth(card.getHealth() + health);
    }

    private boolean cardExists(Card card) {
        return this.cards.containsKey(card.getName());
    }
}
