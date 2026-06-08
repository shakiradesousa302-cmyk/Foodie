package foodie;
import java.util.Random;
import java.util.Scanner;

public class Pedidos {
	


	    Scanner scanner = new Scanner(System.in);
	    Random random = new Random();

	    // ══════════════════════════════════════
	    //        PRODUCTOS DEL RESTAURANTE
	    // ══════════════════════════════════════
	    String[] productos = {
	        "Classic Burger", "Double Burger", "BBQ Burger",
	        "Pizza Margarita", "Pizza Pepperoni", "Pizza Hawaiana",
	        "Sushi Salmon", "Sushi Atun", "Sushi Mixto",
	        "Refresco", "Jugo Natural", "Agua"
	    };

	    String[] emojis = {
	        "🍔", "🍔", "🍔",
	        "🍕", "🍕", "🍕",
	        "🍣", "🍣", "🍣",
	        "🍹", "🍹", "💧"
	    };

	    double[] precios = {
	        5.00, 7.00, 8.00,
	        6.00, 8.00, 7.50,
	        9.00, 9.50, 11.00,
	        2.00, 3.00, 1.00
	    };

	    // ══════════════════════════════════════
	    //        VARIABLES DEL JUEGO
	    // ══════════════════════════════════════
	    int puntos = 0;
	    int vidas = 3;
	    int nivel = 1;
	    int clientesAtendidos = 0;
	    int clientesPorNivel = 5;

	    // ══════════════════════════════════════
	    //        NOMBRES DE CLIENTES
	    // ══════════════════════════════════════
	    String[] nombresClientes = {
	        "Carlos", "Maria", "Pedro", "Ana", "Luis",
	        "Sofia", "Diego", "Valentina", "Miguel", "Camila",
	        "Andrés", "Isabella", "Jorge", "Lucia", "Roberto"
	    };

	    String[] estadosCliente = {
	        "😊 Feliz", "😐 Normal", "😤 Apurado", "🤩 Emocionado", "😴 Cansado"
	    };

	    // ══════════════════════════════════════
	    //        INICIO DEL JUEGO
	    // ══════════════════════════════════════
	    public void iniciarJuego() {
	        puntos = 0;
	        vidas = 3;
	        nivel = 1;
	        clientesAtendidos = 0;

	        pantallaInstrucciones();

	        boolean jugando = true;
	        while (jugando && vidas > 0) {
	            jugando = jugarNivel();
	            if (jugando && vidas > 0) {
	            	  nivel++;   
	            	  if(nivel<=3) {
	            		  pantallaSiguienteNivel();
	            	  }
	                
	               
	            }
	            if (nivel > 3) {
	                pantallaVictoria();
	                return;
	            }
	        }

	        if (vidas <= 0) {
	            pantallaGameOver();
	        }
	    }

	    // ══════════════════════════════════════
	    //        INSTRUCCIONES
	    // ══════════════════════════════════════
	    public void pantallaInstrucciones() {
	        MenuPrincipal.limpiarPantalla();
	        System.out.println();
	        System.out.println(MenuPrincipal.CYAN_F + MenuPrincipal.NEGRITA + "  ╔══════════════════════════════════════════╗" + MenuPrincipal.RESET);
	        System.out.println(MenuPrincipal.CYAN_F + MenuPrincipal.NEGRITA + "  ║       📖  COMO JUGAR  📖                  ║" + MenuPrincipal.RESET);
	        System.out.println(MenuPrincipal.CYAN_F + MenuPrincipal.NEGRITA + "  ╠══════════════════════════════════════════╣" + MenuPrincipal.RESET);
	        System.out.println(MenuPrincipal.CYAN_F + MenuPrincipal.NEGRITA + "  ║  " + MenuPrincipal.AMARILLO_F + "🧑 Llegarán clientes con pedidos         " + MenuPrincipal.CYAN_F + "║" + MenuPrincipal.RESET);
	        System.out.println(MenuPrincipal.CYAN_F + MenuPrincipal.NEGRITA + "  ║  " + MenuPrincipal.VERDE_F   + "⏱️  Tienes tiempo limitado para atender  " + MenuPrincipal.CYAN_F + "║" + MenuPrincipal.RESET);
	        System.out.println(MenuPrincipal.CYAN_F + MenuPrincipal.NEGRITA + "  ║  " + MenuPrincipal.ROJO_F    + "❤️  Tienes 3 vidas, no las pierdas!      " + MenuPrincipal.CYAN_F + "║" + MenuPrincipal.RESET);
	        System.out.println(MenuPrincipal.CYAN_F + MenuPrincipal.NEGRITA + "  ║  " + MenuPrincipal.MORADO_F  + "⭐ Gana puntos por cada cliente feliz    " + MenuPrincipal.CYAN_F + "║" + MenuPrincipal.RESET);
	        System.out.println(MenuPrincipal.CYAN_F + MenuPrincipal.NEGRITA + "  ║  " + MenuPrincipal.AZUL_F    + "🎯 Completa 5 clientes por nivel         " + MenuPrincipal.CYAN_F + "║" + MenuPrincipal.RESET);
	        System.out.println(MenuPrincipal.CYAN_F + MenuPrincipal.NEGRITA + "  ║  " + MenuPrincipal.CYAN_F    + "🏆 Hay 3 niveles de dificultad           " + MenuPrincipal.CYAN_F + "║" + MenuPrincipal.RESET);
	        System.out.println(MenuPrincipal.CYAN_F + MenuPrincipal.NEGRITA + "  ╚══════════════════════════════════════════╝" + MenuPrincipal.RESET);
	        System.out.println();
	        System.out.print(MenuPrincipal.AMARILLO_F + "  ¡Presiona Enter para empezar! 🚀 " + MenuPrincipal.RESET);
	        scanner.nextLine();
	    }

	    // ══════════════════════════════════════
	    //        JUGAR UN NIVEL
	    // ══════════════════════════════════════
	    public boolean jugarNivel() {
	        int clientesNivel = 0;

	        while (clientesNivel < clientesPorNivel && vidas > 0) {
	            // Generar cliente aleatorio
	            String nombreCliente = nombresClientes[random.nextInt(nombresClientes.length)];
	            String estadoCliente = estadosCliente[random.nextInt(estadosCliente.length)];

	            // Generar pedido aleatorio (1 o 2 productos según nivel)
	            int numProductos = (nivel >= 2) ? (random.nextInt(2) + 1) : 1;
	            int[] pedidoIdx = new int[numProductos];
	            for (int i = 0; i < numProductos; i++) {
	                pedidoIdx[i] = random.nextInt(productos.length);
	            }

	            // Tiempo según nivel
	            int tiempoSegundos = (nivel == 1) ? 20 : (nivel == 2) ? 15 : 10;

	            // Mostrar cliente
	            mostrarCliente(nombreCliente, estadoCliente, pedidoIdx, tiempoSegundos);

	            // Esperar respuesta con tiempo
	            boolean correcto = esperarRespuesta(pedidoIdx, tiempoSegundos);

	            if (correcto) {
	                mostrarExito(nombreCliente, pedidoIdx);
	                puntos += 100 * nivel;
	                clientesAtendidos++;
	                clientesNivel++;
	                MenuPrincipal.musicaVictoria();
	            } else {
	                mostrarFallo(nombreCliente);
	                vidas--;
	                MenuPrincipal.musicaDerrota();
	                if (vidas <= 0) return false;
	            }

	            MenuPrincipal.esperar(1500);
	        }
	        return true;
	    }

	    // ══════════════════════════════════════
	    //        MOSTRAR CLIENTE
	    // ══════════════════════════════════════
	    public void mostrarCliente(String nombre, String estado, int[] pedidoIdx, int tiempo) {
	        MenuPrincipal.limpiarPantalla();
	        System.out.println();

	        // HUD - Vidas, Nivel, Puntos
	        mostrarHUD();

	        System.out.println(MenuPrincipal.AMARILLO_F + MenuPrincipal.NEGRITA +
	            "  ╔══════════════════════════════════════════╗" + MenuPrincipal.RESET);
	        System.out.println(MenuPrincipal.AMARILLO_F + MenuPrincipal.NEGRITA +
	            "  ║   🧑‍💼  ¡NUEVO CLIENTE!  🧑‍💼               ║" + MenuPrincipal.RESET);
	        System.out.println(MenuPrincipal.AMARILLO_F + MenuPrincipal.NEGRITA +
	            "  ╠══════════════════════════════════════════╣" + MenuPrincipal.RESET);
	        System.out.printf(MenuPrincipal.AMARILLO_F + MenuPrincipal.NEGRITA +
	            "  ║  👤  Cliente: %-27s║%n" + MenuPrincipal.RESET, nombre);
	        System.out.printf(MenuPrincipal.AMARILLO_F + MenuPrincipal.NEGRITA +
	            "  ║  😊  Estado:  %-27s║%n" + MenuPrincipal.RESET, estado);
	        System.out.println(MenuPrincipal.AMARILLO_F + MenuPrincipal.NEGRITA +
	            "  ╠══════════════════════════════════════════╣" + MenuPrincipal.RESET);
	        System.out.println(MenuPrincipal.AMARILLO_F + MenuPrincipal.NEGRITA +
	            "  ║  📋  PIDE:                               ║" + MenuPrincipal.RESET);

	        for (int i = 0; i < pedidoIdx.length; i++) {
	            System.out.printf(MenuPrincipal.VERDE_F + MenuPrincipal.NEGRITA +
	                "  ║    %s  %-36s║%n" + MenuPrincipal.RESET,
	                emojis[pedidoIdx[i]], productos[pedidoIdx[i]]);
	        }

	        System.out.printf(MenuPrincipal.ROJO_F + MenuPrincipal.NEGRITA +
	            "  ║  ⏱️  TIEMPO: %-3d segundos                 ║%n" + MenuPrincipal.RESET, tiempo);
	        System.out.println(MenuPrincipal.AMARILLO_F + MenuPrincipal.NEGRITA +
	            "  ╚══════════════════════════════════════════╝" + MenuPrincipal.RESET);

	        System.out.println();
	        System.out.println(MenuPrincipal.CYAN_F + MenuPrincipal.NEGRITA + "  ┌──────────────────────────────────────────┐" + MenuPrincipal.RESET);
	        System.out.println(MenuPrincipal.CYAN_F + MenuPrincipal.NEGRITA + "  │         🍽️  PRODUCTOS DISPONIBLES         │" + MenuPrincipal.RESET);
	        System.out.println(MenuPrincipal.CYAN_F + MenuPrincipal.NEGRITA + "  ├──────────────────────────────────────────┤" + MenuPrincipal.RESET);

	        for (int i = 0; i < productos.length; i++) {
	            System.out.printf(MenuPrincipal.CYAN_F + "  │  " + MenuPrincipal.BLANCO + "%2d. %s %-30s" + MenuPrincipal.CYAN_F + "│%n" + MenuPrincipal.RESET,
	                (i + 1), emojis[i], productos[i]);
	        }

	        System.out.println(MenuPrincipal.CYAN_F + MenuPrincipal.NEGRITA + "  └──────────────────────────────────────────┘" + MenuPrincipal.RESET);
	        System.out.println();

	        if (pedidoIdx.length == 1) {
	            System.out.print(MenuPrincipal.MORADO_F + MenuPrincipal.NEGRITA +
	                "  👨‍🍳 ¿Qué producto entregas? (número): " + MenuPrincipal.RESET);
	        } else {
	            System.out.print(MenuPrincipal.MORADO_F + MenuPrincipal.NEGRITA +
	                "  👨‍🍳 ¿Qué productos entregas? (ej: 1,4): " + MenuPrincipal.RESET);
	        }

	        MenuPrincipal.musicaCliente();
	    }

	    // ══════════════════════════════════════
	    //        ESPERAR RESPUESTA CON TIEMPO
	    // ══════════════════════════════════════
	    public boolean esperarRespuesta(int[] pedidoIdx, int tiempoSegundos) {
	        long inicio = System.currentTimeMillis();
	        long limite = tiempoSegundos * 1000L;

	        // Hilo para mostrar tiempo restante
	        final boolean[] tiempoAgotado = {false};
	        Thread timerThread = new Thread(() -> {
	            while (!tiempoAgotado[0]) {
	                long transcurrido = System.currentTimeMillis() - inicio;
	                long restante = (limite - transcurrido) / 1000;
	                if (transcurrido >= limite) {
	                    tiempoAgotado[0] = true;
	                    System.out.println(MenuPrincipal.ROJO_F + "\n\n  ⏰ ¡TIEMPO AGOTADO!" + MenuPrincipal.RESET);
	                    break;
	                }
	                MenuPrincipal.esperar(1000);
	            }
	        });
	        timerThread.setDaemon(true);
	        timerThread.start();

	        String respuesta = "";
	        try {
	            respuesta = scanner.nextLine().trim();
	        } catch (Exception e) {
	            return false;
	        }

	        long transcurrido = System.currentTimeMillis() - inicio;
	        if (transcurrido >= limite) return false;

	        tiempoAgotado[0] = true;

	        // Verificar respuesta
	        try {
	            String[] partes = respuesta.split(",");
	            if (partes.length != pedidoIdx.length) return false;

	            int[] respuestas = new int[partes.length];
	            for (int i = 0; i < partes.length; i++) {
	                respuestas[i] = Integer.parseInt(partes[i].trim()) - 1;
	            }

	            // Verificar que coincidan los productos (en cualquier orden)
	            boolean[] usados = new boolean[pedidoIdx.length];
	            for (int r : respuestas) {
	                boolean encontrado = false;
	                for (int j = 0; j < pedidoIdx.length; j++) {
	                    if (!usados[j] && pedidoIdx[j] == r) {
	                        usados[j] = true;
	                        encontrado = true;
	                        break;
	                    }
	                }
	                if (!encontrado) return false;
	            }
	            return true;
	        } catch (Exception e) {
	            return false;
	        }
	    }

	    // ══════════════════════════════════════
	    //        HUD DEL JUEGO
	    // ══════════════════════════════════════
	    public void mostrarHUD() {
	        String vidasStr = "";
	        for (int i = 0; i < vidas; i++) vidasStr += "❤️ ";
	        for (int i = vidas; i < 3; i++) vidasStr += "🖤 ";

	        System.out.println(MenuPrincipal.MORADO_F + MenuPrincipal.NEGRITA +
	            "  ┌──────────────────────────────────────────┐" + MenuPrincipal.RESET);
	        System.out.printf(MenuPrincipal.MORADO_F + MenuPrincipal.NEGRITA +
	            "  │  %s  " + MenuPrincipal.AMARILLO_F + "NIVEL: %d  " +
	            MenuPrincipal.VERDE_F + "PUNTOS: %-6d  " +
	            MenuPrincipal.CYAN_F + "CLIENTES: %d/%d  " +
	            MenuPrincipal.MORADO_F + "│%n" + MenuPrincipal.RESET,
	            vidasStr, nivel, puntos, clientesAtendidos, clientesPorNivel * nivel);
	        System.out.println(MenuPrincipal.MORADO_F + MenuPrincipal.NEGRITA +
	            "  └──────────────────────────────────────────┘" + MenuPrincipal.RESET);
	        System.out.println();
	    }

	    // ══════════════════════════════════════
	    //        PANTALLAS DE RESULTADO
	    // ══════════════════════════════════════
	    public void mostrarExito(String nombre, int[] pedidoIdx) {
	        MenuPrincipal.limpiarPantalla();
	        System.out.println();
	        System.out.println(MenuPrincipal.VERDE_F + MenuPrincipal.NEGRITA + "  ╔══════════════════════════════════════════╗" + MenuPrincipal.RESET);
	        System.out.println(MenuPrincipal.VERDE_F + MenuPrincipal.NEGRITA + "  ║   ✅  ¡PEDIDO CORRECTO!  ✅               ║" + MenuPrincipal.RESET);
	        System.out.println(MenuPrincipal.VERDE_F + MenuPrincipal.NEGRITA + "  ╠══════════════════════════════════════════╣" + MenuPrincipal.RESET);
	        System.out.printf(MenuPrincipal.VERDE_F + MenuPrincipal.NEGRITA  + "  ║  😊 %s dice: ¡Muchas gracias!%-10s║%n" + MenuPrincipal.RESET, nombre, "");
	        System.out.printf(MenuPrincipal.AMARILLO_F + MenuPrincipal.NEGRITA + "  ║  ⭐ +%d puntos ganados!%-20s║%n" + MenuPrincipal.RESET, 100 * nivel, "");
	        System.out.println(MenuPrincipal.VERDE_F + MenuPrincipal.NEGRITA + "  ╚══════════════════════════════════════════╝" + MenuPrincipal.RESET);
	    }

	    public void mostrarFallo(String nombre) {
	        MenuPrincipal.limpiarPantalla();
	        System.out.println();
	        System.out.println(MenuPrincipal.ROJO_F + MenuPrincipal.NEGRITA + "  ╔══════════════════════════════════════════╗" + MenuPrincipal.RESET);
	        System.out.println(MenuPrincipal.ROJO_F + MenuPrincipal.NEGRITA + "  ║   ❌  ¡PEDIDO INCORRECTO!  ❌             ║" + MenuPrincipal.RESET);
	        System.out.println(MenuPrincipal.ROJO_F + MenuPrincipal.NEGRITA + "  ╠══════════════════════════════════════════╣" + MenuPrincipal.RESET);
	        System.out.printf(MenuPrincipal.ROJO_F + MenuPrincipal.NEGRITA   + "  ║  😡 %s se fue enojado!%-16s║%n" + MenuPrincipal.RESET, nombre, "");
	        System.out.printf(MenuPrincipal.AMARILLO_F + MenuPrincipal.NEGRITA + "  ║  💔 Perdiste una vida! Vidas: %-11s║%n" + MenuPrincipal.RESET, vidasStr());
	        System.out.println(MenuPrincipal.ROJO_F + MenuPrincipal.NEGRITA + "  ╚══════════════════════════════════════════╝" + MenuPrincipal.RESET);
	    }

	    public String vidasStr() {
	        String v = "";
	        for (int i = 0; i < vidas - 1; i++) v += "❤️";
	        for (int i = vidas - 1; i < 3; i++) v += "🖤";
	        return v;
	    }

	    public void pantallaSiguienteNivel() {
	        MenuPrincipal.limpiarPantalla();
	        System.out.println();
	        System.out.println(MenuPrincipal.MORADO_F + MenuPrincipal.NEGRITA + "  ╔══════════════════════════════════════════╗" + MenuPrincipal.RESET);
	        System.out.println(MenuPrincipal.MORADO_F + MenuPrincipal.NEGRITA + "  ║   🎉  ¡NIVEL COMPLETADO!  🎉             ║" + MenuPrincipal.RESET);
	        System.out.println(MenuPrincipal.MORADO_F + MenuPrincipal.NEGRITA + "  ╠══════════════════════════════════════════╣" + MenuPrincipal.RESET);
	        System.out.printf(MenuPrincipal.AMARILLO_F + MenuPrincipal.NEGRITA + "  ║  ⭐ Puntos actuales: %-21d║%n" + MenuPrincipal.RESET, puntos);
	        System.out.printf(MenuPrincipal.CYAN_F + MenuPrincipal.NEGRITA     + "  ║  🚀 Siguiente nivel: %-21d║%n" + MenuPrincipal.RESET, nivel 
	        		);
	        System.out.println(MenuPrincipal.ROJO_F + MenuPrincipal.NEGRITA    + "  ║  ⚡ ¡El tiempo será menor!               ║" + MenuPrincipal.RESET);
	        System.out.println(MenuPrincipal.MORADO_F + MenuPrincipal.NEGRITA + "  ╚══════════════════════════════════════════╝" + MenuPrincipal.RESET);
	        MenuPrincipal.musicaVictoria();
	        System.out.println();
	        System.out.print(MenuPrincipal.AMARILLO_F + "  Presiona Enter para continuar..." + MenuPrincipal.RESET);
	        scanner.nextLine(); 
	    }

	    public void pantallaVictoria() {
	        MenuPrincipal.limpiarPantalla();
	        System.out.println();
	        System.out.println(MenuPrincipal.AMARILLO_F + MenuPrincipal.NEGRITA + "  ╔══════════════════════════════════════════╗" + MenuPrincipal.RESET);
	        System.out.println(MenuPrincipal.AMARILLO_F + MenuPrincipal.NEGRITA + "  ║                                          ║" + MenuPrincipal.RESET);
	        System.out.println(MenuPrincipal.AMARILLO_F + MenuPrincipal.NEGRITA + "  ║   🏆  ¡¡¡GANASTE!!!  🏆                  ║" + MenuPrincipal.RESET);
	        System.out.println(MenuPrincipal.AMARILLO_F + MenuPrincipal.NEGRITA + "  ║                                          ║" + MenuPrincipal.RESET);
	        System.out.println(MenuPrincipal.AMARILLO_F + MenuPrincipal.NEGRITA + "  ║   🎉 ¡Completaste los 3 niveles!  🎉     ║" + MenuPrincipal.RESET);
	        System.out.printf(MenuPrincipal.VERDE_F + MenuPrincipal.NEGRITA     + "  ║   ⭐ Puntuacion final: %-18d║%n" + MenuPrincipal.RESET, puntos);
	        System.out.printf(MenuPrincipal.CYAN_F + MenuPrincipal.NEGRITA      + "  ║   🍔 Clientes atendidos: %-15d║%n" + MenuPrincipal.RESET, clientesAtendidos);
	        System.out.println(MenuPrincipal.AMARILLO_F + MenuPrincipal.NEGRITA + "  ║                                          ║" + MenuPrincipal.RESET);
	        System.out.println(MenuPrincipal.AMARILLO_F + MenuPrincipal.NEGRITA + "  ║   👨‍🍳 ¡Eres el mejor chef de FOODIE!     ║" + MenuPrincipal.RESET);
	        System.out.println(MenuPrincipal.AMARILLO_F + MenuPrincipal.NEGRITA + "  ║                                          ║" + MenuPrincipal.RESET);
	        System.out.println(MenuPrincipal.AMARILLO_F + MenuPrincipal.NEGRITA + "  ╚══════════════════════════════════════════╝" + MenuPrincipal.RESET);
	        MenuPrincipal.musicaVictoria();
	        MenuPrincipal.esperar(500);
	        MenuPrincipal.musicaVictoria();
	        System.out.println();
	        System.out.print(MenuPrincipal.AMARILLO_F + "  Presiona Enter para volver al menú..." + MenuPrincipal.RESET);
	        scanner.nextLine();
	    }

	    public void pantallaGameOver() {
	        MenuPrincipal.limpiarPantalla();
	        System.out.println();
	        System.out.println(MenuPrincipal.ROJO_F + MenuPrincipal.NEGRITA + "  ╔══════════════════════════════════════════╗" + MenuPrincipal.RESET);
	        System.out.println(MenuPrincipal.ROJO_F + MenuPrincipal.NEGRITA + "  ║                                          ║" + MenuPrincipal.RESET);
	        System.out.println(MenuPrincipal.ROJO_F + MenuPrincipal.NEGRITA + "  ║        💀  GAME OVER  💀                  ║" + MenuPrincipal.RESET);
	        System.out.println(MenuPrincipal.ROJO_F + MenuPrincipal.NEGRITA + "  ║                                          ║" + MenuPrincipal.RESET);
	        System.out.println(MenuPrincipal.ROJO_F + MenuPrincipal.NEGRITA + "  ║   ¡Se te acabaron las vidas!             ║" + MenuPrincipal.RESET);
	        System.out.printf(MenuPrincipal.AMARILLO_F + MenuPrincipal.NEGRITA + "  ║   Puntos obtenidos: %-20d║%n" + MenuPrincipal.RESET, puntos);
	        System.out.printf(MenuPrincipal.CYAN_F + MenuPrincipal.NEGRITA     + "  ║   Llegaste al nivel: %-19d║%n" + MenuPrincipal.RESET, nivel);
	        System.out.println(MenuPrincipal.ROJO_F + MenuPrincipal.NEGRITA + "  ║                                          ║" + MenuPrincipal.RESET);
	        System.out.println(MenuPrincipal.ROJO_F + MenuPrincipal.NEGRITA + "  ║   ¡Intenta de nuevo!  💪                 ║" + MenuPrincipal.RESET);
	        System.out.println(MenuPrincipal.ROJO_F + MenuPrincipal.NEGRITA + "  ║                                          ║" + MenuPrincipal.RESET);
	        System.out.println(MenuPrincipal.ROJO_F + MenuPrincipal.NEGRITA + "  ╚══════════════════════════════════════════╝" + MenuPrincipal.RESET);
	        MenuPrincipal.musicaDerrota();
	        System.out.println();
	        System.out.print(MenuPrincipal.ROJO_F + "  Presiona Enter para volver al menú..." + MenuPrincipal.RESET);
	        scanner.nextLine();
	    }
}
