import java.io.*;

public class Archivomat {
    public int [][] leerMatriz(String ruta) {
        int[][] mat = new int[0][0];
        try {
            BufferedReader j = getBuffered(ruta);//guarda la ruta
            int l = Integer.parseInt(j.readLine());//convierte en int lo que se leyo
            int [][] matriz = new int[l][l];//crea el tamañano de la matriz
            int cont = 0;
            String fila = j.readLine();
            while(fila != null){
                String values[] = fila.split(" ");
                for(int i = 0; i<values.length; i++){
                    matriz[cont][i] = Integer.parseInt(values[i].toString());
                }
                cont++;
                fila = j.readLine();
            }
            mat = matriz;
        } catch (IOException | NumberFormatException e){
            e.printStackTrace();
        }
        return mat;
    }
    //método para buscar el archivo en la dirección que el usuario mandó
    public BufferedReader getBuffered(String link){

        FileReader leer;
        BufferedReader j = null;
        try {
            File Archivo = new File(link);
            if(!Archivo.exists()) {//condición cuando el archivo no es encontrado
                System.out.println("Archivo no encontrado");
            } else {
                leer = new FileReader(link);
                j = new BufferedReader(leer);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return j;
    }
}
