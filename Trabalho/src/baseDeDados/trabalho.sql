
CREATE SEQUENCE public.produto_idproduto_seq;

CREATE TABLE public.Produto (
                idProduto INTEGER NOT NULL DEFAULT nextval('public.produto_idproduto_seq'),
                descricao VARCHAR NOT NULL,
                valor VARCHAR NOT NULL,
                CONSTRAINT produto_pk PRIMARY KEY (idProduto)
);


ALTER SEQUENCE public.produto_idproduto_seq OWNED BY public.Produto.idProduto;

CREATE SEQUENCE public.tipoevento_idtipoevento_seq;

CREATE TABLE public.TipoEvento (
                idTipoEvento INTEGER NOT NULL DEFAULT nextval('public.tipoevento_idtipoevento_seq'),
                descricao VARCHAR NOT NULL,
                CONSTRAINT tipoevento_pk PRIMARY KEY (idTipoEvento)
);


ALTER SEQUENCE public.tipoevento_idtipoevento_seq OWNED BY public.TipoEvento.idTipoEvento;

CREATE SEQUENCE public.cliente_idcliente_seq;

CREATE TABLE public.Cliente (
                idCliente INTEGER NOT NULL DEFAULT nextval('public.cliente_idcliente_seq'),
                nome VARCHAR NOT NULL,
                telefone VARCHAR NOT NULL,
                email VARCHAR NOT NULL,
                CONSTRAINT cliente_pk PRIMARY KEY (idCliente)
);


ALTER SEQUENCE public.cliente_idcliente_seq OWNED BY public.Cliente.idCliente;

CREATE SEQUENCE public.pedido_idpedido_seq_1;

CREATE TABLE public.Pedido (
                idPedido INTEGER NOT NULL DEFAULT nextval('public.pedido_idpedido_seq_1'),
                origemPedido VARCHAR NOT NULL,
                dataPedido DATE NOT NULL,
                cerimonial VARCHAR NOT NULL,
                dataEvento DATE NOT NULL,
                horaEvento VARCHAR NOT NULL,
                indicacao VARCHAR NOT NULL,
                endereco VARCHAR NOT NULL,
                observacao VARCHAR NOT NULL,
                localEvento VARCHAR NOT NULL,
                idCliente INTEGER NOT NULL,
                idTipoEvento INTEGER NOT NULL,
                CONSTRAINT pedido_pk PRIMARY KEY (idPedido)
);


ALTER SEQUENCE public.pedido_idpedido_seq_1 OWNED BY public.Pedido.idPedido;

CREATE SEQUENCE public.itempedido_iditempedido_seq;

CREATE TABLE public.ItemPedido (
                idItemPedido INTEGER NOT NULL DEFAULT nextval('public.itempedido_iditempedido_seq'),
                quantidade INTEGER NOT NULL,
                valor DOUBLE PRECISION NOT NULL,
                idPedido INTEGER NOT NULL,
                idProduto INTEGER NOT NULL,
                CONSTRAINT itempedido_pk PRIMARY KEY (idItemPedido)
);


ALTER SEQUENCE public.itempedido_iditempedido_seq OWNED BY public.ItemPedido.idItemPedido;

ALTER TABLE public.ItemPedido ADD CONSTRAINT produto_itempedido_fk
FOREIGN KEY (idProduto)
REFERENCES public.Produto (idProduto)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.Pedido ADD CONSTRAINT tipoevento_pedido_fk
FOREIGN KEY (idTipoEvento)
REFERENCES public.TipoEvento (idTipoEvento)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.Pedido ADD CONSTRAINT cliente_pedido_fk
FOREIGN KEY (idCliente)
REFERENCES public.Cliente (idCliente)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.ItemPedido ADD CONSTRAINT pedido_itempedido_fk
FOREIGN KEY (idPedido)
REFERENCES public.Pedido (idPedido)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;