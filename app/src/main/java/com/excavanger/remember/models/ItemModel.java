package com.excavanger.remember.models;

import java.util.UUID;

public class ItemModel {
    private UUID itemId;
    private String backgroundColor;
    private String title;

    public ItemModel(UUID itemId, String backgroundColor, String title) {
        this.itemId = itemId;
        this.backgroundColor = backgroundColor;
        this.title = title;
    }

    public UUID getItemId() {
        return itemId;
    }

    public void setItemId(UUID itemId) {
        this.itemId = itemId;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
