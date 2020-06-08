package draylar.nonethernausea.mixin;

import com.mojang.authlib.GameProfile;
import draylar.nonethernausea.NoNetherNauseaClient;
import draylar.nonethernausea.config.NoNetherNauseaConfig;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Environment(EnvType.CLIENT)
@Mixin(ClientPlayerEntity.class)
public abstract class ClientPlayerEntityMixin extends AbstractClientPlayerEntity {

    private ClientPlayerEntityMixin(ClientWorld world, GameProfile profile) {
        super(world, profile);
    }

    /**
     * {@link AbstractClientPlayerEntity#inNetherPortal} is used to determine whether to display Nether Portal nausea.
     * <p>The given value is set to false after displaying the nausea each tick, so we are safe to do that as well.
     *
     * @param ci  mixin callback information
     */
    @Inject(
            method = "updateNausea",
            at = @At("HEAD")
    )
    private void cancelPortalNausea(CallbackInfo ci) {
        if(NoNetherNauseaClient.CONFIG.disablePortalNausea) {
            this.inNetherPortal = false;
        }
    }
}
