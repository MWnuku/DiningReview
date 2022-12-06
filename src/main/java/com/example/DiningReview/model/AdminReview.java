package com.example.DiningReview.model;

public class AdminReview {
    private Boolean approval;

    public AdminReview(AdminReview adminReview){
        this.approval = adminReview.getApproval();
    }

    public Boolean getApproval(){return this.approval; }

    public void setApproval(Boolean aproval){this.approval = approval; }
}