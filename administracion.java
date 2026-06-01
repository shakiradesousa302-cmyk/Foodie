package foodieadmin;

public class administracion {
	import java.util.ArrayList;
	import java.util.Scanner;

	// Clase para crear comidas
	class Comida {

	    String nombre;
	    int puntos;

	    // Constructor
	    public Comida(String nombre, int puntos) {
	        this.nombre = nombre;
	        this.puntos = puntos;
	    }
	}

	// Clase principal
	public class foodie_administracion {

	    // Lista de comidas
	    static ArrayList<Comida> comidas =
	            new ArrayList<>();

	    public static void main(String[] args) {

	        Scanner scanner =
	                new Scanner(System.in);

	        // Comidas iniciales
	        comidas.add(
	            new Comida("🍔 Hamburguesa", 10)
	        );

	        comidas.add(
	            new Comida("🍕 Pizza", 15)
	        );

	        comidas.add(
	            new Comida("🍣 Sushi", 20)
	        );

	        // Menú principal
	        while (true) {

	            System.out.println(
	                "\n===== FOODIE GAME ====="
	            );

	            System.out.println(
	                "1. Ver comidas"
	            );

	            System.out.println(
	                "2. Administrador"
	            );

	            System.out.println(
	                "3. Salir"
	            );

	            System.out.print(
	                "Selecciona una opción: "
	            );

	            int opcion =
	                    scanner.nextInt();

	            scanner.nextLine();

	            switch (opcion) {

	                case 1:
	                    mostrarComidas();
	                    break;

	                case 2:
	                    loginAdmin(scanner);
	                    break;

	                case 3:
	                    System.out.println(
	                        "Gracias por jugar 🍔"
	                    );

	                    scanner.close();
	                    return;

	                default:
	                    System.out.println(
	                        "Opción inválida"
	                    );
	            }
	        }
	    }

	    // Mostrar comidas
	    public static void mostrarComidas() {

	        System.out.println(
	            "\n----- MENÚ DE COMIDAS -----"
	        );

	        for (Comida comida : comidas) {

	            System.out.println(
	                comida.nombre
	                + " | Puntos: "
	                + comida.puntos
	            );
	        }
	    }

	    // Login administrador
	    public static void loginAdmin(
	            Scanner scanner) {

	        System.out.print(
	            "Usuario: "
	        );

	        String usuario =
	                scanner.nextLine();

	        System.out.print(
	            "Contraseña: "
	        );

	        String password =
	                scanner.nextLine();

	        // Usuario admin
	        if (usuario.equals("admin")
	                && password.equals("1234")) {

	            System.out.println(
	                "Bienvenido Admin ✅"
	            );

	            panelAdmin(scanner);

	        } else {

	            System.out.println(
	                "Usuario o contraseña incorrectos ❌"
	            );
	        }
	    }

	    // Panel administrador
	    public static void panelAdmin(
	            Scanner scanner) {

	        while (true) {

	            System.out.println(
	                "\n===== PANEL ADMIN ====="
	            );

	            System.out.println(
	                "1. Agregar comida"
	            );

	            System.out.println(
	                "2. Ver comidas"
	            );

	            System.out.println(
	                "3. Salir"
	            );

	            System.out.print(
	                "Opción: "
	            );

	            int opcion =
	                    scanner.nextInt();

	            scanner.nextLine();

	            switch (opcion) {

	                case 1:

	                    System.out.print(
	                        "Nombre de comida: "
	                    );

	                    String nombre =
	                            scanner.nextLine();

	                    System.out.print(
	                        "Puntos: "
	                    );

	                    int puntos =
	                            scanner.nextInt();

	                    scanner.nextLine();

	                    comidas.add(
	                        new Comida(
	                            nombre,
	                            puntos
	                        )
	                    );

	                    System.out.println(
	                        "Comida agregada ✅"
	                    );

	                    break;

	                case 2:
	                    mostrarComidas();
	                    break;

	                case 3:
	                    return;

	                default:
	                    System.out.println(
	                        "Opción inválida"
	                    );
	            }
	        }
	    }
	}
	}
}
