package com.careful.clinic.dao.sp3.expertise;

import java.io.File;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.transform.Transformers;

import com.careful.clinic.model.ExpertiseRateMo;
import com.careful.clinic.model.ListExcelFiles;
import com.careful.clinic.model.PersonModel;
import com.careful.clinic.model.Wrap3a_b_Expertise;

@Stateless
public class Sp3ExpertiseDaoBean implements ISp3ExpertiseDao {
	
	@PersistenceContext(unitName="OracleMUR2017")
    private EntityManager mur_collect2017;
	
	@PersistenceContext(unitName="OracleMUR2018")
    private EntityManager mur_collect2018;
	
	@PersistenceContext(unitName="NONXAMUR2018")
    private EntityManager non_mur_collect2018;
	
	
	
	 
	 @Override
	 public List<Wrap3a_b_Expertise> getResalt3b_expertise(String date1,String date2,String user, int firrstResult) {
		 
		 String g = user.equals("777")  ?  " " : " and  p.smoid ="+user+ " " ;
		 String sb = "select p.FIO,p.dr, p.SMOID,p.SERPOLIS,p.NUMPOLIS,p.lpu,p.AMBKARTA, p.DAT_BEG,p.DAT_END,LPU_PRIK,p.s1,p.account,p.AC_DATE,p.REZOBR, p.ds1 as f_mkb_usl, f_person_telephone_v2@dome_dev(p.fam, p.im, p.ot, p.dr) as tel, p.id " 
				 +"from "
				 +"demand d, pat p "
				 +"where "
				 +"d.id_demand = p.demand_id " 
				 +"and  p.caretype = 30 "
				 +"and   p.REZOBR in (21, 23, 14,15) " 
				 +"and  d.period between ' "+date1+" ' and ' "+date2+" ' "  
				 +"and  p.dat_end >= '01.01.2018'  "
				 + g
				 +" and ((substr(p.ds1,0,1) = 'I') or (substr(p.ds1,0,1) = 'C') or (p.ds1 between 'E10' and 'E13.99') or (p.ds1 between 'J44' and 'J47.99') or p.ds1 is null) " 
				 +"and  p.mes between '401048' and '401071' "
				 // брать в список людей первого этапа ('401048' and '401071')  если их нет в подзапросе ниже 
				 +"and (p.fam,p.dr) not in ( "
				 // оставляем только тех в второэтапников у которых первый этап по месам 1-го этапа (401048 - 401071)
				 // выделяем из второго этапа терапевта по мему 401072 и на выход подаем фиод (т.е. это второэтапники (по терапевтическому мэсу) у которых 1 этап в этом году)
				                          +"select zz.fio,zz.dr "
				                            +"from "
				                            +"( "
				                            +"select p.fio,p.dr,p.mes "
				                            +"from "
				                            +"demand d, pat p "
				                            +"where "
				                             +"d.id_demand = p.demand_id " 
				                             +"and  p.caretype = 30 "
				                             +"and   p.REZOBR in (21, 23, 14,15) " 
				                             //+"and  d.period between ' 201801 ' and ' 201802 ' "  
				                             +"and  p.dat_end >= '01.01.2018' "  
				                            // and  p.smoid =4 "  
				                             //+"and ((substr(p.ds1,0,1) <> 'I')and(substr(p.ds1,0,1) <> 'C')and(p.ds1 not between 'E10' and 'E13.99')and(p.ds1 not between 'J44' and 'J47.99')) " 
				                             +"and  p.mes between '401048' and '401080' "
				                             +"and exists (select 1 from pat pp where pp.caretype = 30 and mes between '401048' and '401071'  and pp.fio = p.fio and pp.dr = p.dr) "
				                             +") zz "
				                             +"where zz.mes='401072' "
				                            
				+") "
				+"union all "
				// присоединям второэтапников 
				+"select  zz.FIO,zz.dr, zz.SMOID,zz.SERPOLIS,zz.NUMPOLIS,LPU,zz.AMBKARTA, zz.DAT_BEG,zz.DAT_END,zz.LPU_PRIK,zz.s1,zz.account,zz.AC_DATE,zz.REZOBR, zz.ds1 as f_mkb_usl, f_person_telephone_v2@dome_dev(zz.fam, zz.im, zz.ot, zz.drr) as tel, zz.id " 
				                            +"from "
				                            +"( "
				                            +"select p.mes,p.FIO,p.dr, p.SMOID,p.SERPOLIS,p.NUMPOLIS,p.lpu,p.AMBKARTA, p.DAT_BEG,p.DAT_END,LPU_PRIK,p.s1,p.account,p.AC_DATE,p.REZOBR, p.ds1, p.fam, p.im, p.ot, p.dr as drr, p.id " 
				                            +"from "
				                            +"demand d, pat p "
				                            +"where "
				                             +"d.id_demand = p.demand_id " 
				                             +"and  p.caretype = 30 "
				                             +"and   p.REZOBR in (21, 23, 14,15) " 
				                             +"and  d.period between ' "+date1+" ' and ' "+date2+" ' "  
				                             +"and  p.dat_end >= '01.01.2018' "
				                             + g 
				                             +" and ((substr(p.ds1,0,1) = 'I') or (substr(p.ds1,0,1) = 'C') or (p.ds1 between 'E10' and 'E13.99') or (p.ds1 between 'J44' and 'J47.99') or p.ds1 is null) " 
				                             +"and  p.mes between '401048' and '401080' "
				                             +"and exists (select 1 from pat pp where pp.caretype = 30 and mes between '401048' and '401071'  and pp.fio = p.fio and pp.dr = p.dr) "
				                             +") zz "
				                             +"where zz.mes='401072'";
		 
		// TODO сделать выбор базы на сайте
			Query q = non_mur_collect2018.createNativeQuery(sb);
			
			q.setFirstResult(firrstResult);
			q.setMaxResults(60_000);
			List<Object[]> res = q.getResultList();
			// for processed data
			List<Wrap3a_b_Expertise> ls = new ArrayList<Wrap3a_b_Expertise>(res.size());
			
			res.stream().forEach((record) -> {
				
				String _0 = (String) record[0];
				Date _1 = (Date) record[1];
				Long _2 = ((BigDecimal) record[2]).longValue();
				String _3 = (String) record[3];
				String _4 = (String) record[4];
				String _5 = (String)  record[5];
				String _6 = (String) record[6];
				Date _7 = (Date) record[7];
				Date _8 = (Date) record[8];
				Long _9 = ((BigDecimal)  record[9]).longValue();
				Long _10 = ((BigDecimal) record[10]).longValue();
				Long _11 = ((BigDecimal) record[11]).longValue();
				Date _12 = (Date) record[12];
				String _13 = (String) record[13];
				String _14 = (String) record[14];
				String _tel = (String) record[15];
				Long _id = ((BigDecimal)  record[16]).longValue();
			
				ls.add(new Wrap3a_b_Expertise(_0, _1, _2, _3,_4,_5, _6,_7,_8,_9,_10,_11,_12,_13,_14, _tel, _id));
			
		});
			
			res=null;
		    return ls;
		 
	 }
	
	 @Override
	public List<Wrap3a_b_Expertise> getResalt3a_expertise(String date1,String date2,String user, int firrstResult) throws Exception{
		
		
		
		
		
		//TODO полных лет
		String g = user.equals("777")  ?  " " : " and  p.smoid ="+user+ " " ;
		String sb = "select p.FIO,p.dr, p.SMOID,p.SERPOLIS,p.NUMPOLIS,p.lpu,p.AMBKARTA, p.DAT_BEG,p.DAT_END,LPU_PRIK,p.s1,p.account,p.AC_DATE,p.REZOBR, p.ds1 as f_mkb_usl, f_person_telephone_v2@dome_dev(p.fam, p.im, p.ot, p.dr) as tel, p.id " 
				 +"from "
				 +"demand d, pat p "
				 +"where "
				 +"d.id_demand = p.demand_id " 
				 +"and  p.caretype = 30 "
				 +"and   p.REZOBR in (22) " 
				 +"and  d.period between ' "+date1+" ' and ' "+date2+" ' "  
				 +"and  p.dat_end >= '01.01.2018'  "
				 + g
				 +" and ((substr(p.ds1,0,1) <> 'I')and(substr(p.ds1,0,1) <> 'C')and(p.ds1 not between 'E10' and 'E13.99')and(p.ds1 not between 'J44' and 'J47.99')) " 
				 +"and  p.mes between '401048' and '401071' "
				 // брать в список людей первого этапа ('401048' and '401071')  если их нет в подзапросе ниже 
				 +"and (p.fam,p.dr) not in ( "
				 // оставляем только тех в второэтапников у которых первый этап по месам 1-го этапа (401048 - 401071)
				 // выделяем из второго этапа терапевта по мему 401072 и на выход подаем фиод (т.е. это второэтапники (по терапевтическому мэсу) у которых 1 этап в этом году)
				                          +"select zz.fio,zz.dr "
				                            +"from "
				                            +"( "
				                            +"select p.fio,p.dr,p.mes "
				                            +"from "
				                            +"demand d, pat p "
				                            +"where "
				                             +"d.id_demand = p.demand_id " 
				                             +"and  p.caretype = 30 "
				                             +"and   p.REZOBR in (22) " 
				                             //+"and  d.period between ' 201801 ' and ' 201802 ' "  
				                             +"and  p.dat_end >= '01.01.2018' "  
				                            // and  p.smoid =4 "  
				                             //+"and ((substr(p.ds1,0,1) <> 'I')and(substr(p.ds1,0,1) <> 'C')and(p.ds1 not between 'E10' and 'E13.99')and(p.ds1 not between 'J44' and 'J47.99')) " 
				                             +"and  p.mes between '401048' and '401080' "
				                             +"and exists (select 1 from pat pp where pp.caretype = 30 and mes between '401048' and '401071'  and pp.fio = p.fio and pp.dr = p.dr) "
				                             +") zz "
				                             +"where zz.mes='401072' "
				                            
				+") "
				+"union all "
				// присоединям второэтапников 
				+"select  zz.FIO,zz.dr, zz.SMOID,zz.SERPOLIS,zz.NUMPOLIS,LPU,zz.AMBKARTA, zz.DAT_BEG,zz.DAT_END,zz.LPU_PRIK,zz.s1,zz.account,zz.AC_DATE,zz.REZOBR, zz.ds1 as f_mkb_usl, f_person_telephone_v2@dome_dev(zz.fam, zz.im, zz.ot, zz.drr) as tel, zz.id " 
				                            +"from "
				                            +"( "
				                            +"select p.mes,p.FIO,p.dr, p.SMOID,p.SERPOLIS,p.NUMPOLIS,p.lpu,p.AMBKARTA, p.DAT_BEG,p.DAT_END,LPU_PRIK,p.s1,p.account,p.AC_DATE,p.REZOBR, p.ds1, p.fam, p.im, p.ot, p.dr as drr, p.id " 
				                            +"from "
				                            +"demand d, pat p "
				                            +"where "
				                             +"d.id_demand = p.demand_id " 
				                             +"and  p.caretype = 30 "
				                             +"and   p.REZOBR in (22) " 
				                             +"and  d.period between ' "+date1+" ' and ' "+date2+" ' "  
				                             +"and  p.dat_end >= '01.01.2018' "
				                             + g 
				                             +" and ((substr(p.ds1,0,1) <> 'I')and(substr(p.ds1,0,1) <> 'C')and(p.ds1 not between 'E10' and 'E13.99')and(p.ds1 not between 'J44' and 'J47.99')) " 
				                             +"and  p.mes between '401048' and '401080' "
				                             +"and exists (select 1 from pat pp where pp.caretype = 30 and mes between '401048' and '401071'  and pp.fio = p.fio and pp.dr = p.dr) "
				                             +") zz "
				                             +"where zz.mes='401072'";
				//+ " p.fam='"+personmodel.getSurname()+"' and p.im='"+personmodel.getFirstname()+"' and p.ot='"+personmodel.getLastname()+"' and p.dr='"+personmodel.getBithday()+"' ";
		// TODO сделать выбор базы на сайте
		Query q = non_mur_collect2018.createNativeQuery(sb);
		
		q.setFirstResult(firrstResult);
		q.setMaxResults(60_000);
		List<Object[]> res = q.getResultList();
		// for processed data
		List<Wrap3a_b_Expertise> ls = new ArrayList<Wrap3a_b_Expertise>(res.size());
		
		res.stream().forEach((record) -> {
			
			String _0 = (String) record[0];
			Date _1 = (Date) record[1];
			Long _2 = ((BigDecimal) record[2]).longValue();
			String _3 = (String) record[3];
			String _4 = (String) record[4];
			String _5 = (String)  record[5];
			String _6 = (String) record[6];
			Date _7 = (Date) record[7];
			Date _8 = (Date) record[8];
			Long _9 = ((BigDecimal)  record[9]).longValue();
			Long _10 = ((BigDecimal) record[10]).longValue();
			Long _11 = ((BigDecimal) record[11]).longValue();
			Date _12 = (Date) record[12];
			String _13 = (String) record[13];
			String _14 = (String) record[14];
			String _tel = (String) record[15];
			Long _id = ((BigDecimal)  record[16]).longValue();
		
			ls.add(new Wrap3a_b_Expertise(_0, _1, _2, _3,_4,_5, _6,_7,_8,_9,_10,_11,_12,_13,_14, _tel, _id));
		
	});
		
		res=null;
	    return ls;
	}

	@Override
	public List<?> getListExperiseReport(Integer id) {

		String directoryServer = System.getProperty("jboss.home.dir");
		String directoryDestination = "";
		if(id == 777) directoryDestination = "\\content\\report\\sp3\\expert\\777";
		if(id == 1)	directoryDestination = "\\content\\report\\sp3\\expert\\1";
		if(id == 2)	directoryDestination = "\\content\\report\\sp3\\expert\\2";
		if(id == 4)	directoryDestination = "\\content\\report\\sp3\\expert\\4";
		
		directoryDestination = directoryServer+directoryDestination;
		//TODO создать компонент utils в ejb и сделать метод сортировки по дата изменения файла 
		File path = new File(directoryDestination);
		File[] files = path.listFiles();
		Arrays.sort(files, (a, b) -> Long.compare(b.lastModified(), a.lastModified()));
		
		List<ListExcelFiles> ls = new ArrayList<ListExcelFiles>();
		for(int i=0;i < files.length;i++){
			ls.add(new ListExcelFiles(files[i].getName(),directoryDestination+File.separator+files[i].getName()));
		}
		
		return ls;
	}

	@Override
	public List<?> getResalt3a3b_expertise(String date1,String date2,String user, int firrstResult) {
		//TODO полных лет
		String g = user.equals("777")  ?  " " : " and  p.smoid ="+user+ " " ;
		String sb = "select distinct"
				+ " p.FIO,p.dr, p.SMOID,p.SERPOLIS,p.NUMPOLIS,p.lpu,p.AMBKARTA, p.DAT_BEG,p.DAT_END,LPU_PRIK,p.s1,p.account,p.AC_DATE,p.REZOBR, f_mkb_usl(p.id) as f_mkb_usl, f_person_telephone_v2@dome_dev(p.fam, p.im, p.ot, p.dr) as tel, p.id"
				+ " from demand d, pat p, pat_usl pu where "
				+ "d.id_demand = p.demand_id"
				+ " and "
				+ " pu.id = p.id "
				+ " and "
				+ " p.caretype = 30 "
				+" and "
				+ "  p.REZOBR in (22, 23) "
				+ " and "
				+ " (p.nazr <> 5 and p.nazr <> 7)  and p.pr_d_n <> 1"
				+ " and "
				+ " d.period between ' "+date1+" ' and ' "+date2+" '"
				+ "  and "
				+ " p.dat_end >= '01.01.2018' "
				+ g ;
				//+ " p.fam='"+personmodel.getSurname()+"' and p.im='"+personmodel.getFirstname()+"' and p.ot='"+personmodel.getLastname()+"' and p.dr='"+personmodel.getBithday()+"' ";
		// TODO сделать выбор базы на сайте
		Query q = non_mur_collect2018.createNativeQuery(sb);
		
		q.setFirstResult(firrstResult);
		q.setMaxResults(60_000);
		List<Object[]> res = q.getResultList();
		// for processed data
		List<Wrap3a_b_Expertise> ls = new ArrayList<Wrap3a_b_Expertise>(res.size());
		
		res.stream().forEach((record) -> {
			
			String _0 = (String) record[0];
			Date _1 = (Date) record[1];
			Long _2 = ((BigDecimal) record[2]).longValue();
			String _3 = (String) record[3];
			String _4 = (String) record[4];
			String _5 = (String)  record[5];
			String _6 = (String) record[6];
			Date _7 = (Date) record[7];
			Date _8 = (Date) record[8];
			Long _9 = ((BigDecimal)  record[9]).longValue();
			Long _10 = ((BigDecimal) record[10]).longValue();
			Long _11 = ((BigDecimal) record[11]).longValue();
			Date _12 = (Date) record[12];
			String _13 = (String) record[13];
			String _14 = (String) record[14];
			String _tel = (String) record[15];
			Long _id = ((BigDecimal)  record[16]).longValue();
		
			ls.add(new Wrap3a_b_Expertise(_0, _1, _2, _3,_4,_5, _6,_7,_8,_9,_10,_11,_12,_13,_14, _tel, _id));
		
	});
		
		res=null;
	    return ls;
	}

	@Override
	public List<ExpertiseRateMo> getResalt3b_expertiseRateMo(String date1, String date2, String user) {
		
		String g = user.equals("777")  ?  " " : " and  p.smoid ="+user+ " " ;
		String sb = "select "
				+" tmp1.lp as code_mo , "
				+" tmp.name as name_mo, "
				+" tmp1.total, "
				+" tmp1.total_1, "
				+" tmp1.total_2, "
				+" tmp1.total_4 " 
				+" from "
				 +" (  select  z_tmp.lpu as lp,  count(*) total,  count ( case when z_tmp.smoid = 1 then 1 end ) total_1,  count ( case when z_tmp.smoid = 2 then 1 end ) total_2,  count ( case when z_tmp.smoid = 4 then 1 end ) total_4  from "
				      +" ( "
				      +"select p.FIO,p.dr, p.SMOID,p.SERPOLIS,p.NUMPOLIS,p.lpu,p.AMBKARTA, p.DAT_BEG,p.DAT_END,LPU_PRIK,p.s1,p.account,p.AC_DATE,p.REZOBR, p.ds1 as f_mkb_usl, f_person_telephone_v2@dome_dev(p.fam, p.im, p.ot, p.dr) as tel, p.id " 
								 +"from "
								 +"demand d, pat p "
								 +"where "
								 +"d.id_demand = p.demand_id " 
								 +"and  p.caretype = 30 "
								 +"and   p.REZOBR in (21, 23, 14,15) " 
								 +"and  d.period between ' "+date1+" ' and ' "+date2+" ' "  
								 +"and  p.dat_end >= '01.01.2018'  "
								 + g
								 +" and ((substr(p.ds1,0,1) = 'I') or (substr(p.ds1,0,1) = 'C') or (p.ds1 between 'E10' and 'E13.99') or (p.ds1 between 'J44' and 'J47.99') or p.ds1 is null) " 
								 +"and  p.mes between '401048' and '401071' "
								 // брать в список людей первого этапа ('401048' and '401071')  если их нет в подзапросе ниже 
								 +"and (p.fam,p.dr) not in ( "
								 // оставляем только тех в второэтапников у которых первый этап по месам 1-го этапа (401048 - 401071)
								 // выделяем из второго этапа терапевта по мему 401072 и на выход подаем фиод (т.е. это второэтапники (по терапевтическому мэсу) у которых 1 этап в этом году)
								                          +"select zz.fio,zz.dr "
								                            +"from "
								                            +"( "
								                            +"select p.fio,p.dr,p.mes "
								                            +"from "
								                            +"demand d, pat p "
								                            +"where "
								                             +"d.id_demand = p.demand_id " 
								                             +"and  p.caretype = 30 "
								                             +"and   p.REZOBR in (21, 23, 14,15) " 
								                             //+"and  d.period between ' 201801 ' and ' 201802 ' "  
								                             +"and  p.dat_end >= '01.01.2018' "  
								                            // and  p.smoid =4 "  
								                             //+"and ((substr(p.ds1,0,1) <> 'I')and(substr(p.ds1,0,1) <> 'C')and(p.ds1 not between 'E10' and 'E13.99')and(p.ds1 not between 'J44' and 'J47.99')) " 
								                             +"and  p.mes between '401048' and '401080' "
								                             +"and exists (select 1 from pat pp where pp.caretype = 30 and mes between '401048' and '401071'  and pp.fio = p.fio and pp.dr = p.dr) "
								                             +") zz "
								                             +"where zz.mes='401072' "
								                            
								+") "
								+"union all "
								// присоединям второэтапников 
								+"select  zz.FIO,zz.dr, zz.SMOID,zz.SERPOLIS,zz.NUMPOLIS,LPU,zz.AMBKARTA, zz.DAT_BEG,zz.DAT_END,zz.LPU_PRIK,zz.s1,zz.account,zz.AC_DATE,zz.REZOBR, zz.ds1 as f_mkb_usl, f_person_telephone_v2@dome_dev(zz.fam, zz.im, zz.ot, zz.drr) as tel, zz.id " 
								                            +"from "
								                            +"( "
								                            +"select p.mes,p.FIO,p.dr, p.SMOID,p.SERPOLIS,p.NUMPOLIS,p.lpu,p.AMBKARTA, p.DAT_BEG,p.DAT_END,LPU_PRIK,p.s1,p.account,p.AC_DATE,p.REZOBR, p.ds1, p.fam, p.im, p.ot, p.dr as drr, p.id " 
								                            +"from "
								                            +"demand d, pat p "
								                            +"where "
								                             +"d.id_demand = p.demand_id " 
								                             +"and  p.caretype = 30 "
								                             +"and   p.REZOBR in (21, 23, 14,15) " 
								                             +"and  d.period between ' "+date1+" ' and ' "+date2+" ' "  
								                             +"and  p.dat_end >= '01.01.2018' "
								                             + g 
								                             +" and ((substr(p.ds1,0,1) = 'I') or (substr(p.ds1,0,1) = 'C') or (p.ds1 between 'E10' and 'E13.99') or (p.ds1 between 'J44' and 'J47.99') or p.ds1 is null) " 
								                             +"and  p.mes between '401048' and '401080' "
								                             +"and exists (select 1 from pat pp where pp.caretype = 30 and mes between '401048' and '401071'  and pp.fio = p.fio and pp.dr = p.dr) "
								                             +") zz "
								                             +"where zz.mes='401072' "
				       +" )     z_tmp "
				    +" group  by z_tmp.lpu  order  by 2 desc "  
				 +" ) tmp1,  "
				 +" (  select  distinct substr(t.mo_mcod,4,6) as codl,t.mo_nam_mok as name from medical_organization@dome_dawn t  where t.mo_d_end is null  and t.mo_mcod like '540%'  and t.mo_d_edit = (select max(t2.mo_d_edit) from medical_organization@dome_dawn t2 where t.mo_mcod = t2.mo_mcod)  ) tmp  where tmp1.lp = tmp.codl";
		// TODO сделать выбор базы на сайте
		Query q = non_mur_collect2018.createNativeQuery(sb);
		
		List<Object[]> res = q.getResultList();
		// for processed data
		List<ExpertiseRateMo> ls = new ArrayList<ExpertiseRateMo>(res.size());
		
		res.stream().forEach((record) -> {
			
			String _0 = (String) record[0];
			String _1 = (String) record[1];
			Long _2 = ((BigDecimal) record[2]).longValue();
			Long _3 = ((BigDecimal) record[3]).longValue();
			Long _4 = ((BigDecimal) record[4]).longValue();
			Long _5 = ((BigDecimal) record[5]).longValue();
		
			ls.add(new ExpertiseRateMo(_0, _1, _2, _3,_4,_5));
		
	});
		
		res=null;
		
	    return ls;

	}
	
	@Override
	public List<ExpertiseRateMo> getResalt3a3b_expertiseRateMo(String date1, String date2, String user) {
		
		String g = user.equals("777")  ?  " " : " and  p.smoid ="+user+ " " ;
		String sb = "select "
				+" tmp1.lp as code_mo , "
				+" tmp.name as name_mo, "
				+" tmp1.total, "
				+" tmp1.total_1, "
				+" tmp1.total_2, "
				+" tmp1.total_4 " 
				+" from "
				 +" (  select  z_tmp.lpu as lp,  count(*) total,  count ( case when z_tmp.smoid = 1 then 1 end ) total_1,  count ( case when z_tmp.smoid = 2 then 1 end ) total_2,  count ( case when z_tmp.smoid = 4 then 1 end ) total_4  from "
				      +" ( "
				        +" select "
				        +" distinct p.FIO,p.dr, p.SMOID,p.SERPOLIS,p.NUMPOLIS,p.lpu,p.AMBKARTA, p.DAT_BEG,p.DAT_END,LPU_PRIK,p.s1,p.account,p.AC_DATE,p.REZOBR " 
				         +" from "
				         +" demand d, pat p, pat_usl pu " 
				               +" where "
				               +" d.id_demand = p.demand_id and "
				               +" pu.id = p.id  and "
				               +" p.caretype = 30 "
				               + g
				               + "  and  p.REZOBR in (22, 23) and "
				               + " (p.nazr <> 5 and p.nazr <> 7)  and p.pr_d_n <> 1 "
								+" and "
				               + " d.period between ' "+date1+" ' and ' "+date2+" '"
				               + " and  p.dat_end >= '01.01.2018' "
				       +" )     z_tmp "
				    +" group  by z_tmp.lpu  order  by 2 desc "  
				 +" ) tmp1,  "
				 +" (  select  distinct substr(t.mo_mcod,4,6) as codl,t.mo_nam_mok as name from medical_organization@dome_dawn t  where t.mo_d_end is null  and t.mo_mcod like '540%'  and t.mo_d_edit = (select max(t2.mo_d_edit) from medical_organization@dome_dawn t2 where t.mo_mcod = t2.mo_mcod)  ) tmp  where tmp1.lp = tmp.codl";
		// TODO сделать выбор базы на сайте
		Query q = non_mur_collect2018.createNativeQuery(sb);
		
		List<Object[]> res = q.getResultList();
		// for processed data
		List<ExpertiseRateMo> ls = new ArrayList<ExpertiseRateMo>(res.size());
		
		res.stream().forEach((record) -> {
			
			String _0 = (String) record[0];
			String _1 = (String) record[1];
			Long _2 = ((BigDecimal) record[2]).longValue();
			Long _3 = ((BigDecimal) record[3]).longValue();
			Long _4 = ((BigDecimal) record[4]).longValue();
			Long _5 = ((BigDecimal) record[5]).longValue();
		
			ls.add(new ExpertiseRateMo(_0, _1, _2, _3,_4,_5));
		
	});
		
		res=null;
		
	    return ls;

		
	}
	
	@Override
	public List<ExpertiseRateMo> getResalt3a_expertiseRateMo(String date1, String date2, String user) {
		
		String g = user.equals("777")  ?  " " : " and  p.smoid ="+user+ " " ;
		String sb = "select "
+" tmp1.lp as code_mo , "
+" tmp.name as name_mo, "
+" tmp1.total, "
+" tmp1.total_1, "
+" tmp1.total_2, "
+" tmp1.total_4 " 
+" from "
 +" (  select  z_tmp.lpu as lp,  count(*) total,  count ( case when z_tmp.smoid = 1 then 1 end ) total_1,  count ( case when z_tmp.smoid = 2 then 1 end ) total_2,  count ( case when z_tmp.smoid = 4 then 1 end ) total_4  from "
      +" ( "
      +"select p.FIO,p.dr, p.SMOID,p.SERPOLIS,p.NUMPOLIS,p.lpu,p.AMBKARTA, p.DAT_BEG,p.DAT_END,LPU_PRIK,p.s1,p.account,p.AC_DATE,p.REZOBR, p.ds1 as f_mkb_usl, f_person_telephone_v2@dome_dev(p.fam, p.im, p.ot, p.dr) as tel, p.id " 
				 +"from "
				 +"demand d, pat p "
				 +"where "
				 +"d.id_demand = p.demand_id " 
				 +"and  p.caretype = 30 "
				 +"and   p.REZOBR in (22) " 
				 +"and  d.period between ' "+date1+" ' and ' "+date2+" ' "  
				 +"and  p.dat_end >= '01.01.2018'  "
				 + g
				 +" and ((substr(p.ds1,0,1) <> 'I')and(substr(p.ds1,0,1) <> 'C')and(p.ds1 not between 'E10' and 'E13.99')and(p.ds1 not between 'J44' and 'J47.99')) " 
				 +"and  p.mes between '401048' and '401071' "
				 // брать в список людей первого этапа ('401048' and '401071')  если их нет в подзапросе ниже 
				 +"and (p.fam,p.dr) not in ( "
				 // оставляем только тех в второэтапников у которых первый этап по месам 1-го этапа (401048 - 401071)
				 // выделяем из второго этапа терапевта по мему 401072 и на выход подаем фиод (т.е. это второэтапники (по терапевтическому мэсу) у которых 1 этап в этом году)
				                          +"select zz.fio,zz.dr "
				                            +"from "
				                            +"( "
				                            +"select p.fio,p.dr,p.mes "
				                            +"from "
				                            +"demand d, pat p "
				                            +"where "
				                             +"d.id_demand = p.demand_id " 
				                             +"and  p.caretype = 30 "
				                             +"and   p.REZOBR in (22) " 
				                             //+"and  d.period between ' 201801 ' and ' 201802 ' "  
				                             +"and  p.dat_end >= '01.01.2018' "  
				                            // and  p.smoid =4 "  
				                             //+"and ((substr(p.ds1,0,1) <> 'I')and(substr(p.ds1,0,1) <> 'C')and(p.ds1 not between 'E10' and 'E13.99')and(p.ds1 not between 'J44' and 'J47.99')) " 
				                             +"and  p.mes between '401048' and '401080' "
				                             +"and exists (select 1 from pat pp where pp.caretype = 30 and mes between '401048' and '401071'  and pp.fio = p.fio and pp.dr = p.dr) "
				                             +") zz "
				                             +"where zz.mes='401072' "
				                            
				+") "
				+"union all "
				// присоединям второэтапников 
				+"select  zz.FIO,zz.dr, zz.SMOID,zz.SERPOLIS,zz.NUMPOLIS,LPU,zz.AMBKARTA, zz.DAT_BEG,zz.DAT_END,zz.LPU_PRIK,zz.s1,zz.account,zz.AC_DATE,zz.REZOBR, zz.ds1 as f_mkb_usl, f_person_telephone_v2@dome_dev(zz.fam, zz.im, zz.ot, zz.drr) as tel, zz.id " 
				                            +"from "
				                            +"( "
				                            +"select p.mes,p.FIO,p.dr, p.SMOID,p.SERPOLIS,p.NUMPOLIS,p.lpu,p.AMBKARTA, p.DAT_BEG,p.DAT_END,LPU_PRIK,p.s1,p.account,p.AC_DATE,p.REZOBR, p.ds1, p.fam, p.im, p.ot, p.dr as drr, p.id " 
				                            +"from "
				                            +"demand d, pat p "
				                            +"where "
				                             +"d.id_demand = p.demand_id " 
				                             +"and  p.caretype = 30 "
				                             +"and   p.REZOBR in (22) " 
				                             +"and  d.period between ' "+date1+" ' and ' "+date2+" ' "  
				                             +"and  p.dat_end >= '01.01.2018' "
				                             + g 
				                             +" and ((substr(p.ds1,0,1) <> 'I')and(substr(p.ds1,0,1) <> 'C')and(p.ds1 not between 'E10' and 'E13.99')and(p.ds1 not between 'J44' and 'J47.99')) " 
				                             +"and  p.mes between '401048' and '401080' "
				                             +"and exists (select 1 from pat pp where pp.caretype = 30 and mes between '401048' and '401071'  and pp.fio = p.fio and pp.dr = p.dr) "
				                             +") zz "
				                             +"where zz.mes='401072' "
       +" )     z_tmp "
    +" group  by z_tmp.lpu  order  by 2 desc "  
 +" ) tmp1,  "
 +" (  select  distinct substr(t.mo_mcod,4,6) as codl,t.mo_nam_mok as name from medical_organization@dome_dawn t  where t.mo_d_end is null  and t.mo_mcod like '540%'  and t.mo_d_edit = (select max(t2.mo_d_edit) from medical_organization@dome_dawn t2 where t.mo_mcod = t2.mo_mcod)  ) tmp  where tmp1.lp = tmp.codl"; 
		
		// TODO сделать выбор базы на сайте
		Query q = non_mur_collect2018.createNativeQuery(sb);
		
		List<Object[]> res = q.getResultList();
		// for processed data
		List<ExpertiseRateMo> ls = new ArrayList<ExpertiseRateMo>(res.size());
		
		res.stream().forEach((record) -> {
			
			String _0 = (String) record[0];
			String _1 = (String) record[1];
			Long _2 = ((BigDecimal) record[2]).longValue();
			Long _3 = ((BigDecimal) record[3]).longValue();
			Long _4 = ((BigDecimal) record[4]).longValue();
			Long _5 = ((BigDecimal) record[5]).longValue();
		
			ls.add(new ExpertiseRateMo(_0, _1, _2, _3,_4,_5));
		
	});
		
		res=null;
		
	    return ls;
	}

	
	
}
