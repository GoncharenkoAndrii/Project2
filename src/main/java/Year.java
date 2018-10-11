public class Year {
    private int year ;
    public void setYear (int currentYear){this.year = currentYear;}
    public int getYear (){return year;}
    public Year(int currYear){
        this.year = currYear ;
    }
    public boolean IsVisokosny (){
        if (year%4==0){
            if ((year%100==0)&&(year%400!=0)){return false;}
            else{return true;}
        }
        return false;
    }
}
