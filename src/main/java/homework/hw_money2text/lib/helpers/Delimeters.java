package homework.hw_money2text.lib.helpers;

public enum Delimeters {
    hundreds,
    thousand,
    millions,
    billions;


    public static Delimeters getById(Long id) {
        for(Delimeters e : values()) {
            if(e.ordinal() == id) return e;
        }
        return null;
    }
}
