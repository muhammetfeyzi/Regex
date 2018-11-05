package Regex.com;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import matematikselAlgoritma.KacSeferde1000;

public class findStreetAdreesFromText {
	static float  okunanSatirSayisi=0.00f;
	static float bulunanAdresSayisi=0.00f;
	static float accurancy =0.00f;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		readDocument();
		System.out.println("Regex Adress Analyst"+"\n");
		System.out.println("match Adress Count "+bulunanAdresSayisi);
		System.out.println("----------------");
		System.out.println("read Adres Count "+okunanSatirSayisi +"\n");
		accurancy= (bulunanAdresSayisi/okunanSatirSayisi);
		System.out.println("likelohood : " + accurancy);
	}

	private static void readDocument() {
		// TODO Auto-generated method stub
		File file = new File("C:\\regexAdress.txt");
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Sisteme verilen data."+"\n");
		String st;
		try {
			while((st = br.readLine())!= null)
			{	
				okunanSatirSayisi+=1;
				System.out.println(st);
				chechkRegex(st);
				System.out.println();
				
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void chechkRegex(String str) {
		// TODO Auto-generated method stub
		// pattern declerations
		String mahPattern ="\\w*\\s*((Mahalle|Mah|mah|mh|Mh|mahalle))"; // test edildi.
		String sokakPattern ="\\w*\\s*((Sok|sk|Sk|sok))"; // test edildi.
		String NoPattern ="\\w*((no))\\s*\\W*[0-9]*"; // test edildi 
		String zipCodePattern = "\\d{5}(-\\d{4})?" ; // test edildi.
		String ilceSehirPattern = "\\w*\\s*\\/\\s*\\w*";
		
		//String adressPattern = "^"+mahPattern+"\\w+.*"+sokakPattern+"\\w+.*"+NoPattern+"\\w+,?"+zipCodePattern;
		//String mahx="^"+mahPattern+"\\.?\\s*"+sokakPattern+"\\.?\\s*"+NoPattern+"\\.?\\,?\\s*"+zipCodePattern+"\\s*"+ilceSehirPattern;
		String mahy =""+mahPattern+"\\.?\\s*"+sokakPattern+"\\.?\\s*"+NoPattern+"\\.?\\s*\\W*"+zipCodePattern+"\\s*"+ilceSehirPattern;
		
		Pattern pattern = Pattern.compile(mahy);
		Matcher match =pattern.matcher(str);
		if(match.find())
		{
			bulunanAdresSayisi+=1;
			System.out.println( match.group());
		}
		else{
		System.out.println(" " +match.find() );
		}
	}

}
