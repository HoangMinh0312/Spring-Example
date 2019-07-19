package model;

import java.util.UUID;

public class Category {
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private UUID id;
	private String name;

	/**
	 * @param id
	 * @param name
	 */
	public Category(UUID id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
}
