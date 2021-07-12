package me.igormgs;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Difficulty;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockIgniteEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.help.HelpTopic;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.potion.PotionEffectType;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

import me.igormgs.UtilParticle.ParticleType;
import me.igormgs.db.MySQLManager;
import me.igormgs.others.NUIs;
import me.igormgs.wings.AsasAngelicais;
import me.igormgs.wings.AsasAngelicais2;
import me.igormgs.wings.AsasDemoniacas;
import me.igormgs.wings.AsasDemoniacas2;
import me.igormgs.wings.WingData;

public class Eventos implements Listener {
	
	//»«
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void joinevent(PlayerJoinEvent e) throws SQLException {
		Player p = e.getPlayer();
		e.setJoinMessage(null);
		
		p.getInventory().clear();
		p.setMaxHealth(0.5);
		p.setFoodLevel(26);
		p.setExp(-1);
		
		Location loc = new Location(p.getWorld(), 790.5, 5, -281.5);
		p.teleport(loc);
		
		p.getWorld().setDifficulty(Difficulty.PEACEFUL);
		
		p.removePotionEffect(PotionEffectType.SPEED);
		
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("§c§m---§6§m---§e§m---§a§m---§3§m---§b§m---§5§m---§7§m[---]§5§m---§b§m---§3§m---§a§m---§e§m---§6§m---§c§m---§f");
		p.sendMessage(" ");
		p.sendMessage("§fServidores online no momento:");
		p.sendMessage(" ");
		p.sendMessage("§b§lNOVIDADES");
		p.sendMessage(" §a▪ §fSeason §e1 §fDisponível.");
		p.sendMessage(" §a▪ §fServidores de §c§lHARDCOREGAMES §fonline.");
		p.sendMessage(" ");
		p.sendMessage("§6§lPROMOCãO §fem toda nossa §a§lLOJA§f§7.");
		p.sendMessage(" ");
		p.sendMessage("§e§lLOBBY §fConectado ao lobby §a#1");
		p.sendMessage(" ");
		p.sendMessage("§c§m---§6§m---§e§m---§a§m---§3§m---§b§m---§5§m---§7§m[---]§5§m---§b§m---§3§m---§a§m---§e§m---§6§m---§c§m---§f");
		
		ItemStack stack = new ItemStack(Material.EXPLOSIVE_MINECART);
		ItemMeta stack2 = stack.getItemMeta();
		List<String> ls = new ArrayList<String>();
		ls.add("§7");
		ls.add("§7Disfrute de todos os nossos");
		ls.add("§7servidores utilizando este item.");
		ls.add(" ");
		ls.add("§a» §7Clique para interagir.");
		ls.add(" ");
		ls.add("§8Desfrute das opções em nosso menu.");
		stack2.setDisplayName("§7» §a§nMenu Principal§f §7«");
		stack2.setLore(ls);
		stack.setItemMeta(stack2);
		p.getInventory().setItem(4, stack);
		
		Main.scrun.build(e.getPlayer());
		
		try {
			if(MySQLManager.getRank(p) == 0) {
				p.chat("/tag membro");
			}
			if(MySQLManager.getRank(p) == 1) {
				p.chat("/tag vip");
			}
			if(MySQLManager.getRank(p) == 2) {
				p.chat("/tag vipplus");
			}
			if(MySQLManager.getRank(p) == 3) {
				p.chat("/tag pro");
			}
			if(MySQLManager.getRank(p) == 4) {
				p.chat("/tag ultra");
			}
			if(MySQLManager.getRank(p) == 5) {
				p.chat("/tag beta");
			}
			if(MySQLManager.getRank(p) == 6) {
				p.chat("/tag sttey");
			}
			if(MySQLManager.getRank(p) == 7) {
				p.chat("/tag youtuber");
			}
			if(MySQLManager.getRank(p) == 8) {
				p.chat("/tag youtuberplus");
			}
			if(MySQLManager.getRank(p) == 9) {
				p.chat("/tag helper");
			}
			if(MySQLManager.getRank(p) == 10) {
				p.chat("/tag builder");
			}
			if(MySQLManager.getRank(p) == 11) {
				p.chat("/tag trial");
			}
			if(MySQLManager.getRank(p) == 12) {
				p.chat("/tag mod");
			}
			if(MySQLManager.getRank(p) == 13) {
				p.chat("/tag adm");
			}
			if(MySQLManager.getRank(p) == 14) {
				p.chat("/tag ceo");
			}
			if(MySQLManager.getRank(p) == 15) {
				p.chat("/tag cti");
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
		MySQLManager.firstJoinPlayer(p);
		
        p.setGameMode(GameMode.ADVENTURE);
        p.setAllowFlight(true);
        
        Framework.sendTitle(p, "§6§lLOBBY");
        Framework.sendSubTitle(p, "§7Conectado ao Lobby §a#1");
        Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.instace, new Runnable() {
			
			@Override
			public void run() {
		        Framework.sendTitle(p, "§a§lSEASON");
		        Framework.sendSubTitle(p, "§7Season §e1 §7Já disponível.");
			}
		}, 30L);
        
        Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.instace, new Runnable() {
			
			@Override
			public void run() {
		        Framework.sendTitle(p, "§b§lSERVIDORES");
		        Framework.sendSubTitle(p, "§7Servidores de HardcoreGames §aONLINE§7.");
		        Framework.sendTimings(p, 10, 30, 10);
			}
		}, 60L);
        
        Framework.buildTabConstructor(p, "§c§m---§6§m---§e§m---§a§m---§3§m---§b§m---§5§m---§7§m[---]§5§m---§b§m---§3§m---§a§m---§e§m---§6§m---§c§m---§f\n\n§b§lSTTEY §f§lMC\n   §7Bem-vindo ao §aLobby\n", "\n\n§7Site §astteymc.com\n§7Discord §ads.stteymc.com\n\n  §6§lPROMOÇãO §f§7em toda nossa §a§lLOJA§f§7!\nAcesse: §aloja.stteymc.com\n\n§c§m---§6§m---§e§m---§a§m---§3§m---§b§m---§5§m---§7§m[---]§5§m---§b§m---§3§m---§a§m---§e§m---§6§m---§c§m---§f");
        
        if(((CraftPlayer)p).getHandle().playerConnection.networkManager.getVersion() < 47) {
        	try {
				if(MySQLManager.getVerify(p).equalsIgnoreCase("NAO")) {
					p.kickPlayer("§b§lCONEXãO\n\n§7Verificamos que você está utilizando a versão §61.7§7 do minecraft,\n§7Aconselhamos que para você ter uma melhor experiência dentro de nossa\n§7rede, utilize a versão §b1.8§7. Caso queira continuar nesta versão, apenas relogue.\n\n§7Agradecemos pela atenção.\n§7Equipe Sttey.\n\n§7Site §astteymc.com\n§7Discord §ads.stteymc.com");
					MySQLManager.updateVerify(p);
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
        }
	}
	
	
	@EventHandler
	public void leaveevent(PlayerQuitEvent e) throws SQLException {
		e.setQuitMessage(null);
		Player p = e.getPlayer();
		MySQLManager.updateAno(p);
		MySQLManager.updateDia(p);
		MySQLManager.updateDiaDaSemana(p);
		MySQLManager.updateHoras(p);
		MySQLManager.updateMinutos(p);
		MySQLManager.updateMes(p);
		
		Main.getParticles().stopAll(p);
		if(Main.usandoAngelicais.contains(p)) {
			Main.usandoAngelicais.remove(p);
		}
		if(Main.usandoDemoniacas.contains(p)) {
			Main.usandoDemoniacas.remove(p);
		}
		
	}
	
	@EventHandler
	public void dropar(PlayerDropItemEvent e){
		e.setCancelled(true);
	}
	
	@EventHandler
	public void fome(FoodLevelChangeEvent e){
		e.setCancelled(true);
	}
	
	private HashMap<String, Long> timeout = new HashMap<String, Long>();

	@EventHandler
	 public void chat(AsyncPlayerChatEvent e){
	   Player p = e.getPlayer();
	   if ((this.timeout.containsKey(p.getName())) && 
	     (((Long)this.timeout.get(p.getName())).longValue() > System.currentTimeMillis())){
	       p.sendMessage("§a§lCHAT §fAguarde mais alguns segundos para falar no chat novamente. ");
	     e.setCancelled(true);
	     return;
	   }
	   
	   try {
		if(MySQLManager.getMute(p) == 1) {
			   p.sendMessage("§a§lCHAT §fVocê foi MUTADO, portanto não pode falar no chat geral, para comprar unmute, acesse: §awww.stteymc.com/loja§f. ");
			   e.setCancelled(true);
		   }
	} catch (SQLException e1) {
		e1.printStackTrace();
	}
	   
	   try {
		if(MySQLManager.getStatusChat() == 0) {
			 if(MySQLManager.getRank(p) == 0) {
				   e.setFormat(p.getDisplayName() + " §f§7» §f" + e.getMessage());
				   this.timeout.put(p.getName(), Long.valueOf(System.currentTimeMillis() + 2000L));
			   }
			   if(MySQLManager.getRank(p) == 1) {
				   e.setFormat(p.getDisplayName() + " §f§7» §f" + e.getMessage().replace("&", "§"));
				   this.timeout.put(p.getName(), Long.valueOf(System.currentTimeMillis() + 2000L));
			   }
			   if(MySQLManager.getRank(p) == 2) {
				   e.setFormat(p.getDisplayName() + " §f§7» §f" + e.getMessage().replace("&", "§"));
				   this.timeout.put(p.getName(), Long.valueOf(System.currentTimeMillis() + 2000L));
			   }
			   if(MySQLManager.getRank(p) == 3) {
				   e.setFormat(p.getDisplayName() + " §f§7» §f" + e.getMessage().replace("&", "§"));
				   this.timeout.put(p.getName(), Long.valueOf(System.currentTimeMillis() + 2000L));
			   }
			   if(MySQLManager.getRank(p) == 4) {
				   e.setFormat(p.getDisplayName() + " §f§7» §f" + e.getMessage().replace("&", "§"));
				   this.timeout.put(p.getName(), Long.valueOf(System.currentTimeMillis() + 2000L));
			   }
			   if(MySQLManager.getRank(p) == 5) {
				   e.setFormat(p.getDisplayName() + " §f§7» §f" + e.getMessage().replace("&", "§"));
				   this.timeout.put(p.getName(), Long.valueOf(System.currentTimeMillis() + 2000L));
			   }
			   if(MySQLManager.getRank(p) == 6) {
				   e.setFormat(p.getDisplayName() + " §f§7» §f" + e.getMessage().replace("&", "§"));
				   this.timeout.put(p.getName(), Long.valueOf(System.currentTimeMillis() + 2000L));
			   }
			   if(MySQLManager.getRank(p) == 7) {
				   e.setFormat(p.getDisplayName() + " §f§7» §f" + e.getMessage().replace("&", "§"));
				   this.timeout.put(p.getName(), Long.valueOf(System.currentTimeMillis() + 2000L));
			   }
			   if(MySQLManager.getRank(p) == 8) {
				   e.setFormat(p.getDisplayName() + " §f§7» §f" + e.getMessage().replace("&", "§"));
				   this.timeout.put(p.getName(), Long.valueOf(System.currentTimeMillis() + 2000L));
			   }
			   if(MySQLManager.getRank(p) == 9) {
				   e.setFormat(p.getDisplayName() + " §f§7» §f" + e.getMessage().replace("&", "§"));
				   if(MySQLManager.getStatusStaffChat(p) == 1) {
					   e.setCancelled(true);
				   }
			   }
			   if(MySQLManager.getRank(p) == 10) {
				   e.setFormat(p.getDisplayName() + " §f§7» §f" + e.getMessage().replace("&", "§"));
				   if(MySQLManager.getStatusStaffChat(p) == 1) {
					   e.setCancelled(true);
				   }
			   }
			   if(MySQLManager.getRank(p) == 11) {
				   e.setFormat(p.getDisplayName() + " §f§7» §f" + e.getMessage().replace("&", "§"));
				   if(MySQLManager.getStatusStaffChat(p) == 1) {
					   e.setCancelled(true);
				   }
			   }
			   if(MySQLManager.getRank(p) == 12) {
				   e.setFormat(p.getDisplayName() + " §f§7» §f" + e.getMessage().replace("&", "§"));
				   if(MySQLManager.getStatusStaffChat(p) == 1) {
					   e.setCancelled(true);
				   }
			   }
			   if(MySQLManager.getRank(p) == 13) {
				   e.setFormat(p.getDisplayName() + " §f§7» §f" + e.getMessage().replace("&", "§"));
				   if(MySQLManager.getStatusStaffChat(p) == 1) {
					   e.setCancelled(true);
				   }
			   }
			   if(MySQLManager.getRank(p) == 14) {
				   e.setFormat(p.getDisplayName() + " §f§7» §f" + e.getMessage().replace("&", "§"));
				   if(MySQLManager.getStatusStaffChat(p) == 1) {
					   e.setCancelled(true);
				   }
			   }
			   if(MySQLManager.getRank(p) == 15) {
				   e.setFormat(p.getDisplayName() + " §f§7» §f" + e.getMessage().replace("&", "§"));
				   if(MySQLManager.getStatusStaffChat(p) == 1) {
					   e.setCancelled(true);
				   }
			   }
		} else if(MySQLManager.getStatusChat() == 1) {
			if(MySQLManager.getRank(p) == 0) {
				   e.setCancelled(true); 			
				   p.sendMessage("§a§lCHAT §fO Chat encontra-se §c§lDESATIVADO§f.");
			   }
			if(MySQLManager.getRank(p) == 1) {
				   e.setCancelled(true); 			
				   p.sendMessage("§a§lCHAT §fO Chat encontra-se §c§lDESATIVADO§f.");
			   }
			   if(MySQLManager.getRank(p) == 1) {
				   e.setCancelled(true);			
				   p.sendMessage("§a§lCHAT §fO Chat encontra-se §c§lDESATIVADO§f.");
			   }
			   if(MySQLManager.getRank(p) == 2) {
				   e.setCancelled(true);
				   p.sendMessage("§a§lCHAT §fO Chat encontra-se §c§lDESATIVADO§f.");
			   }
			   if(MySQLManager.getRank(p) == 3) {
				   e.setCancelled(true);
				   p.sendMessage("§a§lCHAT §fO Chat encontra-se §c§lDESATIVADO§f.");
			   }
			   if(MySQLManager.getRank(p) == 4) {
				   e.setCancelled(true);
		           p.sendMessage("§a§lCHAT §fO Chat encontra-se §c§lDESATIVADO§f.");
			   }
			   if(MySQLManager.getRank(p) == 5) {
				   e.setCancelled(true);
				   p.sendMessage("§a§lCHAT §fO Chat encontra-se §c§lDESATIVADO§f.");
			   }
			   if(MySQLManager.getRank(p) == 6) {
				   e.setCancelled(true);
				   p.sendMessage("§a§lCHAT §fO Chat encontra-se §c§lDESATIVADO§f.");
			   }
			   if(MySQLManager.getRank(p) == 7) {
				   e.setCancelled(true);
				   p.sendMessage("§a§lCHAT §fO Chat encontra-se §c§lDESATIVADO§f.");
			   }
			   if(MySQLManager.getRank(p) == 8) {
				   e.setCancelled(true);
				   p.sendMessage("§a§lCHAT §fO Chat encontra-se §c§lDESATIVADO§f.");
			   }
			   if(MySQLManager.getRank(p) == 9) {
				   e.setCancelled(true);
				   p.sendMessage("§a§lCHAT §fO Chat encontra-se §c§lDESATIVADO§f.");
			   }
			   if(MySQLManager.getRank(p) == 10) {
				   e.setFormat(p.getDisplayName() + " §f§7» §f" + e.getMessage().replace("&", "§"));
				   if(MySQLManager.getStatusStaffChat(p) == 1) {
					   e.setCancelled(true);
				   }
			   }
			   if(MySQLManager.getRank(p) == 11) {
				   e.setFormat(p.getDisplayName() + " §f§7» §f" + e.getMessage().replace("&", "§"));
				   if(MySQLManager.getStatusStaffChat(p) == 1) {
					   e.setCancelled(true);
				   }
			   }
			   if(MySQLManager.getRank(p) == 12) {
				   e.setFormat(p.getDisplayName() + " §f§7» §f" + e.getMessage().replace("&", "§"));
				   if(MySQLManager.getStatusStaffChat(p) == 1) {
					   e.setCancelled(true);
				   }
			   }
			   if(MySQLManager.getRank(p) == 13) {
				   e.setFormat(p.getDisplayName() + " §f§7» §f" + e.getMessage().replace("&", "§"));
				   if(MySQLManager.getStatusStaffChat(p) == 1) {
					   e.setCancelled(true);
				   }
			   }
			   if(MySQLManager.getRank(p) == 14) {
				   e.setFormat(p.getDisplayName() + " §f§7» §f" + e.getMessage().replace("&", "§"));
				   if(MySQLManager.getStatusStaffChat(p) == 1) {
					   e.setCancelled(true);
				   }
			   }
			   if(MySQLManager.getRank(p) == 15) {
				   e.setFormat(p.getDisplayName() + " §f§7» §f" + e.getMessage().replace("&", "§"));
				   if(MySQLManager.getStatusStaffChat(p) == 1) {
					   e.setCancelled(true);
				   }
			   }
		}
	    } catch (Exception e2) {
		   e2.printStackTrace();
	    }
	 }
	
	@EventHandler
	public void sairDaIlha(PlayerMoveEvent e){
	   Player p = e.getPlayer();
		if(p.getLocation().getBlockY() <= 0){
			p.teleport(p.getWorld().getSpawnLocation());
		}
	}
	
	@EventHandler
	public void colocar(BlockPlaceEvent e){
		Player p = e.getPlayer();
		try {
			if(MySQLManager.getRank(p) >= 10) {
				e.setCancelled(false);
			} else {
				e.setCancelled(true);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	@EventHandler
	public void quebrar(BlockBreakEvent e){
		Player p = e.getPlayer();
		try {
			if(MySQLManager.getRank(p) >= 10) {
				e.setCancelled(false);
			} else {
				e.setCancelled(true);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	@EventHandler
	public void comandoInexistente(PlayerCommandPreprocessEvent e) {
		Player p = e.getPlayer();
		String comando = e.getMessage().split(" ")[0];
		HelpTopic ht = Bukkit.getServer().getHelpMap().getHelpTopic(comando);
		if(ht == null) {
			p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
		    p.sendMessage("§a§lCHAT §fComando não encontrado.");
		    Framework.sendTitle(p, "§4§lERRO");
		    Framework.sendSubTitle(p, "§fComando não registrado.");
			e.setCancelled(true);
		}
	}
 
    @EventHandler
    public void doubleJump(PlayerToggleFlightEvent event) {
        Player p = event.getPlayer();
            if (p.getGameMode() == GameMode.ADVENTURE) {
            	if(!Main.voando.contains(p)) {
                        p.setFlying(false);
                        Location loc = p.getLocation().clone();
                        loc.setPitch(0.0F);
                   
                        p.setVelocity(p.getLocation().getDirection().multiply(1.6D).setY(1.0D));
                        p.getLocation().getWorld().playSound(p.getLocation(), Sound.ENDERDRAGON_WINGS, 1.0F, -5.0F);
                   
                        p.setAllowFlight(false);
                        event.setCancelled(true);
            	}
            }
    }
 
    @EventHandler
    public void doubleJumpMove(PlayerMoveEvent event) {
        Player p = event.getPlayer();
            if (p.getGameMode() == GameMode.ADVENTURE) {
            	if(!Main.voando.contains(p)) {
               		  if(!p.getAllowFlight()) {
                         Location loc = p.getLocation();
                         Block block = loc.getBlock().getRelative(BlockFace.DOWN);
                         if (block.getType() != Material.AIR) {
                             p.setAllowFlight(true);
                         }
            		}
            	}
            }
    }
    
    @EventHandler
    public void pegar(PlayerPickupItemEvent e) {
    	e.setCancelled(true);
    }
	
	@EventHandler
	public void cair(EntityDamageEvent e) {
		e.setCancelled(true);
	}
	
	@EventHandler
	public void spawnmob(EntitySpawnEvent e) {
		e.setCancelled(true);
	}
	
	@EventHandler
	public void AntiPlugin(PlayerCommandPreprocessEvent e) {
	  Player p = e.getPlayer();
	  if (e.getMessage().contains("/pl") || 
	    e.getMessage().contains("/plugins") || 
	    e.getMessage().contains("/plugin") || 
	    e.getMessage().contains("/bukkit:me") || 
	    e.getMessage().contains("/bukkit:?") || 
	    e.getMessage().contains("/ver") || 
	    e.getMessage().contains("/bukkit:pl") || 
	    e.getMessage().contains("/me") || 
	    e.getMessage().contains("/?")) {
	      
	    e.setCancelled(true);
		p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
	    p.sendMessage("§a§lCHAT §fComando não encontrado.");
	    Framework.sendTitle(p, "§4§lERRO");
	    Framework.sendSubTitle(p, "§fComando não registrado.");
	  } 
	}
	
	@EventHandler
	public void interagir(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if(p.getItemInHand().getType() == Material.EXPLOSIVE_MINECART) {
			NUIs.opMenuPrincipal(p);
			p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
		}
	}
	
	@EventHandler
	public void theflash(BlockIgniteEvent e) {
		e.setCancelled(true);
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void interagirComNUI(InventoryClickEvent e) {
		Inventory  i = e.getInventory();
		Player p = (Player)e.getWhoClicked();
		e.setCancelled(true);
		if ((e.getCurrentItem() != null) && (e.getCurrentItem().getItemMeta() != null)) {
			if(i.getTitle().contains("§8§nMenu Principal")) {
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§b§n§lPREFERêNCIAS§f")) {
					NUIs.opPreferencias(p);
					p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1.0F, 1.0F);
				}
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§b§n§lSERVIDORES§f")) {
					if(e.getClick() == ClickType.LEFT) {
						NUIs.opServidores(p);
						p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1.0F, 1.0F);
					} else if(e.getClick() == ClickType.RIGHT) {
						p.closeInventory();
						p.sendMessage("§e§lINFO §fConectando...");
					}
				}
				
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§b§n§lCOLECIONáVEIS§f")) {
					NUIs.opCole(p);
					p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1.0F, 1.0F);
				}
				
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§b§n§lPERFIL§f")) {
					NUIs.opPerfil(p);
					p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1.0F, 1.0F);
				}
			}
			
			if(i.getTitle().contains("§a§nHardcoreGames")) {
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aVoltar")) {
					NUIs.opServidores(p);
					p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1.0F, 1.0F);
				}
				
				CapturarPing ping = new CapturarPing("localhost", 25582);
				
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aVer estatísticas")) {
				     p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1.0F, 1.0F);
				     NUIs.opPerfil(p);
				}
				
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§f§lHGA1")) {
					if(ping.pegarMotd().contains("Aguardando")) {
						p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
						p.sendMessage("§e§lCONECXãO §fAguarde, você será redirecionado ao servidor §a§lHG-A1§f.");
						Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.instace, new Runnable() {
							
							@Override
							public void run() {
						        ByteArrayDataOutput out = ByteStreams.newDataOutput();
						        out.writeUTF("Connect");
						        out.writeUTF("HGA1");
						        p.sendPluginMessage(Main.instace, "BungeeCord", out.toByteArray());
							}
						}, 20L);
					}
				}
				
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§f§lHGA2")) {
					if(ping.pegarMotd().contains("Aguardando")) {
						p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
						p.sendMessage("§e§lCONECXãO §fAguarde, você será redirecionado ao servidor §a§lHG-A2§f.");
						Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.instace, new Runnable() {
							
							@Override
							public void run() {
						        ByteArrayDataOutput out = ByteStreams.newDataOutput();
						        out.writeUTF("Connect");
						        out.writeUTF("HGA2");
						        p.sendPluginMessage(Main.instace, "BungeeCord", out.toByteArray());
							}
						}, 20L);
					}
				}
				
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§f§lHGA3")) {
					if(ping.pegarMotd().contains("Aguardando")) {
						p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
						p.sendMessage("§e§lCONECXãO §fAguarde, você será redirecionado ao servidor §a§lHG-A3§f.");
						Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.instace, new Runnable() {
							
							@Override
							public void run() {
						        ByteArrayDataOutput out = ByteStreams.newDataOutput();
						        out.writeUTF("Connect");
						        out.writeUTF("HGA3");
						        p.sendPluginMessage(Main.instace, "BungeeCord", out.toByteArray());
							}
						}, 20L);
					}
			   }
			}
			
			if(i.getTitle().contains("§8§nPerfil")) {
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aEstatísticas")) {
					p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1.0F, 1.0F);
					NUIs.opEstatisticas(p);
				}
				
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aVoltar")) {
					NUIs.opPerfil(p);
					p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1.0F, 1.0F);
				}
			}
			
			
			if(i.getTitle().contains("§8§nServidores")) {
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§f§lKITPVP")) {
					p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
					p.sendMessage("§e§lCONECXãO §fEste servidor encontra-se §c§lOFFLINE§f.");
					p.closeInventory();
				}
				
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§f§lRANK UP")) {
					p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
					p.sendMessage("§e§lCONECXãO §fEste servidor encontra-se §c§lOFFLINE§f.");
					p.closeInventory();
				}
				
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§f§lFACTIONS")) {
					p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
					p.sendMessage("§e§lCONECXãO §fEste servidor encontra-se §c§lOFFLINE§f.");
					p.closeInventory();
				}
				
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§f§lSKYWARS")) {
					p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
					p.sendMessage("§e§lCONECXãO §fEste servidor encontra-se §c§lOFFLINE§f.");
					p.closeInventory();
				}
				
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§f§lHARDCOREGAMES")) {
					p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1.0F, 1.0F);
					NUIs.opHG(p);
				}
				
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aVoltar")) {
					NUIs.opMenuPrincipal(p);
					p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1.0F, 1.0F);
				}
			}
			
			if(i.getTitle().contains("§8§nEstatísticas")) {
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aVoltar")) {
					NUIs.opPerfil(p);
					p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1.0F, 1.0F);
				}
			}
			
			if(i.getTitle().contains("§8§nPerfil")) {
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aVoltar")) {
					NUIs.opMenuPrincipal(p);
					p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1.0F, 1.0F);
				}
				
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aPreferências")) {
					NUIs.opPreferencias(p);
					p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1.0F, 1.0F);
				}
			}
			
			if(i.getTitle().contains("§8§nPreferências")) {
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aVoltar")) {
					NUIs.opMenuPrincipal(p);
					p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1.0F, 1.0F);
				}
				
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Sobre")) {
					try {
						if(MySQLManager.getStatusTell(p) == 0) {
							i.setItem(22, null);
							p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1.0F, 1.0F);
							
							Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.instace, new Runnable() {
								@Override
								public void run() {
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
							}, 2L);
							
							MySQLManager.updateTell(p, 1);
							
						} else if(MySQLManager.getStatusTell(p) == 1) {
							
							i.setItem(22, null);
							p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1.0F, 1.0F);
							
							Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.instace, new Runnable() {
								
								@Override
								public void run() {
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
							}, 2L);
							
							MySQLManager.updateTell(p, 0);
							
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
			
			if(i.getTitle().contains("§8§nColecionáveis")) {
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aVoltar")) {
					NUIs.opMenuPrincipal(p);
					p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1.0F, 1.0F);
				}
				
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aCabeças")) {
					NUIs.opCabecas(p);
					p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1.0F, 1.0F);
				}
				
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aEfeitos")) {
					NUIs.opEfeitos(p);
					p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1.0F, 1.0F);
				}
				
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aLocomoção")) {
					NUIs.opLocomocao(p);
					p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1.0F, 1.0F);
				}
			}
			
			if(i.getTitle().contains("§8§nLocomoção")) {
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§f§lTHE FLASH")) {
					  p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
			    	  p.closeInventory();
			    	  Framework.onTheFlash(p);
				}
				
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aVoltar")) {
					NUIs.opCole(p);
					p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1.0F, 1.0F);
				}
				
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aRemover Locomoção")) {
					if(Main.TheFlash.contains(p)) {
						  p.removePotionEffect(PotionEffectType.SPEED);
						  p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
					      Main.TheFlash.remove(p);
					        
					      p.getInventory().setBoots(null);
					      p.getInventory().setHelmet(null);
							p.sendMessage("§a§lLOCALIZAÇãO §fEfeito The Flash retirado.");
							p.closeInventory();
					} else {
						p.sendMessage("§a§lLOCOMOÇãO §fVocê não está usando nenhum item de locomoção.");
						 p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
							p.closeInventory();
					}
				}
			}
			
			if(i.getTitle().contains("§8§nEfeitos")) {
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aVoltar")) {
					NUIs.opCole(p);
					p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1.0F, 1.0F);
				}
				
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§f§lCABEÇA QUENTE")) {
					if(!Main.getParticles().hasEffect(p)) {
						Main.getParticles().rorationEffect(p, ParticleEffect.LAVA);
						p.sendMessage("§a§lEFEITOS §fEfeito §eCabeça Quente §faplicado.");
						p.closeInventory();
						p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
						Framework.sendTitle(p, "§a§lEFEITO");
						Framework.sendSubTitle(p, "§fEfeito aplicado.");
					}
				}
				
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§f§lAPAIXONADO")) {
					if(!Main.getParticles().hasEffect(p)) {
						Main.getParticles().radarEffect(p, me.igormgs.ParticleEffect.HEART);
						p.closeInventory();
						p.sendMessage("§a§lEFEITOS §fEfeito §eApaixonado §faplicado.");
						p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
						Framework.sendTitle(p, "§a§lEFEITO");
						Framework.sendSubTitle(p, "§fEfeito aplicado.");
					}
				}
				
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§f§lANEL DE AGUA")) {
					if(!Main.getParticles().hasEffect(p)) {
						Main.getParticles().radarEffect(p, me.igormgs.ParticleEffect.DRIP_WATER);
						p.closeInventory();
						p.sendMessage("§a§lEFEITOS §fEfeito §eAnel e Agua §faplicado.");
						p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
						Framework.sendTitle(p, "§a§lEFEITO");
						Framework.sendSubTitle(p, "§fEfeito aplicado.");
					}
				}
				
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§f§lANEL DE MAGMA")) {
					if(!Main.getParticles().hasEffect(p)) {
						Main.getParticles().radarEffect(p, me.igormgs.ParticleEffect.DRIP_LAVA);
						p.closeInventory();
						p.sendMessage("§a§lEFEITOS §fEfeito §eAnel e Magma §faplicado.");
						p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
						Framework.sendTitle(p, "§a§lEFEITO");
						Framework.sendSubTitle(p, "§fEfeito aplicado.");
					}
				}
				
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§f§lCÚPULA VERMELHA")) {
					if(!Main.getParticles().hasEffect(p)) {
						Main.getParticles().circleOfParticles(p, ParticleEffect.REDSTONE);
						p.closeInventory();
						p.sendMessage("§a§lEFEITOS §fEfeito §eCúpula Vermelha §faplicado.");
						p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
						Framework.sendTitle(p, "§a§lEFEITO");
						Framework.sendSubTitle(p, "§fEfeito aplicado.");
					}
				}
				
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§f§lROTAÇãO AQUÁTICA")) {
					if(!Main.getParticles().hasEffect(p)) {
						Main.getParticles().spiraleEffect(p, ParticleEffect.DRIP_WATER);
						p.closeInventory();
						p.sendMessage("§a§lEFEITOS §fEfeito §eRotação Aquática §faplicado.");
						p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
						Framework.sendTitle(p, "§a§lEFEITO");
						Framework.sendSubTitle(p, "§fEfeito aplicado.");
					}
				}
				
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§f§lHELIX DE FOGO")) {
					if(!Main.getParticles().hasEffect(p)) {
						Main.getParticles().startHelix(p, ParticleType.FLAME);
						p.closeInventory();
						p.sendMessage("§a§lEFEITOS §fEfeito §eHelix De Fogo §faplicado.");
						p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
						Framework.sendTitle(p, "§a§lEFEITO");
						Framework.sendSubTitle(p, "§fEfeito aplicado.");
					}
				}
				
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§f§lANEL §c§lC§6§lO§e§lL§a§lO§3§lR§b§lI§5§lD§c§lO")) {
					if(!Main.getParticles().hasEffect(p)) {
						Main.getParticles().spiraleEffect(p, ParticleEffect.REDSTONE);
						p.closeInventory();
						p.sendMessage("§a§lEFEITOS §fEfeito §eAnel Colorido §faplicado.");
						p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
						Framework.sendTitle(p, "§a§lEFEITO");
						Framework.sendSubTitle(p, "§fEfeito aplicado.");
					}
				}
				
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§f§lASAS DEMONIACAS")) {
					if(!Main.usandoAngelicais.contains(p)) {
						AsasDemoniacas2 demon1 = new AsasDemoniacas2(p.getUniqueId());
						AsasDemoniacas demon = new AsasDemoniacas();
						WingData demondata = new WingData(p, 0);
						if(!Main.usandoDemoniacas.contains(p)) {
							Main.usandoDemoniacas.add(p);
							Bukkit.getScheduler().scheduleAsyncRepeatingTask(Main.instace, new Runnable() {
								
								@Override
								public void run() {
									if(Main.usandoDemoniacas.contains(p)) {
										demon1.onUpdate(p);
										demon.display(p, demondata);
									}
								}
							}, 2L, 2L);
							p.sendMessage("§a§lEFEITOS §fEfeito §eAsas Demoniacas §faplicado.");
							p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
							Framework.sendTitle(p, "§a§lEFEITO");
							Framework.sendSubTitle(p, "§fEfeito aplicado.");
							p.closeInventory();
						}
					} else {
						p.closeInventory();
						p.sendMessage("§a§lEFEITOS §fRetire o efeito que você está usando, para após utilizar este.");
					}
				}
				
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§f§lASAS ANGELICAIS")) {
					if(!Main.usandoDemoniacas.contains(p)) {
						if(!Main.usandoAngelicais.contains(p)) {
							AsasAngelicais2 angel1 = new AsasAngelicais2(p.getUniqueId());
							AsasAngelicais angel = new AsasAngelicais();
							WingData angeldata = new WingData(p, 1);
							Main.usandoAngelicais.add(p);
							Bukkit.getScheduler().scheduleAsyncRepeatingTask(Main.instace, new Runnable() {
								
								@Override
								public void run() {
									if(Main.usandoAngelicais.contains(p)) {
										angel1.onUpdate(p);
										angel.display(p, angeldata);
									}
								}
							}, 2L, 2L);
							p.closeInventory();
							p.sendMessage("§a§lEFEITOS §fEfeito §eAsas de Borboleta §faplicado.");
							p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
							Framework.sendTitle(p, "§a§lEFEITO");
							Framework.sendSubTitle(p, "§fEfeito aplicado.");
						}
					} else {
						p.closeInventory();
						p.sendMessage("§a§lEFEITOS §fRetire o efeito que você está usando, para após utilizar este.");
					}
				}
				
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aRemover Efeito")) {
					p.closeInventory();
					Main.getParticles().stopAll(p);
					Main.usandoAngelicais.remove(p);
					Main.usandoDemoniacas.remove(p);
					p.sendMessage("§a§lEFEITOS §fEfeitos removidos.");
				}
				
				if(e.getCurrentItem().getType() == Material.getMaterial(351)) {
					p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
					p.closeInventory();
					p.sendMessage("§a§lCABEÇAS §fVocê não possúi esse efeito.");
					Framework.sendTitle(p, "§a§lEFEITO");
					Framework.sendSubTitle(p, "§fVocê não possúi esse efeito.");
				}
			}
			
			if(i.getTitle().contains("§8§nCabeças")) {
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aVoltar")) {
					NUIs.opCole(p);
					p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1.0F, 1.0F);
				}
				
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aRemover Cabeça")) {
					
					if(p.getInventory().getHelmet() == null) {
						p.closeInventory();
						p.sendMessage("§a§lCABEÇAS §fVocê não está usando nenhuma cabeça.");
						p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
					} else if(p.getInventory().getHelmet().getItemMeta().getDisplayName().equalsIgnoreCase("§f§lHOMEM DE FERRO")) {
						p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
						p.getInventory().setHelmet(null);
						p.closeInventory();
						p.sendMessage("§a§lCABEÇAS §fCabeça §eHomem de Ferro §fretirada.");
					} else if(p.getInventory().getHelmet().getItemMeta().getDisplayName().equalsIgnoreCase("§f§lHULK")) {
						p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
						p.getInventory().setHelmet(null);
						p.closeInventory();
						p.sendMessage("§a§lCABEÇAS §fCabeça §eHulk §fretirada.");
					} else if(p.getInventory().getHelmet().getItemMeta().getDisplayName().equalsIgnoreCase("§f§lCAPITãO AMERICA")) {
						p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
						p.getInventory().setHelmet(null);
						p.closeInventory();
						p.sendMessage("§a§lCABEÇAS §fCabeça §eCapitão America §fretirada.");
					} else if(p.getInventory().getHelmet().getItemMeta().getDisplayName().equalsIgnoreCase("§f§lHOMEM ARANHA")) {
						p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
						p.getInventory().setHelmet(null);
						p.closeInventory();
						p.sendMessage("§a§lCABEÇAS §fCabeça §eHomem Aranha §fretirada.");
					} else if(p.getInventory().getHelmet().getItemMeta().getDisplayName().equalsIgnoreCase("§f§lBATMAN")) {
						p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
						p.getInventory().setHelmet(null);
						p.closeInventory();
						p.sendMessage("§a§lCABEÇAS §fCabeça §eBatman §fretirada.");
					} else if(p.getInventory().getHelmet().getItemMeta().getDisplayName().equalsIgnoreCase("§f§lFLASH")) {
						p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
						p.getInventory().setHelmet(null);
						p.closeInventory();
						p.sendMessage("§a§lCABEÇAS §fCabeça §eFlash §fretirada.");
					} else if(p.getInventory().getHelmet().getItemMeta().getDisplayName().equalsIgnoreCase("§f§lLANTERNA VERDE")) {
						p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
						p.getInventory().setHelmet(null);
						p.closeInventory();
						p.sendMessage("§a§lCABEÇAS §fCabeça §eLanterna Verde §fretirada.");
					} else if(p.getInventory().getHelmet().getItemMeta().getDisplayName().equalsIgnoreCase("§f§lSKULL TROOPER (FORTNITE)")) {
						p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
						p.getInventory().setHelmet(null);
						p.closeInventory();
						p.sendMessage("§a§lCABEÇAS §fCabeça §eSkull Trooper §fretirada.");
					} else if(p.getInventory().getHelmet().getItemMeta().getDisplayName().equalsIgnoreCase("§f§lCABEÇA DE TOMATE (FORTNITE)")) {
						p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
						p.getInventory().setHelmet(null);
						p.closeInventory();
						p.sendMessage("§a§lCABEÇAS §fCabeça §eCabeça De Tomate §fretirada.");
					} else if(p.getInventory().getHelmet().getItemMeta().getDisplayName().equalsIgnoreCase("§f§lLÍDER DA EQUIPE DE ABRAÇOS (FORTNITE)")) {
						p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
						p.getInventory().setHelmet(null);
						p.closeInventory();
						p.sendMessage("§a§lCABEÇAS §fCabeça §eLíder da equipe de abraços §fretirada.");
					} else if(p.getInventory().getHelmet().getItemMeta().getDisplayName().equalsIgnoreCase("§f§lFISHSTICK (FORTNITE)")) {
						p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
						p.getInventory().setHelmet(null);
						p.closeInventory();
						p.sendMessage("§a§lCABEÇAS §fCabeça §eFishstick §fretirada.");
					} else if(p.getInventory().getHelmet().getItemMeta().getDisplayName().equalsIgnoreCase("§f§lDEADPOOL")) {
						p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
						p.getInventory().setHelmet(null);
						p.closeInventory();
						p.sendMessage("§a§lCABEÇAS §fCabeça §eDeadpool §fretirada.");
					} else if(p.getInventory().getHelmet().getItemMeta().getDisplayName().equalsIgnoreCase("§f§lVENOM")) {
						p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
						p.getInventory().setHelmet(null);
						p.closeInventory();
						p.sendMessage("§a§lCABEÇAS §fCabeça §eVenom §fretirada.");
					} else if(p.getInventory().getHelmet().getItemMeta().getDisplayName().equalsIgnoreCase("§f§lTHOR")) {
						p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
						p.getInventory().setHelmet(null);
						p.closeInventory();
						p.sendMessage("§a§lCABEÇAS §fCabeça §eThor §fretirada.");
					} else if(p.getInventory().getHelmet().getItemMeta().getDisplayName().equalsIgnoreCase("§f§lSTAN-LEE")) {
						p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
						p.getInventory().setHelmet(null);
						p.closeInventory();
						p.sendMessage("§a§lCABEÇAS §fCabeça §eStan-lee §fretirada.");
					} else if(p.getInventory().getHelmet().getItemMeta().getDisplayName().equalsIgnoreCase("§f§lCORINGA")) {
						p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
						p.getInventory().setHelmet(null);
						p.closeInventory();
						p.sendMessage("§a§lCABEÇAS §fCabeça §eCoringa §fretirada.");
					} else if(p.getInventory().getHelmet().getItemMeta().getDisplayName().equalsIgnoreCase("§f§lROBIN")) {
						p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
						p.getInventory().setHelmet(null);
						p.closeInventory();
						p.sendMessage("§a§lCABEÇAS §fCabeça §eRObin §fretirada.");
					} else if(p.getInventory().getHelmet().getItemMeta().getDisplayName().equalsIgnoreCase("§f§lTHANOS")) {
						p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
						p.getInventory().setHelmet(null);
						p.closeInventory();
						p.sendMessage("§a§lCABEÇAS §fCabeça §eThanos §fretirada.");
					} else if(p.getInventory().getHelmet().getItemMeta().getDisplayName().equalsIgnoreCase("§f§lMINION")) {
						p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
						p.getInventory().setHelmet(null);
						p.closeInventory();
						p.sendMessage("§a§lCABEÇAS §fCabeça §eMinion §fretirada.");
					} else if(p.getInventory().getHelmet().getItemMeta().getDisplayName().equalsIgnoreCase("§f§lPIKACHU")) {
						p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
						p.getInventory().setHelmet(null);
						p.closeInventory();
						p.sendMessage("§a§lCABEÇAS §fCabeça §ePikachu §fretirada.");
					}
				}
				
				if(e.getCurrentItem().getType() == Material.getMaterial(351)) {
					p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
					p.closeInventory();
					p.sendMessage("§a§lCABEÇAS §fVocê não possúi essa cabeça.");
				}
				
				if(e.getCurrentItem().getType() == Material.SKULL_ITEM) {
					if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§f§lTHANOS")) {
						p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
						p.closeInventory();
						p.sendMessage("§a§lCABEÇAS §fCabeça §eThanos§f aplicada.");
						
					    ItemStack skullItem = new ItemStack(Material.SKULL_ITEM);
					    skullItem.setDurability((short)3);
					    SkullMeta skullMeta = (SkullMeta)skullItem.getItemMeta();
					    skullMeta.setOwner("1337raw");
					    skullMeta.setDisplayName("§f§lTHANOS");
				        skullItem.setItemMeta(skullMeta);
						
						p.getInventory().setHelmet(skullItem);
					} else if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§f§lHOMEM DE FERRO")) {
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
								p.closeInventory();
								p.sendMessage("§a§lCABEÇAS §fCabeça §eHomem de Ferro§f aplicada.");
								
							    ItemStack skullItem = new ItemStack(Material.SKULL_ITEM);
							    skullItem.setDurability((short)3);
							    SkullMeta skullMeta = (SkullMeta)skullItem.getItemMeta();
							    skullMeta.setOwner("IronMan");
							    skullMeta.setDisplayName("§f§lHOMEM DE FERRO");
						        skullItem.setItemMeta(skullMeta);
								
								p.getInventory().setHelmet(skullItem);
							} else if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§f§lHOMEM DE FERRO")) {
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
								p.closeInventory();
								p.sendMessage("§a§lCABEÇAS §fCabeça §eHomem de Ferro§f aplicada.");
								
							    ItemStack skullItem = new ItemStack(Material.SKULL_ITEM);
							    skullItem.setDurability((short)3);
							    SkullMeta skullMeta = (SkullMeta)skullItem.getItemMeta();
							    skullMeta.setOwner("IronMan");
							    skullMeta.setDisplayName("§f§lHOMEM DE FERRO");
						        skullItem.setItemMeta(skullMeta);
								
								p.getInventory().setHelmet(skullItem);
							} else if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§f§lROBIN")) {
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
								p.closeInventory();
								p.sendMessage("§a§lCABEÇAS §fCabeça §eRobin§f aplicada.");
								
							    ItemStack skullItem = new ItemStack(Material.SKULL_ITEM);
							    skullItem.setDurability((short)3);
							    SkullMeta skullMeta = (SkullMeta)skullItem.getItemMeta();
							    skullMeta.setOwner("Hamsek");
							    skullMeta.setDisplayName("§f§lROBIN");
						        skullItem.setItemMeta(skullMeta);
								
								p.getInventory().setHelmet(skullItem);
							} else if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§f§lCORINGA")) {
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
								p.closeInventory();
								p.sendMessage("§a§lCABEÇAS §fCabeça §eCoringa§f aplicada.");
								
							    ItemStack skullItem = new ItemStack(Material.SKULL_ITEM);
							    skullItem.setDurability((short)3);
							    SkullMeta skullMeta = (SkullMeta)skullItem.getItemMeta();
							    skullMeta.setOwner("abdal3000");
							    skullMeta.setDisplayName("§f§lCORINGA");
						        skullItem.setItemMeta(skullMeta);
								
								p.getInventory().setHelmet(skullItem);
							} else if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§f§lHULK")) {
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
								p.closeInventory();
								p.sendMessage("§a§lCABEÇAS §fCabeça §eHulk§f aplicada.");
								
							    ItemStack skullItem = new ItemStack(Material.SKULL_ITEM);
							    skullItem.setDurability((short)3);
							    SkullMeta skullMeta = (SkullMeta)skullItem.getItemMeta();
							    skullMeta.setOwner("Hulk");
							    skullMeta.setDisplayName("§f§lHULK");
						        skullItem.setItemMeta(skullMeta);
								
								p.getInventory().setHelmet(skullItem);
							} else if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§f§lCAPITãO AMERICA")) {
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
								p.closeInventory();
								p.sendMessage("§a§lCABEÇAS §fCabeça §eCapitão America§f aplicada.");
								
							    ItemStack skullItem = new ItemStack(Material.SKULL_ITEM);
							    skullItem.setDurability((short)3);
							    SkullMeta skullMeta = (SkullMeta)skullItem.getItemMeta();
							    skullMeta.setOwner("Avengers");
							    skullMeta.setDisplayName("§f§lCAPITãO AMERICA");
						        skullItem.setItemMeta(skullMeta);
								
								p.getInventory().setHelmet(skullItem);
							} else if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§f§lHOMEM ARANHA")) {
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
								p.closeInventory();
								p.sendMessage("§a§lCABEÇAS §fCabeça §eHomem Aranha§f aplicada.");
								
							    ItemStack skullItem = new ItemStack(Material.SKULL_ITEM);
							    skullItem.setDurability((short)3);
							    SkullMeta skullMeta = (SkullMeta)skullItem.getItemMeta();
							    skullMeta.setOwner("0lder");
							    skullMeta.setDisplayName("§f§lHOMEM ARANHA");
						        skullItem.setItemMeta(skullMeta);
								
								p.getInventory().setHelmet(skullItem);
							} else if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§f§lBATMAN")) {
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
								p.closeInventory();
								p.sendMessage("§a§lCABEÇAS §fCabeça §eBatman§f aplicada.");
								
							    ItemStack skullItem = new ItemStack(Material.SKULL_ITEM);
							    skullItem.setDurability((short)3);
							    SkullMeta skullMeta = (SkullMeta)skullItem.getItemMeta();
							    skullMeta.setOwner("Abalone");
							    skullMeta.setDisplayName("§f§lBATMAN");
						        skullItem.setItemMeta(skullMeta);
								
								p.getInventory().setHelmet(skullItem);
							} else if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§f§lFLASH")) {
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
								p.closeInventory();
								p.sendMessage("§a§lCABEÇAS §fCabeça §eFlash§f aplicada.");
								
							    ItemStack skullItem = new ItemStack(Material.SKULL_ITEM);
							    skullItem.setDurability((short)3);
							    SkullMeta skullMeta = (SkullMeta)skullItem.getItemMeta();
							    skullMeta.setOwner("XXl_V2");
							    skullMeta.setDisplayName("§f§lFLASH");
						        skullItem.setItemMeta(skullMeta);
								
								p.getInventory().setHelmet(skullItem);
							} else if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§f§lLANTERNA VERDE")) {
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
								p.closeInventory();
								p.sendMessage("§a§lCABEÇAS §fCabeça §eLanterna Verde§f aplicada.");
								
							    ItemStack skullItem = new ItemStack(Material.SKULL_ITEM);
							    skullItem.setDurability((short)3);
							    SkullMeta skullMeta = (SkullMeta)skullItem.getItemMeta();
							    skullMeta.setOwner("8bitUmpire");
							    skullMeta.setDisplayName("§f§lLANTERNA VERDE");
						        skullItem.setItemMeta(skullMeta);
								
								p.getInventory().setHelmet(skullItem);
							} else if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§f§lSKULL TROOPER (FORTNITE)")) {
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
								p.closeInventory();
								p.sendMessage("§a§lCABEÇAS §fCabeça §eSkull Trooper§f aplicada.");
								
							    ItemStack skullItem = new ItemStack(Material.SKULL_ITEM);
							    skullItem.setDurability((short)3);
							    SkullMeta skullMeta = (SkullMeta)skullItem.getItemMeta();
							    skullMeta.setOwner("CheddarDucks");
							    skullMeta.setDisplayName("§f§lSKULL TROOPER (FORTNITE)");
						        skullItem.setItemMeta(skullMeta);
								
								p.getInventory().setHelmet(skullItem);
							} else if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§f§lCABEÇA DE TOMATE (FORTNITE)")) {
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
								p.closeInventory();
								p.sendMessage("§a§lCABEÇAS §fCabeça §eCabeça de Tomate§f aplicada.");
								
							    ItemStack skullItem = new ItemStack(Material.SKULL_ITEM);
							    skullItem.setDurability((short)3);
							    SkullMeta skullMeta = (SkullMeta)skullItem.getItemMeta();
							    skullMeta.setOwner("11ZayZay11");
							    skullMeta.setDisplayName("§f§lCABEÇA DE TOMATE (FORTNITE)");
						        skullItem.setItemMeta(skullMeta);
								
								p.getInventory().setHelmet(skullItem);
							} else if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§f§lLÍDER DA EQUIPE DE ABRAÇOS (FORTNITE)")) {
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
								p.closeInventory();
								p.sendMessage("§a§lCABEÇAS §fCabeça §eLíder da Equipe de Abraços§f aplicada.");
								
							    ItemStack skullItem = new ItemStack(Material.SKULL_ITEM);
							    skullItem.setDurability((short)3);
							    SkullMeta skullMeta = (SkullMeta)skullItem.getItemMeta();
							    skullMeta.setOwner("Blacksmyth");
							    skullMeta.setDisplayName("§f§lLÍDER DA EQUIPE DE ABRAÇOS (FORTNITE)");
						        skullItem.setItemMeta(skullMeta);
								
								p.getInventory().setHelmet(skullItem);
							} else if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§f§lFISHSTICK (FORTNITE)")) {
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
								p.closeInventory();
								p.sendMessage("§a§lCABEÇAS §fCabeça §eFishstick§f aplicada.");
								
							    ItemStack skullItem = new ItemStack(Material.SKULL_ITEM);
							    skullItem.setDurability((short)3);
							    SkullMeta skullMeta = (SkullMeta)skullItem.getItemMeta();
							    skullMeta.setOwner("012345678910");
							    skullMeta.setDisplayName("§f§lFISHSTICK (FORTNITE)");
						        skullItem.setItemMeta(skullMeta);
								
								p.getInventory().setHelmet(skullItem);
							} else if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§f§lDEADPOOL")) {
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
								p.closeInventory();
								p.sendMessage("§a§lCABEÇAS §fCabeça §eDeadpool§f aplicada.");
								
							    ItemStack skullItem = new ItemStack(Material.SKULL_ITEM);
							    skullItem.setDurability((short)3);
							    SkullMeta skullMeta = (SkullMeta)skullItem.getItemMeta();
							    skullMeta.setOwner("Bongo6");
							    skullMeta.setDisplayName("§f§lDEADPOOL");
						        skullItem.setItemMeta(skullMeta);
								
								p.getInventory().setHelmet(skullItem);
							} else if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§f§lVENOM")) {
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
								p.closeInventory();
								p.sendMessage("§a§lCABEÇAS §fCabeça §eVenom§f aplicada.");
								
							    ItemStack skullItem = new ItemStack(Material.SKULL_ITEM);
							    skullItem.setDurability((short)3);
							    SkullMeta skullMeta = (SkullMeta)skullItem.getItemMeta();
							    skullMeta.setOwner("3AKOMBIL");
							    skullMeta.setDisplayName("§f§lVENOM");
						        skullItem.setItemMeta(skullMeta);
								
								p.getInventory().setHelmet(skullItem);
							} else if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§f§lTHOR")) {
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
								p.closeInventory();
								p.sendMessage("§a§lCABEÇAS §fCabeça §eThor§f aplicada.");
								
							    ItemStack skullItem = new ItemStack(Material.SKULL_ITEM);
							    skullItem.setDurability((short)3);
							    SkullMeta skullMeta = (SkullMeta)skullItem.getItemMeta();
							    skullMeta.setOwner("__KWONJIYONG__");
							    skullMeta.setDisplayName("§f§lTHOR");
						        skullItem.setItemMeta(skullMeta);
								
								p.getInventory().setHelmet(skullItem);
							} else if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§f§lSTAN-LEE")) {
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
								p.closeInventory();
								p.sendMessage("§a§lCABEÇAS §fCabeça §eStan-lee§f aplicada.");
								
							    ItemStack skullItem = new ItemStack(Material.SKULL_ITEM);
							    skullItem.setDurability((short)3);
							    SkullMeta skullMeta = (SkullMeta)skullItem.getItemMeta();
							    skullMeta.setOwner("3u8");
							    skullMeta.setDisplayName("§f§lSTAN-LEE");
						        skullItem.setItemMeta(skullMeta);
								
								p.getInventory().setHelmet(skullItem);
			 				} else if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§f§lMINION")) {
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
								p.closeInventory();
								p.sendMessage("§a§lCABEÇAS §fCabeça §eMinion§f aplicada.");
								
							    ItemStack skullItem = new ItemStack(Material.SKULL_ITEM);
							    skullItem.setDurability((short)3);
							    SkullMeta skullMeta = (SkullMeta)skullItem.getItemMeta();
							    skullMeta.setOwner("05Martiniii");
							    skullMeta.setDisplayName("§f§lMINION");
						        skullItem.setItemMeta(skullMeta);
								
								p.getInventory().setHelmet(skullItem);
			 				} else if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§f§lPIKACHU")) {
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
								p.closeInventory();
								p.sendMessage("§a§lCABEÇAS §fCabeça §ePikachu§f aplicada.");
								
							    ItemStack skullItem = new ItemStack(Material.SKULL_ITEM);
							    skullItem.setDurability((short)3);
							    SkullMeta skullMeta = (SkullMeta)skullItem.getItemMeta();
							    skullMeta.setOwner("05Pikachu");
							    skullMeta.setDisplayName("§f§lPIKACHU");
						        skullItem.setItemMeta(skullMeta);
								
								p.getInventory().setHelmet(skullItem);
			 				}
			     	}
			}
		}
	}
}