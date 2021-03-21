package net.xiaoyu233.mitemod.huya.api;

import java.util.Objects;

public abstract class HuyaUser {
    private final String nickName;
    private final String uniqueID;

    public HuyaUser(String nickName, String uniqueID) {
        this.nickName = nickName;
        this.uniqueID = uniqueID;
    }

    public String getNickName() {
        return nickName;
    }

    public String getUniqueID() {
        return uniqueID;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HuyaUser huyaUser = (HuyaUser) o;
        return uniqueID.equals(huyaUser.uniqueID);
    }

    @Override
    public final int hashCode() {
        return Objects.hash(uniqueID);
    }
}
