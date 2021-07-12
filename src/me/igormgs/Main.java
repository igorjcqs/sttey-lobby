package me.igormgs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import me.igormgs.db.EndDB;
import me.igormgs.db.MySQLManager;
import me.igormgs.others.ActionBar_BlinkEffect;
import me.igormgs.others.BlinkEffect;
import me.igormgs.others.ScoreRun;

public class Main extends JavaPlugin {
	
	public static Main instace;
	
	public static ScoreRun scrun = new ScoreRun();
	public static BlinkEffect bk = new BlinkEffect();
	public static ActionBar_BlinkEffect acbk = new ActionBar_BlinkEffect();
	
	public static ArrayList<Player> voando = new ArrayList<Player>();
	
	public static ArrayList<Player> usandoAngelicais = new ArrayList<Player>();
	
	public static ArrayList<Player> TheFlash = new ArrayList<Player>();
	
	public static ArrayList<Player> usandoDemoniacas = new ArrayList<Player>();
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static List<String> automsg = new ArrayList();
	
	private static UtilParticleType upt;
	
	public static Plugin plugin;
	
	  public static UtilParticleType getParticles(){
		    return upt;
		  }
	  
	  public static String getMeses() {
		Calendar cal = Calendar.getInstance();
		  if(cal.get(Calendar.MONTH) == 0) {
			  return "JANEIRO";
		  }
		  
		  if(cal.get(Calendar.MONTH) == 1) {
			  return "FEVEREIRO";
		  }
		  
		  if(cal.get(Calendar.MONTH) == 2) {
			  return "JANEIRO";
		  }
		  
		  if(cal.get(Calendar.MONTH) == 3) {
			  return "MARÇO";
		  }
		  
		  if(cal.get(Calendar.MONTH) == 4) {
			  return "ABRIL";
		  }
		  
		  if(cal.get(Calendar.MONTH) == 5) {
			  return "MAIO";
		  }
		  
		  if(cal.get(Calendar.MONTH) == 6) {
			  return "JUNHO";
		  }
		  
		  if(cal.get(Calendar.MONTH) == 7) {
			  return "JULHO";
		  }
		  
		  if(cal.get(Calendar.MONTH) == 8) {
			  return "AGOSTO";
		  }
		  
		  if(cal.get(Calendar.MONTH) == 9) {
			  return "SETEMBRO";
		  }
		  
		  if(cal.get(Calendar.MONTH) == 10) {
			  return "OUTUBRO";
		  }
		  
		  if(cal.get(Calendar.MONTH) == 11) {
			  return "NOVEMBRO";
		  }
		  
		  if(cal.get(Calendar.MONTH) == 12) {
			  return "DEZEMBRO";
		  }
		return "NENHUM";
	  }
	  
	  public static int getDia() {
		  Calendar cal = Calendar.getInstance();
		  return cal.get(Calendar.DATE);
	  }
	  
	  
	  public static int getAno() {
		  Calendar cal = Calendar.getInstance();
		  return cal.get(Calendar.YEAR);
	  }
	  
	  public static String getDiaDaSemana() {
		  Calendar cal = Calendar.getInstance();
		  if(cal.get(Calendar.DAY_OF_WEEK) == 1) {
			  return "DOMINGO";
		  }
		  
		  if(cal.get(Calendar.DAY_OF_WEEK) == 2) {
			  return "SEGUNDA-FEIRA";
		  }
		  
		  if(cal.get(Calendar.DAY_OF_WEEK) == 3) {
			  return "TERÇA-FEIRA";
		  }
		  
		  if(cal.get(Calendar.DAY_OF_WEEK) == 4) {
			  return "QUARTA-FEIRA";
		  }
		  
		  if(cal.get(Calendar.DAY_OF_WEEK) == 5) {
			  return "QUINTA-FEIRA";
		  }
		  
		  if(cal.get(Calendar.DAY_OF_WEEK) == 6) {
			  return "SEXTA-FEIRA";
		  }
		  
		  if(cal.get(Calendar.DAY_OF_WEEK) == 7) {
			  return "SÁBADO";
		  }
		  return "NENHUM";
	  }
	  
	  public static int getHora() {
		  Calendar cal = Calendar.getInstance();
		  return cal.get(Calendar.HOUR_OF_DAY);
	  }
	  
	  public static String getMinutos() {
		  Calendar cal = Calendar.getInstance();
		  if(cal.get(Calendar.MINUTE) == 1) {
			  return "0" + cal.get(Calendar.MINUTE);
		  }
		  
		  if(cal.get(Calendar.MINUTE) == 2) {
			  return "0" + cal.get(Calendar.MINUTE);
		  }
		  
		  if(cal.get(Calendar.MINUTE) == 3) {
			  return "0" + cal.get(Calendar.MINUTE);
		  }
		  
		  if(cal.get(Calendar.MINUTE) == 4) {
			  return "0" + cal.get(Calendar.MINUTE);
		  }
		  
		  if(cal.get(Calendar.MINUTE) == 5) {
			  return "0" + cal.get(Calendar.MINUTE);
		  }
		  
		  if(cal.get(Calendar.MINUTE) == 6) {
			  return "0" + cal.get(Calendar.MINUTE);
		  }
		  
		  if(cal.get(Calendar.MINUTE) == 7) {
			  return "0" + cal.get(Calendar.MINUTE);
		  }
		  
		  if(cal.get(Calendar.MINUTE) == 8) {
			  return "0" + cal.get(Calendar.MINUTE);
		  }
		  
		  if(cal.get(Calendar.MINUTE) == 9) {
			  return "0" + cal.get(Calendar.MINUTE);
		  }
		  return "" + cal.get(Calendar.MINUTE);
	  }
	  
	  public static String verificarTag(Player p) {
		  try {
			if(MySQLManager.getRank(p) == 0) {
				return "§7§lMEMBRO";
			}
			if(MySQLManager.getRank(p) == 1) {
				return "§a§lVIP";
			}
			if(MySQLManager.getRank(p) == 2) {
				return "§e§lVIP+";
			}
			if(MySQLManager.getRank(p) == 3) {
				return "§6§lPRO";
			}
			if(MySQLManager.getRank(p) == 4) {
				return "§d§lULTRA";
			}
			if(MySQLManager.getRank(p) == 5) {
				return "§1§lBETA";
			}
			if(MySQLManager.getRank(p) == 6) {
				return "§3§lSTTEY";
			}
			if(MySQLManager.getRank(p) == 7) {
				return "§b§lYOUTUBER";
			}
			if(MySQLManager.getRank(p) == 8) {
				return "§3§lYOUTUBER+";
			}
			if(MySQLManager.getRank(p) == 9) {
				return "§2§lHELPER";
			}
			if(MySQLManager.getRank(p) == 10) {
				return "§d§lBUILDER";
			}
			if(MySQLManager.getRank(p) == 11) {
				return "§d§lTRIAL";
			}
			if(MySQLManager.getRank(p) == 12) {
				return "§5§lMOD";
			}
			if(MySQLManager.getRank(p) == 13) {
				return "§c§lADM";
			}
			if(MySQLManager.getRank(p) == 14) {
				return "§4§lCEO";
			}
			if(MySQLManager.getRank(p) == 15) {
				return "§4§lCTI";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "MEMBRO";
	  }
	  
	  public static ReentrantLock lock = new ReentrantLock(true);
		public static String SQL_HOST = null;
		public static String SQL_PORT = null;
		public static String SQL_USER = null;
		public static String SQL_PASS = null;
		public static String SQL_DATA = null;
		public static Boolean SQL_DSC = Boolean.valueOf(false);
		private static Connection con;
		public MySQLManager mysql = new MySQLManager(this);
		public boolean database = false;
		  
		  public void onLoad() {
			  plugin = this;
			  saveDefaultConfig();
			  automsg = getConfig().getStringList("AutoMsg:");
			  try {
				mysql.setupSQL();
			} catch (Exception e) {
				e.printStackTrace();
			}
		  }
	  
	  public static synchronized void SQLconnect(){
		    try{
		      plugin.getLogger().info("Conectando ao MySQL...");
		      Class.forName("com.mysql.jdbc.Driver").newInstance();
		      String conn = "jdbc:mysql://" + SQL_HOST + ":" + SQL_PORT + "/" + 
		        SQL_DATA;
		      con = DriverManager.getConnection(conn, SQL_USER, SQL_PASS);
		    }
		    catch (ClassNotFoundException ex){
		      plugin.getLogger().warning("MySQL Driver nao encontrado!");
		    }
		    catch (SQLException ex){
		      plugin.getLogger().warning("Erro ao tentar conectar ao Mysql!");
		    }
		    catch (Exception ex){
		      plugin.getLogger().warning("Erro desconhecido enquanto tentava conectar ao MySQL.");
		    }
		  }
		  
		  public static void SQLdisconnect(){
		    EndDB end = new EndDB(plugin, Main.plugin.getLogger(), con);
		    ExecutorService executor = Executors.newCachedThreadPool();
		    executor.execute(end);
		    executor.shutdown();
		  }
		  
		  public static CapturarPing ping = new CapturarPing("localhost", 25582);
	
	@SuppressWarnings("deprecation")
	public void onEnable() {
		
		instace = this;
		
		System.out.print("STTEYMC - LOBBY SCRIPT CARREGADO!");
		
		carregarEventos();
		
		upt = new UtilParticleType();
		
		getCommand("voar").setExecutor(new Comandos());
		getCommand("fly").setExecutor(new Comandos());
		getCommand("tag").setExecutor(new Comandos());
		getCommand("chat").setExecutor(new Comandos());
		getCommand("gm").setExecutor(new Comandos());
		getCommand("gamemode").setExecutor(new Comandos());
		getCommand("tp").setExecutor(new Comandos());
		getCommand("tpall").setExecutor(new Comandos());
		getCommand("tell").setExecutor(new Comandos());
		getCommand("bleh").setExecutor(new Comandos());
		
		Bukkit.getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
		
		try {
			MySQLManager.startingwithData();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		scrun.run();
		
		automsg = getConfig().getStringList("Mensagens");
		
		Bukkit.getScheduler().scheduleAsyncRepeatingTask(instace, new Runnable() {
			
			@Override
			public void run() {
				Random msg = new Random();
		        int r = msg.nextInt(Main.automsg.size());
		        Bukkit.broadcastMessage(((String)Main.automsg.get(r)).replaceAll("&", "§"));
			}
		}, 1400L, 1400L);
		
	}
	
	void carregarEventos() {
		Bukkit.getServer().getPluginManager().registerEvents(new Eventos(), this);
	}
	
	public void onDisable() {
		
		System.out.print("STTEYMC - LOBBY SCRIPT DESABILITADO!");
		
	    if (this.database) {
	        mysql.closeDB();
	    }
	}

}