package com.micropole.homemodule.entity;

import java.util.List;

/**
 * @ClassName SearchBean
 * @Description todo
 * @Author HuaiXianZhong
 * @Sign 。。。
 * @Date 2018/10/23 14:47
 * @Copyright Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
public class SearchBean {

    private List<ProjectBean> project;

    public List<ProjectBean> getProject() {
        return project;
    }

    public void setProject(List<ProjectBean> project) {
        this.project = project;
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
