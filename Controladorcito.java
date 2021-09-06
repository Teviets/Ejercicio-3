import java.io.FileWriter;
import java.io.IOException;

class Controladorcito{
    public static void main(String[] args) {
        try{
            Parqueo parque = new Parqueo();
            VistaC vistita = new VistaC();
            FileWriter archivito = new FileWriter("Estadisticas.txt");
        
            int opcion = 0;

            String x = "La marca favorita es: "+ parque.getMarca() +"\n" +
                        "El espacio favorito es: " + parque.getEspacioFav() + "\n"+
                        "Se han rechazodo :" + parque.getRechazo() + "\n" +
                        "El tiempo de estadia promedio es: " + parque.getTiempoProm() + "\n" +
                        "El horario promedio es desde " + parque.getHoraLlegProm() + " hasta las " + parque.getHoraSalProm() + "\n";

            while (opcion != 8){
                opcion = vistita.menuPrincipalC();

                switch (opcion) {
                    case 1:
                        parque.mostrarInfoCar();
                        break;
                
                    case 2:
                        parque.mostrarInfoEsp();
                        break;
                
                    case 3:
                        String marca = vistita.menuCarMarca();
                        String modelo = vistita.menuCarModelo();
                        String placa = vistita.menuCarPlaca();
                        String taman = vistita.menuCarTaman();
                        String tLlegada = vistita.menuCarTiempLlegada();
                        int indPaAsignar = vistita.menuCarIndEsp();
                        parque.asignacionCarro(taman, tLlegada, placa, marca, modelo,indPaAsignar);
                        break;
                
                    case 4:
                        try {
                            String tSal = vistita.menuSalCarr();
                            System.out.println("\n A continuacion las posibles placas\n");
                            parque.mostrarInfoCar();
                            int indCar = vistita.menuSalCarrInd();
                            System.out.println("\n A continuacion los siguientes espacios\n");
                            parque.mostrarInfoEsp();
                            int indEsp = vistita.menuSalCarrIndiceEsp();
                            parque.setTiempoSal(tSal, indCar, indEsp);
                        } catch (Exception e) {
                            System.out.println("\nNo tiene historial de algun carro\n");
                        }
                    
                    
                        break;
                    case 5:
                        String tamano = vistita.menuEspTaman();
                        boolean tech = vistita.menuEspTech();
                        boolean aer = vistita.menuEspAereo();
                        int parqueoAlQueVa = vistita.menuEspIdentificador();
                        parque.espacioNuevo(tamano, tech, aer, parqueoAlQueVa);

                        break;
                    case 6:
                        try {
                            parque.generarEst();
                            System.out.println("La marca favorita es: "+ parque.getMarca() +"\n" +
                                                "El espacio favorito es: " + parque.getEspacioFav() + "\n"+
                                                "Se han rechazodo :" + parque.getRechazo() + "\n" +
                                                "El tiempo de estadia promedio es: " + parque.getTiempoProm() + "\n" +
                                "El horario promedio es desde " + parque.getHoraLlegProm() + " hasta las " + parque.getHoraSalProm() + "\n");
                        } catch (Exception e) {
                            System.out.println("Ha ocurrido un error, con el mensaje de: " + e.getMessage());
                        }
                    
                        break;
                    case 7:
                        archivito.write("La marca favorita es: "+ parque.getMarca() +"\n" +
                                        "El espacio favorito es: " + parque.getEspacioFav() + "\n"+
                                        "Se han rechazodo :" + parque.getRechazo() + "\n" +
                                        "El tiempo de estadia promedio es: " + parque.getTiempoProm() + "\n" +
                                    "El horario promedio es desde " + parque.getHoraLlegProm() + " hasta las " + parque.getHoraSalProm() + "\n");
                        archivito.close();
                        break;

                    default:
                        break;
                }
            }
        }catch (IOException e) {
                System.out.println("Error E/S "+ e);
            }
    }
}