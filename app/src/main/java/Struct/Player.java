package Struct;

import java.text.DecimalFormat;

public class Player {
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
	
	public Player() {
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
	
	
	public String getNumber() {
		return number;
	}
	public String getName() {
		return  name;
	}
	public String getPosition() {
		return position;
	}
	
	public void setNumber(String x) {
		number = x;
	}
	public void setName(String x) {
		name = x;
	}
	public void setPosition(String x) {
		position = x;
	}
	
	public void attackSuccess() {
		TotalAttack++;
		SuccessAttack++;
	}
	public void attackFail() {
		TotalAttack++;
		MistakeAttack++;
	}
	public void attackInvalid() {
		TotalAttack++;
	}
	
	public void SuccessDefence() {
		TotalDefence++;
		SuccessDefence++;
	}
	public void defenceFail() {
		TotalDefence++;
		MistakeDefence++;
	}
	public void defenceInvalid() {
		TotalDefence++;
	}
	
	public void serveSuccess() {
		TotalServe++;
		SuccessServe++;
	}
	public void serveFail() {
		TotalServe++;
		MistakeServe++;
	}
	public void serveInvalid() {
		TotalServe++;
	}
	
	public void setSuccess() {
		TotalSet++;
		SuccessSet++;
	}
	public void setFail() {
		TotalSet++;
		MistakeSet++;
	}
	public void setInvalid() {
		TotalSet++;
	}
	
	public void blockSuccess() {
		SuccessBlock++;
		TotalBlock++;
	}
	public void blockFail() {
		TotalBlock++;
		MistakeBlock++;
	}
	public void blockTouch() {
		TotalBlock++;
		TouchBlock++;
	}
	public void blockInvalid() {
		TotalBlock++;
	}
	
	public int getSuccessAttack() {
		return SuccessAttack;
	}
	public int getTotalAttack() {
		return TotalAttack;
	}
	public int getMistakeAttack() {
		return MistakeAttack;
	}
	
	public int getTotalDefence() {
		return TotalDefence;
	}
	public int getSuccessDefence() {
		return SuccessDefence;
	}
	public int getMistakeDefence() {
		return MistakeDefence;
	}
	
	public int getTotalServe() {
		return TotalServe;
	}
	public int getSuccessServe() {
		return SuccessServe;
	}
	public int getMistakeServe() {
		return MistakeServe;
	}
	
	public int getTotalBlock() {
		return TotalBlock;
	}
	public int getSuccessBlock() {
		return SuccessBlock;
	}
	public int getMistakeBlock() {
		return MistakeBlock;
	}
	public int getTouchBlock() {
		return TouchBlock;
	}
	
	public int getTotalSet() {
		return TotalSet;
	}
	public int getSuccessSet() {
		return SuccessSet;
	}
	public int getMistakeSet() {
		return MistakeSet;
	}

    public void setSuccessAttack(int x) {
        SuccessAttack = x;
    }
    public void setMistakeAttack(int x) {
        MistakeAttack = x;
    }
    public void setAllAttack(int x) {
        TotalAttack = x;
    }
    public void setSuccessDefence(int x) {
        SuccessDefence = x;
    }
    public void setMistakeDefence(int x) {
        MistakeDefence = x;
    }
    public void setAllDefence(int x) {
        TotalDefence = x;
    }
    public void setSuccessBlock(int x) {
        SuccessBlock = x;
    }
    public void setMistakeBlock(int x) {
        MistakeBlock = x;
    }
    public void setAllBlock(int x) {
        TotalBlock = x;
    }
    public void setTouchBlock(int x) {
        TouchBlock = x;
    }
    public void setSuccessServe(int x) {
        SuccessServe = x;
    }
    public void setMistakeServe(int x) {
        MistakeServe = x;
    }
    public void setAllServe(int x) {
        TotalServe = x;
    }
    public void setSuccessSet(int x) {
        SuccessSet = x;
    }
    public void setMistakeSet(int x) {
        MistakeSet = x;
    }
    public void setAllSet(int x) {
        TotalSet = x;
    }


	private DecimalFormat df = new DecimalFormat("#.##");
	public String getAttack() {
        if(TotalAttack == 0) {
			return df.format(TotalAttack);
		}
		else {
			return df.format((float)SuccessAttack/TotalAttack);
		}
	}
	public String getServe() {
		if(TotalServe == 0) {
			return df.format(TotalServe);
		}
		else {
            return df.format((float) SuccessServe/TotalServe);
		}
	}

	public String getDefence() {
		if(TotalDefence == 0) {
			return df.format(TotalDefence);
		}
		else {
            return df.format((float) SuccessDefence/TotalDefence);
		}
	}

	public String getBlock() {
		if(TotalBlock == 0) {
            return df.format(TotalBlock);
		}
		else {
            return df.format((float) SuccessBlock/TotalBlock);
		}
	}

	public String getSet() {
		if(TotalSet == 0) {
            return df.format(TotalSet);
		}
		else {
            return df.format((float) SuccessSet/TotalSet);
		}
	}

}