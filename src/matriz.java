
//Se importan las librerias a utilizar
import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;
import static java.lang.StrictMath.pow;

public class matriz {   //definimos la clase matriz, la cual recibe como parametro otra matriz, a la que le haremos ciertas opreaciones
    private int mat[][];
    public matriz(int[][] mat){
        this.mat = mat;
    }
    public int tamano(){
        return mat.length;
    } //definimos la clase tamaño que muestra el tamaño de la matriz

    //2
    public void mostrarMatriz(){
        for (int f = 0; f < mat.length; f++) {
            System.out.print("\n");//cada que se cambie de fila se hace un cambio de linea
            for (int c = 0; c < mat.length; c++) {//recorremos la matriz
                System.out.print(mat[f][c]+" ");//luego imprimimos dato por dato
            }
        }
    }

    //3
    public void sumaDatos(){
        int  sum=0;//creamos la variable suma
        for (int f = 0; f < mat.length; f++) {
            for (int c = 0; c < mat.length; c++) {//recorremos la matriz con los ciclos for
                sum += mat[f][c];//Vamos sumando a la variable suma cada valor dentro de la matriz
            }
        }
        System.out.println(sum);
    }

    //4
    public void hallarMayor(){

        int may=MIN_VALUE,//Definimos un valor maximo y lo inicializamos con el valor minimo que permite este tipo de variable
            fil=0,
            col=0;//definimos fila y columa en 0 para que el valor minimo empiece en esta posicion

        for (int f = 0; f < mat.length; f++) {
            for (int c = 0; c < mat.length; c++) {//recorremos el vector
                if (mat[f][c]>may){//comparamos el dato de la posicion con el dato que es el mayor hasta el momento
                    may=mat[f][c];//si es mayor el dato de esa posicion, que el dato mayor que teniamos se guarda el nuevo dato mayor
                    fil=f;
                    col=c;//guardamos la fila y la columna en la que se encuentra
                }
            }
        }
        System.out.println("fila: "+fil+", columna: "+col +", numero: "+may);//imprimimos todos los datos que encontramos
    }

    //5
    public void hallarMenor(){
        int  men= MAX_VALUE,//Definimos un valor minimo y lo inicializamos con el valor maximo que permite este tipo de variable
             fil=0,
             col=0;//definimos fila y columa en 0 para que el valor maximo empiece en esta posicion

        for (int f = 0; f < mat.length; f++) {
            for (int c = 0; c < mat.length; c++) {//recorremos el vector
                if (mat[f][c]<men){//comparamos el dato de la posicion con el dato que es el menor hasta el momento
                    men=mat[f][c];//si es menor el dato de esa posicion, que el dato menor que teniamos se guarda el nuevo dato menor
                    fil=f;
                    col=c;//guardamos la fila y la columna en la que se encuentra
                }
            }
        }
        System.out.println("fila: "+fil+", columna: "+col +", numero: "+men);//imprimimos todos los datos que encontramos
    }

    //6
    public void vectorConMayorDatoPorFila(){//Mostrar el mayor dato de cada fila
        int fil=0,
            col=0;//Se inicia las filas y columnas en 0
        for (int f = 0; f < mat.length; f++) {
            int  may=MIN_VALUE;//en cada fila debemos iniar el mayor en el minimo valor posible
            for (int c = 0; c < mat.length; c++) {
                if (mat[f][c]>may){//comparamos solo los valores de cada fila uno por uno
                    may=mat[f][c];//cuando encuentra un numero mayor que anterior que se tenia se guarda
                    fil=f;
                    col=c;}//tambien guardamos la fila y la columa en la que esta
            }
            System.out.println("fila: "+fil+", columna: "+col +", numero: "+may);//imprimimos los datos
        }
    }

    //7
    public void vectorConMenorDatoPorColumna(){//Mostrar el mayor dato de cada columna
        int fil=0,
            col=0;//Se inicia las filas y columnas en 0
        for (int c = 0; c < mat.length; c++) {//a diferencia de antes, empezamos el contador con las columnas
            int  may=MIN_VALUE;//en cada fila debemos iniar el mayor en el minimo valor posible
            for (int f = 0; f < mat.length; f++) {
                if (mat[f][c]>may){//comparamos solo los valores de cada columna uno por uno
                    may=mat[f][c];
                    fil=f;
                    col=c;}//tambien guardamos la fila y la columa en la que esta
            }
            System.out.println("fila: "+fil+", columna: "+col +", numero: "+may);//imprimimos los datos
        }
    }

    //8
    public void muestraDatoConMayorSumaDigitosPorFila(){
        int mayor = MIN_VALUE, //Se inicia el valor minimo
            suma,
            fila=0; //Se inicia la fila en 0
        for (int i = 0; i < mat.length; i++) {
            suma = 0;//Como se suma por filas, en cada iteracion la suma debe empezar en 0
            for (int j = 0; j < mat.length; j++) {
                suma = mat[i][j]+suma;//Se  realiza la suma de todos los valores de la fila
            }
            if (mayor < suma){//Se compara con el valor suma con el valor mayor previo
                mayor = suma;//si es mayor se actualizan los datos
                fila = i;
            }
        }
        System.out.println("Fila: "+fila+", Numero: "+mayor);//Se imprime el valor mayor

        //Se realiza lo mismo que en el numeral anterior para saber si hay mas de una ocurrencia del numero mayor
        for (int i = 0; i < mat.length; i++) {
            if (i==fila)continue;//no se compara la fila en la cual esta el valor mayor, encontrado previamente
            suma = 0;
            for (int j = 0; j < mat.length; j++) {
                suma = mat[i][j]+suma;}
            if (mayor == suma){//Por cada vez que se encuentre un valor igual se imprimen los datos de este valor
                fila = i;
                System.out.println("Fila: "+fila+", Numero: "+mayor);
            }
        }
    }

    //9
        public void ordenarAscendentementePorFilasTodaLaMatriz() {//Se usa el metodo burbuja mejorado
            for (int i = 0; i <= pow(mat.length,2); i++) {//Se debe recorrer la matriz N*N veces
                boolean sw=true;//Si no se ejecuta ningun cambio es por que ya se termino de ordenar y este quedara igual al final de los dos ciclos
                for (int k = 0; k <mat.length; k++) {
                    for (int l = 0; l < mat.length; l++) {//se recorre la matriz
                        if (l + 1 < mat.length) {//se verifica que el dato siguiente no exceda los limites de la matriz
                            if (mat[k][l] > mat[k][l + 1]) {//si un dato es mayor que el siguiente se intercambian los datos
                                intercambiarDatosMatriz(k, l, k, l + 1);
                                sw=false;
                            }
                        } else if (l + 1 == mat.length && k + 1 < mat.length) {//si se sale de la matriz entonces se compara el ultimo dato de la fila con el primer dato de la siguiente columna
                            if (mat[k][l] > mat[k+1][0]) {
                                intercambiarDatosMatriz(k, l, k + 1, 0);//se intercambian los adtos
                                sw=false;
                            }
                        }
                    }
                }
                if (sw)return;//si no se hizo nungun cambio se termina el programa
            }
        }



    //10
    public void ordenaCadaFilaDescendentemente(){
        //Usar metodo de insercion
        int dato,
            posicion;
        for (int i = 0; i < mat.length ; i++) {
            for (int j = 1; j <mat.length ; j++) {
                dato=mat[i][j];//Se guarda el dato de donde se inicia el proceso
                posicion=j-1;//Se empieza a ordenar la fila desde la posicion j-1
                while (posicion>=0 && mat[i][posicion]<dato){//Se empieza a comparar el dato donde inicia el ciclo con los datos anateriores a el
                    mat[i][posicion+1]=mat[i][posicion];//si son menores se empiezan a almacenar al final del codigo
                    posicion--;//Se resta para seguir comparando con los datos que faltan
                }
                mat[i][posicion+1]=dato;//Si se termina el ciclo, entonces el dato guardado previamente se almacena en la posicion donde quedo el dato que era menor
            }
        }
    }

    //11
    static int[] list;
    //Nos ayuda a comparar los números y verificar que el numero se repita
    static boolean numero(int num){
        for(int i = 0; i<list.length; i++){
            if(list[i] == num){//compara el numero con el número del array
                return false;
            }
        }
        return true;
    }

    public void cuantasVecesseRepiteUnNumero(){
        //pasar una matriz a un vector
        int[] array = new int[mat.length*mat.length];//se declara un array con la cantidad de poisciones que cuenta la matriz
        list = new int [array.length];
        int frecuencia = 0;//controla las posiciones para recorrer el vector

        for(int i=0;i<mat.length;i++){//
            for(int j=0;j<mat.length;j++){
                array[frecuencia] = mat[i][j];//toma los valores de la que hay en la matriz y los pasa al vector
                frecuencia++;
            }
        }
        //Codigo que cuenta cuantas veces está cada número
        for(int x = 0; x<array.length; x++){
            int aux = 0;
            for(int y = 0; y<array.length; y++){
                if(array[x]==array[y]){
                    aux++;
                    if(numero(array[x])){
                        list[x] = array[x];
                    }
                }
            }
            if(list[x] != 0) {
                System.out.println("El " + list[x] + " se repite = " + aux);
            }
        }
    }

    //12
    public void muestraPromedioDatosTridiagonalPrincipal(){
        int suma=0,
            datos=0;
        for (int i = 0; i <mat.length-1 ; i++) {
            suma += mat[i][i]+mat[i][i+1]+mat[i+1][i];//Se suman solo los datos correspondientes a la tridiagonal principal
            datos+=3;//Se suma cuantos datos hay para al final sacar un promedio
        }
        suma += mat[mat.length-1][mat.length-1];//Como al final faltaria un dato, este se le suma
        datos++;
        suma/=datos;//sacamos el promedio
        System.out.println("El promedio de los datos de la tridiagonal principal es: " + suma);//lo mostramos
    }

    //13
    public void ordenaDescendentementePorFila1(){//como nosotros trabajamos las matrices desde la posicion 0, entonces en realidad seria por la fila numero 0
        //Usar metodo de seleccion
        int k;
        for (int i = 0; i < mat.length-1; i++) {
            k=i;
            for (int j = i+1; j < mat.length; j++) {//aplicamos el metodo seleccion para ir ordenando la fila
                if (mat[0][j]>mat[0][k]){//vamos encontrando el numero mayor de la fila 0
                            k=j; //guardamos en numero de la columna en la que se encuentra
                        }
                    }
            intercambiarColumnas(i,k);//intercambiamos las columnas, y se va ordenando la primera fila
        }
     }

    void intercambiarColumnas(int i, int j){//definimos un metodo que nos intercambia los datos de dos columnas
        for (int k = 0; k < mat.length; k++) {
                intercambiarDatosMatriz(k, i, k, j);
        }
    }


    //14
    public void intercambiaFilaConColumna(int i,int j){ // Intercambia los datos de la fila i con los de la columna j
        if (i< mat.length && j<mat.length) {//Se validan los datos ingresados
            for (int k = 0; k < mat.length; k++) {//Se hace un ciclo
                intercambiarDatosMatriz(i, k, k, j);//Se van interccambiando los valores de la matriz
            }
        }
        else System.out.println("Los valores ingresados para fila o columna deben ser menores que "+mat.length);//si son erroneos se muestra un mensaje

    }

    //15
    public void ordenarDigitosTridiagonalSecundaria() {
        mostrarMatriz();//se muestra l matriz antes de ordenar los datos que se quieren
        System.out.println("\n");
        int i=0,
            j=mat.length-1;
            while (i<mat.length && j>0){//va por los datos de arriba y abajo de la diagonal secundaria
                    if (mat[i][j - 1] > numeroAlreves(mat[i][j-1])) {
                        mat[i][j - 1] = numeroAlreves(mat[i][j - 1]);
                    }
                    if (mat[i+1][j] > numeroAlreves(mat[i + 1][j])) {
                        mat[i+1][j]=numeroAlreves(mat[i + 1][j]);
                    }
                    j--;
                    i++;
                }
            i=0;
            j=mat.length-1;
            while (i<=mat.length && j>=0){
                if (mat[i][j] > numeroAlreves(mat[i][j])){
                    mat[i][j]=numeroAlreves(mat[i][j]);//se cambian los datos
                }
                j--;
                i++;
            }
        mostrarMatriz();
    }



    void intercambiarDatosMatriz(int i,int j, int k, int l) {
        int aux;
        aux = mat[i][j];
        mat[i][j]=mat[k][l];
        mat[k][l]= aux;
    }

    public static int numeroAlreves(int x){
        int num=x,
            numInver=0,
            i,
            exponente=0;
        while (num>0){
            num/=10;
            exponente++;
        }
        num=x;
        i= (int) pow(10,exponente);
        while (num>0){
            i/=10;
            numInver+=num%10*i;
            num/=10;
        }

        return numInver;
    }
}
