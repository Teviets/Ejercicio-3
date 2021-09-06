import java.lang.reflect.Array;
import java.util.ArrayList;

class Parqueo {
    private ArrayList<Espacio> espacitos = new ArrayList<Espacio>();
    private ArrayList<Carro> carritos = new ArrayList<Carro>();

    private Espacio espacio1;
    private Espacio espacio2;
    private Espacio espacio3;
    private Espacio espacio4;
    private Espacio espacio5;

    private Espacio espacito;
    private Carro carrito;

    private int rechazo = 0;
    private int promTLleg = 0;
    private int promTSal = 0;
    private int tiempProm = 0;
    private int indEspacioFav = 0;
    private int maxContador = 0;
    private String marcaPopular = "";
    private String caracteristicaPreferida = "";

    public Parqueo(){
        asignacionParqueo();
        espacitos.add(espacio1);
        espacitos.add(espacio2);
        espacitos.add(espacio3);
        espacitos.add(espacio4);
        espacitos.add(espacio5);
    }
    public void asignacionParqueo (){
        espacio1 = new Espacio("European", true, false,1);
        espacio2 = new Espacio("European", true, false,2) ;
        espacio3 = new Espacio("European", false, true,3);
        espacio4 = new Espacio("U.S.standar", true, false,4);
        espacio5 = new Espacio("U.S.standarLarge", true, false,5);
        
    }
    public void mostrarInfoCar (){
        if (carritos.size() > 0){
            for (int i = 0; i<carritos.size() ; i++){
                System.out.println(i + ".- "+carritos.get(i).getPlaca()+"\n");
            }
        }else if (carritos.size() == 0){
            System.out.println("\nNo hay carros en el historial\n");
        }
    }
    public void mostrarInfoEsp (){
        for (int i = 0 ; i < espacitos.size() ; i++){
            System.out.println("\n"+i +".- "+ espacitos.get(i).getNumEsp() + " con los carros: ");
            if (espacitos.get(i).getCarro1() != null){
                System.out.println("                               " + espacitos.get(i).getCarro1().getPlaca() + " ");
            }
            if (espacitos.get(i).getCarro2() != null){
                System.out.println("                               " + espacitos.get(i).getCarro2().getPlaca());
            }
            System.out.println("\n");
            if (espacitos.get(i).getTecho() == true){   
                System.out.println("                          Con la caracteristica de ser techado\n");
            }else if(espacitos.get(i).getAereo() == true){
                System.out.println("                          Con la caracteristica de ser aereo\n");
            }
        }
    }

    public void setTiempoSal (String tS, int i,int j){
        carritos.get(i).tiempoSal(tS);
        espacitos.get(j).salioCarro(carritos.get(i).getPlaca());   
    }
    

    public void generarEst(){
        sumaRechazos();
        calculoHorarioProm();
        calculoTprom();
        calculadorEspacioFav();
        calculadorModaMarc();
        calculadorCaracteristica();
    }
    private void sumaRechazos(){
        for(int i = 0; i < espacitos.size() ; i++){
            rechazo = rechazo + espacitos.get(i).getRechazo();
        }
    } 
    private void calculoHorarioProm (){
        for (int i = 0 ; i < carritos.size() ; i++){
            promTLleg = (promTLleg + Integer.parseInt(carritos.get(i).getHoraLlegada()));
        }
        if (carritos.size() != 0){
            promTLleg = promTLleg / carritos.size();
        }else if (carritos.size() == 0){
            System.out.println("\nHay un problema para calcular el tiempo promedio de llegada\n");
        }
        for (int i = 0; i < carritos.size() ; i++){
            promTSal = (promTSal + Integer.parseInt(carritos.get(i).getHoraSalida()));
        }
        if (carritos.size() != 0){
            promTSal = promTSal / carritos.size();
        }else if (carritos.size() == 0){
            System.out.println("\nHay un problema para calcular el tiempo promedio de Salida\n");
        }
    }
    private void calculoTprom (){
        tiempProm = (promTSal - promTLleg);
    }
    private void calculadorEspacioFav (){
        for (int i = 0; i < espacitos.size(); i++){
            for (int j = 0; j < espacitos.size() ; j++){
                if (espacitos.get(i).getContadorDeUso() > espacitos.get(j).getContadorDeUso()){
                    indEspacioFav = espacitos.get(i).getNumEsp();
                }
            }
        }
    }
    private void calculadorModaMarc (){
        for (int i = 0; i < carritos.size(); i++){
            int cont = 0;
            for (int j = 0; j> carritos.size(); j++){
                if (carritos.get(i).getMarca() == carritos.get(j).getMarca() ){
                    cont = cont + 1;
                }
            }
            if (cont>=maxContador){
                maxContador = cont;
                marcaPopular = carritos.get(i).getMarca();
            }
        }
    }
    private void calculadorCaracteristica (){
        int techado = 0;
        int aereo = 0;
        for (int i = 0; i < espacitos.size() ; i++){
            if (espacitos.get(i).getTecho() == true){
                techado += espacitos.get(i).getContadorDeUso();
            }else if (espacitos.get(i).getAereo() == true){
                aereo += espacitos.get(i).getContadorDeUso();
            }
        }
        if (techado > aereo){
            caracteristicaPreferida = "Techado";
        }else if (aereo > techado){
            caracteristicaPreferida = "Aereo";
        }else if (aereo == techado){
            caracteristicaPreferida = "Las dos caracteristicas son importantes";
        }
    }

    public void asignacionCarro(String tam, String llego, String pla, String mar, String mod,int i){
        carrito = new Carro(tam,llego,pla,mar,mod);
        carritos.add(carrito);
        
        espacitos.get(i).asignarCarro(carrito);
        
    }

    public void espacioNuevo (String tam, boolean tech, boolean aer, int espacioNum){
        espacito = new Espacio(tam,tech,aer,espacioNum);
        espacitos.add(espacito);
    }

    public int getRechazo(){
        return rechazo;
    }
    public int getHoraLlegProm(){
        return promTLleg;
    }
    public int getHoraSalProm(){
        return promTSal;
    }
    public int getTiempoProm(){
        return tiempProm;
    }
    public int getEspacioFav(){
        return indEspacioFav;
    }
    public int getNumMarca(){
        return maxContador;
    }
    public String getMarca(){
        return marcaPopular;
    }
    public String getCaracteristicaFav (){
        return caracteristicaPreferida;
    }
}