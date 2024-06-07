package cl.praxis.model;

import java.util.ArrayList;

    public class ProductoServicio {
        private ArrayList<Producto> listaProductos = new ArrayList<Producto>();
        //private Producto producto1 = new Producto("Jean\n", "15000\n", "Es un Jean muy lindo con hermosos detalles","1500", "42", "Levis", "Azul marino");

        public ProductoServicio(ArrayList<Producto> listaProductos) {
            this.listaProductos = listaProductos;
        }
        public ProductoServicio(){

        }

        public void listarProductos() {
            if (listaProductos.isEmpty()) {
                System.out.println("La lista se encuentra vacía");
                return;
            }
            for (Producto p : listaProductos) {
                System.out.println("\n\t--------------------Producto-------------------\n");
                System.out.println("\tCodigo      : " + p.getCodigo().toString());
                System.out.println("\tArticulo    : " + p.getArticulo().toString());
                System.out.println("\tPrecio      : " + p.getPrecio().toString());
                System.out.println("\tDescripcion : " + p.getDescripcion().toString());
                System.out.println("\tTalla       : " + p.getTalla().toString());
                System.out.println("\tMarca       : " + p.getMarca().toString());
                System.out.println("\tColor       : " + p.getColor().toString());
                System.out.println("\n\t-----------------------------------------------\n");
            }
        }

        public ArrayList<Producto> getListaProductos() {
            return listaProductos;
        }

        public void setListaProductos(ArrayList<Producto> listaProductos) {
            this.listaProductos = listaProductos;
        }

        public void agregarProducto(Producto producto){
            listaProductos.add(producto);
        }
        public Producto getProductosPorCod (String codigoProductos) {
            for (Producto productos: listaProductos) {
                if (productos.getCodigo().equals(codigoProductos)) {
                    return productos;
                }
            }
            return null;
        }
        public void AgregarListaProductos(ArrayList<Producto> nuevaListaProductos) {
            this.listaProductos.addAll(nuevaListaProductos);
        }

        @Override
        public String toString() {
            return "ProductoServicio: \n" +
                    listaProductos;
        }
    }