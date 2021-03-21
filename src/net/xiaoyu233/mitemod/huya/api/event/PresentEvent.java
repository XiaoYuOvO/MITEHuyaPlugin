package net.xiaoyu233.mitemod.huya.api.event;

import com.google.gson.JsonObject;
import net.xiaoyu233.mitemod.huya.api.OnlineUser;
import net.xiaoyu233.mitemod.huya.api.PresentType;

public class PresentEvent extends Event{
    private final PresentType type;
    private final OnlineUser user;
    private final long count;
    private final long roomId;
    //单位:分
    private final int totalPay;
    public PresentEvent(JsonObject data){
        super("getSendItemNotice");
        //粉丝徽章名称
        String badgeName = data.get("badgeName").getAsString();
        //粉丝等级
        int fansLevel = data.get("fansLevel").getAsInt();
        //礼物id
        int giftId = data.get("itemId").getAsInt();
        //贵族等级
        int nobleLevel = data.get("nobleLevel").getAsInt();
        //房间号
        this.roomId = data.get("roomId").getAsLong();
        //送礼连击数
        long sendItemCount = data.get("sendItemCount").getAsLong();
        //送礼者昵称
        String sendNick = data.get("sendNick").getAsString();
        String sendUnion = data.get("unionId").getAsString();
        //用户等级
        int senderLevel = data.get("senderLevel").getAsInt();
        //单位:分
        this.totalPay = data.get("totalPay").getAsInt();
        this.count = sendItemCount;
        this.user = OnlineUser.Builder.of(sendNick,sendUnion).setSenderLevel(senderLevel).setFansLevel(fansLevel).setNobleLevel(nobleLevel).setBadgeName(badgeName).build();
        this.type = PresentType.getById(giftId);
    }

    public PresentType getPresentType() {
        return type;
    }

    public OnlineUser getUser() {
        return user;
    }

    //单位:分
    public int getTotalPay() {
        return totalPay;
    }

    public long getCount() {
        return count;
    }

    public long getRoomId() {
        return roomId;
    }

    public interface Listener extends EventListener<PresentEvent>{
        public abstract void handlePresent(PresentEvent event);

        @Override
        default void handleEvent(PresentEvent event) {
            this.handlePresent(event);
        }
    }
    @Override
    public String toString() {
        return "PresentEvent{" +
                "type=" + type.getCnName() +
                ", user=" + user +
                ", count=" + count +
                ", roomId=" + roomId +
                ", totalPay=" + totalPay +
                '}';
    }
}
