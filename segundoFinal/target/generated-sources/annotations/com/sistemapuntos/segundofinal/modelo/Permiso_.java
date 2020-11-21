package com.sistemapuntos.segundofinal.modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Permiso.class)
public abstract class Permiso_ {

	public static volatile SingularAttribute<Permiso, String> descripcion;
	public static volatile SingularAttribute<Permiso, Integer> idPermiso;
	public static volatile SingularAttribute<Permiso, Integer> tipoPermiso;
	public static volatile CollectionAttribute<Permiso, Usuario> usuarioCollection;

}

