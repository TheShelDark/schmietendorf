package erstproject;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

public class FileTest 
{

	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException 
	{
		// TODO Auto-generated method stub
		
		//File myFileObj = new File("c:\\");
		
		//String[] erg = myFileObj.list();
		
		boolean end = false;
		String pathtemp;
		File directory = new File("c:\\");
		String path = directory.getAbsolutePath();
		
		while (end == false)
		{			
					
			System.out.print("Pfad: " + path + "\t Befehl: ");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String s = br.readLine();           
            
			
            if (s.startsWith("end"))
			{
				System.out.println("Tschüss, schönen Tag noch!");
				end = true;
			}
			else if (s.startsWith("dir"))
			{
				dir (path);
				
			}	
			else if (s.startsWith("cd"))
			{
				if (s.substring(3, 4) == "..")
				{
					int i = path.lastIndexOf("\\");
					path = path.substring(0, i);
				}
				else if (s.substring(3, 4) != "..")
				{
					path = path + "\\" + s.substring(3);
				}			
			
			}
			else if (s.startsWith("md"))
			{
				pathtemp = path;
				path = path + "\\" + s.substring(3);					
				md(path);
				path = pathtemp;
					
			}
            
			else if (s.startsWith("del"))
			{
				pathtemp = path;
				path = path + "\\" + s.substring(4);					
				del(path);
				path = pathtemp;	
			}
			
		}	
			
			
	}
	
		
	
	public static void dir (String v)
	{
		File fi = new File (v);
		Date d = new Date (fi.lastModified());
		System.out.println("Letzte Änderung" + d);
		System.out.println("Pfad " + fi.getAbsolutePath());
		String teststring [] = fi.list();
		for (int i = 0; i < teststring.length; i++)
		{
			System.out.println(teststring[i]);
			String fn = fi.getAbsolutePath() + "/" + teststring[i];
			File f1 = new File (fn);
			System.out.println(" \t \t --- Filegröße " + f1.length() + " Byte ");
		}
	}
	
	public static void del (String v)
	{
		File fi = new File (v);
		if (fi.exists() == true)
		{
			System.out.println("Datei " + fi.getName() + " erfolgreich gelöscht!");
			fi.delete();		
		}
		else
		{
			System.out.println("Diese Datei oder dieses Verzeichnis existiert nicht!!");
		}
		
		
	}
	
	public static void md (String v)
	{
		File fi = new File (v);
		if (fi.exists() == false)
		{
			
			fi.mkdir();
			System.out.println("Verzeichnis " + fi.getName() + " erfolgreich erstellt!");
		}
		else
		{
			System.out.println("Verzeichnis " + fi.getName() + " existiert bereits!");
		}
		
		
	}

}
