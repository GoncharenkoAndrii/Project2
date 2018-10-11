public class Date {

    private final static Date etalonDate = new Date();

    static {
        etalonDate.day = new Day(10);
        etalonDate.month = new Month(10);
        etalonDate.year = new Year(2018);
        etalonDate.name = NameOfTheDaysOfTheWeek.Wednesday;
    }

    public enum NameOfTheDaysOfTheWeek {Sunday, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday}

    ;

    private NameOfTheDaysOfTheWeek name;
    private Day day;
    private Month month;
    private Year year;

    public Date() {

    }

    public Date(int DD, int MM, int YY) {
        this.day = new Day(DD);
        this.month = new Month(MM);
        this.year = new Year(YY);
        calculateDateName();
    }

    private void calculateDateName() {
        int dayCount = calculateDaysFromBegin(this);
        int constCount = calculateDaysFromBegin(etalonDate);

        int daysPassed = dayCount - constCount;
        int dayInWeek = daysPassed % 7;

        NameOfTheDaysOfTheWeek buffer = NameOfTheDaysOfTheWeek.values()[3];
        int index = 0;
        if (daysPassed > 0) {
            index = etalonDate.name.ordinal() + dayInWeek;
            if (index > NameOfTheDaysOfTheWeek.values().length - 1) {
                index = index % NameOfTheDaysOfTheWeek.values().length;
            }

        }
        if (daysPassed < 0){
            index = etalonDate.name.ordinal() + dayInWeek;
            if(index < 0){
                index = index + NameOfTheDaysOfTheWeek.values().length;
            }
        }
        if (daysPassed == 0){index = etalonDate.name.ordinal();}

        name = NameOfTheDaysOfTheWeek.values()[index];

    }

    private static int calculateDaysFromBegin(Date date) {
        int sum = 0;

        int numOfSpecEXperiment = 0;
        sum = sum + (date.year.getYear() - 1) * 365;

        numOfSpecEXperiment = date.year.getYear() / 4 - date.year.getYear() / 100 + date.year.getYear() / 400 + 1;

        sum = sum + date.day.getDay() + numOfSpecEXperiment;
        int i = 0;
        while (i < date.month.getMonth() - 1) {
            sum = sum + Month.MONTH_DURABILITY[i];
            i++;
        }
        if ((date.year.IsVisokosny()) && (date.month.getMonth() > 2)) {
            sum = sum + 1;
        }

        return sum;
    }
    public static void DifferenceInDays (Date d1, Date d2){
        int a = calculateDaysFromBegin(d1);
        int b  =calculateDaysFromBegin(d2);
        System.out.println("Interval of days in chosen interval - " + Math.abs(a-b));
        int monthCounter =  Math.abs((d1.year.getYear()-d2.year.getYear())*12+
                (d1.month.getMonth()-d2.month.getMonth()));
        if (d1.day.getDay() > d2.day.getDay()){monthCounter--;}
        System.out.println("Interval of month in chosen interval - " + monthCounter );
    }

    public static void main(String[] args) {
        /*Date c1 = new Date();
        c1.year = new Year(401);
        c1.month = new Month(0);
        c1.day = new Day(0);
        calculateDaysFromBegin(c1);*/

        Date c2 = new Date(8,3,1999);
        System.out.println(c2.name);
        Date c3 = new Date(5,10,1999);
        DifferenceInDays(c2,c3);
    }

}
