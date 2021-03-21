package net.xiaoyu233.mitemod.huya.api.event;

import com.google.gson.JsonObject;
import net.xiaoyu233.mitemod.huya.api.OnlineUser;

import java.util.function.Function;

public class MessageEvent extends Event{
    private final String content;
    private final OnlineUser user;
    protected MessageEvent(JsonObject json) {
        super("getMessageNotice");
        OnlineUser.Builder user = OnlineUser.Builder.of(json.get("sendNick").getAsString(), json.get("unionId")
                .getAsString()).
                setSenderLevel(json.get("senderLevel").getAsInt()).
                setNobleLevel(json.get("nobleLevel").getAsInt()).
                setFansLevel(json.get("fansLevel").getAsInt());
        if (json.get("showMode").getAsInt() == 0) {
            this.user = user.setBadgeName(json.get("badgeName").getAsString()).build();
        }else {
            this.user = user.build();
        }
        this.content = json.get("content").getAsString();
    }

    public OnlineUser getUser() {
        return user;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "MessageEvent:{ [" + this.user.getBadgeName() + "-"+ user.getFansLevel() + "]("+ this.user.getNobleLevel().getCnName() + ")" + this.user.getNickName() +":" + this.content +" }";
    }

    public interface Listener extends EventListener<MessageEvent>{}
}
