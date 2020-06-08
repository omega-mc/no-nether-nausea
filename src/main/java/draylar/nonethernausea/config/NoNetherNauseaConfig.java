package draylar.nonethernausea.config;

import me.sargunvohra.mcmods.autoconfig1u.ConfigData;
import me.sargunvohra.mcmods.autoconfig1u.annotation.Config;
import me.sargunvohra.mcmods.autoconfig1u.shadowed.blue.endless.jankson.Comment;

@Config(name = "nonethernausea")
public class NoNetherNauseaConfig implements ConfigData {
    @Comment(value = "Disable the nausea effect from all sources.")
    public boolean disableNausea = true;

    @Comment(value = "Disable the nausea effect from being inside a Nether Portal.")
    public boolean disablePortalNausea = true;

    @Comment(value = "Disable the purple Nether Portal overlay effect.")
    public boolean disablePortalOverlay = true;
}
