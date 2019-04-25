package Struct;

import java.text.DecimalFormat;

public class Player
{
	private String number;
	private String name;
	private String position;
	
	private int TotalAttack;
	private int SuccessAttack;
	private int MistakeAttack;
	
	private int TotalDefence;
	private int SuccessDefence;
	private int MistakeDefence;
	
	private int TotalServe;
	private int SuccessServe;
	private int MistakeServe;
	
	private int TotalBlock;
	private int SuccessBlock;
	private int MistakeBlock;
	private int TouchBlock;
	
	private int TotalSet;
	private int SuccessSet;
	private int MistakeSet;
	
	public Player()
	{
		number = "";
		name = "";
		position = "";
		
		TotalAttack = 0;
		SuccessAttack = 0;
		MistakeAttack = 0;
		
		TotalBlock = 0;
		SuccessBlock = 0;
		MistakeBlock = 0;
		TouchBlock = 0;
		
		TotalDefence = 0;
		SuccessDefence = 0;
		MistakeDefence = 0;
		
		TotalServe = 0;
		SuccessServe = 0;
		MistakeServe = 0;
		
		TotalSet = 0;
		SuccessSet = 0;
		MistakeSet = 0;
	}
	
	
	public String GetNumber()
	{
		return number;
	}
	public String GetName()
	{
		return  name;
	}
	public String GetPosition()
	{
		return position;
	}
	
	public void SetNumber(String x)
	{
//		Log.w("set number",x);
		number = x;
	}
	public void SetName(String x)
	{
		name = x;
	}
	public void SetPosition(String x)
	{
		position = x;
	}
	
	public void SuccessAttack()
	{
		TotalAttack++;
		SuccessAttack++;
	}
	public void MistakeAttack()
	{
		TotalAttack++;
		MistakeAttack++;
	}
	public void InvalidAttack()
	{
		TotalAttack++;
	}
	
	public void SuccessDefence()
	{
		TotalDefence++;
		SuccessDefence++;
	}
	public void MistakeDefence()
	{
		TotalDefence++;
		MistakeDefence++;
	}
	public void InvalidDefence()
	{
		TotalDefence++;
	}
	
	public void SuccessServe()
	{
		TotalServe++;
		SuccessServe++;
	}
	public void MistakeServe()
	{
		TotalServe++;
		MistakeServe++;
	}
	public void InvalidServe()
	{
		TotalServe++;
	}
	
	public void SuccessSet()
	{
		TotalSet++;
		SuccessSet++;
	}
	public void MistakeSet()
	{
		TotalSet++;
		MistakeSet++;
	}
	public void InvalidSet()
	{
		TotalSet++;
	}
	
	public void SuccessBlock()
	{
		SuccessBlock++;
		TotalBlock++;
	}
	public void MistakeBlock()
	{
		TotalBlock++;
		MistakeBlock++;
	}
	public void TouchBlock()
	{
		TotalBlock++;
		TouchBlock++;
	}
	public void InvalidBlock()
	{
		TotalBlock++;
	}
	
	public int GetSuccessAttack()
	{
		return SuccessAttack;
	}
	public int GetTotalAttack()
	{
		return TotalAttack;
	}
	public int GetMistakeAttack()
	{
		return MistakeAttack;
	}
	
	public int GetTotalDefence()
	{
		return TotalDefence;
	}
	public int GetSuccessDefence()
	{
		return SuccessDefence;
	}
	public int GetMistakeDefence()
	{
		return MistakeDefence;
	}
	
	public int GetTotalServe()
	{
		return TotalServe;
	}
	public int GetSuccessServe()
	{
		return SuccessServe;
	}
	public int GetMistakeServe()
	{
		return MistakeServe;
	}
	
	public int GetTotalBlock()
	{
		return TotalBlock;
	}
	public int GetSuccessBlock()
	{
		return SuccessBlock;
	}
	public int GetMistakeBlock()
	{
		return MistakeBlock;
	}
	public int GetTouchBlock()
	{
		return TouchBlock;
	}
	
	public int GetTotalSet()
	{
		return TotalSet;
	}
	public int GetSuccessSet()
	{
		return SuccessSet;
	}
	public int GetMistakeSet()
	{
		return MistakeSet;
	}

    public void SetSuccessAttack(int x)
    {
        SuccessAttack = x;
    }
    public void SetMistakeAttack(int x)
    {
        MistakeAttack = x;
    }
    public void SetAllAttack(int x)
    {
        TotalAttack = x;
    }
    public void SetSuccessDefence(int x)
    {
        SuccessDefence = x;
    }
    public void SetMistakeDefence(int x)
    {
        MistakeDefence = x;
    }
    public void SetAllDefence(int x)
    {
        TotalDefence = x;
    }
    public void SetSuccessBlock(int x)
    {
        SuccessBlock = x;
    }
    public void SetMistakeBlock(int x)
    {
        MistakeBlock = x;
    }
    public void SetAllBlock(int x)
    {
        TotalBlock = x;
    }
    public void SetTouchBlock(int x)
    {
        TouchBlock = x;
    }
    public void SetSuccessServe(int x)
    {
        SuccessServe = x;
    }
    public void SetMistakeServe(int x)
    {
        MistakeServe = x;
    }
    public void SetAllServe(int x)
    {
        TotalServe = x;
    }
    public void SetSuccessSet(int x)
    {
        SuccessSet = x;
    }
    public void SetMistakeSet(int x)
    {
        MistakeSet = x;
    }
    public void SetAllSet(int x)
    {
        TotalSet = x;
    }

	public String GetAttack()
	{
		float tmp;
        DecimalFormat df = new DecimalFormat("#.##");

        if(TotalAttack == 0)
		{
            String s = df.format(TotalAttack);
			return s;
		}
		else 
		{
			tmp = (float) SuccessAttack/TotalAttack;
            String s = df.format(tmp);
			return s;
		}
		
	}
	public String GetServe()
	{
		float tmp;
        DecimalFormat df = new DecimalFormat("#.##");
		
		if(TotalServe == 0)
		{
            String s = df.format(TotalServe);
			return s;
		}
		else
		{
			tmp = (float) SuccessServe/TotalServe;
            String s = df.format(tmp);
            return s;
		}
		
	}
	public String GetDefence()
	{
		float tmp;
        DecimalFormat df = new DecimalFormat("#.##");
		
		if(TotalDefence == 0)
		{
            String s = df.format(TotalDefence);
			return s;
		}
		else
		{
			tmp = (float) SuccessDefence/TotalDefence;
            String s = df.format(tmp);
            return s;
		}
	}
	public String GetBlock()
	{
		float tmp;
        DecimalFormat df = new DecimalFormat("#.##");
		
		if(TotalBlock == 0)
		{
            String s = df.format(TotalBlock);
            return s;
		}
		else
		{
			tmp = (float) SuccessBlock/TotalBlock;
            String s = df.format(tmp);
            return s;
		}
	}
	public String GetSet()
	{
		float tmp;
        DecimalFormat df = new DecimalFormat("#.##");
		
		if(TotalSet == 0)
		{
            String s = df.format(TotalSet);
            return s;
		}
		else
		{
			tmp = (float) SuccessSet/TotalSet;
            String s = df.format(tmp);
            return s;
		}
	}

}