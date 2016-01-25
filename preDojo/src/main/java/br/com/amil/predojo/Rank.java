package br.com.amil.predojo;

public class Rank {

	private String usuario;
	private int qntMortes;
	private int qntassassinatos;
	private String idPartida;

	/**
	 * @param usuario
	 * @param qntMortes
	 * @param qntassassinatos
	 */
	public Rank(String usuario, int qntMortes, int qntassassinatos,
			String idPartida) {
		super();
		this.usuario = usuario;
		this.qntMortes = qntMortes;
		this.qntassassinatos = qntassassinatos;
		this.idPartida = idPartida;
	}

	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario
	 *            the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the qntMortes
	 */
	public int getQntMortes() {
		return qntMortes;
	}

	/**
	 * @param qntMortes
	 *            the qntMortes to set
	 */
	public void setQntMortes(int qntMortes) {
		this.qntMortes = qntMortes;
	}

	public int getQntassassinatos() {
		return qntassassinatos;
	}

	public void setQntassassinatos(int qntassassinatos) {
		this.qntassassinatos = qntassassinatos;
	}

	/**
	 * @return the idPartida
	 */
	public String getIdPartida() {
		return idPartida;
	}

	/**
	 * @param idPartida the idPartida to set
	 */
	public void setIdPartida(String idPartida) {
		this.idPartida = idPartida;
	}
}
