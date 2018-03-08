package selim.enderrifts.events.handlers;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import selim.enderrifts.ModInfo;
import selim.enderrifts.world.DimensionRift;

public class PurpleTint {

	private PurpleUI purpleUi;
	private boolean on;

	@SideOnly(Side.CLIENT)
	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public void onRenderGui(RenderGameOverlayEvent.Pre event) {
//		if (event.getType() == ElementType.ALL) {
			if (purpleUi == null)
				purpleUi = new PurpleUI(Minecraft.getMinecraft());
			if (!on && DimensionRift.isTestDimension(Minecraft.getMinecraft().player.dimension)) {
				this.on = true;
				purpleUi.render();
			} else
				this.on = false;
//		}
	}

	public static class PurpleUI extends Gui {

		private final Minecraft mc;
		private boolean on = false;

		public PurpleUI(Minecraft mc) {
			this.mc = mc;
		}

		public void render() {
			if (DimensionRift.isTestDimension(mc.player.dimension) && !on) {
				on = true;
				// System.out.println("adding purple tint");
				ScaledResolution scaled = new ScaledResolution(mc);
				GL11.glPushMatrix();
				GL11.glDepthMask(false);
				GL11.glEnable(GL11.GL_BLEND);
				OpenGlHelper.glBlendFunc(770, 771, 1, 0);
				drawRect(0, 0, scaled.getScaledWidth(), scaled.getScaledHeight(),
						MathHelper.rgb((float) ModInfo.PURPLE_COLOR.x, (float) ModInfo.PURPLE_COLOR.y,
								(float) ModInfo.PURPLE_COLOR.z) | (85 << 24));
				GL11.glDisable(GL11.GL_BLEND);
				GL11.glPopMatrix();
			} else
				on = false;
		}

		// private boolean enabled = false;
		//
		// @Override
		// public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		// if (enabled) {
		// ScaledResolution scaled = new ScaledResolution(mc);
		// drawRect(0, 0, scaled.getScaledWidth(), scaled.getScaledHeight(),
		// MathHelper.rgb((float) ModInfo.PURPLE_COLOR.x, (float)
		// ModInfo.PURPLE_COLOR.y,
		// (float) ModInfo.PURPLE_COLOR.z));
		// }
		// }
		//
		// public void setEnabled(boolean enabled) {
		// this.enabled = enabled;
		// }

	}

}