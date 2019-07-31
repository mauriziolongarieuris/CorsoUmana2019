package it.umana.articoli;

import java.io.Serializable;

public class ElementoCatalogo implements Serializable {

	private static final long serialVersionUID = -4539729457795652989L;
	
	private Articolo articolo;
	private Integer quantity;
	
	public ElementoCatalogo() {}
	
	public ElementoCatalogo(Articolo articolo, Integer quantity) {
		super();
		this.articolo = articolo;
		this.quantity = quantity;
	}

	public Articolo getArticolo() {
		return articolo;
	}

	public void setArticolo(Articolo articolo) {
		this.articolo = articolo;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
}
