class Espacio{
    private String tamanE;
    private boolean techado;
    private boolean aereo;
    private int contadorDeUso;
    private int rechazo;
    private int numEspacio;
    private Carro[] carrito = new Carro[2];

    public Espacio(String taE, boolean te, boolean ae, int numIden){
        tamanE = taE;
        techado = te;
        aereo = ae;
        numEspacio = numIden;
    }

    public void asignarCarro (Carro c){
        try {
            if (carrito[0] == null ){
                carrito[0] = c;
                contadorDeUso = contadorDeUso + 1;
            }else if (aereo == false && (tamanE != c.getTaman() || carrito[0] != null)){
                rechazo++;
            }else if (aereo == true && carrito[0] == null && carrito[1] == null && tamanE == c.getTaman()){
                carrito[0] = c;
                contadorDeUso = contadorDeUso + 1;
            }else if (aereo == true && carrito[0] != null && carrito[1] == null && tamanE == c.getTaman()){
                carrito[1] = c;
                contadorDeUso = contadorDeUso + 1;
            }else if (aereo == true && (tamanE != c.getTaman() || (carrito[0] != null && carrito[1] != null))){
                rechazo ++;
            } 
        }catch (Exception e){
            System.out.println("Se genero un error "+ e.getMessage());
        }
    }
    public void salioCarro(String plac){
        if (carrito[0].getPlaca() == plac){
            carrito[0] = null;
        }else if (carrito[1].getPlaca() == plac){
            carrito[1] = null;
        }else if (carrito[0].getPlaca() != plac && carrito[1].getPlaca() != plac){
            System.out.println("Se ha equivocado de placa");
        }
    }

    public int getContadorDeUso(){
        return contadorDeUso;
    }
    public int getRechazo(){
        return rechazo;
    }
    public int getNumEsp (){
        return numEspacio;
    }
    public boolean getTecho(){
        return techado;
    }
    public boolean getAereo(){
        return aereo;
    }
    public Carro getCarro1 (){
        return carrito[0];
    }
    public Carro getCarro2(){
        return carrito[1];
    }
}