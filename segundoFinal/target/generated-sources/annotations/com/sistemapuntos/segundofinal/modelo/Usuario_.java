package com.sistemapuntos.segundofinal.modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Usuario.class)
public abstract class Usuario_ {

	public static volatile CollectionAttribute<Usuario, MecanicoPorAuto> mecanicoPorAutoCollection;
	public static volatile SingularAttribute<Usuario, Integer> ci;
	public static volatile CollectionAttribute<Usuario, Auto> autoCollection;
	public static volatile SingularAttribute<Usuario, Integer> idUsuario;
	public static volatile SingularAttribute<Usuario, String> apellido;
	public static volatile SingularAttribute<Usuario, Permiso> idPermisoUsuario;
	public static volatile SingularAttribute<Usuario, String> direccion;
	public static volatile CollectionAttribute<Usuario, Auto> autoCollection1;
	public static volatile SingularAttribute<Usuario, Long> telefono;
	public static volatile SingularAttribute<Usuario, String> nombre;
	public static volatile CollectionAttribute<Usuario, Factura> facturaCollection;

}

