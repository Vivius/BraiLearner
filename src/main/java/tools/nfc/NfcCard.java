package tools.nfc;

/**
 * Represents a NFC card read by the reader device
 */
public class NfcCard {

    private String recordType = "Text";
    private String uri = null;
    private String title = null;
    private String action = null;
    private String language = null;
    private String encoding = "UTF-8";
    private String ATQA = null;
    private String SAK = null;
    private String UID = null;

    public NfcCard() {

    }

    public NfcCard(String UID) {
        this.UID = UID;
    }

    public NfcCard(String UID, String title) {
        this.UID = UID;
        this.title = title;
    }

    @Override
    public boolean equals(Object obj) {
        return this.getUID().equals(((NfcCard) obj).getUID());
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
