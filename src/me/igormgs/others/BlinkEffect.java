package me.igormgs.others;

public class BlinkEffect {
	
	private int i = 1;
	private String 	texto = "§f§lSTTEY";
	public BlinkEffect(){
		
	}
	
	public void next(){
		if (i == 1){
			texto = "§f§lS§b§lTTEY";
		}
		if (i == 2){
			texto = "§b§lS§f§lT§b§lTEY";
		}
		if (i == 3){
			texto = "§b§lST§f§lT§b§lEY";
		}
		if (i == 4){
			texto = "§b§lSTT§f§lE§b§lY";
		}
		if (i == 5){
			texto = "§b§lSTTE§f§lY";
		}
		if (i == 6){
			texto = "§b§lSTTEY";
		}
		if (i == 7){
			texto = "§f§lSTTEY";
		}
		if (i == 8){
			texto = "§b§lSTTEY";
		}
		if (i == 9){
			texto = "§f§lSTTEY";
			i = 0;
		}
		i++;
	}
	public String getText(){
		return texto;
	}

}
