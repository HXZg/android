package com.micropole.homeword.entity;

/**
 * @ClassName ShareHotlBean
 * @Description todo
 * @Author HuaiXianZhong
 * @Sign 。。。
 * @Date 2018/10/26 16:15
 * @Copyright Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
public class ShareHotlBean {


    /**
     * share : {"share_title":"泰丰牧马湖","share_content":"大亚湾大道与龙海二路交汇处","share_img":"/uploads/20181019/c5dd77ec51a3eb0f488bade2e19fac41.jpg"}
     */

    private ShareBean share;

    public ShareBean getShare() {
        return share;
    }

    public void setShare(ShareBean share) {
        this.share = share;
    }

    public static class ShareBean {
        /**
         * share_title : 泰丰牧马湖
         * share_content : 大亚湾大道与龙海二路交汇处
         * share_img : /uploads/20181019/c5dd77ec51a3eb0f488bade2e19fac41.jpg
         */

        private String share_title;
        private String share_content;
        private String share_img;

        public String getShare_title() {
            return share_title;
        }

        public void setShare_title(String share_title) {
            this.share_title = share_title;
        }

        public String getShare_content() {
            return share_content;
        }

        public void setShare_content(String share_content) {
            this.share_content = share_content;
        }

        public String getShare_img() {
            return share_img;
        }

        public void setShare_img(String share_img) {
            this.share_img = share_img;
        }
    }
}
