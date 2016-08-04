package io.Jerry.Dungeon.Command;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import io.Jerry.Dungeon.Party;
import io.Jerry.Dungeon.Games.Game;
import io.Jerry.Dungeon.Util.ConfigUtil;
import io.Jerry.Dungeon.Util.GameUtil;
import io.Jerry.Dungeon.Util.PartyUtil;
import io.Jerry.Dungeon.Util.TitleApi;

public class PartyC implements CommandExecutor {
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if(!(sender instanceof Player)){
			return false;
		}
		
		Player p = (Player)sender;
		if(args.length == 0){
			p.sendMessage("��3/party ��7<���a> ��f- �o�X�ն��n�D");
			p.sendMessage("��3/party ��7kick��3 <���a> ��f- ��X����");
			p.sendMessage("��3/party ��7leave��3 <���a> ��f- ���}����");
			p.sendMessage("��3/party ��7owner��3 <���a> ��f- �ഫ����");
			p.sendMessage("��3/party ��7list ��f- �d�ݶ���");
			p.sendMessage("��3/party ��7play ��f- �i�J����ƥ�");
			return true;
		}
		
		Party py = PartyUtil.getTeam(p);
		if(args.length == 1 && args[0].equalsIgnoreCase("leave")){
			if(py == null){
				p.sendMessage("��3Party> ��f�A�S���[�J���󶤥�");
				return true;
			}
			
			if(py.isOwner(p)){
				PartyUtil.sendMessage(py.list,"����Ѵ��F");
				PartyUtil.list.remove(py);
			}else{
				py.list.remove(p.getName());
				PartyUtil.sendMessage(py.list,"���}�F����");
				p.sendMessage("��3Party> ��f�A���}�F����");
			}
			return true;
		}
		
		if(args.length == 2 && args[0].equalsIgnoreCase("Kick")){
			if(py == null){
				p.sendMessage("��3Party> ��f�A�S���[�J���󶤥�");
				return true;
			}
			
			if(py.isOwner(p) == false){
				p.sendMessage("��3Party> ��f�A���O����");
				return true;
			}
			
			OfflinePlayer T = Bukkit.getOfflinePlayer(args[1]);
			if(T == null){
				p.sendMessage("��3Party> ��f�䤣��" + args[1] + "���a");
				return true;
			}
			
			if(T.getName().equals(p.getName())){
				p.sendMessage("��3Party> ��f�A�����X�ۤv");
				return true;
			}
				
			if(py.isMembers(T.getName())){
				py.remove(T.getName());
				PartyUtil.sendMessage(py.list,T.getName() + "�Q��X",T.getName() + "���}�F����");
				if(T.isOnline()){
					T.getPlayer().sendMessage("��6�A�Q��X�F����");
				}
			}else{
				p.sendMessage("��3Party> ��f�L���O�A������");
			}
			return true;
		}
		
		if(args.length == 2 && args[0].equalsIgnoreCase("Owner")){
			if(py == null){
				p.sendMessage("��3Party> ��f�A�S���[�J���󶤥�");
				return true;
			}
			
			if(py.isOwner(p) == false){
				p.sendMessage("��3Party> ��f�A���O����");
				return true;
			}

			Player T = Bukkit.getPlayer(args[1]);
			if(T == null){
				p.sendMessage("��3Party> ��f�䤣��" + args[1] + "���a");
				p.playSound(p.getLocation(), "note.pling", 1, 1);
				return true;
			}
			
			if(T.getName().equals(p.getName())){
				p.sendMessage("��3Party> ��f�A�����אּ�ۤv");
				return true;
			}
				
			if(py.isMembers(T.getName()) == false){
				p.sendMessage("��3Party> ��f�L���O�A������");
				return true;
			}

			if(T.isOnline() == false){
				p.sendMessage("��3Party> ��f" + T.getName() + "�ä��b�u");
				return true;
			}
				
			py.Owner = T.getName();
			PartyUtil.sendMessage(py.list,py.Owner + "��������");
			return true;
		}
		
		if(args[0].equalsIgnoreCase("List")){
			if(py == null){
				p.sendMessage("��3Party> ��f�A�S���[�J���󶤥�");
				return true;
			}
			
			p.sendMessage(py.Owner + "������");
			for(String TT : py.list){
				p.sendMessage("- ��7" + TT);
			}
			return true;
		}
		
		if(args[0].equalsIgnoreCase("Play")){
//			List<OfflinePlayer> list = Lists.newArrayList();
//			if(py != null){
//				for(String name : py.list){
//					list.add(Bukkit.getOfflinePlayer(name));
//				}
//			}else{
//				list.add(p);
//			}
//			
//			
//			Game LastG = null;
//			for(OfflinePlayer op : list){
//				if(LastG == null){
//					LastG = GameUtil.getGame(op);
//				}
//			}
			Game G = GameUtil.getGame(p);
			
			
			if(G == null && py != null){
				for(String op : py.list){
					if(G == null){
						G = GameUtil.getGame(Bukkit.getOfflinePlayer(op));
					}
				}
			}
			
			
			if(G == null){
				p.sendMessage("��3Party> ��f�A/�A������S�����b�i�檺�ƥ�");
				return true;
			}
			
			if(G.getWorld().equals(p.getWorld())){
				p.sendMessage("��3Party> ��f�A���b�i��ƥ�,�A���B���O�ƥ��@��");
				return true;
			}
			
			if(G.getCanJoinPlayers().contains((OfflinePlayer)p)){
				p.sendMessage("��3Party> ��f�A����i�J�ƥ�,�A�w�g���`�ΰƥ��}�ҮɧA���O����");
				return true;
			}

			boolean Inventory = ConfigUtil.getOptions(G.getName(), "Inventory");

			p.setHealth(p.getMaxHealth());
			ItemStack[] a;
			ItemStack[] b;
			a = p.getInventory().getContents();
			b = p.getInventory().getArmorContents();
			p.getPlayer().teleport(G.getSpawn());
			if(Inventory){
				 p.getPlayer().getInventory().setContents(a);
				 p.getPlayer().getInventory().setArmorContents(b);
			}
			return true;
		}
		//TODO
		
		Player T = Bukkit.getPlayer(args[0]);
		if(T == null){
			p.sendMessage("��3Party> ��f�䤣��" + args[0] + "���a");
			return true;
		}
		
		if(T == p){
			p.sendMessage("��3Party> ��f�A�����ܽЦۤv");
			return true;
		}
		
		Party tpy = PartyUtil.getTeam(T);
		if(py != null){//�ۤv�w�g������
			if(py.AddList.contains(T.getName())){//�}�l�ܽ�T
				p.sendMessage("��3Party> ��f�A�w�g�ܽйL�L�F");
			}else{
				if(tpy != null){//��H�S������
					p.sendMessage("��3Party> ��f�L�w�g������F");
					return true;
				}
				
				py.AddList.add(T.getName());
				T.playSound(T.getLocation(), "note.pling", 1, 1);
				p.sendMessage("��6�w�o�X�ܽ�");
				T.sendMessage("��6" + p.getName() + "�ܽЧA�i�J�L������(" + py.Size() + "�H)");
				TitleApi.sendAction("{\"text\":\"��6�ϥ�/party " + p.getName() + " �Ρ�a���ڱ�����6\",\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/party " + p.getName() + "\"}}",T);
			}
		}else{//�ۤv�S������
			if(tpy != null){//�T���ܽ�
				if(tpy.AddList.contains(p.getName())){//��H�w�g�o�X�L�ܽ�
					p.sendMessage("��6���\�[�J");
					tpy.AddList.remove(p.getName());
					tpy.list.add(p.getName());
					PartyUtil.sendMessage(tpy.list,p.getName() + "�[�J�F����");
				}else{
					p.sendMessage("��3Party> ��f�L�w�g�[�J�F����");
				}
			}else{//��H�S������
				Party NewPy = new Party();
				NewPy.Owner = p.getName();
				NewPy.list.add(p.getName());
				NewPy.AddList.add(T.getName());
				PartyUtil.list.add(NewPy);
				
				p.sendMessage("��6�w�o�X�ܽ�");
				T.playSound(T.getLocation(), "note.pling", 1, 1);
				T.sendMessage("��6" + p.getName() + "�ܽЧA�i�J�L���s����");
				TitleApi.sendAction("{\"text\":\"��6�ϥ�/party " + p.getName() + " �Ρ�a���ڱ�����6\",\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/party " + p.getName() + "\"}}",T);
			}
		}
		return true;
	}
}
