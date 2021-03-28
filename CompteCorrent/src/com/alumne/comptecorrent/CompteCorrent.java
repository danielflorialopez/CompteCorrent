package com.alumne.comptecorrent;

public class CompteCorrent {
	private int saldo;
	private String contrasenya;
	
	/**
	 * 
	 * @param saldoInicial Els diners amb els que parteix el compte corrent
	 * @param cs La contrasenya per a fer operacions al compte corrent
	 */
	// Constructor
	public CompteCorrent(int saldoInicial, String cs) {
		this.saldo = saldoInicial;
		this.contrasenya = cs;
	}
	
	/**
	 * 
	 * @param cs La contrasenya actual
	 * @return Retorna un error si la contrasenya no és correcta,
	 * retorna la contrasenya actual si s'escriu correctament
	 */
	// Retorna la contrasenya actual, és només per a provar als testos el assertSame
	public String getContrasenya(String cs) {
		if (cs != contrasenya) return "No ets de fiar o tens mala memòria";
		
		return contrasenya;
	}
	
	/**
	 * 
	 * @param pasta L'integer que se li suma al saldo
	 * @return saldo Retorna els diners que hi ha al compte
	 */
	// Rebem els diners
	public int diposita(int pasta) {
		saldo += pasta;
		
		return saldo;
		
	}
	
	/**
	 * 
	 * @param pasta L'integer que se li resta al saldo
	 * @param cs La contrasenya requerida per a permetre fer l'operació
	 * @return Retorna l'integer que retirem si hi ha prous diners a saldo,
	 * retorna -1 si no hi ha prou diners, retorna -2 si la contrasenya és incorrecta
	 * 			
	 */
	// Si la contrasenya és correcta i tenim prou diners, els restem del saldo i
	// retornem el valor de la pasta que hem retirat.
	// Si no tenim prou saldo, retornem un -1.
	// Si la contrasenya no és correcte, retornem un -2.
	public int retira(int pasta, String cs) {
		if (pasta > saldo) return -1;
		
		if (cs != contrasenya) return -2;
		
		saldo -= pasta;
		return pasta;
	}
	
	/**
	 * 
	 * @param cs La contrasenya requerida per a fer qualsevol operació
	 * @return Retorna -2 si la contrasenya no és correcta, 
	 * retorna saldo si la contrasenya és correcta.
	 */
	// Retornem el saldo
	public int getSaldo(String cs) {
		if (cs != contrasenya) return -2;
		
		return saldo;
	}
	
	/**
	 * 
	 * @param antiga La contrasenya que es vol canviar
	 * @param nova La contrasenya nova que es vol posar
	 * @return Retorna 0 si tot va bé, retorna -2 si la contrasenya antiga no coincideix
	 */
	// Modifiquem la contrasenya, retornem 0 si va bé i -2 si l’antiga és incorrecta
	public int setContrasenya(String antiga, String nova) {
		if (antiga != contrasenya) return -2;
		
		contrasenya = nova;
		return 0;
	}
}

