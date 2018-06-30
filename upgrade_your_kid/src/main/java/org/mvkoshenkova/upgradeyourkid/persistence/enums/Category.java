package org.mvkoshenkova.upgradeyourkid.persistence.enums;

public enum Category {

    FROM_0_TO_3_MONTH(0, "От 0 до 3 месяцев", "Сейчас ваш малыш совсем кроха, но вам уже хочется помочь ему в познании этого мира, этот раздел скорее будет про налаживание вашего контакта с малышом"),
    FROM_3_TO_6_MONTH(1, "От 3 до 6 месяцев", "Кроха начинает уже активнее познавать мир - переворачивается, берет предметы в руки и начинает с ними знакомиться, готовится к ползанию"),
    FROM_6_TO_9_MONTH(2, "От 6 до 9 месяцев", "Физическая активность возрастает, вот малыш уже ползает, сидит и встает"),
    FROM_9_TO_12_MONTH(3, "От 9 до 12 месяцев", ""),
    FROM_12_TO_18_MONTH(4, "От года до полутора", ""),
    FROM_18_TO_24_MONTH(5, "От полутора до двух лет", "");

    /**
     * Created by Mariya Koshenkova on 18.03.18.
     */
    Category(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public int id;
    public String title;
    public String description;
}
