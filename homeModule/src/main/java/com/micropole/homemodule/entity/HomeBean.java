package com.micropole.homemodule.entity;

import java.util.List;

/**
 * @ClassName HomeBean
 * @Description 首页
 * @Author HuaiXianZhong
 * @Sign 。。。
 * @Date 2018/10/22 17:13
 * @Copyright Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
public class HomeBean {

    /**
     * adve : [{"ad_id":"4","ad_img":"/uploads/20180719/d75765ece888f6238e4886c6e8ce26d3.png","pro_id":"5","ad_sort":"144","ad_url":"","ad_title":"(广州) 中国移动通信集团广东有限公司: 中国移动南方基地二期项目","ad_type":"","ad_st":"1"},{"ad_id":"1","ad_img":"/uploads/20180815/f41595550f6ed80fa13af65770b837ce.png","pro_id":"553","ad_sort":"4","ad_url":"1","ad_title":"广州二运集团有限公司: 西洲中公交立体充电桩停车场项目","ad_type":"","ad_st":"1"},{"ad_id":"3","ad_img":"/uploads/20180719/0cd75cdb52739bfe2f502c0169816bf4.jpg","pro_id":"4","ad_sort":"1","ad_url":"","ad_title":"广东广州市荔新公路广本隧道工程","ad_type":"","ad_st":"1"},{"ad_id":"2","ad_img":"/uploads/20180719/e6cf7329d5ee760f1660306f37f09946.jpg","pro_id":"3","ad_sort":"","ad_url":"http://baidu.com","ad_title":"广州市荔湾区建设项目管理中心: 西湾路旧城改造安置房建设项目 (南片区)","ad_type":"","ad_st":"1"}]
     * project : [{"distance":"113","h_id":"2","h_imgs":"/uploads/20181018/530026712cff6f9bb7143edea881d355.jpg","h_title":"【DUDUSA·画】春熙路/太古里/兰桂坊 双地铁口 阁楼 超大露台画室艺术风","h_address":"广州珠江新城富力盈凯","room_hall":"一房一厅","deposit_free":"1","h_price":"100","h_recommend":"1","comment_score":"","area_name":"非洲建筑风格"},{"distance":"10675","h_id":"3","h_imgs":"/uploads/20181018/530026712cff6f9bb7143edea881d355.jpg","h_title":"｢3# · 四间 · 建筑师的家｣紧邻武侯祠锦里&紧邻地铁口&体院&民族大学","h_address":"广州番禺大石","room_hall":"一房一厅","deposit_free":"1","h_price":"1200","h_recommend":"1","comment_score":"","area_name":"非洲建筑风格"},{"distance":"125934","h_id":"6","h_imgs":"/uploads/20181019/c5dd77ec51a3eb0f488bade2e19fac41.jpg","h_title":"泰丰牧马湖","h_address":"大亚湾大道与龙海二路交汇处","room_hall":"一房一厅","deposit_free":"1","h_price":"100","h_recommend":"1","comment_score":"5","area_name":"非洲建筑风格"}]
     * people_number : 10
     */

    private String people_number;
    private List<AdveBean> adve;
    private List<ProjectBean> project;

    public String getPeople_number() {
        return people_number;
    }

    public void setPeople_number(String people_number) {
        this.people_number = people_number;
    }

    public List<AdveBean> getAdve() {
        return adve;
    }

    public void setAdve(List<AdveBean> adve) {
        this.adve = adve;
    }

    public List<ProjectBean> getProject() {
        return project;
    }

    public void setProject(List<ProjectBean> project) {
        this.project = project;
    }

    public static class AdveBean {
        /**
         * ad_id : 4
         * ad_img : /uploads/20180719/d75765ece888f6238e4886c6e8ce26d3.png
         * pro_id : 5
         * ad_sort : 144
         * ad_url :
         * ad_title : (广州) 中国移动通信集团广东有限公司: 中国移动南方基地二期项目
         * ad_type :
         * ad_st : 1
         */

        private String ad_id;
        private String ad_img;
        private String pro_id;
        private String ad_sort;
        private String ad_url;
        private String ad_title;
        private String ad_type;
        private String ad_st;

        public String getAd_id() {
            return ad_id;
        }

        public void setAd_id(String ad_id) {
            this.ad_id = ad_id;
        }

        public String getAd_img() {
            return ad_img;
        }

        public void setAd_img(String ad_img) {
            this.ad_img = ad_img;
        }

        public String getPro_id() {
            return pro_id;
        }

        public void setPro_id(String pro_id) {
            this.pro_id = pro_id;
        }

        public String getAd_sort() {
            return ad_sort;
        }

        public void setAd_sort(String ad_sort) {
            this.ad_sort = ad_sort;
        }

        public String getAd_url() {
            return ad_url;
        }

        public void setAd_url(String ad_url) {
            this.ad_url = ad_url;
        }

        public String getAd_title() {
            return ad_title;
        }

        public void setAd_title(String ad_title) {
            this.ad_title = ad_title;
        }

        public String getAd_type() {
            return ad_type;
        }

        public void setAd_type(String ad_type) {
            this.ad_type = ad_type;
        }

        public String getAd_st() {
            return ad_st;
        }

        public void setAd_st(String ad_st) {
            this.ad_st = ad_st;
        }
    }

    public static class ProjectBean {
        /**
         * distance : 113
         * h_id : 2
         * h_imgs : /uploads/20181018/530026712cff6f9bb7143edea881d355.jpg
         * h_title : 【DUDUSA·画】春熙路/太古里/兰桂坊 双地铁口 阁楼 超大露台画室艺术风
         * h_address : 广州珠江新城富力盈凯
         * room_hall : 一房一厅
         * deposit_free : 1
         * h_price : 100
         * h_recommend : 1
         * comment_score :
         * area_name : 非洲建筑风格
         */

        private String distance;
        private String h_id;
        private String h_imgs;
        private String h_title;
        private String h_address;
        private String room_hall;
        private String deposit_free;
        private String h_price;
        private String h_recommend;
        private String comment_score;
        private String area_name;

        public String getDistance() {
            return distance;
        }

        public void setDistance(String distance) {
            this.distance = distance;
        }

        public String getH_id() {
            return h_id;
        }

        public void setH_id(String h_id) {
            this.h_id = h_id;
        }

        public String getH_imgs() {
            return h_imgs;
        }

        public void setH_imgs(String h_imgs) {
            this.h_imgs = h_imgs;
        }

        public String getH_title() {
            return h_title;
        }

        public void setH_title(String h_title) {
            this.h_title = h_title;
        }

        public String getH_address() {
            return h_address;
        }

        public void setH_address(String h_address) {
            this.h_address = h_address;
        }

        public String getRoom_hall() {
            return room_hall;
        }

        public void setRoom_hall(String room_hall) {
            this.room_hall = room_hall;
        }

        public String getDeposit_free() {
            return deposit_free;
        }

        public void setDeposit_free(String deposit_free) {
            this.deposit_free = deposit_free;
        }

        public String getH_price() {
            return h_price;
        }

        public void setH_price(String h_price) {
            this.h_price = h_price;
        }

        public String getH_recommend() {
            return h_recommend;
        }

        public void setH_recommend(String h_recommend) {
            this.h_recommend = h_recommend;
        }

        public String getComment_score() {
            return comment_score;
        }

        public void setComment_score(String comment_score) {
            this.comment_score = comment_score;
        }

        public String getArea_name() {
            return area_name;
        }

        public void setArea_name(String area_name) {
            this.area_name = area_name;
        }
    }
}
