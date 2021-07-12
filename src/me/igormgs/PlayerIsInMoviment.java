package me.igormgs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerIsInMoviment
implements Listener{
	
	  public static List<String> Moving = new ArrayList<String>();
	  final HashMap<UUID, Location> lastLocation = new HashMap<UUID, Location>();
	  
	  @EventHandler
	  public void MovementCheck(PlayerMoveEvent e){
	    Player player = e.getPlayer();
	    Location Current = player.getLocation();
	    Location Last = (Location)this.lastLocation.get(player.getUniqueId());
	    if (this.lastLocation.get(player.getUniqueId()) == null){
	      this.lastLocation.put(player.getUniqueId(), Current);
	      Last = (Location)this.lastLocation.get(player.getUniqueId());
	    }
	    this.lastLocation.put(player.getUniqueId(), player.getLocation());
	    if ((Last.getX() != Current.getX()) || (Last.getY() != Current.getY()) || 
	      (Last.getZ() != Current.getZ())){
	      if (!Moving.contains(player.getName())) {
	        Moving.add(player.getName());
	      }
	    }
	    else if (Moving.contains(player.getName())) {
	      Moving.remove(player.getName());
	    }
	  }
	  
	  public static boolean isNotMoving(Player p){
	    if (Moving.contains(p.getName())) {
	      return false;
	    }
	    return true;
	  }
	}