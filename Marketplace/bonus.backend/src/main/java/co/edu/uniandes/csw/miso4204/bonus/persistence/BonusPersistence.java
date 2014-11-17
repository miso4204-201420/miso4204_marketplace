/* ========================================================================
 * Copyright 2014 miso4204
 *
 * Licensed under the MIT, The MIT License (MIT)
 * Copyright (c) 2014 miso4204

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
 * ========================================================================


Source generated by CrudMaker version 1.0.0.qualifier

*/

package co.edu.uniandes.csw.miso4204.bonus.persistence;

import co.edu.uniandes.csw.miso4204.bonus.logic.dto.BonusPageDTO;
import co.edu.uniandes.csw.miso4204.bonus.persistence.converter.BonusConverter;
import co.edu.uniandes.csw.miso4204.bonus.persistence.entity.BonusEntity;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class BonusPersistence extends _BonusPersistence{

	public BonusPersistence(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BonusPU");
		entityManager = emf.createEntityManager();
	}
	
	@SuppressWarnings("unchecked")
	public BonusPageDTO getBonussDate(String minDate, String maxDate,Integer page, Integer maxRecords) {
            
            minDate= minDate == null ? "0000/00/00" : minDate;
            maxDate= maxDate == null ? "3333/33/33" : maxDate;
            BonusPageDTO response = new BonusPageDTO();
            try{
		entityManager.getTransaction().begin();
		Query count = entityManager.createQuery("SELECT COUNT(u) FROM BonusEntity u WHERE u.date > '"+minDate+"' AND u.date < '"+maxDate+"'");
		Long regCount = 0L;
		regCount = Long.parseLong(count.getSingleResult().toString());
		
		Query q = entityManager.createQuery("SELECT u FROM BonusEntity u WHERE u.date > '"+ minDate +"' AND u.date < '"+ maxDate +"'");
		if (page != null && maxRecords != null) {
		    q.setFirstResult((page-1)*maxRecords);
		    q.setMaxResults(maxRecords);
		}
		response.setTotalRecords(regCount);
		response.setRecords(BonusConverter.entity2PersistenceDTOList(q.getResultList()));
            }catch(Exception e){
                e.printStackTrace();
            }
            finally{
                entityManager.getTransaction().commit();
                
            }    
            return response;    
		
	}

}