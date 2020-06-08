package draylar.nonethernausea.mixin;

import draylar.nonethernausea.NoNetherNauseaClient;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.hud.InGameHud;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Environment(EnvType.CLIENT)
@Mixin(InGameHud.class)
public class InGameHudMixin {

    @Inject(
            method = "renderPortalOverlay",
            at = @At("HEAD"),
            cancellable = true
    )
    private void cancelPortalOverlay(float f, CallbackInfo ci) {
        if(NoNetherNauseaClient.CONFIG.disablePortalOverlay) {
            ci.cancel();
        }
    }
}
