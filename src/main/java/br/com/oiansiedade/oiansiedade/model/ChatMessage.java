package br.com.oiansiedade.oiansiedade.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ChatMessage {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
    private MessageType type;
    private String content;
    @ManyToOne
    private User sender;
    @ManyToOne
    private User recipient;

    public static enum MessageType { CHAT, JOIN, LEAVE }
    
    public ChatMessage() {}

    public ChatMessage(MessageType type, String content, User sender) {
		this.type = type;
		this.content = content;
		this.sender = sender;
	}

	public MessageType getType() {
        return type;
    }

    public String getContent() {
        return content;
    }
    
    public User getRecipient() {
		return recipient;
	}
    
    public void setRecipient(User user) {
		this.recipient = user;
	}
    
    public User getSender() {
		return sender;
	}
    
    public void setSender(User sender) {
		this.sender = sender;
	}


}
