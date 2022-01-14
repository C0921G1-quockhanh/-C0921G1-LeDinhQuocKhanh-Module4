package qk.store_email.model;

public class Email {
    protected String[] languages;
    protected Integer[] pageSize;
    protected boolean spamFilter;
    protected String signature;

    public Email() {
    }

    public Email(String[] languages, Integer[] pageSize, boolean spamFilter, String signature) {
        this.languages = languages;
        this.pageSize = pageSize;
        this.spamFilter = spamFilter;
        this.signature = signature;
    }

    public String[] getLanguages() {
        return languages;
    }

    public void setLanguages(String[] languages) {
        this.languages = languages;
    }

    public Integer[] getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer[] pageSize) {
        this.pageSize = pageSize;
    }

    public boolean isSpamFilter() {
        return spamFilter;
    }

    public void setSpamFilter(boolean spamFilter) {
        this.spamFilter = spamFilter;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
