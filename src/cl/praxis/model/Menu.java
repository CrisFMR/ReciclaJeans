package cl.praxis.model;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private Scanner scanner = new Scanner(System.in);
    private ProductoServicio productoServicio = new ProductoServicio();
    private ArchivoServicio archivoServicio =new ArchivoServicio();
    private Utilidad utilidad =new Utilidad();


    public void iniciarMenu() {

        int option;
        do {
            mostrarMenuPrincipal();
            option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    utilidad.loading("Listando productos", 100);
                    System.out.println("");
                    productoServicio.listarProductos();
                    break;
                case 2:
                    menuEdit();
                    break;
                case 3:
                    String path = archivoServicio.rutaImportarCsv();
                    ArrayList<Producto> listaCargada = archivoServicio.cargarDatos(path);
                    if (!listaCargada.isEmpty()){
                        System.out.println("La lista ha sido cargada con exito");
                    }
                    productoServicio.AgregarListaProductos(listaCargada);
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida del menú.");
                    break;
            }

        }while (option != 4) ;
        utilidad.loading("Abandonando el sistema de clientes...", 150);
        System.out.println("\n");
        System.out.println("Acaba de salir del sistema");
    }

    public void mostrarMenuPrincipal(){
        System.out.println("----------------------------------------------");
        System.out.println("|<=<<BIENVENIDO A PANEL DE CONTROL V.1.0>>=>>|");
        System.out.println("----------------------------------------------\n");
        System.out.println("<<===<<MENÚ PRINCIPAL>>==>>");
        System.out.println("1. Listar productos");
        System.out.println("2. Editar datos");
        System.out.println("3. Importar datos");
        System.out.println("4. Salir");
        System.out.println("5. Limpiar");
        System.out.println("Seleccione una opción: ");
    }

    public void menuEdit(){
        int option;
        System.out.println("Ingrese (1) para editar los datos deseados");
        option = scanner.nextInt();
        switch (option) {
            case 1:
                scanner.nextLine();
                System.out.println("Ingrese código del producto:");
                String codProducto= scanner.nextLine();
                Producto producto = productoServicio.getProductosPorCod(codProducto);

                if(producto == null) {

                    System.out.println("Codigo no existe, ingrese nuevamente");
                    break;
                }
                System.out.println("\n<<===<<MENÚ DE EDICIÓN>>==>>");
                int opcion;
                do {
                    System.out.println("1-.El nombre del articulo actual es: "+ producto.getArticulo());
                    System.out.println("2-.El código del producto: "+ producto.getCodigo());
                    System.out.println("3-.El color del producto: "+ producto.getColor());
                    System.out.println("4-.La descripción del producto: " + producto.getDescripcion());
                    System.out.println("5-.La marca del producto: "+ producto.getMarca());
                    System.out.println("6-.El precio del producto: " + producto.getPrecio());
                    System.out.println("7-.La talla del producto: " + producto.getTalla());
                    System.out.println("8-. Volver al menú"+"\n");

                    System.out.println("Ingrese la opción a editar de los datos del producto: ");
                    opcion = scanner.nextInt();
                    scanner.nextLine();

                    switch (opcion) {
                        case 1:
                            System.out.println("Ingrese el nuevo nombre del producto ");
                            String newName= scanner.nextLine();
                            producto.setArticulo(newName);
                            utilidad.loading("Guardando cambios...", 150);
                            System.out.println("");
                            System.out.println("Dato Actualizado!\n");
                            break;
                        case 2:
                            System.out.println("Ingrese nuevo código del producto: ");
                            String codProduct= scanner.nextLine();
                            producto.setCodigo(codProduct);
                            utilidad.loading("Guardando cambios...", 150);
                            System.out.println("");
                            System.out.println("Dato Actualizado!\n");
                            break;
                        case 3:
                            System.out.println("Ingrese nuevo color del producto: ");
                            String newColor= scanner.nextLine();
                            producto.setColor(newColor);
                            utilidad.loading("Guardando cambios...", 150);
                            System.out.println("");
                            System.out.println("Dato Actualizado!\n");
                            break;
                        case 4:
                            System.out.println("Ingrese nueva descripción del producto: ");
                            String newDescription= scanner.nextLine();
                            producto.setDescripcion(newDescription);
                            utilidad.loading("Guardando cambios...", 150);
                            System.out.println("");
                            System.out.println("Dato Actualizado!\n");
                            break;
                        case 5:
                            System.out.println("Ingrese nueva marca del producto: ");
                            String newBrand= scanner.nextLine();
                            producto.setMarca(newBrand);
                            utilidad.loading("Guardando cambios...", 150);
                            System.out.println("");
                            System.out.println("Dato Actualizado!\n");
                            break;
                        case 6:
                            System.out.println("Ingrese nuevo precio del producto: ");
                            String newPrice= scanner.nextLine();
                            producto.setPrecio(newPrice);
                            utilidad.loading("Guardando cambios...", 150);
                            System.out.println("");
                            System.out.println("Dato Actualizado!\n");
                            break;
                        case 7:
                            System.out.println("Ingrese nueva talla del producto: ");
                            String newSize= scanner.nextLine();
                            producto.setTalla(newSize);
                            utilidad.loading("Guardando cambios...", 150);
                            System.out.println("");
                            System.out.println("Dato Actualizado!\n");
                            break;
                        case 8:
                            utilidad.loading("Regresando al menú principal", 150);
                            System.out.println("\n");
                            break;
                        default:
                            System.out.println("Opción inválida, digite nuevamente \n");
                            break;

                    }
                }while (opcion != 8);
                break;
            default:
                System.out.println("Regresando a menú");
        }

    }

}