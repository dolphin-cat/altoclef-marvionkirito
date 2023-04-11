package adris.altoclef.mixins;

import adris.altoclef.eventbus.EventBus;
import adris.altoclef.eventbus.events.ChatMessageEvent;
import net.minecraft.client.gui.hud.ChatHud;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import net.minecraft.text.Text;
import net.minecraft.client.gui.hud.MessageIndicator;
import adris.altoclef.AltoClef;


@Mixin(ChatHud.class)
public final class ChatReadMixin {

    @Inject(
            method = "logChatMessage",
            at = @At("HEAD")
    )
    private void logChatMessage(Text message, MessageIndicator indicator, CallbackInfo ci) {
        ChatMessageEvent evt = new ChatMessageEvent(message);
        EventBus.publish(evt);
    }
}