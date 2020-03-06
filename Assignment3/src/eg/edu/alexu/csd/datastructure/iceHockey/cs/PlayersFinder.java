package eg.edu.alexu.csd.datastructure.iceHockey.cs;

import java.awt.Point;

public class PlayersFinder implements IPlayersFinder {
	
	char[][] photochars;
	char teamchar;
	int chaincount=0;
	int avgx,avgy,totalpoints=0,minx,miny,maxx,maxy;

	@Override
	public Point[] findPlayers(String[] photo, int team, int threshold) {
		if(photo==null||photo.length==0) {
			return null;
		}
		Point[] points=new Point[100];
		teamchar=(char)(team+48);
		photochars=new char[photo.length][photo[0].length()];
		for(int i=0;i<photo.length;i++) {
			for(int j=0;j<photo[0].length();j++) {
				photochars[i][j]=photo[i].charAt(j);
			}
		}
		
		for(int i=0;i<photo.length;i++) {
			for(int j=0;j<photo[0].length();j++) {
				chaincount=0;
				check(i,j,photochars,teamchar);
				if(4*chaincount>=threshold) {
					avgx=(minx+maxx);
					avgy=(miny+maxy);
					points[totalpoints]=new Point (avgx+1,avgy+1);
					totalpoints++;
				}
			}
		}
		Point[] ans=new Point[totalpoints];
		for(int i=0;i<totalpoints;i++) {
			ans[i]=points[i];
		}
		
		for(int i=0;i<totalpoints;i++) {
			for(int j=i;j<totalpoints;j++) {
				if(ans[i].x>ans[j].x) {
					Point temp=new Point(ans[i].x,ans[i].y);
					ans[i]=ans[j];
					ans[j]=temp;
					
				}
				else if ((ans[i].x==ans[j].x)&&ans[i].y>ans[j].y) {
					Point temp=new Point(ans[i].x,ans[i].y);
					ans[i]=ans[j];
					ans[j]=temp;
				}
			}
		}
		
		
		totalpoints=0;
		return ans;
	}
	
	public int check(int i,int j,char[][] e,char teamchar) {
		if(e[i][j]==teamchar) {
			if(chaincount==0) {
				minx=j;
				miny=i;
				maxx=j;
				maxy=i;
			}
			else {
				if(minx>j)
					minx=j;
				else if(maxx<j)
					maxx=j;
				if(miny>i)
					miny=i;
				else if(maxy<i)
					maxy=i;
			}
			chaincount++;
			
			e[i][j]='0';
		
		if(j+1<photochars[0].length)
		check(i,j+1,e,teamchar);
		if(j-1>=0)
		check(i,j-1,e,teamchar);
		if(i+1<photochars.length)
		check(i+1,j,e,teamchar);
		if(i-1>=0)
		check(i-1,j,e,teamchar);
		}
		return chaincount;
	}
	
	
	
}
