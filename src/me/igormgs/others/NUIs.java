package me.igormgs.others;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import me.igormgs.CapturarPing;
import me.igormgs.Framework;
import me.igormgs.Main;
import me.igormgs.db.MySQLManager;

public class NUIs {
	
	public static void opMenuPrincipal(Player p) {
		Inventory i = Bukkit.createInventory(p, 36, "            §8§nMenu Principal");
		
		p.getInventory().clear();
		ItemStack stack = new ItemStack(Material.EXPLOSIVE_MINECART);
		ItemMeta stack2 = stack.getItemMeta();
		List<String> ls = new ArrayList<String>();
		ls.add("§7");
		ls.add("§7Disfrute de todos os nossos");
		ls.add("§7servidores utilizando este item.");
		ls.add(" ");
		ls.add("§a» Clique para interagir.");
		ls.add(" ");
		ls.add("§8Desfrute das opções em nosso menu.");
		stack2.setDisplayName("§7» §a§nMenu Principal§f §7«");
		stack2.setLore(ls);
		stack.setItemMeta(stack2);
		p.getInventory().setItem(4, stack);
		
		ItemStack stack01 = new ItemStack(Material.COMPASS);
		ItemMeta stackm01 = stack01.getItemMeta();
		List<String> ls1 = new ArrayList<String>();
		ls1.add("§7");
		ls1.add(" §7Lista de todos servidores");
		ls1.add(" ");
		ls1.add(" §7Clique com o botão §e§nESQUERDO§f§7 para");
		ls1.add(" §7ver todos os servidores.");
		ls1.add(" ");
		ls1.add(" §7Clique com o botão §e§nDIREITO§f§7 para");
		ls1.add(" §7Se conectar em um servidor de");
		ls1.add(" §cHardcoreGames§7. (§aRECOMENDADO§7).");
		ls1.add(" ");
		ls1.add("§8Navegue entre os servidores.");
		stackm01.setDisplayName("§b§n§lSERVIDORES§f");
		stackm01.setLore(ls1);
		stack01.setItemMeta(stackm01);
		i.setItem(13, stack01);
		
		ItemStack stack02 = new ItemStack(Material.TRIPWIRE_HOOK);
		ItemMeta stackm02 = stack02.getItemMeta();
		List<String> ls02 = new ArrayList<String>();
		ls02.add(" ");
		ls02.add(" §7Clique com o botão §e§nESQUERDO§f§7");
		ls02.add(" §7ou §e§nDIREITO§f§7 para abrir o");
		ls02.add(" §7menu de §aPreferências§7.");
		ls02.add(" ");
		ls02.add("§8Personalize sua experiência em");
		ls02.add("§8nossos servidores.");
		stackm02.setDisplayName("§b§n§lPREFERêNCIAS§f");
		stackm02.setLore(ls02);
		stack02.setItemMeta(stackm02);
		i.setItem(20, stack02);
		
		@SuppressWarnings("deprecation")
		ItemStack stack03 = new ItemStack(Material.getMaterial(349), 1, (short)3);
		ItemMeta stackm03 = stack03.getItemMeta();
		List<String> ls03 = new ArrayList<String>();
		ls03.add(" ");
		ls03.add(" §7Clique com o botão §e§nESQUERDO§f§7");
		ls03.add(" §7ou §e§nDIREITO§f§7 para abrir o");
		ls03.add(" §7menu de §aColecionáveis§7.");
		ls03.add(" ");
		ls03.add(" ");
		ls03.add("§8Personalize sua experiência em");
		ls03.add("§8nossos servidores.");
		stackm03.setDisplayName("§b§n§lCOLECIONáVEIS§f");
		stackm03.setLore(ls03);
		stack03.setItemMeta(stackm03);
		i.setItem(24, stack03);
		
	    ItemStack skullItem = new ItemStack(Material.SKULL_ITEM);
	    skullItem.setDurability((short)3);
	    SkullMeta skullMeta = (SkullMeta)skullItem.getItemMeta();
	    skullMeta.setOwner(p.getName());
	    skullMeta.setDisplayName("§b§n§lPERFIL§f");
		List<String> ls04 = new ArrayList<String>();
		ls04.add(" ");
		ls04.add(" §7Clique com o botão §e§nESQUERDO§f§7");
		ls04.add(" §7ou §e§nDIREITO§f§7 para abrir o seu");
		ls04.add(" §aPerfil§7.");
		ls04.add(" ");
		ls04.add("§8Visualize suas estatisticas, detalhes");
		ls04.add("§8e avanço em nossos servidores.");
		skullMeta.setLore(ls04);
        skullItem.setItemMeta(skullMeta);
		i.setItem(22, skullItem);
		
		p.openInventory(i);
	}
	
	public static void opServidores(Player p) {
		Inventory i = Bukkit.createInventory(p, 36, "             §8§nServidores");
		
		ItemStack stack01 = new ItemStack(Material.ARROW);
		ItemMeta stackm01 = stack01.getItemMeta();
		List<String> ls = new ArrayList<String>();
		ls.add(" ");
		ls.add(" §a» §7Clique para voltar.");
		ls.add(" ");
		ls.add("§8Item de Navegação.");
		stackm01.setDisplayName("§aVoltar");
		stackm01.setLore(ls);
		stack01.setItemMeta(stackm01);
		i.setItem(27, stack01);
		
		ItemStack stack02 = new ItemStack(Material.MUSHROOM_SOUP);
		ItemMeta stackm02 = stack02.getItemMeta();
		List<String> ls02 = new ArrayList<String>();
		ls02.add("§b§m-------------------");
		ls02.add("  §6» §f§lINFORMAÇõES §f§6«");
		ls02.add("§b§m-------------------");
		ls02.add(" ");
		ls02.add("§a▪ §7Status Atual: §a§lONLINE");
		ls02.add(" ");
		ls02.add("§7» §eClique para acessar.");
		ls02.add(" ");
		ls02.add("§8Item de Navegação.");
		stackm02.setDisplayName("§f§lHARDCOREGAMES");
		stackm02.setLore(ls02);
		stack02.setItemMeta(stackm02);
		i.setItem(13, stack02);
		
		ItemStack stack03 = new ItemStack(Material.DIAMOND_SWORD);
		ItemMeta stackm03 = stack03.getItemMeta();
		List<String> ls03 = new ArrayList<String>();
		ls03.add("§b§m-------------------");
		ls03.add("  §6» §f§lINFORMAÇõES §f§6«");
		ls03.add("§b§m-------------------");
		ls03.add(" ");
		ls03.add("§a▪ §7Status Atual: §c§lDESATIVADO");
		ls03.add(" ");
		ls03.add("§8Item de Navegação.");
		stackm03.setDisplayName("§f§lKITPVP");
		stackm03.setLore(ls03);
		stack03.setItemMeta(stackm03);
		i.setItem(15, stack03);
		
		ItemStack stack06 = new ItemStack(Material.DIAMOND_PICKAXE);
		ItemMeta stackm06 = stack06.getItemMeta();
		List<String> ls06 = new ArrayList<String>();
		ls06.add("§b§m-------------------");
		ls06.add("  §6» §f§lINFORMAÇõES §f§6«");
		ls06.add("§b§m-------------------");
		ls06.add(" ");
		ls06.add("§a▪ §7Status Atual: §c§lDESATIVADO");
		ls06.add(" ");
		ls06.add("§8Item de Navegação.");
		stackm06.setDisplayName("§f§lRANK UP");
		stackm06.setLore(ls06);
		stack06.setItemMeta(stackm06);
		i.setItem(23, stack06);
		
		ItemStack stack05 = new ItemStack(Material.TNT);
		ItemMeta stackm05 = stack05.getItemMeta();
		List<String> ls05 = new ArrayList<String>();
		ls05.add("§b§m-------------------");
		ls05.add("  §6» §f§lINFORMAÇõES §f§6«");
		ls05.add("§b§m-------------------");
		ls05.add(" ");
		ls05.add("§a▪ §7Status Atual: §c§lDESATIVADO");
		ls05.add(" ");
		ls05.add("§8Item de Navegação.");
		stackm05.setDisplayName("§f§lFACTIONS");
		stackm05.setLore(ls05);
		stack05.setItemMeta(stackm05);
		i.setItem(21, stack05);
		
		ItemStack stack04 = new ItemStack(Material.GRASS);
		ItemMeta stackm04 = stack04.getItemMeta();
		List<String> ls04 = new ArrayList<String>();
		ls04.add("§b§m-------------------");
		ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
		ls04.add("§b§m-------------------");
		ls04.add(" ");
		ls04.add("§a▪ §7Status Atual: §c§lDESATIVADO");
		ls04.add(" ");
		ls04.add("§8Item de Navegação.");
		stackm04.setDisplayName("§f§lSKYWARS");
		stackm04.setLore(ls04);
		stack04.setItemMeta(stackm04);
		i.setItem(11, stack04);
		
		p.openInventory(i);
	}
	
	@SuppressWarnings("deprecation")
	public static void opPreferencias(Player p) {
		Inventory i = Bukkit.createInventory(p, 36, "            §8§nPreferências");
		
		ItemStack stack01 = new ItemStack(Material.ARROW);
		ItemMeta stackm01 = stack01.getItemMeta();
		List<String> ls = new ArrayList<String>();
		ls.add(" ");
		ls.add(" §a» §7Clique para voltar.");
		ls.add(" ");
		ls.add("§8Item de Navegação.");
		stackm01.setDisplayName("§aVoltar");
		stackm01.setLore(ls);
		stack01.setItemMeta(stackm01);
		i.setItem(27, stack01);
		
		ItemStack stack011 = new ItemStack(Material.getMaterial(160), 1, (short)15);
		ItemMeta stackm011 = stack011.getItemMeta();
		stackm011.setDisplayName("§8Vidro");
		stack011.setItemMeta(stackm011);
		i.setItem(10, stack011);
		
		ItemStack stack0111 = new ItemStack(Material.getMaterial(160), 1, (short)15);
		ItemMeta stackm0111 = stack0111.getItemMeta();
		stackm0111.setDisplayName("§8Vidro");
		stack0111.setItemMeta(stackm0111);
		i.setItem(11, stack0111);
		
		ItemStack stack01111 = new ItemStack(Material.getMaterial(160), 1, (short)15);
		ItemMeta stackm01111 = stack01111.getItemMeta();
		stackm01111.setDisplayName("§8Vidro");
		stack01111.setItemMeta(stackm01111);
		i.setItem(12, stack01111);
		
		ItemStack stack011111 = new ItemStack(Material.PAPER);
		ItemMeta stackm011111 = stack011111.getItemMeta();
		stackm011111.setDisplayName("§aReceber mensagens privadas.");
		List<String> ls04 = new ArrayList<String>();
		ls04.add(" ");
		ls04.add("§7Permitir que jogadores");
		ls04.add("§7enviem mensagens privadas");
		ls04.add("§7para você.");
		ls04.add(" ");
		ls04.add("§8Item de Navegação.");
		stackm011111.setLore(ls04);
		stack011111.setItemMeta(stackm011111);
		i.setItem(13, stack011111);
		
		ItemStack stack0111111 = new ItemStack(Material.getMaterial(160), 1, (short)15);
		ItemMeta stackm0111111 = stack0111111.getItemMeta();
		stackm0111111.setDisplayName("§8Vidro");
		stack0111111.setItemMeta(stackm0111111);
		i.setItem(14, stack0111111);
		
		ItemStack stack01111111 = new ItemStack(Material.getMaterial(160), 1, (short)15);
		ItemMeta stackm01111111 = stack01111111.getItemMeta();
		stackm01111111.setDisplayName("§8Vidro");
		stack01111111.setItemMeta(stackm01111111);
		i.setItem(15, stack01111111);
		
		ItemStack stack011111111 = new ItemStack(Material.getMaterial(160), 1, (short)15);
		ItemMeta stackm011111111 = stack011111111.getItemMeta();
		stackm011111111.setDisplayName("§8Vidro");
		stack011111111.setItemMeta(stackm011111111);
		i.setItem(16, stack011111111);
		
		ItemStack stack0111111111 = new ItemStack(Material.getMaterial(160), 1, (short)15);
		ItemMeta stackm0111111111 = stack0111111111.getItemMeta();
		stackm0111111111.setDisplayName("§8Vidro");
		stack0111111111.setItemMeta(stackm0111111111);
		i.setItem(19, stack0111111111);
		
		ItemStack stack01111111111 = new ItemStack(Material.getMaterial(160), 1, (short)15);
		ItemMeta stackm01111111111 = stack01111111111.getItemMeta();
		stackm01111111111.setDisplayName("§8Vidro");
		stack01111111111.setItemMeta(stackm01111111111);
		i.setItem(20, stack01111111111);
		
		ItemStack stack011111111111 = new ItemStack(Material.getMaterial(160), 1, (short)15);
		ItemMeta stackm011111111111 = stack011111111111.getItemMeta();
		stackm011111111111.setDisplayName("§8Vidro");
		stack011111111111.setItemMeta(stackm011111111111);
		i.setItem(21, stack011111111111);
		
		try {
			if(MySQLManager.getStatusTell(p) == 0) {
				ItemStack stack0111111111111 = new ItemStack(Material.getMaterial(351), 1, (short)10);
				ItemMeta stackm0111111111111 = stack0111111111111.getItemMeta();
				stackm0111111111111.setDisplayName("§7Sobre");
				List<String> ls041 = new ArrayList<String>();
				ls041.add(" ");
				ls041.add(" §7Status §aAtivado");
				ls041.add(" ");
				ls041.add("§8Item de Navegação.");
				stackm0111111111111.setLore(ls041);
				stack0111111111111.setItemMeta(stackm0111111111111);
				i.setItem(22, stack0111111111111);
			} 
			if(MySQLManager.getStatusTell(p) == 1) {
				ItemStack stack0111111111111 = new ItemStack(Material.getMaterial(351), 1, (short)8);
				ItemMeta stackm0111111111111 = stack0111111111111.getItemMeta();
				stackm0111111111111.setDisplayName("§7Sobre");
				List<String> ls041 = new ArrayList<String>();
				ls041.add(" ");
				ls041.add(" §7Status §cDesativado");
				ls041.add(" ");
				ls041.add("§8Item de Navegação.");
				stackm0111111111111.setLore(ls041);
				stack0111111111111.setItemMeta(stackm0111111111111);
				i.setItem(22, stack0111111111111);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ItemStack stack01111111111111 = new ItemStack(Material.getMaterial(160), 1, (short)15);
		ItemMeta stackm01111111111111 = stack01111111111111.getItemMeta();
		stackm01111111111111.setDisplayName("§8Vidro");
		stack01111111111111.setItemMeta(stackm01111111111111);
		i.setItem(23, stack01111111111111);
		
		ItemStack stack011111111111111 = new ItemStack(Material.getMaterial(160), 1, (short)15);
		ItemMeta stackm011111111111111 = stack011111111111111.getItemMeta();
		stackm011111111111111.setDisplayName("§8Vidro");
		stack011111111111111.setItemMeta(stackm011111111111111);
		i.setItem(24, stack011111111111111);
		
		ItemStack stack0111111111111111 = new ItemStack(Material.getMaterial(160), 1, (short)15);
		ItemMeta stackm0111111111111111 = stack0111111111111111.getItemMeta();
		stackm0111111111111111.setDisplayName("§8Vidro");
		stack0111111111111111.setItemMeta(stackm0111111111111111);
		i.setItem(25, stack0111111111111111);
		
		p.openInventory(i);
	}
	
	public static void opEstatisticas(Player p) {
		Inventory i = Bukkit.createInventory(p, 36, "            §8§nEstatísticas");
		
		ItemStack stack01 = new ItemStack(Material.ARROW);
		ItemMeta stackm01 = stack01.getItemMeta();
		List<String> ls = new ArrayList<String>();
		ls.add(" ");
		ls.add(" §a» §7Clique para voltar.");
		ls.add(" ");
		ls.add("§8Item de Navegação.");
		stackm01.setDisplayName("§aVoltar");
		stackm01.setLore(ls);
		stack01.setItemMeta(stackm01);
		i.setItem(27, stack01);
		
		ItemStack stack011 = new ItemStack(Material.DIAMOND_SWORD);
		ItemMeta stackm011 = stack011.getItemMeta();
		List<String> ls1 = new ArrayList<String>();
		ls1.add(" ");
		ls1.add("§f§lHARDCORE GAMES");
		ls1.add(" ");
		ls1.add(" §7Vitorias §a0");
		ls1.add(" §7Abates §a0");
		ls1.add(" §7Mortes §a0");
		ls1.add(" ");
		ls1.add("§8Item de Navegação.");
		stackm011.setDisplayName("§aEstatísticas");
		stackm011.setLore(ls1);
		stack011.setItemMeta(stackm011);
		i.setItem(13, stack011);
		
		p.openInventory(i);
	}
	
	@SuppressWarnings("deprecation")
	public static void opHG(Player p) {
		Inventory i = Bukkit.createInventory(p, 36, "§a§nHardcoreGames");
		
		ItemStack stack01 = new ItemStack(Material.ARROW);
		ItemMeta stackm01 = stack01.getItemMeta();
		List<String> ls = new ArrayList<String>();
		ls.add(" ");
		ls.add(" §a» §7Clique para voltar.");
		ls.add(" ");
		ls.add("§8Item de Navegação.");
		stackm01.setDisplayName("§aVoltar");
		stackm01.setLore(ls);
		stack01.setItemMeta(stackm01);
		i.setItem(27, stack01);
		
		ItemStack stack011 = new ItemStack(Material.MAGMA_CREAM);
		ItemMeta stackm011 = stack011.getItemMeta();
		List<String> ls1 = new ArrayList<String>();
		ls1.add(" ");
		ls1.add(" §7Visite seu perfil e");
		ls1.add(" §7veja suas estatísticas.");
		ls1.add(" ");
		ls1.add("§8Item de Navegação.");
		stackm011.setDisplayName("§aVer estatísticas");
		stackm011.setLore(ls1);
		stack011.setItemMeta(stackm011);
		i.setItem(31, stack011);
		
		ItemStack stack04 = new ItemStack(Material.getMaterial(351), 1, (short)8);
		ItemMeta stackm04 = stack04.getItemMeta();
		List<String> ls04 = new ArrayList<String>();
		ls04.add("§b§m-------------------");
		ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
		ls04.add("§b§m-------------------");
		ls04.add(" ");
		ls04.add(" §a▪ §7Status: §fCarregando...");
		ls04.add(" §a▪ §7Estado: §fCarregando...");
		ls04.add(" §a▪ §7Jogadores: §fCarregando...");
		ls04.add(" ");
		ls04.add("§a» §fClique para conectar");
		ls04.add(" ");
		ls04.add("§8Item de Navegação.");
		stackm04.setDisplayName("§f§lHGA1");
		stackm04.setLore(ls04);
		stack04.setItemMeta(stackm04);
	    i.setItem(12, stack04);
	    
		ItemStack stack041 = new ItemStack(Material.getMaterial(351), 1, (short)8);
		ItemMeta stackm041 = stack041.getItemMeta();
		List<String> ls041 = new ArrayList<String>();
		ls041.add("§b§m-------------------");
		ls041.add("  §6» §f§lINFORMAÇõES §f§6«");
		ls041.add("§b§m-------------------");
		ls041.add(" ");
		ls041.add(" §a▪ §7Status: §fCarregando...");
		ls041.add(" §a▪ §7Estado: §fCarregando...");
		ls041.add(" §a▪ §7Jogadores: §fCarregando...");
		ls041.add(" ");
		ls041.add("§a» §fClique para conectar");
		ls041.add(" ");
		ls041.add("§8Item de Navegação.");
		stackm041.setDisplayName("§f§lHGA2");
		stackm041.setLore(ls041);
		stack041.setItemMeta(stackm041);
	    i.setItem(13, stack041);
	    
		ItemStack stack0411 = new ItemStack(Material.getMaterial(351), 1, (short)8);
		ItemMeta stackm0411 = stack0411.getItemMeta();
		List<String> ls0411 = new ArrayList<String>();
		ls0411.add("§b§m-------------------");
		ls0411.add("  §6» §f§lINFORMAÇõES §f§6«");
		ls0411.add("§b§m-------------------");
		ls0411.add(" ");
		ls0411.add(" §a▪ §7Status: §fCarregando...");
		ls0411.add(" §a▪ §7Estado: §fCarregando...");
		ls0411.add(" §a▪ §7Jogadores: §fCarregando...");
		ls0411.add(" ");
		ls0411.add("§a» §fClique para conectar");
		ls0411.add(" ");
		ls0411.add("§8Item de Navegação.");
		stackm0411.setDisplayName("§f§lHGA3");
		stackm0411.setLore(ls0411);
		stack0411.setItemMeta(stackm0411);
	    i.setItem(14, stack0411);
		
		Bukkit.getScheduler().scheduleAsyncRepeatingTask(Main.instace, new Runnable() {
			public void run() {
				CapturarPing ping = new CapturarPing("localhost", 25582);
				if(ping.pegarMotd().contains("Aguardando")) {
					ItemStack stack04 = new ItemStack(Material.getMaterial(351), 1, (short)10);
					ItemMeta stackm04 = stack04.getItemMeta();
					List<String> ls04 = new ArrayList<String>();
					ls04.add("§b§m-------------------");
					ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
					ls04.add("§b§m-------------------");
					ls04.add(" ");
					ls04.add(" §a▪ §7Status: §a§lONLINE");
					ls04.add(" §a▪ §7Estado: §aAguardando jogadores");
					ls04.add(" §a▪ §7Jogadores: §a§l" + ping.pegarJogadoresOnline() + "/" + ping.pegarJogadoresMaximo());
					ls04.add(" ");
					ls04.add("§a» §fClique para conectar");
					ls04.add(" ");
					ls04.add("§8Item de Navegação.");
					stackm04.setDisplayName("§f§lHGA1");
					stackm04.setLore(ls04);
					stack04.setItemMeta(stackm04);
				    i.setItem(12, stack04);
				} else {
					ItemStack stack04 = new ItemStack(Material.getMaterial(351), 1, (short)8);
					ItemMeta stackm04 = stack04.getItemMeta();
					List<String> ls04 = new ArrayList<String>();
					ls04.add("§b§m-------------------");
					ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
					ls04.add("§b§m-------------------");
					ls04.add(" ");
					ls04.add(" §a▪ §7Status: §fCarregando...");
					ls04.add(" §a▪ §7Estado: §fCarregando...");
					ls04.add(" §a▪ §7Jogadores: §fCarregando...");
					ls04.add(" ");
					ls04.add("§a» §fClique para conectar");
					ls04.add(" ");
					ls04.add("§8Item de Navegação.");
					stackm04.setDisplayName("§f§lHGA1");
					stackm04.setLore(ls04);
					stack04.setItemMeta(stackm04);
				    i.setItem(12, stack04);
				}
				if(ping.pegarMotd().contains("Invencibilidade")) {
					ItemStack stack04 = new ItemStack(Material.getMaterial(351), 1, (short)11);
					ItemMeta stackm04 = stack04.getItemMeta();
					List<String> ls04 = new ArrayList<String>();
					ls04.add("§b§m-------------------");
					ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
					ls04.add("§b§m-------------------");
					ls04.add(" ");
					ls04.add(" §a▪ §7Status: §a§lONLINE");
					ls04.add(" §a▪ §7Estado: §eInvencibilidade");
					ls04.add(" §a▪ §7Jogadores: §a§l" + ping.pegarJogadoresOnline() + "/" + ping.pegarJogadoresMaximo());
					ls04.add(" ");
					ls04.add("§a» §fClique para conectar");
					ls04.add(" ");
					ls04.add("§8Item de Navegação.");
					stackm04.setDisplayName("§f§lHGA1");
					stackm04.setLore(ls04);
					stack04.setItemMeta(stackm04);
				    i.setItem(12, stack04);
				} 
				if(ping.pegarMotd().contains("Andamento")) {
					ItemStack stack04 = new ItemStack(Material.getMaterial(351), 1, (short)1);
					ItemMeta stackm04 = stack04.getItemMeta();
					List<String> ls04 = new ArrayList<String>();
					ls04.add("§b§m-------------------");
					ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
					ls04.add("§b§m-------------------");
					ls04.add(" ");
					ls04.add(" §a▪ §7Status: §a§lONLINE");
					ls04.add(" §a▪ §7Estado: §cAndanmento");
					ls04.add(" §a▪ §7Jogadores: §a§l" + ping.pegarJogadoresOnline() + "/" + ping.pegarJogadoresMaximo());
					ls04.add(" ");
					ls04.add("§a» §fClique para conectar");
					ls04.add(" ");
					ls04.add("§8Item de Navegação.");
					stackm04.setDisplayName("§f§lHGA1");
					stackm04.setLore(ls04);
					stack04.setItemMeta(stackm04);
				    i.setItem(12, stack04);
				}
				if(ping.pegarMotd().contains("Reiniciando")) {
					ItemStack stack04 = new ItemStack(Material.getMaterial(351), 1, (short)8);
					ItemMeta stackm04 = stack04.getItemMeta();
					List<String> ls04 = new ArrayList<String>();
					ls04.add("§b§m-------------------");
					ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
					ls04.add("§b§m-------------------");
					ls04.add(" ");
					ls04.add(" §a▪ §7Status: §a§lONLINE");
					ls04.add(" §a▪ §7Estado: §4Finalizando / Reiniciando");
					ls04.add(" §a▪ §7Jogadores: §a§l" + ping.pegarJogadoresOnline() + "/" + ping.pegarJogadoresMaximo());
					ls04.add(" ");
					ls04.add("§a» §fClique para conectar");
					ls04.add(" ");
					ls04.add("§8Item de Navegação.");
					stackm04.setDisplayName("§f§lHGA1");
					stackm04.setLore(ls04);
					stack04.setItemMeta(stackm04);
				    i.setItem(12, stack04);
				} 
			}
		}, 10L, 10L);
		
		Bukkit.getScheduler().scheduleAsyncRepeatingTask(Main.instace, new Runnable() {
			public void run() {
				CapturarPing ping = new CapturarPing("localhost", 25583);
				if(ping.pegarMotd().contains("Aguardando")) {
					ItemStack stack04 = new ItemStack(Material.getMaterial(351), 1, (short)10);
					ItemMeta stackm04 = stack04.getItemMeta();
					List<String> ls04 = new ArrayList<String>();
					ls04.add("§b§m-------------------");
					ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
					ls04.add("§b§m-------------------");
					ls04.add(" ");
					ls04.add(" §a▪ §7Status: §a§lONLINE");
					ls04.add(" §a▪ §7Estado: §aAguardando jogadores");
					ls04.add(" §a▪ §7Jogadores: §a§l" + ping.pegarJogadoresOnline() + "/" + ping.pegarJogadoresMaximo());
					ls04.add(" ");
					ls04.add("§a» §fClique para conectar");
					ls04.add(" ");
					ls04.add("§8Item de Navegação.");
					stackm04.setDisplayName("§f§lHGA2");
					stackm04.setLore(ls04);
					stack04.setItemMeta(stackm04);
				    i.setItem(13, stack04);
				} else {
					ItemStack stack04 = new ItemStack(Material.getMaterial(351), 1, (short)8);
					ItemMeta stackm04 = stack04.getItemMeta();
					List<String> ls04 = new ArrayList<String>();
					ls04.add("§b§m-------------------");
					ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
					ls04.add("§b§m-------------------");
					ls04.add(" ");
					ls04.add(" §a▪ §7Status: §fCarregando...");
					ls04.add(" §a▪ §7Estado: §fCarregando...");
					ls04.add(" §a▪ §7Jogadores: §fCarregando...");
					ls04.add(" ");
					ls04.add("§a» §fClique para conectar");
					ls04.add(" ");
					ls04.add("§8Item de Navegação.");
					stackm04.setDisplayName("§f§lHGA2");
					stackm04.setLore(ls04);
					stack04.setItemMeta(stackm04);
				    i.setItem(13, stack04);
				}
				if(ping.pegarMotd().contains("Invencibilidade")) {
					ItemStack stack04 = new ItemStack(Material.getMaterial(351), 1, (short)11);
					ItemMeta stackm04 = stack04.getItemMeta();
					List<String> ls04 = new ArrayList<String>();
					ls04.add("§b§m-------------------");
					ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
					ls04.add("§b§m-------------------");
					ls04.add(" ");
					ls04.add(" §a▪ §7Status: §a§lONLINE");
					ls04.add(" §a▪ §7Estado: §eInvencibilidade");
					ls04.add(" §a▪ §7Jogadores: §a§l" + ping.pegarJogadoresOnline() + "/" + ping.pegarJogadoresMaximo());
					ls04.add(" ");
					ls04.add("§a» §fClique para conectar");
					ls04.add(" ");
					ls04.add("§8Item de Navegação.");
					stackm04.setDisplayName("§f§lHGA2");
					stackm04.setLore(ls04);
					stack04.setItemMeta(stackm04);
				    i.setItem(13, stack04);
				} 
				if(ping.pegarMotd().contains("Andamento")) {
					ItemStack stack04 = new ItemStack(Material.getMaterial(351), 1, (short)1);
					ItemMeta stackm04 = stack04.getItemMeta();
					List<String> ls04 = new ArrayList<String>();
					ls04.add("§b§m-------------------");
					ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
					ls04.add("§b§m-------------------");
					ls04.add(" ");
					ls04.add(" §a▪ §7Status: §a§lONLINE");
					ls04.add(" §a▪ §7Estado: §cAndanmento");
					ls04.add(" §a▪ §7Jogadores: §a§l" + ping.pegarJogadoresOnline() + "/" + ping.pegarJogadoresMaximo());
					ls04.add(" ");
					ls04.add("§a» §fClique para conectar");
					ls04.add(" ");
					ls04.add("§8Item de Navegação.");
					stackm04.setDisplayName("§f§lHGA2");
					stackm04.setLore(ls04);
					stack04.setItemMeta(stackm04);
				    i.setItem(13, stack04);
				} 
				if(ping.pegarMotd().contains("Reiniciando")) {
					ItemStack stack04 = new ItemStack(Material.getMaterial(351), 1, (short)8);
					ItemMeta stackm04 = stack04.getItemMeta();
					List<String> ls04 = new ArrayList<String>();
					ls04.add("§b§m-------------------");
					ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
					ls04.add("§b§m-------------------");
					ls04.add(" ");
					ls04.add(" §a▪ §7Status: §a§lONLINE");
					ls04.add(" §a▪ §7Estado: §4Finalizando / Reiniciando");
					ls04.add(" §a▪ §7Jogadores: §a§l" + ping.pegarJogadoresOnline() + "/" + ping.pegarJogadoresMaximo());
					ls04.add(" ");
					ls04.add("§a» §fClique para conectar");
					ls04.add(" ");
					ls04.add("§8Item de Navegação.");
					stackm04.setDisplayName("§f§lHGA2");
					stackm04.setLore(ls04);
					stack04.setItemMeta(stackm04);
				    i.setItem(13, stack04);
				} 
			}
		}, 10L, 10L);
		
		Bukkit.getScheduler().scheduleAsyncRepeatingTask(Main.instace, new Runnable() {
			public void run() {
				CapturarPing ping = new CapturarPing("localhost", 25584);
				if(ping.pegarMotd().contains("Aguardando")) {
					ItemStack stack04 = new ItemStack(Material.getMaterial(351), 1, (short)10);
					ItemMeta stackm04 = stack04.getItemMeta();
					List<String> ls04 = new ArrayList<String>();
					ls04.add("§b§m-------------------");
					ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
					ls04.add("§b§m-------------------");
					ls04.add(" ");
					ls04.add(" §a▪ §7Status: §a§lONLINE");
					ls04.add(" §a▪ §7Estado: §aAguardando jogadores");
					ls04.add(" §a▪ §7Jogadores: §a§l" + ping.pegarJogadoresOnline() + "/" + ping.pegarJogadoresMaximo());
					ls04.add(" ");
					ls04.add("§a» §fClique para conectar");
					ls04.add(" ");
					ls04.add("§8Item de Navegação.");
					stackm04.setDisplayName("§f§lHGA3");
					stackm04.setLore(ls04);
					stack04.setItemMeta(stackm04);
				    i.setItem(14, stack04);
				} else {
					ItemStack stack04 = new ItemStack(Material.getMaterial(351), 1, (short)8);
					ItemMeta stackm04 = stack04.getItemMeta();
					List<String> ls04 = new ArrayList<String>();
					ls04.add("§b§m-------------------");
					ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
					ls04.add("§b§m-------------------");
					ls04.add(" ");
					ls04.add(" §a▪ §7Status: §fCarregando...");
					ls04.add(" §a▪ §7Estado: §fCarregando...");
					ls04.add(" §a▪ §7Jogadores: §fCarregando...");
					ls04.add(" ");
					ls04.add("§a» §fClique para conectar");
					ls04.add(" ");
					ls04.add("§8Item de Navegação.");
					stackm04.setDisplayName("§f§lHGA3");
					stackm04.setLore(ls04);
					stack04.setItemMeta(stackm04);
				    i.setItem(14, stack04);
				}
				if(ping.pegarMotd().contains("Invencibilidade")) {
					ItemStack stack04 = new ItemStack(Material.getMaterial(351), 1, (short)11);
					ItemMeta stackm04 = stack04.getItemMeta();
					List<String> ls04 = new ArrayList<String>();
					ls04.add("§b§m-------------------");
					ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
					ls04.add("§b§m-------------------");
					ls04.add(" ");
					ls04.add(" §a▪ §7Status: §a§lONLINE");
					ls04.add(" §a▪ §7Estado: §eInvencibilidade");
					ls04.add(" §a▪ §7Jogadores: §a§l" + ping.pegarJogadoresOnline() + "/" + ping.pegarJogadoresMaximo());
					ls04.add(" ");
					ls04.add("§a» §fClique para conectar");
					ls04.add(" ");
					ls04.add("§8Item de Navegação.");
					stackm04.setDisplayName("§f§lHGA3");
					stackm04.setLore(ls04);
					stack04.setItemMeta(stackm04);
				    i.setItem(14, stack04);
				} 
				if(ping.pegarMotd().contains("Andamento")) {
					ItemStack stack04 = new ItemStack(Material.getMaterial(351), 1, (short)1);
					ItemMeta stackm04 = stack04.getItemMeta();
					List<String> ls04 = new ArrayList<String>();
					ls04.add("§b§m-------------------");
					ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
					ls04.add("§b§m-------------------");
					ls04.add(" ");
					ls04.add(" §a▪ §7Status: §a§lONLINE");
					ls04.add(" §a▪ §7Estado: §cAndanmento");
					ls04.add(" §a▪ §7Jogadores: §a§l" + ping.pegarJogadoresOnline() + "/" + ping.pegarJogadoresMaximo());
					ls04.add(" ");
					ls04.add("§a» §fClique para conectar");
					ls04.add(" ");
					ls04.add("§8Item de Navegação.");
					stackm04.setDisplayName("§f§lHGA3");
					stackm04.setLore(ls04);
					stack04.setItemMeta(stackm04);
				    i.setItem(14, stack04);
				} 
				if(ping.pegarMotd().contains("Reiniciando")) {
					ItemStack stack04 = new ItemStack(Material.getMaterial(351), 1, (short)8);
					ItemMeta stackm04 = stack04.getItemMeta();
					List<String> ls04 = new ArrayList<String>();
					ls04.add("§b§m-------------------");
					ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
					ls04.add("§b§m-------------------");
					ls04.add(" ");
					ls04.add(" §a▪ §7Status: §a§lONLINE");
					ls04.add(" §a▪ §7Estado: §4Finalizando / Reiniciando");
					ls04.add(" §a▪ §7Jogadores: §a§l" + ping.pegarJogadoresOnline() + "/" + ping.pegarJogadoresMaximo());
					ls04.add(" ");
					ls04.add("§a» §fClique para conectar");
					ls04.add(" ");
					ls04.add("§8Item de Navegação.");
					stackm04.setDisplayName("§f§lHGA3");
					stackm04.setLore(ls04);
					stack04.setItemMeta(stackm04);
				    i.setItem(14, stack04);
				} 
			}
		}, 10L, 10L);
		p.openInventory(i);
	}
	
	@SuppressWarnings("deprecation")
	public static void opPerfil(Player p) {
		Inventory i = Bukkit.createInventory(p, 27, "                 §8§nPerfil");
		
		ItemStack stack01 = new ItemStack(Material.ARROW);
		ItemMeta stackm01 = stack01.getItemMeta();
		List<String> ls = new ArrayList<String>();
		ls.add(" ");
		ls.add(" §a» §7Clique para voltar.");
		ls.add(" ");
		ls.add("§8Item de Navegação.");
		stackm01.setDisplayName("§aVoltar");
		stackm01.setLore(ls);
		stack01.setItemMeta(stackm01);
		i.setItem(18, stack01);
		
		ItemStack stack011 = new ItemStack(Material.getMaterial(160), 1, (short)15);
		ItemMeta stackm011 = stack011.getItemMeta();
		stackm011.setDisplayName("§8Vidro");
		stack011.setItemMeta(stackm011);
		i.setItem(11, stack011);
		
		ItemStack stack0111 = new ItemStack(Material.REDSTONE_COMPARATOR);
		ItemMeta stackm0111 = stack0111.getItemMeta();
		stackm0111.setDisplayName("§aPreferências");
		List<String> ls1111 = new ArrayList<String>();
		ls1111.add(" ");
		ls1111.add(" §a» §7Clique para ver.");
		ls1111.add(" §7suas estatisticas.");
		ls1111.add(" ");
		ls1111.add("§8Item de Navegação.");
		stackm0111.setLore(ls1111);
		stack0111.setItemMeta(stackm0111);
		i.setItem(12, stack0111);
		
		ItemStack stack01111 = new ItemStack(Material.PAPER);
		ItemMeta stackm01111 = stack01111.getItemMeta();
		stackm01111.setDisplayName("§aEstatísticas");
		List<String> ls111 = new ArrayList<String>();
		ls111.add(" ");
		ls111.add(" §a» §7Clique para ver.");
		ls111.add(" §7suas estatísticas.");
		ls111.add(" ");
		ls111.add("§8Item de Navegação.");
		stackm01111.setLore(ls111);
		stack01111.setItemMeta(stackm01111);
		i.setItem(13, stack01111);
		
		ItemStack stack011111 = new ItemStack(Material.STORAGE_MINECART);
		ItemMeta stackm011111 = stack011111.getItemMeta();
		stackm011111.setDisplayName("§aRecompensas");
		List<String> ls11111 = new ArrayList<String>();
		ls11111.add(" ");
		ls11111.add(" §a» §7EM BREVE");
		ls11111.add(" ");
		ls11111.add("§8Item de Navegação.");
		stackm011111.setLore(ls11111);
		stack011111.setItemMeta(stackm011111);
		i.setItem(14, stack011111);
		
		ItemStack stack0111111 = new ItemStack(Material.getMaterial(160), 1, (short)15);
		ItemMeta stackm0111111 = stack0111111.getItemMeta();
		stackm0111111.setDisplayName("§8Vidro");
		stack0111111.setItemMeta(stackm0111111);
		i.setItem(15, stack0111111);
		
		ItemStack stack01111111 = new ItemStack(Material.PAPER);
		ItemMeta stackm01111111 = stack01111111.getItemMeta();
		stackm01111111.setDisplayName("§aEstatísticas");
		List<String> ls111111 = new ArrayList<String>();
		ls111111.add(" ");
		ls111111.add(" §a» §7Clique para ver.");
		ls111111.add(" ");
		ls111111.add("§8Item de Navegação.");
		stackm01111111.setLore(ls111111);
		stack01111111.setItemMeta(stackm01111111);
		i.setItem(13, stack01111111);
		
	    ItemStack skullItem = new ItemStack(Material.SKULL_ITEM);
	    skullItem.setDurability((short)3);
	    SkullMeta skullMeta = (SkullMeta)skullItem.getItemMeta();
	    skullMeta.setOwner(p.getName());
	    skullMeta.setDisplayName("§aInformações Pessoais");
		List<String> ls04 = new ArrayList<String>();
		ls04.add("§fRank " + Main.verificarTag(p));
		try {
			ls04.add("§fXP §a" + MySQLManager.getXp(p));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			ls04.add("§fⓈCoins §a" + MySQLManager.getCoins(p));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			ls04.add("§fPrimeiro login §7" + MySQLManager.getPrimeiroLogin(p));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ls04.add("§fÚltimo login §7.");
		skullMeta.setLore(ls04);
        skullItem.setItemMeta(skullMeta);
		i.setItem(4, skullItem);
		
		p.openInventory(i);
	}
	
	@SuppressWarnings("deprecation")
	public static void opCole(Player p) {
		Inventory i = Bukkit.createInventory(p, 27, "            §8§nColecionáveis");
		
		ItemStack stack01 = new ItemStack(Material.ARROW);
		ItemMeta stackm01 = stack01.getItemMeta();
		List<String> ls = new ArrayList<String>();
		ls.add(" ");
		ls.add(" §a» §7Clique para voltar.");
		ls.add(" ");
		ls.add("§8Item de Navegação.");
		stackm01.setDisplayName("§aVoltar");
		stackm01.setLore(ls);
		stack01.setItemMeta(stackm01);
		i.setItem(18, stack01);
		
		ItemStack stack011 = new ItemStack(Material.getMaterial(160), 1, (short)15);
		ItemMeta stackm011 = stack011.getItemMeta();
		stackm011.setDisplayName("§8Vidro");
		stack011.setItemMeta(stackm011);
		i.setItem(11, stack011);
		
		ItemStack stack0111 = new ItemStack(Material.LEATHER_HELMET);
		ItemMeta stackm0111 = stack0111.getItemMeta();
		stackm0111.setDisplayName("§aCabeças");
		List<String> ls1111 = new ArrayList<String>();
		ls1111.add(" ");
		ls1111.add(" §7Desbloqueados: " + Framework.pegarDesbloqueadosCabecas(p));
		ls1111.add(" ");
		ls1111.add(" §a» §7Clique para ver.");
		ls1111.add(" ");
		ls1111.add("§8Item de Navegação.");
		stackm0111.setLore(ls1111);
		stack0111.setItemMeta(stackm0111);
		i.setItem(10, stack0111);
		
		ItemStack stack0 = new ItemStack(Material.getMaterial(377));
		ItemMeta stackm0 = stack0.getItemMeta();
		stackm0.setDisplayName("§aEfeitos");
		List<String> ls11111 = new ArrayList<String>();
		ls11111.add(" ");
		ls11111.add(" §7Desbloqueados: " + Framework.pegarDesbloqueadosEfeitos(p));
		ls11111.add(" ");
		ls11111.add(" §a» §7Clique para ver.");
		ls11111.add(" ");
		ls11111.add("§8Item de Navegação.");
		stackm0.setLore(ls11111);
		stack0.setItemMeta(stackm0);
		i.setItem(12, stack0);
		
		ItemStack stack011111 = new ItemStack(Material.getMaterial(160), 1, (short)15);
		ItemMeta stackm011111 = stack011111.getItemMeta();
		stackm011111.setDisplayName("§8Vidro");
		stack011111.setItemMeta(stackm011111);
		i.setItem(13, stack011111);
		
		ItemStack stack0111111 = new ItemStack(Material.SADDLE);
		ItemMeta stackm0111111 = stack0111111.getItemMeta();
		stackm0111111.setDisplayName("§aLocomoção");
		List<String> ls111111 = new ArrayList<String>();
		ls111111.add(" ");
		ls111111.add(" §7Desbloqueadas: "  + Framework.pegarDesbloqueadosLocomocao(p));
		ls111111.add(" ");
		ls111111.add(" §a» §7Clique para ver.");
		ls111111.add(" ");
		ls111111.add("§8Item de Navegação.");
		stackm0111111.setLore(ls111111);
		stack0111111.setItemMeta(stackm0111111);
		i.setItem(14, stack0111111);
		
		ItemStack stack01111111 = new ItemStack(Material.getMaterial(160), 1, (short)15);
		ItemMeta stackm01111111 = stack01111111.getItemMeta();
		stackm01111111.setDisplayName("§8Vidro");
		stack01111111.setItemMeta(stackm01111111);
		i.setItem(15, stack01111111);
		
		ItemStack stack011111111 = new ItemStack(Material.BONE);
		ItemMeta stackm011111111 = stack011111111.getItemMeta();
		stackm011111111.setDisplayName("§aPets");
		List<String> ls1111111 = new ArrayList<String>();
		ls1111111.add(" ");
		ls1111111.add(" §eEm Desenvolvimento");
		ls1111111.add(" ");
		ls1111111.add("§8Item de Navegação.");
		stackm011111111.setLore(ls1111111);
		stack011111111.setItemMeta(stackm011111111);
		i.setItem(16, stack011111111);
		
		
		p.openInventory(i);
	}
	
	public static void opCabecas(Player p) {
		Inventory i = Bukkit.createInventory(p, 54, "                 §8§nCabeças");
		
		ItemStack stack01 = new ItemStack(Material.ARROW);
		ItemMeta stackm01 = stack01.getItemMeta();
		List<String> ls = new ArrayList<String>();
		ls.add(" ");
		ls.add(" §a» §7Clique para voltar.");
		ls.add(" ");
		ls.add("§8Item de Navegação.");
		stackm01.setDisplayName("§aVoltar");
		stackm01.setLore(ls);
		stack01.setItemMeta(stackm01);
		i.setItem(48, stack01);
		
		ItemStack stack011 = new ItemStack(Material.BOOK_AND_QUILL);
		ItemMeta stackm011 = stack011.getItemMeta();
		List<String> ls1 = new ArrayList<String>();
		ls1.add(" ");
		ls1.add(" §7Retire a cabeça");
		ls1.add(" §7que você está usando.");
		ls1.add(" ");
		ls1.add("§8Item de Navegação.");
		stackm011.setDisplayName("§aRemover Cabeça");
		stackm011.setLore(ls1);
		stack011.setItemMeta(stackm011);
		i.setItem(49, stack011);
		
		try {
			if(MySQLManager.getRank(p) == 0) {
				@SuppressWarnings("deprecation")
				ItemStack stack01111111 = new ItemStack(Material.getMaterial(351), 1, (short)8);
				ItemMeta stackm01111111 = stack01111111.getItemMeta();
				stackm01111111.setDisplayName("§f§lHOMEM DE FERRO");
				List<String> ls04 = new ArrayList<String>();
				ls04.add("§b§m-------------------");
				ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
				ls04.add("§b§m-------------------");
				ls04.add(" ");
				ls04.add("§fDisponível apartir do rank §a§lVIP§f. ");
				ls04.add("§cVocê não possúi essa cabeça.");
				ls04.add(" ");
				ls04.add("§8Cabeça corativa.");
				stackm01111111.setLore(ls04);
				stack01111111.setItemMeta(stackm01111111);
				i.setItem(10, stack01111111);
			} else {
			    ItemStack skullItem = new ItemStack(Material.SKULL_ITEM);
			    skullItem.setDurability((short)3);
			    SkullMeta skullMeta = (SkullMeta)skullItem.getItemMeta();
			    skullMeta.setOwner("IronMan");
			    skullMeta.setDisplayName("§f§lHOMEM DE FERRO");
				List<String> ls04 = new ArrayList<String>();
				ls04.add("§b§m-------------------");
				ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
				ls04.add("§b§m-------------------");
				ls04.add(" ");
				ls04.add("§fDisponível apartir do rank §a§lVIP§f. ");
				ls04.add("§aVocê possúi essa cabeça.");
				ls04.add(" ");
				ls04.add("§8Cabeça corativa.");
				skullMeta.setLore(ls04);
		        skullItem.setItemMeta(skullMeta);
				i.setItem(10, skullItem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(MySQLManager.getRank(p) == 0) {
				@SuppressWarnings("deprecation")
				ItemStack stack01111111 = new ItemStack(Material.getMaterial(351), 1, (short)8);
				ItemMeta stackm01111111 = stack01111111.getItemMeta();
				stackm01111111.setDisplayName("§f§lHULK");
				List<String> ls04 = new ArrayList<String>();
				ls04.add("§b§m-------------------");
				ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
				ls04.add("§b§m-------------------");
				ls04.add(" ");
				ls04.add("§fDisponível apartir do rank §a§lVIP§f.");
				ls04.add("§cVocê não possúi essa cabeça.");
				ls04.add(" ");
				ls04.add("§8Cabeça corativa.");
				stackm01111111.setLore(ls04);
				stack01111111.setItemMeta(stackm01111111);
				i.setItem(11, stack01111111);
			} else {
			    ItemStack skullItem = new ItemStack(Material.SKULL_ITEM);
			    skullItem.setDurability((short)3);
			    SkullMeta skullMeta = (SkullMeta)skullItem.getItemMeta();
			    skullMeta.setOwner("Hulk");
			    skullMeta.setDisplayName("§f§lHULK");
				List<String> ls04 = new ArrayList<String>();
				ls04.add("§b§m-------------------");
				ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
				ls04.add("§b§m-------------------");
				ls04.add(" ");
				ls04.add("§fDisponível apartir do rank §a§lVIP§f.");
				ls04.add("§aVocê possúi essa cabeça.");
				ls04.add(" ");
				ls04.add("§8Cabeça corativa.");
				skullMeta.setLore(ls04);
		        skullItem.setItemMeta(skullMeta);
				i.setItem(11, skullItem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(MySQLManager.getRank(p) == 0) {
					@SuppressWarnings("deprecation")
					ItemStack stack01111111 = new ItemStack(Material.getMaterial(351), 1, (short)8);
					ItemMeta stackm01111111 = stack01111111.getItemMeta();
					stackm01111111.setDisplayName("§f§lCAPITãO AMERICA");
					List<String> ls04 = new ArrayList<String>();
					ls04.add("§b§m-------------------");
					ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
					ls04.add("§b§m-------------------");
					ls04.add(" ");
					ls04.add("§fDisponível apartir do rank §a§lVIP§f.");
					ls04.add("§cVocê não possúi essa cabeça.");
					ls04.add(" ");
					ls04.add("§8Cabeça corativa.");
					stackm01111111.setLore(ls04);
					stack01111111.setItemMeta(stackm01111111);
					i.setItem(12, stack01111111);
			} else {
			    ItemStack skullItem = new ItemStack(Material.SKULL_ITEM);
			    skullItem.setDurability((short)3);
			    SkullMeta skullMeta = (SkullMeta)skullItem.getItemMeta();
			    skullMeta.setOwner("Avengers");
			    skullMeta.setDisplayName("§f§lCAPITãO AMERICA");
				List<String> ls04 = new ArrayList<String>();
				ls04.add("§b§m-------------------");
				ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
				ls04.add("§b§m-------------------");
				ls04.add(" ");
				ls04.add("§fDisponível apartir do rank §a§lVIP§f.");
				ls04.add("§aVocê possúi essa cabeça.");
				ls04.add(" ");
				ls04.add("§8Cabeça de corativa.");
				skullMeta.setLore(ls04);
		        skullItem.setItemMeta(skullMeta);
				i.setItem(12, skullItem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(MySQLManager.getRank(p) == 0) {
					@SuppressWarnings("deprecation")
					ItemStack stack01111111 = new ItemStack(Material.getMaterial(351), 1, (short)8);
					ItemMeta stackm01111111 = stack01111111.getItemMeta();
					stackm01111111.setDisplayName("§f§lHOMEM ARANHA");
					List<String> ls04 = new ArrayList<String>();
					ls04.add("§b§m-------------------");
					ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
					ls04.add("§b§m-------------------");
					ls04.add(" ");
					ls04.add("§fDisponível apartir do rank §a§lVIP§f.");
					ls04.add("§cVocê não possúi essa cabeça.");
					ls04.add(" ");
					ls04.add("§8Cabeça corativa.");
					stackm01111111.setLore(ls04);
					stack01111111.setItemMeta(stackm01111111);
					i.setItem(13, stack01111111);
			} else {
			    ItemStack skullItem = new ItemStack(Material.SKULL_ITEM);
			    skullItem.setDurability((short)3);
			    SkullMeta skullMeta = (SkullMeta)skullItem.getItemMeta();
			    skullMeta.setOwner("0lder");
			    skullMeta.setDisplayName("§f§lHOMEM ARANHA");
				List<String> ls04 = new ArrayList<String>();
				ls04.add("§b§m-------------------");
				ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
				ls04.add("§b§m-------------------");
				ls04.add(" ");
				ls04.add("§fDisponível apartir do rank §a§lVIP§f.");
				ls04.add("§aVocê possúi essa cabeça.");
				ls04.add(" ");
				ls04.add("§8Cabeça corativa.");
				skullMeta.setLore(ls04);
		        skullItem.setItemMeta(skullMeta);
				i.setItem(13, skullItem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(MySQLManager.getRank(p) == 1) {
					@SuppressWarnings("deprecation")
					ItemStack stack01111111 = new ItemStack(Material.getMaterial(351), 1, (short)8);
					ItemMeta stackm01111111 = stack01111111.getItemMeta();
					stackm01111111.setDisplayName("§f§lBATMAN");
					List<String> ls04 = new ArrayList<String>();
					ls04.add("§b§m-------------------");
					ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
					ls04.add("§b§m-------------------");
					ls04.add(" ");
					ls04.add("§fDisponível apartir do rank §e§lVIP+§f. ");
					ls04.add("§cVocê não possúi essa cabeça.");
					ls04.add(" ");
					ls04.add("§8Cabeça corativa.");
					stackm01111111.setLore(ls04);
					stack01111111.setItemMeta(stackm01111111);
					i.setItem(14, stack01111111);
			} else if(MySQLManager.getRank(p) == 0) {
				@SuppressWarnings("deprecation")
				ItemStack stack01111111 = new ItemStack(Material.getMaterial(351), 1, (short)8);
				ItemMeta stackm01111111 = stack01111111.getItemMeta();
				stackm01111111.setDisplayName("§f§lBATMAN");
				List<String> ls04 = new ArrayList<String>();
				ls04.add("§b§m-------------------");
				ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
				ls04.add("§b§m-------------------");
				ls04.add(" ");
				ls04.add("§fDisponível apartir do rank §e§lVIP+§f.");
				ls04.add("§cVocê não possúi essa cabeça.");
				ls04.add(" ");
				ls04.add("§8Cabeça corativa.");
				stackm01111111.setLore(ls04);
				stack01111111.setItemMeta(stackm01111111);
				i.setItem(14, stack01111111);
			} else {
				        ItemStack skullItem = new ItemStack(Material.SKULL_ITEM);
					    skullItem.setDurability((short)3);
					    SkullMeta skullMeta = (SkullMeta)skullItem.getItemMeta();
					    skullMeta.setOwner("Abalone");
					    skullMeta.setDisplayName("§f§lBATMAN");
						List<String> ls04 = new ArrayList<String>();
						ls04.add("§b§m-------------------");
						ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
						ls04.add("§b§m-------------------");
						ls04.add(" ");
						ls04.add("§fDisponível apartir do rank §e§lVIP+§f.");
						ls04.add("§aVocê possúi essa cabeça.");
						ls04.add(" ");
						ls04.add("§8Cabeça de corativa.");
						skullMeta.setLore(ls04);
				        skullItem.setItemMeta(skullMeta);
						i.setItem(14, skullItem);
					}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(MySQLManager.getRank(p) == 1) {
					@SuppressWarnings("deprecation")
					ItemStack stack01111111 = new ItemStack(Material.getMaterial(351), 1, (short)8);
					ItemMeta stackm01111111 = stack01111111.getItemMeta();
					stackm01111111.setDisplayName("§f§lFLASH");
					List<String> ls04 = new ArrayList<String>();
					ls04.add("§b§m-------------------");
					ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
					ls04.add("§b§m-------------------");
					ls04.add(" ");
					ls04.add("§fDisponível apartir do rank §e§lVIP+§f. ");
					ls04.add("§cVocê não possúi essa cabeça.");
					ls04.add(" ");
					ls04.add("§8Cabeça corativa.");
					stackm01111111.setLore(ls04);
					stack01111111.setItemMeta(stackm01111111);
					i.setItem(15, stack01111111);
			} else if(MySQLManager.getRank(p) == 0) {
				@SuppressWarnings("deprecation")
				ItemStack stack01111111 = new ItemStack(Material.getMaterial(351), 1, (short)8);
				ItemMeta stackm01111111 = stack01111111.getItemMeta();
				stackm01111111.setDisplayName("§f§lFLASH");
				List<String> ls04 = new ArrayList<String>();
				ls04.add("§b§m-------------------");
				ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
				ls04.add("§b§m-------------------");
				ls04.add(" ");
				ls04.add("§fDisponível apartir do rank §e§lVIP+§f.");
				ls04.add("§cVocê não possúi essa cabeça.");
				ls04.add(" ");
				ls04.add("§8Cabeça corativa.");
				stackm01111111.setLore(ls04);
				stack01111111.setItemMeta(stackm01111111);
				i.setItem(15, stack01111111);
			} else {
				        ItemStack skullItem = new ItemStack(Material.SKULL_ITEM);
					    skullItem.setDurability((short)3);
					    SkullMeta skullMeta = (SkullMeta)skullItem.getItemMeta();
					    skullMeta.setOwner("XXl_V2");
					    skullMeta.setDisplayName("§f§lFLASH");
						List<String> ls04 = new ArrayList<String>();
						ls04.add("§b§m-------------------");
						ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
						ls04.add("§b§m-------------------");
						ls04.add(" ");
						ls04.add("§fDisponível apartir do rank §e§lVIP+§f.");
						ls04.add("§aVocê possúi essa cabeça.");
						ls04.add(" ");
						ls04.add("§8Cabeça corativa.");
						skullMeta.setLore(ls04);
				        skullItem.setItemMeta(skullMeta);
						i.setItem(15, skullItem);
					}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(MySQLManager.getRank(p) == 1) {
					@SuppressWarnings("deprecation")
					ItemStack stack01111111 = new ItemStack(Material.getMaterial(351), 1, (short)8);
					ItemMeta stackm01111111 = stack01111111.getItemMeta();
					stackm01111111.setDisplayName("§f§lLANTERNA VERDE");
					List<String> ls04 = new ArrayList<String>();
					ls04.add("§b§m-------------------");
					ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
					ls04.add("§b§m-------------------");
					ls04.add(" ");
					ls04.add("§fDisponível apartir do rank §e§lVIP+§f. ");
					ls04.add("§cVocê não possúi essa cabeça.");
					ls04.add(" ");
					ls04.add("§8Cabeça corativa.");
					stackm01111111.setLore(ls04);
					stack01111111.setItemMeta(stackm01111111);
					i.setItem(16, stack01111111);
			} else if(MySQLManager.getRank(p) == 0) {
				@SuppressWarnings("deprecation")
				ItemStack stack01111111 = new ItemStack(Material.getMaterial(351), 1, (short)8);
				ItemMeta stackm01111111 = stack01111111.getItemMeta();
				stackm01111111.setDisplayName("§f§lLANTERNA VERDE");
				List<String> ls04 = new ArrayList<String>();
				ls04.add("§b§m-------------------");
				ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
				ls04.add("§b§m-------------------");
				ls04.add(" ");
				ls04.add("§fDisponível apartir do rank §e§lVIP+§f.");
				ls04.add("§cVocê não possúi essa cabeça.");
				ls04.add(" ");
				ls04.add("§8Cabeça corativa.");
				stackm01111111.setLore(ls04);
				stack01111111.setItemMeta(stackm01111111);
				i.setItem(16, stack01111111);
			} else {
				        ItemStack skullItem = new ItemStack(Material.SKULL_ITEM);
					    skullItem.setDurability((short)3);
					    SkullMeta skullMeta = (SkullMeta)skullItem.getItemMeta();
					    skullMeta.setOwner("8bitUmpire");
					    skullMeta.setDisplayName("§f§lLANTERNA VERDE");
						List<String> ls04 = new ArrayList<String>();
						ls04.add("§b§m-------------------");
						ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
						ls04.add("§b§m-------------------");
						ls04.add(" ");
						ls04.add("§fDisponível apartir do rank §e§lVIP+§f.");
						ls04.add("§aVocê possúi essa cabeça.");
						ls04.add(" ");
						ls04.add("§8Cabeça corativa.");
						skullMeta.setLore(ls04);
				        skullItem.setItemMeta(skullMeta);
						i.setItem(16, skullItem);
					}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(MySQLManager.getRank(p) == 1) {
					@SuppressWarnings("deprecation")
					ItemStack stack01111111 = new ItemStack(Material.getMaterial(351), 1, (short)8);
					ItemMeta stackm01111111 = stack01111111.getItemMeta();
					stackm01111111.setDisplayName("§f§lSKULL TROOPER (FORTNITE)");
					List<String> ls04 = new ArrayList<String>();
					ls04.add("§b§m-------------------");
					ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
					ls04.add("§b§m-------------------");
					ls04.add(" ");
					ls04.add("§fDisponível apartir do rank §e§lVIP+§f. ");
					ls04.add("§cVocê não possúi essa cabeça.");
					ls04.add(" ");
					ls04.add("§8Cabeça corativa.");
					stackm01111111.setLore(ls04);
					stack01111111.setItemMeta(stackm01111111);
					i.setItem(19, stack01111111);
			} else if(MySQLManager.getRank(p) == 0) {
				@SuppressWarnings("deprecation")
				ItemStack stack01111111 = new ItemStack(Material.getMaterial(351), 1, (short)8);
				ItemMeta stackm01111111 = stack01111111.getItemMeta();
				stackm01111111.setDisplayName("§f§lSKULL TROOPER (FORTNITE)");
				List<String> ls04 = new ArrayList<String>();
				ls04.add("§b§m-------------------");
				ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
				ls04.add("§b§m-------------------");
				ls04.add(" ");
				ls04.add("§fDisponível apartir do rank §e§lVIP+§f.");
				ls04.add("§cVocê não possúi essa cabeça.");
				ls04.add(" ");
				ls04.add("§8Cabeça corativa.");
				stackm01111111.setLore(ls04);
				stack01111111.setItemMeta(stackm01111111);
				i.setItem(19, stack01111111);
			} else {
				        ItemStack skullItem = new ItemStack(Material.SKULL_ITEM);
					    skullItem.setDurability((short)3);
					    SkullMeta skullMeta = (SkullMeta)skullItem.getItemMeta();
					    skullMeta.setOwner("CheddarDucks");
					    skullMeta.setDisplayName("§f§lSKULL TROOPER (FORTNITE)");
						List<String> ls04 = new ArrayList<String>();
						ls04.add("§b§m-------------------");
						ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
						ls04.add("§b§m-------------------");
						ls04.add(" ");
						ls04.add("§fDisponível apartir do rank §e§lVIP+§f.");
						ls04.add("§aVocê possúi essa cabeça.");
						ls04.add(" ");
						ls04.add("§8Cabeça corativa.");
						skullMeta.setLore(ls04);
				        skullItem.setItemMeta(skullMeta);
						i.setItem(19, skullItem);
					}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(MySQLManager.getRank(p) == 1) {
					@SuppressWarnings("deprecation")
					ItemStack stack01111111 = new ItemStack(Material.getMaterial(351), 1, (short)8);
					ItemMeta stackm01111111 = stack01111111.getItemMeta();
					stackm01111111.setDisplayName("§f§lCABEÇA DE TOMATE (FORTNITE)");
					List<String> ls04 = new ArrayList<String>();
					ls04.add("§b§m-------------------");
					ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
					ls04.add("§b§m-------------------");
					ls04.add(" ");
					ls04.add("§fDisponível apartir do rank §6§lPRO§f. ");
					ls04.add("§cVocê não possúi essa cabeça.");
					ls04.add(" ");
					ls04.add("§8Cabeça corativa.");
					stackm01111111.setLore(ls04);
					stack01111111.setItemMeta(stackm01111111);
					i.setItem(20, stack01111111);
			} else if(MySQLManager.getRank(p) == 0) {
				@SuppressWarnings("deprecation")
				ItemStack stack01111111 = new ItemStack(Material.getMaterial(351), 1, (short)8);
				ItemMeta stackm01111111 = stack01111111.getItemMeta();
				stackm01111111.setDisplayName("§f§lCABEÇA DE TOMATE (FORTNITE)");
				List<String> ls04 = new ArrayList<String>();
				ls04.add("§b§m-------------------");
				ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
				ls04.add("§b§m-------------------");
				ls04.add(" ");
				ls04.add("§fDisponível apartir do rank §6§lPRO§f.");
				ls04.add("§cVocê não possúi essa cabeça.");
				ls04.add(" ");
				ls04.add("§8Cabeça corativa.");
				stackm01111111.setLore(ls04);
				stack01111111.setItemMeta(stackm01111111);
				i.setItem(20, stack01111111);
			} else if(MySQLManager.getRank(p) == 2) {
				@SuppressWarnings("deprecation")
				ItemStack stack01111111 = new ItemStack(Material.getMaterial(351), 1, (short)8);
				ItemMeta stackm01111111 = stack01111111.getItemMeta();
				stackm01111111.setDisplayName("§f§lCABEÇA DE TOMATE (FORTNITE)");
				List<String> ls04 = new ArrayList<String>();
				ls04.add("§b§m-------------------");
				ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
				ls04.add("§b§m-------------------");
				ls04.add(" ");
				ls04.add("§fDisponível apartir do rank §6§lPRO§f.");
				ls04.add("§cVocê não possúi essa cabeça.");
				ls04.add(" ");
				ls04.add("§8Cabeça corativa.");
				stackm01111111.setLore(ls04);
				stack01111111.setItemMeta(stackm01111111);
				i.setItem(20, stack01111111);
			} else {
		        ItemStack skullItem = new ItemStack(Material.SKULL_ITEM);
			    skullItem.setDurability((short)3);
			    SkullMeta skullMeta = (SkullMeta)skullItem.getItemMeta();
			    skullMeta.setOwner("11ZayZay11");
			    skullMeta.setDisplayName("§f§lCABEÇA DE TOMATE (FORTNITE)");
				List<String> ls04 = new ArrayList<String>();
				ls04.add("§b§m-------------------");
				ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
				ls04.add("§b§m-------------------");
				ls04.add(" ");
				ls04.add("§fDisponível apartir do rank §6§lPRO§f.");
				ls04.add("§aVocê possúi essa cabeça.");
				ls04.add(" ");
				ls04.add("§8Cabeça corativa.");
				skullMeta.setLore(ls04);
		        skullItem.setItemMeta(skullMeta);
				i.setItem(20, skullItem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(MySQLManager.getRank(p) == 1) {
					@SuppressWarnings("deprecation")
					ItemStack stack01111111 = new ItemStack(Material.getMaterial(351), 1, (short)8);
					ItemMeta stackm01111111 = stack01111111.getItemMeta();
					stackm01111111.setDisplayName("§f§lLÍDER DA EQUIPE DE ABRAÇOS (FORTNITE)");
					List<String> ls04 = new ArrayList<String>();
					ls04.add("§b§m-------------------");
					ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
					ls04.add("§b§m-------------------");
					ls04.add(" ");
					ls04.add("§fDisponível apartir do rank §6§lPRO§f. ");
					ls04.add("§cVocê não possúi essa cabeça.");
					ls04.add(" ");
					ls04.add("§8Cabeça corativa.");
					stackm01111111.setLore(ls04);
					stack01111111.setItemMeta(stackm01111111);
					i.setItem(21, stack01111111);
			} else if(MySQLManager.getRank(p) == 0) {
				@SuppressWarnings("deprecation")
				ItemStack stack01111111 = new ItemStack(Material.getMaterial(351), 1, (short)8);
				ItemMeta stackm01111111 = stack01111111.getItemMeta();
				stackm01111111.setDisplayName("§f§lLÍDER DA EQUIPE DE ABRAÇOS (FORTNITE)");
				List<String> ls04 = new ArrayList<String>();
				ls04.add("§b§m-------------------");
				ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
				ls04.add("§b§m-------------------");
				ls04.add(" ");
				ls04.add("§fDisponível apartir do rank §6§lPRO§f.");
				ls04.add("§cVocê não possúi essa cabeça.");
				ls04.add(" ");
				ls04.add("§8Cabeça corativa.");
				stackm01111111.setLore(ls04);
				stack01111111.setItemMeta(stackm01111111);
				i.setItem(21, stack01111111);
			} else if(MySQLManager.getRank(p) == 2) {
				@SuppressWarnings("deprecation")
				ItemStack stack01111111 = new ItemStack(Material.getMaterial(351), 1, (short)8);
				ItemMeta stackm01111111 = stack01111111.getItemMeta();
				stackm01111111.setDisplayName("§f§lLÍDER DA EQUIPE DE ABRAÇOS (FORTNITE)");
				List<String> ls04 = new ArrayList<String>();
				ls04.add("§b§m-------------------");
				ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
				ls04.add("§b§m-------------------");
				ls04.add(" ");
				ls04.add("§fDisponível apartir do rank §6§lPRO§f.");
				ls04.add("§cVocê não possúi essa cabeça.");
				ls04.add(" ");
				ls04.add("§8Cabeça corativa.");
				stackm01111111.setLore(ls04);
				stack01111111.setItemMeta(stackm01111111);
				i.setItem(21, stack01111111);
			} else {
		        ItemStack skullItem = new ItemStack(Material.SKULL_ITEM);
			    skullItem.setDurability((short)3);
			    SkullMeta skullMeta = (SkullMeta)skullItem.getItemMeta();
			    skullMeta.setOwner("Blacksmyth");
			    skullMeta.setDisplayName("§f§lLÍDER DA EQUIPE DE ABRAÇOS (FORTNITE)");
				List<String> ls04 = new ArrayList<String>();
				ls04.add("§b§m-------------------");
				ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
				ls04.add("§b§m-------------------");
				ls04.add(" ");
				ls04.add("§fDisponível apartir do rank §6§lPRO§f.");
				ls04.add("§aVocê possúi essa cabeça.");
				ls04.add(" ");
				ls04.add("§8Cabeça corativa.");
				skullMeta.setLore(ls04);
		        skullItem.setItemMeta(skullMeta);
				i.setItem(21, skullItem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(MySQLManager.getRank(p) == 1) {
					@SuppressWarnings("deprecation")
					ItemStack stack01111111 = new ItemStack(Material.getMaterial(351), 1, (short)8);
					ItemMeta stackm01111111 = stack01111111.getItemMeta();
					stackm01111111.setDisplayName("§f§lFISHSTICK (FORTNITE)");
					List<String> ls04 = new ArrayList<String>();
					ls04.add("§b§m-------------------");
					ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
					ls04.add("§b§m-------------------");
					ls04.add(" ");
					ls04.add("§fDisponível apartir do rank §6§lPRO§f. ");
					ls04.add("§cVocê não possúi essa cabeça.");
					ls04.add(" ");
					ls04.add("§8Cabeça corativa.");
					stackm01111111.setLore(ls04);
					stack01111111.setItemMeta(stackm01111111);
					i.setItem(22, stack01111111);
			} else if(MySQLManager.getRank(p) == 0) {
				@SuppressWarnings("deprecation")
				ItemStack stack01111111 = new ItemStack(Material.getMaterial(351), 1, (short)8);
				ItemMeta stackm01111111 = stack01111111.getItemMeta();
				stackm01111111.setDisplayName("§f§lFISHSTICK (FORTNITE)");
				List<String> ls04 = new ArrayList<String>();
				ls04.add("§b§m-------------------");
				ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
				ls04.add("§b§m-------------------");
				ls04.add(" ");
				ls04.add("§fDisponível apartir do rank §6§lPRO§f.");
				ls04.add("§cVocê não possúi essa cabeça.");
				ls04.add(" ");
				ls04.add("§8Cabeça corativa.");
				stackm01111111.setLore(ls04);
				stack01111111.setItemMeta(stackm01111111);
				i.setItem(22, stack01111111);
			} else if(MySQLManager.getRank(p) == 2) {
				@SuppressWarnings("deprecation")
				ItemStack stack01111111 = new ItemStack(Material.getMaterial(351), 1, (short)8);
				ItemMeta stackm01111111 = stack01111111.getItemMeta();
				stackm01111111.setDisplayName("§f§lFISHSTICK (FORTNITE)");
				List<String> ls04 = new ArrayList<String>();
				ls04.add("§b§m-------------------");
				ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
				ls04.add("§b§m-------------------");
				ls04.add(" ");
				ls04.add("§fDisponível apartir do rank §6§lPRO§f.");
				ls04.add("§cVocê não possúi essa cabeça.");
				ls04.add(" ");
				ls04.add("§8Cabeça corativa.");
				stackm01111111.setLore(ls04);
				stack01111111.setItemMeta(stackm01111111);
				i.setItem(22, stack01111111);
			} else {
		        ItemStack skullItem = new ItemStack(Material.SKULL_ITEM);
			    skullItem.setDurability((short)3);
			    SkullMeta skullMeta = (SkullMeta)skullItem.getItemMeta();
			    skullMeta.setOwner("012345678910");
			    skullMeta.setDisplayName("§f§lFISHSTICK (FORTNITE)");
				List<String> ls04 = new ArrayList<String>();
				ls04.add("§b§m-------------------");
				ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
				ls04.add("§b§m-------------------");
				ls04.add(" ");
				ls04.add("§fDisponível apartir do rank §6§lPRO§f.");
				ls04.add("§aVocê possúi essa cabeça.");
				ls04.add(" ");
				ls04.add("§8Cabeça corativa.");
				skullMeta.setLore(ls04);
		        skullItem.setItemMeta(skullMeta);
				i.setItem(22, skullItem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(MySQLManager.getRank(p) == 1) {
					@SuppressWarnings("deprecation")
					ItemStack stack01111111 = new ItemStack(Material.getMaterial(351), 1, (short)8);
					ItemMeta stackm01111111 = stack01111111.getItemMeta();
					stackm01111111.setDisplayName("§f§lDEADPOOL");
					List<String> ls04 = new ArrayList<String>();
					ls04.add("§b§m-------------------");
					ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
					ls04.add("§b§m-------------------");
					ls04.add(" ");
					ls04.add("§fDisponível apartir do rank §6§lPRO§f. ");
					ls04.add("§cVocê não possúi essa cabeça.");
					ls04.add(" ");
					ls04.add("§8Cabeça corativa.");
					stackm01111111.setLore(ls04);
					stack01111111.setItemMeta(stackm01111111);
					i.setItem(23, stack01111111);
			} else if(MySQLManager.getRank(p) == 0) {
				@SuppressWarnings("deprecation")
				ItemStack stack01111111 = new ItemStack(Material.getMaterial(351), 1, (short)8);
				ItemMeta stackm01111111 = stack01111111.getItemMeta();
				stackm01111111.setDisplayName("§f§lDEADPOOL");
				List<String> ls04 = new ArrayList<String>();
				ls04.add("§b§m-------------------");
				ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
				ls04.add("§b§m-------------------");
				ls04.add(" ");
				ls04.add("§fDisponível apartir do rank §6§lPRO§f.");
				ls04.add("§cVocê não possúi essa cabeça.");
				ls04.add(" ");
				ls04.add("§8Cabeça corativa.");
				stackm01111111.setLore(ls04);
				stack01111111.setItemMeta(stackm01111111);
				i.setItem(23, stack01111111);
			} else if(MySQLManager.getRank(p) == 2) {
				@SuppressWarnings("deprecation")
				ItemStack stack01111111 = new ItemStack(Material.getMaterial(351), 1, (short)8);
				ItemMeta stackm01111111 = stack01111111.getItemMeta();
				stackm01111111.setDisplayName("§f§lDEADPOOL");
				List<String> ls04 = new ArrayList<String>();
				ls04.add("§b§m-------------------");
				ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
				ls04.add("§b§m-------------------");
				ls04.add(" ");
				ls04.add("§fDisponível apartir do rank §6§lPRO§f.");
				ls04.add("§cVocê não possúi essa cabeça.");
				ls04.add(" ");
				ls04.add("§8Cabeça corativa.");
				stackm01111111.setLore(ls04);
				stack01111111.setItemMeta(stackm01111111);
				i.setItem(23, stack01111111);
			} else {
		        ItemStack skullItem = new ItemStack(Material.SKULL_ITEM);
			    skullItem.setDurability((short)3);
			    SkullMeta skullMeta = (SkullMeta)skullItem.getItemMeta();
			    skullMeta.setOwner("Bongo6");
			    skullMeta.setDisplayName("§f§lDEADPOOL");
				List<String> ls04 = new ArrayList<String>();
				ls04.add("§b§m-------------------");
				ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
				ls04.add("§b§m-------------------");
				ls04.add(" ");
				ls04.add("§fDisponível apartir do rank §6§lPRO§f.");
				ls04.add("§aVocê possúi essa cabeça.");
				ls04.add(" ");
				ls04.add("§8Cabeça corativa.");
				skullMeta.setLore(ls04);
		        skullItem.setItemMeta(skullMeta);
				i.setItem(23, skullItem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(MySQLManager.getRank(p) == 1) {
					@SuppressWarnings("deprecation")
					ItemStack stack01111111 = new ItemStack(Material.getMaterial(351), 1, (short)8);
					ItemMeta stackm01111111 = stack01111111.getItemMeta();
					stackm01111111.setDisplayName("§f§lVENOM");
					List<String> ls04 = new ArrayList<String>();
					ls04.add("§b§m-------------------");
					ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
					ls04.add("§b§m-------------------");
					ls04.add(" ");
					ls04.add("§fDisponível apartir do rank §d§lULTRA§f. ");
					ls04.add("§cVocê não possúi essa cabeça.");
					ls04.add(" ");
					ls04.add("§8Cabeça corativa.");
					stackm01111111.setLore(ls04);
					stack01111111.setItemMeta(stackm01111111);
					i.setItem(24, stack01111111);
			} else if(MySQLManager.getRank(p) == 0) {
				@SuppressWarnings("deprecation")
				ItemStack stack01111111 = new ItemStack(Material.getMaterial(351), 1, (short)8);
				ItemMeta stackm01111111 = stack01111111.getItemMeta();
				stackm01111111.setDisplayName("§f§lVENOM");
				List<String> ls04 = new ArrayList<String>();
				ls04.add("§b§m-------------------");
				ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
				ls04.add("§b§m-------------------");
				ls04.add(" ");
				ls04.add("§fDisponível apartir do rank §d§lULTRA§f.");
				ls04.add("§cVocê não possúi essa cabeça.");
				ls04.add(" ");
				ls04.add("§8Cabeça corativa.");
				stackm01111111.setLore(ls04);
				stack01111111.setItemMeta(stackm01111111);
				i.setItem(24, stack01111111);
			} else if(MySQLManager.getRank(p) == 2) {
				@SuppressWarnings("deprecation")
				ItemStack stack01111111 = new ItemStack(Material.getMaterial(351), 1, (short)8);
				ItemMeta stackm01111111 = stack01111111.getItemMeta();
				stackm01111111.setDisplayName("§f§lVENOM");
				List<String> ls04 = new ArrayList<String>();
				ls04.add("§b§m-------------------");
				ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
				ls04.add("§b§m-------------------");
				ls04.add(" ");
				ls04.add("§fDisponível apartir do rank §d§lULTRA§f.");
				ls04.add("§cVocê não possúi essa cabeça.");
				ls04.add(" ");
				ls04.add("§8Cabeça corativa.");
				stackm01111111.setLore(ls04);
				stack01111111.setItemMeta(stackm01111111);
				i.setItem(24, stack01111111);
			} else if(MySQLManager.getRank(p) == 3) {
				@SuppressWarnings("deprecation")
				ItemStack stack01111111 = new ItemStack(Material.getMaterial(351), 1, (short)8);
				ItemMeta stackm01111111 = stack01111111.getItemMeta();
				stackm01111111.setDisplayName("§f§lVENOM");
				List<String> ls04 = new ArrayList<String>();
				ls04.add("§b§m-------------------");
				ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
				ls04.add("§b§m-------------------");
				ls04.add(" ");
				ls04.add("§fDisponível apartir do rank §d§lULTRA§f.");
				ls04.add("§cVocê não possúi essa cabeça.");
				ls04.add(" ");
				ls04.add("§8Cabeça corativa.");
				stackm01111111.setLore(ls04);
				stack01111111.setItemMeta(stackm01111111);
				i.setItem(24, stack01111111);
			} else {
		        ItemStack skullItem = new ItemStack(Material.SKULL_ITEM);
			    skullItem.setDurability((short)3);
			    SkullMeta skullMeta = (SkullMeta)skullItem.getItemMeta();
			    skullMeta.setOwner("3AKOMBIL");
			    skullMeta.setDisplayName("§f§lVENOM");
				List<String> ls04 = new ArrayList<String>();
				ls04.add("§b§m-------------------");
				ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
				ls04.add("§b§m-------------------");
				ls04.add(" ");
				ls04.add("§fDisponível apartir do rank §d§lULTRA§f.");
				ls04.add("§aVocê possúi essa cabeça.");
				ls04.add(" ");
				ls04.add("§8Cabeça corativa.");
				skullMeta.setLore(ls04);
		        skullItem.setItemMeta(skullMeta);
				i.setItem(24, skullItem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(MySQLManager.getRank(p) == 1) {
					@SuppressWarnings("deprecation")
					ItemStack stack01111111 = new ItemStack(Material.getMaterial(351), 1, (short)8);
					ItemMeta stackm01111111 = stack01111111.getItemMeta();
					stackm01111111.setDisplayName("§f§lTHOR");
					List<String> ls04 = new ArrayList<String>();
					ls04.add("§b§m-------------------");
					ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
					ls04.add("§b§m-------------------");
					ls04.add(" ");
					ls04.add("§fDisponível apartir do rank §d§lULTRA§f. ");
					ls04.add("§cVocê não possúi essa cabeça.");
					ls04.add(" ");
					ls04.add("§8Cabeça corativa.");
					stackm01111111.setLore(ls04);
					stack01111111.setItemMeta(stackm01111111);
					i.setItem(25, stack01111111);
			} else if(MySQLManager.getRank(p) == 0) {
				@SuppressWarnings("deprecation")
				ItemStack stack01111111 = new ItemStack(Material.getMaterial(351), 1, (short)8);
				ItemMeta stackm01111111 = stack01111111.getItemMeta();
				stackm01111111.setDisplayName("§f§lTHOR");
				List<String> ls04 = new ArrayList<String>();
				ls04.add("§b§m-------------------");
				ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
				ls04.add("§b§m-------------------");
				ls04.add(" ");
				ls04.add("§fDisponível apartir do rank §d§lULTRA§f.");
				ls04.add("§cVocê não possúi essa cabeça.");
				ls04.add(" ");
				ls04.add("§8Cabeça corativa.");
				stackm01111111.setLore(ls04);
				stack01111111.setItemMeta(stackm01111111);
				i.setItem(25, stack01111111);
			} else if(MySQLManager.getRank(p) == 2) {
				@SuppressWarnings("deprecation")
				ItemStack stack01111111 = new ItemStack(Material.getMaterial(351), 1, (short)8);
				ItemMeta stackm01111111 = stack01111111.getItemMeta();
				stackm01111111.setDisplayName("§f§LTHOR");
				List<String> ls04 = new ArrayList<String>();
				ls04.add("§b§m-------------------");
				ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
				ls04.add("§b§m-------------------");
				ls04.add(" ");
				ls04.add("§fDisponível apartir do rank §d§lULTRA§f.");
				ls04.add("§cVocê não possúi essa cabeça.");
				ls04.add(" ");
				ls04.add("§8Cabeça corativa.");
				stackm01111111.setLore(ls04);
				stack01111111.setItemMeta(stackm01111111);
				i.setItem(25, stack01111111);
			} else if(MySQLManager.getRank(p) == 3) {
				@SuppressWarnings("deprecation")
				ItemStack stack01111111 = new ItemStack(Material.getMaterial(351), 1, (short)8);
				ItemMeta stackm01111111 = stack01111111.getItemMeta();
				stackm01111111.setDisplayName("§f§LTHOR");
				List<String> ls04 = new ArrayList<String>();
				ls04.add("§b§m-------------------");
				ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
				ls04.add("§b§m-------------------");
				ls04.add(" ");
				ls04.add("§fDisponível apartir do rank §d§lULTRA§f.");
				ls04.add("§cVocê não possúi essa cabeça.");
				ls04.add(" ");
				ls04.add("§8Cabeça corativa.");
				stackm01111111.setLore(ls04);
				stack01111111.setItemMeta(stackm01111111);
				i.setItem(25, stack01111111);
			} else {
		        ItemStack skullItem = new ItemStack(Material.SKULL_ITEM);
			    skullItem.setDurability((short)3);
			    SkullMeta skullMeta = (SkullMeta)skullItem.getItemMeta();
			    skullMeta.setOwner("__KWONJIYONG__");
			    skullMeta.setDisplayName("§f§lTHOR");
				List<String> ls04 = new ArrayList<String>();
				ls04.add("§b§m-------------------");
				ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
				ls04.add("§b§m-------------------");
				ls04.add(" ");
				ls04.add("§fDisponível apartir do rank §d§lULTRA§f.");
				ls04.add("§aVocê possúi essa cabeça.");
				ls04.add(" ");
				ls04.add("§8Cabeça corativa.");
				skullMeta.setLore(ls04);
		        skullItem.setItemMeta(skullMeta);
				i.setItem(25, skullItem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(MySQLManager.getRank(p) == 1) {
					@SuppressWarnings("deprecation")
					ItemStack stack01111111 = new ItemStack(Material.getMaterial(351), 1, (short)8);
					ItemMeta stackm01111111 = stack01111111.getItemMeta();
					stackm01111111.setDisplayName("§f§LSTAN-LEE");
					List<String> ls04 = new ArrayList<String>();
					ls04.add("§b§m-------------------");
					ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
					ls04.add("§b§m-------------------");
					ls04.add(" ");
					ls04.add("§fDisponível apartir do rank §d§lULTRA§f. ");
					ls04.add("§cVocê não possúi essa cabeça.");
					ls04.add(" ");
					ls04.add("§8Cabeça corativa.");
					stackm01111111.setLore(ls04);
					stack01111111.setItemMeta(stackm01111111);
					i.setItem(28, stack01111111);
			} else if(MySQLManager.getRank(p) == 0) {
				@SuppressWarnings("deprecation")
				ItemStack stack01111111 = new ItemStack(Material.getMaterial(351), 1, (short)8);
				ItemMeta stackm01111111 = stack01111111.getItemMeta();
				stackm01111111.setDisplayName("§f§LSTAN-LEE");
				List<String> ls04 = new ArrayList<String>();
				ls04.add("§b§m-------------------");
				ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
				ls04.add("§b§m-------------------");
				ls04.add(" ");
				ls04.add("§fDisponível apartir do rank §d§lULTRA§f.");
				ls04.add("§cVocê não possúi essa cabeça.");
				ls04.add(" ");
				ls04.add("§8Cabeça corativa.");
				stackm01111111.setLore(ls04);
				stack01111111.setItemMeta(stackm01111111);
				i.setItem(28, stack01111111);
			} else if(MySQLManager.getRank(p) == 2) {
				@SuppressWarnings("deprecation")
				ItemStack stack01111111 = new ItemStack(Material.getMaterial(351), 1, (short)8);
				ItemMeta stackm01111111 = stack01111111.getItemMeta();
				stackm01111111.setDisplayName("§f§LSTAN-LEE");
				List<String> ls04 = new ArrayList<String>();
				ls04.add("§b§m-------------------");
				ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
				ls04.add("§b§m-------------------");
				ls04.add(" ");
				ls04.add("§fDisponível apartir do rank §d§lULTRA§f.");
				ls04.add("§cVocê não possúi essa cabeça.");
				ls04.add(" ");
				ls04.add("§8Cabeça corativa.");
				stackm01111111.setLore(ls04);
				stack01111111.setItemMeta(stackm01111111);
				i.setItem(28, stack01111111);
			} else if(MySQLManager.getRank(p) == 3) {
				@SuppressWarnings("deprecation")
				ItemStack stack01111111 = new ItemStack(Material.getMaterial(351), 1, (short)8);
				ItemMeta stackm01111111 = stack01111111.getItemMeta();
				stackm01111111.setDisplayName("§f§LSTAN-LEE");
				List<String> ls04 = new ArrayList<String>();
				ls04.add("§b§m-------------------");
				ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
				ls04.add("§b§m-------------------");
				ls04.add(" ");
				ls04.add("§fDisponível apartir do rank §d§lULTRA§f.");
				ls04.add("§cVocê não possúi essa cabeça.");
				ls04.add(" ");
				ls04.add("§8Cabeça corativa.");
				stackm01111111.setLore(ls04);
				stack01111111.setItemMeta(stackm01111111);
				i.setItem(28, stack01111111);
			} else {
		        ItemStack skullItem = new ItemStack(Material.SKULL_ITEM);
			    skullItem.setDurability((short)3);
			    SkullMeta skullMeta = (SkullMeta)skullItem.getItemMeta();
			    skullMeta.setOwner("3u8");
			    skullMeta.setDisplayName("§f§lSTAN-LEE");
				List<String> ls04 = new ArrayList<String>();
				ls04.add("§b§m-------------------");
				ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
				ls04.add("§b§m-------------------");
				ls04.add(" ");
				ls04.add("§fDisponível apartir do rank §d§lULTRA§f.");
				ls04.add("§aVocê possúi essa cabeça.");
				ls04.add(" ");
				ls04.add("§8Cabeça corativa.");
				skullMeta.setLore(ls04);
		        skullItem.setItemMeta(skullMeta);
				i.setItem(28, skullItem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(MySQLManager.getRank(p) == 1) {
					@SuppressWarnings("deprecation")
					ItemStack stack01111111 = new ItemStack(Material.getMaterial(351), 1, (short)8);
					ItemMeta stackm01111111 = stack01111111.getItemMeta();
					stackm01111111.setDisplayName("§f§lCORINGA");
					List<String> ls04 = new ArrayList<String>();
					ls04.add("§b§m-------------------");
					ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
					ls04.add("§b§m-------------------");
					ls04.add(" ");
					ls04.add("§fDisponível apartir do rank §d§lULTRA§f. ");
					ls04.add("§cVocê não possúi essa cabeça.");
					ls04.add(" ");
					ls04.add("§8Cabeça corativa.");
					stackm01111111.setLore(ls04);
					stack01111111.setItemMeta(stackm01111111);
					i.setItem(29, stack01111111);
			} else if(MySQLManager.getRank(p) == 0) {
				@SuppressWarnings("deprecation")
				ItemStack stack01111111 = new ItemStack(Material.getMaterial(351), 1, (short)8);
				ItemMeta stackm01111111 = stack01111111.getItemMeta();
				stackm01111111.setDisplayName("§f§lCORINGA");
				List<String> ls04 = new ArrayList<String>();
				ls04.add("§b§m-------------------");
				ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
				ls04.add("§b§m-------------------");
				ls04.add(" ");
				ls04.add("§fDisponível apartir do rank §d§lULTRA§f.");
				ls04.add("§cVocê não possúi essa cabeça.");
				ls04.add(" ");
				ls04.add("§8Cabeça corativa.");
				stackm01111111.setLore(ls04);
				stack01111111.setItemMeta(stackm01111111);
				i.setItem(29, stack01111111);
			} else if(MySQLManager.getRank(p) == 2) {
				@SuppressWarnings("deprecation")
				ItemStack stack01111111 = new ItemStack(Material.getMaterial(351), 1, (short)8);
				ItemMeta stackm01111111 = stack01111111.getItemMeta();
				stackm01111111.setDisplayName("§f§lCORINGA");
				List<String> ls04 = new ArrayList<String>();
				ls04.add("§b§m-------------------");
				ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
				ls04.add("§b§m-------------------");
				ls04.add(" ");
				ls04.add("§fDisponível apartir do rank §d§lULTRA§f.");
				ls04.add("§cVocê não possúi essa cabeça.");
				ls04.add(" ");
				ls04.add("§8Cabeça corativa.");
				stackm01111111.setLore(ls04);
				stack01111111.setItemMeta(stackm01111111);
				i.setItem(29, stack01111111);
			} else if(MySQLManager.getRank(p) == 3) {
				@SuppressWarnings("deprecation")
				ItemStack stack01111111 = new ItemStack(Material.getMaterial(351), 1, (short)8);
				ItemMeta stackm01111111 = stack01111111.getItemMeta();
				stackm01111111.setDisplayName("§f§lCORINGA");
				List<String> ls04 = new ArrayList<String>();
				ls04.add("§b§m-------------------");
				ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
				ls04.add("§b§m-------------------");
				ls04.add(" ");
				ls04.add("§fDisponível apartir do rank §d§lULTRA§f.");
				ls04.add("§cVocê não possúi essa cabeça.");
				ls04.add(" ");
				ls04.add("§8Cabeça corativa.");
				stackm01111111.setLore(ls04);
				stack01111111.setItemMeta(stackm01111111);
				i.setItem(29, stack01111111);
			} else {
		        ItemStack skullItem = new ItemStack(Material.SKULL_ITEM);
			    skullItem.setDurability((short)3);
			    SkullMeta skullMeta = (SkullMeta)skullItem.getItemMeta();
			    skullMeta.setOwner("abdal3000");
			    skullMeta.setDisplayName("§f§lCORINGA");
				List<String> ls04 = new ArrayList<String>();
				ls04.add("§b§m-------------------");
				ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
				ls04.add("§b§m-------------------");
				ls04.add(" ");
				ls04.add("§fDisponível apartir do rank §d§lULTRA§f.");
				ls04.add("§aVocê possúi essa cabeça.");
				ls04.add(" ");
				ls04.add("§8Cabeça corativa.");
				skullMeta.setLore(ls04);
		        skullItem.setItemMeta(skullMeta);
				i.setItem(29, skullItem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(MySQLManager.getRank(p) == 1) {
					@SuppressWarnings("deprecation")
					ItemStack stack01111111 = new ItemStack(Material.getMaterial(351), 1, (short)8);
					ItemMeta stackm01111111 = stack01111111.getItemMeta();
					stackm01111111.setDisplayName("§f§lROBIN");
					List<String> ls04 = new ArrayList<String>();
					ls04.add("§b§m-------------------");
					ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
					ls04.add("§b§m-------------------");
					ls04.add(" ");
					ls04.add("§fDisponível apartir do rank §3§lSTTEY§f.");
					ls04.add("§cVocê não possúi essa cabeça.");
					ls04.add(" ");
					ls04.add("§8Cabeça corativa.");
					stackm01111111.setLore(ls04);
					stack01111111.setItemMeta(stackm01111111);
					i.setItem(30, stack01111111);
			} else if(MySQLManager.getRank(p) == 0) {
				@SuppressWarnings("deprecation")
				ItemStack stack01111111 = new ItemStack(Material.getMaterial(351), 1, (short)8);
				ItemMeta stackm01111111 = stack01111111.getItemMeta();
				stackm01111111.setDisplayName("§f§lROBIN");
				List<String> ls04 = new ArrayList<String>();
				ls04.add("§b§m-------------------");
				ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
				ls04.add("§b§m-------------------");
				ls04.add(" ");
				ls04.add("§fDisponível apartir do rank §3§lSTTEY§f.");
				ls04.add("§cVocê não possúi essa cabeça.");
				ls04.add(" ");
				ls04.add("§8Cabeça corativa.");
				stackm01111111.setLore(ls04);
				stack01111111.setItemMeta(stackm01111111);
				i.setItem(30, stack01111111);
			} else if(MySQLManager.getRank(p) == 2) {
				@SuppressWarnings("deprecation")
				ItemStack stack01111111 = new ItemStack(Material.getMaterial(351), 1, (short)8);
				ItemMeta stackm01111111 = stack01111111.getItemMeta();
				stackm01111111.setDisplayName("§f§lROBIN");
				List<String> ls04 = new ArrayList<String>();
				ls04.add("§b§m-------------------");
				ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
				ls04.add("§b§m-------------------");
				ls04.add(" ");
				ls04.add("§fDisponível apartir do rank §3§lSTTEY§f.");
				ls04.add("§cVocê não possúi essa cabeça.");
				ls04.add(" ");
				ls04.add("§8Cabeça corativa.");
				stackm01111111.setLore(ls04);
				stack01111111.setItemMeta(stackm01111111);
				i.setItem(30, stack01111111);
			} else if(MySQLManager.getRank(p) == 3) {
				@SuppressWarnings("deprecation")
				ItemStack stack01111111 = new ItemStack(Material.getMaterial(351), 1, (short)8);
				ItemMeta stackm01111111 = stack01111111.getItemMeta();
				stackm01111111.setDisplayName("§f§lROBIN");
				List<String> ls04 = new ArrayList<String>();
				ls04.add("§b§m-------------------");
				ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
				ls04.add("§b§m-------------------");
				ls04.add(" ");
				ls04.add("§fDisponível apartir do rank §3§lSTTEY§f.");
				ls04.add("§cVocê não possúi essa cabeça.");
				ls04.add(" ");
				ls04.add("§8Cabeça corativa.");
				stackm01111111.setLore(ls04);
				stack01111111.setItemMeta(stackm01111111);
				i.setItem(30, stack01111111);
			} else if(MySQLManager.getRank(p) == 4) {
				@SuppressWarnings("deprecation")
				ItemStack stack01111111 = new ItemStack(Material.getMaterial(351), 1, (short)8);
				ItemMeta stackm01111111 = stack01111111.getItemMeta();
				stackm01111111.setDisplayName("§f§lROBIN");
				List<String> ls04 = new ArrayList<String>();
				ls04.add("§b§m-------------------");
				ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
				ls04.add("§b§m-------------------");
				ls04.add(" ");
				ls04.add("§fDisponível apartir do rank §3§lSTTEY§f.");
				ls04.add("§cVocê não possúi essa cabeça.");
				ls04.add(" ");
				ls04.add("§8Cabeça corativa.");
				stackm01111111.setLore(ls04);
				stack01111111.setItemMeta(stackm01111111);
				i.setItem(30, stack01111111);
			} else {
		        ItemStack skullItem = new ItemStack(Material.SKULL_ITEM);
			    skullItem.setDurability((short)3);
			    SkullMeta skullMeta = (SkullMeta)skullItem.getItemMeta();
			    skullMeta.setOwner("Hamsek");
			    skullMeta.setDisplayName("§f§lROBIN");
				List<String> ls04 = new ArrayList<String>();
				ls04.add("§b§m-------------------");
				ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
				ls04.add("§b§m-------------------");
				ls04.add(" ");
				ls04.add("§fDisponível apartir do rank §3§lSTTEY§f.");
				ls04.add("§aVocê possúi essa cabeça.");
				ls04.add(" ");
				ls04.add("§8Cabeça corativa.");
				skullMeta.setLore(ls04);
		        skullItem.setItemMeta(skullMeta);
				i.setItem(30, skullItem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(MySQLManager.getRank(p) == 1) {
					@SuppressWarnings("deprecation")
					ItemStack stack01111111 = new ItemStack(Material.getMaterial(351), 1, (short)8);
					ItemMeta stackm01111111 = stack01111111.getItemMeta();
					stackm01111111.setDisplayName("§f§lTHANOS");
					List<String> ls04 = new ArrayList<String>();
					ls04.add("§b§m-------------------");
					ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
					ls04.add("§b§m-------------------");
					ls04.add(" ");
					ls04.add("§fDisponível apartir do rank §3§lSTTEY§f.");
					ls04.add("§cVocê não possúi essa cabeça.");
					ls04.add(" ");
					ls04.add("§8Cabeça corativa.");
					stackm01111111.setLore(ls04);
					stack01111111.setItemMeta(stackm01111111);
					i.setItem(31, stack01111111);
			} else if(MySQLManager.getRank(p) == 0) {
				@SuppressWarnings("deprecation")
				ItemStack stack01111111 = new ItemStack(Material.getMaterial(351), 1, (short)8);
				ItemMeta stackm01111111 = stack01111111.getItemMeta();
				stackm01111111.setDisplayName("§f§lTHANOS");
				List<String> ls04 = new ArrayList<String>();
				ls04.add("§b§m-------------------");
				ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
				ls04.add("§b§m-------------------");
				ls04.add(" ");
				ls04.add("§fDisponível apartir do rank §3§lSTTEY§f.");
				ls04.add("§cVocê não possúi essa cabeça.");
				ls04.add(" ");
				ls04.add("§8Cabeça corativa.");
				stackm01111111.setLore(ls04);
				stack01111111.setItemMeta(stackm01111111);
				i.setItem(31, stack01111111);
			} else if(MySQLManager.getRank(p) == 2) {
				@SuppressWarnings("deprecation")
				ItemStack stack01111111 = new ItemStack(Material.getMaterial(351), 1, (short)8);
				ItemMeta stackm01111111 = stack01111111.getItemMeta();
				stackm01111111.setDisplayName("§f§lTHANOS");
				List<String> ls04 = new ArrayList<String>();
				ls04.add("§b§m-------------------");
				ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
				ls04.add("§b§m-------------------");
				ls04.add(" ");
				ls04.add("§fDisponível apartir do rank §3§lSTTEY§f.");
				ls04.add("§cVocê não possúi essa cabeça.");
				ls04.add(" ");
				ls04.add("§8Cabeça corativa.");
				stackm01111111.setLore(ls04);
				stack01111111.setItemMeta(stackm01111111);
				i.setItem(31, stack01111111);
			} else if(MySQLManager.getRank(p) == 3) {
				@SuppressWarnings("deprecation")
				ItemStack stack01111111 = new ItemStack(Material.getMaterial(351), 1, (short)8);
				ItemMeta stackm01111111 = stack01111111.getItemMeta();
				stackm01111111.setDisplayName("§f§lTHANOS");
				List<String> ls04 = new ArrayList<String>();
				ls04.add("§b§m-------------------");
				ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
				ls04.add("§b§m-------------------");
				ls04.add(" ");
				ls04.add("§fDisponível apartir do rank §3§lSTTEY§f.");
				ls04.add("§cVocê não possúi essa cabeça.");
				ls04.add(" ");
				ls04.add("§8Cabeça corativa.");
				stackm01111111.setLore(ls04);
				stack01111111.setItemMeta(stackm01111111);
				i.setItem(31, stack01111111);
			} else if(MySQLManager.getRank(p) == 4) {
				@SuppressWarnings("deprecation")
				ItemStack stack01111111 = new ItemStack(Material.getMaterial(351), 1, (short)8);
				ItemMeta stackm01111111 = stack01111111.getItemMeta();
				stackm01111111.setDisplayName("§f§lTHANOS");
				List<String> ls04 = new ArrayList<String>();
				ls04.add("§b§m-------------------");
				ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
				ls04.add("§b§m-------------------");
				ls04.add(" ");
				ls04.add("§fDisponível apartir do rank §3§lSTTEY§f.");
				ls04.add("§cVocê não possúi essa cabeça.");
				ls04.add(" ");
				ls04.add("§8Cabeça corativa.");
				stackm01111111.setLore(ls04);
				stack01111111.setItemMeta(stackm01111111);
				i.setItem(31, stack01111111);
			} else {
		        ItemStack skullItem = new ItemStack(Material.SKULL_ITEM);
			    skullItem.setDurability((short)3);
			    SkullMeta skullMeta = (SkullMeta)skullItem.getItemMeta();
			    skullMeta.setOwner("1337raw");
			    skullMeta.setDisplayName("§f§lTHANOS");
				List<String> ls04 = new ArrayList<String>();
				ls04.add("§b§m-------------------");
				ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
				ls04.add("§b§m-------------------");
				ls04.add(" ");
				ls04.add("§fDisponível apartir do rank §3§lSTTEY§f.");
				ls04.add("§aVocê possúi essa cabeça.");
				ls04.add(" ");
				ls04.add("§8Cabeça corativa.");
				skullMeta.setLore(ls04);
		        skullItem.setItemMeta(skullMeta);
				i.setItem(31, skullItem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(MySQLManager.getRank(p) == 1) {
					@SuppressWarnings("deprecation")
					ItemStack stack01111111 = new ItemStack(Material.getMaterial(351), 1, (short)8);
					ItemMeta stackm01111111 = stack01111111.getItemMeta();
					stackm01111111.setDisplayName("§f§lPIKACHU");
					List<String> ls04 = new ArrayList<String>();
					ls04.add("§b§m-------------------");
					ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
					ls04.add("§b§m-------------------");
					ls04.add(" ");
					ls04.add("§fDisponível apartir do rank §3§lSTTEY§f.");
					ls04.add("§cVocê não possúi essa cabeça.");
					ls04.add(" ");
					ls04.add("§8Cabeça corativa.");
					stackm01111111.setLore(ls04);
					stack01111111.setItemMeta(stackm01111111);
					i.setItem(32, stack01111111);
			} else if(MySQLManager.getRank(p) == 0) {
				@SuppressWarnings("deprecation")
				ItemStack stack01111111 = new ItemStack(Material.getMaterial(351), 1, (short)8);
				ItemMeta stackm01111111 = stack01111111.getItemMeta();
				stackm01111111.setDisplayName("§f§lPIKACHU");
				List<String> ls04 = new ArrayList<String>();
				ls04.add("§b§m-------------------");
				ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
				ls04.add("§b§m-------------------");
				ls04.add(" ");
				ls04.add("§fDisponível apartir do rank §3§lSTTEY§f.");
				ls04.add("§cVocê não possúi essa cabeça.");
				ls04.add(" ");
				ls04.add("§8Cabeça corativa.");
				stackm01111111.setLore(ls04);
				stack01111111.setItemMeta(stackm01111111);
				i.setItem(32, stack01111111);
			} else if(MySQLManager.getRank(p) == 2) {
				@SuppressWarnings("deprecation")
				ItemStack stack01111111 = new ItemStack(Material.getMaterial(351), 1, (short)8);
				ItemMeta stackm01111111 = stack01111111.getItemMeta();
				stackm01111111.setDisplayName("§f§lPIKACHU");
				List<String> ls04 = new ArrayList<String>();
				ls04.add("§b§m-------------------");
				ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
				ls04.add("§b§m-------------------");
				ls04.add(" ");
				ls04.add("§fDisponível apartir do rank §3§lSTTEY§f.");
				ls04.add("§cVocê não possúi essa cabeça.");
				ls04.add(" ");
				ls04.add("§8Cabeça corativa.");
				stackm01111111.setLore(ls04);
				stack01111111.setItemMeta(stackm01111111);
				i.setItem(32, stack01111111);
			} else if(MySQLManager.getRank(p) == 3) {
				@SuppressWarnings("deprecation")
				ItemStack stack01111111 = new ItemStack(Material.getMaterial(351), 1, (short)8);
				ItemMeta stackm01111111 = stack01111111.getItemMeta();
				stackm01111111.setDisplayName("§f§lPIKACHU");
				List<String> ls04 = new ArrayList<String>();
				ls04.add("§b§m-------------------");
				ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
				ls04.add("§b§m-------------------");
				ls04.add(" ");
				ls04.add("§fDisponível apartir do rank §3§lSTTEY§f.");
				ls04.add("§cVocê não possúi essa cabeça.");
				ls04.add(" ");
				ls04.add("§8Cabeça corativa.");
				stackm01111111.setLore(ls04);
				stack01111111.setItemMeta(stackm01111111);
				i.setItem(32, stack01111111);
			} else if(MySQLManager.getRank(p) == 4) {
				@SuppressWarnings("deprecation")
				ItemStack stack01111111 = new ItemStack(Material.getMaterial(351), 1, (short)8);
				ItemMeta stackm01111111 = stack01111111.getItemMeta();
				stackm01111111.setDisplayName("§f§lPIKACHU");
				List<String> ls04 = new ArrayList<String>();
				ls04.add("§b§m-------------------");
				ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
				ls04.add("§b§m-------------------");
				ls04.add(" ");
				ls04.add("§fDisponível apartir do rank §3§lSTTEY§f.");
				ls04.add("§cVocê não possúi essa cabeça.");
				ls04.add(" ");
				ls04.add("§8Cabeça corativa.");
				stackm01111111.setLore(ls04);
				stack01111111.setItemMeta(stackm01111111);
				i.setItem(32, stack01111111);
			} else {
		        ItemStack skullItem = new ItemStack(Material.SKULL_ITEM);
			    skullItem.setDurability((short)3);
			    SkullMeta skullMeta = (SkullMeta)skullItem.getItemMeta();
			    skullMeta.setOwner("05Pikachu");
			    skullMeta.setDisplayName("§f§lPIKACHU");
				List<String> ls04 = new ArrayList<String>();
				ls04.add("§b§m-------------------");
				ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
				ls04.add("§b§m-------------------");
				ls04.add(" ");
				ls04.add("§fDisponível apartir do rank §3§lSTTEY§f.");
				ls04.add("§aVocê possúi essa cabeça.");
				ls04.add(" ");
				ls04.add("§8Cabeça corativa.");
				skullMeta.setLore(ls04);
		        skullItem.setItemMeta(skullMeta);
				i.setItem(32, skullItem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			if(MySQLManager.getRank(p) == 1) {
					@SuppressWarnings("deprecation")
					ItemStack stack01111111 = new ItemStack(Material.getMaterial(351), 1, (short)8);
					ItemMeta stackm01111111 = stack01111111.getItemMeta();
					stackm01111111.setDisplayName("§f§lMINION");
					List<String> ls04 = new ArrayList<String>();
					ls04.add("§b§m-------------------");
					ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
					ls04.add("§b§m-------------------");
					ls04.add(" ");
					ls04.add("§fDisponível apartir do rank §3§lSTTEY§f.");
					ls04.add("§cVocê não possúi essa cabeça.");
					ls04.add(" ");
					ls04.add("§8Cabeça corativa.");
					stackm01111111.setLore(ls04);
					stack01111111.setItemMeta(stackm01111111);
					i.setItem(33, stack01111111);
			} else if(MySQLManager.getRank(p) == 0) {
				@SuppressWarnings("deprecation")
				ItemStack stack01111111 = new ItemStack(Material.getMaterial(351), 1, (short)8);
				ItemMeta stackm01111111 = stack01111111.getItemMeta();
				stackm01111111.setDisplayName("§f§lMINION");
				List<String> ls04 = new ArrayList<String>();
				ls04.add("§b§m-------------------");
				ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
				ls04.add("§b§m-------------------");
				ls04.add(" ");
				ls04.add("§fDisponível apartir do rank §3§lSTTEY§f.");
				ls04.add("§cVocê não possúi essa cabeça.");
				ls04.add(" ");
				ls04.add("§8Cabeça corativa.");
				stackm01111111.setLore(ls04);
				stack01111111.setItemMeta(stackm01111111);
				i.setItem(33, stack01111111);
			} else if(MySQLManager.getRank(p) == 2) {
				@SuppressWarnings("deprecation")
				ItemStack stack01111111 = new ItemStack(Material.getMaterial(351), 1, (short)8);
				ItemMeta stackm01111111 = stack01111111.getItemMeta();
				stackm01111111.setDisplayName("§f§lMINION");
				List<String> ls04 = new ArrayList<String>();
				ls04.add("§b§m-------------------");
				ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
				ls04.add("§b§m-------------------");
				ls04.add(" ");
				ls04.add("§fDisponível apartir do rank §3§lSTTEY§f.");
				ls04.add("§cVocê não possúi essa cabeça.");
				ls04.add(" ");
				ls04.add("§8Cabeça corativa.");
				stackm01111111.setLore(ls04);
				stack01111111.setItemMeta(stackm01111111);
				i.setItem(33, stack01111111);
			} else if(MySQLManager.getRank(p) == 3) {
				@SuppressWarnings("deprecation")
				ItemStack stack01111111 = new ItemStack(Material.getMaterial(351), 1, (short)8);
				ItemMeta stackm01111111 = stack01111111.getItemMeta();
				stackm01111111.setDisplayName("§f§lMINION");
				List<String> ls04 = new ArrayList<String>();
				ls04.add("§b§m-------------------");
				ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
				ls04.add("§b§m-------------------");
				ls04.add(" ");
				ls04.add("§fDisponível apartir do rank §3§lSTTEY§f.");
				ls04.add("§cVocê não possúi essa cabeça.");
				ls04.add(" ");
				ls04.add("§8Cabeça corativa.");
				stackm01111111.setLore(ls04);
				stack01111111.setItemMeta(stackm01111111);
				i.setItem(33, stack01111111);
			} else if(MySQLManager.getRank(p) == 4) {
				@SuppressWarnings("deprecation")
				ItemStack stack01111111 = new ItemStack(Material.getMaterial(351), 1, (short)8);
				ItemMeta stackm01111111 = stack01111111.getItemMeta();
				stackm01111111.setDisplayName("§f§lMINION");
				List<String> ls04 = new ArrayList<String>();
				ls04.add("§b§m-------------------");
				ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
				ls04.add("§b§m-------------------");
				ls04.add(" ");
				ls04.add("§fDisponível apartir do rank §3§lSTTEY§f.");
				ls04.add("§cVocê não possúi essa cabeça.");
				ls04.add(" ");
				ls04.add("§8Cabeça corativa.");
				stackm01111111.setLore(ls04);
				stack01111111.setItemMeta(stackm01111111);
				i.setItem(33, stack01111111);
			} else {
		        ItemStack skullItem = new ItemStack(Material.SKULL_ITEM);
			    skullItem.setDurability((short)3);
			    SkullMeta skullMeta = (SkullMeta)skullItem.getItemMeta();
			    skullMeta.setOwner("05Martiniii");
			    skullMeta.setDisplayName("§f§lMINION");
				List<String> ls04 = new ArrayList<String>();
				ls04.add("§b§m-------------------");
				ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
				ls04.add("§b§m-------------------");
				ls04.add(" ");
				ls04.add("§fDisponível apartir do rank §3§lSTTEY§f.");
				ls04.add("§aVocê possúi essa cabeça.");
				ls04.add(" ");
				ls04.add("§8Cabeça corativa.");
				skullMeta.setLore(ls04);
		        skullItem.setItemMeta(skullMeta);
				i.setItem(33, skullItem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		p.openInventory(i);
	}
	
	public static void opEfeitos(Player p) {
		Inventory i = Bukkit.createInventory(p, 54, "                §8§nEfeitos");
		
		ItemStack stack01 = new ItemStack(Material.ARROW);
		ItemMeta stackm01 = stack01.getItemMeta();
		List<String> ls = new ArrayList<String>();
		ls.add(" ");
		ls.add(" §a» §7Clique para voltar.");
		ls.add(" ");
		ls.add("§8Item de Navegação.");
		stackm01.setDisplayName("§aVoltar");
		stackm01.setLore(ls);
		stack01.setItemMeta(stackm01);
		i.setItem(48, stack01);
		
		ItemStack stack011 = new ItemStack(Material.BOOK_AND_QUILL);
		ItemMeta stackm011 = stack011.getItemMeta();
		List<String> ls1 = new ArrayList<String>();
		ls1.add(" ");
		ls1.add(" §7Retire o efeito");
		ls1.add(" §7que você está usando.");
		ls1.add(" ");
		ls1.add("§8Item de Navegação.");
		stackm011.setDisplayName("§aRemover Efeito");
		stackm011.setLore(ls1);
		stack011.setItemMeta(stackm011);
		i.setItem(49, stack011);
		
		try {
			if(MySQLManager.getRank(p) == 0) {
				@SuppressWarnings("deprecation")
				ItemStack stack01111111 = new ItemStack(Material.getMaterial(351), 1, (short)8);
				ItemMeta stackm01111111 = stack01111111.getItemMeta();
				stackm01111111.setDisplayName("§f§lCABEÇA QUENTE");
				List<String> ls04 = new ArrayList<String>();
				ls04.add("§b§m-------------------");
				ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
				ls04.add("§b§m-------------------");
				ls04.add(" ");
				ls04.add("§fDisponível apartir do rank §a§lVIP§f.");
				ls04.add("§cVocê não possúi esse efeito.");
				ls04.add(" ");
				ls04.add("§8Efeito corativo.");
				stackm01111111.setLore(ls04);
				stack01111111.setItemMeta(stackm01111111);
				i.setItem(10, stack01111111);
			} else {
				ItemStack stack01111 = new ItemStack(Material.FIREBALL);
				ItemMeta stackm01111 = stack01111.getItemMeta();
				List<String> ls111 = new ArrayList<String>();
				ls111.add("§b§m-------------------");
				ls111.add("  §6» §f§lINFORMAÇõES §f§6«");
				ls111.add("§b§m-------------------");
				ls111.add(" ");
				ls111.add("§fDisponível apartir do rank §a§lVIP§f.");
				ls111.add("§aVocê possúi esse efeito.");
				ls111.add(" ");
				ls111.add("§8Efeito corativo.");
				stackm01111.setDisplayName("§f§lCABEÇA QUENTE");
				stackm01111.setLore(ls111);
				stack01111.setItemMeta(stackm01111);
				i.setItem(10, stack01111);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(MySQLManager.getRank(p) == 0) {
				@SuppressWarnings("deprecation")
				ItemStack stack01111111 = new ItemStack(Material.getMaterial(351), 1, (short)8);
				ItemMeta stackm01111111 = stack01111111.getItemMeta();
				stackm01111111.setDisplayName("§f§lAPAIXONADO");
				List<String> ls04 = new ArrayList<String>();
				ls04.add("§b§m-------------------");
				ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
				ls04.add("§b§m-------------------");
				ls04.add(" ");
				ls04.add("§fDisponível apartir do rank §a§lVIP§f.");
				ls04.add("§cVocê não possúi essa cabeça.");
				ls04.add(" ");
				ls04.add("§8Efeito corativo.");
				stackm01111111.setLore(ls04);
				stack01111111.setItemMeta(stackm01111111);
				i.setItem(11, stack01111111);
			} else {
				@SuppressWarnings("deprecation")
				ItemStack stack01111 = new ItemStack(Material.getMaterial(351), 1, (short)1);
				ItemMeta stackm01111 = stack01111.getItemMeta();
				List<String> ls111 = new ArrayList<String>();
				ls111.add("§b§m-------------------");
				ls111.add("  §6» §f§lINFORMAÇõES §f§6«");
				ls111.add("§b§m-------------------");
				ls111.add(" ");
				ls111.add("§fDisponível apartir do rank §a§lVIP§f.");
				ls111.add("§aVocê possúi esse efeito.");
				ls111.add(" ");
				ls111.add("§8Efeito corativo.");
				stackm01111.setDisplayName("§f§lAPAIXONADO");
				stackm01111.setLore(ls111);
				stack01111.setItemMeta(stackm01111);
				i.setItem(11, stack01111);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(MySQLManager.getRank(p) == 0) {
					@SuppressWarnings("deprecation")
					ItemStack stack01111111 = new ItemStack(Material.getMaterial(351), 1, (short)8);
					ItemMeta stackm01111111 = stack01111111.getItemMeta();
					stackm01111111.setDisplayName("§f§lANEL DE AGUA");
					List<String> ls04 = new ArrayList<String>();
					ls04.add("§b§m-------------------");
					ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
					ls04.add("§b§m-------------------");
					ls04.add(" ");
					ls04.add("§fDisponível apartir do rank §e§lVIP+§f.");
					ls04.add("§cVocê não possúi esse efeito.");
					ls04.add(" ");
					ls04.add("§8Efeito corativo.");
					stackm01111111.setLore(ls04);
					stack01111111.setItemMeta(stackm01111111);
					i.setItem(12, stack01111111);
			} else if(MySQLManager.getRank(p) == 1) {
				@SuppressWarnings("deprecation")
				ItemStack stack01111111 = new ItemStack(Material.getMaterial(351), 1, (short)8);
				ItemMeta stackm01111111 = stack01111111.getItemMeta();
				stackm01111111.setDisplayName("§f§lANEL DE AGUA");
				List<String> ls04 = new ArrayList<String>();
				ls04.add("§b§m-------------------");
				ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
				ls04.add("§b§m-------------------");
				ls04.add(" ");
				ls04.add("§fDisponível apartir do rank §e§lVIP+§f.");
				ls04.add("§cVocê não possúi esse efeito.");
				ls04.add(" ");
				ls04.add("§8Efeito corativo.");
				stackm01111111.setLore(ls04);
				stack01111111.setItemMeta(stackm01111111);
				i.setItem(12, stack01111111);
		} else {
				ItemStack stack01111 = new ItemStack(Material.WATER_BUCKET);
				ItemMeta stackm01111 = stack01111.getItemMeta();
				List<String> ls111 = new ArrayList<String>();
				ls111.add("§b§m-------------------");
				ls111.add("  §6» §f§lINFORMAÇõES §f§6«");
				ls111.add("§b§m-------------------");
				ls111.add(" ");
				ls111.add("§fDisponível apartir do rank §e§lVIP+§f.");
				ls111.add("§aVocê possúi esse efeito.");
				ls111.add(" ");
				ls111.add("§8Efeito corativo.");
				stackm01111.setDisplayName("§f§lANEL DE AGUA");
				stackm01111.setLore(ls111);
				stack01111.setItemMeta(stackm01111);
				i.setItem(12, stack01111);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(MySQLManager.getRank(p) == 0) {
					@SuppressWarnings("deprecation")
					ItemStack stack01111111 = new ItemStack(Material.getMaterial(351), 1, (short)8);
					ItemMeta stackm01111111 = stack01111111.getItemMeta();
					stackm01111111.setDisplayName("§f§lANEL DE MAGMA");
					List<String> ls04 = new ArrayList<String>();
					ls04.add("§b§m-------------------");
					ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
					ls04.add("§b§m-------------------");
					ls04.add(" ");
					ls04.add("§fDisponível apartir do rank §a§lVIP§f.");
					ls04.add("§cVocê não possúi essa cabeça.");
					ls04.add(" ");
					ls04.add("§8Efeito corativo.");
					stackm01111111.setLore(ls04);
					stack01111111.setItemMeta(stackm01111111);
					i.setItem(13, stack01111111);
			} else if(MySQLManager.getRank(p) == 1) {
				@SuppressWarnings("deprecation")
				ItemStack stack01111111 = new ItemStack(Material.getMaterial(351), 1, (short)8);
				ItemMeta stackm01111111 = stack01111111.getItemMeta();
				stackm01111111.setDisplayName("§f§lANEL DE MAGMA");
				List<String> ls04 = new ArrayList<String>();
				ls04.add("§b§m-------------------");
				ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
				ls04.add("§b§m-------------------");
				ls04.add(" ");
				ls04.add("§fDisponível apartir do rank §e§lVIP+§f.");
				ls04.add("§cVocê não possúi esse efeito.");
				ls04.add(" ");
				ls04.add("§8Efeito corativo.");
				stackm01111111.setLore(ls04);
				stack01111111.setItemMeta(stackm01111111);
				i.setItem(13, stack01111111);
		} else {
				ItemStack stack01111 = new ItemStack(Material.LAVA_BUCKET);
				ItemMeta stackm01111 = stack01111.getItemMeta();
				List<String> ls111 = new ArrayList<String>();
				ls111.add("§b§m-------------------");
				ls111.add("  §6» §f§lINFORMAÇõES §f§6«");
				ls111.add("§b§m-------------------");
				ls111.add(" ");
				ls111.add("§fDisponível apartir do rank §e§lVIP+§f.");
				ls111.add("§aVocê possúi esse efeito.");
				ls111.add(" ");
				ls111.add("§8Efeito corativo.");
				stackm01111.setDisplayName("§f§lANEL DE MAGMA");
				stackm01111.setLore(ls111);
				stack01111.setItemMeta(stackm01111);
				i.setItem(13, stack01111);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(MySQLManager.getRank(p) == 0) {
					@SuppressWarnings("deprecation")
					ItemStack stack01111111 = new ItemStack(Material.getMaterial(351), 1, (short)8);
					ItemMeta stackm01111111 = stack01111111.getItemMeta();
					stackm01111111.setDisplayName("§f§lANEL §c§lC§6§lO§e§lL§a§lO§3§lR§b§lI§5§lD§c§lO");
					List<String> ls04 = new ArrayList<String>();
					ls04.add("§b§m-------------------");
					ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
					ls04.add("§b§m-------------------");
					ls04.add(" ");
					ls04.add("§fDisponível apartir do rank §6§lPRO§f.");
					ls04.add("§cVocê não possúi essa cabeça.");
					ls04.add(" ");
					ls04.add("§8Efeito corativo.");
					stackm01111111.setLore(ls04);
					stack01111111.setItemMeta(stackm01111111);
					i.setItem(14, stack01111111);
			} else if(MySQLManager.getRank(p) == 1) {
				@SuppressWarnings("deprecation")
				ItemStack stack01111111 = new ItemStack(Material.getMaterial(351), 1, (short)8);
				ItemMeta stackm01111111 = stack01111111.getItemMeta();
				stackm01111111.setDisplayName("§f§lANEL §c§lC§6§lO§e§lL§a§lO§3§lR§b§lI§5§lD§c§lO");
				List<String> ls04 = new ArrayList<String>();
				ls04.add("§b§m-------------------");
				ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
				ls04.add("§b§m-------------------");
				ls04.add(" ");
				ls04.add("§fDisponível apartir do rank §6§lPRO§f.");
				ls04.add("§cVocê não possúi esse efeito.");
				ls04.add(" ");
				ls04.add("§8Efeito corativo.");
				stackm01111111.setLore(ls04);
				stack01111111.setItemMeta(stackm01111111);
				i.setItem(14, stack01111111);
		} else if(MySQLManager.getRank(p) == 2) {
			@SuppressWarnings("deprecation")
			ItemStack stack01111111 = new ItemStack(Material.getMaterial(351), 1, (short)8);
			ItemMeta stackm01111111 = stack01111111.getItemMeta();
			stackm01111111.setDisplayName("§f§lANEL §c§lC§6§lO§e§lL§a§lO§3§lR§b§lI§5§lD§c§lO");
			List<String> ls04 = new ArrayList<String>();
			ls04.add("§b§m-------------------");
			ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
			ls04.add("§b§m-------------------");
			ls04.add(" ");
			ls04.add("§fDisponível apartir do rank §6§lPRO§f.");
			ls04.add("§cVocê não possúi esse efeito.");
			ls04.add(" ");
			ls04.add("§8Efeito corativo.");
			stackm01111111.setLore(ls04);
			stack01111111.setItemMeta(stackm01111111);
			i.setItem(14, stack01111111);
	} else {
				ItemStack stack01111 = new ItemStack(Material.GOLDEN_APPLE);
				ItemMeta stackm01111 = stack01111.getItemMeta();
				List<String> ls111 = new ArrayList<String>();
				ls111.add("§b§m-------------------");
				ls111.add("  §6» §f§lINFORMAÇõES §f§6«");
				ls111.add("§b§m-------------------");
				ls111.add(" ");
				ls111.add("§fDisponível apartir do rank §6§lPRO§f.");
				ls111.add("§aVocê possúi esse efeito.");
				ls111.add(" ");
				ls111.add("§8Efeito corativo.");
				stackm01111.setDisplayName("§f§lANEL §c§lC§6§lO§e§lL§a§lO§3§lR§b§lI§5§lD§c§lO");
				stackm01111.setLore(ls111);
				stack01111.setItemMeta(stackm01111);
				i.setItem(14, stack01111);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(MySQLManager.getRank(p) == 0) {
					@SuppressWarnings("deprecation")
					ItemStack stack01111111 = new ItemStack(Material.getMaterial(351), 1, (short)8);
					ItemMeta stackm01111111 = stack01111111.getItemMeta();
					stackm01111111.setDisplayName("§f§lHELIX DE FOGO");
					List<String> ls04 = new ArrayList<String>();
					ls04.add("§b§m-------------------");
					ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
					ls04.add("§b§m-------------------");
					ls04.add(" ");
					ls04.add("§fDisponível apartir do rank §6§lPRO§f.");
					ls04.add("§cVocê não possúi essa cabeça.");
					ls04.add(" ");
					ls04.add("§8Efeito corativo.");
					stackm01111111.setLore(ls04);
					stack01111111.setItemMeta(stackm01111111);
					i.setItem(15, stack01111111);
			} else if(MySQLManager.getRank(p) == 1) {
				@SuppressWarnings("deprecation")
				ItemStack stack01111111 = new ItemStack(Material.getMaterial(351), 1, (short)8);
				ItemMeta stackm01111111 = stack01111111.getItemMeta();
				stackm01111111.setDisplayName("§f§lHELIX DE FOGO");
				List<String> ls04 = new ArrayList<String>();
				ls04.add("§b§m-------------------");
				ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
				ls04.add("§b§m-------------------");
				ls04.add(" ");
				ls04.add("§fDisponível apartir do rank §6§lPRO§f.");
				ls04.add("§cVocê não possúi esse efeito.");
				ls04.add(" ");
				ls04.add("§8Efeito corativo.");
				stackm01111111.setLore(ls04);
				stack01111111.setItemMeta(stackm01111111);
				i.setItem(15, stack01111111);
		} else if(MySQLManager.getRank(p) == 2) {
			@SuppressWarnings("deprecation")
			ItemStack stack01111111 = new ItemStack(Material.getMaterial(351), 1, (short)8);
			ItemMeta stackm01111111 = stack01111111.getItemMeta();
			stackm01111111.setDisplayName("§f§lHELIX DE FOGO");
			List<String> ls04 = new ArrayList<String>();
			ls04.add("§b§m-------------------");
			ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
			ls04.add("§b§m-------------------");
			ls04.add(" ");
			ls04.add("§fDisponível apartir do rank §6§lPRO§f.");
			ls04.add("§cVocê não possúi esse efeito.");
			ls04.add(" ");
			ls04.add("§8Efeito corativo.");
			stackm01111111.setLore(ls04);
			stack01111111.setItemMeta(stackm01111111);
			i.setItem(15, stack01111111);
	} else {
				@SuppressWarnings("deprecation")
				ItemStack stack01111 = new ItemStack(Material.getMaterial(377));
				ItemMeta stackm01111 = stack01111.getItemMeta();
				List<String> ls111 = new ArrayList<String>();
				ls111.add("§b§m-------------------");
				ls111.add("  §6» §f§lINFORMAÇõES §f§6«");
				ls111.add("§b§m-------------------");
				ls111.add(" ");
				ls111.add("§fDisponível apartir do rank §6§lPRO§f.");
				ls111.add("§aVocê possúi esse efeito.");
				ls111.add(" ");
				ls111.add("§8Efeito corativo.");
				stackm01111.setDisplayName("§f§lHELIX DE FOGO");
				stackm01111.setLore(ls111);
				stack01111.setItemMeta(stackm01111);
				i.setItem(15, stack01111);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(MySQLManager.getRank(p) == 0) {
					@SuppressWarnings("deprecation")
					ItemStack stack01111111 = new ItemStack(Material.getMaterial(351), 1, (short)8);
					ItemMeta stackm01111111 = stack01111111.getItemMeta();
					stackm01111111.setDisplayName("§f§lCÚPULA VERMELHA");
					List<String> ls04 = new ArrayList<String>();
					ls04.add("§b§m-------------------");
					ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
					ls04.add("§b§m-------------------");
					ls04.add(" ");
					ls04.add("§fDisponível apartir do rank §d§lULTRA§f.");
					ls04.add("§cVocê não possúi essa cabeça.");
					ls04.add(" ");
					ls04.add("§8Efeito corativo.");
					stackm01111111.setLore(ls04);
					stack01111111.setItemMeta(stackm01111111);
					i.setItem(16, stack01111111);
			} else if(MySQLManager.getRank(p) == 1) {
				@SuppressWarnings("deprecation")
				ItemStack stack01111111 = new ItemStack(Material.getMaterial(351), 1, (short)8);
				ItemMeta stackm01111111 = stack01111111.getItemMeta();
				stackm01111111.setDisplayName("§f§lCÚPULA VERMELHA");
				List<String> ls04 = new ArrayList<String>();
				ls04.add("§b§m-------------------");
				ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
				ls04.add("§b§m-------------------");
				ls04.add(" ");
				ls04.add("§fDisponível apartir do rank §d§lULTRA§f.");
				ls04.add("§cVocê não possúi esse efeito.");
				ls04.add(" ");
				ls04.add("§8Efeito corativo.");
				stackm01111111.setLore(ls04);
				stack01111111.setItemMeta(stackm01111111);
				i.setItem(16, stack01111111);
		} else if(MySQLManager.getRank(p) == 3) {
			@SuppressWarnings("deprecation")
			ItemStack stack01111111 = new ItemStack(Material.getMaterial(351), 1, (short)8);
			ItemMeta stackm01111111 = stack01111111.getItemMeta();
			stackm01111111.setDisplayName("§f§lCÚPULA VERMELHA");
			List<String> ls04 = new ArrayList<String>();
			ls04.add("§b§m-------------------");
			ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
			ls04.add("§b§m-------------------");
			ls04.add(" ");
			ls04.add("§fDisponível apartir do rank §d§lULTRA§f.");
			ls04.add("§cVocê não possúi esse efeito.");
			ls04.add(" ");
			ls04.add("§8Efeito corativo.");
			stackm01111111.setLore(ls04);
			stack01111111.setItemMeta(stackm01111111);
			i.setItem(16, stack01111111);
	}  else if(MySQLManager.getRank(p) == 2) {
			@SuppressWarnings("deprecation")
			ItemStack stack01111111 = new ItemStack(Material.getMaterial(351), 1, (short)8);
			ItemMeta stackm01111111 = stack01111111.getItemMeta();
			stackm01111111.setDisplayName("§f§lCÚPULA VERMELHA");
			List<String> ls04 = new ArrayList<String>();
			ls04.add("§b§m-------------------");
			ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
			ls04.add("§b§m-------------------");
			ls04.add(" ");
			ls04.add("§fDisponível apartir do rank §d§lULTRA§f.");
			ls04.add("§cVocê não possúi esse efeito.");
			ls04.add(" ");
			ls04.add("§8Efeito corativo.");
			stackm01111111.setLore(ls04);
			stack01111111.setItemMeta(stackm01111111);
			i.setItem(16, stack01111111);
	} else {
				ItemStack stack01111 = new ItemStack(Material.REDSTONE_BLOCK);
				ItemMeta stackm01111 = stack01111.getItemMeta();
				List<String> ls111 = new ArrayList<String>();
				ls111.add("§b§m-------------------");
				ls111.add("  §6» §f§lINFORMAÇõES §f§6«");
				ls111.add("§b§m-------------------");
				ls111.add(" ");
				ls111.add("§fDisponível apartir do rank §d§lULTRA§f.");
				ls111.add("§aVocê possúi esse efeito.");
				ls111.add(" ");
				ls111.add("§8Efeito corativo.");
				stackm01111.setDisplayName("§f§lCÚPULA VERMELHA");
				stackm01111.setLore(ls111);
				stack01111.setItemMeta(stackm01111);
				i.setItem(16, stack01111);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(MySQLManager.getRank(p) == 0) {
					@SuppressWarnings("deprecation")
					ItemStack stack01111111 = new ItemStack(Material.getMaterial(351), 1, (short)8);
					ItemMeta stackm01111111 = stack01111111.getItemMeta();
					stackm01111111.setDisplayName("§f§lROTAÇãO AQUÁTICA");
					List<String> ls04 = new ArrayList<String>();
					ls04.add("§b§m-------------------");
					ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
					ls04.add("§b§m-------------------");
					ls04.add(" ");
					ls04.add("§fDisponível apartir do rank §d§lULTRA§f.");
					ls04.add("§cVocê não possúi essa cabeça.");
					ls04.add(" ");
					ls04.add("§8Efeito corativo.");
					stackm01111111.setLore(ls04);
					stack01111111.setItemMeta(stackm01111111);
					i.setItem(19, stack01111111);
			} else if(MySQLManager.getRank(p) == 1) {
				@SuppressWarnings("deprecation")
				ItemStack stack01111111 = new ItemStack(Material.getMaterial(351), 1, (short)8);
				ItemMeta stackm01111111 = stack01111111.getItemMeta();
				stackm01111111.setDisplayName("§f§lROTAÇãO AQUÁTICA");
				List<String> ls04 = new ArrayList<String>();
				ls04.add("§b§m-------------------");
				ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
				ls04.add("§b§m-------------------");
				ls04.add(" ");
				ls04.add("§fDisponível apartir do rank §d§lULTRA§f.");
				ls04.add("§cVocê não possúi esse efeito.");
				ls04.add(" ");
				ls04.add("§8Efeito corativo.");
				stackm01111111.setLore(ls04);
				stack01111111.setItemMeta(stackm01111111);
				i.setItem(19, stack01111111);
		} else if(MySQLManager.getRank(p) == 3) {
			@SuppressWarnings("deprecation")
			ItemStack stack01111111 = new ItemStack(Material.getMaterial(351), 1, (short)8);
			ItemMeta stackm01111111 = stack01111111.getItemMeta();
			stackm01111111.setDisplayName("§f§lROTAÇãO AQUÁTICA");
			List<String> ls04 = new ArrayList<String>();
			ls04.add("§b§m-------------------");
			ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
			ls04.add("§b§m-------------------");
			ls04.add(" ");
			ls04.add("§fDisponível apartir do rank §d§lULTRA§f.");
			ls04.add("§cVocê não possúi esse efeito.");
			ls04.add(" ");
			ls04.add("§8Efeito corativo.");
			stackm01111111.setLore(ls04);
			stack01111111.setItemMeta(stackm01111111);
			i.setItem(19, stack01111111);
	}  else if(MySQLManager.getRank(p) == 2) {
			@SuppressWarnings("deprecation")
			ItemStack stack01111111 = new ItemStack(Material.getMaterial(351), 1, (short)8);
			ItemMeta stackm01111111 = stack01111111.getItemMeta();
			stackm01111111.setDisplayName("§f§lROTAÇãO AQUÁTICA");
			List<String> ls04 = new ArrayList<String>();
			ls04.add("§b§m-------------------");
			ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
			ls04.add("§b§m-------------------");
			ls04.add(" ");
			ls04.add("§fDisponível apartir do rank §d§lULTRA§f.");
			ls04.add("§cVocê não possúi esse efeito.");
			ls04.add(" ");
			ls04.add("§8Efeito corativo.");
			stackm01111111.setLore(ls04);
			stack01111111.setItemMeta(stackm01111111);
			i.setItem(19, stack01111111);
	} else {
				@SuppressWarnings("deprecation")
				ItemStack stack01111 = new ItemStack(Material.getMaterial(351), 1, (short)4);
				ItemMeta stackm01111 = stack01111.getItemMeta();
				List<String> ls111 = new ArrayList<String>();
				ls111.add("§b§m-------------------");
				ls111.add("  §6» §f§lINFORMAÇõES §f§6«");
				ls111.add("§b§m-------------------");
				ls111.add(" ");
				ls111.add("§fDisponível apartir do rank §d§lULTRA§f.");
				ls111.add("§aVocê possúi esse efeito.");
				ls111.add(" ");
				ls111.add("§8Efeito corativo.");
				stackm01111.setDisplayName("§f§lROTAÇãO AQUÁTICA");
				stackm01111.setLore(ls111);
				stack01111.setItemMeta(stackm01111);
				i.setItem(19, stack01111);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(MySQLManager.getRank(p) == 0) {
					@SuppressWarnings("deprecation")
					ItemStack stack01111111 = new ItemStack(Material.getMaterial(351), 1, (short)8);
					ItemMeta stackm01111111 = stack01111111.getItemMeta();
					stackm01111111.setDisplayName("§f§lASA ANGELICAIS");
					List<String> ls04 = new ArrayList<String>();
					ls04.add("§b§m-------------------");
					ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
					ls04.add("§b§m-------------------");
					ls04.add(" ");
					ls04.add("§fDisponível apartir do rank §3§lSTTEY§f.");
					ls04.add("§cVocê não possúi essa cabeça.");
					ls04.add(" ");
					ls04.add("§8Efeito corativo.");
					stackm01111111.setLore(ls04);
					stack01111111.setItemMeta(stackm01111111);
					i.setItem(20, stack01111111);
			} else if(MySQLManager.getRank(p) == 1) {
				@SuppressWarnings("deprecation")
				ItemStack stack01111111 = new ItemStack(Material.getMaterial(351), 1, (short)8);
				ItemMeta stackm01111111 = stack01111111.getItemMeta();
				stackm01111111.setDisplayName("§f§lASA ANGELICAIS");
				List<String> ls04 = new ArrayList<String>();
				ls04.add("§b§m-------------------");
				ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
				ls04.add("§b§m-------------------");
				ls04.add(" ");
				ls04.add("§fDisponível apartir do rank §3§lSTTEY§f.");
				ls04.add("§cVocê não possúi esse efeito.");
				ls04.add(" ");
				ls04.add("§8Efeito corativo.");
				stackm01111111.setLore(ls04);
				stack01111111.setItemMeta(stackm01111111);
				i.setItem(20, stack01111111);
		} else if(MySQLManager.getRank(p) == 3) {
			@SuppressWarnings("deprecation")
			ItemStack stack01111111 = new ItemStack(Material.getMaterial(351), 1, (short)8);
			ItemMeta stackm01111111 = stack01111111.getItemMeta();
			stackm01111111.setDisplayName("§f§lASA ANGELICAIS");
			List<String> ls04 = new ArrayList<String>();
			ls04.add("§b§m-------------------");
			ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
			ls04.add("§b§m-------------------");
			ls04.add(" ");
			ls04.add("§fDisponível apartir do rank §3§lSTTEY§f.");
			ls04.add("§cVocê não possúi esse efeito.");
			ls04.add(" ");
			ls04.add("§8Efeito corativo.");
			stackm01111111.setLore(ls04);
			stack01111111.setItemMeta(stackm01111111);
			i.setItem(20, stack01111111);
	} else if(MySQLManager.getRank(p) == 4) {
		@SuppressWarnings("deprecation")
		ItemStack stack01111111 = new ItemStack(Material.getMaterial(351), 1, (short)8);
		ItemMeta stackm01111111 = stack01111111.getItemMeta();
		stackm01111111.setDisplayName("§f§lASA ANGELICAIS");
		List<String> ls04 = new ArrayList<String>();
		ls04.add("§b§m-------------------");
		ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
		ls04.add("§b§m-------------------");
		ls04.add(" ");
		ls04.add("§fDisponível apartir do rank §3§lSTTEY§f.");
		ls04.add("§cVocê não possúi esse efeito.");
		ls04.add(" ");
		ls04.add("§8Efeito corativo.");
		stackm01111111.setLore(ls04);
		stack01111111.setItemMeta(stackm01111111);
		i.setItem(20, stack01111111);
} else if(MySQLManager.getRank(p) == 2) {
			@SuppressWarnings("deprecation")
			ItemStack stack01111111 = new ItemStack(Material.getMaterial(351), 1, (short)8);
			ItemMeta stackm01111111 = stack01111111.getItemMeta();
			stackm01111111.setDisplayName("§f§lASA ANGELICAIS");
			List<String> ls04 = new ArrayList<String>();
			ls04.add("§b§m-------------------");
			ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
			ls04.add("§b§m-------------------");
			ls04.add(" ");
			ls04.add("§fDisponível apartir do rank §3§lSTTEY§f.");
			ls04.add("§cVocê não possúi esse efeito.");
			ls04.add(" ");
			ls04.add("§8Efeito corativo.");
			stackm01111111.setLore(ls04);
			stack01111111.setItemMeta(stackm01111111);
			i.setItem(20, stack01111111);
	} else {
				ItemStack stack01111 = new ItemStack(Material.FEATHER);
				ItemMeta stackm01111 = stack01111.getItemMeta();
				List<String> ls111 = new ArrayList<String>();
				ls111.add("§b§m-------------------");
				ls111.add("  §6» §f§lINFORMAÇõES §f§6«");
				ls111.add("§b§m-------------------");
				ls111.add(" ");
				ls111.add("§fDisponível apartir do rank §3§lSTTEY§f.");
				ls111.add("§aVocê possúi esse efeito.");
				ls111.add(" ");
				ls111.add("§8Efeito corativo.");
				stackm01111.setDisplayName("§f§lASAS ANGELICAIS");
				stackm01111.setLore(ls111);
				stack01111.setItemMeta(stackm01111);
				i.setItem(20, stack01111);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(MySQLManager.getRank(p) == 0) {
					@SuppressWarnings("deprecation")
					ItemStack stack01111111 = new ItemStack(Material.getMaterial(351), 1, (short)8);
					ItemMeta stackm01111111 = stack01111111.getItemMeta();
					stackm01111111.setDisplayName("§f§lASA DEMONIACAS");
					List<String> ls04 = new ArrayList<String>();
					ls04.add("§b§m-------------------");
					ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
					ls04.add("§b§m-------------------");
					ls04.add(" ");
					ls04.add("§fDisponível apartir do rank §3§lSTTEY§f.");
					ls04.add("§cVocê não possúi essa cabeça.");
					ls04.add(" ");
					ls04.add("§8Efeito corativo.");
					stackm01111111.setLore(ls04);
					stack01111111.setItemMeta(stackm01111111);
					i.setItem(21, stack01111111);
			} else if(MySQLManager.getRank(p) == 1) {
				@SuppressWarnings("deprecation")
				ItemStack stack01111111 = new ItemStack(Material.getMaterial(351), 1, (short)8);
				ItemMeta stackm01111111 = stack01111111.getItemMeta();
				stackm01111111.setDisplayName("§f§lASA DEMONIACAS");
				List<String> ls04 = new ArrayList<String>();
				ls04.add("§b§m-------------------");
				ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
				ls04.add("§b§m-------------------");
				ls04.add(" ");
				ls04.add("§fDisponível apartir do rank §3§lSTTEY§f.");
				ls04.add("§cVocê não possúi esse efeito.");
				ls04.add(" ");
				ls04.add("§8Efeito corativo.");
				stackm01111111.setLore(ls04);
				stack01111111.setItemMeta(stackm01111111);
				i.setItem(21, stack01111111);
		} else if(MySQLManager.getRank(p) == 4) {
			@SuppressWarnings("deprecation")
			ItemStack stack01111111 = new ItemStack(Material.getMaterial(351), 1, (short)8);
			ItemMeta stackm01111111 = stack01111111.getItemMeta();
			stackm01111111.setDisplayName("§f§lASA DEMONIACAS");
			List<String> ls04 = new ArrayList<String>();
			ls04.add("§b§m-------------------");
			ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
			ls04.add("§b§m-------------------");
			ls04.add(" ");
			ls04.add("§fDisponível apartir do rank §3§lSTTEY§f.");
			ls04.add("§cVocê não possúi esse efeito.");
			ls04.add(" ");
			ls04.add("§8Efeito corativo.");
			stackm01111111.setLore(ls04);
			stack01111111.setItemMeta(stackm01111111);
			i.setItem(21, stack01111111);
	} else if(MySQLManager.getRank(p) == 3) {
			@SuppressWarnings("deprecation")
			ItemStack stack01111111 = new ItemStack(Material.getMaterial(351), 1, (short)8);
			ItemMeta stackm01111111 = stack01111111.getItemMeta();
			stackm01111111.setDisplayName("§f§lASA DEMONIACAS");
			List<String> ls04 = new ArrayList<String>();
			ls04.add("§b§m-------------------");
			ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
			ls04.add("§b§m-------------------");
			ls04.add(" ");
			ls04.add("§fDisponível apartir do rank §3§lSTTEY§f.");
			ls04.add("§cVocê não possúi esse efeito.");
			ls04.add(" ");
			ls04.add("§8Efeito corativo.");
			stackm01111111.setLore(ls04);
			stack01111111.setItemMeta(stackm01111111);
			i.setItem(21, stack01111111);
	} else if(MySQLManager.getRank(p) == 2) {
			@SuppressWarnings("deprecation")
			ItemStack stack01111111 = new ItemStack(Material.getMaterial(351), 1, (short)8);
			ItemMeta stackm01111111 = stack01111111.getItemMeta();
			stackm01111111.setDisplayName("§f§lASA DEMONIACAS");
			List<String> ls04 = new ArrayList<String>();
			ls04.add("§b§m-------------------");
			ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
			ls04.add("§b§m-------------------");
			ls04.add(" ");
			ls04.add("§fDisponível apartir do rank §3§lSTTEY§f.");
			ls04.add("§cVocê não possúi esse efeito.");
			ls04.add(" ");
			ls04.add("§8Efeito corativo.");
			stackm01111111.setLore(ls04);
			stack01111111.setItemMeta(stackm01111111);
			i.setItem(21, stack01111111);
	} else {
				ItemStack stack01111 = new ItemStack(Material.NETHER_STAR);
				ItemMeta stackm01111 = stack01111.getItemMeta();
				List<String> ls111 = new ArrayList<String>();
				ls111.add("§b§m-------------------");
				ls111.add("  §6» §f§lINFORMAÇõES §f§6«");
				ls111.add("§b§m-------------------");
				ls111.add(" ");
				ls111.add("§fDisponível apartir do rank §3§lSTTEY§f.");
				ls111.add("§aVocê possúi esse efeito.");
				ls111.add(" ");
				ls111.add("§8Efeito corativo.");
				stackm01111.setDisplayName("§f§lASAS DEMONIACAS");
				stackm01111.setLore(ls111);
				stack01111.setItemMeta(stackm01111);
				i.setItem(21, stack01111);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		p.openInventory(i);
	}
	
	public static void opLocomocao(Player p) {
		Inventory i = Bukkit.createInventory(p, 54, "         §8§nLocomoção");
		
		ItemStack stack01 = new ItemStack(Material.ARROW);
		ItemMeta stackm01 = stack01.getItemMeta();
		List<String> ls = new ArrayList<String>();
		ls.add(" ");
		ls.add(" §a» §7Clique para voltar.");
		ls.add(" ");
		ls.add("§8Item de Navegação.");
		stackm01.setDisplayName("§aVoltar");
		stackm01.setLore(ls);
		stack01.setItemMeta(stackm01);
		i.setItem(48, stack01);
		
		try {
			if(MySQLManager.getRank(p) == 0) {
					@SuppressWarnings("deprecation")
					ItemStack stack01111111 = new ItemStack(Material.getMaterial(351), 1, (short)8);
					ItemMeta stackm01111111 = stack01111111.getItemMeta();
					stackm01111111.setDisplayName("§f§lTHE FLASH");
					List<String> ls04 = new ArrayList<String>();
					ls04.add("§b§m-------------------");
					ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
					ls04.add("§b§m-------------------");
					ls04.add(" ");
					ls04.add("§fDisponível apartir do rank §3§lSTTEY§f.");
					ls04.add("§cVocê não possúi esse item.");
					ls04.add(" ");
					ls04.add("§8Modo de Locomoção.");
					stackm01111111.setLore(ls04);
					stack01111111.setItemMeta(stackm01111111);
					i.setItem(10, stack01111111);
			} else if(MySQLManager.getRank(p) == 1) {
				@SuppressWarnings("deprecation")
				ItemStack stack01111111 = new ItemStack(Material.getMaterial(351), 1, (short)8);
				ItemMeta stackm01111111 = stack01111111.getItemMeta();
				stackm01111111.setDisplayName("§f§lTHE FLASH");
				List<String> ls04 = new ArrayList<String>();
				ls04.add("§b§m-------------------");
				ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
				ls04.add("§b§m-------------------");
				ls04.add(" ");
				ls04.add("§fDisponível apartir do rank §3§lSTTEY§f.");
				ls04.add("§cVocê não possúi esse item.");
				ls04.add(" ");
				ls04.add("§8Modo de Locomoção.");
				stackm01111111.setLore(ls04);
				stack01111111.setItemMeta(stackm01111111);
				i.setItem(10, stack01111111);
		} else if(MySQLManager.getRank(p) == 3) {
			@SuppressWarnings("deprecation")
			ItemStack stack01111111 = new ItemStack(Material.getMaterial(351), 1, (short)8);
			ItemMeta stackm01111111 = stack01111111.getItemMeta();
			stackm01111111.setDisplayName("§f§lTHE FLASH");
			List<String> ls04 = new ArrayList<String>();
			ls04.add("§b§m-------------------");
			ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
			ls04.add("§b§m-------------------");
			ls04.add(" ");
			ls04.add("§fDisponível apartir do rank §3§lSTTEY§f.");
			ls04.add("§cVocê não possúi esse item.");
			ls04.add(" ");
			ls04.add("§8Modo de Locomoção.");
			stackm01111111.setLore(ls04);
			stack01111111.setItemMeta(stackm01111111);
			i.setItem(10, stack01111111);
	} else if(MySQLManager.getRank(p) == 2) {
			@SuppressWarnings("deprecation")
			ItemStack stack01111111 = new ItemStack(Material.getMaterial(351), 1, (short)8);
			ItemMeta stackm01111111 = stack01111111.getItemMeta();
			stackm01111111.setDisplayName("§f§lTHE FLASH");
			List<String> ls04 = new ArrayList<String>();
			ls04.add("§b§m-------------------");
			ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
			ls04.add("§b§m-------------------");
			ls04.add(" ");
			ls04.add("§fDisponível apartir do rank §3§lSTTEY§f.");
			ls04.add("§cVocê não possúi esse item.");
			ls04.add(" ");
			ls04.add("§8Modo de Locomoção.");
			stackm01111111.setLore(ls04);
			stack01111111.setItemMeta(stackm01111111);
			i.setItem(10, stack01111111);
	}else if(MySQLManager.getRank(p) == 4) {
		@SuppressWarnings("deprecation")
		ItemStack stack01111111 = new ItemStack(Material.getMaterial(351), 1, (short)8);
		ItemMeta stackm01111111 = stack01111111.getItemMeta();
		stackm01111111.setDisplayName("§f§lTHE FLASH");
		List<String> ls04 = new ArrayList<String>();
		ls04.add("§b§m-------------------");
		ls04.add("  §6» §f§lINFORMAÇõES §f§6«");
		ls04.add("§b§m-------------------");
		ls04.add(" ");
		ls04.add("§fDisponível apartir do rank §3§lSTTEY§f.");
		ls04.add("§cVocê não possúi esse item.");
		ls04.add(" ");
		ls04.add("§8Modo de Locomoção.");
		stackm01111111.setLore(ls04);
		stack01111111.setItemMeta(stackm01111111);
		i.setItem(10, stack01111111);
} else {
		ItemStack stack011 = new ItemStack(Material.DIAMOND_BOOTS);
		ItemMeta stackm011 = stack011.getItemMeta();
		List<String> ls1 = new ArrayList<String>();
		ls1.add("§b§m-------------------");
		ls1.add("  §6» §f§lINFORMAÇõES §f§6«");
		ls1.add("§b§m-------------------");
		ls1.add(" ");
		ls1.add("§fDisponível apartir do rank §3§lSTTEY§f.");
		ls1.add("§aVocê possúi esse item.");
		ls1.add(" ");
		ls1.add("§8Modo de Locomoção.");
		stackm011.setDisplayName("§f§lTHE FLASH");
		stackm011.setLore(ls1);
		stack011.setItemMeta(stackm011);
		i.setItem(10, stack011);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ItemStack stack01111 = new ItemStack(Material.BOOK_AND_QUILL);
		ItemMeta stackm01111 = stack01111.getItemMeta();
		List<String> ls111 = new ArrayList<String>();
		ls111.add(" ");
		ls111.add(" §7Retire o meio de locomoção");
		ls111.add(" §7que você está usando.");
		ls111.add(" ");
		ls111.add("§8Item de Navegação.");
		stackm01111.setDisplayName("§aRemover Locomoção");
		stackm01111.setLore(ls111);
		stack01111.setItemMeta(stackm01111);
		i.setItem(49, stack01111);
		
		p.openInventory(i);
	}
}