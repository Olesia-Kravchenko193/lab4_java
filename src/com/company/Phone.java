package com.company;

import java.util.Comparator;
public class Phone {

    private String phoneName;
    private String slug;
    private int hits;
    private String detail;

    /**
     * No args constructor for use in serialization
     *
     */
    public Phone() {
    }

    /**
     *
     * @param hits
     * @param detail
     * @param phoneName
     * @param slug
     */
    public Phone(String phoneName, String slug, int hits, String detail) {
        super();
        this.phoneName = phoneName;
        this.slug = slug;
        this.hits = hits;
        this.detail = detail;
    }


    public String getPhoneName() {
        return phoneName;
    }

    public void setPhoneName(String phoneName) {
        this.phoneName = phoneName;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Phone.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("phoneName");
        sb.append('=');
        sb.append(((this.phoneName == null)?"<null>":this.phoneName));
        sb.append(',');
        sb.append("slug");
        sb.append('=');
        sb.append(((this.slug == null)?"<null>":this.slug));
        sb.append(',');
        sb.append("hits");
        sb.append('=');
        sb.append(this.hits);
        sb.append(',');
        sb.append("detail");
        sb.append('=');
        sb.append(((this.detail == null)?"<null>":this.detail));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    public static Comparator<Phone> byNameAsc = Comparator.comparing(o -> o.phoneName);
    public static Comparator<Phone> byNameDesc = (o1, o2) -> o2.phoneName.compareTo(o1.phoneName);
    public static Comparator<Phone> byValueAsc = (o1, o2) -> o1.hits > o2.hits ? 1 : o1.hits < o2.hits ? -1 : 0;
    public static Comparator<Phone> byValueDesc = (o1, o2) -> o1.hits < o2.hits ? 1 : o1.hits > o2.hits ? -1 : 0;

}