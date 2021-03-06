package riskyken.armourersWorkshop.common.network.messages.server;

import com.mojang.authlib.GameProfile;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTUtil;
import riskyken.armourersWorkshop.common.GameProfileCache;

public class MessageServerGameProfile  implements IMessage, IMessageHandler<MessageServerGameProfile, IMessage> {

    private GameProfile gameProfile;
    
    public MessageServerGameProfile() {}
    
    public MessageServerGameProfile(GameProfile gameProfile) {
        this.gameProfile = gameProfile;
    }
    
    @Override
    public void toBytes(ByteBuf buf) {
        NBTTagCompound profileTag = new NBTTagCompound();
        NBTUtil.func_152460_a(profileTag, this.gameProfile);
        ByteBufUtils.writeTag(buf, profileTag);
    }
    
    @Override
    public void fromBytes(ByteBuf buf) {
        NBTTagCompound profileTag = ByteBufUtils.readTag(buf);
        gameProfile = NBTUtil.func_152459_a(profileTag);
    }

    @Override
    public IMessage onMessage(MessageServerGameProfile message, MessageContext ctx) {
        GameProfileCache.onServerSentProfile(message.gameProfile);
        return null;
    }
}
