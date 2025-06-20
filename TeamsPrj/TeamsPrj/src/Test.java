import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

class TeamBase implements BasketballTeam, VolleyBallTeam{
	protected String name;
	private int playersCount;
	private double[] heights;
	
	public TeamBase() {
		name = "";	
		playersCount = 0;
	}
	
	public TeamBase(String n, int cnt, double[] h) {
		name = n;
		playersCount = cnt;
		heights = h;
	}
	
	public double avHeight() {
		double combinedHeights = 0;
		
		for(int i = 0; i < heights.length; i++) {
			combinedHeights+=heights[i];
		}
		
		return (combinedHeights / playersCount);
	}
	
	public double maxHeight() {
		if(heights.length == 0) return 0;
		double max = heights[0];
		for(int i = 1; i < heights.length; i++) {
			if(heights[i] > max) max = heights[i];
		}
		return max;
	}
	
	public int getPlayersCount() {
		return playersCount;
	}

	@Override
	public String getVolleyBallTeamName() {
		return "Volleyball team: " + "\"" + name +" V.C\"";
	}

	@Override
	public String getBasketballTeamName() {
		return "Basketball team: " + "\"" + name +" B.C\"";
	}
	
}

class Team extends TeamBase{
	private char kind;
	
	public Team() {
		super();
	}
	
	public Team(char k, String name, int cnt, double[]h) {
		super(name,cnt,h);
		kind = k;
	}
	
	public Team getData(String lineRead) {
		String[] data = lineRead.split(",");
		char kind = data[0].charAt(0);
		String name = data[1];
		int playersCount = Integer.parseInt(data[2]);
		
		double[]heights = new double[playersCount];
		int i = 0;
		for(int j = 3; j < data.length; j++) {
			heights[i] = Double.parseDouble(data[j]);
			i++;
		}
		
		return new Team(kind, name, playersCount, heights);
	}
	
	@Override
	public String toString() {
		String name;
		
		if(kind == 'B' || kind == 'b') name = this.getBasketballTeamName();
		else if(kind == 'V' || kind == 'v') name= this.getVolleyBallTeamName();
		else return "Unknown kind.";
		
		return String.format("%s, Players:%d, average height: %.2f, maximal height: %.2f", name, getPlayersCount(), avHeight(), maxHeight());
	}
}

interface BasketballTeam {
	public String getBasketballTeamName();
}

interface VolleyBallTeam {
	public String getVolleyBallTeamName();
}

class cmp {
	public int compare(TeamBase o1, TeamBase o2) {
		
		if(o1.avHeight() < o2.avHeight()) return 1;
		if(o1.avHeight() > o2.avHeight()) return -1;
		
		return 0;
	}
}

//MAIN CLASS
public class Test {
	public static Scanner inp;
	public static void main(String[] args) {
		File f = new File("data.txt");
		try {
			inp = new Scanner(f);
		} catch (Exception e) {
			System.out.println("File not found");
			return;
		}
		
		ArrayList<Team>teams = new ArrayList<>();
		
		while(inp.hasNextLine()) {
			String line = inp.nextLine();
			Team t = new Team();
			t = t.getData(line);
			teams.add(t);
		}
		
		for(Team t : teams) {
			System.out.println(t.toString());
		}
	}
}




