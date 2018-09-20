package provanorton.model;

/**
 * @author Norton Wagner Martins  
 * @date 19/09/2018
 */
public class Custo{
    
    private int codigo;
    private Destino destino;
    private String dsCusto;
    private Integer tpCusto;
    private Double vlCusto;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Destino getDestino() {
        return destino;
    }

    public void setDestino(Destino destino) {
        this.destino = destino;
    }

    public String getDsCusto() {
        return dsCusto;
    }

    public void setDsCusto(String dsCusto) {
        this.dsCusto = dsCusto;
    }

    public Integer getTpCusto() {
        return tpCusto;
    }

    public void setTpCusto(Integer tpCusto) {
        this.tpCusto = tpCusto;
    }

    public Double getVlCusto() {
        return vlCusto;
    }

    public void setVlCusto(Double vlCusto) {
        this.vlCusto = vlCusto;
    }

}
