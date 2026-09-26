public class Program
{
    public static void main(String[] args)
    {
        Date objDate = new Date();

        System.out.println("Date Menu");
        System.out.println("1. Set Date");
        System.out.println("2. Add Days");
        System.out.println("3. Add Months");
        System.out.println("4. Add Years");
        System.out.println("5. Display");
        System.out.println("6. Compare Dates (not implement)");
        System.out.println("7. Exit");

        System.out.println("Enter your choice");
        int choice = ConsoleInput.getInt();

        if(choice == 1)
        {
            System.out.println("Enter the day");
            int day = ConsoleInput.getInt();

            System.out.println("Enter the month");
            int month = ConsoleInput.getInt();

            System.out.println("Enter the year");
            int year = ConsoleInput.getInt();

            objDate.setDate(day, month, year);
        }

        else if(choice == 2)
        {
            System.out.println("Enter number of days");
            int days = ConsoleInput.getInt();

            objDate.addDays(days);
        }

        else if(choice == 3)
        {
            System.out.println("Enter number of months");
            int months = ConsoleInput.getInt();

            objDate.addMonths(months);
        }

        else if(choice == 4)
        {
            System.out.println("Enter number of years");
            int years = ConsoleInput.getInt();

            objDate.addYears(years);
        }

        else if(choice == 5)
        {
            objDate.display();
        }

        else if(choice == 6)
        {
            System.out.println("Compare Dates - Not Implemented");
        }

        else if(choice == 7)
        {
            System.out.println("Exit");
        }

        else
        {
            System.out.println("Invalid choice");
        }
    }
}