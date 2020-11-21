package com.sistemapuntos.segundofinal.modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Factura.class)
public abstract class Factura_ {

	public static volatile SingularAttribute<Factura, Usuario> idCliente;
	public static volatile SingularAttribute<Factura, Integer> idFactura;
	public static volatile SingularAttribute<Factura, HojaRepuestosUsados> idHoja;
	public static volatile SingularAttribute<Factura, Integer> montoTotal;

}

