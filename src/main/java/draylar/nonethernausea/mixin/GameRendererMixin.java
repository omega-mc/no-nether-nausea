package draylar.nonethernausea.mixin;

import draylar.nonethernausea.NoNetherNauseaClient;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.util.math.MathHelper;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Environment(EnvType.CLIENT)
@Mixin(GameRenderer.class)
public class GameRendererMixin {

    @Shadow @Final private MinecraftClient client;

    @Redirect(
            method = "renderWorld",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/util/math/MathHelper;lerp(FFF)F")
    )
    private float redirectNauseaScale(float delta, float first, float second) {
        if(NoNetherNauseaClient.CONFIG.disableNausea) {
            return 0;
        } else {
            return MathHelper.lerp(delta, this.client.player.lastNauseaStrength, this.client.player.nextNauseaStrength);
        }
    }
}
