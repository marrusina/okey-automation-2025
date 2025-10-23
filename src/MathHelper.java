public class MathHelper
{
    public int calc(int a, int b, char action) {
        if (action == '+')
        {
            return this.plus(a, b);
        } else if (action == '-')
        {
            return this.minus(a,b);
        } else if (action == '*')
        {
            return this.multiply(a, b);
        } else if (action == '/')
        {
            return this.div(a,b);
        } else return this.returnError("Strange divider");

    }

    private int returnError(String error)
    {
        System.out.println(error);
        return 0;
    }

    private int plus(int a, int b)
    {
        return a + b;
    }

    private int minus(int a, int b)
    {
        return a - b;
    }

    private int multiply(int a, int b)
    {
        return a * b;
    }

    private int div(int num, int div)
    {
        if (div == 0)
        {
            return this.returnError("Cannot divide by zero");
        }
        else
        {
            return num / div;
        }
    }
}
