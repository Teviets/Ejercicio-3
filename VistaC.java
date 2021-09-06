import java.util.Scanner;


class VistaC{
    private Scanner scan;
    private Scanner scan1;
    private String txt;
    private int num;
    private boolean booleano;

    public VistaC(){
        scan = new Scanner (System.in);
        scan1 = new Scanner (System.in);
    }

    public int menuPrincipalC (){
        System.out.println("\n\n1. Mostrar placa de todos los carros\n" +
                           "2. Mostrar el numero de parqueo y los carros que tienen\n" +
                           "3. Nuevo carro y asignar carro\n" +
                           "4. Se va un carro\n" +
                           "5. Nuevo espacio (Se requieren haber tenido carros para esta opcion)\n"+
                           "6. Mostrar estadisticas (Se requieren haber tenido carros para esta opcion)\n"+
                           "7. Guardar las estadisticas\n" +
                           "8. Salir\n");
        num = scan.nextInt();
        return num;
    }

    public int menuCarIndEsp (){
        System.out.println("Ingrese el indice del Espacio para asignar al carro");
        scan = new Scanner(System.in);
        num = scan.nextInt();
        return num;
    }
    public String menuCarTaman (){
        System.out.println("Ingrese el tamaño del carro (European, U.S.standar O U.S.standarLarge)\n");
        scan = new Scanner(System.in);
        txt = scan.nextLine();
        return txt;
    }
    public String menuCarTiempLlegada (){
        System.out.println("Ingrese la hora en que llego el carro (Ejemplo 13, 16, 22, no introdusca decimales)\n");
        txt = scan.nextLine();
        return txt;
    }
    public String menuCarPlaca (){
        System.out.println("Ingrese los caracteres de la placa del carro en mayusculas todo\n");
        txt = scan1.next();
        return txt;
    }
    public String menuCarMarca (){
        System.out.println("Ingrese la marca del carro (Ejemplo Toyota, Mazda, Honda)\n");
        Scanner scanercito = new Scanner(System.in);
        txt = scanercito.nextLine();
        return txt;
    }
    public String menuCarModelo (){
        System.out.println("Ingrese el modelo del carro\n");
        Scanner scanercito = new Scanner(System.in);
        txt = scanercito.nextLine();
        return txt;
    }

    public String menuEspTaman (){
        System.out.println("Ingresa el tamaño del espacio del parqueo (European, U.S.standar O U.S.standarLarge)\n");
        scan = new Scanner(System.in);
        txt = scan.nextLine();
        return txt;
    }
    public boolean menuEspTech (){
        System.out.println("¿El espacio es techado? (SI O NO)\n");
        scan = new Scanner(System.in);
        txt = scan.nextLine();
        if (txt == "SI" || txt == "si" || txt == "Si"){
            booleano = true;
        }else if (txt == "NO" || txt == "no" || txt =="No"){
            booleano = false;
        }
        return booleano;
    }
    public boolean menuEspAereo (){
        System.out.println("¿El espacio es aereo? (SI o NO)\n");
        txt = scan.nextLine();
        if (txt == "SI" || txt == "si" || txt == "Si"){
            booleano = true;
        }else if (txt == "NO" || txt == "no" || txt == "No"){
            booleano = false;
        }
        return booleano;
    }
    public int menuEspIdentificador (){
        System.out.println("¿Que numero es el identificador del espacio?\n");
        num = scan.nextInt();
        return num;
    }

    public String menuSalCarr (){
        System.out.println("Ingrese la hora de salida (Ejemplo 15, 20, no decimales)\n");
        scan = new Scanner(System.in);
        txt = scan.nextLine();
        return txt;
    }
    public int menuSalCarrIndiceEsp (){
        System.out.println("Ingrese el indice del espacio de donde salio el vahicullo\n");
        num = scan.nextInt();
        return num;
    }
    public int menuSalCarrInd (){
        System.out.println("Ingrese el indice del carro que se va\n");
        num = scan.nextInt();
        return num;
    }
    
}