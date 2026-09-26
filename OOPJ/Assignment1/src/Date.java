public class Date
{
    private int day;
    private int month;
    private int year;


    // Setter / Mutator
    public void setDate(int dd, int mm, int yy)
    {
        year = yy;

        if(mm < 1 || mm > 12)
            month = 1;
        else
            month = mm;


        if(month == 1 || month == 3 || month == 5 ||
           month == 7 || month == 8 || month == 10 ||
           month == 12)
        {
            if(dd < 1 || dd > 31)
                day = 1;
            else
                day = dd;
        }

        else if(month == 4 || month == 6 ||
                month == 9 || month == 11)
        {
            if(dd < 1 || dd > 30)
                day = 1;
            else
                day = dd;
        }

        else
        {
            if(dd < 1 || dd > 28)
                day = 1;
            else
                day = dd;
        }
    }


    // Add Days
    public void addDays(int days)
    {
        for(int i = 1; i <= days; i++)
        {
            day++;

            if(month == 1 || month == 3 || month == 5 ||
               month == 7 || month == 8 || month == 10 ||
               month == 12)
            {
                if(day > 31)
                {
                    day = 1;
                    month++;
                }
            }

            else if(month == 4 || month == 6 ||
                    month == 9 || month == 11)
            {
                if(day > 30)
                {
                    day = 1;
                    month++;
                }
            }

            else
            {
                if(day > 28)
                {
                    day = 1;
                    month++;
                }
            }

            if(month > 12)
            {
                month = 1;
                year++;
            }
        }
    }


    // Add Months
    public void addMonths(int months)
    {
        for(int i = 1; i <= months; i++)
        {
            month++;

            if(month > 12)
            {
                month = 1;
                year++;
            }
        }
    }


    // Add Years
    public void addYears(int years)
    {
        year = year + years;
    }


    // Display
    public void display()
    {
        System.out.println(day + "/" + month + "/" + year);
    }
}