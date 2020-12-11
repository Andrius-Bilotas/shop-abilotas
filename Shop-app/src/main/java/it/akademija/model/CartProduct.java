package it.akademija.model;

import java.util.List;

public final class CartProduct {

	private String id;
	private String title;
	private String image;

	public CartProduct() {
	}

	public CartProduct(String id, String title, String image) {
		this.id = id;
		this.title = title;
		this.image = image;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getimage() {
		return image;
	}

	public void setimage(String image) {
		this.image = image;
	}

}
