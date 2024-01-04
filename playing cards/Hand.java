package LAB3;

public class Hand 
{
    private List<MyCard> cards = new ArrayList<>();
    public static void addCard(Card c)
    {
        this.cards.add(c);
        System.out.println("Added card: " + c);
    }
}
