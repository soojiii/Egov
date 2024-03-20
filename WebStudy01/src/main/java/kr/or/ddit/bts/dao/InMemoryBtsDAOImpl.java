package kr.or.ddit.bts.dao;

import java.util.ArrayList;
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
	btsMap.put("B007", new Object[] {"슈가", "bts/suga", 40});
	}
	
	@Override
	public BtsVO selectBts(String code) {
		
		Object[] values = btsMap.get(code);
		BtsVO bts = null;
		if(values!=null) {
			bts = new BtsVO(code, values[0], values[1]);
		}
		
		return bts;
	}

	@Override
	public List<BtsVO> selectBtsList() {
		
		List<BtsVO> btsList = new ArrayList<BtsVO>();
		for(Entry<String, String[]> entry : btsMap.entrySet()) {
			String[] values = entry.getValue();
			btsList.add(new BtsVO(entry.getKey(), values[0], values[1]));
		}
		return btsList;
	}

	@Override
	public void incrementHit(String code) {
		
		
	}

}
