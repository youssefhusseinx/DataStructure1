package eg.edu.alexu.csd.datastructure.iceHockey.cs;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Point;

import org.junit.jupiter.api.Test;

class findertest {

	@Test
	void test() {
		PlayersFinder match=new PlayersFinder();
		String[] string1=null;
		Point[] x1=match.findPlayers(string1, 8, 9);
		System.out.println(x1);
		
		String[] string2={
				"33JUBU33",
				"3U3O4433",
				"O33P44NB",
				"PO3NSDP3",
				"VNDSD333",
				"OINFD33X"
				};
		Point[] x2=match.findPlayers(string2, 3, 16);
		for(int i=0;i<x2.length;i++)
		{
		System.out.println(x2[i] );
		}
		
		
		String[] string3={
				"44444H44S4",
				"K444K4L444",
				"4LJ44T44XH",
				"444O4VIF44",
				"44C4D4U444",
				"4V4Y4KB4M4",
				"G4W4HP4O4W",
				"4444ZDQ4S4",
				"4BR4Y4A444",
				"4G4V4T4444"
				};
		Point[] x3=match.findPlayers(string3, 4, 16);
		for(int i=0;i<x3.length;i++)
		{
		System.out.println(x3[i] );
		}
		
		
		String[] string4={
				"8D88888J8L8E888",
				"88NKMG8N8E8JI88",
				"888NS8EU88HN8EO",
				"LUQ888A8TH8OIH8",
				"888QJ88R8SG88TY",
				"88ZQV88B88OUZ8O",
				"FQ88WF8Q8GG88B8",
				"8S888HGSB8FT8S8",
				"8MX88D88888T8K8",
				"8S8A88MGVDG8XK8",
				"M88S8B8I8M88J8N",
				"8W88X88ZT8KA8I8",
				"88SQGB8I8J88W88",
				"U88H8NI8CZB88B8",
				"8PK8H8T8888TQR8"
				};
		Point[] x4=match.findPlayers(string4, 8, 9);
		for(int i=0;i<x4.length;i++)
		{
		System.out.println(x4[i] );
		}
		
		String[] string5={
				"11111",
				"1AAA1",
				"1A1A1",
				"1AAA1",
				"11111"
				};
		Point[] x5=match.findPlayers(string5, 1, 3);
		for(int i=0;i<x5.length;i++)
		{
		System.out.println(x5[i] );
		}
	}

}
