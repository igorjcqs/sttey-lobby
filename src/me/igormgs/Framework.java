package me.igormgs;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.SQLException;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.spigotmc.ProtocolInjector;

import me.igormgs.db.MySQLManager;
import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;
import net.minecraft.server.v1_7_R4.ChatSerializer;
import net.minecraft.server.v1_7_R4.IChatBaseComponent;
import net.minecraft.server.v1_7_R4.PacketPlayOutChat;
import net.minecraft.server.v1_7_R4.PlayerConnection;

public class Framework {
	
	private static int VERSION = 47; 
	
	public static void enviarActionBar(Player p, String msg) {
		if(((CraftPlayer)p).getHandle().playerConnection.networkManager.getVersion() < VERSION) {
			return;
		}
		IChatBaseComponent cbc = ChatSerializer.a("{\"text\": \"" + msg + "\"}");
		PacketPlayOutChat pakt = new PacketPlayOutChat(cbc, (byte) 2);
		((CraftPlayer) p).getHandle().playerConnection.sendPacket(pakt);
	}

	public static void sendTitle(Player p, String title) {
	 if (((CraftPlayer) p).getHandle().playerConnection.networkManager.getVersion() < VERSION) {
	  return;
	 }
	 ((CraftPlayer) p).getHandle().playerConnection.sendPacket(new ProtocolInjector.PacketTitle(ProtocolInjector.PacketTitle.Action.TITLE, ChatSerializer.a("{\"text\": \"\"}").a(title)));
	}

	public static void sendSubTitle(Player p, String subtitle) {
	 if (((CraftPlayer) p).getHandle().playerConnection.networkManager.getVersion() < VERSION) {
	  return;
	 }
	 ((CraftPlayer) p).getHandle().playerConnection.sendPacket(new ProtocolInjector.PacketTitle(ProtocolInjector.PacketTitle.Action.SUBTITLE, ChatSerializer.a(
	   "{\"text\": \"\"}").a(subtitle)));
	}

	public static void sendTimings(Player p, int fadeIn, int stay, int fadeOut) {
	 if (((CraftPlayer) p).getHandle().playerConnection.networkManager.getVersion() < VERSION) {
	  return;
	 }
	 try {
	  Object handle = getHandle(p);
	  Object connection = getField(handle.getClass(), "playerConnection").get(handle);
	  Object packet = ProtocolInjector.PacketTitle.class.getConstructor(new Class[] { ProtocolInjector.PacketTitle.Action.class, Integer.TYPE, Integer.TYPE, Integer.TYPE }).newInstance(new Object[] { ProtocolInjector.PacketTitle.Action.TIMES, Integer.valueOf(fadeIn), Integer.valueOf(stay), Integer.valueOf(fadeOut) });
	  getMethod(connection.getClass(), "sendPacket", new Class[0]).invoke(connection, new Object[] { packet });
	 } catch (Exception e) {
	  e.printStackTrace();
	 }
	}

	private static boolean ClassListEqual(Class<?>[] l1, Class<?>[] l2) {
	 boolean equal = true;
	 if (l1.length != l2.length) {
	  return false;
	 }
	 for (int i = 0; i < l1.length; i++) {
	  if (l1[i] != l2[i]) {
	    equal = false;
	    break;
	   }
	  }
	  return equal;
	 }

	 private static Field getField(Class<?> clazz, String name) {
	  try {
	   Field field = clazz.getDeclaredField(name);
	   field.setAccessible(true);
	   return field;
	  } catch (Exception e) {
	   e.printStackTrace();
	  }
	  return null;
	 }

	 private static Method getMethod(Class<?> clazz, String name, Class<?>... args) {
	  for (Method m : clazz.getMethods()) {
	   if ((m.getName().equals(name)) && ((args.length == 0) || (ClassListEqual(args, m.getParameterTypes())))) {
	    m.setAccessible(true);
	    return m;
	   }
	  }
	  return null;
	 }

	 private static Object getHandle(Object obj) {
	  try {
	   return getMethod(obj.getClass(), "getHandle", new Class[0]).invoke(obj, new Object[0]);
	  } catch (Exception e) {
	   e.printStackTrace();
	  }
	  return null;
	 }

	 public static void reset(Player p) {
	  if (((CraftPlayer) p).getHandle().playerConnection.networkManager.getVersion() < VERSION) {
	   return;
	  }
	  ((CraftPlayer) p).getHandle().playerConnection.sendPacket(new ProtocolInjector.PacketTitle(ProtocolInjector.PacketTitle.Action.RESET));
	 }

	 public static void clear(Player p) {
	  if (((CraftPlayer) p).getHandle().playerConnection.networkManager.getVersion() < VERSION) {
	   return;
	  }
	  ((CraftPlayer) p).getHandle().playerConnection.sendPacket(new ProtocolInjector.PacketTitle(ProtocolInjector.PacketTitle.Action.CLEAR));
	 }
	 
	 public static void buildTabConstructor(Player p, String texto1, String texto2) {
	     PlayerConnection connect = ((CraftPlayer) p).getHandle().playerConnection;
	     IChatBaseComponent top = ChatSerializer.a("{'text':'" + texto1 + "\n '}");

	     IChatBaseComponent bottom = ChatSerializer.a("{'extra': [{'color': 'aqua', 'text': '" + texto2 + "', 'underline': 'true'}], 'color': 'gold', 'text': ''}");
	      if (((CraftPlayer) p).getHandle().playerConnection.networkManager.getVersion() < 47) {
	          return;
	      }
	     connect.sendPacket(new ProtocolInjector.PacketTabHeader(top, bottom));
	 }
	 
	 
	  public static String getShortStr(String name) {
		    if (name.length() == 16)
		    {
		      return name.substring(0, name.length() - 5);
		    }
		    
		    if (name.length() == 15)
		    {
		      return name.substring(0, name.length() - 4);
		    }
		    
		    return name;
		  }
	  
	  public static String pegarDesbloqueadosCabecas(Player p) {
		  try {
			if(MySQLManager.getRank(p) == 0) {
				  return "§e0§7/§e20 §e0§7%";
			}
			if(MySQLManager.getRank(p) == 1) {
				  return "§e4§7/§e20 §e20§7%";
			}
			if(MySQLManager.getRank(p) == 2) {
				  return "§e8§7/§e20 §e40§7%";
			}
			if(MySQLManager.getRank(p) == 3) {
				  return "§e12§7/§e20 §e60§7%";
			}
			if(MySQLManager.getRank(p) == 4) {
				  return "§e16§7/§e20 §e80§7%";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		  return "§e20§7/§e20 §e100§7%";
	  }
	  
	  public static String pegarDesbloqueadosEfeitos(Player p) {
		  try {
			if(MySQLManager.getRank(p) == 0) {
				  return "§e0§7/§e10 §e0§7%";
			}
			if(MySQLManager.getRank(p) == 1) {
				  return "§e2§7/§e10 §e20§7%";
			}
			if(MySQLManager.getRank(p) == 2) {
				  return "§e4§7/§e10 §e40§7%";
			}
			if(MySQLManager.getRank(p) == 3) {
				  return "§e6§7/§e10 §e60§7%";
			}
			if(MySQLManager.getRank(p) == 4) {
				  return "§e8§7/§e10 §e80§7%";
			}
			if(MySQLManager.getRank(p) == 5) {
				  return "§e10§7/§e10 §e100§7%";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		  return "§e10§7/§e10 §e100§7%";
	  }
	  
	  public static String pegarDesbloqueadosLocomocao(Player p) {
		  try {
			if(MySQLManager.getRank(p) == 0) {
				  return "§e0§7/§e1 §e0§7%";
			}
			if(MySQLManager.getRank(p) == 1) {
				  return "§e0§7/§e1 §e0§7%";
			}
			if(MySQLManager.getRank(p) == 2) {
				  return "§e0§7/§e1 §e0§7%";
			}
			if(MySQLManager.getRank(p) == 3) {
				  return "§e0§7/§e1 §e0§7%";
			}
			if(MySQLManager.getRank(p) == 4) {
				  return "§e0§7/§e1 §e0§7%";
			}
			if(MySQLManager.getRank(p) == 5) {
				  return "§e1§7/§e1 §e100§7%";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		  return "§e1§7/§e1 §e100§7%";
	  }
	  
	  @SuppressWarnings("deprecation")
	public static void onTheFlash(Player p) {
		  if(!Main.TheFlash.contains(p)) {
			  p.getWorld().spawnEntity(p.getLocation(), EntityType.LIGHTNING);
			  p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999999, 10));
			  Bukkit.getScheduler().scheduleAsyncRepeatingTask(Main.instace, new Runnable() {
				
				@Override
				public void run() {
					if(Main.TheFlash.contains(p)) {
						p.playEffect(p.getLocation(), Effect.MOBSPAWNER_FLAMES, 20);
					}
				}
			}, 5L, 5L);
			  
		        ItemStack skullItem = new ItemStack(Material.SKULL_ITEM);
			    skullItem.setDurability((short)3);
			    SkullMeta skullMeta = (SkullMeta)skullItem.getItemMeta();
			    skullMeta.setOwner("XXl_V2");
			    skullMeta.setDisplayName("§f§lFLASH");
		        skullItem.setItemMeta(skullMeta);
				
		        ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
		        ItemMeta bootsmeta = boots.getItemMeta();
		        bootsmeta.setDisplayName("§f§lFLASH BOOTS");
		        boots.setItemMeta(bootsmeta);
		        
		        Main.TheFlash.add(p);
		        
		        p.getInventory().setBoots(boots);
		        p.getInventory().setHelmet(skullItem);
		  } else {
			  p.sendMessage("§a§lLOCOMOÇãO §fVocê já está usando este efeito.");
		  }
	  }
	  
   public static void criarNPC(Player parametroJogador, String parametroNomeDoNPC) {
	      NPC npc = CitizensAPI.getNPCRegistry().createNPC(EntityType.PLAYER, parametroJogador.getName());
          npc.spawn(parametroJogador.getLocation());
   }
}