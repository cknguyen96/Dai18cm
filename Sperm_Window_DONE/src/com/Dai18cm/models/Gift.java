package com.Dai18cm.models;

import com.Dai18cm.controllers.GiftType;

/**
 * Created by nhoxkem96 on 14/05/2016.
 */
public class Gift extends GameObject {
    public static final int WIDTH_DEFAULT = 30;
    public static final int HEIGHT_DEFAULT = 30;
    private GiftType giftType = GiftType.NONE;
    public Gift(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public GiftType getGiftType() {
        return giftType;
    }
}
