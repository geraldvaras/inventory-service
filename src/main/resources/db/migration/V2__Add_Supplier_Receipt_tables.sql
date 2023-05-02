CREATE TABLE PROVEEDORES
(
    CODEMP        VARCHAR(3)  NOT NULL,
    CODPROV       VARCHAR(6)  NOT NULL,
    COMPANIA      VARCHAR(60) NOT NULL,
    RUC           VARCHAR(15) NOT NULL,
    VERSION       INT         NOT NULL,
    FECHAREGISTRO DATETIME2   NOT NULL,
    ROWFECHAHORA  DATETIME2   NOT NULL,
    CONSTRAINT PK_PROVEEDORES PRIMARY KEY (CODEMP, CODPROV)
);

CREATE TABLE RECEPCIONCAB
(
    CODEMP           VARCHAR(3)  NOT NULL,
    CODSUC           VARCHAR(3)  NOT NULL,
    CODALM           VARCHAR(3)  NOT NULL,
    INTERNO          INT         NOT NULL,
    TIPODOC          VARCHAR(3)  NOT NULL,
    NUMDOC           VARCHAR(15) NOT NULL,
    SERIE            VARCHAR(4)  NOT NULL,
    CODPROV          VARCHAR(6)  NOT NULL,
    OBSERVACION      VARCHAR(200),
    FECHAFAC         DATE        NOT NULL,
    FECHAVENC        DATE        NOT NULL,
    SOLOBONIFICACION INT         NOT NULL,
    VERSION          INT         NOT NULL,
    UPDATEFECHAHORA  DATETIME2   NOT NULL,
    ROWFECHAHORA     DATETIME2   NOT NULL,
    CONSTRAINT PK_RECEPCIONCAB PRIMARY KEY (CODEMP, CODSUC, CODALM, INTERNO)
);


CREATE TABLE RECEPCIONDET
(
    CODEMP            VARCHAR(3)   NOT NULL,
    CODSUC            VARCHAR(3)   NOT NULL,
    CODALM            VARCHAR(3)   NOT NULL,
    INTERNO           INT          NOT NULL,
    ITEM              INT          NOT NULL,
    ORDEN             INT          NOT NULL,
    CODPROD           VARCHAR(8)   NOT NULL,
    DESPROD           VARCHAR(120) NOT NULL,
    FRACCION          INT          NOT NULL,
    CODBAR            VARCHAR(15)  NOT NULL,
    UNIMED            VARCHAR(3)   NOT NULL,
    UNIMEDMIN         VARCHAR(3)   NOT NULL,
    CANDES            INT          NOT NULL,
    CANDESMIN         INT          NOT NULL,
    CANBONI           INT          NOT NULL,
    TOTCANTMIN        INT          NOT NULL,
    CANDES_COM        INT          NOT NULL,
    CANDESMIN_COM     INT          NOT NULL,
    CANBONI_COM       INT          NOT NULL,
    TOTCANTMIN_COM    INT          NOT NULL,
    IDTIPOOBSERVACION INT          NOT NULL,
    OBSERVACION       VARCHAR(200) NOT NULL,
    CANDES_FAC        INT          NOT NULL,
    CANDESMIN_FAC     INT          NOT NULL,
    CANBONI_FAC       INT          NOT NULL,
    TOTCANTMIN_FAC    INT          NOT NULL,
    LOTE              VARCHAR(15)  NOT NULL,
    FECHAVENC         DATE         NOT NULL,
    FLAGDIF_COMPRA    INT          NOT NULL,
    SOLOBONIFICACION  INT          NOT NULL,
    CONSTRAINT PK_RECEPCIONDET PRIMARY KEY (CODEMP, CODSUC, CODALM, INTERNO, ITEM),
    CONSTRAINT FK_RECEPCION_CAB FOREIGN KEY (CODEMP, CODSUC, CODALM, INTERNO)
        REFERENCES RECEPCIONCAB (CODEMP, CODSUC, CODALM, INTERNO)
);

CREATE TABLE RECEPCIONORDENCOMPRA
(
    CODEMP        VARCHAR(3) NOT NULL,
    CODSUC        VARCHAR(3) NOT NULL,
    CODALM        VARCHAR(3) NOT NULL,
    IDRECEPCION   INT        NOT NULL,
    IDORDENCOMPRA VARCHAR(8) NOT NULL,
    FECHAREGISTRO DATETIME2  NOT NULL,
    CONSTRAINT PK_RECEPCIONORDENCOMPRA PRIMARY KEY (CODEMP, CODSUC, CODALM, IDRECEPCION, IDORDENCOMPRA)
);

CREATE TABLE RECEPCIONTIPOOBSERVACION
(
    CODEMP            VARCHAR(3)  NOT NULL,
    IDTIPOOBSERVACION INT         NOT NULL,
    DESCRIPCION       VARCHAR(80) NOT NULL,
    ESTADO            INT,
    ACCION            VARCHAR(20),
    FECHAREGISTRO     DATETIME2   NOT NULL,
    CONSTRAINT PK_RECEPCIONTIPOOBSERVACION PRIMARY KEY (CODEMP, IDTIPOOBSERVACION)
);

CREATE TABLE OCOMCAB
(
    CODEMP          VARCHAR(3)  NOT NULL,
    CODSUC          VARCHAR(3)  NOT NULL,
    NUMORDENCOM     VARCHAR(6)  NOT NULL,
    CODPROV         VARCHAR(6)  NOT NULL,
    RUC             VARCHAR(15) NOT NULL,
    COMPANIA        VARCHAR(60) NOT NULL,
    DIRECCION       VARCHAR(255),
    NUMITEM         INT         NOT NULL,
    NOTAS           VARCHAR(255),
    FECHAORDEN      DATETIME2  NOT NULL,
    FECHEMISION     DATETIME2   NOT NULL,
    VERSION         INT         NOT NULL,
    UPDATEFECHAHORA DATETIME2   NULL,
    CONSTRAINT PK_OCOMCAB PRIMARY KEY (CODEMP, CODSUC, NUMORDENCOM)
);

CREATE TABLE OCOMITE
(
    CODEMP      VARCHAR(3)   NOT NULL,
    CODSUC      VARCHAR(3)   NOT NULL,
    NUMORDENCOM VARCHAR(6)   NOT NULL,
    CODREG      INT          NOT NULL,
    CODPROD     VARCHAR(8)   NOT NULL,
    DESPROD     VARCHAR(120) NOT NULL,
    DESPRES     VARCHAR(30)  NOT NULL,
    CANDES      INT          NOT NULL,
    CANDESMIN   INT          NOT NULL,
    CANBONI     INT          NOT NULL,
    TOTCANTMIN  INT          NOT NULL,
    CONSTRAINT PK_OCOMITE PRIMARY KEY (CODEMP, CODSUC, NUMORDENCOM, CODREG),
    CONSTRAINT FK_OCOMCAB FOREIGN KEY (CODEMP, CODSUC, NUMORDENCOM)
        REFERENCES OCOMCAB (CODEMP, CODSUC, NUMORDENCOM)
);