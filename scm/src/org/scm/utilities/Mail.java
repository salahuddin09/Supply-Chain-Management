package org.scm.utilities;

public class Mail {
	private String userName="scsmanager13";
	private String password="scs12345";
	private String from="scsmanager13@gmail.com";
	private String recipients="salahuddincse09@gmail.com";
	private String subject="Testing Subject";
	private String body;
        private String fileAttachment = "F:/finishedproduct.pdf";
        
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getRecipients() {
		return recipients;
	}
	public void setRecipients(String recipients) {
		this.recipients = recipients;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}

    /**
     * @return the fileAttachment
     */
    public String getFileAttachment() {
        return fileAttachment;
    }

    /**
     * @param fileAttachment the fileAttachment to set
     */
    public void setFileAttachment(String fileAttachment) {
        this.fileAttachment = fileAttachment;
    }
	
}
