package com.sistemainventario.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Ventas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idVenta;
    Integer cantidad;

    @ManyToOne
    @JoinColumn(name = "idProducto")
    private Producto producto;

    public enum TipoMovimiento{
        ENTRADA,
        SALIDA
    }

    @Enumerated(EnumType.STRING)
    private TipoMovimiento movimiento;

}
