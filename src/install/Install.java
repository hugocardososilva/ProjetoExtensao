package install;

import models.AreaTematica;
import models.LinhaDeExtensao;
import models.LocalRealizacao;
import models.TipoAtividade;
import models.Vinculo;
import dao.DAO;
import dao.DAOAreaTematica;
import dao.DAOLinhaDeExtensao;
import dao.DAOLocalRealizacao;
import dao.DAOTipoAtividade;
import dao.DAOVinculo;

public class Install {
	public static void addTipoAtividade(){
		DAOTipoAtividade daoTipo= new DAOTipoAtividade();
		DAO.open();
		DAO.begin();
			TipoAtividade t1= new TipoAtividade();
			t1.setNome("Programa de Extensão");
			t1.setSigla("PRO");
			daoTipo.persist(t1);
			DAO.flush();
			
				TipoAtividade t2= new TipoAtividade();
				t2.setNome("Projeto de Extensão");
				t2.setSigla("PE");				
				daoTipo.persist(t2);
				DAO.flush();
				
				TipoAtividade t3= new TipoAtividade();
				t3.setNome("Curso de Extensão");
				t3.setSigla("CE");
				daoTipo.persist(t3);
				DAO.flush();
				
				TipoAtividade t4= new TipoAtividade();
				t4.setNome("Evento de Extensão");
				t4.setSigla("EE");
				daoTipo.persist(t4);
				DAO.flush();
				
				TipoAtividade t5= new TipoAtividade();
				t5.setNome("Prestação de Serviço");
				t5.setSigla("PS");
				daoTipo.persist(t5);
				DAO.flush();
				
				TipoAtividade t6= new TipoAtividade();
				t6.setNome("Empreendedorismo");
				t6.setSigla("EP");
				daoTipo.persist(t6);
				DAO.flush();
				
				TipoAtividade t7= new TipoAtividade();
				t7.setNome("Visitas Técnicas");
				t7.setSigla("VT");
				daoTipo.persist(t7);
				DAO.flush();
				
				TipoAtividade t8= new TipoAtividade();
				t8.setNome("Acompanhamento de Egressos");
				t8.setSigla("AE");
				daoTipo.persist(t8);
			DAO.flush();
			DAO.commit();
			DAO.close();
	}
	public static void addVinculos(){
		DAO.open();
		DAO.begin();
			DAOVinculo daoVinculo= new DAOVinculo();
				
				Vinculo v1= new Vinculo();
				v1.setNome("PROBEXT");
				daoVinculo.persist(v1);
				DAO.flush();
				
				Vinculo v2= new Vinculo();
				v2.setNome("PED");
				daoVinculo.persist(v2);
				DAO.flush();
				
				Vinculo v3= new Vinculo();
				v3.setNome("Inclusão Digital");
				daoVinculo.persist(v3);
				DAO.flush();
			
		DAO.commit();
		DAO.close();
		
	}
	
	public static void addAreaTematica(){
		DAO.open();
		DAO.begin();
			DAOAreaTematica daoArea= new DAOAreaTematica();
		
			AreaTematica a1= new AreaTematica();
			a1.setArea("Área 1 -");
			a1.setDescricao("Comunicação");
			a1.setSigla("COM");
			daoArea.persist(a1);
			DAO.flush();
			
			AreaTematica a2= new AreaTematica();
			a2.setArea("Área 2 -");
			a2.setDescricao("Cultura");
			a2.setSigla("CUL");
			daoArea.persist(a2);
			DAO.flush();
			
			AreaTematica a3= new AreaTematica();
			a3.setArea("Área 3 -");
			a3.setDescricao("Direitos Humanos e Justiça");
			a3.setSigla("DHJ");
			daoArea.persist(a3);
			DAO.flush();
			
			AreaTematica a4= new AreaTematica();
			a4.setArea("Área 4 -");
			a4.setDescricao("Educação ");
			a4.setSigla("EDU");
			daoArea.persist(a4);
			DAO.flush();
			
			AreaTematica a5= new AreaTematica();
			a5.setArea("Área 5 -");
			a5.setDescricao("Meio Ambiente ");
			a5.setSigla("MAM");
			daoArea.persist(a5);
			DAO.flush();
			
			AreaTematica a6= new AreaTematica();
			a6.setArea("Área 6 -");
			a6.setDescricao("Saúde ");
			a6.setSigla("SAU");
			daoArea.persist(a6);
			DAO.flush();
			
			AreaTematica a7= new AreaTematica();
			a7.setArea("Área 7 -");
			a7.setDescricao("Tecnologia e Produção ");
			a7.setSigla("TEC");
			daoArea.persist(a7);
			DAO.flush();
			
			AreaTematica a8= new AreaTematica();
			a8.setArea("Área 8 -");
			a8.setDescricao("Trabalho ");
			a8.setSigla("TRA");
			daoArea.persist(a8);
			DAO.flush();
			
			DAO.commit();
			DAO.close();
	}
	public static void addLinhaExtensao(){
		DAO.open();
		DAO.begin();
			DAOLinhaDeExtensao daoLinha= new DAOLinhaDeExtensao();
			LinhaDeExtensao l1= new LinhaDeExtensao();
			l1.setNumero(1);
			l1.setDenominacao("Assistência Jurídica");
			l1.setDefinicoes("Assistência jurídica a pessoas, instituições e oranizações");
			daoLinha.persist(l1);
			DAO.flush();
			//falta o restante
			DAO.commit();
			DAO.close();
			
			
	}
	public static void addLocalRealização(){
			DAO.open();
			DAO.begin();
				DAOLocalRealizacao daoLocal = new DAOLocalRealizacao();
				
				LocalRealizacao l1= new LocalRealizacao();
				l1.setCodigo(01);
				l1.setLocal("Reitoria");
				daoLocal.persist(l1);
				DAO.flush();
				
				LocalRealizacao l2= new LocalRealizacao();
				l2.setCodigo(02);
				l2.setLocal("Campus João Pessoa");
				daoLocal.persist(l2);
				DAO.flush();
				
				LocalRealizacao l3= new LocalRealizacao();
				l3.setCodigo(03);
				l3.setLocal("Campus Cajazeiras");
				daoLocal.persist(l3);
				DAO.flush();
				
				LocalRealizacao l4= new LocalRealizacao();
				l4.setCodigo(04);
				l4.setLocal("Campus Campina Grande");
				daoLocal.persist(l4);
				DAO.flush();
				
				LocalRealizacao l5= new LocalRealizacao();
				l5.setCodigo(05);
				l5.setLocal("Campus Sousa");
				daoLocal.persist(l5);
				DAO.flush();
				
				LocalRealizacao l6= new LocalRealizacao();
				l6.setCodigo(06);
				l6.setLocal("Campus Cabedelo");
				daoLocal.persist(l6);
				DAO.flush();
				
				LocalRealizacao l7= new LocalRealizacao();
				l7.setCodigo(07);
				l7.setLocal("Campus Picuí");
				daoLocal.persist(l7);
				DAO.flush();
				
				LocalRealizacao l8= new LocalRealizacao();
				l8.setCodigo(8);
				l8.setLocal("Campus Princesa Isabel");
				daoLocal.persist(l8);
				DAO.flush();
				
				LocalRealizacao l9= new LocalRealizacao();
				l9.setCodigo(9);
				l9.setLocal("Campus Patos");
				daoLocal.persist(l9);
				DAO.flush();
				
				LocalRealizacao l10= new LocalRealizacao();
				l10.setCodigo(010);
				l10.setLocal("Campus Monteiro");
				daoLocal.persist(l10);
				DAO.flush();
				
				LocalRealizacao l11= new LocalRealizacao();
				l11.setCodigo(011);
				l11.setLocal("Centro de Referencia em Pesca e Navegação Marítima");
				daoLocal.persist(l11);
				DAO.flush();
				
				LocalRealizacao l12= new LocalRealizacao();
				l12.setCodigo(012);
				l12.setLocal("Núcleo Avançado de Guarabira");
				daoLocal.persist(l12);
				DAO.flush();
		
			DAO.commit();
			DAO.close();
	}

}
