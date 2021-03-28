package com.alumne.comptecorrent;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CompteCorrentTest {

	@Test
	void testCompteCorrent() {
		int saldoInicial = 100;
		String contrasenya = "mevaContrasenya";
		
		CompteCorrent meuCompte = new CompteCorrent(saldoInicial, contrasenya);
		
		assertEquals(saldoInicial, meuCompte.getSaldo(contrasenya), "Error al saldo del constructor");
		assertSame(contrasenya, meuCompte.getContrasenya(contrasenya), "Error a la contrasenya del constructor");
	}

	@Test
	void testDiposita() {
		int resultatActual;
		int resultatEsperat;

		CompteCorrent meuCompte = new CompteCorrent(100, "mevaContrasenya");

		resultatActual = meuCompte.diposita(200);

		resultatEsperat = 300;

		assertEquals(resultatEsperat, resultatActual, "Error al dipositar diners");
	}
	
	@Test
	void testRetiraCorrecte() {
		
		String contrasenya = "mevaContrasenya";
		int saldoInicial = 100;
		int pastaRetirar = 20;
		
		int resultatActual;
		int resultatEsperat;
		
		CompteCorrent meuCompte = new CompteCorrent (saldoInicial, contrasenya);
		
		resultatActual = meuCompte.retira(pastaRetirar, contrasenya);
		resultatEsperat = 20;
		
		assertEquals(resultatEsperat, resultatActual, "Error, no hi ha prou saldo");
	}
	
	@Test
	void testRetiraMassaPasta() {
		
		String contrasenya = "mevaContrasenya";
		int saldoInicial = 100;
		int pastaRetirar = 150;
		
		int resultatActual;
		int resultatEsperat;
		
		CompteCorrent meuCompte = new CompteCorrent (saldoInicial, contrasenya);
		
		resultatActual = meuCompte.retira(pastaRetirar, contrasenya);
		resultatEsperat = -1;
		
		assertEquals(resultatEsperat, resultatActual, "Error, s'esperava una pasta a retirar superior al saldo");
	}
	
	@Test
	void testRetiraContrasenyaIncorrecta() {
		
		String contrasenya = "mevaContrasenya";
		String contrasenyaIncorrecta = "Contrasenyan't";
		int saldoInicial = 100;
		int pastaRetirar = 20;
		
		int resultatActual;
		int resultatEsperat;
		
		CompteCorrent meuCompte = new CompteCorrent (saldoInicial, contrasenya);
		
		resultatActual = meuCompte.retira(pastaRetirar, contrasenyaIncorrecta);
		resultatEsperat = -2;
		
		assertEquals(resultatEsperat, resultatActual, "Error, s'esperava una contrasenya incorrecta");
	}
	
	@Test
	void testGetSaldoCsCorrecta() {
		
		String contrasenya = "mevaContrasenya";
		int saldoInicial = 100;
		
		int resultatActual;
		int resultatEsperat;
		
		CompteCorrent meuCompte = new CompteCorrent(saldoInicial, contrasenya);
		
		resultatActual = meuCompte.getSaldo(contrasenya);
		resultatEsperat = 100;
		
		assertEquals(resultatEsperat, resultatActual, "Error, s'esperava retornar el saldo");
	}
	
	@Test
	void testGetSaldoCsIncorrecta() {
		
		String contrasenya = "mevaContrasenya";
		String contrasenyaIncorrecta = "Contrasenyan't";
		int saldoInicial = 100;
		
		int resultatActual;
		int resultatEsperat;
		
		CompteCorrent meuCompte = new CompteCorrent(saldoInicial, contrasenya);
		
		resultatActual = meuCompte.getSaldo(contrasenyaIncorrecta);
		resultatEsperat = -2;
		
		assertEquals(resultatEsperat, resultatActual, "Error, s'esperava una contrasenya incorrecta");
	}
	
	@Test
	void testSetContrasenyaAmbAntigaCorrecta() {
		String contrasenyaAntiga = "antigaContrasenya";
		String contrasenyaNova = "novaContrasenya";
		int saldoInicial = 100;
		
		int resultatActual;
		int resultatEsperat;
		
		CompteCorrent meuCompte = new CompteCorrent(saldoInicial, contrasenyaAntiga);
		
		resultatActual = meuCompte.setContrasenya(contrasenyaAntiga, contrasenyaNova);
		resultatEsperat = 0;
		
		assertEquals(resultatEsperat, resultatActual, "Error, s'esperava una contrasenya antiga correcta");
	}

	@Test
	void testSetContrasenyaAmbAntigaIncorrecta() {
		String contrasenyaAntiga = "antigaContrasenya";
		String contrasenyaAntigaIncorrecta = "Contrasenyan't";
		String contrasenyaNova = "novaContrasenya";
		int saldoInicial = 100;
		
		int resultatActual;
		int resultatEsperat;
		
		CompteCorrent meuCompte = new CompteCorrent(saldoInicial, contrasenyaAntiga);
		
		resultatActual = meuCompte.setContrasenya(contrasenyaAntigaIncorrecta, contrasenyaNova);
		resultatEsperat = -2;
		
		assertEquals(resultatEsperat, resultatActual, "Error, s'esperava una contrasenya antiga incorrecta");
	}
}