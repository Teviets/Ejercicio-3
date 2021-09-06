class Carro{
    private String taman;
    private String tiempoLlegada;
    private String tiempoSalida;
    private String placa;
    private String marca;
    private String modelo;
    private int tiempoEstadia;

    public Carro (String t, String tL, String p, String ma, String mo){
        taman = t;
        tiempoLlegada = tL;
        placa = p;
        marca = ma;
        modelo = mo;
    }
    public void tiempoSal (String tS){
        tiempoSalida = tS;
    }
    private void CalculoTiempo(){
        tiempoEstadia = (Integer.parseInt(tiempoSalida) -Integer.parseInt(tiempoLlegada));
    }
    public String getHoraLlegada (){
        return tiempoLlegada;
    }
    public String getHoraSalida (){
        return tiempoSalida;
    }
    public int getTiempoEstancia (){
        return tiempoEstadia;
    }
    public String getMarca (){
        return marca;
    }
    public String getTaman (){
        return taman;
    }
    public String getPlaca(){
        return placa;
    }
}