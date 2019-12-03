package com.bawei.mwngxuan.mabel.bean;

import java.util.List;

/**
 * @包名 com.bawei.mwngxuan
 * @mengxuan
 * @日期2019/12/3
 * @日期2019 : 12:03
 * @项目名MwngXuan2019123
 * @类名Mall
 **/
public class Mall {

    /**
     * code : 200
     * shopGridData : [{"title":"honor20","price":"￥2099","imageurl":"http://blog.zhaoliang5156.cn/api/images/honor20.jpg"},{"title":"mate30","price":"￥6899","imageurl":"http://blog.zhaoliang5156.cn/api/images/mate30.jpg"},{"title":"oppoReno2","price":"￥1680","imageurl":"http://blog.zhaoliang5156.cn/api/images/oppoReno2.jpg"},{"title":"vivonex3","price":"￥1580","imageurl":"http://blog.zhaoliang5156.cn/api/images/vivonex3.jpg"}]
     */

    private String code;
    private List<ShopGridDataBean> shopGridData;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<ShopGridDataBean> getShopGridData() {
        return shopGridData;
    }

    public void setShopGridData(List<ShopGridDataBean> shopGridData) {
        this.shopGridData = shopGridData;
    }

    public static class ShopGridDataBean {
        /**
         * title : honor20
         * price : ￥2099
         * imageurl : http://blog.zhaoliang5156.cn/api/images/honor20.jpg
         */

        private String title;
        private String price;
        private String imageurl;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getImageurl() {
            return imageurl;
        }

        public void setImageurl(String imageurl) {
            this.imageurl = imageurl;
        }
    }
}
