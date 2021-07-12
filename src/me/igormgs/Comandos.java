package me.igormgs;

import java.sql.SQLException;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import ca.wacos.nametagedit.NametagAPI;
import me.igormgs.db.MySQLManager;
import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;

public class Comandos implements CommandExecutor {
	
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender parametroSender, Command parametroCMD, String parametroLabel, String[] parametroArgumentos) {
	  Player p = (Player)parametroSender;
		if(!(parametroSender instanceof Player)){
			return true;
		}
		if(parametroLabel.equalsIgnoreCase("voar")) {
			try {
				if(MySQLManager.getRank(p) != 0) {
					if(!Main.voando.contains(p)) {
						Block embaixo = p.getLocation().getBlock().getRelative(BlockFace.DOWN);
						if(embaixo.getType() == Material.AIR) {
							p.sendMessage("§a§lFLY §fVocê tem que estar no chão.");
							p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
						    Framework.sendTitle(p, "§4§lERRO");
						    Framework.sendSubTitle(p, "§fVocê tem que estar no chão.");
							return false;
						} else if(embaixo.getType() != Material.AIR) {
							Main.voando.add(p);
							p.sendMessage("§a§lFLY §fVocê §a§lATIVOU§f suas asas, agora você pode voar.");
							Framework.sendTitle(p, "");
							Framework.sendSubTitle(p, "§7Agora você §a§npode§f §7voar.");
							p.setAllowFlight(true);
							return true;
						}
					} else {
						Main.voando.remove(p);
						p.sendMessage("§a§lFLY §fVocê §c§lDESATIVOU§f suas asas, agora você pode voar.");
						Framework.sendTitle(p, "");
						Framework.sendSubTitle(p, "§7Agora você §c§nnão pode§f§7 voar.");
						p.setAllowFlight(false);
					}
				} else {
					p.sendMessage("§a§lFLY §fVocê não tem permissão para executar esse comando.");
					p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
				    Framework.sendTitle(p, "§4§lERRO");
				    Framework.sendSubTitle(p, "§fVocê não tem permissão.");
				    return false;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(parametroLabel.equalsIgnoreCase("fly")) {
			try {
				if(MySQLManager.getRank(p) != 0) {
					if(!Main.voando.contains(p)) {
						Block embaixo = p.getLocation().getBlock().getRelative(BlockFace.DOWN);
						if(embaixo.getType() == Material.AIR) {
							p.sendMessage("§a§lFLY §fVocê tem que estar no chão.");
							p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
						    Framework.sendTitle(p, "§4§lERRO");
						    Framework.sendSubTitle(p, "§fVocê tem que estar no chão.");
							return false;
						} else {
							Main.voando.add(p);
							p.sendMessage("§a§lFLY §fVocê §a§lATIVOU§f suas asas, agora você pode voar.");
							Framework.sendTitle(p, "");
							Framework.sendSubTitle(p, "§7Agora você §a§npode§f §7voar.");
							p.setAllowFlight(true);
							return true;
						}
					} else {
						Main.voando.remove(p);
						p.sendMessage("§a§lFLY §fVocê §c§lDESATIVOU§f suas asas, agora você não pode voar.");
						Framework.sendTitle(p, "");
						Framework.sendSubTitle(p, "§7Agora você §c§nnão pode§f§7 voar.");
						p.setAllowFlight(false);
					}
				} else {
					p.sendMessage("§a§lFLY §fVocê não tem permissão para executar esse comando.");
					p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
				    Framework.sendTitle(p, "§4§lERRO");
				    Framework.sendSubTitle(p, "§fVocê não tem permissão.");
				    return false;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(parametroLabel.equalsIgnoreCase("tag")) {
			if (parametroArgumentos.length == 0) {
				try {
				  if(MySQLManager.getRank(p) == 0) {
					  p.sendMessage("§a§lTAGS §fTags registrados em seu nome: §7§lMEMBRO§f.");
					  return true;
				  }
					   if(MySQLManager.getRank(p) == 1) {
					       p.sendMessage("§a§lTAGS §fTags registrados em seu nome: §7§lMEMBRO§f, §a§lVIP§f.");
					       return true;
					   }
					   if(MySQLManager.getRank(p) == 2) {
					       p.sendMessage("§a§lTAGS §fTags registrados em seu nome: §7§lMEMBRO§f, §a§lVIP§f, §e§lVIP+§f.");
					       return true;
					   }
					   if(MySQLManager.getRank(p) == 3) {
					       p.sendMessage("§a§lTAGS §fTags registrados em seu nome: §7§lMEMBRO§f, §a§lVIP§f, §e§lVIP+§f, §6§lPRO§f.");
					       return true;
					   }
					   if(MySQLManager.getRank(p) == 4) {
					       p.sendMessage("§a§lTAGS §fTags registrados em seu nome: §7§lMEMBRO§f, §a§lVIP§f, §e§lVIP+§f, §6§lPRO§f, §d§lULTRA§f.");
					       return true;
					   }
					   if(MySQLManager.getRank(p) == 5) {
					       p.sendMessage("§a§lTAGS §fTags registrados em seu nome: §7§lMEMBRO§f, §a§lVIP§f, §e§lVIP+§f, §6§lPRO§f, §d§lULTRA§f, §1§lBETA§f.");
					       return true;
					   }
					   if(MySQLManager.getRank(p) == 6) {
					       p.sendMessage("§a§lTAGS §fTags registrados em seu nome: §7§lMEMBRO§f, §a§lVIP§f, §e§lVIP+§f, §6§lPRO§f, §d§lULTRA§f, §3§lSTTEY§f.");
					       return true;
					   }
					   if(MySQLManager.getRank(p) == 7) {
					       p.sendMessage("§a§lTAGS §fTags registrados em seu nome: §7§lMEMBRO§f, §a§lVIP§f, §e§lVIP+§f, §6§lPRO§f, §d§lULTRA§f, §3§lSTTEY§f, §b§lYOUTUBER§f.");
					       return true;
					   }
					   if(MySQLManager.getRank(p) == 8) {
					       p.sendMessage("§a§lTAGS §fTags registrados em seu nome: §7§lMEMBRO§f, §a§lVIP§f, §e§lVIP+§f, §6§lPRO§f, §d§lULTRA§f, §3§lSTTEY§f, §3§lYOUTUBER+§f.");
					       return true;
					   }
					   if(MySQLManager.getRank(p) == 9) {
					       p.sendMessage("§a§lTAGS §fTags registrados em seu nome: §7§lMEMBRO§f, §a§lVIP§f, §e§lVIP+§f, §6§lPRO§f, §d§lULTRA§f, §3§lSTTEY§f, §2§lHELPER§f.");
					       return true;
					   }
					   if(MySQLManager.getRank(p) == 10) {
					       p.sendMessage("§a§lTAGS §fTags registrados em seu nome: §7§lMEMBRO§f, §a§lVIP§f, §e§lVIP+§f, §6§lPRO§f, §d§lULTRA§f, §3§lSTTEY§f, §b§lBUIL§d§lDER§f.");
					       return true;
					   }
					   if(MySQLManager.getRank(p) == 11) {
					       p.sendMessage("§a§lTAGS §fTags registrados em seu nome: §7§lMEMBRO§f, §a§lVIP§f, §e§lVIP+§f, §6§lPRO§f, §d§lULTRA§f, §3§lSTTEY§f, §d§lTRIAL§f.");
					       return true;
					   }
					   if(MySQLManager.getRank(p) == 12) {
					       p.sendMessage("§a§lTAGS §fTags registrados em seu nome: §7§lMEMBRO§f, §a§lVIP§f, §e§lVIP+§f, §6§lPRO§f, §d§lULTRA§f, §3§lSTTEY§f, §5§lMOD§f.");
					       return true;
					   }
					   if(MySQLManager.getRank(p) == 13) {
					       p.sendMessage("§a§lTAGS §fTags registrados em seu nome: §7§lMEMBRO§f, §a§lVIP§f, §e§lVIP+§f, §6§lPRO§f, §d§lULTRA§f, §3§lSTTEY§f, §c§lADM§f.");
					       return true;
					   }
					   if(MySQLManager.getRank(p) == 14) {
					       p.sendMessage("§a§lTAGS §fTags registrados em seu nome: §4§lTODAS§f.");
					       return true;
					   }
					   if(MySQLManager.getRank(p) == 15) {
					       p.sendMessage("§a§lTAGS §fTags registrados em seu nome: §4§lTODAS§f.");
					       return true;
					   }
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				   try {
					if(MySQLManager.getRank(p) != 15) {
					if(MySQLManager.getRank(p) != 14) {
				    if(MySQLManager.getRank(p) != 13) {
					if(MySQLManager.getRank(p) != 12) {
					if(MySQLManager.getRank(p) != 11) {
					if(MySQLManager.getRank(p) != 10) {
					if(MySQLManager.getRank(p) != 9) {
					if(MySQLManager.getRank(p) != 8) {
					if(MySQLManager.getRank(p) != 7) {
					if(MySQLManager.getRank(p) != 6) {
					if(MySQLManager.getRank(p) != 5) {
					if(MySQLManager.getRank(p) != 4) {
					if(MySQLManager.getRank(p) != 3) {
					if(MySQLManager.getRank(p) != 2) {
					if(MySQLManager.getRank(p) != 1) {
					if(MySQLManager.getRank(p) != 0) {
						p.sendMessage("§a§lTAGS §fVocê não está em nenhum grupo!");
						return true;
																				   }
																			   }
																		   }
																	   }
																   }
															   }
														   }
													   }
												   }
											   }
										   }
									   }
								   }
							   }
						   }
					   }
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return true;
			}
			
			if (parametroArgumentos.length == 1) {
				String paramLocalArgs = parametroArgumentos[0];
				 if (paramLocalArgs.equalsIgnoreCase("ceo")) {
						try {
							if(MySQLManager.getRank(p) == 0) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 1) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 2) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 3) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 4) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 5) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 6) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 7) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 8) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 9) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 10) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 11) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 12) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 13) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 14) {
							   p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §4§lCEO §fcom sucesso.");
							   NametagAPI.setPrefix(p.getName(), "§4§lCEO §f§7");
							   p.setDisplayName("§4§lCEO §f§7" + p.getName());
							   Framework.sendTitle(p, "§a§lTAGS");
							   Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
							   p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
							   return true;
							} else if(MySQLManager.getRank(p) == 15) {
							   p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §4§lCEO §fcom sucesso.");
							   NametagAPI.setPrefix(p.getName(), "§4§lCEO §f§7");
							   p.setDisplayName("§4§lCEO §f§7" + p.getName());
							   Framework.sendTitle(p, "§a§lTAGS");
							   Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
							   p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
							   return true;
							}
						} catch (Exception e) {
						    e.printStackTrace();
						}
						return false;
						
					} else if(paramLocalArgs.equalsIgnoreCase("cti")) {
						try {
							if(MySQLManager.getRank(p) == 0) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 1) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 2) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 3) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 4) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 5) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 6) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 7) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 8) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 9) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 10) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 11) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 12) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 13) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 14) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
							    return false;
							} else if(MySQLManager.getRank(p) == 15) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §4§lCTI §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§4§lCTI §f§7");
								p.setDisplayName("§4§lCTI §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
							    return true;
							}
						} catch (Exception e) {
						    e.printStackTrace();
						}
					} else if(paramLocalArgs.equalsIgnoreCase("membro")) {
						p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §7§lMEMBRO §fcom sucesso.");
						NametagAPI.setPrefix(p.getName(), "§7§lMEMBRO §f§7");
					    p.setDisplayName("§7§lMEMBRO §f§7" + p.getName());
						Framework.sendTitle(p, "§a§lTAGS");
						Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
						p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
						return true;
					} else if(paramLocalArgs.equalsIgnoreCase("vip")) {
						try {
							if(MySQLManager.getRank(p) == 0) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 1) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §a§lVIP §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§a§lVIP §f§7");
								p.setDisplayName("§a§lVIP §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
								return true;
							} else if(MySQLManager.getRank(p) == 2) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §a§lVIP §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§a§lVIP §f§7");
								p.setDisplayName("§a§lVIP §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
								return true;
							} else if(MySQLManager.getRank(p) == 3) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §a§lVIP §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§a§lVIP §f§7");
								p.setDisplayName("§a§lVIP §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
								return true;
							} else if(MySQLManager.getRank(p) == 4) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §a§lVIP §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§a§lVIP §f§7");
								p.setDisplayName("§a§lVIP §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
								return true;
							} else if(MySQLManager.getRank(p) == 5) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §a§lVIP §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§a§lVIP §f§7");
								p.setDisplayName("§a§lVIP §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
								return true;
							} else if(MySQLManager.getRank(p) == 6) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §a§lVIP §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§a§lVIP §f§7");
								p.setDisplayName("§a§lVIP §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
								return true;
							} else if(MySQLManager.getRank(p) == 7) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §a§lVIP §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§a§lVIP §f§7");
								p.setDisplayName("§a§lVIP §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
								return true;
							} else if(MySQLManager.getRank(p) == 8) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §a§lVIP §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§a§lVIP §f§7");
								p.setDisplayName("§a§lVIP §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
								return true;
							} else if(MySQLManager.getRank(p) == 9) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §a§lVIP §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§a§lVIP §f§7");
								p.setDisplayName("§a§lVIP §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
								return true;
							} else if(MySQLManager.getRank(p) == 10) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §a§lVIP §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§a§lVIP §f§7");
								p.setDisplayName("§a§lVIP §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
								return true;
							} else if(MySQLManager.getRank(p) == 11) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §a§lVIP §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§a§lVIP §f§7");
								p.setDisplayName("§a§lVIP §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
								return true;
							} else if(MySQLManager.getRank(p) == 12) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §a§lVIP §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§a§lVIP §f§7");
								p.setDisplayName("§a§lVIP §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
								return true;
							} else if(MySQLManager.getRank(p) == 13) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §a§lVIP §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§a§lVIP §f§7");
								p.setDisplayName("§a§lVIP §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
								return true;
							} else if(MySQLManager.getRank(p) == 14) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §a§lVIP §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§a§lVIP §f§7");
								p.setDisplayName("§a§lVIP §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
								return true;
							} else if(MySQLManager.getRank(p) == 15) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §a§lVIP §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§a§lVIP §f§7");
								p.setDisplayName("§a§lVIP §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
							    return true;
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					} else if(paramLocalArgs.equalsIgnoreCase("vipplus")) {
						try {
							if(MySQLManager.getRank(p) == 0) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 1) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
							    return false;
							} else if(MySQLManager.getRank(p) == 2) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §e§lVIPPLUS §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§e§lVIPPLUS §f§7");
								p.setDisplayName("§e§lVIPPLUS §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
								return true;
							} else if(MySQLManager.getRank(p) == 3) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §e§lVIPPLUS §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§e§lVIPPLUS §f§7");
								p.setDisplayName("§e§lVIPPLUS §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
								return true;
							} else if(MySQLManager.getRank(p) == 4) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §e§lVIPPLUS §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§e§lVIPPLUS §f§7");
								p.setDisplayName("§e§lVIPPLUS §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
								return true;
							} else if(MySQLManager.getRank(p) == 5) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §e§lVIPPLUS §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§e§lVIPPLUS §f§7");
								p.setDisplayName("§e§lVIPPLUS §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
								return true;
							} else if(MySQLManager.getRank(p) == 6) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §e§lVIPPLUS §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§e§lVIPPLUS §f§7");
								p.setDisplayName("§e§lVIPPLUS §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
								return true;
							} else if(MySQLManager.getRank(p) == 7) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §e§lVIPPLUS §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§e§lVIPPLUS §f§7");
								p.setDisplayName("§e§lVIPPLUS §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
								return true;
							} else if(MySQLManager.getRank(p) == 8) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §e§lVIPPLUS §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§e§lVIPPLUS §f§7");
								p.setDisplayName("§e§lVIPPLUS §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
								return true;
							} else if(MySQLManager.getRank(p) == 9) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §e§lVIPPLUS §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§e§lVIPPLUS §f§7");
								p.setDisplayName("§e§lVIPPLUS §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
								return true;
							} else if(MySQLManager.getRank(p) == 10) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §e§lVIPPLUS §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§e§lVIPPLUS §f§7");
								p.setDisplayName("§e§lVIPPLUS §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
								return true;
							} else if(MySQLManager.getRank(p) == 11) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §e§lVIPPLUS §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§e§lVIPPLUS §f§7");
								p.setDisplayName("§e§lVIPPLUS §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
								return true;
							} else if(MySQLManager.getRank(p) == 12) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §e§lVIPPLUS §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§e§lVIPPLUS §f§7");
								p.setDisplayName("§e§lVIPPLUS §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
								return true;
							} else if(MySQLManager.getRank(p) == 13) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §e§lVIPPLUS §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§e§lVIPPLUS §f§7");
								p.setDisplayName("§e§lVIPPLUS §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
							    return true;
							} else if(MySQLManager.getRank(p) == 14) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §e§lVIPPLUS §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§e§lVIPPLUS §f§7");
								p.setDisplayName("§e§lVIPPLUS §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
								return true;
							} else if(MySQLManager.getRank(p) == 15) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §e§lVIPPLUS §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§e§lVIPPLUS §f§7");
								p.setDisplayName("§e§lVIPPLUS §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
							    return true;
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					} else if(paramLocalArgs.equalsIgnoreCase("pro")) {
						try {
							if(MySQLManager.getRank(p) == 0) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 1) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 2) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 3) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §6§lPRO §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§6§lPRO §f§7");
								p.setDisplayName("§6§lPRO §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
							    return true;
							} else if(MySQLManager.getRank(p) == 4) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §6§lPRO §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§6§lPRO §f§7");
								p.setDisplayName("§6§lPRO §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
							    return true;
							} else if(MySQLManager.getRank(p) == 5) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §6§lPRO §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§6§lPRO §f§7");
								p.setDisplayName("§6§lPRO §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
							    return true;
							} else if(MySQLManager.getRank(p) == 6) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §6§lPRO §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§6§lPRO §f§7");
								p.setDisplayName("§6§lPRO §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
							    return true;
							} else if(MySQLManager.getRank(p) == 7) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §6§lPRO §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§6§lPRO §f§7");
								p.setDisplayName("§6§lPRO §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
							    return true;
							} else if(MySQLManager.getRank(p) == 8) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §6§lPRO §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§6§lPRO §f§7");
								p.setDisplayName("§6§lPRO §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
							    return true;
							} else if(MySQLManager.getRank(p) == 9) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §6§lPRO §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§6§lPRO §f§7");
								p.setDisplayName("§6§lPRO §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
							    return true;
							} else if(MySQLManager.getRank(p) == 10) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §6§lPRO §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§6§lPRO §f§7");
								p.setDisplayName("§6§lPRO §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
							    return true;
							} else if(MySQLManager.getRank(p) == 11) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §6§lPRO §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§6§lPRO §f§7");
								p.setDisplayName("§6§lPRO §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
							    return true;
							} else if(MySQLManager.getRank(p) == 12) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §6§lPRO §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§6§lPRO §f§7");
								p.setDisplayName("§6§lPRO §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
							    return true;
							} else if(MySQLManager.getRank(p) == 13) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §6§lPRO §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§6§lPRO §f§7");
								p.setDisplayName("§6§lPRO §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
							    return true;
							} else if(MySQLManager.getRank(p) == 14) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §6§lPRO §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§6§lPRO §f§7");
								p.setDisplayName("§6§lPRO §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
							    return true;
							} else if(MySQLManager.getRank(p) == 15) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §6§lPRO §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§6§lPRO §f§7");
								p.setDisplayName("§6§lPRO §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
							    return true;
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					} else if(paramLocalArgs.equalsIgnoreCase("ultra")) {
						try {
							if(MySQLManager.getRank(p) == 0) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 1) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 2) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 3) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 4) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §d§lULTRA §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§d§lULTRA §f§7");
								p.setDisplayName("§d§lULTRA §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
							    return true;
							} else if(MySQLManager.getRank(p) == 5) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §d§lULTRA §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§d§lULTRA §f§7");
								p.setDisplayName("§d§lULTRA §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
							    return true;
							} else if(MySQLManager.getRank(p) == 6) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §d§lULTRA §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§d§lULTRA §f§7");
								p.setDisplayName("§d§lULTRA §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
							    return true;
							} else if(MySQLManager.getRank(p) == 7) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §d§lULTRA §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§d§lULTRA §f§7");
								p.setDisplayName("§d§lULTRA §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
							    return true;
							} else if(MySQLManager.getRank(p) == 8) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §d§lULTRA §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§d§lULTRA §f§7");
								p.setDisplayName("§d§lULTRA §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
							    return true;
							} else if(MySQLManager.getRank(p) == 9) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §d§lULTRA §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§d§lULTRA §f§7");
								p.setDisplayName("§d§lULTRA §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
							    return true;
							} else if(MySQLManager.getRank(p) == 10) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §d§lULTRA §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§d§lULTRA §f§7");
								p.setDisplayName("§d§lULTRA §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
							    return true;
							} else if(MySQLManager.getRank(p) == 11) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §d§lULTRA §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§d§lULTRA §f§7");
								p.setDisplayName("§d§lULTRA §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
							    return true;
							} else if(MySQLManager.getRank(p) == 12) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §d§lULTRA §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§d§lULTRA §f§7");
								p.setDisplayName("§d§lULTRA §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
							    return true;
							} else if(MySQLManager.getRank(p) == 13) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §d§lULTRA §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§d§lULTRA §f§7");
								p.setDisplayName("§d§lULTRA §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
							    return true;
							} else if(MySQLManager.getRank(p) == 14) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §d§lULTRA §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§d§lULTRA §f§7");
								p.setDisplayName("§d§lULTRA §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
							    return true;
							} else if(MySQLManager.getRank(p) == 15) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §d§lULTRA §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§d§lULTRA §f§7");
								p.setDisplayName("§d§lULTRA §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
							    return true;
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					} else if(paramLocalArgs.equalsIgnoreCase("beta")) {
						try {
							if(MySQLManager.getRank(p) == 0) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
							    return false;
							} else if(MySQLManager.getRank(p) == 1) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
							    return false;
							} else if(MySQLManager.getRank(p) == 2) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
							    return false;
							} else if(MySQLManager.getRank(p) == 3) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
							    return false;
							} else if(MySQLManager.getRank(p) == 4) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
							    return false;
							} else if(MySQLManager.getRank(p) == 5) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §1§lBETA §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§1§lBETA §f§7");
								p.setDisplayName("§1§lBETA §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
							    return true;
							} else if(MySQLManager.getRank(p) == 6) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §1§lBETA §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§1§lBETA §f§7");
								p.setDisplayName("§1§lBETA §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
							    return true;
							} else if(MySQLManager.getRank(p) == 7) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §1§lBETA §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§1§lBETA §f§7");
								p.setDisplayName("§1§lBETA §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
							    return true;
							} else if(MySQLManager.getRank(p) == 8) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §1§lBETA §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§1§lBETA §f§7");
								p.setDisplayName("§1§lBETA §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
							    return true;
							} else if(MySQLManager.getRank(p) == 9) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §1§lBETA §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§1§lBETA §f§7");
								p.setDisplayName("§1§lBETA §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
							    return true;
							} else if(MySQLManager.getRank(p) == 10) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §1§lBETA §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§1§lBETA §f§7");
								p.setDisplayName("§1§lBETA §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
							    return true;
							} else if(MySQLManager.getRank(p) == 11) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §1§lBETA §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§1§lBETA §f§7");
								p.setDisplayName("§1§lBETA §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
							    return true;
							} else if(MySQLManager.getRank(p) == 12) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §1§lBETA §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§1§lBETA §f§7");
								p.setDisplayName("§1§lBETA §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
							    return true;
							} else if(MySQLManager.getRank(p) == 13) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §1§lBETA §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§1§lBETA §f§7");
								p.setDisplayName("§1§lBETA §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
							    return true;
							} else if(MySQLManager.getRank(p) == 14) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §1§lBETA §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§1§lBETA §f§7");
								p.setDisplayName("§1§lBETA §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
							    return true;
							} else if(MySQLManager.getRank(p) == 15) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §1§lBETA §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§1§lBETA §f§7");
								p.setDisplayName("§1§lBETA §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
							    return true;
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					} else if(paramLocalArgs.equalsIgnoreCase("sttey")) {
						try {
							if(MySQLManager.getRank(p) == 0) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 1) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 2) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 3) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 4) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 5) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
							    return false;
							} else if(MySQLManager.getRank(p) == 6) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §3§lSTTEY §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§3§lSTTEY §f§7");
								p.setDisplayName("§3§lSTTEY §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
							    return true;
							} else if(MySQLManager.getRank(p) == 7) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §3§lSTTEY §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§3§lSTTEY §f§7");
								p.setDisplayName("§3§lSTTEY §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
							    return true;
							} else if(MySQLManager.getRank(p) == 8) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §3§lSTTEY §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§3§lSTTEY §f§7");
								p.setDisplayName("§3§lSTTEY §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
							    return true;
							} else if(MySQLManager.getRank(p) == 9) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §3§lSTTEY §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§3§lSTTEY §f§7");
								p.setDisplayName("§3§lSTTEY §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
							    return true;
							} else if(MySQLManager.getRank(p) == 10) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §3§lSTTEY §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§3§lSTTEY §f§7");
								p.setDisplayName("§3§lSTTEY §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
							    return true;
							} else if(MySQLManager.getRank(p) == 11) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §3§lSTTEY §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§3§lSTTEY §f§7");
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
							    return true;
							} else if(MySQLManager.getRank(p) == 12) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §3§lSTTEY §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§3§lSTTEY §f§7");
								p.setDisplayName("§3§lSTTEY §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
							    return true;
							} else if(MySQLManager.getRank(p) == 13) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §3§lSTTEY §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§3§lSTTEY §f§7");
								p.setDisplayName("§3§lSTTEY §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
							    return true;
							} else if(MySQLManager.getRank(p) == 14) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §3§lSTTEY §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§3§lSTTEY §f§7");
								p.setDisplayName("§3§lSTTEY §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
							    return true;
							} else if(MySQLManager.getRank(p) == 15) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §3§lSTTEY §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§3§lSTTEY §f§7");
								p.setDisplayName("§3§lSTTEY §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
							    return true;
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					} else if(paramLocalArgs.equalsIgnoreCase("youtuber")) {
						try {
							if(MySQLManager.getRank(p) == 0) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 1) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 2) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 3) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 4) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 5) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 6) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 7) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §b§lYOUTUBER §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§b§lYT §f§7");
								p.setDisplayName("§b§lYT §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
							    return true;
							} else if(MySQLManager.getRank(p) == 8) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 9) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §b§lYOUTUBER §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§b§lYT §f§7");
								p.setDisplayName("§b§lYT §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
							    return true;
							} else if(MySQLManager.getRank(p) == 10) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §b§lYOUTUBER §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§b§lYT §f§7");
								p.setDisplayName("§b§lYT §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
							    return true;
							} else if(MySQLManager.getRank(p) == 11) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §b§lYOUTUBER §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§b§lYT §f§7");
								p.setDisplayName("§b§lYT §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
							    return true;
							} else if(MySQLManager.getRank(p) == 12) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §b§lYOUTUBER §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§b§lYT §f§7");
								p.setDisplayName("§b§lYT §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
							    return true;
							} else if(MySQLManager.getRank(p) == 13) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §b§lYOUTUBER §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§b§lYT §f§7");
								p.setDisplayName("§b§lYT §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
							    return true;
							} else if(MySQLManager.getRank(p) == 14) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §b§lYOUTUBER §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§b§lYT §f§7");
								p.setDisplayName("§b§lYT §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
							    return true;
							} else if(MySQLManager.getRank(p) == 15) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §b§lYOUTUBER §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§b§lYT §f§7");
								p.setDisplayName("§b§lYT §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
							    return true;
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					} else if(paramLocalArgs.equalsIgnoreCase("youtuberplus")) {
						try {
							if(MySQLManager.getRank(p) == 0) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 1) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 2) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 3) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 4) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 5) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 6) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 7) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 8) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §3§lYOUTUBERPLUS §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§3§lYT+ §f§7");
								p.setDisplayName("§3§lYT+ §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
							    return true;
							} else if(MySQLManager.getRank(p) == 9) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §3§lYOUTUBERPLUS §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§3§lYT+ §f§7");
								p.setDisplayName("§3§lYT+ §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
							    return true;
							} else if(MySQLManager.getRank(p) == 10) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §3§lYOUTUBERPLUS §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§3§lYT+ §f§7");
								p.setDisplayName("§3§lYT+ §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
							    return true;
							} else if(MySQLManager.getRank(p) == 11) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §3§lYOUTUBERPLUS §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§3§lYT+ §f§7");
								p.setDisplayName("§3§lYT+ §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
							    return true;
							} else if(MySQLManager.getRank(p) == 12) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §3§lYOUTUBERPLUS §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§3§lYT+ §f§7");
								p.setDisplayName("§3§lYT+ §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
							    return true;
							} else if(MySQLManager.getRank(p) == 13) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §3§lYOUTUBERPLUS §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§3§lYT+ §f§7");
								p.setDisplayName("§3§lYT+ §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
							    return true;
							} else if(MySQLManager.getRank(p) == 14) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §3§lYOUTUBERPLUS §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§3§lYT+ §f§7");
								p.setDisplayName("§3§lYT+ §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
							    return true;
							} else if(MySQLManager.getRank(p) == 15) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §3§lYOUTUBERPLUS §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§3§lYT+ §f§7");
								p.setDisplayName("§3§lYT+ §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
							    return true;
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
				  } else if(paramLocalArgs.equalsIgnoreCase("helper")) {
						try {
							if(MySQLManager.getRank(p) == 0) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 1) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 2) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 3) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 4) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 5) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 6) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 7) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 8) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 9) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §2§lHELPER §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§2§lHELPER §f§7");
								p.setDisplayName("§2§lHELPER §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
							    return true;
							} else if(MySQLManager.getRank(p) == 10) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §2§lHELPER §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§2§lHELPER §f§7");
								p.setDisplayName("§2§lHELPER §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
							    return true;
							} else if(MySQLManager.getRank(p) == 11) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §2§lHELPER §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§2§lHELPER §f§7");
								p.setDisplayName("§2§lHELPER §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
							    return true;
							} else if(MySQLManager.getRank(p) == 12) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §2§lHELPER §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§2§lHELPER §f§7");
								p.setDisplayName("§2§lHELPER §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
							    return true;
							} else if(MySQLManager.getRank(p) == 13) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §2§lHELPER §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§2§lHELPER §f§7");
								p.setDisplayName("§2§lHELPER §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
							    return true;
							} else if(MySQLManager.getRank(p) == 14) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §2§lHELPER §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§2§lHELPER §f§7");
								p.setDisplayName("§2§lHELPER §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
							    return true;
							} else if(MySQLManager.getRank(p) == 15) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §2§lHELPER §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§2§lHELPER §f§7");
								p.setDisplayName("§2§lHELPER §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
							    return true;
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
				  } else if(paramLocalArgs.equalsIgnoreCase("builder")) {
						try {
							if(MySQLManager.getRank(p) == 0) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 1) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 2) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 3) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 4) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 5) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 6) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 7) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 8) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 9) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 10) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §d§lBUILDER §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§d§lBUILDER §f§7");
								p.setDisplayName("§d§lBUILDER §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
							    return true;
							} else if(MySQLManager.getRank(p) == 11) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §d§lBUILDER §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§d§lBUILDER §f§7");
								p.setDisplayName("§d§lBUILDER §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
							    return true;
							} else if(MySQLManager.getRank(p) == 12) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §d§lBUILDER §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§d§lBUILDER §f§7");
								p.setDisplayName("§d§lBUILDER §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
							    return true;
							} else if(MySQLManager.getRank(p) == 13) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §d§lBUILDER §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§d§lBUILDER §f§7");
								p.setDisplayName("§d§lBUILDER §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
							    return true;
							} else if(MySQLManager.getRank(p) == 14) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §d§lBUILDER §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§d§lBUILDER §f§7");
								p.setDisplayName("§d§lBUILDER §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
							    return true;
							} else if(MySQLManager.getRank(p) == 15) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §d§lBUILDER §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§d§lBUILDER §f§7");
								p.setDisplayName("§d§lBUILDER §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
							    return true;
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
				  } else if(paramLocalArgs.equalsIgnoreCase("trial")) {
						try {
							if(MySQLManager.getRank(p) == 0) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 1) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 2) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 3) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 4) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 5) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 6) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 7) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 8) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 9) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 10) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 11) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §d§lTRIAL §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§d§lTRIAL §f§7");
								p.setDisplayName("§d§lTRIAL §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
							    return true;
							} else if(MySQLManager.getRank(p) == 12) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §d§lTRIAL §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§d§lTRIAL §f§7");
								p.setDisplayName("§d§lTRIAL §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
							    return true;
							} else if(MySQLManager.getRank(p) == 13) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §d§lTRIAL §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§d§lTRIAL §f§7");
								p.setDisplayName("§d§lTRIAL §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
							    return true;
							} else if(MySQLManager.getRank(p) == 14) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §d§lTRIAL §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§d§lTRIAL §f§7");
								p.setDisplayName("§d§lTRIAL §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
							    return true;
							} else if(MySQLManager.getRank(p) == 15) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §d§lTRIAL §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§d§lTRIAL §f§7");
								p.setDisplayName("§d§lTRIAL §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
							    return true;
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
				  } else if(paramLocalArgs.equalsIgnoreCase("mod")) {
						try {
							if(MySQLManager.getRank(p) == 0) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 1) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 2) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 3) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 4) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 5) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 6) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 7) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 8) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 9) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 10) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 11) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 12) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §5§lMOD §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§5§lMOD §f§7");
								p.setDisplayName("§5§lMOD §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
							    return true;
							} else if(MySQLManager.getRank(p) == 13) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §5§lMOD §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§5§lMOD §f§7");
								p.setDisplayName("§5§lMOD §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
							    return true;
							} else if(MySQLManager.getRank(p) == 14) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §5§lMOD §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§5§lMOD §f§7");
								p.setDisplayName("§5§lMOD §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
							    return true;
							} else if(MySQLManager.getRank(p) == 15) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §5§lMOD §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§5§lMOD §f§7");
								p.setDisplayName("§5§lMOD §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
							    return true;
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
				  } else if(paramLocalArgs.equalsIgnoreCase("adm")) {
						try {
							if(MySQLManager.getRank(p) == 0) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 1) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 2) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 3) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 4) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 5) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 6) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 7) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 8) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 9) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 10) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 11) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 12) {
							    p.sendMessage("§a§lTAGS §fVocê não tem permissão para aplicar essa tag.");
								Framework.sendTitle(p, "§4§lERRO");
								Framework.sendSubTitle(p, "§fVocê não tem permissão para aplicar essa tag.");
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
								return false;
							} else if(MySQLManager.getRank(p) == 13) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §c§lADM §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§c§lADM §f§7");
								p.setDisplayName("§c§lADM §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
							    return true;
							} else if(MySQLManager.getRank(p) == 14) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §c§lADM §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§c§lADM §f§7");
								p.setDisplayName("§c§lADM §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
							    return true;
							} else if(MySQLManager.getRank(p) == 15) {
								p.sendMessage("§a§lTAGS §fA sua tag exibida foi alterada para: §c§lADM §fcom sucesso.");
							    NametagAPI.setPrefix(p.getName(), "§c§lADM §f§7");
								p.setDisplayName("§c§lADM §f§7" + p.getName());
								Framework.sendTitle(p, "§a§lTAGS");
								Framework.sendSubTitle(p, "§7A sua tag em exibição foi alterada.");
								p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1.0F, 1.0F);
							    return true;
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
				} else {
					p.sendMessage("§a§lTAGS §fA Tag §c" + paramLocalArgs.toString() + " §fnão foi encontrada no banco de dados.");
					return false;
				}
		  }
		}
		
		if(parametroLabel.equalsIgnoreCase("chat")) {
			try {
				if(parametroArgumentos.length == 0) {
					if(MySQLManager.getRank(p) == 15) {
						Framework.sendTitle(p, "§a§lCHAT");
						Framework.sendSubTitle(p, "§7Comando Incorreto.");
						p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
						p.sendMessage("§a§lCHAT §fComando incorreto, use /chat (§eON§f,§eOFF§f ou §eLIMPAR§f).");
						return false;
					} else if(MySQLManager.getRank(p) == 14) {
						Framework.sendTitle(p, "§a§lCHAT");
						Framework.sendSubTitle(p, "§7Comando Incorreto.");
						p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
						p.sendMessage("§a§lCHAT §fComando incorreto, use /chat (§eON§f,§eOFF§f ou §eLIMPAR§f).");
						return false;
					} else if(MySQLManager.getRank(p) == 13) {
						Framework.sendTitle(p, "§a§lCHAT");
						Framework.sendSubTitle(p, "§7Comando Incorreto.");
						p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
						p.sendMessage("§a§lCHAT §fComando incorreto, use /chat (§eON§f,§eOFF§f ou §eLIMPAR§f).");
						return false;
					} else if(MySQLManager.getRank(p) == 12) {
						Framework.sendTitle(p, "§a§lCHAT");
						Framework.sendSubTitle(p, "§7Comando Incorreto.");
						p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
						p.sendMessage("§a§lCHAT §fComando incorreto, use /chat (§eON§f,§eOFF§f ou §eLIMPAR§f).");
						return false;
					} else {
						p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
					    p.sendMessage("§a§lCHAT §fComando não encontrado.");
					    Framework.sendTitle(p, "§4§lERRO");
					    Framework.sendSubTitle(p, "§fComando não registrado.");
						return false;
					}
				}
				
				if(parametroArgumentos.length == 1) {
					
				}
				
				if(parametroArgumentos.length == 1) {
					if(MySQLManager.getRank(p) == 15) {
						if(parametroArgumentos[0].equalsIgnoreCase("limpar")) {
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage("§b§m------------------------------------------------------");
							Bukkit.broadcastMessage("                        §6» §f§lO CHAT FOI LIMPO §f§6«");
							Bukkit.broadcastMessage("§b§m------------------------------------------------------");
							for(Player online : Bukkit.getOnlinePlayers()) {
								Framework.sendTitle(online, "§a§lCHAT");
								Framework.sendSubTitle(online, "§7O Chat foi limpo pelo CTI: §a" + p.getName());
								Framework.sendTimings(online, 10, 30, 10);
							}
							Framework.sendTitle(p, "§a§lCHAT");
							Framework.sendSubTitle(p, "§7Você limpou o chat.");
							return true;
						}
					}
					if(MySQLManager.getRank(p) == 14) {
						if(parametroArgumentos[0].equalsIgnoreCase("limpar")) {
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage("§b§m------------------------------------------------------");
							Bukkit.broadcastMessage("                        §6» §f§lO CHAT FOI LIMPO §f§6«");
							Bukkit.broadcastMessage("§b§m------------------------------------------------------");
							for(Player online : Bukkit.getOnlinePlayers()) {
								Framework.sendTitle(online, "§a§lCHAT");
								Framework.sendSubTitle(online, "§7O Chat foi limpo pelo CEO: §a" + p.getName());
								Framework.sendTimings(online, 10, 30, 10);
							}
							Framework.sendTitle(p, "§a§lCHAT");
							Framework.sendSubTitle(p, "§7Você limpou o chat.");
							return true;
						}
					}
					
					if(MySQLManager.getRank(p) == 13) {
						if(parametroArgumentos[0].equalsIgnoreCase("limpar")) {
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage("§b§m------------------------------------------------------");
							Bukkit.broadcastMessage("                        §6» §f§lO CHAT FOI LIMPO §f§6«");
							Bukkit.broadcastMessage("§b§m------------------------------------------------------");
							for(Player online : Bukkit.getOnlinePlayers()) {
								Framework.sendTitle(online, "§a§lCHAT");
								Framework.sendSubTitle(online, "§7O Chat foi limpo pelo Administrador: §a" + p.getName());
								Framework.sendTimings(online, 10, 30, 10);
							}
							Framework.sendTitle(p, "§a§lCHAT");
							Framework.sendSubTitle(p, "§7Você limpou o chat.");
							return true;
						}
					}
					
					if(MySQLManager.getRank(p) == 12) {
						if(parametroArgumentos[0].equalsIgnoreCase("limpar")) {
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage(" ");
							Bukkit.broadcastMessage("§b§m------------------------------------------------------");
							Bukkit.broadcastMessage("                        §6» §f§lO CHAT FOI LIMPO §f§6«");
							Bukkit.broadcastMessage("§b§m------------------------------------------------------");
							for(Player online : Bukkit.getOnlinePlayers()) {
								Framework.sendTitle(online, "§a§lCHAT");
								Framework.sendSubTitle(online, "§7O Chat foi limpo pelo Moderador: §a" + p.getName());
								Framework.sendTimings(online, 10, 30, 10);
							}
							Framework.sendTitle(p, "§a§lCHAT");
							Framework.sendSubTitle(p, "§7Você limpou o chat.");
							return true;
						}
					}
					
					if(parametroArgumentos[0].equalsIgnoreCase("on")) {
						if(MySQLManager.getRank(p) == 15) {
							if(MySQLManager.getStatusChat() == 0) {
								p.sendMessage("§a§lCHAT §fO chat já está ATIVO.");
								return false;
							}
							
							if(MySQLManager.getStatusChat() == 1) {
								p.sendMessage("§a§lCHAT §fO chat foi definido como §a§lATIVO§f.");
								MySQLManager.updateChat(0, p);
								for(Player online : Bukkit.getOnlinePlayers()) {
									Framework.sendTitle(online, "§a§lCHAT");
									Framework.sendSubTitle(online, "§7O Chat foi ativado pelo CTI: §a" + p.getName());
									Framework.sendTimings(online, 10, 30, 10);
								}
								Framework.sendTitle(p, "§a§lCHAT");
								Framework.sendSubTitle(p, "§7Você §a§nativou§f o chat.");
								return true;
							}
						}else
						
						if(MySQLManager.getRank(p) == 14) {
							if(MySQLManager.getStatusChat() == 0) {
								p.sendMessage("§a§lCHAT §fO chat já está ATIVO.");
								return false;
							}
							
							if(MySQLManager.getStatusChat() == 1) {
								p.sendMessage("§a§lCHAT §fO chat foi definido como §a§lATIVO§f.");
								MySQLManager.updateChat(0, p);
								for(Player online : Bukkit.getOnlinePlayers()) {
									Framework.sendTitle(online, "§a§lCHAT");
									Framework.sendSubTitle(online, "§7O Chat foi ativado pelo CEO: §a" + p.getName());
									Framework.sendTimings(online, 10, 30, 10);
								}
								Framework.sendTitle(p, "§a§lCHAT");
								Framework.sendSubTitle(p, "§7Você §a§nativou§f o chat.");
								return true;
							}
						}else
						
						if(MySQLManager.getRank(p) == 13) {
							if(MySQLManager.getStatusChat() == 0) {
								p.sendMessage("§a§lCHAT §fO chat já está ATIVO.");
								return false;
							}
							
							if(MySQLManager.getStatusChat() == 1) {
								p.sendMessage("§a§lCHAT §fO chat foi definido como §a§lATIVO§f.");
								MySQLManager.updateChat(0, p);
								for(Player online : Bukkit.getOnlinePlayers()) {
									Framework.sendTitle(online, "§a§lCHAT");
									Framework.sendSubTitle(online, "§7O Chat foi ativado pelo Administrador: §a" + p.getName());
									Framework.sendTimings(online, 10, 30, 10);
								}
								Framework.sendTitle(p, "§a§lCHAT");
								Framework.sendSubTitle(p, "§7Você §a§nativou§f o chat.");
								return true;
							}
						}else
						if(MySQLManager.getRank(p) == 12) {
							if(MySQLManager.getStatusChat() == 0) {
								p.sendMessage("§a§lCHAT §fO chat já está ATIVO.");
								return false;
							}
							
							if(MySQLManager.getStatusChat() == 1) {
								p.sendMessage("§a§lCHAT §fO chat foi definido como §a§lATIVO§f.");
								MySQLManager.updateChat(0, p);
								for(Player online : Bukkit.getOnlinePlayers()) {
									Framework.sendTitle(online, "§a§lCHAT");
									Framework.sendSubTitle(online, "§7O Chat foi ativado pelo Moderador: §a" + p.getName());
									Framework.sendTimings(online, 10, 30, 10);
								}
								Framework.sendTitle(p, "§a§lCHAT");
								Framework.sendSubTitle(p, "§7Você §a§nativou§f o chat.");
								return true;
							}
						} else if(MySQLManager.getRank(p) == 11) {
							p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
						    p.sendMessage("§a§lCHAT §fComando não encontrado.");
						    Framework.sendTitle(p, "§4§lERRO");
						    Framework.sendSubTitle(p, "§fComando não registrado.");
							return false;
						} else
						if(MySQLManager.getRank(p) == 10) {
							p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
						    p.sendMessage("§a§lCHAT §fComando não encontrado.");
						    Framework.sendTitle(p, "§4§lERRO");
						    Framework.sendSubTitle(p, "§fComando não registrado.");
							return false;
						}else
						if(MySQLManager.getRank(p) == 9) {
							p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
						    p.sendMessage("§a§lCHAT §fComando não encontrado.");
						    Framework.sendTitle(p, "§4§lERRO");
						    Framework.sendSubTitle(p, "§fComando não registrado.");
							return false;
						}else
						if(MySQLManager.getRank(p) == 8) {
							p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
						    p.sendMessage("§a§lCHAT §fComando não encontrado.");
						    Framework.sendTitle(p, "§4§lERRO");
						    Framework.sendSubTitle(p, "§fComando não registrado.");
							return false;
						}else
						if(MySQLManager.getRank(p) == 7) {
							p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
						    p.sendMessage("§a§lCHAT §fComando não encontrado.");
						    Framework.sendTitle(p, "§4§lERRO");
						    Framework.sendSubTitle(p, "§fComando não registrado.");
							return false;
						}else
						if(MySQLManager.getRank(p) == 6) {
							p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
						    p.sendMessage("§a§lCHAT §fComando não encontrado.");
						    Framework.sendTitle(p, "§4§lERRO");
						    Framework.sendSubTitle(p, "§fComando não registrado.");
							return false;
						}else
						if(MySQLManager.getRank(p) == 5) {
							p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
						    p.sendMessage("§a§lCHAT §fComando não encontrado.");
						    Framework.sendTitle(p, "§4§lERRO");
						    Framework.sendSubTitle(p, "§fComando não registrado.");
							return false;
						}else
						if(MySQLManager.getRank(p) == 4) {
							p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
						    p.sendMessage("§a§lCHAT §fComando não encontrado.");
						    Framework.sendTitle(p, "§4§lERRO");
						    Framework.sendSubTitle(p, "§fComando não registrado.");
							return false;
						}else
						if(MySQLManager.getRank(p) == 3) {
							p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
						    p.sendMessage("§a§lCHAT §fComando não encontrado.");
						    Framework.sendTitle(p, "§4§lERRO");
						    Framework.sendSubTitle(p, "§fComando não registrado.");
							return false;
						}else
						if(MySQLManager.getRank(p) == 2) {
							p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
						    p.sendMessage("§a§lCHAT §fComando não encontrado.");
						    Framework.sendTitle(p, "§4§lERRO");
						    Framework.sendSubTitle(p, "§fComando não registrado.");
							return false;
						}else
						if(MySQLManager.getRank(p) == 1) {
							p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
						    p.sendMessage("§a§lCHAT §fComando não encontrado.");
						    Framework.sendTitle(p, "§4§lERRO");
						    Framework.sendSubTitle(p, "§fComando não registrado.");
							return false;
						}else
						if(MySQLManager.getRank(p) == 0) {
							p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
						    p.sendMessage("§a§lCHAT §fComando não encontrado.");
						    Framework.sendTitle(p, "§4§lERRO");
						    Framework.sendSubTitle(p, "§fComando não registrado.");
							return false;
						}
					}
					
					if(parametroArgumentos[0].equalsIgnoreCase("off")) {
						if(MySQLManager.getRank(p) == 15) {
							if(MySQLManager.getStatusChat() == 1) {
								p.sendMessage("§a§lCHAT §fO chat já está DESATIVADO.");
								return false;
							}
							
							if(MySQLManager.getStatusChat() == 0) {
								p.sendMessage("§a§lCHAT §fO chat foi definido como §c§lDESATIVADO§f.");
								MySQLManager.updateChat(1, p);
								for(Player online : Bukkit.getOnlinePlayers()) {
									Framework.sendTitle(online, "§a§lCHAT");
									Framework.sendSubTitle(online, "§7O Chat foi desativado pelo CTI: §a" + p.getName());
									Framework.sendTimings(online, 10, 30, 10);
								}
								Framework.sendTitle(p, "§a§lCHAT");
								Framework.sendSubTitle(p, "§7Você §c§ndesativou§f o chat.");
								return false;
							}
						} else 
						if(MySQLManager.getRank(p) == 14) {
							if(MySQLManager.getStatusChat() == 1) {
								p.sendMessage("§a§lCHAT §fO chat já está DESATIVADO.");
								return false;
							}
							
							if(MySQLManager.getStatusChat() == 0) {
								p.sendMessage("§a§lCHAT §fO chat foi definido como §c§lDESATIVADO§f.");
								MySQLManager.updateChat(1, p);
								for(Player online : Bukkit.getOnlinePlayers()) {
									Framework.sendTitle(online, "§a§lCHAT");
									Framework.sendSubTitle(online, "§7O Chat foi desativado pelo CEO: §a" + p.getName());
									Framework.sendTimings(online, 10, 30, 10);
								}
								Framework.sendTitle(p, "§a§lCHAT");
								Framework.sendSubTitle(p, "§7Você §c§ndesativou§f o chat.");
								return false;
							}
						} else if(MySQLManager.getRank(p) == 13) {
							if(MySQLManager.getStatusChat() == 1) {
								p.sendMessage("§a§lCHAT §fO chat já está DESATIVADO.");
								return false;
							}
							
							if(MySQLManager.getStatusChat() == 0) {
								p.sendMessage("§a§lCHAT §fO chat foi definido como §c§lDESATIVADO§f.");
								MySQLManager.updateChat(1, p);
								for(Player online : Bukkit.getOnlinePlayers()) {
									Framework.sendTitle(online, "§a§lCHAT");
									Framework.sendSubTitle(online, "§7O Chat foi desativado pelo Administrador: §a" + p.getName());
									Framework.sendTimings(online, 10, 30, 10);
								}
								Framework.sendTitle(p, "§a§lCHAT");
								Framework.sendSubTitle(p, "§7Você §c§ndesativou§f o chat.");
								return false;
							}
						} else if(MySQLManager.getRank(p) == 12) {
							if(MySQLManager.getStatusChat() == 1) {
								p.sendMessage("§a§lCHAT §fO chat já está DESATIVADO.");
								return false;
							}
							
							if(MySQLManager.getStatusChat() == 0) {
								p.sendMessage("§a§lCHAT §fO chat foi definido como §c§lDESATIVADO§f.");
								MySQLManager.updateChat(1, p);
								for(Player online : Bukkit.getOnlinePlayers()) {
									Framework.sendTitle(online, "§a§lCHAT");
									Framework.sendSubTitle(online, "§7O Chat foi desativado pelo Moderador: §a" + p.getName());
									Framework.sendTimings(online, 10, 30, 10);
								}
								Framework.sendTitle(p, "§a§lCHAT");
								Framework.sendSubTitle(p, "§7Você §c§ndesativou§f o chat.");
								return false;
							}
						} else if(MySQLManager.getRank(p) == 11) {
							p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
						    p.sendMessage("§a§lCHAT §fComando não encontrado.");
						    Framework.sendTitle(p, "§4§lERRO");
						    Framework.sendSubTitle(p, "§fComando não registrado.");
							return false;
						} else
						if(MySQLManager.getRank(p) == 10) {
							p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
						    p.sendMessage("§a§lCHAT §fComando não encontrado.");
						    Framework.sendTitle(p, "§4§lERRO");
						    Framework.sendSubTitle(p, "§fComando não registrado.");
							return false;
						}else
						if(MySQLManager.getRank(p) == 9) {
							p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
						    p.sendMessage("§a§lCHAT §fComando não encontrado.");
						    Framework.sendTitle(p, "§4§lERRO");
						    Framework.sendSubTitle(p, "§fComando não registrado.");
							return false;
						}else
						if(MySQLManager.getRank(p) == 8) {
							p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
						    p.sendMessage("§a§lCHAT §fComando não encontrado.");
						    Framework.sendTitle(p, "§4§lERRO");
						    Framework.sendSubTitle(p, "§fComando não registrado.");
							return false;
						}else
						if(MySQLManager.getRank(p) == 7) {
							p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
						    p.sendMessage("§a§lCHAT §fComando não encontrado.");
						    Framework.sendTitle(p, "§4§lERRO");
						    Framework.sendSubTitle(p, "§fComando não registrado.");
							return false;
						}else
						if(MySQLManager.getRank(p) == 6) {
							p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
						    p.sendMessage("§a§lCHAT §fComando não encontrado.");
						    Framework.sendTitle(p, "§4§lERRO");
						    Framework.sendSubTitle(p, "§fComando não registrado.");
							return false;
						}else
						if(MySQLManager.getRank(p) == 5) {
							p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
						    p.sendMessage("§a§lCHAT §fComando não encontrado.");
						    Framework.sendTitle(p, "§4§lERRO");
						    Framework.sendSubTitle(p, "§fComando não registrado.");
							return false;
						}else
						if(MySQLManager.getRank(p) == 4) {
							p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
						    p.sendMessage("§a§lCHAT §fComando não encontrado.");
						    Framework.sendTitle(p, "§4§lERRO");
						    Framework.sendSubTitle(p, "§fComando não registrado.");
							return false;
						}else
						if(MySQLManager.getRank(p) == 3) {
							p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
						    p.sendMessage("§a§lCHAT §fComando não encontrado.");
						    Framework.sendTitle(p, "§4§lERRO");
						    Framework.sendSubTitle(p, "§fComando não registrado.");
							return false;
						}else
						if(MySQLManager.getRank(p) == 2) {
							p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
						    p.sendMessage("§a§lCHAT §fComando não encontrado.");
						    Framework.sendTitle(p, "§4§lERRO");
						    Framework.sendSubTitle(p, "§fComando não registrado.");
							return false;
						}else
						if(MySQLManager.getRank(p) == 1) {
							p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
						    p.sendMessage("§a§lCHAT §fComando não encontrado.");
						    Framework.sendTitle(p, "§4§lERRO");
						    Framework.sendSubTitle(p, "§fComando não registrado.");
							return false;
						}else
						if(MySQLManager.getRank(p) == 0) {
							p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
						    p.sendMessage("§a§lCHAT §fComando não encontrado.");
						    Framework.sendTitle(p, "§4§lERRO");
						    Framework.sendSubTitle(p, "§fComando não registrado.");
							return false;
						}
					}
				} else if(parametroArgumentos.length > 1) {
					if(MySQLManager.getRank(p) == 15) {
						p.sendMessage("§a§lCHAT §fComando incorreto, use /chat (§eON§f,§eOFF§f ou §eLIMPAR§f).");
						return false;
					} else if(MySQLManager.getRank(p) == 14) {
						p.sendMessage("§a§lCHAT §fComando incorreto, use /chat (§eON§f,§eOFF§f ou §eLIMPAR§f).");
						return false;
					} else if(MySQLManager.getRank(p) == 13) {
						p.sendMessage("§a§lCHAT §fComando incorreto, use /chat (§eON§f,§eOFF§f ou §eLIMPAR§f).");
						return false;
					} else if(MySQLManager.getRank(p) == 12) {
						p.sendMessage("§a§lCHAT §fComando incorreto, use /chat (§eON§f,§eOFF§f ou §eLIMPAR§f).");
						return false;
					} else {
						p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
					    p.sendMessage("§a§lCHAT §fComando não encontrado.");
					    Framework.sendTitle(p, "§4§lERRO");
					    Framework.sendSubTitle(p, "§fComando não registrado.");
						return false;
					}
				}
				
				if(!parametroArgumentos[0].equalsIgnoreCase("off")) {
					p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
				    p.sendMessage("§a§lCHAT §fComando não encontrado.");
				    Framework.sendTitle(p, "§4§lERRO");
				    Framework.sendSubTitle(p, "§fComando não registrado.");
					return false;
				}
				
				if(!parametroArgumentos[0].equalsIgnoreCase("on")) {
					p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
				    p.sendMessage("§a§lCHAT §fComando não encontrado.");
				    Framework.sendTitle(p, "§4§lERRO");
				    Framework.sendSubTitle(p, "§fComando não registrado.");
					return false;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if(parametroLabel.equalsIgnoreCase("gm")) {
			if(parametroArgumentos.length != 1) {
				try {
					if(MySQLManager.getRank(p) == 15) {
						p.sendMessage("§e§lGAMEMODE §fComando incorreto, use /gm (§e1§f ou §e0§f).");
						return false;
					} else if(MySQLManager.getRank(p) == 14) {
						p.sendMessage("§e§lGAMEMODE §fComando incorreto, use /gm (§e1§f ou §e0§f).");
						return false;
					} else  if(MySQLManager.getRank(p) == 13) {
						p.sendMessage("§e§lGAMEMODE §fComando incorreto, use /gm (§e1§f ou §e0§f).");
						return false;
					} else if(MySQLManager.getRank(p) == 12) {
						p.sendMessage("§e§lGAMEMODE §fComando incorreto, use /gm (§e1§f ou §e0§f).");
						return false;
					} else if(MySQLManager.getRank(p) == 11) {
						p.sendMessage("§e§lGAMEMODE §fComando incorreto, use /gm (§e1§f ou §e0§f).");
						return false;
					} else
					if(MySQLManager.getRank(p) == 10) {
						p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
					    p.sendMessage("§a§lCHAT §fComando não encontrado.");
					    Framework.sendTitle(p, "§4§lERRO");
					    Framework.sendSubTitle(p, "§fComando não registrado.");
						return false;
					}else
					if(MySQLManager.getRank(p) == 9) {
						p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
					    p.sendMessage("§a§lCHAT §fComando não encontrado.");
					    Framework.sendTitle(p, "§4§lERRO");
					    Framework.sendSubTitle(p, "§fComando não registrado.");
						return false;
					}else
					if(MySQLManager.getRank(p) == 8) {
						p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
					    p.sendMessage("§a§lCHAT §fComando não encontrado.");
					    Framework.sendTitle(p, "§4§lERRO");
					    Framework.sendSubTitle(p, "§fComando não registrado.");
						return false;
					}else
					if(MySQLManager.getRank(p) == 7) {
						p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
					    p.sendMessage("§a§lCHAT §fComando não encontrado.");
					    Framework.sendTitle(p, "§4§lERRO");
					    Framework.sendSubTitle(p, "§fComando não registrado.");
						return false;
					}else
					if(MySQLManager.getRank(p) == 6) {
						p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
					    p.sendMessage("§a§lCHAT §fComando não encontrado.");
					    Framework.sendTitle(p, "§4§lERRO");
					    Framework.sendSubTitle(p, "§fComando não registrado.");
						return false;
					}else
					if(MySQLManager.getRank(p) == 5) {
						p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
					    p.sendMessage("§a§lCHAT §fComando não encontrado.");
					    Framework.sendTitle(p, "§4§lERRO");
					    Framework.sendSubTitle(p, "§fComando não registrado.");
						return false;
					}else
					if(MySQLManager.getRank(p) == 4) {
						p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
					    p.sendMessage("§a§lCHAT §fComando não encontrado.");
					    Framework.sendTitle(p, "§4§lERRO");
					    Framework.sendSubTitle(p, "§fComando não registrado.");
						return false;
					}else
					if(MySQLManager.getRank(p) == 3) {
						p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
					    p.sendMessage("§a§lCHAT §fComando não encontrado.");
					    Framework.sendTitle(p, "§4§lERRO");
					    Framework.sendSubTitle(p, "§fComando não registrado.");
						return false;
					}else
					if(MySQLManager.getRank(p) == 2) {
						p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
					    p.sendMessage("§a§lCHAT §fComando não encontrado.");
					    Framework.sendTitle(p, "§4§lERRO");
					    Framework.sendSubTitle(p, "§fComando não registrado.");
						return false;
					}else
					if(MySQLManager.getRank(p) == 1) {
						p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
					    p.sendMessage("§a§lCHAT §fComando não encontrado.");
					    Framework.sendTitle(p, "§4§lERRO");
					    Framework.sendSubTitle(p, "§fComando não registrado.");
						return false;
					}else
					if(MySQLManager.getRank(p) == 0) {
						p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
					    p.sendMessage("§a§lCHAT §fComando não encontrado.");
					    Framework.sendTitle(p, "§4§lERRO");
					    Framework.sendSubTitle(p, "§fComando não registrado.");
						return false;
					}
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if(parametroArgumentos.length == 1) {
				if(parametroArgumentos[0].equalsIgnoreCase("1")) {
					try {
						if(MySQLManager.getRank(p) == 15) {
							p.sendMessage("§a§lGAMEMODE §fModo de jogo alterado para §a§nCRIATIVO§f.");
							p.setGameMode(GameMode.CREATIVE);
							for(Player online : Bukkit.getOnlinePlayers()) {
								try {
									if(MySQLManager.getRank(online) == 15) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) + " §f§7trocou o modo de jogo para CRIATIVO!");
									}
									if(MySQLManager.getRank(online) == 14) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) + " §f§7trocou o modo de jogo para CRIATIVO!");
									}
									if(MySQLManager.getRank(online) == 13) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) + " §f§7trocou o modo de jogo para CRIATIVO!");
									}
									if(MySQLManager.getRank(online) == 12) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) + " §f§7trocou o modo de jogo para CRIATIVO!");
									}
									if(MySQLManager.getRank(online) == 11) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) + " §f§7trocou o modo de jogo para CRIATIVO!");
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						} else if(MySQLManager.getRank(p) == 14) {
							p.sendMessage("§a§lGAMEMODE §fModo de jogo alterado para §a§nCRIATIVO§f.");
							p.setGameMode(GameMode.CREATIVE);
							for(Player online : Bukkit.getOnlinePlayers()) {
								try {
									if(MySQLManager.getRank(online) == 15) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) + " §f§7trocou o modo de jogo para CRIATIVO!");
									}
									if(MySQLManager.getRank(online) == 14) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) + " §f§7trocou o modo de jogo para CRIATIVO!");
									}
									if(MySQLManager.getRank(online) == 13) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) + " §f§7trocou o modo de jogo para CRIATIVO!");
									}
									if(MySQLManager.getRank(online) == 12) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) + " §f§7trocou o modo de jogo para CRIATIVO!");
									}
									if(MySQLManager.getRank(online) == 11) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) + " §f§7trocou o modo de jogo para CRIATIVO!");
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						} else  if(MySQLManager.getRank(p) == 13) {
							p.sendMessage("§a§lGAMEMODE §fModo de jogo alterado para §a§nCRIATIVO§f.");
							p.setGameMode(GameMode.CREATIVE);
							for(Player online : Bukkit.getOnlinePlayers()) {
								try {
									if(MySQLManager.getRank(online) == 15) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) + " §f§7trocou o modo de jogo para CRIATIVO!");
									}
									if(MySQLManager.getRank(online) == 14) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) + " §f§7trocou o modo de jogo para CRIATIVO!");
									}
									if(MySQLManager.getRank(online) == 13) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) + " §f§7trocou o modo de jogo para CRIATIVO!");
									}
									if(MySQLManager.getRank(online) == 12) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) + " §f§7trocou o modo de jogo para CRIATIVO!");
									}
									if(MySQLManager.getRank(online) == 11) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) + " §f§7trocou o modo de jogo para CRIATIVO!");
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						} else if(MySQLManager.getRank(p) == 12) {
							p.sendMessage("§a§lGAMEMODE §fModo de jogo alterado para §a§nCRIATIVO§f.");
							p.setGameMode(GameMode.CREATIVE);
							for(Player online : Bukkit.getOnlinePlayers()) {
								try {
									if(MySQLManager.getRank(online) == 15) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) + " §f§7trocou o modo de jogo para CRIATIVO!");
									}
									if(MySQLManager.getRank(online) == 14) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) + " §f§7trocou o modo de jogo para CRIATIVO!");
									}
									if(MySQLManager.getRank(online) == 13) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) + " §f§7trocou o modo de jogo para CRIATIVO!");
									}
									if(MySQLManager.getRank(online) == 12) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) + " §f§7trocou o modo de jogo para CRIATIVO!");
									}
									if(MySQLManager.getRank(online) == 11) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) + " §f§7trocou o modo de jogo para CRIATIVO!");
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						} else if(MySQLManager.getRank(p) == 11) {
							p.sendMessage("§a§lGAMEMODE §fModo de jogo alterado para §a§nCRIATIVO§f.");
							p.setGameMode(GameMode.CREATIVE);
							for(Player online : Bukkit.getOnlinePlayers()) {
								try {
									if(MySQLManager.getRank(online) == 15) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) + " §f§7trocou o modo de jogo para CRIATIVO!");
									}
									if(MySQLManager.getRank(online) == 14) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) + " §f§7trocou o modo de jogo para CRIATIVO!");
									}
									if(MySQLManager.getRank(online) == 13) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) + " §f§7trocou o modo de jogo para CRIATIVO!");
									}
									if(MySQLManager.getRank(online) == 12) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) + " §f§7trocou o modo de jogo para CRIATIVO!");
									}
									if(MySQLManager.getRank(online) == 11) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) + " §f§7trocou o modo de jogo para CRIATIVO!");
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						} else
						if(MySQLManager.getRank(p) == 10) {
							p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
						    p.sendMessage("§a§lCHAT §fComando não encontrado.");
						    Framework.sendTitle(p, "§4§lERRO");
						    Framework.sendSubTitle(p, "§fComando não registrado.");
							return false;
						}else
						if(MySQLManager.getRank(p) == 9) {
							p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
						    p.sendMessage("§a§lCHAT §fComando não encontrado.");
						    Framework.sendTitle(p, "§4§lERRO");
						    Framework.sendSubTitle(p, "§fComando não registrado.");
							return false;
						}else
						if(MySQLManager.getRank(p) == 8) {
							p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
						    p.sendMessage("§a§lCHAT §fComando não encontrado.");
						    Framework.sendTitle(p, "§4§lERRO");
						    Framework.sendSubTitle(p, "§fComando não registrado.");
							return false;
						}else
						if(MySQLManager.getRank(p) == 7) {
							p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
						    p.sendMessage("§a§lCHAT §fComando não encontrado.");
						    Framework.sendTitle(p, "§4§lERRO");
						    Framework.sendSubTitle(p, "§fComando não registrado.");
							return false;
						}else
						if(MySQLManager.getRank(p) == 6) {
							p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
						    p.sendMessage("§a§lCHAT §fComando não encontrado.");
						    Framework.sendTitle(p, "§4§lERRO");
						    Framework.sendSubTitle(p, "§fComando não registrado.");
							return false;
						}else
						if(MySQLManager.getRank(p) == 5) {
							p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
						    p.sendMessage("§a§lCHAT §fComando não encontrado.");
						    Framework.sendTitle(p, "§4§lERRO");
						    Framework.sendSubTitle(p, "§fComando não registrado.");
							return false;
						}else
						if(MySQLManager.getRank(p) == 4) {
							p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
						    p.sendMessage("§a§lCHAT §fComando não encontrado.");
						    Framework.sendTitle(p, "§4§lERRO");
						    Framework.sendSubTitle(p, "§fComando não registrado.");
							return false;
						}else
						if(MySQLManager.getRank(p) == 3) {
							p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
						    p.sendMessage("§a§lCHAT §fComando não encontrado.");
						    Framework.sendTitle(p, "§4§lERRO");
						    Framework.sendSubTitle(p, "§fComando não registrado.");
							return false;
						}else
						if(MySQLManager.getRank(p) == 2) {
							p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
						    p.sendMessage("§a§lCHAT §fComando não encontrado.");
						    Framework.sendTitle(p, "§4§lERRO");
						    Framework.sendSubTitle(p, "§fComando não registrado.");
							return false;
						}else
						if(MySQLManager.getRank(p) == 1) {
							p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
						    p.sendMessage("§a§lCHAT §fComando não encontrado.");
						    Framework.sendTitle(p, "§4§lERRO");
						    Framework.sendSubTitle(p, "§fComando não registrado.");
							return false;
						}else
						if(MySQLManager.getRank(p) == 0) {
							p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
						    p.sendMessage("§a§lCHAT §fComando não encontrado.");
						    Framework.sendTitle(p, "§4§lERRO");
						    Framework.sendSubTitle(p, "§fComando não registrado.");
							return false;
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				
				if(parametroArgumentos[0].equalsIgnoreCase("0")) {
					try {
						if(MySQLManager.getRank(p) == 15) {
							p.sendMessage("§a§lGAMEMODE §fModo de jogo alterado para §c§nsobrevivência§f.");
							p.setGameMode(GameMode.SURVIVAL);
							p.setFlying(false);
							for(Player online : Bukkit.getOnlinePlayers()) {
								try {
									if(MySQLManager.getRank(online) == 15) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) +" §f§7trocou o modo de jogo para SOBREVIVÊNCIA!");
									}
									if(MySQLManager.getRank(online) == 14) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) +" §f§7trocou o modo de jogo para SOBREVIVÊNCIA!");
									}
									if(MySQLManager.getRank(online) == 13) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) +" §f§7trocou o modo de jogo para SOBREVIVÊNCIA!");
									}
									if(MySQLManager.getRank(online) == 12) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) +" §f§7trocou o modo de jogo para SOBREVIVÊNCIA!");
									}
									if(MySQLManager.getRank(online) == 11) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) +" §f§7trocou o modo de jogo para SOBREVIVÊNCIA!");
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
							return true;
						} else if(MySQLManager.getRank(p) == 14) {
							p.sendMessage("§a§lGAMEMODE §fModo de jogo alterado para §c§nsobrevivência§f.");
							p.setGameMode(GameMode.SURVIVAL);
							p.setFlying(false);
							for(Player online : Bukkit.getOnlinePlayers()) {
								try {
									if(MySQLManager.getRank(online) == 15) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) +" §f§7trocou o modo de jogo para SOBREVIVÊNCIA!");
									}
									if(MySQLManager.getRank(online) == 14) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) +" §f§7trocou o modo de jogo para SOBREVIVÊNCIA!");
									}
									if(MySQLManager.getRank(online) == 13) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) +" §f§7trocou o modo de jogo para SOBREVIVÊNCIA!");
									}
									if(MySQLManager.getRank(online) == 12) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) +" §f§7trocou o modo de jogo para SOBREVIVÊNCIA!");
									}
									if(MySQLManager.getRank(online) == 11) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) +" §f§7trocou o modo de jogo para SOBREVIVÊNCIA!");
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
							return true;
						} else  if(MySQLManager.getRank(p) == 13) {
							p.sendMessage("§a§lGAMEMODE §fModo de jogo alterado para §c§nsobrevivência§f.");
							p.setGameMode(GameMode.SURVIVAL);
							p.setFlying(false);
							for(Player online : Bukkit.getOnlinePlayers()) {
								try {
									if(MySQLManager.getRank(online) == 15) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) +" §f§7trocou o modo de jogo para SOBREVIVÊNCIA!");
									}
									if(MySQLManager.getRank(online) == 14) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) +" §f§7trocou o modo de jogo para SOBREVIVÊNCIA!");
									}
									if(MySQLManager.getRank(online) == 13) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) +" §f§7trocou o modo de jogo para SOBREVIVÊNCIA!");
									}
									if(MySQLManager.getRank(online) == 12) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) +" §f§7trocou o modo de jogo para SOBREVIVÊNCIA!");
									}
									if(MySQLManager.getRank(online) == 11) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) +" §f§7trocou o modo de jogo para SOBREVIVÊNCIA!");
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
							return true;
						} else if(MySQLManager.getRank(p) == 12) {
							p.sendMessage("§a§lGAMEMODE §fModo de jogo alterado para §c§nsobrevivência§f.");
							p.setGameMode(GameMode.SURVIVAL);
							p.setFlying(false);
							for(Player online : Bukkit.getOnlinePlayers()) {
								try {
									if(MySQLManager.getRank(online) == 15) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) +" §f§7trocou o modo de jogo para SOBREVIVÊNCIA!");
									}
									if(MySQLManager.getRank(online) == 14) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) +" §f§7trocou o modo de jogo para SOBREVIVÊNCIA!");
									}
									if(MySQLManager.getRank(online) == 13) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) +" §f§7trocou o modo de jogo para SOBREVIVÊNCIA!");
									}
									if(MySQLManager.getRank(online) == 12) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) +" §f§7trocou o modo de jogo para SOBREVIVÊNCIA!");
									}
									if(MySQLManager.getRank(online) == 11) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) +" §f§7trocou o modo de jogo para SOBREVIVÊNCIA!");
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
							return true;
						} else if(MySQLManager.getRank(p) == 11) {
							p.sendMessage("§a§lGAMEMODE §fModo de jogo alterado para §c§nsobrevivência§f.");
							p.setGameMode(GameMode.SURVIVAL);
							p.setFlying(false);
							for(Player online : Bukkit.getOnlinePlayers()) {
								try {
									if(MySQLManager.getRank(online) == 15) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) +" §f§7trocou o modo de jogo para SOBREVIVÊNCIA!");
									}
									if(MySQLManager.getRank(online) == 14) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) +" §f§7trocou o modo de jogo para SOBREVIVÊNCIA!");
									}
									if(MySQLManager.getRank(online) == 13) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) +" §f§7trocou o modo de jogo para SOBREVIVÊNCIA!");
									}
									if(MySQLManager.getRank(online) == 12) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) +" §f§7trocou o modo de jogo para SOBREVIVÊNCIA!");
									}
									if(MySQLManager.getRank(online) == 11) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) +" §f§7trocou o modo de jogo para SOBREVIVÊNCIA!");
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
							return true;
						} else
						if(MySQLManager.getRank(p) == 10) {
							p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
						    p.sendMessage("§a§lCHAT §fComando não encontrado.");
						    Framework.sendTitle(p, "§4§lERRO");
						    Framework.sendSubTitle(p, "§fComando não registrado.");
							return false;
						}else
						if(MySQLManager.getRank(p) == 9) {
							p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
						    p.sendMessage("§a§lCHAT §fComando não encontrado.");
						    Framework.sendTitle(p, "§4§lERRO");
						    Framework.sendSubTitle(p, "§fComando não registrado.");
							return false;
						}else
						if(MySQLManager.getRank(p) == 8) {
							p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
						    p.sendMessage("§a§lCHAT §fComando não encontrado.");
						    Framework.sendTitle(p, "§4§lERRO");
						    Framework.sendSubTitle(p, "§fComando não registrado.");
							return false;
						}else
						if(MySQLManager.getRank(p) == 7) {
							p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
						    p.sendMessage("§a§lCHAT §fComando não encontrado.");
						    Framework.sendTitle(p, "§4§lERRO");
						    Framework.sendSubTitle(p, "§fComando não registrado.");
							return false;
						}else
						if(MySQLManager.getRank(p) == 6) {
							p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
						    p.sendMessage("§a§lCHAT §fComando não encontrado.");
						    Framework.sendTitle(p, "§4§lERRO");
						    Framework.sendSubTitle(p, "§fComando não registrado.");
							return false;
						}else
						if(MySQLManager.getRank(p) == 5) {
							p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
						    p.sendMessage("§a§lCHAT §fComando não encontrado.");
						    Framework.sendTitle(p, "§4§lERRO");
						    Framework.sendSubTitle(p, "§fComando não registrado.");
							return false;
						}else
						if(MySQLManager.getRank(p) == 4) {
							p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
						    p.sendMessage("§a§lCHAT §fComando não encontrado.");
						    Framework.sendTitle(p, "§4§lERRO");
						    Framework.sendSubTitle(p, "§fComando não registrado.");
							return false;
						}else
						if(MySQLManager.getRank(p) == 3) {
							p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
						    p.sendMessage("§a§lCHAT §fComando não encontrado.");
						    Framework.sendTitle(p, "§4§lERRO");
						    Framework.sendSubTitle(p, "§fComando não registrado.");
							return false;
						}else
						if(MySQLManager.getRank(p) == 2) {
							p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
						    p.sendMessage("§a§lCHAT §fComando não encontrado.");
						    Framework.sendTitle(p, "§4§lERRO");
						    Framework.sendSubTitle(p, "§fComando não registrado.");
							return false;
						}else
						if(MySQLManager.getRank(p) == 1) {
							p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
						    p.sendMessage("§a§lCHAT §fComando não encontrado.");
						    Framework.sendTitle(p, "§4§lERRO");
						    Framework.sendSubTitle(p, "§fComando não registrado.");
							return false;
						}else
						if(MySQLManager.getRank(p) == 0) {
							p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
						    p.sendMessage("§a§lCHAT §fComando não encontrado.");
						    Framework.sendTitle(p, "§4§lERRO");
						    Framework.sendSubTitle(p, "§fComando não registrado.");
							return false;
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				
				try {
					if(MySQLManager.getRank(p) == 10) {
						p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
					    p.sendMessage("§a§lCHAT §fComando não encontrado.");
					    Framework.sendTitle(p, "§4§lERRO");
					    Framework.sendSubTitle(p, "§fComando não registrado.");
						return false;
					}else
					if(MySQLManager.getRank(p) == 9) {
						p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
					    p.sendMessage("§a§lCHAT §fComando não encontrado.");
					    Framework.sendTitle(p, "§4§lERRO");
					    Framework.sendSubTitle(p, "§fComando não registrado.");
						return false;
					}else
					if(MySQLManager.getRank(p) == 8) {
						p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
					    p.sendMessage("§a§lCHAT §fComando não encontrado.");
					    Framework.sendTitle(p, "§4§lERRO");
					    Framework.sendSubTitle(p, "§fComando não registrado.");
						return false;
					}else
					if(MySQLManager.getRank(p) == 7) {
						p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
					    p.sendMessage("§a§lCHAT §fComando não encontrado.");
					    Framework.sendTitle(p, "§4§lERRO");
					    Framework.sendSubTitle(p, "§fComando não registrado.");
						return false;
					}else
					if(MySQLManager.getRank(p) == 6) {
						p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
					    p.sendMessage("§a§lCHAT §fComando não encontrado.");
					    Framework.sendTitle(p, "§4§lERRO");
					    Framework.sendSubTitle(p, "§fComando não registrado.");
						return false;
					}else
					if(MySQLManager.getRank(p) == 5) {
						p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
					    p.sendMessage("§a§lCHAT §fComando não encontrado.");
					    Framework.sendTitle(p, "§4§lERRO");
					    Framework.sendSubTitle(p, "§fComando não registrado.");
						return false;
					}else
					if(MySQLManager.getRank(p) == 4) {
						p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
					    p.sendMessage("§a§lCHAT §fComando não encontrado.");
					    Framework.sendTitle(p, "§4§lERRO");
					    Framework.sendSubTitle(p, "§fComando não registrado.");
						return false;
					}else
					if(MySQLManager.getRank(p) == 3) {
						p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
					    p.sendMessage("§a§lCHAT §fComando não encontrado.");
					    Framework.sendTitle(p, "§4§lERRO");
					    Framework.sendSubTitle(p, "§fComando não registrado.");
						return false;
					}else
					if(MySQLManager.getRank(p) == 2) {
						p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
					    p.sendMessage("§a§lCHAT §fComando não encontrado.");
					    Framework.sendTitle(p, "§4§lERRO");
					    Framework.sendSubTitle(p, "§fComando não registrado.");
						return false;
					}else
					if(MySQLManager.getRank(p) == 1) {
						p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
					    p.sendMessage("§a§lCHAT §fComando não encontrado.");
					    Framework.sendTitle(p, "§4§lERRO");
					    Framework.sendSubTitle(p, "§fComando não registrado.");
						return false;
					}else
					if(MySQLManager.getRank(p) == 0) {
						p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
					    p.sendMessage("§a§lCHAT §fComando não encontrado.");
					    Framework.sendTitle(p, "§4§lERRO");
					    Framework.sendSubTitle(p, "§fComando não registrado.");
						return false;
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		if(parametroLabel.equalsIgnoreCase("gamemode")) {
			if(parametroArgumentos.length != 1) {
				try {
					if(MySQLManager.getRank(p) == 15) {
						p.sendMessage("§a§lGAMEMODE §fComando incorreto, use /gm (§e1§f ou §e0§f).");
						return false;
					} else if(MySQLManager.getRank(p) == 14) {
						p.sendMessage("§a§lGAMEMODE §fComando incorreto, use /gm (§e1§f ou §e0§f).");
						return false;
					} else  if(MySQLManager.getRank(p) == 13) {
						p.sendMessage("§a§lGAMEMODE §fComando incorreto, use /gm (§e1§f ou §e0§f).");
						return false;
					} else if(MySQLManager.getRank(p) == 12) {
						p.sendMessage("§a§lGAMEMODE §fComando incorreto, use /gm (§e1§f ou §e0§f).");
						return false;
					} else if(MySQLManager.getRank(p) == 11) {
						p.sendMessage("§a§lGAMEMODE §fComando incorreto, use /gm (§e1§f ou §e0§f).");
						return false;
					} else
					if(MySQLManager.getRank(p) == 10) {
						p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
					    p.sendMessage("§a§lCHAT §fComando não encontrado.");
					    Framework.sendTitle(p, "§4§lERRO");
					    Framework.sendSubTitle(p, "§fComando não registrado.");
						return false;
					}else
					if(MySQLManager.getRank(p) == 9) {
						p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
					    p.sendMessage("§a§lCHAT §fComando não encontrado.");
					    Framework.sendTitle(p, "§4§lERRO");
					    Framework.sendSubTitle(p, "§fComando não registrado.");
						return false;
					}else
					if(MySQLManager.getRank(p) == 8) {
						p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
					    p.sendMessage("§a§lCHAT §fComando não encontrado.");
					    Framework.sendTitle(p, "§4§lERRO");
					    Framework.sendSubTitle(p, "§fComando não registrado.");
						return false;
					}else
					if(MySQLManager.getRank(p) == 7) {
						p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
					    p.sendMessage("§a§lCHAT §fComando não encontrado.");
					    Framework.sendTitle(p, "§4§lERRO");
					    Framework.sendSubTitle(p, "§fComando não registrado.");
						return false;
					}else
					if(MySQLManager.getRank(p) == 6) {
						p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
					    p.sendMessage("§a§lCHAT §fComando não encontrado.");
					    Framework.sendTitle(p, "§4§lERRO");
					    Framework.sendSubTitle(p, "§fComando não registrado.");
						return false;
					}else
					if(MySQLManager.getRank(p) == 5) {
						p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
					    p.sendMessage("§a§lCHAT §fComando não encontrado.");
					    Framework.sendTitle(p, "§4§lERRO");
					    Framework.sendSubTitle(p, "§fComando não registrado.");
						return false;
					}else
					if(MySQLManager.getRank(p) == 4) {
						p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
					    p.sendMessage("§a§lCHAT §fComando não encontrado.");
					    Framework.sendTitle(p, "§4§lERRO");
					    Framework.sendSubTitle(p, "§fComando não registrado.");
						return false;
					}else
					if(MySQLManager.getRank(p) == 3) {
						p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
					    p.sendMessage("§a§lCHAT §fComando não encontrado.");
					    Framework.sendTitle(p, "§4§lERRO");
					    Framework.sendSubTitle(p, "§fComando não registrado.");
						return false;
					}else
					if(MySQLManager.getRank(p) == 2) {
						p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
					    p.sendMessage("§a§lCHAT §fComando não encontrado.");
					    Framework.sendTitle(p, "§4§lERRO");
					    Framework.sendSubTitle(p, "§fComando não registrado.");
						return false;
					}else
					if(MySQLManager.getRank(p) == 1) {
						p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
					    p.sendMessage("§a§lCHAT §fComando não encontrado.");
					    Framework.sendTitle(p, "§4§lERRO");
					    Framework.sendSubTitle(p, "§fComando não registrado.");
						return false;
					}else
					if(MySQLManager.getRank(p) == 0) {
						p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
					    p.sendMessage("§a§lCHAT §fComando não encontrado.");
					    Framework.sendTitle(p, "§4§lERRO");
					    Framework.sendSubTitle(p, "§fComando não registrado.");
						return false;
					}
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if(parametroArgumentos.length == 1) {
				if(parametroArgumentos[0].equalsIgnoreCase("1")) {
					try {
						if(MySQLManager.getRank(p) == 15) {
							p.sendMessage("§a§lGAMEMODE §fModo de jogo alterado para §a§nCRIATIVO§f.");
							p.setGameMode(GameMode.CREATIVE);
							for(Player online : Bukkit.getOnlinePlayers()) {
								try {
									if(MySQLManager.getRank(online) == 15) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) + " §f§7trocou o modo de jogo para CRIATIVO!");
									}
									if(MySQLManager.getRank(online) == 14) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) + " §f§7trocou o modo de jogo para CRIATIVO!");
									}
									if(MySQLManager.getRank(online) == 13) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) + " §f§7trocou o modo de jogo para CRIATIVO!");
									}
									if(MySQLManager.getRank(online) == 12) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) + " §f§7trocou o modo de jogo para CRIATIVO!");
									}
									if(MySQLManager.getRank(online) == 11) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) + " §f§7trocou o modo de jogo para CRIATIVO!");
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						} else if(MySQLManager.getRank(p) == 14) {
							p.sendMessage("§a§lGAMEMODE §fModo de jogo alterado para §a§nCRIATIVO§f.");
							p.setGameMode(GameMode.CREATIVE);
							for(Player online : Bukkit.getOnlinePlayers()) {
								try {
									if(MySQLManager.getRank(online) == 15) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) + " §f§7trocou o modo de jogo para CRIATIVO!");
									}
									if(MySQLManager.getRank(online) == 14) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) + " §f§7trocou o modo de jogo para CRIATIVO!");
									}
									if(MySQLManager.getRank(online) == 13) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) + " §f§7trocou o modo de jogo para CRIATIVO!");
									}
									if(MySQLManager.getRank(online) == 12) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) + " §f§7trocou o modo de jogo para CRIATIVO!");
									}
									if(MySQLManager.getRank(online) == 11) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) + " §f§7trocou o modo de jogo para CRIATIVO!");
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						} else  if(MySQLManager.getRank(p) == 13) {
							p.sendMessage("§a§lGAMEMODE §fModo de jogo alterado para §a§nCRIATIVO§f.");
							p.setGameMode(GameMode.CREATIVE);
							for(Player online : Bukkit.getOnlinePlayers()) {
								try {
									if(MySQLManager.getRank(online) == 15) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) + " §f§7trocou o modo de jogo para CRIATIVO!");
									}
									if(MySQLManager.getRank(online) == 14) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) + " §f§7trocou o modo de jogo para CRIATIVO!");
									}
									if(MySQLManager.getRank(online) == 13) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) + " §f§7trocou o modo de jogo para CRIATIVO!");
									}
									if(MySQLManager.getRank(online) == 12) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) + " §f§7trocou o modo de jogo para CRIATIVO!");
									}
									if(MySQLManager.getRank(online) == 11) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) + " §f§7trocou o modo de jogo para CRIATIVO!");
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						} else if(MySQLManager.getRank(p) == 12) {
							p.sendMessage("§a§lGAMEMODE §fModo de jogo alterado para §a§nCRIATIVO§f.");
							p.setGameMode(GameMode.CREATIVE);
							for(Player online : Bukkit.getOnlinePlayers()) {
								try {
									if(MySQLManager.getRank(online) == 15) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) + " §f§7trocou o modo de jogo para CRIATIVO!");
									}
									if(MySQLManager.getRank(online) == 14) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) + " §f§7trocou o modo de jogo para CRIATIVO!");
									}
									if(MySQLManager.getRank(online) == 13) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) + " §f§7trocou o modo de jogo para CRIATIVO!");
									}
									if(MySQLManager.getRank(online) == 12) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) + " §f§7trocou o modo de jogo para CRIATIVO!");
									}
									if(MySQLManager.getRank(online) == 11) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) + " §f§7trocou o modo de jogo para CRIATIVO!");
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						} else if(MySQLManager.getRank(p) == 11) {
							p.sendMessage("§a§lGAMEMODE §fModo de jogo alterado para §a§nCRIATIVO§f.");
							p.setGameMode(GameMode.CREATIVE);
							for(Player online : Bukkit.getOnlinePlayers()) {
								try {
									if(MySQLManager.getRank(online) == 15) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) + " §f§7trocou o modo de jogo para CRIATIVO!");
									}
									if(MySQLManager.getRank(online) == 14) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) + " §f§7trocou o modo de jogo para CRIATIVO!");
									}
									if(MySQLManager.getRank(online) == 13) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) + " §f§7trocou o modo de jogo para CRIATIVO!");
									}
									if(MySQLManager.getRank(online) == 12) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) + " §f§7trocou o modo de jogo para CRIATIVO!");
									}
									if(MySQLManager.getRank(online) == 11) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) + " §f§7trocou o modo de jogo para CRIATIVO!");
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						} else
						if(MySQLManager.getRank(p) == 10) {
							p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
						    p.sendMessage("§a§lCHAT §fComando não encontrado.");
						    Framework.sendTitle(p, "§4§lERRO");
						    Framework.sendSubTitle(p, "§fComando não registrado.");
							return false;
						}else
						if(MySQLManager.getRank(p) == 9) {
							p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
						    p.sendMessage("§a§lCHAT §fComando não encontrado.");
						    Framework.sendTitle(p, "§4§lERRO");
						    Framework.sendSubTitle(p, "§fComando não registrado.");
							return false;
						}else
						if(MySQLManager.getRank(p) == 8) {
							p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
						    p.sendMessage("§a§lCHAT §fComando não encontrado.");
						    Framework.sendTitle(p, "§4§lERRO");
						    Framework.sendSubTitle(p, "§fComando não registrado.");
							return false;
						}else
						if(MySQLManager.getRank(p) == 7) {
							p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
						    p.sendMessage("§a§lCHAT §fComando não encontrado.");
						    Framework.sendTitle(p, "§4§lERRO");
						    Framework.sendSubTitle(p, "§fComando não registrado.");
							return false;
						}else
						if(MySQLManager.getRank(p) == 6) {
							p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
						    p.sendMessage("§a§lCHAT §fComando não encontrado.");
						    Framework.sendTitle(p, "§4§lERRO");
						    Framework.sendSubTitle(p, "§fComando não registrado.");
							return false;
						}else
						if(MySQLManager.getRank(p) == 5) {
							p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
						    p.sendMessage("§a§lCHAT §fComando não encontrado.");
						    Framework.sendTitle(p, "§4§lERRO");
						    Framework.sendSubTitle(p, "§fComando não registrado.");
							return false;
						}else
						if(MySQLManager.getRank(p) == 4) {
							p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
						    p.sendMessage("§a§lCHAT §fComando não encontrado.");
						    Framework.sendTitle(p, "§4§lERRO");
						    Framework.sendSubTitle(p, "§fComando não registrado.");
							return false;
						}else
						if(MySQLManager.getRank(p) == 3) {
							p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
						    p.sendMessage("§a§lCHAT §fComando não encontrado.");
						    Framework.sendTitle(p, "§4§lERRO");
						    Framework.sendSubTitle(p, "§fComando não registrado.");
							return false;
						}else
						if(MySQLManager.getRank(p) == 2) {
							p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
						    p.sendMessage("§a§lCHAT §fComando não encontrado.");
						    Framework.sendTitle(p, "§4§lERRO");
						    Framework.sendSubTitle(p, "§fComando não registrado.");
							return false;
						}else
						if(MySQLManager.getRank(p) == 1) {
							p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
						    p.sendMessage("§a§lCHAT §fComando não encontrado.");
						    Framework.sendTitle(p, "§4§lERRO");
						    Framework.sendSubTitle(p, "§fComando não registrado.");
							return false;
						}else
						if(MySQLManager.getRank(p) == 0) {
							p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
						    p.sendMessage("§a§lCHAT §fComando não encontrado.");
						    Framework.sendTitle(p, "§4§lERRO");
						    Framework.sendSubTitle(p, "§fComando não registrado.");
							return false;
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				
				if(parametroArgumentos[0].equalsIgnoreCase("0")) {
					try {
						if(MySQLManager.getRank(p) == 15) {
							p.sendMessage("§a§lGAMEMODE §fModo de jogo alterado para §c§nsobrevivência§f.");
							p.setGameMode(GameMode.SURVIVAL);
							p.setFlying(false);
							for(Player online : Bukkit.getOnlinePlayers()) {
								try {
									if(MySQLManager.getRank(online) == 15) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) +" §f§7trocou o modo de jogo para SOBREVIVÊNCIA!");
									}
									if(MySQLManager.getRank(online) == 14) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) +" §f§7trocou o modo de jogo para SOBREVIVÊNCIA!");
									}
									if(MySQLManager.getRank(online) == 13) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) +" §f§7trocou o modo de jogo para SOBREVIVÊNCIA!");
									}
									if(MySQLManager.getRank(online) == 12) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) +" §f§7trocou o modo de jogo para SOBREVIVÊNCIA!");
									}
									if(MySQLManager.getRank(online) == 11) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) +" §f§7trocou o modo de jogo para SOBREVIVÊNCIA!");
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
							return true;
						} else if(MySQLManager.getRank(p) == 14) {
							p.sendMessage("§a§lGAMEMODE §fModo de jogo alterado para §c§nsobrevivência§f.");
							p.setGameMode(GameMode.SURVIVAL);
							p.setFlying(false);
							for(Player online : Bukkit.getOnlinePlayers()) {
								try {
									if(MySQLManager.getRank(online) == 15) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) +" §f§7trocou o modo de jogo para SOBREVIVÊNCIA!");
									}
									if(MySQLManager.getRank(online) == 14) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) +" §f§7trocou o modo de jogo para SOBREVIVÊNCIA!");
									}
									if(MySQLManager.getRank(online) == 13) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) +" §f§7trocou o modo de jogo para SOBREVIVÊNCIA!");
									}
									if(MySQLManager.getRank(online) == 12) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) +" §f§7trocou o modo de jogo para SOBREVIVÊNCIA!");
									}
									if(MySQLManager.getRank(online) == 11) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) +" §f§7trocou o modo de jogo para SOBREVIVÊNCIA!");
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
							return true;
						} else  if(MySQLManager.getRank(p) == 13) {
							p.sendMessage("§a§lGAMEMODE §fModo de jogo alterado para §c§nsobrevivência§f.");
							p.setGameMode(GameMode.SURVIVAL);
							p.setFlying(false);
							for(Player online : Bukkit.getOnlinePlayers()) {
								try {
									if(MySQLManager.getRank(online) == 15) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) +" §f§7trocou o modo de jogo para SOBREVIVÊNCIA!");
									}
									if(MySQLManager.getRank(online) == 14) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) +" §f§7trocou o modo de jogo para SOBREVIVÊNCIA!");
									}
									if(MySQLManager.getRank(online) == 13) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) +" §f§7trocou o modo de jogo para SOBREVIVÊNCIA!");
									}
									if(MySQLManager.getRank(online) == 12) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) +" §f§7trocou o modo de jogo para SOBREVIVÊNCIA!");
									}
									if(MySQLManager.getRank(online) == 11) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) +" §f§7trocou o modo de jogo para SOBREVIVÊNCIA!");
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
							return true;
						} else if(MySQLManager.getRank(p) == 12) {
							p.sendMessage("§a§lGAMEMODE §fModo de jogo alterado para §c§nsobrevivência§f.");
							p.setGameMode(GameMode.SURVIVAL);
							p.setFlying(false);
							for(Player online : Bukkit.getOnlinePlayers()) {
								try {
									if(MySQLManager.getRank(online) == 15) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) +" §f§7trocou o modo de jogo para SOBREVIVÊNCIA!");
									}
									if(MySQLManager.getRank(online) == 14) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) +" §f§7trocou o modo de jogo para SOBREVIVÊNCIA!");
									}
									if(MySQLManager.getRank(online) == 13) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) +" §f§7trocou o modo de jogo para SOBREVIVÊNCIA!");
									}
									if(MySQLManager.getRank(online) == 12) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) +" §f§7trocou o modo de jogo para SOBREVIVÊNCIA!");
									}
									if(MySQLManager.getRank(online) == 11) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) +" §f§7trocou o modo de jogo para SOBREVIVÊNCIA!");
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
							return true;
						} else if(MySQLManager.getRank(p) == 11) {
							p.sendMessage("§a§lGAMEMODE §fModo de jogo alterado para §c§nsobrevivência§f.");
							p.setGameMode(GameMode.SURVIVAL);
							p.setFlying(false);
							for(Player online : Bukkit.getOnlinePlayers()) {
								try {
									if(MySQLManager.getRank(online) == 15) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) +" §f§7trocou o modo de jogo para SOBREVIVÊNCIA!");
									}
									if(MySQLManager.getRank(online) == 14) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) +" §f§7trocou o modo de jogo para SOBREVIVÊNCIA!");
									}
									if(MySQLManager.getRank(online) == 13) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) +" §f§7trocou o modo de jogo para SOBREVIVÊNCIA!");
									}
									if(MySQLManager.getRank(online) == 12) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) +" §f§7trocou o modo de jogo para SOBREVIVÊNCIA!");
									}
									if(MySQLManager.getRank(online) == 11) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) +" §f§7trocou o modo de jogo para SOBREVIVÊNCIA!");
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
							return true;
						} else
						if(MySQLManager.getRank(p) == 10) {
							p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
						    p.sendMessage("§a§lCHAT §fComando não encontrado.");
						    Framework.sendTitle(p, "§4§lERRO");
						    Framework.sendSubTitle(p, "§fComando não registrado.");
							return false;
						}else
						if(MySQLManager.getRank(p) == 9) {
							p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
						    p.sendMessage("§a§lCHAT §fComando não encontrado.");
						    Framework.sendTitle(p, "§4§lERRO");
						    Framework.sendSubTitle(p, "§fComando não registrado.");
							return false;
						}else
						if(MySQLManager.getRank(p) == 8) {
							p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
						    p.sendMessage("§a§lCHAT §fComando não encontrado.");
						    Framework.sendTitle(p, "§4§lERRO");
						    Framework.sendSubTitle(p, "§fComando não registrado.");
							return false;
						}else
						if(MySQLManager.getRank(p) == 7) {
							p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
						    p.sendMessage("§a§lCHAT §fComando não encontrado.");
						    Framework.sendTitle(p, "§4§lERRO");
						    Framework.sendSubTitle(p, "§fComando não registrado.");
							return false;
						}else
						if(MySQLManager.getRank(p) == 6) {
							p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
						    p.sendMessage("§a§lCHAT §fComando não encontrado.");
						    Framework.sendTitle(p, "§4§lERRO");
						    Framework.sendSubTitle(p, "§fComando não registrado.");
							return false;
						}else
						if(MySQLManager.getRank(p) == 5) {
							p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
						    p.sendMessage("§a§lCHAT §fComando não encontrado.");
						    Framework.sendTitle(p, "§4§lERRO");
						    Framework.sendSubTitle(p, "§fComando não registrado.");
							return false;
						}else
						if(MySQLManager.getRank(p) == 4) {
							p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
						    p.sendMessage("§a§lCHAT §fComando não encontrado.");
						    Framework.sendTitle(p, "§4§lERRO");
						    Framework.sendSubTitle(p, "§fComando não registrado.");
							return false;
						}else
						if(MySQLManager.getRank(p) == 3) {
							p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
						    p.sendMessage("§a§lCHAT §fComando não encontrado.");
						    Framework.sendTitle(p, "§4§lERRO");
						    Framework.sendSubTitle(p, "§fComando não registrado.");
							return false;
						}else
						if(MySQLManager.getRank(p) == 2) {
							p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
						    p.sendMessage("§a§lCHAT §fComando não encontrado.");
						    Framework.sendTitle(p, "§4§lERRO");
						    Framework.sendSubTitle(p, "§fComando não registrado.");
							return false;
						}else
						if(MySQLManager.getRank(p) == 1) {
							p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
						    p.sendMessage("§a§lCHAT §fComando não encontrado.");
						    Framework.sendTitle(p, "§4§lERRO");
						    Framework.sendSubTitle(p, "§fComando não registrado.");
							return false;
						}else
						if(MySQLManager.getRank(p) == 0) {
							p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
						    p.sendMessage("§a§lCHAT §fComando não encontrado.");
						    Framework.sendTitle(p, "§4§lERRO");
						    Framework.sendSubTitle(p, "§fComando não registrado.");
							return false;
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				
				try {
					if(MySQLManager.getRank(p) == 10) {
						p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
					    p.sendMessage("§a§lCHAT §fComando não encontrado.");
					    Framework.sendTitle(p, "§4§lERRO");
					    Framework.sendSubTitle(p, "§fComando não registrado.");
						return false;
					}else
					if(MySQLManager.getRank(p) == 9) {
						p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
					    p.sendMessage("§a§lCHAT §fComando não encontrado.");
					    Framework.sendTitle(p, "§4§lERRO");
					    Framework.sendSubTitle(p, "§fComando não registrado.");
						return false;
					}else
					if(MySQLManager.getRank(p) == 8) {
						p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
					    p.sendMessage("§a§lCHAT §fComando não encontrado.");
					    Framework.sendTitle(p, "§4§lERRO");
					    Framework.sendSubTitle(p, "§fComando não registrado.");
						return false;
					}else
					if(MySQLManager.getRank(p) == 7) {
						p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
					    p.sendMessage("§a§lCHAT §fComando não encontrado.");
					    Framework.sendTitle(p, "§4§lERRO");
					    Framework.sendSubTitle(p, "§fComando não registrado.");
						return false;
					}else
					if(MySQLManager.getRank(p) == 6) {
						p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
					    p.sendMessage("§a§lCHAT §fComando não encontrado.");
					    Framework.sendTitle(p, "§4§lERRO");
					    Framework.sendSubTitle(p, "§fComando não registrado.");
						return false;
					}else
					if(MySQLManager.getRank(p) == 5) {
						p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
					    p.sendMessage("§a§lCHAT §fComando não encontrado.");
					    Framework.sendTitle(p, "§4§lERRO");
					    Framework.sendSubTitle(p, "§fComando não registrado.");
						return false;
					}else
					if(MySQLManager.getRank(p) == 4) {
						p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
					    p.sendMessage("§a§lCHAT §fComando não encontrado.");
					    Framework.sendTitle(p, "§4§lERRO");
					    Framework.sendSubTitle(p, "§fComando não registrado.");
						return false;
					}else
					if(MySQLManager.getRank(p) == 3) {
						p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
					    p.sendMessage("§a§lCHAT §fComando não encontrado.");
					    Framework.sendTitle(p, "§4§lERRO");
					    Framework.sendSubTitle(p, "§fComando não registrado.");
						return false;
					}else
					if(MySQLManager.getRank(p) == 2) {
						p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
					    p.sendMessage("§a§lCHAT §fComando não encontrado.");
					    Framework.sendTitle(p, "§4§lERRO");
					    Framework.sendSubTitle(p, "§fComando não registrado.");
						return false;
					}else
					if(MySQLManager.getRank(p) == 1) {
						p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
					    p.sendMessage("§a§lCHAT §fComando não encontrado.");
					    Framework.sendTitle(p, "§4§lERRO");
					    Framework.sendSubTitle(p, "§fComando não registrado.");
						return false;
					}else
					if(MySQLManager.getRank(p) == 0) {
						p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
					    p.sendMessage("§a§lCHAT §fComando não encontrado.");
					    Framework.sendTitle(p, "§4§lERRO");
					    Framework.sendSubTitle(p, "§fComando não registrado.");
						return false;
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		if(parametroLabel.equalsIgnoreCase("tp")) {
			if(parametroArgumentos.length != 1) {
				try {
					if(MySQLManager.getRank(p) == 15) {
						p.sendMessage("§a§lTELEPORTE §fComando incorreto, use /tp (§eJOGADOR§f).");
						return false;
					} else if(MySQLManager.getRank(p) == 14) {
						p.sendMessage("§a§lTELEPORTE §fComando incorreto, use /tp (§eJOGADOR§f).");
						return false;
					} else  if(MySQLManager.getRank(p) == 13) {
						p.sendMessage("§a§lTELEPORTE §fComando incorreto, use /tp (§eJOGADOR§f).");
						return false;
					} else if(MySQLManager.getRank(p) == 12) {
						p.sendMessage("§a§lTELEPORTE §fComando incorreto, use /tp (§eJOGADOR§f).");
						return false;
					} else if(MySQLManager.getRank(p) == 11) {
						p.sendMessage("§a§lTELEPORTE §fComando incorreto, use /tp (§eJOGADOR§f).");
						return false;
					} else
					if(MySQLManager.getRank(p) == 10) {
						p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
					    p.sendMessage("§a§lCHAT §fComando não encontrado.");
					    Framework.sendTitle(p, "§4§lERRO");
					    Framework.sendSubTitle(p, "§fComando não registrado.");
						return false;
					}else
					if(MySQLManager.getRank(p) == 9) {
						p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
					    p.sendMessage("§a§lCHAT §fComando não encontrado.");
					    Framework.sendTitle(p, "§4§lERRO");
					    Framework.sendSubTitle(p, "§fComando não registrado.");
						return false;
					}else
					if(MySQLManager.getRank(p) == 8) {
						p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
					    p.sendMessage("§a§lCHAT §fComando não encontrado.");
					    Framework.sendTitle(p, "§4§lERRO");
					    Framework.sendSubTitle(p, "§fComando não registrado.");
						return false;
					}else
					if(MySQLManager.getRank(p) == 7) {
						p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
					    p.sendMessage("§a§lCHAT §fComando não encontrado.");
					    Framework.sendTitle(p, "§4§lERRO");
					    Framework.sendSubTitle(p, "§fComando não registrado.");
						return false;
					}else
					if(MySQLManager.getRank(p) == 6) {
						p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
					    p.sendMessage("§a§lCHAT §fComando não encontrado.");
					    Framework.sendTitle(p, "§4§lERRO");
					    Framework.sendSubTitle(p, "§fComando não registrado.");
						return false;
					}else
					if(MySQLManager.getRank(p) == 5) {
						p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
					    p.sendMessage("§a§lCHAT §fComando não encontrado.");
					    Framework.sendTitle(p, "§4§lERRO");
					    Framework.sendSubTitle(p, "§fComando não registrado.");
						return false;
					}else
					if(MySQLManager.getRank(p) == 4) {
						p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
					    p.sendMessage("§a§lCHAT §fComando não encontrado.");
					    Framework.sendTitle(p, "§4§lERRO");
					    Framework.sendSubTitle(p, "§fComando não registrado.");
						return false;
					}else
					if(MySQLManager.getRank(p) == 3) {
						p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
					    p.sendMessage("§a§lCHAT §fComando não encontrado.");
					    Framework.sendTitle(p, "§4§lERRO");
					    Framework.sendSubTitle(p, "§fComando não registrado.");
						return false;
					}else
					if(MySQLManager.getRank(p) == 2) {
						p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
					    p.sendMessage("§a§lCHAT §fComando não encontrado.");
					    Framework.sendTitle(p, "§4§lERRO");
					    Framework.sendSubTitle(p, "§fComando não registrado.");
						return false;
					}else
					if(MySQLManager.getRank(p) == 1) {
						p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
					    p.sendMessage("§a§lCHAT §fComando não encontrado.");
					    Framework.sendTitle(p, "§4§lERRO");
					    Framework.sendSubTitle(p, "§fComando não registrado.");
						return false;
					}else
					if(MySQLManager.getRank(p) == 0) {
						p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
					    p.sendMessage("§a§lCHAT §fComando não encontrado.");
					    Framework.sendTitle(p, "§4§lERRO");
					    Framework.sendSubTitle(p, "§fComando não registrado.");
						return false;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if(parametroArgumentos.length == 1) {
				try {
					if(MySQLManager.getRank(p) == 15) {
				        Player parametroAlvo = Bukkit.getPlayerExact(parametroArgumentos[0]);
				        if ((parametroAlvo == null) || (!(parametroAlvo instanceof Player))) {
						  p.sendMessage("§a§lTELEPORTE §fNão foi possível encontrar §e" + parametroArgumentos[0]);
				          return false;
				        }
							p.teleport(parametroAlvo);
							p.sendMessage("§a§lTELEPORTE §fTeleportado até o jogador: §e" + parametroAlvo.getName());
							for(Player online : Bukkit.getOnlinePlayers()) {
								try {
									if(MySQLManager.getRank(online) == 15) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) +" §f§7teleportou-se até §e" + parametroAlvo.getName());
									}
									if(MySQLManager.getRank(online) == 14) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) +" §f§7teleportou-se até §e" + parametroAlvo.getName());
									}
									if(MySQLManager.getRank(online) == 13) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) +" §f§7teleportou-se até §e" + parametroAlvo.getName());
									}
									if(MySQLManager.getRank(online) == 12) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) +" §f§7teleportou-se até §e" + parametroAlvo.getName());
									}
									if(MySQLManager.getRank(online) == 11) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) +" §f§7teleportou-se até §e" + parametroAlvo.getName());
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
					}
					if(MySQLManager.getRank(p) == 14) {
				        Player parametroAlvo = Bukkit.getPlayerExact(parametroArgumentos[0]);
				        if ((parametroAlvo == null) || (!(parametroAlvo instanceof Player))) {
						  p.sendMessage("§a§lTELEPORTE §fNão foi possível encontrar §e" + parametroArgumentos[0]);
				          return false;
				        }
							p.teleport(parametroAlvo);
							p.sendMessage("§a§lTELEPORTE §fTeleportado até o jogador: §e" + parametroAlvo.getName());
							for(Player online : Bukkit.getOnlinePlayers()) {
								try {
									if(MySQLManager.getRank(online) == 15) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) +" §f§7teleportou-se até §e" + parametroAlvo.getName());
									}
									if(MySQLManager.getRank(online) == 14) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) +" §f§7teleportou-se até §e" + parametroAlvo.getName());
									}
									if(MySQLManager.getRank(online) == 13) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) +" §f§7teleportou-se até §e" + parametroAlvo.getName());
									}
									if(MySQLManager.getRank(online) == 12) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) +" §f§7teleportou-se até §e" + parametroAlvo.getName());
									}
									if(MySQLManager.getRank(online) == 11) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) +" §f§7teleportou-se até §e" + parametroAlvo.getName());
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
					}
					if(MySQLManager.getRank(p) == 13) {
				        Player parametroAlvo = Bukkit.getPlayerExact(parametroArgumentos[0]);
				        if ((parametroAlvo == null) || (!(parametroAlvo instanceof Player))) {
						  p.sendMessage("§a§lTELEPORTE §fNão foi possível encontrar §e" + parametroArgumentos[0]);
				          return false;
				        }
							p.teleport(parametroAlvo);
							p.sendMessage("§a§lTELEPORTE §fTeleportado até o jogador: §e" + parametroAlvo.getName());
							for(Player online : Bukkit.getOnlinePlayers()) {
								try {
									if(MySQLManager.getRank(online) == 15) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) +" §f§7teleportou-se até §e" + parametroAlvo.getName());
									}
									if(MySQLManager.getRank(online) == 14) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) +" §f§7teleportou-se até §e" + parametroAlvo.getName());
									}
									if(MySQLManager.getRank(online) == 13) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) +" §f§7teleportou-se até §e" + parametroAlvo.getName());
									}
									if(MySQLManager.getRank(online) == 12) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) +" §f§7teleportou-se até §e" + parametroAlvo.getName());
									}
									if(MySQLManager.getRank(online) == 11) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) +" §f§7teleportou-se até §e" + parametroAlvo.getName());
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
					}
					if(MySQLManager.getRank(p) == 12) {
				        Player parametroAlvo = Bukkit.getPlayerExact(parametroArgumentos[0]);
				        if ((parametroAlvo == null) || (!(parametroAlvo instanceof Player))) {
						  p.sendMessage("§a§lTELEPORTE §fNão foi possível encontrar §e" + parametroArgumentos[0]);
				          return false;
				        }
							p.teleport(parametroAlvo);
							p.sendMessage("§a§lTELEPORTE §fTeleportado até o jogador: §e" + parametroAlvo.getName());
							for(Player online : Bukkit.getOnlinePlayers()) {
								try {
									if(MySQLManager.getRank(online) == 15) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) +" §f§7teleportou-se até §e" + parametroAlvo.getName());
									}
									if(MySQLManager.getRank(online) == 14) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) +" §f§7teleportou-se até §e" + parametroAlvo.getName());
									}
									if(MySQLManager.getRank(online) == 13) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) +" §f§7teleportou-se até §e" + parametroAlvo.getName());
									}
									if(MySQLManager.getRank(online) == 12) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) +" §f§7teleportou-se até §e" + parametroAlvo.getName());
									}
									if(MySQLManager.getRank(online) == 11) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) +" §f§7teleportou-se até §e" + parametroAlvo.getName());
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
					}
					
					if(MySQLManager.getRank(p) == 11) {
				        Player parametroAlvo = Bukkit.getPlayerExact(parametroArgumentos[0]);
				        if ((parametroAlvo == null) || (!(parametroAlvo instanceof Player))) {
						  p.sendMessage("§a§lTELEPORTE §fNão foi possível encontrar §e" + parametroArgumentos[0]);
				          return false;
				        }
							p.teleport(parametroAlvo);
							p.sendMessage("§a§lTELEPORTE §fTeleportado até o jogador: §e" + parametroAlvo.getName());
							for(Player online : Bukkit.getOnlinePlayers()) {
								try {
									if(MySQLManager.getRank(online) == 15) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) +" §f§7teleportou-se até §e" + parametroAlvo.getName());
									}
									if(MySQLManager.getRank(online) == 14) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) +" §f§7teleportou-se até §e" + parametroAlvo.getName());
									}
									if(MySQLManager.getRank(online) == 13) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) +" §f§7teleportou-se até §e" + parametroAlvo.getName());
									}
									if(MySQLManager.getRank(online) == 12) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) +" §f§7teleportou-se até §e" + parametroAlvo.getName());
									}
									if(MySQLManager.getRank(online) == 11) {
										online.sendMessage("§7O Staff [" + p.getName() + "] §7com o cargo de: " + Main.verificarTag(p) +" §f§7teleportou-se até §e" + parametroAlvo.getName());
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
					}
				} catch (Exception e) {
					e.printStackTrace();
			    }
		    }
		}
		
		if(parametroLabel.equalsIgnoreCase("tpall")) {
			if(parametroArgumentos.length >= 1) {
						try {
							if(MySQLManager.getRank(p) == 15) {
								p.sendMessage("§a§lTELEPORTE §fComando incorreto, use /tpall.");
								return false;
							} else if(MySQLManager.getRank(p) == 14) {
								p.sendMessage("§a§lTELEPORTE §fComando incorreto, use /tpall.");
								return false;
							} else  if(MySQLManager.getRank(p) == 13) {
								p.sendMessage("§a§lTELEPORTE §fComando incorreto, use /tpall.");
								return false;
							} else if(MySQLManager.getRank(p) == 12) {
								p.sendMessage("§a§lTELEPORTE §fComando incorreto, use /tpall.");
								return false;
							} else if(MySQLManager.getRank(p) == 11) {
								p.sendMessage("§a§lTELEPORTE §fComando incorreto, use /tpall.");
								return false;
							} else
							if(MySQLManager.getRank(p) == 10) {
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
							    p.sendMessage("§a§lCHAT §fComando não encontrado.");
							    Framework.sendTitle(p, "§4§lERRO");
							    Framework.sendSubTitle(p, "§fComando não registrado.");
								return false;
							}else
							if(MySQLManager.getRank(p) == 9) {
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
							    p.sendMessage("§a§lCHAT §fComando não encontrado.");
							    Framework.sendTitle(p, "§4§lERRO");
							    Framework.sendSubTitle(p, "§fComando não registrado.");
								return false;
							}else
							if(MySQLManager.getRank(p) == 8) {
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
							    p.sendMessage("§a§lCHAT §fComando não encontrado.");
							    Framework.sendTitle(p, "§4§lERRO");
							    Framework.sendSubTitle(p, "§fComando não registrado.");
								return false;
							}else
							if(MySQLManager.getRank(p) == 7) {
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
							    p.sendMessage("§a§lCHAT §fComando não encontrado.");
							    Framework.sendTitle(p, "§4§lERRO");
							    Framework.sendSubTitle(p, "§fComando não registrado.");
								return false;
							}else
							if(MySQLManager.getRank(p) == 6) {
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
							    p.sendMessage("§a§lCHAT §fComando não encontrado.");
							    Framework.sendTitle(p, "§4§lERRO");
							    Framework.sendSubTitle(p, "§fComando não registrado.");
								return false;
							}else
							if(MySQLManager.getRank(p) == 5) {
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
							    p.sendMessage("§a§lCHAT §fComando não encontrado.");
							    Framework.sendTitle(p, "§4§lERRO");
							    Framework.sendSubTitle(p, "§fComando não registrado.");
								return false;
							}else
							if(MySQLManager.getRank(p) == 4) {
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
							    p.sendMessage("§a§lCHAT §fComando não encontrado.");
							    Framework.sendTitle(p, "§4§lERRO");
							    Framework.sendSubTitle(p, "§fComando não registrado.");
								return false;
							}else
							if(MySQLManager.getRank(p) == 3) {
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
							    p.sendMessage("§a§lCHAT §fComando não encontrado.");
							    Framework.sendTitle(p, "§4§lERRO");
							    Framework.sendSubTitle(p, "§fComando não registrado.");
								return false;
							}else
							if(MySQLManager.getRank(p) == 2) {
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
							    p.sendMessage("§a§lCHAT §fComando não encontrado.");
							    Framework.sendTitle(p, "§4§lERRO");
							    Framework.sendSubTitle(p, "§fComando não registrado.");
								return false;
							}else
							if(MySQLManager.getRank(p) == 1) {
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
							    p.sendMessage("§a§lCHAT §fComando não encontrado.");
							    Framework.sendTitle(p, "§4§lERRO");
							    Framework.sendSubTitle(p, "§fComando não registrado.");
								return false;
							}else
							if(MySQLManager.getRank(p) == 0) {
								p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
							    p.sendMessage("§a§lCHAT §fComando não encontrado.");
							    Framework.sendTitle(p, "§4§lERRO");
							    Framework.sendSubTitle(p, "§fComando não registrado.");
								return false;
							}
						} catch (SQLException e) {
							e.printStackTrace();
						}
				} else if(parametroArgumentos.length == 0) {
					try {
						if(MySQLManager.getRank(p) == 15) {
						    p.sendMessage("§a§lTELEPORTE §fTodos os jogadores online foram teletransportados até a localização de §e" + p.getName() + " §f.");
							for(Player online : Bukkit.getOnlinePlayers()) {
							    Framework.sendTitle(online, "§a§lTELEPORTE");
							    Framework.sendSubTitle(online, "§fVocê foi teleportado até a localização de §e" + p.getName());
							    Framework.sendTitle(p, "§a§lTELEPORTE");
							    Framework.sendSubTitle(p, "§fVocê puxou todos os jogadores até sua localização atual.");
							    online.teleport(p);
							}
							return true;
						} else if(MySQLManager.getRank(p) == 14) {
						    p.sendMessage("§a§lTELEPORTE §fTodos os jogadores online foram teletransportados até a localização de §e" + p.getName() + " §f.");
							for(Player online : Bukkit.getOnlinePlayers()) {
							    Framework.sendTitle(online, "§a§lTELEPORTE");
							    Framework.sendSubTitle(online, "§fVocê foi teleportado até a localização de §e" + p.getName());
							    Framework.sendTitle(p, "§a§lTELEPORTE");
							    Framework.sendSubTitle(p, "§fVocê puxou todos os jogadores até sua localização atual.");
							    online.teleport(p);
							}
							return true;
						} else  if(MySQLManager.getRank(p) == 13) {
						    p.sendMessage("§a§lTELEPORTE §fTodos os jogadores online foram teletransportados até a localização de §e" + p.getName() + " §f.");
							for(Player online : Bukkit.getOnlinePlayers()) {
							    Framework.sendTitle(online, "§a§lTELEPORTE");
							    Framework.sendSubTitle(online, "§fVocê foi teleportado até a localização de §e" + p.getName());
							    Framework.sendTitle(p, "§a§lTELEPORTE");
							    Framework.sendSubTitle(p, "§fVocê puxou todos os jogadores até sua localização atual.");
							    online.teleport(p);
							}
							return true;
						} else if(MySQLManager.getRank(p) == 12) {
						    p.sendMessage("§a§lTELEPORTE §fTodos os jogadores online foram teletransportados até a localização de §e" + p.getName() + " §f.");
							for(Player online : Bukkit.getOnlinePlayers()) {
							    Framework.sendTitle(online, "§a§lTELEPORTE");
							    Framework.sendSubTitle(online, "§fVocê foi teleportado até a localização de §e" + p.getName());
							    Framework.sendTitle(p, "§a§lTELEPORTE");
							    Framework.sendSubTitle(p, "§fVocê puxou todos os jogadores até sua localização atual.");
							    online.teleport(p);
							}
							return true;
						} else if(MySQLManager.getRank(p) == 11) {
						    p.sendMessage("§a§lTELEPORTE §fTodos os jogadores online foram teletransportados até a localização de §e" + p.getName() + " §f.");
							for(Player online : Bukkit.getOnlinePlayers()) {
							    Framework.sendTitle(online, "§a§lTELEPORTE");
							    Framework.sendSubTitle(online, "§fVocê foi teleportado até a localização de §e" + p.getName());
							    Framework.sendTitle(p, "§a§lTELEPORTE");
							    Framework.sendSubTitle(p, "§fVocê puxou todos os jogadores até sua localização atual.");
							    online.teleport(p);
							}
							return true;
						} else
						if(MySQLManager.getRank(p) == 10) {
							p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
						    p.sendMessage("§a§lCHAT §fComando não encontrado.");
						    Framework.sendTitle(p, "§4§lERRO");
						    Framework.sendSubTitle(p, "§fComando não registrado.");
							return false;
						}else
						if(MySQLManager.getRank(p) == 9) {
							p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
						    p.sendMessage("§a§lCHAT §fComando não encontrado.");
						    Framework.sendTitle(p, "§4§lERRO");
						    Framework.sendSubTitle(p, "§fComando não registrado.");
							return false;
						}else
						if(MySQLManager.getRank(p) == 8) {
							p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
						    p.sendMessage("§a§lCHAT §fComando não encontrado.");
						    Framework.sendTitle(p, "§4§lERRO");
						    Framework.sendSubTitle(p, "§fComando não registrado.");
							return false;
						}else
						if(MySQLManager.getRank(p) == 7) {
							p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
						    p.sendMessage("§a§lCHAT §fComando não encontrado.");
						    Framework.sendTitle(p, "§4§lERRO");
						    Framework.sendSubTitle(p, "§fComando não registrado.");
							return false;
						}else
						if(MySQLManager.getRank(p) == 6) {
							p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
						    p.sendMessage("§a§lCHAT §fComando não encontrado.");
						    Framework.sendTitle(p, "§4§lERRO");
						    Framework.sendSubTitle(p, "§fComando não registrado.");
							return false;
						}else
						if(MySQLManager.getRank(p) == 5) {
							p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
						    p.sendMessage("§a§lCHAT §fComando não encontrado.");
						    Framework.sendTitle(p, "§4§lERRO");
						    Framework.sendSubTitle(p, "§fComando não registrado.");
							return false;
						}else
						if(MySQLManager.getRank(p) == 4) {
							p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
						    p.sendMessage("§a§lCHAT §fComando não encontrado.");
						    Framework.sendTitle(p, "§4§lERRO");
						    Framework.sendSubTitle(p, "§fComando não registrado.");
							return false;
						}else
						if(MySQLManager.getRank(p) == 3) {
							p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
						    p.sendMessage("§a§lCHAT §fComando não encontrado.");
						    Framework.sendTitle(p, "§4§lERRO");
						    Framework.sendSubTitle(p, "§fComando não registrado.");
							return false;
						}else
						if(MySQLManager.getRank(p) == 2) {
							p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
						    p.sendMessage("§a§lCHAT §fComando não encontrado.");
						    Framework.sendTitle(p, "§4§lERRO");
						    Framework.sendSubTitle(p, "§fComando não registrado.");
							return false;
						}else
						if(MySQLManager.getRank(p) == 1) {
							p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
						    p.sendMessage("§a§lCHAT §fComando não encontrado.");
						    Framework.sendTitle(p, "§4§lERRO");
						    Framework.sendSubTitle(p, "§fComando não registrado.");
							return false;
						}else
						if(MySQLManager.getRank(p) == 0) {
							p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
						    p.sendMessage("§a§lCHAT §fComando não encontrado.");
						    Framework.sendTitle(p, "§4§lERRO");
						    Framework.sendSubTitle(p, "§fComando não registrado.");
							return false;
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
			    }
		   }
		
		
		if(parametroLabel.equalsIgnoreCase("tell")) {
			if(parametroArgumentos.length <= 1) {
				p.sendMessage("§a§lTELL §fUse: /tell (§eJOGADOR§f) (§eMENSAGEM§f).");
				return false;
				} else if(parametroArgumentos.length > 2) {
					p.sendMessage("§a§lTELL §fUse: /tell (§eJOGADOR§f) (§eMENSAGEM§f).");
					return false;
			    } else if(parametroArgumentos.length == 2) {
					Player alvo = Bukkit.getPlayer(parametroArgumentos[0]);
					if(alvo == null) {
						p.sendMessage("§a§lTELL §fNão foi possível encontrar o jogador: §c" + parametroArgumentos[0]);
						return false;
					} else {
						try {
							if(MySQLManager.getStatusTell(p) == 0) {
						        StringBuilder sb = new StringBuilder();
						        for (int i = 1; i < parametroArgumentos.length; i++) {
						          sb.append(parametroArgumentos[i]).append(" ");
						        }
						        String allArgs = sb.toString().trim();
								p.sendMessage("§a§lTELL §fVocê enviou um tell para §e" + alvo.getName() + "§f, com a seguinte mensagem §b" + allArgs);
								alvo.sendMessage("§a§lTELL §fVocê recebeu um tell de §e" + p.getName() + "§f, com a seguinte mensagem §b" + allArgs);
								return true;
							} else if(MySQLManager.getStatusTell(p) == 1) {
								p.sendMessage("§a§lTELL §fEste jogador está com o as mensagens privadas desativadas.");
								return false;
							}
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
				}
		   }
	  return false;
	}
}