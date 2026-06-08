package foodie;
import java.util.Scanner;
public class MenuPrincipal {
	  public static final String RESET     = "\u001B[0m";
	    public static final String NEGRITA   = "\u001B[1m";
	    public static final String ROJO      = "\u001B[31m";
	    public static final String VERDE     = "\u001B[32m";
	    public static final String AMARILLO  = "\u001B[33m";
	    public static final String AZUL      = "\u001B[34m";
	    public static final String MORADO    = "\u001B[35m";
	    public static final String CYAN      = "\u001B[36m";
	    public static final String BLANCO    = "\u001B[37m";
	    public static final String ROJO_F    = "\u001B[91m";
	    public static final String VERDE_F   = "\u001B[92m";
	    public static final String AMARILLO_F= "\u001B[93m";
	    public static final String AZUL_F    = "\u001B[94m";
	    public static final String MORADO_F  = "\u001B[95m";
	    public static final String CYAN_F    = "\u001B[96m";

	    static Scanner scanner = new Scanner(System.in);
        static javax.sound.midi.Sequencer sequencer;
        static boolean musicaActiva =false;
	    public static void musicaMenu() {
	        String b = "\007";
	        System.out.print(b); esperar(150);
	        System.out.print(b); esperar(150);
	        System.out.print(b); esperar(100);
	        System.out.print(b); esperar(200);
	        System.out.print(b);
	    }

	    public static void musicaVictoria() {
	        String b = "\007";
	        for (int i = 0; i < 3; i++) { System.out.print(b); esperar(80); }
	        esperar(200);
	        System.out.print(b); esperar(100);
	        System.out.print(b);
	    }

	    public static void musicaDerrota() {
	        String b = "\007";
	        System.out.print(b); esperar(500);
	        System.out.print(b); esperar(500);
	        System.out.print(b);
	    }

	    public static void musicaCliente() {
	        String b = "\007";
	        System.out.print(b); esperar(100);
	        System.out.print(b);
	    }
	    public static void toggleMusica() {
	        if (musicaActiva) {
	            sequencer.stop();
	            musicaActiva = false;
	            System.out.println(ROJO_F + "\n  🔇 Musica desactivada." + RESET);
	        } else {
	            sequencer.start();
	            musicaActiva = true;
	            System.out.println(VERDE_F + "\n  🎵 Musica activada." + RESET);
	        }
	        
	        esperar(1000);
	    }

	    public static void reproducirMusica() {
	        try {
	            sequencer = javax.sound.midi.MidiSystem.getSequencer();
	            sequencer.open();
	            javax.sound.midi.Sequence sequence = 
	                new javax.sound.midi.Sequence(javax.sound.midi.Sequence.PPQ, 4);
	            javax.sound.midi.Track track = sequence.createTrack();
	            int[] notas = {72, 74, 76, 72, 76, 79, 77, 76, 74, 72, 74, 76, 67, 69, 71, 72};
	            for (int i = 0; i < notas.length; i++) {
	                track.add(new javax.sound.midi.MidiEvent(
	                    new javax.sound.midi.ShortMessage(
	                        javax.sound.midi.ShortMessage.NOTE_ON, 0, notas[i], 93), i * 4));
	                track.add(new javax.sound.midi.MidiEvent(
	                    new javax.sound.midi.ShortMessage(
	                        javax.sound.midi.ShortMessage.NOTE_OFF, 0, notas[i], 0), i * 4 + 3));
	            }
	            sequencer.setSequence(sequence);
	            sequencer.setTempoInBPM(140);
	            sequencer.setLoopCount(javax.sound.midi.Sequencer.LOOP_CONTINUOUSLY);
	            sequencer.start();
	            musicaActiva = true;
	        } catch (Exception e) {}
	    }
	    
	    public void mostrarIntro() {
	        limpiarPantalla();
	        reproducirMusica();
	        musicaMenu();
	        esperar(300);

	        System.out.println();
	        // Fuente ANSI Shadow estilo retro - color CYAN brillante
	        System.out.println(CYAN_F + NEGRITA + "  ███████╗ ██████╗  ██████╗ ██████╗ ██╗███████╗" + RESET);
	        esperar(100);
	        System.out.println(CYAN_F + NEGRITA + "  ██╔════╝██╔═══██╗██╔═══██╗██╔══██╗██║██╔════╝" + RESET);
	        esperar(100);
	        System.out.println(CYAN_F + NEGRITA + "  █████╗  ██║   ██║██║   ██║██║  ██║██║█████╗  " + RESET);
	        esperar(100);
	        System.out.println(CYAN_F + NEGRITA + "  ██╔══╝  ██║   ██║██║   ██║██║  ██║██║██╔══╝  " + RESET);
	        esperar(100);
	        System.out.println(CYAN_F + NEGRITA + "  ██║     ╚██████╔╝╚██████╔╝██████╔╝██║███████╗" + RESET);
	        esperar(100);
	        System.out.println(CYAN_F + NEGRITA + "  ╚═╝      ╚═════╝  ╚═════╝ ╚═════╝ ╚═╝╚══════╝" + RESET);
	        esperar(100);
	        System.out.println(CYAN_F + NEGRITA + "  ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░" + RESET);
	        esperar(400);

	        System.out.println();
	        System.out.println(AMARILLO_F + NEGRITA + "        🍔  El Restaurante mas EPICO  🍣" + RESET);
	        System.out.println(MORADO_F   + NEGRITA + "        🍕  ¡Atiende a tus clientes!  🍹" + RESET);
	        System.out.println();

	        System.out.print(VERDE_F + "  Cargando ");
	        for (int i = 0; i < 20; i++) {
	            System.out.print(CYAN_F + NEGRITA + "."
	            		+ "" + RESET);
	            esperar(60);
	        }
	        System.out.println(VERDE_F + " ¡Listo!" + RESET);
	        esperar(600);

	        System.out.println();
	        System.out.println(AMARILLO_F + NEGRITA + "  Presiona Enter para continuar..." + RESET);
	        scanner.nextLine();
	    }

	    public void mostrarMenu() {
	        int opcion = 0;
	        do {
	            limpiarPantalla();
	            System.out.println();
	            System.out.println(CYAN_F + NEGRITA + "  ╔══════════════════════════════════════════╗" + RESET);
	            System.out.println(CYAN_F + NEGRITA + "  ║                                          ║" + RESET);
	            System.out.println(CYAN_F + NEGRITA + "  ║  " + AMARILLO_F + NEGRITA + " ███████╗ ██████╗  ██████╗ ██████╗ ██╗███████╗" + CYAN_F + NEGRITA + " ║" + RESET);
	            System.out.println(CYAN_F + NEGRITA + "  ║  " + AMARILLO_F + NEGRITA + " ██╔════╝██╔═══██╗██╔═══██╗██╔══██╗██║██╔════╝" + CYAN_F + NEGRITA + " ║" + RESET);
	            System.out.println(CYAN_F + NEGRITA + "  ║  " + ROJO_F     + NEGRITA + " █████╗  ██║   ██║██║   ██║██║  ██║██║█████╗  " + CYAN_F + NEGRITA + " ║" + RESET);
	            System.out.println(CYAN_F + NEGRITA + "  ║  " + ROJO_F     + NEGRITA + " ██╔══╝  ██║   ██║██║   ██║██║  ██║██║██╔══╝  " + CYAN_F + NEGRITA + " ║" + RESET);
	            System.out.println(CYAN_F + NEGRITA + "  ║  " + MORADO_F   + NEGRITA + " ██║     ╚██████╔╝╚██████╔╝██████╔╝██║███████╗" + CYAN_F + NEGRITA + " ║" + RESET);
	            System.out.println(CYAN_F + NEGRITA + "  ║  " + MORADO_F   + NEGRITA + " ╚═╝      ╚═════╝  ╚═════╝ ╚═════╝ ╚═╝╚══════╝" + CYAN_F + NEGRITA + "║" + RESET);
	            System.out.println(CYAN_F + NEGRITA + "  ║                                          ║" + RESET);
	            System.out.println(CYAN_F + NEGRITA + "  ╠══════════════════════════════════════════╣" + RESET);
	            System.out.println(CYAN_F + NEGRITA + "  ║                                          ║" + RESET);
	            System.out.println(CYAN_F + NEGRITA + "  ║   " + VERDE_F   + NEGRITA + "🎮   1.   J U G A R                    " + CYAN_F + NEGRITA + "║" + RESET);
	            System.out.println(CYAN_F + NEGRITA + "  ║                                          ║" + RESET);
	            System.out.println(CYAN_F + NEGRITA + "  ║   " + AMARILLO_F+ NEGRITA + "📋   2.   V E R   M E N U              " + CYAN_F + NEGRITA + "║" + RESET);
	            System.out.println(CYAN_F + NEGRITA + "  ║                                          ║" + RESET);
	            System.out.println(CYAN_F + NEGRITA + "  ║   " + AZUL_F    + NEGRITA + "⚙️    3.   A D M I N I S T R A C I O N " + CYAN_F + NEGRITA + "║" + RESET);
	            System.out.println(CYAN_F + NEGRITA + "  ║                                          ║" + RESET);
	            System.out.println(CYAN_F + NEGRITA + "  ║   " + MORADO_F  + NEGRITA + "🏆   4.   P U N T U A C I O N E S      " + CYAN_F + NEGRITA + "║" + RESET);
	            System.out.println(CYAN_F + NEGRITA + "  ║                                          ║" + RESET);
	            System.out.println(CYAN_F + NEGRITA + "  ║   " + ROJO_F    + NEGRITA + " $   5.   M U S I C A                    " + CYAN_F + NEGRITA + "║" + RESET);
	            System.out.println(CYAN_F + NEGRITA + "  ║   " + ROJO_F    + NEGRITA + "🚪   6.   S A L I R                    " + CYAN_F + NEGRITA + "║" + RESET);
	            System.out.println(CYAN_F + NEGRITA + "  ║                                          ║" + RESET);
	            System.out.println(CYAN_F + NEGRITA + "  ╚══════════════════════════════════════════╝" + RESET);
	            System.out.println();
	            System.out.println(AMARILLO_F + NEGRITA + "  🍔  🍕  🍣  🍹  🍔  🍕  🍣  🍹  🍔  🍕" + RESET);
	            System.out.println();
	            System.out.print(CYAN_F + NEGRITA + "  👉 Elige una opcion: " + RESET);

	            try { opcion = Integer.parseInt(scanner.nextLine().trim()); }
	            catch (Exception e) { opcion = 0; }

	            switch (opcion) {
	                case 1: musicaCliente(); new Pedidos().iniciarJuego(); break;
	                case 2: verMenuComidas(); break;
	                case 3: new Administracion().inicioAdmin(); break;
	                case 4: verPuntuaciones(); break;
	                case 5: toggleMusica(); break;
	                case 6: pantallaSalida();break;
	                default:
	                    System.out.println(ROJO_F + "\n  ❌ Opcion invalida." + RESET);
	                    esperar(1000);
	            }
	        } while (opcion != 6);
	    }

	    public void verMenuComidas() {
	        limpiarPantalla();
	        System.out.println();
	        System.out.println(CYAN_F + NEGRITA + "  ╔══════════════════════════════════════════╗" + RESET);
	        System.out.println(CYAN_F + NEGRITA + "  ║       🍽️   MENU DE FOODIE   🍽️            ║" + RESET);
	        System.out.println(CYAN_F + NEGRITA + "  ╠══════════════════════════════════════════╣" + RESET);
	        System.out.println(CYAN_F + NEGRITA + "  ║  " + AMARILLO_F + "🍔  HAMBURGUESAS                        " + CYAN_F + "║" + RESET);
	        System.out.println(CYAN_F + NEGRITA + "  ║  " + BLANCO     + "    Classic Burger ............. $5.00  " + CYAN_F + "║" + RESET);
	        System.out.println(CYAN_F + NEGRITA + "  ║  " + BLANCO     + "    Double Burger .............. $7.00  " + CYAN_F + "║" + RESET);
	        System.out.println(CYAN_F + NEGRITA + "  ║  " + BLANCO     + "    BBQ Burger ................. $8.00  " + CYAN_F + "║" + RESET);
	        System.out.println(CYAN_F + NEGRITA + "  ╠══════════════════════════════════════════╣" + RESET);
	        System.out.println(CYAN_F + NEGRITA + "  ║  " + ROJO_F     + "🍕  PIZZAS                              " + CYAN_F + "║" + RESET);
	        System.out.println(CYAN_F + NEGRITA + "  ║  " + BLANCO     + "    Pizza Margarita ............ $6.00  " + CYAN_F + "║" + RESET);
	        System.out.println(CYAN_F + NEGRITA + "  ║  " + BLANCO     + "    Pizza Pepperoni ............ $8.00  " + CYAN_F + "║" + RESET);
	        System.out.println(CYAN_F + NEGRITA + "  ║  " + BLANCO     + "    Pizza Hawaiana ............. $7.50  " + CYAN_F + "║" + RESET);
	        System.out.println(CYAN_F + NEGRITA + "  ╠══════════════════════════════════════════╣" + RESET);
	        System.out.println(CYAN_F + NEGRITA + "  ║  " + VERDE_F    + "🍣  SUSHI                               " + CYAN_F + "║" + RESET);
	        System.out.println(CYAN_F + NEGRITA + "  ║  " + BLANCO     + "    Sushi Salmon ............... $9.00  " + CYAN_F + "║" + RESET);
	        System.out.println(CYAN_F + NEGRITA + "  ║  " + BLANCO     + "    Sushi Atun ................. $9.50  " + CYAN_F + "║" + RESET);
	        System.out.println(CYAN_F + NEGRITA + "  ║  " + BLANCO     + "    Sushi Mixto ............... $11.00  " + CYAN_F + "║" + RESET);
	        System.out.println(CYAN_F + NEGRITA + "  ╠══════════════════════════════════════════╣" + RESET);
	        System.out.println(CYAN_F + NEGRITA + "  ║  " + AZUL_F     + "🍹  BEBIDAS                             " + CYAN_F + "║" + RESET);
	        System.out.println(CYAN_F + NEGRITA + "  ║  " + BLANCO     + "    Refresco ................... $2.00  " + CYAN_F + "║" + RESET);
	        System.out.println(CYAN_F + NEGRITA + "  ║  " + BLANCO     + "    Jugo Natural ............... $3.00  " + CYAN_F + "║" + RESET);
	        System.out.println(CYAN_F + NEGRITA + "  ║  " + BLANCO     + "    Agua ....................... $1.00  " + CYAN_F + "║" + RESET);
	        System.out.println(CYAN_F + NEGRITA + "  ╚══════════════════════════════════════════╝" + RESET);
	        System.out.println();
	        System.out.print(AMARILLO_F + "  Presiona Enter para volver..." + RESET);
	        scanner.nextLine();
	    }

	    public void verPuntuaciones() {
	        limpiarPantalla();
	        System.out.println();
	        System.out.println(AMARILLO_F + NEGRITA + "  ╔══════════════════════════════════════════╗" + RESET);
	        System.out.println(AMARILLO_F + NEGRITA + "  ║         🏆  MEJORES SCORES  🏆            ║" + RESET);
	        System.out.println(AMARILLO_F + NEGRITA + "  ╠══════════════════════════════════════════╣" + RESET);
	        System.out.println(AMARILLO_F + NEGRITA + "  ║  " + VERDE_F + "🥇  Nivel 3 completado - 300 pts       " + AMARILLO_F + "║" + RESET);
	        System.out.println(AMARILLO_F + NEGRITA + "  ║  " + CYAN_F  + "🥈  Nivel 2 completado - 200 pts       " + AMARILLO_F + "║" + RESET);
	        System.out.println(AMARILLO_F + NEGRITA + "  ║  " + ROJO_F  + "🥉  Nivel 1 completado - 100 pts       " + AMARILLO_F + "║" + RESET);
	        System.out.println(AMARILLO_F + NEGRITA + "  ║                                          ║" + RESET);
	        System.out.println(AMARILLO_F + NEGRITA + "  ║  " + BLANCO  + "  ¡Juega para superar records!         " + AMARILLO_F + "║" + RESET);
	        System.out.println(AMARILLO_F + NEGRITA + "  ╚══════════════════════════════════════════╝" + RESET);
	        System.out.println();
	        System.out.print(AMARILLO_F + "  Presiona Enter para volver..." + RESET);
	        scanner.nextLine();
	    }

	    public void pantallaSalida() {
	        limpiarPantalla();
	        System.out.println();
	        System.out.println(ROJO_F + NEGRITA + "  ╔══════════════════════════════════════════╗" + RESET);
	        System.out.println(ROJO_F + NEGRITA + "  ║                                          ║" + RESET);
	        System.out.println(ROJO_F + NEGRITA + "  ║   👋  ¡Gracias por jugar FOODIE!  👋     ║" + RESET);
	        System.out.println(ROJO_F + NEGRITA + "  ║                                          ║" + RESET);
	        System.out.println(ROJO_F + NEGRITA + "  ║   🍔  ¡Vuelve pronto, chef!  🍔          ║" + RESET);
	        System.out.println(ROJO_F + NEGRITA + "  ║                                          ║" + RESET);
	        System.out.println(ROJO_F + NEGRITA + "  ╚══════════════════════════════════════════╝" + RESET);
	        musicaDerrota();
	        esperar(1500);
	        musicaDerrota();      // 240
	        if (sequencer != null && sequencer.isRunning()) {
	            sequencer.stop();
	            sequencer.close();
	        }
	        esperar(1500);          // después
	    }

	    public static void limpiarPantalla() {
	        for (int i = 0; i < 60; i++) System.out.println();
	    }

	    public static void esperar(int ms) {
	        try { Thread.sleep(ms); } catch (Exception e) {}
}
}

