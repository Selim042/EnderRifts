package selim.enderrifts.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

	protected static MainScreen lastScreen = new MainScreen();

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if (lastScreen == null)
			lastScreen = new MainScreen();
		return lastScreen;
	}

	public static MainScreen getOpenScreen() {
		if (lastScreen == null)
			lastScreen = new MainScreen();
		return lastScreen;
	}

}
