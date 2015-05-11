/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho;


/**
 *
 * @author Carolini
 */
public class Pedido {
    
    private Integer idpedido;
    private String origempedido;
    private String datapedido;
    private String cerimonial;
    private String dataevento;
    private String horaevento;
    private String indicacao;
    private String endereco;
    private String observacao;
    private String localevento;
    private String cliente;
    private String evento;

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

    public Integer getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(Integer IdCliente) {
        this.IdCliente = IdCliente;
    }

    public Integer getIdEvento() {
        return IdEvento;
    }

    public void setIdEvento(Integer IdEvento) {
        this.IdEvento = IdEvento;
    }
    private Integer IdCliente;
    private Integer IdEvento;

    public Integer getIdpedido() {
        return idpedido;
    }

    public void setIdpedido(Integer idpedido) {
        this.idpedido = idpedido;
    }

    public String getOrigempedido() {
        return origempedido;
    }

    public void setOrigempedido(String origempedido) {
        this.origempedido = origempedido;
    }

    public String getDatapedido() {
        return datapedido;
    }

    public void setDatapedido(String datapedido) {
        this.datapedido = datapedido;
    }

    public String getCerimonial() {
        return cerimonial;
    }

    public void setCerimonial(String cerimonial) {
        this.cerimonial = cerimonial;
    }

    public String getDataevento() {
        return dataevento;
    }

    public void setDataevento(String dataevento) {
        this.dataevento = dataevento;
    }

    public String getHoraevento() {
        return horaevento;
    }

    public void setHoraevento(String horaevento) {
        this.horaevento = horaevento;
    }

    public String getIndicacao() {
        return indicacao;
    }

    public void setIndicacao(String indicacao) {
        this.indicacao = indicacao;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getLocalevento() {
        return localevento;
    }

    public void setLocalevento(String localevento) {
        this.localevento = localevento;
    }

  

    
}
