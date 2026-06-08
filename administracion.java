package foodie;
import java.util.Scanner;
public class Administracion {
	   Scanner scanner = new Scanner(System.in);
	   //Este codigo es la base de un sistema de administraccion para un restaurante  llamando Foodie donde se almacena los productos, sus precios y una clave para acceder al sistema 
	    String clave = "foodie123";

	    String[] nombres = {
	        "Classic Burger", "Double Burger", "BBQ Burger",
	        "Pizza Margarita", "Pizza Pepperoni", "Pizza Hawaiana",
	        "Sushi Salmon", "Sushi Atun", "Sushi Mixto",
	        "Refresco", "Jugo Natural", "Agua"
	    };

	   
	  
	    

	    double[] precios = {
	        5.00, 7.00, 8.00,
	        6.00, 8.00, 7.50,
	        9.00, 9.50, 11.00,
	        2.00, 3.00, 1.00
	    };

	    boolean[] disponible = new boolean[12];

	    public Administracion() {
	        for (int i = 0; i < disponible.length; i++) disponible[i] = true;
	    }

	    public void inicioAdmin() {
	        if (!verificarClave()) return;

	        int opcion = 0;
	        do {
	            MenuPrincipal.limpiarPantalla();
	            System.out.println();
	            System.out.println(MenuPrincipal.AZUL_F + MenuPrincipal.NEGRITA + "  ╔══════════════════════════════════════════╗" + MenuPrincipal.RESET);
	            System.out.println(MenuPrincipal.AZUL_F + MenuPrincipal.NEGRITA + "  ║           PANEL DE ADMINISTRACION        ║" + MenuPrincipal.RESET);
	            System.out.println(MenuPrincipal.AZUL_F + MenuPrincipal.NEGRITA + "  ╠══════════════════════════════════════════╣" + MenuPrincipal.RESET);
	            System.out.println(MenuPrincipal.AZUL_F + MenuPrincipal.NEGRITA + "  ║  " + MenuPrincipal.VERDE_F    + "      1.  Ver todos los productos       " + MenuPrincipal.AZUL_F + "║" + MenuPrincipal.RESET);
	            System.out.println(MenuPrincipal.AZUL_F + MenuPrincipal.NEGRITA + "  ║  " + MenuPrincipal.AMARILLO_F + "      2.  Cambiar precio                " + MenuPrincipal.AZUL_F + "║" + MenuPrincipal.RESET);
	            System.out.println(MenuPrincipal.AZUL_F + MenuPrincipal.NEGRITA + "  ║  " + MenuPrincipal.CYAN_F     + "      3.  Cambiar nombre               " + MenuPrincipal.AZUL_F + "║" + MenuPrincipal.RESET);
	            System.out.println(MenuPrincipal.AZUL_F + MenuPrincipal.NEGRITA + "  ║  " + MenuPrincipal.MORADO_F   + "      4.  Activar/Desactivar producto  " + MenuPrincipal.AZUL_F + "║" + MenuPrincipal.RESET);
	            System.out.println(MenuPrincipal.AZUL_F + MenuPrincipal.NEGRITA + "  ║  " + MenuPrincipal.ROJO_F     + "      5.  Volver al menú               " + MenuPrincipal.AZUL_F + "║" + MenuPrincipal.RESET);
	            System.out.println(MenuPrincipal.AZUL_F + MenuPrincipal.NEGRITA + "  ╚══════════════════════════════════════════╝" + MenuPrincipal.RESET);
	            System.out.println();
	            System.out.print(MenuPrincipal.AMARILLO_F + MenuPrincipal.NEGRITA + "     Elige una opción: " + MenuPrincipal.RESET);

	            try { opcion = Integer.parseInt(scanner.nextLine()); }
	            catch (Exception e) { opcion = 0; }

	            switch (opcion) {
	                case 1: verProductos(); break;
	                case 2: cambiarPrecio(); break;
	                case 3: cambiarNombre(); break;
	                case 4: activarDesactivar(); break;
	                case 5: break;
	                default:
	                    System.out.println(MenuPrincipal.ROJO_F + "\n    Opción inválida." + MenuPrincipal.RESET);
	                    MenuPrincipal.esperar(1000);
	            }
	        } while (opcion != 5);
	    }

	    public boolean verificarClave() {
	        MenuPrincipal.limpiarPantalla();
	        System.out.println();
	        System.out.println(MenuPrincipal.ROJO_F + MenuPrincipal.NEGRITA + "  ╔══════════════════════════════════════════╗" + MenuPrincipal.RESET);
	        System.out.println(MenuPrincipal.ROJO_F + MenuPrincipal.NEGRITA + "  ║          ACCESO RESTRINGIDO              ║" + MenuPrincipal.RESET);
	        System.out.println(MenuPrincipal.ROJO_F + MenuPrincipal.NEGRITA + "  ║      Solo para administradores           ║" + MenuPrincipal.RESET);
	        System.out.println(MenuPrincipal.ROJO_F + MenuPrincipal.NEGRITA + "  ╚══════════════════════════════════════════╝" + MenuPrincipal.RESET);
	        System.out.print(MenuPrincipal.AMARILLO_F + "\n     Ingresa la clave: " + MenuPrincipal.RESET);
	        String intento = scanner.nextLine();

	        if (intento.equals(clave)) {
	            System.out.println(MenuPrincipal.VERDE_F + "\n    ¡Acceso concedido! Bienvenido admin." + MenuPrincipal.RESET);
	            MenuPrincipal.esperar(1000);
	            return true;
	        } else {
	            System.out.println(MenuPrincipal.ROJO_F + "\n    Clave incorrecta. Acceso denegado." + MenuPrincipal.RESET);
	            MenuPrincipal.esperar(1500);
	            return false;
	        }
	    }

	    public void verProductos() {
	        MenuPrincipal.limpiarPantalla();
	        System.out.println();
	        System.out.println(MenuPrincipal.VERDE_F + MenuPrincipal.NEGRITA + "  ╔══════════════════════════════════════════╗" + MenuPrincipal.RESET);
	        System.out.println(MenuPrincipal.VERDE_F + MenuPrincipal.NEGRITA + "  ║           TODOS LOS PRODUCTOS            ║" + MenuPrincipal.RESET);
	        System.out.println(MenuPrincipal.VERDE_F + MenuPrincipal.NEGRITA + "  ╠══════════════════════════════════════════╣" + MenuPrincipal.RESET);
	        for (int i = 0; i < nombres.length; i++) {
	            String estado = disponible[i] ? MenuPrincipal.VERDE_F + " !" : MenuPrincipal.ROJO_F + " ¡";
	            System.out.printf(MenuPrincipal.VERDE_F + "  ║  " + MenuPrincipal.BLANCO + "%2d.  %-22s $%5.2f  %s  " + MenuPrincipal.VERDE_F + "║%n" + MenuPrincipal.RESET,
	                (i + 1), nombres[i], precios[i], estado);
	        }
	        System.out.println(MenuPrincipal.VERDE_F + MenuPrincipal.NEGRITA + "  ╚══════════════════════════════════════════╝" + MenuPrincipal.RESET);
	        System.out.print(MenuPrincipal.AMARILLO_F + "\n  Presiona Enter para continuar..." + MenuPrincipal.RESET);
	        scanner.nextLine();
	    }

	    public void cambiarPrecio() {
	        verProductos();
	        System.out.print(MenuPrincipal.CYAN_F + "\n  ¿Qué producto modificar? (1-12): " + MenuPrincipal.RESET);
	        int idx;
	        try { idx = Integer.parseInt(scanner.nextLine()) - 1; }
	        catch (Exception e) { idx = -1; }

	        if (idx >= 0 && idx < nombres.length) {
	            System.out.printf(MenuPrincipal.CYAN_F + "  Precio actual: $%.2f%n" + MenuPrincipal.RESET, precios[idx]);
	            System.out.print(MenuPrincipal.CYAN_F + "  Nuevo precio: $" + MenuPrincipal.RESET);
	            try {
	                double np = Double.parseDouble(scanner.nextLine());
	                if (np > 0) {
	                    precios[idx] = np;
	                    System.out.println(MenuPrincipal.VERDE_F + "\n    Precio actualizado!" + MenuPrincipal.RESET);
	                }
	            } catch (Exception e) {
	                System.out.println(MenuPrincipal.ROJO_F + "\n    Valor inválido." + MenuPrincipal.RESET);
	            }
	        } else {
	            System.out.println(MenuPrincipal.ROJO_F + "\n    Producto inválido." + MenuPrincipal.RESET);
	        }
	        MenuPrincipal.esperar(1200);
	    }

	    public void cambiarNombre() {
	        verProductos();
	        System.out.print(MenuPrincipal.CYAN_F + "\n  ¿Qué producto renombrar? (1-12): " + MenuPrincipal.RESET);
	        int idx;
	        try { idx = Integer.parseInt(scanner.nextLine()) - 1; }
	        catch (Exception e) { idx = -1; }

	        if (idx >= 0 && idx < nombres.length) {
	            System.out.println(MenuPrincipal.CYAN_F + "  Nombre actual: " + nombres[idx] + MenuPrincipal.RESET);
	            System.out.print(MenuPrincipal.CYAN_F + "  Nuevo nombre: " + MenuPrincipal.RESET);
	            String nn = scanner.nextLine();
	            if (!nn.isEmpty()) {
	                nombres[idx] = nn;
	                System.out.println(MenuPrincipal.VERDE_F + "\n    Nombre actualizado!" + MenuPrincipal.RESET);
	            }
	        } else {
	            System.out.println(MenuPrincipal.ROJO_F + "\n     Producto inválido." + MenuPrincipal.RESET);
	        }
	        MenuPrincipal.esperar(1200);
	    }

	    public void activarDesactivar() {
	        verProductos();
	        System.out.print(MenuPrincipal.CYAN_F + "\n  ¿Qué producto activar/desactivar? (1-12): " + MenuPrincipal.RESET);
	        int idx;
	        try { idx = Integer.parseInt(scanner.nextLine()) - 1; }
	        catch (Exception e) { idx = -1; }

	        if (idx >= 0 && idx < nombres.length) {
	            disponible[idx] = !disponible[idx];
	            String est = disponible[idx] ? MenuPrincipal.VERDE_F + "  ACTIVADO" : MenuPrincipal.ROJO_F + "  DESACTIVADO";
	            System.out.println("\n  " + est + ": " + nombres[idx] + MenuPrincipal.RESET);
	        } else {
	            System.out.println(MenuPrincipal.ROJO_F + "\n    Producto inválido." + MenuPrincipal.RESET);
	        }
	        MenuPrincipal.esperar(1200);
	    }
}