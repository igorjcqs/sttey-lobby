package me.igormgs.others;

import java.sql.SQLException;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import me.igormgs.Framework;
import me.igormgs.Main;
import me.igormgs.db.MySQLManager;

public class ScoreRun {
	
    public ScoreRun(){
		
	}
	
	public void run(){
		new BukkitRunnable() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void run() {
				Main.bk.next();
				Main.acbk.next();
				for (Player p : Bukkit.getOnlinePlayers()){
					update(p.getScoreboard(), p);
					Framework.enviarActionBar(p, Main.acbk.getText());
				}
				
			}
		}.runTaskTimer(Main.instace, 0, 5);
	}
	
	@SuppressWarnings("deprecation")
	public void build(Player p){
		Scoreboard score = Bukkit.getScoreboardManager().getNewScoreboard();
		Objective obj = score.registerNewObjective("score", "dummy");
		obj.setDisplaySlot(DisplaySlot.SIDEBAR);
		obj.setDisplayName("§b§lSTTEY");
		
		//Espaço 02
		FastOfflinePlayer espaco03 = new FastOfflinePlayer("§9");
		obj.getScore(espaco03).setScore(8);
		
		//Linha 05
		FastOfflinePlayer linha05 = new FastOfflinePlayer("§l");
		Team l05 = score.registerNewTeam("linha5");
		l05.setPrefix(" §fRank "); 
		l05.addPlayer(linha05);
		obj.getScore(linha05).setScore(7);
		
		//Linha 04
		FastOfflinePlayer linha04 = new FastOfflinePlayer("§n");
		Team l04 = score.registerNewTeam("linha4");
		l04.setPrefix(" §fXP "); 
		l04.addPlayer(linha04);
		obj.getScore(linha04).setScore(6);
		
		//Linha 03
		FastOfflinePlayer linha03 = new FastOfflinePlayer("§m");
		Team l03 = score.registerNewTeam("linha3");
		l03.setPrefix(" §fⓈCoins "); 
		l03.addPlayer(linha03);
		obj.getScore(linha03).setScore(5);
		
		//Espaço 02
		FastOfflinePlayer espaco02 = new FastOfflinePlayer("§3");
		obj.getScore(espaco02).setScore(4);
		
		//Linha 02
		FastOfflinePlayer linha02 = new FastOfflinePlayer("§2");
		Team l02 = score.registerNewTeam("linha2");
		l02.setPrefix(" §fOnline "); 
		l02.addPlayer(linha02);
		obj.getScore(linha02).setScore(3);
		
		//Espaço 01
		FastOfflinePlayer espaco01 = new FastOfflinePlayer("§1");
		obj.getScore(espaco01).setScore(2);
		
		//Linha 01
		FastOfflinePlayer linha01 = new FastOfflinePlayer("§0");
		Team l01 = score.registerNewTeam("linha1");
		l01.setPrefix("§astteymc.com");
		l01.addPlayer(linha01);
		obj.getScore(linha01).setScore(1);
		
		p.setScoreboard(score);
	}
	
	public void update(final Scoreboard score, Player p) {
		Thread th = new Thread(new Runnable() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void run() {
				Team team01 = score.getTeam("linha2");
				team01.setSuffix("§a" + Bukkit.getOnlinePlayers().length);
				
				Team team02 = score.getTeam("linha3");
				try {
					team02.setSuffix("§e" + MySQLManager.getCoins(p));
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				Team team03 = score.getTeam("linha4");
				try {
					team03.setSuffix("§a" + MySQLManager.getXp(p));
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				Team team04 = score.getTeam("linha5");
				team04.setSuffix("" + Main.verificarTag(p));
				
				Objective obj = score.getObjective("score");
				obj.setDisplayName(Main.bk.getText());
			}
		});
		th.start();
	}

}