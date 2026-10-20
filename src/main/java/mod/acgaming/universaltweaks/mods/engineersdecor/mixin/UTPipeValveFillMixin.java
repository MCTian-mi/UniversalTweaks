package mod.acgaming.universaltweaks.mods.engineersdecor.mixin;

import net.minecraftforge.fluids.FluidStack;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import wile.engineersdecor.blocks.BlockDecorPipeValve;

@Mixin(value = BlockDecorPipeValve.BTileEntity.class, remap = false)
public class UTPipeValveFillMixin
{
    @ModifyVariable(method = "fill(Lnet/minecraftforge/fluids/FluidStack;Z)I",
        at = @At("HEAD"), argsOnly = true, ordinal = 0)
    private FluidStack utCopyResource(FluidStack resource)
    {
        return resource == null ? null : resource.copy();
    }
}