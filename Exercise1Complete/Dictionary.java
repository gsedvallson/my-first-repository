import java.io.*;
import java.util.*;

public class Dictionary 
{
    // instansvariabler

    private ArrayList<Zoophobia> vec;

    // konstruktorer

    public Dictionary()
    {
        vec = new ArrayList<Zoophobia>();
    }

    // instansmetoder

    public void load() 
    {
        String line, phobia, animal;
        StringTokenizer tokens;
        try {
        BufferedReader infile = new BufferedReader
                               (new FileReader("old.txt"));

        while ((line = infile.readLine()) != null)
        {
            tokens = new StringTokenizer(line);
            phobia = tokens.nextToken();
            animal = tokens.nextToken();
            vec.add(new Zoophobia(phobia, animal));
        }

        infile.close();}
        catch(IOException ierr){}
    }

    public void print()
    {
        Collections.sort(vec);

        for (int i = 0; i < vec.size(); i++)
        {
            System.out.println(vec.get(i));
        }
    }

    public void insert(Zoophobia zp)
    {
        int i = 0;

        while (i < vec.size() && zp.compareTo(vec.get(i)) != 0)
        {
            i++;
        }

        if (i < vec.size())
        {
            vec.get(i).setAnimal(zp.getAnimal());
        }
        else
        {
            vec.add(zp);
        }
    }

    public void delete(String phobia)
    {
        for (int i = 0; i < vec.size(); i++)
        {
            if (phobia.equals(vec.get(i).getPhobia()))
            {
                vec.remove(i);
                //  break;
            }
        }
    }

    public String lookup(String phobia)
    {
        for (int i = 0; i < vec.size(); i++)
        {
            if (phobia.equals(vec.get(i).getPhobia()))
            {
                return vec.get(i).getAnimal();
            }
        }

        return "unknown";
    }

    public void save() 
    {
    	try {
        Collections.sort(vec);

        PrintWriter outfile = new PrintWriter
                             (new BufferedWriter
                             (new FileWriter("new.txt")));

        for (int i = 0; i < vec.size(); i++)
        { 
            outfile.format("%-20s%s\n", vec.get(i).getPhobia(),
                                        vec.get(i).getAnimal());
        }

        outfile.close();}
    	catch(IOException ierr){}
    }
}
