package com.sistemapuntos.segundofinal.modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Auto.class)
public abstract class Auto_ {

	public static volatile CollectionAttribute<Auto, MecanicoPorAuto> mecanicoPorAutoCollection;
	public static volatile CollectionAttribute<Auto, Taller> tallerCollection;
	public static volatile SingularAttribute<Auto, String> color;
	public static volatile SingularAttribute<Auto, Usuario> idCliente;
	public static volatile SingularAttribute<Auto, Integer> idAuto;
	public static volatile SingularAttribute<Auto, String> matricula;
	public static volatile CollectionAttribute<Auto, Usuario> usuarioCollection;
	public static volatile SingularAttribute<Auto, String> modelo;

}

