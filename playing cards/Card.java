abstract class Card
{
    public enum Rank
    {
        ACE (1, "One"), TWO (2, "Two"), THREE (3, "Three"), FOUR (4, "Four"), FIVE (5, "Five"), SIX (6, "Six"), SEVEN (7, "Seven"), EIGHT (8, "Eight"), NINE (9, "Nine"), TEN (10, "Ten"), KNIGHT (12, "Twelve"), QUEEN (13, "Thirteen"), KING (14, "Fourteen");
        private final int value;
        private final String text;
        Rank(int value, String text)
        {
            this.value = value;
            this.text = text;
        }
    }
}