package com.sankuai.inf.leaf.common;

import com.sankuai.inf.leaf.IDGen;
import com.sankuai.inf.leaf.segment.model.LeafAlloc;

public class ZeroIDGen implements IDGen {
    @Override
    public Result get(String key) {
        return new Result(0, Status.SUCCESS);
    }

    @Override
    public boolean init() {
        return true;
    }

	@Override
	public LeafAlloc getLeafByParam(LeafAlloc leafAlloc) {
		// TODO Auto-generated method stub
		return null;
	}
}
