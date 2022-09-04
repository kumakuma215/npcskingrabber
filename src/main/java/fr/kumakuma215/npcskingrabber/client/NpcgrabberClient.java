package fr.kumakuma215.npcskingrabber.client;

import fr.kumakuma215.npcskingrabber.client.listeners.AttackEntityListener;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;

@Environment(net.fabricmc.api.EnvType.CLIENT)
public class NpcgrabberClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        AttackEntityCallback.EVENT.register(new AttackEntityListener());
    }
}
