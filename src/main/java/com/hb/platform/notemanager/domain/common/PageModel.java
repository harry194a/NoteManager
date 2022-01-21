package com.hb.platform.notemanager.domain.common;

import java.util.List;

public class PageModel {

    List items;
    Long totalCount;

    public PageModel(List items, Long totalCount) {
        this.items = items;
        this.totalCount = totalCount;
    }

    public List getItems() {
        return items;
    }

    public void setItems(List items) {
        this.items = items;
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }
}
