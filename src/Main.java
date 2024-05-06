import java.util.Random;
import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		Random r=new Random();
		
		//dichiaro tutte le variabili che mi serviranno
		int nComputer;
		String mossaComputer;
		String mossaUtente;
		int vittorieComputer;
		int vittorieUtente;
		String nomeUtente;
		String controllo;
		String risposta;
		int cheat=0;
		
		System.out.println("Benvenuto! Questo è il gioco di MORRA CINESE.");
		System.out.println();
		System.out.println("Per vincere contro il computer hai a disposizione 3 mosse:");
		System.out.println("SASSO; CARTA; FORBICI.");
		System.out.println();
		System.out.println("Sasso batte carta, carta batte forbici e forbici batte sasso.");
		System.out.println("Per vincere la partita devi conseguire 5 vittorie,");
		System.out.println("mentre se il computer vince 5 volte allora hai perso.");
		System.out.println("Buona fortuna!");
		System.out.println();
		System.out.println();
		//chiedo il nome del giocatore da mostrare con i punteggi
		System.out.println("Inserire nome giocatore:");
		nomeUtente= sc.nextLine();
		
		do {
			//avvio il ciclo per poter giocare di nuovo
			//resetto i punteggi
			vittorieComputer=0;
			vittorieUtente=0;
			
			do {
				//inizio il ciclo per fare le manche successive
				
				nComputer=r.nextInt(3)+1;
				//genero la mossa del computer tramite un numero random tra 1 e 3
				//associo ciascun numero a una delle tre mosse nel gioco
				if (nComputer==1) {
					mossaComputer="sasso";
				}else if (nComputer==2) {
					mossaComputer="carta";
				} else {
					mossaComputer="forbici";
				}
				System.out.println("Mossa computer generata.");
				
				do {
					//chiedo l'inserimento della mossa del giocatore e ne controllo il valore
					System.out.println(nomeUtente+" inserisci la tua mossa");
					mossaUtente= sc.nextLine().toLowerCase();
					
					if(mossaUtente.equals("forbici")||mossaUtente.equals("sasso")||mossaUtente.equals("carta")||mossaUtente.equals("vittoria!")) {
						controllo="true";
					}else {
						System.out.println("Inserimento mossa non valido!");
						controllo="false";
					}
				}while (controllo.equals("false"));
				
				if (mossaUtente.equals("vittoria!")) {
					vittorieUtente=4;
					cheat++;
				}
				
				//confronto le mosse dei due avversari
				if (mossaUtente.equals(mossaComputer)) {
					
					//racchiudo in un ramo dell'if i 3 casi di pareggio
					System.out.println("Pareggio! Avete scelto entrambi "+mossaUtente+"!");
					
					//nei restanti sei casi vince il giocatore oppure il computer
				} else if ((mossaComputer.equals("sasso")&&mossaUtente.equals("forbici"))||(mossaComputer.equals("carta")&&mossaUtente.equals("sasso"))||(mossaComputer.equals("forbici")&&mossaUtente.equals("carta"))){
					
					//racchiudo in un altro ramo tutti i 3 casi in cui vince il computer
					System.out.println(nomeUtente+": "+mossaUtente+" - Computer: "+mossaComputer+".");
					System.out.println("Ha vinto il computer!");
					vittorieComputer++;
				}else {
					
					//i restanti 3 casi sono di vittoria del giocatore
					System.out.println(nomeUtente+": "+mossaUtente+" - Computer: "+mossaComputer+".");
					System.out.println("Ha vinto "+nomeUtente+"!");
					vittorieUtente++;
				}
				
				//mostro il punteggio di entrambi gli avversari
				System.out.println("Totale: "+nomeUtente+" "+vittorieUtente+" - Computer "+vittorieComputer);
			} while (vittorieUtente<5&&vittorieComputer<5);
			
			/*
			 una volta che uno dei due avversari
			 ha raggiunto le cinque vittorie
			 il gioco è concluso
			 */
			System.out.println();
			System.out.println("GAME OVER!");
			System.out.println();
			//dico chi ha vinto
			if (vittorieUtente==5) {
				System.out.println("Complimenti! Hai vinto!");
			} else {
				System.out.println("Peccato! Hai perso.");
			};
			
			//chiedo se vuole giocare di nuovo
			System.out.println("Vuoi giocare di nuovo? (s/n)");
			risposta=sc.nextLine().toLowerCase().substring(0, 1);
			
		}while (risposta.equals("s"));
		System.out.println("Ok, arrivederci!");
		if (cheat!=0) {
			System.out.println("Ti piace vincere facile...");
		}
		sc.close();
	}

}
