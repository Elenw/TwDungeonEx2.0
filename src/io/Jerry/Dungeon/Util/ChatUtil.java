package io.Jerry.Dungeon.Util;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class ChatUtil {
	public static HashMap<Player,String> list = new HashMap<Player,String>();
	
	public static void setJoin(Player p){
		if(list.get(p) != null){
			p.sendMessage("��3Dun> ��f�Х��h�X�ثe����");
			return;
		}
		
		String name = GameUtil.getSelect(p);
		if(name == null){
			p.sendMessage("��3Dun> ��f�ШϥΫ��O/Dun select <�ƥ�> ��ܻݭn�]�w���ƥ�");
			return;
		}
		GameUtil.ban.add(p);
		page0(p);
		
	}
	
	public static void setQuit(Player p){
		if(list.get(p) != null){
			p.sendMessage("��3Dun> ��f�Х��h�X�ثe����");
			return;
		}
		
		String name = GameUtil.getSelect(p);
		if(name == null){
			p.sendMessage("��3Dun> ��f�ШϥΫ��O/Dun select <�ƥ�> ��ܻݭn�]�w���ƥ�");
			return;
		}
		GameUtil.ban.add(p);
		page1(p);
	}
	
	public static void leave(Player p){
		list.put(p, null);
		GameUtil.selectGame(p, null);
		GameUtil.selectEnd(p, null);
		p.sendMessage("��3Dun> ��f�h�X�s��");
		GameUtil.ban.remove((OfflinePlayer)p);
	}
	
	public static void page0(Player p){
		list.put(p, "0");
		
		p.sendMessage("��3Dun> ��f�s��ƥ��i�JĲ�o");
		p.sendMessage("��61. ��e�s��i�J�ƥ�");
		p.sendMessage("��62. ��e�s��i�J�n�D");
		p.sendMessage("��63. ��3�h�X�s��");
		p.sendMessage("��6\n��6��e�䤤�@�ӡ�6�ƥ�(Event)Ĳ�o��|�ˬd�i�J�n�D(Needs)");
		p.sendMessage("��6�p�G��e�Ҧ���6�i�J�n�D�����Y�i�i�J�ƥ�");
	}
	
	public static void page0_1(Player p){
		list.put(p, "0_1");
		
		String name = GameUtil.getSelect(p);
		p.sendMessage("��3Dun> ��f�s��ƥ��i�J�ƥ�");
		p.sendMessage("��61. ��e�I������" + (ConfigUtil.getJoin_ClickEntity(name) == null ? "��7(�S���]�m)" : "��a(�w�g�]�m)"));
		p.sendMessage("��62. ��e�I�����" + (
				ConfigUtil.getJoin_ClickBlock(name) != null || ConfigUtil.getJoin_ClickBlock_useItem(name) != null 
				? "��a(�w�g�]�m)" : "��7(�S���]�m)" ));
		p.sendMessage("��63. ��e�i�J��m" + (ConfigUtil.getJoin_ToLocation(name) == null ? "��7(�S���]�m)" : "��a(�w�g�]�m)"));
		p.sendMessage("��64. ��3�W�@��");
		
	}
	
	public static void page0_1_1(Player p){
		list.put(p, "0_1_1");
		
		String name = GameUtil.getSelect(p);
		String entity = ConfigUtil.getJoin_ClickEntity(name);
		p.sendMessage("��3Dun> ��f�s���I������Ĳ�o����");
		p.sendMessage("��e��g�n�I�������骺��ܦW�١A�ثe" + (entity == null ? "�S���]�m" : "�]�w��f" +entity));
		p.sendMessage("��e��g\"back\"�h�X�s��A��g\"delete\"������Ĳ�o");
	}
	
	public static void page0_1_2(Player p){
		list.put(p, "0_1_2");
		
		String name = GameUtil.getSelect(p);
		p.sendMessage("��3Dun> ��f�s���I�����Ĳ�o�Ӹ`");
		p.sendMessage("��61. ��e�I�����" + (ConfigUtil.getJoin_ClickBlock(name) == null ? "��7(�S������)" : "��a(�]�m����)"));
		p.sendMessage("��62. ��e�ϥΪ��~" + (ConfigUtil.getJoin_ClickBlock_useItem(name) == null ? "��7(�S������)" : "��a(�]�m����)"));
		p.sendMessage("��63. ��3�W�@��");
	}
	
	public static void page0_1_3(Player p){
		list.put(p, "0_1_3");
		
		String name = GameUtil.getSelect(p);
		String loc = ConfigUtil.getJoin_ToLocation(name);
		p.sendMessage("��3Dun> ��f�s��i�J��mĲ�o����");
		p.sendMessage("��e��g\"here\"�A�]�m�ݭn�I���A��l���B��e����m�A�ثe" + (loc == null ? "�S���]�m" : "�]�w��f" + loc));
		p.sendMessage("��e��g\"back\"�h�X�s��A��g\"delete\"�����ӱ���");
	}
	
	public static void page0_1_2_1(Player p){
		list.put(p, "0_1_2_1");
		
		String name = GameUtil.getSelect(p);
		String Block = ConfigUtil.getJoin_ClickBlock(name);
		p.sendMessage("��3Dun> ��f�s���I�����Ĳ�o����");
		p.sendMessage("��e��g\"here\"�A�]�m�ݭn�I���A��l�}�U��e������A�ثe" + (Block == null ? "�S���]�m" : "�]�w��f" + Block));
		p.sendMessage("��e��g\"back\"�h�X�s��A��g\"delete\"�����ӱ���");
	}
	
	public static void page0_1_2_2(Player p){
		list.put(p, "0_1_2_2");
		
		String name = GameUtil.getSelect(p);
		ItemStack item = ConfigUtil.getJoin_ClickBlock_useItem(name);
		p.sendMessage("��3Dun> ��f�s���I�����Ĳ�o����");
		p.sendMessage("��e��g\"hand\"�A�]�m�ݭn�ϥΧA��l��W��e�����~�I���A�ثe" + 
				(item == null ? "�S���]�m" : "�]�w��f" + ItemsUtil.GetName(item)));
		p.sendMessage("��e��g\"back\"�h�X�s��A��g\"delete\"�����ӱ���");
	}
	
	public static void page0_2(Player p){
		list.put(p, "0_2");
		
		String name = GameUtil.getSelect(p);
		p.sendMessage("��3Dun> ��f�s��ƥ��i�J�n�D");
		p.sendMessage("��61. ��e����H��" + 
				(ConfigUtil.getNeed_JoinSize_Mix(name) != 1 || ConfigUtil.getNeed_JoinSize_Max(name)  != -1  
				? "��a(�w�g�]�m)" : "��7(�S������)"));
		p.sendMessage("��62. ��e����" + (ConfigUtil.getNeed_Money(name) == -1 ? "��7(�S������)" : "��a(�w�g�]�m)"));
		p.sendMessage("��63. ��e�v��" + (ConfigUtil.getNeed_Permission(name) == null ? "��7(�S������)" : "��a(�w�g�]�m)"));
		p.sendMessage("��64. ��e����" + (ConfigUtil.getNeed_Exp_Mix(name) != 0 || ConfigUtil.getNeed_Exp_Max(name) != -1
				?  "��a(�w�g�]�m)" : "��7(�S������)"));
		p.sendMessage("��65. ��3�W�@��");
	}
	
	public static void page0_2_1(Player p){
		list.put(p, "0_2_1");
		
		String name = GameUtil.getSelect(p);
		int mix = ConfigUtil.getNeed_JoinSize_Mix(name);
		int max = ConfigUtil.getNeed_JoinSize_Max(name);
		
		p.sendMessage("��3Dun> ��f�s�趤��H�ƭn�D");
		p.sendMessage("��e��g�榡:\"<�̤֤H��>~<�̤j�H��>\"�A�ثe" + 
				(mix != 1 || max != -1 ? "�]�w��f" + mix + "~" + (max == -1 ? "��" : max) : "�S���]�m"));
		p.sendMessage("��e��g\"back\"�h�X�s��A��g\"delete\"�����ӭn�D");
		p.sendMessage("��e��g�t�ƥN��Ӷ��L��");
	}
	
	public static void page0_2_2(Player p){
		list.put(p, "0_2_2");
		
		String name = GameUtil.getSelect(p);
		int money = ConfigUtil.getNeed_Money(name);
		
		p.sendMessage("��3Dun> ��f�s������n�D");
		p.sendMessage("��e��g�ݭn�F�쪺�����A�ثe" + 
				(money == -1 ? "�S���]�m" : "�]�w��f$" + money ));
		p.sendMessage("��e��g\"back\"�h�X�s��A��g\"delete\"�����ӭn�D");
	}
	
	public static void page0_2_3(Player p){
		list.put(p, "0_2_3");
		
		String name = GameUtil.getSelect(p);
		String per = ConfigUtil.getNeed_Permission(name);
		
		p.sendMessage("��3Dun> ��f�s���v���n�D");
		p.sendMessage("��e��g�ݭn���v���A�ثe" + 
				(per == null ? "�S���]�m" : "�]�w��f$" + per ));
		p.sendMessage("��e��g\"back\"�h�X�s��A��g\"delete\"�����ӭn�D");
	}
	
	public static void page0_2_4(Player p){
		list.put(p, "0_2_4");
		
		String name = GameUtil.getSelect(p);
		int mix = ConfigUtil.getNeed_Exp_Mix(name);
		int max = ConfigUtil.getNeed_Exp_Max(name);
		
		p.sendMessage("��3Dun> ��f�s�赥�ŭn�D");
		p.sendMessage("��e��g�榡:\"<�ֵ̤���>~<�̤j����>\"�A�ثe" + 
				(mix != 0 || max != -1 ? "�]�w��f" + mix + "~" + (max == -1 ? "��" : max) : "�S���]�m"));
		p.sendMessage("��e��g\"back\"�h�X�s��A��g\"delete\"�����ӭn�D");
		p.sendMessage("��e��g�t�ƥN��Ӷ��L��");
	}
	
	public static void page1(Player p){
		list.put(p, "1");
		
		p.sendMessage("��3Dun> ��f�s��ƥ�����Ĳ�o");
		p.sendMessage("��61. ��e�s�W����Ĳ�o");
		p.sendMessage("��62. ��e�s�赲��Ĳ�o");
		p.sendMessage("��63. ��e��������Ĳ�o");
		p.sendMessage("��64. ��3�h�X�s��");
		p.sendMessage("��6\n��6��e�䤤�@�ӡ�6�ƥ�(Event)Ĳ�o��t��������y(Bonus)");
		p.sendMessage("��6�P�@�Өƥ������i�H����e���P��6��Ĳ�o");
	}
	
	public static void page1_1(Player p){
		list.put(p, "1_1");
		
		p.sendMessage("��3Dun> ��f�s�W����Ĳ�o");
		p.sendMessage("��e��gĲ�o�ۭq�W�r�A��g\"back\"�h�X�s��");
	}
	
	public static void page1_2(Player p){
		list.put(p, "1_2");
		
		String name = GameUtil.getSelect(p);
		Set<String> list = ConfigUtil.getQuit(name);
		p.sendMessage("��3Dun> ��f�s�赲��Ĳ�o");
		p.sendMessage("��e����Ĳ�o�C��");
		for(String str : list){
			p.sendMessage("��6 - ��f" + str);
		}
		p.sendMessage("��e��g�n�s�誺Ĳ�o���W�r�A��g\"back\"�h�X�s��");
	}
	
	public static void page1_2_0(Player p){
		list.put(p, "1_2_0");
		
		String name = GameUtil.getSelect(p);
		String quit = GameUtil.getSelectEnd(p);
		String type = ConfigUtil.getQuit_Type(name,quit);
		String info = ConfigUtil.getQuit_Info(name,quit);
		p.sendMessage("��3Dun> ��f�s�赲��Ĳ�o");
		p.sendMessage("��61. ��eĲ�o: " +  ConfigUtil.toString(type,info));
		p.sendMessage("��62. ��e�������y: " +  (ConfigUtil.hasQuit_Bonus(name,quit) ? "��a(�w�g�]�m)" : "��7(�S���]�m)"));
		p.sendMessage("��63. ��3�h�X�s��");
	}
	
	public static void page1_2_0_1(Player p){
		list.put(p, "1_2_0_1");
		
		p.sendMessage("��3Dun> ��f�s�赲��Ĳ�oĲ�o����");
		p.sendMessage("��61. ��e���a���`");
		p.sendMessage("��62. ��e���馺�`");
		p.sendMessage("��63. ��e�I������");
		p.sendMessage("��64. ��e�}�a���");
		p.sendMessage("��65. ��e�I�����");
		p.sendMessage("��66. ��e�i�J��m");
		p.sendMessage("��67. ��e�ɶ�");
		p.sendMessage("��68. ��3�h�X�s��");
	}
	
	public static void page1_2_0_1_1(Player p){
		list.put(p, "1_2_0_1_1");
		
		p.sendMessage("��3Dun> ��f�s�赲��Ĳ�oĲ�o�Ӹ`");
		p.sendMessage("��e��g�X�h�Ӷi�J�ƥ������a���`Ĳ�o�Өƥ�");
		p.sendMessage("��e�Ҧp��g\"4\"�N��4�ӡA��g\"back\"�h�X�s��");
	}
	
	public static void page1_2_0_1_2(Player p){
		list.put(p, "1_2_0_1_2");
		
		p.sendMessage("��3Dun> ��f�s�赲��Ĳ�oĲ�o�Ӹ`");
		p.sendMessage("��e��g<x>�ӦW�r��<y>�����馺�`Ĳ�o�Өƥ�");
		p.sendMessage("��e�榡: \"<x> <y>\"�A�Ҧp��g\"10 &c�g��\"");
		p.sendMessage("��E��g\"back\"�h�X�s��");
	}
	
	public static void page1_2_0_1_3(Player p){
		list.put(p, "1_2_0_1_3");
		
		p.sendMessage("��3Dun> ��f�s�赲��Ĳ�oĲ�o�Ӹ`");
		p.sendMessage("��e��g�ӦW�r������Q�I����|Ĳ�o�ƥ�");
		p.sendMessage("��E��g\"back\"�h�X�s��");
	}
	
	public static void page1_2_0_1_4(Player p){
		list.put(p, "1_2_0_1_4");
		
		p.sendMessage("��3Dun> ��f�s�赲��Ĳ�oĲ�o�Ӹ`");
		p.sendMessage("��e��g�}�a<x>�Ӻ�����<y>�����Ĳ�o�Өƥ�");
		p.sendMessage("��e�榡: \"<x> <y>\"�A�Ҧp��g\"3 glass\"");
		p.sendMessage("��E��g\"back\"�h�X�s��");
	}
	
	public static void page1_2_0_1_5(Player p){
		list.put(p, "1_2_0_1_5");
		
		p.sendMessage("��3Dun> ��f�s�赲��Ĳ�oĲ�o�Ӹ`");
		p.sendMessage("��e��g�Ӯy�Ъ�����Q�I����|Ĳ�o�ƥ�");
		p.sendMessage("��e�榡: \"<x> <y> <z>\"�A�Ҧp��g\"0 64 0\"");
		p.sendMessage("��E��g\"back\"�h�X�s��");
	}
	
	public static void page1_2_0_1_6(Player p){
		list.put(p, "1_2_0_1_6");
		
		p.sendMessage("��3Dun> ��f�s�赲��Ĳ�oĲ�o�Ӹ`");
		p.sendMessage("��e��g�i�J�Ӯy�Ы�|Ĳ�o�ƥ�");
		p.sendMessage("��e�榡: \"<x> <y> <z>\"�A�Ҧp��g\"0 64 0\"");
		p.sendMessage("��E��g\"back\"�h�X�s��");
	}
	
	public static void page1_2_0_1_7(Player p){
		list.put(p, "1_2_0_1_7");
		
		p.sendMessage("��3Dun> ��f�s�赲��Ĳ�oĲ�o�Ӹ`");
		p.sendMessage("��e�C���ɶ��F��X�h��ɷ|Ĳ�o�ƥ�");
		p.sendMessage("��E��g\"back\"�h�X�s��");
	}
	
	public static void page1_2_0_2(Player p){
		list.put(p, "1_2_0_2");
		
		String name = GameUtil.getSelect(p);
		String quit = GameUtil.getSelectEnd(p);
		p.sendMessage("��3Dun> ��f�s�赲��Ĳ�o���y");
		p.sendMessage("��61. ��e���O" + (ConfigUtil.getQuit_Bonus_Command(name, quit) != null  ? "��a(�w�g�]�m)" : "��7(�S���]�m)"));
		p.sendMessage("��62. ��e����" + (ConfigUtil.getQuit_Bonus_Money(name, quit) != -1  ? "��a(�w�g�]�m)" : "��7(�S���]�m)"));
		p.sendMessage("��63. ��e�g���" + (ConfigUtil.getQuit_Bonus_Exp(name, quit) != -1  ? "��a(�w�g�]�m)" : "��7(�S���]�m)"));
		p.sendMessage("��64. ��e���~" + (ConfigUtil.getQuit_Bonus_Item(name, quit) != null  ? "��a(�w�g�]�m)" : "��7(�S���]�m)"));
		p.sendMessage("��65. ��e��m" + (ConfigUtil.getQuit_Bonus_Location(name, quit) != null  ? "��a(�w�g�]�m)" : "��7(�S���]�m)"));
		p.sendMessage("��66. ��3�h�X�s��");
	}
	
	public static void page1_2_0_2_1(Player p){
		list.put(p, "1_2_0_2_1");
		
		String name = GameUtil.getSelect(p);
		String quit = GameUtil.getSelectEnd(p);
		String cmd = ConfigUtil.getQuit_Bonus_Command(name, quit);
		
		p.sendMessage("��e��g������t�η|�۰ʰ��檺���O�A�ثe" + 
				(cmd == null ? "�S���]�m" : "�]�w��f" + cmd ));
		p.sendMessage("��e���O�]�t <PLAYER>�i���o���a�W��");
		p.sendMessage("��e��g\"back\"�h�X�s��A��g\"delete\"�����Ӽ��y");
	}
	
	public static void page1_2_0_2_2(Player p){
		list.put(p, "1_2_0_2_2");
		
		String name = GameUtil.getSelect(p);
		String quit = GameUtil.getSelectEnd(p);
		int m = ConfigUtil.getQuit_Bonus_Money(name, quit);
		
		p.sendMessage("��e��g�����᪱�a��o�h�֪����A�ثe" + 
				(m == -1 ? "�S���]�m" : "�]�w��f$" + m ));
		p.sendMessage("��e��g\"back\"�h�X�s��A��g\"delete\"�����Ӽ��y");
	}
	
	public static void page1_2_0_2_3(Player p){
		list.put(p, "1_2_0_2_3");
		
		String name = GameUtil.getSelect(p);
		String quit = GameUtil.getSelectEnd(p);
		int m = ConfigUtil.getQuit_Bonus_Exp(name, quit);
		
		p.sendMessage("��e��g�����᪱�a��o�h�ָg��ȡA�ثe" + 
				(m == -1 ? "�S���]�m" : "�]�w��f" + m ));
		p.sendMessage("��e��g\"back\"�h�X�s��A��g\"delete\"�����Ӽ��y");
	}
	
	public static void page1_2_0_2_4(Player p){
		list.put(p, "1_2_0_2_4");
		
		String name = GameUtil.getSelect(p);
		String quit = GameUtil.getSelectEnd(p);
		String item = ConfigUtil.getQuit_Bonus_Item(name, quit);
		
		p.sendMessage("��e��g�����᪱�a��o�����~" + 
				(item == null ? "�A�ثe�S���]�m" : "" ));
		p.sendMessage("��e��g\"add\"�W�[��W�����~����o�C��");
		p.sendMessage("��e��g\"delete <x>\"�����C����x�������~");
		p.sendMessage("��e��g\"back\"�h�X�s��");
		if(item != null){
			List<ItemStack> item_list = ConfigUtil.getItemList(item);
			p.sendMessage("��e��o�C��:");
			for(int i = 0; i < item_list.size(); i ++){
				p.sendMessage("��6" + (i+1) + ". ��f" + ItemsUtil.GetName(item_list.get(i)));
			}
		}
	}
	
	public static void page1_2_0_2_5(Player p){
		list.put(p, "1_2_0_2_5");
		
		String name = GameUtil.getSelect(p);
		String quit = GameUtil.getSelectEnd(p);
		String loc = ConfigUtil.getQuit_Bonus_Location(name, quit);
		
		p.sendMessage("��e��g�����᪱�a�|�ǰe�줰��a��A�ثe" + 
				(loc == null ? "�S���]�m" : "�]�w��f" + loc ));
		p.sendMessage("��e��g\"here\"Ĳ�o��ǰe��A����m");
		p.sendMessage("��e��g\"back\"�h�X�s��A��g\"delete\"�����Ӽ��y");
	}
	
	public static void page1_3(Player p){
		list.put(p, "1_3");
		
		String name = GameUtil.getSelect(p);
		Set<String> list = ConfigUtil.getQuit(name);
		p.sendMessage("��3Dun> ��f��������Ĳ�o");
		p.sendMessage("��e����Ĳ�o�C��");
		for(String str : list){
			p.sendMessage("��6 - ��f" + str);
		}
		p.sendMessage("��e��g�n������Ĳ�o���W�r�A��g\"back\"�h�X�s��");
	}
}
