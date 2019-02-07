package model;

/**
 * Represents all the data given by the explorenfc software
 */
public class NfcCard {

    private String recordType;
    private String uri;
    private String title;
    private String action;
    private String language;
    private String encoding;
    private String ATQA;
    private String SAK;
    private String UID;

    public NfcCard() {

    }

    public NfcCard(String recordType, String uri, String title, String action, String language, String encoding, String ATQA, String SAK, String UID) {
        this.recordType = recordType;
        this.uri = uri;
        this.title = title;
        this.action = action;
        this.language = language;
        this.encoding = encoding;
        this.ATQA = ATQA;
        this.SAK = SAK;
        this.UID = UID;
    }

    public String getRecordType() {
        return recordType;
    }

    public void setRecordType(String recordType) {
        this.recordType = recordType;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getEncoding() {
        return encoding;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    public String getATQA() {
        return ATQA;
    }

    public void setATQA(String ATQA) {
        this.ATQA = ATQA;
    }

    public String getSAK() {
        return SAK;
    }

    public void setSAK(String SAK) {
        this.SAK = SAK;
    }

    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }

    @Override
    public String toString() {
        return "NfcCard{" +
                "recordType='" + recordType + '\'' +
                ", uri='" + uri + '\'' +
                ", title='" + title + '\'' +
                ", action='" + action + '\'' +
                ", language='" + language + '\'' +
                ", encoding='" + encoding + '\'' +
                ", ATQA='" + ATQA + '\'' +
                ", SAK='" + SAK + '\'' +
                ", UID='" + UID + '\'' +
                '}';
    }
}
