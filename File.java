import java.io.*;
import java.util.*;
import java.io.BufferedReader;

class CreateFile 
{ 
    CreateFile(String filename, String input) throws IOException
    {
        FileWriter fw=new FileWriter(filename); 

        fw.write(input);

        fw.write("\n");

        //System.out.println("Writing successful"); 
        fw.close(); 
    } 
}


class ReadFile 
{ 
    ReadFile(String filename) throws IOException
    { 
        String s;
  
        FileReader fr=null; 
        try
        { 
        	fr = new FileReader(filename);
        	BufferedReader br = new BufferedReader(fr);
        	StringBuffer sb = new StringBuffer();

        	while ((s=br.readLine())!=null) 
        	{
            	sb.append(s);
            	sb.append("\n");
        	}

        	System.out.print(sb.toString());
  
        	fr.close();
        }
        catch (FileNotFoundException fe)
        {
        	System.out.println("File not found");
        }
         
    } 
}

class AppendFile
{
	AppendFile(String filename, String input) throws IOException
	{
		FileWriter fw = new FileWriter(filename, true);

		fw.write(input);

		fw.write("\n");

        //System.out.println("Appending successful"); 
        fw.close();
	}
}

class File
{
	public static void main(String []args) throws IOException
	{
		//System.out.println("Reading file");

		Scanner sc = new Scanner(System.in);

		try
		{
			ReadFile x = new ReadFile("output.txt");
		}
		catch(FileNotFoundException fe)
		{
			System.out.println("File not found");
		}

		//System.out.println("Writing file");

		try
		{
			System.out.println("Input the string to write.");
			String input = sc.nextLine();
			CreateFile y = new CreateFile("output.txt", input);
		}
		catch(FileNotFoundException fe)
		{
			System.out.println("File not found");
		}

		//System.out.println("Appending file");

		try
		{
			System.out.println("Input the string to append.");
			String input = sc.nextLine();
			AppendFile z = new AppendFile("output.txt", input);
		}
		catch(FileNotFoundException fe)
		{
			System.out.println("File not found");
		}

	}
}
