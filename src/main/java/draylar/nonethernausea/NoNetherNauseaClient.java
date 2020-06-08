package draylar.nonethernausea;

import draylar.nonethernausea.config.NoNetherNauseaConfig;
import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import me.sargunvohra.mcmods.autoconfig1u.serializer.JanksonConfigSerializer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class NoNetherNauseaClient implements ClientModInitializer {

    public static final NoNetherNauseaConfig CONFIG = AutoConfig.register(NoNetherNauseaConfig.class, JanksonConfigSerializer::new).getConfig();

    @Override
    public void onInitializeClient() {

    }
}
