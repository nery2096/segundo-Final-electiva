package com.sistemapuntos.segundofinal.modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(HojaRepuestosUsados.class)
public abstract class HojaRepuestosUsados_ {

	public static volatile SingularAttribute<HojaRepuestosUsados, Integer> precio;
	public static volatile SingularAttribute<HojaRepuestosUsados, String> descripcionRepuesto;
	public static volatile SingularAttribute<HojaRepuestosUsados, Integer> idHoja;
	public static volatile CollectionAttribute<HojaRepuestosUsados, Factura> facturaCollection;

}

