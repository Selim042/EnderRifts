package selim.enderrifts.misc;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.World;
import net.minecraftforge.common.DimensionManager;

public class WorldBlockPos extends BlockPos {

	private final int dimId;

	public WorldBlockPos(World world, BlockPos pos) {
		this(world, pos.getX(), pos.getY(), pos.getZ());
	}

	public WorldBlockPos(World world, int x, int y, int z) {
		super(x, y, z);
		this.dimId = world.provider.getDimension();
	}

	public WorldBlockPos(World world, double x, double y, double z) {
		super(x, y, z);
		this.dimId = world.provider.getDimension();
	}

	public WorldBlockPos(Entity source) {
		this(source.world, source.posX, source.posY, source.posZ);
	}

	public WorldBlockPos(World world, Vec3d vec) {
		this(world, vec.x, vec.y, vec.z);
	}

	public WorldBlockPos(World world, Vec3i source) {
		this(world, source.getX(), source.getY(), source.getZ());
	}

	public World getWorld() {
		return DimensionManager.getWorld(this.dimId);
	}

	public IBlockState getState() {
		return this.getWorld().getBlockState(this);
	}

	public TileEntity getTileEntity() {
		return this.getWorld().getTileEntity(this);
	}

}