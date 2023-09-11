package com.utn.tpPersistencia.entidades;

import com.utn.tpPersistencia.enums.Estado;
import com.utn.tpPersistencia.enums.TipoEnvio;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pedido implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String fecha;
    private Estado estado;
    private Date horaEstimadaEntrega;
    private TipoEnvio tipoEnvio;
    private double total;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetallePedido> detallePedidos = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Factura factura;


}
