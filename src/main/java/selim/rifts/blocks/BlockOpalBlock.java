package selim.rifts.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;
import selim.rifts.EnderRifts;
import selim.rifts.ModInfo;
import selim.rifts.api.docs.IDocEntryLink;

public class BlockOpalBlock extends Block implements IDocEntryLink {

	public BlockOpalBlock() {
		super(Material.ROCK);
		this.setRegistryName(new ResourceLocation(ModInfo.ID, "opal_block"));
		this.setUnlocalizedName(ModInfo.ID + ":opal_block");
		this.setCreativeTab(EnderRifts.mainTab);
		this.setHardness(1.5f);
	}

	@Override
	public ResourceLocation getLinkedEntry() {
		return new ResourceLocation(ModInfo.ID, "opal");
	}

}
