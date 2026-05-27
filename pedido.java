package foodieservicion;

public class pedido {
	// ── Atributos: los datos que guarda cada pedido ──
    private int numeroMesa;
    private String[] platos;
    private double[] precios;
    private int cantidadPlatos;
    private String estado;

    // ── Constructor: se ejecuta cuando creamos un pedido nuevo ──
    public Pedido(int numeroMesa) {
        this.numeroMesa     = numeroMesa;
        this.platos         = new String[10];
        this.precios        = new double[10];
        this.cantidadPlatos = 0;
        this.estado         = "PENDIENTE";
    }

    // ── Agrega un plato al pedido ──
    public void agregarPlato(String nombre, double precio) {
        if (cantidadPlatos < 10) {
            platos[cantidadPlatos]  = nombre;
            precios[cantidadPlatos] = precio;
            cantidadPlatos++;
        } else {
            System.out.println("⚠️ Máximo 10 platos por pedido.");
        }
    }

    // ── Suma todos los precios y devuelve el total ──
    public double calcularTotal() {
        double total = 0;
        for (int i = 0; i < cantidadPlatos; i++) {
            total += precios[i];
        }
        return total;
    }

    // ── Muestra el detalle completo del pedido ──
    public void mostrarDetalle() {
        System.out.println("┌─────────────────────────────┐");
        System.out.println("│  Mesa: " + numeroMesa + 
                           "  |  Estado: " + estado);
        System.out.println("├─────────────────────────────┤");
        for (int i = 0; i < cantidadPlatos; i++) {
            System.out.println("│  " + platos[i] + 
                               "  -  $" + precios[i]);
        }
        System.out.println("├─────────────────────────────┤");
        System.out.println("│  TOTAL: $" + calcularTotal());
        System.out.println("└─────────────────────────────┘");
    }

    // ── Getters y Setters ──
    public int    getNumeroMesa()      { return numeroMesa; }
    public String getEstado()          { return estado; }
    public void   setEstado(String e)  { this.estado = e; }
}
}
