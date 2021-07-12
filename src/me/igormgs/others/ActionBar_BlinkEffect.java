package me.igormgs.others;

public class ActionBar_BlinkEffect {
	
	private int i = 1;
	private String 	texto = "§f§lSTTEYMC";
	public ActionBar_BlinkEffect(){
		
	}
	
	public void next(){
		if (i == 1){
			texto = "§e§nw§f§fww.stteymc.com";
		}
		if (i == 2){
			texto = "§f§fw§e§nw§f§fw.stteymc.com";
		}
		
		if (i == 3){
			texto = "§f§fww§e§nw§f§f.stteymc.com";
		}
		
		if (i == 4){
			texto = "§f§fwww§e§n.§f§fstteymc.com";
		}
		
		if (i == 5){
			texto = "§f§fwww.§e§ns§f§ftteymc.com";
		}
		
		if (i == 6){
			texto = "§f§fwww.s§e§nt§f§fteymc.com";
		}
		
		if (i == 7){
			texto = "§f§fwww.st§e§nt§f§feymc.com";
		}
		
		if (i == 8){
			texto = "§f§fwww.stt§e§ne§f§fymc.com";
		}
		
		if (i == 9){
			texto = "§f§fwww.stte§e§ny§f§fmc.com";
		}
		
		if (i == 10){
			texto = "§f§fwww.sttey§e§nm§f§fc.com";
		}
		
		if (i == 11){
			texto = "§f§fwww.stteym§e§nc§f§f.com";
		}
		
		if (i == 12){
			texto = "§f§fwww.stteymc§e§n.§f§fcom";
		}
		
		if (i == 13){
			texto = "§f§fwww.stteymc.§e§nc§f§fom";
		}
		
		if (i == 14){
			texto = "§f§fwww.stteymc.c§e§no§f§fm";
		}
		
		if (i == 15){
			texto = "§f§fwww.stteymc.co§e§nm";
		}
		
		if (i == 16){
			texto = "§e§nwww.stteymc.com";
		}
		
		if (i == 17){
			texto = "§f§nwww.stteymc.com";
		}
		
		if (i == 18){
			texto = "§e§nwww.stteymc.com";
		}
		
		if (i == 19){
			texto = "§f§nwww.stteymc.com";
			i = 0;
		}
		i++;
	}
	public String getText(){
		return texto;
	}

}
