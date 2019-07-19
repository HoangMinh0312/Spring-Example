package service;

import java.util.UUID;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.messaging.support.MessageBuilder;

import model.Category;

@EnableBinding(MessageSender.class)
public class CategoryPublisher {

	@Bean
	@InboundChannelAdapter(channel = "newCategoryChannel", poller = @Poller(fixedDelay = "2000"))
	public org.springframework.integration.core.MessageSource<Category> name() {
		return () -> MessageBuilder.withPayload(new Category(UUID.randomUUID(), "new category")).build();
	}
}
