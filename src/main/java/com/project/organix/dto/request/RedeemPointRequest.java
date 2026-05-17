package com.project.organix.dto.request;

public class RedeemPointRequest {
    private Long userId;
    private Integer poinDitukar;
    private String keteranganItem;

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public Integer getPoinDitukar() { return poinDitukar; }
    public void setPoinDitukar(Integer poinDitukar) { this.poinDitukar = poinDitukar; }

    public String getKeteranganItem() { return keteranganItem; }
    public void setKeteranganItem(String keteranganItem) { this.keteranganItem = keteranganItem; }
}