package net.xiaoyu233.mitemod.huya.managment;

import com.google.gson.JsonObject;
import net.xiaoyu233.mitemod.huya.api.HuyaUser;
import net.xiaoyu233.mitemod.huya.api.SimpleUser;

import java.io.File;

public class PointList extends UserList<HuyaUser, PointList.PointListEntry>{

    public PointList(File saveFile) {
        super(saveFile);
    }

    @Override
    protected UserListEntry<HuyaUser> createEntry(JsonObject entryData) {
        return new PointListEntry(entryData);
    }

    public static class PointListEntry extends UserListEntry<HuyaUser>{
        private int point;
        public PointListEntry(HuyaUser user) {
            super(user);
        }

        public void setPoint(int point) {
            this.point = point;
        }

        public int getPoint() {
            return point;
        }

        public PointListEntry(JsonObject data){
            super(SimpleUser.fromJson(data));
        }

        @Override
        protected void onSerialization(JsonObject data) {
            if (PointListEntry.this.getValue() != null){
                data.addProperty("uuid", this.getValue().getUniqueID() == null ? "" : this.getValue().getUniqueID());
                data.addProperty("name", this.getValue().getNickName());
                data.addProperty("point",this.point);
            }
        }
    }
}
