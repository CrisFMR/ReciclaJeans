package cl.praxis.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class ArchivoServicio {
    Scanner scanner = new Scanner(System.in);

    public String rutaImportarCsv() {
        String ruta = "";
        String sistemaOperativo = System.getProperty("os.name").toLowerCase();

        if (sistemaOperativo.contains("win")) {
            System.out.println("========Cargar Datos en Windows======");
            System.out.println("Ingresa la ruta en donde se encuentra el archivo ProductosImportados.csv (Ej: C:/Users/QWERY/Documents...)");
            System.out.println();
            ruta = scanner.nextLine();
        }

        return ruta;

    }
    public ArrayList<Producto> cargarDatos(String filePath) {
        ArrayList<Producto> listaProductos = new ArrayList<Producto>();
        try{
            FileReader fileReader = new FileReader(filePath+"/"+"ProductosImportados.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String productoCsv;
            while ((productoCsv = bufferedReader.readLine())!= null) {
                String[] productoArray = productoCsv.split(",");

                Producto nProducto = new Producto(productoArray[0],productoArray[1], productoArray[2],productoArray[3], productoArray[4], productoArray[5], productoArray[6]);
                listaProductos.add(nProducto);

            }
            bufferedReader.close();
            System.out.println(listaProductos);
            System.out.println("Datos cargados correctamente en la lista\n");

        }
        catch(Exception e){
            System.out.println("Error al cargar datos");
        }

        return listaProductos;


    }


}