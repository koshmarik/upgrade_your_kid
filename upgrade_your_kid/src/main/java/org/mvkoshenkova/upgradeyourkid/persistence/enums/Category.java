package org.mvkoshenkova.upgradeyourkid.persistence.enums;

public enum Category {

    FROM_0_TO_3_MONTH(0, ""),
    FROM_3_TO_6_MONTH(1, ""),
    FROM_6_TO_9_MONTH(2, ""),
    FROM_9_TO_12_MONTH(3, ""),
    FROM_12_TO_18_MONTH(4, ""),
    FROM_18_TO_24_MONTH(5, "");

    /**
     * Created by Mariya Koshenkova on 18.03.18.
     */
    Category(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public int id;
    public String title;
}
