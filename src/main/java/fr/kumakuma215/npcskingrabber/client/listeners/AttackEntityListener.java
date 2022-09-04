package fr.kumakuma215.npcskingrabber.client.listeners;

import com.mojang.authlib.minecraft.MinecraftProfileTexture;
import fr.kumakuma215.npcskingrabber.mixin.MinecraftClientAccessor;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.fabricmc.fabric.api.event.player.UseEntityCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.texture.PlayerSkinProvider;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.ClickEvent;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class AttackEntityListener implements AttackEntityCallback {
    @Override
    public ActionResult interact(PlayerEntity player, World world, Hand hand, Entity entity, @Nullable EntityHitResult hitResult) {
        if (player.isSneaking() && entity instanceof AbstractClientPlayerEntity clientPlayer) {
            PlayerSkinProvider skinProvider = ((MinecraftClientAccessor) MinecraftClient.getInstance()).getSkinProvider();
            String SKIN_URL = skinProvider.getTextures(clientPlayer.getGameProfile()).get(MinecraftProfileTexture.Type.SKIN).getUrl();


            player.sendMessage(Text.of("§7[SkinGrabber] §r").copy().append(Text.of(SKIN_URL).copy().styled((style -> style.withClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, SKIN_URL))))), false);
            return ActionResult.FAIL;
        }
        return ActionResult.PASS;
    }


}
