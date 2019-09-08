package br.com.oiansiedade.oiansiedade.model;

import javax.persistence.CascadeType;
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
    
    @ManyToOne(cascade = CascadeType.ALL)
    private User user;

    public static enum MessageType { CHAT, JOIN, LEAVE }
    
    public ChatMessage() {}

    public ChatMessage(MessageType type, String content, User user) {
		this.type = type;
		this.content = content;
		this.user = user;
	}

	public MessageType getType() {
        return type;
    }

    public String getContent() {
        return content;
    }
    
    public User getUser() {
		return user;
	}
    

}
