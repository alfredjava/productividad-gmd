--                                                                
-- ER/Studio 7.1 SQL Code Generation                              
-- Company :      Microsoft                                       
-- Project :      MDPRODUCTIVIDAD.dm1                             
-- Author :       Microsoft                                       
--                                                                
-- Date Created : Friday, January 11, 2013 12:00:00               
-- Target DBMS : MySQL 5.x                                        
--                                                                
                                                                  
--                                                                
-- TABLE: ACTIVIDAD_COLABORADOR                                   
--                                                                
                                                                  
CREATE TABLE ACTIVIDAD_COLABORADOR(                               
    ID_ACTV_COLA      DECIMAL(10, 0)    NOT NULL,                 
    ID_COLABORADOR    DECIMAL(10, 0)    NOT NULL,                 
    ID_PROYECTO       DECIMAL(10, 0)    NOT NULL,                 
    TI_ACTIVIDAD      CHAR(1),                                    
    FE_INICIO         DATE,                                       
    FE_FIN            DATE,                                       
    TO_TIEMPO         DECIMAL(10, 4),                             
    PRIMARY KEY (ID_ACTV_COLA)                                    
)                                                                 
;                                                                 
                                                                  
                                                                  
                                                                  
--                                                                
-- TABLE: ASIGNACION_TRABAJO                                      
--                                                                
                                                                  
CREATE TABLE ASIGNACION_TRABAJO(                                  
    ID_ASIGNACION              DECIMAL(10, 0)    NOT NULL,        
    ID_COLABORADOR             DECIMAL(10, 0)    NOT NULL,        
    ID_TECNOLOGIA              DECIMAL(10, 0)    NOT NULL,        
    ID_COMPONENTE              DECIMAL(10, 0)    NOT NULL,        
    ID_HERRAMIENTA             DECIMAL(10, 0)    NOT NULL,        
    UP                         VARCHAR(10),                       
    IN_COMPLEJIDAD             CHAR(1),                           
    TI_PROCESO                 CHAR(1),                           
    TI_TAREA                   CHAR(1),                           
    FE_INICIO                  DATE,                              
    FE_FIN                     DATE,                              
    FE_FIN_REAL                DATE,                              
    HO_DESARROLLO_REAL         DECIMAL(10, 4),                    
    CA_COMPONENTE              DECIMAL(10, 4),                    
    ST_CONSTRUCCION            CHAR(1),                           
    ST_TESTING                 CHAR(1),                           
    HO_MODELO_ESTADISTICO      DECIMAL(10, 4),                    
    CA_COMPONENTE_UNITARIO     DECIMAL(10, 4),                    
    IN_RETRABAJO               CHAR(1)           DEFAULT 0,       
    HO_BRECHA_PRODUCTIVIDAD    DECIMAL(10, 4),                    
    HO_EFICIENCIA              DECIMAL(10, 4),                    
    TX_OBSERVACION             VARCHAR(100),                      
    PRIMARY KEY (ID_ASIGNACION)                                   
)                                                                 
;                                                                 
                                                                  
                                                                  
                                                                  
--                                                                
-- TABLE: COLABORADOR                                             
--                                                                
                                                                  
CREATE TABLE COLABORADOR(                                         
    ID_COLABORADOR    DECIMAL(10, 0)    NOT NULL,                 
    AP_PATERNO        VARCHAR(50),                                
    AP_MATERNO        VARCHAR(50),                                
    NOMBRES           VARCHAR(50),                                
    ROL               CHAR(1),                                    
    TI_DOCUMENTO      CHAR(1),                                    
    NU_DOCUMENTO      VARCHAR(15),                                
    PRIMARY KEY (ID_COLABORADOR)                                  
)                                                                 
;                                                                 
                                                                  
                                                                  
                                                                  
--                                                                
-- TABLE: COMPONENTE                                              
--                                                                
                                                                  
CREATE TABLE COMPONENTE(                                          
    ID_COMPONENTE    DECIMAL(10, 0)    NOT NULL,                  
    NO_COMPONENTE    VARCHAR(50),                                 
    IN_CATEGORIA     CHAR(1),                                     
    PRIMARY KEY (ID_COMPONENTE)                                   
)                                                                 
;                                                                 
                                                                  
                                                                  
                                                                  
--                                                                
-- TABLE: HERRAMIENTA                                             
--                                                                
                                                                  
CREATE TABLE HERRAMIENTA(                                         
    ID_HERRAMIENTA    DECIMAL(10, 0)    NOT NULL,                 
    NO_HERRAMIENTA    VARCHAR(50),                                
    PRIMARY KEY (ID_HERRAMIENTA)                                  
)                                                                 
;                                                                 
                                                                  
                                                                  
                                                                  
--                                                                
-- TABLE: LENGUAJE                                                
--                                                                
                                                                  
CREATE TABLE LENGUAJE(                                            
    ID_LENGUAJE    DECIMAL(10, 0)    NOT NULL,                    
    IN_TIPO        CHAR(1),                                       
    NO_LENGUAJE    VARCHAR(50),                                   
    PRIMARY KEY (ID_LENGUAJE)                                     
)                                                                 
;                                                                 
                                                                  
                                                                  
                                                                  
--                                                                
-- TABLE: PARAMETRO                                               
--                                                                
                                                                  
CREATE TABLE PARAMETRO(                                           
    ID_PARAMETRO    VARCHAR(10)    NOT NULL,                      
    TI_PARAMETRO    VARCHAR(10),                                  
    VL_PARAMETRO    VARCHAR(50),                                  
    TX_DETALLE      VARCHAR(50),                                  
    PRIMARY KEY (ID_PARAMETRO)                                    
)                                                                 
;                                                                 
                                                                  
                                                                  
                                                                  
--                                                                
-- TABLE: PROYECTO                                                
--                                                                
                                                                  
CREATE TABLE PROYECTO(                                            
    ID_PROYECTO    DECIMAL(10, 0)    NOT NULL,                    
    NO_PROYECTO    CHAR(10),                                      
    PRIMARY KEY (ID_PROYECTO)                                     
)                                                                 
;                                                                 
                                                                  
                                                                  
                                                                  
--                                                                
-- TABLE: TECNOLOGIA                                              
--                                                                
                                                                  
CREATE TABLE TECNOLOGIA(                                          
    ID_TECNOLOGIA    DECIMAL(10, 0)    NOT NULL,                  
    ID_LENGUAJE      DECIMAL(10, 0)    NOT NULL,                  
    IN_ESTANDAR      CHAR(1),                                     
    NO_TECNOLOGIA    VARCHAR(50),                                 
    PRIMARY KEY (ID_TECNOLOGIA)                                   
)                                                                 
;                                                                 
                                                                  
                                                                  
                                                                  
--                                                                
-- TABLE: TECNOLOGIA_COMPONENTE                                   
--                                                                
                                                                  
CREATE TABLE TECNOLOGIA_COMPONENTE(                               
    ID_TECN_COMP      DECIMAL(10, 0)    NOT NULL,                 
    ID_TECNOLOGIA     DECIMAL(10, 0)    NOT NULL,                 
    ID_COLABORADOR    DECIMAL(10, 0)    NOT NULL,                 
    ID_HERRAMIENTA    DECIMAL(10, 0)    NOT NULL,                 
    TO_TIEMPO         DECIMAL(10, 0),                             
    PRIMARY KEY (ID_TECN_COMP)                                    
)                                                                 
;                                                                 
                                                                  
                                                                  
                                                                  
--                                                                
-- TABLE: ACTIVIDAD_COLABORADOR                                   
--                                                                
                                                                  
ALTER TABLE ACTIVIDAD_COLABORADOR ADD CONSTRAINT RefCOLABORADOR21 
    FOREIGN KEY (ID_COLABORADOR)                                  
    REFERENCES COLABORADOR(ID_COLABORADOR)                        
;                                                                 
                                                                  
ALTER TABLE ACTIVIDAD_COLABORADOR ADD CONSTRAINT fk_prueba        
    FOREIGN KEY (ID_PROYECTO)                                     
    REFERENCES PROYECTO(ID_PROYECTO)                              
;                                                                 
                                                                  
                                                                  
--                                                                
-- TABLE: ASIGNACION_TRABAJO                                      
--                                                                
                                                                  
ALTER TABLE ASIGNACION_TRABAJO ADD CONSTRAINT RefCOLABORADOR5     
    FOREIGN KEY (ID_COLABORADOR)                                  
    REFERENCES COLABORADOR(ID_COLABORADOR)                        
;                                                                 
                                                                  
ALTER TABLE ASIGNACION_TRABAJO ADD CONSTRAINT RefCOMPONENTE17     
    FOREIGN KEY (ID_COMPONENTE)                                   
    REFERENCES COMPONENTE(ID_COMPONENTE)                          
;                                                                 
                                                                  
ALTER TABLE ASIGNACION_TRABAJO ADD CONSTRAINT RefTECNOLOGIA34     
    FOREIGN KEY (ID_TECNOLOGIA)                                   
    REFERENCES TECNOLOGIA(ID_TECNOLOGIA)                          
;                                                                 
                                                                  
ALTER TABLE ASIGNACION_TRABAJO ADD CONSTRAINT RefHERRAMIENTA35    
    FOREIGN KEY (ID_HERRAMIENTA)                                  
    REFERENCES HERRAMIENTA(ID_HERRAMIENTA)                        
;                                                                 
                                                                  
                                                                  
--                                                                
-- TABLE: TECNOLOGIA                                              
--                                                                
                                                                  
ALTER TABLE TECNOLOGIA ADD CONSTRAINT RefLENGUAJE31               
    FOREIGN KEY (ID_LENGUAJE)                                     
    REFERENCES LENGUAJE(ID_LENGUAJE)                              
;                                                                 
                                                                  
                                                                  
--                                                                
-- TABLE: TECNOLOGIA_COMPONENTE                                   
--                                                                
                                                                  
ALTER TABLE TECNOLOGIA_COMPONENTE ADD CONSTRAINT RefTECNOLOGIA15  
    FOREIGN KEY (ID_TECNOLOGIA)                                   
    REFERENCES TECNOLOGIA(ID_TECNOLOGIA)                          
;                                                                 
                                                                  
ALTER TABLE TECNOLOGIA_COMPONENTE ADD CONSTRAINT RefCOLABORADOR18 
    FOREIGN KEY (ID_COLABORADOR)                                  
    REFERENCES COLABORADOR(ID_COLABORADOR)                        
;                                                                 
                                                                  
ALTER TABLE TECNOLOGIA_COMPONENTE ADD CONSTRAINT RefHERRAMIENTA39 
    FOREIGN KEY (ID_HERRAMIENTA)                                  
    REFERENCES HERRAMIENTA(ID_HERRAMIENTA)                        
;                                                                 
                                                                  
                                                                  