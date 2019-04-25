package Struct;

public class GameData
{
	private String HomeName;
	private String AwayName;
	private String BlueName;
	private String RedName;
	
	private int BlueScore;
	private int RedScore;
	
	private int[] OnField;
	private int[] Sub;
	private int[] L;
	
	private String Year;
	private String Month;
	private String Day;

	private int Format;
	
	private int LCount;
	private int RedChange;
	private int BlueChange;
	
	private int change;
	private int previousScore;
	
	private int subCount;

	private int BlueSet;
	private int RedSet;
	
	public GameData() {
		HomeName = "";
		AwayName = "";
		BlueName = "Home";
		RedName = "Away";
		
		OnField = new int[]{0,1,2,3,4,5};
		Sub = new int[]{6,7,8,9,10,11};
		L = new int[]{12,13};
		
		change = 0;
		
		BlueScore = 0;
		RedScore = 0;

		LCount = 0;
		BlueChange = 0;
		RedChange = 0;
		
		Year = "";
		Month = "";
		Day = "";
		
		previousScore = 1;
		subCount = 0;

		BlueSet = 0;
		RedSet = 0;
	}
	
	public void setBlueName(String x) {
		BlueName = x;
	}
	public void setRedName(String x) {
		RedName = x;
	}
	public void setHome(String x) {
		HomeName = x;
	}
	public void setAway(String x) {
		AwayName = x;
	}
	
	public void BlueScore() {
		BlueScore++;
	}
    public void BlueScoreMinus() {
        BlueScore--;
    }
	public void RedScore() {
		RedScore++;
	}
    public void RedScoreMinus() {
        RedScore--;
    }

    public void setBlueScore(int x) {
        BlueScore = x;
    }
    public void setRedScore(int x) {
        RedScore = x;
    }
	
	public String getHomeName() {
		return HomeName;
	}
	public String getAwayName() {
		return AwayName;
	}
	public String getBlueName() {
		return BlueName;
	}
	public String getRedName() {
		return RedName;
	}
	
	public int getBlueScore() {
		return BlueScore;
	}
	public int getRedScore() {
		return RedScore;
	}
	
	public int getOnField(int x) {
		return OnField[x];
	}
	public int getSub(int x) {
		return Sub[x];
	}
	
	public void change() {
		change++;
	}
	public int getChange() {
		return change;
	}

	public int getBlueSet() {
		return BlueSet;
	}
	public int getRedSet() {
		return RedSet;
	}
	
	public void changePlayer(int x, int y) {
		int tmp;
		
		tmp = OnField[x];
		OnField[x] = Sub[y];
		Sub[y] = tmp;
	}
	public void changeLPlayer(int x, int y) {
		int tmp;
		
		tmp = OnField[x];
		OnField[x] = L[y];
		L[y] = tmp;
	}
	
	public int getL(int x) {
		return L[x];
	}
	
	public void RedChange() {
		RedChange++;
	}
	public void BlueChange() {
		BlueChange++;
	}
	public void setDay(String x) {
		Day = x;
	}
	public void setMonth(String y) {
		Month = y;
	}
	public void setYear(String z) {
		Year = z;
	}

	public void setBlueSet() {
		BlueSet++;
	}
	public void setRedSet() {
		RedSet++;
	}

	public void setFormat(String f) {
		if(f.equals("Best of 1") || f.equals("一局決勝")) {
			Format = 1;
		}
		if(f.equals("Best of 3") || f.equals("三戰兩勝")) {
			Format = 3;
		}
		if(f.equals("Best of 5") || f.equals("五戰三勝")) {
			Format = 5;
		}
		/*int tmp = this.GetFormat();
		String tmp_string = Integer.toString(tmp);
		Log.w("Format_game_playing", tmp_string);*/
	}
	public void setFormat_int(int i) {
			Format = i;
	}
	public int getBlueChange() {
		return BlueChange;
	}
	public int getRedChange() {
		return RedChange;
	}
	public String getYear() {
		return Year;
	}
	public String getMonth() {
		return Month;
	}
	public String getDay() {
		return Day;
	}
	public int getFormat(){
		return Format;
	}
	public int getLCount() {
		return LCount;
	}
	
	public int getPrevious() {
		return previousScore;
	}
	public void setPrevious(int x) {
		previousScore = x;
	}
	
	public void setSubCount() {
		subCount++;
	}
	public void setLCount() {
		LCount++;
	}
	public int getSubCount() {
		return subCount;
	}
    public void setSubCount_Data(int x) {
		subCount = x;
    }
    public void setLCount_Data(int x) {
		LCount = x;
    }
}
