package service;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface MessageSender {
	@Output("newCategoryChannel")
	MessageChannel newCategory();
}