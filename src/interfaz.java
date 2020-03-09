import java.io.File;
import java.util.Scanner;


public class interfaz {

    public static void menu() {
        Scanner s;
        File archivo = new File(System.getProperty("user.dir"));
        String ruta = archivo.getAbsolutePath()+"\\Matriz.txt";
        Archivomat a = new Archivomat();//Se ingresa una matriz predeterminada, que se guarda en los datos del programa

        int matriz1 [][] = a.leerMatriz(ruta);
        matriz mat= new matriz(matriz1);

        Scanner sm = new Scanner(System.in);
        int m = 0;
        try {
        do {
            System.out.print("\n1. Lee matriz\n"
                    + "2. Muestra matriz\n"
                    + "3. Sumar datos\n"
                    + "4. Hallar numero mayor\n"
                    + "5. Hallar numero menor\n"
                    + "6. Mostrar el mayor dato de cada fila\n"
                    + "7. Mostrar el mayor dato de cada columna\n"
                    + "8. Mostrar el dato con mayor suma de digitos por fila\n"
                    + "9. Ordenar ascendentemente por filas toda la matriz\n"
                    + "10. Ordenar cada fila descendentemente\n"
                    + "11. Numero de veces de cada dato\n"
                    + "12. Mostrar el promedio de los datos de la Tridiagonal principal\n"
                    + "13. Ordenar descendentemente por fila 1\n"
                    + "14. Intercambiar fila por columna\n"
                    + "15. Ordena ascendentemente los digitos de cada deto de la tridiagonal secundaria\n"
                    + "16.Salir\n");
            m = sm.nextInt();
            switch (m) {
                case (1):
                    s = new Scanner(System.in);
                    System.out.println("Ingrese la ruta del archivo:");
                    ruta = s.nextLine();
                    a = new Archivomat();
                    int matriz2[][] = a.leerMatriz(ruta);
                    mat = new matriz(matriz2);
                    break;
                case (2):
                    mat.mostrarMatriz();
                    break;
                case (3):
                    mat.sumaDatos();
                    break;
                case (4):
                    mat.hallarMayor();
                    break;
                case (5):
                    mat.hallarMenor();
                    break;
                case (6):
                    mat.vectorConMayorDatoPorFila();
                    break;
                case (7):
                    mat.vectorConMenorDatoPorColumna();
                    break;
                case (8):
                    mat.muestraDatoConMayorSumaDigitosPorFila();
                    break;
                case (9):
                    mat.ordenarAscendentementePorFilasTodaLaMatriz();
                    break;
                case (10):
                    mat.ordenaCadaFilaDescendentemente();
                    break;
                case (11):
                    mat.cuantasVecesseRepiteUnNumero();
                case (12):
                    mat.muestraPromedioDatosTridiagonalPrincipal();
                case (13):
                    mat.ordenaDescendentementePorFila1();
                    break;
                case (14):
                    s = new Scanner(System.in);
                    int fila, columna;
                    System.out.println("Ingrese la fila: ");
                    fila = s.nextInt();
                    System.out.println("Ingresar la columna: ");
                    columna = s.nextInt();
                    mat.intercambiaFilaConColumna(fila, columna);
                    break;
                case (15):
                    mat.ordenarDigitosTridiagonalSecundaria();
                    break;
            }

        }while (m != 16);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
