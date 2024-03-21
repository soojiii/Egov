package kr.or.ddit.bts.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import kr.or.ddit.vo.BtsVO;

public class InMemoryBtsDAOImpl implements BtsDAO {
	
	Map<String, Object[]> btsMap = new LinkedHashMap<>();
	{
	btsMap.put("B001", new Object[] {"뷔", "bts/bui", 100});
	btsMap.put("B002", new Object[] {"제이홉", "bts/jhop", 200});
	btsMap.put("B003", new Object[] {"지민", "bts/jimin", 300});
	btsMap.put("B004", new Object[] {"진", "bts/jin", 0});
	btsMap.put("B005", new Object[] {"정국", "bts/jungkuk", 120});
	btsMap.put("B006", new Object[] {"RM", "bts/rm", 30});
	btsMap.put("B007", new Object[] {"슈가", "bts/suga", new Integer(40)});
	}
	
	@Override
	public BtsVO selectBts(String code) {
		Object[] values = btsMap.get(code);
		BtsVO bts = null;
		if(values!=null) {
			bts = new BtsVO(code, (String)values[0], (String)values[1]);
			bts.setCount((int)values[2]);
		}
		return bts;
	}

	
	@Override
	public List<BtsVO> selectBtsList() {
		List<BtsVO> btsList = new ArrayList<BtsVO>();
		for(Entry<String, Object[]> entry : btsMap.entrySet()) {
			Object[] values = entry.getValue();
			BtsVO tmp = new BtsVO(entry.getKey(), (String)values[0], (String)values[1]);
			tmp.setCount((int)values[2]);
			btsList.add(tmp);
		}
		Collections.sort(btsList);
		return btsList;
	}

	
	@Override
	public void incrementHit(String code) {
		BtsVO bts = selectBts(code);
		if(bts!=null) {
			int count = bts.getCount() + 1;
//			bts.setCount(count);
			btsMap.get(code)[2] = count;
		}
	}
}
