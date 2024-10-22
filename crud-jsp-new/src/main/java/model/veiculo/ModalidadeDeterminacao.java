package model.veiculo;



public enum ModalidadeDeterminacao {

    Margen_valor_agregado("0"),
    Pauta("1"),
    Preço_tabelado_max("2"),
    Valor_operação("3");

    private String descricao;

    ModalidadeDeterminacao(String descricao){
        this.descricao = descricao;
    }


}
