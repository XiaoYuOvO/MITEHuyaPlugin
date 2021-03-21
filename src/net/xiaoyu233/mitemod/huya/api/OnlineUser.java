package net.xiaoyu233.mitemod.huya.api;

public class OnlineUser extends HuyaUser{
    private final int fansLevel;
    private final NobleType nobleLevel;
    private final int senderLevel;
    private final String badgeName;
    public OnlineUser(String nickName, String uniqueID, int fansLevel, int nobleLevel, int senderLevel, String badgeName) {
        super(nickName, uniqueID);
        this.fansLevel = fansLevel;
        this.nobleLevel = NobleType.getFromLevel(nobleLevel);
        this.senderLevel = senderLevel;
        this.badgeName = badgeName;
    }

    public int getFansLevel() {
        return fansLevel;
    }

    public NobleType getNobleLevel() {
        return nobleLevel;
    }

    public int getSenderLevel() {
        return senderLevel;
    }

    public String getBadgeName() {
        return badgeName;
    }

    public static class Builder{
        private int fansLevel = -1;
        private int nobleLevel = -1;
        private int senderLevel = -1;
        private String badgeName = "";
        private final String nickName;
        private final String unionId;

        private Builder(String nickName, String unionId) {
            this.nickName = nickName;
            this.unionId = unionId;
        }

        public static Builder of(String nickName, String unionId){
            return new Builder(nickName, unionId);
        }

        public Builder setBadgeName(String badgeName) {
            this.badgeName = badgeName;
            return this;
        }

        public Builder setFansLevel(int fansLevel) {
            this.fansLevel = fansLevel;
            return this;
        }

        public Builder setNobleLevel(int nobleLevel) {
            this.nobleLevel = nobleLevel;
            return this;
        }

        public Builder setSenderLevel(int senderLevel) {
            this.senderLevel = senderLevel;
            return this;
        }

        public OnlineUser build(){
            return new OnlineUser(this.nickName,this.unionId,this.fansLevel,this.nobleLevel,this.senderLevel,this.badgeName);
        }
    }

    @Override
    public String toString() {
        return "OnlineUser{" +
                "userName="+ this.getNickName() +
                " fansLevel=" + fansLevel +
                ", nobleLevel=" + nobleLevel +
                ", senderLevel=" + senderLevel +
                '}';
    }
}
