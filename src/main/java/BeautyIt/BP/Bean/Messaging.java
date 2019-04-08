package BeautyIt.BP.Bean;

import java.util.Date;
import java.util.List;

public class Messaging {

    private int MessageID;
    private int UserWebID;
    private String MessageFrom;
    private String Messageen;
    private String MessageRead;
    private String MessageTitle;
    private List<String> messageContainer;
    private Date MessageDate;
    private String MessageImportant;
    private String MessageTo;


    public Messaging(int userWebID, String messageFrom, String messageTitle, String messageen, String messageRead, String messageTo, String messageImportant) {
        UserWebID = userWebID;
        MessageFrom = messageFrom;
        MessageTitle = messageTitle;
        Messageen = messageen;
        MessageRead = messageRead;
        MessageTo = messageTo;
        MessageImportant = messageImportant;

    }

    public Messaging(int messageID, int userWebID, String messageFrom, String messageen, String messageRead, String messageTitle, List<String> messageContainer, Date messageDate, String messageImportant, String messageTo) {
        MessageID = messageID;
        UserWebID = userWebID;
        MessageFrom = messageFrom;
        Messageen = messageen;
        MessageRead = messageRead;
        MessageTitle = messageTitle;
        this.messageContainer = messageContainer;
        MessageDate = messageDate;
        MessageImportant = messageImportant;
        MessageTo = messageTo;
    }

    public Messaging() {
    }

    public int getMessageID() {
        return MessageID;
    }

    public void setMessageID(int messageID) {
        MessageID = messageID;
    }

    public int getUserWebID() {
        return UserWebID;
    }

    public void setUserWebID(int userWebID) {
        UserWebID = userWebID;
    }

    public String getMessageFrom() {
        return MessageFrom;
    }

    public void setMessageFrom(String messageFrom) {
        MessageFrom = messageFrom;
    }

    public String getMessageen() {
        return Messageen;
    }

    public void setMessageen(String messageen) {
        Messageen = messageen;
    }

    public String getMessageRead() {
        return MessageRead;
    }

    public void setMessageRead(String messageRead) {
        MessageRead = messageRead;
    }

    public String getMessageTitle() {
        return MessageTitle;
    }

    public void setMessageTitle(String messageTitle) {
        MessageTitle = messageTitle;
    }

    public List<String> getMessageContainer() {
        return messageContainer;
    }

    public void setMessageContainer(List<String> messageContainer) {
        this.messageContainer = messageContainer;
    }

    public Date getMessageDate() {
        return MessageDate;
    }

    public void setMessageDate(Date messageDate) {
        MessageDate = messageDate;
    }

    public String getMessageImportant() {
        return MessageImportant;
    }

    public void setMessageImportant(String messageImportant) {
        MessageImportant = messageImportant;
    }

    public String getMessageTo() {
        return MessageTo;
    }

    public void setMessageTo(String messageTo) {
        MessageTo = messageTo;
    }
}