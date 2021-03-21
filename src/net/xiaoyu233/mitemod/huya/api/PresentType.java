package net.xiaoyu233.mitemod.huya.api;

import net.xiaoyu233.fml.util.Utils;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
public enum PresentType {
    HULIANG("虎粮","huliang",4,0.1,100,1000),
    BAO("藏宝图","bao",12,4999.0,5000000,-1),
    HONGXIN("红心","hongxin",49,-1.0,-1,-1),
    BANGBANGTANG("棒棒糖","bangbangtang",50,0.1,100,-1),
    GUZHANG("鼓掌","guzhang",51,0.1,100,-1),
    QIQIU("气球","qiqiu",52,0.1,100,-1),
    QINGSHU("情书","qingshu",53,0.1,100,-1),
    MEMEDA("接待么么哒","memeda",54,0.3,300,-1),
    XIONGBAO("熊抱","xiongbao",55,0.3,300,-1),
    YUEMA("约吗","yuema",56,0.9,900,-1),
    XIANGJIAO("香蕉","xiangjiao",57,0.9,900,-1),
    MEIGUIHUA("玫瑰花","meiguihua",58,4.9,4900,-1),
    QIAOKELI("巧克力","qiaokeli",59,4.9,4900,-1),
    XIANGSHUI("香水","xiangshui",60,9.9,9900,-1),
    KOUHONG("口红","kouhong",61,9.9,9900,-1),
    ZUANJIE1("钻戒1","zuanjie1",62,19.9,19900,-1),
    HAIYANGZHIXIN("海洋之心","haiyangzhixin",63,19.9,19900,-1),
    LUOLI("萝莉","luoli",202,9.9,9900,-1),
    RUANMEI("软妹","ruanmei",203,9.9,9900,-1),
    BAOBEI("宝贝","baobei",204,9.9,9900,-1),
    MEINV("美女","meinv",205,9.9,9900,-1),
    DIAOSI("屌丝","diaosi",206,9.9,9900,-1),
    LAOWANG("老王","laowang",207,9.9,9900,-1),
    ZHENGHUN("征婚","zhenghun",208,9.9,9900,-1),
    DOUBI("逗比","doubi",209,9.9,9900,-1),
    XIAOQINGXIN("小清新","xiaoqingxin",210,9.9,9900,-1),
    ZHONGKOUWEI("重口味","zhongkouwei",211,9.9,9900,-1),
    XIAOXIANROU("小鲜肉","xiaoxianrou",212,9.9,9900,-1),
    GUAISHSHU("怪蜀黍","guaishshu",213,9.9,9900,-1),
    TUHAO("土豪","tuhao",214,19.9,19900,-1),
    BOSS("Boss","Boss",215,19.9,19900,-1),
    ZUANSHINAN("钻石男","zuanshinan",216,19.9,19900,-1),
    BADAOZONGCAI("霸道总裁","badaozongcai",217,19.9,19900,-1),
    NANSHEN("男神","nanshen",218,29.9,29900,-1),
    NVSHEN("女神","nvshen",219,29.9,29900,-1),
    GAOFUSHUAI("高富帅","gaofushuai",220,29.9,29900,-1),
    BAIFUMEI("白富美","baifumei",221,29.9,29900,-1),
    LAOGONG("老公","laogong",222,99.9,99900,-1),
    LAOPO("老婆","laopo",223,99.9,99900,-1),
    LIANGCHEN("良辰","liangchen",301,1.0,1000,-1),
    RITIAN("日天","ritian",302,1.0,1000,-1),
    DIAOSI1("屌丝1","diaosi1",303,1.0,1000,-1),
    LAOWANG1("老王1","laowang1",304,1.0,1000,-1),
    SHOUCAN("手残","shoucan",305,1.0,1000,-1),
    QINTONG("青铜","qintong",306,1.0,1000,-1),
    KANGYA("抗压","kangya",307,1.0,1000,-1),
    TANGYING("躺赢","tangying",308,1.0,1000,-1),
    SHUNFENGLANG("顺风浪","shunfenglang",309,1.0,1000,-1),
    NIFENGTOU("逆风投","nifengtou",310,1.0,1000,-1),
    BEIGUOXIA("背锅侠","beiguoxia",311,1.0,1000,-1),
    QIANGXINGSHUAIGUO("强行甩锅","qiangxingshuaiguo",312,1.0,1000,-1),
    WANGZHE("王者","wangzhe",313,9.9,9900,-1),
    CARRY("凯瑞","carry",314,9.9,9900,-1),
    DATUI("大腿","datui",315,9.9,9900,-1),
    BAOZHASHUCHU("爆炸输出","baozhashuchu",316,9.9,9900,-1),
    GAOFUSHUAI1("高富帅1","gaofushuai1",317,19.9,19900,-1),
    BAIFUMEI1("白富美1","baifumei1",318,19.9,19900,-1),
    TUHAO1("土豪1","tuhao1",319,19.9,19900,-1),
    LAOBAN("老板","laoban",320,19.9,19900,-1),
    LAOGONG1("老公1","laogong1",321,99.0,99000,-1),
    LAOPO1("老婆1","laopo1",322,99.0,99000,-1),
    NIU("牛","niu",20015,0.1,100,-1),
    BAI_DZ("德州膜拜","bai-dz",20016,0.1,100,-1),
    APPLE_DZ("德州小苹果","apple-dz",20017,9.9,9900,-1),
    EGG_DZ("德州茶叶蛋","egg-dz",20018,99.0,99000,-1),
    BLOOD_DZ("德州血瓶","blood-dz",20019,4.9,4900,-1),
    AIXIN_DZ("德州爱心","aixin-dz",20041,-1.0,9900,-1),
    SHENZHIYISHOU_DZ("德州神之一手","shenzhiyishou-dz",20042,-1.0,1900,-1),
    CAKE("生日蛋糕","cake",20102,0.1,100,-1),
    SWORD("彩灯","sword",20114,0.1,100,-1),
    PIAPIAPIA("啪啪啪","piapiapia",20188,0.1,100,-1),
    OLD_DRIVER("超火","old driver",20200,0.1,100,-1),
    THROWBOMB("小心心","throwbomb",20201,0.1,100,-1),
    ANNIVERSARY("周年蛋糕","anniversary",20205,0.1,100,-1),
    GLOWSTICK("荧光棒","glowstick",20206,0.1,100,-1),
    FALALI("法拉利","falali",20218,99.0,99000,-1),
    GODSTICKS("上上签","godsticks",20261,10.0,10000,-1),
    BANKNOTEGUN("钞票枪","banknotegun",20267,300.0,300000,-1),
    SPACESHUTTLE("虎牙一号","spaceshuttle",20269,1000.0,1000000,-1),
    MAGICBOOK("魔法书","magicbook",20271,99.0,99000,-1),
    CHAFINGDISH("火锅","Chafingdish",20273,66.0,66000,-1),
    TROPHY("奖杯","Trophy",20275,6.6,6600,-1),
    NEWBLOOD("血瓶","Newblood",20277,6.6,6600,-1),
    HIGHENERGY("高能预警","Highenergy",20279,88.0,88000,-1),
    ROTTENEGG("鸡蛋","Rottenegg",20281,0.1,100,-1),
    EXPRESS("能量石","express",20293,1.0,1000,-1),
    BOMBSHELL("炸弹","bombshell",20301,300.0,300000,-1),
    TVONLY("白号皇冠","TVonly",20313,66.0,66000,-1),
    SUPERFANSCARD("超粉卡.","superfanscard",20317,6.0,6000,-1),
    PURPLEBOOK("小紫本","PurpleBook",20331,1.0,1000,-1),
    CHENGBAO("奇迹城堡","chengbao",20341,5000.0,5000000,-1),
    SHOUHUZHUANSHULIWU("守护之盾","shouhuzhuanshuliwu",20349,66.0,66000,-1),
    FERRIS_WHEEL("幸福摩天轮","Ferris wheel",20365,1000.0,1000000,-1),
    XINDEHUANGGUAN("皇冠","xindehuangguan",20367,99.0,99000,-1),
    ZHENGAOBAIQIQIU("告白气球","zhengaobaiqiqiu",20369,520.0,520000,-1),
    FENSIPIAONEW("粉丝票","fensipiaonew",20373,0.1,100,-1),
    NAICHA("奶茶","naicha",20377,0.1,100,-1),
    SHUIQIANG("小水枪","shuiqiang",20387,66.0,66000,-1),
    MESSAGELOVE("情书","messagelove",20389,1.0,1000,-1),
    REQIQIUNEW("浪漫热气球","reqiqiunew",20391,5000.0,5000000,-1),
    WUYUN("十万伏特","wuyun",20399,66.0,66000,-1),
    GUIWU("小黑屋","guiwu",20401,1000.0,1000000,-1),
    MAJIANGMOFASHU("专属魔法书","majiangmofashu",20403,99.0,99000,-1),
    DIAHEART("钻心","diaHeart",20409,6.0,6000,-1),
    JIAOYOUZHONGQIUYI("小月饼","jiaoyouzhongqiuyi",20411,0.1,100,-1),
    SSHIHUODONGLIWUYI("LPL加油","sshihuodongliwuyi",20415,0.1,100,-1),
    OCEANDIA("海洋之心","oceanDia",20425,5000.0,5000000,-1),
    XIAOXINGXING("小星星","xiaoxingxing",20427,0.1,100,-1),
    TUHAOXIAOCAIQI("小彩旗","tuhaoxiaocaiqi",20433,66.0,66000,-1),
    JEFFBAJIE("Jeff八戒","jeffbajie",20435,66.0,66000,-1),
    JUNZIZHUANSHU("快上车","junzizhuanshu",20437,5000.0,5000000,-1),
    XUYUANDENG("许愿灯","xuyuandeng",20447,0.1,100,-1),
    GHZHUANSHU("星光卡","GHzhuanshu",20459,6.0,6000,-1),
    CUPID("丘比特之箭","Cupid",20471,0.1,100,-1),
    YBJY("一博加油","YBJY",20475,0.1,100,-1),
    BUJIELE("不接了","bujiele",20477,6.6,6600,-1),
    MAXIAOJI("麻小鸡","maxiaoji",20479,6.6,6600,-1),
    GANDEPIAOLIANG("干的漂亮","gandepiaoliang",20481,0.1,100,-1),
    BLING("Bling~","bling",20485,52.0,52000,-1),
    MVP("MVP","MVP",20487,1.0,1000,-1),
    JIUZHE("就这？","jiuzhe",20489,0.1,100,-1),
    GUANJUNBEI("捧杯吧","guanjunbei",20491,1.0,1000,-1),
    JIAKECHONG("糖豆车","jiakechong",20493,6.6,6600,-1),
    YINHEZHIGUANG("银河之光","yinhezhiguang",20495,1000.0,1000000,-1),
    PANEL_214("告白灯牌","214灯牌",20501,66.0,66000,-1),
    MAGIC_RING("魔法指环","MagicRing",20351,0.1,100,-1);
    private static final Map<Integer, PresentType> idToGiftType = Utils.make(new HashMap<>(),(map) ->{
        for (PresentType value : PresentType.values()) {
            map.put(value.getGiftId(),value);
        }
    });
    private final String cnName;
    private final String enName;
    private final int giftId;
    private final double prizeYb;
    private final int prizeGoldbean;
    private final int prizeSilverbean;
    PresentType(String cnName, String enName, int giftId, double prizeYb, int prizeGoldbean, int prizeSilverbean){
        this.cnName = cnName;
        this.enName = enName;
        this.giftId = giftId;
        this.prizeYb = prizeYb;
        this.prizeGoldbean = prizeGoldbean;
        this.prizeSilverbean = prizeSilverbean;
    }

    public static PresentType getById(int id){
        return idToGiftType.get(id);
    }

    public String getCnName() {
        return cnName;
    }

    public String getEnName() {
        return enName;
    }

    public int getGiftId() {
        return giftId;
    }

    public double getPrizeYb() {
        return prizeYb;
    }

    public int getPrizeGoldbean() {
        return prizeGoldbean;
    }

    public int getPrizeSilverbean() {
        return prizeSilverbean;
    }
}
