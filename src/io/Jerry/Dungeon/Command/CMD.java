package io.Jerry.Dungeon.Command;

import java.util.List;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.google.common.collect.Lists;

import io.Jerry.Dungeon.Aerry;
import io.Jerry.Dungeon.Util.ChatUtil;
import io.Jerry.Dungeon.Util.ConfigUtil;
import io.Jerry.Dungeon.Util.GameUtil;
import io.Jerry.Dungeon.Util.GuiUtil;
import io.Jerry.Dungeon.Util.TitleApi;

public class CMD implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if((sender.isOp() && sender instanceof Player) == false){
			return false;
		}

		Player p = (Player)sender;
		//----------------------------------------------------------------------------------------------
//		//DONE
//		if(args.length == 2 && args[0].equalsIgnoreCase("Goto")){
//			for(Game G : GameUtil.Game){
//				if(G.getWorld().getPlayers().contains(p)){
//					p.sendMessage("��3Dun> ��f�A���b�ϥΨ�L�ƥ�");
//					return true;
//				}
//			}
//			
//			double startTime = System.currentTimeMillis();
//			
//			try {
//				Game G = new Game(args[1],null);
//				G.onGameStart(true, Arrays.asList(new String[]{p.getName()}));
//				GameUtil.Game.add(G);
//			} catch (GameError e) {
//				p.sendMessage("��3Dun> ��f" + e.getMessage());
//			}
//			
//			double endTime   = System.currentTimeMillis();
//			double totalTime = endTime - startTime;
//			totalTime = totalTime/1000;
//			p.sendMessage("��3Dun> ��f�ϥ�" + totalTime + "����ճЫ�");
//			return true;
//		}
//		//----------------------------------------------------------------------------------------------
//
//		if(args.length == 1 && args[0].equalsIgnoreCase("End")){
//			boolean use = false;
//			for(Game G : GameUtil.Game){
//				if(G.getWorld().getPlayers().contains(p)){
//					double startTime = System.currentTimeMillis();
//					
//					G.onGameEnd();
//					GameUtil.Game.remove(G);
//					
//					double endTime   = System.currentTimeMillis();
//					double totalTime = endTime - startTime;
//					totalTime = totalTime/1000;
//					p.sendMessage("��3Dun> ��f�ϥ�" + totalTime + "��R��");
//					
//					use = true;
//					break;
//				}
//			}
//			if(use == false){
//				p.sendMessage("��3Dun> ��f�A���b����ƥ���");
//			}
//			return true;
//		}

//		if(args.length == 1 && args[0].equalsIgnoreCase("Spawn")){
//			for(Game G : GameUtil.Game){
//				if(G.getWorld().getPlayers().contains(p)){
//					if(Main.c.get("Game." + G.getName() + ".X") == null){//TODO
//						p.sendMessage("��3Dun> ��f�ƥ��X���I�S���]�w");
//					}else{
//						p.teleport(GameUtil.getSpawnLoc(G.getWorld(), G.getName()));
//					}
//					return true;
//				}
//			}
//			p.sendMessage("��3Dun> ��f�A���b����ƥ���");
//			return true;
//		}
//		//----------------------------------------------------------------------------------------------
//
//		if(args.length == 1 && args[0].equalsIgnoreCase("SetSpawn")){
//			boolean use = false;
//			for(Game G : GameUtil.Game){
//				if(G.getWorld().getPlayers().contains(p)){
//					Location L = p.getLocation();//TODO
//					Main.c.set("Game." + G.getName() + ".X",L.getBlockX());
//					Main.c.set("Game." + G.getName() + ".Y",L.getBlockY());
//					Main.c.set("Game." + G.getName() + ".Z",L.getBlockZ());
//					Main.PL.saveConfig();
//					p.sendMessage("��3Dun> ��f�w�]�w�X���I");
//					use = true;
//					break;
//				}
//			}
//			if(use == false){
//				p.sendMessage("��3Dun> ��f�A���b����ƥ���");
//			}
//			return true;
//		}
//		//----------------------------------------------------------------------------------------------
//		//DONE
//		if(args.length >= 2 && args[0].equalsIgnoreCase("SetExit")){
//			if(GameUtil.hasGame(args[1]) ==  false){
//				p.sendMessage("��3Dun> ��f�S�����ƥ�");
//				return true;
//			}
//			
//			if(args.length == 2){
//				Location L = p.getLocation();//TODO
//				Main.c.set("Game." + args[1] + ".Exit.W",L.getWorld().getName());
//				Main.c.set("Game." + args[1] + ".Exit.X",L.getBlockX());
//				Main.c.set("Game." + args[1] + ".Exit.Y",L.getBlockY());
//				Main.c.set("Game." + args[1] + ".Exit.Z",L.getBlockZ());
//				Main.PL.saveConfig();
//				p.sendMessage("��3Dun> ��f�w�]�w���}��m");
//				return true;
//			}else if(args.length == 3 && args[2].equalsIgnoreCase("null")){
//				Main.c.set("Game." + args[1] + ".Exit",null);
//				p.sendMessage("��3Dun> ��f�w�]�w���}��m��Spawn�I");
//				
//				Main.PL.saveConfig();
//				return true;
//			}
//			
//		}
//		//----------------------------------------------------------------------------------------------
//		//DONE
//		if(args.length >= 2 && args[0].equalsIgnoreCase("SetIn")){
//			if(GameUtil.hasGame(args[1]) ==  false){
//				p.sendMessage("��3Dun> ��f�S�����ƥ�");
//				return true;
//			}
//			
//			if(args.length == 2){
//				Location L = p.getLocation();//TODO
//				Main.c.set("Game." + args[1] + ".In.W",L.getWorld().getName());
//				Main.c.set("Game." + args[1] + ".In.X",L.getBlockX());
//				Main.c.set("Game." + args[1] + ".In.Y",L.getBlockY());
//				Main.c.set("Game." + args[1] + ".In.Z",L.getBlockZ());
//				p.sendMessage("��3Dun> ��f�w�]�w�i�J��m");
//				
//				Main.PL.saveConfig();
//				return true;
//			}else if(args.length == 3 && args[2].equalsIgnoreCase("null")){
//				Main.c.set("Game." + args[1] + ".In",null);
//				p.sendMessage("��3Dun> ��f�w�]�w�����m����i�J");
//				
//				Main.PL.saveConfig();
//				return true;
//			}
//			
//			
//		}
//		//----------------------------------------------------------------------------------------------
//		//DONE
//		if(args.length == 2 && args[0].equalsIgnoreCase("SetItem")){
//			if(p.getItemInHand() == null || p.getItemInHand().getType() == Material.AIR){
//				p.sendMessage("��3Dun> ��f��W�����۪��~");
//				return true;
//			}
//			
//			if(GameUtil.hasGame(args[1]) ==  false){
//				p.sendMessage("��3Dun> ��f�S�����ƥ�");
//				return true;
//			}
//			
//			Main.c.set("Game." + args[1] + ".Item",p.getItemInHand());//TODO
//			Main.PL.saveConfig();
//			p.sendMessage("��3Dun> ��f�w�]�w�ƥ��ǰe�Ѭ�" + ItemsUtil.GetName(p.getItemInHand()));
//			return true;
//		}
//		//----------------------------------------------------------------------------------------------
//		//DONE
//		if(args.length == 2 && args[0].equalsIgnoreCase("getItem")){
//			if(GameUtil.hasGame(args[1]) ==  false){
//				p.sendMessage("��3Dun> ��f�S�����ƥ�");
//				return true;
//			}
//			
//			ItemStack i = GameUtil.getItem(args[1]);
//			if(i == null){
//				p.sendMessage("��3Dun> ��f�S���]�w�ƥ��ǰe��");
//			}else{
//				p.getInventory().addItem(i);
//			}
//			return true;
//		}
//		
//		//----------------------------------------------------------------------------------------------
//		if(args.length == 2 && args[0].equalsIgnoreCase("Create")){
//			if(GameUtil.hasGame(args[1])){
//				p.sendMessage("��3Dun> ��f�w�g�����ƥ�");
//				return true;
//			}
//			
//			Main.c.set("Game." + args[1] + ".UUID",UUID.randomUUID().toString());
//			Main.PL.saveConfig();
//			p.sendMessage("��3Dun> ��f���\�W�]");
//			return true;
//		}
//		
//		
//		if(args.length == 2 && args[0].equalsIgnoreCase("Delete")){
//			if(GameUtil.hasGame(args[1]) ==  false){
//				p.sendMessage("��3Dun> ��f�S�����ƥ�");
//				return true;
//			}
//			
//			Main.c.set("Game." + args[1] ,null);//TODO
//			Main.PL.saveConfig();
//			p.sendMessage("��3Dun> ��f�w�R���ƥ��]�w��");
//			return true;
//		}
//		
//		if(args.length == 4 && args[0].equalsIgnoreCase("Limit")){
//			if(GameUtil.hasGame(args[1]) ==  false){
//				p.sendMessage("��3Dun> ��f�S�����ƥ�");
//				return true;
//			}
//			
//			try{
//				Main.c.set("Game." + args[1] + ".Mix",Integer.parseInt(args[2]));//TODO
//				Main.c.set("Game." + args[1] + ".Max",Integer.parseInt(args[3]));
//				Main.PL.saveConfig();
//				p.sendMessage("��3Dun> ��f�w���ƥ��]�w��");
//			}catch(Exception ex){
//				p.sendMessage("��3Dun> ��f�]�w���~");
//			}
//			return true;
//		}
//		
//		if(args.length == 3 && args[0].equalsIgnoreCase("Time")){
//			if(GameUtil.hasGame(args[1]) ==  false){
//				p.sendMessage("��3Dun> ��f�S�����ƥ�");
//				return true;
//			}
//			
//			try{
//				Main.c.set("Game." + args[1] + ".Time",Integer.parseInt(args[2]));//TODO
//				Main.PL.saveConfig();
//				p.sendMessage("��3Dun> ��f�w���ƥ��]�w��");
//			}catch(Exception ex){
//				p.sendMessage("��3Dun> ��f�]�w���~");
//			}
//			return true;
//		}
//		
//		if(args.length == 3 && args[0].equalsIgnoreCase("Respawn")){
//			if(GameUtil.hasGame(args[1]) ==  false){
//				p.sendMessage("��3Dun> ��f�S�����ƥ�");
//				return true;
//			}
//			
//			try{
//				Main.c.set("Game." + args[1] + ".Respawn",Boolean.valueOf(args[2]));//TODO
//				Main.PL.saveConfig();
//				p.sendMessage("��3Dun> ��f�w���ƥ��]�w��");
//			}catch(Exception ex){
//				p.sendMessage("��3Dun> ��f�]�w���~");
//			}
//			return true;
//		}
		if(args.length == 2){
			if(args[0].equalsIgnoreCase("Create")){
				if(ConfigUtil.hasGame(args[1])){
					p.sendMessage("��3Dun> ��f�w�g�����ƥ�");
					return true;
				}
				
				ConfigUtil.createGame(args[1]);
				GameUtil.selectGame(p, args[1]);
				p.sendMessage("��3Dun> ��f���\�W�]");
				return true;
			}
			
			
			if(args[0].equalsIgnoreCase("Delete")){
				if(ConfigUtil.hasGame(args[1]) ==  false){
					p.sendMessage("��3Dun> ��f�S�����ƥ�");
					return true;
				}
				
				ConfigUtil.deleteGame(args[1]);
				p.sendMessage("��3Dun> ��f�w�R���ƥ��]�w��");
				return true;
			}
			
			if(args[0].equalsIgnoreCase("Select")){
				if(ConfigUtil.hasGame(args[1]) ==  false){
					p.sendMessage("��3Dun> ��f�S�����ƥ�");
					return true;
				}
				
				GameUtil.selectGame(p, args[1]);
				p.sendMessage("��3Dun> ��f�w��ܰƥ�");
				return true;
			}
	
			if(args[0].equalsIgnoreCase("delMob")){
				String name = GameUtil.getSelect(p);
				if(name == null){
					p.sendMessage("��3Dun> ��f�ШϥΫ��O/Dun select <�ƥ�> ��ܻݭn�]�w���ƥ�");
					return true;
				}
					
				try{
					List<String> list = ConfigUtil.getSpawn_EntityList(name);
					if(list == null){
						p.sendMessage("��3Dun> ��f�C���Ū�");
						return true;
					}
					
					list.remove(Integer.parseInt(args[1]));
					ConfigUtil.setSpawn_EntityList(name,list);
				}catch(Exception ex){
					p.sendMessage("��3Dun> ��f�]�m���~");
				}
				return true;
			}
		}
		
		
		if(args.length == 1){
			if(args[0].equalsIgnoreCase("Join")){
				ChatUtil.setJoin(p);
				return true;
			}else if(args[0].equalsIgnoreCase("Quit")){
				ChatUtil.setQuit(p);
				return true;
			}else if(args[0].equalsIgnoreCase("Set")){
				String name = GameUtil.getSelect(p);
				if(name == null){
					p.sendMessage("��3Dun> ��f�ШϥΫ��O/Dun select <�ƥ�> ��ܻݭn�]�w���ƥ�");
					return true;
				}
				p.openInventory(GuiUtil.getOptionsGui(name));
				return true;
			}else if(args[0].equalsIgnoreCase("listMob")){
				String name = GameUtil.getSelect(p);
				if(name == null){
					p.sendMessage("��3Dun> ��f�ШϥΫ��O/Dun select <�ƥ�> ��ܻݭn�]�w���ƥ�");
					return true;
				}
					
				List<String> list = ConfigUtil.getSpawn_EntityList(name);
				if(list == null){
					p.sendMessage("��3Dun> ��f�C���Ū�");
					return true;
				}
						
				Aerry A;
				Location L;
				for(String str : list){
					A = new Aerry(str,p.getWorld());
					L = A.getLocation();
					p.sendMessage(" - " + L.getBlockX() + "," + L.getBlockY() + "," + L.getBlockZ() + " | " + A.getMobName());
				}
				return true;
			}else if(args[0].equalsIgnoreCase("listMob")){
				String name = GameUtil.getSelect(p);
				if(name == null){
					p.sendMessage("��3Dun> ��f�ШϥΫ��O/Dun select <�ƥ�> ��ܻݭn�]�w���ƥ�");
					return true;
				}
				
				
			}else if(args[0].equalsIgnoreCase("2")){
				p.sendMessage("��3Dun> ��f�]�w���O");
				help(p,helplist2);
				p.sendMessage("��3�Х�/Dun <����> �d��");
				return true;
			}else if(args[0].equalsIgnoreCase("3")){
				p.sendMessage("��3Dun> ��f�Ǫ����O");
				help(p,helplist3);
				p.sendMessage("��3�Х�/Dun <����> �d��");
				return true;
			}
			
		}
		
		if(args.length == 4){
			if(args[0].equalsIgnoreCase("SetSpawn")){
				String name = GameUtil.getSelect(p);
				if(name == null){
					p.sendMessage("��3Dun> ��f�ШϥΫ��O/Dun select <�ƥ�> ��ܻݭn�]�w���ƥ�");
					return true;
				}
				
				try{
					ConfigUtil.setSpawn_SpawnPoint(name, 
							Integer.parseInt(args[1]), 
							Integer.parseInt(args[2]), 
							Integer.parseInt(args[3]));
					p.sendMessage("��3Dun> ��f�w�]�w�X���I");
				}catch(Exception ex){
					p.sendMessage("��3Dun> ��f�]�m���~");
				}
				return true;
			}
		}
		
		if(args.length == 5){
			if(args[0].equalsIgnoreCase("addMob")){
				String name = GameUtil.getSelect(p);
				if(name == null){
					p.sendMessage("��3Dun> ��f�ШϥΫ��O/Dun select <�ƥ�> ��ܻݭn�]�w���ƥ�");
					return true;
				}
				
				try{
					String str = 
							Integer.parseInt(args[2]) + "," + 
							Integer.parseInt(args[3]) + "," + 
							Integer.parseInt(args[4]) + "," + 
							args[1];
					
					List<String> list = ConfigUtil.getSpawn_EntityList(name);
					list = list == null ? Lists.newArrayList() : list;
					list.add(str);
					ConfigUtil.setSpawn_EntityList(name, list);
					p.sendMessage("��3Dun> ��f�w�s�W�Ǫ�");
				}catch(Exception ex){
					p.sendMessage("��3Dun> ��f�]�m���~");
				}
				return true;
			}
		}
		
		
		p.sendMessage("��3Dun> ��f�򥻫��O");
		help(p,helplist1);
		p.sendMessage("��3�Х�/Dun <����> �d��");
		return true;
	}
	public static String[] helplist1 = {
			"/Dun ��7Create <�ƥ�>","/Dun Create <�ƥ�>","�Ыذƥ��]�w��",
			"/Dun ��7Delete <�ƥ�>","/Dun Delete <�ƥ�>","�R���ƥ��]�w��",
			"/Dun ��7select <�ƥ�>","/Dun select <�ƥ�>","��ܰƥ�"};

	public static String[] helplist2 = {
			"/Dun ��7Join ","/Dun Join ","�]�w�i�JĲ�o",
			"/Dun ��7Quit","/Dun Quit","�]�w����Ĳ�o",
			"/Dun ��7Set","/Dun Set","�]�w�ƥ��\�i�v",
			"/Dun ��7setspawn <x> <y> <z>","/Dun setspawn <x> <y> <z>","�]�w�X���I"};
	
	public static String[] helplist3 = {
			"/Dun ��7addMob <�Ǫ��W��> <x> <y> <z>","/Dun addMob <x> <y> <z>","�s�W�Ǫ�",
			"/Dun ��7delMob <��>","/Dun delMob <��>","�����ͦ��Ǫ��C���ĴX��",
			"/Dun ��7listMob","/Dun listMob","�d�ݥͦ��Ǫ��C��"};
	
		
	public void help(Player p, String[] list){
		for(int i = 0; i + 2 < list.length; i = i +3){
			TitleApi.sendAction("{\"text\":\"" + list[i] + "\","
					+ "\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"" + list[i+1] + "\"},"
					+ "\"hoverEvent\":{\"action\":\"show_text\",\"value\":\""
						+ list[i+2]
						+ "\n�I���H�d�ݫ��O"
					+ "\"}}", p);
		}
	}
}
