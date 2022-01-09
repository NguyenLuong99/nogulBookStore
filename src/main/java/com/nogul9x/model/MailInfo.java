package com.nogul9x.model;

public class MailInfo {
		String from;
		String to;
		String[] cc;
		String[] bcc;
		String subject;
		String body;
		String[] attachment;
		public MailInfo(String to, String subject, String body) {
			this.from = "NogulNA <1buinguyenluong1999@gmail.com>";
			this.to = to;
			this.subject = subject;
			this.body = body;
		}
		public String getFrom() {
			return from;
		}
		public void setFrom(String from) {
			this.from = from;
		}
		public String getTo() {
			return to;
		}
		public void setTo(String to) {
			this.to = to;
		}
		public String[] getCc() {
			return cc;
		}
		public void setCc(String[] cc) {
			this.cc = cc;
		}
		public String[] getBcc() {
			return bcc;
		}
		public void setBcc(String[] bcc) {
			this.bcc = bcc;
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
		public String[] getAttachment() {
			return attachment;
		}
		public void setAttachment(String[] attachment) {
			this.attachment = attachment;
		}
		
		
}
