package com.example.DiningReview.model;

import lombok.Getter;

@Getter
public class AdminReview {
    private Boolean approval;

    public AdminReview(AdminReview adminReview){
        this.approval = adminReview.getApproval();
    }

    public void setApproval(Boolean aproval){
        this.approval = approval;
    }
}