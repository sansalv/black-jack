package peli;

import peli.Pelipoyta;
import henkilot.Pelaaja;

public class PelinSuorittaja {

	public static void main(String[] args) {

		boolean haluaaJatkaa = true;
		Pelipoyta poyta = new Pelipoyta();
		poyta.pelinAlustus();

		do {
			poyta.uusiKierros();
			if (((Pelaaja) poyta.annaHenkilot()[0]).annaOmaisuus() == 0) {
				System.out.println("\nAika l�hte� kotiin. Rahat on loppu.");
				break;
			}
			System.out.println("Haluatko pelata uuden k�den? (Vastaa k/e)");
			char x = poyta.annaSkanneri().next().charAt(0);
			if (x == 'k') {
				poyta.annaHenkilot()[0].uusiKortti(poyta.annaPakka().annaKortti());
				continue;
			} else if (x == 'e') {
				haluaaJatkaa = false;
				break;
			} else {
				System.out.println("Tarkista sy�te!");
				continue;
			}
		} while (((Pelaaja) poyta.annaHenkilot()[0]).annaOmaisuus() > 0 && haluaaJatkaa);

		do {
			System.out.println("Haluatko tekstitiedoston omaisuus per kierros pelist�si? (Vastaa k/e)");
			char x = poyta.annaSkanneri().next().charAt(0);
			if (x == 'k') {
				System.out.println(
						"Kirjoita polku jonne haluat tekstitiedoston tallennettavan. \nEsim: C:\\Users\\Kayttaja\\Desktop\\peliHistoria.txt");
				String polku = poyta.annaSkanneri().next();
				poyta.teeTiedosto(poyta.annaPeliHistoria(), polku);
				break;
			} else if (x == 'e') {
				break;
			} else {
				System.out.println("Tarkista sy�te!");
				continue;
			}
		} while (true);

		poyta.suljeSkanneri();

		System.out.println("\nTervetuloa uudelleen " + poyta.annaHenkilot()[0].annaNimi() + "!");

	}

}