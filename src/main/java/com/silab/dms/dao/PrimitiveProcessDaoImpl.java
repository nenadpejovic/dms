package com.silab.dms.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.silab.dms.model.PrimitiveProcess;

@Repository("primitiveProcessDao")
public class PrimitiveProcessDaoImpl extends AbstractDao<Integer, PrimitiveProcess> implements PrimitiveProcessDao{

	@Override
	public List<PrimitiveProcess> retrievePrimitiveProcesses() {
		Criteria criteria = createEntityCriteria();
		return (List<PrimitiveProcess>)criteria.list();
	}

}
