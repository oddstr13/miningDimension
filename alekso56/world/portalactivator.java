package alekso56.world;

import java.util.List;

import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;

public class portalactivator implements ICommand {

	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getCommandName() {
		return "tm";
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender) {
		return "/tm";
	}

	@Override
	public List getCommandAliases() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void processCommand(ICommandSender icommandsender, String[] astring) {
	 EntityPlayerMP playermp = miningworld.getPlayerForName(icommandsender, icommandsender.getCommandSenderName());
	 if(playermp.dimension != miningworld.dimension){
		MinecraftServer.getServer().getConfigurationManager().transferPlayerToDimension(playermp, miningworld.dimension);
	 }
	 else if(astring[0].equalsIgnoreCase("o") && (astring.length > 0)){
		 MinecraftServer.getServer().getConfigurationManager().transferPlayerToDimension(playermp, 0);
	 }
	}

	@Override
	public boolean canCommandSenderUseCommand(ICommandSender icommandsender) {
		return true;
	}

	@Override
	public List addTabCompletionOptions(ICommandSender icommandsender,
			String[] astring) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isUsernameIndex(String[] astring, int i) {
		// TODO Auto-generated method stub
		return false;
	}

}
