import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Image;
/// Varie librerie utilizzate


/**
 *
 * @author Fabian
 */

/**
* <b>@SuppressWarnings("unchecked") </b>il compilatore del Notepad++ del prof. Sacco (ma anche jCreator) dava un warning (Note: gestioneCellulare.java uses unchecked
* or unsafe operations. Note: Recompile with -Xlint:unchecked for details.) il quale non mi lasciava compilare  il programma,
* cercando in internet ho trovato questa riga che, lo dice anche nel nome, fa nel modo che il programma si "scordi" i warning
* di tipo unchecked.
*/
@SuppressWarnings("unchecked")


public class gestioneCellulare extends javax.swing.JFrame {

	/** ArrayList che conterra' tutti i cellulari del file cellulari.csv */
	public static ArrayList cellulari= new ArrayList();
	/** Oggetto di tipo Cellulare*/
	public static Cellulare cl = new Cellulare();

	/**
	* <p><b>Costruttore</b> che stabilisce alcune cose al partire della grafica</p>
	*/
	public gestioneCellulare() {

		initComponents();       												/// richiamo del metodo initComponents il quale contiene la grafica del programma
		doIt.setEnabled(false);													/// doIt e' un button nella graffica che modifica i dettagli dei cellulari
		cl = (Cellulare)cellulari.get(0);										/// mette nell'oggetto cl il contenuto che si trova nell'arrayList all'Index 0
		String immagine="immagini\\"+cl.getImmagine();							/// da' alla stringa immagine il valore dell'attributo immagine(
		if(!immagine.contains(".png")){
			ImagePreview.setIcon(null);
			ImagePreview.setText("Nessuna immagine trovata");
		}	
		imageSet(immagine);
		String detail = cellulari.get(0).toString();							/// da' alla stringa detail il contenuto che si trova
		Details.setText(detail);												/// setta alla textarea Details i dettagli del cellulare
		Details.setEditable(false);												///-al partire del programma mette la textarea non-editable e unabled per non
		Details.setEnabled(false);												///-poter modificare i valori prima che il pulsante "modifica" viene premuto
	}

	public void imageSet(String str) {
		ImageIcon img = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource(str)));
		Image limg = (img.getImage()).getScaledInstance(ImagePreview.getWidth(),ImagePreview.getHeight(), Image.SCALE_SMOOTH);
		ImagePreview.setIcon(new javax.swing.ImageIcon(limg)); 					/// setta al label ImagePreview l'immagine del cellulare
	}

	/** <p>In quanto non volevo fare un'area dentro gestioneCellulare per aggiungere un telefono, avevo pensato di creare un nuovo file java chiamato Aggiuni il quale conterra' un finestra GUI nella quale si potra' mettere i dettagli del nuovo telefono.</p>
	* @param newLine rappresenta il contenuto che l'utente aggiunge nella finestra Aggiungi
	*/
	public gestioneCellulare(String newLine) {					/// metodo che fa la comunicazione tra gestioneCellulare.java e Aggiungi.java
		initComponents();
		String[] line = newLine.split(",");					///	prende i dettagli del nuovo cellulare dal Aggiungi.java e gli mette dentro un array di Stringhe
		Cellulare clapp = new Cellulare(line[0],line[1],line[2],line[3],line[4],Double.parseDouble(line[5]),line[6]);	/// aggiunge nel nuovo cellulare(di appoggio) gli attributi scritti dall'user. Se avessi usato lo stesso oggetto di prima (cl) una volta aggiunto nell'arrayList il telefono veniva aggiunto alla coda della lista pero' cambiava anche i dettagli del primo cellulare ( cellulari.get(0) ),e se poi veniva aggiunto un nuovo cellulare, veniva aggiunto alla coda della lista, pero' cambiava sia il primo cellulare che l'ultimo cellulare aggiunto.
		cellulari.add(clapp); 							/// aggiunge nell'arrayList il nuovo cellulare.		
	}

	/** <p> Per la grafica avevo usato netBeans perche' volevo avere la precisione grafica dei vari componenti (cioe' buttons che venivano messi nei posti apposta) quindi questo metodo conterra' intorno a 200 righe di codice generato da netBeans </p>*/
	private void initComponents() {

		jPanel2 = new javax.swing.JPanel();
		Next = new javax.swing.JButton();
		Previous = new javax.swing.JButton();
		jScrollPane1 = new javax.swing.JScrollPane();
		Details = new javax.swing.JTextArea();
		SearchBar = new javax.swing.JTextField();
		SearchButton = new javax.swing.JButton();
		Add = new javax.swing.JButton();
		ImagePreview = new javax.swing.JLabel();
		doIt = new javax.swing.JButton();
		Modify = new javax.swing.JButton();
		Exit = new javax.swing.JButton();
		Cancella = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setBackground(new java.awt.Color(102, 102, 102));
		setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

		jPanel2.setBackground(new java.awt.Color(102, 102, 102));

		Next.setBackground(new java.awt.Color(102, 102, 102));
		Next.setForeground(new java.awt.Color(51, 51, 51));
		Next.setIcon(new javax.swing.ImageIcon("immagini\\arrowRight.png")); // NOI18N
		Next.setAlignmentY(1.0F);
		Next.setPreferredSize(new java.awt.Dimension(137, 59));
		Next.setRequestFocusEnabled(false);
		Next.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				NextActionPerformed(evt);
			}
		});

		Previous.setBackground(new java.awt.Color(102, 102, 102));
		Previous.setIcon(new javax.swing.ImageIcon("immagini\\arrowLeft.png")); // NOI18N
		Previous.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				PreviousActionPerformed(evt);
			}
		});

		Details.setEditable(true);
		Details.setBackground(new java.awt.Color(204, 204, 204));
		Details.setColumns(20);
		Details.setRows(5);
		Details.setEnabled(true);
		jScrollPane1.setViewportView(Details);

		SearchBar.setBackground(new java.awt.Color(204, 204, 204));
		SearchBar.setText("Search...");


		SearchButton.setBackground(new java.awt.Color(102, 102, 102));
		SearchButton.setForeground(new java.awt.Color(255, 255, 255));
		SearchButton.setText("Search");
		SearchButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				SearchButtonActionPerformed(evt);
			}
		});

		Add.setBackground(new java.awt.Color(102, 102, 102));
		Add.setForeground(new java.awt.Color(255, 255, 255));
		Add.setText("+");
		Add.setPreferredSize(new java.awt.Dimension(40, 40));
		Add.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				AddActionPerformed(evt);
			}
		});

		doIt.setBackground(new java.awt.Color(102, 102, 102));
		doIt.setForeground(new java.awt.Color(255, 255, 255));
		doIt.setText("Modifica!");
		doIt.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				doItActionPerformed(evt);
			}
		});

		Modify.setBackground(new java.awt.Color(102, 102, 102));
		Modify.setForeground(new java.awt.Color(255, 255, 255));
		Modify.setText("Modifica Cellulare");
		Modify.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				ModifyActionPerformed(evt);
			}
		});

		Exit.setBackground(new java.awt.Color(102, 102, 102));
		Exit.setForeground(new java.awt.Color(255, 255, 255));
		Exit.setText("Chiudi e Salva");
		Exit.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				ExitActionPerformed(evt);
			}
		});

		Cancella.setBackground(new java.awt.Color(102, 102, 102));
		Cancella.setForeground(new java.awt.Color(255, 255, 255));
		Cancella.setText("-");
		Cancella.setPreferredSize(new java.awt.Dimension(40, 40));
		Cancella.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				CancellaActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(
		    jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		    .addGroup(jPanel2Layout.createSequentialGroup()
		              .addContainerGap()
		              .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		                        .addComponent(Exit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		                        .addComponent(jScrollPane1)
		                        .addGroup(jPanel2Layout.createSequentialGroup()
		                                  .addComponent(Modify, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
		                                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
		                                  .addComponent(doIt, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
		                        .addGroup(jPanel2Layout.createSequentialGroup()
		                                  .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
		                                          .addGroup(jPanel2Layout.createSequentialGroup()
		                                                  .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		                                                          .addGroup(jPanel2Layout.createSequentialGroup()
		                                                                  .addGap(8, 8, 8)
		                                                                  .addComponent(Previous, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
		                                                          .addGroup(jPanel2Layout.createSequentialGroup()
		                                                                  .addGap(16, 16, 16)
		                                                                  .addComponent(Cancella, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
		                                                  .addGap(18, 18, 18)
		                                                  .addComponent(ImagePreview, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
		                                          .addComponent(SearchBar, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE))
		                                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
		                                  .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		                                          .addComponent(SearchButton)
		                                          .addGroup(jPanel2Layout.createSequentialGroup()
		                                                  .addGap(9, 9, 9)
		                                                  .addComponent(Add, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
		                                          .addComponent(Next, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
		                                  .addGap(0, 0, Short.MAX_VALUE)))
		              .addContainerGap())
		);
		jPanel2Layout.setVerticalGroup(
		    jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		    .addGroup(jPanel2Layout.createSequentialGroup()
		              .addContainerGap()
		              .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
		                        .addComponent(SearchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
		                        .addComponent(SearchBar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
		              .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		                        .addGroup(jPanel2Layout.createSequentialGroup()
		                                  .addGap(30, 30, 30)
		                                  .addComponent(Add, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
		                                  .addGap(26, 26, 26)
		                                  .addComponent(Next, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
		                        .addGroup(jPanel2Layout.createSequentialGroup()
		                                  .addGap(18, 18, 18)
		                                  .addComponent(ImagePreview, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
		                        .addGroup(jPanel2Layout.createSequentialGroup()
		                                  .addGap(31, 31, 31)
		                                  .addComponent(Cancella, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
		                                  .addGap(27, 27, 27)
		                                  .addComponent(Previous, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
		              .addGap(18, 18, 18)
		              .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
		              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
		              .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
		                        .addComponent(doIt, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
		                        .addComponent(Modify, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
		              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
		              .addComponent(Exit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
		              .addContainerGap())
		);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
		    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
		);
		layout.setVerticalGroup(
		    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		);

		pack();
	}// </editor-fold>

	/** <p> Quando il pulsante " + " viene cliccato questo actionPerformed crea' una finestra di tipo Aggiungi e la rende visibile (a.setVisible(true))</p> */
	private void AddActionPerformed(java.awt.event.ActionEvent evt) {
		Aggiungi a = new Aggiungi();
		a.setVisible(true);
	}

	/** <p> Metodo che contiene le funzionalità di search del programma </p> */
	private void SearchButtonActionPerformed(java.awt.event.ActionEvent evt) {
		String str = SearchBar.getText();                        /// la stringa prende il valore inserito dall'utente nella searchbar
		int posizione=-1;										 /// la variabile posizione con valore default -1
		for(int i=0; i<cellulari.size(); i++) {
			cl = (Cellulare)cellulari.get(i);					 /// l'oggetto cl prende i valori che si trova nell'arrayList all'index i
			String strapp=cl.getMarca();						 /// la stringa di appoggio prende il valore della marca del cellulare
			if(str.toLowerCase().equals(strapp.toLowerCase())) { /// controllo che verifica se la stringa inserita dall'utente e quella di appoggio si assomigliano
				posizione = i;									 ///-se si assomigliano allora la variabile posizione riceve il valore di i
				i=cellulari.size();								 ///-e "i" prende il valore della lunghezza del arraylist in modo da finire il ciclo
			}
			strapp=cl.getModello();								 /// la stringa di appoggio prende il valore del modello del cellulare
			if(str.toLowerCase().equals(strapp.toLowerCase())) { /// controllo che verifica se la stringa inserita dall'utente e quella di appoggio si assomigliano
				posizione = i;									 ///-se si assomigliano allora la variabile posizione riceve il valore di i
				i=cellulari.size();								 ///-e "i" prende il valore della lunghezza del arraylist in modo da finire il ciclo
			}
			strapp=Double.toString(cl.getPrezzo());		  		 /// la stringa di appoggio prende il valore del prezzo del cellulare
			if(str.toLowerCase().equals(strapp.toLowerCase())) { /// controllo che verifica se la stringa inserita dall'utente e quella di appoggio si assomigliano
				posizione = i;									 ///-se si assomigliano allora la variabile posizione riceve il valore di i
				i=cellulari.size();								 ///-e "i" prende il valore della lunghezza del arraylist in modo da finire il ciclo
			}
		}
		if(posizione==-1) {								/// se la posizione rimane la stessa a quella di default allora setta nella searchbar un testo..
			SearchBar.setBackground(Color.RED);
			SearchBar.setText("Cellulare non trovato");
		} else if(posizione!=-1) {						/// se invece la posizione e' difersa a quella di default
			SearchBar.setBackground(Color.GREEN);		/// cambia colore del background della textfield
			SearchBar.setText("Trovato");				/// setta il testo riguardo al fatto che il cellulare e' stato trovato
			cl = (Cellulare)cellulari.get(posizione);	/// da a cl gli attributi che si trovano nella specifica posizione
			String immagine="immagini\\"+cl.getImmagine();
			imageSet(immagine);
			String detail = cellulari.get(posizione).toString();	/// da alla stringa i dettagli del cellulare
			Details.setText(detail);								/// setta' i dettagli nella textArea
		}
	}

	/** <p> Metodo che viene eseguito quando il button con la freccia rivolta verso sinistra (<img src="immagini/arrowLeft.png">) viene premuto </p>*/
	private void PreviousActionPerformed(java.awt.event.ActionEvent evt) {		/// metodo per la navigazione con i buttons (Previous, quello di prima)
		String nome = Details.getText();										/// da' alla stringa i dettagli della textarea
		int posizione=-1;														/// posizione di default -1
		for(int i=0; i<cellulari.size(); i++) {
			if(nome.equals(cellulari.get(i).toString())) {						/// se i dettagli sono uguali a quello del cellulare
				posizione = i;													/// la posizione prende il valore di i
				i=cellulari.size();												/// da' ad "i" il valore della lunghezza dell'arraylist per finire il ciclo
			}
		}
		if(posizione == 0)												/// se la posizione e' uguale a 0 allora cambia la posizione a quella dell'ultimo cellulare
			posizione=cellulari.size();
		posizione--;				/// posizione-- per prendere il l'index del cellulare precedente
		Details.setText(cellulari.get(posizione).toString());		/// setta nella textarea i dettagli del cellulare precedente
		cl = (Cellulare)cellulari.get(posizione);					/// da a cl i valori che si trovano nell'arrayList alla "posizione"
		String immagine="immagini\\"+cl.getImmagine();							/// prende il valore dell'immagine
		if(!immagine.contains(".png")){
			ImagePreview.setIcon(null);
			ImagePreview.setText("Nessuna immagine trovata");
		}
		else
		imageSet(immagine);
	}

	/** <span style="color:red;">*ho spostato il metodo fuori dall'actionPerformed perche' servira' dopo nella cancellazzione del cellulare*</span>.<br/> Contiene tutte le funzioni che verrano eseguite al premere del button con la freccia rivolta verso destra (<img src ="immagini/arrowRight.png">)*/
	private void Next() {			/// c'e' lo stesso procedimento che c'e' nella previous
		String nome = Details.getText();
		int posizione=-1;
		for(int i=0; i<cellulari.size(); i++) {
			if(nome.equals(cellulari.get(i).toString())) {
				posizione = i;
				i=cellulari.size();
			}
		}
		posizione++;
		if(posizione == cellulari.size())		/// se la posizione arriva a quella della lunghezza del cellulare allora la posizione e' 0
			posizione=0;
		Details.setText(cellulari.get(posizione).toString());
		cl = (Cellulare)cellulari.get(posizione);
		String immagine="immagini\\"+cl.getImmagine();
		if(!immagine.contains(".png")){
			ImagePreview.setIcon(null);
			ImagePreview.setText("Nessuna immagine trovata");
		}
		else
		imageSet(immagine);
	}

	/** <p>Metodo che viene eseguito quando la freccia rivolta verso destra viene cliccata (<img src="immagini/arrowRight.png">)</p> */
	private void NextActionPerformed(java.awt.event.ActionEvent evt) {
		Next();			/// il richiamo del metodo Next
	}


	String cellulareVecchio;	/// Stringa da appoggio, usata piu' per il controllo
	/** <p>Metodo che viene attivato quando il pulsante "Modifica Cellulare" viene premuto</p> */
	private void ModifyActionPerformed(java.awt.event.ActionEvent evt) { /// quando il button Modifica' viene premuto si attiva questa funzione
		cellulareVecchio = Details.getText();		/// cellulareVecchio prende i dettagli che si trovano in quel momento al cellulare
		Details.setEditable(true);					/// rende usabile la textArea
		Details.setEnabled(true);					/// --
		doIt.setEnabled(true);						/// rende usabile il pulsante Cambia
		Modify.setEnabled(false);					/// il pulsante modifica non puo' essere premuto un'altra volta
	}

	/** <p>Metodo che viene attivato quando il pulsante "Modifica!" viene premuto</p> */
	private void doItActionPerformed(java.awt.event.ActionEvent evt) { /// quando il button Cambia viene premuto si attiva questa funzione
		String cellulareNuovo = Details.getText();		/// cellulareNuovo prende i valori cambiati dall'utente
		int ind = 0;				/// verra' usato come la variable "posizione" e' stata usata qualche funzione fa'
		if(!cellulareNuovo.equals(cellulareVecchio)) {	/// se il cellulare nuovo e' diverso da quello vecchio allora:

			String[] str = cellulareNuovo.split("\\r?\\n");		///-toglie gli endLine (\n) di entrambe le stringhe e gli aggiunge in un arrat di Stringhe
			String[] strv = cellulareVecchio.split("\\r?\\n");	///--

			strv[2] = strv[2].replace("Modello:","");			///-toglie dal cellulare vecchio  il testo "Modello:" per poi poter trovare la posizione in qui
			for(int i=0; i<cellulari.size(); i++) {				///-il nuovo cellulare verra' messo
				cl = (Cellulare)cellulari.get(i);
				String strapp=cl.getModello();
				if(strv[2].toLowerCase().equals(strapp.toLowerCase())) {
					ind = i;
					i=cellulari.size();
				}
			}
			str[1] = str[1].replace("Marca:","");			/// toglie i vari testi per ottenere un array di stringhe che potra' essere scritta nel arrayList
			str[2] = str[2].replace("Modello:","");
			str[3] = str[3].replace("OS:","");
			str[4] = str[4].replace("Tipo:","");
			str[5] = str[5].replace("Dimensioni:","");
			str[6] = str[6].replace("Prezzo:","");
			str[7] = str[7].replace("Immagine:","");
			cl.set(str[1],str[2],str[3],str[4],str[5],Double.parseDouble(str[6]),str[7]);	/// setta' i valori scritti dall'utente nell'oggeto cl
			cellulari.set(ind,cl);			/// setta' il cellulare nuovo nella posizione ind
		}
		Details.setEditable(false);			/// rende non-editable e unabled la textarea
		Details.setEnabled(false);			/// --
		doIt.setEnabled(false);				/// rende unabled il button Cambia
		Modify.setEnabled(true);			/// rende usable il button Modifica
	}

	/** <p>Metodo che viene attivato quando il pulsante "Chiudi e Salva" viene premuto. Il suo compito e' quello di salvare le modifiche avvenute salvandole in un file apposta</p> */
	private void ExitActionPerformed(java.awt.event.ActionEvent evt) {	/// metodo del button Chiudi e Salva che quando il programma verra' spento, tutte le
		try {															///modifiche avvenute verrano salvate nel file cellulari.csv
			Scanner in = new Scanner(System.in);
			String str= "cellulari.csv";
			Writer fd = new FileWriter(str);
			str="";
			for(int i=0; i < cellulari.size(); i++) {
				cl =(Cellulare)cellulari.get(i);
				str+=cl.scritturaFile()+endl;
				System.out.println(cl);
			}
			fd.write(str);
			fd.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		System.exit(0);
	}

	/// metodo che cancella il cellulare mostrato in quel momento
	/** <p>Metodo che quando il tasto "-" viene premuto cancella il telefono dalla lista</p> */
	private void CancellaActionPerformed(java.awt.event.ActionEvent evt) {
		String nome = Details.getText();
		Next();			/// quando verra' cancellato si passa al prossimo cellulare
		int posizione=-1;
		for(int i=0; i<cellulari.size(); i++) {
			if(nome.equals(cellulari.get(i).toString()))
				posizione = i;
		}

		if(cellulari.size()==1) {
			cellulari.remove(posizione);
			ImagePreview.setIcon(null);
			ImagePreview.setText("Nessuna immagine trovata");
			Details.setText("Nessun dettaglio trovato");
			Cancella.setEnabled(false);

		} else
			cellulari.remove(posizione);	/// la cancellazzione del cellulare nell'arrayList

	}


	public static void main(String args[]) {
		///--------------------------------------------------------------------------------------------------------------------------------
		try {																														///	---
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {					///	---
				if ("Nimbus".equals(info.getName())) {																				/// ---
					javax.swing.UIManager.setLookAndFeel(info.getClassName());														/// ---
					break;																											/// ---
				}																													/// ---
			}																														/// ---
		} catch (ClassNotFoundException ex) {																						/// ---
			java.util.logging.Logger.getLogger(gestioneCellulare.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);	/// ---
		} catch (InstantiationException ex) {																						/// ---
			java.util.logging.Logger.getLogger(gestioneCellulare.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);	///	---
		} catch (IllegalAccessException ex) {																						/// ---
			java.util.logging.Logger.getLogger(gestioneCellulare.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);	/// ---
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {																	/// ---
			java.util.logging.Logger.getLogger(gestioneCellulare.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);	/// ---
		}																															/// ---
		///--------------------------------------------------------------------------------------------------------------------------------
		///----ROBA SCRITTA DA NETBEANS----------------------------
		java.awt.EventQueue.invokeLater(new Runnable() {	/// ---
			public void run() {
				cellulari = cl.leggiFile(cellulari);
				new gestioneCellulare().setVisible(true);
			}
		});


	}

	/// la dichiarazione dei buttons/textareas/labels/panels/textfields
	private javax.swing.JButton Add;
	private javax.swing.JButton Cancella;
	private javax.swing.JTextArea Details;
	private javax.swing.JButton Exit;
	private javax.swing.JLabel ImagePreview;
	private javax.swing.JButton Modify;
	private javax.swing.JButton Next;
	private javax.swing.JButton Previous;
	private javax.swing.JTextField SearchBar;
	private javax.swing.JButton SearchButton;
	private javax.swing.JButton doIt;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JScrollPane jScrollPane1;

	private  static String endl = System.getProperty("line.separator");
}

