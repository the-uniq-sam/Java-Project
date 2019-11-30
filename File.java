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

        fw.close(); 
    } 
}


class ReadFile 
{
	String data;

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

        	data = sb.toString();

  
        	fr.close();
        }
        catch (FileNotFoundException fe)
        {
        	System.out.println("File not found");
        }
         
    }

    String getdata()
    {
    	return data;
    }
}

class AppendFile
{
	AppendFile(String filename, String input) throws IOException
	{
		FileWriter fw = new FileWriter(filename, true);

		fw.write(input);

		fw.write("\n");

        fw.close();
	}
}

class File
{
	public static void main(String []args) throws IOException
	{

		Scanner sc = new Scanner(System.in);


		int fill = 0;

		System.out.println("Do you want to check previous attendance or fill new ones. 0 for previous, 1 to fill");
		fill = sc.nextInt();

		if(fill == 1)
		{
			
			System.out.println("Enter 0 and 1 according to classes (Microprocessor, OS, Java, TOC, Maths)");
			String input = sc.next();
			try
			{
				AppendFile y = new AppendFile("output.txt", input);
			}
			catch(FileNotFoundException fe)
			{
				System.out.println("File not found");
			}

		}
		else
		{
			try
			{
				ReadFile z = new ReadFile("output.txt");
				String temp = z.getdata();

				double classes = 0, microprocessor = 0, os = 0, java = 0, toc = 0, maths = 0;


				for(int i = 0; i<temp.length(); i = i+5)
				{
					String t = temp.substring(i, i+5);
					
					if(t.charAt(0) == '1')
					{
						microprocessor += 1;
					}
					if(t.charAt(1) == '1')
					{
						os += 1;
					}
					if(t.charAt(2) == '1')
					{
						java += 1;
					}
					if(t.charAt(3) == '1')
					{
						toc += 1;
					}
					if(t.charAt(4) == '1')
					{
						maths += 1;
					}

					i++;
					classes++;
				}

				/*****Given double are the values to be shown to user */


				double mip = (microprocessor*100)/classes;
				double op = (os*100)/classes;
				double jp = (java*100)/classes;
				double tp = (toc*100)/classes;
				double map = (maths*100)/classes;


				System.out.println(classes + " " + mip + " " + op + " " + jp +  " " + tp + " " + map);

				if(mip < 75.0)
				{
					double a =  (classes * mip)/25;
					mip = 3*classes - a;

					System.out.println("classes require in mip = " + (int)mip);
				}
				if(op < 75.0)
				{
					double b = (classes*op)/25;
					op = 3*classes - b;
					System.out.println("classes require in op = " + (int)op);
				}
				if(jp < 75.0)
				{
					double c = (classes*jp)/25;
					jp = 3*classes - c;
					System.out.println("classes require in jp = " + (int)jp);
				}
				if(tp < 75.0)
				{
					double d = (classes*tp)/25;
					tp = 3*classes - d;
					System.out.println("classes require in tp = " + (int)tp);
				}
				if(map < 75.0)
				{
					double e = (classes*map)/25;
					map = 3*classes - e;
					System.out.println("classes require in map = " + (int)map);
				}




			}
			catch(FileNotFoundException fe)
			{
				System.out.println("File:output.txt not found");
			}
			

		}


	}
}
