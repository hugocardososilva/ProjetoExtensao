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
			t1.setNome("Programa de Extens�o");
			t1.setSigla("PRO");
			daoTipo.persist(t1);
			DAO.flush();
			
				TipoAtividade t2= new TipoAtividade();
				t2.setNome("Projeto de Extens�o");
				t2.setSigla("PE");				
				daoTipo.persist(t2);
				DAO.flush();
				
				TipoAtividade t3= new TipoAtividade();
				t3.setNome("Curso de Extens�o");
				t3.setSigla("CE");
				daoTipo.persist(t3);
				DAO.flush();
				
				TipoAtividade t4= new TipoAtividade();
				t4.setNome("Evento de Extens�o");
				t4.setSigla("EE");
				daoTipo.persist(t4);
				DAO.flush();
				
				TipoAtividade t5= new TipoAtividade();
				t5.setNome("Presta��o de Servi�o");
				t5.setSigla("PS");
				daoTipo.persist(t5);
				DAO.flush();
				
				TipoAtividade t6= new TipoAtividade();
				t6.setNome("Empreendedorismo");
				t6.setSigla("EP");
				daoTipo.persist(t6);
				DAO.flush();
				
				TipoAtividade t7= new TipoAtividade();
				t7.setNome("Visitas T�cnicas");
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
				v3.setNome("Inclus�o Digital");
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
			a1.setArea("�rea 1 -");
			a1.setDescricao("Comunica��o");
			a1.setSigla("COM");
			daoArea.persist(a1);
			DAO.flush();
			
			AreaTematica a2= new AreaTematica();
			a2.setArea("�rea 2 -");
			a2.setDescricao("Cultura");
			a2.setSigla("CUL");
			daoArea.persist(a2);
			DAO.flush();
			
			AreaTematica a3= new AreaTematica();
			a3.setArea("�rea 3 -");
			a3.setDescricao("Direitos Humanos e Justi�a");
			a3.setSigla("DHJ");
			daoArea.persist(a3);
			DAO.flush();
			
			AreaTematica a4= new AreaTematica();
			a4.setArea("�rea 4 -");
			a4.setDescricao("Educa��o ");
			a4.setSigla("EDU");
			daoArea.persist(a4);
			DAO.flush();
			
			AreaTematica a5= new AreaTematica();
			a5.setArea("�rea 5 -");
			a5.setDescricao("Meio Ambiente ");
			a5.setSigla("MAM");
			daoArea.persist(a5);
			DAO.flush();
			
			AreaTematica a6= new AreaTematica();
			a6.setArea("�rea 6 -");
			a6.setDescricao("Sa�de ");
			a6.setSigla("SAU");
			daoArea.persist(a6);
			DAO.flush();
			
			AreaTematica a7= new AreaTematica();
			a7.setArea("�rea 7 -");
			a7.setDescricao("Tecnologia e Produ��o ");
			a7.setSigla("TEC");
			daoArea.persist(a7);
			DAO.flush();
			
			AreaTematica a8= new AreaTematica();
			a8.setArea("�rea 8 -");
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
			l1.setDenominacao("Assist�ncia Jur�dica");
			l1.setDefinicoes("Assist�ncia jur�dica a pessoas, institui��es e oraniza��es");
			daoLinha.persist(l1);
			DAO.flush();
			//falta o restante
			DAO.commit();
			DAO.close();
			
			
	}
	public static void addLocalRealiza��o(){
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
				l2.setLocal("Campus Jo�o Pessoa");
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
				l7.setLocal("Campus Picu�");
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
				l11.setLocal("Centro de Referencia em Pesca e Navega��o Mar�tima");
				daoLocal.persist(l11);
				DAO.flush();
				
				LocalRealizacao l12= new LocalRealizacao();
				l12.setCodigo(012);
				l12.setLocal("N�cleo Avan�ado de Guarabira");
				daoLocal.persist(l12);
				DAO.flush();
		
			DAO.commit();
			DAO.close();
	}

}
