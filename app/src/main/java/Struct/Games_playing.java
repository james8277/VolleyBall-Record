package Struct;

public class Games_playing
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
	
	private int Lnumber;
	private int RedChange;
	private int BlueChange;
	
	private int change;
	private int previousScore;
	
	private int subNumber;

	private int BlueSet;
	private int RedSet;
	
	public Games_playing()
	{
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
		
		Lnumber = 0;
		BlueChange = 0;
		RedChange = 0;
		
		Year = "";
		Month = "";
		Day = "";
		
		previousScore = 1;
		subNumber = 0;

		BlueSet = 0;
		RedSet = 0;
	}
	
	public void SetBlueName(String x)
	{
		BlueName = x;
	}
	public void SetRedName(String x)
	{
		RedName = x;
	}
	public void SetHome(String x)
	{
		HomeName = x;
	}
	public void SetAway(String x)
	{
		AwayName = x;
	}
	
	public void BlueScore()
	{
		BlueScore++;
	}
    public void BlueScoreMinus()
    {
        BlueScore--;
    }
	public void RedScore()
	{
		RedScore++;
	}
    public void RedScoreMinus()
    {
        RedScore--;
    }

    public void SetBlueScore(int x)
    {
        BlueScore = x;
    }
    public void SetRedScore(int x)
    {
        RedScore = x;
    }
	
	public String GetHomeName()
	{
		return HomeName;
	}
	public String GetAwayName()
	{
		return AwayName;
	}
	public String GetBlueName()
	{
		return BlueName;
	}
	public String GetRedName()
	{
		return RedName;
	}
	
	public int GetBlueScore()
	{
		return BlueScore;
	}
	public int GetRedScore()
	{
		return RedScore;
	}
	
	public int GetOnField(int x)
	{
		return OnField[x];
	}
	public int GetSub(int x)
	{
		return Sub[x];
	}
	
	public void Change()
	{
		change++;
	}
	public int GetChange()
	{
		return change;
	}

	public int GetBlueSet()
	{
		return BlueSet;
	}
	public int GetRedSet()
	{
		return RedSet;
	}
	
	public void Changeplayer(int x, int y)
	{
		int tmp;
		
		tmp = OnField[x];
		OnField[x] = Sub[y];
		Sub[y] = tmp;
	}
	public void LchangePlayer(int x, int y)
	{
		int tmp;
		
		tmp = OnField[x];
		OnField[x] = L[y];
		L[y] = tmp;
	}
	
	public int GetL(int x)
	{
		return L[x];
	}
	
	public void RedChange()
	{
		RedChange++;
	}
	public void BlueChange()
	{
		BlueChange++;
	}
	public void SetDay(String x)
	{
		Day = x;
	}
	public void SetMonth(String y)
	{
		Month = y;
	}
	public void SetYear(String z)
	{
		Year = z;
	}

	public void SetBlueSet()
	{
		BlueSet++;
	}
	public void SetRedSet()
	{
		RedSet++;
	}

	public void SetFormat(String f)
	{
		if(f.equals("Best of 1") || f.equals("一局決勝"))
		{
			Format = 1;
		}
		if(f.equals("Best of 3") || f.equals("三戰兩勝"))
		{
			Format = 3;
		}
		if(f.equals("Best of 5") || f.equals("五戰三勝"))
		{
			Format = 5;
		}
		/*int tmp = this.GetFormat();
		String tmp_string = Integer.toString(tmp);
		Log.w("Format_game_playing", tmp_string);*/

	}
	public void SetFormat_int(int i)
	{
			Format = i;
	}
	public int GetBlueChange()
	{
		return BlueChange;
	}
	public int GetRedChange()
	{
		return RedChange;
	}
	public String GetYear()
	{
		return Year;
	}
	public String GetMonth()
	{
		return Month;
	}
	public String GetDay()
	{
		return Day;
	}
	public int GetFormat(){

		//Log.w("Format_Get_Format", Integer.toString(Format));
		return Format;
	}
	public void SetLnumber()
	{
		Lnumber++;
	}
	public int GetLnumber()
	{
		return Lnumber;
	}
	
	public int GetPrevious()
	{
		return previousScore;
	}
	public void SetPrevious(int x)
	{
		previousScore = x;
	}
	
	public void SetSubNumber()
	{
		subNumber++;
	}
	public int GetSubNumber()
	{
		return subNumber;
	}

    public void SetSubNumber_Data(int x)
    {
        subNumber = x;
    }
    public void SetLNumber_Data(int x)
    {
        Lnumber = x;
    }
}
