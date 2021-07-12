package me.igormgs.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;

import org.bukkit.entity.Player;

import me.igormgs.Main;

public class MySQLManager {
	
	  private static MySQL db;
	  public Main plugin;
	  
	  public MySQLManager(Main plugin2) {
		  this.plugin = plugin2;
	  }
	  
	  public void setupSQL()
	    throws SQLException{
	      db = new MySQL(this.plugin, 
	        Main.plugin.getConfig().getString("mysql.host-name"), 
	        Main.plugin.getConfig().getString("mysql.porta"), 
	        Main.plugin.getConfig().getString("mysql.database"), 
	        Main.plugin.getConfig().getString("mysql.usuario"), 
	        Main.plugin.getConfig().getString("mysql.senha"));
	      db.openConnection();
	      Statement statement = db.getConnection().createStatement();
	      statement.executeUpdate("CREATE TABLE IF NOT EXISTS `dados_lobby` (`uuid` varchar(255), `username` varchar(255), `senha` varchar(255), `rank` int(2), `xp` int(16), `coins` int(16), `verificado` TEXT, `staffchat` int(16), `tell` int(16))");
	      statement.executeUpdate("CREATE TABLE IF NOT EXISTS `inf_extr_sv` (`status_chat` INT, `nick` varchar(255), `uuid` varchar(255), `status_tabela` TEXT, `dia` int(2), `mes` TEXT, `ano` int(4), `hora` int(2), `minutos` int(2))");
	      statement.executeUpdate("CREATE TABLE IF NOT EXISTS `loginsfirst` (`uuid` varchar(255), `username` varchar(255), `dia` int(2), `dia_da_semana` TEXT, `mes` TEXT, `ano` int(4), `hora` int(2), `minutos` int(2))");
	      statement.executeUpdate("CREATE TABLE IF NOT EXISTS `lastlogin` (`uuid` varchar(255), `username` varchar(255), `dia` int(2), `dia_da_semana` TEXT, `mes` TEXT, `ano` int(4), `hora` int(2), `minutos` int(2))");
	      statement.executeUpdate("CREATE TABLE IF NOT EXISTS `dados_punicoes` (`uuid` varchar(255), `username` varchar(255), `stats_ban` int(2), `motivo` varchar(255), `responsavel` varchar(255))");
	      plugin.database = true;
	    }
	  
	  public void closeDB() {
	    db.closeConnection();
	  }
	  
	  public static void firstJoinPlayer(Player p) throws SQLException {
	    if (!db.checkConnection()) {
	      db.openConnection();
	    }
	    Statement s = db.getConnection().createStatement();
	    
	    ResultSet rs = s.executeQuery("SELECT * FROM dados_lobby WHERE `uuid`='" + p.getUniqueId() + "';");
	    if (rs.next()) {
	      return;
	    }
	    s.executeUpdate("INSERT INTO dados_lobby (`uuid`, `username`, `senha`, `rank`, `xp`, `coins`, `verificado`, `staffchat`, `tell`) VALUES ('" + p.getUniqueId() + "', '" + p.getName() + "', 'Senha Não registrada', '" + 0 + "', '" + 0 + "', '" + 0 + "', 'NAO', '" + 0 + "', '" + 0 + "');");
	    s.executeUpdate("INSERT INTO dados_punicoes (`uuid`, `username`, `stats_ban`) VALUES ('" + p.getUniqueId() + "', '" + p.getName() + "', '" + 0 + "', 'NENHUM', 'NENHUM');");
	    s.executeUpdate("INSERT INTO loginsfirst (`uuid`, `username`, `dia`, `dia_da_semana`, `mes`, `ano`, `hora`, `minutos`) VALUES ('" + p.getUniqueId() + "', '" + p.getName() + "', '"+ Main.getDia() + "', '" + Main.getDiaDaSemana() + "', '" + Main.getMeses() + "', '" + Main.getAno() + "', '" + Main.getHora() + "', '" + Main.getMinutos() +"');");
	    s.executeUpdate("INSERT INTO lastlogin (`uuid`, `username`, `dia`, `dia_da_semana`, `mes`, `ano`, `hora`, `minutos`) VALUES ('" + p.getUniqueId() + "', '" + p.getName() + "', '"+ Main.getDia() + "', '" + Main.getDiaDaSemana() + "', '" + Main.getMeses() + "', '" + Main.getAno() + "', '" + Main.getHora() + "', '" + Main.getMinutos() +"');");
	    Main.plugin.getLogger().log(Level.INFO,  "Os dados do jogador "+ p.getName() + "(" + p.getUniqueId() + ") foram inseridos com sucesso no banco de dados.");
	  }
	  
	  public static void startingwithData() throws SQLException {
		    if (!db.checkConnection()) {
		      db.openConnection();
		    }
		    Statement s = db.getConnection().createStatement();
		    
		    ResultSet rs = s.executeQuery("SELECT * FROM inf_extr_sv WHERE `status_tabela`='CRIADA';");
		    if (rs.next()) {
		      return;
		    }
		    s.executeUpdate("INSERT INTO inf_extr_sv (`status_chat`, `nick`, `uuid`, `status_tabela`, `dia`, `mes`, `ano`, `hora`, `minutos`) VALUES ('" + 0 +"', 'NENHUM', 'NENHUM', 'CRIADA', '" + Main.getDia() + "', '" + Main.getMeses() +  "', '" + Main.getAno() + "', '" + Main.getHora() + "', '" + Main.getMinutos() + "');");
		    Main.plugin.getLogger().log(Level.INFO,  "Os dados do servidor foram inseridos com sucesso no banco de dados.");
		  }
	  
	  public static int getMute(Player p) throws SQLException {
			String name = p.getUniqueId().toString();
			 if (!db.checkConnection()) {
			   db.openConnection();
			 }
			 Statement s = db.getConnection().createStatement();
			 ResultSet rs = s.executeQuery("SELECT * FROM dados_punicoes WHERE `uuid`='" + name + "';");
			 if (!rs.next()) {
			   return 0;
			 }
			 int retorno = rs.getInt("stats_mute");
			    
			 return retorno;
		  }
	  
	  public static int getStatusChat() throws SQLException {
			 if (!db.checkConnection()) {
			   db.openConnection();
			 }
			 Statement s = db.getConnection().createStatement();
			    ResultSet rs = s.executeQuery("SELECT * FROM inf_extr_sv WHERE `status_tabela`='CRIADA';");
			 if (!rs.next()) {
			   return 0;
			 }
			 int retorno = rs.getInt("status_chat");
			    
			 return retorno;
		  }
	  
	  public static int getStatusTell(Player p) throws SQLException {
			 if (!db.checkConnection()) {
			   db.openConnection();
			 }
			 Statement s = db.getConnection().createStatement();
			    ResultSet rs = s.executeQuery("SELECT * FROM dados_lobby WHERE `uuid`='" + p.getUniqueId().toString() + "';");
			 if (!rs.next()) {
			   return 0;
			 }
			 int retorno = rs.getInt("tell");
			    
			 return retorno;
		  }
	  
	  public static String getPrimeiroLogin(Player p) throws SQLException {
			 if (!db.checkConnection()) {
			   db.openConnection();
			 }
			 Statement s = db.getConnection().createStatement();
			 ResultSet rs = s.executeQuery("SELECT * FROM loginsfirst WHERE `uuid`='" + p.getUniqueId() + "';");
			 if (!rs.next()) {
			   return "ERROR";
			 }
			 String retorno = rs.getString("dia");
			 
			 String retorno2 = rs.getString("mes");
			 
			 String retorno3 = rs.getString("ano");
			    
			 String retorno4 = rs.getString("hora");
			 
			 String retorno5 = rs.getString("minutos");
			 
			 return retorno + " de " + retorno2 + " de " + retorno3 + " ás " + retorno4 + ":" + retorno5;
		  }
	  
	  public static void updateChat(int status, Player p) throws SQLException {
		if (!db.checkConnection()) {
		  db.openConnection();
		}
	    Statement s = db.getConnection().createStatement();
		s.executeUpdate("UPDATE inf_extr_sv SET `status_chat`='" + status + "';");
		s.executeUpdate("UPDATE inf_extr_sv SET `nick`='" + p.getName()  + "';");
		s.executeUpdate("UPDATE inf_extr_sv SET `uuid`='" + p.getUniqueId().toString() + "';");
		s.executeUpdate("UPDATE inf_extr_sv SET `dia`='" + Main.getDia() + "';");
		s.executeUpdate("UPDATE inf_extr_sv SET `mes`='" + Main.getMeses() + "';");
		s.executeUpdate("UPDATE inf_extr_sv SET `ano`='" + Main.getAno() + "';");
		s.executeUpdate("UPDATE inf_extr_sv SET `hora`='" + Main.getHora() + "';");
		s.executeUpdate("UPDATE inf_extr_sv SET `minutos`='" + Main.getMinutos() + "';");
	  }
	  
	  public static void updateMinutos(Player p) throws SQLException {
		String name = p.getUniqueId().toString();
		if (!db.checkConnection()) {
		  db.openConnection();
		}
	    Statement s = db.getConnection().createStatement();
		s.executeUpdate("UPDATE lastlogin SET `minutos`='" + Main.getMinutos() + "' WHERE `uuid`='" + name + "';");
	  }
	  
	  public static void updateHoras(Player p) throws SQLException {
		String name = p.getUniqueId().toString();
		if (!db.checkConnection()) {
		  db.openConnection();
		}
	    Statement s = db.getConnection().createStatement();
		s.executeUpdate("UPDATE lastlogin SET `hora`='" + Main.getHora() + "' WHERE `uuid`='" + name + "';");
	  }
	  
	  public static void updateAno(Player p) throws SQLException {
	    String name = p.getUniqueId().toString();
		if (!db.checkConnection()) {
		  db.openConnection();
		}
	    Statement s = db.getConnection().createStatement();
		s.executeUpdate("UPDATE lastlogin SET `ano`='" + Main.getAno() + "' WHERE `uuid`='" + name + "';");
	  }
	  
	  public static void updateMes(Player p) throws SQLException {
		String name = p.getUniqueId().toString();
		if (!db.checkConnection()) {
		  db.openConnection();
		}
	    Statement s = db.getConnection().createStatement();
		s.executeUpdate("UPDATE lastlogin SET `mes`='" + Main.getMeses() + "' WHERE `uuid`='" + name + "';");
	  }
	  
	  public static void updateTell(Player p, int status) throws SQLException {
		String name = p.getUniqueId().toString();
		if (!db.checkConnection()) {
		  db.openConnection();
		}
	    Statement s = db.getConnection().createStatement();
		s.executeUpdate("UPDATE dados_lobby SET `tell`='" + status + "' WHERE `uuid`='" + name + "';");
	  }
	  
	  public static void updateDiaDaSemana(Player p) throws SQLException {
		String name = p.getUniqueId().toString();
		if (!db.checkConnection()) {
		  db.openConnection();
		}
	    Statement s = db.getConnection().createStatement();
		s.executeUpdate("UPDATE lastlogin SET `dia_da_semana`='" + Main.getDiaDaSemana() + "' WHERE `uuid`='" + name + "';");
	  }
	  
	  public static void updateDia(Player p) throws SQLException {
		String name = p.getUniqueId().toString();
		if (!db.checkConnection()) {
		  db.openConnection();
		}
	    Statement s = db.getConnection().createStatement();
		s.executeUpdate("UPDATE lastlogin SET `dia`='" + Main.getDia() + "' WHERE `uuid`='" + name + "';");
	  }
	  
	  public static int getCoins(Player p) throws SQLException {
		String name = p.getUniqueId().toString();
		 if (!db.checkConnection()) {
		   db.openConnection();
		 }
		 Statement s = db.getConnection().createStatement();
		 ResultSet rs = s.executeQuery("SELECT * FROM dados_lobby WHERE `uuid`='" + name + "';");
		 if (!rs.next()) {
		   return 0;
		 }
		 int retorno = rs.getInt("coins");
		    
		 return retorno;
	  }
	  
	  public static int getXp(Player p) throws SQLException {
		String name = p.getUniqueId().toString();
		 if (!db.checkConnection()) {
		   db.openConnection();
		 }
		 Statement s = db.getConnection().createStatement();
		 ResultSet rs = s.executeQuery("SELECT * FROM dados_lobby WHERE `uuid`='" + name + "';");
		 if (!rs.next()) {
		   return 0;
		 }
		 int retorno = rs.getInt("xp");
		    
		 return retorno;
	  }
	  
	  public static String getVerify(Player p) throws SQLException {
		String name = p.getUniqueId().toString();
		 if (!db.checkConnection()) {
		   db.openConnection();
		 }
		 Statement s = db.getConnection().createStatement();
		 ResultSet rs = s.executeQuery("SELECT * FROM dados_lobby WHERE `uuid`='" + name + "';");
		 if (!rs.next()) {
		   return "NAO";
		 }
		 String retorno = rs.getString("verificado");
		    
		 return retorno;
	  }
	  
	  public static void updateVerify(Player p) throws SQLException {
		String name = p.getUniqueId().toString();
		if (!db.checkConnection()) {
		  db.openConnection();
		}
	    Statement s = db.getConnection().createStatement();
		s.executeUpdate("UPDATE dados_lobby SET `verificado`='SIM' WHERE `uuid`='" + name + "';");
	  }
	  
	  public static int getStatusStaffChat(Player p) throws SQLException {
		  String uuid = p.getUniqueId().toString();
			 if (!db.checkConnection()) {
			   db.openConnection();
			 }
			 Statement s = db.getConnection().createStatement();
			    ResultSet rs = s.executeQuery("SELECT * FROM dados_lobby WHERE `uuid`='" + uuid + "';");
			 if (!rs.next()) {
			   return 0;
			 }
			 int retorno = rs.getInt("staffchat");
			    
			 return retorno;
		  }
	  
	  public static int getRank(Player p) throws SQLException {
		String name = p.getUniqueId().toString();
		 if (!db.checkConnection()) {
		   db.openConnection();
		 }
		 Statement s = db.getConnection().createStatement();
		 ResultSet rs = s.executeQuery("SELECT * FROM dados_lobby WHERE `uuid`='" + name + "';");
		 if (!rs.next()) {
		   return 0;
		 }
		 int retorno = rs.getInt("rank");
		    
		 return retorno;
	  }
	  
	  public static void updateRank(Player p, String rank) throws SQLException {
		String name = p.getUniqueId().toString();
		if (!db.checkConnection()) {
		  db.openConnection();
		}
	    Statement s = db.getConnection().createStatement();
		s.executeUpdate("UPDATE dados_lobby SET `rank`='" + rank + "' WHERE `uuid`='" + name + "';");
	  }
	  
}