package com.zxwl.chinahappy.Bean;

import java.util.List;

/**
 * Created by sks on 2018/4/12.
 */

public class TigerdataBean {

    /**
     * total : 1
     * datas : [{"id":"9","countdown":"12","xapple":"0","xorange":"0","xcoconut":"0","xwatermelons":"0","xstar":"0","xqq":"0","xbar":"0","xalarm":"0"}]
     */

    private int total;
    private List<DatasBean> datas;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<DatasBean> getDatas() {
        return datas;
    }

    public void setDatas(List<DatasBean> datas) {
        this.datas = datas;
    }

    public static class DatasBean {
        /**
         * id : 9
         * countdown : 12
         * xapple : 0
         * xorange : 0
         * xcoconut : 0
         * xwatermelons : 0
         * xstar : 0
         * xqq : 0
         * xbar : 0
         * xalarm : 0
         */

        private String id;
        private String countdown;
        private String xapple;
        private String xorange;
        private String xcoconut;
        private String xwatermelons;
        private String xstar;
        private String xqq;
        private String xbar;
        private String xalarm;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCountdown() {
            return countdown;
        }

        public void setCountdown(String countdown) {
            this.countdown = countdown;
        }

        public String getXapple() {
            return xapple;
        }

        public void setXapple(String xapple) {
            this.xapple = xapple;
        }

        public String getXorange() {
            return xorange;
        }

        public void setXorange(String xorange) {
            this.xorange = xorange;
        }

        public String getXcoconut() {
            return xcoconut;
        }

        public void setXcoconut(String xcoconut) {
            this.xcoconut = xcoconut;
        }

        public String getXwatermelons() {
            return xwatermelons;
        }

        public void setXwatermelons(String xwatermelons) {
            this.xwatermelons = xwatermelons;
        }

        public String getXstar() {
            return xstar;
        }

        public void setXstar(String xstar) {
            this.xstar = xstar;
        }

        public String getXqq() {
            return xqq;
        }

        public void setXqq(String xqq) {
            this.xqq = xqq;
        }

        public String getXbar() {
            return xbar;
        }

        public void setXbar(String xbar) {
            this.xbar = xbar;
        }

        public String getXalarm() {
            return xalarm;
        }

        public void setXalarm(String xalarm) {
            this.xalarm = xalarm;
        }
    }
}
