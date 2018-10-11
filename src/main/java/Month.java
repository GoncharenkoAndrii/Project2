public class Month {
    private int month ;
    public static int[] MONTH_DURABILITY = {31,28,31,30,31,30,31,31,30,31,30,31};
    public void setMonth (int currentMonth){this.month = currentMonth;}
    public int getMonth (){return month;}
    public Month(int currMonth){
        this.month = currMonth;
    }

}
