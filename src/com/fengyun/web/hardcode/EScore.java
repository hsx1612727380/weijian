package com.fengyun.web.hardcode;

public enum EScore {

	BigExcellent(5,5),
	Excellent(2,4),
	Normal(0,3),
	Bad(-2,2),
	BigBad(-5,1),
	;
	
	public int score;
	public int desc;
	
	private EScore(final int score,int desc){
		this.score = score;
		this.desc = desc;
	}
	
	public static int getNameByScore(int score){
		if(score > 5)
			score = 5;
		else if(score < -5)
			score = -5;
		for(EScore e : EScore.values()){
			if(e.score == score)
				return e.desc;
		}
		return 0;
	}
}
