public class Str
{
    public static void main(String[] args)
    {
        String s = "Java Concept Of The Day";
        //Defining destination char array
        char[] dst = new char[s.length()];
        //Copying the set of characters from s into dst.
        s.getChars(5, 11, dst, 0);
        for (char c : dst)
        {
            System.out.print(c);       //Output : --Concep--
        }
    }
}