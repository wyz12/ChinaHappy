package com.zxwl.chinahappy.Bean;

import java.util.List;

/**
 * Created by sks on 2018/4/13.
 */

public class TigerUserYzBean {

    /**
     * total : 10
     * datas : [{"id":"184","Answer":"0"},{"id":"183","Answer":"6"},{"id":"182","Answer":"4"},{"id":"181","Answer":"3"},{"id":"180","Answer":"5"},{"id":"179","Answer":"7"},{"id":"178","Answer":"7"},{"id":"177","Answer":"4"},{"id":"176","Answer":"1"},{"id":"175","Answer":"12"}]
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
         * id : 184
         * Answer : 0
         */

        private String id;
        private String Answer;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getAnswer() {
            return Answer;
        }

        public void setAnswer(String Answer) {
            this.Answer = Answer;
        }
    }
}
