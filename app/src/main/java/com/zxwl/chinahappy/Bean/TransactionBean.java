package com.zxwl.chinahappy.Bean;

import java.util.List;

/**
 * Created by sks on 2018/4/20.
 */

public class TransactionBean {

    /**
     * total : 10
     * datas : [{"phone":"18210909941","type":"2","number":null,"timesign":"2018-04-12 12:01:26","money":"202","integral":"8000"},{"phone":"18210909941","type":"2","number":null,"timesign":"2018-04-12 12:01:51","money":"210","integral":"0"},{"phone":"18210909941","type":"1","number":null,"timesign":"2018-04-12 12:02:24","money":"200","integral":"10000"},{"phone":"18210909941","type":"1","number":null,"timesign":"2018-04-12 12:02:27","money":"100","integral":"110000"},{"phone":"18210909941","type":"1","number":null,"timesign":"2018-04-20 11:23:31","money":"0","integral":"109040"},{"phone":"18210909941","type":"1","number":null,"timesign":"2018-04-20 11:26:31","money":"0","integral":"110940"},{"phone":"18210909941","type":"1","number":null,"timesign":"2018-04-20 11:27:31","money":"0","integral":"119440"},{"phone":"18210909941","type":"1","number":null,"timesign":"2018-04-20 11:46:39","money":"99","integral":"120440"},{"phone":"18210909941","type":"1","number":null,"timesign":"2018-04-20 11:47:36","money":"98","integral":"121440"},{"phone":"18210909941","type":"1","number":null,"timesign":"2018-04-20 11:50:19","money":"97","integral":"122440"}]
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
         * phone : 18210909941
         * type : 2
         * number : null
         * timesign : 2018-04-12 12:01:26
         * money : 202
         * integral : 8000
         */

        private String phone;
        private String type;
        private Object number;
        private String timesign;
        private String money;
        private String integral;

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Object getNumber() {
            return number;
        }

        public void setNumber(Object number) {
            this.number = number;
        }

        public String getTimesign() {
            return timesign;
        }

        public void setTimesign(String timesign) {
            this.timesign = timesign;
        }

        public String getMoney() {
            return money;
        }

        public void setMoney(String money) {
            this.money = money;
        }

        public String getIntegral() {
            return integral;
        }

        public void setIntegral(String integral) {
            this.integral = integral;
        }
    }
}
